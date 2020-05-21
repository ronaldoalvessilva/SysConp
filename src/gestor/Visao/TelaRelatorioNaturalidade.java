/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaLoginSenha.nameUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ronaldo
 */
public class TelaRelatorioNaturalidade extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String nomeCidade;
    int flag;

    /**
     * Creates new form TelaRelatorioNaturalidade
     */
    public TelaRelatorioNaturalidade() {
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
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesqNomeCidade = new javax.swing.JTextField();
        jBtPesqCidade = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaCidade = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtConfirmar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Relatório de Internos por Naturalidade :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome da Cidade:");

        jPesqNomeCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCidadeActionPerformed(evt);
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
                .addComponent(jPesqNomeCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTodos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxTodos)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jPesqNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtPesqCidade)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaCidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCidade);

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 0, 255));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jTabbedPane1.addTab("Listagem", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(42, 42, 42))
        );

        setBounds(350, 150, 464, 275);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            jTabelaCidade.setVisible(true);
            this.preencherTabela();
        } else {
            jTabelaCidade.setVisible(!true);
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesqCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCidadeActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeCidade.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesqNomeCidade.requestFocus();
        } else {
            jTabelaCidade.setVisible(true);
            preencherTabelaNome("SELECT * FROM CIDADES WHERE NomeCidade LIKE'" + jPesqNomeCidade.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqCidadeActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/CRC/RelatorioInternosNaturalidade.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE NomeCidade='" + jPesqNomeCidade.getText() + "'");
            HashMap parametros = new HashMap();
            parametros.put("nomeCidade", jPesqNomeCidade.getText());            
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Internos por Naturalidade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCidadeMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String NomeCidade = "" + jTabelaCidade.getValueAt(jTabelaCidade.getSelectedRow(), 1);
            jPesqNomeCidade.setText(NomeCidade);
        }
    }//GEN-LAST:event_jTabelaCidadeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqCidade;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqNomeCidade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaCidade;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Nome Cidade", "DDD", "UF", "País"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CIDADES JOIN PAISES ON CIDADES.IdPais = PAISES.IdPais");
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdCidade"), conecta.rs.getString("NomeCidade"), conecta.rs.getInt("DddCidade"), conecta.rs.getString("UfCidade"), conecta.rs.getString("NomePais")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCidade.setModel(modelo);
        jTabelaCidade.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCidade.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCidade.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaCidade.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCidade.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaCidade.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCidade.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTabelaCidade.getColumnModel().getColumn(3).setResizable(false);
        jTabelaCidade.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaCidade.getColumnModel().getColumn(4).setResizable(false);
        jTabelaCidade.getTableHeader().setReorderingAllowed(false);
        jTabelaCidade.setAutoResizeMode(jTabelaCidade.AUTO_RESIZE_OFF);
        jTabelaCidade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Nome Cidade", "DDD"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdCidade"), conecta.rs.getString("NomeCidade"), conecta.rs.getInt("DddCidade")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaCidade.setModel(modelo);
        jTabelaCidade.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaCidade.getColumnModel().getColumn(0).setResizable(false);
        jTabelaCidade.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTabelaCidade.getColumnModel().getColumn(1).setResizable(false);
        jTabelaCidade.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaCidade.getColumnModel().getColumn(2).setResizable(false);
        jTabelaCidade.getTableHeader().setReorderingAllowed(false);
        jTabelaCidade.setAutoResizeMode(jTabelaCidade.AUTO_RESIZE_OFF);
        jTabelaCidade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
