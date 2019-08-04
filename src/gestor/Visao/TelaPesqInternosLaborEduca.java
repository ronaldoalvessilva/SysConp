/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.FotoInternoEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jBtZoon;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jNomeInstituicao;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jIdInternoEduExt;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jMatriculaInternoEdu;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jNomeInternoEdu;
//import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jSituacao;
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
public class TelaPesqInternosLaborEduca extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    String statusEmp = "ABERTO";
    String caminho;
    int tipoAcesso = 0; // Zero é liberado na tabela de INTERNOS_SAIDA_EDUCACIONAL
    String evadidoEscola = "";

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqInternosLaborEduca() {
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
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInternosEmpresaLab = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Agendamento Internos - {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtPesqNome))
                .addContainerGap())
        );

        jTabelaPesqInternosEmpresaLab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInternosEmpresaLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "CNC"
            }
        ));
        jTabelaPesqInternosEmpresaLab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternosEmpresaLabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInternosEmpresaLab);
        if (jTabelaPesqInternosEmpresaLab.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(1).setMinWidth(350);
            jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(1).setMaxWidth(350);
            jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setMaxWidth(100);
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 355, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair)))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        setBounds(250, 20, 564, 295);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInternosEmpresaLab.getValueAt(jTabelaPesqInternosEmpresaLab.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INTERNOS_SAIDA_EDUCACIONAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_SAIDA_EDUCACIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN ASSISTENCIA_EDUCACAO_EXTERNA "
                        + "ON INTERNOS_SAIDA_EDUCACIONAL.IdEduca=ASSISTENCIA_EDUCACAO_EXTERNA.IdEduca "
                        + "INNER JOIN INSTITUICAOESCOLAR "
                        + "ON ASSISTENCIA_EDUCACAO_EXTERNA.IdCod=INSTITUICAOESCOLAR.IdCod "
                        + "WHERE NomeInstituicao='" + jNomeInstituicao.getText() + "' "
                        + "AND TipoAcesso='" + tipoAcesso + "' "
                        + "AND NomeInternoCrc='" + jPesqNomeInterno.getText() + "' "
                        + "AND SituacaoCrc='" + situacaoEnt + "' "
                        + "OR NomeInstituicao='" + jNomeInstituicao.getText() + "' "
                        + "AND TipoAcesso='" + tipoAcesso + "' "
                        + "AND NomeInternoCrc='" + jPesqNomeInterno.getText() + "' "
                        + "AND SituacaoCrc='" + situacaoRet + "'");
                conecta.rs.first();
                jIdInternoEduExt.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoEdu.setText(conecta.rs.getString("NomeInternoCrc"));
                jMatriculaInternoEdu.setText(conecta.rs.getString("MatriculaCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoInternoEdu.setIcon(i);
                    FotoInternoEdu.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoEdu.getWidth(), FotoInternoEdu.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInternoEdu.getWidth(), FotoInternoEdu.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInternoEdu.setIcon(icon);
                }
                conecta.desconecta();
                jBtZoon.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa, verifique a situacao do interno no CRC.");
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
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jPesqNomeInterno.requestFocus();
        } else {
            buscarInternoAgendados("SELECT * FROM INTERNOS_SAIDA_EDUCACIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ASSISTENCIA_EDUCACAO_EXTERNA "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdEduca=ASSISTENCIA_EDUCACAO_EXTERNA.IdEduca "
                    + "INNER JOIN INSTITUICAOESCOLAR "
                    + "ON ASSISTENCIA_EDUCACAO_EXTERNA.IdCod=INSTITUICAOESCOLAR.IdCod "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%' "
                    + "AND NomeInstituicao='" + jNomeInstituicao.getText() + "' "
                    + "AND TipoAcesso='" + tipoAcesso + "' "
                    + "AND Evadido='" + evadidoEscola + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.buscarInternoAgendados("SELECT * FROM INTERNOS_SAIDA_EDUCACIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ASSISTENCIA_EDUCACAO_EXTERNA "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdEduca=ASSISTENCIA_EDUCACAO_EXTERNA.IdEduca "
                    + "INNER JOIN INSTITUICAOESCOLAR "
                    + "ON ASSISTENCIA_EDUCACAO_EXTERNA.IdCod=INSTITUICAOESCOLAR.IdCod "
                    + "WHERE NomeInstituicao='" + jNomeInstituicao.getText() + "' "
                    + "AND TipoAcesso='" + tipoAcesso + "' "
                    + "AND Evadido='" + evadidoEscola + "'");
        } else {
            limparTabelaInternos();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaPesqInternosEmpresaLabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternosEmpresaLabMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            String nomeInterno = "" + jTabelaPesqInternosEmpresaLab.getValueAt(jTabelaPesqInternosEmpresaLab.getSelectedRow(), 1);
            jPesqNomeInterno.setText(nomeInterno);
        }
    }//GEN-LAST:event_jTabelaPesqInternosEmpresaLabMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqInternosEmpresaLab;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os COLABORADORES
    public void buscarInternoAgendados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "CNC"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Cnc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!\nERRO: " + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternosEmpresaLab.setModel(modelo);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternosEmpresaLab.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternosEmpresaLab.setAutoResizeMode(jTabelaPesqInternosEmpresaLab.AUTO_RESIZE_OFF);
        jTabelaPesqInternosEmpresaLab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "CNC"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInternosEmpresaLab.setModel(modelo);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaPesqInternosEmpresaLab.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInternosEmpresaLab.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInternosEmpresaLab.setAutoResizeMode(jTabelaPesqInternosEmpresaLab.AUTO_RESIZE_OFF);
        jTabelaPesqInternosEmpresaLab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}
