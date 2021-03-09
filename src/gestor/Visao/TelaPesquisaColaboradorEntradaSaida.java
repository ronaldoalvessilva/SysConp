/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jFuncaoColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jFotoColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jIdColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jNomeColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jMatriculaColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jNomeMaeColaborador;
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
 * @author user
 */
public class TelaPesquisaColaboradorEntradaSaida extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String caminho;
    String statusFunc = "Ativo";
    String idFunc;
    String nomeFuncionario;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesquisaColaboradorEntradaSaida() {
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
        jPesquisarNomeColaborador = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqFunc = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Colaborador Gte. Adm. :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Colaborador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesquisarNomeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome :");

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesquisarNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(9, 9, 9))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jCheckBox1)
                .addComponent(jBtPesqNome)
                .addComponent(jPesquisarNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
        );

        jTabelaPesqFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Colaborador", "Cargo", "Departamento"
            }
        ));
        jTabelaPesqFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqFuncMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqFunc);
        if (jTabelaPesqFunc.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqFunc.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPesqFunc.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaPesqFunc.getColumnModel().getColumn(1).setMinWidth(200);
            jTabelaPesqFunc.getColumnModel().getColumn(1).setMaxWidth(200);
            jTabelaPesqFunc.getColumnModel().getColumn(2).setMinWidth(150);
            jTabelaPesqFunc.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 539, 277);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesquisarNomeColaborador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do colaborador e clique no botão ENVIAR");
        } else if (idFunc == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecione nome do colaborador corretamente para ENVIAR.");
        } else {
            if (flag == 1) {
                nomeFuncionario = "" + jTabelaPesqFunc.getValueAt(jTabelaPesqFunc.getSelectedRow(), 1);
                jPesquisarNomeColaborador.setText(nomeFuncionario);
                idFunc = "" + jTabelaPesqFunc.getValueAt(jTabelaPesqFunc.getSelectedRow(), 0);
                jIdColaborador.setText(idFunc);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM COLABORADOR "
                            + "INNER JOIN CARGOS "
                            + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "WHERE NomeFunc='" + nomeFuncionario + "' "
                            + "AND StatusFunc='" + statusFunc + "'");
                    conecta.rs.first();
                    // Tabela Funcionarios
                    jIdColaborador.setText(String.valueOf(conecta.rs.getInt("IdFunc")));
                    jNomeColaborador.setText(conecta.rs.getString("NomeFunc"));
                    caminho = conecta.rs.getString("ImagemFunc");
                    if (caminho != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                        jFotoColaborador.setIcon(i);
                        jFotoColaborador.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (img2Bytes != null) {
                        ImageIcon pic2 = null;
                        pic2 = new ImageIcon(img2Bytes);
                        Image scaled2 = pic2.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon2 = new ImageIcon(scaled2);
                        jFotoColaborador.setIcon(icon2);
                    }
                    jMatriculaColaborador.setText(conecta.rs.getString("MatriculaFunc"));
                    jFuncaoColaborador.setText(conecta.rs.getString("Funcao"));
                    jNomeMaeColaborador.setText(conecta.rs.getString("NomeMae"));
                    conecta.desconecta();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + ex);
                }
                dispose();
            }
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:
        // Pesquisar colaborador por nome
        flag = 1;
        if (jPesquisarNomeColaborador.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesquisarNomeColaborador.requestFocus();
        } else {
            buscarFunc("SELECT * FROM COLABORADOR "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "WHERE NomeFunc LIKE'%" + jPesquisarNomeColaborador.getText() + "%' "
                    + "AND StatusFunc='" + statusFunc + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.buscarFunc("SELECT * FROM COLABORADOR "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "WHERE StatusFunc='" + statusFunc + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaPesqFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqFuncMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            nomeFuncionario = "" + jTabelaPesqFunc.getValueAt(jTabelaPesqFunc.getSelectedRow(), 1);
            jPesquisarNomeColaborador.setText(nomeFuncionario);
            idFunc = "" + jTabelaPesqFunc.getValueAt(jTabelaPesqFunc.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaPesqFuncMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesquisarNomeColaborador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqFunc;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os COLABORADORES
    public void buscarFunc(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Colaborador", "Cargo", "Departamento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeCargo"), conecta.rs.getString("NomeDepartamento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqFunc.setModel(modelo);
        jTabelaPesqFunc.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqFunc.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqFunc.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaPesqFunc.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqFunc.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTabelaPesqFunc.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqFunc.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaPesqFunc.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqFunc.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqFunc.setAutoResizeMode(jTabelaPesqFunc.AUTO_RESIZE_OFF);
        jTabelaPesqFunc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaCamposTabela();
        conecta.desconecta();
    }

    public void alinhaCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPesqFunc.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Colaborador", "Cargo", "Departamento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqFunc.setModel(modelo);
        jTabelaPesqFunc.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqFunc.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqFunc.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaPesqFunc.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqFunc.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTabelaPesqFunc.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqFunc.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaPesqFunc.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqFunc.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqFunc.setAutoResizeMode(jTabelaPesqFunc.AUTO_RESIZE_OFF);
        jTabelaPesqFunc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}