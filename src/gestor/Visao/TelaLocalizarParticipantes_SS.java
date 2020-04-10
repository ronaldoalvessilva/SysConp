/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.LimiteDigitos;
import Utilitarios.ModeloTabela;
import gestor.Dao.*;
import gestor.Modelo.EntradaLote;
import gestor.Modelo.ItensEntradaLote;
import static gestor.Visao.TelaAtendimentoGrupoSS.jCNC;
import static gestor.Visao.TelaAtendimentoGrupoSS.jCela;
import static gestor.Visao.TelaAtendimentoGrupoSS.jCodigoAtend;
import static gestor.Visao.TelaAtendimentoGrupoSS.jDataNascimento;
import static gestor.Visao.TelaAtendimentoGrupoSS.jFotoInternoGrupo;
import static gestor.Visao.TelaAtendimentoGrupoSS.jIdInternoGrp;
import static gestor.Visao.TelaAtendimentoGrupoSS.jNomeInternoGrp;
import static gestor.Visao.TelaAtendimentoGrupoSS.jNomeMae;
import static gestor.Visao.TelaAtendimentoGrupoSS.jPavilhao;
import static gestor.Visao.TelaAtendimentoGrupoSS.jRegime;
import static gestor.Visao.TelaAtendimentoGrupoSS.idItem;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtAlterarParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtCancelarParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtExcluirParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtNovoParticipantes;
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
public class TelaLocalizarParticipantes_SS extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaLote objEntLote = new EntradaLote();
    ItensEntradaLote objItens = new ItensEntradaLote();
    int flag;
    String dataEntrada;
    String dataSaida;
    String caminho;

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaLocalizarParticipantes_SS() {
        initComponents();
        jNomeInternoCrc.setDocument(new LimiteDigitos(50));
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
        jNomeInternoCrc = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInterno = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Entrada Interno - {ATG} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Entrada de Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setToolTipText("Pesquisa por Nome");
        jBtPesqNome.setContentAreaFilled(false);
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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaPesqInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Nome do Interno", "Matricula Penal", "Regime"
            }
        ));
        jTabelaPesqInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInterno);
        if (jTabelaPesqInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInterno.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPesqInterno.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPesqInterno.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaPesqInterno.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaPesqInterno.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaPesqInterno.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaPesqInterno.getColumnModel().getColumn(3).setMinWidth(90);
            jTabelaPesqInterno.getColumnModel().getColumn(3).setMaxWidth(90);
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

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

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

        setBounds(250, 20, 594, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 1);
            jNomeInternoCrc.setText(nomeInterno);
            //
            jBtNovoParticipantes.setEnabled(true);
            jBtAlterarParticipantes.setEnabled(true);
            jBtExcluirParticipantes.setEnabled(true);
            jBtCancelarParticipantes.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_SS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInternoCrc.getText() + "' "
                        + "AND PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdAtGrupoSS='" + jCodigoAtend.getText() + "'");
                conecta.rs.first();
                // Tabela Funcionarios
                jIdInternoGrp.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoGrp.setText(conecta.rs.getString("NomeInternoCrc"));
                jCNC.setText(conecta.rs.getString("Cnc"));
                jRegime.setText(conecta.rs.getString("Regime"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoGrupo.setIcon(i);
                    jFotoInternoGrupo.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoGrupo.getWidth(), jFotoInternoGrupo.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoGrupo.getWidth(), jFotoInternoGrupo.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoGrupo.setIcon(icon);
                }
                //
                idItem = conecta.rs.getString("IdItemPartSS");
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jNomeMae.setText(conecta.rs.getString("MaeInternoCrc"));
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                jCela.setText(conecta.rs.getString("EndCelaPav"));
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
        objEntLote.setIdLanc(Integer.valueOf(jCodigoAtend.getText()));
        flag = 1;
        if (jNomeInternoCrc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jNomeInternoCrc.requestFocus();
        } else {
            buscarInternos("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_SS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoCrc.getText() + "%' "
                    + "AND PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdAtGrupoSS='" + jCodigoAtend.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jTabelaPesqInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 1);
            jNomeInternoCrc.setText(nomeInterno);
        }
    }//GEN-LAST:event_jTabelaPesqInternoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqInterno;
    // End of variables declaration//GEN-END:variables

//Preencher tabela com todos os INTERNOS
    public void buscarInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Nome do Interno ", "Matricula Penal", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdItemPartSS"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInterno.setModel(modelo);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInterno.setAutoResizeMode(jTabelaPesqInterno.AUTO_RESIZE_OFF);
        jTabelaPesqInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Nome do Interno ", "Matricula Penal", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInterno.setModel(modelo);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInterno.setAutoResizeMode(jTabelaPesqInterno.AUTO_RESIZE_OFF);
        jTabelaPesqInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        //
        jTabelaPesqInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
