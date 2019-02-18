/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEntradaSaidaVisitasInternasInternos;
import gestor.Controle.ControleInternosVisitadosInternas;
import gestor.Controle.ControleInternasVisitandoInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleVisitasFamiliarInternos;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.EntradaSaidaVisitasInternos;
import gestor.Modelo.ItensEntradaSaidaVisitasInternos;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPortarias.codAbrirP1;
import static gestor.Visao.TelaModuloPortarias.codAlterarP1;
import static gestor.Visao.TelaModuloPortarias.codConsultarP1;
import static gestor.Visao.TelaModuloPortarias.codExcluirP1;
import static gestor.Visao.TelaModuloPortarias.codGravarP1;
import static gestor.Visao.TelaModuloPortarias.codIncluirP1;
import static gestor.Visao.TelaModuloPortarias.codUserAcessoP1;
import static gestor.Visao.TelaModuloPortarias.codigoGrupoP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserGroupP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserP1;
import static gestor.Visao.TelaModuloPortarias.nomeGrupoP1;
import static gestor.Visao.TelaModuloPortarias.nomeTelaP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaVisitasInternasIntRIVisiP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaSaidaVisitasInternasRIManuP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaPesqInternosVisitasInternas.idRol;
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
public class TelaEntradaSaidaVisitasInternasInternos extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVisitasInternos objEntSaiVisitasInterno = new EntradaSaidaVisitasInternos();
    ControleEntradaSaidaVisitasInternasInternos control = new ControleEntradaSaidaVisitasInternasInternos();
    ItensEntradaSaidaVisitasInternos objItensVisitaInternos = new ItensEntradaSaidaVisitasInternos();
    ControleInternosVisitadosInternas controle = new ControleInternosVisitadosInternas(); // Controle dos Internos ITENS_VISITA_INTERNO
    ControleInternasVisitandoInternos controleInternas = new ControleInternasVisitandoInternos(); // ITENS_VISITA_INTERNA
    ControleVisitasFamiliarInternos objControl = new ControleVisitasFamiliarInternos(); //Atualizar historico visitas internos (com erro)
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Entrada/Saida Visitas de Internos:Manutenção";
    String nomeModuloTela2 = "Portaria:Entrada/Saida Visitas de Internos:Internas";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    String statusEnt = "ABERTO";
    String dataEntrada;
    String dataSaida;
    public static String idItem;
    String dataInicial;
    String dataFinal;
    String codLanc;
    String caminho, caminhoVisita;
    int count = 0;
    int count1 = 0;
    // VARIAVEIS PARA BLOQUEAR O REGISTRO CASO NÃO ESTEJA COM OS HORÁRIOS PREENCHIDOS COM AS HORAS.
    String verHorarioSaida = "00:00";
    String verHorarioEntrada = "00:00";
    String horaEntradaEncontrada, codigoRegistro, horaSaidaEncontrado;
    //
    String item;
    String nomePavilhao = null; // IRÁ MOSTRAR O INTERNO MESMO QUE NÃO ESTEJA NO LOCAL
    String codigoInternoLocal;
    // VERIFICAR SE O INTERNO E A VISITA JÁ EXISTEM, IMPEDINDO DE GRAVAR DUPLICIDADE
    String codigoInternoGrava;
    String codigoVisitaGrava;
    String codigoRegistroGrava;
    String codigoRegistroGravaReg;
    /**
     * Creates new form TelaEntradaSaidaVistasInternos
     */
    public static TelaFotoHallMasculino telafotohallmasculino;
    public static TelaFotoHallFeminino telafotohallfeminino;

    public TelaEntradaSaidaVisitasInternasInternos() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampo();
    }

    public void mostrarFotoInterno() {
        telafotohallmasculino = new TelaFotoHallMasculino(this, true);
        telafotohallmasculino.setVisible(true);
    }

    public void mostrarFotoInterna() {
        telafotohallfeminino = new TelaFotoHallFeminino(this, true);
        telafotohallfeminino.setVisible(true);
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jPesqNomeInterna = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jBtPesqNomeInterna = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEntradaSaidaVisitasInternos = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jIDlanc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDatalancamento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jStatusEntCola = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jObservacao = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoriaManu = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaVisitasInternasInternos = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jFotoInternoVisitasInterno = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSituacao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPavilhao = new javax.swing.JTextField();
        jBtZoonInterno = new javax.swing.JButton();
        jtotalItens = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jIDVisitaInterna = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jNomeVisitanteInterna = new javax.swing.JTextField();
        jBtPesqVisitas = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jFotoVisitaInterno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jHorarioSaida = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jBtZoonInterna = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jBtBuscarInterno = new javax.swing.JButton();
        jBtAuditoriaItens = new javax.swing.JButton();
        jBtSairVisita = new javax.swing.JButton();
        jBtCancelarVisita = new javax.swing.JButton();
        jBtSalvarVisita = new javax.swing.JButton();
        jBtExcluirVisita = new javax.swing.JButton();
        jBtAlterarVisita = new javax.swing.JButton();
        jBtNovaVisita = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("...::: Entrada e Saida de Visitas Internas/Internos - {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));

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

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome Interno:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Nome Interna:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqNomeInterna.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jBtPesqNomeInterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterna.setContentAreaFilled(false);
        jBtPesqNomeInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPesqNomeInterna, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtPesqNomeInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(18, Short.MAX_VALUE))
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
                    .addComponent(jLabel18)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jPesqNomeInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabelaEntradaSaidaVisitasInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEntradaSaidaVisitasInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaEntradaSaidaVisitasInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEntradaSaidaVisitasInternosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEntradaSaidaVisitasInternos);
        if (jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setMinWidth(470);
            jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setMaxWidth(470);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabeçalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jIDlanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDlanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDlanc.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Cadastro");

        jDatalancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDatalancamento.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Status");

        jStatusEntCola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusEntCola.setForeground(new java.awt.Color(255, 0, 0));
        jStatusEntCola.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusEntCola.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 167, Short.MAX_VALUE))
                    .addComponent(jStatusEntCola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusEntCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatalancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDatalancamento, jIDlanc, jStatusEntCola});

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jObservacao)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jBtAuditoriaManu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaManu.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaManu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaManu.setToolTipText("Auditoria");
        jBtAuditoriaManu.setContentAreaFilled(false);
        jBtAuditoriaManu.setEnabled(false);
        jBtAuditoriaManu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaManuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaManu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtAuditoriaManu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAuditoriaManu, jBtFinalizar});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/new-user-group-icone-6256-128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(31, 31, 31))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabelaVisitasInternasInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitasInternasInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome da Interna Visitante", "Data Entrada", "Horário", "Data Saída", "Horário"
            }
        ));
        jTabelaVisitasInternasInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasInternasInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaVisitasInternasInternos);
        if (jTabelaVisitasInternasInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setMinWidth(50);
            jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setMaxWidth(50);
        }

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar Internos no Rol");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFotoInternoVisitasInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jFotoInternoVisitasInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Situação na Unidade");

        jSituacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSituacao.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Pavilhão");

        jPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhao.setEnabled(false);

        jBtZoonInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoonInterno.setToolTipText("Ampliar Foto Interno");
        jBtZoonInterno.setEnabled(false);
        jBtZoonInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonInternoActionPerformed(evt);
            }
        });

        jtotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jtotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Total Itens");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jPavilhao)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtZoonInterno))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jtotalItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtotalItens)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtZoonInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdInterno, jtotalItens});

        jTabbedPane2.addTab("Interno", jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Código");

        jIDVisitaInterna.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDVisitaInterna.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDVisitaInterna.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome da Visita Interna");

        jNomeVisitanteInterna.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitanteInterna.setEnabled(false);

        jBtPesqVisitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisitas.setToolTipText("Pesquisar Visita do Interno");
        jBtPesqVisitas.setContentAreaFilled(false);
        jBtPesqVisitas.setEnabled(false);
        jBtPesqVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitasActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisitaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisitaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 255));
        jLabel6.setText("Data Entrada");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioEntrada.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 255));
        jLabel8.setText("Horário");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("Data Saída");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jHorarioSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioSaida.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));
        jLabel10.setText("Horário");

        jBtZoonInterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoonInterna.setToolTipText("Ampliar Foto Interno");
        jBtZoonInterna.setEnabled(false);
        jBtZoonInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonInternaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jIDVisitaInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtPesqVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtZoonInterna))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(199, 199, 199))
                        .addComponent(jNomeVisitanteInterna, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtZoonInterna)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtPesqVisitas)
                            .addComponent(jIDVisitaInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeVisitanteInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        jTabbedPane2.addTab("Internas", jPanel10);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jBtBuscarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarInterno.setText("Buscar");
        jBtBuscarInterno.setEnabled(false);
        jBtBuscarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarInternoActionPerformed(evt);
            }
        });

        jBtAuditoriaItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaItens.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoriaItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItens.setText("Auditoria");
        jBtAuditoriaItens.setEnabled(false);
        jBtAuditoriaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItensActionPerformed(evt);
            }
        });

        jBtSairVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairVisita.setText("Sair");
        jBtSairVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairVisitaActionPerformed(evt);
            }
        });

        jBtCancelarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarVisita.setText("Cancelar");
        jBtCancelarVisita.setEnabled(false);
        jBtCancelarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarVisitaActionPerformed(evt);
            }
        });

        jBtSalvarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarVisita.setText("Gravar");
        jBtSalvarVisita.setEnabled(false);
        jBtSalvarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarVisitaActionPerformed(evt);
            }
        });

        jBtExcluirVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirVisita.setText("Excluir");
        jBtExcluirVisita.setEnabled(false);
        jBtExcluirVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirVisitaActionPerformed(evt);
            }
        });

        jBtAlterarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarVisita.setText("Alterar");
        jBtAlterarVisita.setEnabled(false);
        jBtAlterarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarVisitaActionPerformed(evt);
            }
        });

        jBtNovaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaVisita.setText("Novo");
        jBtNovaVisita.setEnabled(false);
        jBtNovaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtBuscarInterno)
                    .addComponent(jBtAuditoriaItens)
                    .addComponent(jBtSairVisita)
                    .addComponent(jBtCancelarVisita)
                    .addComponent(jBtSalvarVisita)
                    .addComponent(jBtExcluirVisita)
                    .addComponent(jBtAlterarVisita)
                    .addComponent(jBtNovaVisita))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarVisita, jBtAuditoriaItens, jBtBuscarInterno, jBtCancelarVisita, jBtExcluirVisita, jBtNovaVisita, jBtSairVisita, jBtSalvarVisita});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovaVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaItens)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarVisita, jBtAuditoriaItens, jBtBuscarInterno, jBtCancelarVisita, jBtExcluirVisita, jBtNovaVisita, jBtSairVisita, jBtSalvarVisita});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(250, 20, 679, 558);
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
                        preencherTodasEntSai("SELECT * FROM ENTRADAS_INTERNO_INTERNA WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
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
                        preencherTodasEntSai("SELECT * FROM ENTRADAS_INTERNO_INTERNA WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
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
            preencherTodasEntSai("SELECT * FROM ENTRADAS_INTERNO_INTERNA WHERE IdLanc='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jTabelaEntradaSaidaVisitasInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEntradaSaidaVisitasInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaEntradaSaidaVisitasInternos.getValueAt(jTabelaEntradaSaidaVisitasInternos.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            jDatalancamento.setDate(jDatalancamento.getDate());
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtNovaVisita.setEnabled(true);
            jBtBuscarInterno.setEnabled(true);
            jBtAuditoriaManu.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADAS_INTERNO_INTERNA WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIDlanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusEntCola.setText(conecta.rs.getString("Statuslanc"));
                jDatalancamento.setDate(conecta.rs.getDate("DataLanc"));
                jObservacao.setText(conecta.rs.getString("ObsLanc"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            preencherTabelaInternaVisitante("SELECT * FROM ITENS_VISITA_INTERNA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdLanc='" + IdLanc + "'");
        }
    }//GEN-LAST:event_jTabelaEntradaSaidaVisitasInternosMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasRIManuP1);
        if (codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasRIManuP1) && codIncluirP1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES")) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            jtotalItens.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasRIManuP1);
        if (codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasRIManuP1) && codAlterarP1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES")) {
            objEntSaiVisitasInterno.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de visitantes não poderá ser alterado, o mesmo encontra-se FINALIZADO");
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
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasRIManuP1);
        if (codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasRIManuP1) && codExcluirP1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES")) {
            objEntSaiVisitasInterno.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de visitantes não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasRIManuP1);
        if (codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasRIManuP1) && codGravarP1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES")) {
            if (jDatalancamento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lancamento.");
                jDatalancamento.requestFocus();
                jDatalancamento.setBackground(Color.white);
            } else {
                objEntSaiVisitasInterno.setDataLanc(jDatalancamento.getDate());
                objEntSaiVisitasInterno.setObsLanc(jObservacao.getText());
                objEntSaiVisitasInterno.setStatusLanc(statusEnt);
                objEntSaiVisitasInterno.setUsuarioInsert(nameUser);
                objEntSaiVisitasInterno.setDataInsert(dataModFinal);
                objEntSaiVisitasInterno.setHoraInsert(horaMov);
                if (acao == 1) {
                    control.incluirEntradaSaidaInternas(objEntSaiVisitasInterno);
                    buscarID();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objEntSaiVisitasInterno.setUsuarioUp(nameUser);
                    objEntSaiVisitasInterno.setDataUp(dataModFinal);
                    objEntSaiVisitasInterno.setHoraUp(horaMov);
                    objEntSaiVisitasInterno.setIdLanc(Integer.valueOf(jIDlanc.getText()));
                    control.alterarEntradaSaidaInternas(objEntSaiVisitasInterno);
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
            JOptionPane.showMessageDialog(rootPane, "Não é possível FINALIZAR esse registro, existe(m) horário(s) de entrada de interno(s) em aberto.\nCorrija os horários com divergências e então poderá FINALIZAR o documento. ");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADAS_INTERNO_INTERNA WHERE IdLanc='" + jIDlanc.getText() + "'");
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

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        // Pesquisar Internos no Rol
        TelaPesqInternosVisitasInternas objVisitasInternos = new TelaPesqInternosVisitasInternas();
        TelaModuloPortarias.jPainelPortarias.add(objVisitasInternos);
        objVisitasInternos.show();
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaVisitasInternasInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasInternasInternosMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            item = "" + jTabelaVisitasInternasInternos.getValueAt(jTabelaVisitasInternasInternos.getSelectedRow(), 0);
            String idVisita = "" + jTabelaVisitasInternasInternos.getValueAt(jTabelaVisitasInternasInternos.getSelectedRow(), 1);
            jIDVisitaInterna.setText(idVisita);
            String nomeVisitante = "" + jTabelaVisitasInternasInternos.getValueAt(jTabelaVisitasInternasInternos.getSelectedRow(), 2);
            jNomeVisitanteInterna.setText(nomeVisitante);
            // Habilitar os botões
            jBtZoonInterno.setEnabled(true);
            jBtZoonInterna.setEnabled(true);
            jBtNovaVisita.setEnabled(true);
            jBtAlterarVisita.setEnabled(true);
            jBtExcluirVisita.setEnabled(true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(true);
            jBtAuditoriaItens.setEnabled(true);
            //  VERIFICAR SE O INTERNO AINDA TEM LOCALIZAÇÃO.
            verificarInternoLocalizacao();
            if (nomePavilhao != null) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_VISITA_INTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN ITENS_VISITA_INTERNA "
                            + "ON ITENS_VISITA_INTERNO.IdRol=ITENS_VISITA_INTERNO.IdRol "
                            + "INNER JOIN ITENSLOCACAOINTERNO "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                            + "INNER JOIN CELAS "
                            + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                            + "INNER JOIN PAVILHAO "
                            + "ON CELAS.IdPav=PAVILHAO.IdPav "
                            + "WHERE ITENS_VISITA_INTERNO.IdLanc='" + jIDlanc.getText() + "' "
                            + "AND ITENS_VISITA_INTERNO.IdItem='" + item + "'");
                    conecta.rs.first();
                    jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                    jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                    jSituacao.setText(conecta.rs.getString("SituacaoCrc"));
                    jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                    // Capturando foto
                    caminho = conecta.rs.getString("FotoInternoCrc");
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoVisitasInterno.setIcon(i);
                    jFotoInternoVisitasInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoVisitasInterno.getWidth(), jFotoInternoVisitasInterno.getHeight(), Image.SCALE_DEFAULT)));
                    //
                    conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNA  "
                            + "INNER JOIN PRONTUARIOSCRC  "
                            + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                            + "WHERE NomeInternoCrc='" + jNomeVisitanteInterna.getText() + "' "
                            + "AND IdLanc='" + jIDlanc.getText() + "'");
                    conecta.rs.first();
                    //
                    jIDVisitaInterna.setText(conecta.rs.getString("IdInternoCrc")); //Coluna 0
                    jNomeVisitanteInterna.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1
                    // Capturando foto
                    caminhoVisita = conecta.rs.getString("FotoInternoCrc");
                    if (caminhoVisita != null) {
                        javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                        jFotoVisitaInterno.setIcon(v);
                        jFotoVisitaInterno.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisitaInterno.getWidth(), jFotoVisitaInterno.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoVisitaInterno.getWidth(), jFotoVisitaInterno.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoVisitaInterno.setIcon(icon);
                    }
                    idItem = conecta.rs.getString("IdItem"); // Coluna 2                
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioEntrada.setText(conecta.rs.getString("HorarioEntrada"));
                    jHorarioSaida.setText(conecta.rs.getString("HorarioSaida"));
                    conecta.desconecta();
                } catch (SQLException ex) {
                }
            } else if (nomePavilhao == null) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_VISITA_INTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN ITENS_VISITA_INTERNA "
                            + "ON ITENS_VISITA_INTERNO.IdRol=ITENS_VISITA_INTERNO.IdRol "
                            + "WHERE ITENS_VISITA_INTERNO.IdLanc='" + jIDlanc.getText() + "' "
                            + "AND ITENS_VISITA_INTERNO.IdItem='" + item + "'");
                    conecta.rs.first();
                    jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                    jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                    jSituacao.setText(conecta.rs.getString("SituacaoCrc"));
                    jPavilhao.setText("");
                    // Capturando foto
                    caminho = conecta.rs.getString("FotoInternoCrc");
                    if (caminho != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                        jFotoInternoVisitasInterno.setIcon(i);
                        jFotoInternoVisitasInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoVisitasInterno.getWidth(), jFotoInternoVisitasInterno.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                    if (img2Bytes != null) {
                        ImageIcon pic2 = null;
                        pic2 = new ImageIcon(img2Bytes);
                        Image scaled2 = pic2.getImage().getScaledInstance(jFotoInternoVisitasInterno.getWidth(), jFotoInternoVisitasInterno.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled2);
                        jFotoInternoVisitasInterno.setIcon(icon);
                    }
                    conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNA  "
                            + "INNER JOIN PRONTUARIOSCRC  "
                            + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                            + "WHERE NomeInternoCrc='" + jNomeVisitanteInterna.getText() + "' "
                            + "AND IdLanc='" + jIDlanc.getText() + "'");
                    conecta.rs.first();
                    //
                    jIDVisitaInterna.setText(conecta.rs.getString("IdInternoCrc")); //Coluna 0
                    jNomeVisitanteInterna.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1
                    // Capturando foto
                    caminhoVisita = conecta.rs.getString("FotoInternoCrc");
                    if (caminhoVisita != null) {
                        javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                        jFotoVisitaInterno.setIcon(v);
                        jFotoVisitaInterno.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisitaInterno.getWidth(), jFotoVisitaInterno.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    byte[] img3Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                    if (img3Bytes != null) {
                        ImageIcon pic3 = null;
                        pic3 = new ImageIcon(img3Bytes);
                        Image scaled3 = pic3.getImage().getScaledInstance(jFotoVisitaInterno.getWidth(), jFotoVisitaInterno.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled3);
                        jFotoVisitaInterno.setIcon(icon);
                    }
                    idItem = conecta.rs.getString("IdItem"); // Coluna 2                
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioEntrada.setText(conecta.rs.getString("HorarioEntrada"));
                    jHorarioSaida.setText(conecta.rs.getString("HorarioSaida"));
                    conecta.desconecta();
                } catch (SQLException ex) {
                }
            }
        }
    }//GEN-LAST:event_jTabelaVisitasInternasInternosMouseClicked

    private void jBtNovaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasIntRIVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasIntRIVisiP1) && codIncluirP1 == 1) {
            objEntSaiVisitasInterno.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de visitantes não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoVisita();
                corCampo();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovaVisitaActionPerformed

    private void jBtAlterarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasIntRIVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasIntRIVisiP1) && codAlterarP1 == 1) {
            objEntSaiVisitasInterno.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de visitantes não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarVisita();
                corCampo();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarVisitaActionPerformed

    private void jBtExcluirVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasIntRIVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasIntRIVisiP1) && codExcluirP1 == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEntSaiVisitasInterno.setStatusLanc(jStatusEntCola.getText());
            if (jStatusEntCola.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  colaborador não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o VISITANTE selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItensVisitaInternos.setIdItem(Integer.valueOf(idItem));
                    controle.excluirInternasVisitantes(objItensVisitaInternos);
                    buscarIdInternoVisita();
                    // Tabela ITENS_VISITA_INTERNA 
                    controleInternas.excluirItensVisitaInternos(objItensVisitaInternos);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirVisita();
                    preencherTabelaInternaVisitante("SELECT * FROM ITENS_VISITA_INTERNA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdLanc='" + jIDlanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirVisitaActionPerformed

    private void jBtSalvarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVisitasInternasIntRIVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasIntRIVisiP1) && codGravarP1 == 1) {
            verificarInternoVisitaCadastrado();
            horaEntradaEncontrada = "";
            horaSaidaEncontrado = "";
            if (jNomeVisitanteInterna.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do visitante.");
                jNomeVisitanteInterna.setBackground(Color.red);
            } else {
                if (jNomeInterno.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome do Interno");
                    jNomeInterno.requestFocus();
                    jNomeInterno.setBackground(Color.red);
                } else {
                    if (jDataEntrada.getDate() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada do visitante.");
                        jDataEntrada.requestFocus();
                        jDataEntrada.setBackground(Color.red);
                    } else {
                        if (jHorarioEntrada.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "É necessário informar um horário de entrada.");
                            jHorarioEntrada.requestFocus();
                            jHorarioEntrada.setBackground(Color.red);
                        } else {
                            if (jDataSaida.getDate() == null) {
                                JOptionPane.showMessageDialog(rootPane, "É necessário informar uma data de saida.");
                                jDataSaida.requestFocus();
                                jDataSaida.setBackground(Color.red);
                            } else {
                                if (jHorarioSaida.getText().equals("")) {
                                    jHorarioSaida.requestFocus();
                                    jHorarioSaida.setBackground(Color.red);
                                } else {
                                    objItensVisitaInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
                                    objItensVisitaInternos.setIdVisita(Integer.valueOf(jIDVisitaInterna.getText()));
                                    objItensVisitaInternos.setDataEntrada(jDataEntrada.getDate());
                                    objItensVisitaInternos.setHorarioEntrada(jHorarioEntrada.getText());
                                    objItensVisitaInternos.setDataSaida(jDataSaida.getDate());
                                    objItensVisitaInternos.setHorarioSaida(jHorarioSaida.getText());
                                    objItensVisitaInternos.setIdRol(idRol);
                                    if (acao == 3) {
                                        if (jIdInterno.getText().equals(codigoInternoGrava) && jIDVisitaInterna.getText().equals(codigoVisitaGrava) && jIDlanc.getText().equals(codigoRegistroGravaReg)) {
                                            JOptionPane.showMessageDialog(rootPane, "Esse interno e essa visita já foram cadastrado nesse registro.");
                                        } else {
                                            // Para o log do registro
                                            objItensVisitaInternos.setUsuarioInsert(nameUser);
                                            objItensVisitaInternos.setDataInsert(dataModFinal);
                                            objItensVisitaInternos.setHoraInsert(horaMov);
                                            //
                                            objItensVisitaInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));//                                
                                            objItensVisitaInternos.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                            objItensVisitaInternos.setNomeInternosCrc(jNomeInterno.getText());
                                            // Tabela ITENS_VISITA_INTERNO
                                            controle.incluirInternasVisitantes(objItensVisitaInternos);
                                            buscarIdInternoVisita();
                                            // Tabela ITENS_VISITA_INTERNA                                  
                                            objItensVisitaInternos.setIdVisita(Integer.valueOf(jIDVisitaInterna.getText()));
                                            objItensVisitaInternos.setNomeVisita(jNomeVisitanteInterna.getText());
                                            controleInternas.incluirItensVisitasInternos(objItensVisitaInternos);
                                            objLog2();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            SalvarVisita();
                                            preencherTabelaInternaVisitante("SELECT * FROM ITENS_VISITA_INTERNA "
                                                    + "INNER JOIN PRONTUARIOSCRC "
                                                    + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                    + "WHERE IdLanc='" + jIDlanc.getText() + "'");
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                        }
                                    }
                                    if (acao == 4) {
                                        objItensVisitaInternos.setUsuarioUp(nameUser);
                                        objItensVisitaInternos.setDataUp(dataModFinal);
                                        objItensVisitaInternos.setHoraUp(horaMov);
                                        //
                                        objItensVisitaInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
                                        objItensVisitaInternos.setIdItem(Integer.valueOf(idItem));
                                        objItensVisitaInternos.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                        objItensVisitaInternos.setNomeInternosCrc(jNomeInterno.getText());
                                        // Tabela ITENS_VISITA_INTERNO
                                        controle.alterarInternasVisitantes(objItensVisitaInternos);
                                        buscarIdInternoVisita();
                                        // Tabela ITENS_VISITA_INTERNA
                                        objItensVisitaInternos.setIdItem(Integer.valueOf(idItem));
                                        objItensVisitaInternos.setIdVisita(Integer.valueOf(jIDVisitaInterna.getText()));
                                        objItensVisitaInternos.setNomeVisita(jNomeVisitanteInterna.getText());
                                        controleInternas.alterarItensVisitasInternos(objItensVisitaInternos);
                                        objLog2();
                                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                        SalvarVisita();
                                        preencherTabelaInternaVisitante("SELECT * FROM ITENS_VISITA_INTERNA "
                                                + "INNER JOIN PRONTUARIOSCRC "
                                                + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                + "WHERE IdLanc='" + jIDlanc.getText() + "'");
                                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarVisitaActionPerformed

    private void jBtCancelarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarVisitaActionPerformed
        // TODO add your handling code here:
        CancelarVisita();
    }//GEN-LAST:event_jBtCancelarVisitaActionPerformed

    private void jBtSairVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairVisitaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairVisitaActionPerformed

    private void jIDDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDDeptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDDeptoActionPerformed

    private void jBtPesqVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitasActionPerformed
        // TODO add your handling code here:
        // Pesquisar Interna que irá visitar o Interno
        TelaPesqInternaRolInterno objVisRol = new TelaPesqInternaRolInterno();
        TelaModuloPortarias.jPainelPortarias.add(objVisRol);
        objVisRol.show();
    }//GEN-LAST:event_jBtPesqVisitasActionPerformed

    private void jBtBuscarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqBuscarInternasInternos objPesqItensBuscarInternos = new TelaPesqBuscarInternasInternos();
        TelaModuloPortarias.jPainelPortarias.add(objPesqItensBuscarInternos);
        objPesqItensBuscarInternos.show();
    }//GEN-LAST:event_jBtBuscarInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntSai("SELECT * FROM ENTRADAS_INTERNO_INTERNA");
        } else {
            jtotalRegistros.setText("");
            limparTabelaVisitasInternas();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaManuActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEntradasVisitasInternasInternos audEntSaiIn = new TelaAuditoriaEntradasVisitasInternasInternos();
        TelaModuloPortarias.jPainelPortarias.add(audEntSaiIn);
        audEntSaiIn.show();
    }//GEN-LAST:event_jBtAuditoriaManuActionPerformed

    private void jBtAuditoriaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItensActionPerformed
        // TODO add your handling code here:
        TelaAudItensEntradaSaidaVisitasInternosInternas objAudItensEntSaiInt = new TelaAudItensEntradaSaidaVisitasInternosInternas();
        TelaModuloPortarias.jPainelPortarias.add(objAudItensEntSaiInt);
        objAudItensEntSaiInt.show();
    }//GEN-LAST:event_jBtAuditoriaItensActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome ou parte do nome do interno para pesquisa.");
        } else {
            preencherTabelaNomeInterno("SELECT * FROM ENTRADAS_INTERNO_INTERNO "
                    + "INNER JOIN ITENS_VISITA_INTERNO "
                    + "ON ENTRADAS_INTERNO_INTERNA.IdLanc=ITENS_VISITA_INTERNO.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_VISITA_INTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqNomeInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternaActionPerformed
        // TODO add your handling code here:
        if (jPesqNomeInterna.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome ou parte do nome da interna para pesquisa.");
        } else {
            preencherTabelaNomeInterna("SELECT * FROM ENTRADAS_INTERNO_INTERNA "
                    + "INNER JOIN ITENS_VISITA_INTERNA "
                    + "ON ENTRADAS_INTERNO_INTERNA.IdLanc=ITENS_VISITA_INTERNA.IdLanc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_VISITA_INTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterna.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternaActionPerformed

    private void jBtZoonInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonInternoActionPerformed
        // TODO add your handling code here:
        mostrarFotoInterno();
    }//GEN-LAST:event_jBtZoonInternoActionPerformed

    private void jBtZoonInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonInternaActionPerformed
        // TODO add your handling code here:
        mostrarFotoInterna();
    }//GEN-LAST:event_jBtZoonInternaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAlterarVisita;
    private javax.swing.JButton jBtAuditoriaItens;
    private javax.swing.JButton jBtAuditoriaManu;
    public static javax.swing.JButton jBtBuscarInterno;
    private javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarVisita;
    private javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirVisita;
    private javax.swing.JButton jBtFinalizar;
    public static javax.swing.JButton jBtNovaVisita;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqNomeInterna;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesqVisitas;
    private javax.swing.JButton jBtSairVisita;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarVisita;
    public static javax.swing.JButton jBtZoonInterna;
    public static javax.swing.JButton jBtZoonInterno;
    private javax.swing.JCheckBox jCheckBox1;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    private com.toedter.calendar.JDateChooser jDatalancamento;
    public static javax.swing.JLabel jFotoInternoVisitasInterno;
    public static javax.swing.JLabel jFotoVisitaInterno;
    public static javax.swing.JFormattedTextField jHorarioEntrada;
    public static javax.swing.JFormattedTextField jHorarioSaida;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIDVisitaInterna;
    public static javax.swing.JTextField jIDlanc;
    public static javax.swing.JTextField jIdInterno;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jNomeVisitanteInterna;
    private javax.swing.JTextField jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTextField jPesqNomeInterna;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextField jSituacao;
    private javax.swing.JTextField jStatusEntCola;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaEntradaSaidaVisitasInternos;
    private javax.swing.JTable jTabelaVisitasInternasInternos;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void buscarIdInternoVisita() {
        objItensVisitaInternos.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        objItensVisitaInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
    }

    public void formatarCampos() {
        try {
            MaskFormatter horarioEntrada = new MaskFormatter("##:##");
            jHorarioEntrada.setFormatterFactory(new DefaultFormatterFactory(horarioEntrada));
            MaskFormatter horarioSaida = new MaskFormatter("##:##");;
            jHorarioSaida.setFormatterFactory(new DefaultFormatterFactory(horarioSaida));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível formatar campos\nERRO :" + ex);
        }

    }

    public void bloquearCamposPesquisa() {
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoVisitasInterno.setIcon(null);
        jSituacao.setText("");
        jPavilhao.setText("");
        jBtZoonInterno.setEnabled(!true);
        //
        jIDVisitaInterna.setText("");
        jNomeVisitanteInterna.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jFotoVisitaInterno.setIcon(null);
        jHorarioSaida.setText("00:00");
        jBtZoonInterna.setEnabled(!true);
        // Habilitar/Desabilitar campos
        jIdInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jSituacao.setEnabled(!true);
        jPavilhao.setEnabled(!true);
        //
        jIDVisitaInterna.setEnabled(!true);
        jNomeVisitanteInterna.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        // Botões
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqVisitas.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
    }

    public void corCampo() {

        jIDlanc.setBackground(Color.white);
        jStatusEntCola.setBackground(Color.white);
        jDatalancamento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIDVisitaInterna.setBackground(Color.white);
        jNomeVisitanteInterna.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jSituacao.setBackground(Color.white);
        jPavilhao.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jHorarioSaida.setBackground(Color.white);
    }

    public void Novo() {

        jIdInterno.setText("");
        jFotoInternoVisitasInterno.setIcon(null);
        jNomeInterno.setText("");
        jIDVisitaInterna.setText("");
        jFotoVisitaInterno.setIcon(null);
        jNomeVisitanteInterna.setText("");
        jBtZoonInterno.setEnabled(!true);
        jBtZoonInterna.setEnabled(!true);
        limparTabelaVisitasInternas();
        // Limpar campos
        jIDlanc.setText("");
        jStatusEntCola.setText("ABERTO");
        jDatalancamento.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        //Habilitar/Desabilitar campos
        jIDlanc.setEnabled(true);
        jDatalancamento.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jIDVisitaInterna.setText("");
        jNomeVisitanteInterna.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("");
        limparTabelaVisitasInternas();
        //                
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
    }

    public void Alterar() {
        jBtZoonInterno.setEnabled(!true);
        jBtZoonInterna.setEnabled(!true);
        //Habilitar/Desabilitar campos        
        jDatalancamento.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void Excluir() {

        // Limpar campos
        jIDlanc.setText("");
        jDatalancamento.setDate(null);
        jObservacao.setText("");
        //Habilitar/Desabilitar campos        
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void Salvar() {

        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(true);
    }

    public void Cancelar() {

        if (jIDlanc.getText().equals("")) {
            jIDlanc.setText("");
            jStatusEntCola.setText("");
            jDatalancamento.setDate(null);
            jObservacao.setText("");
            //
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jIDVisitaInterna.setText("");
            jNomeVisitanteInterna.setText("");
            jDataEntrada.setDate(null);
            jHorarioEntrada.setText("");
            jDataSaida.setDate(null);
            jHorarioSaida.setText("");
            jBtZoonInterno.setEnabled(!true);
            jBtZoonInterna.setEnabled(!true);
            limparTabelaVisitasInternas();
            //
            jBtAuditoriaManu.setEnabled(!true);
            jBtCancelarVisita.setEnabled(!true);
            jBtAlterarVisita.setEnabled(!true);
            jBtExcluirVisita.setEnabled(!true);
            jBtBuscarInterno.setEnabled(!true);
            jBtAuditoriaItens.setEnabled(!true);
        }
        jDatalancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtAuditoriaManu.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtBuscarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
    }

    public void Finalizar() {

        String statusLanc = "FINALIZADO";
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objEntSaiVisitasInterno.setStatusLanc(statusLanc);
            objEntSaiVisitasInterno.setIdLanc(Integer.parseInt(jIDlanc.getText()));
            control.finalizarEntradaSaidaInternas(objEntSaiVisitasInterno);
            jStatusEntCola.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jDatalancamento.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovaVisita.setEnabled(!true);
            jBtAlterarVisita.setEnabled(!true);
            jBtExcluirVisita.setEnabled(!true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(!true);
            jBtBuscarInterno.setEnabled(!true);
        }
    }

    public void NovoVisita() {
        // Limpar os campos
        jIDVisitaInterna.setText("");
        jNomeVisitanteInterna.setText("");
        jFotoVisitaInterno.setIcon(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoVisitasInterno.setIcon(null);
        jSituacao.setText("");
        jPavilhao.setText("");
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText("00:00");
        jDataSaida.setCalendar(Calendar.getInstance());
        jHorarioSaida.setText("00:00");
        // Habilitar/Desabilitar campos
        jBtPesqInterno.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        // Botões
        jBtZoonInterno.setEnabled(!true);
        jBtZoonInterna.setEnabled(!true);
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtPesqInterno.setEnabled(true);
        jBtPesqVisitas.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaManu.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void AlterarVisita() {

        // Habilitar/Desabilitar campos
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        // Botões
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtPesqInterno.setEnabled(true);
        jBtPesqVisitas.setEnabled(true);
        jBtBuscarInterno.setEnabled(!true);
    }

    public void ExcluirVisita() {

        // Limpar os campos
        jIDVisitaInterna.setText("");
        jNomeVisitanteInterna.setText("");
        jFotoVisitaInterno.setIcon(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoVisitasInterno.setIcon(null);
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("");
        jSituacao.setText("");
        jPavilhao.setText("");
        // Habilitar/Desabilitar campos
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        // Botões
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqVisitas.setEnabled(!true);
    }

    public void SalvarVisita() {

        // Limpar os campos
        jIDVisitaInterna.setText("");
        jNomeVisitanteInterna.setText("");
        jFotoVisitaInterno.setIcon(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jSituacao.setText("");
        jFotoInternoVisitasInterno.setIcon(null);
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("");
        jSituacao.setText("");
        jPavilhao.setText("");
        // Habilitar/Desabilitar campos
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        // Botões
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqVisitas.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarVisita() {

        if (!jIDlanc.getText().equals("")) {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoriaManu.setEnabled(true);
            jBtBuscarInterno.setEnabled(true);
        }
        // Habilitar/Desabilitar campos        
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        // Botões
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqVisitas.setEnabled(!true);
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADAS_INTERNO_INTERNA");
            conecta.rs.last();
            jIDlanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o ID do lancamento.\nERRO: " + ex);
        }
    }

    public void verificarHoraEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNA WHERE HorarioSaida='" + verHorarioSaida + "'AND Idlanc='" + jIDlanc.getText() + "'OR HorarioEntrada='" + verHorarioEntrada + "'AND Idlanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            horaEntradaEncontrada = conecta.rs.getString("HorarioEntrada");
            horaSaidaEncontrado = conecta.rs.getString("HorarioSaida");
            codigoRegistro = conecta.rs.getString("Idlanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoLocalizacao() {
        nomePavilhao = null;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_VISITA_INTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENS_VISITA_INTERNA "
                    + "ON ITENS_VISITA_INTERNO.IdRol=ITENS_VISITA_INTERNO.IdRol "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE ITENS_VISITA_INTERNO.IdLanc='" + jIDlanc.getText() + "' "
                    + "AND ITENS_VISITA_INTERNO.IdItem='" + item + "'");
            conecta.rs.first();
            codigoInternoLocal = conecta.rs.getString("IdInternoCrc");
            //
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE IdInternoCrc='" + codigoInternoLocal + "'");
            conecta.rs.first();
            nomePavilhao = conecta.rs.getString("DescricaoPav");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoVisitaCadastrado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNO "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codigoInternoGrava = conecta.rs.getString("IdInternoCrc");
            codigoRegistroGrava = conecta.rs.getString("IdLanc");
            //
            conecta.executaSQL("SELECT * FROM ITENS_VISITA_INTERNA "
                    + "WHERE IdInternoCrc='" + jIDVisitaInterna.getText() + "' "
                    + "AND IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codigoVisitaGrava = conecta.rs.getString("IdInternoCrc");
            codigoRegistroGravaReg = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaNomeInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno(a)"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaVisitasInternos.setModel(modelo);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(470);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaVisitasInternos.setAutoResizeMode(jTabelaEntradaSaidaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    public void preencherTabelaNomeInterna(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno(a)"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaVisitasInternos.setModel(modelo);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(470);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaVisitasInternos.setAutoResizeMode(jTabelaEntradaSaidaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    //Preencher tabela com todos os dados de entrada/saída COLABORADOR
    public void preencherTodasEntSai(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("ObsLanc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaVisitasInternos.setModel(modelo);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(470);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaVisitasInternos.setAutoResizeMode(jTabelaEntradaSaidaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaVisitasInternos.setModel(modelo);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(470);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaVisitasInternos.setAutoResizeMode(jTabelaEntradaSaidaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradaSaidaVisitasInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternaVisitante(String sql) {
        count1 = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Interna Visitante", "Data Entrada", "Horário", "Data Saida", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                // Data de Saida
                // Formatar a data Entrada
                dataSaida = conecta.rs.getString("DataSaida");
                String dias = dataSaida.substring(8, 10);
                String mess = dataSaida.substring(5, 7);
                String anos = dataSaida.substring(0, 4);
                dataSaida = dias + "/" + mess + "/" + anos;
                jtotalItens.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela                
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternasInternos.setModel(modelo);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaVisitasInternasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternasInternos.setAutoResizeMode(jTabelaVisitasInternasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaVisitasInternas();
        conecta.desconecta();
    }

    public void limparTabelaVisitasInternas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Interna Visitante ", "Data Entrada", "Horário", "Data Saida", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternasInternos.setModel(modelo);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaVisitasInternasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternasInternos.setAutoResizeMode(jTabelaVisitasInternasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaVisitasInternas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaVisitasInternasInternos.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }

    public void verificarItens() {

        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSFAMILIAR WHERE Idlanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codLanc = conecta.rs.getString("IdLanc");
            if (jIDlanc.getText().equals(codLanc)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEntSaiVisitasInterno.setIdLanc(Integer.parseInt(jIDlanc.getText()));
                control.excluirEntradaSaidaInternas(objEntSaiVisitasInterno);
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
