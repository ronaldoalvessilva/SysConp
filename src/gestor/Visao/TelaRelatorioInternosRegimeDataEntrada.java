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
public class TelaRelatorioInternosRegimeDataEntrada extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    String pSITUACAO_entrada = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String pSITUACAO_retorno = "RETORNO A UNIDADE"; // Todos os Retornos
    String pSITUACAO_transferencia = "TRANSFERENCIA"; // Todas as Transferencias
    String situacaoNull = ""; // Cadastrado mas não foi feito entrada
    String pSITUACAO_SAIDA_temporaria = "SAIDA TEMPORARIA";
    String pPRISAO_DOMICILIAR = "PRISAO DOMICILIAR";
    //
    String pDATA_inicial = "";
    String pDATA_final = "";

    /**
     * Creates new form TelaRelatorioInternosRegime
     */
    public TelaRelatorioInternosRegimeDataEntrada() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxRegime = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtConfimar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Relatorio de Internos Por Regime :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Selecione o Regime");

        jComboBoxRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Aberto", "Fechado", "Provisório", "Semi-Aberto" }));
        jComboBoxRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Inicial");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Final");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxRegime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jBtConfimar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfimar.setText("Confirmar");
        jBtConfimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfimarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
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
                .addGap(58, 58, 58)
                .addComponent(jBtConfimar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfimar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtConfimar)
                    .addComponent(jBtSair))
                .addGap(6, 6, 6))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfimar, jBtSair});

        setBounds(300, 60, 354, 187);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfimarActionPerformed
        // TODO add your handling code here:
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jComboBoxRegime.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário antes escolher um reegime para pesquisar.");
            } else if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else if (jDataPesFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesFinal.requestFocus();
            } else if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
            } else {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                pDATA_inicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                pDATA_final = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                carregando.setVisible(true);//Teste tela aguarde
                Thread t = new Thread() { //Teste tela aguarde
                    public void run() { //Teste
                        // Remodelar esse relatório com o regime e sexo dos internos. (Feito em 26/11/2014)
                        try {
                            conecta.abrirConexao();
                            String path = "reports/CRC/ListagemInternosPorRegimePenalData.jasper";
                            conecta.executaSQL("SELECT "
                                    + "p.IdInternoCrc, "
                                    + "p.NomeInternoCrc, "
                                    + "p.MatriculaCrc, "
                                    + "p.SituacaoCrc, "
                                    + "p.SexoCrc, "
                                    + "d.Regime, "
                                    + "d.DataEntrada "
                                    + "FROM PRONTUARIOSCRC AS p "
                                    + "INNER JOIN DADOSPENAISINTERNOS AS d "
                                    + "ON p.IdInternoCrc=d.IdInternoCrc "
                                    + "WHERE CONVERT(DATE, d.DataEntrada) BETWEEN'" + pDATA_inicial + "' "
                                    + "AND'" + pDATA_final + "' "
                                    + "AND p.SituacaoCrc='" + pSITUACAO_entrada + "' "
                                    + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                    + "OR CONVERT(DATE, d.DataEntrada) BETWEEN'" + pDATA_inicial + "' "
                                    + "AND'" + pDATA_final + "' "
                                    + "AND SituacaoCrc='" + pSITUACAO_retorno + "' "
                                    + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                    + "OR CONVERT(DATE, d.DataEntrada) BETWEEN'" + pDATA_inicial + "' "
                                    + "AND'" + pDATA_final + "' "
                                    + "AND SituacaoCrc LIKE'%" + pPRISAO_DOMICILIAR + "%' "
                                    + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                    + "ORDER BY d.DataEntrada,p.NomeInternoCrc");
                            HashMap parametros = new HashMap();
                            parametros.put("Entrada", pSITUACAO_entrada);
                            parametros.put("Retorno", pSITUACAO_retorno);
                            parametros.put("covid", pPRISAO_DOMICILIAR);
                            parametros.put("nomeUsuario", nameUser);
                            parametros.put("descricaoUnidade", descricaoUnidade);
                            parametros.put("regimePenal", jComboBoxRegime.getSelectedItem());
                            parametros.put("dataInicial", pDATA_inicial);
                            parametros.put("dataFinal", pDATA_final);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Listagem de Internos Por Regime Penal e Data Entrada");
                            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                            jv.toFront(); // Traz o relatorio para frente da aplicação      
                            carregando.dispose(); //Teste tela aguarde
                            conecta.desconecta();
                        } catch (JRException e) {
                            carregando.dispose(); //Teste tela aguarde
                            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                        }
                    }
                }; //Teste tela aguarde
                t.start(); //Teste tela aguarde
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jComboBoxRegime.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário antes escolher um reegime para pesquisar.");
            } else if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else if (jDataPesFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesFinal.requestFocus();
            } else if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
            } else {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                pDATA_inicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                pDATA_final = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                carregando.setVisible(true);//Teste tela aguarde
                Thread t = new Thread() { //Teste tela aguarde
                    public void run() { //Teste
                        // Remodelar esse relatório com o regime e sexo dos internos. (Feito em 26/11/2014)
                        try {
                            conecta.abrirConexao();
                            String path = "reports/CRC/ListagemInternosPorRegimePenalData.jasper";
                            conecta.executaSQL("SELECT "
                                    + "p.IdInternoCrc, "
                                    + "p.NomeInternoCrc, "
                                    + "p.MatriculaCrc, "
                                    + "p.SituacaoCrc, "
                                    + "p.SexoCrc, "
                                    + "d.Regime, "
                                    + "d.DataEntrada "
                                    + "FROM PRONTUARIOSCRC AS p "
                                    + "INNER JOIN DADOSPENAISINTERNOS AS d "
                                    + "ON p.IdInternoCrc=d.IdInternoCrc "
                                    + "WHERE CONVERT(DATE, d.DataEntrada) BETWEEN'" + pDATA_inicial + "' "
                                    + "AND'" + pDATA_final + "' "
                                    + "AND p.SituacaoCrc='" + pSITUACAO_entrada + "' "
                                    + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                    + "OR CONVERT(DATE, d.DataEntrada) BETWEEN'" + pDATA_inicial + "' "
                                    + "AND'" + pDATA_final + "' "
                                    + "AND SituacaoCrc='" + pSITUACAO_retorno + "' "
                                    + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                    + "OR CONVERT(DATE, d.DataEntrada) BETWEEN'" + pDATA_inicial + "' "
                                    + "AND'" + pDATA_final + "' "
                                    + "AND SituacaoCrc LIKE'%" + pPRISAO_DOMICILIAR + "%' "
                                    + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                    + "ORDER BY d.DataEntrada,p.NomeInternoCrc");
                            HashMap parametros = new HashMap();
                            parametros.put("Entrada", pSITUACAO_entrada);
                            parametros.put("Retorno", pSITUACAO_retorno);
                            parametros.put("covid", pPRISAO_DOMICILIAR);
                            parametros.put("nomeUsuario", nameUser);
                            parametros.put("descricaoUnidade", descricaoUnidade);
                            parametros.put("regimePenal", jComboBoxRegime.getSelectedItem());
                            parametros.put("dataInicial", pDATA_inicial);
                            parametros.put("dataFinal", pDATA_final);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Listagem de Internos Por Regime Penal e Data Entrada");
                            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                            jv.toFront(); // Traz o relatorio para frente da aplicação      
                            carregando.dispose(); //Teste tela aguarde
                            conecta.desconecta();
                        } catch (JRException e) {
                            carregando.dispose(); //Teste tela aguarde
                            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                        }
                    }
                }; //Teste tela aguarde
                t.start(); //Teste tela aguarde
            }
        }
    }//GEN-LAST:event_jBtConfimarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfimar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxRegime;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
