/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaConsultaPopulacao.jBrasHomenAberto;
import static gestor.Visao.TelaConsultaPopulacao.jBrasHomenFechado;
import static gestor.Visao.TelaConsultaPopulacao.jBrasHomenProvisorio;
import static gestor.Visao.TelaConsultaPopulacao.jBrasHomenSemi;
import static gestor.Visao.TelaConsultaPopulacao.jBrasMulheresAberto;
import static gestor.Visao.TelaConsultaPopulacao.jBrasMulheresFechado;
import static gestor.Visao.TelaConsultaPopulacao.jBrasMulheresProvisorio;
import static gestor.Visao.TelaConsultaPopulacao.jBrasMulheresSemi;
import static gestor.Visao.TelaConsultaPopulacao.jBrasMulheresTotal;
import static gestor.Visao.TelaConsultaPopulacao.jDataPop;
import static gestor.Visao.TelaConsultaPopulacao.jEstaHomeAberto;
import static gestor.Visao.TelaConsultaPopulacao.jEstraHomeSemi;
import static gestor.Visao.TelaConsultaPopulacao.jEstranHomeFechado;
import static gestor.Visao.TelaConsultaPopulacao.jEstranHomeProvisorio;
import static gestor.Visao.TelaConsultaPopulacao.jEstranMulherAberto;
import static gestor.Visao.TelaConsultaPopulacao.jEstranMulherFechado;
import static gestor.Visao.TelaConsultaPopulacao.jEstranMulherProvisorio;
import static gestor.Visao.TelaConsultaPopulacao.jEstranMulherSemi;
import static gestor.Visao.TelaConsultaPopulacao.jEstranTotalHomem;
import static gestor.Visao.TelaConsultaPopulacao.jIdPop;
import static gestor.Visao.TelaConsultaPopulacao.jPopAgenteFem;
import static gestor.Visao.TelaConsultaPopulacao.jPopAgenteMasc;
import static gestor.Visao.TelaConsultaPopulacao.jStatusPop;
import static gestor.Visao.TelaConsultaPopulacao.jTotalBrasHomens;
import static gestor.Visao.TelaConsultaPopulacao.jTotalEstranMulheres;
import static gestor.Visao.TelaConsultaPopulacao.jTotalGeralAgentes;
import static gestor.Visao.TelaConsultaPopulacao.jTotalGeralPopInternos;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Ronaldo
 */
public class TelaPesqPopulacaoPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataPopulacao;
    String dataInicial;
    String dataFinal;

    /**
     * Creates new form TelaPesquisaCidade
     */
    public TelaPesqPopulacaoPortaria() {
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBtData = new javax.swing.JButton();
        jPesDtPopFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPesDtPopInicial = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIDPesPop = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPopulacao = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setTitle("...::: Pesquisar População :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar População", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        jBtData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtData.setToolTipText("Pesquisa por Nome");
        jBtData.setContentAreaFilled(false);
        jBtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataActionPerformed(evt);
            }
        });

        jPesDtPopFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("De:");

        jPesDtPopInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Até");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código:");

        jIDPesPop.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesPop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

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
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIDPesPop, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jIDPesPop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jCheckBox1))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtData)
                    .addComponent(jLabel1)
                    .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPopulacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPopulacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaPopulacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPopulacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPopulacao);

        jBtEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEnviar.setForeground(new java.awt.Color(0, 204, 0));
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 150, 370, 289);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataActionPerformed
          flag = 1;
        if (jPesDtPopInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Data inicial não pode ser em branco.");
            jPesDtPopInicial.requestFocus();
        } else {
            if (jPesDtPopFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data final não pode ser em branco.");
                jPesDtPopFinal.requestFocus();
            } else {
                if (jPesDtPopInicial.getDate().after(jPesDtPopFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final.");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jPesDtPopInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jPesDtPopFinal.getDate().getTime());
                    jTabelaPopulacao.setVisible(true);
                    preencherTabelaNome("SELECT * FROM MOVPOPULACAO WHERE DataPopMov BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }

    }//GEN-LAST:event_jBtDataActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
          flag = 1;
        if (jIDPesPop.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma data' e clique no botão ENVIAR");
        } else {            
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM MOVPOPULACAO INNER JOIN POPESTRANGMASC ON MOVPOPULACAO.IdPopMov=POPESTRANGMASC.IdPopMov INNER JOIN POPESTRANGFEM ON MOVPOPULACAO.IdPopMov=POPESTRANGFEM.IdPopMov INNER JOIN POPBRASMASC ON MOVPOPULACAO.IdPopMov=POPBRASMASC.IdPopMov INNER JOIN POPBRASFEM ON MOVPOPULACAO.IdPopMov=POPBRASFEM.IdPopMov INNER JOIN POPAGENTES ON MOVPOPULACAO.IdPopMov=POPAGENTES.IdPopMov WHERE MOVPOPULACAO.IdPopMov='" + jIDPesPop.getText() + "'");
                conecta.rs.first();
                // Tabela Movimento de População
                jIdPop.setText(conecta.rs.getString("IdPopMov"));
                jDataPop.setDate(conecta.rs.getDate("DataPopMov"));
                jStatusPop.setText(conecta.rs.getString("StatusPop"));
                // Tabela de Estrangeiros masculino
                jEstranHomeFechado.setText(conecta.rs.getString("EstraHomenFec"));
                jEstraHomeSemi.setText(conecta.rs.getString("EstraHomenSem"));
                jEstaHomeAberto.setText(conecta.rs.getString("EstraHomenAbe"));
                jEstranHomeProvisorio.setText(conecta.rs.getString("EstraHomenPro"));
                jEstranTotalHomem.setText(conecta.rs.getString("TotalGeralMasc"));
                // Tabela de Estrangeiros masculino
                jEstranMulherFechado.setText(conecta.rs.getString("EstraMulherFec"));
                jEstranMulherSemi.setText(conecta.rs.getString("EstraMulherSem"));
                jEstranMulherAberto.setText(conecta.rs.getString("EstraMulherAbe"));
                jEstranMulherProvisorio.setText(conecta.rs.getString("EstraMulherPro"));
                jTotalEstranMulheres.setText(conecta.rs.getString("TotalGeralFem"));
                // Tabela de Brasileiros masculino
                jBrasHomenFechado.setText(conecta.rs.getString("BrasHomemFec"));
                jBrasHomenSemi.setText(conecta.rs.getString("BrasHomemSem"));
                jBrasHomenAberto.setText(conecta.rs.getString("BrasHomemAbe"));
                jBrasHomenProvisorio.setText(conecta.rs.getString("BrasHomemPro"));
                jTotalBrasHomens.setText(conecta.rs.getString("TotalGeralBrasMasc"));
                // Tabela de Brasileiros feminino
                jBrasMulheresFechado.setText(conecta.rs.getString("BrasMulherFec"));
                jBrasMulheresSemi.setText(conecta.rs.getString("BrasMulherSem"));
                jBrasMulheresAberto.setText(conecta.rs.getString("BrasMulherAbe"));
                jBrasMulheresProvisorio.setText(conecta.rs.getString("BrasMulherPro"));
                jBrasMulheresTotal.setText(conecta.rs.getString("TotalGeralBrasFem"));
                // Tabela de agentes
                jPopAgenteMasc.setText(conecta.rs.getString("AgenteMasc"));
                jPopAgenteFem.setText(conecta.rs.getString("AgenteFem"));
                // Tabela de Movimento População
                jTotalGeralPopInternos.setText(conecta.rs.getString("TotalGeralInternos"));
                jTotalGeralAgentes.setText(conecta.rs.getString("TotalGeralAgentes"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a pesquisa.\nERRO: " + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaPopulacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPopulacaoMouseClicked
        // TODO add your handling code here: 
        flag = 1;
        if (flag == 1) {
            String idPopMov = "" + jTabelaPopulacao.getValueAt(jTabelaPopulacao.getSelectedRow(), 0);
            jIDPesPop.setText(idPopMov);
        }
    }//GEN-LAST:event_jTabelaPopulacaoMouseClicked

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIDPesPop.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um ID e clique no botão ENVIAR");
        } else {
            jTabelaPopulacao.setVisible(true);
            preencherTabelaID("SELECT * FROM MOVPOPULACAO INNER JOIN POPESTRANGMASC ON MOVPOPULACAO.IdPopMov=POPESTRANGMASC.IdPopMov INNER JOIN POPESTRANGFEM ON MOVPOPULACAO.IdPopMov=POPESTRANGFEM.IdPopMov INNER JOIN POPBRASMASC ON MOVPOPULACAO.IdPopMov=POPBRASMASC.IdPopMov INNER JOIN POPBRASFEM ON MOVPOPULACAO.IdPopMov=POPBRASFEM.IdPopMov INNER JOIN POPAGENTES ON MOVPOPULACAO.IdPopMov=POPAGENTES.IdPopMov WHERE MOVPOPULACAO.IdPopMov='" + jIDPesPop.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
         flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            jTabelaPopulacao.setVisible(true);
            this.preencherTabela();
        } else {
            jTabelaPopulacao.setVisible(!true);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtData;
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jIDPesPop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jPesDtPopFinal;
    private com.toedter.calendar.JDateChooser jPesDtPopInicial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaPopulacao;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Data População", "Total Agentes", "Total Internos"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MOVPOPULACAO INNER JOIN POPESTRANGMASC ON MOVPOPULACAO.IdPopMov=POPESTRANGMASC.IdPopMov INNER JOIN POPESTRANGFEM ON MOVPOPULACAO.IdPopMov=POPESTRANGFEM.IdPopMov INNER JOIN POPBRASMASC ON MOVPOPULACAO.IdPopMov=POPBRASMASC.IdPopMov INNER JOIN POPBRASFEM ON MOVPOPULACAO.IdPopMov=POPBRASFEM.IdPopMov INNER JOIN POPAGENTES ON MOVPOPULACAO.IdPopMov=POPAGENTES.IdPopMov");
            conecta.rs.first();
            do {
                // Formatar a data População
                dataPopulacao = conecta.rs.getString("DataPopMov");
                String dia = dataPopulacao.substring(8, 10);
                String mes = dataPopulacao.substring(5, 7);
                String ano = dataPopulacao.substring(0, 4);
                dataPopulacao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPopMov"), dataPopulacao, conecta.rs.getInt("TotalGeralAgentes"), conecta.rs.getInt("TotalGeralInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Data População", "Total Agentes", "Total Internos"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataPopulacao = conecta.rs.getString("DataPopMov");
                String dia = dataPopulacao.substring(8, 10);
                String mes = dataPopulacao.substring(5, 7);
                String ano = dataPopulacao.substring(0, 4);
                dataPopulacao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPopMov"), dataPopulacao, conecta.rs.getInt("TotalGeralAgentes"), conecta.rs.getInt("TotalGeralInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    // Método de pesquisa pela Descrição
    public void preencherTabelaID(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Data População", "Total Agentes", "Total Internos"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dataPopulacao = conecta.rs.getString("DataPopMov");
                String dia = dataPopulacao.substring(8, 10);
                String mes = dataPopulacao.substring(5, 7);
                String ano = dataPopulacao.substring(0, 4);
                dataPopulacao = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdPopMov"), dataPopulacao, conecta.rs.getInt("TotalGeralAgentes"), conecta.rs.getInt("TotalGeralInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPopulacao.setModel(modelo);
        jTabelaPopulacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPopulacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaPopulacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPopulacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPopulacao.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPopulacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPopulacao.getTableHeader().setReorderingAllowed(false);
        jTabelaPopulacao.setAutoResizeMode(jTabelaPopulacao.AUTO_RESIZE_OFF);
        jTabelaPopulacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
