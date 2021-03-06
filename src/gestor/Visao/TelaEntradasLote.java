/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleDadosPenais;
import gestor.Controle.ControleEntradaLote;
import gestor.Controle.ControleItensEntradaNova;
import gestor.Controle.ControleItensEntradasLote;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleNovaEntradaInternos;
import gestor.Controle.ControleNovaEntradaLoteCRC;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControlePreLocacaoInternos;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.EntradaLote;
import gestor.Modelo.ItensEntradaLote;
import gestor.Modelo.ItensNovaEntrada;
import gestor.Modelo.ItensPreLocacao;
import gestor.Modelo.LogSistema;
import gestor.Modelo.MovimentoCrc;
import gestor.Modelo.Operacao;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RolVisitas;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloCRC.codAbrirCRC;
import static gestor.Visao.TelaModuloCRC.codIncluirCRC;
import static gestor.Visao.TelaModuloCRC.codUserAcessoCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserGroupCRC;
import static gestor.Visao.TelaModuloCRC.codigoGrupoCRC;
import static gestor.Visao.TelaModuloCRC.codAlterarCRC;
import static gestor.Visao.TelaModuloCRC.codExcluirCRC;
import static gestor.Visao.TelaModuloCRC.codGravarCRC;
import static gestor.Visao.TelaModuloCRC.codConsultarCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserCRC;
import static gestor.Visao.TelaModuloCRC.nomeGrupoCRC;
import static gestor.Visao.TelaModuloCRC.nomeTelaCRC;
import static gestor.Visao.TelaModuloCRC.telaEntradaIntIntCRC;
import static gestor.Visao.TelaModuloCRC.telaEntradaIntManuCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloTriagem.codigoUserGroupTRI;
import static gestor.Visao.TelaModuloTriagem.codigoGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.codAbrirTRI;
import static gestor.Visao.TelaModuloTriagem.codGravarTRI;
import static gestor.Visao.TelaModuloTriagem.codConcultarTRI;
import static gestor.Visao.TelaModuloTriagem.codAlterarTRI;
import static gestor.Visao.TelaModuloTriagem.codExcluirTRI;
import static gestor.Visao.TelaModuloTriagem.codIncluirTRI;
import static gestor.Visao.TelaModuloTriagem.codUserAcessoTRI;
import static gestor.Visao.TelaModuloTriagem.codigoUserTRI;
import static gestor.Visao.TelaModuloTriagem.nomeGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.nomeTelaTRI;
import static gestor.Visao.TelaModuloTriagem.telaEntredaInternosManuTRI;
import java.awt.Color;
import java.awt.HeadlessException;
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
 * @author Ronaldo
 */
public class TelaEntradasLote extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaLote objEntLote = new EntradaLote();
    ItensEntradaLote objItens = new ItensEntradaLote();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    ControleEntradaLote control = new ControleEntradaLote();
    ControleItensEntradasLote controle = new ControleItensEntradasLote();
    ControleDadosPenais controlInterno = new ControleDadosPenais();
    ControleSituacao mod = new ControleSituacao();
    Operacao objOp = new Operacao();
    ControleMovInternos controlMov = new ControleMovInternos();
    MovimentoCrc movCrc = new MovimentoCrc();
    //
    ControleItensEntradaNova controlPort = new ControleItensEntradaNova(); // Quando interno vem pelo registro de nova entrada na portaria
    ItensNovaEntrada objItensNova = new ItensNovaEntrada();
    // ADICIONAR A NOVA DATA DE ENTRADA DO INTERNO - 11/07/2016    
    ControleNovaEntradaInternos controleNovaData = new ControleNovaEntradaInternos();
    // GRAVA A UTILIZAÇÃO OU NÃO PELA TRIAGEM DO INTERNO NA PRÉ-LOCAÇÃO, SOMENTE NA TRIAGEM. (27/06/2018) - ITABUNA
    ItensPreLocacao objItensPreLocacao = new ItensPreLocacao();
    ControlePreLocacaoInternos controlePre = new ControlePreLocacaoInternos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    ControleRolVisitas controlRol = new ControleRolVisitas(); // Classe do Serviço social para FINALIZAR Rol quando interno sair da unidade
    RolVisitas objRol = new RolVisitas();
    // HISTÓRICO DOS DADOS PENAIS DOS INTERNOS.
    ControleNovaEntradaLoteCRC controleHistDP = new ControleNovaEntradaLoteCRC();
    //PORTA DE ENTRADA
    PortaEntrada objPortaEntrada = new PortaEntrada();
    ControlePortaEntrada control_PE = new ControlePortaEntrada();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Entrada de Internos:Manutenção";
    String nomeModuloTela2 = "CRC:Entrada de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int flagItem;
    int codItemEnt = 0; // buscar o id do item para alterar na movimentação
    public int codEnt;
    int codItem; // Buscar o código do item (ITENSENTRADALOTE)
    public static String idItem;
    String dataBrasil;
    String tipo = "Entradas"; // Tipo de operação (ENTRADA)
    String situacao = "ENTRADA NA UNIDADE"; // Máximo 19 caracteres    
    String codEntrada;
    String dataInicial;
    String dataFinal;
    String statusEntrada = "ABERTO";
    String caminho;
    int coditem; // Código do iem para exclusao
    String utilizacaoCrc = "Sim"; // Utilizado para pesquisar o registro na tabela ITENSNOVAENTRADA
    String excluirUtilizacao = "Não"; // utilizado para excluir registro na ENTRADA DO CRC ITENSENTRADA e modificar a TABELA ITENSNOVAENTRADA
    int count = 0;
    String statusRol = "ABERTO"; // Se o Rol estiver ABERTO, irá ser FINALIZADO para não ser mostrado na lista do Rol na portaria
    int idInternoRol; // Código do interno no Rol de Visitas.
    String statusRolFechado = "FINALIZADO"; // Se o Rol estiver fechado e o usuário excluir, o Rol volta a ser ABERTO
    // AFIRMAÇÃO DE QUE O INTERNO NÃO FOI AINDA UTILIZADO NA PRÉ-LOCAÇÃO DA TRIAGEM.
    String confirmaPreLocacao = "Não";
    String origemTriagem = "";
    //
    String pagtoKit = "Não";
    //PARA PESQUISA DOS INTERNOS NAS ADMISSÕES DO PSP
    String pID_INTERNO_MEDICO = "";
    String pID_INTERNO_ENFERMEIRA = "";
    String pID_INTERNO_JURIDICO = "";
    String pID_INTERNO_PEDAGOGIA = "";
    String pID_INTERNO_PSICOLOGIA = "";
    String pID_INTERNO_SERVICO = "";
    String pID_INTERNO_ODONTOLOGIA = "";
    String pID_INTERNO_TERAPIA = "";
    String pID_INTERNO_EDUCACAO = "";
    //
    String pCODIGO_INTERNO_PE = "";
    //NOME DOS SETORES DO PSP PARA IMPLEMENTAR ADMISSÃO ADICIONAL
    String pPSP_POSTO_MEDICO = "ENFERMARIA";
    String pPSP_JURIDICO = "JURIDICO";
    String pPSP_PEDAGOGIA = "PEDAGOGIA";
    String pPSP_PSICOLOGIA = "PSICOLOGIA";
    String pPSP_SERVICO = "SERVICO SOCIAL";
    String pPSP_ODONTOLOGIA = "ODONTOLOGIA";
    String pPSP_TERAPIA = "TERAPIA OCUPACIONAL";
    String pPSP_EDUCACAO_FISICA = "EDUCACAO FISICA";
    //
    String pOPCAO_CONFIRMAR = "Sim";
    String pOPCAO_NEGAR = "Não";

    /**
     * Creates new form TelaEntradaLote
     */
    public TelaEntradasLote() {
        initComponents();
        formatarCampos();
        corCampo();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jIDPesqLan = new javax.swing.JTextField();
        jBtDataLanc = new javax.swing.JButton();
        jBtIdLanc = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtNomeInterno = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaLanLote = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIDLanc = new javax.swing.JTextField();
        jBtPesqOperacao = new javax.swing.JButton();
        jDataLancamento = new com.toedter.calendar.JDateChooser();
        jDescricaoOp = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jStatusEntrada = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jIDInterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxUnidPenal = new javax.swing.JComboBox();
        jBtPesInterno = new javax.swing.JButton();
        jBtPesqUnidade = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxRegime = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDataCrime = new com.toedter.calendar.JDateChooser();
        jDataPrisao = new com.toedter.calendar.JDateChooser();
        jPena = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDataCondenacao = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jArtigo1 = new javax.swing.JTextField();
        jArtigo2 = new javax.swing.JTextField();
        jArtigo3 = new javax.swing.JTextField();
        jParagrafo1 = new javax.swing.JTextField();
        jParagrafo2 = new javax.swing.JTextField();
        jParagrafo3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jDataTerminoPena = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaItensIterno = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtSairItens = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        FotoInternoCrc = new javax.swing.JLabel();
        jBtNovolanc = new javax.swing.JButton();
        jBtAlterarlanc = new javax.swing.JButton();
        jBtExcluirlanc = new javax.swing.JButton();
        jBtSalvarlanc = new javax.swing.JButton();
        jBtCancelarlanc = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoriaManu = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jBtAudiItensEntrada = new javax.swing.JButton();
        jBtBuscarIntPortaria = new javax.swing.JButton();
        jBtPesquisarInterno = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Entrada Internos na Unidade :::...");
        setToolTipText("");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código:");

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDataLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLanc.setContentAreaFilled(false);
        jBtDataLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLancActionPerformed(evt);
            }
        });

        jBtIdLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdLanc.setContentAreaFilled(false);
        jBtIdLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdLancActionPerformed(evt);
            }
        });

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data Final:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomeInterno.setContentAreaFilled(false);
        jBtNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeInternoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome do Interno:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtDataLanc)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataPesFinal, jDataPesqInicial, jIDPesqLan});

        jTabelaLanLote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaLanLote.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaLanLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"
            }
        ));
        jTabelaLanLote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaLanLoteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaLanLote);
        if (jTabelaLanLote.getColumnModel().getColumnCount() > 0) {
            jTabelaLanLote.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaLanLote.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaLanLote.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaLanLote.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaLanLote.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaLanLote.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaLanLote.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaLanLote.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaLanLote.getColumnModel().getColumn(4).setMinWidth(180);
            jTabelaLanLote.getColumnModel().getColumn(4).setMaxWidth(180);
            jTabelaLanLote.getColumnModel().getColumn(5).setMinWidth(280);
            jTabelaLanLote.getColumnModel().getColumn(5).setMaxWidth(280);
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
            .addGap(0, 521, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Lançamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Dt. Documento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Descrição da Operação");

        jIDLanc.setBackground(new java.awt.Color(240, 240, 240));
        jIDLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDLanc.setEnabled(false);

        jBtPesqOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqOperacao.setContentAreaFilled(false);
        jBtPesqOperacao.setEnabled(false);
        jBtPesqOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqOperacaoActionPerformed(evt);
            }
        });

        jDataLancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLancamento.setEnabled(false);

        jDescricaoOp.setBackground(new java.awt.Color(240, 240, 240));
        jDescricaoOp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoOp.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Status");

        jStatusEntrada.setBackground(new java.awt.Color(240, 240, 240));
        jStatusEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusEntrada.setForeground(new java.awt.Color(255, 0, 0));
        jStatusEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusEntrada.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDescricaoOp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jStatusEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescricaoOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaObs.setRows(5);
        jTextAreaObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextAreaObs.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código:");

        jIDInterno.setBackground(new java.awt.Color(240, 240, 240));
        jIDInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInterno.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome:");

        jNomeInterno.setBackground(new java.awt.Color(240, 240, 240));
        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);
        jNomeInterno.setPreferredSize(new java.awt.Dimension(3, 18));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Origem:");

        jComboBoxUnidPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidPenal.setEnabled(false);

        jBtPesInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesInterno.setToolTipText("Pesquisar Interno");
        jBtPesInterno.setContentAreaFilled(false);
        jBtPesInterno.setEnabled(false);
        jBtPesInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesInternoActionPerformed(evt);
            }
        });

        jBtPesqUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqUnidade.setContentAreaFilled(false);
        jBtPesqUnidade.setEnabled(false);
        jBtPesqUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqUnidadeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Sexo:");

        jComboBoxSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));
        jComboBoxSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexo.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxUnidPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqUnidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxUnidPenal, jNomeInterno});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxUnidPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jBtPesqUnidade)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxUnidPenal, jNomeInterno});

        jTabbedPane2.setForeground(new java.awt.Color(153, 0, 51));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Dt. Entrada:");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Regime:");

        jComboBoxRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Fechado", "Semi-Aberto", "Aberto", "Provisório" }));
        jComboBoxRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegime.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data Crime:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Prisão:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Pena:");

        jDataCrime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCrime.setEnabled(false);

        jDataPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrisao.setEnabled(false);

        jPena.setBackground(new java.awt.Color(240, 240, 240));
        jPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPena.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Conde:");

        jDataCondenacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCondenacao.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 40, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxRegime, jPena});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jDataPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jDataCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Penais", jPanel9);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("Artigo1");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 255));
        jLabel18.setText("Artigo2");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setText("Artigo3");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("Parágrafo1");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Parágrafo2");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("Parágrafo3");

        jArtigo1.setBackground(new java.awt.Color(240, 240, 240));
        jArtigo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo1.setEnabled(false);

        jArtigo2.setBackground(new java.awt.Color(240, 240, 240));
        jArtigo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo2.setEnabled(false);

        jArtigo3.setBackground(new java.awt.Color(240, 240, 240));
        jArtigo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo3.setEnabled(false);

        jParagrafo1.setBackground(new java.awt.Color(240, 240, 240));
        jParagrafo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo1.setEnabled(false);

        jParagrafo2.setBackground(new java.awt.Color(240, 240, 240));
        jParagrafo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo2.setEnabled(false);

        jParagrafo3.setBackground(new java.awt.Color(240, 240, 240));
        jParagrafo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo3.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Termino Pena");

        jDataTerminoPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerminoPena.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(13, 13, 13)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jArtigo3)
                    .addComponent(jLabel19))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jParagrafo2))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jParagrafo3))
                .addGap(35, 35, 35)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jDataTerminoPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jArtigo1, jArtigo2, jArtigo3});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jParagrafo1, jParagrafo2, jParagrafo3});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataTerminoPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jArtigo1, jArtigo2, jArtigo3, jDataTerminoPena, jParagrafo1, jParagrafo2, jParagrafo3});

        jTabbedPane2.addTab("Artigos/Parágrafos", jPanel11);

        jTabelaItensIterno.setAutoCreateRowSorter(true);
        jTabelaItensIterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensIterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaItensIterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq.", "Nome do Interno", "Matricula Penal", "Unidade Penal (Procedência)", "Regime"
            }
        ));
        jTabelaItensIterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensIternoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaItensIterno);
        if (jTabelaItensIterno.getColumnModel().getColumnCount() > 0) {
            jTabelaItensIterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaItensIterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaItensIterno.getColumnModel().getColumn(1).setMinWidth(200);
            jTabelaItensIterno.getColumnModel().getColumn(1).setMaxWidth(200);
            jTabelaItensIterno.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaItensIterno.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaItensIterno.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaItensIterno.getColumnModel().getColumn(3).setMaxWidth(250);
            jTabelaItensIterno.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaItensIterno.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 204, 0))); // NOI18N

        jBtNovoItem.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jBtNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoItem.setText("Novo");
        jBtNovoItem.setEnabled(false);
        jBtNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoItemActionPerformed(evt);
            }
        });

        jBtAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarItem.setText("Alterar");
        jBtAlterarItem.setEnabled(false);
        jBtAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarItemActionPerformed(evt);
            }
        });

        jBtExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirItem.setText("Excluir");
        jBtExcluirItem.setEnabled(false);
        jBtExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirItemActionPerformed(evt);
            }
        });

        jBtSalvarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarItem.setText("Gravar");
        jBtSalvarItem.setEnabled(false);
        jBtSalvarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarItemActionPerformed(evt);
            }
        });

        jBtCancelarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarItem.setText("Cancelar");
        jBtCancelarItem.setEnabled(false);
        jBtCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarItemActionPerformed(evt);
            }
        });

        jBtSairItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairItens.setText("Sair");
        jBtSairItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSalvarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtNovoItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSairItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jBtNovoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtSalvarItem)
                        .addGap(31, 31, 31))
                    .addComponent(jBtCancelarItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairItens)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        FotoInternoCrc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrc, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrc, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );

        jBtNovolanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovolanc.setText("Novo");
        jBtNovolanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovolancActionPerformed(evt);
            }
        });

        jBtAlterarlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarlanc.setText("Alterar");
        jBtAlterarlanc.setEnabled(false);
        jBtAlterarlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarlancActionPerformed(evt);
            }
        });

        jBtExcluirlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirlanc.setText("Excluir");
        jBtExcluirlanc.setEnabled(false);
        jBtExcluirlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirlancActionPerformed(evt);
            }
        });

        jBtSalvarlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarlanc.setText("Gravar");
        jBtSalvarlanc.setEnabled(false);
        jBtSalvarlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarlancActionPerformed(evt);
            }
        });

        jBtCancelarlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarlanc.setText("Cancelar");
        jBtCancelarlanc.setEnabled(false);
        jBtCancelarlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarlancActionPerformed(evt);
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtAudiItensEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudiItensEntrada.setForeground(new java.awt.Color(255, 0, 0));
        jBtAudiItensEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudiItensEntrada.setToolTipText("Auditoria");
        jBtAudiItensEntrada.setContentAreaFilled(false);
        jBtAudiItensEntrada.setEnabled(false);
        jBtAudiItensEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudiItensEntradaActionPerformed(evt);
            }
        });

        jBtBuscarIntPortaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtBuscarIntPortaria.setForeground(new java.awt.Color(255, 0, 0));
        jBtBuscarIntPortaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarIntPortaria.setText("Buscar P1");
        jBtBuscarIntPortaria.setToolTipText("Buscar Nova Entrada na P1");
        jBtBuscarIntPortaria.setEnabled(false);
        jBtBuscarIntPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarIntPortariaActionPerformed(evt);
            }
        });

        jBtPesquisarInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesquisarInterno.setForeground(new java.awt.Color(0, 153, 0));
        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setText("Pesquisar");
        jBtPesquisarInterno.setToolTipText("Pesquisar Interno no Doc.");
        jBtPesquisarInterno.setEnabled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jBtAudiItensEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtBuscarIntPortaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jBtPesquisarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarIntPortaria)
                .addGap(18, 18, 18)
                .addComponent(jBtAudiItensEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, Short.MAX_VALUE))
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtNovolanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaManu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarlanc, jBtCancelarlanc, jBtExcluirlanc, jBtFinalizar, jBtNovolanc, jBtSalvarlanc});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovolanc)
                    .addComponent(jBtAlterarlanc)
                    .addComponent(jBtExcluirlanc)
                    .addComponent(jBtSalvarlanc)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtAuditoriaManu)
                    .addComponent(jBtCancelarlanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel12});

        jTabbedPane1.addTab("Manutenção", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 530));

        setBounds(250, 10, 745, 561);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaLanLoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaLanLoteMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaLanLote.getValueAt(jTabelaLanLote.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            //
            jDataLancamento.setDate(jDataLancamento.getDate());
            jBtNovolanc.setEnabled(true);
            jBtAlterarlanc.setEnabled(true);
            jBtExcluirlanc.setEnabled(true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAuditoriaManu.setEnabled(true);
            jBtPesquisarInterno.setEnabled(true);
            jBtBuscarIntPortaria.setEnabled(!true);
            //
            jDataLancamento.setDate(null);
            // Limpart os Campos
            jIDLanc.setText("");
            jStatusEntrada.setText("");
            jDescricaoOp.setText("");
            jTextAreaObs.setText("");
            //
            jIDInterno.setText("");
            jNomeInterno.setText("");
            FotoInternoCrc.setIcon(null);
            jComboBoxUnidPenal.setSelectedItem(null);
            jComboBoxSexo.setSelectedItem(null);
            jDataEntrada.setDate(null);
            jDataCrime.setDate(null);
            jComboBoxRegime.setSelectedItem(null);
            jDataCondenacao.setDate(null);
            jDataPrisao.setDate(null);
            jPena.setText("");
            jArtigo1.setText("");
            jArtigo2.setText("");
            jArtigo3.setText("");
            jParagrafo1.setText("");
            jParagrafo2.setText("");
            jParagrafo3.setText("");
            jDataTerminoPena.setDate(null);
            //
            jDataLancamento.setEnabled(!true);
            jIDLanc.setEnabled(!true);
            jDescricaoOp.setEnabled(!true);
            jTextAreaObs.setEnabled(!true);
            jBtPesqOperacao.setEnabled(!true);
            jBtPesInterno.setEnabled(!true);
            jBtPesqUnidade.setEnabled(!true);
            //
            jIDInterno.setEnabled(!true);
            jNomeInterno.setEnabled(!true);
            jComboBoxUnidPenal.setEnabled(!true);
            jComboBoxSexo.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jDataCrime.setEnabled(!true);
            jComboBoxRegime.setEnabled(!true);
            jDataCondenacao.setEnabled(!true);
            jDataPrisao.setEnabled(!true);
            jPena.setEnabled(!true);
            jArtigo1.setEnabled(!true);
            jArtigo2.setEnabled(!true);
            jArtigo3.setEnabled(!true);
            jParagrafo1.setEnabled(!true);
            jParagrafo2.setEnabled(!true);
            jParagrafo3.setEnabled(!true);
            jDataTerminoPena.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(!true);
            jBtAudiItensEntrada.setEnabled(!true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ENTRADALOTE "
                        + "INNER JOIN OPERACAO "
                        + "ON ENTRADALOTE.IdOp=OPERACAO.IdOp "
                        + "WHERE IdEntrada ='" + IdLanc + "'");
                conecta.rs.first();
                jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdEntrada")));
                jStatusEntrada.setText(conecta.rs.getString("StatusEnt"));
                jDataLancamento.setDate(conecta.rs.getDate("DataLancaMov"));
                jDescricaoOp.setText(conecta.rs.getString("DescricaoOp"));
                jTextAreaObs.setText(conecta.rs.getString("ObsEntrada"));
                conecta.desconecta();
                preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "WHERE IdEntrada='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
        }
    }//GEN-LAST:event_jTabelaLanLoteMouseClicked

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            pesquisarLancCod("SELECT * FROM ENTRADALOTE "
                    + "INNER JOIN OPERACAO "
                    + "ON ENTRADALOTE.IdOp=OPERACAO.IdOp "
                    + "WHERE IdEntrada='" + jIDPesqLan.getText() + "'");
        }
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jBtCancelarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarlancActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarlancActionPerformed

    private void jBtSalvarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntManuCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            if (jDescricaoOp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da operação de entrada");
                jDescricaoOp.requestFocus();
            } else {
                if (jDataLancamento.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento");
                    jDataLancamento.requestFocus();
                } else {
                    objEntLote.setDateLancamento(jDataLancamento.getDate());
                    objEntLote.setStatusEntrada(statusEntrada);
                    objEntLote.setNomeOperacao(jDescricaoOp.getText());
                    objEntLote.setObs(jTextAreaObs.getText());
                    // log de usuario
                    objEntLote.setUsuarioInsert(nameUser);
                    objEntLote.setDataInsert(dataModFinal);
                    objEntLote.setHoraInsert(horaMov);
                    try {
                        if (acao == 1) {
                            control.incluirEntradaLote(objEntLote);
                            buscarCodEnt();
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro INCLUIDO com sucesso, será necessário\nincluir os internos na aba (INTERNOS)\npara que possa ser registrado a movimentação.");
                            Salvar();
                        }
                        if (acao == 2) {
                            // log de usuario
                            objEntLote.setUsuarioUp(nameUser);
                            objEntLote.setDataUp(dataModFinal);
                            objEntLote.setHoraUp(horaMov);
                            objEntLote.setIdLanc(Integer.parseInt(jIDLanc.getText()));
                            control.alterarEntradaLote(objEntLote);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro ALTERADO com sucesso. Se necessário\n faça aleração dos internos na aba(INTERNOS)");
                            Salvar();
                        }
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível GRAVAR registro !!!\n" + e);
                    }
                }
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntManuCRC) && codAbrirCRC == 1) {
            if (jDescricaoOp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da operação de entrada");
                jDescricaoOp.requestFocus();
            } else {
                if (jDataLancamento.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento");
                    jDataLancamento.requestFocus();
                } else {
                    objEntLote.setDateLancamento(jDataLancamento.getDate());
                    objEntLote.setStatusEntrada(statusEntrada);
                    objEntLote.setNomeOperacao(jDescricaoOp.getText());
                    objEntLote.setObs(jTextAreaObs.getText());
                    // log de usuario
                    objEntLote.setUsuarioInsert(nameUser);
                    objEntLote.setDataInsert(dataModFinal);
                    objEntLote.setHoraInsert(horaMov);
                    try {
                        if (acao == 1) {
                            control.incluirEntradaLote(objEntLote);
                            buscarCodEnt();
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro INCLUIDO com sucesso, será necessário\nincluir os internos na aba (INTERNOS)\npara que possa ser registrado a movimentação.");
                            Salvar();
                        }
                        if (acao == 2) {
                            // log de usuario
                            objEntLote.setUsuarioUp(nameUser);
                            objEntLote.setDataUp(dataModFinal);
                            objEntLote.setHoraUp(horaMov);
                            objEntLote.setIdLanc(Integer.parseInt(jIDLanc.getText()));
                            control.alterarEntradaLote(objEntLote);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro ALTERADO com sucesso. Se necessário\n faça aleração dos internos na aba(INTERNOS)");
                            Salvar();
                        }
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível GRAVAR registro !!!\n" + e);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarlancActionPerformed

    private void jBtExcluirlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntManuCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser excluida, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntManuCRC) && codExcluirCRC == 1) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser excluida, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirlancActionPerformed

    private void jBtAlterarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntManuCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampo();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntManuCRC) && codAbrirCRC == 1) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampo();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarlancActionPerformed

    private void jBtNovolancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovolancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntManuCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntManuCRC) && codIncluirCRC == 1) {
            acao = 1;
            Novo();
            corCampo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovolancActionPerformed

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntIntCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntIntCRC) && codIncluirCRC == 1) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntIntCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                flag = 1;
                AlterarItem();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntIntCRC) && codAlterarCRC == 1) {
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                flag = 1;
                AlterarItem();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntIntCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItens.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensEntLote(objItens);
                    //
                    objItens.setIdItem(coditem);
                    objItens.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                    controlMov.excluirMovInterno(objItens);
                    // Alterar na tabela de ITENSNOVAENTRADA como "não" para poder ser excluido caso necessário
                    objItensNova.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objItensNova.setUtilizacaoCrc(excluirUtilizacao); // Passa como "não"
                    controlPort.alterarUtilizacaoNovaEntrada(objItensNova); // Tabela ITENSNOVAENTRADA
                    // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016      
                    jDataEntrada.setDate(null);
                    objDadosPena.setDataNovaEntrada(jDataEntrada.getDate());
                    objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    controleNovaData.incluirDataNovaEntrada(objDadosPena);
                    // INFORMAR OPÇÕES DO KIT DE HIGIENE
                    pagtoKit = null;
                    objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                    objProCrc.setDataChegada(jDataEntrada.getDate());
                    objProCrc.setKitInicial(pagtoKit);
                    objProCrc.setKitIPago(pagtoKit);
                    objProCrc.setKitDecendial(pagtoKit);
                    objProCrc.setKitDPago(pagtoKit);
                    objProCrc.setKitQuinzenal(pagtoKit);
                    objProCrc.setKitQPago(pagtoKit);
                    objProCrc.setKitMensal(pagtoKit);
                    objProCrc.setKitMPago(pagtoKit);
                    objProCrc.setKitSemestral(pagtoKit);
                    objProCrc.setKitSPago(pagtoKit);
                    objProCrc.setKitAnual(pagtoKit);
                    objProCrc.setKitAPago(pagtoKit);
                    controle.informarkitHigiene(objProCrc);
                    // HISTORICO DE DADOS PENAIS DOS INTERNOS.
                    objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objDadosPena.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                    objDadosPena.setIdItem(Integer.valueOf(idItem));
                    controleHistDP.excluirDadosPenaisInterno(objDadosPena);
                    //PORTA DE ENTRADA, HABILITAR A NOVA ADMISSÃO PARA O INTERNO, CASO ELE JÁ TENHA.
                    verificarAdmissoesPSP();
                    verificarAdmissaoPortaEntrada(jIDInterno.getText());
                    //SE EXISTIR NA TABELA ADMISSAOMEDICA
                    if (jIDInterno.getText().equals(pID_INTERNO_MEDICO)) {
                        //ALTERAR PORTA DE ENTRADA   
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAOENFERMEIRA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_ENFERMEIRA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ATENDIMENTOJURIDICO
                    } else if (jIDInterno.getText().equals(pID_INTERNO_JURIDICO)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAO_PEDAGOGICA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_PEDAGOGIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAOPSI
                    } else if (jIDInterno.getText().equals(pID_INTERNO_PSICOLOGIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAOSOCIAL
                    } else if (jIDInterno.getText().equals(pID_INTERNO_SERVICO)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAODONTOLOGICA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_ODONTOLOGIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSA_TERAPIA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_TERAPIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                    }
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN UNIDADE ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE IdEntrada='" + jIDLanc.getText() + "'");
                }
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntIntCRC) && codExcluirCRC == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objEntLote.setStatusEntrada(jStatusEntrada.getText());
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItens.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensEntLote(objItens);
                    //
                    objItens.setIdItem(coditem);
                    objItens.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                    controlMov.excluirMovInterno(objItens);
                    // Alterar na tabela de ITENSNOVAENTRADA como "não" para poder ser excluido caso necessário
                    objItensNova.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objItensNova.setUtilizacaoCrc(excluirUtilizacao); // Passa como "não"
                    controlPort.alterarUtilizacaoNovaEntrada(objItensNova); // Tabela ITENSNOVAENTRADA
                    // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016      
                    jDataEntrada.setDate(null);
                    objDadosPena.setDataNovaEntrada(jDataEntrada.getDate());
                    objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    controleNovaData.incluirDataNovaEntrada(objDadosPena);
                    // INFORMAR OPÇÕES DO KIT DE HIGIENE
                    pagtoKit = null;
                    objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                    objProCrc.setKitInicial(pagtoKit);
                    objProCrc.setKitIPago(pagtoKit);
                    objProCrc.setKitDecendial(pagtoKit);
                    objProCrc.setKitDPago(pagtoKit);
                    objProCrc.setKitQuinzenal(pagtoKit);
                    objProCrc.setKitQPago(pagtoKit);
                    objProCrc.setKitMensal(pagtoKit);
                    objProCrc.setKitMPago(pagtoKit);
                    objProCrc.setKitSemestral(pagtoKit);
                    objProCrc.setKitSPago(pagtoKit);
                    objProCrc.setKitAnual(pagtoKit);
                    objProCrc.setKitAPago(pagtoKit);
                    controle.informarkitHigiene(objProCrc);
                    //PORTA DE ENTRADA, HABILITAR A NOVA ADMISSÃO PARA O INTERNO, CASO ELE JÁ TENHA.
                    verificarAdmissoesPSP();
                    verificarAdmissaoPortaEntrada(jIDInterno.getText());
                    //SE EXISTIR NA TABELA ADMISSAOMEDICA
                    if (jIDInterno.getText().equals(pID_INTERNO_MEDICO)) {
                        //ALTERAR PORTA DE ENTRADA   
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAOENFERMEIRA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_ENFERMEIRA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ATENDIMENTOJURIDICO
                    } else if (jIDInterno.getText().equals(pID_INTERNO_JURIDICO)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAO_PEDAGOGICA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_PEDAGOGIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAOPSI
                    } else if (jIDInterno.getText().equals(pID_INTERNO_PSICOLOGIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAOSOCIAL
                    } else if (jIDInterno.getText().equals(pID_INTERNO_SERVICO)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSAODONTOLOGICA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_ODONTOLOGIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                        //SE EXISTIR NA TABELA ADMISSA_TERAPIA
                    } else if (jIDInterno.getText().equals(pID_INTERNO_TERAPIA)) {
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                        objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                        objPortaEntrada.setHabEnf(pOPCAO_NEGAR);
                        objPortaEntrada.setHabMed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabJur(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPed(pOPCAO_NEGAR);
                        objPortaEntrada.setHabPsi(pOPCAO_NEGAR);
                        objPortaEntrada.setHabSso(pOPCAO_NEGAR);
                        objPortaEntrada.setHabOdo(pOPCAO_NEGAR);
                        objPortaEntrada.setHabTer(pOPCAO_NEGAR);
                        objPortaEntrada.setHabEdu(pOPCAO_NEGAR);
                        control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                    }
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN UNIDADE ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE IdEntrada='" + jIDLanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        buscarAcessoUsuarioCRC(telaEntradaIntIntCRC);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do Interno não pode ser em branco,\nutilize o botão pesquisar ao lado.");
                jNomeInterno.requestFocus();
            } else {
                if (jComboBoxUnidPenal.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Procedência (UNIDADE PENAL) não pode ser em branco.");
                    jComboBoxUnidPenal.requestFocus();
                } else {
                    if (jDataEntrada.getDate() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Data de Entrada não pode ser em branco.");
                        jDataEntrada.requestFocus();
                    } else {
                        if (jDataCrime.getDate() == null) {
                            JOptionPane.showMessageDialog(rootPane, "Data do Crime não pode ser em branco.");
                            jDataCrime.requestFocus();
                        } else {
                            if (jDataPrisao.getDate() == null) {
                                JOptionPane.showMessageDialog(rootPane, "Data da Prisão não pode ser em branco.");
                                jDataPrisao.requestFocus();
                            } else {
                                if (jDataCondenacao.getDate() == null) {
                                    JOptionPane.showMessageDialog(rootPane, "Data da Condenção não pode ser em branco.");
                                    jDataCondenacao.requestFocus();
                                } else {
                                    if (jDataTerminoPena.getDate() == null) {
                                        JOptionPane.showMessageDialog(rootPane, "Data do Termino da Pena não pode ser em branco.");
                                        jDataTerminoPena.requestFocus();
                                    } else {
                                        objItens.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                        objItens.setNomeInterno(jNomeInterno.getText());
                                        objItens.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                        objProCrc.setSexo((String) jComboBoxSexo.getSelectedItem());
                                        objDadosPena.setDataEntrada(jDataEntrada.getDate());
                                        objDadosPena.setDataCrime(jDataCrime.getDate());
                                        objDadosPena.setDataPrisao(jDataPrisao.getDate());
                                        objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                                        objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                                        objDadosPena.setPena(jPena.getText());
                                        objDadosPena.setArtigo1(jArtigo1.getText());
                                        objDadosPena.setArtigo2(jArtigo2.getText());
                                        objDadosPena.setArtigo3(jArtigo3.getText());
                                        objDadosPena.setParagrafo1(jParagrafo1.getText());
                                        objDadosPena.setParagrafo2(jParagrafo2.getText());
                                        objDadosPena.setParagrafo3(jParagrafo3.getText());
                                        objDadosPena.setTerminoPena(jDataTerminoPena.getDate());
                                        objItens();
                                        // Incluir os itens da Entrada
                                        if (acao == 3) {
                                            objItens.setIdEntrada((Integer.parseInt(jIDLanc.getText())));
                                            objItens();
                                            controle.incluirItensEntLote(objItens);
                                            //
                                            buscarIdItem();
                                            // INFORMAR OPÇÕES DO KIT DE HIGIENE INICIAL
                                            pagtoKit = "Não";
                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                            objProCrc.setNomeInterno(jNomeInterno.getText());
                                            objProCrc.setDataChegada(jDataEntrada.getDate());
                                            objProCrc.setKitPago(pagtoKit);
                                            objProCrc.setUtilizado(pagtoKit);
                                            controle.informarkitHigiene(objProCrc);
                                            // MODIFICAR A SITUAÇÃO DO INTERNO NA TABELA PRONTUARIOSCRC
                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                            objProCrc.setSituacao(situacao);
                                            mod.alterarSituacaoInterno(objProCrc);
                                            // TABLEA DADOSPENAISINTERNOS
                                            objDadosPena.setIdInternoCrc(Integer.parseInt(jIDInterno.getText()));
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            controlInterno.alterarDadosPenaisLote(objDadosPena);
                                            //Inserir na tabela de movimentação                                              
                                            objItens.setDataEntrada(jDataEntrada.getDate());
                                            objItens.setIdItem(codItemEnt);
                                            controlMov.incluirMovInterno(objItens);
                                            //
                                            objItensNova.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            objItensNova.setUtilizacaoCrc(utilizacaoCrc);
                                            controlPort.alterarUtilizacaoNovaEntrada(objItensNova);
                                            // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016               
                                            objDadosPena.setDataNovaEntrada(jDataEntrada.getDate());
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            controleNovaData.incluirDataNovaEntrada(objDadosPena);
                                            //ATUALIZAR ROL DE VISITAS
                                            atualizarRolSaidaInterno();
                                            // SE A TELA DE ENTRADA NA UNIDADE ESTÁ SENDO UTILIZADA PELA TRIAGEM, 
                                            // ENTÃO ATUALIZA A TABELA DE ITENENTRADA.
                                            if (origemTriagem.equals("Sim")) {
                                                origemTriagem = "Não"; // PASSA A SER "Não" PARA SER UTILIZADA NA PRÉ-LOCAÇÃO PELA TRIAGEM.
                                                objItensPreLocacao.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                                objItensPreLocacao.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objItensPreLocacao.setConfirmaUtil(origemTriagem);
                                                controlePre.confirmcaoPreLocacaoInternosEntrada(objItensPreLocacao);
                                                origemTriagem = ""; // LIMPA A VARIAVEL
                                            }
                                            // HISTÓRICO DOS DADOS PENAIS DOS INTERNOS.
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            objDadosPena.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                            objDadosPena.setIdItem(Integer.valueOf(idItem));
                                            objDadosPena.setNomeInternoCrc(jNomeInterno.getText());
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            objDadosPena.setDataEntrada(jDataEntrada.getDate());
                                            objDadosPena.setDataCrime(jDataCrime.getDate());
                                            objDadosPena.setDataPrisao(jDataPrisao.getDate());
                                            objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                                            objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                                            objDadosPena.setPena(jPena.getText());
                                            objDadosPena.setArtigo1(jArtigo1.getText());
                                            objDadosPena.setArtigo2(jArtigo2.getText());
                                            objDadosPena.setArtigo3(jArtigo3.getText());
                                            objDadosPena.setParagrafo1(jParagrafo1.getText());
                                            objDadosPena.setParagrafo2(jParagrafo2.getText());
                                            objDadosPena.setParagrafo3(jParagrafo3.getText());
                                            objDadosPena.setTerminoPena(jDataTerminoPena.getDate());
                                            objDadosPena.setUsuarioInsert(nameUser);
                                            objDadosPena.setDataInsert(jDataSistema.getText());
                                            objDadosPena.setHorarioInsert(jHoraSistema.getText());
                                            controleHistDP.incluirDadosPenaisInterno(objDadosPena);
                                            //
                                            //PORTA DE ENTRADA, HABILITAR A NOVA ADMISSÃO PARA O INTERNO, CASO ELE JÁ TENHA.
                                            verificarAdmissoesPSP();
                                            verificarAdmissaoPortaEntrada(jIDInterno.getText());
                                            //SE EXISTIR NA TABELA ADMISSAOMEDICA
                                            if (jIDInterno.getText().equals(pID_INTERNO_MEDICO)) {
                                                //ALTERAR PORTA DE ENTRADA   
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAOENFERMEIRA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_ENFERMEIRA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ATENDIMENTOJURIDICO
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_JURIDICO)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAO_PEDAGOGICA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_PEDAGOGIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAOPSI
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_PSICOLOGIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAOSOCIAL
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_SERVICO)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAODONTOLOGICA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_ODONTOLOGIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSA_TERAPIA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_TERAPIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                            } else {
                                                //TABELA PORTA_ENTRADA
                                                if (jIDInterno.getText().equals(pCODIGO_INTERNO_PE)) {
                                                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                    objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                    objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                    objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                    control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                } else {
                                                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                    objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                                    objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                    objPortaEntrada.setpSPEnf(pPSP_POSTO_MEDICO);
                                                    objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPMed(pPSP_POSTO_MEDICO);
                                                    objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPJur(pPSP_JURIDICO);
                                                    objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPPed(pPSP_PEDAGOGIA);
                                                    objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPPsi(pPSP_PSICOLOGIA);
                                                    objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPSso(pPSP_SERVICO);
                                                    objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPOdo(pPSP_ODONTOLOGIA);
                                                    objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPTer(pPSP_TERAPIA);
                                                    objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPEdu(pPSP_EDUCACAO_FISICA);
                                                    objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                    control_PE.incluirPortaEntrada(objPortaEntrada);
                                                }
                                            }
                                            objLog2();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            //                                        
                                            SalvarItem();
                                            preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                                                    + "INNER JOIN PRONTUARIOSCRC "
                                                    + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                    + "INNER JOIN UNIDADE "
                                                    + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                                                    + "INNER JOIN DADOSPENAISINTERNOS "
                                                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                                    + "WHERE IdEntrada='" + jIDLanc.getText() + "'");
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso...");
                                        }
                                        // Alterar os itens da Entrada
                                        if (acao == 4) {
                                            // Para o log do registro
                                            objItens.setUsuarioUp(nameUser);
                                            objItens.setDataUp(jDataSistema.getText());
                                            objItens.setHoraUp(jHoraSistema.getText());
                                            //
                                            objItens.setIdEntrada((Integer.parseInt(jIDLanc.getText())));
                                            objProCrc.setIdInterno(Integer.parseInt(jIDInterno.getText()));
                                            objItens.setIdItem(Integer.valueOf(idItem));
                                            controle.alterarItensEntLote(objItens);
                                            //
                                            objDadosPena.setIdInternoCrc(Integer.parseInt(jIDInterno.getText()));
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            controlInterno.alterarDadosPenaisLote(objDadosPena);
                                            //
                                            objItens.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                            objItens.setIdInternoCrc(Integer.parseInt(jIDInterno.getText()));
                                            controlMov.alterarMovInterno(objItens);
                                            // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016               
                                            objDadosPena.setDataNovaEntrada(jDataEntrada.getDate());
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            controleNovaData.incluirDataNovaEntrada(objDadosPena);
                                            //
                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                            objProCrc.setSituacao(situacao);
                                            mod.alterarSituacaoInterno(objProCrc);
                                            // HISTÓRICO DOS DADOS PENAIS DOS INTERNOS.
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            objDadosPena.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                            objDadosPena.setIdItem(Integer.valueOf(idItem));
                                            objDadosPena.setNomeInternoCrc(jNomeInterno.getText());
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            objProCrc.setSexo((String) jComboBoxSexo.getSelectedItem());
                                            objDadosPena.setDataEntrada(jDataEntrada.getDate());
                                            objDadosPena.setDataCrime(jDataCrime.getDate());
                                            objDadosPena.setDataPrisao(jDataPrisao.getDate());
                                            objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                                            objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                                            objDadosPena.setPena(jPena.getText());
                                            objDadosPena.setArtigo1(jArtigo1.getText());
                                            objDadosPena.setArtigo2(jArtigo2.getText());
                                            objDadosPena.setArtigo3(jArtigo3.getText());
                                            objDadosPena.setParagrafo1(jParagrafo1.getText());
                                            objDadosPena.setParagrafo2(jParagrafo2.getText());
                                            objDadosPena.setParagrafo3(jParagrafo3.getText());
                                            objDadosPena.setTerminoPena(jDataTerminoPena.getDate());
                                            objDadosPena.setUsuarioUp(nameUser);
                                            objDadosPena.setDataUp(jDataSistema.getText());
                                            objDadosPena.setHorarioUp(jHoraSistema.getText());
                                            controleHistDP.alterarDadosPenaisInterno(objDadosPena);
                                            //
                                            objLog2();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                        
                                            SalvarItem();
                                            preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                                                    + "INNER JOIN PRONTUARIOSCRC "
                                                    + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                    + "INNER JOIN UNIDADE "
                                                    + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                                                    + "INNER JOIN DADOSPENAISINTERNOS "
                                                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                                    + "WHERE IdEntrada='" + jIDLanc.getText() + "'");
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado coom sucesso...");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEntradaIntIntCRC) && codGravarCRC == 1) {
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do Interno não pode ser em branco,\nutilize o botão pesquisar ao lado.");
                jNomeInterno.requestFocus();
            } else {
                if (jComboBoxUnidPenal.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Procedência (UNIDADE PENAL) não pode ser em branco.");
                    jComboBoxUnidPenal.requestFocus();
                } else {
                    if (jDataEntrada.getDate() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Data de Entrada não pode ser em branco.");
                        jDataEntrada.requestFocus();
                    } else {
                        if (jDataCrime.getDate() == null) {
                            JOptionPane.showMessageDialog(rootPane, "Data do Crime não pode ser em branco.");
                            jDataCrime.requestFocus();
                        } else {
                            if (jDataPrisao.getDate() == null) {
                                JOptionPane.showMessageDialog(rootPane, "Data da Prisão não pode ser em branco.");
                                jDataPrisao.requestFocus();
                            } else {
                                if (jDataCondenacao.getDate() == null) {
                                    JOptionPane.showMessageDialog(rootPane, "Data da Condenção não pode ser em branco.");
                                    jDataCondenacao.requestFocus();
                                } else {
                                    if (jDataTerminoPena.getDate() == null) {
                                        JOptionPane.showMessageDialog(rootPane, "Data do Termino da Pena não pode ser em branco.");
                                        jDataTerminoPena.requestFocus();
                                    } else {
                                        objItens.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                        objItens.setNomeInterno(jNomeInterno.getText());
                                        objItens.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                        objProCrc.setSexo((String) jComboBoxSexo.getSelectedItem());
                                        objDadosPena.setDataEntrada(jDataEntrada.getDate());
                                        objDadosPena.setDataCrime(jDataCrime.getDate());
                                        objDadosPena.setDataPrisao(jDataPrisao.getDate());
                                        objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                                        objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                                        objDadosPena.setPena(jPena.getText());
                                        objDadosPena.setArtigo1(jArtigo1.getText());
                                        objDadosPena.setArtigo2(jArtigo2.getText());
                                        objDadosPena.setArtigo3(jArtigo3.getText());
                                        objDadosPena.setParagrafo1(jParagrafo1.getText());
                                        objDadosPena.setParagrafo2(jParagrafo2.getText());
                                        objDadosPena.setParagrafo3(jParagrafo3.getText());
                                        objDadosPena.setTerminoPena(jDataTerminoPena.getDate());
                                        objItens();
                                        // Incluir os itens da Entrada
                                        if (acao == 3) {
                                            objItens.setIdEntrada((Integer.parseInt(jIDLanc.getText())));
                                            objItens();
                                            controle.incluirItensEntLote(objItens);
                                            //
                                            buscarIdItem();
                                            // INFORMAR OPÇÕES DO KIT DE HIGIENE INICIAL
                                            pagtoKit = "Não";
                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                            objProCrc.setNomeInterno(jNomeInterno.getText());
                                            objProCrc.setDataChegada(jDataEntrada.getDate());
                                            objProCrc.setKitPago(pagtoKit);
                                            objProCrc.setUtilizado(pagtoKit);
                                            controle.informarkitHigiene(objProCrc);
                                            // MODIFICAR A SITUAÇÃO DO INTERNO NA TABELA PRONTUARIOSCRC
                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                            objProCrc.setSituacao(situacao);
                                            mod.alterarSituacaoInterno(objProCrc);
                                            // TABLEA DADOSPENAISINTERNOS
                                            objDadosPena.setIdInternoCrc(Integer.parseInt(jIDInterno.getText()));
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            controlInterno.alterarDadosPenaisLote(objDadosPena);
                                            //Inserir na tabela de movimentação                                              
                                            objItens.setDataEntrada(jDataEntrada.getDate());
                                            objItens.setIdItem(codItemEnt);
                                            controlMov.incluirMovInterno(objItens);
                                            //
                                            objItensNova.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            objItensNova.setUtilizacaoCrc(utilizacaoCrc);
                                            controlPort.alterarUtilizacaoNovaEntrada(objItensNova);
                                            // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016               
                                            objDadosPena.setDataNovaEntrada(jDataEntrada.getDate());
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            controleNovaData.incluirDataNovaEntrada(objDadosPena);
                                            //ATUALIZAR ROL DE VISITAS
                                            atualizarRolSaidaInterno();
                                            // SE A TELA DE ENTRADA NA UNIDADE ESTÁ SENDO UTILIZADA PELA TRIAGEM, 
                                            // ENTÃO ATUALIZA A TABELA DE ITENENTRADA.
                                            if (origemTriagem.equals("Sim")) {
                                                origemTriagem = "Não"; // PASSA A SER "Não" PARA SER UTILIZADA NA PRÉ-LOCAÇÃO PELA TRIAGEM.
                                                objItensPreLocacao.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                                objItensPreLocacao.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objItensPreLocacao.setConfirmaUtil(origemTriagem);
                                                controlePre.confirmcaoPreLocacaoInternosEntrada(objItensPreLocacao);
                                                origemTriagem = ""; // LIMPA A VARIAVEL
                                            }
                                            // HISTÓRICO DOS DADOS PENAIS DOS INTERNOS.
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            objDadosPena.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                            objDadosPena.setIdItem(Integer.valueOf(idItem));
                                            objDadosPena.setNomeInternoCrc(jNomeInterno.getText());
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            objDadosPena.setDataEntrada(jDataEntrada.getDate());
                                            objDadosPena.setDataCrime(jDataCrime.getDate());
                                            objDadosPena.setDataPrisao(jDataPrisao.getDate());
                                            objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                                            objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                                            objDadosPena.setPena(jPena.getText());
                                            objDadosPena.setArtigo1(jArtigo1.getText());
                                            objDadosPena.setArtigo2(jArtigo2.getText());
                                            objDadosPena.setArtigo3(jArtigo3.getText());
                                            objDadosPena.setParagrafo1(jParagrafo1.getText());
                                            objDadosPena.setParagrafo2(jParagrafo2.getText());
                                            objDadosPena.setParagrafo3(jParagrafo3.getText());
                                            objDadosPena.setTerminoPena(jDataTerminoPena.getDate());
                                            objDadosPena.setUsuarioInsert(nameUser);
                                            objDadosPena.setDataInsert(jDataSistema.getText());
                                            objDadosPena.setHorarioInsert(jHoraSistema.getText());
                                            controleHistDP.incluirDadosPenaisInterno(objDadosPena);
                                            //
                                            //PORTA DE ENTRADA, HABILITAR A NOVA ADMISSÃO PARA O INTERNO, CASO ELE JÁ TENHA.
                                            verificarAdmissoesPSP();
                                            verificarAdmissaoPortaEntrada(jIDInterno.getText());
                                            //SE EXISTIR NA TABELA ADMISSAOMEDICA
                                            if (jIDInterno.getText().equals(pID_INTERNO_MEDICO)) {
                                                //ALTERAR PORTA DE ENTRADA   
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAOENFERMEIRA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_ENFERMEIRA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ATENDIMENTOJURIDICO
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_JURIDICO)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAO_PEDAGOGICA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_PEDAGOGIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAOPSI
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_PSICOLOGIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAOSOCIAL
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_SERVICO)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSAODONTOLOGICA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_ODONTOLOGIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                //SE EXISTIR NA TABELA ADMISSA_TERAPIA
                                            } else if (jIDInterno.getText().equals(pID_INTERNO_TERAPIA)) {
                                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                            } else {
                                                //TABELA PORTA_ENTRADA
                                                if (jIDInterno.getText().equals(pCODIGO_INTERNO_PE)) {
                                                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                    objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                    objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                    control_PE.alterarPortaEntradaCRC(objPortaEntrada);
                                                } else {
                                                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                    objPortaEntrada.setDataEntrada(jDataLancamento.getDate());
                                                    objPortaEntrada.setpSPEnf(pPSP_POSTO_MEDICO);
                                                    objPortaEntrada.setHabEnf(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPMed(pPSP_POSTO_MEDICO);
                                                    objPortaEntrada.setHabMed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPJur(pPSP_JURIDICO);
                                                    objPortaEntrada.setHabJur(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPPed(pPSP_PEDAGOGIA);
                                                    objPortaEntrada.setHabPed(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPPsi(pPSP_PSICOLOGIA);
                                                    objPortaEntrada.setHabPsi(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPSso(pPSP_SERVICO);
                                                    objPortaEntrada.setHabSso(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPOdo(pPSP_ODONTOLOGIA);
                                                    objPortaEntrada.setHabOdo(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPTer(pPSP_TERAPIA);
                                                    objPortaEntrada.setHabTer(pOPCAO_CONFIRMAR);
                                                    objPortaEntrada.setpSPEdu(pPSP_EDUCACAO_FISICA);
                                                    objPortaEntrada.setHabEdu(pOPCAO_CONFIRMAR);
                                                    control_PE.incluirPortaEntrada(objPortaEntrada);
                                                }
                                            }
                                            //
                                            objLog2();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            //                                        
                                            SalvarItem();
                                            preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                                                    + "INNER JOIN PRONTUARIOSCRC "
                                                    + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                    + "INNER JOIN UNIDADE "
                                                    + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                                                    + "INNER JOIN DADOSPENAISINTERNOS "
                                                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                                    + "WHERE IdEntrada='" + jIDLanc.getText() + "'");
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso...");
                                        }
                                        // Alterar os itens da Entrada
                                        if (acao == 4) {
                                            // Para o log do registro
                                            objItens.setUsuarioUp(nameUser);
                                            objItens.setDataUp(jDataSistema.getText());
                                            objItens.setHoraUp(jHoraSistema.getText());
                                            //
                                            objItens.setIdEntrada((Integer.parseInt(jIDLanc.getText())));
                                            objProCrc.setIdInterno(Integer.parseInt(jIDInterno.getText()));
                                            objItens.setIdItem(Integer.valueOf(idItem));
                                            controle.alterarItensEntLote(objItens);
                                            //
                                            objDadosPena.setIdInternoCrc(Integer.parseInt(jIDInterno.getText()));
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            controlInterno.alterarDadosPenaisLote(objDadosPena);
                                            //
                                            objItens.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                            objItens.setIdInternoCrc(Integer.parseInt(jIDInterno.getText()));
                                            controlMov.alterarMovInterno(objItens);
                                            // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016               
                                            objDadosPena.setDataNovaEntrada(jDataEntrada.getDate());
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            controleNovaData.incluirDataNovaEntrada(objDadosPena);
                                            //
                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                            objProCrc.setSituacao(situacao);
                                            mod.alterarSituacaoInterno(objProCrc);
                                            // HISTÓRICO DOS DADOS PENAIS DOS INTERNOS.
                                            objDadosPena.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                            objDadosPena.setIdEntrada(Integer.valueOf(jIDLanc.getText()));
                                            objDadosPena.setIdItem(Integer.valueOf(idItem));
                                            objDadosPena.setNomeInternoCrc(jNomeInterno.getText());
                                            objDadosPena.setNomeUnidade((String) jComboBoxUnidPenal.getSelectedItem());
                                            objProCrc.setSexo((String) jComboBoxSexo.getSelectedItem());
                                            objDadosPena.setDataEntrada(jDataEntrada.getDate());
                                            objDadosPena.setDataCrime(jDataCrime.getDate());
                                            objDadosPena.setDataPrisao(jDataPrisao.getDate());
                                            objDadosPena.setDataCondenacao(jDataCondenacao.getDate());
                                            objDadosPena.setRegime((String) jComboBoxRegime.getSelectedItem());
                                            objDadosPena.setPena(jPena.getText());
                                            objDadosPena.setArtigo1(jArtigo1.getText());
                                            objDadosPena.setArtigo2(jArtigo2.getText());
                                            objDadosPena.setArtigo3(jArtigo3.getText());
                                            objDadosPena.setParagrafo1(jParagrafo1.getText());
                                            objDadosPena.setParagrafo2(jParagrafo2.getText());
                                            objDadosPena.setParagrafo3(jParagrafo3.getText());
                                            objDadosPena.setTerminoPena(jDataTerminoPena.getDate());
                                            objDadosPena.setUsuarioUp(nameUser);
                                            objDadosPena.setDataUp(jDataSistema.getText());
                                            objDadosPena.setHorarioUp(jHoraSistema.getText());
                                            controleHistDP.alterarDadosPenaisInterno(objDadosPena);
                                            //
                                            objLog2();
                                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                        
                                            SalvarItem();
                                            preencherTabelaItens("SELECT * FROM ITENSENTRADA "
                                                    + "INNER JOIN PRONTUARIOSCRC "
                                                    + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                    + "INNER JOIN UNIDADE "
                                                    + "ON ITENSENTRADA.IdUnid=UNIDADE.IdUnid "
                                                    + "INNER JOIN DADOSPENAISINTERNOS "
                                                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                                    + "WHERE IdEntrada='" + jIDLanc.getText() + "'");
                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado coom sucesso...");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarItemActionPerformed

    private void jBtCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarItemActionPerformed
        // TODO add your handling code here:
        CancelarItem();
    }//GEN-LAST:event_jBtCancelarItemActionPerformed

    private void jBtPesqOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqOperacaoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaOpEntLote objOpLote = new TelaPesquisaOpEntLote();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objOpLote);
            objOpLote.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objOpLote);
            objOpLote.show();
        }
    }//GEN-LAST:event_jBtPesqOperacaoActionPerformed

    private void jBtPesInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesInternoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaEntraInterLote objEIntLote = new TelaPesquisaEntraInterLote();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objEIntLote);
            objEIntLote.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objEIntLote);
            objEIntLote.show();
            origemTriagem = "Sim";
        }
    }//GEN-LAST:event_jBtPesInternoActionPerformed

    private void jTabelaItensIternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensIternoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaItensIterno.getValueAt(jTabelaItensIterno.getSelectedRow(), 1);
            jNomeInterno.setText(nomeInterno);
            idItem = "" + jTabelaItensIterno.getValueAt(jTabelaItensIterno.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAudiItensEntrada.setEnabled(true);
            jComboBoxUnidPenal.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSENTRADA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON UNIDADE.IdUnid=ITENSENTRADA.IdUnid "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                        + "AND IdEntrada='" + jIDLanc.getText() + "' "
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIDInterno.setText(conecta.rs.getString("IdInternoCrc")); //Coluna 0
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1
                idItem = conecta.rs.getString("IdItem"); // Coluna 2
                coditem = conecta.rs.getInt("IdItem"); // Código do item para exclusão
                jComboBoxUnidPenal.addItem(conecta.rs.getString("DescricaoUnid"));
                jComboBoxSexo.setSelectedItem(conecta.rs.getString("SexoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoInternoCrc.setIcon(i);
                    FotoInternoCrc.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoCrc.getWidth(), FotoInternoCrc.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInternoCrc.getWidth(), FotoInternoCrc.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInternoCrc.setIcon(icon);
                }
                //
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jDataCrime.setDate(conecta.rs.getDate("DataCrime"));
                jComboBoxRegime.setSelectedItem(conecta.rs.getString("Regime"));
                jDataCondenacao.setDate(conecta.rs.getDate("DataCondenacao"));
                jDataPrisao.setDate(conecta.rs.getDate("DataPrisao"));
                jPena.setText(conecta.rs.getString("Pena"));
                jArtigo1.setText(conecta.rs.getString("Artigo1"));
                jArtigo2.setText(conecta.rs.getString("Artigo2"));
                jArtigo3.setText(conecta.rs.getString("Artigo3"));
                jParagrafo1.setText(conecta.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conecta.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conecta.rs.getString("Paragrafo3"));
                jDataTerminoPena.setDate(conecta.rs.getDate("TerminoPena"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensIternoMouseClicked

    private void jBtPesqUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqUnidadeActionPerformed
        // TODO add your handling code here:
        TelaPesquisaUnidEntradaLote objUnidLote = new TelaPesquisaUnidEntradaLote();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objUnidLote);
            objUnidLote.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objUnidLote);
            objUnidLote.show();
        }
    }//GEN-LAST:event_jBtPesqUnidadeActionPerformed

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
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
                        pesquisarLancCod("SELECT * FROM ENTRADALOTE "
                                + "INNER JOIN OPERACAO "
                                + "ON ENTRADALOTE.IdOp=OPERACAO.IdOp "
                                + "WHERE DataLancaMov BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
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
                        pesquisarLancCod("SELECT * FROM ENTRADALOTE "
                                + "INNER JOIN OPERACAO "
                                + "ON ENTRADALOTE.IdOp=OPERACAO.IdOp "
                                + "WHERE DataLancaMov BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtSairItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairItensActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairItensActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADALOTE WHERE IdEntrada='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            jStatusEntrada.setText(conecta.rs.getString("StatusEnt"));
            if (jStatusEntrada.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntradas();
        } else {
            jtotalRegistros.setText("");
            limparTabelaEntradas();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquisa.");
        } else {
            pesquisarEntradaInterno("SELECT * FROM  ENTRADALOTE "
                    + "INNER JOIN ITENSENTRADA "
                    + "ON ENTRADALOTE.IdEntrada=ITENSENTRADA.IdEntrada "
                    + "INNER JOIN OPERACAO "
                    + "ON ENTRADALOTE.IdOp=OPERACAO.IdOp "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSENTRADA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jBtAuditoriaManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaManuActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEntradas objAudiManu = new TelaAuditoriaEntradas();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objAudiManu);
            objAudiManu.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objAudiManu);
            objAudiManu.show();
        }
    }//GEN-LAST:event_jBtAuditoriaManuActionPerformed

    private void jBtAudiItensEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudiItensEntradaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEntrada objItensAudi = new TelaAuditoriaItensEntrada();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objItensAudi);
            objItensAudi.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objItensAudi);
            objItensAudi.show();
        }
    }//GEN-LAST:event_jBtAudiItensEntradaActionPerformed

    private void jBtBuscarIntPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarIntPortariaActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoNovaEntradaCrc objPesqIntNovaEntP1 = new TelaPesqInternoNovaEntradaCrc();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objPesqIntNovaEntP1);
            objPesqIntNovaEntP1.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objPesqIntNovaEntP1);
            objPesqIntNovaEntP1.show();
            origemTriagem = "Sim";
        }
    }//GEN-LAST:event_jBtBuscarIntPortariaActionPerformed

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoEntradaCrc objPesqEntra = new TelaPesqInternoEntradaCrc();
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaModuloCRC.jPainelCRC.add(objPesqEntra);
            objPesqEntra.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objPesqEntra);
            objPesqEntra.show();
        }
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel FotoInternoCrc;
    public static javax.swing.JTextField jArtigo1;
    public static javax.swing.JTextField jArtigo2;
    public static javax.swing.JTextField jArtigo3;
    public static javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarlanc;
    private javax.swing.JButton jBtAudiItensEntrada;
    private javax.swing.JButton jBtAuditoriaManu;
    private javax.swing.JButton jBtBuscarIntPortaria;
    public static javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtCancelarlanc;
    private javax.swing.JButton jBtDataLanc;
    public static javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtExcluirlanc;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtNomeInterno;
    public static javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtNovolanc;
    private javax.swing.JButton jBtPesInterno;
    private javax.swing.JButton jBtPesqOperacao;
    private javax.swing.JButton jBtPesqUnidade;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtSairItens;
    public static javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarlanc;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JComboBox jComboBoxRegime;
    public static javax.swing.JComboBox jComboBoxSexo;
    public static javax.swing.JComboBox jComboBoxUnidPenal;
    public static com.toedter.calendar.JDateChooser jDataCondenacao;
    public static com.toedter.calendar.JDateChooser jDataCrime;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataLancamento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataPrisao;
    public static com.toedter.calendar.JDateChooser jDataTerminoPena;
    public static javax.swing.JTextField jDescricaoOp;
    public static javax.swing.JTextField jIDInterno;
    public static javax.swing.JTextField jIDLanc;
    private javax.swing.JTextField jIDPesqLan;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInterno;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jParagrafo1;
    public static javax.swing.JTextField jParagrafo2;
    public static javax.swing.JTextField jParagrafo3;
    public static javax.swing.JTextField jPena;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField jStatusEntrada;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaItensIterno;
    private javax.swing.JTable jTabelaLanLote;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarAdmissoesPSP() {

        conecta.abrirConexao();
        //MÉDICO
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_MEDICO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //ENFERMEIRA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_ENFERMEIRA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //JURIDICO
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOJURIDICO "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_JURIDICO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //PEDAGOGIA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_PEDAGOGIA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_PEDAGOGIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //PSICOLOGIA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOPSI "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_PSICOLOGIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //SERVIÇO SOCIAL
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_SERVICO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //ODONTOLOGIA
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTODONTO "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_ODONTOLOGIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //TERAPIA OCUPACIONAL
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOTERAPIA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_TERAPIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //EDUCAÇÃO FÍSICA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_EDUCACAO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarAdmissaoPortaEntrada(String interno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + interno + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_PE = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formatarCampos() {
        jTextAreaObs.setLineWrap(true);
        jTextAreaObs.setWrapStyleWord(true);
    }

    public void corCampo() {

        jDataLancamento.setBackground(Color.white);
        jIDLanc.setBackground(Color.white);
        jStatusEntrada.setBackground(Color.white);
        jDescricaoOp.setBackground(Color.white);
        jTextAreaObs.setBackground(Color.white);
        //
        jIDInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jComboBoxUnidPenal.setBackground(Color.white);
        jComboBoxSexo.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jDataCrime.setBackground(Color.white);
        jComboBoxRegime.setBackground(Color.white);
        jDataCondenacao.setBackground(Color.white);
        jDataPrisao.setBackground(Color.white);
        jPena.setBackground(Color.white);
        jArtigo1.setBackground(Color.white);
        jArtigo2.setBackground(Color.white);
        jArtigo3.setBackground(Color.white);
        jParagrafo1.setBackground(Color.white);
        jParagrafo2.setBackground(Color.white);
        jParagrafo3.setBackground(Color.white);
        jDataTerminoPena.setBackground(Color.white);
    }

    public void Novo() {

        //Formatar a data do campo com a do computador
        // SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        jDataLancamento.setCalendar(Calendar.getInstance());
        // Limpart os Campos
        jIDLanc.setText("");
        jStatusEntrada.setText("ABERTO");
        jDescricaoOp.setText("");
        jTextAreaObs.setText("");
        // Habilitar os campos para inclusão
        jDataLancamento.setEnabled(true);
        jDescricaoOp.setEnabled(!true);
        jBtPesqOperacao.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        // Habilitar os boitões de lançamento
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        // Aba de inclusão dos iternos
        //  jTabelaItensIterno.setVisible(!true); // Limpar a tabela de itens
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrc.setIcon(null);
        jComboBoxUnidPenal.setSelectedItem(null);
        jComboBoxSexo.setSelectedItem(null);
        jDataEntrada.setDate(null);
        jDataCrime.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataCondenacao.setDate(null);
        jDataPrisao.setDate(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerminoPena.setDate(null);
        //Habilta botões dos itens
        jBtNovolanc.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        limparTabelaItens();
    }

    public void Alterar() {

        jDataLancamento.setEnabled(true);
        jDescricaoOp.setEnabled(!true);
        jTextAreaObs.setEnabled(true);
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //Habilta botões dos itens
        jBtNovolanc.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);

    }

    public void Excluir() {
        // Limpart os Campos
        jIDLanc.setText("");
        jDescricaoOp.setText("");
        jTextAreaObs.setText("");
        // Habilitar os campos para inclusão
        jDataLancamento.setEnabled(!true);
        jDescricaoOp.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar os boitões de lançamento
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        // Aba de inclusão dos iternos
        jTabelaItensIterno.setVisible(!true); // Limpar a tabela de itens
        jIDInterno.setText("");
        jNomeInterno.setText("");
        jComboBoxUnidPenal.setSelectedItem(null);
        jComboBoxSexo.setSelectedItem(null);
        jDataEntrada.setDate(null);
        jDataCrime.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataCondenacao.setDate(null);
        jDataPrisao.setDate(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerminoPena.setDate(null);
    }

    public void Salvar() {

        // Desabilita os campos após gravar o registro
        jDataLancamento.setEnabled(!true);
        jDescricaoOp.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtNovoItem.setEnabled(true);
        jTabelaItensIterno.setVisible(true);
    }

    public void Cancelar() {

        // Habilitar os campos para inclusão
        jDataLancamento.setEnabled(!true);
        jDescricaoOp.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar os boitões de lançamento
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
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
            objEntLote.setStatusEntrada(statusEntrada);
            objEntLote.setIdLanc(Integer.parseInt(jIDLanc.getText()));
            control.finalizarEntradaLote(objEntLote);
            jStatusEntrada.setText(statusEntrada);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataEntrada.setEnabled(!true);
            jBtNovolanc.setEnabled(true);
            jBtAlterarlanc.setEnabled(!true);
            jBtExcluirlanc.setEnabled(!true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtNovoItem.setEnabled(!true);
        }
    }

    public void NovoItem() {
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrc.setIcon(null);
        // jComboBoxUnidPenal.setSelectedItem(null);
        jComboBoxUnidPenal.removeAllItems();
        jComboBoxSexo.setSelectedItem(null);
        jDataEntrada.setDate(null);
        jDataCrime.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataCondenacao.setDate(null);
        jDataPrisao.setDate(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerminoPena.setDate(null);
        //Habilta botões dos itens
        jBtNovolanc.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtBuscarIntPortaria.setEnabled(true);
        //
        jBtPesInterno.setEnabled(true);
        // Habilitar os campos para edição
        jComboBoxSexo.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jDataCrime.setEnabled(true);
        jComboBoxRegime.setEnabled(true);
        jDataCondenacao.setEnabled(true);
        jDataPrisao.setEnabled(true);
        jPena.setEnabled(true);
        jArtigo1.setEnabled(true);
        jArtigo2.setEnabled(true);
        jArtigo3.setEnabled(true);
        jParagrafo1.setEnabled(true);
        jParagrafo2.setEnabled(true);
        jParagrafo3.setEnabled(true);
        jDataTerminoPena.setEnabled(true);
        //
        jComboBoxUnidPenal.setEnabled(true);
        jBtPesqUnidade.setEnabled(true);
        jBtPesInterno.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void AlterarItem() {

        // Habilita os campos
        jComboBoxSexo.setEnabled(true);
        jComboBoxUnidPenal.setEnabled(true);
        jBtPesqUnidade.setEnabled(true);
        jBtPesInterno.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jDataCrime.setEnabled(true);
        jComboBoxRegime.setEnabled(true);
        jDataCondenacao.setEnabled(true);
        jDataPrisao.setEnabled(true);
        jPena.setEnabled(true);
        jArtigo1.setEnabled(true);
        jArtigo2.setEnabled(true);
        jArtigo3.setEnabled(true);
        jParagrafo1.setEnabled(true);
        jParagrafo2.setEnabled(true);
        jParagrafo3.setEnabled(true);
        jDataTerminoPena.setEnabled(true);
        // Habilta/Desabilita os botões        
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarItem.setEnabled(true);
        jBtPesquisarInterno.setEnabled(true);
        jBtBuscarIntPortaria.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void ExcluirItem() {

        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrc.setIcon(null);
        jComboBoxUnidPenal.removeAllItems();
        jComboBoxSexo.setSelectedItem(null);
        jDataEntrada.setDate(null);
        jDataCrime.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataCondenacao.setDate(null);
        jDataPrisao.setDate(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerminoPena.setDate(null);
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtBuscarIntPortaria.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);

    }

    public void SalvarItem() {
        //
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrc.setIcon(null);
        jComboBoxUnidPenal.removeAllItems();
        jComboBoxSexo.setSelectedItem(null);
        jDataEntrada.setDate(null);
        jDataCrime.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataCondenacao.setDate(null);
        jDataPrisao.setDate(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerminoPena.setDate(null);
        //
        flag = 1;
        jBtPesInterno.setEnabled(!true);
        jBtPesqUnidade.setEnabled(!true);
        jComboBoxUnidPenal.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jDataCrime.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jDataCondenacao.setEnabled(!true);
        jDataPrisao.setEnabled(!true);
        jPena.setEnabled(!true);
        jArtigo1.setEnabled(!true);
        jArtigo2.setEnabled(!true);
        jArtigo3.setEnabled(!true);
        jParagrafo1.setEnabled(!true);
        jParagrafo2.setEnabled(!true);
        jParagrafo3.setEnabled(!true);
        jDataTerminoPena.setEnabled(!true);
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtBuscarIntPortaria.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarItem() {
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrc.setIcon(null);
        jComboBoxUnidPenal.setSelectedItem("");
        jComboBoxSexo.setSelectedItem(null);
        jDataEntrada.setDate(null);
        jDataCrime.setDate(null);
        jComboBoxRegime.setSelectedItem(null);
        jDataCondenacao.setDate(null);
        jDataPrisao.setDate(null);
        jPena.setText("");
        jArtigo1.setText("");
        jArtigo2.setText("");
        jArtigo3.setText("");
        jParagrafo1.setText("");
        jParagrafo2.setText("");
        jParagrafo3.setText("");
        jDataTerminoPena.setDate(null);
        jBtPesInterno.setEnabled(!true);
        jBtPesqUnidade.setEnabled(!true);
        jComboBoxUnidPenal.setEnabled(!true);
        jComboBoxSexo.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jDataCrime.setEnabled(!true);
        jComboBoxRegime.setEnabled(!true);
        jDataCondenacao.setEnabled(!true);
        jDataPrisao.setEnabled(!true);
        jPena.setEnabled(!true);
        jArtigo1.setEnabled(!true);
        jArtigo2.setEnabled(!true);
        jArtigo3.setEnabled(!true);
        jParagrafo1.setEnabled(!true);
        jParagrafo2.setEnabled(!true);
        jParagrafo3.setEnabled(!true);
        jDataTerminoPena.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtBuscarIntPortaria.setEnabled(!true);
        // Habilitar os botões para manutenção
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
    }
// Buscar OPERAÇÃO

    public void buscarOperacao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OPERACAO WHERE TipoOp='" + tipo + "'");
            conecta.rs.first();
            do {
                jDescricaoOp.setText(conecta.rs.getString("DescricaoOp"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodasEntradas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADALOTE "
                    + "INNER JOIN OPERACAO "
                    + "ON ENTRADALOTE.IdOp = OPERACAO.IdOp");
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancaMov");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdEntrada"), dataBrasil, conecta.rs.getString("StatusEnt"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsEntrada")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLanLote.setModel(modelo);
        jTabelaLanLote.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLanLote.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLanLote.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaLanLote.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaLanLote.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaLanLote.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLanLote.getTableHeader().setReorderingAllowed(false);
        jTabelaLanLote.setAutoResizeMode(jTabelaLanLote.AUTO_RESIZE_OFF);
        jTabelaLanLote.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEntradas();
        conecta.desconecta();
    }

    public void limparTabelaEntradas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLanLote.setModel(modelo);
        jTabelaLanLote.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLanLote.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLanLote.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaLanLote.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaLanLote.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaLanLote.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLanLote.getTableHeader().setReorderingAllowed(false);
        jTabelaLanLote.setAutoResizeMode(jTabelaLanLote.AUTO_RESIZE_OFF);
        jTabelaLanLote.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaEntradas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaLanLote.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaLanLote.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaLanLote.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void buscarUnidade() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE ORDER BY DescricaoUnid");
            conecta.rs.first();
            do {
                jComboBoxUnidPenal.addItem(conecta.rs.getString("DescricaoUnid"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Matricula Penal", "Unidade Penal (Procedência)", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc"), conecta.rs.getString("DescricaoUnid"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensIterno.setModel(modelo);
        jTabelaItensIterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensIterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaItensIterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaItensIterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaItensIterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaItensIterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensIterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensIterno.setAutoResizeMode(jTabelaItensIterno.AUTO_RESIZE_OFF);
        jTabelaItensIterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Matricula Penal", "Unidade Penal (Procedência)", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensIterno.setModel(modelo);
        jTabelaItensIterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensIterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaItensIterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaItensIterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaItensIterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensIterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaItensIterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensIterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensIterno.setAutoResizeMode(jTabelaItensIterno.AUTO_RESIZE_OFF);
        jTabelaItensIterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaItensIterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensIterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
    //Buscar código de entrada

    public void buscarCodEnt() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADALOTE");
            conecta.rs.last();
            codEnt = conecta.rs.getInt("IdEntrada");
            jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdEntrada")));
            objEntLote.setIdLanc(Integer.valueOf(jIDLanc.getText()));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar LANÇAMENTO DE ENTRADA \nERRO: " + ex);
        }
    }
// Irá excluir o registro caso não exista internos relacionados a essa documento

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADA WHERE IdEntrada='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            codEntrada = conecta.rs.getString("IdEntrada");
            if (jIDLanc.getText().equals(codEntrada)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEntLote.setIdLanc(Integer.parseInt(jIDLanc.getText()));
                control.excluirEntradaLote(objEntLote);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherEntradasDatas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição ", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ENTRADALOTE "
                    + "INNER JOIN OPERACAO "
                    + "ON ENTRADALOTE.IdOp=OPERACAO.IdOp "
                    + "WHERE DataLancaMov BETWEEN'" + jDataPesqInicial.getDateFormatString() + "' AND '" + jDataPesFinal.getDateFormatString() + "'");
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancaMov");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getDate("IdEntrada"), dataBrasil, conecta.rs.getString("StatusEnt"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLanLote.setModel(modelo);
        jTabelaLanLote.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLanLote.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaLanLote.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaLanLote.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaLanLote.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLanLote.getTableHeader().setReorderingAllowed(false);
        jTabelaLanLote.setAutoResizeMode(jTabelaLanLote.AUTO_RESIZE_OFF);
        jTabelaLanLote.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEntradas();
        conecta.desconecta();
    }

    public void objItens() {

        objItens.setDataEntrada(jDataEntrada.getDate());
        objItens.setDataCrime(jDataCrime.getDate());
        objItens.setDataPrisao(jDataPrisao.getDate());
        objItens.setDataCondenacao(jDataCondenacao.getDate());
        objItens.setRegime((String) jComboBoxRegime.getSelectedItem());
        objItens.setPena(jPena.getText());
        objItens.setArtigo1(jArtigo1.getText());
        objItens.setArtigo2(jArtigo2.getText());
        objItens.setArtigo3(jArtigo3.getText());
        objItens.setParagrafo1(jParagrafo1.getText());
        objItens.setParagrafo2(jParagrafo2.getText());
        objItens.setParagrafo3(jParagrafo3.getText());
        objItens.setTerminoPena(jDataTerminoPena.getDate());
        // Para o log do registro
        objItens.setUsuarioInsert(nameUser);
        objItens.setDataInsert(dataModFinal);
        objItens.setHoraInsert(horaMov);
    }

    // Pesquisa de Lançamento por Código (ID)
    public void pesquisarLancCod(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancaMov");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdEntrada"), dataBrasil, conecta.rs.getString("StatusEnt"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLanLote.setModel(modelo);
        jTabelaLanLote.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaLanLote.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLanLote.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaLanLote.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaLanLote.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaLanLote.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLanLote.getTableHeader().setReorderingAllowed(false);
        jTabelaLanLote.setAutoResizeMode(jTabelaLanLote.AUTO_RESIZE_OFF);
        jTabelaLanLote.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void pesquisarEntradaInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancaMov");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdEntrada"), dataBrasil, conecta.rs.getString("StatusEnt"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaLanLote.setModel(modelo);
        jTabelaLanLote.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaLanLote.getColumnModel().getColumn(0).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(1).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaLanLote.getColumnModel().getColumn(2).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaLanLote.getColumnModel().getColumn(3).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(4).setPreferredWidth(130);
        jTabelaLanLote.getColumnModel().getColumn(4).setResizable(false);
        jTabelaLanLote.getColumnModel().getColumn(5).setPreferredWidth(390);
        jTabelaLanLote.getColumnModel().getColumn(5).setResizable(false);
        jTabelaLanLote.getTableHeader().setReorderingAllowed(false);
        jTabelaLanLote.setAutoResizeMode(jTabelaLanLote.AUTO_RESIZE_OFF);
        jTabelaLanLote.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarIdItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADA ");
            conecta.rs.last();
            codItemEnt = conecta.rs.getInt("IdItem");
            idItem = conecta.rs.getString("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void atualizarRolSaidaInterno() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIDInterno.getText() + "'AND StatusRol='" + statusRolFechado + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "ABERTO";
        objRol.setIdInterno(Integer.valueOf(jIDInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol(jDescricaoOp.getText());
        //  objRol.setObsRol(jOrigem.getText());
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String pTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserTRI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserTRI + "'");
            conecta.rs.first();
            codigoUserGroupTRI = conecta.rs.getInt("IdUsuario");
            codigoGrupoTRI = conecta.rs.getInt("IdGrupo");
            nomeGrupoTRI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserTRI + "' "
                    + "AND NomeTela='" + pTela + "'");
            conecta.rs.first();
            codUserAcessoTRI = conecta.rs.getInt("IdUsuario");
            codAbrirTRI = conecta.rs.getInt("Abrir");
            codIncluirTRI = conecta.rs.getInt("Incluir");
            codAlterarTRI = conecta.rs.getInt("Alterar");
            codExcluirTRI = conecta.rs.getInt("Excluir");
            codGravarTRI = conecta.rs.getInt("Gravar");
            codConcultarTRI = conecta.rs.getInt("Consultar");
            nomeTelaTRI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioCRC(String pTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserCRC = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserCRC + "'");
            conecta.rs.first();
            codigoUserGroupCRC = conecta.rs.getInt("IdUsuario");
            codigoGrupoCRC = conecta.rs.getInt("IdGrupo");
            nomeGrupoCRC = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserCRC + "' "
                    + "AND NomeTela='" + pTela + "'");
            conecta.rs.first();
            codUserAcessoCRC = conecta.rs.getInt("IdUsuario");
            codAbrirCRC = conecta.rs.getInt("Abrir");
            codIncluirCRC = conecta.rs.getInt("Incluir");
            codAlterarCRC = conecta.rs.getInt("Alterar");
            codExcluirCRC = conecta.rs.getInt("Excluir");
            codGravarCRC = conecta.rs.getInt("Gravar");
            codConsultarCRC = conecta.rs.getInt("Consultar");
            nomeTelaCRC = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
