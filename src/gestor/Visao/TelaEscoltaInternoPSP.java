/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEscoltaInternosPSP;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.EscoltaInternosPSP;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloBaseDois.codAbrirB2;
import static gestor.Visao.TelaModuloBaseDois.codExcluirB2;
import static gestor.Visao.TelaModuloBaseDois.codAlterarB2;
import static gestor.Visao.TelaModuloBaseDois.codGravarB2;
import static gestor.Visao.TelaModuloBaseDois.codIncluirB2;
import static gestor.Visao.TelaModuloBaseDois.codConsultarB2;
import static gestor.Visao.TelaModuloBaseDois.codUserAcessoB2;
import static gestor.Visao.TelaModuloBaseDois.codigoUserB2;
import static gestor.Visao.TelaModuloBaseDois.nomeGrupoB2;
import static gestor.Visao.TelaModuloBaseDois.nomeTelaB2;
import static gestor.Visao.TelaModuloBaseDois.codigoUserGroupB2;
import static gestor.Visao.TelaModuloBaseDois.codigoGrupoB2;
import static gestor.Visao.TelaModuloBaseUm.codIncluirB1;
import static gestor.Visao.TelaModuloBaseUm.codUserAcessoB1;
import static gestor.Visao.TelaModuloBaseUm.codigoUserB1;
import static gestor.Visao.TelaModuloBaseUm.codigoUserGroupB1;
import static gestor.Visao.TelaModuloBaseUm.codigoGrupoB1;
import static gestor.Visao.TelaModuloBaseUm.nomeGrupoB1;
import static gestor.Visao.TelaModuloBaseUm.nomeTelaB1;
import static gestor.Visao.TelaModuloBaseUm.telaEscoltaInternoPSP_B1;
import static gestor.Visao.TelaModuloBaseDois.telaEscoltaInternoPSP_B2;
import static gestor.Visao.TelaModuloBaseUm.codAbrirB1;
import static gestor.Visao.TelaModuloBaseUm.codConsultarB1;
import static gestor.Visao.TelaModuloBaseUm.codAlterarB1;
import static gestor.Visao.TelaModuloBaseUm.codExcluirB1;
import static gestor.Visao.TelaModuloBaseUm.codGravarB1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class TelaEscoltaInternoPSP extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscoltaInternosPSP objEscolta = new EscoltaInternosPSP();
    ControleEscoltaInternosPSP control = new ControleEscoltaInternosPSP();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Base Pavilhão:Escolta de Interno PSP:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int count;
    String dataRegistro;
    String dataSaida;
    String dataInicial;
    String dataFinal;
    String pCODIGO_REGISTRO = "";
    //
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturadaColaborador = null;
    public static byte[] pDigitalCapturadaInterno = null;
    public static byte[] pDigitalCapturadaColaboradorLiberador = null;
    public static String pLiberacaoImpressa = "Não";
    public static int codigoLiberador = 0;
    public static String nomeLiberador = "";
    public static String dataAssinatura = "";
    public static String horaAssinatura = "";
    //
    String pCAMINHO_FOTO_INTERNO = "";
    String pCAMINHO_FOTO_COLABORADOR = "";
    //
    byte[] pBYTES_FOTO_INTERNO;
    byte[] pBYTES_FOTO_COLABORADOR;

    /**
     * Creates new form TelaEscoltaInternoPSP
     */
    public static TelaAssinaturaoBiometriaColaboradoresEscoltaPSP funcBio;
    public static TelaRegistroInternosBasePSP bioInterno;
    public static TelaAssinaturaoBiometriaColaboradorLiberadorEscoltaPSP liberBio;

    public TelaEscoltaInternoPSP() {
        initComponents();
        corCampos();
    }

    public void mostrarFunc() {
        funcBio = new TelaAssinaturaoBiometriaColaboradoresEscoltaPSP(this, true);
        funcBio.setVisible(true);
    }

    public void mostrarInterno() {
        bioInterno = new TelaRegistroInternosBasePSP(this, true);
        bioInterno.setVisible(true);
    }

    public void mostrarLiberador() {
        liberBio = new TelaAssinaturaoBiometriaColaboradorLiberadorEscoltaPSP(this, true);
        liberBio.setVisible(true);
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
        jBtPesqData = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jPesqNomeInternoVisitado = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jBtPesqNomeColaborador = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaPagamentoKit = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jBtBiometriaColaborador = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBtBiometriaInterno = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jHoraSaidaEscolta = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDataRetorno = new com.toedter.calendar.JDateChooser();
        jHoraRetorno = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jIdColaboradorEscolta = new javax.swing.JTextField();
        jIdInternoCrc = new javax.swing.JTextField();
        jNomeInternoCrc = new javax.swing.JTextField();
        jNomeColaboradorEscolta = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jFotoColaboradorEscolta = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jFotoInternoEscolta = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtLiberador = new javax.swing.JButton();
        jBtRetorno = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jDataRegistro = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Escolta Interno Pavilhão/PSP :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jCheckBox19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox19.setText("Todos");
        jCheckBox19.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox19ItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome Interno:");

        jPesqNomeInternoVisitado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome Monitor:");

        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeColaborador.setContentAreaFilled(false);
        jBtPesqNomeColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox19))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jPesqNomeInternoVisitado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jCheckBox19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeColaborador)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPagamentoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPagamentoKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno", "Nome do Colaborador"
            }
        ));
        jTabelaPagamentoKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPagamentoKitMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaPagamentoKit);
        if (jTabelaPagamentoKit.getColumnModel().getColumnCount() > 0) {
            jTabelaPagamentoKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(3).setMinWidth(350);
            jTabelaPagamentoKit.getColumnModel().getColumn(3).setMaxWidth(350);
            jTabelaPagamentoKit.getColumnModel().getColumn(4).setMinWidth(350);
            jTabelaPagamentoKit.getColumnModel().getColumn(4).setMaxWidth(350);
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

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Biometria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jBtBiometriaColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria42.png"))); // NOI18N
        jBtBiometriaColaborador.setToolTipText("Biometria do Colaborador");
        jBtBiometriaColaborador.setEnabled(false);
        jBtBiometriaColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtBiometriaColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtBiometriaColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Biometria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jBtBiometriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria42Vermelho.png"))); // NOI18N
        jBtBiometriaInterno.setToolTipText("Biometria do Interno");
        jBtBiometriaInterno.setEnabled(false);
        jBtBiometriaInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBiometriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtBiometriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtBiometriaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Hora");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jHoraSaidaEscolta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSaidaEscolta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraSaidaEscolta.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jHoraSaidaEscolta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraSaidaEscolta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Retorno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Hora");

        jDataRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRetorno.setEnabled(false);

        jHoraRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraRetorno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraRetorno.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jHoraRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome do Colaborador");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Código");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome do Interno");

        jIdColaboradorEscolta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdColaboradorEscolta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdColaboradorEscolta.setEnabled(false);

        jIdInternoCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoCrc.setEnabled(false);

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrc.setEnabled(false);

        jNomeColaboradorEscolta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaboradorEscolta.setEnabled(false);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoColaboradorEscolta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaboradorEscolta, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaboradorEscolta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoInternoEscolta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoEscolta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoEscolta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jIdInternoCrc)
                            .addComponent(jIdColaboradorEscolta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jNomeColaboradorEscolta)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jNomeColaboradorEscolta, jNomeInternoCrc});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jIdColaboradorEscolta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeColaboradorEscolta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel6, jPanel7});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtLiberador.setForeground(new java.awt.Color(0, 102, 0));
        jBtLiberador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Base1-18.png"))); // NOI18N
        jBtLiberador.setToolTipText("Liberador");
        jBtLiberador.setContentAreaFilled(false);
        jBtLiberador.setEnabled(false);
        jBtLiberador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLiberadorActionPerformed(evt);
            }
        });

        jBtRetorno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtRetorno.setText("Retorno");
        jBtRetorno.setContentAreaFilled(false);
        jBtRetorno.setEnabled(false);
        jBtRetorno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtRetorno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtRetorno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRetornoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(0, 0, 0)
                .addComponent(jBtRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvar)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelar)
                .addGap(0, 0, 0)
                .addComponent(jBtSair)
                .addGap(18, 18, 18)
                .addComponent(jBtLiberador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAuditoria)
                .addComponent(jBtSair)
                .addComponent(jBtCancelar)
                .addComponent(jBtSalvar)
                .addComponent(jBtNovo)
                .addComponent(jBtRetorno)
                .addComponent(jBtLiberador))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código:");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Status:");

        jComboBoxStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Saída", "Retorno" }));
        jComboBoxStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatus.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data:");

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );

        setBounds(300, 30, 467, 484);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherTabelaPagotKit("SELECT * FROM ESCOLTA_INTERNO_PSP "
                                + "INNER JOIN COLABORADOR "
                                + "ON ESCOLTA_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ESCOLTA_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataRegistro BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherTabelaPagotKit("SELECT * FROM ESCOLTA_INTERNO_PSP "
                                + "INNER JOIN COLABORADOR "
                                + "ON ESCOLTA_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ESCOLTA_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataRegistro BETWEEN'" + dataInicial + "' "
                                + "AND'" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um Código para pesquisa.");
        } else {
            preencherTabelaPagotKit("SELECT * FROM ESCOLTA_INTERNO_PSP "
                    + "INNER JOIN COLABORADOR "
                    + "ON ESCOLTA_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ESCOLTA_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdEsco='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jCheckBox19ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox19ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaPagotKit("SELECT * FROM ESCOLTA_INTERNO_PSP "
                    + "INNER JOIN COLABORADOR "
                    + "ON ESCOLTA_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ESCOLTA_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox19ItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInternoVisitado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisa.");
        } else {
            preencherTabelaPagotKit("SELECT * FROM ESCOLTA_INTERNO_PSP "
                    + "INNER JOIN COLABORADOR "
                    + "ON ESCOLTA_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ESCOLTA_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jTabelaPagamentoKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPagamentoKitMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaPagamentoKit.getValueAt(jTabelaPagamentoKit.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtRetorno.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            limparCamposManutencao();
            bloquearCampos();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ESCOLTA_INTERNO_PSP "
                        + "INNER JOIN COLABORADOR "
                        + "ON ESCOLTA_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ESCOLTA_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdEsco='" + IdLanc + "'");
                conecta.rs.first();
                jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdEsco")));
                jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusEscolta"));
                jDataRegistro.setDate(conecta.rs.getDate("DataRegistro"));
                jIdColaboradorEscolta.setText(conecta.rs.getString("IdFunc"));
                jNomeColaboradorEscolta.setText(conecta.rs.getString("NomeFunc"));
                jIdInternoCrc.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoCrc.setText(conecta.rs.getString("NomeInternoCrc"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jHoraSaidaEscolta.setText(conecta.rs.getString("HoraSaida"));
                jDataRetorno.setDate(conecta.rs.getDate("DataRetorno"));
                jHoraRetorno.setText(conecta.rs.getString("HoraRetorno"));
                pCAMINHO_FOTO_COLABORADOR = conecta.rs.getString("ImagemFunc");
                pBYTES_FOTO_COLABORADOR = conecta.rs.getBytes("ImagemFrenteCO");
                //
                pCAMINHO_FOTO_INTERNO = conecta.rs.getString("FotoInternoCrc");
                pBYTES_FOTO_INTERNO = conecta.rs.getBytes("ImagemFrente");

                //FOTO DO INTERNO
                if (pCAMINHO_FOTO_INTERNO != null) {
                    javax.swing.ImageIcon a = new javax.swing.ImageIcon(pCAMINHO_FOTO_INTERNO);
                    jFotoInternoEscolta.setIcon(a);
                    jFotoInternoEscolta.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoEscolta.getWidth(), jFotoInternoEscolta.getHeight(), Image.SCALE_DEFAULT)));
                } else if (pBYTES_FOTO_INTERNO != null) {
                    ImageIcon pic2 = null;
                    pic2 = new ImageIcon(pBYTES_FOTO_INTERNO);
                    Image scaled2 = pic2.getImage().getScaledInstance(jFotoInternoEscolta.getWidth(), jFotoInternoEscolta.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(scaled2);
                    jFotoInternoEscolta.setIcon(icon2);
                }
                //FOTO DO COLABORADOR
                if (pCAMINHO_FOTO_COLABORADOR != null) {
                    javax.swing.ImageIcon a = new javax.swing.ImageIcon(pCAMINHO_FOTO_COLABORADOR);
                    jFotoColaboradorEscolta.setIcon(a);
                    jFotoColaboradorEscolta.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoColaboradorEscolta.getWidth(), jFotoColaboradorEscolta.getHeight(), Image.SCALE_DEFAULT)));
                } else if (pBYTES_FOTO_COLABORADOR != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(pBYTES_FOTO_COLABORADOR);
                    Image scaled = pic.getImage().getScaledInstance(jFotoColaboradorEscolta.getWidth(), jFotoColaboradorEscolta.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoColaboradorEscolta.setIcon(icon);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaPagamentoKitMouseClicked

    private void jBtPesqNomeColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtPesqNomeColaboradorActionPerformed

    private void jBtBiometriaColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaColaboradorActionPerformed
        // TODO add your handling code here:
        mostrarFunc();
    }//GEN-LAST:event_jBtBiometriaColaboradorActionPerformed

    private void jBtBiometriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaInternoActionPerformed
        // TODO add your handling code here:
        mostrarInterno();
    }//GEN-LAST:event_jBtBiometriaInternoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioB1(telaEscoltaInternoPSP_B1);
        buscarAcessoUsuarioB2(telaEscoltaInternoPSP_B2);
        if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEscoltaInternoPSP_B1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos();
            bloquearBotoes();
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEscoltaInternoPSP_B2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos();
            bloquearBotoes();
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRetornoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxStatus.getSelectedItem().equals("Saída")) {
            buscarAcessoUsuarioB1(telaEscoltaInternoPSP_B1);
            buscarAcessoUsuarioB2(telaEscoltaInternoPSP_B2);
            if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEscoltaInternoPSP_B1) && codAlterarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
                acao = 2;
                Retorno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEscoltaInternoPSP_B2) && codAlterarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
                acao = 2;
                Retorno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível fazer o retorno, pois, não existe registro de saída para esse interno.");
        }
    }//GEN-LAST:event_jBtRetornoActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioB1(telaEscoltaInternoPSP_B1);
        buscarAcessoUsuarioB2(telaEscoltaInternoPSP_B2);
        if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEscoltaInternoPSP_B1) && codGravarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jComboBoxStatus.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o status do registro, SAIDA ou RETORNO.");
            } else if (jIdColaboradorEscolta.getText().equals("") || jNomeColaboradorEscolta.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário que o colaborador faça a assinatura.");
            } else if (jIdInternoCrc.getText().equals("") || jNomeInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário que o interno assine, ou seja liberado por outro colaborador.");
            } else if (jDataSaida.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de saída do interno.");
            } else if (jHoraSaidaEscolta.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de saída do interno.");
            } else if (jComboBoxStatus.getSelectedItem().equals("Retorno") && jDataRetorno.getDate() == null && jHoraRetorno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "O interno está retornando, então é necessário assinar.");
            } else {
                objEscolta.setStatusEscolta((String) jComboBoxStatus.getSelectedItem());
                objEscolta.setDataRegistro(jDataRegistro.getDate());
                objEscolta.setIdInternoCrc(Integer.valueOf(jIdInternoCrc.getText()));
                objEscolta.setNomeInternoCrc(jNomeInternoCrc.getText());
                objEscolta.setIdFunc(Integer.valueOf(jIdColaboradorEscolta.getText()));
                objEscolta.setNomeColaborador(jNomeColaboradorEscolta.getText());
                objEscolta.setDataSaida(jDataSaida.getDate());
                objEscolta.setHoraSaida(jHoraSaidaEscolta.getText());
                //ASSINATURA BIOMETRICA DE SAIDA DO COLABORADOR E DO INTERNO
                objEscolta.setAssinaturaColaboradorSaida(pDigitalCapturadaColaborador);
                objEscolta.setAssinaturaInternoSaida(pDigitalCapturadaInterno);
                //ASSINATURA BIOMETRICA DE ENTRADA DO COLABORADOR E DO INTERNO
                objEscolta.setAssinaturaColaboradorEntrada(pDigitalCapturadaColaborador);
                objEscolta.setAssinaturaInternoEntrada(pDigitalCapturadaInterno);
                //ASSINATURA DO LIBERADOR QUANDO NECESSÁRIO - SAÍDA
                objEscolta.setAssinaturaColaboradorLiberadorSaida(pDigitalCapturadaColaboradorLiberador);
                //
                objEscolta.setDataEntrada(jDataRetorno.getDate());
                objEscolta.setHoraEntrada(jHoraRetorno.getText());
                //
                if (acao == 1) {
                    // Para o log do registro
                    objEscolta.setUsuarioInsert(nameUser);
                    objEscolta.setDataInsert(dataModFinal);
                    objEscolta.setHorarioInsert(horaMov);
                    //
                    control.incluirEscoltaInternoPSP(objEscolta);
                    bloquearCampos();
                    bloquearBotoes();
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    jComboBoxStatus.setSelectedItem("Saída");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    // Log do registro usuarios
                    objEscolta.setUsuarioUp(nameUser);
                    objEscolta.setDataUp(dataModFinal);
                    objEscolta.setHorarioUp(horaMov);
                    //
                    objEscolta.setIdEsco(Integer.valueOf(jIdRegistro.getText()));
                    //ASSINATURA DO LIBERADOR QUANDO NECESSÁRIO - RETORNO
                    objEscolta.setAssinaturaColaboradorLiberadorRetorno(pDigitalCapturadaColaboradorLiberador);
                    control.alterarEscoltaInternoPSP(objEscolta);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                    jComboBoxStatus.setSelectedItem("Retorno");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEscoltaInternoPSP_B2) && codGravarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            if (jComboBoxStatus.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o status do registro, SAIDA ou RETORNO.");
            } else if (jIdColaboradorEscolta.getText().equals("") || jNomeColaboradorEscolta.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário que o colaborador faça a assinatura.");
            } else if (jIdInternoCrc.getText().equals("") || jNomeInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário que o interno assine.");
            } else if (jDataSaida.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de saída do interno.");
            } else if (jHoraSaidaEscolta.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de saída do interno.");
            } else if (jComboBoxStatus.getSelectedItem().equals("Retorno") && jDataRetorno.getDate() == null && jHoraRetorno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "O interno está retornando, então é necessário assinar.");
            } else {
                objEscolta.setStatusEscolta((String) jComboBoxStatus.getSelectedItem());
                objEscolta.setDataRegistro(jDataRegistro.getDate());
                objEscolta.setIdInternoCrc(Integer.valueOf(jIdInternoCrc.getText()));
                objEscolta.setNomeInternoCrc(jNomeInternoCrc.getText());
                objEscolta.setIdFunc(Integer.valueOf(jIdColaboradorEscolta.getText()));
                objEscolta.setDataSaida(jDataSaida.getDate());
                objEscolta.setHoraSaida(jHoraSaidaEscolta.getText());
                //ASSINATURA BIOMETRICA DE SAIDA DO COLABORADOR E DO INTERNO
                objEscolta.setAssinaturaColaboradorSaida(pDigitalCapturadaColaborador);
                objEscolta.setAssinaturaInternoSaida(pDigitalCapturadaInterno);
                //ASSINATURA BIOMETRICA DE ENTRADA DO COLABORADOR E DO INTERNO
                objEscolta.setAssinaturaColaboradorEntrada(pDigitalCapturadaColaborador);
                objEscolta.setAssinaturaInternoEntrada(pDigitalCapturadaInterno);
                //ASSINATURA DO LIBERADOR QUANDO NECESSÁRIO - SAÍDA
                objEscolta.setAssinaturaColaboradorLiberadorSaida(pDigitalCapturadaColaboradorLiberador);
                //
                objEscolta.setDataEntrada(jDataRetorno.getDate());
                objEscolta.setHoraEntrada(jHoraRetorno.getText());
                //FALTA INCLUIR AS ASSINATURAS, DO COLABOADOR, INTERNO E DO LIBERADOR CASO NECESSÁRIO.
                if (acao == 1) {
                    // Para o log do registro
                    objEscolta.setUsuarioInsert(nameUser);
                    objEscolta.setDataInsert(dataModFinal);
                    objEscolta.setHorarioInsert(horaMov);
                    //
                    control.incluirEscoltaInternoPSP(objEscolta);
                    bloquearCampos();
                    bloquearBotoes();
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    jComboBoxStatus.setSelectedItem("Saída");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    // Log do registro usuarios
                    objEscolta.setUsuarioUp(nameUser);
                    objEscolta.setDataUp(dataModFinal);
                    objEscolta.setHorarioUp(horaMov);
                    //
                    objEscolta.setIdEsco(Integer.valueOf(jIdRegistro.getText()));
                    //ASSINATURA DO LIBERADOR QUANDO NECESSÁRIO - RETORNO
                    objEscolta.setAssinaturaColaboradorLiberadorRetorno(pDigitalCapturadaColaboradorLiberador);
                    control.alterarEscoltaInternoPSP(objEscolta);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                    jComboBoxStatus.setSelectedItem("Retorno");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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

    private void jBtLiberadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberadorActionPerformed
        // TODO add your handling code here:
        if (jIdColaboradorEscolta.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do colaborador que está fazendo a escolta do interno.");
        } else {
            mostrarLiberador();
        }
    }//GEN-LAST:event_jBtLiberadorActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaAuditoriaEscoltaInternos obj_AUDITORIA = new TelaAuditoriaEscoltaInternos();
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(obj_AUDITORIA);
            obj_AUDITORIA.show();
        }
        if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaAuditoriaEscoltaInternos obj_AUDITORIA = new TelaAuditoriaEscoltaInternos();
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(obj_AUDITORIA);
            obj_AUDITORIA.show();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtBiometriaColaborador;
    private javax.swing.JButton jBtBiometriaInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtLiberador;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqNomeColaborador;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtRetorno;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    private javax.swing.JCheckBox jCheckBox19;
    public static javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static com.toedter.calendar.JDateChooser jDataRetorno;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    public static javax.swing.JLabel jFotoColaboradorEscolta;
    public static javax.swing.JLabel jFotoInternoEscolta;
    public static javax.swing.JFormattedTextField jHoraRetorno;
    public static javax.swing.JFormattedTextField jHoraSaidaEscolta;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdColaboradorEscolta;
    public static javax.swing.JTextField jIdInternoCrc;
    public static javax.swing.JTextField jIdRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeColaboradorEscolta;
    public static javax.swing.JTextField jNomeInternoCrc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInternoVisitado;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPagamentoKit;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jComboBoxStatus.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jIdColaboradorEscolta.setBackground(Color.white);
        jNomeColaboradorEscolta.setBackground(Color.white);
        jIdInternoCrc.setBackground(Color.white);
        jNomeInternoCrc.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jHoraSaidaEscolta.setBackground(Color.white);
        jDataRetorno.setBackground(Color.white);
        jHoraRetorno.setBackground(Color.white);
    }

    public void limparCamposManutencao() {
        jIdRegistro.setText("");
        jComboBoxStatus.setSelectedItem("Selecione...");
        jDataRegistro.setDate(null);
        jIdColaboradorEscolta.setText("");
        jNomeColaboradorEscolta.setText("");
        jIdInternoCrc.setText("");
        jNomeInternoCrc.setText("");
        jDataSaida.setDate(null);
        jHoraSaidaEscolta.setText("");
        jDataRetorno.setDate(null);
        jHoraRetorno.setText("");
        jFotoColaboradorEscolta.setIcon(null);
        jFotoInternoEscolta.setIcon(null);
    }

    public void bloquearCampos() {
        jIdRegistro.setEnabled(!true);
        jComboBoxStatus.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jIdColaboradorEscolta.setEnabled(!true);
        jNomeColaboradorEscolta.setEnabled(!true);
        jIdInternoCrc.setEnabled(!true);
        jNomeInternoCrc.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHoraSaidaEscolta.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jHoraRetorno.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtBiometriaColaborador.setEnabled(!true);
        jBtBiometriaInterno.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtRetorno.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtLiberador.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Novo() {
        jComboBoxStatus.setSelectedItem("Saída");
        jComboBoxStatus.setEnabled(true);
        jDataRegistro.setCalendar(Calendar.getInstance());
        jBtBiometriaColaborador.setEnabled(true);
        jBtBiometriaInterno.setEnabled(true);
        jBtLiberador.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Retorno() {
        jComboBoxStatus.setSelectedItem("Retorno");
        jComboBoxStatus.setEnabled(true);
        jBtBiometriaColaborador.setEnabled(true);
        jBtBiometriaInterno.setEnabled(true);
        jBtLiberador.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Salvar() {
        jBtNovo.setEnabled(true);
        jBtRetorno.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistro.getText().equals("")) {
            limparCamposManutencao();
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtRetorno.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ESCOLTA_INTERNO_PSP");
            conecta.rs.last();
            jIdRegistro.setText(conecta.rs.getString("IdEsco"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void preencherTabelaPagotKit(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno", "Nome do Colaborador"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataRegistro = conecta.rs.getString("DataRegistro");
                String diae = dataRegistro.substring(8, 10);
                String mese = dataRegistro.substring(5, 7);
                String anoe = dataRegistro.substring(0, 4);
                dataRegistro = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdEsco"), dataRegistro, conecta.rs.getString("StatusEscolta"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("NomeFunc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPagamentoKit.setModel(modelo);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(4).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPagamentoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaPagamentoKit.setAutoResizeMode(jTabelaPagamentoKit.AUTO_RESIZE_OFF);
        jTabelaPagamentoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno", "Nome do Colaborador"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPagamentoKit.setModel(modelo);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(4).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPagamentoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaPagamentoKit.setAutoResizeMode(jTabelaPagamentoKit.AUTO_RESIZE_OFF);
        jTabelaPagamentoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void buscarAcessoUsuarioB1(String nomeTelaAcessoB1) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserB1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserB1 + "'");
            conecta.rs.first();
            codigoUserGroupB1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserB1 + "' "
                    + "AND NomeTela='" + nomeTelaAcessoB1 + "'");
            conecta.rs.first();
            codUserAcessoB1 = conecta.rs.getInt("IdUsuario");
            codAbrirB1 = conecta.rs.getInt("Abrir");
            codIncluirB1 = conecta.rs.getInt("Incluir");
            codAlterarB1 = conecta.rs.getInt("Alterar");
            codExcluirB1 = conecta.rs.getInt("Excluir");
            codGravarB1 = conecta.rs.getInt("Gravar");
            codConsultarB1 = conecta.rs.getInt("Consultar");
            nomeTelaB1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioB2(String nomeTelaAcessoB2) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserB2 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserB2 + "'");
            conecta.rs.first();
            codigoUserGroupB2 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB2 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB2 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserB2 + "' "
                    + "AND NomeTela='" + nomeTelaAcessoB2 + "'");
            conecta.rs.first();
            codUserAcessoB2 = conecta.rs.getInt("IdUsuario");
            codAbrirB2 = conecta.rs.getInt("Abrir");
            codIncluirB2 = conecta.rs.getInt("Incluir");
            codAlterarB2 = conecta.rs.getInt("Alterar");
            codExcluirB2 = conecta.rs.getInt("Excluir");
            codGravarB2 = conecta.rs.getInt("Gravar");
            codConsultarB2 = conecta.rs.getInt("Consultar");
            nomeTelaB2 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
