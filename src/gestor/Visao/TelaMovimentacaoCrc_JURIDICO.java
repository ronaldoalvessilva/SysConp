/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleRefreshDataMovi;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ItensEntradaLote;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaPesquisaMovInterno.idInt;
import java.awt.Color;
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
public class TelaMovimentacaoCrc_JURIDICO extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleRefreshDataMovi controle = new ControleRefreshDataMovi();
    ItensEntradaLote objItens = new ItensEntradaLote();
    String caminho;
    String dataMovimento;

    /**
     * Creates new form TelaMovimentacaoCrc
     */
    public TelaMovimentacaoCrc_JURIDICO() {
        initComponents();
        corCampos();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jNomeInterno = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jFotoInterno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jUnidadePenal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRegime = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMatriculaPenalInterno = new javax.swing.JTextField();
        jBtPesquisarInterno = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBtSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jDataPena = new com.toedter.calendar.JDateChooser();
        jBtAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaMovimentacao = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Historico de Movimentação de Internos {CRC} :::...");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome Completo do Interno");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jFotoInterno.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Procedência:");

        jUnidadePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadePenal.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Regime:");

        jRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegime.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Matricula:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Nascimento:");

        jMatriculaPenalInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalInterno.setEnabled(false);

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setToolTipText("Pesquisar Interno");
        jBtPesquisarInterno.setContentAreaFilled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Pesquisar Internos");

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Tela");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Termino Pena:");

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jDataPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPena.setEnabled(false);

        jBtAtualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAtualizar.setForeground(new java.awt.Color(0, 0, 255));
        jBtAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAtualizar.setText("Refresh");
        jBtAtualizar.setToolTipText("Atualizar histórico");
        jBtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jMatriculaPenalInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jNomeInterno)
                            .addComponent(jUnidadePenal, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(jDataPena, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtualizar, jBtSair});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jMatriculaPenalInterno, jRegime});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(jMatriculaPenalInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(jUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jDataPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtSair)
                            .addComponent(jLabel4)
                            .addComponent(jBtPesquisarInterno)
                            .addComponent(jBtAtualizar)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jMatriculaPenalInterno, jRegime});

        jTabelaMovimentacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaMovimentacao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTabelaMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Mov.", "Documento", "Descrição da Operação", "Origem/Destino do Interno"
            }
        ));
        jScrollPane1.setViewportView(jTabelaMovimentacao);
        if (jTabelaMovimentacao.getColumnModel().getColumnCount() > 0) {
            jTabelaMovimentacao.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaMovimentacao.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaMovimentacao.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaMovimentacao.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaMovimentacao.getColumnModel().getColumn(2).setMinWidth(200);
            jTabelaMovimentacao.getColumnModel().getColumn(2).setMaxWidth(200);
            jTabelaMovimentacao.getColumnModel().getColumn(3).setMinWidth(260);
            jTabelaMovimentacao.getColumnModel().getColumn(3).setMaxWidth(260);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(250, 20, 659, 455);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // Pesquisar Internos        
        TelaPesquisaMovInterno_JURIDICO objTelaMovInt = new TelaPesquisaMovInterno_JURIDICO();
        TelaModuloJuridico.jPainelJuridico.add(objTelaMovInt);
        objTelaMovInt.show();
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtualizarActionPerformed
        // TODO add your handling code here:
        if (jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe interno selecionado, pesquise\n antes e caso necessário atualize a tela");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInterno.getText() + "' "
                        + "AND PRONTUARIOSCRC.IdInternoCrc='" + idInt + "'");
                conecta.rs.first();
                jIdInterno.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInterno.setIcon(i);
                jFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_DEFAULT)));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jUnidadePenal.setText(conecta.rs.getString("DescricaoUnid"));
                jMatriculaPenalInterno.setText(conecta.rs.getString("MatriculaCrc"));
                jRegime.setText(conecta.rs.getString("Regime"));
                jDataPena.setDate(conecta.rs.getDate("TerminoPena"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir os dados!!! \nERRO :" + ex);
            }
            //ZERAR HORARIOS DAS DATAS
            controle.alterarDataMovimentacao(objItens);
            preencherTabelaItens("SELECT * FROM MOVIMENTOCRC "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "ORDER BY DataMov");
        }
    }//GEN-LAST:event_jBtAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAtualizar;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtSair;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    public static com.toedter.calendar.JDateChooser jDataPena;
    public static javax.swing.JLabel jFotoInterno;
    public static javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaPenalInterno;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField jRegime;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTabelaMovimentacao;
    public static javax.swing.JTextField jUnidadePenal;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jMatriculaPenalInterno.setBackground(Color.white);
        jDataNascimento.setBackground(Color.white);
        jUnidadePenal.setBackground(Color.white);
        jRegime.setBackground(Color.white);
        jDataPena.setBackground(Color.white);
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Mov.", "Documento", "Descrição da Operação", "Origem/Destino do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataMovimento = conecta.rs.getString("DataMov");
                String dia = dataMovimento.substring(8, 10);
                String mes = dataMovimento.substring(5, 7);
                String ano = dataMovimento.substring(0, 4);
                dataMovimento = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{dataMovimento, conecta.rs.getInt("IdDoc"), conecta.rs.getString("NomeOpe"), conecta.rs.getString("OrigemDestino")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMovimentacao.setModel(modelo);
        jTabelaMovimentacao.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaMovimentacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMovimentacao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaMovimentacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMovimentacao.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTabelaMovimentacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMovimentacao.getColumnModel().getColumn(3).setPreferredWidth(260);
        jTabelaMovimentacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMovimentacao.getTableHeader().setReorderingAllowed(false);
        jTabelaMovimentacao.setAutoResizeMode(jTabelaMovimentacao.AUTO_RESIZE_OFF);
        jTabelaMovimentacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaMovimentacao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaMovimentacao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaMovimentacao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaMovimentacao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }
}