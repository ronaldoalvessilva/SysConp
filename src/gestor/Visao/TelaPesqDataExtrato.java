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
import static gestor.Visao.TelaConsultaSaldoFin.jIdInternoFinDir;
import static gestor.Visao.TelaConsultaSaldoFin.jTabelaDeposito;
import static gestor.Visao.TelaConsultaSaldoFin.jTabelaSaque;
import static gestor.Visao.TelaConsultaSaldoFin.jTabelaTransferencia;
import static gestor.Visao.TelaConsultaSaldoFin.jlSaldoAtual;
import static gestor.Visao.TelaConsultaSaldoFin.jlTotalCredito;
import static gestor.Visao.TelaConsultaSaldoFin.jlTotalDebito;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaPesqDataExtrato extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DepositoInterno objDeposito = new DepositoInterno();
    SaqueValores objSaque = new SaqueValores();
    String dataInicial, dataFinal;
    String dataSaq, dataLanc;
    float valorTotalCredito = 0;
    float valorTotalDebito = 0;
    float saldoAtualCredito = 0;
    float saldoAtualDebito = 0;
    float saldoGeral = 0;
    double valorDeposito = 0;
    double valorSaque = 0;
    double valorTrans = 0;

    /**
     * Creates new form TelaPesqDataExtrato
     */
    public TelaPesqDataExtrato() {
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
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(450, 100, 284, 171);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:   
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        jTabelaDeposito.setEnabled(!true);
                        jTabelaSaque.setEnabled(!true);
                        preencherTabelaDeposito("SELECT * FROM DEPOSITO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON DEPOSITO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DEPOSITO.IdInternoCrc='" + jIdInternoFinDir.getText() + "' "
                                + "AND DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                        preencherTabelaSaque("SELECT * FROM SAQUE "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON SAQUE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE SAQUE.IdInternoCrc='" + jIdInternoFinDir.getText() + "' "
                                + "AND DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                        saldoGeral = valorTotalCredito - valorTotalDebito;
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        jlSaldoAtual.setText(df.format(saldoGeral));
                        preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_VALORES_INATIVOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON TRANSFERENCIA_VALORES_INATIVOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE TRANSFERENCIA_VALORES_INATIVOS.IdInternoCrc='" + jIdInternoFinDir.getText() + "'");
                        saldoGeral = valorTotalCredito - valorTotalDebito;
                        DecimalFormat df1 = new DecimalFormat("#,##0.00");
                        jlSaldoAtual.setText(df1.format(saldoGeral));
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                        jTabelaDeposito.setEnabled(!true);
                        jTabelaSaque.setEnabled(!true);
                        preencherTabelaDeposito("SELECT * FROM DEPOSITO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON DEPOSITO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DEPOSITO.IdInternoCrc='" + jIdInternoFinDir.getText() + "' "
                                + "AND DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                        preencherTabelaSaque("SELECT * FROM SAQUE "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON SAQUE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE SAQUE.IdInternoCrc='" + jIdInternoFinDir.getText() + "' "
                                + "AND DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                        saldoGeral = valorTotalCredito - valorTotalDebito;
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        jlSaldoAtual.setText(df.format(saldoGeral));
                        preencherTabelaTransferencia("SELECT * FROM TRANSFERENCIA_VALORES_INATIVOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON TRANSFERENCIA_VALORES_INATIVOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE TRANSFERENCIA_VALORES_INATIVOS.IdInternoCrc='" + jIdInternoFinDir.getText() + "'");
                        saldoGeral = valorTotalCredito - valorTotalDebito;
                        DecimalFormat df1 = new DecimalFormat("#,##0.00");
                        jlSaldoAtual.setText(df1.format(saldoGeral));
                    }
                }
            }
        }
        dispose();
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
        String[] Colunas = new String[]{"Data", "Nr. Doc", "Histórico", "Valor R$", "Depositante"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                saldoAtualCredito = conecta.rs.getFloat("ValorDeposito");
                valorTotalCredito = valorTotalCredito + saldoAtualCredito;
                //Formatar o valor para ser exibdo na tela BR
                DecimalFormat df = new DecimalFormat("#,##0.00");
                jlTotalCredito.setText(df.format(valorTotalCredito));
                // Mostrar o valor na telada tabela no formato BR
                valorDeposito = conecta.rs.getFloat("ValorDeposito");
                DecimalFormat vd = new DecimalFormat("#,##0.00");
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
        alinharCamposTabelaDeposito();
        conecta.desconecta();
    }

    public void preencherTabelaSaque(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data", "Nr. Doc", "Histórico", "Valor R$", "Favorecido"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                saldoAtualDebito = conecta.rs.getFloat("ValorSaque");
                valorTotalDebito = valorTotalDebito + saldoAtualDebito;
                // Formatar o valor para ser exibdo na tela BR
                DecimalFormat df = new DecimalFormat("#,##0.00");
                jlTotalDebito.setText(df.format(valorTotalDebito));
                // Mostrar o valor na tabels no formato BR
                valorSaque = conecta.rs.getFloat("ValorSaque");
                DecimalFormat vs = new DecimalFormat("#,##0.00");
                String vlsaque = vs.format(valorSaque);
                // Formatar a data Deposito
                dataSaq = conecta.rs.getString("DataLanc");
                String diad = dataSaq.substring(8, 10);
                String mesd = dataSaq.substring(5, 7);
                String anod = dataSaq.substring(0, 4);
                dataSaq = diad + "/" + mesd + "/" + anod;
                dados.add(new Object[]{dataSaq, conecta.rs.getString("IdSaq"), conecta.rs.getString("Observacao"), vlsaque, conecta.rs.getString("Favorecido")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {

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
        alinharCamposTabelaSaque();
        conecta.desconecta();
    }

    public void alinharCamposTabelaSaque() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaSaque.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaSaque.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaSaque.getColumnModel().getColumn(3).setCellRenderer(direita);
    }

    public void alinharCamposTabelaDeposito() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaDeposito.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaDeposito.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaDeposito.getColumnModel().getColumn(3).setCellRenderer(direita);
    }

    public void preencherTabelaTransferencia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data", "Nr. Doc", "Histórico", "Valor R$", "Favorecido"};
        conecta.abrirConexao();
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                // Mostrar o valor na tabels no formato BR
                valorTrans = conecta.rs.getFloat("ValorTransferido");
                DecimalFormat vst = new DecimalFormat("#,##0.00");
                String vlTrans = vst.format(valorTrans);
                // Formatar a data Deposito
                dataSaq = conecta.rs.getString("DataLanc");
                String diad = dataSaq.substring(8, 10);
                String mesd = dataSaq.substring(5, 7);
                String anod = dataSaq.substring(0, 4);
                dataSaq = diad + "/" + mesd + "/" + anod;
                dados.add(new Object[]{dataSaq, conecta.rs.getString("IdLanc"), conecta.rs.getString("Motivo"), vlTrans, conecta.rs.getString("TipoTransferencia")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTransferencia.setModel(modelo);
        jTabelaTransferencia.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaTransferencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTransferencia.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaTransferencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTransferencia.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaTransferencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTransferencia.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaTransferencia.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTransferencia.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaTransferencia.getColumnModel().getColumn(4).setResizable(false);
        jTabelaTransferencia.getTableHeader().setReorderingAllowed(false);
        jTabelaTransferencia.setAutoResizeMode(jTabelaTransferencia.AUTO_RESIZE_OFF);
        jTabelaTransferencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaTran();
        conecta.desconecta();
    }

    public void alinharCamposTabelaTran() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaTransferencia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaTransferencia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaTransferencia.getColumnModel().getColumn(3).setCellRenderer(direita);
    }
}
