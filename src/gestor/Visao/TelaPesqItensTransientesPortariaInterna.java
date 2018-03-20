/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaAcessosPortariaInterna.caminhoFotoAdvogado;
import static gestor.Visao.TelaAcessosPortariaInterna.caminhoFotoColaborador;
import static gestor.Visao.TelaAcessosPortariaInterna.caminhoFotoVisita;
import static gestor.Visao.TelaAcessosPortariaInterna.idItemTran;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtAlterarEvento;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtAuditoriaEvento;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtCancelarEvento;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtExcluirEvento;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtNovoEvento;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtSalvarEvento;
import static gestor.Visao.TelaAcessosPortariaInterna.jBtZoom;
import static gestor.Visao.TelaAcessosPortariaInterna.jDataEntrada;
import static gestor.Visao.TelaAcessosPortariaInterna.jDataSaida;
import static gestor.Visao.TelaAcessosPortariaInterna.jDestino;
import static gestor.Visao.TelaAcessosPortariaInterna.jFotoTransiente;
import static gestor.Visao.TelaAcessosPortariaInterna.jHorarioEntrada;
import static gestor.Visao.TelaAcessosPortariaInterna.jHorarioSaida;
import static gestor.Visao.TelaAcessosPortariaInterna.jIdLanc;
import static gestor.Visao.TelaAcessosPortariaInterna.jIdTransiente;
import static gestor.Visao.TelaAcessosPortariaInterna.jMotivo;
import static gestor.Visao.TelaAcessosPortariaInterna.jNomeTransiente;
import static gestor.Visao.TelaAcessosPortariaInterna.jRadioBtAdvogados;
import static gestor.Visao.TelaAcessosPortariaInterna.jRadioBtColaboradores;
import static gestor.Visao.TelaAcessosPortariaInterna.jRadioBtVisitasDiversas;
import static gestor.Visao.TelaAcessosPortariaInterna.tipoVisita;
//import static gestor.Visao.TelaAcessosPortariaInterna.tipoVisita;
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
public class TelaPesqItensTransientesPortariaInterna extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataEntrada;
    String dataSaida;
//    String caminho, caminhoAdvogado, caminhoVisita;
  //  int tipoVisita;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqItensTransientesPortariaInterna() {
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

        buttonGroupTipoVisita = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPesqNomeVisitante = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRBAdvogados = new javax.swing.JRadioButton();
        jRBColaboradores = new javax.swing.JRadioButton();
        jRBVisitasDiversas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqVistante = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Vistas Diversas - {P1} :::...");

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

        buttonGroupTipoVisita.add(jRBAdvogados);
        jRBAdvogados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAdvogados.setForeground(new java.awt.Color(255, 0, 0));
        jRBAdvogados.setSelected(true);
        jRBAdvogados.setText("Advogados");

        buttonGroupTipoVisita.add(jRBColaboradores);
        jRBColaboradores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBColaboradores.setForeground(new java.awt.Color(0, 0, 255));
        jRBColaboradores.setText("Colaboradores");

        buttonGroupTipoVisita.add(jRBVisitasDiversas);
        jRBVisitasDiversas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBVisitasDiversas.setForeground(new java.awt.Color(0, 153, 0));
        jRBVisitasDiversas.setText("Visitas Diversas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tipo de Visitante:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRBAdvogados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jRBColaboradores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jRBVisitasDiversas))
                    .addComponent(jPesqNomeVisitante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBAdvogados)
                    .addComponent(jRBColaboradores)
                    .addComponent(jRBVisitasDiversas)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqNome)
                    .addComponent(jPesqNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPesqVistante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqVistante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome Visitante", "Data Entrada", "Horário", "Data Saída", "Hotário"
            }
        ));
        jTabelaPesqVistante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqVistanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqVistante);
        if (jTabelaPesqVistante.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqVistante.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPesqVistante.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPesqVistante.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaPesqVistante.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaPesqVistante.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaPesqVistante.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaPesqVistante.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaPesqVistante.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaPesqVistante.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaPesqVistante.getColumnModel().getColumn(6).setMinWidth(70);
            jTabelaPesqVistante.getColumnModel().getColumn(6).setMaxWidth(70);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(450, 60, 691, 329);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String item = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 0);
            String idVisita = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 1);
            String nomeVisitante = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 2);
            jPesqNomeVisitante.setText(nomeVisitante);            
            String horarioEntrada = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 4);
            jHorarioEntrada.setText(horarioEntrada);
            jIdTransiente.setText(idVisita);
            //
            jBtNovoEvento.setEnabled(true);
            jBtAlterarEvento.setEnabled(true);
            jBtExcluirEvento.setEnabled(true);
            jBtSalvarEvento.setEnabled(!true);
            jBtCancelarEvento.setEnabled(true);
            jBtZoom.setEnabled(true);
            jBtAuditoriaEvento.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                        + "INNER JOIN TRANSIENTES "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                        + "WHERE IdItem='" + item + "'");
                conecta.rs.first();
                idItemTran = conecta.rs.getString("IdItem");
                tipoVisita = conecta.rs.getInt("TipoTrans");
                if (tipoVisita == 0) {
                    // ADVOGADOS
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN ADVOGADOS "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=ADVOGADOS.IdAdvogado "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeAdvogado"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtAdvogados.setSelected(true);
                    //
                    caminhoFotoAdvogado = conecta.rs.getString("FotoAdvogado");
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoAdvogado);
                    jFotoTransiente.setIcon(i);
                    jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    jBtZoom.setEnabled(true);
                } else if (tipoVisita == 1) {
                    // COLABORADORES
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN COLABORADOR "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=COLABORADOR.IdFunc "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeFunc"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtColaboradores.setSelected(true);
                    //
                    caminhoFotoColaborador = conecta.rs.getString("ImagemFunc");
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoColaborador);
                    jFotoTransiente.setIcon(i);
                    jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    jBtZoom.setEnabled(true);
                } else if (tipoVisita == 2) {
                    // VISITAS DIVERSAS
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN VISITASDIVERSAS "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=VISITASDIVERSAS.IdVisita "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeVisita"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtVisitasDiversas.setSelected(true);
                    //                    
                    caminhoFotoVisita = conecta.rs.getString("FotoVisita");
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoVisita);
                    jFotoTransiente.setIcon(i);
                    jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    jBtZoom.setEnabled(true);
                }
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
        if (jRBAdvogados.isSelected()) {
            tipoVisita = 0;
        } else if (jRBColaboradores.isSelected()) {
            tipoVisita = 1;
        } else if (jRBVisitasDiversas.isSelected()) {
            tipoVisita = 2;
        }
        flag = 1;
        if (jPesqNomeVisitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqNomeVisitante.requestFocus();
        } else {
            if (tipoVisita == 0) {
                buscarAdvogado("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                        + "INNER JOIN ADVOGADOS "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=ADVOGADOS.IdAdvogado "
                        + "INNER JOIN TRANSIENTES "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                        + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.TipoTrans='" + tipoVisita + "' "
                        + "AND ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                        + "AND ADVOGADOS.NomeAdvogado LIKE'%" + jPesqNomeVisitante.getText() + "%'");
            } else if (tipoVisita == 1) {
                buscarColaborador("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                        + "INNER JOIN COLABORADOR "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=COLABORADOR.IdFunc "
                        + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.TipoTrans='" + tipoVisita + "' "
                        + "AND ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                        + "AND COLABORADOR.NomeFunc LIKE'%" + jPesqNomeVisitante.getText() + "%'");
            } else if (tipoVisita == 2) {
                buscarVisitante("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                        + "INNER JOIN VISITASDIVERSAS "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=VISITASDIVERSAS.IdVisita "
                        + "INNER JOIN TRANSIENTES "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                        + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.TipoTrans='" + tipoVisita + "' "
                        + "AND ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                        + "AND VISITASDIVERSAS.NomeVisita LIKE'%" + jPesqNomeVisitante.getText() + "%'");
            }
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jTabelaPesqVistanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqVistanteMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String item = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 0);
            String idVisita = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 1);
            String nomeVisitante = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 2);
            jPesqNomeVisitante.setText(nomeVisitante);            
            String horarioEntrada = "" + jTabelaPesqVistante.getValueAt(jTabelaPesqVistante.getSelectedRow(), 4);
        }
    }//GEN-LAST:event_jTabelaPesqVistanteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoVisita;
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeVisitante;
    private javax.swing.JRadioButton jRBAdvogados;
    private javax.swing.JRadioButton jRBColaboradores;
    private javax.swing.JRadioButton jRBVisitasDiversas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqVistante;
    // End of variables declaration//GEN-END:variables

    public void buscarAdvogado(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item","Código", "Nome Visitante", "Data Entrada", "Horário", "Data Saída", "Horário"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdItem"),conecta.rs.getInt("IdAdvogado"), conecta.rs.getString("NomeAdvogado"), dataEntrada, conecta.rs.getString("HoraEntrada"), dataSaida, conecta.rs.getString("HoraSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVistante.setModel(modelo);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setResizable(false);
        jTabelaPesqVistante.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVistante.setAutoResizeMode(jTabelaPesqVistante.AUTO_RESIZE_OFF);
        jTabelaPesqVistante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void buscarColaborador(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item","Código", "Nome Visitante", "Data Entrada", "Horário", "Data Saída", "Horário"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdItem"),conecta.rs.getInt("IdFunc"), conecta.rs.getString("NomeFunc"), dataEntrada, conecta.rs.getString("HoraEntrada"), dataSaida, conecta.rs.getString("HoraSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVistante.setModel(modelo);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setResizable(false);
        jTabelaPesqVistante.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVistante.setAutoResizeMode(jTabelaPesqVistante.AUTO_RESIZE_OFF);
        jTabelaPesqVistante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void buscarVisitante(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome Visitante", "Data Entrada", "Horário", "Data Saída", "Horário"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdItem"),conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), dataEntrada, conecta.rs.getString("HoraEntrada"), dataSaida, conecta.rs.getString("HoraSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqVistante.setModel(modelo);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqVistante.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqVistante.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setResizable(false);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setResizable(false);
        jTabelaPesqVistante.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqVistante.setAutoResizeMode(jTabelaPesqVistante.AUTO_RESIZE_OFF);
        jTabelaPesqVistante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaPesqVistante.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqVistante.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPesqVistante.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaPesqVistante.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaPesqVistante.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaPesqVistante.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }
}
