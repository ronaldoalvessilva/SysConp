/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAcessoGeral;
import gestor.Controle.ControleColaborador;
import gestor.Controle.ControleDependentesColaborador;
import gestor.Controle.ControleDocumentosColaborador;
import gestor.Controle.ControleEnderecosColaborador;
import gestor.Controle.ControleEntradaSaidaColaboradores;
import gestor.Controle.ControleListaTransferenciaColaLOCALHOST;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleTransferenciaColaboradorUnidades;
import gestor.Controle.PesquisarColaboradoresEntradasSaidasUni;
import gestor.Controle.PesquisarGravacaoColaboradores;
import gestor.Controle.PesquisarGravacaoColaboradoresCodigo;
import gestor.Controle.PesquisarGravacaoColaboradoresData;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CamposAcessos;
import gestor.Modelo.ColaboradoresTransferenciasUnidades;
import gestor.Modelo.Dependentes;
import gestor.Modelo.Documentos;
import gestor.Modelo.Enderecos;
import gestor.Modelo.EntradasSaidasColaboradores;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAdmPessoal.telaEntradasSaidasColaboradoresCola_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaEntradasSaidasColaboradoresManu_ADM;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaEntradaSaidasColaboradores extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleListaTransferenciaColaLOCALHOST CONTROLE_FINALIZA_func = new ControleListaTransferenciaColaLOCALHOST();
    //
    EntradasSaidasColaboradores objEntraSaiFunc = new EntradasSaidasColaboradores();
    PesquisarGravacaoColaboradores LISTAR_TODOS_registros = new PesquisarGravacaoColaboradores();
    PesquisarGravacaoColaboradoresCodigo LISTA_ENTRADAS_SAIDAS_codigo = new PesquisarGravacaoColaboradoresCodigo();
    PesquisarGravacaoColaboradoresData LISTA_ENTRADAS_SAIDAS_data = new PesquisarGravacaoColaboradoresData();
    ControleEntradaSaidaColaboradores CONTROLE_ENTRADAS_saidas = new ControleEntradaSaidaColaboradores();
    PesquisarColaboradoresEntradasSaidasUni LISTAR_colaboradores = new PesquisarColaboradoresEntradasSaidasUni();
    //
    ColaboradoresTransferenciasUnidades objCola = new ColaboradoresTransferenciasUnidades();
    ControleColaborador control = new ControleColaborador();
    Enderecos objEnd = new Enderecos();
    ControleEnderecosColaborador controle = new ControleEnderecosColaborador();
    Documentos objDoc = new Documentos();
    ControleDocumentosColaborador controleDoc = new ControleDocumentosColaborador();
    Dependentes objDep = new Dependentes();
    ControleDependentesColaborador controlDep = new ControleDependentesColaborador();
    //
    ControleTransferenciaColaboradorUnidades CONTROL_STATUS_func = new ControleTransferenciaColaboradorUnidades();
    //
    ControleAcessoGeral pPESQUISAR_acessos = new ControleAcessoGeral();
    CamposAcessos objCampos = new CamposAcessos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Gerência ADM:Entrada e Saída de Colaboradores:Manutenção";
    String nomeModuloTela1 = "Gerência ADM:Entrada e Saída de Colaboradores:Colaboradores";
    //
    int count = 0;
    int flag = 0;
    public static String dataInicial;
    public static String dataFinal;
    int acao = 0;
    String dataEntrada;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String pDATA_evento = null;
    String pDATA_retorno = null;
    public static int pTOTAL_registros = 0;
    public static int pUNIDADE_origem = 0;
    public static int pUNIDADE_destino = 0;
    public static String pCODIGO_registro = "";
    public static String pCODIGO_colaborador = "";
    //
    public static String pRESPOSTA_opcao = "";
    public static String pID_item;
    public static int pITEM;
    public static String pID_colaborador;
    int pCODIGO_funcionario = 0;

    /**
     * Creates new form TelaEntradaSaidasColaboradores
     */
    public static TelaFinalizarEntradaSaidaColaboradorADM pFINALIZAR_entrada;

    public TelaEntradaSaidasColaboradores() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarFinalizar() {
        pFINALIZAR_entrada = new TelaFinalizarEntradaSaidaColaboradorADM(this, true);
        pFINALIZAR_entrada.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPesqNome = new javax.swing.JTextField();
        jBtPesqNome = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jCodigoPesqFunc = new javax.swing.JTextField();
        jBtPesqCodigoFunc = new javax.swing.JButton();
        jBtPesqDatas = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaFuncionario = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jIdRegistro = new javax.swing.JTextField();
        jStatusRegistro = new javax.swing.JTextField();
        jComboBoxTipoMovimento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxUnidadeOrigem = new javax.swing.JComboBox<>();
        jComboBoxUnidadeDestino = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxOperacao = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jBtNovoColaborador = new javax.swing.JButton();
        jBtAlterarColaborador = new javax.swing.JButton();
        jBtExcluirColaborador = new javax.swing.JButton();
        jBtSalvarColaborador = new javax.swing.JButton();
        jBtCancelarColaborador = new javax.swing.JButton();
        jBtFinalizarColaborador = new javax.swing.JButton();
        jBtSairColaborador = new javax.swing.JButton();
        jBtAuditoriaColaborador = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jIdColaborador = new javax.swing.JTextField();
        jMatriculaColaborador = new javax.swing.JTextField();
        jFuncaoColaborador = new javax.swing.JTextField();
        jNomeColaborador = new javax.swing.JTextField();
        jNomeMaeColaborador = new javax.swing.JTextField();
        jBtPesquisarColaborador = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDataEvento = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jDataRetorno = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jtotaColaboradoresRegistrados = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaColaborador = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jFotoColaborador = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();

        jRadioButton1.setText("jRadioButton1");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Entrada/Saída Colaboradores :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNome.setContentAreaFilled(false);
        jBtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Nome:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Código:");

        jCodigoPesqFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPesqFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigoFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigoFunc.setContentAreaFilled(false);
        jBtPesqCodigoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoFuncActionPerformed(evt);
            }
        });

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Data Inicial:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Data Final:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPesqNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel74)
                                        .addGap(97, 97, 97))
                                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtPesqNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCodigoPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqCodigoFunc)
                    .addComponent(jLabel23)
                    .addComponent(jCodigoPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNome))
                .addGap(5, 5, 5))
        );

        jTabelaFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Operação", "Tipo Movimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaFuncionario);
        if (jTabelaFuncionario.getColumnModel().getColumnCount() > 0) {
            jTabelaFuncionario.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaFuncionario.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaFuncionario.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaFuncionario.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaFuncionario.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaFuncionario.getColumnModel().getColumn(4).setMaxWidth(250);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
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
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(3, 3, 3)
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Movimento");

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jStatusRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusRegistro.setForeground(new java.awt.Color(204, 0, 0));
        jStatusRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusRegistro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusRegistro.setEnabled(false);

        jComboBoxTipoMovimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoMovimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", " ", " " }));
        jComboBoxTipoMovimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoMovimento.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Unidade de Origem");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Unidade de Destino");

        jComboBoxUnidadeOrigem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidadeOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxUnidadeOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidadeOrigem.setEnabled(false);

        jComboBoxUnidadeDestino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidadeDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "localHost" }));
        jComboBoxUnidadeDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidadeDestino.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Motivo");

        jMotivo.setColumns(20);
        jMotivo.setRows(5);
        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);
        jScrollPane1.setViewportView(jMotivo);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Operação");

        jComboBoxOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Entradas", "Saídas", " " }));
        jComboBoxOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOperacao.setEnabled(false);
        jComboBoxOperacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOperacaoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jStatusRegistro)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 197, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addComponent(jComboBoxOperacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxUnidadeDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTipoMovimento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxUnidadeOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxUnidadeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxUnidadeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
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
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
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
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtNovo)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair))
                .addGap(5, 5, 5))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoColaborador.setEnabled(false);
        jBtNovoColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoColaboradorActionPerformed(evt);
            }
        });

        jBtAlterarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarColaborador.setEnabled(false);
        jBtAlterarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarColaboradorActionPerformed(evt);
            }
        });

        jBtExcluirColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirColaborador.setEnabled(false);
        jBtExcluirColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirColaboradorActionPerformed(evt);
            }
        });

        jBtSalvarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarColaborador.setEnabled(false);
        jBtSalvarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarColaboradorActionPerformed(evt);
            }
        });

        jBtCancelarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarColaborador.setEnabled(false);
        jBtCancelarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarColaboradorActionPerformed(evt);
            }
        });

        jBtFinalizarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizarColaborador.setEnabled(false);
        jBtFinalizarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarColaboradorActionPerformed(evt);
            }
        });

        jBtSairColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairColaboradorActionPerformed(evt);
            }
        });

        jBtAuditoriaColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaColaborador.setToolTipText("Auditoria");
        jBtAuditoriaColaborador.setContentAreaFilled(false);
        jBtAuditoriaColaborador.setEnabled(false);
        jBtAuditoriaColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jBtFinalizarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarColaborador, jBtCancelarColaborador, jBtExcluirColaborador, jBtFinalizarColaborador, jBtNovoColaborador, jBtSairColaborador, jBtSalvarColaborador});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoriaColaborador)
                    .addComponent(jBtAlterarColaborador)
                    .addComponent(jBtExcluirColaborador)
                    .addComponent(jBtSalvarColaborador)
                    .addComponent(jBtNovoColaborador)
                    .addComponent(jBtCancelarColaborador)
                    .addComponent(jBtFinalizarColaborador)
                    .addComponent(jBtSairColaborador))
                .addGap(5, 5, 5))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarColaborador, jBtCancelarColaborador, jBtExcluirColaborador, jBtFinalizarColaborador, jBtNovoColaborador, jBtSairColaborador, jBtSalvarColaborador});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Matricula");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Função");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nome do Colaborador");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome da Mãe");

        jIdColaborador.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdColaborador.setEnabled(false);

        jMatriculaColaborador.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaColaborador.setEnabled(false);

        jFuncaoColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFuncaoColaborador.setEnabled(false);

        jNomeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaborador.setEnabled(false);

        jNomeMaeColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeColaborador.setEnabled(false);

        jBtPesquisarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarColaborador.setText("Pesquisa");
        jBtPesquisarColaborador.setToolTipText("Pesquisar Colaborador");
        jBtPesquisarColaborador.setEnabled(false);
        jBtPesquisarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarColaboradorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Evento");

        jDataEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvento.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Retorno");

        jDataRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRetorno.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("Total Itens");

        jtotaColaboradoresRegistrados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotaColaboradoresRegistrados.setForeground(new java.awt.Color(204, 0, 0));
        jtotaColaboradoresRegistrados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtotaColaboradoresRegistrados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtotaColaboradoresRegistrados.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jtotaColaboradoresRegistrados.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeMaeColaborador)
                    .addComponent(jNomeColaborador)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jMatriculaColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jFuncaoColaborador)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtotaColaboradoresRegistrados)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jFuncaoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeMaeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtotaColaboradoresRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarColaborador))
                .addGap(3, 3, 3))
        );

        jTabelaColaborador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Colaborador", "Data Evento", "Data Retorno", "Nome da Mãe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaColaboradorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaColaborador);
        if (jTabelaColaborador.getColumnModel().getColumnCount() > 0) {
            jTabelaColaborador.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaColaborador.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaColaborador.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaColaborador.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaColaborador.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaColaborador.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaColaborador.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaColaborador.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaColaborador.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaColaborador.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaColaborador.getColumnModel().getColumn(5).setMinWidth(250);
            jTabelaColaborador.getColumnModel().getColumn(5).setMaxWidth(250);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Colaborador(es)", jPanel5);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoColaborador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        setBounds(300, 60, 649, 471);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeActionPerformed
        // TODO add your handling code here:
//        count = 0;
//        flag = 1;
//        pesquisarFuncNome("SELECT * FROM COLABORADOR "
//            + "INNER JOIN DEPARTAMENTOS "
//            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
//            + "INNER JOIN CARGOS "
//            + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
//            + "WHERE NomeFunc LIKE'%" + jPesqNome.getText() + "%'");
    }//GEN-LAST:event_jBtPesqNomeActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            // APAGAR DADOS DA TABELA
            while (jTabelaFuncionario.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaFuncionario.getModel()).removeRow(0);
            }
            mostrarTodos();
            if (pTOTAL_registros == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
            }
        } else {
            // APAGAR DADOS DA TABELA
            while (jTabelaFuncionario.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaFuncionario.getModel()).removeRow(0);
            }
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqCodigoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoFuncActionPerformed
        // TODO add your handling code here:
        if (jCodigoPesqFunc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            // APAGAR DADOS DA TABELA
            while (jTabelaFuncionario.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaFuncionario.getModel()).removeRow(0);
            }
            mostrarRegistroCodigo();
            if (pTOTAL_registros == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem exibidos...");
            }
        }
    }//GEN-LAST:event_jBtPesqCodigoFuncActionPerformed

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
                        while (jTabelaFuncionario.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaFuncionario.getModel()).removeRow(0);
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
                        while (jTabelaFuncionario.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaFuncionario.getModel()).removeRow(0);
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

    private void jTabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFuncionarioMouseClicked
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaFuncionario.getValueAt(jTabelaFuncionario.getSelectedRow(), 0);
            jCodigoPesqFunc.setText(IdLanc);
            bloquearBotoes(!true);
            bloquearTodosCampos(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoColaborador.setEnabled(true);
            jBtFinalizarColaborador.setEnabled(true);
            //
            jComboBoxUnidadeOrigem.removeAllItems();
            jComboBoxUnidadeDestino.removeAllItems();
            //
            CONTROLE_ENTRADAS_saidas.MOSTRAR_colaborador(objEntraSaiFunc);
            jIdRegistro.setText(String.valueOf(objEntraSaiFunc.getIdRegistro()));
            jStatusRegistro.setText(objEntraSaiFunc.getStatusRegistro());
            jDataRegistro.setDate(objEntraSaiFunc.getDataRegistro());
            jComboBoxOperacao.setSelectedItem(objEntraSaiFunc.getOperacao());
            jComboBoxTipoMovimento.setSelectedItem(objEntraSaiFunc.getTipoMovimento());
            jComboBoxUnidadeOrigem.addItem(objEntraSaiFunc.getUnidadeOrigem());
            jComboBoxUnidadeDestino.addItem(objEntraSaiFunc.getUnidadeDestino());
            jMotivo.setText(objEntraSaiFunc.getMotivo());
            if (jComboBoxTipoMovimento.getSelectedItem().equals("Admissão")) {
                jLabel6.setText("Data Admissão");
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Entrada por Transferência")) {
                jLabel6.setText("Data Transf.");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Retorno de Férias")) {
                jLabel6.setText("Data Entrada.");
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento")) {
                jLabel6.setText("Data Desli.");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento Voluntário")) {
                jLabel6.setText("Data Des.Vol.");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Saída por Transferência")) {
                jLabel6.setText("Data Transf.");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Óbito")) {
                jLabel6.setText("Data Óbito");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("INSS")) {
                jLabel6.setText("Data INSS");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Férias")) {
                jLabel6.setText("Data Férias");
                jLabel15.setVisible(!true);
                jDataRetorno.setVisible(!true);
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaColaborador.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaColaborador.getModel()).removeRow(0);
            }
            pPREENCHER_TABELA_colaboradores();
        }
    }//GEN-LAST:event_jTabelaFuncionarioMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here: 
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresManu_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresManu_ADM) && objCampos.getCodigoIncluir() == 1) {
            acao = 1;
            limparTodosCampos();
            bloquearBotoes(!true);
            bloquearTodosCampos(!true);
            // APAGAR DADOS DA TABELA
            while (jTabelaColaborador.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaColaborador.getModel()).removeRow(0);
            }
            habilitarCamposManutencao(true);
            Novo(true);
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
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresManu_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresManu_ADM) && objCampos.getCodigoAlterar() == 1) {
            objEntraSaiFunc.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa inventário não poderá ser alterado, o mesmo encontra-se EFETIVADO");
            } else {
                acao = 2;
                bloquearBotoes(!true);
                bloquearTodosCampos(!true);
                habilitarCamposManutencao(true);
                Alterar(true);
                buscarUnidadeOrigemDestino();
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
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresManu_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresManu_ADM) && objCampos.getCodigoExcluir() == 1) {
            objEntraSaiFunc.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                Integer row = jTabelaColaborador.getRowCount();
                if (row != 0) {
                    JOptionPane.showMessageDialog(null, "Não é possível excluir o registro selecionado, exclua primeiro o(s) colaborador(es) associado(s) a esse registro.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {

                        statusMov = "Excluiu";
                        horaMov = jHoraSistema.getText();
                        objEntraSaiFunc.setIdRegistro(Integer.valueOf(jIdRegistro.getText()));
                        CONTROLE_ENTRADAS_saidas.excluirRegistroSaida(objEntraSaiFunc);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação         
                        bloquearBotoes(!true);
                        bloquearTodosCampos(!true);
                        limparTodosCampos();
                        Excluir(true);
                        JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresManu_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresManu_ADM) && objCampos.getCodigoExcluir() == 1) {
            if (jComboBoxOperacao.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da operação.");
            } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de movimento.");
            } else if (jComboBoxUnidadeOrigem.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a unidade penal de origem.");
            } else if (jComboBoxUnidadeDestino.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a unidade penal de destino");
            } else if (jMotivo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe um motivo para operação especificada.");
            } else if (jComboBoxUnidadeOrigem.getSelectedItem().equals(jComboBoxUnidadeDestino.getSelectedItem())
                    && jComboBoxTipoMovimento.getSelectedItem().equals("Saída por Transferência")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível fazer a saída por transferência do colaborador para a mesma unidade.");
            } else {
                objEntraSaiFunc.setStatusRegistro(jStatusRegistro.getText());
                objEntraSaiFunc.setDataRegistro(jDataRegistro.getDate());
                objEntraSaiFunc.setOperacao((String) jComboBoxOperacao.getSelectedItem());
                objEntraSaiFunc.setTipoMovimento((String) jComboBoxTipoMovimento.getSelectedItem());
                objEntraSaiFunc.setUnidadeOrigem((String) jComboBoxUnidadeOrigem.getSelectedItem());
                objEntraSaiFunc.setUnidadeDestino((String) jComboBoxUnidadeDestino.getSelectedItem());
                objEntraSaiFunc.setMotivo(jMotivo.getText());
                if (acao == 1) {
                    objEntraSaiFunc.setUsuarioInsert(nameUser);
                    objEntraSaiFunc.setDataInsert(dataModFinal);
                    objEntraSaiFunc.setHorarioInsert(horaMov);
                    CONTROLE_ENTRADAS_saidas.incluirRegistroSaida(objEntraSaiFunc);
                    BUSCAR_codigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes(!true);
                    bloquearTodosCampos(!true);
                    Salvar(true);
                    if (pRESPOSTA_opcao.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pRESPOSTA_opcao.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
                if (acao == 2) {
                    objEntraSaiFunc.setUsuarioUp(nameUser);
                    objEntraSaiFunc.setDataUp(dataModFinal);
                    objEntraSaiFunc.setHorarioUp(horaMov);
                    objEntraSaiFunc.setIdRegistro(Integer.parseInt(jIdRegistro.getText()));
                    CONTROLE_ENTRADAS_saidas.alterarRegistroSaida(objEntraSaiFunc);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes(!true);
                    bloquearTodosCampos(!true);
                    Salvar(true);
                    if (pRESPOSTA_opcao.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pRESPOSTA_opcao.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar(true);
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaColaborador.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            CONTROLE_ENTRADAS_saidas.PESQUISAR_status(objEntraSaiFunc);
            if (objEntraSaiFunc.getStatusRegistro().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                if (jComboBoxTipoMovimento.getSelectedItem().equals("Admissão")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Ativo");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Entrada por Transferência")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Ativo");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Retorno de Férias")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Ativo");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Desligado");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento Voluntário")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Desligado");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Saída por Transferência")) {
                    pFINALIZAR_REG_colaboradores();
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Óbito")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Óbito");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("INSS")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("INSS");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Férias")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Férias");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaTransferenciaColaboradores objAuditoriaMan = new TelaAuditoriaTransferenciaColaboradores();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAuditoriaMan);
        objAuditoriaMan.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jComboBoxOperacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOperacaoItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxOperacao.getSelectedItem().equals("Entradas")) {
            jComboBoxTipoMovimento.removeAllItems();
            jComboBoxTipoMovimento.addItem("Admissão");
            jComboBoxTipoMovimento.addItem("Entrada por Transferência");
            jComboBoxTipoMovimento.addItem("Retorno de Férias");
        } else if (jComboBoxOperacao.getSelectedItem().equals("Saídas")) {
            jComboBoxTipoMovimento.removeAllItems();
            jComboBoxTipoMovimento.addItem("Desligamento");
            jComboBoxTipoMovimento.addItem("Desligamento Voluntário");
            jComboBoxTipoMovimento.addItem("Saída por Transferência");
            jComboBoxTipoMovimento.addItem("Óbito");
            jComboBoxTipoMovimento.addItem("INSS");
            jComboBoxTipoMovimento.addItem("Férias");
        }
        buscarUnidadeOrigemDestino();
    }//GEN-LAST:event_jComboBoxOperacaoItemStateChanged

    private void jBtNovoColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoColaboradorActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresCola_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresCola_ADM) && objCampos.getCodigoIncluir() == 1) {
            objEntraSaiFunc.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa inventário não poderá ser alterado, o mesmo encontra-se EFETIVADO");
            } else {
                acao = 3;
                limparCamposColaborador();
                bloquearBotoes(!true);
                bloquearTodosCampos(!true);
                NovoColaborador(true);
                habilitarCamposColaborador(true);
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoColaboradorActionPerformed

    private void jBtAlterarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarColaboradorActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresCola_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresCola_ADM) && objCampos.getCodigoAlterar() == 1) {
            objEntraSaiFunc.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa inventário não poderá ser alterado, o mesmo encontra-se EFETIVADO");
            } else {
                acao = 4;
                bloquearBotoes(!true);
                bloquearTodosCampos(!true);
                AlterarColaborador(true);
                habilitarCamposColaborador(true);
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarColaboradorActionPerformed

    private void jBtExcluirColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirColaboradorActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresCola_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresCola_ADM) && objCampos.getCodigoExcluir() == 1) {
            objEntraSaiFunc.setStatusRegistro(jStatusRegistro.getText());
            if (jStatusRegistro.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa inventário não poderá ser alterado, o mesmo encontra-se EFETIVADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearBotoes(!true);
                    bloquearTodosCampos(!true);
                    limparCamposColaborador();
                    ExcluirColaborador(true);
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    objEntraSaiFunc.setIdItem(Integer.valueOf(pID_item));
                    CONTROLE_ENTRADAS_saidas.excluirItensRegistroSaida(objEntraSaiFunc);
                    //
                    if (pRESPOSTA_opcao.equals("Sim")) {
                        // APAGAR DADOS DA TABELA
                        while (jTabelaColaborador.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaColaborador.getModel()).removeRow(0);
                        }
                        pPREENCHER_TABELA_colaboradores();
                        JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                    } else if (pRESPOSTA_opcao.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirColaboradorActionPerformed

    private void jBtSalvarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarColaboradorActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEntradasSaidasColaboradoresCola_ADM);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEntradasSaidasColaboradoresCola_ADM) && objCampos.getCodigoGravar() == 1) {
            if (jIdColaborador.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do colaborador.");
            } else if (jNomeColaborador.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do colaborador.");
            } else if (jDataEvento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do evento.");
            } else {
                objEntraSaiFunc.setIdRegistro(Integer.valueOf(jIdRegistro.getText()));
                objEntraSaiFunc.setIdColaborador(Integer.valueOf(jIdColaborador.getText()));
                objEntraSaiFunc.setNomeColaborador(jNomeColaborador.getText());
                objEntraSaiFunc.setDataEvento(jDataEvento.getDate());
                objEntraSaiFunc.setDataRetorno(jDataRetorno.getDate());
                if (acao == 3) {
                    objEntraSaiFunc.setUsuarioInsert(nameUser);
                    objEntraSaiFunc.setDataInsert(dataModFinal);
                    objEntraSaiFunc.setHorarioInsert(horaMov);
                    CONTROLE_ENTRADAS_saidas.incluirItensRegistroSaida(objEntraSaiFunc);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes(!true);
                    bloquearTodosCampos(!true);
                    limparCamposColaborador();
                    SalvarColaborador(true);
                    if (pRESPOSTA_opcao.equals("Sim")) {
                        // APAGAR DADOS DA TABELA
                        while (jTabelaColaborador.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaColaborador.getModel()).removeRow(0);
                        }
                        pPREENCHER_TABELA_colaboradores();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pRESPOSTA_opcao.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
                if (acao == 4) {
                    objEntraSaiFunc.setUsuarioUp(nameUser);
                    objEntraSaiFunc.setDataUp(dataModFinal);
                    objEntraSaiFunc.setHorarioUp(horaMov);
                    objEntraSaiFunc.setIdItem(Integer.valueOf(pID_item));
                    CONTROLE_ENTRADAS_saidas.alterarItensRegistroSaida(objEntraSaiFunc);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação

                    bloquearBotoes(!true);
                    bloquearTodosCampos(!true);
                    limparCamposColaborador();
                    SalvarColaborador(true);
                    if (pRESPOSTA_opcao.equals("Sim")) {
                        // APAGAR DADOS DA TABELA
                        while (jTabelaColaborador.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaColaborador.getModel()).removeRow(0);
                        }
                        pPREENCHER_TABELA_colaboradores();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pRESPOSTA_opcao.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarColaboradorActionPerformed

    private void jBtCancelarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarColaboradorActionPerformed
        // TODO add your handling code here:
        CancelarColaborador(true);
    }//GEN-LAST:event_jBtCancelarColaboradorActionPerformed

    private void jBtFinalizarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarColaboradorActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaColaborador.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            CONTROLE_ENTRADAS_saidas.PESQUISAR_status(objEntraSaiFunc);
            if (objEntraSaiFunc.getStatusRegistro().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                if (jComboBoxTipoMovimento.getSelectedItem().equals("Admissão")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Ativo");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Entrada por Transferência")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Ativo");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Retorno de Férias")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Ativo");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Desligado");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento Voluntário")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Desligado");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Saída por Transferência")) {
                    pFINALIZAR_REG_colaboradores();
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Óbito")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Óbito");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("INSS")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("INSS");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Férias")) {
                    for (int i = 0; i < jTabelaColaborador.getRowCount(); i++) {
                        pCODIGO_funcionario = (int) jTabelaColaborador.getValueAt(i, 1);
                        objCola.setIdFunc(pCODIGO_funcionario);
                        objCola.setStatusFunc("Férias");
                        CONTROLE_FINALIZA_func.FINALIZAR_ColaboradorLOCALHOST(objCola);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        }
    }//GEN-LAST:event_jBtFinalizarColaboradorActionPerformed

    private void jBtSairColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairColaboradorActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairColaboradorActionPerformed

    private void jBtAuditoriaColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaColaboradorActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaTransferenciaColaboradores_FUNC objAuditoriaCola = new TelaAuditoriaTransferenciaColaboradores_FUNC();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAuditoriaCola);
        objAuditoriaCola.show();
    }//GEN-LAST:event_jBtAuditoriaColaboradorActionPerformed

    private void jTabelaColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaColaboradorMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            pID_item = "" + jTabelaColaborador.getValueAt(jTabelaColaborador.getSelectedRow(), 0);
            //
            pID_colaborador = "" + jTabelaColaborador.getValueAt(jTabelaColaborador.getSelectedRow(), 1);
            jIdColaborador.setText(pID_colaborador);
            bloquearBotoes(!true);
            bloquearTodosCampos(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoColaborador.setEnabled(true);
            jBtAlterarColaborador.setEnabled(true);
            jBtExcluirColaborador.setEnabled(true);
            jBtCancelarColaborador.setEnabled(true);
            LISTAR_colaboradores.MOSTRAR_ENTRADA_SAIDA_colaboradores(objEntraSaiFunc);
            jIdColaborador.setText(String.valueOf(objEntraSaiFunc.getIdColaborador()));
            jMatriculaColaborador.setText(objEntraSaiFunc.getMatricula());
            jFuncaoColaborador.setText(objEntraSaiFunc.getFuncao());
            jNomeColaborador.setText(objEntraSaiFunc.getNomeColaborador());
            jNomeMaeColaborador.setText(objEntraSaiFunc.getNomeMaeColaborador());
            jDataEvento.setDate(objEntraSaiFunc.getDataEvento());
            jDataRetorno.setDate(objEntraSaiFunc.getDataRetorno());
        }
    }//GEN-LAST:event_jTabelaColaboradorMouseClicked

    private void jBtPesquisarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarColaboradorActionPerformed
        // TODO add your handling code here:
        TelaPesquisaColaboradorEntradaSaida objPesquisaFunc = new TelaPesquisaColaboradorEntradaSaida();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPesquisaFunc);
        objPesquisaFunc.show();
    }//GEN-LAST:event_jBtPesquisarColaboradorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarColaborador;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaColaborador;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarColaborador;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirColaborador;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtFinalizarColaborador;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoColaborador;
    private javax.swing.JButton jBtPesqCodigoFunc;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqNome;
    private javax.swing.JButton jBtPesquisarColaborador;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairColaborador;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarColaborador;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCodigoPesqFunc;
    private javax.swing.JComboBox<String> jComboBoxOperacao;
    private javax.swing.JComboBox<String> jComboBoxTipoMovimento;
    public static javax.swing.JComboBox<String> jComboBoxUnidadeDestino;
    public static javax.swing.JComboBox<String> jComboBoxUnidadeOrigem;
    private com.toedter.calendar.JDateChooser jDataEvento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    private com.toedter.calendar.JDateChooser jDataRetorno;
    public static javax.swing.JLabel jFotoColaborador;
    public static javax.swing.JTextField jFuncaoColaborador;
    public static javax.swing.JTextField jIdColaborador;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaColaborador;
    private javax.swing.JTextArea jMotivo;
    public static javax.swing.JTextField jNomeColaborador;
    public static javax.swing.JTextField jNomeMaeColaborador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextField jStatusRegistro;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaColaborador;
    private javax.swing.JTable jTabelaFuncionario;
    private javax.swing.JTextField jtotaColaboradoresRegistrados;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jMotivo.setLineWrap(true);
        jMotivo.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdRegistro.setBackground(Color.WHITE);
        jStatusRegistro.setBackground(Color.WHITE);
        jDataRegistro.setBackground(Color.WHITE);
        jComboBoxOperacao.setBackground(Color.WHITE);
        jComboBoxTipoMovimento.setBackground(Color.WHITE);
        jComboBoxUnidadeOrigem.setBackground(Color.WHITE);
        jComboBoxUnidadeDestino.setBackground(Color.WHITE);
        jMotivo.setBackground(Color.WHITE);
        //
        jIdColaborador.setBackground(Color.WHITE);
        jMatriculaColaborador.setBackground(Color.WHITE);
        jFuncaoColaborador.setBackground(Color.WHITE);
        jNomeColaborador.setBackground(Color.WHITE);
        jNomeMaeColaborador.setBackground(Color.WHITE);
        jDataEvento.setBackground(Color.WHITE);
        jDataRetorno.setBackground(Color.WHITE);
        jtotaColaboradoresRegistrados.setBackground(Color.WHITE);
    }

    public void limparTodosCampos() {
        jIdRegistro.setText("");
        jStatusRegistro.setText("");
        jDataRegistro.setDate(null);
        jComboBoxOperacao.setSelectedItem("Selecione...");
        jComboBoxTipoMovimento.setSelectedItem("Selecione...");
        jComboBoxUnidadeOrigem.setSelectedItem("Selecione...");
        jComboBoxUnidadeDestino.setSelectedItem("Selecione...");
        jMotivo.setText("");

        jIdColaborador.setText("");
        jMatriculaColaborador.setText("");
        jFuncaoColaborador.setText("");
        jNomeColaborador.setText("");
        jNomeMaeColaborador.setText("");
        jDataEvento.setDate(null);
        jDataRetorno.setDate(null);
        jFotoColaborador.setIcon(null);
    }

    public void limparCamposColaborador() {
        jIdColaborador.setText("");
        jMatriculaColaborador.setText("");
        jFuncaoColaborador.setText("");
        jNomeColaborador.setText("");
        jNomeMaeColaborador.setText("");
        jDataEvento.setDate(null);
        jDataRetorno.setDate(null);
        jFotoColaborador.setIcon(null);
    }

    public void bloquearTodosCampos(boolean opcao) {
        jIdRegistro.setEnabled(opcao);
        jStatusRegistro.setEnabled(opcao);
        jDataRegistro.setEnabled(opcao);
        jComboBoxOperacao.setEnabled(opcao);
        jComboBoxTipoMovimento.setEnabled(opcao);
        jComboBoxUnidadeOrigem.setEnabled(opcao);
        jComboBoxUnidadeDestino.setEnabled(opcao);
        jMotivo.setEnabled(opcao);
        //
        jIdColaborador.setEnabled(opcao);
        jMatriculaColaborador.setEnabled(opcao);
        jFuncaoColaborador.setEnabled(opcao);
        jNomeColaborador.setEnabled(opcao);
        jNomeMaeColaborador.setEnabled(opcao);
        jDataEvento.setEnabled(opcao);
        jDataRetorno.setEnabled(opcao);
    }

    public void bloquearCamposColaborador(boolean opcao) {
        jIdColaborador.setEnabled(opcao);
        jMatriculaColaborador.setEnabled(opcao);
        jFuncaoColaborador.setEnabled(opcao);
        jNomeColaborador.setEnabled(opcao);
        jNomeMaeColaborador.setEnabled(opcao);
        jDataEvento.setEnabled(opcao);
        jDataRetorno.setEnabled(opcao);
    }

    public void bloquearCamposManutencao(boolean opcao) {
        jComboBoxOperacao.setEnabled(opcao);
        jComboBoxTipoMovimento.setEnabled(opcao);
        jComboBoxUnidadeOrigem.setEnabled(opcao);
        jComboBoxUnidadeDestino.setEnabled(opcao);
        jMotivo.setEnabled(opcao);
    }

    public void habilitarCamposManutencao(boolean opcao) {
        jComboBoxOperacao.setEnabled(opcao);
        jComboBoxTipoMovimento.setEnabled(opcao);
        jComboBoxUnidadeOrigem.setEnabled(opcao);
        jComboBoxUnidadeDestino.setEnabled(opcao);
        jMotivo.setEnabled(opcao);
    }

    public void habilitarCamposColaborador(boolean opcao) {
        jDataEvento.setEnabled(opcao);
        jDataRetorno.setEnabled(opcao);
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
        jBtNovoColaborador.setEnabled(opcao);
        jBtAlterarColaborador.setEnabled(opcao);
        jBtExcluirColaborador.setEnabled(opcao);
        jBtSalvarColaborador.setEnabled(opcao);
        jBtCancelarColaborador.setEnabled(opcao);
        jBtFinalizarColaborador.setEnabled(opcao);
        jBtAuditoriaColaborador.setEnabled(opcao);
        jBtPesquisarColaborador.setEnabled(opcao);
    }

    public void Novo(boolean opcao) {
        jStatusRegistro.setText("ABERTO");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
    }

    public void Alterar(boolean opcao) {
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
    }

    public void Excluir(boolean opcao) {
        jBtNovo.setEnabled(opcao);
    }

    public void Salvar(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        //
        jBtNovoColaborador.setEnabled(opcao);
    }

    public void Cancelar(boolean opcao) {
        if (jIdRegistro.getText().equals("")) {
            bloquearTodosCampos(!true);
            bloquearBotoes(!true);
            jBtNovo.setEnabled(opcao);
        } else {
            bloquearTodosCampos(true);
            bloquearBotoes(!true);
            jBtNovo.setEnabled(opcao);
            jBtAlterar.setEnabled(opcao);
            jBtExcluir.setEnabled(opcao);
            jBtFinalizar.setEnabled(opcao);
            jBtAuditoria.setEnabled(opcao);
        }
    }

    public void BUSCAR_codigo() {
        CONTROLE_ENTRADAS_saidas.PESQUISAR_codigo(objEntraSaiFunc);
    }

    public void buscarUnidadeOrigemDestino() {
        CONTROLE_ENTRADAS_saidas.PESQUISAR_unidades(objEntraSaiFunc);
    }

    public void NovoColaborador(boolean opcao) {
        if (jComboBoxTipoMovimento.getSelectedItem().equals("Admissão")) {
            jLabel6.setText("Data Admissão");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Entrada por Transferência")) {
            jLabel6.setText("Data Transf.");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Retorno de Férias")) {
            jLabel6.setText("Data Entrada.");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento")) {
            jLabel6.setText("Data Desli.");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Desligamento Voluntário")) {
            jLabel6.setText("Data Des.Vol.");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Saída por Transferência")) {
            jLabel6.setText("Data Transf.");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Óbito")) {
            jLabel6.setText("Data Óbito");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("INSS")) {
            jLabel6.setText("Data INSS");
        } else if (jComboBoxTipoMovimento.getSelectedItem().equals("Férias")) {
            jLabel6.setText("Data Férias");
        }
        jBtSalvarColaborador.setEnabled(opcao);
        jBtCancelarColaborador.setEnabled(opcao);
        jBtPesquisarColaborador.setEnabled(opcao);
    }

    public void AlterarColaborador(boolean opcao) {
        jBtSalvarColaborador.setEnabled(opcao);
        jBtCancelarColaborador.setEnabled(opcao);
    }

    public void ExcluirColaborador(boolean opcao) {
        jBtNovoColaborador.setEnabled(opcao);
    }

    public void SalvarColaborador(boolean opcao) {
        jBtNovoColaborador.setEnabled(opcao);
        //
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
    }

    public void CancelarColaborador(boolean opcao) {
        limparCamposColaborador();
        jBtNovoColaborador.setEnabled(opcao);
        //
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
    }

    public void mostrarTodos() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaFuncionario.getModel();
        try {
            for (EntradasSaidasColaboradores dd : LISTAR_TODOS_registros.read()) {
                pDATA_evento = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_evento.substring(8, 10);
                String mes = pDATA_evento.substring(5, 7);
                String ano = pDATA_evento.substring(0, 4);
                pDATA_evento = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), pDATA_evento, dd.getStatusRegistro(), dd.getOperacao(), dd.getTipoMovimento()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaFuncionario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaFuncionario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaFuncionario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarRegistroCodigo() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaFuncionario.getModel();
        try {
            for (EntradasSaidasColaboradores dd : LISTA_ENTRADAS_SAIDAS_codigo.read()) {
                pDATA_evento = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_evento.substring(8, 10);
                String mes = pDATA_evento.substring(5, 7);
                String ano = pDATA_evento.substring(0, 4);
                pDATA_evento = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), pDATA_evento, dd.getStatusRegistro(), dd.getOperacao(), dd.getTipoMovimento()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaFuncionario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaFuncionario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaFuncionario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostraPesquisaData() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaFuncionario.getModel();
        try {
            for (EntradasSaidasColaboradores dd : LISTA_ENTRADAS_SAIDAS_data.read()) {
                pDATA_evento = String.valueOf(dd.getDataRegistro());
                String dia = pDATA_evento.substring(8, 10);
                String mes = pDATA_evento.substring(5, 7);
                String ano = pDATA_evento.substring(0, 4);
                pDATA_evento = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(pTOTAL_registros));
                dadosOrigem.addRow(new Object[]{dd.getIdRegistro(), pDATA_evento, dd.getStatusRegistro(), dd.getOperacao(), dd.getTipoMovimento()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaFuncionario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaFuncionario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaFuncionario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pPREENCHER_TABELA_colaboradores() {
        // APAGAR DADOS DA TABELA
        while (jTabelaColaborador.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaColaborador.getModel()).removeRow(0);
        }
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaColaborador.getModel();
        try {
            for (EntradasSaidasColaboradores dd : LISTAR_colaboradores.read()) {
                pDATA_evento = String.valueOf(dd.getDataEvento());
                if (pDATA_evento != null) {
                    String dia = pDATA_evento.substring(8, 10);
                    String mes = pDATA_evento.substring(5, 7);
                    String ano = pDATA_evento.substring(0, 4);
                    pDATA_evento = dia + "/" + mes + "/" + ano;
                }
                //                
                pDATA_retorno = String.valueOf(dd.getDataRetorno());
                if (pDATA_retorno == null) {
                    pDATA_retorno = "Sem Retorno";
                    dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdColaborador(), dd.getNomeColaborador(), pDATA_evento, pDATA_retorno, dd.getNomeMaeColaborador()});
                    jtotaColaboradoresRegistrados.setText(Integer.toString(pTOTAL_registros));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaColaborador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaColaborador.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                } else if (pDATA_retorno.equals("")) {
                    pDATA_retorno = "Sem Retorno";
                    dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdColaborador(), dd.getNomeColaborador(), pDATA_evento, pDATA_retorno, dd.getNomeMaeColaborador()});
                    jtotaColaboradoresRegistrados.setText(Integer.toString(pTOTAL_registros));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaColaborador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaColaborador.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                } else if (pDATA_retorno.equals(null)) {
                    pDATA_retorno = "Sem Retorno";
                    dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdColaborador(), dd.getNomeColaborador(), pDATA_evento, pDATA_retorno, dd.getNomeMaeColaborador()});
                    jtotaColaboradoresRegistrados.setText(Integer.toString(pTOTAL_registros));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaColaborador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaColaborador.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                } else if (pDATA_retorno.equals("null")) {
                    pDATA_retorno = "Sem Retorno";
                    dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdColaborador(), dd.getNomeColaborador(), pDATA_evento, pDATA_retorno, dd.getNomeMaeColaborador()});
                    jtotaColaboradoresRegistrados.setText(Integer.toString(pTOTAL_registros));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaColaborador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaColaborador.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                } else if (!pDATA_retorno.equals("") && !pDATA_retorno.equals(null)) {
                    String diaR = pDATA_retorno.substring(8, 10);
                    String mesR = pDATA_retorno.substring(5, 7);
                    String anoR = pDATA_retorno.substring(0, 4);
                    pDATA_retorno = diaR + "/" + mesR + "/" + anoR;
                    dadosOrigem.addRow(new Object[]{dd.getIdItem(), dd.getIdColaborador(), dd.getNomeColaborador(), pDATA_evento, pDATA_retorno, dd.getNomeMaeColaborador()});
                    jtotaColaboradoresRegistrados.setText(Integer.toString(pTOTAL_registros));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaColaborador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaColaborador.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                    jTabelaColaborador.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pFINALIZAR_REG_colaboradores() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            mostrarFinalizar();
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
