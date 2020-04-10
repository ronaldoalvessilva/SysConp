/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaConsultaOcorrenciaPortariaServicoSocial.jCodigoRegistro;
import static gestor.Visao.TelaConsultaOcorrenciaPortariaServicoSocial.jComboBoxTipoVisita;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int count = 0;
    int flag;
    String dataInicial, dataFinal, dataLiberacao;

    public static TelaConsultaOcorrenciaPortariaServicoSocial telaOcorrenciaPortSS;

    /**
     * Creates new form TelaAprovacaoOcorrenciaVisitaPortaria
     */
    public TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir(TelaConsultaOcorrenciaPortariaServicoSocial parent, boolean modal) {
        this.telaOcorrenciaPortSS = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaOcorrenciaPortSS);
        initComponents();
        if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
            preencherTabelaVisitas("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                    + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                    + "ON VISITAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE VISITAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
        } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
            preencherTabelaInternosVisitas("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                    + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                    + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaVisita = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Aprovação de Ocorrência Visitas Portaria :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jTabelaVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome da Visita", "Data Inicial", "Data Final", "Grau Parentesco"
            }
        ));
        jScrollPane1.setViewportView(jTabelaVisita);
        if (jTabelaVisita.getColumnModel().getColumnCount() > 0) {
            jTabelaVisita.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaVisita.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaVisita.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaVisita.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaVisita.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaVisita.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaVisita.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaVisita.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaVisita.getColumnModel().getColumn(4).setMinWidth(150);
            jTabelaVisita.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel64.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64)
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Consulta de Bloqueio/ Liberação das Visitas de Internos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir dialog = new TelaAprovacaoOcorrenciaVisitaPortariaSegurancaDir(telaOcorrenciaPortSS, true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaVisita;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Visitante", "Data Inicial", "Data Final", "Grau Parentesco"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                // Formatar a data Entrada
                dataInicial = conecta.rs.getString("DataBloq");
                if (dataInicial != null) {
                    String diae = dataInicial.substring(8, 10);
                    String mese = dataInicial.substring(5, 7);
                    String anoe = dataInicial.substring(0, 4);
                    dataInicial = diae + "/" + mese + "/" + anoe;
                }
                if (dataFinal != null) {
                    dataFinal = conecta.rs.getString("DataBloq1");
                    String diaf = dataFinal.substring(8, 10);
                    String mesf = dataFinal.substring(5, 7);
                    String anof = dataFinal.substring(0, 4);
                    dataFinal = diaf + "/" + mesf + "/" + anof;
                }                          
                count = count + 1;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("IdVisita"), conecta.rs.getString("NomeVisita"), dataInicial, dataFinal, conecta.rs.getString("ParentescoVisita")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisita.setModel(modelo);
        jTabelaVisita.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaVisita.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaVisita.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTabelaVisita.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisita.getTableHeader().setReorderingAllowed(false);
        jTabelaVisita.setAutoResizeMode(jTabelaVisita.AUTO_RESIZE_OFF);
        jTabelaVisita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaVisitas();
        conecta.desconecta();
    }

    public void preencherTabelaInternosVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Visitante", "Data Inicial", "Data Final", "Data Liberação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                // Formatar a data Entrada
                dataInicial = conecta.rs.getString("DataBloq");
                String diae = dataInicial.substring(8, 10);
                String mese = dataInicial.substring(5, 7);
                String anoe = dataInicial.substring(0, 4);
                dataInicial = diae + "/" + mese + "/" + anoe;
                //
                dataFinal = conecta.rs.getString("DataBloq1");
                String diaf = dataFinal.substring(8, 10);
                String mesf = dataFinal.substring(5, 7);
                String anof = dataFinal.substring(0, 4);
                dataFinal = diaf + "/" + mesf + "/" + anof;
                //                   
                dataLiberacao = conecta.rs.getString("DataLib");
                if (dataLiberacao != null) {
                    String dial = dataLiberacao.substring(8, 10);
                    String mesl = dataLiberacao.substring(5, 7);
                    String anol = dataLiberacao.substring(0, 4);
                    dataLiberacao = dial + "/" + mesl + "/" + anol;
                }
                //
                count = count + 1;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataInicial, dataFinal, dataLiberacao});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisita.setModel(modelo);
        jTabelaVisita.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaVisita.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaVisita.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTabelaVisita.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisita.getTableHeader().setReorderingAllowed(false);
        jTabelaVisita.setAutoResizeMode(jTabelaVisita.AUTO_RESIZE_OFF);
        jTabelaVisita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaVisitas();
        conecta.desconecta();
    }

    public void alinharTabelaVisitas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisita.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisita.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaVisita.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }
}
