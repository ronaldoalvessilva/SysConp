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
 * @author ronaldo.silva7
 */
public class TelaRelatorioRetornoInternosPT extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    String pDATA_inicial, pDATA_final;

    /**
     * Creates new form TelaRelatorioRetornoInternosPT
     */
    public TelaRelatorioRetornoInternosPT() {
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
        jLabel2 = new javax.swing.JLabel();
        jPesDtRetInicial = new com.toedter.calendar.JDateChooser();
        jPesDtRetFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipoRetorno = new javax.swing.JComboBox<>();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("... Tela Relatório Retorno Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Final:");

        jPesDtRetInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesDtRetFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo Retorno:");

        jComboBoxTipoRetorno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoRetorno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Retorno de Saída Temporária", "Retorno médico", "Retorno audiência", "Retorno Prisão domiciliar - Covid-19", "Retorno Transferência" }));
        jComboBoxTipoRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPesDtRetInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPesDtRetFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPesDtRetFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jPesDtRetInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTipoRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addGap(6, 6, 6))
        );

        setBounds(330, 30, 423, 144);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jPesDtRetInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data inicial não pode ser em branco.");
                jPesDtRetInicial.requestFocus();
            } else if (jPesDtRetFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data final não pode ser em branco.");
                jPesDtRetFinal.requestFocus();
            } else if (jPesDtRetInicial.getDate().after(jPesDtRetFinal.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final.");
            } else if (jComboBoxTipoRetorno.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de retorno.");
            } else {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                pDATA_inicial = formatoAmerica.format(jPesDtRetInicial.getDate().getTime());
                pDATA_final = formatoAmerica.format(jPesDtRetFinal.getDate().getTime());
                try {
                    conecta.abrirConexao();
                    String path = "reports/PortariaInterna/RelatorioRetornoInternosPortaria.jasper";
                    conecta.executaSQL("SELECT ITENSREGISTRO.IdInternoCrc, "
                            + "PRONTUARIOSCRC.NomeInternoCrc, "
                            + "ITENSREGISTRO.DataRetorno, "
                            + "ITENSREGISTRO.HorarioRetorno, "
                            + "ITENSREGISTRO.OrigemRetorno, "
                            + "PAVILHAO.DescricaoPav, "
                            + "CELAS.EndCelaPav "
                            + "FROM ITENSREGISTRO   "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN ITENSLOCACAOINTERNO "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                            + "INNER JOIN CELAS "
                            + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                            + "INNER JOIN PAVILHAO "
                            + "ON CELAS.IdPav=PAVILHAO.IdPav "
                            + "WHERE CONVERT(DATE, DataRetorno,103) BETWEEN'" + pDATA_inicial + "' "
                            + "AND '" + pDATA_final + "' "
                            + "AND OrigemRetorno='" + jComboBoxTipoRetorno.getSelectedItem() + "' "
                            + "ORDER BY ITENSREGISTRO.DataRetorno,PRONTUARIOSCRC.NomeInternoCrc");
                    HashMap parametros = new HashMap();
                    parametros.put("dataInicial", pDATA_inicial);
                    parametros.put("dataFinal", pDATA_final);
                    parametros.put("pUNIDADE_penal", descricaoUnidade);
                    parametros.put("pUSUARIO_logado", nameUser);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Retorno de Internos na Unidade");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação                  
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jPesDtRetInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data inicial não pode ser em branco.");
                jPesDtRetInicial.requestFocus();
            } else if (jPesDtRetFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data final não pode ser em branco.");
                jPesDtRetFinal.requestFocus();
            } else if (jPesDtRetInicial.getDate().after(jPesDtRetFinal.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final.");
            } else if (jComboBoxTipoRetorno.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de retorno.");
            } else {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                pDATA_inicial = formatoAmerica.format(jPesDtRetInicial.getDate().getTime());
                pDATA_final = formatoAmerica.format(jPesDtRetFinal.getDate().getTime());
                try {
                    conecta.abrirConexao();
                    String path = "reports/PortariaInterna/RelatorioRetornoInternosPortaria.jasper";
                    conecta.executaSQL("SELECT ITENSREGISTRO.IdInternoCrc, "
                            + "PRONTUARIOSCRC.NomeInternoCrc, "
                            + "ITENSREGISTRO.DataRetorno, "
                            + "ITENSREGISTRO.HorarioRetorno, "
                            + "ITENSREGISTRO.OrigemRetorno, "
                            + "PAVILHAO.DescricaoPav, "
                            + "CELAS.EndCelaPav "
                            + "FROM ITENSREGISTRO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN ITENSLOCACAOINTERNO "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                            + "INNER JOIN CELAS "
                            + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                            + "INNER JOIN PAVILHAO "
                            + "ON CELAS.IdPav=PAVILHAO.IdPav "
                            + "WHERE CONVERT(DATE, DataRetorno,103) BETWEEN'" + pDATA_inicial + "' "
                            + "AND '" + pDATA_final + "' "
                            + "AND OrigemRetorno='" + jComboBoxTipoRetorno.getSelectedItem() + "' "
                            + "ORDER BY ITENSREGISTRO.DataRetorno,PRONTUARIOSCRC.NomeInternoCrc");
                    HashMap parametros = new HashMap();
                    parametros.put("dataInicial", pDATA_inicial);
                    parametros.put("dataFinal", pDATA_final);
                    parametros.put("pUNIDADE_penal", descricaoUnidade);
                    parametros.put("pUSUARIO_logado", nameUser);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Retorno de Internos na Unidade");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
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
    private javax.swing.JComboBox<String> jComboBoxTipoRetorno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jPesDtRetFinal;
    private com.toedter.calendar.JDateChooser jPesDtRetInicial;
    // End of variables declaration//GEN-END:variables
}