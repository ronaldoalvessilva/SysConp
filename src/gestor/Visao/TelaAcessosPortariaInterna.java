/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleItensEntSaiAdvInternos;
import gestor.Controle.ControleItensTransientes;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleTransientes;
import gestor.Controle.ControleVisitasAdvogados;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ItensEntradaSaidaAdvInternos;
import gestor.Modelo.ItensTransientes;
import gestor.Modelo.LogSistema;
import gestor.Modelo.Transientes;
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
import static gestor.Visao.TelaModuloPortarias.telaAcessosPortariaManuP1;
import static gestor.Visao.TelaModuloPortarias.telaAcessosPortariaTranP1;
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
 * @author Ronaldo
 */
public class TelaAcessosPortariaInterna extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Transientes objTransi = new Transientes();
    ControleTransientes control = new ControleTransientes();
    ItensTransientes objItensTransi = new ItensTransientes();
    ControleItensTransientes controle = new ControleItensTransientes();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    ItensEntradaSaidaAdvInternos objItensEntSaiAdvInternos = new ItensEntradaSaidaAdvInternos();
    ControleItensEntSaiAdvInternos controles = new ControleItensEntSaiAdvInternos();
    VisitasAdvogadosInternos objVisitasAdvInt = new VisitasAdvogadosInternos();
    ControleVisitasAdvogados controleAd = new ControleVisitasAdvogados();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Acessos Portaria:Manutenção";
    String nomeModuloTela2 = "Portaria:Acessos Portaria:Transientes";
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
    public static String caminhoFotoColaborador, caminhoFotoVisita, caminhoFotoAdvogado, caminhoFotoOficial;
    int count = 0;
    // VARIAVEIS PARA BLOQUEAR O REGISTRO CASO NÃO ESTEJA COM OS HORÁRIOS PREENCHIDOS COM AS HORAS.
    String verHorarioSaida = "00:00";
    String verHorarioEntrada = "00:00";
    String horaEntradaEncontrada, codigoRegistro, horaSaidaEncontrado;
    public static int tipoVisita;
    public static String idItemTran;
    String codigoTransiente;
    byte[] assinaturaBiometrica;
    String caminho;

    /**
     * Creates new form TelaAcessosPortariaInterna
     */
    public static TelaFotoVisitasPortariaInterna telaFotoVisitasPortariaInterna;
    public static TelaAcessoBiometriaRADIU telaAcessoBioRADIU;

    public TelaAcessosPortariaInterna() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
    }

    public void mostrarFotoAmpliada() {
        telaFotoVisitasPortariaInterna = new TelaFotoVisitasPortariaInterna(this, true);
        telaFotoVisitasPortariaInterna.setVisible(true);
    }

    public void mostrarRADIU() {
        telaAcessoBioRADIU = new TelaAcessoBiometriaRADIU(this, true);
        telaAcessoBioRADIU.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTransientes = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jBtPesquisaCodigo = new javax.swing.JButton();
        jBtPesqData = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaEntradaSaidaVisitasDiversas = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jObservacao = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jBtSair = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaVisitasDiversas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jIdTransiente = new javax.swing.JTextField();
        jNomeTransiente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBtPesquisarTransiente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDestino = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jMotivo = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jFotoTransiente = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jHorarioSaida = new javax.swing.JFormattedTextField();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jBtNovoEvento = new javax.swing.JButton();
        jBtAlterarEvento = new javax.swing.JButton();
        jBtExcluirEvento = new javax.swing.JButton();
        jBtSalvarEvento = new javax.swing.JButton();
        jBtCancelarEvento = new javax.swing.JButton();
        jBtAuditoriaEvento = new javax.swing.JButton();
        jRadioBtAdvogados = new javax.swing.JRadioButton();
        jRadioBtVisitasDiversas = new javax.swing.JRadioButton();
        jRadioBtColaboradores = new javax.swing.JRadioButton();
        jBtBuscarRegistro = new javax.swing.JButton();
        jBtZoom = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jRadioBtOficialJustica = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Controle Acessos Portaria Interna :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Inicial:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Data Final:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaCodigo.setContentAreaFilled(false);
        jBtPesquisaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCodigoActionPerformed(evt);
            }
        });

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addComponent(jCheckBoxTodos)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData)
                    .addComponent(jCheckBoxTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaEntradaSaidaVisitasDiversas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEntradaSaidaVisitasDiversas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaEntradaSaidaVisitasDiversas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEntradaSaidaVisitasDiversasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaEntradaSaidaVisitasDiversas);
        if (jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumnCount() > 0) {
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(3).setMinWidth(580);
            jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(3).setMaxWidth(580);
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
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
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
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
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

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Observação");

        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jObservacao))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setToolTipText("Novo");
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
        jBtAlterar.setToolTipText("Alterar");
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

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setToolTipText("Excluir");
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
        jBtSalvar.setToolTipText("Gravar");
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
        jBtCancelar.setToolTipText("Cancelar");
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

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtFinalizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
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
                .addComponent(jBtSair)
                .addGap(82, 82, 82)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtSair)
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtCancelar)
                        .addComponent(jBtFinalizar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jTabelaVisitasDiversas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitasDiversas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Data Entrada", "Hora", "Data Saída", "Hora", "Destino", "Motivo"
            }
        ));
        jTabelaVisitasDiversas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasDiversasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaVisitasDiversas);
        if (jTabelaVisitasDiversas.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitasDiversas.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaVisitasDiversas.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaVisitasDiversas.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaVisitasDiversas.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaVisitasDiversas.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaVisitasDiversas.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaVisitasDiversas.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaVisitasDiversas.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaVisitasDiversas.getColumnModel().getColumn(4).setMinWidth(60);
            jTabelaVisitasDiversas.getColumnModel().getColumn(4).setMaxWidth(60);
            jTabelaVisitasDiversas.getColumnModel().getColumn(5).setMinWidth(250);
            jTabelaVisitasDiversas.getColumnModel().getColumn(5).setMaxWidth(250);
            jTabelaVisitasDiversas.getColumnModel().getColumn(6).setMinWidth(250);
            jTabelaVisitasDiversas.getColumnModel().getColumn(6).setMaxWidth(250);
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jIdTransiente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdTransiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdTransiente.setEnabled(false);

        jNomeTransiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeTransiente.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome");

        jBtPesquisarTransiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarTransiente.setContentAreaFilled(false);
        jBtPesquisarTransiente.setEnabled(false);
        jBtPesquisarTransiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarTransienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Destino");

        jDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDestino.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Motivo");

        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDestino)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdTransiente, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jNomeTransiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarTransiente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jMotivo))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarTransiente)
                    .addComponent(jNomeTransiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdTransiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jFotoTransiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoTransiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoTransiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Hora Entrada");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Data Saida");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Data Entrada");

        jHorarioSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaida.setEnabled(false);

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioEntrada.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Hora Saída");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtNovoEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoEvento.setText("Novo");
        jBtNovoEvento.setToolTipText("Novo");
        jBtNovoEvento.setEnabled(false);
        jBtNovoEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtNovoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoEventoActionPerformed(evt);
            }
        });

        jBtAlterarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvento.setText("Alterar");
        jBtAlterarEvento.setToolTipText("Alterar");
        jBtAlterarEvento.setEnabled(false);
        jBtAlterarEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAlterarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEventoActionPerformed(evt);
            }
        });

        jBtExcluirEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvento.setText("Excluir");
        jBtExcluirEvento.setToolTipText("Excluir");
        jBtExcluirEvento.setEnabled(false);
        jBtExcluirEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEventoActionPerformed(evt);
            }
        });

        jBtSalvarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvento.setText("Gravar");
        jBtSalvarEvento.setToolTipText("Gravar");
        jBtSalvarEvento.setEnabled(false);
        jBtSalvarEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSalvarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEventoActionPerformed(evt);
            }
        });

        jBtCancelarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvento.setText("Cancelar");
        jBtCancelarEvento.setToolTipText("Cancelar");
        jBtCancelarEvento.setEnabled(false);
        jBtCancelarEvento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtCancelarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEventoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvento.setToolTipText("Auditoria");
        jBtAuditoriaEvento.setContentAreaFilled(false);
        jBtAuditoriaEvento.setEnabled(false);
        jBtAuditoriaEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEventoActionPerformed(evt);
            }
        });

        buttonGroupTransientes.add(jRadioBtAdvogados);
        jRadioBtAdvogados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtAdvogados.setForeground(new java.awt.Color(0, 0, 255));
        jRadioBtAdvogados.setText("Advogado");
        jRadioBtAdvogados.setToolTipText("Advogado");
        jRadioBtAdvogados.setEnabled(false);

        buttonGroupTransientes.add(jRadioBtVisitasDiversas);
        jRadioBtVisitasDiversas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtVisitasDiversas.setForeground(new java.awt.Color(255, 0, 0));
        jRadioBtVisitasDiversas.setSelected(true);
        jRadioBtVisitasDiversas.setText("V. Diversas");
        jRadioBtVisitasDiversas.setToolTipText("Visitas Diversas");
        jRadioBtVisitasDiversas.setEnabled(false);

        buttonGroupTransientes.add(jRadioBtColaboradores);
        jRadioBtColaboradores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtColaboradores.setForeground(new java.awt.Color(0, 153, 0));
        jRadioBtColaboradores.setText("Colaborador");
        jRadioBtColaboradores.setEnabled(false);

        jBtBuscarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarRegistro.setText("Buscar");
        jBtBuscarRegistro.setToolTipText("Buscar Registro Cadastrado");
        jBtBuscarRegistro.setEnabled(false);
        jBtBuscarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarRegistroActionPerformed(evt);
            }
        });

        jBtZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoom.setToolTipText("Ampliar Foto");
        jBtZoom.setContentAreaFilled(false);
        jBtZoom.setEnabled(false);
        jBtZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoomActionPerformed(evt);
            }
        });

        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setToolTipText("Biometria");
        jBtBiometria.setContentAreaFilled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        buttonGroupTransientes.add(jRadioBtOficialJustica);
        jRadioBtOficialJustica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtOficialJustica.setText("O. Justiça");
        jRadioBtOficialJustica.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtAuditoriaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtBuscarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtNovoEvento)
                            .addComponent(jBtAlterarEvento)
                            .addComponent(jBtSalvarEvento)
                            .addComponent(jBtExcluirEvento)
                            .addComponent(jBtCancelarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioBtVisitasDiversas)
                            .addComponent(jRadioBtAdvogados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioBtOficialJustica)
                            .addComponent(jRadioBtColaboradores)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvento, jBtBuscarRegistro, jBtCancelarEvento, jBtExcluirEvento, jBtNovoEvento, jBtSalvarEvento});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioBtAdvogados)
                                .addComponent(jRadioBtOficialJustica))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioBtVisitasDiversas)
                                .addComponent(jRadioBtColaboradores)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jBtNovoEvento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtAlterarEvento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtExcluirEvento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtSalvarEvento))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(124, 124, 124)
                                    .addComponent(jBtCancelarEvento)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtBuscarRegistro)
                            .addGap(16, 16, 16)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtAuditoriaEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jBtBiometria)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(400, 30, 769, 549);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            preencherTodasEntSai("SELECT * FROM TRANSIENTES "
                    + "WHERE TRANSIENTES.IdTrans='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesquisaCodigoActionPerformed

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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherTodasEntSai("SELECT * FROM TRANSIENTES "
                                + "WHERE DataTrans BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
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
                        preencherTodasEntSai("SELECT * FROM TRANSIENTES "
                                + "WHERE DataTrans BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntSai("SELECT * FROM TRANSIENTES");
        } else {
            jtotalRegistros.setText("");
            limparTabelaEntSai();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaEntradaSaidaVisitasDiversasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEntradaSaidaVisitasDiversasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaEntradaSaidaVisitasDiversas.getValueAt(jTabelaEntradaSaidaVisitasDiversas.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            //            
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            // 
            jBtNovoEvento.setEnabled(true);
            jBtBuscarRegistro.setEnabled(true);
            jBtZoom.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TRANSIENTES WHERE IdTrans='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdTrans")));
                jStatusLanc.setText(conecta.rs.getString("StatusTrans"));
                jDataLanc.setDate(conecta.rs.getDate("DataTrans"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            preencherTabelaItens("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                    + "INNER JOIN TRANSIENTES "
                    + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                    + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + IdLanc + "'");
        }
        conecta.desconecta();
    }//GEN-LAST:event_jTabelaEntradaSaidaVisitasDiversasMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaManuP1) && codIncluirP1 == 1) {
            acao = 1;
            corCampos();
            limparTabelaItens();
            limparCamposRegistro();
            bloquearBotaoes();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaManuP1) && codAlterarP1 == 1) {
            objTransi.setStatusTrans(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse acesso não poderá ser alterado, o mesmo encontra-se FINALIZADO");
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
        buscarAcessoUsuario(telaAcessosPortariaManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaManuP1) && codExcluirP1 == 1) {
            objTransi.setStatusTrans(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse acesso não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaManuP1) && codGravarP1 == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
            } else {
                objTransi.setStatusTrans(jStatusLanc.getText());
                objTransi.setDataTrans(jDataLanc.getDate());
                objTransi.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objTransi.setUsuarioInsert(nameUser);
                    objTransi.setDataInsert(dataModFinal);
                    objTransi.setHorarioInsert(horaMov);
                    //
                    control.incluirTransientes(objTransi);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objTransi.setUsuarioUp(nameUser);
                    objTransi.setDataUp(dataModFinal);
                    objTransi.setHorarioUp(horaMov);
                    //
                    objTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                    control.alterarTransientes(objTransi);
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        verificarHoraEntrada();
        if (jHorarioSaida.getText().equals(horaSaidaEncontrado) && jIdLanc.getText().equals(codigoRegistro) || jHorarioEntrada.getText().equals(horaEntradaEncontrada) && jIdLanc.getText().equals(codigoRegistro)) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível FINALIZAR esse registro, existe(m) horário(s) de entrada de visitas(s) em aberto.\nCorrija os horários com divergências e então poderá FINALIZAR o documento. ");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM TRANSIENTES WHERE IdTrans='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jStatusLanc.setText(conecta.rs.getString("StatusTrans"));
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

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAudEntSaiTransientes objAudi = new TelaAudEntSaiTransientes();
        TelaModuloPortarias.jPainelPortarias.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoEventoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaTranP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaTranP1) && codIncluirP1 == 1) {
            objTransi.setStatusTrans(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse acesso não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoEvento();
                corCampos();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoEventoActionPerformed

    private void jBtAlterarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEventoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaTranP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaTranP1) && codAlterarP1 == 1) {
            verificarAssinaturaBiometrica();
            objTransi.setStatusTrans(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse acesso não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdTransiente.getText().equals(codigoTransiente) && assinaturaBiometrica != null) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro, o mesmo está assinado através da biometria.");
                } else {
                    acao = 4;
                    bloquearBotaoes();
                    bloquearCamposPesquisa();
                    AlterarEvento();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEventoActionPerformed

    private void jBtExcluirEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEventoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaTranP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaTranP1) && codExcluirP1 == 1) {
            verificarAssinaturaBiometrica();
            objTransi.setStatusTrans(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse acesso não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdTransiente.getText().equals(codigoTransiente) && assinaturaBiometrica != null) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro, o mesmo está assinado através da biometria.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objItensTransi.setIdItens(Integer.valueOf(idItemTran));
                        controle.excluirItensTransientes(objItensTransi);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaItens("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                                + "INNER JOIN TRANSIENTES "
                                + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                                + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        ExcluirEvento();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEventoActionPerformed

    private void jBtSalvarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEventoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessosPortariaTranP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaTranP1) && codGravarP1 == 1) {
            if (jIdTransiente.getText().equals("") || jNomeTransiente.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do visitante.");
            } else if (jDestino.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual o destino do visitante.");
            } else if (jMotivo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o motivo do acesso.");
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada do visitante.");
            } else if (jHorarioEntrada.getText().equals("") || jHorarioEntrada.getText().equals("00:00")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário de entrada do acesso.");
            } else if (jDataSaida.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de saida da visita.");
            } else if (jHorarioSaida.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário de saída do visitante.");
            } else {
                objItensTransi.setIdAdvogado(Integer.valueOf(jIdTransiente.getText()));
                objItensTransi.setNomeAdvogado(jNomeTransiente.getText());
                objItensTransi.setIdVisitaDiversas(Integer.valueOf(jIdTransiente.getText()));
                objItensTransi.setNomeVisitaDiversa(jNomeTransiente.getText());
                objItensTransi.setIdFunc(Integer.valueOf(jIdTransiente.getText()));
                objItensTransi.setNomeColaborador(jNomeTransiente.getText());
                objItensTransi.setIdOficial(Integer.valueOf(jIdTransiente.getText()));
                objItensTransi.setNomeOficial(jNomeTransiente.getText());
                objItensTransi.setDestino(jDestino.getText());
                objItensTransi.setMotivo(jMotivo.getText());
                objItensTransi.setDataEntrada(jDataEntrada.getDate());
                objItensTransi.setHoraEntrada(jHorarioEntrada.getText());
                objItensTransi.setDataSaida(jDataSaida.getDate());
                objItensTransi.setHoraSaida(jHorarioSaida.getText());
                if (jRadioBtAdvogados.isSelected()) {
                    tipoVisita = 0;
                } else if (jRadioBtColaboradores.isSelected()) {
                    tipoVisita = 1;
                } else if (jRadioBtVisitasDiversas.isSelected()) {
                    tipoVisita = 2;
                } else if (jRadioBtOficialJustica.isSelected()) {
                    tipoVisita = 3;
                }
                objItensTransi.setTipoTrans(tipoVisita);
                // ADVOGADO VISITANDO INTERNO, APÓS VISITAR UM SETOR DA ADMINISTRAÇÃO
                if (jRadioBtAdvogados.isSelected()) {
                    JOptionPane.showMessageDialog(rootPane, "Se está visita de advogado for para falar com internos, é necessário fazer a entrada dele em outro local, em: ENTRADA/SAIDA ADVOGADOS A INTERNOS. ");
                    if (acao == 3) {
                        objItensTransi.setUsuarioInsert(nameUser);
                        objItensTransi.setDataInsert(dataModFinal);
                        objItensTransi.setHorarioInsert(horaMov);
                        //
                        objItensTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                        controle.incluirItensTransientes(objItensTransi);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                        SalvarEvento();
                        preencherTabelaItens("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                                + "INNER JOIN TRANSIENTES "
                                + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                                + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                    if (acao == 4) {
                        objItensTransi.setUsuarioUp(nameUser);
                        objItensTransi.setDataUp(dataModFinal);
                        objItensTransi.setHorarioUp(horaMov);
                        //
                        objItensTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                        objItensTransi.setIdItens(Integer.valueOf(idItemTran));
                        controle.alterarItensTransientes(objItensTransi);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                        SalvarEvento();
                        preencherTabelaItens("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                                + "INNER JOIN TRANSIENTES "
                                + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                                + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }

                } else {
                    if (acao == 3) {
                        objItensTransi.setUsuarioInsert(nameUser);
                        objItensTransi.setDataInsert(dataModFinal);
                        objItensTransi.setHorarioInsert(horaMov);
                        //
                        objItensTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                        controle.incluirItensTransientes(objItensTransi);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                        SalvarEvento();
                        preencherTabelaItens("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                                + "INNER JOIN TRANSIENTES "
                                + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                                + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                    if (acao == 4) {
                        objItensTransi.setUsuarioUp(nameUser);
                        objItensTransi.setDataUp(dataModFinal);
                        objItensTransi.setHorarioUp(horaMov);
                        //
                        objItensTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                        objItensTransi.setIdItens(Integer.valueOf(idItemTran));
                        controle.alterarItensTransientes(objItensTransi);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                        SalvarEvento();
                        preencherTabelaItens("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                                + "INNER JOIN TRANSIENTES "
                                + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                                + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEventoActionPerformed

    private void jBtCancelarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEventoActionPerformed
        // TODO add your handling code here:
        CancelarEvento();
    }//GEN-LAST:event_jBtCancelarEventoActionPerformed

    private void jBtBuscarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarRegistroActionPerformed
        // TODO add your handling code here:
        TelaPesqItensTransientesPortariaInterna objBuscarVisita = new TelaPesqItensTransientesPortariaInterna();
        TelaModuloPortarias.jPainelPortarias.add(objBuscarVisita);
        objBuscarVisita.show();
    }//GEN-LAST:event_jBtBuscarRegistroActionPerformed

    private void jBtAuditoriaEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEventoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEntSaiTransientes objAudiItensTrans = new TelaAuditoriaItensEntSaiTransientes();
        TelaModuloPortarias.jPainelPortarias.add(objAudiItensTrans);
        objAudiItensTrans.show();
    }//GEN-LAST:event_jBtAuditoriaEventoActionPerformed

    private void jBtPesquisarTransienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarTransienteActionPerformed
        // TODO add your handling code here:
        if (jRadioBtAdvogados.isSelected()) {
            TelaPesqAdvogadosPortariaExterna objPesqAdvExt = new TelaPesqAdvogadosPortariaExterna();
            TelaModuloPortarias.jPainelPortarias.add(objPesqAdvExt);
            objPesqAdvExt.show();
        } else if (jRadioBtColaboradores.isSelected()) {
            TelaPesquisaColabordorPortariaInterna objPesqCola = new TelaPesquisaColabordorPortariaInterna();
            TelaModuloPortarias.jPainelPortarias.add(objPesqCola);
            objPesqCola.show();
        } else if (jRadioBtVisitasDiversas.isSelected()) {
            TelaPesqVisitasDiversasPortariaInterna objPesqVisitaDiv = new TelaPesqVisitasDiversasPortariaInterna();
            TelaModuloPortarias.jPainelPortarias.add(objPesqVisitaDiv);
            objPesqVisitaDiv.show();
        } else if (jRadioBtOficialJustica.isSelected()) {
            TelaPesqOficialJusticaPortariaExterna objPesqOficialExt = new TelaPesqOficialJusticaPortariaExterna();
            TelaModuloPortarias.jPainelPortarias.add(objPesqOficialExt);
            objPesqOficialExt.show();
        }
    }//GEN-LAST:event_jBtPesquisarTransienteActionPerformed

    private void jBtZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoomActionPerformed
        // TODO add your handling code here:
        mostrarFotoAmpliada();
    }//GEN-LAST:event_jBtZoomActionPerformed

    private void jTabelaVisitasDiversasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasDiversasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idItemTran = "" + jTabelaVisitasDiversas.getValueAt(jTabelaVisitasDiversas.getSelectedRow(), 0);
            //
            jBtNovoEvento.setEnabled(true);
            jBtAlterarEvento.setEnabled(true);
            jBtExcluirEvento.setEnabled(true);
            jBtSalvarEvento.setEnabled(!true);
            jBtCancelarEvento.setEnabled(true);
            jBtAuditoriaEvento.setEnabled(true);
            jBtBuscarRegistro.setEnabled(true);
            jBtZoom.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                        + "INNER JOIN TRANSIENTES "
                        + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                        + "WHERE IdItem='" + idItemTran + "'");
                conecta.rs.first();
                idItemTran = conecta.rs.getString("IdItem");
                tipoVisita = conecta.rs.getInt("TipoTrans");
                // ADVOGADO
                if (tipoVisita == 0) {
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN ADVOGADOS "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=ADVOGADOS.IdAdvogado "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeAdvogado"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtAdvogados.setSelected(true);
                    //
                    caminhoFotoAdvogado = conecta.rs.getString("FotoAdvogado");
                    if (caminhoFotoAdvogado != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoAdvogado);
                        jFotoTransiente.setIcon(i);
                        jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteAD"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoTransiente.setIcon(icon);
                    }
                    jBtZoom.setEnabled(true);
                    // COLABORADOR
                } else if (tipoVisita == 1) {
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN COLABORADOR "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=COLABORADOR.IdFunc "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeFunc"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtColaboradores.setSelected(true);
                    //
                    caminhoFotoColaborador = conecta.rs.getString("ImagemFunc");
                    if (caminhoFotoColaborador != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoColaborador);
                        jFotoTransiente.setIcon(i);
                        jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoTransiente.setIcon(icon);
                    }
                    jBtZoom.setEnabled(true);
                    // VISITAS DIVERSAS
                } else if (tipoVisita == 2) {
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN VISITASDIVERSAS "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=VISITASDIVERSAS.IdVisita "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeVisita"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtVisitasDiversas.setSelected(true);
                    //                    
                    caminhoFotoVisita = conecta.rs.getString("FotoVisita");
                    if (caminhoFotoVisita != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoVisita);
                        jFotoTransiente.setIcon(i);
                        jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVD"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoTransiente.setIcon(icon);
                    }
                    jBtZoom.setEnabled(true);
                    // OFICIAL DE JUSTIÇA
                } else if (tipoVisita == 3) {
                    conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                            + "INNER JOIN OFICIAL_JUSTICA "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdCodigo=OFICIAL_JUSTICA.IdOficial "
                            + "INNER JOIN TRANSIENTES "
                            + "ON ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans=TRANSIENTES.IdTrans "
                            + "WHERE ITENS_TRANSIENTES_VISITAS_DIVERSAS.IdTrans='" + jIdLanc.getText() + "' "
                            + "AND IdItem='" + idItemTran + "'");
                    conecta.rs.first();
                    jIdTransiente.setText(conecta.rs.getString("IdCodigo"));
                    jNomeTransiente.setText(conecta.rs.getString("NomeOficial"));
                    jDestino.setText(conecta.rs.getString("Destino"));
                    jMotivo.setText(conecta.rs.getString("Motivo"));
                    jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                    jHorarioEntrada.setText(conecta.rs.getString("HoraEntrada"));
                    jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                    jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                    jRadioBtOficialJustica.setSelected(true);
                    //                    
                    caminhoFotoOficial = conecta.rs.getString("FotoOficial");
                    if (caminhoFotoOficial != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoOficial);
                        jFotoTransiente.setIcon(i);
                        jFotoTransiente.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteOF"));
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoTransiente.getWidth(), jFotoTransiente.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoTransiente.setIcon(icon);
                    }
                    jBtZoom.setEnabled(true);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa...\nERROR: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaVisitasDiversasMouseClicked

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar biometria, documento encontra-se FINALIZADO.");
        } else {
            mostrarRADIU();
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTransientes;
    private javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAlterarEvento;
    private javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtAuditoriaEvento;
    private javax.swing.JButton jBtBiometria;
    public static javax.swing.JButton jBtBuscarRegistro;
    private javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarEvento;
    private javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirEvento;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoEvento;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesquisaCodigo;
    public static javax.swing.JButton jBtPesquisarTransiente;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarEvento;
    public static javax.swing.JButton jBtZoom;
    private javax.swing.JCheckBox jCheckBoxTodos;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    public static javax.swing.JTextField jDestino;
    public static javax.swing.JLabel jFotoTransiente;
    public static javax.swing.JFormattedTextField jHorarioEntrada;
    public static javax.swing.JFormattedTextField jHorarioSaida;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdTransiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMotivo;
    public static javax.swing.JTextField jNomeTransiente;
    private javax.swing.JTextField jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JRadioButton jRadioBtAdvogados;
    public static javax.swing.JRadioButton jRadioBtColaboradores;
    private javax.swing.JRadioButton jRadioBtOficialJustica;
    public static javax.swing.JRadioButton jRadioBtVisitasDiversas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaEntradaSaidaVisitasDiversas;
    public static javax.swing.JTable jTabelaVisitasDiversas;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdTransiente.setBackground(Color.white);
        jNomeTransiente.setBackground(Color.white);
        jDestino.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jHorarioSaida.setBackground(Color.white);
    }

    public void formatarCampos() {
        // campo destino e motivo(65)
        jObservacao.setDocument(new LimiteDigitosAlfa(57));
        jDestino.setDocument(new LimiteDigitosAlfa(65));
        jMotivo.setDocument(new LimiteDigitosAlfa(65));
        try {
            MaskFormatter horarioEntrada = new MaskFormatter("##:##");
            jHorarioEntrada.setFormatterFactory(new DefaultFormatterFactory(horarioEntrada));
            MaskFormatter horarioSaida = new MaskFormatter("##:##");
            jHorarioSaida.setFormatterFactory(new DefaultFormatterFactory(horarioSaida));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível formatar campos de Horário.\nERRO: " + ex);
        }
    }

    public void bloquearCamposPesquisa() {
        jDataLanc.setEnabled(!true);
        jStatusLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jDestino.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);

    }

    public void limparCamposRegistro() {
        jDataLanc.setDate(null);
        jStatusLanc.setText("");
        jObservacao.setText("");
        //
        jIdTransiente.setText("");
        jNomeTransiente.setText("");
        jFotoTransiente.setIcon(null);
        jDestino.setText("");
        jMotivo.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
    }

    public void bloquearBotaoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovoEvento.setEnabled(!true);
        jBtAlterarEvento.setEnabled(!true);
        jBtExcluirEvento.setEnabled(!true);
        jBtSalvarEvento.setEnabled(!true);
        jBtCancelarEvento.setEnabled(!true);
        jBtPesquisarTransiente.setEnabled(!true);
        jBtBuscarRegistro.setEnabled(!true);
        jBtAuditoriaEvento.setEnabled(!true);
    }

    public void Novo() {
        jDataLanc.setCalendar(Calendar.getInstance());
        jStatusLanc.setText("ABERTO");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Alterar() {
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Excluir() {
        jDataLanc.setDate(null);
        jStatusLanc.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Salvar() {
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoEvento.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jDataLanc.setDate(null);
            jStatusLanc.setText("");
            jObservacao.setText("");
            //
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finalizado,você não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objTransi.setStatusTrans(statusLanc);
            objTransi.setIdTrans(Integer.parseInt(jIdLanc.getText()));
            control.finalizarTransientes(objTransi);
            jStatusLanc.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //
            jBtNovoEvento.setEnabled(!true);
            jBtAlterarEvento.setEnabled(!true);
            jBtExcluirEvento.setEnabled(!true);
            jBtSalvarEvento.setEnabled(!true);
            jBtCancelarEvento.setEnabled(!true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TRANSIENTES");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdTrans"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do lancamento.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarAssinaturaBiometrica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS WHERE IdItem='" + idItemTran + "'");
            conecta.rs.first();
            codigoTransiente = conecta.rs.getString("IdCodigo");
            assinaturaBiometrica = conecta.rs.getBytes("AssinaturaEntrada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do lancamento.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void NovoEvento() {
        jIdTransiente.setText("");
        jNomeTransiente.setText("");
        jFotoTransiente.setIcon(null);
        jDestino.setText("");
        jMotivo.setText("");
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText("00:00");
        jDataSaida.setCalendar(Calendar.getInstance());
        jHorarioSaida.setText("00:00");
        //
        jDestino.setEnabled(true);
        jMotivo.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jRadioBtAdvogados.setEnabled(true);
        jRadioBtColaboradores.setEnabled(true);
        jRadioBtVisitasDiversas.setEnabled(true);
        jRadioBtOficialJustica.setEnabled(true);
        //
        jBtPesquisarTransiente.setEnabled(true);
        //
        jBtNovoEvento.setEnabled(!true);
        jBtAlterarEvento.setEnabled(!true);
        jBtExcluirEvento.setEnabled(!true);
        jBtSalvarEvento.setEnabled(true);
        jBtCancelarEvento.setEnabled(true);
        jBtAuditoriaEvento.setEnabled(!true);
        jBtZoom.setEnabled(true);
    }

    public void AlterarEvento() {
        jDestino.setEnabled(true);
        jMotivo.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        jDataSaida.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jRadioBtAdvogados.setEnabled(!true);
        jRadioBtColaboradores.setEnabled(!true);
        jRadioBtVisitasDiversas.setEnabled(!true);
        jRadioBtOficialJustica.setEnabled(true);
        //
        jBtPesquisarTransiente.setEnabled(!true);
        //
        jBtNovoEvento.setEnabled(!true);
        jBtAlterarEvento.setEnabled(!true);
        jBtExcluirEvento.setEnabled(!true);
        jBtSalvarEvento.setEnabled(true);
        jBtCancelarEvento.setEnabled(true);
        jBtAuditoriaEvento.setEnabled(!true);
        jBtZoom.setEnabled(true);
    }

    public void ExcluirEvento() {
        jIdTransiente.setText("");
        jNomeTransiente.setText("");
        jFotoTransiente.setIcon(null);
        jDestino.setText("");
        jMotivo.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //
        jDestino.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jRadioBtAdvogados.setEnabled(!true);
        jRadioBtColaboradores.setEnabled(!true);
        jRadioBtVisitasDiversas.setEnabled(!true);
        jRadioBtOficialJustica.setEnabled(!true);
        //
        jBtPesquisarTransiente.setEnabled(!true);
        //
        jBtNovoEvento.setEnabled(true);
        jBtAlterarEvento.setEnabled(!true);
        jBtExcluirEvento.setEnabled(!true);
        jBtSalvarEvento.setEnabled(!true);
        jBtCancelarEvento.setEnabled(!true);
        jBtAuditoriaEvento.setEnabled(!true);
        jBtZoom.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarEvento() {
        jIdTransiente.setText("");
        jNomeTransiente.setText("");
        jFotoTransiente.setIcon(null);
        jDestino.setText("");
        jMotivo.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //
        jDestino.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jRadioBtAdvogados.setEnabled(!true);
        jRadioBtColaboradores.setEnabled(!true);
        jRadioBtVisitasDiversas.setEnabled(!true);
        jRadioBtOficialJustica.setEnabled(!true);
        //
        jBtPesquisarTransiente.setEnabled(!true);
        //
        jBtNovoEvento.setEnabled(true);
        jBtAlterarEvento.setEnabled(!true);
        jBtExcluirEvento.setEnabled(!true);
        jBtSalvarEvento.setEnabled(!true);
        jBtCancelarEvento.setEnabled(!true);
        jBtAuditoriaEvento.setEnabled(!true);
        jBtZoom.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarEvento() {
        jIdTransiente.setText("");
        jNomeTransiente.setText("");
        jFotoTransiente.setIcon(null);
        jDestino.setText("");
        jMotivo.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("00:00");
        jDataSaida.setDate(null);
        jHorarioSaida.setText("00:00");
        //
        jDestino.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        jRadioBtAdvogados.setEnabled(!true);
        jRadioBtColaboradores.setEnabled(!true);
        jRadioBtVisitasDiversas.setEnabled(!true);
        jRadioBtOficialJustica.setEnabled(!true);
        //
        jBtPesquisarTransiente.setEnabled(!true);
        //
        jBtNovoEvento.setEnabled(true);
        jBtAlterarEvento.setEnabled(!true);
        jBtExcluirEvento.setEnabled(!true);
        jBtSalvarEvento.setEnabled(!true);
        jBtCancelarEvento.setEnabled(!true);
        jBtAuditoriaEvento.setEnabled(!true);
        jBtZoom.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void verificarHoraEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                    + "WHERE HoraSaida='" + verHorarioSaida + "' "
                    + "AND IdTrans='" + jIdLanc.getText() + "' "
                    + "OR HoraEntrada='" + verHorarioEntrada + "' "
                    + "AND IdTrans='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            horaEntradaEncontrada = conecta.rs.getString("HorarioEntrada");
            horaSaidaEncontrado = conecta.rs.getString("HorarioSaida");
            codigoRegistro = conecta.rs.getString("IdTrans");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        if (jRadioBtAdvogados.isSelected()) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_ADVOGADOS "
                        + "WHERE IdTrans='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                codLanc = conecta.rs.getString("IdTrans");
                if (jIdLanc.getText().equals(codLanc)) {
                    JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
                }
            } catch (SQLException ex) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                    control.excluirTransientes(objTransi);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
                conecta.desconecta();
            }
        } else if (jRadioBtVisitasDiversas.isSelected()) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_VISITAS_DIVERSAS "
                        + "WHERE IdTrans='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                codLanc = conecta.rs.getString("IdTrans");
                if (jIdLanc.getText().equals(codLanc)) {
                    JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
                }
            } catch (SQLException ex) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                    control.excluirTransientes(objTransi);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
                conecta.desconecta();
            }
        } else if (jRadioBtColaboradores.isSelected()) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_TRANSIENTES_COLABORADORES "
                        + "WHERE IdTrans='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                codLanc = conecta.rs.getString("IdTrans");
                if (jIdLanc.getText().equals(codLanc)) {
                    JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
                }
            } catch (SQLException ex) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objTransi.setIdTrans(Integer.valueOf(jIdLanc.getText()));
                    control.excluirTransientes(objTransi);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
                conecta.desconecta();
            }
        }
    }

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
                dataEntrada = conecta.rs.getString("DataTrans");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdTrans"), dataEntrada, conecta.rs.getString("StatusTrans"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaVisitasDiversas.setModel(modelo);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(3).setPreferredWidth(580);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaVisitasDiversas.setAutoResizeMode(jTabelaEntradaSaidaVisitasDiversas.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaVisitasDiversas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaEnSai();
        conecta.desconecta();
    }

    public void limparTabelaEntSai() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaVisitasDiversas.setModel(modelo);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(3).setPreferredWidth(580);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaVisitasDiversas.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaVisitasDiversas.setAutoResizeMode(jTabelaEntradaSaidaVisitasDiversas.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaVisitasDiversas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaEnSai() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradaSaidaVisitasDiversas.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data Entrada", "Hora", "Data Saida", "Hora", "Destino", "Motivo"};
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
                // Data de Saida
                // Formatar a data Entrada
                dataSaida = conecta.rs.getString("DataSaida");
                String dias = dataSaida.substring(8, 10);
                String mess = dataSaida.substring(5, 7);
                String anos = dataSaida.substring(0, 4);
                dataSaida = dias + "/" + mess + "/" + anos;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEntrada, conecta.rs.getString("HoraEntrada"), dataSaida, conecta.rs.getString("HoraSaida"), conecta.rs.getString("Destino"), conecta.rs.getString("Motivo"),});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasDiversas.setModel(modelo);
        jTabelaVisitasDiversas.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaVisitasDiversas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaVisitasDiversas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaVisitasDiversas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitasDiversas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaVisitasDiversas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTabelaVisitasDiversas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(6).setPreferredWidth(250);
        jTabelaVisitasDiversas.getColumnModel().getColumn(6).setResizable(false);
        jTabelaVisitasDiversas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasDiversas.setAutoResizeMode(jTabelaVisitasDiversas.AUTO_RESIZE_OFF);
        jTabelaVisitasDiversas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data Entrada", "Hora", "Data Saida", "Hora", "Destino", "Motivo"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasDiversas.setModel(modelo);
        jTabelaVisitasDiversas.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaVisitasDiversas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaVisitasDiversas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaVisitasDiversas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitasDiversas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaVisitasDiversas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTabelaVisitasDiversas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasDiversas.getColumnModel().getColumn(6).setPreferredWidth(250);
        jTabelaVisitasDiversas.getColumnModel().getColumn(6).setResizable(false);
        jTabelaVisitasDiversas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasDiversas.setAutoResizeMode(jTabelaVisitasDiversas.AUTO_RESIZE_OFF);
        jTabelaVisitasDiversas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasDiversas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasDiversas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitasDiversas.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaVisitasDiversas.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaVisitasDiversas.getColumnModel().getColumn(4).setCellRenderer(centralizado);
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
