/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaAprazamentoMedicacoes.jCela;
import static gestor.Visao.TelaAprazamentoMedicacoes.jIdInternoAbra;
import static gestor.Visao.TelaAprazamentoMedicacoes.jIdReq;
import static gestor.Visao.TelaAprazamentoMedicacoes.jNomeInternoAbra;
import static gestor.Visao.TelaAprazamentoMedicacoes.jPavilhao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TelaPesqRequisicaoAprazaMed extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataEmissao;
    String statusRequisicao = "FINALIZADO";
    String statusReqAtend = "Não Atendido";
    // String statusReqAndamento = "Em Andamento";

    /**
     * Creates new form TelaPesqProdutoFarmacia
     */
    public TelaPesqRequisicaoAprazaMed() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIdRequisicao = new javax.swing.JTextField();
        jBtPesqRequisicao = new javax.swing.JButton();
        jCheckBoxPesqTodosProd = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaRequisicaoMedicamentos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Listagem de Requisição de Medicamentos {ENF} :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Código:");

        jIdRequisicao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRequisicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqRequisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqRequisicao.setContentAreaFilled(false);
        jBtPesqRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqRequisicaoActionPerformed(evt);
            }
        });

        jCheckBoxPesqTodosProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPesqTodosProd.setText("Todos");
        jCheckBoxPesqTodosProd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxPesqTodosProdItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Interno:");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jIdRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxPesqTodosProd))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jNomeInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jBtPesqRequisicao)
                        .addComponent(jIdRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jCheckBoxPesqTodosProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap())
        );

        jTabelaRequisicaoMedicamentos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRequisicaoMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Nome Completo do Interno"
            }
        ));
        jTabelaRequisicaoMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRequisicaoMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaRequisicaoMedicamentos);
        if (jTabelaRequisicaoMedicamentos.getColumnModel().getColumnCount() > 0) {
            jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(2).setMinWidth(290);
            jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(2).setMaxWidth(290);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSair)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pesquisas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 10, 427, 282);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqRequisicaoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIdRequisicao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe uma descrição do produto para pesquisa.");
        } else {            
            preencherTabelaProdutos("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdReq='" + jIdRequisicao.getText() + "'AND StatusReq='" + statusRequisicao + "' "
                    + "AND StatusReqAtend='" + statusReqAtend + "'");
        }
    }//GEN-LAST:event_jBtPesqRequisicaoActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIdRequisicao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                        + "INNER JOIN COLABORADOR "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdReq='" + jIdRequisicao.getText() + "'");
                conecta.rs.first();
                jIdReq.setText(String.valueOf(conecta.rs.getInt("IdReq")));
                jIdInternoAbra.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoAbra.setText(conecta.rs.getString("NomeInternoCrc"));
                jPavilhao.setText(conecta.rs.getString("DescricaoPavilhao"));
                jCela.setText(conecta.rs.getString("DescricaoCela"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa do produto" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaRequisicaoMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRequisicaoMedicamentosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeProduto = "" + jTabelaRequisicaoMedicamentos.getValueAt(jTabelaRequisicaoMedicamentos.getSelectedRow(), 0);
            jIdRequisicao.setText(nomeProduto);
        }
    }//GEN-LAST:event_jTabelaRequisicaoMedicamentosMouseClicked

    private void jCheckBoxPesqTodosProdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxPesqTodosProdItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {            
            this.preencherTabelaProdutos("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE StatusReq='" + statusRequisicao + "'AND StatusReqAtend='" + statusReqAtend + "'");
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxPesqTodosProdItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        if (jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
        } else {
            preencherTabelaProdutos("SELECT * FROM REQUISICAO_PRODUTOS_INTERNOS_ENF "
                    + "INNER JOIN COLABORADOR "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REQUISICAO_PRODUTOS_INTERNOS_ENF.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jNomeInterno.getText() + "%'AND StatusReq='" + statusRequisicao + "'AND StatusReqAtend='" + statusReqAtend + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesqRequisicao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxPesqTodosProd;
    private javax.swing.JTextField jIdRequisicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jNomeInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaRequisicaoMedicamentos;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaProdutos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome Completo do Interno"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dataEmissao = conecta.rs.getString("DataReq");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdReq"), dataEmissao, conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRequisicaoMedicamentos.setModel(modelo);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(290);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRequisicaoMedicamentos.getTableHeader().setReorderingAllowed(false);
        jTabelaRequisicaoMedicamentos.setAutoResizeMode(jTabelaRequisicaoMedicamentos.AUTO_RESIZE_OFF);
        jTabelaRequisicaoMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaRequisicao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaRequisicao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setCellRenderer(centralizado);      
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome Completo do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRequisicaoMedicamentos.setModel(modelo);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(290);
        jTabelaRequisicaoMedicamentos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRequisicaoMedicamentos.getTableHeader().setReorderingAllowed(false);
        jTabelaRequisicaoMedicamentos.setAutoResizeMode(jTabelaRequisicaoMedicamentos.AUTO_RESIZE_OFF);
        jTabelaRequisicaoMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}
