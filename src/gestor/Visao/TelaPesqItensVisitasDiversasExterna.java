/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jBtAlterarVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jBtCancelarVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jBtExcluirVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jBtNovaVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jBtSalvarVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jDataEntrada;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jDataSaida;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jHorarioEntrada;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jHorarioSaida;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jIDDepto;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jIDVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jNomeVisitante;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jIDlanc;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.jDepartamento;
import static gestor.Visao.TelaEntradaSaidaVisitasDiversasExterna.idItem;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class TelaPesqItensVisitasDiversasExterna extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataEntrada;
    String dataSaida;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqItensVisitasDiversasExterna() {
        initComponents();
        jPesqNomeVisitante.setDocument(new LimiteDigitos(50));
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
        jPesqNomeVisitante = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqVistante = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Colaborador - {P1-Externa} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Visitantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));

        jPesqNomeVisitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome Visitante:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaPesqVistante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqVistante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome Visitante", "Data Entrada", "Horário", "Data Saída", "Hotário"
            }
        ));
        jTabelaPesqVistante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqVistanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqVistante);
        if (jTabelaPesqVistante.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqVistante.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPesqVistante.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaPesqVistante.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaPesqVistante.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaPesqVistante.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaPesqVistante.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaPesqVistante.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaPesqVistante.getColumnModel().getColumn(5).setMaxWidth(70);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 20, 607, 278);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeVisitante = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 1);
            jPesqNomeVisitante.setText(nomeVisitante);
            String idVisita = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 0);
            String horarioEntrada = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 3);
            jHorarioEntrada.setText(horarioEntrada);
            jIDVisita.setText(idVisita);
            jBtNovaVisita.setEnabled(true);
            jBtAlterarVisita.setEnabled(true);
            jBtExcluirVisita.setEnabled(true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSVISITASDIVERSAS INNER JOIN VISITASDIVERSAS ON ITENSVISITASDIVERSAS.IdVisita=VISITASDIVERSAS.IdVisita INNER JOIN DEPARTAMENTOS ON ITENSVISITASDIVERSAS.IdDepartamento=DEPARTAMENTOS.IdDepartamento WHERE NomeVisita LIKE'" + jPesqNomeVisitante.getText() + "%' AND IdLanc='" + jIDlanc.getText() + "'AND HorarioEntrada='" + jHorarioEntrada.getText() + "'");
                conecta.rs.first();
                // Tabela Funcionarios
                jIDVisita.setText(String.valueOf(conecta.rs.getInt("IdVisita")));
                jNomeVisitante.setText(conecta.rs.getString("NomeVisita"));
                idItem = conecta.rs.getString("IdItem");
                jIDDepto.setText(conecta.rs.getString("IdDepartamento"));
                jDepartamento.setText(conecta.rs.getString("NomeDepartamento"));
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jHorarioEntrada.setText(conecta.rs.getString("HorarioEntrada"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jHorarioSaida.setText(conecta.rs.getString("HorarioSaida"));
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
        // Pesquisar colaborador por nome             
        flag = 1;
        if (jPesqNomeVisitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqNomeVisitante.requestFocus();
        } else {
            buscarVisitante("SELECT * FROM ITENSVISITASDIVERSAS "
                    + "INNER JOIN VISITASDIVERSAS "
                    + "ON ITENSVISITASDIVERSAS.IdVisita=VISITASDIVERSAS.IdVisita "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON ITENSVISITASDIVERSAS.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "WHERE NomeVisita LIKE'%" + jPesqNomeVisitante.getText() + "%' "
                    + "AND IdLanc='" + jIDlanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jTabelaPesqVistanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqVistanteMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeVisitante = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 1);
            jPesqNomeVisitante.setText(nomeVisitante);
            String idVisita = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 0);
            String horarioEntrada = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 3);
        }
    }//GEN-LAST:event_jTabelaPesqVistanteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeVisitante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqVistante;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os VISITANTES
    public void buscarVisitante(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Visitante", "Data Entrada", "Horário", "Data Saída", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            // Formatar a data Entrada
            dataEntrada = conecta.rs.getString("DataEntrada");
            String dia = dataEntrada.substring(8, 10);
            String mes = dataEntrada.substring(5, 7);
            String ano = dataEntrada.substring(0, 4);
            dataEntrada = dia + "/" + mes + "/" + ano;
            // Fortmatar data de Cadastro          
            dataSaida = conecta.rs.getString("DataSaida");
            String day = dataSaida.substring(8, 10);
            String mesc = dataSaida.substring(5, 7);
            String anoc = dataSaida.substring(0, 4);
            dataSaida = day + "/" + mesc + "/" + anoc;
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVistante.setModel(modelo);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPesqVistante.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVistante.setAutoResizeMode(jTabelaPesqVistante.AUTO_RESIZE_OFF);
        jTabelaPesqVistante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
