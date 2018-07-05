/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.*;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.FotoInternoCrcSaida;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jBtZoon;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jComboBoxUnidadeDestino;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jDataSaida;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jIDInterno;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jNomeInterno;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jNrDocumento;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jTipoSaida;
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
 * @author Ronaldo
 */
public class TelaPesquisaRegistroSaidaInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    int flag;
    String caminho;
    String nomeInterno;
    String idInt;
    String dataSaida;
    String confirmacaoSaida = "Não";
    public static String idItemSaida; // Item da tabela de ITENS DE SAIDA (ITENSSAIDA)
    public static int idItemCrcPort; // Item da tabela ITENSCRCPORTARIA
    String codInt;

    /**
     * Creates new form TelaPesquisaEntradaInternos
     */
    public TelaPesquisaRegistroSaidaInterno() {
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
        jTabelaInterno = new javax.swing.JTable();
        jBtSair = new javax.swing.JButton();
        jBtEnviar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa de Internos Saída :::...");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Saídas de Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

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
                .addGap(19, 19, 19)
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

        jTabelaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Data Saída", "Destino Saída"
            }
        ));
        jTabelaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInterno);
        if (jTabelaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInterno.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaInterno.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaInterno.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaInterno.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaInterno.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaInterno.getColumnModel().getColumn(4).setMaxWidth(200);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 390, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(200, 10, 606, 272);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeActionPerformed

        flag = 1;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe NOME para pesquisa!!!");
            jPesqNome.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM ITENSCRCPORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNome.getText() + "%' "
                    + "AND SaidaConfirmada='" + confirmacaoSaida + "'");
        }
    }//GEN-LAST:event_jBtNomeActionPerformed

    private void jTabelaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            nomeInterno = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 2);
            jPesqNome.setText(nomeInterno);
            codInt = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 1);
            idInt = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 0);

        }
    }//GEN-LAST:event_jTabelaInternoMouseClicked

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        if (jPesqNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do interno e clique no botão ENVIAR");
        } else if (idInt == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecione nome do interno corretamente para ENVIAR.");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSCRCPORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENSCRCPORTARIA.IdItem='" + idInt + "' "
                        + "AND PRONTUARIOSCRC.NomeInternoCrc='" + nomeInterno + "' "
                        + "AND PRONTUARIOSCRC.IdInternoCrc='" + codInt + "'");
                conecta.rs.first();
                jIDInterno.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                jTipoSaida.setText(conecta.rs.getString("DestinoSaida"));
                jNrDocumento.setText(conecta.rs.getString("DocumentoSaida"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                idItemSaida = conecta.rs.getString("IdSaida"); //IdItemSaida antes
                idItemCrcPort = conecta.rs.getInt("IdItemSaida");
                idInt = conecta.rs.getString("IdItem");
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoInternoCrcSaida.setIcon(i);
                    FotoInternoCrcSaida.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoCrcSaida.getWidth(), FotoInternoCrcSaida.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInternoCrcSaida.getWidth(), FotoInternoCrcSaida.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInternoCrcSaida.setIcon(icon);
                }
                conecta.desconecta();
                jBtZoon.setEnabled(true);
                if (jTipoSaida.getText().equals("TRANSFERENCIA")) {
                    jComboBoxUnidadeDestino.setEnabled(true);
                    preencherComboBoxGrupo();
                } else {
                    jComboBoxUnidadeDestino.setEnabled(!true);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa INTERNO" + e);
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosInternos("SELECT * FROM ITENSCRCPORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE SaidaConfirmada='" + confirmacaoSaida + "'");
        } else {
            limparTabelaInternos();
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
    private javax.swing.JTable jTabelaInterno;
    // End of variables declaration//GEN-END:variables

    public void preencherComboBoxGrupo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE");
            conecta.rs.first();
            do {
                jComboBoxUnidadeDestino.addItem(conecta.rs.getString("DescricaoUnid"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

// Método de pesquisa pela Descrição
    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Saída", "Destino Saída"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataSaida = conecta.rs.getString("DataSaida");
                String dia = dataSaida.substring(8, 10);
                String mes = dataSaida.substring(5, 7);
                String ano = dataSaida.substring(0, 4);
                dataSaida = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("DestinoSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Saída", "Destino Saída"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataSaida = conecta.rs.getString("DataSaida");
                String dia = dataSaida.substring(8, 10);
                String mes = dataSaida.substring(5, 7);
                String ano = dataSaida.substring(0, 4);
                dataSaida = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("DestinoSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInterno();
        conecta.desconecta();
    }

    public void alinharCamposTabelaInterno() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Saída", "Destino Saída"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}
