/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEvadidosIndividual;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.EvadidoIndividual;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaAlertaEvadidosSaidaTemporario.jTabelaIntEvadidosSaidaTemporaria;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaEvadidosSaidaTemporaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvadidoIndividual objEvadidoInd = new EvadidoIndividual();
    ControleEvadidosIndividual control = new ControleEvadidosIndividual();
    ControleMovInternos controlMov = new ControleMovInternos();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleSituacao mod = new ControleSituacao();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:InternosEvadidos:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag;
    public static int acao;
    String dataInicial, dataFinal, dataLancaMov;
    String statusEva = "ABERTO";
    String evadidoInd = "EVADIDO";
    String situacao = "EVADIDO DA UNIDADE"; // Máximo 19 caracteres   
    String confirmaRetorno = "Não";
    //
    String NrDocRetorno = "";
    String NrDocRetornoNull = null;
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    String dataEntrada, dataSaida, dataSaidaTemp;
    String idRetorniInt;
    String dataRetorno, dataPrevRetorno;

    /**
     * Creates new form TelaEvadidosIndividual
     */
    public TelaEvadidosSaidaTemporaria() {
        initComponents();
        corCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtAuditoria = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jIdInternoEvadido = new javax.swing.JTextField();
        jNomeInternoEvadido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jNrDocumentoSaidaTmp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jOperacao = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Internos Evadidos  Saída Temporária :::...");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelar, jBtSair, jBtSalvar});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtCancelar))
                    .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelar, jBtSair, jBtSalvar});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Observação:");

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane2.setViewportView(jObservacao);

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoria.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jBtAuditoria.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(jBtAuditoria)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Código");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome do Interno");

        jIdInternoEvadido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoEvadido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoEvadido.setEnabled(false);

        jNomeInternoEvadido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvadido.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nr. Documento");

        jNrDocumentoSaidaTmp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrDocumentoSaidaTmp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrDocumentoSaidaTmp.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoEvadido)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jIdInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jNrDocumentoSaidaTmp))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNrDocumentoSaidaTmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Evasão:");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Operação:");

        jOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOperacao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jOperacao))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        setBounds(350, 80, 447, 379);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (jOperacao.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o tipo de operação.");
        } else {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                if (jNomeInternoEvadido.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
                } else {
                    objEvadidoInd.setStatusLanc(statusEva);
                    objEvadidoInd.setTipoOperacao(jOperacao.getText());
                    objEvadidoInd.setDataLanc(jDataLanc.getDate());
                    objEvadidoInd.setIdInternoCrc(Integer.valueOf(jIdInternoEvadido.getText()));
                    objEvadidoInd.setObservacao(jObservacao.getText());
                    objEvadidoInd.setUsuarioInsert(nameUser);
                    objEvadidoInd.setDataInsert(jDataSistema.getText());
                    objEvadidoInd.setHorarioInsert(jHoraSistema.getText());
                    if (acao == 1) {
                        control.incluirEvadidoInd(objEvadidoInd);
                        buscarId();
                        objEvadidoInd.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        controlMov.incluirMovEvasaoSaidaTmp(objEvadidoInd);
                        // ATUALIZA TABELA DE ITENS DE ITENS DE SAÍDA TEMPORÁRIA, QUANDO INTERNO ESTA EVADIDO.
                        // TABELA ITENSSAIDA
                        objItemSaida.setInternoEvadido(evadidoInd); // Quando interno EVADE
                        objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoEvadido.getText()));
                        objItemSaida.setDocumento(jNrDocumentoSaidaTmp.getText());
                        control.alterarEvasaoInternoSaidaTmp(objItemSaida);
                        // CONFIRMAR EVASÃO DO INTERNO NA TABELA MOVISR
                        objItemSaida.setDocumento(jNrDocumentoSaidaTmp.getText());
                        objItemSaida.setDataEvasao(jDataSistema.getText()); // Data da Evasão 
                        control.confirmaEvasaoInternoSaidaTmp(objItemSaida); // Confirmar a evasão do interno
                        // ALTERAR SITUAÇÃO DE INTERNO NO PRONTUÁRIO DO INTERNO
                        objProCrc.setIdInterno(Integer.parseInt(jIdInternoEvadido.getText()));
                        objProCrc.setSituacao(situacao);
                        mod.alterarSituacaoInterno(objProCrc);
                        Salvar();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
            preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM MOVISR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON MOVISR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NrDocRetorno='" + NrDocRetorno + "'AND DataPrevRetorno <'" + jDataSistema.getText() + "'AND DataEvasao='" + dataEvasao + "'");
            dispose();
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

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvadidosIndividual objAudEva = new TelaAuditoriaEvadidosIndividual();
        TelaModuloCRC.jPainelCRC.add(objAudEva);
        objAudEva.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    public static com.toedter.calendar.JDateChooser jDataLanc;
    public static javax.swing.JTextField jIdInternoEvadido;
    public static javax.swing.JTextField jIdLanc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField jNomeInternoEvadido;
    public static javax.swing.JTextField jNrDocumentoSaidaTmp;
    public static javax.swing.JTextArea jObservacao;
    public static javax.swing.JTextField jOperacao;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {

    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jOperacao.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        jIdInternoEvadido.setBackground(Color.white);
        jNrDocumentoSaidaTmp.setBackground(Color.white);
        jNomeInternoEvadido.setBackground(Color.white);
    }

    public void Novo() {
        //
        jIdLanc.setText("");
        jOperacao.setText("");
        jDataLanc.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        jIdInternoEvadido.setText("");
        jNomeInternoEvadido.setText("");
        //
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        //
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        //
        jIdLanc.setText("");
        jOperacao.setText("");
        jDataLanc.setDate(null);
        jObservacao.setText("");
        jIdInternoEvadido.setText("");
        jNomeInternoEvadido.setText("");
        //
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Salvar() {
        //
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
    }

    public void Cancelar() {
        //
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void Finalizar() {

    }

    public void buscarId() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVADIDOSIND");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do lançamento.");
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
// Atualiza a tela após lançamento da evasão

    public void preencherTabelaEvadidoSaidaTemporaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nr.Doc.","Código", "Nome do Interno", "Data Saída", "Data Prev. Retorno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Saida
                dataSaidaTemp = conecta.rs.getString("DataSaida");
                String diap = dataSaidaTemp.substring(8, 10);
                String mesp = dataSaidaTemp.substring(5, 7);
                String anop = dataSaidaTemp.substring(0, 4);
                dataSaidaTemp = diap + "/" + mesp + "/" + anop;
                // Formatar a data Entrada
                dataPrevRetorno = conecta.rs.getString("DataPrevRetorno");
                String diar = dataPrevRetorno.substring(8, 10);
                String mesr = dataPrevRetorno.substring(5, 7);
                String anor = dataPrevRetorno.substring(0, 4);
                dataPrevRetorno = diar + "/" + mesr + "/" + anor;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"),conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaidaTemp, dataPrevRetorno});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaTemporaria.setModel(modelo);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaTemporaria.setAutoResizeMode(jTabelaIntEvadidosSaidaTemporaria.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaTemporaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEvadidos();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaEvadidos() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }
}
