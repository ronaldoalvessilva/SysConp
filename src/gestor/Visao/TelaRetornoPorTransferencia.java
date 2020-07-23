/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleItensEntradasLote;
import gestor.Controle.ControleItensRetornoPorTransferencia;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleNovaEntradaInternos;
import gestor.Controle.ControleRetornoPortariaCrc;
import gestor.Controle.ControleRetornoTransferencia;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControlePortaEntrada;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.ItensRetornoTransferencia;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RetornoPorTransferencia;
import gestor.Modelo.RetornoPortariaCrc;
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
import static gestor.Visao.TelaModuloCRC.telaRetornoTransInteCRC;
import static gestor.Visao.TelaModuloCRC.telaRetornoTransManuCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaPesqRegIntTransferencia.idItemRetornoAudiencia;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaRetornoPorTransferencia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoPorTransferencia objRetTrans = new RetornoPorTransferencia();
    ItensRetornoTransferencia objItensRetTrans = new ItensRetornoTransferencia();
    ControleMovInternos controlMov = new ControleMovInternos();
    ControleRetornoTransferencia control = new ControleRetornoTransferencia();
    ControleItensRetornoPorTransferencia controle = new ControleItensRetornoPorTransferencia();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleSituacao mod = new ControleSituacao();
    // ADICIONAR A NOVA DATA DE ENTRADA DO INTERNO - 11/07/2016
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    ControleNovaEntradaInternos controleNovaData = new ControleNovaEntradaInternos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    ControleRolVisitas controlRol = new ControleRolVisitas(); // Classe do Serviço social para FINALIZAR Rol quando interno sair da unidade
    RolVisitas objRol = new RolVisitas();
    //
    RetornoPortariaCrc objRetPortCrc = new RetornoPortariaCrc();
    ControleRetornoPortariaCrc controleRepostaCrc = new ControleRetornoPortariaCrc();
    //
    ControleItensEntradasLote controleKit = new ControleItensEntradasLote();
    //PORTA DE ENTRADA
    PortaEntrada objPortaEntrada = new PortaEntrada();
    ControlePortaEntrada control_PE = new ControlePortaEntrada();
    //
    String statusRol = "ABERTO"; // Se o Rol estiver ABERTO, irá ser FINALIZADO para não ser mostrado na lista do Rol na portaria
    String statusRolFechado = "FINALIZADO"; // Se o Rol estiver fechado e o usuário excluir, o Rol volta a ser ABERTO
    String observacaoRol; // Varivael que irá informar no Rol do Interno se ele está na unidade
    int idInternoRol; // Código do interno no Rol de Visitas.
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Movimentação:Retorno por Transferência de Internos:Manutenção";
    String nomeModuloTela2 = "CRC:Movimentação:Retorno por Transferência de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag;
    int acao;
    int codRet;
    int codItem = 0; // Código do Histórico de Movimetação MOVIMENTOCRC
    String tipo = "Retornos";
    String situacao = "RETORNO A UNIDADE"; // Máximo 19 caracteres   
    String dataInicial, dataFinal;
    String dataRetorno, dataBrasil;
    String codRetorno;
    public static String idItem;
    String nrDoc;
    String statusRetorno = "ABERTO";
    String origemRetornoEspontaneo = "RETORNO POR TRANSFERÊNCIA";
    String caminho;
    String confirmaRetorno;
    String confirmaExclusaoRetorno;
    int idRegistro; // Variável que impede o item de alterar quando importado do registro da portaria
    String codParametrosRetorno;
    int count = 0;
    //
    Date date = null;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String regime = "Semi-Aberto";
    // VARIAVEIS PARA AVISO DE RETORNO DO INTERNO
    String confirmacaoCrc = "Não";
    String respostaCrc = "Sim";
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
     * Creates new form TelaRetornoEspontaneo
     */
    public TelaRetornoPorTransferencia() {
        initComponents();
        corCampos();
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
        jLabel5 = new javax.swing.JLabel();
        jIDPesqLan = new javax.swing.JTextField();
        jBtDataLanc = new javax.swing.JButton();
        jBtIdLanc = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtNomeInterno = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaRetorno = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIDLanc = new javax.swing.JTextField();
        jStatusRetorno = new javax.swing.JTextField();
        jDataLancamento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jDescricaoOpe = new javax.swing.JTextField();
        jBtPesqOperacao = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jBtNovolanc1 = new javax.swing.JButton();
        jBtAlterarlanc1 = new javax.swing.JButton();
        jBtExcluirlanc1 = new javax.swing.JButton();
        jBtSalvarlanc1 = new javax.swing.JButton();
        jBtCancelarlanc1 = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDataRetorno = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jOrigem = new javax.swing.JTextField();
        jBtPesqInternos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jUnidadePenal = new javax.swing.JTextField();
        jBtPesqUnidadePenal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaItensInterno = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtSairItem = new javax.swing.JButton();
        jBtAudInternos = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        FotoInternoCrcRetEsp = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Retorno de Internos Por Transferência :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código:");

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDPesqLan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDPesqLanActionPerformed(evt);
            }
        });

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
        jLabel24.setText("Data  Final:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Data Inicial:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nome  Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomeInterno.setContentAreaFilled(false);
        jBtNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel25)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDataLanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRetorno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaRetorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"
            }
        ));
        jTabelaRetorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRetornoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaRetorno);
        if (jTabelaRetorno.getColumnModel().getColumnCount() > 0) {
            jTabelaRetorno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaRetorno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaRetorno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaRetorno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaRetorno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaRetorno.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaRetorno.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaRetorno.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaRetorno.getColumnModel().getColumn(4).setMinWidth(180);
            jTabelaRetorno.getColumnModel().getColumn(4).setMaxWidth(180);
            jTabelaRetorno.getColumnModel().getColumn(5).setMinWidth(280);
            jTabelaRetorno.getColumnModel().getColumn(5).setMaxWidth(280);
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabeçalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data:");

        jIDLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDLanc.setEnabled(false);

        jStatusRetorno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusRetorno.setEnabled(false);

        jDataLancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLancamento.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Operação:");

        jDescricaoOpe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoOpe.setEnabled(false);

        jBtPesqOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqOperacao.setContentAreaFilled(false);
        jBtPesqOperacao.setEnabled(false);
        jBtPesqOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqOperacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStatusRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDescricaoOpe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jDescricaoOpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqOperacao))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setRows(5);
        jTextAreaObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextAreaObs.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovolanc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovolanc1.setText("Novo");
        jBtNovolanc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovolanc1ActionPerformed(evt);
            }
        });

        jBtAlterarlanc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarlanc1.setText("Alterar");
        jBtAlterarlanc1.setEnabled(false);
        jBtAlterarlanc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarlanc1ActionPerformed(evt);
            }
        });

        jBtExcluirlanc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirlanc1.setText("Excluir");
        jBtExcluirlanc1.setEnabled(false);
        jBtExcluirlanc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirlanc1ActionPerformed(evt);
            }
        });

        jBtSalvarlanc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarlanc1.setText("Gravar");
        jBtSalvarlanc1.setEnabled(false);
        jBtSalvarlanc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarlanc1ActionPerformed(evt);
            }
        });

        jBtCancelarlanc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarlanc1.setText("Cancelar");
        jBtCancelarlanc1.setEnabled(false);
        jBtCancelarlanc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarlanc1ActionPerformed(evt);
            }
        });

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovolanc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarlanc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirlanc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarlanc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarlanc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovolanc1)
                        .addComponent(jBtAlterarlanc1)
                        .addComponent(jBtExcluirlanc1)
                        .addComponent(jBtSalvarlanc1)
                        .addComponent(jBtCancelarlanc1)
                        .addComponent(jBtFinalizar))
                    .addComponent(jBtAuditoria))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarlanc1, jBtCancelarlanc1, jBtExcluirlanc1, jBtNovolanc1, jBtSalvarlanc1});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Retorno");

        jDataRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRetorno.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tipo Retorno");

        jOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrigem.setEnabled(false);

        jBtPesqInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtPesqInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternos.setToolTipText("Pesquisar Registro de Retorno");
        jBtPesqInternos.setContentAreaFilled(false);
        jBtPesqInternos.setEnabled(false);
        jBtPesqInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Procedência");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jUnidadePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadePenal.setEnabled(false);

        jBtPesqUnidadePenal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqUnidadePenal.setToolTipText("Pesquisar Procedência");
        jBtPesqUnidadePenal.setContentAreaFilled(false);
        jBtPesqUnidadePenal.setEnabled(false);
        jBtPesqUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqUnidadePenalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel6)))
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaItensInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Data Retorno", "Procedência"
            }
        ));
        jTabelaItensInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaItensInterno);
        if (jTabelaItensInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaItensInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaItensInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaItensInterno.getColumnModel().getColumn(1).setMinWidth(60);
            jTabelaItensInterno.getColumnModel().getColumn(1).setMaxWidth(60);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMinWidth(210);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMaxWidth(210);
            jTabelaItensInterno.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(4).setMinWidth(200);
            jTabelaItensInterno.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jBtSairItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairItem.setText("Sair");
        jBtSairItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairItemActionPerformed(evt);
            }
        });

        jBtAudInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtAudInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudInternos.setText("Auditoria");
        jBtAudInternos.setEnabled(false);
        jBtAudInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudInternosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtAudInternos)
                    .addComponent(jBtSairItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSalvarItem)
                    .addComponent(jBtExcluirItem)
                    .addComponent(jBtAlterarItem)
                    .addComponent(jBtNovoItem))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItem, jBtAudInternos, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItem, jBtSalvarItem});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem)
                .addGap(8, 8, 8)
                .addComponent(jBtSalvarItem)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAudInternos)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtAudInternos, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItem, jBtSalvarItem});

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        FotoInternoCrcRetEsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrcRetEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotoInternoCrcRetEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(300, 20, 745, 496);
    }// </editor-fold>//GEN-END:initComponents

    private void jIDPesqLanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDPesqLanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDPesqLanActionPerformed

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
                        pesquisarLancCod("SELECT * FROM RETORNOTRANSFERENCIA "
                                + "INNER JOIN OPERACAO "
                                + "ON RETORNOMEDICO.IdOp=OPERACAO.IdOp "
                                + "WHERE DataLancRetorno BETWEEN'" + dataInicial + "' "
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
                        pesquisarLancCod("SELECT * FROM RETORNOTRANSFERENCIA "
                                + "INNER JOIN OPERACAO "
                                + "ON RETORNOMEDICO.IdOp=OPERACAO.IdOp "
                                + "WHERE DataLancRetorno BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        pesquisarLancCod("SELECT * FROM RETORNOTRANSFERENCIA "
                + "INNER JOIN OPERACAO "
                + "ON RETORNOTRANSFERENCIA.IdOp=OPERACAO.IdOp "
                + "WHERE IdRetorno='" + jIDPesqLan.getText() + "'");
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntradas();
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquuisa.");
        } else {
            pesquisarRecapturaInterno("SELECT * FROM  RETORNOTRANSFERENCIA "
                    + "INNER JOIN ITENSRETORNOTRANSFERENCIA "
                    + "ON RETORNOTRANSFERENCIA.IdRetorno=ITENSRETORNOTRANSFERENCIA.IdRetorno "
                    + "INNER JOIN OPERACAO "
                    + "ON RETORNOTRANSFERENCIA.IdOp=OPERACAO.IdOp "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSRETORNOTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jTabelaRetornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRetornoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRetorno.getValueAt(jTabelaRetorno.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            //
            jDataLancamento.setDate(jDataLancamento.getDate());
            jBtNovolanc1.setEnabled(!true);
            jBtAlterarlanc1.setEnabled(true);
            jBtExcluirlanc1.setEnabled(true);
            jBtSalvarlanc1.setEnabled(!true);
            jBtCancelarlanc1.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            //
            jDataRetorno.setDate(null);
            jIdInterno.setText("");
            jNomeInterno.setText("");
            FotoInternoCrcRetEsp.setIcon(null);
            jOrigem.setText("");
            jUnidadePenal.setText("");
            jBtPesqInternos.setEnabled(!true);
            jBtPesqUnidadePenal.setEnabled(!true);
            jDataRetorno.setDate(null);
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM RETORNOTRANSFERENCIA "
                        + "INNER JOIN OPERACAO "
                        + "ON RETORNOTRANSFERENCIA.IdOp=OPERACAO.IdOp "
                        + "WHERE IdRetorno='" + IdLanc + "'");
                conecta.rs.first();
                jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdRetorno")));
                jStatusRetorno.setText(conecta.rs.getString("StatusRet"));
                jDataLancamento.setDate(conecta.rs.getDate("DataLancRetorno"));
                jDescricaoOpe.setText(conecta.rs.getString("DescricaoOp"));
                jTextAreaObs.setText(conecta.rs.getString("ObsRetorno"));
                conecta.desconecta();
                preencherTabelaItens("SELECT * FROM ITENSRETORNOTRANSFERENCIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSRETORNOTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON ITENSRETORNOTRANSFERENCIA.IdUnid=UNIDADE.IdUnid "
                        + "WHERE IdRetorno='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
        }
    }//GEN-LAST:event_jTabelaRetornoMouseClicked

    private void jBtPesqOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqOperacaoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaOpRetornoPorTransf objPesqOpRetTrans = new TelaPesquisaOpRetornoPorTransf();
        TelaModuloCRC.jPainelCRC.add(objPesqOpRetTrans);
        objPesqOpRetTrans.show();
    }//GEN-LAST:event_jBtPesqOperacaoActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRetornoTransferencia objAudRetornoTrans = new TelaAuditoriaRetornoTransferencia();
        TelaModuloCRC.jPainelCRC.add(objAudRetornoTrans);
        objAudRetornoTrans.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM RETORNOTRANSFERENCIA WHERE IdRetorno='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            jStatusRetorno.setText(conecta.rs.getString("StatusRet"));
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtNovolanc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovolanc1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransManuCRC) && codIncluirCRC == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovolanc1ActionPerformed

    private void jBtAlterarlanc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarlanc1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransManuCRC) && codAlterarCRC == 1) {
            objRetTrans.setStatusRet(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarlanc1ActionPerformed

    private void jBtExcluirlanc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirlanc1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransManuCRC) && codExcluirCRC == 1) {
            objRetTrans.setStatusRet(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirlanc1ActionPerformed

    private void jBtSalvarlanc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarlanc1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransManuCRC) && codGravarCRC == 1) {
            if (jDescricaoOpe.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a descrição da operação de retorno");
                jDescricaoOpe.requestFocus();
            } else {
                if (jDataLancamento.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe da data de lançamento");
                    jDataLancamento.requestFocus();
                } else {
                    objRetTrans.setDataLancRetorno(jDataLancamento.getDate());
                    objRetTrans.setStatusRet(statusRetorno);
                    objRetTrans.setNomeOperacao(jDescricaoOpe.getText());
                    objRetTrans.setObsRetorno(jTextAreaObs.getText());
                    try {
                        if (acao == 1) {
                            objRetTrans.setNomeUsuarioInsert(nameUser);
                            objRetTrans.setDataInsert(jDataSistema.getText());
                            objRetTrans.setHoraInsert(jHoraSistema.getText());
                            control.incluirRetonoTransferencia(objRetTrans);
                            buscarCodRet();
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro INCLUIDO com sucesso, será necessário\nincluir os internos na aba (INTERNOS)\npara que possa ser registrado a movimentação.");
                            Salvar();
                        }
                        if (acao == 2) {
                            objRetTrans.setNomeUsuarioUpdate(nameUser);
                            objRetTrans.setDataUp(jDataSistema.getText());
                            objRetTrans.setHoraUp(jHoraSistema.getText());
                            objRetTrans.setIdRetorno(Integer.parseInt(jIDLanc.getText()));
                            control.alterarRetonoTransferencia(objRetTrans);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro ALTERADO com sucesso. Se necessário\n faça aleração dos internos na aba(INTERNOS)");
                            Salvar();
                        }
                        preencherTabelaItens("SELECT * FROM ITENSRETORNOTRANSFERENCIA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENSRETORNOTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível GRAVAR registro !!!\n" + e);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarlanc1ActionPerformed

    private void jBtCancelarlanc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarlanc1ActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarlanc1ActionPerformed

    private void jTabelaItensInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensInternoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 2);
            jNomeInterno.setText(nomeInterno);
            idItem = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAudInternos.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN ITENSRETORNOTRANSFERENCIA "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSRETORNOTRANSFERENCIA.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON ITENSRETORNOTRANSFERENCIA.IdUnid=UNIDADE.IdUnid "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                        + "AND IdRetorno='" + jIDLanc.getText() + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if(caminho != null){
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                FotoInternoCrcRetEsp.setIcon(i);
                FotoInternoCrcRetEsp.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoCrcRetEsp.getWidth(), FotoInternoCrcRetEsp.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInternoCrcRetEsp.getWidth(), FotoInternoCrcRetEsp.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInternoCrcRetEsp.setIcon(icon);
                }
                jOrigem.setText(conecta.rs.getString("OrigemRetorno"));
                jUnidadePenal.setText(conecta.rs.getString("DescricaoUnid"));
                idItem = conecta.rs.getString("IdItem");
                jDataRetorno.setDate(conecta.rs.getDate("DataRetorno"));
                idRegistro = conecta.rs.getInt("IdRegistro");
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensInternoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransInteCRC) && codIncluirCRC == 1) {
            objRetTrans.setStatusRet(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                verificarParamentrosCrc();
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
        buscarAcessoUsuario(telaRetornoTransInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransInteCRC) && codAlterarCRC == 1) {
            objRetTrans.setStatusRet(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (idRegistro != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo tem origem da portaria.\nPor medidas de segurança, você poderá exclui-lo e lançar novamente caso deseje.");
                } else {
                    verificarParamentrosCrc();
                    acao = 4;
                    flag = 1;
                    AlterarItem();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransInteCRC) && codExcluirCRC == 1) {
            confirmacaoCrc = "Sim";
            respostaCrc = "Não";
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objRetTrans.setStatusRet(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItensRetTrans.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensRetornoTransferencia(objItensRetTrans);
                    objItensRetTrans.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
                    controlMov.excluirMovRetornoTransferencia(objItensRetTrans);
                    // Modifica o registro do interno na tabela ITENSREGEISTRO caso o interno seja seja excluido do Retorno Audiencia do CRC 
                    confirmaExclusaoRetorno = "Não"; // Passa ser "Não" para atualizar a tabela ITENSREGISTRO - (PORTARIA)              
                    objItensRetTrans.setIdRegistro(idRegistro);
                    objItensRetTrans.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objItensRetTrans.setConfirmaRetorno(confirmaExclusaoRetorno);
                    controle.confirmaUtilizacaoItensRetornoTransferencia(objItensRetTrans);
                    // Atualiza o Rol para ABERTO quando usuario exclui o interno
                    atualizarRolSaidaInternoExcluir();
                    // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016
                    // LIMPA A DATA PARA ATUALIZAR O CADASTRO DO INTERNO
                    jDataRetorno.setDate(null);
                    objDadosPena.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objDadosPena.setDataNovaEntrada(jDataRetorno.getDate());
                    controleNovaData.incluirDataNovaEntrada(objDadosPena);
                    // ATUALIZAR TABELA DE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS COMO "Sim"
                    objRetPortCrc.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objRetPortCrc.setConfirmaCrc(confirmacaoCrc); // CONFIRMAÇÃO ESTÁ COM "Não"
                    objRetPortCrc.setRespostaCrc(respostaCrc); // RESPOSTA ESTÁ COMO "Sim"
                    controleRepostaCrc.alterarRespostaRetornoInterno(objRetPortCrc);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENSRETORNOTRANSFERENCIA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSRETORNOTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN UNIDADE "
                            + "ON ITENSRETORNOTRANSFERENCIA.IdUnid=UNIDADE.IdUnid "
                            + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTransInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTransInteCRC) && codGravarCRC == 1) {
            confirmaRetorno = "Sim";
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do interno não pode ser em branco\nfaça uma pesquisa para preencher nome do interno");
                jNomeInterno.requestFocus();
            } else if (jUnidadePenal.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a Procedência do Interno.");
            } else {
                objItensRetTrans.setIdInternoCrc(Integer.parseInt(jIdInterno.getText()));
                objItensRetTrans.setNomeInterno(jNomeInterno.getText());
                objItensRetTrans.setDataRetorno(jDataRetorno.getDate());
                objItensRetTrans.setOrigemRetorno(origemRetornoEspontaneo);
                objProCrc.setSituacao(situacao);
                // Para o log do registro
                objItensRetTrans.setUsuarioInsert(nameUser);
                objItensRetTrans.setDataInsert(dataModFinal);
                objItensRetTrans.setHoraInsert(horaMov);
                try {
                    if (acao == 3) {
                        objItensRetTrans.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                        objItensRetTrans.setIdRegistro(idItemRetornoAudiencia); // Grava o iditem para impedir de alterar, informado ao usuário para excluir e lançar novamente
                        objItensRetTrans.setDescricaoUnidade(jUnidadePenal.getText());
                        controle.incluirItensRetornoTransferencia(objItensRetTrans);
                        //
                        objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                        mod.alterarSituacaoInterno(objProCrc);
                        objItensRetTrans.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                        buscarIdItem();
                        objItensRetTrans.setIdItem(codItem);
                        controlMov.incluirMovRetornoTransferencia(objItensRetTrans);
                        //
                        objItensRetTrans.setConfirmaRetorno(confirmaRetorno);
                        objItensRetTrans.setIdItem(idItemRetornoAudiencia);
                        objItensRetTrans.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objItensRetTrans.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
                        controle.alterarRegItensRetornoTransferenciaPortaria(objItensRetTrans);
                        //
                        atualizarRolSaidaInterno();
                        // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016               
                        objDadosPena.setDataNovaEntrada(jDataRetorno.getDate());
                        objDadosPena.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        controleNovaData.incluirDataNovaEntrada(objDadosPena);
                        // ATUALIZAR TABELA DE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS COMO "Sim"
                        objRetPortCrc.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objRetPortCrc.setConfirmaCrc(confirmacaoCrc); // CONFIRMAÇÃO ESTÁ COM "Não"
                        objRetPortCrc.setRespostaCrc(respostaCrc); // RESPOSTA ESTÁ COMO "Sim"
                        controleRepostaCrc.alterarRespostaRetornoInterno(objRetPortCrc);
                        // INFORMAR OPÇÕES DO KIT DE HIGIENE INICIAL
                        pagtoKit = "Não";
                        objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                        objProCrc.setNomeInterno(jNomeInterno.getText());
                        objProCrc.setDataChegada(jDataRetorno.getDate());
                        objProCrc.setKitPago(pagtoKit);
                        objProCrc.setUtilizado(pagtoKit);
                        controleKit.informarkitHigiene(objProCrc);
                        //PORTA DE ENTRADA, HABILITAR A NOVA ADMISSÃO PARA O INTERNO, CASO ELE JÁ TENHA.
                        verificarAdmissoesPSP();
                        verificarAdmissaoPortaEntrada(jIdInterno.getText());
                        //SE EXISTIR NA TABELA ADMISSAOMEDICA
                        if (jIdInterno.getText().equals(pID_INTERNO_MEDICO)) {
                            //ALTERAR PORTA DE ENTRADA   
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_ENFERMEIRA)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_JURIDICO)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_PEDAGOGIA)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_PSICOLOGIA)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_SERVICO)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_ODONTOLOGIA)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        } else if (jIdInterno.getText().equals(pID_INTERNO_TERAPIA)) {
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                            if (jIdInterno.getText().equals(pCODIGO_INTERNO_PE)) {
                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
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
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys);
                        preencherTabelaItens("SELECT * FROM ITENSRETORNOTRANSFERENCIA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENSRETORNOTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN UNIDADE "
                                + "ON ITENSRETORNOTRANSFERENCIA.IdUnid=UNIDADE.IdUnid "
                                + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                        SalvarItem();
                        JOptionPane.showMessageDialog(rootPane, "Registro incluido com sucesso.");
                    }
                    if (acao == 4) {
                        // Para o log do registro
                        objItensRetTrans.setUsuarioUp(nameUser);
                        objItensRetTrans.setDataUp(jDataSistema.getText());
                        objItensRetTrans.setHoraUp(jHoraSistema.getText());
                        objItensRetTrans.setDescricaoUnidade(jUnidadePenal.getText());
                        objItensRetTrans.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                        objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                        objItensRetTrans.setIdItem(Integer.valueOf(idItem));
                        controle.alterarItensRetornoTransferencia(objItensRetTrans);
                        objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                        mod.alterarSituacaoInterno(objProCrc);
                        objItensRetTrans.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                        controlMov.alterarMovRetornoTransferencia(objItensRetTrans);
                        // ATUALIZAR OS DADOS PENAIS COM A NOVA DA DE ENTRADA - 11/07/2016                
                        objDadosPena.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objDadosPena.setDataNovaEntrada(jDataRetorno.getDate());
                        controleNovaData.incluirDataNovaEntrada(objDadosPena);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys);
                        preencherTabelaItens("SELECT * FROM ITENSRETORNOTRANSFERENCIA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENSRETORNOTRANSFERENCIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN UNIDADE "
                                + "ON ITENSRETORNOTRANSFERENCIA.IdUnid=UNIDADE.IdUnid "
                                + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                        SalvarItem();
                        JOptionPane.showMessageDialog(rootPane, "Registro alterado com sucesso.");
                    }
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro \nERRO :" + e);
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

    private void jBtSairItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairItemActionPerformed
        // TODO add your handling code here:
        if (jStatusRetorno.getText().equals("ABERTO") && !jIDLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não esqueça de finalizar o documento para concluir a operação.");
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja FINALIZAR o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Finalizar();
            }
            dispose();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jBtSairItemActionPerformed

    private void jBtAudInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensRetornoTransferencia objAudInternosRetTrans = new TelaAuditoriaItensRetornoTransferencia();
        TelaModuloCRC.jPainelCRC.add(objAudInternosRetTrans);
        objAudInternosRetTrans.show();
    }//GEN-LAST:event_jBtAudInternosActionPerformed

    private void jBtPesqInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternosActionPerformed
        // TODO add your handling code here:
        TelaPesqRegIntTransferencia objRetTransInternoP1 = new TelaPesqRegIntTransferencia();
        TelaModuloCRC.jPainelCRC.add(objRetTransInternoP1);
        objRetTransInternoP1.show();
    }//GEN-LAST:event_jBtPesqInternosActionPerformed

    private void jBtPesqUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqUnidadePenalActionPerformed
        // TODO add your handling code here:
        TelaPesquisaUnididadeRetorno objUnid = new TelaPesquisaUnididadeRetorno();
        TelaModuloCRC.jPainelCRC.add(objUnid);
        objUnid.show();
    }//GEN-LAST:event_jBtPesqUnidadePenalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel FotoInternoCrcRetEsp;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarlanc1;
    private javax.swing.JButton jBtAudInternos;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtCancelarlanc1;
    private javax.swing.JButton jBtDataLanc;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtExcluirlanc1;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtNomeInterno;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtNovolanc1;
    private javax.swing.JButton jBtPesqInternos;
    private javax.swing.JButton jBtPesqOperacao;
    private javax.swing.JButton jBtPesqUnidadePenal;
    private javax.swing.JButton jBtSairItem;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarlanc1;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDataLancamento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataRetorno;
    public static javax.swing.JTextField jDescricaoOpe;
    public static javax.swing.JTextField jIDLanc;
    private javax.swing.JTextField jIDPesqLan;
    public static javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jOrigem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusRetorno;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaItensInterno;
    private javax.swing.JTable jTabelaRetorno;
    private javax.swing.JTextArea jTextAreaObs;
    public static javax.swing.JTextField jUnidadePenal;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarAdmissoesPSP() {

        conecta.abrirConexao();
        //MÉDICO
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_MEDICO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //ENFERMEIRA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOENFERMEIRA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_ENFERMEIRA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //JURIDICO
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOJURIDICO "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_JURIDICO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //PEDAGOGIA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_PEDAGOGIA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_PEDAGOGIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //PSICOLOGIA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOPSI "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_PSICOLOGIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //SERVIÇO SOCIAL
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_SERVICO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //ODONTOLOGIA
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTODONTO "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_ODONTOLOGIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //TERAPIA OCUPACIONAL
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOTERAPIA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            pID_INTERNO_TERAPIA = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        //EDUCAÇÃO FÍSICA
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
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

    public void bloquearCamposPesquisa() {
        jIDLanc.setEnabled(!true);
        jStatusRetorno.setEnabled(!true);
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jOrigem.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        jDataLancamento.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jDataRetorno.setEnabled(!true);
        jIdInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        //
        jBtPesqOperacao.setEnabled(!true);
        jBtPesqInternos.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAudInternos.setEnabled(!true);
    }

    public void corCampos() {
        jIDLanc.setBackground(Color.white);
        jStatusRetorno.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jDescricaoOpe.setBackground(Color.white);
        jOrigem.setBackground(Color.white);
        jTextAreaObs.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jTextAreaObs.setBackground(Color.white);
        //
        jDataRetorno.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jUnidadePenal.setBackground(Color.white);
    }

    public void Novo() {
        if (jIDLanc.getText().equals("")) {
            jIDLanc.setText("");
            jStatusRetorno.setText("");
            jDataLancamento.setCalendar(Calendar.getInstance());
            jDescricaoOpe.setText("");
            jTextAreaObs.setText("");
            limparTabelaItens();
        }
        // Limpar campos para inclusão
        jIDLanc.setText("");
        jStatusRetorno.setText("ABERTO");
        jDataLancamento.setCalendar(Calendar.getInstance());
        jDescricaoOpe.setText("");
        jTextAreaObs.setText("");
        jDataLancamento.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc1.setEnabled(!true);
        jBtAlterarlanc1.setEnabled(!true);
        jBtExcluirlanc1.setEnabled(!true);
        jBtSalvarlanc1.setEnabled(true);
        jBtCancelarlanc1.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAudInternos.setEnabled(!true);
        limparTabelaItens();
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcRetEsp.setIcon(null);
        jOrigem.setText("");
        jUnidadePenal.setText("");
        //
        jBtPesqInternos.setEnabled(true);
        jDataRetorno.setDate(null);
    }

    public void Alterar() {

        jDataLancamento.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc1.setEnabled(!true);
        jBtAlterarlanc1.setEnabled(!true);
        jBtExcluirlanc1.setEnabled(!true);
        jBtSalvarlanc1.setEnabled(true);
        jBtCancelarlanc1.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Excluir() {
        //Limpar campos
        jIDLanc.setText("");
        jDataLancamento.setDate(null);
        jDescricaoOpe.setText("");
        jTextAreaObs.setText("");
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc1.setEnabled(true);
        jBtAlterarlanc1.setEnabled(!true);
        jBtExcluirlanc1.setEnabled(!true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Salvar() {
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc1.setEnabled(true);
        jBtAlterarlanc1.setEnabled(true);
        jBtExcluirlanc1.setEnabled(true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        jBtNovoItem.setEnabled(true);
    }

    public void Cancelar() {
        if (jIDLanc.getText().equals("")) {
            jIDLanc.setText("");
            jStatusRetorno.setText("");
            jDataLancamento.setCalendar(Calendar.getInstance());
            jDescricaoOpe.setText("");
            jTextAreaObs.setText("");
            limparTabelaItens();
        }
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc1.setEnabled(true);
        jBtAlterarlanc1.setEnabled(!true);
        jBtExcluirlanc1.setEnabled(!true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse retorno de internos for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o LANÇAMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            // ATUALIZAR DADOS NA TABELA DADOSPENAISINTERNOS            
            atualizarProntuarioInterno();
            objRetTrans.setStatusRet(statusEntrada);
            objRetTrans.setIdRetorno(Integer.parseInt(jIDLanc.getText()));
            control.finalizarRetonoTransferencia(objRetTrans);
            jStatusRetorno.setText(statusEntrada);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataLancamento.setEnabled(!true);
            jBtNovolanc1.setEnabled(true);
            jBtAlterarlanc1.setEnabled(!true);
            jBtExcluirlanc1.setEnabled(!true);
            jBtSalvarlanc1.setEnabled(!true);
            jBtCancelarlanc1.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtNovoItem.setEnabled(!true);
        }
    }

    public void NovoItem() {
        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcRetEsp.setIcon(null);
        jOrigem.setText(origemRetornoEspontaneo);
        jUnidadePenal.setText("");
        //
        jBtPesqInternos.setEnabled(true);
        jBtPesqUnidadePenal.setEnabled(true);
        jDataRetorno.setCalendar(Calendar.getInstance());
        jDataRetorno.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAudInternos.setEnabled(!true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc1.setEnabled(!true);
        jBtAlterarlanc1.setEnabled(!true);
        jBtExcluirlanc1.setEnabled(!true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void AlterarItem() {
        jBtPesqInternos.setEnabled(true);
        jBtPesqUnidadePenal.setEnabled(true);
        //Habilitar os campos       
        jDataRetorno.setEnabled(true);
        // Habilitar os botões
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAudInternos.setEnabled(!true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc1.setEnabled(!true);
        jBtAlterarlanc1.setEnabled(!true);
        jBtExcluirlanc1.setEnabled(!true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirItem() {

        // Desabilitar Campos
        jBtPesqInternos.setEnabled(!true);
        jBtPesqUnidadePenal.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcRetEsp.setIcon(null);
        jOrigem.setText("");
        jUnidadePenal.setText("");
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtAudInternos.setEnabled(!true);
        jBtPesqInternos.setEnabled(!true);
    }

    public void SalvarItem() {

        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcRetEsp.setIcon(null);
        jOrigem.setText("");
        jUnidadePenal.setText("");
        // Desabilitar Campos
        jBtPesqInternos.setEnabled(!true);
        jBtPesqUnidadePenal.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAudInternos.setEnabled(!true);
        jBtPesqInternos.setEnabled(!true);
        //
        jBtNovolanc1.setEnabled(true);
        jBtAlterarlanc1.setEnabled(true);
        jBtExcluirlanc1.setEnabled(true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);

    }

    public void CancelarItem() {
        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcRetEsp.setIcon(null);
        jOrigem.setText("");
        jUnidadePenal.setText("");
        //Habilitar/Desabilitar campos
        jDataRetorno.setEnabled(!true);
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesqUnidadePenal.setEnabled(!true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc1.setEnabled(true);
        jBtAlterarlanc1.setEnabled(true);
        jBtExcluirlanc1.setEnabled(true);
        jBtSalvarlanc1.setEnabled(!true);
        jBtCancelarlanc1.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtAudInternos.setEnabled(true);
        jBtPesqInternos.setEnabled(!true);
    }

    public void atualizarProntuarioInterno() {

        for (int i = 0; i < jTabelaItensInterno.getRowCount(); i++) {
            objItensRetTrans.setRegime(regime);
            objItensRetTrans.setIdInternoCrc((int) jTabelaItensInterno.getValueAt(i, 1));
            try {
                // Converte a data de string para date, para ser inserido no banco de dados.
                date = (java.util.Date) formatter.parse((String) jTabelaItensInterno.getValueAt(i, 3));
            } catch (ParseException ex) {
            }
            objItensRetTrans.setDescricaoUnidade((String) jTabelaItensInterno.getValueAt(i, 4));
            objItensRetTrans.setDataRetorno(date);
            controle.alterarProntuarioRetronoTransferencia(objItensRetTrans);
        }
    }

    // Verificar se existe itens na saida do interno
    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSRETORNOTRANSFERENCIA WHERE IdRetorno='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            codRetorno = conecta.rs.getString("IdRetorno");
            if (jIDLanc.getText().equals(codRetorno)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objRetTrans.setIdRetorno(Integer.parseInt(jIDLanc.getText()));
                control.excluirRetonoTransferencia(objRetTrans);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel EXCLUIR Lançamento...\nERRO :" + ex);
            }
        }
    }

    public void preencherTodasEntradas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM RETORNOTRANSFERENCIA "
                    + "INNER JOIN OPERACAO "
                    + "ON RETORNOTRANSFERENCIA.IdOp=OPERACAO.IdOp");
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancRetorno");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRetorno"), dataBrasil, conecta.rs.getString("StatusRet"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void pesquisarLancCod(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição ", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancRetorno");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRetorno"), dataBrasil, conecta.rs.getString("StatusRet"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void pesquisarRecapturaInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Operação", "Descrição", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancRetorno");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRetorno"), dataBrasil, conecta.rs.getString("StatusRet"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(130);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(390);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRetorno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRetorno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaRetorno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Retorno", "Procedência"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataRetorno = conecta.rs.getString("DataRetorno");
                String dia = dataRetorno.substring(8, 10);
                String mes = dataRetorno.substring(5, 7);
                String ano = dataRetorno.substring(0, 4);
                dataRetorno = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataRetorno, conecta.rs.getString("DescricaoUnid")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensInterno.setModel(modelo);
        jTabelaItensInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaItensInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(2).setPreferredWidth(210);
        jTabelaItensInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaItensInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaItensInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensInterno.setAutoResizeMode(jTabelaItensInterno.AUTO_RESIZE_OFF);
        jTabelaItensInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Retorno", "Procedência"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensInterno.setModel(modelo);
        jTabelaItensInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaItensInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(2).setPreferredWidth(210);
        jTabelaItensInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaItensInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaItensInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensInterno.setAutoResizeMode(jTabelaItensInterno.AUTO_RESIZE_OFF);
        jTabelaItensInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaItensInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaItensInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    //Buscar código de Retorno
    public void buscarCodRet() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM RETORNOTRANSFERENCIA");
            conecta.rs.last();
            codRet = conecta.rs.getInt("IdRetorno");
            jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdRetorno")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar LANÇAMENTO DE RETORNO \nERRO: " + ex);
        }
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
            conecta.executaSQL("SELECT * FROM ITENSRETORNOTRANSFERENCIA");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarParamentrosCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            codParametrosRetorno = conecta.rs.getString("RetornosPortaria");
        } catch (SQLException ex) {
        }
    }

    // FINALIZA o Rol do interno quando o mesmo sair da unidade
    public void atualizarRolSaidaInterno() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIdInterno.getText() + "'AND StatusRol='" + statusRolFechado + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "ABERTO";
        objRol.setIdInterno(Integer.valueOf(jIdInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol(jDescricaoOpe.getText());
        //  objRol.setObsRol(jOrigem.getText());
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    // Se o usuário excluir o interno da saida da portaria, atualiza o status do Rol para ABERTO
    public void atualizarRolSaidaInternoExcluir() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIdInterno.getText() + "'AND StatusRol='" + statusRol + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "FINALIZADO";
        objRol.setIdInterno(Integer.valueOf(jIdInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol("");
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
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
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
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
