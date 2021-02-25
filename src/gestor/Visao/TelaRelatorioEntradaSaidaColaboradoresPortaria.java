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
public class TelaRelatorioEntradaSaidaColaboradoresPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    String dataInicial, dataFinal;
    int codigoDepto;

    /**
     * Creates new form TelaRelMapaConfere
     */
    public TelaRelatorioEntradaSaidaColaboradoresPortaria() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPesDtPopInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPesDtPopFinal = new com.toedter.calendar.JDateChooser();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Relatório Entrada/Saída Colaboradores  :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jPesDtPopFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesDtPopInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
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
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(550, 150, 410, 172);
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
                        final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                        carregando.setVisible(true);//Teste tela aguarde
                        Thread t = new Thread() { //Teste tela aguarde
                            public void run() { //Teste
                                try {
                                    conecta.abrirConexao();
                                    String path = "reports/GerenciaAdministrativa/RelatorioEntradaSaidaColaboradores.jasper";
                                    conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                                            + "INNER JOIN COLABORADOR "
                                            + "ON DEPARTAMENTOS.IdDepartamento=COLABORADOR.IdDepartamento "
                                            + "INNER JOIN ITENSENTRADASFUNC "
                                            + "ON COLABORADOR.IdFunc=ITENSENTRADASFUNC.IdFunc "
                                            + "WHERE DataEntrada>='" + dataInicial + "' "
                                            + "AND DataEntrada<='" + dataFinal + "' "
                                            + "ORDER BY DEPARTAMENTOS.IdDepartamento,ITENSENTRADASFUNC.DataEntrada");
                                    HashMap parametros = new HashMap();
                                    parametros.put("dataInicial", dataInicial);
                                    parametros.put("dataFinal", dataFinal);
                                    parametros.put("nomeUsuario", nameUser);
                                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                                    jv.setTitle("Relatório de Colaboradores (Frequência)");
                                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                                    carregando.dispose(); //Teste tela aguarde
                                    conecta.desconecta();
                                } catch (JRException e) {
                                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                                }
                            }
                        }; //Teste tela aguarde
                        t.start(); //Teste tela aguarde
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
                        final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                        carregando.setVisible(true);//Teste tela aguarde
                        Thread t = new Thread() { //Teste tela aguarde
                            public void run() { //Teste
                                try {
                                    conecta.abrirConexao();
                                    String path = "reports/GerenciaAdministrativa/RelatorioEntradaSaidaColaboradores.jasper";
                                    conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                                            + "INNER JOIN COLABORADOR "
                                            + "ON DEPARTAMENTOS.IdDepartamento=COLABORADOR.IdDepartamento "
                                            + "INNER JOIN ITENSENTRADASFUNC "
                                            + "ON COLABORADOR.IdFunc=ITENSENTRADASFUNC.IdFunc "
                                            + "WHERE DataEntrada>='" + dataInicial + "' "
                                            + "AND DataEntrada<='" + dataFinal + "' "
                                            + "ORDER BY DEPARTAMENTOS.IdDepartamento,ITENSENTRADASFUNC.DataEntrada");

                                    HashMap parametros = new HashMap();
                                    parametros.put("dataInicial", dataInicial);
                                    parametros.put("dataFinal", dataFinal);
                                    parametros.put("nomeUsuario", nameUser);
                                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                                    jv.setTitle("Relatório de Atividade Laborativa Externa (Frequência)");
                                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                                    jv.toFront(); // Traz o relatorio para frente da aplicação 
                                    carregando.dispose(); //Teste tela aguarde
                                    conecta.desconecta();
                                } catch (JRException e) {
                                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                                }
                            }
                        }; //Teste tela aguarde
                        t.start(); //Teste tela aguarde
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jPesDtPopFinal;
    private com.toedter.calendar.JDateChooser jPesDtPopInicial;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
