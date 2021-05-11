/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ronaldo
 */
public class TelaRelatorioInternosFilhosIdade extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    int flag;
    int pIDADE_INICIAL = 0;
    int pIDADE_FINAL = 0;
    String pSITUACAO_entrada = "ENTRADA NA UNIDADE";
    String pSITUACAO_retorno = "RETORNO A UNIDADE";

    public TelaRelatorioInternosFilhosIdade() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIdadeInicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jIdadeFinal = new javax.swing.JTextField();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle("...::: Relatório por Idade :::...");

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Idade Inicial:");

        jIdadeInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Idade Final:");

        jIdadeFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdadeInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdadeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdadeFinal, jIdadeInicial});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jIdadeInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jIdadeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addGap(53, 53, 53))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jTabbedPane1.addTab("Pesquisa", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(450, 200, 356, 147);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed

        pIDADE_INICIAL = Integer.parseInt(jIdadeInicial.getText());
        pIDADE_FINAL = Integer.parseInt(jIdadeInicial.getText());
        if (jIdadeInicial.getText() == null || jIdadeInicial.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jIdadeInicial.requestFocus();
        } else if (jIdadeFinal.getText() == null || jIdadeFinal.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
            jIdadeFinal.requestFocus();
        } else if (pIDADE_INICIAL > pIDADE_FINAL) {
            JOptionPane.showMessageDialog(rootPane, "Idade Inicial não pode ser maior que a idade final");
        } else {
            final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
            carregando.setVisible(true);//Teste tela aguarde
            Thread t = new Thread() { //Teste tela aguarde
                public void run() { //Teste
                    try {
                        conecta.abrirConexao();
                        String path = "reports/ServicoSocial/RelatorioFilhosInternosMenosIdade.jasper";
                        conecta.executaSQL("SELECT "
                                + "p.IdInternoCrc, "
                                + "p.NomeInternoCrc, "
                                + "p.SituacaoCrc, "
                                + "v.IdVisita, "
                                + "v.NomeVisita, "
                                + "v.DataNasc, "
                                + "Floor(Datediff(DAY, CONVERT(DATE, v.DataNasc), Getdate()) / 365.25) AS Idade, "
                                + "v.SexoVisita, "
                                + "v.StatusVisita "
                                + "FROM VISITASINTERNO AS v "
                                + "INNER JOIN ITENSROL AS i "
                                + "ON v.IdVisita=i.IdVisita "
                                + "INNER JOIN PRONTUARIOSCRC AS p "
                                + "ON i.IdInternoCrc=p.IdInternoCrc "
                                + "WHERE  Floor(Datediff(DAY, CONVERT(DATE, v.DataNasc), Getdate()) / 365.25) BETWEEN' "
                                + jIdadeInicial.getText() + "' "
                                + "AND'" + jIdadeFinal.getText() + "' "
                                + "AND p.SituacaoCrc='" + pSITUACAO_entrada + "' "
                                + "OR Floor(Datediff(DAY, CONVERT(DATE, v.DataNasc), Getdate()) / 365.25) BETWEEN' "
                                + jIdadeInicial.getText() + "' "
                                + "AND'" + jIdadeFinal.getText() + "' "
                                + "AND p.SituacaoCrc='" + pSITUACAO_retorno + "' "
                                + "ORDER BY p.NomeInternoCrc");
                        HashMap parametros = new HashMap();
                        parametros.put("IDADE_INICIAL", jIdadeInicial.getText());
                        parametros.put("IDADE_FINAL", jIdadeFinal.getText());
                        parametros.put("pSITUACAO_entrada", pSITUACAO_entrada);
                        parametros.put("pSITUACAO_retorno", pSITUACAO_retorno);
                        parametros.put("descricaoUnidade", descricaoUnidade);
                        parametros.put("nomeUsuario", nameUser);
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("Relatório de Filhos de Internos Por Idade");
                        jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                        jv.toFront(); // Traz o relatorio para frente da aplicação            
                        conecta.desconecta();
                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                    }
                    carregando.dispose(); //Teste tela aguarde
                }
            }; //Teste tela aguarde
            t.start(); //Teste tela aguarde
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JTextField jIdadeFinal;
    private javax.swing.JTextField jIdadeInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
