/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaEntradaSaidaVisitasReligiosas.jIdIstituicao;
import static gestor.Visao.TelaEntradaSaidaVisitasReligiosas.jNomeInstituicao;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaPesquisaInstituicaoRolReligiosoPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    String nomeInstituicao;
    String situacao = "Ativo";
    String idInt;
    // TESTE PARA BUSCAR O DIA DA SEMANA
    String dataDiaAtualSemana;
    int diaAtual;
    String dataDiaAtual;
    //    
    int diaAtivo = 1;
    String nomeDiaSemana = "";

    /**
     * Creates new form TelaPesquisaEntradaInternos
     */
    public TelaPesquisaInstituicaoRolReligiosoPortaria() {
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
        jPanel3 = new javax.swing.JPanel();
        jPesqNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtNome = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInstituicoesReligiosas = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtEnviar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa de Instituições/Congregações :::...");
        setPreferredSize(new java.awt.Dimension(538, 340));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Instituições Religiosas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome:");

        jBtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNome.setToolTipText("Pesquisa Por Nome");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNome)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInstituicoesReligiosas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInstituicoesReligiosas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Status", "Descrição da Instituição"
            }
        ));
        jTabelaInstituicoesReligiosas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInstituicoesReligiosasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInstituicoesReligiosas);
        if (jTabelaInstituicoesReligiosas.getColumnModel().getColumnCount() > 0) {
            jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setMinWidth(390);
            jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setMaxWidth(390);
        }

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Pesquisa");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEnviar.setForeground(new java.awt.Color(0, 0, 255));
        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSair)
                    .addComponent(jBtEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setBounds(350, 30, 538, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed

        dataDiaAtualSemana = jDataSistema.getText();
        String dia = dataDiaAtualSemana.substring(0, 2);
        diaAtual = Integer.parseInt(dia.trim());
        diaDaSemana(diaAtual);
        if (nomeDiaSemana.equals("Domingo")) {
            flag = 1;
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Domingo='" + diaAtivo + "'");
            }
        } else if (nomeDiaSemana.equals("Segunda")) {
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Segunda='" + diaAtivo + "'");
            }
        } else if (nomeDiaSemana.equals("Terça")) {
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Terca='" + diaAtivo + "'");
            }
        } else if (nomeDiaSemana.equals("Quarta")) {
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Quarta='" + diaAtivo + "'");
            }
        } else if (nomeDiaSemana.equals("Quinta")) {
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Quinta='" + diaAtivo + "'");
            }
        } else if (nomeDiaSemana.equals("Sexta")) {
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Sexta='" + diaAtivo + "'");
            }
        } else if (nomeDiaSemana.equals("Sábado")) {
            if (jPesqNome.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
                jPesqNome.requestFocus();
            } else {
                preencherTabelaNome("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod  "
                        + "WHERE NomeInstituicao LIKE'%" + jPesqNome.getText() + "%' "
                        + "AND StatusInst='" + situacao + "' "
                        + "AND Sabado='" + diaAtivo + "'");
            }
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaInstituicoesReligiosasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInstituicoesReligiosasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInstituicao = "" + jTabelaInstituicoesReligiosas.getValueAt(jTabelaInstituicoesReligiosas.getSelectedRow(), 2);
            jPesqNome.setText(nomeInstituicao);
            idInt = "" + jTabelaInstituicoesReligiosas.getValueAt(jTabelaInstituicoesReligiosas.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaInstituicoesReligiosasMouseClicked

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jPesqNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "WHERE  INSTITUICAO_RELIGIOSA.NomeInstituicao='" + nomeInstituicao + "' "
                        + "AND INSTITUICAO_RELIGIOSA.IdCod='" + idInt + "'");
                conecta.rs.first();
                jIdIstituicao.setText(String.valueOf(conecta.rs.getInt("IdCod")));
                jNomeInstituicao.setText(conecta.rs.getString("NomeInstituicao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa INSTITUIÇÃO." + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        dataDiaAtualSemana = jDataSistema.getText();
        String dia = dataDiaAtualSemana.substring(0, 2);
        diaAtual = Integer.parseInt(dia.trim());
        diaDaSemana(diaAtual);
        if (nomeDiaSemana.equals("Domingo")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Domingo='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        } else if (nomeDiaSemana.equals("Segunda")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Segunda='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        } else if (nomeDiaSemana.equals("Terça")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Terca='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        } else if (nomeDiaSemana.equals("Quarta")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Quarta='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        } else if (nomeDiaSemana.equals("Quinta")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Quinta='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        } else if (nomeDiaSemana.equals("sexta")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Sexta='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        } else if (nomeDiaSemana.equals("Sábado")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTodosInternos("SELECT * FROM INSTITUICAO_RELIGIOSA "
                        + "INNER JOIN ROL_VISITAS_RELIGIOSA "
                        + "ON INSTITUICAO_RELIGIOSA.IdCod=ROL_VISITAS_RELIGIOSA.IdCod "
                        + "WHERE StatusInst='" + situacao + "' "
                        + "AND Sabado='" + diaAtivo + "'");
            } else {
                limparTabela();
            }
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaInstituicoesReligiosas;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome da Instituição"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdCod"), conecta.rs.getString("StatusInst"), conecta.rs.getString("NomeInstituicao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInstituicoesReligiosas.setModel(modelo);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setPreferredWidth(390);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInstituicoesReligiosas.getTableHeader().setReorderingAllowed(false);
        jTabelaInstituicoesReligiosas.setAutoResizeMode(jTabelaInstituicoesReligiosas.AUTO_RESIZE_OFF);
        jTabelaInstituicoesReligiosas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposItensInternos();
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome da Instituição"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdCod"), conecta.rs.getString("StatusInst"), conecta.rs.getString("NomeInstituicao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInstituicoesReligiosas.setModel(modelo);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setPreferredWidth(390);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInstituicoesReligiosas.getTableHeader().setReorderingAllowed(false);
        jTabelaInstituicoesReligiosas.setAutoResizeMode(jTabelaInstituicoesReligiosas.AUTO_RESIZE_OFF);
        jTabelaInstituicoesReligiosas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposItensInternos();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome da Instituição"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInstituicoesReligiosas.setModel(modelo);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setPreferredWidth(390);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInstituicoesReligiosas.getTableHeader().setReorderingAllowed(false);
        jTabelaInstituicoesReligiosas.setAutoResizeMode(jTabelaInstituicoesReligiosas.AUTO_RESIZE_OFF);
        jTabelaInstituicoesReligiosas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposItensInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInstituicoesReligiosas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void diaDaSemana(int dia) {

        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        dia = c.get(c.DAY_OF_WEEK);
        switch (dia) {
            case Calendar.SUNDAY:
                nomeDiaSemana = "Domingo";
                break;
            case Calendar.MONDAY:
                nomeDiaSemana = "Segunda";
                break;
            case Calendar.TUESDAY:
                nomeDiaSemana = "Terça";
                break;
            case Calendar.WEDNESDAY:
                nomeDiaSemana = "Quarta";
                break;
            case Calendar.THURSDAY:
                nomeDiaSemana = "Quinta";
                break;
            case Calendar.FRIDAY:
                nomeDiaSemana = "Sexta";
                break;
            case Calendar.SATURDAY:
                nomeDiaSemana = "sábado";
                break;
        }
    }
}
