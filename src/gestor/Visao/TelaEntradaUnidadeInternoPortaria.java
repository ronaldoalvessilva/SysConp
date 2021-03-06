/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEntradaInternosPortaria;
import gestor.Controle.ControleExportacaoInternoPortaria;
import gestor.Controle.ControleItensEntradaPortaria;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitos;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleEntradasSaidasPopulacaoInternos;
import gestor.Controle.ListagemRegistroEntradaSaidaPopulcao;
import gestor.Controle.ListagemUltimaPopulacaoCRC;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import gestor.Modelo.EntradasInternosPortaria;
import gestor.Modelo.ItensEntradaInternosPortaria;
import gestor.Modelo.LogSistema;
import gestor.Modelo.TransferenciaInternosPortaria;
import static gestor.Visao.TelaImportarDadosInternosUnidades.idTransPortUni;
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
import static gestor.Visao.TelaModuloPortarias.telaEntradaInternoUniPRIManuP1;
import static gestor.Visao.TelaModuloPortarias.telaEntradaInternoUniPRIIntP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Ronaldo
 */
public class TelaEntradaUnidadeInternoPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradasInternosPortaria objEntIntPort = new EntradasInternosPortaria();
    ItensEntradaInternosPortaria objItensEntIntPort = new ItensEntradaInternosPortaria();
    ControleEntradaInternosPortaria control = new ControleEntradaInternosPortaria();
    ControleItensEntradaPortaria controle = new ControleItensEntradaPortaria();
    //
    TransferenciaInternosPortaria pSaidaPortaria = new TransferenciaInternosPortaria();
    ControleExportacaoInternoPortaria controlTransPort = new ControleExportacaoInternoPortaria();
    //ADICIONAR A POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULACAO_INTERNOS (CONTROLE ALIMENTAÇÃO)
    ControleEntradasSaidasPopulacaoInternos populacao = new ControleEntradasSaidasPopulacaoInternos();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    ListagemUltimaPopulacaoCRC listaUltimaPopulacao = new ListagemUltimaPopulacaoCRC();
    ListagemRegistroEntradaSaidaPopulcao listaRegistroES = new ListagemRegistroEntradaSaidaPopulcao();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Entrada de Internos Unidade:Manutenção";
    String nomeModuloTela2 = "Portaria:Entrada de Internos Unidade:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    public static int acao;
    int flag;
    public static int idItem;
    String dataInicial, dataFinal, dataBrasil, dataChegada;
    String confirmaEntrada = "Não";
    String codEntrada;
    String entradaConfirmadaCrc;
    int count = 0;
    String confirmaImp = "Sim";
    //
    String pTIPO_OPERCAO_ENTRADA = "Entrada na Unidade";
    public static String pREGISTRO_ENTRADA = "";
    int pPOPULCAO_ATUAL = 0;
    int pQUANTIDADE_ENTRADA_INTERNO = 1;
    int pID_ITEM_ALIMENTACAO = 0;
    String pREGISTRO_CANCELADO = "REGISTRO CANCELADO PELO CRC";
    //
    String pCODIGO_INTERNO = "";
    String pREGISTRO = "";
    String pCONFIRMA_ENTRADA = "";
    String pCANCELADO = "";

    /**
     * Creates new form TelaEntradaUnidadeInternoPortaria
     */
    public TelaEntradaUnidadeInternoPortaria() {
        initComponents();
        corCampos();
        formatarCampos();
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
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jIdPesq = new javax.swing.JTextField();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqData = new javax.swing.JButton();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEntradasUnidInternos = new javax.swing.JTable();
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
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jNomeInternoPortaria = new javax.swing.JTextField();
        jDataChegada = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jOficio = new javax.swing.JTextField();
        jHorario = new javax.swing.JFormattedTextField();
        jComboBoxOrigemInterno = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jCanceladoCRC = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaItensEntradaInterno = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtAuditoriaInternos = new javax.swing.JButton();
        jBtImportarDados = new javax.swing.JButton();
        jBtSai1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtLocalizarInterno = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Entrada Internos na Unidade PRIMEIRA VEZ  {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Código:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Inicial:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data Final:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome Interno:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jIdPesq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jIdPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addGap(22, 22, 22))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jIdPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaEntradasUnidInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEntradasUnidInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaEntradasUnidInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEntradasUnidInternosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEntradasUnidInternos);
        if (jTabelaEntradasUnidInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setMinWidth(490);
            jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setMaxWidth(490);
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
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

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
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 241, Short.MAX_VALUE))
                    .addComponent(jStatusLanc))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jNomeInternoPortaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPortaria.setEnabled(false);

        jDataChegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataChegada.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data Chegada");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Horário");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nr. Oficio");

        jOficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOficio.setEnabled(false);

        jHorario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorario.setEnabled(false);

        jComboBoxOrigemInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrigemInterno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxOrigemInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOrigemInterno.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Origem do Interno");

        jCanceladoCRC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCanceladoCRC.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addComponent(jIdInterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jNomeInternoPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(80, 80, 80))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jOficio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCanceladoCRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jComboBoxOrigemInterno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jOficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCanceladoCRC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxOrigemInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCanceladoCRC, jOficio});

        jTabelaItensEntradaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensEntradaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno", "Data", "Horário", "Nr. Oficio"
            }
        ));
        jTabelaItensEntradaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensEntradaInternoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaItensEntradaInterno);
        if (jTabelaItensEntradaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setMinWidth(120);
            jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 204, 0))); // NOI18N

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

        jBtAuditoriaInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoriaInternos.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInternos.setContentAreaFilled(false);
        jBtAuditoriaInternos.setEnabled(false);
        jBtAuditoriaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternosActionPerformed(evt);
            }
        });

        jBtImportarDados.setForeground(new java.awt.Color(204, 0, 0));
        jBtImportarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Download-16.png"))); // NOI18N
        jBtImportarDados.setText("Importar");
        jBtImportarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImportarDadosActionPerformed(evt);
            }
        });

        jBtSai1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSai1.setText("Sair");
        jBtSai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSai1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImportarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtImportarDados, jBtNovoInterno, jBtSai1, jBtSalvarInterno});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
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
                .addComponent(jBtImportarDados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSai1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInternos))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtAuditoriaInternos, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/auth-user-icone-5782-48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo Registro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar Registro");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir Registro");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar Registro");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtLocalizarInterno.setForeground(new java.awt.Color(255, 0, 0));
        jBtLocalizarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtLocalizarInterno.setText("Localizar Prontuário");
        jBtLocalizarInterno.setToolTipText("Localizar Prontuário de Internos cadastrados na unidade");
        jBtLocalizarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLocalizarInternoActionPerformed(evt);
            }
        });

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(0, 51, 255));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar Registro");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jBtLocalizarInterno)
                        .addGap(6, 6, 6)
                        .addComponent(jBtFinalizar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSair)
                    .addComponent(jBtLocalizarInterno)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtAuditoria))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 10, 681, 521);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIManuP1) && codIncluirP1 == 1) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO: Antes de realizar a entrada dos internos que chegaram pela primeira vez na unidade, faça uma pesquisa\npara ter certeza que esses mesmos internos não sejam evadidos da unidade penal. Utilize o botão LOCALIZAR logo\n abaixo para realizar a pesquisa.");
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            corCampos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIManuP1) && codAlterarP1 == 1) {
            objEntIntPort.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                corCampos();
                Alterar();
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
        buscarAcessoUsuario(telaEntradaInternoUniPRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIManuP1) && codExcluirP1 == 1) {
            objEntIntPort.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser excluida, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIManuP1) && codGravarP1 == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                objEntIntPort.setStatusLanc(jStatusLanc.getText());
                objEntIntPort.setDataLanc(jDataLanc.getDate());
                objEntIntPort.setObservacao(jObservacao.getText());
                objEntIntPort.setUsuarioInsert(nameUser);
                objEntIntPort.setDataInsert(jDataSistema.getText());
                objEntIntPort.setHorarioInsert(horaMov);
                if (acao == 1) {
                    control.incluirEntradaInternosUnid(objEntIntPort);
                    buscarId();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objEntIntPort.setUsuarioUp(nameUser);
                    objEntIntPort.setDataUp(jDataSistema.getText());
                    objEntIntPort.setHorarioUp(horaMov);
                    objEntIntPort.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarEntradaInternosUnid(objEntIntPort);
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
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADAINTERNOSPORTARIA "
                    + "WHERE IdLanc='" + jIdLanc.getText() + "'");
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
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAudEntInternosP1 objAudP1 = new TelaAudEntInternosP1();
        TelaModuloPortarias.jPainelPortarias.add(objAudP1);
        objAudP1.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIIntP1) && codIncluirP1 == 1) {
            objEntIntPort.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que o lançamento desse interno está correto?, pois, uma vez incluído\no registro, não poderá ser excluir. Caso seja realizado a inclusão, você só poderá\nfazer a saída do interno. Deseja continuar?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    acao = 3;
                    NovoInterno();
                    preencherComboNovo();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIIntP1) && codAlterarP1 == 1) {
            verificarUtilizacaoCrc();
            objEntIntPort.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (pCONFIRMA_ENTRADA.equals("Sim")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poder ser modificado, o mesmo está sendo utilizado no CRC, ou foi CANCELADO.");
                } else if (pCANCELADO != null && pCANCELADO.equals(pREGISTRO_CANCELADO)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poder ser modificado, o mesmo foi CANCELADO.");
                } else {
                    acao = 4;
                    AlterarInterno();
                    preencherComboNovo();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIIntP1) && codExcluirP1 == 1) {
            if (entradaConfirmadaCrc.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poder ser excluído, o mesmo está sendo utilizado no CRC.");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não podera ser excluído, caso necessário, solicite ao CRC fazer o cancelamento.\nCaso seja necessário, após o cancelamento refaça a entrada do interno.");
//                statusMov = "Excluiu";
//                horaMov = jHoraSistema.getText();
//                dataModFinal = jDataSistema.getText();
//                objEntIntPort.setStatusLanc(jStatusLanc.getText());
//                if (jStatusLanc.getText().equals("FINALIZADO")) {
//                    JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
//                } else {
//                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
//                            JOptionPane.YES_NO_OPTION);
//                    if (resposta == JOptionPane.YES_OPTION) {
//                        objItensEntIntPort.setIdItem(Integer.valueOf(idItem));
//                        controle.excluirItensEntradaPortaria(objItensEntIntPort);
//                        objLog2();
//                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
//                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
//                        ExcluirInterno();
//                        preencherTabelaItensInterno("SELECT * FROM ITENSENTRADAPORTARIA "
//                                + "WHERE IdLanc='" + jIdLanc.getText() + "'");
//                    }
//                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaInternoUniPRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIIntP1) && codGravarP1 == 1) {
            if (jNomeInternoPortaria.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno a ser cadastrado.");
                jNomeInternoPortaria.requestFocus();
                jNomeInternoPortaria.setBackground(Color.red);
            } else if (jDataChegada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de chegado da interno");
            } else if (jComboBoxOrigemInterno.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a origem do interno.");
            } else if (jComboBoxOrigemInterno.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a origem do interno.");
            } else {
                objItensEntIntPort.setNomeInternoCrc(jNomeInternoPortaria.getText());
                objItensEntIntPort.setDataChegada(jDataChegada.getDate());
                objItensEntIntPort.setHorarioChegada(jHorario.getText());
                objItensEntIntPort.setNumeroOficio(jOficio.getText());
                objItensEntIntPort.setConfirmaEntrada(confirmaEntrada);
                objItensEntIntPort.setOrigemInterno((String) jComboBoxOrigemInterno.getSelectedItem());
                if (acao == 3) {
                    objItensEntIntPort.setUsuarioInsert(nameUser);
                    objItensEntIntPort.setDataInsert(jDataSistema.getText());
                    objItensEntIntPort.setHorarioInsert(horaMov);
                    objItensEntIntPort.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    controle.incluirItensEntradaPortaria(objItensEntIntPort);
                    buscarItem();
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //CONFIRMAR QUE A PORTARIA UTILIZOU O CADASTRO FEITO PELA OUTRA UNIDADE
                    if (idTransPortUni != null) {
                        pSaidaPortaria.setConfirmaImp(confirmaImp);
                        pSaidaPortaria.setIdSaidTransfTmp(idTransPortUni);
                        controlTransPort.alterarConfirmacaoPortariaBAR(pSaidaPortaria);
                    }
                    //ADICIONAR A POPULAAÇÃO DA ALIMENTAÇÃO A QUANTIDADE DE INTERNOS
                    populacaoAlimentacao();
                    SalvarInterno();
                    preencherTabelaItensInterno("SELECT * FROM ITENSENTRADAPORTARIA "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    objItensEntIntPort.setConfirmaEntrada(confirmaEntrada);
                    objItensEntIntPort.setUsuarioUp(nameUser);
                    objItensEntIntPort.setDataUp(jDataSistema.getText());
                    objItensEntIntPort.setHorarioUp(horaMov);
                    objItensEntIntPort.setIdItem(idItem);
                    objItensEntIntPort.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    controle.alterarItensEntradaPortaria(objItensEntIntPort);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItensInterno("SELECT * FROM ITENSENTRADAPORTARIA "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                    SalvarInterno();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternosActionPerformed
        // TODO add your handling code here:
        TelaAudItensEntradaInternosUnidade objAudItensEntInternos = new TelaAudItensEntradaInternosUnidade();
        TelaModuloPortarias.jPainelPortarias.add(objAudItensEntInternos);
        objAudItensEntInternos.show();
    }//GEN-LAST:event_jBtAuditoriaInternosActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.pesquisarLancamentos("SELECT * FROM ENTRADAINTERNOSPORTARIA");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ome do interno para pesquisa.");
        } else {
            pesquisarEntradaInternoNome("SELECT * FROM ENTRADAINTERNOSPORTARIA "
                    + "INNER JOIN ITENSENTRADAPORTARIA "
                    + "ON ENTRADAINTERNOSPORTARIA.IdLanc=ITENSENTRADAPORTARIA.IdLanc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

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
                if (jDataPesFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        pesquisarLancamentos("SELECT * FROM ENTRADAINTERNOSPORTARIA "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        pesquisarLancamentos("SELECT * FROM ENTRADAINTERNOSPORTARIA "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIdPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            pesquisarLancamentos("SELECT * FROM ENTRADAINTERNOSPORTARIA "
                    + "WHERE IdLanc='" + jIdPesq.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jTabelaEntradasUnidInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEntradasUnidInternosMouseClicked
        // TODO add your handling code here:  
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaEntradasUnidInternos.getValueAt(jTabelaEntradasUnidInternos.getSelectedRow(), 0);
            jIdLanc.setText(IdLanc);
            jDataLanc.setDate(jDataLanc.getDate());
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoInterno.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADAINTERNOSPORTARIA "
                        + "WHERE IdLanc ='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
                preencherTabelaItensInterno("SELECT * FROM ITENSENTRADAPORTARIA "
                        + "WHERE IdLanc='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por lançamento " + e);
            }
        }
    }//GEN-LAST:event_jTabelaEntradasUnidInternosMouseClicked

    private void jTabelaItensEntradaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensEntradaInternoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaItensEntradaInterno.getValueAt(jTabelaItensEntradaInterno.getSelectedRow(), 1);
            jNomeInternoPortaria.setText(nomeInterno);
            String idInterno = "" + jTabelaItensEntradaInterno.getValueAt(jTabelaItensEntradaInterno.getSelectedRow(), 0);
            jIdInterno.setText(idInterno);
            // Habilitar os botões
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true);
            if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
                jBtExcluirInterno.setEnabled(true);
            }
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInternos.setEnabled(true);
            //
            jComboBoxOrigemInterno.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA "
                        + "WHERE IdItem='" + jIdInterno.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdItem")); //Coluna 0
                jNomeInternoPortaria.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1 
                idItem = conecta.rs.getInt("IdItem");
                jDataChegada.setDate(conecta.rs.getDate("DataEntrada"));
                jHorario.setText(conecta.rs.getString("HoraEntrada"));
                jOficio.setText(conecta.rs.getString("OficioInternos"));
                jComboBoxOrigemInterno.addItem(conecta.rs.getString("OrigemInterno"));
                entradaConfirmadaCrc = conecta.rs.getString("ConfirmaEntrada");
                jCanceladoCRC.setText(conecta.rs.getString("RegistroCancelado"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensEntradaInternoMouseClicked

    private void jBtLocalizarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizarInternoActionPerformed
        // TODO add your handling code here:
        TelaLocalizarInternoCrcPortaria objLocaIt = new TelaLocalizarInternoCrcPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objLocaIt);
        objLocaIt.show();
    }//GEN-LAST:event_jBtLocalizarInternoActionPerformed

    private void jBtSai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSai1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSai1ActionPerformed

    private void jBtImportarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImportarDadosActionPerformed
        // TODO add your handling code here:
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível importar dados, registro já está finalizado.");
        } else if (jIdLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É ncessário informar um registro principal para fazer pesquisa..");
        } else {
//            Integer row = jTabelaItensEntradaInterno.getRowCount();
//            if (row == 0) {
//                acao = 3;
//                mostrarTelaQuantidade();
//            }
            acao = 3;
            TelaImportarDadosInternosUnidades objImport = new TelaImportarDadosInternosUnidades();
            TelaModuloPortarias.jPainelPortarias.add(objImport);
            objImport.show();
        }
    }//GEN-LAST:event_jBtImportarDadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jBtAlterar;
    public static javax.swing.JButton jBtAlterarInterno;
    public static javax.swing.JButton jBtAuditoria;
    public static javax.swing.JButton jBtAuditoriaInternos;
    public static javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarInterno;
    public static javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirInterno;
    public static javax.swing.JButton jBtFinalizar;
    public static javax.swing.JButton jBtImportarDados;
    public static javax.swing.JButton jBtLocalizarInterno;
    public static javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSai1;
    private javax.swing.JButton jBtSair;
    public static javax.swing.JButton jBtSalvar;
    public static javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JLabel jCanceladoCRC;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JComboBox jComboBoxOrigemInterno;
    public static com.toedter.calendar.JDateChooser jDataChegada;
    public static com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JFormattedTextField jHorario;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdLanc;
    private javax.swing.JTextField jIdPesq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInternoPortaria;
    public static javax.swing.JTextArea jObservacao;
    public static javax.swing.JTextField jOficio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaEntradasUnidInternos;
    private javax.swing.JTable jTabelaItensEntradaInterno;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarUtilizacaoCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA "
                    + "WHERE IdItem='" + jIdInterno.getText() + "' "
                    + "AND IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            pCODIGO_INTERNO = conecta.rs.getString("IdItem");
            pREGISTRO = conecta.rs.getString("IdLanc");
            pCONFIRMA_ENTRADA = conecta.rs.getString("ConfirmaEntrada");
            pCANCELADO = conecta.rs.getString("RegistroCancelado");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void populacaoAlimentacao() {
        //ADICIONAR POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULCAO_INTERNOS
        objEntradaSaida.setIdDocumento(pID_ITEM_ALIMENTACAO);
        objEntradaSaida.setDataMovimento(jDataChegada.getDate());
        objEntradaSaida.setHorarioMovimento(jHorario.getText());
        objEntradaSaida.setQuantidade(pQUANTIDADE_ENTRADA_INTERNO);
        objEntradaSaida.setTipoOperacao(pTIPO_OPERCAO_ENTRADA);
        objEntradaSaida.setUsuarioInsert(nameUser);
        objEntradaSaida.setDataInsert(jDataSistema.getText());
        objEntradaSaida.setHorarioInsert(horaMov);
        //PEGAR ULTIMA POPUÇÃO PARA EFETUAR CALCULO ANTES DE GRAVAR
        listaUltimaPopulacao.selecionarPopulacao(objEntradaSaida);
        pPOPULCAO_ATUAL = objEntradaSaida.getPopulacao() + pQUANTIDADE_ENTRADA_INTERNO;
        objEntradaSaida.setPopulacao(pPOPULCAO_ATUAL);
        populacao.incluirEntradaSaidaPortaria(objEntradaSaida);
    }

    public void buscarItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA");
            conecta.rs.last();
            pID_ITEM_ALIMENTACAO = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar CÓDIGO DO ITEM \nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jNomeInternoPortaria.setDocument(new LimiteDigitos(57));
        try {
            MaskFormatter horario = new MaskFormatter("##:##");
            jHorario.setFormatterFactory(new DefaultFormatterFactory(horario));
        } catch (ParseException ex) {
        }
    }

    public void bloquearCamposPesquisa() {
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInterno.setEnabled(!true);
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        jComboBoxOrigemInterno.setEnabled(!true);
        //       
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        jComboBoxOrigemInterno.setSelectedItem("Selecione");
        //
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void corCampos() {
        //
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInterno.setBackground(Color.white);
        jNomeInternoPortaria.setBackground(Color.white);
        jDataChegada.setBackground(Color.white);
        jHorario.setBackground(Color.white);
        jOficio.setBackground(Color.white);
    }

    public void Novo() {
        // Limpara campos
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        //
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        //Habiliar campos       
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //        
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
        // Limpar tabela de internos
        limparTabelaItens();
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        jComboBoxOrigemInterno.setSelectedItem("Selecione");
    }

    public void Alterar() {
        //Habiliar campos       
        jDataLanc.setEnabled(true);
        jObservacao.setEnabled(true);
        //         
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void Salvar() {
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //        
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
    }

    public void Excluir() {
        // Limpara campos
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jObservacao.setText("");
        //
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        jCanceladoCRC.setText("");
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //        
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // Limpar tabela de internos
        limparTabelaItens();
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            // Limpara campos
            jIdLanc.setText("");
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jObservacao.setText("");
            //
            jIdInterno.setText("");
            jNomeInternoPortaria.setText("");
            jDataChegada.setDate(null);
            jHorario.setText("");
            jOficio.setText("");
            jCanceladoCRC.setText("");
            //Habiliar campos       
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //        
            jNomeInternoPortaria.setEnabled(!true);
            jDataChegada.setEnabled(!true);
            jHorario.setEnabled(!true);
            jOficio.setEnabled(!true);
            //Habilitar/Desabilitar botões
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        } else {
            //Habiliar campos       
            jDataLanc.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //        
            jNomeInternoPortaria.setEnabled(!true);
            jDataChegada.setEnabled(!true);
            jHorario.setEnabled(!true);
            jOficio.setEnabled(!true);
            //Habilitar/Desabilitar botões
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se essa entrada de internos for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objEntIntPort.setStatusLanc(statusEntrada);
            objEntIntPort.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarEntradaInternosUnid(objEntIntPort);
            jStatusLanc.setText(statusEntrada);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataLanc.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtNovoInterno.setEnabled(!true);
        }
    }

    public void NovoInterno() {
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setCalendar(Calendar.getInstance());
        jHorario.setText("");
        jOficio.setText("");
        jCanceladoCRC.setText("");
        jComboBoxOrigemInterno.setSelectedItem(null);
        //
        jNomeInternoPortaria.setEnabled(true);
        jDataChegada.setEnabled(true);
        jHorario.setEnabled(true);
        jOficio.setEnabled(true);
        jComboBoxOrigemInterno.setEnabled(true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void AlterarInterno() {
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jNomeInternoPortaria.setEnabled(true);
        jDataChegada.setEnabled(true);
        jHorario.setEnabled(true);
        jOficio.setEnabled(true);
        jComboBoxOrigemInterno.setEnabled(true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void ExcluirInterno() {
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        jCanceladoCRC.setText("");
        //
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        jComboBoxOrigemInterno.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void SalvarInterno() {
        //
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        jCanceladoCRC.setText("");
        jComboBoxOrigemInterno.setSelectedItem(null);
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jComboBoxOrigemInterno.setEnabled(!true);
        //
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void CancelarInterno() {
        //Habiliar campos       
        jDataLanc.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInternoPortaria.setText("");
        jDataChegada.setDate(null);
        jHorario.setText("");
        jOficio.setText("");
        jCanceladoCRC.setText("");
        jComboBoxOrigemInterno.setSelectedItem(null);
        //
        jNomeInternoPortaria.setEnabled(!true);
        jDataChegada.setEnabled(!true);
        jHorario.setEnabled(!true);
        jOficio.setEnabled(!true);
        jComboBoxOrigemInterno.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // Habilitar/Desabilitar botoes internos
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInternos.setEnabled(!true);
    }

    public void preencherComboNovo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE ORDER BY DescricaoUnid");
            conecta.rs.first();
            do {
                jComboBoxOrigemInterno.addItem(conecta.rs.getString("DescricaoUnid"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarId() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADAINTERNOSPORTARIA");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
        }
    }

    public void buscarIditem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA");
            conecta.rs.last();
            jIdInterno.setText(conecta.rs.getString("IdItem"));
        } catch (SQLException ex) {
        }
    }

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codEntrada = conecta.rs.getString("IdLanc");
            if (jIdLanc.getText().equals(codEntrada)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEntIntPort.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                control.excluirEntradaInternosUnid(objEntIntPort);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void pesquisarEntradaInternoNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno "};
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
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataBrasil, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradasUnidInternos.setModel(modelo);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setPreferredWidth(520);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradasUnidInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradasUnidInternos.setAutoResizeMode(jTabelaEntradasUnidInternos.AUTO_RESIZE_OFF);
        jTabelaEntradasUnidInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    // Pesquisa de Lançamento por Código (ID)
    public void pesquisarLancamentos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
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
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataBrasil, conecta.rs.getString("StatusLanc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradasUnidInternos.setModel(modelo);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setPreferredWidth(490);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradasUnidInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradasUnidInternos.setAutoResizeMode(jTabelaEntradasUnidInternos.AUTO_RESIZE_OFF);
        jTabelaEntradasUnidInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradasUnidInternos.setModel(modelo);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setPreferredWidth(490);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradasUnidInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradasUnidInternos.setAutoResizeMode(jTabelaEntradasUnidInternos.AUTO_RESIZE_OFF);
        jTabelaEntradasUnidInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradasUnidInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaItensInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data", "Horário", "Nr. Oficio"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataChegada = conecta.rs.getString("DataEntrada");
                String diac = dataChegada.substring(8, 10);
                String mesc = dataChegada.substring(5, 7);
                String anoc = dataChegada.substring(0, 4);
                dataChegada = diac + "/" + mesc + "/" + anoc;
                dados.add(new Object[]{conecta.rs.getString("IdItem"), conecta.rs.getString("NomeInternoCrc"), dataChegada, conecta.rs.getString("HoraEntrada"), conecta.rs.getString("OficioInternos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensEntradaInterno.setModel(modelo);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensEntradaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensEntradaInterno.setAutoResizeMode(jTabelaItensEntradaInterno.AUTO_RESIZE_OFF);
        jTabelaItensEntradaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data", "Horário", "Nr. Oficio"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensEntradaInterno.setModel(modelo);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensEntradaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensEntradaInterno.setAutoResizeMode(jTabelaItensEntradaInterno.AUTO_RESIZE_OFF);
        jTabelaItensEntradaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaItens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensEntradaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaItensEntradaInterno.getColumnModel().getColumn(4).setCellRenderer(centralizado);
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
