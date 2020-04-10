/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEmissaoRevaAtestadoReclusao;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
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
import static gestor.Visao.TelaModuloCRC.nomeGrupoCRC;
import static gestor.Visao.TelaModuloCRC.nomeTelaCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import gestor.Modelo.EmissaoAtestadoReclusao;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaModuloCRC.impressaoRevalidarAtCRC;
import static gestor.Visao.TelaModuloCRC.liberacaoRevAtestadoCRC;
import static gestor.Visao.TelaModuloCRC.revalidarAtestadoCRC;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
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
public class TelaRevalidacaoAtestadoReclusao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmissaoAtestadoReclusao objEmissao = new EmissaoAtestadoReclusao();
    ControleEmissaoRevaAtestadoReclusao control = new ControleEmissaoRevaAtestadoReclusao();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Revalidação de Atestado de Reclusão:Manutenção";
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
    // FICHA JURÍDICA
    public static String codProc;
    public static String codProdDoc;
    public static String codIncPen;
    String dataFicha, dataAmparo, dataDoc, dataInicioProcesso, dataTerminoProcesso;
    public static String codigoFichaJuridica;
    public static String codigoInterno;
    String codIntPenal;

    /**
     * Creates new form TelaRevalidacaoAtestadoReclusao
     */
    public static TelaTextoRevalidaAtestadoReclusao revalidaAtesta;
    public static TelaAssinaturaoBiometriaColaboradoresRevalidaAtestadoReclusao revalidaCola;

    public TelaRevalidacaoAtestadoReclusao() {
        initComponents();
        corCampos();
    }

    public void mostrarTexto() {
        revalidaAtesta = new TelaTextoRevalidaAtestadoReclusao(this, true);
        revalidaAtesta.setVisible(true);
    }

    public void mostrarLiberador() {
        revalidaCola = new TelaAssinaturaoBiometriaColaboradoresRevalidaAtestadoReclusao(this, true);
        revalidaCola.setVisible(true);
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
        jLabel15 = new javax.swing.JLabel();
        jDataValidade = new com.toedter.calendar.JDateChooser();
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
        jPanel7 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtAtestado = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtLiberar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jNumeroProcesso = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jNumeroInquerito = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jComboBoxRegimeProcesso = new javax.swing.JComboBox();
        jDataInicioProcesso = new com.toedter.calendar.JDateChooser();
        jTotalDias = new javax.swing.JTextField();
        jMeses = new javax.swing.JTextField();
        jDias = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jAnos = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jDataTerminoProcesso = new com.toedter.calendar.JDateChooser();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jComboBoxSentenca = new javax.swing.JComboBox();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jComboBoxTipoSentencaCondenatoria = new javax.swing.JComboBox();
        jComboBoxSituacaoPresoProcesso = new javax.swing.JComboBox();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jObservacaoProcesso = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaProcesso = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel45 = new javax.swing.JPanel();
        jDescricaoAmparoLegal = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jIdAmparo = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jComboBoxAlinea = new javax.swing.JTextField();
        jComboBoxArtigo = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        jComboBoxParagrafo = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        jComboBoxInciso = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaAmparoLegal = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jIdNatp = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        jDescricaoNaturezaPrisao = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        jDocumentoPrisao = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        jDataDocumentoPrisao = new com.toedter.calendar.JDateChooser();
        jHoraDocumento = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaDocumentosProcesso = new javax.swing.JTable();
        jOrigemDocumentoPrisao = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Revalidação de Atestado Reclusão :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/document-preview-icone-7988-16.png")), jPanel1); // NOI18N

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
                    .addComponent(jComboBoxClassAtestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados do Solicitante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

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

        jBtBuscarDadosVI.setForeground(new java.awt.Color(0, 102, 0));
        jBtBuscarDadosVI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Copy-16x16.png"))); // NOI18N
        jBtBuscarDadosVI.setText("Buscar Dados");
        jBtBuscarDadosVI.setEnabled(false);
        jBtBuscarDadosVI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarDadosVIActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Valid. Atestado");

        jDataValidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataValidade.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeSolicitanteAtestado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdVisitaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jParentescoAtestado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtBuscarDadosVI, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdVisitaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jParentescoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBuscarDadosVI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeSolicitanteAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

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
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jRegimePenalAux))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(0, 11, Short.MAX_VALUE))
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

        jButton1.setForeground(new java.awt.Color(153, 0, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jButton1.setText("Validar");
        jButton1.setToolTipText("Verificar Validade do Atestado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLiberar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAtestado)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtLiberar)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Manutenção", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/290718163923_16.png")), jPanel2); // NOI18N

        jTabbedPane4.setForeground(new java.awt.Color(204, 0, 0));
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jNumeroProcesso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroProcesso.setEnabled(false);

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel164.setText("Nº. do Processo");

        jNumeroInquerito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroInquerito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNumeroInquerito.setEnabled(false);

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel165.setText("Regime do Processo");

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel166.setText("Nº.  do Inquérito");

        jComboBoxRegimeProcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegimeProcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Fechado", "Semi-Aberto", "Aberto", "Provisório" }));
        jComboBoxRegimeProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegimeProcesso.setEnabled(false);

        jDataInicioProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataInicioProcesso.setEnabled(false);

        jTotalDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotalDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotalDias.setEnabled(false);

        jMeses.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMeses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMeses.setEnabled(false);

        jDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDias.setEnabled(false);

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel167.setText("Total de Dias");

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel168.setText("Meses");

        jAnos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAnos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAnos.setEnabled(false);

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel169.setText("Anos");

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel170.setText("Data Inicio");

        jDataTerminoProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerminoProcesso.setEnabled(false);

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel171.setText("Data Término");

        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel172.setText("Dias");

        jLabel173.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel173.setText("Sentença");

        jComboBoxSentenca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSentenca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Terminativa", "Definitva", "Sem sentença", " ", " " }));
        jComboBoxSentenca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSentenca.setEnabled(false);

        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel174.setText("Tipo Sentença Condenatória");

        jLabel175.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel175.setText("Situ. Preso Processo");

        jComboBoxTipoSentencaCondenatoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoSentencaCondenatoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Mérito", "Execução", "Provisória", "Definitiva" }));
        jComboBoxTipoSentencaCondenatoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoSentencaCondenatoria.setEnabled(false);

        jComboBoxSituacaoPresoProcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSituacaoPresoProcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Recluso", "Liberdade Provisória", " ", " " }));
        jComboBoxSituacaoPresoProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSituacaoPresoProcesso.setEnabled(false);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel173, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNumeroProcesso, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSentenca, javax.swing.GroupLayout.Alignment.LEADING, 0, 141, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel174)
                            .addComponent(jNumeroInquerito)
                            .addComponent(jComboBoxTipoSentencaCondenatoria, 0, 197, Short.MAX_VALUE)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel164)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel166))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jAnos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel169)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168)
                            .addComponent(jMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel170)
                                .addGap(30, 30, 30))
                            .addComponent(jDataInicioProcesso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataTerminoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel171))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel165)
                    .addComponent(jTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel175)
                    .addComponent(jLabel167)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBoxSituacaoPresoProcesso, 0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBoxRegimeProcesso, 0, 130, Short.MAX_VALUE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxRegimeProcesso, jComboBoxSituacaoPresoProcesso, jTotalDias});

        jPanel43Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxSentenca, jNumeroProcesso});

        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jLabel164)
                    .addComponent(jLabel166))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumeroInquerito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRegimeProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel173)
                    .addComponent(jLabel174)
                    .addComponent(jLabel175))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxSentenca, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoSentencaCondenatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSituacaoPresoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel168)
                    .addComponent(jLabel169)
                    .addComponent(jLabel172)
                    .addComponent(jLabel170)
                    .addComponent(jLabel171)
                    .addComponent(jLabel167))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataInicioProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataTerminoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Processos", jPanel43);

        jObservacaoProcesso.setColumns(20);
        jObservacaoProcesso.setRows(5);
        jObservacaoProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoProcesso.setEnabled(false);
        jScrollPane4.setViewportView(jObservacaoProcesso);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Observação do Processo", jPanel44);

        jTabelaProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nr. Processo", "Nr. Inquérito", "Regime", "Anos", "Meses", "Dias", "Data Inicio", "Data Témino"
            }
        ));
        jTabelaProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProcessoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaProcesso);
        if (jTabelaProcesso.getColumnModel().getColumnCount() > 0) {
            jTabelaProcesso.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaProcesso.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaProcesso.getColumnModel().getColumn(1).setMinWidth(200);
            jTabelaProcesso.getColumnModel().getColumn(1).setMaxWidth(200);
            jTabelaProcesso.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaProcesso.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaProcesso.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(4).setMinWidth(60);
            jTabelaProcesso.getColumnModel().getColumn(4).setMaxWidth(60);
            jTabelaProcesso.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(5).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(6).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(6).setMaxWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(7).setMinWidth(70);
            jTabelaProcesso.getColumnModel().getColumn(8).setMinWidth(80);
            jTabelaProcesso.getColumnModel().getColumn(8).setMaxWidth(80);
        }

        jTabbedPane5.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jDescricaoAmparoLegal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoAmparoLegal.setEnabled(false);

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel185.setText("Código");

        jIdAmparo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAmparo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAmparo.setEnabled(false);

        jLabel181.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel181.setText("Artigo");

        jLabel180.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel180.setText("Amparo Legal");

        jLabel184.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel184.setText("Alínea");

        jComboBoxAlinea.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxAlinea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlinea.setEnabled(false);

        jComboBoxArtigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxArtigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxArtigo.setEnabled(false);

        jLabel182.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel182.setText("Parágrafo");

        jComboBoxParagrafo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxParagrafo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParagrafo.setEnabled(false);

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel183.setText("Inciso");

        jComboBoxInciso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jComboBoxInciso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxInciso.setEnabled(false);

        jTabelaAmparoLegal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAmparoLegal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Amparo legal", "Artigo", "Parágrafo", "Inciso", "Alínea"
            }
        ));
        jTabelaAmparoLegal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAmparoLegalMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaAmparoLegal);
        if (jTabelaAmparoLegal.getColumnModel().getColumnCount() > 0) {
            jTabelaAmparoLegal.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaAmparoLegal.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaAmparoLegal.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaAmparoLegal.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaAmparoLegal.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaAmparoLegal.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaAmparoLegal.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(5).setMinWidth(50);
            jTabelaAmparoLegal.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel185, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jIdAmparo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addComponent(jLabel180)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDescricaoAmparoLegal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel181)
                            .addComponent(jComboBoxArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxParagrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel183, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxInciso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel184, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxAlinea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel185)
                            .addComponent(jLabel180)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183)
                            .addComponent(jLabel184)
                            .addComponent(jLabel181)
                            .addComponent(jLabel182))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdAmparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoAmparoLegal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxParagrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxInciso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAlinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Incidência Penal", jPanel45);

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel186.setText("Código");

        jIdNatp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdNatp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdNatp.setEnabled(false);

        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel187.setText("Natureza da Prisão");

        jDescricaoNaturezaPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoNaturezaPrisao.setEnabled(false);

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel188.setText("Documento");

        jDocumentoPrisao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumentoPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumentoPrisao.setEnabled(false);

        jLabel190.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel190.setText("Data Doc.");

        jDataDocumentoPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataDocumentoPrisao.setEnabled(false);

        jHoraDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraDocumento.setEnabled(false);

        jLabel191.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel191.setText("Hora Doc.");

        jTabelaDocumentosProcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaDocumentosProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Natureza da Prisão", "Documento", "Origem", "Data", "Horário"
            }
        ));
        jTabelaDocumentosProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaDocumentosProcessoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaDocumentosProcesso);
        if (jTabelaDocumentosProcesso.getColumnModel().getColumnCount() > 0) {
            jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setMaxWidth(300);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        jOrigemDocumentoPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrigemDocumentoPrisao.setEnabled(false);

        jLabel189.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel189.setText("Origem do Documento");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel186, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jIdNatp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel187)
                            .addComponent(jDescricaoNaturezaPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel188)
                            .addComponent(jDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel191)
                            .addComponent(jHoraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel189)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jOrigemDocumentoPrisao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel191)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel186)
                                    .addComponent(jLabel187)))
                            .addComponent(jLabel188, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel190, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdNatp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoNaturezaPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel189)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOrigemDocumentoPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Documentos do Processo", jPanel46);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(117, 117, 117))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTabbedPane4, jTabbedPane5});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5))
        );

        jTabbedPane1.addTab("Ficha Jurídica", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png")), jPanel8); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setBounds(300, 30, 558, 543);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherTodosAtestados("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN VISITASINTERNO "
                                + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                                + "WHERE DataRevAtestado BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                        preencherTodosAtestados("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN VISITASINTERNO "
                                + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                                + "WHERE DataRevAtestado BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
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
            preencherTodosAtestados("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE IdRevAtestado='" + jIDPesqRol.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDRolActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa");
            jPesqNomeInterno.requestFocus();
        } else {
            preencherTodosAtestados("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosAtestados("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita");
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
            preencherTodosAtestados("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
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
                conecta.executaSQL("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON DADOSPENAISINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE IdRevAtestado='" + idRol + "'");
                conecta.rs.first();
                jIdAtestado.setText(String.valueOf(conecta.rs.getInt("IdRevAtestado")));
                codigoSoliAtestado = conecta.rs.getInt("IdAtestado");
                jStatusAtestado.setText(conecta.rs.getString("StatusRevAtestado"));
                jDataAtestado.setDate(conecta.rs.getDate("DataRevAtestado"));
                jDataValidade.setDate(conecta.rs.getDate("DataValidade"));
                jComboBoxClassAtestado.setSelectedItem(conecta.rs.getString("ClassRevAtestado"));
                jIdVisitaAtestado.setText(conecta.rs.getString("IdVisita"));
                jParentescoAtestado.setText(conecta.rs.getString("ParentescoVisita"));
                jNomeSolicitanteAtestado.setText(conecta.rs.getString("NomeVisita"));
                jIdInternoAtestado.setText(conecta.rs.getString("IdInternoCrc"));
                jCncAtestado.setText(conecta.rs.getString("Cnc"));
                jRegimePenalAux.setText(conecta.rs.getString("Regime"));
                jDatEntradaAtestado.setDate(conecta.rs.getDate("DataEntrada"));
                jNomeInternoAtestado.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInternoAtestado.setText(conecta.rs.getString("MaeInternoCrc"));
                textoAtestadoReclusao = conecta.rs.getString("TextoRevAtestado");
                dataAssinatura = conecta.rs.getString("DataAssinatura");
                horaAssinatura = conecta.rs.getString("HoraAssinatura");
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
            // FICHA JURIDICA                        
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FICHA_JURIDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON FICHA_JURIDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE FICHA_JURIDICA.IdInternoCrc='" + jIdInternoAtestado.getText() + "'");
                conecta.rs.first();
                codigoFichaJuridica = conecta.rs.getString("IdFicha");
                codigoInterno = conecta.rs.getString("IdInternoCrc");
            } catch (SQLException e) {
            }
            if (jIdInternoAtestado.getText().equals(codigoInterno)) {
                preencherTabelaProcessos("SELECT * FROM PROCESSOS_JURIDICOS "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON PROCESSOS_JURIDICOS.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "WHERE PROCESSOS_JURIDICOS.IdFicha='" + codigoFichaJuridica + "'");
                preencherTabelaIncidenciaPenal("SELECT * FROM INCIDENCIA_PENAL "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON INCIDENCIA_PENAL.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN AMPARO_LEGAL "
                        + "ON INCIDENCIA_PENAL.IdLanc=AMPARO_LEGAL.IdLanc "
                        + "WHERE INCIDENCIA_PENAL.IdFicha='" + codigoFichaJuridica + "'");
                preencherTabelaDocumentosProcessos("SELECT * FROM DOCUMENTOS_PROCESSO "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON DOCUMENTOS_PROCESSO.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN NATUREZA_PRISAO "
                        + "ON DOCUMENTOS_PROCESSO.IdNatp=NATUREZA_PRISAO.IdNatp "
                        + "WHERE DOCUMENTOS_PROCESSO.IdFicha='" + codigoFichaJuridica + "'");
            } else {
                limparCamposFichaJuridica();
                limparTabelaDocumentos();
                limparTabelaAmparolegal();
                limparTabelaProcessos();
            }
        }
    }//GEN-LAST:event_jTabelaSolicitacaoAtestaReclusaoMouseClicked

    private void jBtBuscarDadosVIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarDadosVIActionPerformed
        // TODO add your handling code here:TelaPesqVisitasInternoSoliAtestado
        TelaPesqVisitasInternoRevAtestado objPesqRevAtestaRec = new TelaPesqVisitasInternoRevAtestado();
        TelaModuloCRC.jPainelCRC.add(objPesqRevAtestaRec);
        objPesqRevAtestaRec.show();
    }//GEN-LAST:event_jBtBuscarDadosVIActionPerformed

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
        buscarAcessoUsuario(impressaoRevalidarAtCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(impressaoRevalidarAtCRC) && codAbrirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
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
                    String path = "reports/RelatorioRevAtestadoReclusaoCRC.jasper";
                    conecta.executaSQL("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON REVALIDAR_ATESTADO_RECLUSAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON DADOSPENAISINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON REVALIDAR_ATESTADO_RECLUSAO.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE REVALIDAR_ATESTADO_RECLUSAO.IdRevAtestado='" + jIdAtestado.getText() + "'");
                    HashMap parametros = new HashMap();
                    parametros.put("idRegistro", jIdAtestado.getText());
                    parametros.put("nomeUsuario", nameUser);
                    parametros.put("nomeUnidade", descricaoUnidade);
                    parametros.put("chaveValidacaoInterno", chaveValidacaoRelatorio);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Revalidação do Atestado de Reclusão Carcerária");
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

    private void jBtLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(liberacaoRevAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(liberacaoRevAtestadoCRC) && codAbrirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
            if (textoAtestadoReclusao.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "O texto do atestado de reclusão está vazio, preencher o atestado de reclusão antes de liberar.");
            } else {
                mostrarLiberador();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a liberar o registro.");
        }
    }//GEN-LAST:event_jBtLiberarActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(revalidarAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(revalidarAtestadoCRC) && codIncluirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
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
        buscarAcessoUsuario(revalidarAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(revalidarAtestadoCRC) && codAlterarCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
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
        buscarAcessoUsuario(revalidarAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(revalidarAtestadoCRC) && codExcluirCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
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
        buscarAcessoUsuario(revalidarAtestadoCRC);
        if (codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(revalidarAtestadoCRC) && codGravarCRC == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES")) {
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
//            } else if (!jParentescoAtestado.getText().equals("COMPANHEIRO") || !jParentescoAtestado.getText().equals("COMPANHEIRA") || !jParentescoAtestado.getText().equals("ESPOSO") || !jParentescoAtestado.getText().equals("ESPOSA") || !jParentescoAtestado.getText().equals("MARIDO") || !jParentescoAtestado.getText().equals("MULHER")) {
//                JOptionPane.showMessageDialog(rootPane, "Solicitante não tem permissão para requerer atestado de reclusão..");
            } else {
                objEmissao.setStatusAtestado(jStatusAtestado.getText());
                objEmissao.setClassAtestado((String) jComboBoxClassAtestado.getSelectedItem());
                objEmissao.setDataAtestado(jDataAtestado.getDate());
                objEmissao.setDataValidade(jDataValidade.getDate());
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
//                    // ATUALIZAR A TABELA SOLICITACAO_ATESTADO-RECLUSAO
//                    objEmissao.setCodRegAux(codigoSoliAtestado);
//                    objEmissao.setUtilizadoCrc(utilizacao);
//                    control.confirmarEmissaoAtestadoReclusao(objEmissao);
                    //CONVERTE A DATA EM STRING PARA SER CRIPTOGRAFADA.
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataAtestado.getDate().getTime());
                    // CRIPTOGRAFAR OS DADOS DO DOCUMENTO, CODIGO DO INTERNO E O NOME DO INTERNO
                    // UTILIZA O ID DO REGISTRO, A DATA DO REGISTRO, O ID DO INTERNO, O NOME DO INTERNO E O ID DO SOLICITANTE.
                    criptografarDadosInternoSimetrico(jIdAtestado.getText(), dataInicial, jIdInternoAtestado.getText(), jNomeInternoAtestado.getText(), jIdVisitaAtestado.getText());
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
        TelaAuditoriaEmissaoRevAtestadoRec objAudiEA = new TelaAuditoriaEmissaoRevAtestadoRec();
        TelaModuloCRC.jPainelCRC.add(objAudiEA);
        objAudiEA.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jTabelaProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProcessoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaProcesso.getValueAt(jTabelaProcesso.getSelectedRow(), 0);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PROCESSOS_JURIDICOS "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON PROCESSOS_JURIDICOS.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "WHERE PROCESSOS_JURIDICOS.IdProc='" + idLanc + "'");
                conecta.rs.first();
                codProc = conecta.rs.getString("IdProc");
                jNumeroProcesso.setText(conecta.rs.getString("NrProcesso"));
                jNumeroInquerito.setText(conecta.rs.getString("Inquerito"));
                jComboBoxRegimeProcesso.setSelectedItem(conecta.rs.getString("Regime"));
                jComboBoxSentenca.setSelectedItem(conecta.rs.getString("Sentenca"));
                jComboBoxTipoSentencaCondenatoria.setSelectedItem(conecta.rs.getString("TipoSentenca"));
                jComboBoxSituacaoPresoProcesso.setSelectedItem(conecta.rs.getString("SituacaoPresoProcesso"));
                jAnos.setText(conecta.rs.getString("Anos"));
                jMeses.setText(conecta.rs.getString("Meses"));
                jDias.setText(conecta.rs.getString("Dias"));
                jMeses.setText(conecta.rs.getString("Meses"));
                jTotalDias.setText(conecta.rs.getString("TotalDias"));
                jDataInicioProcesso.setDate(conecta.rs.getDate("DataInicio"));
                jDataTerminoProcesso.setDate(conecta.rs.getDate("DataTermino"));
                jObservacaoProcesso.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaProcessoMouseClicked

    private void jTabelaAmparoLegalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAmparoLegalMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaAmparoLegal.getValueAt(jTabelaAmparoLegal.getSelectedRow(), 0);
            jIdAmparo.setText(idLanc);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INCIDENCIA_PENAL "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON INCIDENCIA_PENAL.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN AMPARO_LEGAL "
                        + "ON INCIDENCIA_PENAL.IdLanc=AMPARO_LEGAL.IdLanc "
                        + "WHERE INCIDENCIA_PENAL.IdInc='" + idLanc + "'");
                conecta.rs.first();
                codIncPen = conecta.rs.getString("IdInc");
                jIdAmparo.setText(conecta.rs.getString("IdLanc"));
                jDescricaoAmparoLegal.setText(conecta.rs.getString("DescricaoAmparoLegal"));
                jComboBoxArtigo.setText(conecta.rs.getString("Artigo"));
                jComboBoxParagrafo.setText(conecta.rs.getString("Paragrafo"));
                jComboBoxInciso.setText(conecta.rs.getString("Inciso"));
                jComboBoxAlinea.setText(conecta.rs.getString("Alinea"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaAmparoLegalMouseClicked

    private void jTabelaDocumentosProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaDocumentosProcessoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaDocumentosProcesso.getValueAt(jTabelaDocumentosProcesso.getSelectedRow(), 0);
            jIdNatp.setText(idLanc);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DOCUMENTOS_PROCESSO "
                        + "INNER JOIN FICHA_JURIDICA "
                        + "ON DOCUMENTOS_PROCESSO.IdFicha=FICHA_JURIDICA.IdFicha "
                        + "INNER JOIN NATUREZA_PRISAO "
                        + "ON DOCUMENTOS_PROCESSO.IdNatp=NATUREZA_PRISAO.IdNatp "
                        + "WHERE DOCUMENTOS_PROCESSO.IdDocPro='" + idLanc + "'");
                conecta.rs.first();
                jIdNatp.setText(conecta.rs.getString("IdNatp"));
                codProdDoc = conecta.rs.getString("IdDocPro");
                jDescricaoNaturezaPrisao.setText(conecta.rs.getString("DescricaoNatureza"));
                jDocumentoPrisao.setText(conecta.rs.getString("Documento"));
                jOrigemDocumentoPrisao.setText(conecta.rs.getString("OrigemDoc"));
                jDataDocumentoPrisao.setDate(conecta.rs.getDate("DataDoc"));
                jHoraDocumento.setText(conecta.rs.getString("HoraDoc"));
                //                jObservacaoDocumento.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaDocumentosProcessoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(revalidarAtestadoCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(revalidarAtestadoCRC) && codAbrirCRC == 1) {
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
                TelaValidadorRevAtestadoReclusao objRevValidador = new TelaValidadorRevAtestadoReclusao();
                TelaModuloCRC.jPainelCRC.add(objRevValidador);
                objRevValidador.show();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField jAnos;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCncAtestado;
    public static javax.swing.JTextField jComboBoxAlinea;
    public static javax.swing.JTextField jComboBoxArtigo;
    public static javax.swing.JComboBox<String> jComboBoxClassAtestado;
    public static javax.swing.JTextField jComboBoxInciso;
    public static javax.swing.JTextField jComboBoxParagrafo;
    public static javax.swing.JComboBox jComboBoxRegimeProcesso;
    public static javax.swing.JComboBox jComboBoxSentenca;
    public static javax.swing.JComboBox jComboBoxSituacaoPresoProcesso;
    public static javax.swing.JComboBox jComboBoxTipoSentencaCondenatoria;
    public static com.toedter.calendar.JDateChooser jDatEntradaAtestado;
    private com.toedter.calendar.JDateChooser jDataAtestado;
    public static com.toedter.calendar.JDateChooser jDataDocumentoPrisao;
    public static com.toedter.calendar.JDateChooser jDataInicioProcesso;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataTerminoProcesso;
    private com.toedter.calendar.JDateChooser jDataValidade;
    public static javax.swing.JTextField jDescricaoAmparoLegal;
    public static javax.swing.JTextField jDescricaoNaturezaPrisao;
    public static javax.swing.JTextField jDias;
    public static javax.swing.JTextField jDocumentoPrisao;
    public static javax.swing.JTextField jHoraDocumento;
    private javax.swing.JTextField jIDPesqRol;
    public static javax.swing.JTextField jIdAmparo;
    public static javax.swing.JTextField jIdAtestado;
    public static javax.swing.JTextField jIdInternoAtestado;
    public static javax.swing.JTextField jIdNatp;
    public static javax.swing.JTextField jIdVisitaAtestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
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
    public static javax.swing.JTextField jMeses;
    public static javax.swing.JTextField jNomeInternoAtestado;
    public static javax.swing.JTextField jNomeSolicitanteAtestado;
    private javax.swing.JTextField jNomeVisitaInterna;
    public static javax.swing.JTextField jNumeroInquerito;
    public static javax.swing.JTextField jNumeroProcesso;
    public static javax.swing.JTextArea jObservacaoProcesso;
    public static javax.swing.JTextField jOrigemDocumentoPrisao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public static javax.swing.JTextField jParentescoAtestado;
    private javax.swing.JTextField jPesqNomeInterno;
    public static javax.swing.JTextField jRegimePenalAux;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jStatusAtestado;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    public static javax.swing.JTable jTabelaAmparoLegal;
    public static javax.swing.JTable jTabelaDocumentosProcesso;
    public static javax.swing.JTable jTabelaProcesso;
    private javax.swing.JTable jTabelaSolicitacaoAtestaReclusao;
    public static javax.swing.JTextField jTotalDias;
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
        //
        jNumeroProcesso.setBackground(Color.white);
        jNumeroInquerito.setBackground(Color.white);
        jComboBoxRegimeProcesso.setBackground(Color.white);
        jAnos.setBackground(Color.white);
        jMeses.setBackground(Color.white);
        jDias.setBackground(Color.white);
        jDataInicioProcesso.setBackground(Color.white);
        jDataTerminoProcesso.setBackground(Color.white);
        jTotalDias.setBackground(Color.white);
        jObservacaoProcesso.setBackground(Color.white);
        //ABA INCIDENCIA PENAL
        jIdAmparo.setBackground(Color.white);
        jDescricaoAmparoLegal.setBackground(Color.white);
        jComboBoxArtigo.setBackground(Color.white);
        jComboBoxParagrafo.setBackground(Color.white);
        jComboBoxInciso.setBackground(Color.white);
        jComboBoxAlinea.setBackground(Color.white);
        // ABA DOCUMENTO DO PROCESSO
        jIdNatp.setBackground(Color.white);
        jDescricaoNaturezaPrisao.setBackground(Color.white);
        jDocumentoPrisao.setBackground(Color.white);
        jOrigemDocumentoPrisao.setBackground(Color.white);
        jDataDocumentoPrisao.setBackground(Color.white);
        jHoraDocumento.setBackground(Color.white);
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
        jDataValidade.setDate(null);
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
        // CALCULAR A DATA DE VALIDADE DO ATESTADO
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 3);
        jDataValidade.setCalendar(calendar);
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
            conecta.executaSQL("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO");
            conecta.rs.last();
            jIdAtestado.setText(String.valueOf(conecta.rs.getInt("IdRevAtestado")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar registro. \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarValidadores() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REVALIDAR_ATESTADO_RECLUSAO "
                    + "WHERE IdRevAtestado='" + jIdAtestado.getText() + "'");
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
                dataAtestado = conecta.rs.getString("DataRevAtestado");
                String dia = dataAtestado.substring(8, 10);
                String mes = dataAtestado.substring(5, 7);
                String ano = dataAtestado.substring(0, 4);
                dataAtestado = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRevAtestado"), dataAtestado, conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("NomeVisita")});
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

    // FICHA JURÍDICA
    public void preencherTabelaProcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nr. Processo", "Nr. Inquérito", "Regime", "Anos", "Meses", "Dias", "Data Inicio", "Data Término"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataInicioProcesso = conecta.rs.getString("DataInicio");
                if (dataInicioProcesso != null) {
                    String diaIp = dataInicioProcesso.substring(8, 10);
                    String mesIp = dataInicioProcesso.substring(5, 7);
                    String anoIp = dataInicioProcesso.substring(0, 4);
                    dataInicioProcesso = diaIp + "/" + mesIp + "/" + anoIp;
                }
                //
                dataTerminoProcesso = conecta.rs.getString("DataTermino");
                if (dataTerminoProcesso != null) {
                    String diaTp = dataTerminoProcesso.substring(8, 10);
                    String mesTp = dataTerminoProcesso.substring(5, 7);
                    String anoTp = dataTerminoProcesso.substring(0, 4);
                    dataTerminoProcesso = diaTp + "/" + mesTp + "/" + anoTp;
                }
                dados.add(new Object[]{conecta.rs.getString("IdProc"), conecta.rs.getString("NrProcesso"), conecta.rs.getString("Inquerito"), conecta.rs.getString("Regime"), conecta.rs.getString("Anos"), conecta.rs.getString("Meses"), conecta.rs.getString("Dias"), dataInicioProcesso, dataTerminoProcesso});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProcesso.setModel(modelo);
        jTabelaProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(6).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(7).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaProcesso.getColumnModel().getColumn(8).setResizable(false);
        jTabelaProcesso.setAutoResizeMode(jTabelaProcesso.AUTO_RESIZE_OFF);
        jTabelaProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaProcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaProcesso.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        jTabelaProcesso.getColumnModel().getColumn(8).setCellRenderer(centralizado);
    }

    public void limparTabelaProcessos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nr. Processo", "Nr. Inquérito", "Regime", "Anos", "Meses", "Dias", "Data Inicio", "Data Término"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProcesso.setModel(modelo);
        jTabelaProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(6).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaProcesso.getColumnModel().getColumn(7).setResizable(false);
        jTabelaProcesso.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTabelaProcesso.getColumnModel().getColumn(8).setResizable(false);
        jTabelaProcesso.setAutoResizeMode(jTabelaProcesso.AUTO_RESIZE_OFF);
        jTabelaProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaIncidenciaPenal(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Amparo Legal", "Artigo", "Parágrafo", "Inciso", "Alínea"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInc"), conecta.rs.getString("DescricaoAmparoLegal"), conecta.rs.getString("Artigo"), conecta.rs.getString("Paragrafo"), conecta.rs.getString("Inciso"), conecta.rs.getString("Alinea")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAmparoLegal.setModel(modelo);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAmparoLegal.setAutoResizeMode(jTabelaAmparoLegal.AUTO_RESIZE_OFF);
        jTabelaAmparoLegal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAmparoLegal();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAmparoLegal() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void limparTabelaAmparolegal() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Amparo Legal", "Artigo", "Parágrafo", "Inciso", "Alínea"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAmparoLegal.setModel(modelo);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaAmparoLegal.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaAmparoLegal.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaAmparoLegal.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTabelaAmparoLegal.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAmparoLegal.setAutoResizeMode(jTabelaAmparoLegal.AUTO_RESIZE_OFF);
        jTabelaAmparoLegal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaDocumentosProcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Natureza da Prisão", "Documento", "Origem", "Data", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataDoc = conecta.rs.getString("DataDoc");
                String dia = dataDoc.substring(8, 10);
                String mes = dataDoc.substring(5, 7);
                String ano = dataDoc.substring(0, 4);
                dataDoc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdDocPro"), conecta.rs.getString("DescricaoNatureza"), conecta.rs.getString("Documento"), conecta.rs.getString("OrigemDoc"), dataDoc, conecta.rs.getString("HoraDoc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentosProcesso.setModel(modelo);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaDocumentosProcesso.setAutoResizeMode(jTabelaDocumentosProcesso.AUTO_RESIZE_OFF);
        jTabelaDocumentosProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaDocumentosProcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaDocumentosProcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void limparTabelaDocumentos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Natureza da Prisão", "Documento", "Origem", "Data", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaDocumentosProcesso.setModel(modelo);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(0).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(1).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(2).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(3).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(4).setResizable(false);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaDocumentosProcesso.getColumnModel().getColumn(5).setResizable(false);
        jTabelaDocumentosProcesso.setAutoResizeMode(jTabelaDocumentosProcesso.AUTO_RESIZE_OFF);
        jTabelaDocumentosProcesso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparCamposFichaJuridica() {
        // ABA PROCESSOS
        jNumeroProcesso.setText("");
        jNumeroInquerito.setText("");
        jComboBoxRegimeProcesso.setSelectedItem(null);
        jAnos.setText("");
        jMeses.setText("");
        jDias.setText("");
        jDataInicioProcesso.setDate(null);
        jDataTerminoProcesso.setDate(null);
        jTotalDias.setText("");
        jObservacaoProcesso.setText("");
        //ABA INCIDENCIA PENAL
        jIdAmparo.setText("");
        jDescricaoAmparoLegal.setText("");
        jComboBoxArtigo.setText("");
        jComboBoxParagrafo.setText("");
        jComboBoxInciso.setText("");
        jComboBoxAlinea.setText("");
        // ABA DOCUMENTO DO PROCESSO
        jIdNatp.setText("");
        jDescricaoNaturezaPrisao.setText("");
        jDocumentoPrisao.setText("");
        jOrigemDocumentoPrisao.setText("");
        jDataDocumentoPrisao.setDate(null);
        jHoraDocumento.setText("");
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
