/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEntradaSaidaEducacao;
import gestor.Controle.ControleHistoricoInstituicaoInternos;
import gestor.Controle.ControleInternosEntradaSaidaEducacao;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.ModeloTabela;
import gestor.Modelo.EntradaSaidaEducacao;
import gestor.Modelo.HistoricoInternoEducacao;
import gestor.Modelo.InternosEntradaSaidaEducacional;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPortarias.codigoUserGroupP1;
import static gestor.Visao.TelaModuloPortarias.codigoGrupoP1;
import static gestor.Visao.TelaModuloPortarias.codAbrirP1;
import static gestor.Visao.TelaModuloPortarias.codAlterarP1;
import static gestor.Visao.TelaModuloPortarias.codExcluirP1;
import static gestor.Visao.TelaModuloPortarias.codGravarP1;
import static gestor.Visao.TelaModuloPortarias.codConsultarP1;
import static gestor.Visao.TelaModuloPortarias.codIncluirP1;
import static gestor.Visao.TelaModuloPortarias.codUserAcessoP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserP1;
import static gestor.Visao.TelaModuloPortarias.nomeGrupoP1;
import static gestor.Visao.TelaModuloPortarias.nomeTelaP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaESIEEManuP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaESIEEIP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ronaldo
 */
public class TelaRegistroEntradaSaidaEducacional extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaEducacao objEntSaiEdu = new EntradaSaidaEducacao();
    ControleEntradaSaidaEducacao control = new ControleEntradaSaidaEducacao();
    InternosEntradaSaidaEducacional objInteEntSaiEduca = new InternosEntradaSaidaEducacional();
    ControleInternosEntradaSaidaEducacao controle = new ControleInternosEntradaSaidaEducacao();
    HistoricoInternoEducacao objHistInterEdu = new HistoricoInternoEducacao();
    ControleHistoricoInstituicaoInternos controlHist = new ControleHistoricoInstituicaoInternos();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Entrada/Saida de Internos Educação P1:Manutenção";
    String nomeModuloTela2 = "Portaria:Entrada/Saida de Internos Educação P1:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag;
    int acao;
    String dataInicial, dataFinal, dataEntrada, dataSaida, dataEntraSai;
    public static String idItem;
    String codlanc;
    String caminho;
    int count = 0;
    // VARIAVEIS PARA BLOQUEAR O REGISTRO CASO NÃO ESTEJA COM OS HORÁRIOS PREENCHIDOS COM AS HORAS.
    String verHorarioSaida = "00:00";
    String verHorarioEntrada = "00:00";
    String horaEntradaEncontrada, codigoRegistro, horaSaidaEncontrado;
    //
    String mesAtual;
    String codigoInterno;
    String codigoInternoCrc, statusFreqLab, mesReferencia, anoReferencia, dataPeriodoInicial, dataPeriodoFinal;
    String statusFreq = "ABERTO";
    int vQuant = 1;
    int qtdDias;
    int qtdDiastotal = 0;
    //
    byte[] pAssinaturaDigitralSaida;
    byte[] pAssinaturaDigitalEntrada;

    /**
     * Creates new form TelaRegistroEntradaSaidaEducacional
     */
    public static TelaFotoPortariaSaidaEducacional telafotosaidaeduca;
    public static TelaBiometriaSaidaEducacaoPortaria biometriaSaidaInternoEdu;

    public TelaRegistroEntradaSaidaEducacional() {
        super();
        initComponents();
        setResizable(false);
        formatarCampo();
        corCampos();
    }

    public void mostraFotoSaidaEdu() {
        telafotosaidaeduca = new TelaFotoPortariaSaidaEducacional(this, true);
        telafotosaidaeduca.setVisible(true);
    }

    public void mostrarBiometriaSaidaInternos() {
        biometriaSaidaInternoEdu = new TelaBiometriaSaidaEducacaoPortaria(this, true);
        biometriaSaidaInternoEdu.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jBtPesqData = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPesqInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEntraSaiInternosEstuda = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jIdCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jNomeInstituicao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBtPesqInstituicao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jBtBuscarInterno = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jIdInternoEduExt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeInternoEdu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jBtPesqInternoEdu = new javax.swing.JButton();
        jMatriculaInternoEdu = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTotalItens = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jObservacaoInternoEdu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jDataEntradaEdu = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jHorarioEntradaEdu = new javax.swing.JFormattedTextField();
        jPanel13 = new javax.swing.JPanel();
        jDataSaidaEdu = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jHorarioSaidaEdu = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        FotoInternoEdu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtZoon = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        jTextField6.setText("jTextField6");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Registro Entrada/Saida Educacional {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome Interno:");

        jPesqInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPesqInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaEntraSaiInternosEstuda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEntraSaiInternosEstuda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaEntraSaiInternosEstuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEntraSaiInternosEstudaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEntraSaiInternosEstuda);
        if (jTabelaEntraSaiInternosEstuda.getColumnModel().getColumnCount() > 0) {
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(3).setMinWidth(400);
            jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(3).setMaxWidth(400);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

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

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 204));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtNovo))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jIdCod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdCod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdCod.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jNomeInstituicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInstituicao.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome da Instituição");

        jBtPesqInstituicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInstituicao.setContentAreaFilled(false);
        jBtPesqInstituicao.setEnabled(false);
        jBtPesqInstituicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInstituicaoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBackground(new java.awt.Color(255, 255, 255));
        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jIdCod, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 221, Short.MAX_VALUE))
                            .addComponent(jStatusLanc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(156, 156, 156))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jNomeInstituicao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdCod, jIdLanc});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Instituição", jPanel7);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Observação", jPanel8);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setText("Novo");
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setText("Alterar");
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setText("Excluir");
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setText("Gravar");
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setText("Cancelar");
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAuditoriaInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaInterno.setForeground(new java.awt.Color(0, 0, 204));
        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        jBtBuscarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarInterno.setText("Buscar");
        jBtBuscarInterno.setEnabled(false);
        jBtBuscarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarInternoActionPerformed(evt);
            }
        });

        jBtBiometria.setForeground(new java.awt.Color(255, 0, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setText("Biometria");
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtBiometria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtNovoInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtBuscarInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(65, 65, 65))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtBuscarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBiometria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Data Entrada", "Horário", "Data Saída", "Horário"
            }
        ));
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        jTabbedPane3.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Código");

        jIdInternoEduExt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoEduExt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoEduExt.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome Completo do Interno");

        jNomeInternoEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEdu.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Matricula Penal");

        jBtPesqInternoEdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoEdu.setContentAreaFilled(false);
        jBtPesqInternoEdu.setEnabled(false);
        jBtPesqInternoEdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoEduActionPerformed(evt);
            }
        });

        jMatriculaInternoEdu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaInternoEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaInternoEdu.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Total Registros");

        jTotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jTotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTotalItens.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jNomeInternoEdu)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jIdInternoEduExt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqInternoEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMatriculaInternoEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTotalItens, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                            .addComponent(jLabel7))
                        .addGap(118, 118, 118))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoEduExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInternoEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(jMatriculaInternoEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jNomeInternoEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane3.addTab("Internos", jPanel3);

        jObservacaoInternoEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoInternoEdu.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Observação:");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jDataEntradaEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntradaEdu.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Data Entrada");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setText("Horário Entrada");

        jHorarioEntradaEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntradaEdu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioEntradaEdu.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEntradaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jHorarioEntradaEdu, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHorarioEntradaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEntradaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jDataSaidaEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaidaEdu.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Data Saída");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Horário Saída");

        jHorarioSaidaEdu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaidaEdu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioSaidaEdu.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jDataSaidaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jHorarioSaidaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHorarioSaidaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaidaEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jObservacaoInternoEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jObservacaoInternoEdu)
                    .addComponent(jLabel13))
                .addGap(13, 13, 13))
        );

        jTabbedPane3.addTab("Horários", jPanel11);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoEdu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoEdu, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtFinalizar.setForeground(new java.awt.Color(0, 102, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtZoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoon.setText("Zoon");
        jBtZoon.setToolTipText("Aumentar Foto de Interno");
        jBtZoon.setEnabled(false);
        jBtZoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtZoon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jBtZoon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jBtFinalizar)
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/contact-list-preferences-icone-4703-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(300, 20, 834, 543);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
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
                    jTabelaEntraSaiInternosEstuda.setVisible(true);
                    preencherTodasEntSai("SELECT * FROM ENTRADA_SAIDA_EDUCACAO "
                            + "INNER JOIN INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                            + "ON ENTRADA_SAIDA_EDUCACAO.IdLanc=INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdLanc "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            preencherTodasEntSai("SELECT * FROM ENTRADA_SAIDA_EDUCACAO "
                    + "INNER JOIN INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                    + "ON ENTRADA_SAIDA_EDUCACAO.IdLanc=INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ENTRADA_SAIDA_EDUCACAO.IdLanc='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome ou parte do nome do interno para pesquisa.");
        } else {
            preencherTodasEntSai("SELECT * FROM ENTRADA_SAIDA_EDUCACAO "
                    + "INNER JOIN INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                    + "ON ENTRADA_SAIDA_EDUCACAO.IdLanc=INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntSai("SELECT * FROM ENTRADA_SAIDA_EDUCACAO");
        } else {
            jtotalRegistros.setText("");
            limparTabelaTodos();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqInstituicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInstituicaoActionPerformed
        // TODO add your handling code here:
        TelaPesqInstituicaoEscolarPortaria objPesInstEscoPort = new TelaPesqInstituicaoEscolarPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objPesInstEscoPort);
        objPesInstEscoPort.show();
    }//GEN-LAST:event_jBtPesqInstituicaoActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEntradaSaidaInternosEduca objAudiEntSaiEduca = new TelaAuditoriaEntradaSaidaInternosEduca();
        TelaModuloPortarias.jPainelPortarias.add(objAudiEntSaiEduca);
        objAudiEntSaiEduca.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        verificarHoraEntradaInternos();
        if (jHorarioSaidaEdu.getText().equals(horaSaidaEncontrado) && jIdLanc.getText().equals(codigoRegistro) || jHorarioEntradaEdu.getText().equals(horaEntradaEncontrada) && jIdLanc.getText().equals(codigoRegistro)) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível FINALIZAR esse registro, existe(m) horário(s) de entrada de interno(s) em aberto.\nCorrija os horários com divergências e então poderá FINALIZAR o documento. ");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADA_SAIDA_EDUCACAO WHERE IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                if (jStatusLanc.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
                } else {
                    Finalizar();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEManuP1) && codIncluirP1 == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEManuP1) && codAlterarP1 == 1) {
            objEntSaiEdu.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEManuP1) && codExcluirP1 == 1) {
            objEntSaiEdu.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse lançamento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarInternos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEManuP1) && codGravarP1 == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a Data de Lançamento.");
            } else if (jIdCod.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a instituição educacional do interno.");
            } else {
                objEntSaiEdu.setStatusLanc(jStatusLanc.getText());
                objEntSaiEdu.setDataLanc(jDataLanc.getDate());
                objEntSaiEdu.setNomeInstituicao(jNomeInstituicao.getText());
                objEntSaiEdu.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objEntSaiEdu.setUsuarioInsert(nameUser);
                    objEntSaiEdu.setDataInsert(dataModFinal);
                    objEntSaiEdu.setHorarioInsert(horaMov);
                    //
                    control.incluirEntSaiEducar(objEntSaiEdu);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objEntSaiEdu.setUsuarioUp(nameUser);
                    objEntSaiEdu.setDataUp(dataModFinal);
                    objEntSaiEdu.setHorarioUp(horaMov);
                    //
                    objEntSaiEdu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarEntSaiEducar(objEntSaiEdu);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jTabelaEntraSaiInternosEstudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEntraSaiInternosEstudaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaEntraSaiInternosEstuda.getValueAt(jTabelaEntraSaiInternosEstuda.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN INSTITUICAOESCOLAR "
                        + "ON ENTRADA_SAIDA_EDUCACAO.IdCod=INSTITUICAOESCOLAR.IdCod "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("Statuslanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIdCod.setText(conecta.rs.getString("IdCod"));
                jNomeInstituicao.setText(conecta.rs.getString("NomeInstituicao"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            count = 0; // Zera contador de registros de internos.
            preencherTabelaItens("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + IdLanc + "'");
        }
    }//GEN-LAST:event_jTabelaEntraSaiInternosEstudaMouseClicked

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqInternoEduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoEduActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosLaborEduca objPesIntEduca = new TelaPesqInternosLaborEduca();
        TelaModuloPortarias.jPainelPortarias.add(objPesIntEduca);
        objPesIntEduca.show();
    }//GEN-LAST:event_jBtPesqInternoEduActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeColaborador = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            jNomeInternoEdu.setText(nomeColaborador);
            idItem = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2);
            // Habilitar os botões
            jBtZoon.setEnabled(true);
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtBuscarInterno.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(true);
            //
            //  jDatalancamento.setEnabled(!true);
            jBtPesqInternoEdu.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInternoEdu.getText() + "' "
                        + "AND IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdInternoEduExt.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoEdu.setText(conecta.rs.getString("NomeInternoCrc"));
                idItem = conecta.rs.getString("IdItem");
                jMatriculaInternoEdu.setText(conecta.rs.getString("MatriculaCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoInternoEdu.setIcon(i);
                    FotoInternoEdu.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoEdu.getWidth(), FotoInternoEdu.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInternoEdu.getWidth(), FotoInternoEdu.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInternoEdu.setIcon(icon);
                }
                jDataEntradaEdu.setDate(conecta.rs.getDate("DataEntrada"));
                jHorarioEntradaEdu.setText(conecta.rs.getString("HorarioEntrada"));
                jDataSaidaEdu.setDate(conecta.rs.getDate("DataSaida"));
                jHorarioSaidaEdu.setText(conecta.rs.getString("HorarioSaida"));
                jObservacaoInternoEdu.setText(conecta.rs.getString("Observacao"));
                pAssinaturaDigitralSaida = conecta.rs.getBytes("AssinaturaSaida");
                pAssinaturaDigitalEntrada = conecta.rs.getBytes("AssinaturaEntrada");
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEIP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEIP1) && codIncluirP1 == 1) {
            objEntSaiEdu.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInterno();
                corCampos();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEIP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEIP1) && codAlterarP1 == 1) {
            objEntSaiEdu.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (pAssinaturaDigitralSaida != null && pAssinaturaDigitalEntrada == null) {
                    AlterarInternoBio();
                } else if (pAssinaturaDigitralSaida == null && pAssinaturaDigitalEntrada == null) {
                    acao = 4;
                    AlterarInterno();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }else if(pAssinaturaDigitralSaida != null && pAssinaturaDigitalEntrada != null){
                    JOptionPane.showMessageDialog(rootPane, "Não é possível alterar esse registro, o mesmo foi assinado através da biometria de interno.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEIP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEIP1) && codExcluirP1 == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEntSaiEdu.setStatusLanc(jStatusLanc.getText());
            if (pAssinaturaDigitralSaida != null) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível Excluir esse registro, o mesmo foi assinado através da biometria.");
            } else {
                if (jStatusLanc.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Essa registro de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o interno selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objDatasHoras();
                        controlHist.excluirInterEdu(objHistInterEdu);
                        objInteEntSaiEduca.setIdItem(Integer.valueOf(idItem));
                        controle.excluiEntSaiInternoEducar(objInteEntSaiEduca);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        ExcluirInterno();
                        preencherTabelaItens("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESIEEIP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEIP1) && codGravarP1 == 1) {
            horaEntradaEncontrada = "";
            horaSaidaEncontrado = "";
            count = 0;
            if (jIdInternoEduExt.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jDataSaidaEdu.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de saida do interno.");
            } else if (jHorarioSaidaEdu.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário de saída do interno.");
            } else {
                objInteEntSaiEduca.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objInteEntSaiEduca.setIdInternoCrc(Integer.valueOf(jIdInternoEduExt.getText()));
                objHistInterEdu.setNomeInterno(jNomeInternoEdu.getText());
                objInteEntSaiEduca.setNomeInternoEduca(jNomeInternoEdu.getText());
                objInteEntSaiEduca.setDataSaida(jDataSaidaEdu.getDate());
                objInteEntSaiEduca.setHorarioSaida(jHorarioSaidaEdu.getText());
                objInteEntSaiEduca.setDataEntrada(jDataEntradaEdu.getDate());
                objInteEntSaiEduca.setHorarioEntrada(jHorarioEntradaEdu.getText());
                objInteEntSaiEduca.setObservacao(jObservacaoInternoEdu.getText());
                if (acao == 3) {
                    objInteEntSaiEduca.setUsuarioInsert(nameUser);
                    objInteEntSaiEduca.setDataInsert(dataModFinal);
                    objInteEntSaiEduca.setHorarioInsert(horaMov);
                    //
                    controle.incluirEntSaiInternoEducar(objInteEntSaiEduca);
                    buscarIdItem();
                    //Inclusão do histórico do interno na instituição
                    objHistInterEdu.setNomeInstituicao(jNomeInstituicao.getText());
                    objHistInterEdu.setIdInternoCrc(Integer.valueOf(jIdInternoEduExt.getText()));
                    objHistInterEdu.setNomeInterno(jNomeInternoEdu.getText());
                    objDatasHoras();
                    controlHist.incluirInterEdu(objHistInterEdu);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    SalvarInterno();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    objInteEntSaiEduca.setUsuarioUp(nameUser);
                    objInteEntSaiEduca.setDataUp(dataModFinal);
                    objInteEntSaiEduca.setHorarioUp(horaMov);
                    //
                    objInteEntSaiEduca.setIdItem(Integer.valueOf(idItem));
                    controle.alterarEntSaiInternoEducar(objInteEntSaiEduca);
                    //Alteração do histórico do interno na empresa                    
                    objHistInterEdu.setNomeInstituicao(jNomeInstituicao.getText());
                    objHistInterEdu.setIdInternoCrc(Integer.valueOf(jIdInternoEduExt.getText()));
                    objHistInterEdu.setNomeInterno(jNomeInternoEdu.getText());
                    objDatasHoras();
                    controlHist.alterarInterEdu(objHistInterEdu);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOS_ENTRADA_SAIDA_EDUCACAO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    SalvarInterno();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtBuscarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarInternoActionPerformed
        // TODO add your handling code here:
        TelaBuscarInternosLaborEducar objBuscarEduca = new TelaBuscarInternosLaborEducar();
        TelaModuloPortarias.jPainelPortarias.add(objBuscarEduca);
        objBuscarEduca.show();
    }//GEN-LAST:event_jBtBuscarInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEntSaiIntEduca objAudEntSaiIntEduca = new TelaAuditoriaItensEntSaiIntEduca();
        TelaModuloPortarias.jPainelPortarias.add(objAudEntSaiIntEduca);
        objAudEntSaiIntEduca.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtZoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonActionPerformed
        // TODO add your handling code here:
        mostraFotoSaidaEdu();
    }//GEN-LAST:event_jBtZoonActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        mostrarBiometriaSaidaInternos();
    }//GEN-LAST:event_jBtBiometriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel FotoInternoEdu;
    private javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtBiometria;
    public static javax.swing.JButton jBtBuscarInterno;
    private javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqInstituicao;
    private javax.swing.JButton jBtPesqInternoEdu;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarInterno;
    public static javax.swing.JButton jBtZoon;
    private javax.swing.JCheckBox jCheckBox1;
    public static com.toedter.calendar.JDateChooser jDataEntradaEdu;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaidaEdu;
    public static javax.swing.JFormattedTextField jHorarioEntradaEdu;
    public static javax.swing.JFormattedTextField jHorarioSaidaEdu;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdCod;
    public static javax.swing.JTextField jIdInternoEduExt;
    public static javax.swing.JTextField jIdLanc;
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
    public static javax.swing.JTextField jMatriculaInternoEdu;
    public static javax.swing.JTextField jNomeInstituicao;
    public static javax.swing.JTextField jNomeInternoEdu;
    private javax.swing.JTextArea jObservacao;
    public static javax.swing.JTextField jObservacaoInternoEdu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JTextField jPesqInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabelaEntraSaiInternosEstuda;
    public static javax.swing.JTable jTabelaInternos;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel jTotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampo() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jObservacaoInternoEdu.setDocument(new LimiteDigitos(50));
        try {
            MaskFormatter horarioEntrada = new MaskFormatter("##:##");
            jHorarioEntradaEdu.setFormatterFactory(new DefaultFormatterFactory(horarioEntrada));
            MaskFormatter horarioSaida = new MaskFormatter("##:##");
            jHorarioSaidaEdu.setFormatterFactory(new DefaultFormatterFactory(horarioSaida));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível formatar os campos de hora.");
        }
    }

    public void bloquearCamposPesquisa() {
        jDataLanc.setEnabled(!true);
        jIdCod.setEnabled(!true);
        jNomeInstituicao.setEnabled(!true);
        jBtPesqInstituicao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInternoEduExt.setText("");
        jNomeInternoEdu.setText("");
        jMatriculaInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("00:00");
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("00:00");
        //
        jIdInternoEduExt.setEnabled(!true);
        jNomeInternoEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jBtPesqInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(true);
        jBtZoon.setEnabled(!true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIdCod.setBackground(Color.white);
        jNomeInstituicao.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInternoEduExt.setBackground(Color.white);
        jMatriculaInternoEdu.setBackground(Color.white);
        jNomeInternoEdu.setBackground(Color.white);
        FotoInternoEdu.setBackground(Color.white);
        //
        jDataSaidaEdu.setBackground(Color.white);
        jHorarioSaidaEdu.setBackground(Color.white);
        jDataEntradaEdu.setBackground(Color.white);
        jHorarioEntradaEdu.setBackground(Color.white);
        jObservacaoInternoEdu.setBackground(Color.white);
    }

    public void Novo() {
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIdCod.setText("");
        jNomeInstituicao.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        jBtPesqInstituicao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jBtZoon.setEnabled(!true);
        jBtPesqInternoEdu.setEnabled(!true);
        //
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("00:00");
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("00:00");
        jObservacaoInternoEdu.setText("");
        //
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jObservacaoInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        limparTabelaItens();
    }

    public void Alterar() {
        //
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        jBtPesqInstituicao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jBtPesqInternoEdu.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("");
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("");
        jObservacaoInternoEdu.setText("");
        //
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jObservacaoInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
    }

    public void Excluir() {
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jIdCod.setText("");
        jNomeInstituicao.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jBtPesqInstituicao.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("");
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("");
        jObservacaoInternoEdu.setText("");
        //
        jBtPesqInternoEdu.setEnabled(!true);
        //
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jObservacaoInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Salvar() {
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jBtPesqInstituicao.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jIdCod.setText("");
            jNomeInstituicao.setText("");
            jObservacao.setText("");
            //
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            jBtPesqInstituicao.setEnabled(!true);
            jBtZoon.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //
            jIdInternoEduExt.setText("");
            jMatriculaInternoEdu.setText("");
            jNomeInternoEdu.setText("");
            FotoInternoEdu.setIcon(null);
            //
            jDataSaidaEdu.setDate(null);
            jHorarioSaidaEdu.setText("");
            jDataEntradaEdu.setDate(null);
            jHorarioEntradaEdu.setText("");
            jObservacaoInternoEdu.setText("");
            //
            jBtPesqInternoEdu.setEnabled(!true);
            jBtZoon.setEnabled(!true);
            //
            jDataSaidaEdu.setEnabled(!true);
            jHorarioSaidaEdu.setEnabled(!true);
            jDataEntradaEdu.setEnabled(!true);
            jHorarioEntradaEdu.setEnabled(!true);
            jObservacaoInternoEdu.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            jBtPesqInstituicao.setEnabled(!true);
            jBtZoon.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jIdInternoEduExt.setText("");
            jMatriculaInternoEdu.setText("");
            jNomeInternoEdu.setText("");
            FotoInternoEdu.setIcon(null);
            //
            jDataSaidaEdu.setDate(null);
            jHorarioSaidaEdu.setText("");
            jDataEntradaEdu.setDate(null);
            jHorarioEntradaEdu.setText("");
            jObservacaoInternoEdu.setText("");
            //
            jBtPesqInternoEdu.setEnabled(!true);
            //
            jDataSaidaEdu.setEnabled(!true);
            jHorarioSaidaEdu.setEnabled(!true);
            jDataEntradaEdu.setEnabled(!true);
            jHorarioEntradaEdu.setEnabled(!true);
            jObservacaoInternoEdu.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objEntSaiEdu.setStatusLanc(statusLanc);
            objEntSaiEdu.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarEntSaiEducar(objEntSaiEdu);
            // GRAVAR NA TABELA DE ITENS_FREQUENCIA_LABORATIVA_EXTERNA
            gravarRegistroLaborativo();
            jStatusLanc.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtPesqInstituicao.setEnabled(!true);
            jDataLanc.setEnabled(!true);
            jDataEntradaEdu.setEnabled(!true);
            jHorarioEntradaEdu.setEnabled(!true);
            jDataSaidaEdu.setEnabled(!true);
            jHorarioSaidaEdu.setEnabled(!true);
            jBtPesqInternoEdu.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
        }
    }

    // GRAVAR AS FREQUENCIAS DOS INTERNOS NO MOMENTO QUE FOR FINALIZADO O DOCUMENTO NA TABELA ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA
    public void gravarRegistroLaborativo() {
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro na tabela a ser lançado.");
        } else {
            for (int i = 0; i < jTabelaInternos.getRowCount(); i++) {
                objInteEntSaiEduca.setIdInternoCrc((int) jTabelaInternos.getValueAt(i, 0));
                pegarDataRegistro();
                pegarDadosInterno();
                qtdDiastotal = qtdDias + vQuant;
                if (codigoInterno.equals(codigoInternoCrc) && mesReferencia.equals(mesAtual) && statusFreqLab.equals(statusFreq)) {
                    objInteEntSaiEduca.setIdInternoCrc((int) jTabelaInternos.getValueAt(i, 0));
                    objInteEntSaiEduca.setQtdInt(qtdDiastotal);
                    objInteEntSaiEduca.setMesReferencia(mesReferencia);
                    // GRAVA NA TABELA DE ITENS_FREQUENCIA_PEDAGOGIA_EXERNA
                    controle.alterarQuantidadeFrequencia(objInteEntSaiEduca);
                }
            }
        }
    }

    // PEGAR O MES DA DATA NA TABELA ITENSLABORINTERNO PARA GRAVAR NA TABELA DE ITENS_FREQUENCIA_LABORATIVA_EXTERNA (10/03/2016)
    public void pegarDataRegistro() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "'AND IdInternoCrc='" + objInteEntSaiEduca.getIdInternoCrc() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            dataEntrada = conecta.rs.getString("DataEntrada");
            String dia = dataEntrada.substring(8, 10);
            String mes = dataEntrada.substring(5, 7);
            String ano = dataEntrada.substring(0, 4);
            dataEntrada = dia + "/" + mes + "/" + ano;
            java.util.Date dt = df.parse(dataEntrada);
            DateFormat df2 = new SimpleDateFormat("MMMMM", new Locale("pt", "BR"));
            mesAtual = df2.format(dt);
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // TABELA DE FREQUENCIA_LABORATIVA_EXTERNA E ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA
    public void pegarDadosInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "INNER JOIN ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "ON FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab=ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab "
                    + "WHERE ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdInternoCrc='" + objInteEntSaiEduca.getIdInternoCrc() + "'AND StatusFreqlab='" + statusFreq + "'");
            conecta.rs.first();
            statusFreqLab = conecta.rs.getString("StatusFreqLab");
            mesReferencia = conecta.rs.getString("MesReferencia");
            anoReferencia = conecta.rs.getString("AnoReferencia");
            codigoInternoCrc = conecta.rs.getString("IdInternoCrc");
            qtdDias = conecta.rs.getInt("TotalDias");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADA_SAIDA_EDUCACAO");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("Idlanc"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
    }

    public void verificarHoraEntradaInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO WHERE HorarioSaida='" + verHorarioSaida + "'AND Idlanc='" + jIdLanc.getText() + "'OR HorarioEntrada='" + verHorarioEntrada + "'AND Idlanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            horaEntradaEncontrada = conecta.rs.getString("HorarioEntrada");
            horaSaidaEncontrado = conecta.rs.getString("HorarioSaida");
            codigoRegistro = conecta.rs.getString("Idlanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternos() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codlanc = conecta.rs.getString("IdLanc");
            if (jIdLanc.getText().equals(codlanc)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEntSaiEdu.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                control.excluirEntSaiEducar(objEntSaiEdu);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void NovoInterno() {
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jBtPesqInstituicao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jDataSaidaEdu.setCalendar(Calendar.getInstance());
        jHorarioSaidaEdu.setText("00:00");
        jDataEntradaEdu.setCalendar(Calendar.getInstance());
        jHorarioEntradaEdu.setText("00:00");
        jObservacaoInternoEdu.setText("");
        //
        jBtPesqInternoEdu.setEnabled(true);
        jBtZoon.setEnabled(!true);
        //
        jDataSaidaEdu.setEnabled(true);
        jHorarioSaidaEdu.setEnabled(true);
        jDataEntradaEdu.setEnabled(true);
        jHorarioEntradaEdu.setEnabled(true);
        jObservacaoInternoEdu.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void AlterarInterno() {
        jBtPesqInternoEdu.setEnabled(true);
        jBtZoon.setEnabled(true);
        //
        jDataSaidaEdu.setEnabled(true);
        jHorarioSaidaEdu.setEnabled(true);
        jDataEntradaEdu.setEnabled(true);
        jHorarioEntradaEdu.setEnabled(true);
        jObservacaoInternoEdu.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void AlterarInternoBio() {
        jBtZoon.setEnabled(true);
        //        
        jDataEntradaEdu.setEnabled(true);
        jHorarioEntradaEdu.setEnabled(true);
        jObservacaoInternoEdu.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void ExcluirInterno() {
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("00:00");
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("00:00");
        jObservacaoInternoEdu.setText("");
        //
        jBtPesqInternoEdu.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jObservacaoInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarInterno() {
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("00:00");
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("00:00");
        jObservacaoInternoEdu.setText("");
        //
        jBtPesqInternoEdu.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jObservacaoInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarInterno() {
        jIdInternoEduExt.setText("");
        jMatriculaInternoEdu.setText("");
        jNomeInternoEdu.setText("");
        FotoInternoEdu.setIcon(null);
        //
        jDataSaidaEdu.setDate(null);
        jHorarioSaidaEdu.setText("00:00");
        jDataEntradaEdu.setDate(null);
        jHorarioEntradaEdu.setText("00:00");
        jObservacaoInternoEdu.setText("");
        //
        jBtPesqInternoEdu.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jDataSaidaEdu.setEnabled(!true);
        jHorarioSaidaEdu.setEnabled(!true);
        jDataEntradaEdu.setEnabled(!true);
        jHorarioEntradaEdu.setEnabled(!true);
        jObservacaoInternoEdu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarIdItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO");
            conecta.rs.last();
            idItem = conecta.rs.getString("IdItem");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.");
        }
        conecta.desconecta();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Entrada", "Horário", "Data Saída", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                if (dataEntrada != null) {
                    String dia = dataEntrada.substring(8, 10);
                    String mes = dataEntrada.substring(5, 7);
                    String ano = dataEntrada.substring(0, 4);
                    dataEntrada = dia + "/" + mes + "/" + ano;
                }
                // Formatar a data Saida               
                dataSaida = conecta.rs.getString("DataSaida");
                String dias = dataSaida.substring(8, 10);
                String mess = dataSaida.substring(5, 7);
                String anos = dataSaida.substring(0, 4);
                dataSaida = dias + "/" + mess + "/" + anos;
                jTotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInterno();
        conecta.desconecta();
    }

    public void alinharCamposTabelaInterno() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void preencherTodasEntSai(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                // Formatar a data Entrada
                dataEntraSai = conecta.rs.getString("DataLanc");
                String dial = dataEntraSai.substring(8, 10);
                String mesl = dataEntraSai.substring(5, 7);
                String anol = dataEntraSai.substring(0, 4);
                dataEntraSai = dial + "/" + mesl + "/" + anol;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntraSai, conecta.rs.getString("StatusLanc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntraSaiInternosEstuda.setModel(modelo);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getTableHeader().setReorderingAllowed(false);
        jTabelaEntraSaiInternosEstuda.setAutoResizeMode(jTabelaEntraSaiInternosEstuda.AUTO_RESIZE_OFF);
        jTabelaEntraSaiInternosEstuda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaTabelaEntraSai();
        conecta.desconecta();
    }

    public void alinhaTabelaEntraSai() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaTodos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntraSaiInternosEstuda.setModel(modelo);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEntraSaiInternosEstuda.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntraSaiInternosEstuda.getTableHeader().setReorderingAllowed(false);
        jTabelaEntraSaiInternosEstuda.setAutoResizeMode(jTabelaEntraSaiInternosEstuda.AUTO_RESIZE_OFF);
        jTabelaEntraSaiInternosEstuda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Entrada", "Horário", "Data Saída", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objDatasHoras() {
        objHistInterEdu.setIdItem(Integer.valueOf(idItem));
        objHistInterEdu.setIdInternoCrc(Integer.valueOf(jIdInternoEduExt.getText()));
        objHistInterEdu.setNomeInterno(jNomeInternoEdu.getText());
        objHistInterEdu.setDataEntrada(jDataEntradaEdu.getDate());
        objHistInterEdu.setHorarioEntrada(jHorarioEntradaEdu.getText());
        objHistInterEdu.setDataSaida(jDataSaidaEdu.getDate());
        objHistInterEdu.setHorarioSaida(jHorarioSaidaEdu.getText());
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserP1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1 + "'");
            conecta.rs.first();
            codigoUserGroupP1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1 = conecta.rs.getInt("IdUsuario");
            codAbrirP1 = conecta.rs.getInt("Abrir");
            codIncluirP1 = conecta.rs.getInt("Incluir");
            codAlterarP1 = conecta.rs.getInt("Alterar");
            codExcluirP1 = conecta.rs.getInt("Excluir");
            codGravarP1 = conecta.rs.getInt("Gravar");
            codConsultarP1 = conecta.rs.getInt("Consultar");
            nomeTelaP1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
