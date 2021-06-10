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
 * @author ronaldo.silva7
 */
public class TelaRelatorioInternosRegime extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    String pSITUACAO_entrada = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String pSITUACAO_retorno = "RETORNO A UNIDADE"; // Todos os Retornos
    String pSITUACAO_transferencia = "TRANSFERENCIA"; // Todas as Transferencias
    String situacaoNull = ""; // Cadastrado mas não foi feito entrada
    String pSITUACAO_SAIDA_temporaria = "SAIDA TEMPORARIA";
    String pPRISAO_DOMICILIAR = "PRISAO DOMICILIAR";

    /**
     * Creates new form TelaRelatorioInternosRegime
     */
    public TelaRelatorioInternosRegime() {
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jBtConfimar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfimar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtConfimar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfimar, jBtSair});

        setBounds(300, 60, 456, 145);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfimarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxRegime.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário antes escolher um reegime para pesquisar.");
        } else {
            final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
            carregando.setVisible(true);//Teste tela aguarde
            Thread t = new Thread() { //Teste tela aguarde
                public void run() { //Teste
                    // Remodelar esse relatório com o regime e sexo dos internos. (Feito em 26/11/2014)
                    try {
                        conecta.abrirConexao();
                        String path = "reports/CRC/ListagemInternosPorRegimePenal.jasper";
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
                                + "WHERE p.SituacaoCrc='" + pSITUACAO_entrada + "' "
                                + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                + "OR SituacaoCrc='" + pSITUACAO_retorno + "' "
                                + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                + "OR SituacaoCrc LIKE'%" + pPRISAO_DOMICILIAR + "%' "
                                + "AND d.Regime='" + jComboBoxRegime.getSelectedItem() + "' "
                                + "ORDER BY p.NomeInternoCrc");
                        HashMap parametros = new HashMap();
                        parametros.put("Entrada", pSITUACAO_entrada);
                        parametros.put("Retorno", pSITUACAO_retorno);
                        parametros.put("covid", pPRISAO_DOMICILIAR);
                        parametros.put("nomeUsuario", nameUser);
                        parametros.put("descricaoUnidade", descricaoUnidade);
                        parametros.put("regimePenal", jComboBoxRegime.getSelectedItem());
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("Listagem de Internos Por Regime Penal");
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
    }//GEN-LAST:event_jBtConfimarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfimar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxRegime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}