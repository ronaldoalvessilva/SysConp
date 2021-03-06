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
import static gestor.Visao.TelaEntradasLote.idItem;
import static gestor.Visao.TelaPreLocaoInternos.jCodigoReg;
import static gestor.Visao.TelaPreLocaoInternos.jDocEntrada;
import static gestor.Visao.TelaPreLocaoInternos.jFotoInternoExportado;
import static gestor.Visao.TelaPreLocaoInternos.jIdInternoReg;
import static gestor.Visao.TelaPreLocaoInternos.jNomeInternoReg;
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
public class TelaPesqInternoEntradaCrcPreLocacao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaLote objEntLote = new EntradaLote();
    ItensEntradaLote objItens = new ItensEntradaLote();
    int flag;
    String dataEntrada;
    String dataSaida;
    String caminho;
    String confirmacao = "Não";

    /**
     * Creates new form TelaPesqColaborador
     */
    public TelaPesqInternoEntradaCrcPreLocacao() {
        initComponents();
        formatarCampos();        
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
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jRegistroEntrada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesqInterno = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Pesquisa Entrada Interno - {CRC} :::...");

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

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Registo Entrada:");

        jRegistroEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRegistroEntrada.setForeground(new java.awt.Color(204, 0, 0));
        jRegistroEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRegistroEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRegistroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTodos)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel2)
                .addComponent(jRegistroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBtPesqNome)
                .addComponent(jCheckBoxTodos))
        );

        jTabelaPesqInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Registro", "Código", "Nome do Interno", "Matricula Penal", "Unidade Penal(Procedência)", "Regime"
            }
        ));
        jTabelaPesqInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesqInterno);
        if (jTabelaPesqInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqInterno.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPesqInterno.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPesqInterno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPesqInterno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPesqInterno.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaPesqInterno.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaPesqInterno.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaPesqInterno.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaPesqInterno.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaPesqInterno.getColumnModel().getColumn(4).setMaxWidth(250);
            jTabelaPesqInterno.getColumnModel().getColumn(5).setMinWidth(80);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair))
                .addGap(6, 6, 6))
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
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 20, 810, 328);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 2);
            jNomeInternoReg.setText(nomeInterno);
            String idInterno = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 1);
            jIdInternoReg.setText(idInterno);
            String idReg = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 0);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSENTRADA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + idInterno + "' "
                        + "AND IdEntrada='" + idReg + "'");
                        
                conecta.rs.first();
                // Tabela Funcionarios
                jIdInternoReg.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoReg.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoExportado.setIcon(i);
                    jFotoInternoExportado.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoExportado.getWidth(), jFotoInternoExportado.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR FOTO DO BANCO DE DADOS.
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoExportado.getWidth(), jFotoInternoExportado.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoExportado.setIcon(icon);
                }
                jDocEntrada.setText(conecta.rs.getString("IdEntrada"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados." + ex);
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
        if (jNomeInternoCrc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisar.");
            jNomeInternoCrc.requestFocus();
        } else if (jRegistroEntrada.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do registro de entrada dos internos.");
        } else {
            buscarInternos("SELECT * FROM ITENSENTRADA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN UNIDADE "
                    + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoCrc.getText() + "%' "
                    + "AND ITENSENTRADA.IdEntrada='" + jRegistroEntrada.getText() + "' "
                    + "AND ConfirmaUtil='" + confirmacao + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (jRegistroEntrada.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do registro de entrada dos internos.");
        } else {
            if (evt.getStateChange() == evt.SELECTED) {
                this.buscarInternos("SELECT * FROM ITENSENTRADA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "WHERE ITENSENTRADA.IdEntrada='" + jRegistroEntrada.getText() + "' "
                        + "AND ConfirmaUtil='" + confirmacao + "'");
            } else {
                limparTabelaInternos();
            }
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaPesqInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqInternoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 2);
            jNomeInternoCrc.setText(nomeInterno);
            idItem = "" + jTabelaPesqInterno.getValueAt(jTabelaPesqInterno.getSelectedRow(), 0);
        }
    }//GEN-LAST:event_jTabelaPesqInternoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtSair;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jRegistroEntrada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPesqInterno;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos(){
        //jRegistro.setText(jCodigoReg.getText());
        jNomeInternoCrc.setDocument(new LimiteDigitos(200));
    }
//Preencher tabela com todos os INTERNOS
    public void buscarInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno ", "Unidade Penal (Procedência)", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdEntrada"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("DescricaoUnid"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInterno.setModel(modelo);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaPesqInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqInterno.setAutoResizeMode(jTabelaPesqInterno.AUTO_RESIZE_OFF);
        jTabelaPesqInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno ", "Unidade Penal (Procedência)", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqInterno.setModel(modelo);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPesqInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaPesqInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaPesqInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaPesqInterno.getColumnModel().getColumn(4).setResizable(false);
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
        jTabelaPesqInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }
}
