/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.converterDataStringDataDate;
import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jDataSaida;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jIdInternoEvadido;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jIdSaida;
import static gestor.Visao.TelaEvadidosSaidaTemporariaManual.jNomeInternoEvadido;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaPesqInternosEvadidosEducacao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();

    String dataEntrada, dataSaida, dataSaidaTemp;
    String dataRetorno, dataPrevRetorno;
    String dataBrasil;
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    String NrDocRetorno = "";
    String NrDocRetornoNull = null;
    String evadido = "";
    int flag;
    String nomeInterno;
    String idInt;
    String horarioEntrada = "00:00";

    /**
     * Creates new form TelaPesqInternosEvadidosManual
     */
    public TelaPesqInternosEvadidosEducacao() {
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
        jLabel1 = new javax.swing.JLabel();
        jPesqNomeInternoEvadido = new javax.swing.JTextField();
        jBtPesqNomeInternoEvadido = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jBtSelecionar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaIntEvadidosSaidaLaborativa = new javax.swing.JTable();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos Saída Educacional {Evadido} :::..");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jPesqNomeInternoEvadido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInternoEvadido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInternoEvadido.setContentAreaFilled(false);
        jBtPesqNomeInternoEvadido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoEvadidoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesqNomeInternoEvadido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtPesqNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtSelecionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionar.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
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

        jTabelaIntEvadidosSaidaLaborativa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaIntEvadidosSaidaLaborativa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Id Doc.", "Data Saída", "H. Saída", "Data Entrada", "H. Entrada"
            }
        ));
        jTabelaIntEvadidosSaidaLaborativa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaIntEvadidosSaidaLaborativaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaIntEvadidosSaidaLaborativa);
        if (jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumnCount() > 0) {
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setMaxWidth(70);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setMinWidth(60);
            jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtSair))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSelecionar});

        setBounds(300, 20, 636, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInternoEvadido.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome de interno a ser selecionado.");
        } else if (idInt == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecione corretamente o nome do interno..");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + nomeInterno + "'");
                conecta.rs.first();
                jIdInternoEvadido.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoEvadido.setText(conecta.rs.getString("NomeInternoCrc"));
                jIdSaida.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + ex);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqNomeInternoEvadidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoEvadidoActionPerformed
        // TODO add your handling code here:
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jPesqNomeInternoEvadido.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
            } else {
                preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE Evadido='" + evadido + "' "
                        + "AND NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido.getText() + "%' "
                        + "AND DataEntrada<'" + dataSisConvert + "' "
                        + "AND HorarioEntrada='" + horarioEntrada + "'");
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jPesqNomeInternoEvadido.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
            } else {
                preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE Evadido='" + evadido + "' "
                        + "AND NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido.getText() + "%' "
                        + "AND DataEntrada<'" + jDataSistema.getText() + "' "
                        + "AND HorarioEntrada='" + horarioEntrada + "'");
            }
        }
    }//GEN-LAST:event_jBtPesqNomeInternoEvadidoActionPerformed

    private void jTabelaIntEvadidosSaidaLaborativaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaIntEvadidosSaidaLaborativaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            nomeInterno = "" + jTabelaIntEvadidosSaidaLaborativa.getValueAt(jTabelaIntEvadidosSaidaLaborativa.getSelectedRow(), 1);
            jPesqNomeInternoEvadido.setText(nomeInterno);
            idInt = "" + jTabelaIntEvadidosSaidaLaborativa.getValueAt(jTabelaIntEvadidosSaidaLaborativa.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaIntEvadidosSaidaLaborativaMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE Evadido='" + evadido + "' "
                        + "AND DataEntrada<'" + dataSisConvert + "' "
                        + "AND HorarioEntrada='" + horarioEntrada + "'");
            } else {
                limparTabela();
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            flag = 1;
            if (evt.getStateChange() == evt.SELECTED) {
                this.preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE Evadido='" + evadido + "' "
                        + "AND DataEntrada<'" + jDataSistema.getText() + "' "
                        + "AND HorarioEntrada='" + horarioEntrada + "'");
            } else {
                limparTabela();
            }
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtPesqNomeInternoEvadido;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPesqNomeInternoEvadido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaIntEvadidosSaidaLaborativa;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaEvadidoSaidaTemporaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno ", "Id Doc.", "Data Saída", "H. Saída", "Dt.Entrada", "H.Entrada"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Saida
                dataSaidaTemp = conecta.rs.getString("DataSaida");
                String diap = dataSaidaTemp.substring(8, 10);
                String mesp = dataSaidaTemp.substring(5, 7);
                String anop = dataSaidaTemp.substring(0, 4);
                dataSaidaTemp = diap + "/" + mesp + "/" + anop;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String diar = dataEntrada.substring(8, 10);
                String mesr = dataEntrada.substring(5, 7);
                String anor = dataEntrada.substring(0, 4);
                dataEntrada = diar + "/" + mesr + "/" + anor;
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("IdLanc"), dataSaidaTemp, conecta.rs.getString("HorarioSaida"), dataEntrada, conecta.rs.getString("HorarioEntrada")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaLaborativa.setModel(modelo);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaLaborativa.setAutoResizeMode(jTabelaIntEvadidosSaidaLaborativa.AUTO_RESIZE_OFF);
        alinhaColunasTabelaEvadidosSaidaLaborativa();
        jTabelaIntEvadidosSaidaLaborativa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno ", "Id Doc.", "Data Saída", "H. Saída", "Dt.Entrada", "H.Entrada"};
        conecta.abrirConexao();
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaLaborativa.setModel(modelo);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setResizable(false);
        jTabelaIntEvadidosSaidaLaborativa.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaLaborativa.setAutoResizeMode(jTabelaIntEvadidosSaidaLaborativa.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaLaborativa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinhaColunasTabelaEvadidosSaidaLaborativa() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        //
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaLaborativa.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }
}
