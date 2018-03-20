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
import gestor.Controle.ControleBiometriaInternos;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.BiometriaInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaProntuarioTriagem.caminhoFotoInternoTRIAGEM;
import static gestor.Visao.TelaProntuarioTriagem.jFotoMininoDireito;
import static gestor.Visao.TelaProntuarioTriagem.jFotoAnularDireito;
import static gestor.Visao.TelaProntuarioTriagem.jFotoAnularEsquerdo;
import static gestor.Visao.TelaProntuarioTriagem.jFotoIndicadorDireito;
import static gestor.Visao.TelaProntuarioTriagem.jFotoIndicadorEsquerdo;
import static gestor.Visao.TelaProntuarioTriagem.jFotoMedioDireito;
import static gestor.Visao.TelaProntuarioTriagem.jFotoMedioEsquerdo;
import static gestor.Visao.TelaProntuarioTriagem.jFotoMinimoEsquerdo;
import static gestor.Visao.TelaProntuarioTriagem.jFotoPolegarDireito;
import static gestor.Visao.TelaProntuarioTriagem.jFotoPolegarEsquerdo;
import static gestor.Visao.TelaProntuarioTriagem.jIdInterno;
import static gestor.Visao.TelaProntuarioTriagem.jMatriculaPenal;
import static gestor.Visao.TelaProntuarioTriagem.jNomeInterno;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class TelaBiometriaInterno extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    BiometriaInternos objBio = new BiometriaInternos();
    ControleBiometriaInternos control = new ControleBiometriaInternos();
    //
    String codigoInterno;
    Date dataFormatada;
    // MÃO DIREITA
    byte[] capDigital1 = null;
    byte[] capDigital2 = null;
    byte[] capDigital3 = null;
    byte[] capDigital4 = null;
    byte[] capDigital5 = null;
    // MÃO ESQUERDDA
    byte[] capDigital6 = null;
    byte[] capDigital7 = null;
    byte[] capDigital8 = null;
    byte[] capDigital9 = null;
    byte[] capDigital10 = null;
    // CAMINHO DAS IMAGENS DA MÃO DIREITA
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    String caminhoBiometria4 = "";
    String caminhoBiometria5 = "";
    // CAMINHO DAS IMAGENS DA MÃO ESQUERDA
    String caminhoBiometria6 = "";
    String caminhoBiometria7 = "";
    String caminhoBiometria8 = "";
    String caminhoBiometria9 = "";
    String caminhoBiometria10 = "";
    // CAMINHO DAS DIGITAIS PARA GRAVAR NO BANCO DADOS;
    String caminhoImagemDigital1 = "";
    String caminhoImagemDigital2 = "";
    String caminhoImagemDigital3 = "";
    String caminhoImagemDigital4 = "";
    String caminhoImagemDigital5 = "";
    String caminhoImagemDigital6 = "";
    String caminhoImagemDigital7 = "";
    String caminhoImagemDigital8 = "";
    String caminhoImagemDigital9 = "";
    String caminhoImagemDigital10 = "";

    //   
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
    public static TelaProntuarioTriagem prontuarioTriagem;

    /**
     * Creates new form TelaBiometriaInterno
     */
    public TelaBiometriaInterno(TelaProntuarioTriagem parent, boolean modal) {
        this.prontuarioTriagem = parent;
        this.setModal(modal);
        setLocationRelativeTo(prontuarioTriagem);
        initComponents();
        corCampos();
        dadosInterno();
        buscarCaminhoTempleteImagem();
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
        jPanel3 = new javax.swing.JPanel();
        btnVersao = new javax.swing.JButton();
        lblVersao = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jFotoInternoBiometria = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jBtDedo1 = new javax.swing.JButton();
        jBtDedo2 = new javax.swing.JButton();
        jBtDedo3 = new javax.swing.JButton();
        jBtDedo4 = new javax.swing.JButton();
        jBtDedo5 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jBtDedo6 = new javax.swing.JButton();
        jBtDedo7 = new javax.swing.JButton();
        jBtDedo8 = new javax.swing.JButton();
        jBtDedo9 = new javax.swing.JButton();
        jBtDedo10 = new javax.swing.JButton();
        btnCancelarLeitura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCodigoInterno = new javax.swing.JTextField();
        jNomeInternoCrc = new javax.swing.JTextField();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMatriculaPenalBio = new javax.swing.JFormattedTextField();
        jComboBoxOpcao = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Ficha de Datiloscopia Biometrica :::...");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teste Conexão com a DLL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        btnVersao.setForeground(new java.awt.Color(0, 153, 0));
        btnVersao.setText("Ler DLL (Versão SDK)");
        btnVersao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVersaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVersao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVersao)
        );

        lblVersao.setForeground(new java.awt.Color(0, 153, 0));
        lblVersao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVersao.setText("Versão SDK          ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVersao))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoBiometria, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoBiometria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Ler Digitais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Mão Direita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jBtDedo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo1.setForeground(new java.awt.Color(0, 0, 255));
        jBtDedo1.setText("Ler Dedo Polegar *");
        jBtDedo1.setToolTipText("Polegar Direito");
        jBtDedo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo1ActionPerformed(evt);
            }
        });

        jBtDedo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo2.setForeground(new java.awt.Color(0, 0, 255));
        jBtDedo2.setText("Ler Dedo Indicador *");
        jBtDedo2.setToolTipText("Indicador Direito");
        jBtDedo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo2ActionPerformed(evt);
            }
        });

        jBtDedo3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo3.setText("Ler Dedo Médio");
        jBtDedo3.setToolTipText("Polegar Esquerdo");
        jBtDedo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo3ActionPerformed(evt);
            }
        });

        jBtDedo4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo4.setText("Ler Dedo Anular");
        jBtDedo4.setToolTipText("Indicador Direito");
        jBtDedo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo4ActionPerformed(evt);
            }
        });

        jBtDedo5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo5.setText("Ler Dedo Mínimo");
        jBtDedo5.setToolTipText("Indicador Direito");
        jBtDedo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtDedo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDedo1)
                    .addComponent(jBtDedo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDedo4)
                    .addComponent(jBtDedo5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtDedo1, jBtDedo2, jBtDedo3, jBtDedo4, jBtDedo5});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtDedo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Mão Esquerda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jBtDedo6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo6.setForeground(new java.awt.Color(0, 0, 255));
        jBtDedo6.setText("Ler Dedo Polegar *");
        jBtDedo6.setToolTipText("Polegar Direito");
        jBtDedo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo6ActionPerformed(evt);
            }
        });

        jBtDedo7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo7.setForeground(new java.awt.Color(0, 0, 255));
        jBtDedo7.setText("Ler Dedo Indicador *");
        jBtDedo7.setToolTipText("Indicador Direito");
        jBtDedo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo7ActionPerformed(evt);
            }
        });

        jBtDedo8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo8.setText("Ler Dedo Médio");
        jBtDedo8.setToolTipText("Polegar Esquerdo");
        jBtDedo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo8ActionPerformed(evt);
            }
        });

        jBtDedo9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo9.setText("Ler Dedo Anular");
        jBtDedo9.setToolTipText("Indicador Direito");
        jBtDedo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo9ActionPerformed(evt);
            }
        });

        jBtDedo10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtDedo10.setText("Ler Dedo Mínimo");
        jBtDedo10.setToolTipText("Indicador Direito");
        jBtDedo10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDedo10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtDedo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDedo6)
                    .addComponent(jBtDedo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtDedo9)
                    .addComponent(jBtDedo10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtDedo10, jBtDedo6, jBtDedo7, jBtDedo8, jBtDedo9});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtDedo6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDedo10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelarLeitura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelarLeitura.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelarLeitura.setText("Cancelar leitura");
        btnCancelarLeitura.setToolTipText("Cancelar Leitura");
        btnCancelarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLeituraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarLeitura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome do Interno");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código");

        jCodigoInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoInterno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoInterno.setEnabled(false);

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoCrc.setEnabled(false);

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setToolTipText("Gravar digital");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("(*) Dedos usados no kit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Matricula Penal");

        jMatriculaPenalBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalBio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenalBio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jMatriculaPenalBio.setEnabled(false);

        jComboBoxOpcao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Cadastrar Biometria", "Alterar Biometria" }));
        jComboBoxOpcao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Operação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCodigoInterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jNomeInternoCrc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMatriculaPenalBio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMatriculaPenalBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSair)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVersaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVersaoActionPerformed
        // TODO add your handling code here:
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        Pointer p;
        p = dll.CIS_SDK_Versao();
        String val = p.getString(0);
        lblVersao.setText("CIS SDK - v." + val);
    }//GEN-LAST:event_btnVersaoActionPerformed

    private void jBtDedo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo1ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital1 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem1 = new File(caminhoBiometria1 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital1-MD" + ".gif");
        fileImagem1.delete();
        // Gravar a digital em um arquivo
        File arquivo2 = new File(caminhoBiometria1 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital1-MD" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo2)) {
            arq.write(pDigitalImagem);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital1 = pDigital1;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem1;
            imagem1 = ImageIO.read(new File(caminhoBiometria1 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital1-MD" + ".gif"));
            javax.swing.ImageIcon b = new javax.swing.ImageIcon(imagem1);
            jFotoPolegarDireito.setIcon(b);
            jFotoPolegarDireito.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoPolegarDireito.getWidth(), jFotoPolegarDireito.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital1 = caminhoBiometria1 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital1-MD" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo1ActionPerformed

    private void jBtDedo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo2ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        //
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital2 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem2 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem2 = new File(caminhoBiometria2 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital2-MD" + ".gif");
        fileImagem2.delete();
        // Gravar a digital em um arquivo
        File arquivo2 = new File(caminhoBiometria2 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital2-MD" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo2)) {
            arq.write(pDigitalImagem2);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        // PARA GRAVAR NO BANCO DE DADOS
        capDigital2 = pDigital2;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem2;
            imagem2 = ImageIO.read(new File(caminhoBiometria2 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital2-MD" + ".gif"));
            javax.swing.ImageIcon b = new javax.swing.ImageIcon(imagem2);
            jFotoIndicadorDireito.setIcon(b);
            jFotoIndicadorDireito.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoIndicadorDireito.getWidth(), jFotoIndicadorDireito.getHeight(), Image.SCALE_DEFAULT)));
            // PARA GRAVAR CAMINHO DA DIGITAL NO BANCO DE DADOS
            caminhoImagemDigital2 = caminhoBiometria2 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital2-MD" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo2ActionPerformed

    private void jBtDedo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo3ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital3 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem3 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem3 = new File(caminhoBiometria3 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital3-MD" + ".gif");
        fileImagem3.delete();
        // Gravar a digital em um arquivo
        File arquivo2 = new File(caminhoBiometria3 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital3-MD" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo2)) {
            arq.write(pDigitalImagem3);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital3 = pDigital3;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem3;
            imagem3 = ImageIO.read(new File(caminhoBiometria3 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital3-MD" + ".gif"));
            javax.swing.ImageIcon b = new javax.swing.ImageIcon(imagem3);
            jFotoMedioDireito.setIcon(b);
            jFotoMedioDireito.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoMedioDireito.getWidth(), jFotoMedioDireito.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital3 = caminhoBiometria3 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital3-MD" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo3ActionPerformed

    private void jBtDedo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo4ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital4 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem4 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem4 = new File(caminhoBiometria4 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital4-MD" + ".gif");
        fileImagem4.delete();
        // Gravar a digital em um arquivo
        File arquivo3 = new File(caminhoBiometria4 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital4-MD" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo3)) {
            arq.write(pDigitalImagem4);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital4 = pDigital4;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem4;
            imagem4 = ImageIO.read(new File(caminhoBiometria4 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital4-MD" + ".gif"));
            javax.swing.ImageIcon b = new javax.swing.ImageIcon(imagem4);
            jFotoAnularDireito.setIcon(b);
            jFotoAnularDireito.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoAnularDireito.getWidth(), jFotoAnularDireito.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital4 = caminhoBiometria4 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital4-MD" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo4ActionPerformed

    private void btnCancelarLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLeituraActionPerformed
        // TODO add your handling code here:

        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;

        // Cancelar a leitura
        dll.CIS_SDK_Biometrico_CancelarLeitura();

        btnCancelarLeitura.setEnabled(false);
    }//GEN-LAST:event_btnCancelarLeituraActionPerformed

    private void jBtDedo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo5ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital5 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem5 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem5 = new File(caminhoBiometria5 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital5-MD" + ".gif");
        fileImagem5.delete();
        // Gravar a digital em um arquivo
        File arquivo4 = new File(caminhoBiometria5 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital5-MD" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo4)) {
            arq.write(pDigitalImagem5);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital5 = pDigital5;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem5;
            imagem5 = ImageIO.read(new File(caminhoBiometria5 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital5-MD" + ".gif"));
            javax.swing.ImageIcon c = new javax.swing.ImageIcon(imagem5);
            jFotoMininoDireito.setIcon(c);
            jFotoMininoDireito.setIcon(new ImageIcon(c.getImage().getScaledInstance(jFotoMininoDireito.getWidth(), jFotoMininoDireito.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital5 = caminhoBiometria5 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital5-MD" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo5ActionPerformed

    private void jBtDedo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo6ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital6 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem6 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem5 = new File(caminhoBiometria6 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital6-ME" + ".gif");
        fileImagem5.delete();
        // Gravar a digital em um arquivo
        File arquivo5 = new File(caminhoBiometria6 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital6-ME" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo5)) {
            arq.write(pDigitalImagem6);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital6 = pDigital6;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem6;
            imagem6 = ImageIO.read(new File(caminhoBiometria6 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital6-ME" + ".gif"));
            javax.swing.ImageIcon d = new javax.swing.ImageIcon(imagem6);
            jFotoPolegarEsquerdo.setIcon(d);
            jFotoPolegarEsquerdo.setIcon(new ImageIcon(d.getImage().getScaledInstance(jFotoPolegarEsquerdo.getWidth(), jFotoPolegarEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital6 = caminhoBiometria6 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital6-ME" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo6ActionPerformed

    private void jBtDedo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo7ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital7 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem7 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem6 = new File(caminhoBiometria7 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital7-ME" + ".gif");
        fileImagem6.delete();
        // Gravar a digital em um arquivo
        File arquivo6 = new File(caminhoBiometria7 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital7-ME" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo6)) {
            arq.write(pDigitalImagem7);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital7 = pDigital7;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem7;
            imagem7 = ImageIO.read(new File(caminhoBiometria7 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital7-ME" + ".gif"));
            javax.swing.ImageIcon e = new javax.swing.ImageIcon(imagem7);
            jFotoIndicadorEsquerdo.setIcon(e);
            jFotoIndicadorEsquerdo.setIcon(new ImageIcon(e.getImage().getScaledInstance(jFotoIndicadorEsquerdo.getWidth(), jFotoIndicadorEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital7 = caminhoBiometria7 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital7-ME" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo7ActionPerformed

    private void jBtDedo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo8ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital8 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem8 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem7 = new File(caminhoBiometria8 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital8-ME" + ".gif");
        fileImagem7.delete();
        // Gravar a digital em um arquivo
        File arquivo7 = new File(caminhoBiometria8 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital8-ME" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo7)) {
            arq.write(pDigitalImagem8);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital8 = pDigital8;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem8;
            imagem8 = ImageIO.read(new File(caminhoBiometria8 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital8-ME" + ".gif"));
            javax.swing.ImageIcon f = new javax.swing.ImageIcon(imagem8);
            jFotoMedioEsquerdo.setIcon(f);
            jFotoMedioEsquerdo.setIcon(new ImageIcon(f.getImage().getScaledInstance(jFotoMedioEsquerdo.getWidth(), jFotoMedioEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital8 = caminhoBiometria8 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital8-ME" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo8ActionPerformed

    private void jBtDedo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo9ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital9 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem9 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem8 = new File(caminhoBiometria9 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital9-ME" + ".gif");
        fileImagem8.delete();
        // Gravar a digital em um arquivo
        File arquivo8 = new File(caminhoBiometria9 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital9-ME" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo8)) {
            arq.write(pDigitalImagem9);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital9 = pDigital9;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem9;
            imagem9 = ImageIO.read(new File(caminhoBiometria9 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital9-ME" + ".gif"));
            javax.swing.ImageIcon g = new javax.swing.ImageIcon(imagem9);
            jFotoAnularEsquerdo.setIcon(g);
            jFotoAnularEsquerdo.setIcon(new ImageIcon(g.getImage().getScaledInstance(jFotoAnularEsquerdo.getWidth(), jFotoAnularEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital9 = caminhoBiometria9 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital9-ME" + ".gif";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtDedo9ActionPerformed

    private void jBtDedo10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDedo10ActionPerformed
        // TODO add your handling code here:
        CIS_SDK dll = CIS_SDK.INSTANCE;

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
        //
        final Pointer pTemplate = new Memory(1000);
        final Pointer pImagem = new Memory(200000);
        //
        int iFundoBranco = 1;
        int iTipoImagem = 2;
        //
        IntByReference iTemplate = new IntByReference();
        IntByReference iImagem = new IntByReference();
        //
        iRetorno = dll.CIS_SDK_Biometrico_LerDigitalComImagem(pTemplate, iTemplate, pImagem, iImagem, iFundoBranco, iTipoImagem);
        if (iRetorno != 1 && iRetorno == 0) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            dll.CIS_SDK_Biometrico_Finalizar();
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        int iTemp = iTemplate.getValue();
        int iImag = iImagem.getValue();
        //
        byte[] pDigital10 = pTemplate.getByteArray(0, iTemp);
        byte[] pDigitalImagem10 = pImagem.getByteArray(0, iImag);
        // APAGAR A IMAGEM ANTERIOR
        File fileImagem9 = new File(caminhoBiometria10 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital10-ME" + ".gif");
        fileImagem9.delete();
        // Gravar a digital em um arquivo
        File arquivo9 = new File(caminhoBiometria10 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital10-ME" + ".gif");
        try (FileOutputStream arq = new FileOutputStream(arquivo9)) {
            arq.write(pDigitalImagem10);
            arq.flush();
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO. Não existe caminho para gravar a imagem da biometria !!! ");
        }
        capDigital10 = pDigital10;
        JOptionPane.showMessageDialog(null, "Template e Imagem da Digital gerado!");
        //
        iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
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
        // LER A IMAGEM DA DIGITAL E MOSTRAR NA TELA
        try {
            BufferedImage imagem10;
            imagem10 = ImageIO.read(new File(caminhoBiometria10 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital10-ME" + ".gif"));
            javax.swing.ImageIcon h = new javax.swing.ImageIcon(imagem10);
            jFotoMinimoEsquerdo.setIcon(h);
            jFotoMinimoEsquerdo.setIcon(new ImageIcon(h.getImage().getScaledInstance(jFotoMinimoEsquerdo.getWidth(), jFotoMinimoEsquerdo.getHeight(), Image.SCALE_DEFAULT)));
            //
            caminhoImagemDigital10 = caminhoBiometria10 + jCodigoInterno.getText() + "-" + jNomeInternoCrc.getText() + "-Digital10-ME" + ".gif";
        } catch (Exception e) {
        }
        jBtSalvar.setEnabled(true);
    }//GEN-LAST:event_jBtDedo10ActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        verificarInternoBiometria();
        if (jComboBoxOpcao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma opção para poder gravar a biometria");
        } else {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dataFormatada = formato.parse(jDataSistema.getText());
            } catch (ParseException ex) {
                Logger.getLogger(TelaBiometriaInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (jComboBoxOpcao.getSelectedItem().equals("Cadastrar Biometria") && !jCodigoInterno.getText().equals(codigoInterno)) {
                if (capDigital1 != null && capDigital2 != null && capDigital3 != null && capDigital4 != null) {
                    objBio.setIdInternoCrc(Integer.valueOf(jCodigoInterno.getText()));
                    objBio.setNomeInternoBio(jNomeInternoCrc.getText());
                    objBio.setDataCadastro(dataFormatada);
                    objBio.setBiometriaDedo1(capDigital1);
                    objBio.setBiometriaDedo2(capDigital2);
                    objBio.setBiometriaDedo3(capDigital3);
                    objBio.setBiometriaDedo4(capDigital4);
                    //
                    objBio.setCaminhoImagemDedo1(caminhoImagemDigital1);
                    objBio.setCaminhoImagemDedo2(caminhoImagemDigital2);
                    objBio.setCaminhoImagemDedo3(caminhoImagemDigital3);
                    objBio.setCaminhoImagemDedo4(caminhoImagemDigital4);
                    objBio.setCaminhoImagemDedo5(caminhoImagemDigital5);
                    objBio.setCaminhoImagemDedo6(caminhoImagemDigital6);
                    objBio.setCaminhoImagemDedo7(caminhoImagemDigital7);
                    objBio.setCaminhoImagemDedo8(caminhoImagemDigital8);
                    objBio.setCaminhoImagemDedo9(caminhoImagemDigital9);
                    objBio.setCaminhoImagemDedo10(caminhoImagemDigital10);
                    //
                    objBio.setUsuarioInsert(nameUser);
                    objBio.setDataInsert(jDataSistema.getText());
                    objBio.setHorarioInsert(jHoraSistema.getText());
                    //
                    control.incluirBiometriaInterno(objBio);
                    Salvar();
                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "É necessário capturar todas as digitais para serem gravadas.");
                }
            } else if (jComboBoxOpcao.getSelectedItem().equals("Alterar Biometria") && jCodigoInterno.getText().equals(codigoInterno)) {
                objBio.setUsuarioUp(nameUser);
                objBio.setDataUp(jDataSistema.getText());
                objBio.setHorarioUp(jHoraSistema.getText());
                if (capDigital1 != null && capDigital2 != null && capDigital3 != null && capDigital4 != null) {
                    objBio.setIdInternoCrc(Integer.valueOf(jCodigoInterno.getText()));
                    objBio.setNomeInternoBio(jNomeInternoCrc.getText());
                    objBio.setDataCadastro(dataFormatada);
                    objBio.setBiometriaDedo1(capDigital1);
                    objBio.setBiometriaDedo2(capDigital2);
                    objBio.setBiometriaDedo3(capDigital3);
                    objBio.setBiometriaDedo4(capDigital4);
                    //
                    objBio.setCaminhoImagemDedo1(caminhoImagemDigital1);
                    objBio.setCaminhoImagemDedo2(caminhoImagemDigital2);
                    objBio.setCaminhoImagemDedo3(caminhoImagemDigital3);
                    objBio.setCaminhoImagemDedo4(caminhoImagemDigital4);
                    objBio.setCaminhoImagemDedo5(caminhoImagemDigital5);
                    objBio.setCaminhoImagemDedo6(caminhoImagemDigital6);
                    objBio.setCaminhoImagemDedo7(caminhoImagemDigital7);
                    objBio.setCaminhoImagemDedo8(caminhoImagemDigital8);
                    objBio.setCaminhoImagemDedo9(caminhoImagemDigital9);
                    objBio.setCaminhoImagemDedo10(caminhoImagemDigital10);
                    //
                    control.alterarBiometriaInterno(objBio);
                    Salvar();
                    JOptionPane.showMessageDialog(null, "Registro alterardo com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "É necessário capturar todas as digitais para serem gravadas.");
                }
            } else if (jComboBoxOpcao.getSelectedItem().equals("Cadastrar Biometria") && jCodigoInterno.getText().equals(codigoInterno)) {
                JOptionPane.showMessageDialog(null, "Já foi cadastrado a biometria para esse interno. Caso deseje modificar, altere a operação.");
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaBiometriaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBiometriaInterno dialog = new TelaBiometriaInterno(prontuarioTriagem, true);
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
    private javax.swing.JButton btnCancelarLeitura;
    private javax.swing.JButton btnVersao;
    private javax.swing.JButton jBtDedo1;
    private javax.swing.JButton jBtDedo10;
    private javax.swing.JButton jBtDedo2;
    private javax.swing.JButton jBtDedo3;
    private javax.swing.JButton jBtDedo4;
    private javax.swing.JButton jBtDedo5;
    private javax.swing.JButton jBtDedo6;
    private javax.swing.JButton jBtDedo7;
    private javax.swing.JButton jBtDedo8;
    private javax.swing.JButton jBtDedo9;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JTextField jCodigoInterno;
    private javax.swing.JComboBox jComboBoxOpcao;
    public static javax.swing.JLabel jFotoInternoBiometria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JFormattedTextField jMatriculaPenalBio;
    private javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblVersao;
    // End of variables declaration//GEN-END:variables

    public void buscarCaminhoTempleteImagem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            // CAMINHOS DAS IMAGENS
            caminhoBiometria1 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria2 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria3 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria4 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria5 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria6 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria7 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria8 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria9 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria10 = conecta.rs.getString("CaminhoImagemCRCInterno");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void corCampos() {
        jCodigoInterno.setBackground(Color.white);
        jNomeInternoCrc.setBackground(Color.white);
        jMatriculaPenalBio.setBackground(Color.white);
    }

    public void Salvar() {
        capDigital1 = null;
        capDigital2 = null;
        capDigital3 = null;
        capDigital4 = null;
        jBtSalvar.setEnabled(!true);
    }

    public void dadosInterno() {
        javax.swing.ImageIcon z = new javax.swing.ImageIcon(caminhoFotoInternoTRIAGEM);
        jFotoInternoBiometria.setIcon(z);
        jFotoInternoBiometria.setIcon(new ImageIcon(z.getImage().getScaledInstance(jFotoInternoBiometria.getWidth(), jFotoInternoBiometria.getHeight(), Image.SCALE_DEFAULT)));
        jCodigoInterno.setText(jIdInterno.getText());
        jNomeInternoCrc.setText(jNomeInterno.getText());
        jMatriculaPenalBio.setText(jMatriculaPenal.getText());
    }

    public void verificarInternoBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM BIOMETRIA_INTERNOS "
                    + "WHERE IdInternoCrc='" + jCodigoInterno.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
