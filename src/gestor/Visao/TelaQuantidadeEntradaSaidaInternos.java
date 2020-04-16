/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.LimiteDigitosSoNum;
import gestor.Controle.ControleEntradasSaidasPopulacaoInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ListagemRegistroEntradaSaidaPopulcao;
import gestor.Controle.ListagemUltimaPopulacaoCRC;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.acao;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jDataLanc;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jObservacao;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtAlterarInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtAuditoria;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtAuditoriaInternos;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtCancelarInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtExcluir;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtExcluirInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtFinalizar;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtNovoInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jBtSalvarInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jComboBoxOrigemInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jDataChegada;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jHorario;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jIdInterno;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jIdLanc;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jNomeInternoPortaria;
import static gestor.Visao.TelaEntradaUnidadeInternoPortaria.jOficio;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaQuantidadeEntradaSaidaInternos extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //ADICIONAR A POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULACAO_INTERNOS (CONTROLE ALIMENTAÇÃO)
    ControleEntradasSaidasPopulacaoInternos populacao = new ControleEntradasSaidasPopulacaoInternos();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    ListagemUltimaPopulacaoCRC listaUltimaPopulacao = new ListagemUltimaPopulacaoCRC();
    ListagemRegistroEntradaSaidaPopulcao listaRegistroES = new ListagemRegistroEntradaSaidaPopulcao();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela = "Portaria:Entrada de Internos Unidade:Quantidade Entradada de Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    String pTIPO_OPERCAO_ENTRADA = "Entrada na Unidade";
    int opcao = 0;
    public static String pREGISTRO_ENTRADA = "";
    int pPOPULCAO_ATUAL = 0;

    /**
     * Creates new form TelaQuantidadeEntradaSaidaInternos
     */
    public static TelaEntradaUnidadeInternoPortaria pENTRADA_PORTARIA_PV;

    public TelaQuantidadeEntradaSaidaInternos(TelaEntradaUnidadeInternoPortaria parent, boolean modal) {
        this.pENTRADA_PORTARIA_PV = parent;
        this.setModal(modal);
        setLocationRelativeTo(pENTRADA_PORTARIA_PV);
        initComponents();
        corCampos();
        formatarCampos();
        pesquisarRegistro();
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
        jLabel3 = new javax.swing.JLabel();
        jDataMovimento = new com.toedter.calendar.JDateChooser();
        jHorarioMovimento = new javax.swing.JFormattedTextField();
        jQuantidadeMovimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jDocumento = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Quantidade Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Horário");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Quantidade");

        jDataMovimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataMovimento.setEnabled(false);

        jHorarioMovimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioMovimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioMovimento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHorarioMovimento.setEnabled(false);

        jQuantidadeMovimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidadeMovimento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidadeMovimento.setText("0");
        jQuantidadeMovimento.setCaretColor(new java.awt.Color(204, 0, 0));
        jQuantidadeMovimento.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jQuantidadeMovimento.setEnabled(false);
        jQuantidadeMovimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Documento");

        jDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDocumento.setEnabled(false);
        jDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jQuantidadeMovimento)
                    .addComponent(jDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDataMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jHorarioMovimento)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataMovimento, jDocumento, jHorarioMovimento, jQuantidadeMovimento});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQuantidadeMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtNovo, jBtSair, jBtSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtNovo)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelar))
                .addGap(5, 5, 5))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        opcao = 1;
        Novo();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        opcao = 2;
        Alterar();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jDataMovimento.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data do lançamento.");
        } else if (jHorarioMovimento.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o horário do lançamento.");
        } else if (jQuantidadeMovimento.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a quandidade de internos entrando na unidade.");
        } else if (jQuantidadeMovimento.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "Quandidade de internos informada não pode ser zero.");
        } else if (jQuantidadeMovimento.getText().equals("00")) {
            JOptionPane.showMessageDialog(rootPane, "Quandidade de internos informada não pode ser zero.");
        } else if (jQuantidadeMovimento.getText().equals("000")) {
            JOptionPane.showMessageDialog(rootPane, "Quandidade de internos informada não pode ser zero.");
        } else if (jQuantidadeMovimento.getText().equals("0000")) {
            JOptionPane.showMessageDialog(rootPane, "Quandidade de internos informada não pode ser zero.");
        } else {
            //ADICIONAR POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULCAO_INTERNOS
            objEntradaSaida.setIdDocumento(Integer.valueOf(jIdLanc.getText()));
            objEntradaSaida.setDataMovimento(jDataMovimento.getDate());
            objEntradaSaida.setHorarioMovimento(jHorarioMovimento.getText());
            objEntradaSaida.setQuantidade(Integer.valueOf(jQuantidadeMovimento.getText()));
            objEntradaSaida.setTipoOperacao(pTIPO_OPERCAO_ENTRADA);
            if (opcao == 1) {
                objEntradaSaida.setUsuarioInsert(nameUser);
                objEntradaSaida.setDataInsert(jDataSistema.getText());
                objEntradaSaida.setHorarioInsert(horaMov);
                //PEGAR ULTIMA POPUÇÃO PARA EFETUAR CALCULO ANTES DE GRAVAR
                listaUltimaPopulacao.selecionarPopulacao(objEntradaSaida);
                pPOPULCAO_ATUAL = objEntradaSaida.getPopulacao() + Integer.parseInt(jQuantidadeMovimento.getText());
                objEntradaSaida.setPopulacao(pPOPULCAO_ATUAL);
                populacao.incluirEntradaSaidaPortaria(objEntradaSaida);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                NovoInterno();
            }
            if (opcao == 2) {
                objEntradaSaida.setUsuarioUp(nameUser);
                objEntradaSaida.setDataUp(jDataSistema.getText());
                objEntradaSaida.setHorarioUp(horaMov);
                objEntradaSaida.setIdDocumento(Integer.valueOf(jIdLanc.getText()));
                populacao.alterarEntradaSaidaPortaria(objEntradaSaida);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaQuantidadeEntradaSaidaInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaQuantidadeEntradaSaidaInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaQuantidadeEntradaSaidaInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaQuantidadeEntradaSaidaInternos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaQuantidadeEntradaSaidaInternos dialog = new TelaQuantidadeEntradaSaidaInternos(pENTRADA_PORTARIA_PV, true);
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
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private com.toedter.calendar.JDateChooser jDataMovimento;
    private javax.swing.JFormattedTextField jDocumento;
    private javax.swing.JFormattedTextField jHorarioMovimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField jQuantidadeMovimento;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jDocumento.setBackground(Color.white);
        jDataMovimento.setBackground(Color.white);
        jHorarioMovimento.setBackground(Color.white);
        jQuantidadeMovimento.setBackground(Color.white);
    }

    public void formatarCampos() {
        jQuantidadeMovimento.setDocument(new LimiteDigitosSoNum(4));
    }

    public void pesquisarRegistro() {
        listaRegistroES.selecionarRegistroEntrada(objEntradaSaida);
        if (objEntradaSaida.getIdDocumento() == Integer.parseInt(jIdLanc.getText())) {
            jDocumento.setText(String.valueOf(objEntradaSaida.getIdDocumento()));
            jDataMovimento.setDate(objEntradaSaida.getDataMovimento());
            jHorarioMovimento.setText(objEntradaSaida.getHorarioMovimento());
            jQuantidadeMovimento.setText(String.valueOf(objEntradaSaida.getQuantidade()));
            //
            jQuantidadeMovimento.setEnabled(!true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            NovoInterno();
        }
    }

    public void NovoInterno() {
        if (acao == 3 || acao == 4) {
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jIdInterno.setText("");
            jNomeInternoPortaria.setText("");
            jDataChegada.setCalendar(Calendar.getInstance());
            jHorario.setText("");
            jOficio.setText("");
            jComboBoxOrigemInterno.setSelectedItem(null);
            //
            jNomeInternoPortaria.setEnabled(true);
            jDataChegada.setEnabled(true);
            jHorario.setEnabled(true);
            jOficio.setEnabled(true);
            jComboBoxOrigemInterno.setEnabled(true);
            //Habilitar/Desabilitar botões
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            // Habilitar/Desabilitar botoes internos
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInternos.setEnabled(!true);
            preencherComboNovo();
        }
    }

    public void preencherComboNovo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE ORDER BY DescricaoUnid");
            conecta.rs.first();
            do {
                jComboBoxOrigemInterno.addItem(conecta.rs.getString("DescricaoUnid"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void Novo() {
        jDocumento.setText(jIdLanc.getText());
        jDataMovimento.setCalendar(Calendar.getInstance());
        jHorarioMovimento.setText(jHoraSistema.getText());
        //
        jQuantidadeMovimento.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jQuantidadeMovimento.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Salvar() {
        jQuantidadeMovimento.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Cancelar() {
        jQuantidadeMovimento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
