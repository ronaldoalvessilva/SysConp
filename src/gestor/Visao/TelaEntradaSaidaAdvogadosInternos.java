/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAlertasPortariaPavilhoes;
import gestor.Controle.ControleEntSaiAdvInternos;
import gestor.Controle.ControleItensEntSaiAdvInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleVisitasAdvogados;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AlertaVisitasPortariaPavilhoes;
import gestor.Modelo.EntradaSaidaAdvogadosInternos;
import gestor.Modelo.ItensEntradaSaidaAdvInternos;
import gestor.Modelo.LogSistema;
import gestor.Modelo.VisitasAdvogadosInternos;
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
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaAdIntInterP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaAdIntManuP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author user
 */
public class TelaEntradaSaidaAdvogadosInternos extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaAdvogadosInternos objEntSaiAdInternos = new EntradaSaidaAdvogadosInternos();
    ItensEntradaSaidaAdvInternos objItensEntSaiAdvInternos = new ItensEntradaSaidaAdvInternos();
    ControleEntSaiAdvInternos control = new ControleEntSaiAdvInternos();
    ControleItensEntSaiAdvInternos controle = new ControleItensEntSaiAdvInternos();
    VisitasAdvogadosInternos objVisitasAdvInt = new VisitasAdvogadosInternos();
    ControleVisitasAdvogados controleAd = new ControleVisitasAdvogados();
    //
    AlertaVisitasPortariaPavilhoes objAlertaPortPav = new AlertaVisitasPortariaPavilhoes();
    ControleAlertasPortariaPavilhoes controleOFPortPav = new ControleAlertasPortariaPavilhoes();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Entrada/Saida de Advogados/Internos:Manutenção";
    String nomeModuloTela2 = "Portaria:Entrada/Saida de Advogados/Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    String statusEnt = "ABERTO";
    String dataInicial;
    String dataFinal;
    String dataEntrada, dataBrasil;
    String dataSaida;
    public static String idItem;
    String codlanc;
    String idEntAd; // ID de lançamento para atualizar data e hora dos Ad. e Internos
    String caminho, caminhoAdv;
    int count = 0;
    // VARIAVEIS PARA BLOQUEAR O REGISTRO CASO NÃO ESTEJA COM OS HORÁRIOS PREENCHIDOS COM AS HORAS.
    String verHorarioSaida = "00:00";
    String verHorarioEntrada = "00:00";
    String horaEntradaEncontrada, codigoRegistro, horaSaidaEncontrado;
    //
    public static int codigoPavilhao = 0;
    String confirmacaoUso = "Não"; // VARIAVEL QUE CONTROLA SE O PAVILHAO CONFIRMOU O REGISTRO
    //

    /**
     * Creates new form TelaEntradaSaidaAdvogadosInternos
     */
    public static TelaFotoAdvogado telafotoadvogado;
    public static TelaFotoAdvogadoInterno telainternoadv;

    public TelaEntradaSaidaAdvogadosInternos() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampo();
    }

    public void mostrarFotoAdvogado() {
        telafotoadvogado = new TelaFotoAdvogado(this, true);
        telafotoadvogado.setVisible(true);
    }

    public void mostrarFotoInternoAdv() {
        telainternoadv = new TelaFotoAdvogadoInterno(this, true);
        telainternoadv.setVisible(true);
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
        jLabel9 = new javax.swing.JLabel();
        jPesquisaNomeAdvogado = new javax.swing.JTextField();
        jBtNomeAdvogado = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEntradaSaidaAdvogados = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoriaManu = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jIdInterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jDescricaoPavilhao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDataEntradaInterno = new com.toedter.calendar.JDateChooser();
        jBtPesqInterno = new javax.swing.JButton();
        jBtZoonFotoInterno = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSairVisita = new javax.swing.JButton();
        jBtAuditoriaInternos = new javax.swing.JButton();
        jBtBuscarInterno = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIDlanc = new javax.swing.JTextField();
        jStatusEntCola = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDatalancamento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jIDAdvogado = new javax.swing.JTextField();
        jNomeAdvogado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBtPesqAdvogado = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jHorarioSaida = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jBtZoonFotoAdvogado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jFotoInternoAdvogado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jFotoAdvogado = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("...::: Entrada e Saida Advogados Visitas Internos {P1} :::...");

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome Advogado:");

        jPesquisaNomeAdvogado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNomeAdvogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomeAdvogado.setContentAreaFilled(false);
        jBtNomeAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeAdvogadoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPesquisaNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jLabel15)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jPesquisaNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNomeAdvogado)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaEntradaSaidaAdvogados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEntradaSaidaAdvogados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome Advogado", "Observação"
            }
        ));
        jTabelaEntradaSaidaAdvogados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEntradaSaidaAdvogadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEntradaSaidaAdvogados);
        if (jTabelaEntradaSaidaAdvogados.getColumnModel().getColumnCount() > 0) {
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setMinWidth(350);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setMaxWidth(350);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setMinWidth(360);
            jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setMaxWidth(360);
        }

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoriaManu.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaManu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaManu.setContentAreaFilled(false);
        jBtAuditoriaManu.setEnabled(false);
        jBtAuditoriaManu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaManuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaManu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoriaManu)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovo)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtCancelar)
                        .addComponent(jBtFinalizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);
        jNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNomeInternoActionPerformed(evt);
            }
        });

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Pavilhão");

        jDescricaoPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoPavilhao.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data Entrada");

        jDataEntradaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntradaInterno.setEnabled(false);

        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar Setor");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jBtZoonFotoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoonFotoInterno.setToolTipText("Ampliar Foto Interno");
        jBtZoonFotoInterno.setEnabled(false);
        jBtZoonFotoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonFotoInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtZoonFotoInterno))
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jDescricaoPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataEntradaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtZoonFotoInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDescricaoPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataEntradaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 6, Short.MAX_VALUE))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Interno", "Pavilhão", "Data Entrada"
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
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(160);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(160);
            jTabelaInternos.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

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

        jBtSairVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairVisita.setText("Sair");
        jBtSairVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairVisitaActionPerformed(evt);
            }
        });

        jBtAuditoriaInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoriaInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInternos.setToolTipText("Auditoria");
        jBtAuditoriaInternos.setContentAreaFilled(false);
        jBtAuditoriaInternos.setEnabled(false);
        jBtAuditoriaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternosActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoInterno)
                    .addComponent(jBtAlterarInterno)
                    .addComponent(jBtExcluirInterno)
                    .addComponent(jBtSalvarInterno)
                    .addComponent(jBtCancelarInterno)
                    .addComponent(jBtBuscarInterno)
                    .addComponent(jBtSairVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtBuscarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSairVisita, jBtSalvarInterno});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno)
                .addGap(11, 11, 11)
                .addComponent(jBtCancelarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaInternos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtAuditoriaInternos, jBtBuscarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSairVisita, jBtSalvarInterno});

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIDlanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDlanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDlanc.setEnabled(false);

        jStatusEntCola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusEntCola.setForeground(new java.awt.Color(255, 0, 0));
        jStatusEntCola.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusEntCola.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Status");

        jDatalancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDatalancamento.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Cadastro");

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 173, Short.MAX_VALUE))
                            .addComponent(jStatusEntCola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusEntCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDatalancamento, jIDlanc, jStatusEntCola});

        jTabbedPane2.addTab("Documento", jPanel11);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jIDAdvogado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDAdvogado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDAdvogado.setEnabled(false);

        jNomeAdvogado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeAdvogado.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome do Advogado");

        jBtPesqAdvogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqAdvogado.setContentAreaFilled(false);
        jBtPesqAdvogado.setEnabled(false);
        jBtPesqAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqAdvogadoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 255));
        jLabel11.setText("Data Entrada");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioEntrada.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 255));
        jLabel13.setText("Horário");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 0));
        jLabel18.setText("Data Saída");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jHorarioSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioSaida.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 0));
        jLabel19.setText("Horário");

        jBtZoonFotoAdvogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoonFotoAdvogado.setToolTipText("Ampliar Foto Advogado");
        jBtZoonFotoAdvogado.setEnabled(false);
        jBtZoonFotoAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonFotoAdvogadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jIDAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jNomeAdvogado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel13))
                            .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtZoonFotoAdvogado))
                            .addComponent(jLabel19))))
                .addGap(126, 126, 126))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIDAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqAdvogado)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtZoonFotoAdvogado))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados do Advogado", jPanel12);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/manedit-icone-5567-128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAdvogado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Advogado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4});

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(250, 10, 706, 560);
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
                        preencherTodasEntSai("SELECT * FROM ENTRADASADVINTERNOS "
                                + "INNER JOIN ADVOGADOS "
                                + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
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
                        preencherTodasEntSai("SELECT * FROM ENTRADASADVINTERNOS "
                                + "INNER JOIN ADVOGADOS "
                                + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
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
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            preencherTodasEntSai("SELECT * FROM ENTRADASADVINTERNOS "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "WHERE IdLanc='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jTabelaEntradaSaidaAdvogadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEntradaSaidaAdvogadosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaEntradaSaidaAdvogados.getValueAt(jTabelaEntradaSaidaAdvogados.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            //
            jDatalancamento.setDate(jDatalancamento.getDate());
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtNovoInterno.setEnabled(true);
            jBtBuscarInterno.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoriaManu.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADASADVINTERNOS "
                        + "INNER JOIN ADVOGADOS "
                        + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIDlanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusEntCola.setText(conecta.rs.getString("Statuslanc"));
                jDatalancamento.setDate(conecta.rs.getDate("DataLanc"));
                jIDAdvogado.setText(String.valueOf(conecta.rs.getInt("IdAdvogado")));
                jNomeAdvogado.setText(conecta.rs.getString("NomeAdvogado"));
                // Capturando foto
                caminhoAdv = conecta.rs.getString("FotoAdvogado");
                if (caminhoAdv != null) {
                    javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoAdv);
                    jFotoAdvogado.setIcon(a);
                    jFotoAdvogado.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoAdvogado.getWidth(), jFotoAdvogado.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteAD"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoAdvogado.getWidth(), jFotoAdvogado.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoAdvogado.setIcon(icon);
                }
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jHorarioEntrada.setText(conecta.rs.getString("HorarioEntrada"));
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jHorarioSaida.setText(conecta.rs.getString("HorarioSaida"));
                jObservacao.setText(conecta.rs.getString("ObsLanc"));
                conecta.desconecta();
                preencherTabelaItens("SELECT * FROM ITENSADVOGADOINTERNOS "
                        + "INNER JOIN ADVOGADOS "
                        + "ON ITENSADVOGADOINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSADVOGADOINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE IdLanc='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaEntradaSaidaAdvogadosMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdIntManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntManuP1) && codIncluirP1 == 1) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdIntManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntManuP1) && codAlterarP1 == 1) {
            objEntSaiAdInternos.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de advogado não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampo();
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
        buscarAcessoUsuario(telaEntradaSaidaAdIntManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntManuP1) && codExcluirP1 == 1) {
            objEntSaiAdInternos.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de advogado não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdIntManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntManuP1) && codGravarP1 == 1) {
            horaEntradaEncontrada = "";
            horaSaidaEncontrado = "";
            if (jDatalancamento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lancamento.");
                jDatalancamento.requestFocus();
                jDatalancamento.setBackground(Color.red);
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada do advogado.");
                jDataEntrada.requestFocus();
                jDataEntrada.setBackground(Color.red);
            } else if (jHorarioEntrada.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar um horário de entrada.");
                jHorarioEntrada.requestFocus();
                jHorarioEntrada.setBackground(Color.red);
            } else if (jDataSaida.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar uma data de saida.");
                jDataSaida.requestFocus();
                jDataSaida.setBackground(Color.red);
            } else if (jHorarioSaida.getText().equals("")) {
                jHorarioSaida.setText("00:00");
            } else if (jIDAdvogado.getText().equals("") || jNomeAdvogado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do advogado.");
            } else {
                objEntSaiAdInternos.setDataLanc(jDatalancamento.getDate());
                objEntSaiAdInternos.setObsLanc(jObservacao.getText());
                objEntSaiAdInternos.setStatusLanc(statusEnt);
                objEntSaiAdInternos.setDataEntrada(jDataEntrada.getDate());
                objEntSaiAdInternos.setHorarioEntrada(jHorarioEntrada.getText());
                objEntSaiAdInternos.setDataSaida(jDataSaida.getDate());
                objEntSaiAdInternos.setHorarioSaida(jHorarioSaida.getText());
                objEntSaiAdInternos.setUsuarioInsert(nameUser);
                objEntSaiAdInternos.setDataInsert(dataModFinal);
                objEntSaiAdInternos.setHoraInsert(horaMov);
                if (acao == 1) {
                    objEntSaiAdInternos.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
                    objEntSaiAdInternos.setNomeAdvogado(jNomeAdvogado.getText());
                    control.incluirEntSaiAdvogado(objEntSaiAdInternos);
                    buscarID();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objEntSaiAdInternos.setUsuarioUp(nameUser);
                    objEntSaiAdInternos.setDataUp(dataModFinal);
                    objEntSaiAdInternos.setHoraUp(horaMov);
                    objEntSaiAdInternos.setIdLanc(Integer.valueOf(jIDlanc.getText()));
                    objEntSaiAdInternos.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
                    objEntSaiAdInternos.setNomeAdvogado(jNomeAdvogado.getText());
                    control.alterarEntSaiAdvogado(objEntSaiAdInternos);
                    verificarInternos();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
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

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        verificarHoraEntrada();
        if (jHorarioSaida.getText().equals(horaSaidaEncontrado) && jIDlanc.getText().equals(codigoRegistro) || jHorarioEntrada.getText().equals(horaEntradaEncontrada) && jIDlanc.getText().equals(codigoRegistro)) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível FINALIZAR esse registro, existe(m) horário(s) de entrada de advogado(s) em aberto.\nCorrija os horários com divergências e então poderá FINALIZAR o documento. ");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADASADVINTERNOS WHERE IdLanc='" + jIDlanc.getText() + "'");
                conecta.rs.first();
                jStatusEntCola.setText(conecta.rs.getString("StatusLanc"));
                if (jStatusEntCola.getText().equals("FINALIZADO")) {
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

    private void jBtPesqAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqAdvogadoActionPerformed
        // TODO add your handling code here:        
        TelaPesqAdvogadosInternos objPesqAdvo = new TelaPesqAdvogadosInternos();
        TelaModuloPortarias.jPainelPortarias.add(objPesqAdvo);
        objPesqAdvo.show();
    }//GEN-LAST:event_jBtPesqAdvogadoActionPerformed

    private void jNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomeInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNomeInternoActionPerformed

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosAdvogadosEntSai objInternosAdvogados = new TelaPesqInternosAdvogadosEntSai();
        TelaModuloPortarias.jPainelPortarias.add(objInternosAdvogados);
        objInternosAdvogados.show();
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String nomeColaborador = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            jNomeInterno.setText(nomeColaborador);
            idItem = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2);
            // Habilitar os botões
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInternos.setEnabled(true);
            jBtZoonFotoInterno.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSADVOGADOINTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSADVOGADOINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                        + "AND IdLanc='" + jIDlanc.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                idItem = conecta.rs.getString("IdItem"); // Coluna 2          
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoAdvogado.setIcon(i);
                    jFotoInternoAdvogado.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoAdvogado.getWidth(), jFotoInternoAdvogado.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (img2Bytes != null) {
                    ImageIcon pic2 = null;
                    pic2 = new ImageIcon(img2Bytes);
                    Image scaled2 = pic2.getImage().getScaledInstance(jFotoInternoAdvogado.getWidth(), jFotoInternoAdvogado.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(scaled2);
                    jFotoInternoAdvogado.setIcon(icon2);
                }
                codigoPavilhao = conecta.rs.getInt("IdPav");
                jDescricaoPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                jDataEntradaInterno.setDate(conecta.rs.getDate("DataEntrada"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdIntInterP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntInterP1) && codIncluirP1 == 1) {
            objEntSaiAdInternos.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de interno não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInterno();
                corCampo();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdIntInterP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntInterP1) && codAlterarP1 == 1) {
            objEntSaiAdInternos.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de interno não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarInterno();
                corCampo();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdIntInterP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntInterP1) && codExcluirP1 == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEntSaiAdInternos.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o interno selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // EXCLUIR REGISTROS DE ALERTA PARA PORTARIA DE ACORDO COM O PARÂMETRO (HABILITADO - DESABILITADO)                   
                    objAlertaPortPav.setIdRegistroAD(Integer.valueOf(jIDlanc.getText()));//  
                    objAlertaPortPav.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    controleOFPortPav.excluirAcessoAdvogadoPortariaPavilhoes(objAlertaPortPav);
                    //
                    objItensEntSaiAdvInternos.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensEnSaiAdvInternos(objItensEntSaiAdvInternos);
                    objVisitasAdvInt.setIdLanc(Integer.valueOf(jIDlanc.getText()));
                    objVisitasAdvInt.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    controleAd.excluirAdvogadosInterno(objVisitasAdvInt);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirInterno();
                    preencherTabelaItens("SELECT * FROM ITENSADVOGADOINTERNOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSADVOGADOINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE Idlanc='" + jIDlanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaEntradaSaidaAdIntInterP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntInterP1) && codGravarP1 == 1) {
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Interno");
                jNomeInterno.requestFocus();
                jNomeInterno.setBackground(Color.red);
            } else {
                objItensEntSaiAdvInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
                // Para o log do registro
                objItensEntSaiAdvInternos.setUsuarioInsert(nameUser);
                objItensEntSaiAdvInternos.setDataInsert(dataModFinal);
                objItensEntSaiAdvInternos.setHoraInsert(horaMov);
                if (acao == 3) {
                    objItensEntSaiAdvInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
                    objItensEntSaiAdvInternos.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
                    objItensEntSaiAdvInternos.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objItensEntSaiAdvInternos.setNomeInterno(jNomeInterno.getText());
                    controle.incluirItensEnSaiAdvInternos(objItensEntSaiAdvInternos);
                    objAdvogadosInternos();
                    controleAd.incluirAdvogadosInterno(objVisitasAdvInt); // Incluir os internos no cadastro do advogdo
                    // INCLUIR REGISTROS DE ALERTA PARA PORTARIA DE ACORDO COM O PARÂMETRO (HABILITADO - DESABILITADO)
                    objAlertaPortPav.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objAlertaPortPav.setNomeInternoCrc(jNomeInterno.getText());
                    objAlertaPortPav.setIdRegistroAD(Integer.valueOf(jIDlanc.getText()));
                    objAlertaPortPav.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
                    objAlertaPortPav.setDataChegada(jDataEntrada.getDate());
                    objAlertaPortPav.setHoraChegada(jHorarioEntrada.getText());
                    objAlertaPortPav.setConfirmacao(confirmacaoUso);
                    objAlertaPortPav.setIdPav(codigoPavilhao);
                    objAlertaPortPav.setDescricaoPavilhao(jDescricaoPavilhao.getText());
                    // USUARIO NA PORTARIA QUE FEZ O LANÇAMENTO DO REGISTRO
                    objAlertaPortPav.setUsuarioInsert(nameUser);
                    objAlertaPortPav.setDataInsert(dataModFinal);
                    objAlertaPortPav.setHorarioInsert(horaMov);
                    controleOFPortPav.incluirAcessoAdvogadoPortariaPavilhoes(objAlertaPortPav);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM ITENSADVOGADOINTERNOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSADVOGADOINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "INNER JOIN ITENSLOCACAOINTERNO "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                            + "INNER JOIN CELAS "
                            + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                            + "INNER JOIN PAVILHAO "
                            + "ON CELAS.IdPav=PAVILHAO.IdPav "
                            + "WHERE Idlanc='" + jIDlanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarInterno();
                }
                if (acao == 4) {
                    objItensEntSaiAdvInternos.setUsuarioUp(nameUser);
                    objItensEntSaiAdvInternos.setDataUp(dataModFinal);
                    objItensEntSaiAdvInternos.setHoraUp(horaMov);
                    objItensEntSaiAdvInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
                    objItensEntSaiAdvInternos.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
                    objItensEntSaiAdvInternos.setIdItem(Integer.valueOf(idItem));
                    objItensEntSaiAdvInternos.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objItensEntSaiAdvInternos.setNomeInterno(jNomeInterno.getText());
                    controle.alterarItensEnSaiAdvInternos(objItensEntSaiAdvInternos);
                    objAdvogadosInternos();
                    controleAd.alterarAdvogadosInterno(objVisitasAdvInt); // Alterar os internos no cadastro do advogado
                    // ALTERAR REGISTROS DE ALERTA PARA PORTARIA DE ACORDO COM O PARÂMETRO (HABILITADO - DESABILITADO)
                    objAlertaPortPav.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objAlertaPortPav.setNomeInternoCrc(jNomeInterno.getText());
                    objAlertaPortPav.setIdRegistroAD(Integer.valueOf(jIDlanc.getText()));
                    objAlertaPortPav.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
                    objAlertaPortPav.setDataChegada(jDataEntrada.getDate());
                    objAlertaPortPav.setHoraChegada(jHorarioEntrada.getText());
                    objAlertaPortPav.setConfirmacao(confirmacaoUso);
                    objAlertaPortPav.setIdPav(codigoPavilhao);
                    objAlertaPortPav.setDescricaoPavilhao(jDescricaoPavilhao.getText());
                    // USUARIO NA PORTARIA QUE MODIFICOU O LANÇAMENTO DO REGISTRO
                    objAlertaPortPav.setUsuarioUp(nameUser);
                    objAlertaPortPav.setDataUp(dataModFinal);
                    objAlertaPortPav.setHorarioUp(horaMov);
                    controleOFPortPav.alterarAcessoAdvogadoPortariaPavilhoes(objAlertaPortPav);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM ITENSADVOGADOINTERNOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSADVOGADOINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "INNER JOIN ITENSLOCACAOINTERNO "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                            + "INNER JOIN CELAS "
                            + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                            + "INNER JOIN PAVILHAO "
                            + "ON CELAS.IdPav=PAVILHAO.IdPav "
                            + "WHERE Idlanc='" + jIDlanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarInterno();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSairVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairVisitaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairVisitaActionPerformed

    private void jBtBuscarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarInternoActionPerformed
        // TODO add your handling code here:
        TelaBuscarInternosAdvogados objBuscarInternos = new TelaBuscarInternosAdvogados();
        TelaModuloPortarias.jPainelPortarias.add(objBuscarInternos);
        objBuscarInternos.show();
    }//GEN-LAST:event_jBtBuscarInternoActionPerformed

    private void jBtNomeAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeAdvogadoActionPerformed
        // TODO add your handling code here:   
        count = 0;
        flag = 1;
        if (jPesquisaNomeAdvogado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome de Advogado para pesquisa");
            jPesquisaNomeAdvogado.requestFocus();
        } else {
            pesquisarEntSaiAdvInterno("SELECT * FROM ENTRADASADVINTERNOS "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "WHERE NomeAdvogado LIKE'" + jPesquisaNomeAdvogado.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeAdvogadoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntSai("SELECT * FROM ENTRADASADVINTERNOS "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado ORDER BY DataLanc");
        } else {
            jtotalRegistros.setText("");
            limparTabelaEntSai();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaManuActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEntSaiAdvInternos objAudEntSaiAdvInt = new TelaAuditoriaEntSaiAdvInternos();
        TelaModuloPortarias.jPainelPortarias.add(objAudEntSaiAdvInt);
        objAudEntSaiAdvInt.show();
    }//GEN-LAST:event_jBtAuditoriaManuActionPerformed

    private void jBtAuditoriaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEntradaSaidaAdvInternos objAudEntSaiItensInt = new TelaAuditoriaItensEntradaSaidaAdvInternos();
        TelaModuloPortarias.jPainelPortarias.add(objAudEntSaiItensInt);
        objAudEntSaiItensInt.show();
    }//GEN-LAST:event_jBtAuditoriaInternosActionPerformed

    private void jBtZoonFotoAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonFotoAdvogadoActionPerformed
        // TODO add your handling code here:
        if (jIDAdvogado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pesquise primeiro o Advogado para poder ampliar a foto.");
        } else {
            mostrarFotoAdvogado();
        }
    }//GEN-LAST:event_jBtZoonFotoAdvogadoActionPerformed

    private void jBtZoonFotoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonFotoInternoActionPerformed
        // TODO add your handling code here:
        if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
        } else {
            mostrarFotoInternoAdv();
        }
    }//GEN-LAST:event_jBtZoonFotoInternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoriaInternos;
    private javax.swing.JButton jBtAuditoriaManu;
    public static javax.swing.JButton jBtBuscarInterno;
    private javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNomeAdvogado;
    private javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqAdvogado;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtSairVisita;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarInterno;
    public static javax.swing.JButton jBtZoonFotoAdvogado;
    public static javax.swing.JButton jBtZoonFotoInterno;
    private javax.swing.JCheckBox jCheckBox1;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    public static com.toedter.calendar.JDateChooser jDataEntradaInterno;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    private com.toedter.calendar.JDateChooser jDatalancamento;
    public static javax.swing.JTextField jDescricaoPavilhao;
    public static javax.swing.JLabel jFotoAdvogado;
    public static javax.swing.JLabel jFotoInternoAdvogado;
    public static javax.swing.JFormattedTextField jHorarioEntrada;
    public static javax.swing.JFormattedTextField jHorarioSaida;
    public static javax.swing.JTextField jIDAdvogado;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIDlanc;
    public static javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    public static javax.swing.JTextField jNomeAdvogado;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesquisaNomeAdvogado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusEntCola;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaEntradaSaidaAdvogados;
    private javax.swing.JTable jTabelaInternos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarInternos() {
        //Verificar a existencia de registros para serem atualizados com a data da capa
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASADVOGADOS WHERE IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            idEntAd = conecta.rs.getString("IdLanc");
            if (jIDlanc.getText().equals(idEntAd)) {
                objHorarioAdvogadosInternos();
                objItensEntSaiAdvInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
                controleAd.alterarHorarioAdvogadosInterno(objVisitasAdvInt);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel gravar o novo horário...");
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar operação.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void objHorarioAdvogadosInternos() {
        objVisitasAdvInt.setIdLanc(Integer.valueOf(jIDlanc.getText()));
        objVisitasAdvInt.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
        objVisitasAdvInt.setDataEntrada(jDataEntrada.getDate());
        objVisitasAdvInt.setHorarioEntrada(jHorarioEntrada.getText());
        objVisitasAdvInt.setDataSaida(jDataSaida.getDate());
        objVisitasAdvInt.setHorarioSaida(jHorarioSaida.getText());
    }

    public void objAdvogadosInternos() {

        objVisitasAdvInt.setIdAdvogado(Integer.valueOf(jIDAdvogado.getText()));
        objVisitasAdvInt.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        objVisitasAdvInt.setIdLanc(Integer.valueOf(jIDlanc.getText()));
        objVisitasAdvInt.setDataEntrada(jDataEntrada.getDate());
        objVisitasAdvInt.setHorarioEntrada(jHorarioEntrada.getText());
        objVisitasAdvInt.setDataSaida(jDataSaida.getDate());
        objVisitasAdvInt.setHorarioSaida(jHorarioSaida.getText());
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        try {
            MaskFormatter horarioEntrada = new MaskFormatter("##:##");
            jHorarioEntrada.setFormatterFactory(new DefaultFormatterFactory(horarioEntrada));
            MaskFormatter horarioSaida = new MaskFormatter("##:##");
            jHorarioSaida.setFormatterFactory(new DefaultFormatterFactory(horarioSaida));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível formatar campos\nERRO :" + ex);
        }

    }

    public void bloquearCamposPesquisa() {
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jDataEntradaInterno.setEnabled(!true);
        jBtZoonFotoAdvogado.setEnabled(true);
        //
        jBtPesqAdvogado.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoAdvogado.setIcon(null);
        jDataEntrada.setDate(null);
        jDescricaoPavilhao.setText("");
        jDataEntradaInterno.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //        
        jBtZoonFotoInterno.setEnabled(true);
        // Botões
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void corCampo() {

        jIDlanc.setBackground(Color.white);
        jStatusEntCola.setBackground(Color.white);
        jDatalancamento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIDAdvogado.setBackground(Color.white);
        jNomeAdvogado.setBackground(Color.white);
        // jDepartamento.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jHorarioSaida.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jDescricaoPavilhao.setBackground(Color.white);
        jDataEntradaInterno.setBackground(Color.white);
    }

    public void Novo() {
        // Limpar campos
        jIDlanc.setText("");
        jDatalancamento.setCalendar(Calendar.getInstance());
        jStatusEntCola.setText("ABERTO");
        jObservacao.setText("");
        //
        jIDAdvogado.setText("");
        jNomeAdvogado.setText("");
        jFotoAdvogado.setIcon(null);
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText("00:00");
        jDataSaida.setCalendar(Calendar.getInstance());
        jHorarioSaida.setText("00:00");
        //Habilitar/Desabilitar campos        
        jDatalancamento.setEnabled(true);
        jObservacao.setEnabled(true);
        jBtPesqAdvogado.setEnabled(true);
        jBtZoonFotoAdvogado.setEnabled(true);
        //
        jIdInterno.setText("");
        jFotoInternoAdvogado.setIcon(null);
        jNomeInterno.setText("");
        jDescricaoPavilhao.setText("");
        jDataEntradaInterno.setDate(null);
        //
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jBtPesqAdvogado.setEnabled(true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtZoonFotoInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        limparTabelaItens();
    }

    public void Alterar() {
        //Habilitar/Desabilitar campos        
        jDatalancamento.setEnabled(true);
        jObservacao.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtPesqAdvogado.setEnabled(true);
        jBtAuditoriaManu.setEnabled(!true);
    }

    public void Excluir() {
        // Limpar campos
        jIDlanc.setText("");
        jDatalancamento.setDate(null);
        jIDAdvogado.setText("");
        jNomeAdvogado.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("");
        jObservacao.setText("");
        // Dados do interno
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jDescricaoPavilhao.setText("");
        jDataEntradaInterno.setDate(null);
        //Habilitar/Desabilitar campos        
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("");
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtPesqAdvogado.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
    }

    public void Salvar() {

        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtPesqAdvogado.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
    }

    public void Cancelar() {

        if (jIDlanc.getText().equals("")) {
            // Limpar campos
            jIDlanc.setText("");
            jDatalancamento.setDate(null);
            jStatusEntCola.setText("");
            jObservacao.setText("");
            jIDAdvogado.setText("");
            jNomeAdvogado.setText("");
            // jDepartamento.setText("");
            jDataEntrada.setCalendar(Calendar.getInstance());
            jHorarioEntrada.setText("00:00");
            jDataSaida.setCalendar(Calendar.getInstance());
            jHorarioSaida.setText("00:00");
            limparTabelaItens();
        }
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtPesqAdvogado.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
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
            objEntSaiAdInternos.setStatusLanc(statusLanc);
            objEntSaiAdInternos.setIdLanc(Integer.parseInt(jIDlanc.getText()));
            control.finalizarEntSaiAdvInterno(objEntSaiAdInternos);
            jStatusEntCola.setText("FINALIZADO");
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtPesqAdvogado.setEnabled(!true);
            jDatalancamento.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jHorarioEntrada.setEnabled(!true);
            jDataSaida.setEnabled(!true);
            jHorarioSaida.setEnabled(!true);
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

    public void NovoInterno() {
        // Limpar os campos
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoAdvogado.setIcon(null);
        jDescricaoPavilhao.setText("");
        jDataEntradaInterno.setDate(null);
        // Habilitar/Desabilitar campos
        jBtZoonFotoInterno.setEnabled(!true);
        jBtPesqInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(true);

        // Botões
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void AlterarInterno() {

        // Habilitar/Desabilitar campos
        jBtPesqInterno.setEnabled(true);
        // Botões
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void ExcluirInterno() {

        // Limpar os campos
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoAdvogado.setIcon(null);
        jDescricaoPavilhao.setText("");
        jDataEntradaInterno.setDate(null);
        // Habilitar/Desabilitar campos
        jBtPesqInterno.setEnabled(!true);
        // Botões
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void SalvarInterno() {

        // Limpar os campos
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoAdvogado.setIcon(null);
        jDescricaoPavilhao.setText("");
        jDataEntradaInterno.setDate(null);
        // Habilitar/Desabilitar campos
        jBtPesqInterno.setEnabled(!true);
        // Botões
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void CancelarInterno() {

        // Habilitar/Desabilitar campos
        jBtPesqInterno.setEnabled(!true);
        // Botões
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBuscarInterno.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
        //
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoriaManu.setEnabled(true);
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADASADVINTERNOS");
            conecta.rs.last();
            jIDlanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o ID do lancamento.\nERRO: " + ex);
        }
    }

    public void verificarHoraEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADASADVINTERNOS WHERE HorarioSaida='" + verHorarioSaida + "'AND Idlanc='" + jIDlanc.getText() + "'OR HorarioEntrada='" + verHorarioEntrada + "'AND Idlanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            horaEntradaEncontrada = conecta.rs.getString("HorarioEntrada");
            horaSaidaEncontrado = conecta.rs.getString("HorarioSaida");
            codigoRegistro = conecta.rs.getString("Idlanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //Preencher tabela com todos os dados de entrada/saída 
    public void preencherTodasEntSai(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Advogado", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataLanc");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeAdvogado"), conecta.rs.getString("ObsLanc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaAdvogados.setModel(modelo);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setPreferredWidth(360);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaAdvogados.setAutoResizeMode(jTabelaEntradaSaidaAdvogados.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaAdvogados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaEntSai();
        conecta.desconecta();
    }

    public void limparTabelaEntSai() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Advogado", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaAdvogados.setModel(modelo);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setPreferredWidth(360);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaAdvogados.setAutoResizeMode(jTabelaEntradaSaidaAdvogados.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaAdvogados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaEntSai() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void pesquisarEntSaiAdvInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno ", "Dt. Entrada", "Horário", "Dt. Saída", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLanc");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                // Formatar a data no formato Brasil
                dataEntrada = conecta.rs.getString("DataEntrada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                // Formatar a data no formato Brasil
                dataSaida = conecta.rs.getString("DataSaida");
                String dias = dataSaida.substring(8, 10);
                String mess = dataSaida.substring(5, 7);
                String anos = dataSaida.substring(0, 4);
                dataSaida = dias + "/" + mess + "/" + anos;
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataBrasil, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeAdvogado"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaAdvogados.setModel(modelo);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(6).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(7).setResizable(false);
        jTabelaEntradaSaidaAdvogados.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaAdvogados.setAutoResizeMode(jTabelaEntradaSaidaAdvogados.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaAdvogados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaAdvogados();
        conecta.desconecta();
    }

    public void alinharTabelaAdvogados() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaEntradaSaidaAdvogados.getColumnModel().getColumn(7).setCellRenderer(centralizado);
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Pavilhão", "Data Entrada"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("DescricaoPav"), dataEntrada});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(160);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaItens();
        conecta.desconecta();
    }

    public void alinharTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Pavilhão", "Data Entrada"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(160);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void verificarItens() {

        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSADVOGADOINTERNOS "
                    + "WHERE IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codlanc = conecta.rs.getString("IdLanc");
            if (jIDlanc.getText().equals(codlanc)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEntSaiAdInternos.setIdLanc(Integer.parseInt(jIDlanc.getText()));
                control.excluirEntSaiAdvogado(objEntSaiAdInternos);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
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
