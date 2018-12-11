/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaValidadorAtestadoReclusao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    String chaveHexadecinal;
    String chaveHexadecinal2;
    String validadorInterno;
    String validadorInterno2;
    String dataInicial;
    String dataPesquisa;
    //   
    String codigoRegistro = "";
    Date dataRegistro;
    String codigoInterno = "";
    String codigoVisita = "";
    String nomeInternoCrc = "";
    String chaveInterno;

    /**
     * Creates new form TelaValidadorAtestadoReclusao
     */
    public TelaValidadorAtestadoReclusao() {
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

        btGrupoValidacao = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jIdVisita = new javax.swing.JTextField();
        jIdInternoCrc = new javax.swing.JTextField();
        jNomeInternoCrc = new javax.swing.JTextField();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jBtPesquisarInterno = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBtValidar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jRBtRegistro = new javax.swing.JRadioButton();
        jRBtChave = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jChaveUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Validador de Atestado de Reclusão :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código Registro");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Registro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código Visita");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código Interno");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Interno");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jIdVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jIdInternoCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisarInterno.setToolTipText("Pesquisar Interno");
        jBtPesquisarInterno.setContentAreaFilled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoCrc)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jIdRegistro)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(14, 14, 14))
                                    .addComponent(jIdVisita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jIdInternoCrc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdInternoCrc, jIdRegistro, jIdVisita});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtValidar.setForeground(new java.awt.Color(0, 102, 0));
        jBtValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtValidar.setText("Validar");
        jBtValidar.setToolTipText("Validar Atestado de Reclusão");
        jBtValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtValidarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
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
                .addGap(119, 119, 119)
                .addComponent(jBtValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtValidar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtValidar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtValidar});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tipo de Validação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        btGrupoValidacao.add(jRBtRegistro);
        jRBtRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtRegistro.setForeground(new java.awt.Color(0, 0, 204));
        jRBtRegistro.setSelected(true);
        jRBtRegistro.setText("Dados do Registro");

        btGrupoValidacao.add(jRBtChave);
        jRBtChave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtChave.setForeground(new java.awt.Color(0, 102, 0));
        jRBtChave.setText("Chave de Validação");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jRBtRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBtChave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBtRegistro)
                    .addComponent(jRBtChave))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Chave de Validação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jChaveUsuario.setToolTipText("Chave de Validação do Atestado de Reclusão");
        jChaveUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Chave de Validação do Documento");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChaveUsuario)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChaveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(400, 100, 543, 352);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do atestado para pesquisa.");
        } else {
            pesquisarAtestado();
        }
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jBtValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtValidarActionPerformed
        // TODO add your handling code here:
        if (jRBtRegistro.isSelected()) {
            if (jIdRegistro.getText().equals("")) {
                jIdRegistro.requestFocus();
                jIdRegistro.setBackground(Color.red);
                JOptionPane.showMessageDialog(rootPane, "Informe o número do atestado.");
            } else if (jDataRegistro.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de emissão do atestado.");
            } else if (jIdVisita.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o código da Visita.");
            } else if (jIdInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o código do interno.");
            } else if (jNomeInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else {
                pesquisarDadosCriptografia();
                //CONVERTE A DATA EM STRING PARA SER CRIPTOGRAFADA.
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = formatoAmerica.format(jDataRegistro.getDate().getTime());
                dataPesquisa = formatoAmerica.format(dataRegistro);
                criptografiaMD5(jIdRegistro.getText(), dataInicial, jIdVisita.getText(), jIdInternoCrc.getText(), jNomeInternoCrc.getText());
                criptografiaPesquisaMD5(codigoRegistro, dataPesquisa, codigoVisita, codigoInterno, nomeInternoCrc);
                if (chaveHexadecinal.equals(chaveHexadecinal2)) {
                    corCampos();
                    JOptionPane.showMessageDialog(rootPane, "Documento validado com sucesso.");
                } else {
                    corCampos();
                    JOptionPane.showMessageDialog(rootPane, "Documento invalido !!!");
                }
            }
        } else if (jRBtChave.isSelected()) {
            pesquisarDadosCriptografia();
            if (jIdRegistro.getText().equals("")) {
                jIdRegistro.requestFocus();
                jIdRegistro.setBackground(Color.red);
                JOptionPane.showMessageDialog(rootPane, "Informe o código do Atestado.");
            } else if (jChaveUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a chave de validação.");
            } else {
                if (chaveInterno.equals(jChaveUsuario.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Documento validado com sucesso.");
                    corCampos();
                } else {
                    corCampos();
                    JOptionPane.showMessageDialog(rootPane, "Documento invalido !!!");
                }
            }
        }
    }//GEN-LAST:event_jBtValidarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btGrupoValidacao;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtValidar;
    private javax.swing.JTextField jChaveUsuario;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    private javax.swing.JTextField jIdInternoCrc;
    private javax.swing.JTextField jIdRegistro;
    private javax.swing.JTextField jIdVisita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRBtChave;
    private javax.swing.JRadioButton jRBtRegistro;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jIdVisita.setBackground(Color.white);
        jIdInternoCrc.setBackground(Color.white);
        jNomeInternoCrc.setBackground(Color.white);
    }

    public void pesquisarAtestado() {
        conecta.abrirConexao();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc= PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdAtestado='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            jIdRegistro.setText(conecta.rs.getString("IdAtestado"));
            jDataRegistro.setDate(conecta.rs.getDate("DataAtestado"));
            jIdVisita.setText(conecta.rs.getString("IdVisita"));
            jIdInternoCrc.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoCrc.setText(conecta.rs.getString("NomeInternoCrc"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // CRIPTOGRAFIA ASSIMETRICA COM MD5
    public void criptografiaMD5(String idRegistro, String dataRegistro, String idVisita, String idInterno, String nomeInterno) {
        validadorInterno = idRegistro + dataRegistro + idVisita + idInterno + nomeInterno;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(validadorInterno.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));
            }

            chaveHexadecinal = sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaValidadorAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TelaValidadorAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criptografiaPesquisaMD5(String idRegistro, String dataRegistro, String idVisita, String idInterno, String nomeInterno) {
        validadorInterno2 = idRegistro + dataRegistro + idVisita + idInterno + nomeInterno;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(validadorInterno2.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));
            }

            chaveHexadecinal2 = sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaValidadorAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TelaValidadorAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pesquisarDadosCriptografia() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc= PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdAtestado='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            codigoRegistro = conecta.rs.getString("IdAtestado");
            dataRegistro = conecta.rs.getDate("DataAtestado");
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoVisita = conecta.rs.getString("IdVisita");
            nomeInternoCrc = conecta.rs.getString("NomeInternoCrc");
            chaveInterno = conecta.rs.getString("ChaveInterno");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
