/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.DadosPenaisCrc;
import static gestor.Visao.TelaProntuarioCrc.jCNC;
import static gestor.Visao.TelaProntuarioCrc.jDataEntrada;
import static gestor.Visao.TelaProntuarioCrc.jIdInterno;
import static gestor.Visao.TelaProntuarioCrc.jNomeInterno;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class TelaFasesPersecucao extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    //
    String dataCrime;
    String dataEntrada;
    String dataPrisao;
    String dataCondencao;
    String dataTermino;
    /**
     * Creates new form TelaFasesPersecucao
     */
    public static TelaProntuarioCrc pProntuario;

    public TelaFasesPersecucao(TelaProntuarioCrc parent, boolean modal) {
        this.pProntuario = parent;
        this.setModal(modal);
        setLocationRelativeTo(pProntuario);
        initComponents();
        corCampos();
        buscarDadosInternos();
        preencherTabelaDocumentosProcessos("SELECT * FROM HISTORICO_DADOS_PENAIS_INTERNOS "
                + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIdInternoCrc = new javax.swing.JTextField();
        jCncCrc = new javax.swing.JTextField();
        jNomeInternoCrc = new javax.swing.JTextField();
        jDataEntradaCrc = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDataSaidaCrc = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaDocumentosProcesso = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Fases de Persecução :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CNC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Entrada");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome do Interno");

        jIdInternoCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoCrc.setEnabled(false);

        jCncCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCncCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCncCrc.setEnabled(false);

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrc.setEnabled(false);

        jDataEntradaCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntradaCrc.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Saída");

        jDataSaidaCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaidaCrc.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCncCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDataEntradaCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataSaidaCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCncCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEntradaCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaidaCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabelaDocumentosProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDocumentosProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Entrada", "Data Prisão", "Data Crime", "Data Condenação", "Regime", "Termino Pena", "Artigo1", "Artigo2", "Artigo3", "Paragráfo1", "Paragráfo2", "Paragráfo3"
            }
        ));
        jScrollPane1.setViewportView(jTabelaDocumentosProcesso);
        if (jTabelaDocumentosProcesso.getColumnModel().getColumnCount() > 0) {
            jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setMaxWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setMinWidth(80);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFasesPersecucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFasesPersecucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFasesPersecucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFasesPersecucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaFasesPersecucao dialog = new TelaFasesPersecucao(pProntuario, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField jCncCrc;
    public static com.toedter.calendar.JDateChooser jDataEntradaCrc;
    public static com.toedter.calendar.JDateChooser jDataSaidaCrc;
    public static javax.swing.JTextField jIdInternoCrc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaDocumentosProcesso;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdInternoCrc.setBackground(Color.white);
        jCncCrc.setBackground(Color.white);
        jNomeInternoCrc.setBackground(Color.white);
    }

    public void buscarDadosInternos() {
        jIdInternoCrc.setText(jIdInterno.getText());
        jCncCrc.setText(jCNC.getText());
        jNomeInternoCrc.setText(jNomeInterno.getText());
        jDataEntradaCrc.setDate(jDataEntrada.getDate());
    }

    public void preencherTabelaDocumentosProcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Entrada", "Data Prisão", "Data Crime", "Data Condenação", "Regime", "Termino Pena", "Artigo1", "Artigo2", "Artigo4", "Paragráfo1", "Paragráfo2", "Paragráfo3"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataCrime = conecta.rs.getString("DataCrime");
                if (dataCrime != null) {
                    String diaC = dataCrime.substring(8, 10);
                    String mesC = dataCrime.substring(5, 7);
                    String anoC = dataCrime.substring(0, 4);
                    dataCrime = diaC + "/" + mesC + "/" + anoC;
                }
                dataEntrada = conecta.rs.getString("DataEntrada");
                if (dataEntrada != null) {
                    String diaE = dataEntrada.substring(8, 10);
                    String mesE = dataEntrada.substring(5, 7);
                    String anoE = dataEntrada.substring(0, 4);
                    dataEntrada = diaE + "/" + mesE + "/" + anoE;
                }
                dataPrisao = conecta.rs.getString("DataPrisao");
                if (dataPrisao != null) {
                    String diaP = dataPrisao.substring(8, 10);
                    String mesP = dataPrisao.substring(5, 7);
                    String anoP = dataPrisao.substring(0, 4);
                    dataPrisao = diaP + "/" + mesP + "/" + anoP;
                }
                dataCondencao = conecta.rs.getString("DataCondenacao");
                if (dataCondencao != null) {
                    String diaO = dataCondencao.substring(8, 10);
                    String mesO = dataCondencao.substring(5, 7);
                    String anoO = dataCondencao.substring(0, 4);
                    dataCondencao = diaO + "/" + mesO + "/" + anoO;
                }
                dataTermino = conecta.rs.getString("TerminoPena");
                if (dataTermino != null) {
                    String diaT = dataTermino.substring(8, 10);
                    String mesT = dataTermino.substring(5, 7);
                    String anoT = dataTermino.substring(0, 4);
                    dataTermino = diaT + "/" + mesT + "/" + anoT;
                }
                dados.add(new Object[]{dataEntrada, dataEntrada, dataPrisao, dataCondencao, conecta.rs.getString("Regime"), dataTermino, conecta.rs.getString("Artigo1"), conecta.rs.getString("Artigo2"), conecta.rs.getString("Artigo3"), conecta.rs.getString("Paragrafo1"), conecta.rs.getString("Paragrafo2"), conecta.rs.getString("Paragrafo3")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentosProcesso.setModel(modelo);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setResizable(false);        
        jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setResizable(false);
        jTabelaDocumentosProcesso.setAutoResizeMode(jTabelaDocumentosProcesso.AUTO_RESIZE_OFF);
        jTabelaDocumentosProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaDocumentosProcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaDocumentosProcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        
        jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setCellRenderer(centralizado);
    }

    public void limparTabelaDocumentos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Entrada", "Data Prisão", "Data Crime", "Data Condenação", "Regime", "Termino Pena", "Artigo1", "Artigo2", "Artigo4", "Paragráfo1", "Paragráfo2", "Paragráfo3"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentosProcesso.setModel(modelo);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(6).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(7).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(8).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(9).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(10).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setPreferredWidth(80);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(11).setResizable(false);
        jTabelaDocumentosProcesso.setAutoResizeMode(jTabelaDocumentosProcesso.AUTO_RESIZE_OFF);
        jTabelaDocumentosProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
}