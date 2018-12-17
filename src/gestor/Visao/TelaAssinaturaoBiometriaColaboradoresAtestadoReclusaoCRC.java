/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import gestor.Controle.ControleItensEntSaiFunc;
import gestor.Controle.ControleLogSistema;
import static gestor.Controle.ControleItensEntSaiFunc.qtdColaboradores;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DigitalColaborador;
import gestor.Modelo.EmissaoAtestadoReclusao;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaEntradaSaidaColaborador.jIDlanc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.codigoLiberador;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.dataAssinatura;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.horaAssinatura;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.jBtSalvar;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.nomeLiberador;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.pDigitalCapturadaColaborador;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.pLiberacaoImpressa;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.dataLiberacao;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.codigoValidador;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.jComboBoxClassAtestado;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmissaoAtestadoReclusao objEmissao = new EmissaoAtestadoReclusao();
    ControleItensEntSaiFunc controle = new ControleItensEntSaiFunc();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela2 = "CRC:Liberação Atestado de Reclusão:Biometria";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao;
    int flag;
    int count1;
    // VARIVAEL PARA ARMAZENAR AS DIGITAIS DO BANCO DE DADOS
    String caminhoBiometria = "";
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturada = null;
    public static byte[] imagemFrenteCola = null;
    // CAMINHO DAS FOTOS DO COLABORADOR
    public static String caminhoFotoColaborador;
    String horarioSaidaBio = "00:00";
    int codigoItem = 0;
    String nomeColaboradorCRC = "";
    String nomeColaboradorCRC_SEG = "";
    //
    String dataInicial;
    //
    String validadorDados = "";

    // CÓDIGO DA BIOMETRIA CIS FS-80H
    public interface CIS_SDK extends StdCallLibrary {

        CIS_SDK INSTANCE = (CIS_SDK) Native.loadLibrary("CIS_SDK", CIS_SDK.class);

        public int CIS_SDK_Biometrico_Iniciar();

        public int CIS_SDK_Biometrico_Finalizar();

        public int CIS_SDK_Biometrico_LerDigital(PointerByReference pTemplate);

        public Pointer CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(IntByReference iRetorno);

        public int CIS_SDK_Biometrico_CancelarLeitura();

        public int CIS_SDK_Biometrico_CompararDigital(PointerByReference pAmostra1, PointerByReference pAmostra2);

        public Pointer CIS_SDK_Biometrico_LerWSQ(IntByReference iRetorno, IntByReference iSize);

        public int CIS_SDK_Biometrico_LerDigitalComImagem(Pointer pTemplate, IntByReference iTemplate, Pointer pImagem, IntByReference iImagem, int iFundoBranco, int iTipoImagem);

        public Pointer CIS_SDK_Versao();
    }

    //
    /**
     * Creates new form TelaAcessoBiometria
     */
    public static TelaEmissaoAtestadoReclusaoCRC assinaturaFuncAtestaRec;

    public TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC(TelaEmissaoAtestadoReclusaoCRC parent, boolean modal) {
        this.assinaturaFuncAtestaRec = parent;
        this.setModal(modal);
        setLocationRelativeTo(assinaturaFuncAtestaRec);
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

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIdColaborador = new javax.swing.JTextField();
        jNomeColaborador = new javax.swing.JTextField();
        jFuncaoColaborador = new javax.swing.JTextField();
        jDepartamento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jMatricula = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jDataLiberacao = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jHorarioLiberacao = new javax.swing.JFormattedTextField();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBtIniciarLeitor = new javax.swing.JButton();
        jBtCancelarLeitura = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jFotoColaborador = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Assinatura para Liberação do Atestado de Reclusão :::...");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png")));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Colabordor");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Função");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Departamento");

        jIdColaborador.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdColaborador.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdColaborador.setEnabled(false);

        jNomeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaborador.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeColaborador.setEnabled(false);

        jFuncaoColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFuncaoColaborador.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFuncaoColaborador.setEnabled(false);

        jDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDepartamento.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Matricula");

        jMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatricula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatricula.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeColaborador)
                    .addComponent(jFuncaoColaborador)
                    .addComponent(jDepartamento)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIdColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 182, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFuncaoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Liberação:");

        jDataLiberacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Horário:");

        jHorarioLiberacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioLiberacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataLiberacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHorarioLiberacao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHorarioLiberacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jDataLiberacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jBtConfirmar.setForeground(new java.awt.Color(0, 102, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.setToolTipText("Confirmar assinatura");
        jBtConfirmar.setEnabled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtIniciarLeitor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtIniciarLeitor.setForeground(new java.awt.Color(0, 153, 153));
        jBtIniciarLeitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16.png"))); // NOI18N
        jBtIniciarLeitor.setText("Iniciar Leitor Digital");
        jBtIniciarLeitor.setToolTipText("Iniciar Leitura Biometrica");
        jBtIniciarLeitor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtIniciarLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIniciarLeitorActionPerformed(evt);
            }
        });

        jBtCancelarLeitura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtCancelarLeitura.setForeground(new java.awt.Color(255, 0, 0));
        jBtCancelarLeitura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtCancelarLeitura.setText("Cancelar Leitura");
        jBtCancelarLeitura.setToolTipText("Cancelar Leitura");
        jBtCancelarLeitura.setEnabled(false);
        jBtCancelarLeitura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtCancelarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarLeituraActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Colaborador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoColaborador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBtIniciarLeitor)
                            .addGap(307, 307, 307)
                            .addComponent(jBtCancelarLeitura))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtSair)
                            .addComponent(jBtConfirmar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIniciarLeitor)
                    .addComponent(jBtCancelarLeitura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        verificarColaboradorLiberador();
        if (nomeColaboradorCRC.equals("") || nomeColaboradorCRC_SEG.equals("") || nomeColaboradorCRC == null || nomeColaboradorCRC_SEG == null) {
            JOptionPane.showMessageDialog(rootPane, "Não existe colaborador definido no parametro para realizar a liberação, solicite ao Administrador do Sistema para cadastrar.");
        } else if (nomeColaboradorCRC.equals(jNomeColaborador.getText()) || nomeColaboradorCRC_SEG.equals(jNomeColaborador.getText())) {
            pLiberacaoImpressa = "Sim";
            objEmissao.setIdColaborador(Integer.valueOf(jIdColaborador.getText()));
            objEmissao.setNomeColaborador(jNomeColaborador.getText());
            objEmissao.setDataLiberacao(jDataLiberacao.getDate());
            objEmissao.setHorarioLiberacao(jHorarioLiberacao.getText());
            jComboBoxClassAtestado.setSelectedItem("Liberado");
            dataLiberacao = jDataLiberacao.getDate();
            codigoLiberador = objEmissao.getIdColaborador();
            nomeLiberador = objEmissao.getNomeColaborador();
            pDigitalCapturadaColaborador = pDigitalCapturada;
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataInicial = formatoAmerica.format(jDataLiberacao.getDate().getTime());
            dataAssinatura = dataInicial;
            horaAssinatura = objEmissao.getHorarioLiberacao();
            criptografarDadosColaboradorSimetrico(jIdColaborador.getText(),jNomeColaborador.getText());
            jBtSalvar.setEnabled(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esse colaborador não tem permissão para liberar autorização impressa.");
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:       
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtIniciarLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIniciarLeitorActionPerformed
        // TODO add your handling code here:    
        Novo();
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        //
        int iRetorno = dll.CIS_SDK_Biometrico_Iniciar();
        if (iRetorno != 1 && iRetorno == 0) {
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        jBtCancelarLeitura.setEnabled(true);
        new Thread(LerDigital1).start();
    }//GEN-LAST:event_jBtIniciarLeitorActionPerformed

    private void jBtCancelarLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarLeituraActionPerformed
        // TODO add your handling code here:
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        // Cancelar a leitura 
        dll.CIS_SDK_Biometrico_CancelarLeitura();
        // HABILITAR O BOTÃO PARA CANCELAR A LEITURA
        jBtCancelarLeitura.setEnabled(false);
    }//GEN-LAST:event_jBtCancelarLeituraActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC dialog = new TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC(assinaturaFuncAtestaRec, true);
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
    private javax.swing.JButton jBtCancelarLeitura;
    public static javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtIniciarLeitor;
    private javax.swing.JButton jBtSair;
    public static com.toedter.calendar.JDateChooser jDataLiberacao;
    public static javax.swing.JTextField jDepartamento;
    public static javax.swing.JLabel jFotoColaborador;
    public static javax.swing.JTextField jFuncaoColaborador;
    private javax.swing.JFormattedTextField jHorarioLiberacao;
    public static javax.swing.JTextField jIdColaborador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatricula;
    public static javax.swing.JTextField jNomeColaborador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private static Runnable LerDigital1 = new Runnable() {
        @Override
        public void run() {
            try {
                // Instanciar a DLL
                CIS_SDK dll = CIS_SDK.INSTANCE;
                // Capturar a digital no leitor   
                Pointer pDigital;
                IntByReference iRet = new IntByReference();
                pDigital = dll.CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(iRet);
                int iRetorno2 = iRet.getValue();
                if (iRetorno2 != 1 && iRetorno2 == 0) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -1) {
                    JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -10) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -11) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -12) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -13) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "SDK EM USO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -14) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -15) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -16) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -17) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -18) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -21) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -22) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -23) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -24) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -25) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -26) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -27) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -28) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -29) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
                    return;
                }
                //
                byte[] pDigitalCap = pDigital.getByteArray(0, 669);
                pDigitalCapturada = pDigitalCap; // SALVAR DIGITAL NO BANCO DE DADOS - ANALISANDO
                //
                ControleItensEntSaiFunc digiControl = new ControleItensEntSaiFunc();
                DigitalColaborador d = new DigitalColaborador();
                int pVar = 0;
                for (DigitalColaborador dd : digiControl.read()) {
                    // LER DIGITAL PARA COMPRAR
                    final Pointer p1 = new Memory(669);
                    p1.write(0, pDigitalCap, 0, pDigitalCap.length);
                    final PointerByReference pr1 = new PointerByReference();
                    pr1.setPointer(p1);
                    // DIGITAL DO BANCO DE DADOS - DEDO UM                   
                    Pointer p2 = new Memory(669);
                    p2.write(0, dd.getBiometriaDedo1(), 0, dd.getBiometriaDedo1().length);
                    PointerByReference pr2 = new PointerByReference();
                    pr2.setPointer(p2);
                    // DIGITAL DO BANCO DE DADOS - DEDO DOIS  
                    Pointer p3 = new Memory(669);
                    p3.write(0, dd.getBiometriaDedo2(), 0, dd.getBiometriaDedo2().length);
                    PointerByReference pr3 = new PointerByReference();
                    pr3.setPointer(p3);
                    // DIGITAL DO BANCO DE DADOS - DEDO TRÊS  
                    Pointer p4 = new Memory(669);
                    p4.write(0, dd.getBiometriaDedo3(), 0, dd.getBiometriaDedo3().length);
                    PointerByReference pr4 = new PointerByReference();
                    pr4.setPointer(p4);
                    // DIGITAL DO BANCO DE DADOS - DEDO QUATRO  
                    Pointer p5 = new Memory(669);
                    p5.write(0, dd.getBiometriaDedo4(), 0, dd.getBiometriaDedo4().length);
                    PointerByReference pr5 = new PointerByReference();
                    pr5.setPointer(p5);
                    // COMPARA TODAS AS DIGITAIS                 
                    int iRetorno = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr2);
                    int iRetornod1 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr3);
                    int iRetornod2 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr4);
                    int iRetornod3 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr5);
                    // VERIFICAR SE A DIGITAL É IGUAL AO DEDO UM                  
                    if (iRetorno == 1) {
                        jIdColaborador.setText(String.valueOf(dd.getIdFunc()));
                        jNomeColaborador.setText(dd.getNomeFunc());
                        jFuncaoColaborador.setText(dd.getFuncao());
                        jDepartamento.setText(dd.getDepartamento());
                        caminhoFotoColaborador = dd.getFotoColaborador();
                        if (caminhoFotoColaborador != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoColaborador);
                            jFotoColaborador.setIcon(a);
                            jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO COLABORADOR NO BANCO DE DADOS
                        imagemFrenteCola = dd.getImagemFrenteOF();
                        if (imagemFrenteCola != null) {
                            ImageIcon pic2 = null;
                            pic2 = new ImageIcon(imagemFrenteCola);
                            Image scaled2 = pic2.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon2 = new ImageIcon(scaled2);
                            jFotoColaborador.setIcon(icon2);
                        }
                        jBtConfirmar.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO DOIS
                    } else if (iRetornod1 == 1) {
                        jIdColaborador.setText(String.valueOf(dd.getIdFunc()));
                        jNomeColaborador.setText(dd.getNomeFunc());
                        jFuncaoColaborador.setText(dd.getFuncao());
                        jDepartamento.setText(dd.getDepartamento());
                        caminhoFotoColaborador = dd.getFotoColaborador();
                        if (caminhoFotoColaborador != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoColaborador);
                            jFotoColaborador.setIcon(a);
                            jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFrenteCola = dd.getImagemFrenteOF();
                        if (imagemFrenteCola != null) {
                            ImageIcon pic2 = null;
                            pic2 = new ImageIcon(imagemFrenteCola);
                            Image scaled2 = pic2.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon2 = new ImageIcon(scaled2);
                            jFotoColaborador.setIcon(icon2);
                        }
                        jBtConfirmar.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO TRÊS
                    } else if (iRetornod2 == 1) {
                        jIdColaborador.setText(String.valueOf(dd.getIdFunc()));
                        jNomeColaborador.setText(dd.getNomeFunc());
                        jFuncaoColaborador.setText(dd.getFuncao());
                        jDepartamento.setText(dd.getDepartamento());
                        caminhoFotoColaborador = dd.getFotoColaborador();
                        if (caminhoFotoColaborador != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoColaborador);
                            jFotoColaborador.setIcon(a);
                            jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFrenteCola = dd.getImagemFrenteOF();
                        if (imagemFrenteCola != null) {
                            ImageIcon pic2 = null;
                            pic2 = new ImageIcon(imagemFrenteCola);
                            Image scaled2 = pic2.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon2 = new ImageIcon(scaled2);
                            jFotoColaborador.setIcon(icon2);
                        }
                        jBtConfirmar.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO QUATRO
                    } else if (iRetornod3 == 1) {
                        jIdColaborador.setText(String.valueOf(dd.getIdFunc()));
                        jNomeColaborador.setText(dd.getNomeFunc());
                        jFuncaoColaborador.setText(dd.getFuncao());
                        jDepartamento.setText(dd.getDepartamento());
                        caminhoFotoColaborador = dd.getFotoColaborador();
                        if (caminhoFotoColaborador != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoColaborador);
                            jFotoColaborador.setIcon(a);
                            jFotoColaborador.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFrenteCola = dd.getImagemFrenteOF();
                        if (imagemFrenteCola != null) {
                            ImageIcon pic2 = null;
                            pic2 = new ImageIcon(imagemFrenteCola);
                            Image scaled2 = pic2.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon2 = new ImageIcon(scaled2);
                            jFotoColaborador.setIcon(icon2);
                        }
                        jBtConfirmar.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    }
                    // SE TODOS AS DIGITAIS FOREM IGUAL A -2 , DIGITAL NÃO CADASTRADA
                    if (iRetorno == -2 && iRetornod1 == -2 && iRetornod2 == -2 && iRetornod3 == -2 && qtdColaboradores == pVar) {
                        break;
                    }
                    pVar = pVar + 1;
                }
                JOptionPane.showMessageDialog(null, "Digital não cadastrada, procure a Administração !!!");
                // Finalizar o SDK 
                int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                if (idRetorno != 1 && idRetorno == 0) {
                    JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -1) {
                    JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -10) {
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -11) {
                    JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -12) {
                    JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -13) {
                    JOptionPane.showMessageDialog(null, "SDK EM USO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -14) {
                    JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -15) {
                    JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -16) {
                    JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -17) {
                    JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -18) {
                    JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -21) {
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -22) {
                    JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -23) {
                    JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -24) {
                    JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -25) {
                    JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -26) {
                    JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -27) {
                    JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -28) {
                    JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -29) {
                    JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
                    return;
                }
                d.setBiometriaDedo1(pDigitalCap);
                d.setBiometriaDedo2(pDigitalCap);
                d.setBiometriaDedo3(pDigitalCap);
                d.setBiometriaDedo4(pDigitalCap);
            } catch (Exception e) {
            }
        }
    ;

    };            
    
    // -----------------------------------------------------------------------------
    public void corCampos() {
        jIdColaborador.setBackground(Color.white);
        jMatricula.setBackground(Color.white);
        jNomeColaborador.setBackground(Color.white);
        jFuncaoColaborador.setBackground(Color.white);
        jDepartamento.setBackground(Color.white);
        jDataLiberacao.setBackground(Color.white);
        jHorarioLiberacao.setBackground(Color.white);
    }

    public void Novo() {
        jIdColaborador.setText("");
        jNomeColaborador.setText("");
        jFuncaoColaborador.setText("");
        jDepartamento.setText("");
        jFotoColaborador.setIcon(null);
        //
        jDataLiberacao.setCalendar(Calendar.getInstance());
        jHorarioLiberacao.setText(jHoraSistema.getText());
        //        
        jDataLiberacao.setEnabled(!true);
        jHorarioLiberacao.setEnabled(!true);
        //
        jBtConfirmar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void Salvar() {
        jIdColaborador.setText("");
        jNomeColaborador.setText("");
        jFuncaoColaborador.setText("");
        jDepartamento.setText("");
        jFotoColaborador.setIcon(null);
        jDataLiberacao.setDate(null);
        jHorarioLiberacao.setText("");
        //               
        jDataLiberacao.setEnabled(!true);
        jHorarioLiberacao.setEnabled(!true);
        //
        jBtConfirmar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void Cancelar() {
        jIdColaborador.setText("");
        jNomeColaborador.setText("");
        jFuncaoColaborador.setText("");
        jDepartamento.setText("");
        jFotoColaborador.setIcon(null);
        jDataLiberacao.setDate(null);
        jHorarioLiberacao.setText("");
        //
        jBtConfirmar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(!true);
    }

    public void verificarColaboradorLiberador() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            nomeColaboradorCRC = conecta.rs.getString("NomeColaboradorCRC");
            nomeColaboradorCRC_SEG = conecta.rs.getString("NomeColaboradorCRCSEG");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void criptografarDadosColaboradorSimetrico(String codigo, String nomeColaborador) {
       validadorDados = codigo + nomeColaborador;
       // CRIPTOGRAFIA SIMETRICA: AES,RC2,RC4,RC5, IDEA, Blowfish
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secrecKey = keyGenerator.generateKey();
            Cipher cipher;
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secrecKey);
            byte[] criptografia = cipher.doFinal(validadorDados.getBytes());
            codigoValidador = criptografia;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
