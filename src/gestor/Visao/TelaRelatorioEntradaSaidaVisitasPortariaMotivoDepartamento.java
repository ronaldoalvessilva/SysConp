/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
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
public class TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    String dataInicial, dataFinal;
    int codigoDepto;

    /**
     * Creates new form TelaRelMapaConfere
     */
    public TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento() {
        initComponents();
        preencherComboDepto();
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
        jCodigoDepto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDepartamento = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPesDtPopInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPesDtPopFinal = new com.toedter.calendar.JDateChooser();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Relatório Entrada/Saída Visitas Diversas :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jCodigoDepto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCodigoDepto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoDepto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoDepto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoDepto.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Departamento");

        jComboBoxDepartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxDepartamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxDepartamentoMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial:");

        jPesDtPopInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Final:");

        jPesDtPopFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCodigoDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(168, 168, 168))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(550, 150, 410, 209);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jPesDtPopInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jPesDtPopFinal.getDate().getTime());
                        try {
                            conecta.abrirConexao();
                            String path = "reports/Portarias/RelatorioVisitasDiversaMotivoDepartamento.jasper";
                            conecta.executaSQL("SELECT * FROM ITENSVISITASDIVERSAS "
                                    + "INNER JOIN VISITASDIVERSAS "
                                    + "ON ITENSVISITASDIVERSAS.IdVisita=VISITASDIVERSAS.IdVisita "
                                    + "INNER JOIN DEPARTAMENTOS "
                                    + "ON ITENSVISITASDIVERSAS.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                                    + "WHERE DataEntrada>='" + dataInicial + "' "
                                    + "AND dataEntrada<='" + dataFinal + "' "
                                    + "AND NomeDepartamento='" + jComboBoxDepartamento.getSelectedItem() + "' "
                                    + "ORDER BY DEPARTAMENTOS.IdDepartamento,ITENSVISITASDIVERSAS.DataEntrada");
                            HashMap parametros = new HashMap();
                            parametros.put("nomeDepartamento", jComboBoxDepartamento.getSelectedItem());
                            parametros.put("dataInicial", dataInicial);
                            parametros.put("dataFinal", dataFinal);
                            parametros.put("nomeUsuario", nameUser);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Relatório de Visitantes por Departamentos e Motivo");
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
                            String path = "reports/Portarias/RelatorioVisitasDiversaMotivoDepartamento.jasper";
                            conecta.executaSQL("SELECT * FROM ITENSVISITASDIVERSAS "
                                    + "INNER JOIN VISITASDIVERSAS "
                                    + "ON ITENSVISITASDIVERSAS.IdVisita=VISITASDIVERSAS.IdVisita "
                                    + "INNER JOIN DEPARTAMENTOS "
                                    + "ON ITENSVISITASDIVERSAS.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                                    + "WHERE DataEntrada>='" + dataInicial + "' "
                                    + "AND dataEntrada<='" + dataFinal + "' "
                                    + "AND NomeDepartamento='" + jComboBoxDepartamento.getSelectedItem() + "' "
                                    + "ORDER BY DEPARTAMENTOS.IdDepartamento,ITENSVISITASDIVERSAS.DataEntrada");
                            HashMap parametros = new HashMap();
                            parametros.put("nomeDepartamento", jComboBoxDepartamento.getSelectedItem());
                            parametros.put("dataInicial", dataInicial);
                            parametros.put("dataFinal", dataFinal);
                            parametros.put("nomeUsuario", nameUser);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Relatório de Visitantes por Departamentos e Motivo");
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

    private void jComboBoxDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoMouseClicked
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + jComboBoxDepartamento.getSelectedItem() + "'");
            conecta.rs.first();
            do {
                // jComboBoxDepartamento.addItem(conecta.rs.getString("NomeDepartamento"));
                jCodigoDepto.setText(conecta.rs.getString("IdDepartamento"));
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
        conecta.desconecta();
    }//GEN-LAST:event_jComboBoxDepartamentoMouseClicked

    private void jComboBoxDepartamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoMouseEntered
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + jComboBoxDepartamento.getSelectedItem() + "'");
            conecta.rs.first();
            do {
                // jComboBoxDepartamento.addItem(conecta.rs.getString("NomeDepartamento"));
                jCodigoDepto.setText(conecta.rs.getString("IdDepartamento"));
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
        conecta.desconecta();
    }//GEN-LAST:event_jComboBoxDepartamentoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JTextField jCodigoDepto;
    private javax.swing.JComboBox jComboBoxDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jPesDtPopFinal;
    private com.toedter.calendar.JDateChooser jPesDtPopInicial;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    public void preencherComboDepto() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxDepartamento.addItem(conecta.rs.getString("NomeDepartamento"));
                jCodigoDepto.setText(conecta.rs.getString("IdDepartamento"));
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
