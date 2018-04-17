/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.DepositoInterno;
import gestor.Modelo.SaqueValores;
import static gestor.Visao.TelaConsultaSaldoFin.jTabelaDeposito;
import static gestor.Visao.TelaConsultaSaldoFin.jTabelaSaque;
import static gestor.Visao.TelaConsultaSaldoFin.jlTotalCredito;
import static gestor.Visao.TelaConsultaSaldoFin.jlTotalDebito;
import static gestor.Visao.TelaLoginSenha.nameUser;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronaldo
 */
public class TelaPesqDataRelExtrato extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DepositoInterno objDeposito = new DepositoInterno();
    SaqueValores objSaque = new SaqueValores();
    String dataInicial, dataFinal;
    String dataSaq, dataLanc;
    double valorTotalCredito = 0; // Total dos Créditos
    double valorTotalDebito = 0; // Total dos débitos
    float saldoAtualCredito = 0;
    float saldoAtualDebito = 0;
    float saldoGeral = 0;
    double valorDeposito = 0;
    double valorSaque = 0;
    //
    double valorTotal = 0; // Total geral
    double valorCredito = 0; // Calcular os créditos
    double valorDebito = 0; // Calcular os débitos
    String campoCredito = "C";
    String campoDebito = "D";
    //
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";

    /**
     * Creates new form TelaPesqDataExtrato
     */
    public TelaPesqDataRelExtrato() {
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
        jPanel2 = new javax.swing.JPanel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtConfirmar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("...::: Pesquisa por Data {FIN} :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Final");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
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

        jBtCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtCancelar.setForeground(new java.awt.Color(255, 0, 0));
        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(450, 100, 284, 171);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:   

        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else {
            if (jDataPesFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesFinal.requestFocus();
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                    conecta.abrirConexao();
                    try {
                        String path = "reports/ExtratoValoresGeralInternos.jasper";
                        conecta.executaSQL("SELECT * FROM SALDOVALORES "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON SALDOVALORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEnt + "' "
                                + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "' "
                                + "AND DataMov BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "ORDER BY NomeInternoCrc,DataMov");
                        HashMap parametros = new HashMap();
                        parametros.put("dataInicial", dataInicial);
                        parametros.put("dataFinal", dataFinal);
                        parametros.put("pEntrada", situacaoEnt);
                        parametros.put("pRetorno", situacaoRet);
                        parametros.put("usuario", nameUser);
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("Extrato Geral de Valores de Interno");
                        jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                        jv.toFront(); // Traz o relatorio para frente da aplicação            
                        conecta.desconecta();
                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                    }
                }
            }
        }
        //  dispose();
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtConfirmar;
    public static com.toedter.calendar.JDateChooser jDataPesFinal;
    public static com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
 public void preencherTabelaDeposito(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"   Data", " Nr. Doc", "                Histórico", "   Valor R$", "                Depositante"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                saldoAtualCredito = conecta.rs.getFloat("ValorDeposito");
                valorTotalCredito = valorTotalCredito + saldoAtualCredito;
                //Formatar o valor para ser exibdo na tela BR
                DecimalFormat df = new DecimalFormat(",###.00");
                jlTotalCredito.setText(df.format(valorTotalCredito));
                // Mostrar o valor na telada tabela no formato BR
                valorDeposito = conecta.rs.getFloat("ValorDeposito");
                DecimalFormat vd = new DecimalFormat(",###.00");
                String vlDeposito = vd.format(valorDeposito);
                // Formatar a data Deposito
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{dataLanc, conecta.rs.getString("IdLanc"), conecta.rs.getString("Observacao"), vlDeposito, conecta.rs.getString("Depositante")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDeposito.setModel(modelo);
        jTabelaDeposito.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaDeposito.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDeposito.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaDeposito.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDeposito.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaDeposito.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDeposito.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaDeposito.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDeposito.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaDeposito.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDeposito.getTableHeader().setReorderingAllowed(false);
        jTabelaDeposito.setAutoResizeMode(jTabelaDeposito.AUTO_RESIZE_OFF);
        jTabelaDeposito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void preencherTabelaSaque(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"   Data", " Nr. Doc", "                Histórico", "   Valor R$", "                Favorecido"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                saldoAtualDebito = conecta.rs.getFloat("ValorSaque");
                valorTotalDebito = valorTotalDebito + saldoAtualDebito;
                // Formatar o valor para ser exibdo na tela BR
                DecimalFormat df = new DecimalFormat(",###.00");
                jlTotalDebito.setText(df.format(valorTotalDebito));
                // Mostrar o valor na tabels no formato BR
                valorSaque = conecta.rs.getFloat("ValorSaque");
                DecimalFormat vs = new DecimalFormat(",###.00");
                String vlsaque = vs.format(valorSaque);
                // Formatar a data Deposito
                dataSaq = conecta.rs.getString("DataLanc");
                String dia = dataSaq.substring(8, 10);
                String mes = dataSaq.substring(5, 7);
                String ano = dataSaq.substring(0, 4);
                dataSaq = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{dataLanc, conecta.rs.getString("IdSaq"), conecta.rs.getString("Observacao"), vlsaque, conecta.rs.getString("Favorecido")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaque.setModel(modelo);
        jTabelaSaque.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaSaque.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaque.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaSaque.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaque.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaSaque.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaque.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaSaque.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaque.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaSaque.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSaque.getTableHeader().setReorderingAllowed(false);
        jTabelaSaque.setAutoResizeMode(jTabelaDeposito.AUTO_RESIZE_OFF);
        jTabelaSaque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void calcularCreditDebito() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALDOVALORES WHERE  StatusMov='" + campoCredito + "'");
            conecta.rs.first();
            do {
                valorCredito = conecta.rs.getFloat("ValorMov");
                valorTotalCredito = valorTotalCredito + valorCredito;
            } while (conecta.rs.next());
            conecta.desconecta();
        } catch (SQLException ex) {
        }
        conecta.abrirConexao();
        //Verifica o DÉBITO do interno para deduzir do debito. Se o valor for zero permite sair
        try {
            conecta.executaSQL("SELECT * FROM SALDOVALORES WHERE StatusMov='" + campoDebito + "'");
            conecta.rs.first();
            do {
                valorDebito = conecta.rs.getFloat("ValorMov");
                valorTotalDebito = valorTotalDebito + valorDebito;
            } while (conecta.rs.next());
            valorTotal = valorTotalCredito - valorTotalDebito;
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }
}
