/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronaldo
 */
public class TelaRelatorioEntradaSaidaColaboradoresPortariaIndividual extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    String dataInicial, dataFinal;
    int codigoDepto;
    String codigoFunc = "";

    /**
     * Creates new form TelaRelMapaConfere
     */
    public TelaRelatorioEntradaSaidaColaboradoresPortariaIndividual() {
        initComponents();
        preencherComboBoxColaborador();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxNomeColaborador = new javax.swing.JComboBox<>();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesDtPopInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPesDtPopFinal = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("...::: Relatório Entrada/Saída Colaboradores  :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome do Colaborador");

        jComboBoxNomeColaborador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNomeColaborador.setForeground(new java.awt.Color(153, 0, 0));
        jComboBoxNomeColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxNomeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxNomeColaborador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 0, 255));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial:");

        jPesDtPopInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Final:");

        jPesDtPopFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jTabbedPane1.addTab("Pesquisas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(550, 150, 539, 225);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        pesquisarCodigocolaborador();
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jComboBoxNomeColaborador.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do colaborador para gerar o relatório...");
            } else if (jPesDtPopInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data inicial não pode ser em branco.");
                jPesDtPopInicial.requestFocus();
            } else {
                if (jPesDtPopFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Data final não pode ser em branco.");
                    jPesDtPopFinal.requestFocus();
                } else {
                    if (jPesDtPopInicial.getDate().after(jPesDtPopFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final.");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jPesDtPopInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jPesDtPopFinal.getDate().getTime());
                        try {
                            conecta.abrirConexao();
                            String path = "reports/GerenciaAdministrativa/RelatorioIndividualColaborador.jasper";
                            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON DEPARTAMENTOS.IdDepartamento=COLABORADOR.IdDepartamento "
                                    + "INNER JOIN ITENSENTRADASFUNC "
                                    + "ON COLABORADOR.IdFunc=ITENSENTRADASFUNC.IdFunc "
                                    + "WHERE DataEntrada>='" + dataInicial + "' "
                                    + "AND DataEntrada<='" + dataFinal + "' "
                                    + "AND ITENSENTRADASFUNC.IdFunc='" + codigoFunc + "'"
                                    + "ORDER BY ITENSENTRADASFUNC.DataEntrada");
                            HashMap parametros = new HashMap();
                            parametros.put("pDataInicial", dataInicial);
                            parametros.put("pDataFinal", dataFinal);
                            parametros.put("pNomeUsuario", nameUser);
                            parametros.put("pCodigo", codigoFunc);
                            parametros.put("pDescricaoUnidade", descricaoUnidade);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Relatório Individual de Colaboradores (Frequência)");
                            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                            jv.toFront(); // Traz o relatorio para frente da aplicação            
                            conecta.desconecta();
                        } catch (JRException e) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                        }
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jPesDtPopInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data inicial não pode ser em branco.");
                jPesDtPopInicial.requestFocus();
            } else {
                if (jPesDtPopFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Data final não pode ser em branco.");
                    jPesDtPopFinal.requestFocus();
                } else {
                    if (jPesDtPopInicial.getDate().after(jPesDtPopFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final.");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jPesDtPopInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jPesDtPopFinal.getDate().getTime());
                        try {
                            conecta.abrirConexao();
                            String path = "reports/GerenciaAdministrativa/RelatorioIndividualColaborador.jasper";
                            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                                    + "INNER JOIN COLABORADOR "
                                    + "ON DEPARTAMENTOS.IdDepartamento=COLABORADOR.IdDepartamento "
                                    + "INNER JOIN ITENSENTRADASFUNC "
                                    + "ON COLABORADOR.IdFunc=ITENSENTRADASFUNC.IdFunc "
                                    + "WHERE DataEntrada>='" + dataInicial + "' "
                                    + "AND DataEntrada<='" + dataFinal + "' "
                                    + "AND ITENSENTRADASFUNC.IdFunc='" + codigoFunc + "'"
                                    + "ORDER BY ITENSENTRADASFUNC.DataEntrada");
                            HashMap parametros = new HashMap();
                            parametros.put("pDataInicial", dataInicial);
                            parametros.put("pDataFinal", dataFinal);
                            parametros.put("pNomeUsuario", nameUser);
                            parametros.put("pCodigo", codigoFunc);
                            parametros.put("pDescricaoUnidade", descricaoUnidade);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Relatório Individual de Colaboradores (Frequência)");
                            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                            jv.toFront(); // Traz o relatorio para frente da aplicação            
                            conecta.desconecta();
                        } catch (JRException e) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxNomeColaborador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jPesDtPopFinal;
    private com.toedter.calendar.JDateChooser jPesDtPopInicial;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
   

    public void preencherComboBoxColaborador() {
        jComboBoxNomeColaborador.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR");
            conecta.rs.first();
            do {
                jComboBoxNomeColaborador.addItem(conecta.rs.getString("NomeFunc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void pesquisarCodigocolaborador() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + jComboBoxNomeColaborador.getSelectedItem() + "'");
            conecta.rs.first();
            codigoFunc = conecta.rs.getString("IdFunc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
