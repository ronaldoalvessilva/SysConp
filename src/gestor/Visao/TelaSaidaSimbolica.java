/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAcessoGeral;
import gestor.Controle.ControleEntradasSaidasPopulacaoInternos;
import gestor.Controle.ControleItensLocacaoInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleMovSaidaEvasao;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSaidaSimbolica;
import gestor.Controle.ControleSituacao;
import gestor.Controle.ListagemRegistroSaidaPopulcaoPortaria;
import gestor.Controle.ListagemUltimaPopulacaoCRC;
import gestor.Controle.PesquisaSaidaSimbolicaCodigo;
import gestor.Controle.PesquisaSaidaSimbolicaData;
import gestor.Controle.PesquisarGravacaoInterno;
import gestor.Controle.PesquisarInternosSaidasSimbolicas;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CamposAcessos;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import gestor.Modelo.ItensLocacaoInternos;
import gestor.Modelo.ItensMovSaidaRetorno;
import gestor.Modelo.ItensRegSaidaInternos;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RolVisitas;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloCRC.telaSaidaSimbolicaInt_CRC;
import static gestor.Visao.TelaModuloCRC.telaSaidaSimbolicaManu_CRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaSaidaSimbolica extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();
    PesquisaSaidaSimbolicaCodigo listaCodigo = new PesquisaSaidaSimbolicaCodigo();
    PesquisaSaidaSimbolicaData listaData = new PesquisaSaidaSimbolicaData();
    PesquisarInternosSaidasSimbolicas LISTAR_internos = new PesquisarInternosSaidasSimbolicas();
    PesquisarGravacaoInterno LISTAR_REGISTROS_internos = new PesquisarGravacaoInterno();
    //
    ItensMovSaidaRetorno objMovSaiRetornoEva = new ItensMovSaidaRetorno(); // Classe de saida com verificação de retorno
    ControleMovSaidaEvasao controlMovSaiRet = new ControleMovSaidaEvasao(); // Classe que grava os dados para retorno saida temporaria MOVISR
    //
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    ControleMovInternos controlMov = new ControleMovInternos(); // HISTÓRICO DE MOVIMENTAÇÃO DE SAIDA NO CRC
    //
    ControleRolVisitas controlRol = new ControleRolVisitas(); // Classe do Serviço social para FINALIZAR Rol quando interno sair da unidade
    RolVisitas objRol = new RolVisitas();
    // Excluir interno quando o mesmo sair da unidade, quando não for para saida audiência
    ControleItensLocacaoInternos excluirInternoCela = new ControleItensLocacaoInternos(); // Excluir Cela do Interno na saida
    ItensLocacaoInternos objItensLoca = new ItensLocacaoInternos();
    ItensRegSaidaInternos objItemSaidaPort = new ItensRegSaidaInternos();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleSituacao mod = new ControleSituacao(); // MODIFICA A SITUAÇAO DO INTERNO NO PRONTUARIO.    
    //ADICIONAR A POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULACAO_INTERNOS (CONTROLE ALIMENTAÇÃO)
    ControleEntradasSaidasPopulacaoInternos populacao = new ControleEntradasSaidasPopulacaoInternos();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    ListagemUltimaPopulacaoCRC listaUltimaPopulacao = new ListagemUltimaPopulacaoCRC();
    ListagemRegistroSaidaPopulcaoPortaria listaRegistroES = new ListagemRegistroSaidaPopulcaoPortaria();
    //
    ControleSaidaSimbolica control = new ControleSaidaSimbolica();
    ControleAcessoGeral pPESQUISAR_acessos = new ControleAcessoGeral();
    CamposAcessos objCampos = new CamposAcessos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Movimentação Saída Simbólica:Manutenção";
    String nomeModuloTela1 = "CRC:Movimentação Saída Simbólica:Internos";
    //
    int flag;
    int acao;
    int count;
    public static int pTOTAL_registros = 0;
    public static String dataInicial;
    public static String dataFinal;
    String dataEntrada;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String pDATA_Registros = "";
    //
    public static String pINTERNOS;
    public static String idItemSS;
    public static int idItem;
    public static int codItem;
    // TABELA MOVISR
    String evadido = "";
    String nrDocumentoRetorno = "";
    Date pDATA_retorno = null;
    //POPULAÇÃO
    String pTIPO_OPERCAO_ENTRADA = "Saida da Unidade";
    public static String pREGISTRO_ENTRADA = "";
    int pPOPULCAO_ATUAL = 0;
    int pQUANTIDADE_SAIDA_INTERNO = 1;
    int pID_ITEM_ALIMENTACAO = 0;
    //
    String pREGISTRO_cancelado = "";
    String pSTATUS_ROL_finalizado = "FINALIZADO";
    public static String pCODIGO_INTERNO_rol = "";
    public static String pSTATUS_ROL_aberto = "ABERTO";
    //
    String pSITUACAO_interno = "";
    public static String pCODIGO_registro = "";
    public static String pCODIGO_interno = "";

    /**
     * Creates new form TelaSaidaSimbolica
     */
    public static TelaPesquisaInternoSaidaSimbolica pPESQUISA_INTERNO_saida;

    public TelaSaidaSimbolica() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarPesquisa() {
        pPESQUISA_INTERNO_saida = new TelaPesquisaInternoSaidaSimbolica(this, true);
        pPESQUISA_INTERNO_saida.setVisible(true);
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
        jPanel12 = new javax.swing.JPanel();
        jCodigoReq = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jBtPesqCodigoReq = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBoxTodosReq = new javax.swing.JCheckBox();
        jBtPesqInterno = new javax.swing.JButton();
        jPesquisarNomeInterno = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaSaidaSimbolica = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jStatusRegistro = new javax.swing.JTextField();
        jLocalAudiencia = new javax.swing.JTextField();
        jNomeJuiz = new javax.swing.JTextField();
        jVaraCrime = new javax.swing.JTextField();
        jDocumentoSB_Registro = new javax.swing.JTextField();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMotivo = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoBeneficio = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jIdInternoCrc = new javax.swing.JTextField();
        jMatriculaPenal = new javax.swing.JTextField();
        jRegime = new javax.swing.JTextField();
        jNomeInterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jNomeMaeInterno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSairInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jtotaInternosSelecionados = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jDocumentoInterno = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxTipoBeneficioIndividual = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jDataBeneficio = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jFotoInternoSB = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jBtPesquisaInterno = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Saída Simbólica :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCodigoReq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoReq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Código:");

        jBtPesqCodigoReq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoReq.setContentAreaFilled(false);
        jBtPesqCodigoReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoReqActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Data Final:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jCheckBoxTodosReq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosReq.setText("Todos");
        jCheckBoxTodosReq.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosReqItemStateChanged(evt);
            }
        });

        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jPesquisarNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Interno:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel72)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxTodosReq))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPesquisarNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel70)
                    .addComponent(jCodigoReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigoReq)
                    .addComponent(jCheckBoxTodosReq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addGap(3, 3, 3)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesquisarNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jBtPesqInterno))
                .addGap(5, 5, 5))
        );

        jTabelaSaidaSimbolica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSaidaSimbolica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Dt. Registro", "Status Registro", "Tipo de Benefício"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaSaidaSimbolica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaSaidaSimbolicaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaSaidaSimbolica);
        if (jTabelaSaidaSimbolica.getColumnModel().getColumnCount() > 0) {
            jTabelaSaidaSimbolica.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(2).setMinWidth(90);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(2).setMaxWidth(90);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaSaidaSimbolica.getColumnModel().getColumn(3).setMaxWidth(250);
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
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
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
        jLabel4.setText("Motivo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Doc. Número");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Vara Crime");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Local Audiência");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome do Juíz");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jStatusRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusRegistro.setForeground(new java.awt.Color(204, 0, 0));
        jStatusRegistro.setText("ABERTO");
        jStatusRegistro.setToolTipText("");
        jStatusRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusRegistro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusRegistro.setEnabled(false);

        jLocalAudiencia.setText("Digite aqui o local da audiência");
        jLocalAudiencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLocalAudiencia.setEnabled(false);

        jNomeJuiz.setText("Digite aqui o nome do juíz");
        jNomeJuiz.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeJuiz.setEnabled(false);

        jVaraCrime.setText("Digie aqui a Vara Crime");
        jVaraCrime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jVaraCrime.setEnabled(false);

        jDocumentoSB_Registro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumentoSB_Registro.setText("Documento");
        jDocumentoSB_Registro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumentoSB_Registro.setEnabled(false);

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jMotivo.setColumns(20);
        jMotivo.setRows(5);
        jMotivo.setText("Digiete aqui o motivo da saída");
        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);
        jScrollPane1.setViewportView(jMotivo);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tipo de Benefício");

        jComboBoxTipoBeneficio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoBeneficio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Individual", "Saída Alvará", "Livramento Condicional", "Progressão de Regime", "Regressão de Regime", "Transferência", "Prisão Domiciliar" }));
        jComboBoxTipoBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoBeneficio.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDocumentoSB_Registro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jVaraCrime)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxTipoBeneficio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNomeJuiz, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLocalAudiencia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addGap(0, 13, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDocumentoSB_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jVaraCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeJuiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLocalAudiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
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

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditória");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Matricula Penal");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Regime Penal");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nome do Interno");

        jIdInternoCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoCrc.setEnabled(false);

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegime.setEnabled(false);

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome da Mãe");

        jNomeMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInterno.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(0, 26, Short.MAX_VALUE))
                                    .addComponent(jIdInternoCrc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jMatriculaPenal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(102, 102, 102))
                            .addComponent(jNomeMaeInterno)
                            .addComponent(jNomeInterno)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel13)
                .addGap(3, 3, 3)
                .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Doc. Número", "Benefício", "Data Benefício"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaInternos.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(4).setMinWidth(150);
            jTabelaInternos.getColumnModel().getColumn(4).setMaxWidth(150);
            jTabelaInternos.getColumnModel().getColumn(5).setMinWidth(100);
            jTabelaInternos.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setToolTipText("Novo");
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirInterno.setToolTipText("Excluir");
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setToolTipText("Gravar");
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setToolTipText("Cancelar");
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtSairInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairInterno.setToolTipText("Sair");
        jBtSairInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairInternoActionPerformed(evt);
            }
        });

        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setToolTipText("Auditória");
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jBtSairInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSairInterno, jBtSalvarInterno});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarInterno)
                    .addComponent(jBtExcluirInterno)
                    .addComponent(jBtSalvarInterno)
                    .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSairInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSairInterno, jBtSalvarInterno});

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotaInternosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotaInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotaInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel71.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jDocumentoInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumentoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumentoInterno.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Doc. Número");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tipo de Benefício");

        jComboBoxTipoBeneficioIndividual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoBeneficioIndividual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Outros", "Saída Alvará", "Livramento Condicional", "Progressão de Regime", "Regressão de Regime", "Transferência", "Prisão Domiciliar", "Prisão Domiciliar/COVID-19" }));
        jComboBoxTipoBeneficioIndividual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoBeneficioIndividual.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Data benefício");

        jDataBeneficio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataBeneficio.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jDocumentoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxTipoBeneficioIndividual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoBeneficioIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDocumentoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Internos", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoInternoSB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoSB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoSB, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtPesquisaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaInterno.setText("Pesquisar");
        jBtPesquisaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaInternoActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPesquisaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtImpressao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao, jBtPesquisaInterno});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtPesquisaInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao, jBtPesquisaInterno});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 60, 604, 476);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoReqActionPerformed
        // TODO add your handling code here:
        if (jCodigoReq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            // APAGAR DADOS DA TABELA
            while (jTabelaSaidaSimbolica.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaSaidaSimbolica.getModel()).removeRow(0);
            }
            mostrarRegistroCodigo();
            if (pTOTAL_registros == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
            }
        }
    }//GEN-LAST:event_jBtPesqCodigoReqActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        // APAGAR DADOS DA TABELA
                        while (jTabelaSaidaSimbolica.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaSaidaSimbolica.getModel()).removeRow(0);
                        }
                        mostraPesquisaData();
                        if (pTOTAL_registros == 0) {
                            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
                        }
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
                        // APAGAR DADOS DA TABELA
                        while (jTabelaSaidaSimbolica.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaSaidaSimbolica.getModel()).removeRow(0);
                        }
                        mostraPesquisaData();
                        if (pTOTAL_registros == 0) {
                            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBoxTodosReqItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosReqItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            // APAGAR DADOS DA TABELA
            while (jTabelaSaidaSimbolica.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaSaidaSimbolica.getModel()).removeRow(0);
            }
            mostrarTodos();
            if (pTOTAL_registros == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
            }
        } else {
            // APAGAR DADOS DA TABELA
            while (jTabelaSaidaSimbolica.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaSaidaSimbolica.getModel()).removeRow(0);
            }
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBoxTodosReqItemStateChanged

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        if (jPesquisarNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {

        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jTabelaSaidaSimbolicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaSaidaSimbolicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaSaidaSimbolica.getValueAt(jTabelaSaidaSimbolica.getSelectedRow(), 0);
            jCodigoReq.setText(IdLanc);
            bloquearBotoes(!true);
            bloquearCampos(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
            //
            control.MOSTRAR_interno(objSaida);
            jIdRegistro.setText(String.valueOf(objSaida.getIdRegSaida()));
            jStatusRegistro.setText(objSaida.getStatusRegistro());
            jDataRegistro.setDate(objSaida.getDataRegistro());
            jDocumentoSB_Registro.setText(objSaida.getNrdocumento());
            jVaraCrime.setText(objSaida.getVaraCrime());
            jNomeJuiz.setText(objSaida.getNomeJuiz());
            jLocalAudiencia.setText(String.valueOf(objSaida.getLocalAudiencia()));
            jComboBoxTipoBeneficio.setSelectedItem(objSaida.getTipoBeneficio().toString());
            jMotivo.setText(objSaida.getMotivoSaida());
            // APAGAR DADOS DA TABELA
            while (jTabelaInternos.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
            }
            pPREENCHER_TABELA_Internos();
        }
    }//GEN-LAST:event_jTabelaSaidaSimbolicaMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaManu_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaManu_CRC) && objCampos.getCodigoIncluir() == 1) {
            acao = 1;
            limparTodosCampos();
            bloquearBotoes(!true);
            bloquearCampos(!true);
            // APAGAR DADOS DA TABELA
            while (jTabelaInternos.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
            }
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
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaManu_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaManu_CRC) && objCampos.getCodigoAlterar() == 1) {
            objSaida.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearBotoes(!true);
                bloquearCampos(!true);
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
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaManu_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaManu_CRC) && objCampos.getCodigoExcluir() == 1) {
            objSaida.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    objSaida.setIdRegSaida(Integer.valueOf(jIdRegistro.getText()));
                    control.excluirRegistroSaida(objSaida);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação         
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    limparTodosCampos();
                    Excluir();
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaManu_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaManu_CRC) && objCampos.getCodigoGravar() == 1) {
            if (jDataRegistro.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
            } else if (jVaraCrime.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a Vara Crime.");
            } else if (jLocalAudiencia.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o local da audiência.");
            } else if (jComboBoxTipoBeneficio.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de benefício.");
            } else if (jMotivo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o motivo da saída simbólica.");
            } else {
                objSaida.setStatusRegistro(jStatusRegistro.getText());
                objSaida.setDataRegistro(jDataRegistro.getDate());
                objSaida.setNrdocumento(jDocumentoSB_Registro.getText());
                objSaida.setVaraCrime(jVaraCrime.getText());
                objSaida.setNomeJuiz(jNomeJuiz.getText());
                objSaida.setLocalAudiencia(jLocalAudiencia.getText());
                objSaida.setTipoBeneficio((String) jComboBoxTipoBeneficio.getSelectedItem());
                objSaida.setMotivoSaida(jMotivo.getText());
                if (acao == 1) {
                    objSaida.setUsuarioInsert(nameUser);
                    objSaida.setDataInsert(dataModFinal);
                    objSaida.setHorarioInsert(horaMov);
                    control.incluirRegistroSaida(objSaida);
                    BUSCAR_codigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objSaida.setUsuarioUp(nameUser);
                    objSaida.setDataUp(dataModFinal);
                    objSaida.setHorarioUp(horaMov);
                    objSaida.setIdRegSaida(Integer.parseInt(jIdRegistro.getText()));
                    control.alterarRegistroSaida(objSaida);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaSaidaSimbolica objAudSS = new TelaAuditoriaSaidaSimbolica();
        TelaModuloCRC.jPainelCRC.add(objAudSS);
        objAudSS.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaInt_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaInt_CRC) && objCampos.getCodigoIncluir() == 1) {
            objSaida.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                limparCamposInterno();
                bloquearBotoes(!true);
                bloquearCampos(!true);
                NovoInterno();
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
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaInt_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaInt_CRC) && objCampos.getCodigoAlterar() == 1) {
            objSaida.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                bloquearBotoes(!true);
                bloquearCampos(!true);
                AlterarInterno();
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
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaInt_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaInt_CRC) && objCampos.getCodigoExcluir() == 1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objSaida.setIdItem(WIDTH);
                control.excluirItensRegistroSaida(objSaida);
                objLog1();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                limparCamposInterno();
                bloquearBotoes(!true);
                bloquearCampos(!true);
                ExcluirInterno();
                pPREENCHER_TABELA_Internos();
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaSaidaSimbolicaInt_CRC);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaSaidaSimbolicaInt_CRC) && objCampos.getCodigoGravar() == 1) {
            if (jIdInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jDocumentoInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
            } else if (jComboBoxTipoBeneficioIndividual.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de benefício do interno.");
            } else if(!jComboBoxTipoBeneficioIndividual.getSelectedItem().equals(jComboBoxTipoBeneficio.getSelectedItem())){
                JOptionPane.showMessageDialog(rootPane, "O tipo de beneficio selecionado na aba manutenção, é diferente da aba internos.");
            } else if (jDataBeneficio.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do benefício.");
            } else {
                objSaida.setIdRegSaida(Integer.parseInt(jIdRegistro.getText()));
                objSaida.setIdInternoCrc(Integer.parseInt(jIdInternoCrc.getText()));
                objSaida.setNomeInternoCrc(jNomeInterno.getText());
                objSaida.setNrdocumentoSA(jDocumentoInterno.getText());
                objSaida.setTipoBeneficioSA((String) jComboBoxTipoBeneficioIndividual.getSelectedItem());
                objSaida.setDataRegistroSA(jDataBeneficio.getDate());
                if (acao == 3) {
                    //VERIFICAR A EXISTENCIA DE INTERNO
                    control.PESQUISAR_EXISTENCIA_interno(objSaida);
                    if (jIdRegistro.getText().equals(pCODIGO_registro) && jIdInternoCrc.getText().equals(pCODIGO_interno)) {
                        JOptionPane.showMessageDialog(rootPane, "Interno já cadastrado, tente outro...");
                    } else {
                        objSaida.setUsuarioInsert(nameUser);
                        objSaida.setDataInsert(dataModFinal);
                        objSaida.setHorarioInsert(horaMov);
                        control.incluirItensRegistroSaida(objSaida);
                        objLog1();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        limparCamposInterno();
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        SalvarInterno();
                        pPREENCHER_TABELA_REG_Internos();
                        acao = 0;
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 4) {
                    objSaida.setUsuarioUp(nameUser);
                    objSaida.setDataUp(dataModFinal);
                    objSaida.setHorarioUp(horaMov);
                    objSaida.setIdItem(WIDTH);
                    control.alterarItensRegistroSaida(objSaida);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    limparCamposInterno();
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    SalvarInterno();
                    acao = 0;
                    pPREENCHER_TABELA_REG_Internos();
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

    private void jBtSairInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairInternoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaInternosSaidaSimbolica objAudiInter = new TelaAuditoriaInternosSaidaSimbolica();
        TelaModuloCRC.jPainelCRC.add(objAudiInter);
        objAudiInter.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtPesquisaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaInternoActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        if (jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro principal a ser associado a esse interno.");
        } else if (!jIdRegistro.getText().equals("") && acao == 3 || !jIdRegistro.getText().equals("") && acao == 4) {
            mostrarPesquisa();
        } else if (!jIdRegistro.getText().equals("") && acao != 3 || !jIdRegistro.getText().equals("") && acao != 4) {
            JOptionPane.showMessageDialog(rootPane, "Você não está no modo de edição do registro.");
        }
    }//GEN-LAST:event_jBtPesquisaInternoActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            control.PESQUISAR_status(objSaida);
            if (objSaida.getStatusRegistro().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir esse registro, pois não existe(m) interno(s) lançado(s).");
        } else if (jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registro a ser impresso no relatório.");
        } else {
            final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
            carregando.setVisible(true);//Teste tela aguarde
            Thread t = new Thread() { //Teste tela aguarde
                public void run() { //Teste
                    try {
                        conecta.abrirConexao();
                        String path = "reports/CRC/RelatorioSaidaSimbolicaInterno.jasper";
                        conecta.executaSQL("SELECT * FROM SAIDA_SIMBOLICA_CRC "
                                + "WHERE SAIDA_SIMBOLICA_CRC.IdRegSaida='" + jIdRegistro.getText() + "' ");
                        HashMap parametros = new HashMap();
                        parametros.put("pUnidade", descricaoUnidade);
                        parametros.put("pCodigo", jIdRegistro.getText());
                        parametros.put("pUsuario", nameUser);
                        // Sub Relatório
                        try {
                            parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                        } catch (SQLException ex) {
                        }
                        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                        JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                        JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                        jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                        jv.setTitle("Relatório de Saída Simbólica de internos.");
                        jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                        jv.toFront(); // Traz o relatorio para frente da aplicação    
                        carregando.dispose(); //Teste tela aguarde
                        conecta.desconecta();
                    } catch (JRException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório...\n\nERROR :" + e);
                    }
                }
            }; //Teste tela aguarde
            t.start(); //Teste tela aguarde
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idItemSS = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            pINTERNOS = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            //
            bloquearBotoes(!true);
            bloquearCampos(!true);
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            //
            LISTAR_internos.MOSTRAR_SAIDA_SIMBOLICA_internos(objSaida);
            jIdInternoCrc.setText(String.valueOf(objSaida.getIdInternoCrc()));
            jMatriculaPenal.setText(objSaida.getMatriculaPenal());
            jRegime.setText(objSaida.getRegimePenal());
            jNomeInterno.setText(objSaida.getNomeInternoCrc());
            jNomeMaeInterno.setText(objSaida.getMaeInterno());
            jDocumentoInterno.setText(objSaida.getNrdocumentoSA());
            jComboBoxTipoBeneficioIndividual.setSelectedItem(objSaida.getTipoBeneficioSA());
            jDataBeneficio.setDate(objSaida.getDataRegistroSA());
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqCodigoReq;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesquisaInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairInterno;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBoxTodosReq;
    public static javax.swing.JTextField jCodigoReq;
    private javax.swing.JComboBox<String> jComboBoxTipoBeneficio;
    public static javax.swing.JComboBox<String> jComboBoxTipoBeneficioIndividual;
    public static com.toedter.calendar.JDateChooser jDataBeneficio;
    public static com.toedter.calendar.JDateChooser jDataPesFinal;
    public static com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static javax.swing.JTextField jDocumentoInterno;
    private javax.swing.JTextField jDocumentoSB_Registro;
    public static javax.swing.JLabel jFotoInternoSB;
    public static javax.swing.JTextField jIdInternoCrc;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLocalAudiencia;
    public static javax.swing.JTextField jMatriculaPenal;
    private javax.swing.JTextArea jMotivo;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jNomeJuiz;
    public static javax.swing.JTextField jNomeMaeInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jPesquisarNomeInterno;
    public static javax.swing.JTextField jRegime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusRegistro;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaSaidaSimbolica;
    private javax.swing.JTextField jVaraCrime;
    public static javax.swing.JLabel jtotaInternosSelecionados;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jMotivo.setLineWrap(true);
        jMotivo.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jStatusRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jDocumentoSB_Registro.setBackground(Color.white);
        jVaraCrime.setBackground(Color.white);
        jNomeJuiz.setBackground(Color.white);
        jLocalAudiencia.setBackground(Color.white);
        jComboBoxTipoBeneficio.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
        //
        jIdInternoCrc.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jRegime.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jNomeMaeInterno.setBackground(Color.white);
        jDocumentoInterno.setBackground(Color.white);
        jComboBoxTipoBeneficioIndividual.setBackground(Color.white);
        jDataBeneficio.setBackground(Color.white);
    }

    public void limparTodosCampos() {
        jIdRegistro.setText("");
        jStatusRegistro.setText("");
        jDataRegistro.setDate(null);
        jDocumentoSB_Registro.setText("");
        jVaraCrime.setText("");
        jNomeJuiz.setText("");
        jLocalAudiencia.setText("");
        jComboBoxTipoBeneficio.setSelectedItem("Selecione...");
        jMotivo.setText("");
        //
        jIdInternoCrc.setText("");
        jMatriculaPenal.setText("");
        jRegime.setText("");
        jNomeInterno.setText("");
        jNomeMaeInterno.setText("");
        jDocumentoInterno.setText("");
        jComboBoxTipoBeneficioIndividual.setSelectedItem("Selecione...");
        jDataBeneficio.setDate(null);
        jFotoInternoSB.setIcon(null);
    }

    public void limparCamposInterno() {
        jIdInternoCrc.setText("");
        jMatriculaPenal.setText("");
        jRegime.setText("");
        jNomeInterno.setText("");
        jNomeMaeInterno.setText("");
        jDocumentoInterno.setText("");
        jComboBoxTipoBeneficioIndividual.setSelectedItem("Selecione...");
        jDataBeneficio.setDate(null);
        jFotoInternoSB.setIcon(null);
    }

    public void bloquearBotoes(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        //
        jBtNovoInterno.setEnabled(opcao);
        jBtAlterarInterno.setEnabled(opcao);
        jBtExcluirInterno.setEnabled(opcao);
        jBtSalvarInterno.setEnabled(opcao);
        jBtCancelarInterno.setEnabled(opcao);
        jBtAuditoriaInterno.setEnabled(opcao);
    }

    public void bloquearCampos(boolean opcao) {
        jIdRegistro.setEnabled(opcao);
        jStatusRegistro.setEnabled(opcao);
        jDataRegistro.setEnabled(opcao);
        jDocumentoSB_Registro.setEnabled(opcao);
        jVaraCrime.setEnabled(opcao);
        jNomeJuiz.setEnabled(opcao);
        jLocalAudiencia.setEnabled(opcao);
        jComboBoxTipoBeneficio.setEnabled(opcao);
        jMotivo.setEnabled(opcao);
        //
        jIdInternoCrc.setEnabled(opcao);
        jMatriculaPenal.setEnabled(opcao);
        jRegime.setEnabled(opcao);
        jNomeInterno.setEnabled(opcao);
        jNomeMaeInterno.setEnabled(opcao);
        jDocumentoInterno.setEnabled(opcao);
        jComboBoxTipoBeneficioIndividual.setEnabled(opcao);
        jDataBeneficio.setEnabled(opcao);
    }

    public void Novo() {
        jStatusRegistro.setText("ABERTO");
        jDataRegistro.setCalendar(Calendar.getInstance());
        //
        jDocumentoSB_Registro.setEnabled(true);
        jVaraCrime.setEnabled(true);
        jNomeJuiz.setEnabled(true);
        jLocalAudiencia.setEnabled(true);
        jComboBoxTipoBeneficio.setEnabled(true);
        jMotivo.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDocumentoSB_Registro.setEnabled(true);
        jVaraCrime.setEnabled(true);
        jNomeJuiz.setEnabled(true);
        jLocalAudiencia.setEnabled(true);
        jComboBoxTipoBeneficio.setEnabled(true);
        jMotivo.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistro.getText().equals("")) {
            bloquearBotoes(!true);
            bloquearCampos(!true);
            limparTodosCampos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearBotoes(!true);
            bloquearCampos(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
        }
    }

    public void BUSCAR_codigo() {
        control.PESQUISAR_codigo(objSaida);
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
            carregando.setVisible(true);//Teste tela aguarde
            Thread t = new Thread() { //Teste tela aguarde
                Date date = null;
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                public void run() { //Teste
                    for (int i = 0; i < jTabelaInternos.getRowCount(); i++) {
                        //LANÇAR NA TABELA DE MOVIMENTAÇÃO   
                        // TABELA MOVISR
                        objMovSaiRetornoEva.setIdSaida(Integer.valueOf(jIdRegistro.getText()));
                        objMovSaiRetornoEva.setDataPrevRetorno(pDATA_retorno);
                        objMovSaiRetornoEva.setNrDocRetorno(nrDocumentoRetorno);
                        objMovSaiRetornoEva.setDataEvasao(evadido);
                        objMovSaiRetornoEva.setIdInternoCrc((int) jTabelaInternos.getValueAt(i, 1));
                        objMovSaiRetornoEva.setNomeInternoCrc((String) jTabelaInternos.getValueAt(i, 2));
                        objMovSaiRetornoEva.setNrDocSaida((String) jTabelaInternos.getValueAt(i, 3));
                        objMovSaiRetornoEva.setTipoSaida((String) jTabelaInternos.getValueAt(i, 4));
                        try {
                            // Converte a data de string para date, para ser inserido no banco de dados.
                            date = (java.util.Date) formatter.parse((String) jTabelaInternos.getValueAt(i, 5));
                        } catch (ParseException ex) {
                        }
                        objMovSaiRetornoEva.setDataSaida(date);
                        controlMovSaiRet.incluirMovSaidaEvasao(objMovSaiRetornoEva); // Grava registros para retorno de interno (Sinalizar evasão) MOVISR
                        //TABELA MOVIMENTOCRC
                        //Inserir na tabela de movimentação (SAIDA) HISTÓRICO DE MOVIMENTAÇÃO NO CRC    
                        objItemSaidaPort.setIdItemSaida(jTabelaInternos.getValueAt(i, 0).toString());
                        objItemSaida.setIdInternoSaida((int) jTabelaInternos.getValueAt(i, 1));
                        objItemSaida.setNomeInterno((String) jTabelaInternos.getValueAt(i, 2));
                        objItemSaida.setIdSaida(Integer.valueOf(jIdRegistro.getText()));
                        objItemSaida.setNomeDestino((String) jTabelaInternos.getValueAt(i, 4));
                        objItemSaida.setDataSaida(date);
                        controlMov.incluirMovSaida(objItemSaida);
                        //RETIRAR DO ROL DE VISITAS
                        // Bloquear interno no Rol (FINALIZAR)
                        objRol.setIdInterno((int) jTabelaInternos.getValueAt(i, 1));
                        LISTAR_internos.PESQUISAR_INTERNO_rol(objRol);
                        objRol.setIdInterno((int) jTabelaInternos.getValueAt(i, 1));
                        objRol.setStatusRol(pSTATUS_ROL_finalizado);
                        objRol.setObsRol((String) jTabelaInternos.getValueAt(i, 4));
                        objRol.setUsuarioUp(nameUser);
                        objRol.setDataUp(jDataSistema.getText());
                        objRol.setHoraUp(horaMov);
                        controlRol.finalizarRolVisitasPortaria(objRol);
                        //MODIFICAR SITUAÇÃO DO INTERNO NO PRONTUARIO
                        objProCrc.setIdInterno((int) jTabelaInternos.getValueAt(i, 1));
                        objProCrc.setDescricaoDoc((String) jTabelaInternos.getValueAt(i, 4));
                        if (objProCrc.getDescricaoDoc().equals("Saída Alvará")) {
                            pSITUACAO_interno = "SAIDA ALVARA";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        } else if (objProCrc.getDescricaoDoc().equals("Livramento Condicional")) {
                            pSITUACAO_interno = "LIVRAMENTO CONDICIONAL";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        } else if (objProCrc.getDescricaoDoc().equals("Progressão de Regime")) {
                            pSITUACAO_interno = "PROGRESSAO DE REGIME";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        } else if (objProCrc.getDescricaoDoc().equals("Regressão de Regime")) {
                            pSITUACAO_interno = "REGRESSAO DE REGIME";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        } else if (objProCrc.getDescricaoDoc().equals("Transferência")) {
                            pSITUACAO_interno = "TRANSFERENCIA";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        } else if (objProCrc.getDescricaoDoc().equals("Prisão Domiciliar")) {
                            pSITUACAO_interno = "PRISAO DOMICILIAR";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        } else if (objProCrc.getDescricaoDoc().equals("Prisão Domiciliar/COVID-19")) {
                            pSITUACAO_interno = "PRISAO DOMICILIAR - COVID-19";
                            objProCrc.setSituacao(pSITUACAO_interno);
                        }
                        mod.alterarSituacaoInterno(objProCrc);
                        // RETIRAR DA POPULAÇÃO - RETIRAR DA CELA
                        // EXCLUIR O INTERNO DA CELA NO MOMENTO DA SAIDA NA PORTARIA.
                        objItensLoca.setIdInternoCrc((int) jTabelaInternos.getValueAt(i, 1));
                        excluirInternoCela.deletarInternoLocacaoSaida(objItensLoca);
                        //MODIFICAR A POPULAÇÃO DE ALIMENTAÇÃO
                        objEntradaSaida.setIdDocumento(Integer.parseInt(jIdRegistro.getText()));
                        objEntradaSaida.setDataMovimento(date);
                        objEntradaSaida.setHorarioMovimento(horaMov);
                        objEntradaSaida.setQuantidade(pQUANTIDADE_SAIDA_INTERNO);
                        objEntradaSaida.setTipoOperacao(pTIPO_OPERCAO_ENTRADA);
                        objEntradaSaida.setUsuarioInsert(nameUser);
                        objEntradaSaida.setDataInsert(jDataSistema.getText());
                        objEntradaSaida.setHorarioInsert(horaMov);
                        //PEGAR ULTIMA POPULAÇÃO PARA EFETUAR CALCULO ANTES DE GRAVAR
                        listaUltimaPopulacao.selecionarPopulacao(objEntradaSaida);
                        pPOPULCAO_ATUAL = objEntradaSaida.getPopulacao() - pQUANTIDADE_SAIDA_INTERNO;
                        objEntradaSaida.setPopulacao(pPOPULCAO_ATUAL);
                        populacao.incluirEntradaSaidaPortaria(objEntradaSaida);
                    }
                    String statusLanc = "FINALIZADO";
                    objSaida.setStatusRegistro(statusLanc);
                    objSaida.setIdRegSaida(Integer.parseInt(jIdRegistro.getText()));
                    control.finalizarRegistroSaida(objSaida);
                    jStatusRegistro.setText("FINALIZADO");
                    carregando.dispose(); //Teste tela aguarde
                    JOptionPane.showMessageDialog(rootPane, "Registro finalizado com sucesso.");
                }
            }; //Teste tela aguarde
            t.start(); //Teste tela aguarde
        }
    }

    public void NovoInterno() {
        jDocumentoInterno.setEnabled(true);
        jComboBoxTipoBeneficioIndividual.setEnabled(true);
        jDataBeneficio.setEnabled(true);
        //
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void AlterarInterno() {
        jDocumentoInterno.setEnabled(true);
        jComboBoxTipoBeneficioIndividual.setEnabled(true);
        jDataBeneficio.setEnabled(true);
        //
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void ExcluirInterno() {
        jBtNovoInterno.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarInterno() {
        jBtNovoInterno.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarInterno() {
        limparCamposInterno();
        bloquearBotoes(!true);
        bloquearCampos(!true);
        jBtNovoInterno.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void mostrarTodos() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaSaidaSimbolica.getModel();
        try {
            for (SaidaSimbolica dd : control.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegSaida(), pDATA_Registros, dd.getStatusRegistro(), dd.getTipoBeneficio()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaSaidaSimbolica.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaSaidaSimbolica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaSaidaSimbolica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaSaidaSimbolica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarRegistroCodigo() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaSaidaSimbolica.getModel();
        try {
            for (SaidaSimbolica dd : listaCodigo.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegSaida(), pDATA_Registros, dd.getStatusRegistro(), dd.getTipoBeneficio()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaSaidaSimbolica.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaSaidaSimbolica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaSaidaSimbolica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaSaidaSimbolica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostraPesquisaData() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaSaidaSimbolica.getModel();
        try {
            for (SaidaSimbolica dd : listaData.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegSaida(), pDATA_Registros, dd.getStatusRegistro(), dd.getTipoBeneficio()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaSaidaSimbolica.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaSaidaSimbolica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaSaidaSimbolica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaSaidaSimbolica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pPREENCHER_TABELA_Internos() {
        // APAGAR DADOS DA TABELA
        while (jTabelaInternos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
        }
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
        try {
            for (SaidaSimbolica dd : LISTAR_internos.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistroSA());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdInternoCrc(), dd.getNomeInternoCrc(), dd.getNrdocumentoSA(), dd.getTipoBeneficioSA(), pDATA_Registros});
                jtotaInternosSelecionados.setText(Integer.toString(pTOTAL_registros));
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pPREENCHER_TABELA_REG_Internos() {
        // APAGAR DADOS DA TABELA
        while (jTabelaInternos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
        }
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
        try {
            for (SaidaSimbolica dd : LISTAR_REGISTROS_internos.read()) {
                pDATA_Registros = String.valueOf(dd.getDataRegistroSA());
                String dia = pDATA_Registros.substring(8, 10);
                String mes = pDATA_Registros.substring(5, 7);
                String ano = pDATA_Registros.substring(0, 4);
                pDATA_Registros = dia + "/" + mes + "/" + ano;
                dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdInternoCrc(), dd.getNomeInternoCrc(), dd.getNrdocumentoSA(), dd.getTipoBeneficioSA(), pDATA_Registros});
                jtotaInternosSelecionados.setText(Integer.toString(pTOTAL_registros));
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
