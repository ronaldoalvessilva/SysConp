/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;


import gestor.Dao.*;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.idItem;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtAlterarInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtAuditoriaInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtBuscarInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtCancelarInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtExcluirInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtNovoInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtSalvarInterno;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jHorarioEntradaEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jDataSaidaEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jDataEntradaEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jHorarioSaidaEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jIdLanc;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jIdInternoEduExt;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jNomeInternoEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jObservacaoInternoEdu;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class TelaBuscarInternosLaborEducar extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataEntrada;  
    String dataSaida;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaBuscarInternosLaborEducar() {
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
                .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        setBounds(250, 20, 384, 270);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            String idVisita = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 0);
            String horarioEntrada = "" + jTabelaPesqInternos.getValueAt(jTabelaPesqInternos.getSelectedRow(), 3);    
            jIdInternoEduExt.setText(idVisita);
            //
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtBuscarInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                        + "WHERE NomeInternoCrc='" + jPesqNomeInterno.getText() +  "' AND IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                // Tabela Funcionarios
                jIdInternoEduExt.setText(conecta.rs.getString("IdInternoCrc")); //Coluna 0
                jNomeInternoEdu.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1 
                idItem = conecta.rs.getString("IdItem"); // Coluna 2                                                               
                jDataEntradaEdu.setDate(conecta.rs.getDate("DataEntrada"));
                jHorarioEntradaEdu.setText(conecta.rs.getString("HorarioEntrada"));
                jDataSaidaEdu.setDate(conecta.rs.getDate("DataSaida"));
                jHorarioSaidaEdu.setText(conecta.rs.getString("HorarioSaida"));
                jObservacaoInternoEdu.setText(conecta.rs.getString("Observacao"));
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
            buscarInternos("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%' AND IdLanc='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed


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
        String[] Colunas = new String[]{"Código", "     Nome do Interno ", " Data Entrada", " Horario", "   Data Saída", " Horario"};
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
                // Formatar a data Saida               
                dataSaida = conecta.rs.getString("DataSaida");
                String dias = dataSaida.substring(8, 10);
                String mess = dataSaida.substring(5, 7);
                String anos = dataSaida.substring(0, 4);
                dataSaida = dias + "/" + mess + "/" + anos;
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
        jTabelaPesqInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaPesqInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPesqInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaPesqInternos.getColumnModel().getColumn(3).setResizable(false);        
        jTabelaPesqInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternos.setAutoResizeMode(jTabelaPesqInternos.AUTO_RESIZE_OFF);
        jTabelaPesqInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
