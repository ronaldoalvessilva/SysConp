/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import Utilitarios.LimiteDigitos;
import gestor.Dao.*;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.idItem;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jBtAlterarVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jBtCancelarVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jBtExcluirVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jBtNovaVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jBtSalvarVisita;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jBtBuscarInterno;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jDataEntrada;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jDataSaida;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jFotoInternoVisitasInterno;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jFotoVisitaInterno;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jHorarioEntrada;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jHorarioSaida;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jIDVisitaInterna;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jIDlanc;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jIdInterno;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jNomeInterno;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jNomeVisitanteInterna;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jPavilhao;
import static gestor.Visao.TelaEntradaSaidaVisitasInternasInternos.jSituacao;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class TelaPesqBuscarInternasInternos extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataEntrada;
    String dataSaida;
    String caminho, caminhoVisita;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqBuscarInternasInternos() {
        initComponents();
        jPesqNomeInterno.setDocument(new LimiteDigitos(50));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInternos = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Internos - {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome Interno:");

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
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaPesqInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaPesqInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInternos);

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
                        .addGap(0, 206, Short.MAX_VALUE))
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

        setBounds(250, 20, 415, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            jNomeVisitanteInterna.setText(nomeInterno);
            String idVisita = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 0);
            jIDVisitaInterna.setText(idVisita);
            String horarioEntrada = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 3);
            jHorarioEntrada.setText(horarioEntrada);
            jIDVisitaInterna.setText(idVisita);
            jBtNovaVisita.setEnabled(true);
            jBtAlterarVisita.setEnabled(true);
            jBtExcluirVisita.setEnabled(true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(true);
            jBtBuscarInterno.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_VISITA_INTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN ITENS_VISITA_INTERNA "
                        + "ON ITENS_VISITA_INTERNO.IdRol=ITENS_VISITA_INTERNO.IdRol "
                        + "INNER JOIN ITENSLOCACAOINTERNO ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE ITENS_VISITA_INTERNO.IdLanc='" + jIDlanc.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                jSituacao.setText(conecta.rs.getString("SituacaoCrc"));
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoVisitasInterno.setIcon(i);
                jFotoInternoVisitasInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoVisitasInterno.getWidth(), jFotoInternoVisitasInterno.getHeight(), Image.SCALE_DEFAULT)));
                //
                conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNA  "
                        + "INNER JOIN PRONTUARIOSCRC  "
                        + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                        + "WHERE NomeInternoCrc='" + jNomeVisitanteInterna.getText() + "' AND IdLanc='" + jIDlanc.getText() + "'");
                conecta.rs.first();
                //
                jIDVisitaInterna.setText(conecta.rs.getString("IdInternoCrc")); //Coluna 0
                jNomeVisitanteInterna.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1
                // Capturando foto
                caminhoVisita = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                jFotoVisitaInterno.setIcon(v);
                jFotoVisitaInterno.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisitaInterno.getWidth(), jFotoVisitaInterno.getHeight(), Image.SCALE_DEFAULT)));
                idItem = conecta.rs.getString("IdItem"); // Coluna 2                
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jHorarioEntrada.setText(conecta.rs.getString("HorarioEntrada"));
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
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqNomeInterno.requestFocus();
        } else {
            buscarInternos("SELECT * FROM ITENS_VISITA_INTERNA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    //                    + "INNER JOIN ITENS_VISITA_INTERNO "
                    //                    + "ON ITENS_VISITA_INTERNA.IdRol=ITENS_VISITA_INTERNO.IdRol  "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'AND ITENS_VISITA_INTERNA.IdLanc='" + jIDlanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jTabelaPesqInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            jNomeVisitanteInterna.setText(nomeInterno);
            String idVisita = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 0);
            jIDVisitaInterna.setText(idVisita);
            String horarioEntrada = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 3);
            jHorarioEntrada.setText(horarioEntrada);
        }
    }//GEN-LAST:event_jTabelaPesqInternosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqInternos;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os VISITANTES
    public void buscarInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome da Interna", "Data Entrada", "Horário", "Data Saída", "Horário"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternos.setModel(modelo);
        jTabelaPesqInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaPesqInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaPesqInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPesqInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternos.setAutoResizeMode(jTabelaPesqInternos.AUTO_RESIZE_OFF);
        jTabelaPesqInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
