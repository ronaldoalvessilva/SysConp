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
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleRegistroVisitaPortariaExterna;
import gestor.Controle.ControleVisitaInterno;
import static gestor.Controle.ControleVisitaInterno.count;
import static gestor.Controle.ControleVisitaInterno.qtdVisitas;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.Digital;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroChegadaVisitaPortariaExterna;
import gestor.Modelo.VisitaInterno;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPortariaExterna.codAbrirP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codAlterarP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codConsultarP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codExcluirP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codGravarP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codIncluirP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codUserAcessoP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codigoGrupoP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codigoUserGroupP1E;
import static gestor.Visao.TelaModuloPortariaExterna.codigoUserP1E;
import static gestor.Visao.TelaModuloPortariaExterna.nomeGrupoP1E;
import static gestor.Visao.TelaModuloPortariaExterna.nomeTelaP1E;
import static gestor.Visao.TelaModuloPortariaExterna.telaRegistroChegadaPortExtBioP1E;
import static gestor.Visao.TelaModuloPortariaExterna.telaRegistroChegadaPortExtManuP1E;
import static gestor.Visao.TelaModuloPortariaExterna.telaRegistroChegadaPortExtPesqP1E;
import static gestor.Visao.TelaModuloPortariaExterna.telaRegistroChegadaPortExtRelP1E;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronal
 */
public class TelaRegistroChegadaVisitasInternosPortariaExterna extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitaInterno objVisita = new VisitaInterno();
    RegistroChegadaVisitaPortariaExterna objRegChegaVisitas = new RegistroChegadaVisitaPortariaExterna();
    ControleRegistroVisitaPortariaExterna control = new ControleRegistroVisitaPortariaExterna();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela2 = "Portaria Externa:Registro de Chegada de  Visitas de Internos:Biometria/Manual";
    String statusMov;
    String horaMov;
    String dataModFinal;
    String dataInicial;
    String dataFinal;
    String dataRegistro = "";
    String dataPesquisa = "";
    String dataRelatorio = "";
    String codLanc;
    String caminho, caminhoVisita;
    int flag;
    int count1;
    // VARIVAEL PARA ARMAZENAR AS DIGITAIS DO BANCO DE DADOS
    String caminhoBiometria = "";
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturada = null;
    // PESQUISA PARA TRAZER AS VISITAS ATIVAS E COM BIOMETRIA CADASTRADA   
    String pVisita = "";
    String statusVisita = "Ativo";
    // VERIFICAR SE O INTERNO E A VISITA JÁ EXISTEM, IMPEDINDO DE GRAVAR DUPLICIDADE
    String codigoInternoGrava = "";
    String codigoVisitaGrava = "";
    String codigoRegistroGrava = "";
    // VARIVAIES DE DATA DE ENTRADA E SAIDA DA VISITA
    String dataEntrada;
    String dataSaida;
    // CAMINHO DAS FOTOS DE INTERNOS E VISITAS
    public static String caminhoFotoVisita;
    public static String caminhoFotoInterno;
    String horarioSaidaBio = "00:00";
    public static byte[] assinaturaVisita = null;
    public static byte[] imagemFreteVisita = null;
    int codigoItem = 0;
    int tipoOperacao = 0;
    int ordemChegada = 0; //ORDEM DE REGISTRO E CHEGADA DA VISITA A PORTARIA

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

    /**
     * Creates new form TelaRegistroChegadaVisitasInternosPortariaExterna
     */
    public TelaRegistroChegadaVisitasInternosPortariaExterna() {
        initComponents();
        corCampos();
        formatarCampos();
        verificarVisitasBiometrica();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPesqNomeVisitaInterno = new javax.swing.JTextField();
        jBtPesqVisitaInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaVisitasInternos = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIdInternoBio = new javax.swing.JTextField();
        jNomeInternoBio = new javax.swing.JTextField();
        jRegimePenal = new javax.swing.JTextField();
        jPavilhao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCodigoVisita = new javax.swing.JTextField();
        jGrauParentesco = new javax.swing.JTextField();
        jNomeVisitante = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jIdRol = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jRBDigital = new javax.swing.JRadioButton();
        jRBManual = new javax.swing.JRadioButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMotivoLancamentoManual = new javax.swing.JTextArea();
        jBtNovo = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jRegistro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jStatus = new javax.swing.JTextField();
        jBtCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jFotoVisita = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jBtIniciarLeitor = new javax.swing.JButton();
        jBtCancelarLeitura = new javax.swing.JButton();
        jBtPesquisarVisita = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jBtImpressao = new javax.swing.JButton();
        jDataRelChegada = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Registro de Chegada Visitas Internos {PORTARIA EXTERNA} :::...");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N

        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Nome Visita:");

        jPesqNomeVisitaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqVisitaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisitaInterno.setToolTipText("Pesquisar Visita");
        jBtPesqVisitaInterno.setContentAreaFilled(false);
        jBtPesqVisitaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitaInternoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPesqNomeVisitaInterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqVisitaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1)))
                        .addGap(21, 21, 21))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeVisitaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqVisitaInterno)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaVisitasInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitasInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Nome da Visita do Interno", "Grau Parentesco"
            }
        ));
        jTabelaVisitasInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaVisitasInternos);
        if (jTabelaVisitasInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitasInternos.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaVisitasInternos.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaVisitasInternos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaVisitasInternos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaVisitasInternos.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaVisitasInternos.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaVisitasInternos.getColumnModel().getColumn(3).setMinWidth(150);
            jTabelaVisitasInternos.getColumnModel().getColumn(3).setMaxWidth(150);
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane4.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Regime");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Pavilhão");

        jIdInternoBio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoBio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdInternoBio.setEnabled(false);

        jNomeInternoBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoBio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoBio.setEnabled(false);

        jRegimePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimePenal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jRegimePenal.setEnabled(false);

        jPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPavilhao.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Grau de Parentesco");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome do Visitante");

        jCodigoVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoVisita.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoVisita.setEnabled(false);

        jGrauParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jGrauParentesco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jGrauParentesco.setEnabled(false);

        jNomeVisitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeVisitante.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jRegimePenal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPavilhao)
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jGrauParentesco)
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jIdInternoBio)
                                        .addGap(6, 6, 6)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNomeInternoBio)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jNomeVisitante))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdInternoBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRegimePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Chegada:");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Horário Chegada:");

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioEntrada.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHorarioEntrada.setEnabled(false);

        jIdRol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRol.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdRol.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("ID Rol:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Tipo Operação:");

        grupoBotoes.add(jRBDigital);
        jRBDigital.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBDigital.setForeground(new java.awt.Color(204, 0, 0));
        jRBDigital.setText("Digital");
        jRBDigital.setEnabled(false);
        jRBDigital.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBDigitalItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBManual);
        jRBManual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBManual.setForeground(new java.awt.Color(0, 0, 204));
        jRBManual.setText("Manual");
        jRBManual.setEnabled(false);
        jRBManual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBManualItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jRBDigital)
                        .addGap(18, 18, 18)
                        .addComponent(jRBManual))
                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jRBDigital)
                    .addComponent(jRBManual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/filesave.png"))); // NOI18N
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Motivo Registro Manual/Exclusão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jMotivoLancamentoManual.setColumns(20);
        jMotivoLancamentoManual.setRows(5);
        jMotivoLancamentoManual.setEnabled(false);
        jScrollPane1.setViewportView(jMotivoLancamentoManual);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/novo.gif"))); // NOI18N
        jBtNovo.setToolTipText("Npvo Registro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código:");

        jRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegistro.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Status:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Data:");

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatus.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatus.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel18)
                        .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082324_32.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar Operação");
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelar, jBtNovo, jBtSair, jBtSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelar, jBtNovo, jBtSair, jBtSalvar});

        jTabbedPane4.addTab("Manutenção", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Visitante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jFotoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtIniciarLeitor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtIniciarLeitor.setForeground(new java.awt.Color(0, 153, 51));
        jBtIniciarLeitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16.png"))); // NOI18N
        jBtIniciarLeitor.setText("Iniciar Leitura");
        jBtIniciarLeitor.setToolTipText("Iniciar Leitura Biometrica");
        jBtIniciarLeitor.setEnabled(false);
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
        jBtCancelarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarLeituraActionPerformed(evt);
            }
        });

        jBtPesquisarVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesquisarVisita.setForeground(new java.awt.Color(0, 0, 204));
        jBtPesquisarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarVisita.setText("Pesquisar Visita");
        jBtPesquisarVisita.setToolTipText("Pesquisar Visita");
        jBtPesquisarVisita.setEnabled(false);
        jBtPesquisarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPesquisarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIniciarLeitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarLeitura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor, jBtPesquisarVisita});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtPesquisarVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtIniciarLeitor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarLeitura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor, jBtPesquisarVisita});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Data da Chegada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 51, 0))); // NOI18N

        jBtImpressao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Relatório Chegada");
        jBtImpressao.setToolTipText("Impressão dos Registros de Chegada");
        jBtImpressao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jDataRelChegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtImpressao, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jDataRelChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jDataRelChegada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtImpressao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel12, jPanel3, jPanel7, jPanel8});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(300, 30, 752, 551);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIniciarLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIniciarLeitorActionPerformed
        // TODO add your handling code here:    
        buscarAcessoUsuario(telaRegistroChegadaPortExtBioP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaRegistroChegadaPortExtBioP1E) && codAbrirP1E == 1) {
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
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
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

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroChegadaPortExtManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaRegistroChegadaPortExtManuP1E) && codGravarP1E == 1) {
            jStatus.setText("FINALIZADO");
//            verificarOrdemChegada();
            verificarInternoVisitaCadastrado();
            if (jIdInternoBio.getText().equals("") || jNomeInternoBio.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Interno para gravar o registro.");
            } else if (jCodigoVisita.getText().equals("") || jNomeVisitante.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita para gravar o registro.");
            } else if (jIdRol.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual Rol a visita pertence.");
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de chegada da visita.");
            } else if (jHorarioEntrada.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário de chegada da visita.");
            } else if (jRBManual.isSelected() && jMotivoLancamentoManual.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o motivo pelo qual o registro está sendo manual.");
            } else {
                if (jRBDigital.isSelected()) {
                    tipoOperacao = 1;
                } else if (!jRBDigital.isSelected()) {
                    tipoOperacao = 0;
                }
                objRegChegaVisitas.setStatusReg(jStatus.getText());
                objRegChegaVisitas.setDataReg(jDataRegistro.getDate());
                objRegChegaVisitas.setIdInternoCrc(Integer.valueOf(jIdInternoBio.getText()));
                objRegChegaVisitas.setNomeInterno(jNomeInternoBio.getText());
                objRegChegaVisitas.setIdVisita(Integer.valueOf(jCodigoVisita.getText()));
                objRegChegaVisitas.setNomeVisita(jNomeVisitante.getText());
                objRegChegaVisitas.setDataChegada(jDataEntrada.getDate());
                objRegChegaVisitas.setHoraChegada(jHorarioEntrada.getText());
                objRegChegaVisitas.setIdRol(Integer.valueOf(jIdRol.getText()));
                objRegChegaVisitas.setTipoAssinatura(tipoOperacao);
                objRegChegaVisitas.setMotivoNaoAssinarDigital(jMotivoLancamentoManual.getText());
                objRegChegaVisitas.setAssinaturaDigitalVisita(pDigitalCapturada);
                if (jIdInternoBio.getText().trim().equals(codigoInternoGrava) && jCodigoVisita.getText().trim().equals(codigoVisitaGrava) && dataPesquisa.equals(dataRegistro)) {
                    JOptionPane.showMessageDialog(rootPane, "Essa visita já está registrada.");
                } else if (!jIdInternoBio.getText().trim().equals(codigoInternoGrava) && !jCodigoVisita.getText().trim().equals(codigoVisitaGrava) && !dataPesquisa.equals(dataRegistro)) {
                    verificarOrdemChegada();
                    if (dataPesquisa.equals(dataRegistro)) {
                        ordemChegada = ordemChegada + 1;
                        objRegChegaVisitas.setOrdemChegadaVisita(ordemChegada);
                        // Para o log do registro
                        objRegChegaVisitas.setUsuarioInsert(nameUser);
                        objRegChegaVisitas.setDataInsert(dataModFinal);
                        objRegChegaVisitas.setHorarioInsert(horaMov);
                        control.incluirRegistroChegadaVisitasInternos(objRegChegaVisitas);
                        buscarRegistroChegada();
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realizar outro cadastro?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            Novo();
                        }
                    } else {
                        ordemChegada = 1;
                        objRegChegaVisitas.setOrdemChegadaVisita(ordemChegada);
                        // Para o log do registro
                        objRegChegaVisitas.setUsuarioInsert(nameUser);
                        objRegChegaVisitas.setDataInsert(dataModFinal);
                        objRegChegaVisitas.setHorarioInsert(horaMov);
                        control.incluirRegistroChegadaVisitasInternos(objRegChegaVisitas);
                        buscarRegistroChegada();
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realizar outro cadastro?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            Novo();
                        }
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroChegadaPortExtManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaRegistroChegadaPortExtManuP1E) && codIncluirP1E == 1) {
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            popularTabelaNomeVisita("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE IdRegVisita='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

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
                    popularTabelaNomeVisita("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                            + "WHERE DataReg BETWEEN'" + dataInicial + "' "
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
                    popularTabelaNomeVisita("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                            + "WHERE DataReg BETWEEN'" + dataInicial + "' "
                            + "AND'" + dataFinal + "'");
                }
            }
        }
}
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqVisitaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitaInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeVisitaInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome ou parte do nome da Visita.");
        } else {
            popularTabelaNomeVisita("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE NomeVisita LIKE'%" + jPesqNomeVisitaInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqVisitaInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.popularTabelaNomeVisita("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdVisita=VISITASINTERNO.IdVisita");
        } else {
            jtotalRegistros.setText("");
            limparTabelaEntradaVisitas();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jRBDigitalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBDigitalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            jBtIniciarLeitor.setEnabled(true);
            jBtPesquisarVisita.setEnabled(!true);
            if (jRegistro.getText().equals("")) {
                jMotivoLancamentoManual.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jRBDigitalItemStateChanged

    private void jRBManualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBManualItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            jBtIniciarLeitor.setEnabled(!true);
            jBtPesquisarVisita.setEnabled(true);
            if (jRegistro.getText().equals("")) {
                jMotivoLancamentoManual.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jRBManualItemStateChanged

    private void jBtPesquisarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarVisitaActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaRegistroChegadaPortExtPesqP1E) && codAbrirP1E == 1) {
            TelaPesqVisitasInternoChegadaPortExt objPesqVisitaChe = new TelaPesqVisitasInternoChegadaPortExt();
            TelaModuloPortariaExterna.jPainelPortariaExterna.add(objPesqVisitaChe);
            objPesqVisitaChe.show();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtPesquisarVisitaActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaRegistroChegadaPortExtRelP1E) && codAbrirP1E == 1) {
            if (jDataRelChegada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de chegada das visitas.");
            } else {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataRelatorio = formatoAmerica.format(jDataRelChegada.getDate().getTime());
                try {
                    conecta.abrirConexao();
                    String path = "reports/RelatorioRegistroChegadaVisitaPortariaExterna.jasper";
                    conecta.executaSQL("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.DataInsert='" + dataRelatorio + "' "
                            + "ORDER BY DataChegada,HoraChegada");
                    HashMap parametros = new HashMap();
                    parametros.put("DataInsert", dataRelatorio);
                    parametros.put("descricaoUnidade", descricaoUnidade);
                    parametros.put("nomeUsuario", nameUser);
                    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                    JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                    JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                    jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                    jv.setTitle("Relatório de Registro de Chegada de Visitas na Portaria Externa");
                    jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                    jv.toFront(); // Traz o relatorio para frente da aplicação            
                    conecta.desconecta();
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jTabelaVisitasInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasInternosMouseClicked
        // TODO add your handling code here:     
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaVisitasInternos.getValueAt(jTabelaVisitasInternos.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            //            
            bloquearCamposBotoes();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdVisita=VISITASINTERNO.IdVisita "
                        + "INNER JOIN ROLVISITAS "
                        + "ON REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdRol=ROLVISITAS.IdRol "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ROLVISITAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN ITENSROL "
                        + "ON ROLVISITAS.IdRol=ITENSROL.IdRol "
                        + "WHERE REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA.IdRegVisita='" + IdLanc + "'");
                conecta.rs.first();
                jRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegVisita")));
                jStatus.setText(conecta.rs.getString("StatusReg"));
                jDataRegistro.setDate(conecta.rs.getDate("DataReg"));
                jCodigoVisita.setText(String.valueOf(conecta.rs.getInt("IdVisita")));
                jNomeVisitante.setText(conecta.rs.getString("NomeVisita"));
                jGrauParentesco.setText(conecta.rs.getString("ParentescoVisita"));
                // Capturando foto
                caminhoVisita = conecta.rs.getString("ImagemVisita");
                if (caminhoVisita != null) {
                    javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                    jFotoVisita.setIcon(v);
                    jFotoVisita.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVI"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoVisita.setIcon(icon);
                }
                jIdInternoBio.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoBio.setText(conecta.rs.getString("NomeInternoCrc"));
                jRegimePenal.setText(conecta.rs.getString("Regime"));
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                tipoOperacao = conecta.rs.getInt("TipoOperacao");
                if (tipoOperacao == 0) {
                    jRBManual.setSelected(true);
                } else if (tipoOperacao == 1) {
                    jRBDigital.setSelected(true);
                }
                jIdRol.setText(String.valueOf(conecta.rs.getInt("IdRol")));
                jDataEntrada.setDate(conecta.rs.getDate("DataChegada"));
                jHorarioEntrada.setText(conecta.rs.getString("HoraChegada"));
                jMotivoLancamentoManual.setText(conecta.rs.getString("MotivoNaoAssinarDigital"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaVisitasInternosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarLeitura;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtIniciarLeitor;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqVisitaInterno;
    private javax.swing.JButton jBtPesquisarVisita;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCodigoVisita;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    private com.toedter.calendar.JDateChooser jDataRelChegada;
    public static javax.swing.JLabel jFotoVisita;
    public static javax.swing.JTextField jGrauParentesco;
    private javax.swing.JFormattedTextField jHorarioEntrada;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdInternoBio;
    public static javax.swing.JTextField jIdRol;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jMotivoLancamentoManual;
    public static javax.swing.JTextField jNomeInternoBio;
    public static javax.swing.JTextField jNomeVisitante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
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
    public static javax.swing.JTextField jPavilhao;
    private javax.swing.JTextField jPesqNomeVisitaInterno;
    private javax.swing.JRadioButton jRBDigital;
    private javax.swing.JRadioButton jRBManual;
    public static javax.swing.JTextField jRegimePenal;
    private javax.swing.JTextField jRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jStatus;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTabelaVisitasInternos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    private static Runnable LerDigital1 = new Runnable() {
        @Override
        public void run() {
            try {
                // Instanciar a DLL
                TelaAcessoBiometria.CIS_SDK dll = TelaAcessoBiometria.CIS_SDK.INSTANCE;
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
                ControleVisitaInterno digiControl = new ControleVisitaInterno();
                Digital d = new Digital();
                int pVar = 0;
                for (Digital dd : digiControl.read()) {
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
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisita = dd.getImagemFrenteVI();
                        if (imagemFreteVisita != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisita);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO DOIS
                    } else if (iRetornod1 == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisita = dd.getImagemFrenteVI();
                        if (imagemFreteVisita != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisita);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO TRÊS
                    } else if (iRetornod2 == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisita = dd.getImagemFrenteVI();
                        if (imagemFreteVisita != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisita);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO QUATRO
                    } else if (iRetornod3 == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisita = dd.getImagemFrenteVI();
                        if (imagemFreteVisita != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisita);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    }
                    // SE TODOS AS DIGITAIS FOREM IGUAL A -2 , DIGITAL NÃO CADASTRADA
                    if (iRetorno == -2 && iRetornod1 == -2 && iRetornod2 == -2 && iRetornod3 == -2 && qtdVisitas == pVar) {
                        break;
                    }
                    pVar = pVar + 1;
                }
                JOptionPane.showMessageDialog(null, "Digital não cadastrada, procure o Serviço Social !!!");
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
        jRegistro.setBackground(Color.white);
        jStatus.setBackground(Color.white);
        jIdRol.setBackground(Color.white);
        jIdInternoBio.setBackground(Color.white);
        jNomeInternoBio.setBackground(Color.white);
        jRegimePenal.setBackground(Color.white);
        jPavilhao.setBackground(Color.white);
        jCodigoVisita.setBackground(Color.white);
        jGrauParentesco.setBackground(Color.white);
        jNomeVisitante.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
        jMotivoLancamentoManual.setBackground(Color.white);
    }

    public void formatarCampos() {
        jMotivoLancamentoManual.setLineWrap(true);
        jMotivoLancamentoManual.setWrapStyleWord(true);
    }

    public void bloquearCamposBotoes() {
        jIdRol.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jRBDigital.setEnabled(!true);
        jRBManual.setEnabled(!true);
        jMotivoLancamentoManual.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(!true);
        jBtPesquisarVisita.setEnabled(!true);
    }

    public void Novo() {
        ordemChegada = 0;
        //
        dataRegistro = "";
        dataPesquisa = "";
        //
        jRegistro.setText("");
        jStatus.setText("ABERTO");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jIdInternoBio.setText("");
        jNomeInternoBio.setText("");
        jRegimePenal.setText("");
        jPavilhao.setText("");
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jGrauParentesco.setText("");
        jNomeVisitante.setText("");
        jMotivoLancamentoManual.setText("");
        //
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText(jHoraSistema.getText());
        //        
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jRBDigital.setEnabled(true);
        jRBManual.setEnabled(true);
        //
        grupoBotoes.clearSelection();
        //
        jBtNovo.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtIniciarLeitor.setEnabled(!true);
        jBtPesquisarVisita.setEnabled(!true);
    }

    public void Salvar() {
        jIdRol.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jRBDigital.setEnabled(!true);
        jRBManual.setEnabled(!true);
        jMotivoLancamentoManual.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(!true);
        jBtPesquisarVisita.setEnabled(!true);
    }

    public void Cancelar() {
        if (jRegistro.getText().equals("")) {
            jIdInternoBio.setText("");
            jNomeInternoBio.setText("");
            jRegimePenal.setText("");
            jPavilhao.setText("");
            jCodigoVisita.setText("");
            jNomeVisitante.setText("");
            jGrauParentesco.setText("");
            jFotoVisita.setIcon(null);
            jIdRol.setText("");
            jDataEntrada.setDate(null);
            jHorarioEntrada.setText("");
            jMotivoLancamentoManual.setText("");
            //
            jDataEntrada.setEnabled(!true);
            jHorarioEntrada.setEnabled(!true);
            jRBDigital.setEnabled(!true);
            jRBManual.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtIniciarLeitor.setEnabled(!true);
            jBtPesquisarVisita.setEnabled(!true);
        } else {
            jDataEntrada.setEnabled(!true);
            jHorarioEntrada.setEnabled(!true);
            jRBDigital.setEnabled(!true);
            jRBManual.setEnabled(!true);
            jMotivoLancamentoManual.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtIniciarLeitor.setEnabled(!true);
            jBtPesquisarVisita.setEnabled(!true);

        }
    }

    public void buscarRegistroChegada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA");
            conecta.rs.last();
            jRegistro.setText(conecta.rs.getString("IdRegVisita"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do lancamento.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarVisitasBiometrica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO "
                    + "WHERE BiometriaDedo1!='" + pVisita + "' "
                    + "AND StatusVisita='" + statusVisita + "'");
            count = count + 1;
            do {
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
    }

    public void verificarInternoVisitaCadastrado() {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataPesquisa = formatoAmerica.format(jDataRegistro.getDate().getTime());
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                    + "WHERE IdInternoCrc='" + jIdInternoBio.getText() + "' "
                    + "AND IdVisita='" + jCodigoVisita.getText() + "' "
                    + "AND DataInsert='" + dataPesquisa + "'");
            conecta.rs.first();
            codigoInternoGrava = conecta.rs.getString("IdInternoCrc");
            codigoVisitaGrava = conecta.rs.getString("IdVisita");
            codigoRegistroGrava = conecta.rs.getString("IdRegVisita");
            dataRegistro = conecta.rs.getString("DataInsert");
            ordemChegada = conecta.rs.getInt("OrdemChegada");
            assinaturaVisita = conecta.rs.getBytes("AssinaturaDigitalVisita");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarOrdemChegada() {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataPesquisa = formatoAmerica.format(jDataRegistro.getDate().getTime());
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA "
                    + "WHERE DataInsert='" + dataPesquisa + "'");
            conecta.rs.last();
            dataRegistro = conecta.rs.getString("DataInsert");
            ordemChegada = conecta.rs.getInt("OrdemChegada");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void popularTabelaNomeVisita(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome da Visita do Interno", "Grau de Parentesco"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataChegada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRegVisita"), dataEntrada, conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaVisitasInternos.setModel(modelo);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternos.setAutoResizeMode(jTabelaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaTodas();
        conecta.desconecta();
    }

    public void limparTabelaEntradaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome da Visita do Interno", "Grau de Parentesco"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA 
        jTabelaVisitasInternos.setModel(modelo);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternos.setAutoResizeMode(jTabelaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaTodas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserP1E = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1E + "'");
            conecta.rs.first();
            codigoUserGroupP1E = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1E = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1E = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1E + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1E = conecta.rs.getInt("IdUsuario");
            codAbrirP1E = conecta.rs.getInt("Abrir");
            codIncluirP1E = conecta.rs.getInt("Incluir");
            codAlterarP1E = conecta.rs.getInt("Alterar");
            codExcluirP1E = conecta.rs.getInt("Excluir");
            codGravarP1E = conecta.rs.getInt("Gravar");
            codConsultarP1E = conecta.rs.getInt("Consultar");
            nomeTelaP1E = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
