/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleOrganogramaCrime;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.OrganogramaCrime;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloSeguranca.codAbrir;
import static gestor.Visao.TelaModuloSeguranca.codAlterar;
import static gestor.Visao.TelaModuloSeguranca.codConsultar;
import static gestor.Visao.TelaModuloSeguranca.codExcluir;
import static gestor.Visao.TelaModuloSeguranca.codGravar;
import static gestor.Visao.TelaModuloSeguranca.codIncluir;
import static gestor.Visao.TelaModuloSeguranca.codUserAcesso;
import static gestor.Visao.TelaModuloSeguranca.codigoGrupo;
import static gestor.Visao.TelaModuloSeguranca.codigoUser;
import static gestor.Visao.TelaModuloSeguranca.codigoUserGroup;
import static gestor.Visao.TelaModuloSeguranca.nomeGrupo;
import static gestor.Visao.TelaModuloSeguranca.nomeTela;
import static gestor.Visao.TelaModuloSeguranca.telaBaralhoCrimeUnidadePrisional;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class BaralhoCrimeUnidadePrisional extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OrganogramaCrime objOrg = new OrganogramaCrime();
    ControleOrganogramaCrime control = new ControleOrganogramaCrime();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Segurança:Organograma Prisional:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao;
    int flag;
    int count = 0;
    String dataInicial;
    String dataFinal;
    String dataEntrada;
    String caminhoCarta;
    //1º ESCALÃO
    public static int pINTERNO_L1A = 0;
    public static int pINTERNO_L1B = 0;
    public static int pINTERNO_L1C = 0;
    public static int pINTERNO_L1D = 0;
    //2º ESCALÃO
    public static int pINTERNO_L2A = 0;
    public static int pINTERNO_L2B = 0;
    public static int pINTERNO_L2C = 0;
    public static int pINTERNO_L2D = 0;
    //
    public static int CODIGO_CONFIRMACAO_GRAVACAO = 0;
    //TABELAS PARA PESQUISAS
    //1ºESCALÃO
    String pTABELA_L1A = "L1A_ORGANOGRAMA_CRIME";
    String pTABELA_L1B = "L1B_ORGANOGRAMA_CRIME";
    String pTABELA_L1C = "L1C_ORGANOGRAMA_CRIME";
    String pTABELA_L1D = "L1D_ORGANOGRAMA_CRIME";
    //2ºESCALÃO
    String pTABELA_L2A = "L2A_ORGANOGRAMA_CRIME";
    String pTABELA_L2B = "L2B_ORGANOGRAMA_CRIME";
    String pTABELA_L2C = "L2C_ORGANOGRAMA_CRIME";
    String pTABELA_L2D = "L2D_ORGANOGRAMA_CRIME";
    //1º ESCALÃO
    int pID_INTERNO_L1A = 0;
    int pID_REGISTRO_L1A = 0;
    int pID_INTERNO_L1B = 0;
    int pID_REGISTRO_L1B = 0;
    int pID_INTERNO_L1C = 0;
    int pID_REGISTRO_L1C = 0;
    int pID_INTERNO_L1D = 0;
    int pID_REGISTRO_L1D = 0;
    //2º ESCALÃO
    int pID_INTERNO_L2A = 0;
    int pID_REGISTRO_L2A = 0;
    int pID_INTERNO_L2B = 0;
    int pID_REGISTRO_L2B = 0;
    int pID_INTERNO_L2C = 0;
    int pID_REGISTRO_L2C = 0;
    int pID_INTERNO_L2D = 0;
    int pID_REGISTRO_L2D = 0;
    //
    float valorCusto = 0;
    //CAMINHO PARA AS FOTOS DOS INTERNOS
    //1º ESCALÃO
    String caminho = "";
    String caminhoL1A = "";
    String caminhoL1B = "";
    String caminhoL1C = "";
    String caminhoL1D = "";
    //2º ESCALÃO
    String caminhoL2A = "";
    String caminhoL2B = "";
    String caminhoL2C = "";
    String caminhoL2D = "";

    /**
     * Creates new form TelaPrincipalBaralho
     */
    public static TelaInformacoesInternoBC0 INF_BC0;
    public static TelaInformacoesInternoBC1 INF_BC1;
    public static TelaInformacoesInternoBC2 INF_BC2;
    public static TelaInformacoesInternoBC3 INF_BC3;
    public static TelaEnderecoOCPV ENDoc;
    //
    public static TelaInformacoesInternoBCB0 INFO_BCB0;
    public static TelaInformacoesInternoBCB1 INFO_BCB1;
    public static TelaInformacoesInternoBCB2 INFO_BCB2;
    public static TelaInformacoesInternoBCB3 INFO_BCB3;

    public BaralhoCrimeUnidadePrisional() {
        initComponents();
        corCampos();
        formataCampos();
    }

    //INFORMAÇÕES SOBRE O PRIMEIRO ESCALÃO
    public void mostrarInformacaoBC0() {
        INF_BC0 = new TelaInformacoesInternoBC0(this, true);
        INF_BC0.setVisible(true);
    }

    public void mostrarInformacaoBC1() {
        INF_BC1 = new TelaInformacoesInternoBC1(this, true);
        INF_BC1.setVisible(true);
    }

    public void mostrarInformacaoBC2() {
        INF_BC2 = new TelaInformacoesInternoBC2(this, true);
        INF_BC2.setVisible(true);
    }

    public void mostrarInformacaoBC3() {
        INF_BC3 = new TelaInformacoesInternoBC3(this, true);
        INF_BC3.setVisible(true);
    }

    public void mostrarEndereco() {
        ENDoc = new TelaEnderecoOCPV(this, true);
        ENDoc.setVisible(true);
    }

    //INFORMAÇÕES SOBRE O SEGUNDO ESCALÃO
    public void mostrarInformacaoBCB0() {
        INFO_BCB0 = new TelaInformacoesInternoBCB0(this, true);
        INFO_BCB0.setVisible(true);
    }

    public void mostrarInformacaoBCB1() {
        INFO_BCB1 = new TelaInformacoesInternoBCB1(this, true);
        INFO_BCB1.setVisible(true);
    }

    public void mostrarInformacaoBCB2() {
        INFO_BCB2 = new TelaInformacoesInternoBCB2(this, true);
        INFO_BCB2.setVisible(true);
    }

    public void mostrarInformacaoBCB3() {
        INFO_BCB3 = new TelaInformacoesInternoBCB3(this, true);
        INFO_BCB3.setVisible(true);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jBtPesqID = new javax.swing.JButton();
        jIDPesqLoca = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesquisaPorNome = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaLocacao = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelFoto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabelCarta = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jBtCarta = new javax.swing.JButton();
        jBtRemoverCarta = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jNomeInternoBC = new javax.swing.JTextField();
        jNaturalidade = new javax.swing.JTextField();
        jAlcunhaBC = new javax.swing.JTextField();
        jRGBC = new javax.swing.JTextField();
        jCPFBC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jNomeMaeBC = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jIdInternoBC = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jFaccao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jCNC_BC = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jRegime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSituacaoCrc = new javax.swing.JTextField();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jBtEndereco = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jDataCrimeBC = new com.toedter.calendar.JDateChooser();
        jDataPrisaoBC = new com.toedter.calendar.JDateChooser();
        jDataCondenacaoBC = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDataEntradaBC = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jDataTerPena = new com.toedter.calendar.JDateChooser();
        jParagrafo1 = new javax.swing.JTextField();
        jParagrafo2 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jParagrafo3 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jArtigo1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jArtigo2 = new javax.swing.JTextField();
        jComboBoxEdiondo = new javax.swing.JComboBox();
        jArtigo3 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jProcedenciaBC = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jVaraCondenatoriaBC = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jFotoL11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jFotoL13 = new javax.swing.JLabel();
        jBtAdd1 = new javax.swing.JButton();
        jBtDel1 = new javax.swing.JButton();
        jBtAdd2 = new javax.swing.JButton();
        jBtDel2 = new javax.swing.JButton();
        jBtAdd3 = new javax.swing.JButton();
        jBtDel3 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jFotoL12 = new javax.swing.JLabel();
        jBtInfo1 = new javax.swing.JButton();
        jBtInfo2 = new javax.swing.JButton();
        jBtInfo3 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jFotoL14 = new javax.swing.JLabel();
        jBtInfo4 = new javax.swing.JButton();
        jBtAdd4 = new javax.swing.JButton();
        jBtDel4 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacaoL1 = new javax.swing.JTextArea();
        jPanel24 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jFotoL15 = new javax.swing.JLabel();
        jBtDel5 = new javax.swing.JButton();
        jBtAdd5 = new javax.swing.JButton();
        jBtInfo5 = new javax.swing.JButton();
        jBtDel6 = new javax.swing.JButton();
        jBtAdd6 = new javax.swing.JButton();
        jBtAdd7 = new javax.swing.JButton();
        jBtDel7 = new javax.swing.JButton();
        jBtDel8 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacaoL2 = new javax.swing.JTextArea();
        jPanel33 = new javax.swing.JPanel();
        jFotoL16 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jFotoL17 = new javax.swing.JLabel();
        jBtInfo6 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jFotoL18 = new javax.swing.JLabel();
        jBtInfo7 = new javax.swing.JButton();
        jBtInfo8 = new javax.swing.JButton();
        jBtAdd8 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtBuscarInterno = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPavilhaoBC = new javax.swing.JTextField();
        jCelaBC = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jRecompensaBC = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: NIM - Núcleo de Informações e Monitoramento :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jIDPesqLoca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLoca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("ID Locação:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaPorNome.setContentAreaFilled(false);
        jBtPesquisaPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaPorNomeActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Nome Interno:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jIDPesqLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel23)
                    .addComponent(jIDPesqLoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jLabel24)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel26)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaPorNome)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaLocacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ));
        jTabelaLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaLocacaoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaLocacao);
        if (jTabelaLocacao.getColumnModel().getColumnCount() > 0) {
            jTabelaLocacao.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaLocacao.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaLocacao.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaLocacao.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaLocacao.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaLocacao.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaLocacao.getColumnModel().getColumn(3).setMinWidth(380);
            jTabelaLocacao.getColumnModel().getColumn(3).setMaxWidth(380);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("STATUS:");

        jComboBoxStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "PRIMEIRA VOZ", "SEGUNDA VOZ", "TERCEIRA VOZ", "QUARTA VOZ", "QUINTA VOZ" }));
        jComboBoxStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatus.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabelCarta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCarta, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Registro");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data:");

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(3, 3, 3)
                .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtCarta.setForeground(new java.awt.Color(0, 102, 0));
        jBtCarta.setText("ADD. CARTA");
        jBtCarta.setEnabled(false);
        jBtCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCartaActionPerformed(evt);
            }
        });

        jBtRemoverCarta.setForeground(new java.awt.Color(204, 0, 0));
        jBtRemoverCarta.setText("REMOVE CARTA");
        jBtRemoverCarta.setEnabled(false);
        jBtRemoverCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverCartaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jBtCarta)
                                        .addGap(24, 24, 24)
                                        .addComponent(jBtRemoverCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCarta, jBtRemoverCarta});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCarta)
                    .addComponent(jBtRemoverCarta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome da Mãe");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Alcunha");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("R.G.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("C.P.F.");

        jNomeInternoBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoBC.setEnabled(false);

        jNaturalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturalidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNaturalidade.setEnabled(false);

        jAlcunhaBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlcunhaBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jAlcunhaBC.setEnabled(false);

        jRGBC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jRGBC.setEnabled(false);

        jCPFBC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCPFBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCPFBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCPFBC.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data Nasc.");

        jNomeMaeBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeMaeBC.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código");

        jIdInternoBC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdInternoBC.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Facção");

        jFaccao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFaccao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFaccao.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("CNC");

        jCNC_BC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC_BC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC_BC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCNC_BC.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Regime");

        jRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegime.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jRegime.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Situação");

        jSituacaoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSituacaoCrc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jSituacaoCrc.setEnabled(false);

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Naturalidade");

        jBtEndereco.setForeground(new java.awt.Color(0, 102, 0));
        jBtEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtEndereco.setText("Endereço");
        jBtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoBC)
                    .addComponent(jNomeMaeBC)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIdInternoBC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jCNC_BC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFaccao)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(0, 199, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSituacaoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jNaturalidade)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jRGBC, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jCPFBC, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(0, 93, Short.MAX_VALUE))
                            .addComponent(jRegime)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jAlcunhaBC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtEndereco)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdInternoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFaccao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCNC_BC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeMaeBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSituacaoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jAlcunhaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRGBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCPFBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Pessoais", jPanel8);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jDataCrimeBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCrimeBC.setEnabled(false);

        jDataPrisaoBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrisaoBC.setEnabled(false);

        jDataCondenacaoBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCondenacaoBC.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Data Entrada");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Crime");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Prisão");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Dt. Condenação");

        jDataEntradaBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntradaBC.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEntradaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataCrimeBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDataPrisaoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel14))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataCondenacaoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEntradaBC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCrimeBC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPrisaoBC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCondenacaoBC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jDataTerPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerPena.setEnabled(false);

        jParagrafo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jParagrafo1.setEnabled(false);

        jParagrafo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jParagrafo2.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Artigo 1:");

        jParagrafo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jParagrafo3.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Artigo 2:");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Crime Hediondo:");

        jArtigo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jArtigo1.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Artigo 3:");

        jArtigo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jArtigo2.setEnabled(false);

        jComboBoxEdiondo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEdiondo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Sim", "Não" }));
        jComboBoxEdiondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEdiondo.setEnabled(false);

        jArtigo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jArtigo3.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Parágrafo 1:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Parágrafo 2:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Término Pena:");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Parágrafo 3:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEdiondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataTerPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel53)
                    .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel54)
                    .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxEdiondo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jDataTerPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Procedência:");

        jProcedenciaBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProcedenciaBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jProcedenciaBC.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Vara Condenação:");

        jVaraCondenatoriaBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jVaraCondenatoriaBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jVaraCondenatoriaBC.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProcedenciaBC))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jVaraCondenatoriaBC)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jProcedenciaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jVaraCondenatoriaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Jurídicos", jPanel9);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jFotoL11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL11, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL11, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL13, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL13, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jBtAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd1.setToolTipText("Adicionar");
        jBtAdd1.setEnabled(false);
        jBtAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd1ActionPerformed(evt);
            }
        });

        jBtDel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel1.setToolTipText("Remover");
        jBtDel1.setEnabled(false);
        jBtDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel1ActionPerformed(evt);
            }
        });

        jBtAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd2.setToolTipText("Adicionar");
        jBtAdd2.setEnabled(false);
        jBtAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd2ActionPerformed(evt);
            }
        });

        jBtDel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel2.setToolTipText("Remover");
        jBtDel2.setEnabled(false);
        jBtDel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel2ActionPerformed(evt);
            }
        });

        jBtAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd3.setEnabled(false);
        jBtAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd3ActionPerformed(evt);
            }
        });

        jBtDel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel3.setToolTipText("Remover");
        jBtDel3.setEnabled(false);
        jBtDel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel3ActionPerformed(evt);
            }
        });

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL12, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL12, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jBtInfo1.setText("Informações");
        jBtInfo1.setEnabled(false);
        jBtInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo1ActionPerformed(evt);
            }
        });

        jBtInfo2.setText("Informações");
        jBtInfo2.setEnabled(false);
        jBtInfo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo2ActionPerformed(evt);
            }
        });

        jBtInfo3.setText("Informações");
        jBtInfo3.setEnabled(false);
        jBtInfo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo3ActionPerformed(evt);
            }
        });

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL14, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jBtInfo4.setText("Informações");
        jBtInfo4.setEnabled(false);
        jBtInfo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo4ActionPerformed(evt);
            }
        });

        jBtAdd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd4.setEnabled(false);
        jBtAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd4ActionPerformed(evt);
            }
        });

        jBtDel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel4.setToolTipText("Remover");
        jBtDel4.setEnabled(false);
        jBtDel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel4ActionPerformed(evt);
            }
        });

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jObservacaoL1.setColumns(20);
        jObservacaoL1.setRows(5);
        jObservacaoL1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoL1.setEnabled(false);
        jScrollPane1.setViewportView(jObservacaoL1);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1º ESCALÃO");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jBtInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtInfo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jBtAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtDel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jBtAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtDel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jBtAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtDel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtDel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jBtInfo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jBtInfo4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addGap(20, 20, 20))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdd1, jBtAdd2, jBtAdd3, jBtAdd4, jBtDel1, jBtDel2, jBtDel3, jBtDel4});

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel17, jPanel18, jPanel27});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtDel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtAdd2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtDel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtAdd3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtDel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBtAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtInfo1)
                    .addComponent(jBtInfo2)
                    .addComponent(jBtInfo3)
                    .addComponent(jBtInfo4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAdd1, jBtAdd2, jBtAdd3, jBtAdd4, jBtDel1, jBtDel2, jBtDel3, jBtDel4});

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel17, jPanel18, jPanel19, jPanel27});

        jTabbedPane2.addTab("Ligações", jPanel16);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL15, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jBtDel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel5.setToolTipText("Remover");
        jBtDel5.setEnabled(false);
        jBtDel5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel5ActionPerformed(evt);
            }
        });

        jBtAdd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd5.setToolTipText("Adicionar");
        jBtAdd5.setEnabled(false);
        jBtAdd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd5ActionPerformed(evt);
            }
        });

        jBtInfo5.setText("Informações");
        jBtInfo5.setEnabled(false);
        jBtInfo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo5ActionPerformed(evt);
            }
        });

        jBtDel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel6.setToolTipText("Remover");
        jBtDel6.setEnabled(false);
        jBtDel6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel6ActionPerformed(evt);
            }
        });

        jBtAdd6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd6.setEnabled(false);
        jBtAdd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd6ActionPerformed(evt);
            }
        });

        jBtAdd7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd7.setEnabled(false);
        jBtAdd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd7ActionPerformed(evt);
            }
        });

        jBtDel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel7.setToolTipText("Remover");
        jBtDel7.setEnabled(false);
        jBtDel7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel7ActionPerformed(evt);
            }
        });

        jBtDel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtDel8.setToolTipText("Remover");
        jBtDel8.setEnabled(false);
        jBtDel8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDel8ActionPerformed(evt);
            }
        });

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jObservacaoL2.setColumns(20);
        jObservacaoL2.setRows(5);
        jObservacaoL2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoL2.setEnabled(false);
        jScrollPane2.setViewportView(jObservacaoL2);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL16, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL16, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jFotoL17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL17, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL17, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jBtInfo6.setText("Informações");
        jBtInfo6.setEnabled(false);
        jBtInfo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo6ActionPerformed(evt);
            }
        });

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("2º ESCALÃO");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel28)
                .addGap(2, 2, 2))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL18, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoL18, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jBtInfo7.setText("Informações");
        jBtInfo7.setEnabled(false);
        jBtInfo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo7ActionPerformed(evt);
            }
        });

        jBtInfo8.setText("Informações");
        jBtInfo8.setEnabled(false);
        jBtInfo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInfo8ActionPerformed(evt);
            }
        });

        jBtAdd8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdd8.setToolTipText("Adicionar");
        jBtAdd8.setEnabled(false);
        jBtAdd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdd8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jBtInfo6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtInfo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jBtAdd8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtDel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jBtAdd5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtDel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jBtAdd7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtDel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtAdd6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtDel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jBtInfo8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jBtInfo5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addGap(20, 20, 20))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdd5, jBtAdd6, jBtAdd7, jBtAdd8, jBtDel5, jBtDel6, jBtDel7, jBtDel8});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAdd8)
                    .addComponent(jBtDel5)
                    .addComponent(jBtAdd5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAdd7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAdd6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtInfo6)
                    .addComponent(jBtInfo7)
                    .addComponent(jBtInfo8)
                    .addComponent(jBtInfo5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAdd5, jBtAdd6, jBtAdd7, jBtAdd8, jBtDel5, jBtDel6, jBtDel7, jBtDel8});

        jTabbedPane2.addTab("Ligações", jPanel28);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo Registro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
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

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
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

        jBtBuscarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarInterno.setToolTipText("Pesquisar");
        jBtBuscarInterno.setEnabled(false);
        jBtBuscarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarInternoActionPerformed(evt);
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

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Impressão");
        jBtImpressao.setEnabled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtExcluir, jBtNovo});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jBtNovo)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtCancelar)
                        .addComponent(jBtBuscarInterno)
                        .addComponent(jBtImpressao)
                        .addComponent(jBtSair))
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtBuscarInterno, jBtCancelar, jBtExcluir, jBtImpressao, jBtNovo, jBtSair, jBtSalvar});

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Pavilhão:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Cela:");

        jPavilhaoBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPavilhaoBC.setEnabled(false);

        jCelaBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaBC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCelaBC.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPavilhaoBC, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCelaBC)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jPavilhaoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jCelaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("RECOMPENSA - R$:");

        jRecompensaBC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRecompensaBC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRecompensaBC.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRecompensaBC, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jRecompensaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Manutenção", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 30, 809, 485);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLoca.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisar.");
        } else {
            preencherTodasLocacao("SELECT * FROM ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIDPesqLoca.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicial.requestFocus();
            } else {
                if (jDataFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinal.requestFocus();
                } else {
                    if (jDataFinal.getDate().after(jDataFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        preencherTodasLocacao("SELECT * FROM ORGANOGRAMA_CRIME "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataOrg BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicial.requestFocus();
            } else {
                if (jDataFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinal.requestFocus();
                } else {
                    if (jDataFinal.getDate().after(jDataFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        preencherTodasLocacao("SELECT * FROM ORGANOGRAMA_CRIME "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataOrg BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesquisaPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaPorNomeActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisar.");
        } else {
            preencherTodasLocacao("SELECT * FROM ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIDPesqLoca.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaPorNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasLocacao("SELECT * FROM ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabelaLocacao();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaLocacaoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaLocacao.getValueAt(jTabelaLocacao.getSelectedRow(), 0);
            jIDPesqLoca.setText(IdLanc);
            // 
            bloquearBotoes();
            bloquearCampos();
            limparCampos();
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtInfo1.setEnabled(true);
            jBtInfo2.setEnabled(true);
            jBtInfo3.setEnabled(true);
            jBtInfo4.setEnabled(true);
            jBtInfo5.setEnabled(true);
            jBtInfo6.setEnabled(true);
            jBtInfo7.setEnabled(true);
            jBtInfo8.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ORGANOGRAMA_CRIME "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav  "
                        + "WHERE IdOrg='" + IdLanc + "'");
                conecta.rs.first();
                jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdOrg")));
                jDataRegistro.setDate(conecta.rs.getDate("DataOrg"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jLabelFoto.setIcon(i);
                    jLabelFoto.setIcon(new ImageIcon(i.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jLabelFoto.setIcon(icon);
                }
                //BUSCAR CARTA DE BARALHO NO BANCO DE DADOS.
                byte[] imgBytes0 = ((byte[]) conecta.rs.getBytes("CartaBaralho"));
                if (imgBytes0 != null) {
                    ImageIcon pic0 = null;
                    pic0 = new ImageIcon(imgBytes0);
                    Image scaled = pic0.getImage().getScaledInstance(jLabelCarta.getWidth(), jLabelCarta.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon0 = new ImageIcon(scaled);
                    jLabelCarta.setIcon(icon0);
                }
                jIdInternoBC.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jCNC_BC.setText(conecta.rs.getString("Cnc"));
                jFaccao.setText(conecta.rs.getString("Faccao"));
                jNomeInternoBC.setText(conecta.rs.getString("NomeInternoCrc"));
                jNomeMaeBC.setText(conecta.rs.getString("MaeInternoCrc"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jSituacaoCrc.setText(conecta.rs.getString("SituacaoCrc"));
                jNaturalidade.setText(conecta.rs.getString("NomeCidade"));
                jAlcunhaBC.setText(conecta.rs.getString("AlcunhaCrc"));
                jRGBC.setText(conecta.rs.getString("RgInternoCrc"));
                jCPFBC.setText(conecta.rs.getString("CpfInternoCrc"));
                jRegime.setText(conecta.rs.getString("Regime"));
                jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusOrg"));
                jCelaBC.setText(conecta.rs.getString("EndCelaPav"));
                jPavilhaoBC.setText(conecta.rs.getString("DescricaoPav"));
                //  jObservacaoL1.setText(conecta.rs.getString("Observacao"));
                //
                valorCusto = conecta.rs.getFloat("Recompensa");
                DecimalFormat vc = new DecimalFormat("#,##0.00");
                String vlCusto = vc.format(valorCusto);
                jRecompensaBC.setText(vlCusto);
                //
                jDataEntradaBC.setDate(conecta.rs.getDate("DataEntrada"));
                jDataCrimeBC.setDate(conecta.rs.getDate("DataCrime"));
                jDataPrisaoBC.setDate(conecta.rs.getDate("DataPrisao"));
                jDataCondenacaoBC.setDate(conecta.rs.getDate("DataCondenacao"));
                jArtigo1.setText(conecta.rs.getString("Artigo1"));
                jArtigo2.setText(conecta.rs.getString("Artigo2"));
                jArtigo3.setText(conecta.rs.getString("Artigo3"));
                jComboBoxEdiondo.setSelectedItem(conecta.rs.getString("CrimeEdiondo"));
                jParagrafo1.setText(conecta.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conecta.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conecta.rs.getString("Paragrafo3"));
                jDataTerPena.setDate(conecta.rs.getDate("TerminoPena"));
                jProcedenciaBC.setText(conecta.rs.getString("DescricaoUnid"));
                jVaraCondenatoriaBC.setText(conecta.rs.getString("VaraCondenatoria"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            pesquisarPrimeiroEscalao();
            pesquisarSegundoEscalao();
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaLocacaoMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBaralhoCrimeUnidadePrisional);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaBaralhoCrimeUnidadePrisional) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 1;
            bloquearCampos();
            bloquearBotoes();
            limparCampos();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, entre em contato com o administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBaralhoCrimeUnidadePrisional);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaBaralhoCrimeUnidadePrisional) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 2;
            bloquearCampos();
            bloquearBotoes();
            Alterar();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBaralhoCrimeUnidadePrisional);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaBaralhoCrimeUnidadePrisional) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL2D_Organograma(objOrg);
                limparCamposTSEG4();
                control.excluirL2C_Organograma(objOrg);
                limparCamposTSEG3();
                control.excluirL2B_Organograma(objOrg);
                limparCamposTSEG2();
                control.excluirL2A_Organograma(objOrg);
                limparCamposTSEG1();
                //
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL1D_Organograma(objOrg);
                limparCamposTPRI4();
                control.excluirL1C_Organograma(objOrg);
                limparCamposTPRI3();
                control.excluirL1B_Organograma(objOrg);
                limparCamposTPRI2();
                control.excluirL1A_Organograma(objOrg);
                limparCamposTPRI1();
                if (pINTERNO_L1A == 0
                        && pINTERNO_L1B == 0
                        && pINTERNO_L1C == 0
                        && pINTERNO_L1D == 0
                        && pINTERNO_L2A == 0
                        && pINTERNO_L2B == 0
                        && pINTERNO_L2C == 0
                        && pINTERNO_L2D == 0) {
                    bloquearBotoes();
                    bloquearCampos();
                    limparCampos();
                    objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                    control.excluirOrganograma_PRINCIPAL(objOrg);
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
                    Excluir();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o registro totalmente, solicite ajuda do administrador do sistema.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não é possível excluir o registro, solicite suporte técnico ao administrador do sistema.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, entre em contato com o administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBaralhoCrimeUnidadePrisional);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaBaralhoCrimeUnidadePrisional) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            DecimalFormat valorReal = new DecimalFormat("###,##00.0");
            valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jIdInternoBC.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "É necessário informar o nome do interno.");
            } else if (jLabelCarta.getIcon() == null) {
                JOptionPane.showMessageDialog(null, "É necessário informar uma carta do baralho.");
            } else {
                objOrg.setDataOrg(jDataRegistro.getDate());
                objOrg.setIdInternoCrc(Integer.valueOf(jIdInternoBC.getText()));
                objOrg.setNomeInterno(jNomeInternoBC.getText());
                objOrg.setFaccao(jFaccao.getText());
                objOrg.setDescricaoPav(jPavilhaoBC.getText());
                objOrg.setDescricaoCela(jCelaBC.getText());
                objOrg.setStatusOrg((String) jComboBoxStatus.getSelectedItem());
                // PREPARAR FOTO PARA GRAVAR NO BANCO DE DADOS - FOTO DE FRENTE   
                if (jLabelCarta.getIcon() != null) {
                    Image img = ((ImageIcon) jLabelCarta.getIcon()).getImage();
                    BufferedImage bi = new BufferedImage(//é a imagem na memória e que pode ser alterada
                            img.getWidth(null),
                            img.getHeight(null),
                            BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2 = bi.createGraphics();
                    g2.drawImage(img, 0, 0, null);
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    try {
                        ImageIO.write(bi, "png", buffer);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(BaralhoCrimeUnidadePrisional.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(BaralhoCrimeUnidadePrisional.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    objOrg.setCartaBaralho(buffer.toByteArray());
                }
                try {
                    objOrg.setRecompensa(valorReal.parse(jRecompensaBC.getText()).doubleValue());
                } catch (ParseException ex) {
                    Logger.getLogger(BaralhoCrimeUnidadePrisional.class.getName()).log(Level.SEVERE, null, ex);
                }
                objOrg.setObservacao(jObservacaoL1.getText());
                objOrg.setObservacao2(jObservacaoL2.getText());
                //
                objOrg.setIdInternoCrcL1A(pINTERNO_L1A);
                objOrg.setIdInternoCrcL1B(pINTERNO_L1B);
                objOrg.setIdInternoCrcL1C(pINTERNO_L1C);
                objOrg.setIdInternoCrcL1D(pINTERNO_L1D);
                //
                objOrg.setIdInternoCrcL2A(pINTERNO_L2A);
                objOrg.setIdInternoCrcL2B(pINTERNO_L2B);
                objOrg.setIdInternoCrcL2C(pINTERNO_L2C);
                objOrg.setIdInternoCrcL2D(pINTERNO_L2D);
                if (acao == 1) {
                    objOrg.setUsuarioInsert(nameUser);
                    objOrg.setDataInsert(dataModFinal);
                    objOrg.setHorarioInsert(horaMov);
                    //
                    control.incluirOrganograma_PRINCIPAL(objOrg);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação        
                    objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                    if (CODIGO_CONFIRMACAO_GRAVACAO == 0) {
                        if (pINTERNO_L1A != 0) {
                            control.incluirL1A_Organograma(objOrg);
                        }
                        if (pINTERNO_L1B != 0) {
                            control.incluirL1B_Organograma(objOrg);
                        }
                        if (pINTERNO_L1C != 0) {
                            control.incluirL1C_Organograma(objOrg);
                        }
                        if (pINTERNO_L1D != 0) {
                            control.incluirL1D_Organograma(objOrg);
                        }
                        if (pINTERNO_L2A != 0) {
                            control.incluirL2A_Organograma(objOrg);
                        }
                        if (pINTERNO_L2B != 0) {
                            control.incluirL2B_Organograma(objOrg);
                        }
                        if (pINTERNO_L2C != 0) {
                            control.incluirL2C_Organograma(objOrg);
                        }
                        if (pINTERNO_L2D != 0) {
                            control.incluirL2D_Organograma(objOrg);
                        }
                        bloquearCampos();
                        bloquearBotoes();
                        Salvar();
                        JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados, tente novamente.");
                        bloquearCampos();
                        bloquearBotoes();
                        Salvar();
                    }
                }
                if (acao == 2) {
                    objOrg.setUsuarioInsert(nameUser);
                    objOrg.setDataUp(dataModFinal);
                    objOrg.setHorarioUp(horaMov);
                    //
                    objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                    control.alterarOrganograma_PRINCIPAL(objOrg);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    if (CODIGO_CONFIRMACAO_GRAVACAO == 0) {
                        //1ºESCALÃO
                        verificarExistenciaInternoDBL1A();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L1A && pINTERNO_L1A != 0) {
                            control.incluirL1A_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L1A && pINTERNO_L1A != 0 && objOrg.getIdInternoCrc() != pINTERNO_L1A) {
                            control.alterarL1A_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L1A && pINTERNO_L1A != 0) {
                            control.alterarL1A_Organograma(objOrg);
                        }
                        verificarExistenciaInternoDBL1B();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L1B && pINTERNO_L1B != 0) {
                            control.incluirL1B_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L1B && pINTERNO_L1B != 0 && objOrg.getIdInternoCrc() != pINTERNO_L1B) {
                            control.alterarL1B_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L1B && pINTERNO_L1B != 0) {
                            control.alterarL1B_Organograma(objOrg);
                        }
                        verificarExistenciaInternoDBL1C();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L1C && pINTERNO_L1C != 0) {
                            control.incluirL1C_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L1C && pINTERNO_L1C != 0 && objOrg.getIdInternoCrc() != pINTERNO_L1C) {
                            control.alterarL1C_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L1C && pINTERNO_L1C != 0) {
                            control.alterarL1C_Organograma(objOrg);
                        }
                        verificarExistenciaInternoDBL1D();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L1D && pINTERNO_L1D != 0) {
                            control.incluirL1D_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L1D && pINTERNO_L1D != 0 && objOrg.getIdInternoCrc() != pINTERNO_L1D) {
                            control.alterarL1D_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L1D && pINTERNO_L1D != 0) {
                            control.alterarL1D_Organograma(objOrg);
                        }
                        //2ºESCALÃO
                        verificarExistenciaInternoDBL2A();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L2A && pINTERNO_L2A != 0) {
                            control.incluirL2A_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L2A && pINTERNO_L2A != 0 && objOrg.getIdInternoCrc() != pINTERNO_L2A) {
                            control.alterarL2A_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L2A && pINTERNO_L2A != 0) {
                            control.alterarL2A_Organograma(objOrg);
                        }
                        verificarExistenciaInternoDBL2B();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L2B && pINTERNO_L2B != 0) {
                            control.incluirL2B_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L2B && pINTERNO_L2B != 0 && objOrg.getIdInternoCrc() != pINTERNO_L2B) {
                            control.alterarL2B_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L2B && pINTERNO_L2B != 0) {
                            control.alterarL2B_Organograma(objOrg);
                        }
                        verificarExistenciaInternoDBL2C();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L2C && pINTERNO_L2C != 0) {
                            control.incluirL2C_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L2C && pINTERNO_L2C != 0 && objOrg.getIdInternoCrc() != pINTERNO_L2C) {
                            control.alterarL2C_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L2C && pINTERNO_L2C != 0) {
                            control.alterarL2C_Organograma(objOrg);
                        }
                        verificarExistenciaInternoDBL2D();
                        if (objOrg.getIdOrg() != pID_REGISTRO_L2D && pINTERNO_L2D != 0) {
                            control.incluirL2D_Organograma(objOrg);
                        }
                        if (objOrg.getIdOrg() == pID_REGISTRO_L2D && pINTERNO_L2D != 0 && objOrg.getIdInternoCrc() != pINTERNO_L2D) {
                            control.alterarL2D_Organograma(objOrg);
                        } else if (objOrg.getIdOrg() == pID_REGISTRO_L2D && pINTERNO_L2D != 0) {
                            control.alterarL2D_Organograma(objOrg);
                        }
                        bloquearCampos();
                        bloquearBotoes();
                        Salvar();
                        JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados, tente novamente.");
                        bloquearCampos();
                        bloquearBotoes();
                        Salvar();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, entre em contato com o administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtBuscarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoSegurancaBC0 objPESQ_INTBC = new TelaPesqInternoSegurancaBC0();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC);
        objPESQ_INTBC.show();
    }//GEN-LAST:event_jBtBuscarInternoActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaBC objAudBC = new TelaAuditoriaBC();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudBC);
        objAudBC.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCartaActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser seletor = new javax.swing.JFileChooser();
        int acao = seletor.showOpenDialog(this);
        if (acao == JFileChooser.APPROVE_OPTION) {
            java.io.File f = seletor.getSelectedFile();
            caminhoCarta = f.getPath();
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoCarta);
            jLabelCarta.setIcon(i);
            ImageIcon image = new ImageIcon(seletor.getSelectedFile().getPath());
            jLabelCarta.setIcon(new ImageIcon(image.getImage().getScaledInstance(jLabelCarta.getWidth(), jLabelCarta.getHeight(), Image.SCALE_DEFAULT)));
            caminhoCarta = f.getPath();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleção da carta do interno foi cancelada.");
        }
    }//GEN-LAST:event_jBtCartaActionPerformed

    private void jBtRemoverCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverCartaActionPerformed
        // TODO add your handling code here:
        jLabelCarta.setIcon(null);
    }//GEN-LAST:event_jBtRemoverCartaActionPerformed

    private void jBtInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo1ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L1A != 0) {
            mostrarInformacaoBC0();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo1ActionPerformed

    private void jBtInfo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo2ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L1B != 0) {
            mostrarInformacaoBC1();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo2ActionPerformed

    private void jBtInfo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo3ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L1C != 0) {
            mostrarInformacaoBC2();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo3ActionPerformed

    private void jBtInfo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo4ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L1D != 0) {
            mostrarInformacaoBC3();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo4ActionPerformed

    private void jBtAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd1ActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoSegurancaBC1 objPESQ_INTBC1 = new TelaPesqInternoSegurancaBC1();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC1);
        objPESQ_INTBC1.show();
    }//GEN-LAST:event_jBtAdd1ActionPerformed

    private void jBtAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd2ActionPerformed
        // TODO add your handling code here:        
        TelaPesqInternoSegurancaBC2 objPESQ_INTBC2 = new TelaPesqInternoSegurancaBC2();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC2);
        objPESQ_INTBC2.show();
    }//GEN-LAST:event_jBtAdd2ActionPerformed

    private void jBtAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd3ActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoSegurancaBC3 objPESQ_INTBC3 = new TelaPesqInternoSegurancaBC3();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC3);
        objPESQ_INTBC3.show();
    }//GEN-LAST:event_jBtAdd3ActionPerformed

    private void jBtAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd4ActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoSegurancaBC4 objPESQ_INTBC4 = new TelaPesqInternoSegurancaBC4();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC4);
        objPESQ_INTBC4.show();
    }//GEN-LAST:event_jBtAdd4ActionPerformed

    private void jBtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnderecoActionPerformed
        // TODO add your handling code here:
        if (jIdInternoBC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pesquise primeiro o interno para mostrar o endereço.");
        } else {
            mostrarEndereco();
        }
    }//GEN-LAST:event_jBtEnderecoActionPerformed

    private void jBtAdd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd5ActionPerformed
        // TODO add your handling code here:TelaPesqInternoSegurancaBC3B
        TelaPesqInternoSegurancaBC3B objPESQ_INTBC3B = new TelaPesqInternoSegurancaBC3B();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC3B);
        objPESQ_INTBC3B.show();
    }//GEN-LAST:event_jBtAdd5ActionPerformed

    private void jBtInfo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo5ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L2D != 0) {
            mostrarInformacaoBCB3();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo5ActionPerformed

    private void jBtAdd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd6ActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoSegurancaBC5B objPESQ_INTBC5B = new TelaPesqInternoSegurancaBC5B();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC5B);
        objPESQ_INTBC5B.show();
    }//GEN-LAST:event_jBtAdd6ActionPerformed

    private void jBtAdd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd7ActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoSegurancaBC4B objPESQ_INTBC4B = new TelaPesqInternoSegurancaBC4B();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC4B);
        objPESQ_INTBC4B.show();
    }//GEN-LAST:event_jBtAdd7ActionPerformed

    private void jBtInfo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo6ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L2A != 0) {
            mostrarInformacaoBCB0();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo6ActionPerformed

    private void jBtInfo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo7ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L2B != 0) {
            mostrarInformacaoBCB1();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo7ActionPerformed

    private void jBtInfo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInfo8ActionPerformed
        // TODO add your handling code here:
        if (pINTERNO_L2C != 0) {
            mostrarInformacaoBCB2();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise o interno para exibir as informações complementares.");
        }
    }//GEN-LAST:event_jBtInfo8ActionPerformed

    private void jBtAdd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdd8ActionPerformed
        // TODO add your handling code here:TelaPesqInternoSegurancaBC2B
        TelaPesqInternoSegurancaBC2B objPESQ_INTBC2B = new TelaPesqInternoSegurancaBC2B();
        TelaModuloSeguranca.jPainelSeguranca.add(objPESQ_INTBC2B);
        objPESQ_INTBC2B.show();
    }//GEN-LAST:event_jBtAdd8ActionPerformed

    private void jBtDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel1ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTPRI1();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL1A_Organograma(objOrg);
                limparCamposTPRI1();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel1ActionPerformed

    private void jBtDel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel2ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTPRI2();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL1B_Organograma(objOrg);
                limparCamposTPRI2();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel2ActionPerformed

    private void jBtDel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel3ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTPRI3();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL1C_Organograma(objOrg);
                limparCamposTPRI3();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel3ActionPerformed

    private void jBtDel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel4ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTPRI4();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL1D_Organograma(objOrg);
                limparCamposTPRI4();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel4ActionPerformed

    private void jBtDel5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel5ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTSEG1();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL2A_Organograma(objOrg);
                limparCamposTSEG1();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel5ActionPerformed

    private void jBtDel6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel6ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTSEG2();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL2B_Organograma(objOrg);
                limparCamposTSEG2();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel6ActionPerformed

    private void jBtDel8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel8ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTSEG3();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL2C_Organograma(objOrg);
                limparCamposTSEG3();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel8ActionPerformed

    private void jBtDel7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDel7ActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            limparCamposTSEG4();
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objOrg.setIdOrg(Integer.valueOf(jIdRegistro.getText()));
                control.excluirL2D_Organograma(objOrg);
                limparCamposTSEG4();
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtDel7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField jAlcunhaBC;
    public static javax.swing.JTextField jArtigo1;
    public static javax.swing.JTextField jArtigo2;
    public static javax.swing.JTextField jArtigo3;
    private javax.swing.JButton jBtAdd1;
    private javax.swing.JButton jBtAdd2;
    private javax.swing.JButton jBtAdd3;
    private javax.swing.JButton jBtAdd4;
    private javax.swing.JButton jBtAdd5;
    private javax.swing.JButton jBtAdd6;
    private javax.swing.JButton jBtAdd7;
    private javax.swing.JButton jBtAdd8;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtBuscarInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCarta;
    private javax.swing.JButton jBtDel1;
    private javax.swing.JButton jBtDel2;
    private javax.swing.JButton jBtDel3;
    private javax.swing.JButton jBtDel4;
    private javax.swing.JButton jBtDel5;
    private javax.swing.JButton jBtDel6;
    private javax.swing.JButton jBtDel7;
    private javax.swing.JButton jBtDel8;
    private javax.swing.JButton jBtEndereco;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtInfo1;
    private javax.swing.JButton jBtInfo2;
    private javax.swing.JButton jBtInfo3;
    private javax.swing.JButton jBtInfo4;
    private javax.swing.JButton jBtInfo5;
    private javax.swing.JButton jBtInfo6;
    private javax.swing.JButton jBtInfo7;
    private javax.swing.JButton jBtInfo8;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesquisaPorNome;
    private javax.swing.JButton jBtRemoverCarta;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JTextField jCNC_BC;
    public static javax.swing.JTextField jCPFBC;
    public static javax.swing.JTextField jCelaBC;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JComboBox jComboBoxEdiondo;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    public static com.toedter.calendar.JDateChooser jDataCondenacaoBC;
    public static com.toedter.calendar.JDateChooser jDataCrimeBC;
    public static com.toedter.calendar.JDateChooser jDataEntradaBC;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    public static com.toedter.calendar.JDateChooser jDataPrisaoBC;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static com.toedter.calendar.JDateChooser jDataTerPena;
    private javax.swing.JTextField jFaccao;
    public static javax.swing.JLabel jFotoL11;
    public static javax.swing.JLabel jFotoL12;
    public static javax.swing.JLabel jFotoL13;
    public static javax.swing.JLabel jFotoL14;
    public static javax.swing.JLabel jFotoL15;
    public static javax.swing.JLabel jFotoL16;
    public static javax.swing.JLabel jFotoL17;
    public static javax.swing.JLabel jFotoL18;
    private javax.swing.JTextField jIDPesqLoca;
    public static javax.swing.JTextField jIdInternoBC;
    public static javax.swing.JTextField jIdRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelCarta;
    public static javax.swing.JLabel jLabelFoto;
    public static javax.swing.JTextField jNaturalidade;
    public static javax.swing.JTextField jNomeInternoBC;
    public static javax.swing.JTextField jNomeMaeBC;
    private javax.swing.JTextArea jObservacaoL1;
    private javax.swing.JTextArea jObservacaoL2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jParagrafo1;
    public static javax.swing.JTextField jParagrafo2;
    public static javax.swing.JTextField jParagrafo3;
    public static javax.swing.JTextField jPavilhaoBC;
    private javax.swing.JTextField jPesqNomeInterno;
    public static javax.swing.JTextField jProcedenciaBC;
    public static javax.swing.JTextField jRGBC;
    private javax.swing.JFormattedTextField jRecompensaBC;
    public static javax.swing.JTextField jRegime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTextField jSituacaoCrc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaLocacao;
    public static javax.swing.JTextField jVaraCondenatoriaBC;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formataCampos() {
        jObservacaoL1.setLineWrap(true);
        jObservacaoL1.setWrapStyleWord(true);
    }

    public void corCampos() {
        //ABA DADOS PESSOAIS    
        jIdRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jSituacaoCrc.setBackground(Color.white);
        //
        jIdInternoBC.setBackground(Color.white);
        jCNC_BC.setBackground(Color.white);
        jFaccao.setBackground(Color.white);
        jNomeInternoBC.setBackground(Color.white);
        jNomeMaeBC.setBackground(Color.white);
        jNaturalidade.setBackground(Color.white);
        jAlcunhaBC.setBackground(Color.white);
        jRegime.setBackground(Color.white);
        jRGBC.setBackground(Color.white);
        jCPFBC.setBackground(Color.white);
        //
        jPavilhaoBC.setBackground(Color.white);
        jCelaBC.setBackground(Color.white);
        jRecompensaBC.setBackground(Color.white);
        //ABA DADOS PENAIS
        jDataEntradaBC.setBackground(Color.white);
        jDataCrimeBC.setBackground(Color.white);
        jDataPrisaoBC.setBackground(Color.white);
        jDataCondenacaoBC.setBackground(Color.white);
        jArtigo1.setBackground(Color.white);
        jArtigo2.setBackground(Color.white);
        jArtigo3.setBackground(Color.white);
        jComboBoxEdiondo.setBackground(Color.white);
        jParagrafo1.setBackground(Color.white);
        jParagrafo2.setBackground(Color.white);
        jParagrafo3.setBackground(Color.white);
        jDataTerPena.setBackground(Color.white);
        jProcedenciaBC.setBackground(Color.white);
        jVaraCondenatoriaBC.setBackground(Color.white);
        jObservacaoL1.setBackground(Color.white);
    }

    public void limparCampos() {
        jIdRegistro.setText("");
        jDataRegistro.setDate(null);
        jSituacaoCrc.setText("");
        jLabelCarta.setIcon(null);
        jLabelFoto.setIcon(null);
        //
        jIdInternoBC.setText("");
        jCNC_BC.setText("");
        jFaccao.setText("");
        jNomeInternoBC.setText("");
        jNomeMaeBC.setText("");
        jNaturalidade.setText("");
        jAlcunhaBC.setText("");
        jRegime.setText("");
        jRGBC.setText("");
        jCPFBC.setText("");
        jComboBoxStatus.setSelectedItem("Selecione...");
        //
        jPavilhaoBC.setText("");
        jCelaBC.setText("");
        jRecompensaBC.setText("0,00");
        //ABA DADOS PENAIS
        jDataEntradaBC.setDate(null);
        jDataCrimeBC.setDate(null);
        jDataPrisaoBC.setDate(null);
        jDataCondenacaoBC.setDate(null);
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jComboBoxEdiondo.setSelectedItem("Selecione...");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerPena.setDate(null);
        jProcedenciaBC.setText("");
        jVaraCondenatoriaBC.setText("");
        jObservacaoL1.setText("");
        jObservacaoL2.setText("");
        jFotoL11.setIcon(null);
        jFotoL12.setIcon(null);
        jFotoL13.setIcon(null);
        jFotoL14.setIcon(null);
        jFotoL15.setIcon(null);
        jFotoL16.setIcon(null);
        jFotoL17.setIcon(null);
        jFotoL18.setIcon(null);
        //1º ESCALÃO
        pINTERNO_L1A = 0;
        pINTERNO_L1B = 0;
        pINTERNO_L1C = 0;
        pINTERNO_L1D = 0;
        //2º ESCALÃO
        pINTERNO_L2A = 0;
        pINTERNO_L2B = 0;
        pINTERNO_L2C = 0;
        pINTERNO_L2D = 0;
    }

    public void bloquearCampos() {
        jIdRegistro.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jSituacaoCrc.setEnabled(!true);
        //
        jIdInternoBC.setEnabled(!true);
        jCNC_BC.setEnabled(!true);
        jFaccao.setEnabled(!true);
        jNomeInternoBC.setEnabled(!true);
        jNomeMaeBC.setEnabled(!true);
        jNaturalidade.setEnabled(!true);
        jAlcunhaBC.setEnabled(!true);
        jRegime.setEnabled(!true);
        jRGBC.setEnabled(!true);
        jCPFBC.setEnabled(!true);
        jComboBoxStatus.setEnabled(!true);
        //
        jPavilhaoBC.setEnabled(!true);
        jCelaBC.setEnabled(!true);
        jRecompensaBC.setEnabled(!true);
        //ABA DADOS PENAIS
        jDataEntradaBC.setEnabled(!true);
        jDataCrimeBC.setEnabled(!true);
        jDataPrisaoBC.setEnabled(!true);
        jDataCondenacaoBC.setEnabled(!true);
        jArtigo1.setEnabled(!true);
        jArtigo2.setEnabled(!true);
        jArtigo3.setEnabled(!true);
        jComboBoxEdiondo.setEnabled(!true);
        jParagrafo1.setEnabled(!true);
        jParagrafo2.setEnabled(!true);
        jParagrafo3.setEnabled(!true);
        jDataTerPena.setEnabled(!true);
        jProcedenciaBC.setEnabled(!true);
        jVaraCondenatoriaBC.setEnabled(!true);
        //
        jObservacaoL1.setEnabled(!true);
        jObservacaoL2.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtCarta.setEnabled(!true);
        jBtRemoverCarta.setEnabled(!true);
        //ABA L1
        jBtAdd1.setEnabled(!true);
        jBtAdd2.setEnabled(!true);
        jBtAdd3.setEnabled(!true);
        jBtAdd4.setEnabled(!true);
        //
        jBtDel1.setEnabled(!true);
        jBtDel2.setEnabled(!true);
        jBtDel3.setEnabled(!true);
        jBtDel4.setEnabled(!true);
        //
        jBtInfo1.setEnabled(!true);
        jBtInfo2.setEnabled(!true);
        jBtInfo3.setEnabled(!true);
        jBtInfo4.setEnabled(!true);
        //ABAL-2        
        jBtAdd5.setEnabled(!true);
        jBtAdd6.setEnabled(!true);
        jBtAdd7.setEnabled(!true);
        jBtAdd8.setEnabled(!true);
        //
        jBtDel5.setEnabled(!true);
        jBtDel6.setEnabled(!true);
        jBtDel7.setEnabled(!true);
        jBtDel8.setEnabled(!true);
        //
        jBtInfo5.setEnabled(!true);
        jBtInfo6.setEnabled(!true);
        jBtInfo7.setEnabled(!true);
        jBtInfo8.setEnabled(!true);
    }

    public void Novo() {
        //1º ESCALÃO
        pINTERNO_L1A = 0;
        pINTERNO_L1B = 0;
        pINTERNO_L1C = 0;
        pINTERNO_L1D = 0;
        //2º ESCALÃO
        pINTERNO_L2A = 0;
        pINTERNO_L2B = 0;
        pINTERNO_L2C = 0;
        pINTERNO_L2D = 0;
        //
        jDataRegistro.setCalendar(Calendar.getInstance());
        jFaccao.setEnabled(true);
        jRecompensaBC.setEnabled(true);
        jObservacaoL1.setEnabled(true);
        jComboBoxStatus.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtBuscarInterno.setEnabled(true);
        jBtCarta.setEnabled(true);
        jBtRemoverCarta.setEnabled(true);
        //ABA L1
        jBtAdd1.setEnabled(true);
        jBtAdd2.setEnabled(true);
        jBtAdd3.setEnabled(true);
        jBtAdd4.setEnabled(true);
        //
        jBtDel1.setEnabled(true);
        jBtDel2.setEnabled(true);
        jBtDel3.setEnabled(true);
        jBtDel4.setEnabled(true);
        //
        jBtInfo1.setEnabled(true);
        jBtInfo2.setEnabled(true);
        jBtInfo3.setEnabled(true);
        jBtInfo4.setEnabled(true);
        //ABAL-2        
        jBtAdd5.setEnabled(true);
        jBtAdd6.setEnabled(true);
        jBtAdd7.setEnabled(true);
        jBtAdd8.setEnabled(true);
        //
        jBtDel5.setEnabled(true);
        jBtDel6.setEnabled(true);
        jBtDel7.setEnabled(true);
        jBtDel8.setEnabled(true);
        //
        jBtInfo5.setEnabled(true);
        jBtInfo6.setEnabled(true);
        jBtInfo7.setEnabled(true);
        jBtInfo8.setEnabled(true);
    }

    public void Alterar() {
        jDataRegistro.setCalendar(Calendar.getInstance());
        jFaccao.setEnabled(true);
        jRecompensaBC.setEnabled(true);
        jObservacaoL1.setEnabled(true);
        jComboBoxStatus.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtBuscarInterno.setEnabled(true);
        jBtCarta.setEnabled(true);
        jBtRemoverCarta.setEnabled(true);
        //ABA L1
        jBtAdd1.setEnabled(true);
        jBtAdd2.setEnabled(true);
        jBtAdd3.setEnabled(true);
        jBtAdd4.setEnabled(true);
        //
        jBtDel1.setEnabled(true);
        jBtDel2.setEnabled(true);
        jBtDel3.setEnabled(true);
        jBtDel4.setEnabled(true);
        //
        jBtInfo1.setEnabled(true);
        jBtInfo2.setEnabled(true);
        jBtInfo3.setEnabled(true);
        jBtInfo4.setEnabled(true);
        //ABAL-2        
        jBtAdd5.setEnabled(true);
        jBtAdd6.setEnabled(true);
        jBtAdd7.setEnabled(true);
        jBtAdd8.setEnabled(true);
        //
        jBtDel5.setEnabled(true);
        jBtDel6.setEnabled(true);
        jBtDel7.setEnabled(true);
        jBtDel8.setEnabled(true);
        //
        jBtInfo5.setEnabled(true);
        jBtInfo6.setEnabled(true);
        jBtInfo7.setEnabled(true);
        jBtInfo8.setEnabled(true);
    }

    public void Excluir() {
        jBtCancelar.setEnabled(true);
    }

    public void Salvar() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
        //ABA L1        
        jBtInfo1.setEnabled(true);
        jBtInfo2.setEnabled(true);
        jBtInfo3.setEnabled(true);
        jBtInfo4.setEnabled(true);
        //ABAL-2                       
        jBtInfo5.setEnabled(true);
        jBtInfo6.setEnabled(true);
        jBtInfo7.setEnabled(true);
        jBtInfo8.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistro.getText().equals("")) {
            limparCampos();
            bloquearCampos();
            bloquearBotoes();
            //
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressao.setEnabled(true);
            //ABA L1        
            jBtInfo1.setEnabled(true);
            jBtInfo2.setEnabled(true);
            jBtInfo3.setEnabled(true);
            jBtInfo4.setEnabled(true);
            //ABAL-2                       
            jBtInfo5.setEnabled(true);
            jBtInfo6.setEnabled(true);
            jBtInfo7.setEnabled(true);
            jBtInfo8.setEnabled(true);
        }
    }

    //LIMPAR CAMPOS DA PRIMEIRA LIGAÇÃO
    public void limparCamposTPRI1() {
        jFotoL11.setIcon(null);
        pINTERNO_L1A = 0;
    }

    public void limparCamposTPRI2() {
        jFotoL12.setIcon(null);
        pINTERNO_L1B = 0;
    }

    public void limparCamposTPRI3() {
        jFotoL13.setIcon(null);
        pINTERNO_L1C = 0;
    }

    public void limparCamposTPRI4() {
        jFotoL14.setIcon(null);
        pINTERNO_L1D = 0;
    }

    //LIMPAR CAMPOS DA SEGUNDA LIGAÇÃO
    public void limparCamposTSEG1() {
        jFotoL17.setIcon(null);
        pINTERNO_L2A = 0;
    }

    public void limparCamposTSEG2() {
        jFotoL16.setIcon(null);
        pINTERNO_L2B = 0;
    }

    public void limparCamposTSEG3() {
        jFotoL18.setIcon(null);
        pINTERNO_L2C = 0;
    }

    public void limparCamposTSEG4() {
        jFotoL15.setIcon(null);
        pINTERNO_L2D = 0;
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ORGANOGRAMA_CRIME");
            conecta.rs.last();
            jIdRegistro.setText(conecta.rs.getString("IdOrg"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível buscar o código do regitro.");
        }
        conecta.desconecta();
    }

    //1º ESCALÃO
    public void verificarExistenciaInternoDBL1A() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L1A_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L1A + "'");
            conecta.rs.first();
            pID_INTERNO_L1A = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L1A = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoDBL1B() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L1B_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L1B + "'");
            conecta.rs.first();
            pID_INTERNO_L1B = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L1B = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoDBL1C() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L1C_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L1C + "'");
            conecta.rs.first();
            pID_INTERNO_L1C = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L1C = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoDBL1D() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L1D_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L1D + "'");
            conecta.rs.first();
            pID_INTERNO_L1D = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L1D = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //1º ESCALÃO
    public void verificarExistenciaInternoDBL2A() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L2A_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L2A + "'");
            conecta.rs.first();
            pID_INTERNO_L2A = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L2A = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoDBL2B() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L2B_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L2B + "'");
            conecta.rs.first();
            pID_INTERNO_L2B = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L2B = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoDBL2C() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L2C_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L2C + "'");
            conecta.rs.first();
            pID_INTERNO_L2C = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L2C = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoDBL2D() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L2D_ORGANOGRAMA_CRIME "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + pINTERNO_L2D + "'");
            conecta.rs.first();
            pID_INTERNO_L2D = conecta.rs.getInt("IdInternoCrc");
            pID_REGISTRO_L2D = conecta.rs.getInt("IdOrg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //1º ESCALÃO
    public void pesquisarPrimeiroEscalao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L1A_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L1A_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L1A = conecta.rs.getInt("IdInternoCrc");
            jObservacaoL1.setText(conecta.rs.getString("Observacao"));
            caminhoL1A = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL1A != null) {
                javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoL1A);
                jFotoL11.setIcon(a);
                jFotoL11.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoL11.getWidth(), jFotoL11.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes11 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes11 != null) {
                ImageIcon pic11 = null;
                pic11 = new ImageIcon(imgBytes11);
                Image scaled = pic11.getImage().getScaledInstance(jFotoL11.getWidth(), jFotoL11.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon11 = new ImageIcon(scaled);
                jFotoL11.setIcon(icon11);
            }
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM L1B_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L1B_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L1B = conecta.rs.getInt("IdInternoCrc");
            caminhoL1B = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL1B != null) {
                javax.swing.ImageIcon b = new javax.swing.ImageIcon(caminhoL1B);
                jFotoL12.setIcon(b);
                jFotoL12.setIcon(new ImageIcon(b.getImage().getScaledInstance(jFotoL12.getWidth(), jFotoL12.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes12 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes12 != null) {
                ImageIcon pic12 = null;
                pic12 = new ImageIcon(imgBytes12);
                Image scaled = pic12.getImage().getScaledInstance(jFotoL12.getWidth(), jFotoL12.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon12 = new ImageIcon(scaled);
                jFotoL12.setIcon(icon12);
            }
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM L1C_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L1C_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L1C = conecta.rs.getInt("IdInternoCrc");
            caminhoL1C = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL1C != null) {
                javax.swing.ImageIcon c = new javax.swing.ImageIcon(caminhoL1C);
                jFotoL13.setIcon(c);
                jFotoL13.setIcon(new ImageIcon(c.getImage().getScaledInstance(jFotoL13.getWidth(), jFotoL13.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes13 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes13 != null) {
                ImageIcon pic13 = null;
                pic13 = new ImageIcon(imgBytes13);
                Image scaled = pic13.getImage().getScaledInstance(jFotoL13.getWidth(), jFotoL13.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon13 = new ImageIcon(scaled);
                jFotoL13.setIcon(icon13);
            }
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM L1D_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L1D_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L1D = conecta.rs.getInt("IdInternoCrc");
            caminhoL1D = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL1D != null) {
                javax.swing.ImageIcon d = new javax.swing.ImageIcon(caminhoL1D);
                jFotoL14.setIcon(d);
                jFotoL14.setIcon(new ImageIcon(d.getImage().getScaledInstance(jFotoL14.getWidth(), jFotoL14.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes14 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes14 != null) {
                ImageIcon pic14 = null;
                pic14 = new ImageIcon(imgBytes14);
                Image scaled = pic14.getImage().getScaledInstance(jFotoL14.getWidth(), jFotoL14.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon14 = new ImageIcon(scaled);
                jFotoL14.setIcon(icon14);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //2ºESCALÃO
    public void pesquisarSegundoEscalao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM L2A_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L2A_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L2A = conecta.rs.getInt("IdInternoCrc");
            jObservacaoL2.setText(conecta.rs.getString("Observacao"));
            caminhoL2A = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL2A != null) {
                javax.swing.ImageIcon e = new javax.swing.ImageIcon(caminhoL2A);
                jFotoL17.setIcon(e);
                jFotoL17.setIcon(new ImageIcon(e.getImage().getScaledInstance(jFotoL17.getWidth(), jFotoL17.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes17 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes17 != null) {
                ImageIcon pic17 = null;
                pic17 = new ImageIcon(imgBytes17);
                Image scaled = pic17.getImage().getScaledInstance(jFotoL17.getWidth(), jFotoL17.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon17 = new ImageIcon(scaled);
                jFotoL17.setIcon(icon17);
            }
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM L2B_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L2B_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L2B = conecta.rs.getInt("IdInternoCrc");
            caminhoL2B = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL2B != null) {
                javax.swing.ImageIcon f = new javax.swing.ImageIcon(caminhoL2B);
                jFotoL16.setIcon(f);
                jFotoL16.setIcon(new ImageIcon(f.getImage().getScaledInstance(jFotoL16.getWidth(), jFotoL16.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes16 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes16 != null) {
                ImageIcon pic16 = null;
                pic16 = new ImageIcon(imgBytes16);
                Image scaled = pic16.getImage().getScaledInstance(jFotoL16.getWidth(), jFotoL16.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon16 = new ImageIcon(scaled);
                jFotoL16.setIcon(icon16);
            }
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM L2C_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L2C_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L2C = conecta.rs.getInt("IdInternoCrc");
            caminhoL2C = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL2C != null) {
                javax.swing.ImageIcon g = new javax.swing.ImageIcon(caminhoL2C);
                jFotoL18.setIcon(g);
                jFotoL18.setIcon(new ImageIcon(g.getImage().getScaledInstance(jFotoL18.getWidth(), jFotoL18.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes18 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes18 != null) {
                ImageIcon pic18 = null;
                pic18 = new ImageIcon(imgBytes18);
                Image scaled = pic18.getImage().getScaledInstance(jFotoL18.getWidth(), jFotoL18.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon18 = new ImageIcon(scaled);
                jFotoL18.setIcon(icon18);
            }
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM L2D_ORGANOGRAMA_CRIME "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON L2D_ORGANOGRAMA_CRIME.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdOrg='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            pINTERNO_L2D = conecta.rs.getInt("IdInternoCrc");
            caminhoL2D = conecta.rs.getString("FotoInternoCrc");
            if (caminhoL2D != null) {
                javax.swing.ImageIcon h = new javax.swing.ImageIcon(caminhoL2D);
                jFotoL15.setIcon(h);
                jFotoL15.setIcon(new ImageIcon(h.getImage().getScaledInstance(jFotoL15.getWidth(), jFotoL15.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO INTERNO NO BANCO DE DADOS
            byte[] imgBytes15 = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes15 != null) {
                ImageIcon pic15 = null;
                pic15 = new ImageIcon(imgBytes15);
                Image scaled = pic15.getImage().getScaledInstance(jFotoL15.getWidth(), jFotoL15.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon15 = new ImageIcon(scaled);
                jFotoL15.setIcon(icon15);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTodasLocacao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataOrg");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdOrg"), dataEntrada, conecta.rs.getString("StatusOrg"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLocacao.setModel(modelo);
        jTabelaLocacao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaLocacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLocacao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaLocacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLocacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLocacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLocacao.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaLocacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLocacao.getTableHeader().setReorderingAllowed(false);
        jTabelaLocacao.setAutoResizeMode(jTabelaLocacao.AUTO_RESIZE_OFF);
        jTabelaLocacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaLocacao();
        conecta.desconecta();
    }

    public void limparTabelaLocacao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLocacao.setModel(modelo);
        jTabelaLocacao.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaLocacao.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLocacao.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaLocacao.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLocacao.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLocacao.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLocacao.getColumnModel().getColumn(3).setPreferredWidth(380);
        jTabelaLocacao.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLocacao.getTableHeader().setReorderingAllowed(false);
        jTabelaLocacao.setAutoResizeMode(jTabelaLocacao.AUTO_RESIZE_OFF);
        jTabelaLocacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaLocacao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaLocacao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaLocacao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaLocacao.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroup = conecta.rs.getInt("IdUsuario");
            codigoGrupo = conecta.rs.getInt("IdGrupo");
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcesso = conecta.rs.getInt("IdUsuario");
            codAbrir = conecta.rs.getInt("Abrir");
            codIncluir = conecta.rs.getInt("Incluir");
            codAlterar = conecta.rs.getInt("Alterar");
            codExcluir = conecta.rs.getInt("Excluir");
            codGravar = conecta.rs.getInt("Gravar");
            codConsultar = conecta.rs.getInt("Consultar");
            nomeTela = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
