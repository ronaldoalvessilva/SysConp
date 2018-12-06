/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEmissaoAtestadoReclusao;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.EmissaoAtestadoReclusao;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloCRC.codAbrirCRC;
import static gestor.Visao.TelaModuloCRC.codAlterarCRC;
import static gestor.Visao.TelaModuloCRC.codConsultarCRC;
import static gestor.Visao.TelaModuloCRC.codExcluirCRC;
import static gestor.Visao.TelaModuloCRC.codGravarCRC;
import static gestor.Visao.TelaModuloCRC.codIncluirCRC;
import static gestor.Visao.TelaModuloCRC.codUserAcessoCRC;
import static gestor.Visao.TelaModuloCRC.codigoGrupoCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserGroupCRC;
import static gestor.Visao.TelaModuloCRC.impressaoAtestadoCRC;
import static gestor.Visao.TelaModuloCRC.liberacaoAtestadoCRC;
import static gestor.Visao.TelaModuloCRC.nomeGrupoCRC;
import static gestor.Visao.TelaModuloCRC.nomeTelaCRC;
import static gestor.Visao.TelaModuloCRC.telaEmissaoAtestadoReclusao;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronal
 */
public class TelaEmissaoAtestadoReclusao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmissaoAtestadoReclusao objEmissao = new EmissaoAtestadoReclusao();
    ControleEmissaoAtestadoReclusao control = new ControleEmissaoAtestadoReclusao();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Atestado de Reclusão:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    public static int acao;
    int flag;
    int count = 0;
    String dataInicial;
    String dataFinal;
    String dataAtestado;
    String caminho;
    String camFotoVisita;
    String utilizacao = "Sim";
    public static String textoAtestadoReclusao = "";
    public static byte[] pAssinaturaLiberador = null;
    public static int codigoSoliAtestado = 0;
    //
    public static int codigoLiberador = 0;
    public static Date dataLiberacao = null;
    public static String dataAssinatura;
    public static String horaAssinatura;
    public static String nomeLiberador;
    public static byte[] pDigitalCapturadaColaborador;
    public static String pLiberacaoImpressa;
    // CHAVES PARA CRIPTOGRAFIA
    public static byte[] codigoValidador;
    byte[] chaveInterno;
    String validadorInterno;
    String chaveHexadecinal;
    // DADOS PARA IMPRESSÃO DO ATESTADO
    byte[] assinaturaColaboradorPesq;
    byte[] chaveValidadorInternoPesq;
    byte[] chaveValidadorColaboradorPesq;
    String chaveValidacaoRelatorio;
    /**
     * Creates new form TelaEmissaoAtestadoReclusao
     */
    public static TelaTextoAtestadoReclusao textoAtestado;
    public static TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao liberador;

    public TelaEmissaoAtestadoReclusao() {
        initComponents();
        corCampos();
    }

    public void mostrarTexto() {
        textoAtestado = new TelaTextoAtestadoReclusao(this, true);
        textoAtestado.setVisible(true);
    }

    public void mostrarLiberador() {
        liberador = new TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao(this, true);
        liberador.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jIDPesqRol = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jBtPesqIDRol = new javax.swing.JButton();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jNomeVisitaInterna = new javax.swing.JTextField();
        jBtPesqNomeVisitaInterna = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaSolicitacaoAtestaReclusao = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIdAtestado = new javax.swing.JTextField();
        jStatusAtestado = new javax.swing.JTextField();
        jComboBoxClassAtestado = new javax.swing.JComboBox<>();
        jDataAtestado = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jIdVisitaAtestado = new javax.swing.JTextField();
        jParentescoAtestado = new javax.swing.JTextField();
        jNomeSolicitanteAtestado = new javax.swing.JTextField();
        jBtBuscarDadosVI = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jIdInternoAtestado = new javax.swing.JTextField();
        jCncAtestado = new javax.swing.JTextField();
        jNomeInternoAtestado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMaeInternoAtestado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDatEntradaAtestado = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jRegimePenalAux = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtAtestado = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtLiberar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Emissao de Atestado de Reclusão :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_word.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código:");

        jIDPesqRol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jBtPesqIDRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqIDRol.setContentAreaFilled(false);
        jBtPesqIDRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDRolActionPerformed(evt);
            }
        });

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nome Interno:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jNomeVisitaInterna.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeVisitaInterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeVisitaInterna.setContentAreaFilled(false);
        jBtPesqNomeVisitaInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeVisitaInternaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Nome Visita Int:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jIDPesqRol, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqIDRol, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jNomeVisitaInterna, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jPesqNomeInterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqNomeVisitaInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jIDPesqRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqIDRol)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeVisitaInterna)
                    .addComponent(jNomeVisitaInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap())
        );

        jTabelaSolicitacaoAtestaReclusao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSolicitacaoAtestaReclusao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Nome do Interno", "Nome da Visita"
            }
        ));
        jTabelaSolicitacaoAtestaReclusao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaSolicitacaoAtestaReclusaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaSolicitacaoAtestaReclusao);
        if (jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumnCount() > 0) {
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(2).setMinWidth(320);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(2).setMaxWidth(320);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(3).setMinWidth(320);
            jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(3).setMaxWidth(320);
        }

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Classificação");

        jIdAtestado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAtestado.setEnabled(false);

        jStatusAtestado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAtestado.setForeground(new java.awt.Color(204, 0, 0));
        jStatusAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAtestado.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusAtestado.setEnabled(false);

        jComboBoxClassAtestado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxClassAtestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Não Liberado", "Liberado" }));
        jComboBoxClassAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxClassAtestado.setEnabled(false);

        jDataAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtestado.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStatusAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxClassAtestado, 0, 154, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxClassAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados do Solicitante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Parentesco");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome do Solicitante");

        jIdVisitaAtestado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdVisitaAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdVisitaAtestado.setEnabled(false);

        jParentescoAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParentescoAtestado.setEnabled(false);

        jNomeSolicitanteAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeSolicitanteAtestado.setEnabled(false);

        jBtBuscarDadosVI.setForeground(new java.awt.Color(204, 0, 0));
        jBtBuscarDadosVI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Copy-16x16.png"))); // NOI18N
        jBtBuscarDadosVI.setText("Buscar Dados");
        jBtBuscarDadosVI.setEnabled(false);
        jBtBuscarDadosVI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarDadosVIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jIdVisitaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jParentescoAtestado, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtBuscarDadosVI, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jNomeSolicitanteAtestado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jParentescoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdVisitaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBuscarDadosVI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeSolicitanteAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jIdInternoAtestado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAtestado.setEnabled(false);

        jCncAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCncAtestado.setEnabled(false);

        jNomeInternoAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAtestado.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("CNC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome do Interno");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome da Mãe do Interno");

        jMaeInternoAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaeInternoAtestado.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Entrada");

        jDatEntradaAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDatEntradaAtestado.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Regime Penal");

        jRegimePenalAux.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimePenalAux.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoAtestado)
                    .addComponent(jMaeInternoAtestado)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCncAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRegimePenalAux, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jDatEntradaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdInternoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCncAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRegimePenalAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDatEntradaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMaeInternoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSair)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoria)))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtFinalizar.setForeground(new java.awt.Color(51, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar Atestado");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAtestado.setForeground(new java.awt.Color(0, 0, 204));
        jBtAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_word.png"))); // NOI18N
        jBtAtestado.setText("Atestado");
        jBtAtestado.setToolTipText("Redigir Atestado");
        jBtAtestado.setEnabled(false);
        jBtAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtestadoActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.setToolTipText("Imprimir Atestado de Reclusão");
        jBtImpressao.setEnabled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jBtLiberar.setForeground(new java.awt.Color(204, 0, 0));
        jBtLiberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtLiberar.setText("Liberar");
        jBtLiberar.setToolTipText("Liberar com Biometria");
        jBtLiberar.setEnabled(false);
        jBtLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLiberarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAtestado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtestado, jBtFinalizar, jBtImpressao, jBtLiberar});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAtestado)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtLiberar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel5, jPanel6, jPanel7});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Movimentação", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 20, 529, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data incial.");
            jDataPesqInicial.requestFocus();
            jDataPesqInicial.setBackground(Color.red);
        } else {
            if (jDataPesqFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final.");
                jDataPesqFinal.requestFocus();
                jDataPesqFinal.setBackground(Color.red);
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Final não pode ser menor que a data inicial.");
                    jDataPesqFinal.requestFocus();
                    jDataPesqFinal.setBackground(Color.red);
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                    preencherTodosAtestados("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON EMISSAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE DataRegAux BETWEEN'" + dataInicial + "' "
                            + "AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDRolActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqRol.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
            jIDPesqRol.requestFocus();
        } else {
            preencherTodosAtestados("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE IdAtestado='" + jIDPesqRol.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDRolActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa");
            jPesqNomeInterno.requestFocus();
        } else {
            preencherTodosAtestados("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosAtestados("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON EMISSAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita");
        } else {
            jtotalRegistros.setText("");
            limparTabelaAtestado();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqNomeVisitaInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeVisitaInternaActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNomeVisitaInterna.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita para pesquisa");
            jNomeVisitaInterna.requestFocus();
        } else {
            preencherTodosAtestados("SELECT * FROM SOLICITACAO_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SOLICITACAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON SOLICITACAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE VISITASINTERNO.NomeVisita LIKE'%" + jNomeVisitaInterna.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeVisitaInternaActionPerformed

    private void jTabelaSolicitacaoAtestaReclusaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaSolicitacaoAtestaReclusaoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idRol = "" + jTabelaSolicitacaoAtestaReclusao.getValueAt(jTabelaSolicitacaoAtestaReclusao.getSelectedRow(), 0);
            jIDPesqRol.setText(idRol);
            //
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAtestado.setEnabled(true);
            jBtImpressao.setEnabled(true);
            // PARA NÃO DEIXAR ALTERAR O TEXTO DO ATESTADO SEM ANTES ACIONAR O BOTÃO NOVO OU ALTERAR
            acao = 0;
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON DADOSPENAISINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON EMISSAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE IdAtestado='" + idRol + "'");
                conecta.rs.first();
                jIdAtestado.setText(String.valueOf(conecta.rs.getInt("IdAtestado")));
                codigoSoliAtestado = conecta.rs.getInt("CodRegAux");
                jStatusAtestado.setText(conecta.rs.getString("StatusAtestado"));
                jDataAtestado.setDate(conecta.rs.getDate("DataAtestado"));
                jComboBoxClassAtestado.setSelectedItem(conecta.rs.getString("ClassAtestado"));
                jIdVisitaAtestado.setText(conecta.rs.getString("IdVisita"));
                jParentescoAtestado.setText(conecta.rs.getString("ParentescoVisita"));
                jNomeSolicitanteAtestado.setText(conecta.rs.getString("NomeVisita"));
                jIdInternoAtestado.setText(conecta.rs.getString("IdInternoCrc"));
                jCncAtestado.setText(conecta.rs.getString("Cnc"));
                jRegimePenalAux.setText(conecta.rs.getString("Regime"));
                jDatEntradaAtestado.setDate(conecta.rs.getDate("DataEntrada"));
                jNomeInternoAtestado.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInternoAtestado.setText(conecta.rs.getString("MaeInternoCrc"));
                textoAtestadoReclusao = conecta.rs.getString("TextoAtestado");
                dataAssinatura = conecta.rs.getString("DataAssinatura");
                horaAssinatura = conecta.rs.getString("HoraAssinatura");
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
        }
    }//GEN-LAST:event_jTabelaSolicitacaoAtestaReclusaoMouseClicked

    private void jBtBuscarDadosVIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarDadosVIActionPerformed
        // TODO add your handling code here:TelaPesqVisitasInternoSoliAtestado
        TelaPesqVisitasInternoSoliAtestado objPesqAtestaRec = new TelaPesqVisitasInternoSoliAtestado();
        TelaModuloCRC.jPainelCRC.add(objPesqAtestaRec);
        objPesqAtestaRec.show();
    }//GEN-LAST:event_jBtBuscarDadosVIActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmissaoAtestadoReclusao);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEmissaoAtestadoReclusao) && codIncluirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            acao = 1;
            limparCampos();
            bloquearBotoes();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmissaoAtestadoReclusao);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEmissaoAtestadoReclusao) && codAlterarCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            verificarValidadores();
            objEmissao.setStatusAtestado(jStatusAtestado.getText());
            if (jStatusAtestado.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else if (chaveValidadorColaboradorPesq != null) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo já foi liberado.");
            } else {
                acao = 2;
                bloquearBotoes();
                Alterar();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmissaoAtestadoReclusao);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEmissaoAtestadoReclusao) && codExcluirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            verificarValidadores();
            objEmissao.setStatusAtestado(jStatusAtestado.getText());
            if (jStatusAtestado.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else if (chaveValidadorColaboradorPesq != null) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo já foi liberado.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // ATUALIZAR A TABELA SOLICITACAO_ATESTADO-RECLUSAO
                    utilizacao = "Não";
                    objEmissao.setCodRegAux(codigoSoliAtestado);
                    objEmissao.setUtilizadoCrc(utilizacao);
                    control.confirmarEmissaoAtestadoReclusao(objEmissao);
                    //
                    objEmissao.setIdAtestado(Integer.valueOf(jIdAtestado.getText()));
                    control.excluirEmissaoAtestadoReclusao(objEmissao);
                    bloquearBotoes();
                    limparCampos();
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmissaoAtestadoReclusao);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEmissaoAtestadoReclusao) && codGravarCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            if (jComboBoxClassAtestado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de classificação.");
            } else if (jDataAtestado.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "A data do Atestado não pode ser em branco.");
            } else if (jIdVisitaAtestado.getText().equals("") || jNomeSolicitanteAtestado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o solicitante.");
            } else if (jIdInternoAtestado.getText().equals("") || jNomeInternoAtestado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe para qual interno é o atestado de reclusão.");
            } else if (textoAtestadoReclusao.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o texto do atestado de reclusão.");
            } else if (jRegimePenalAux.getText().equals("Provisório")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível emitir esse atestado, o regime do interno é PROVISÓRIO.");
            } else {
                objEmissao.setStatusAtestado(jStatusAtestado.getText());
                objEmissao.setClassAtestado((String) jComboBoxClassAtestado.getSelectedItem());
                objEmissao.setDataAtestado(jDataAtestado.getDate());
                objEmissao.setIdVisitaAtestado(Integer.valueOf(jIdVisitaAtestado.getText()));
                objEmissao.setNomeSolicitanteAtestado(jNomeSolicitanteAtestado.getText());
                objEmissao.setIdInternoAtestado(Integer.valueOf(jIdInternoAtestado.getText()));
                objEmissao.setNomeInternoAtestado(jNomeInternoAtestado.getText());
                objEmissao.setCodRegAux(codigoSoliAtestado);
                objEmissao.setTextoAtestado(textoAtestadoReclusao);
                objEmissao.setAssinaturaColaborador(pDigitalCapturadaColaborador);
                objEmissao.setDataAssinatura(dataAssinatura);
                objEmissao.setHorarioLiberacao(horaAssinatura);
                objEmissao.setValidadorDados(codigoValidador);
                if (acao == 1) {
                    objEmissao.setUsuarioInsert(nameUser);
                    objEmissao.setDataInsert(jDataSistema.getText());
                    objEmissao.setHorarioInsert(jHoraSistema.getText());
                    control.incluirEmissaoAtestadoReclusao(objEmissao);
                    buscarCodigo();
                    // ATUALIZAR A TABELA SOLICITACAO_ATESTADO-RECLUSAO
                    objEmissao.setCodRegAux(codigoSoliAtestado);
                    objEmissao.setUtilizadoCrc(utilizacao);
                    control.confirmarEmissaoAtestadoReclusao(objEmissao);
                    //CONVERTE A DATA EM STRING PARA SER CRIPTOGRAFADA.
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataAtestado.getDate().getTime());
                    // CRIPTOGRAFAR OS DADOS DO DOCUMENTO, CODIGO DO INTERNO E O NOME DO INTERNO
                    // UTILIZA O ID DO REGISTRO, A DATA DO REGISTRO, O ID DO INTERNO, O NOME DO INTERNO E O ID DO SOLICITANTE.
                    // CRIPTOGRAFIA MD5
                    criptografiaMD5(jIdAtestado.getText(), dataInicial, jIdVisitaAtestado.getText(), jIdInternoAtestado.getText(), jNomeInternoAtestado.getText());
                    objEmissao.setChaveInterno(chaveInterno);
                    objEmissao.setIdAtestado(Integer.valueOf(jIdAtestado.getText()));
                    control.gravarCriptografiaEmissaoAtestadoReclusao(objEmissao);
                    //                    
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objEmissao.setUsuarioUp(nameUser);
                    objEmissao.setDataUp(jDataSistema.getText());
                    objEmissao.setHorarioUp(jHoraSistema.getText());
                    //CRIPTOGRAFAR OS DADOS DO DOCUMENTO E O NOME DO INTERNO
                    criptografarDadosInternoSimetrico(jIdAtestado.getText(), dataInicial, jIdInternoAtestado.getText(), jNomeInternoAtestado.getText(), jIdVisitaAtestado.getText());
                    objEmissao.setChaveInterno(chaveInterno);
                    //
                    objEmissao.setIdAtestado(Integer.valueOf(jIdAtestado.getText()));
                    control.alterarEmissaoAtestadoReclusao(objEmissao);
                    // ATUALIZAR A TABELA SOLICITACAO_ATESTADO-RECLUSAO
                    objEmissao.setCodRegAux(codigoSoliAtestado);
                    objEmissao.setUtilizadoCrc(utilizacao);
                    control.confirmarEmissaoAtestadoReclusao(objEmissao);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar o registro.");
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
        TelaAuditoriaEmissaoAtestadoRec objAudiEA = new TelaAuditoriaEmissaoAtestadoRec();
        TelaModuloCRC.jPainelCRC.add(objAudiEA);
        objAudiEA.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        if (jStatusAtestado.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Esse Registro já encontra-se FINALIZADO");
        } else {
            statusMov = "Finalizou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEmissao.setIdAtestado(Integer.parseInt(jIdAtestado.getText()));
            String statusSoli = "FINALIZADO";
            objEmissao.setStatusAtestado(statusSoli);
            control.finalizarEmissaoAtestadoReclusao(objEmissao);
            jStatusAtestado.setText(statusSoli);
            //
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                        
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(liberacaoAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(liberacaoAtestadoCRC) && codAbrirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            if (textoAtestadoReclusao.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "O texto do atestado de reclusão está vazio, preencher o atestado de reclusão antes de liberar.");
            } else {
                mostrarLiberador();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a liberar o registro.");
        }
    }//GEN-LAST:event_jBtLiberarActionPerformed

    private void jBtAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtestadoActionPerformed
        // TODO add your handling code here:
        if (jIdVisitaAtestado.getText().equals("")
                || jNomeSolicitanteAtestado.getText().equals("")
                || jIdInternoAtestado.getText().equals("")
                || jNomeInternoAtestado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar o solicitante e o interno para poder preencher o atestado de reclusão.");
        } else {
            mostrarTexto();
        }
    }//GEN-LAST:event_jBtAtestadoActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(impressaoAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(impressaoAtestadoCRC) && codAbrirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            verificarValidadores();
            if (jIdAtestado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não existe registro a ser impresso.");
            } else if (textoAtestadoReclusao.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "O texto do Atestado de Reclusão está vazio, é necessário preencher o documento.");
            } else if (assinaturaColaboradorPesq == null) {
                JOptionPane.showMessageDialog(rootPane, "O colaborador ainda não liberou para impressão o atestado, é necessário assinar através da biometria.");
            } else if (chaveValidadorInternoPesq == null) {
                JOptionPane.showMessageDialog(rootPane, "A chave de validação do interno ainda não foi gerado, essa chave necessário para validar o atestado.");
            } else if (chaveValidadorColaboradorPesq == null) {
                JOptionPane.showMessageDialog(rootPane, "A chave de validação do colaborador ainda não foi gerado, essa chave faz parte da validação do registro.");
            } else {
                try {
                    conecta.abrirConexao();
                    String path = "reports/RelatorioAtestadoReclusaoCRC.jasper";
                    conecta.executaSQL("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON EMISSAO_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON DADOSPENAISINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON EMISSAO_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE EMISSAO_ATESTADO_RECLUSAO.IdAtestado='" + jIdAtestado.getText() + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("idRegistro", jIdAtestado.getText());
                    parametros.put("nomeUsuario", nameUser);
                    parametros.put("nomeUnidade", descricaoUnidade);
                    parametros.put("chaveValidacaoInterno", chaveValidacaoRelatorio);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Atestado de Reclusão Carcerária");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado             
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a impressão do registro.");
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAtestado;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtBuscarDadosVI;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtLiberar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqIDRol;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesqNomeVisitaInterna;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCncAtestado;
    public static javax.swing.JComboBox<String> jComboBoxClassAtestado;
    public static com.toedter.calendar.JDateChooser jDatEntradaAtestado;
    private com.toedter.calendar.JDateChooser jDataAtestado;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JTextField jIDPesqRol;
    public static javax.swing.JTextField jIdAtestado;
    public static javax.swing.JTextField jIdInternoAtestado;
    public static javax.swing.JTextField jIdVisitaAtestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMaeInternoAtestado;
    public static javax.swing.JTextField jNomeInternoAtestado;
    public static javax.swing.JTextField jNomeSolicitanteAtestado;
    private javax.swing.JTextField jNomeVisitaInterna;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JTextField jParentescoAtestado;
    private javax.swing.JTextField jPesqNomeInterno;
    public static javax.swing.JTextField jRegimePenalAux;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusAtestado;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaSolicitacaoAtestaReclusao;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdAtestado.setBackground(Color.white);
        jStatusAtestado.setBackground(Color.white);
        jComboBoxClassAtestado.setBackground(Color.white);
        jDataAtestado.setBackground(Color.white);
        jIdVisitaAtestado.setBackground(Color.white);
        jParentescoAtestado.setBackground(Color.white);
        jNomeSolicitanteAtestado.setBackground(Color.white);
        jIdInternoAtestado.setBackground(Color.white);
        jCncAtestado.setBackground(Color.white);
        jRegimePenalAux.setBackground(Color.white);
        jDatEntradaAtestado.setBackground(Color.white);
        jNomeInternoAtestado.setBackground(Color.white);
        jMaeInternoAtestado.setBackground(Color.white);
    }

    public void bloquearCampos() {
        jIdAtestado.setEnabled(!true);
        jStatusAtestado.setEnabled(!true);
        jComboBoxClassAtestado.setEnabled(!true);
        jDataAtestado.setEnabled(!true);
        jParentescoAtestado.setEnabled(!true);
        jIdVisitaAtestado.setEnabled(!true);
        jParentescoAtestado.setEnabled(!true);
        jNomeSolicitanteAtestado.setEnabled(!true);
        jIdInternoAtestado.setEnabled(!true);
        jCncAtestado.setEnabled(!true);
        jDatEntradaAtestado.setEnabled(!true);
        jNomeInternoAtestado.setEnabled(!true);
        jMaeInternoAtestado.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAtestado.setEnabled(!true);
        jBtLiberar.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtBuscarDadosVI.setEnabled(!true);
    }

    public void limparCampos() {
        jIdAtestado.setText("");
        jStatusAtestado.setText("");
        jComboBoxClassAtestado.setSelectedItem(null);
        jDataAtestado.setDate(null);
        jIdVisitaAtestado.setText("");
        jParentescoAtestado.setText("");
        jNomeSolicitanteAtestado.setText("");
        jIdInternoAtestado.setText("");
        jCncAtestado.setText("");
        jRegimePenalAux.setText("");
        jDatEntradaAtestado.setDate(null);
        jNomeInternoAtestado.setText("");
        jMaeInternoAtestado.setText("");
    }

    public void Novo() {
        jStatusAtestado.setText("ABERTO");
        jComboBoxClassAtestado.setSelectedItem("Selecione...");
        jDataAtestado.setCalendar(Calendar.getInstance());
        //
        jComboBoxClassAtestado.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtBuscarDadosVI.setEnabled(true);
        jBtLiberar.setEnabled(true);
        jBtAtestado.setEnabled(true);
    }

    public void Alterar() {
        jComboBoxClassAtestado.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtBuscarDadosVI.setEnabled(true);
        jBtAtestado.setEnabled(true);
        jBtLiberar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtLiberar.setEnabled(true);
        jBtAtestado.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdAtestado.getText().equals("")) {
            bloquearCampos();
            bloquearBotoes();
            limparCampos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtLiberar.setEnabled(true);
            jBtAtestado.setEnabled(true);
            jBtImpressao.setEnabled(true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO");
            conecta.rs.last();
            jIdAtestado.setText(String.valueOf(conecta.rs.getInt("IdAtestado")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar registro. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarValidadores() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMISSAO_ATESTADO_RECLUSAO WHERE IdAtestado='" + jIdAtestado.getText() + "'");
            conecta.rs.first();
            assinaturaColaboradorPesq = conecta.rs.getBytes("AssinaturaColaborador");
            chaveValidadorColaboradorPesq = conecta.rs.getBytes("CodigoValidador");
            chaveValidadorInternoPesq = conecta.rs.getBytes("ChaveInterno");
            chaveValidacaoRelatorio = conecta.rs.getString("ChaveInterno");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar registro. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void preencherTodosAtestados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome do Interno", "Nome da Visita"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataAtestado = conecta.rs.getString("DataAtestado");
                String dia = dataAtestado.substring(8, 10);
                String mes = dataAtestado.substring(5, 7);
                String ano = dataAtestado.substring(0, 4);
                dataAtestado = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAtestado"), dataAtestado, conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("NomeVisita")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSolicitacaoAtestaReclusao.setModel(modelo);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(2).setPreferredWidth(320);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(3).setPreferredWidth(320);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getTableHeader().setReorderingAllowed(false);
        jTabelaSolicitacaoAtestaReclusao.setAutoResizeMode(jTabelaSolicitacaoAtestaReclusao.AUTO_RESIZE_OFF);
        jTabelaSolicitacaoAtestaReclusao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharColunasTabelaAtestado();
        conecta.desconecta();
    }

    public void limparTabelaAtestado() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome do Interno", "Nome da Visita"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSolicitacaoAtestaReclusao.setModel(modelo);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(2).setPreferredWidth(320);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(3).setPreferredWidth(320);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSolicitacaoAtestaReclusao.getTableHeader().setReorderingAllowed(false);
        jTabelaSolicitacaoAtestaReclusao.setAutoResizeMode(jTabelaSolicitacaoAtestaReclusao.AUTO_RESIZE_OFF);
        jTabelaSolicitacaoAtestaReclusao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharColunasTabelaAtestado() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaSolicitacaoAtestaReclusao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    // CRIPTOGRAFIA SIMETRICA
    public void criptografarDadosInternoSimetrico(String idRegistro, String dataRegistro, String idInterno, String nomeInterno, String idVisita) {
        validadorInterno = idRegistro + dataRegistro + idInterno + nomeInterno + idVisita;
        // CRIPTOGRAFIA SIMETRICA: AES,RC2,RC4,RC5, IDEA, Blowfish
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secrecKey = keyGenerator.generateKey();
            Cipher cipher;
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secrecKey);
            byte[] criptografia = cipher.doFinal(validadorInterno.getBytes());
            chaveInterno = criptografia;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(TelaAssinaturaoBiometriaColaboradoresAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(TelaEmissaoAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TelaEmissaoAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAtestado.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserCRC = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserCRC + "'");
            conecta.rs.first();
            codigoUserGroupCRC = conecta.rs.getInt("IdUsuario");
            codigoGrupoCRC = conecta.rs.getInt("IdGrupo");
            nomeGrupoCRC = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserCRC + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoCRC = conecta.rs.getInt("IdUsuario");
            codAbrirCRC = conecta.rs.getInt("Abrir");
            codIncluirCRC = conecta.rs.getInt("Incluir");
            codAlterarCRC = conecta.rs.getInt("Alterar");
            codExcluirCRC = conecta.rs.getInt("Excluir");
            codGravarCRC = conecta.rs.getInt("Gravar");
            codConsultarCRC = conecta.rs.getInt("Consultar");
            nomeTelaCRC = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
