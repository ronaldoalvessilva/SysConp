/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtendimentoGrupoEnfermagem;
import gestor.Controle.ControleAtendimentoGrupoPsicologia;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AtividadesGrupoPsicologia;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.botaoLiberar_ENF;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAtendimentoGrupoENF_Manu;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAtendimentoGrupoENF_Plan;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAtendimentoGrupoENF_Inte;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAtendimentoGrupoENF_AVG;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAtendimentoGrupoENF_AVI;

/**
 *
 * @author Socializa TI 02
 */
public class TelaAtendimentoGrupoENF extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesGrupoPsicologia objAvalia = new AtividadesGrupoPsicologia();
    ControleAtendimentoGrupoEnfermagem control = new ControleAtendimentoGrupoEnfermagem();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Enfermaria:Atendimento em Grupo:Manutenção";
    String nomeModuloTela2 = "Enfermaria:Atendimento em Grupo:Planejamento";
    String nomeModuloTela3 = "Enfermaria:Atendimento em Grupo:Participantes";
    String nomeModuloTela4 = "Enfermaria:Atendimento em Grupo:Avaliação em Grupo";
    String nomeModuloTela5 = "Enfermaria:Atendimento em Grupo:Avaliação Individual";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int flag;
    int count = 0;
    public static int count0 = 0;
    public static int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int acao = 0;
    String dataInicial, dataFinal, dataEntrada, dataEvolucao;
    String nomeUserRegistro;
    String pCODIGO_PLAN;
    public static int pCODIGO_ITEM_PARTICIPANTE = 0;
    String pCODIGO_PART;
    String caminho;
    public static int pCODIGO_AVALIACAO_GRUPO = 0;
    int pCODIGO_AVALIACAO_INDIVIDUAL = 0;
    public static int pCODIGO_AVALIACAO_GRUPO_AVG = 0; // CÓDIGO DA AVALIAÇÃO EXISTENTE, PARA NÃO SER GRAVADA DUAS PARA A MESMA ATIVIDADE
    public static int pCODIGO_AVALIACAO_GRUPO_AVGI = 0;
    String pCODIGO_AVI;
    //
    String pCODIGO_ATENDE_PLAN = "";
    String pCODIGO_ATENDE_PART = "";
    String pCODIGO_ATENDE_AVAG = "";
    String pCODIGO_ATENDE_AVAI = "";
    //
    public static String idItem;
    String pSIGLA = "EN";

    /**
     * Creates new form TelaAtendimentoGrupoPSI
     */
    public static TelaLiberacaoAtendimentoGruposENF pATENDE_GRUPO;
    public static TelaSelecaoLoteInternosAG_ENF pPESQUISA_LOTE;

    public TelaAtendimentoGrupoENF() {
        initComponents();
        corCampos();
        formatarCampos();
    }

    public void mostrarTelaAG() {
        pATENDE_GRUPO = new TelaLiberacaoAtendimentoGruposENF(this, true);
        pATENDE_GRUPO.setVisible(true);
    }

    public void mostrarPesquisaLote() {
        pPESQUISA_LOTE = new TelaSelecaoLoteInternosAG_ENF(this, true);
        pPESQUISA_LOTE.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGrupo = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jListagem = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jIDPesq = new javax.swing.JTextField();
        jBtIDPesq = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesquisarInternos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaAdmissaoPsicologica = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jManutencao = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jCodigoAtend = new javax.swing.JTextField();
        jDataAtend = new com.toedter.calendar.JDateChooser();
        jLabel55 = new javax.swing.JLabel();
        jStatusAtend = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jResponsavel = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jComboBoxPavilhaoGaleria = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jHorarioInicio = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jHorarioTermino = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLocalAtividade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxAmbiente = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jGrupoAtividade = new javax.swing.JTextField();
        jObservacao = new javax.swing.JTextField();
        jComboBoxNivelPavilhao = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jPlanejamento = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jAtividades = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jRecursos = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jHorarioInicialTema = new javax.swing.JFormattedTextField();
        jHorarioFinalTema = new javax.swing.JFormattedTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCodigoTema = new javax.swing.JTextField();
        jComboBoxTema = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jComboBoxTipoVacina = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jRBPrimeira = new javax.swing.JRadioButton();
        jRBSegunda = new javax.swing.JRadioButton();
        jRBTerceira = new javax.swing.JRadioButton();
        jRBReforco = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaPlanejamento = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jBtNovoPlan = new javax.swing.JButton();
        jBtAlterarPlan = new javax.swing.JButton();
        jBtExcluirPlan = new javax.swing.JButton();
        jBtSalvarPlan = new javax.swing.JButton();
        jBtCancelarPlan = new javax.swing.JButton();
        jBtAuditoriaPlan = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jtotalRegistrosPlanejamento = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jParticipantes = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jNomeInternoGrp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtPesquisarPart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRegime = new javax.swing.JTextField();
        jIdInternoGrp = new javax.swing.JTextField();
        jCNC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPavilhao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCela = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jNomeMae = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jBtNovoParticipantes = new javax.swing.JButton();
        jBtAlterarParticipantes = new javax.swing.JButton();
        jBtExcluirParticipantes = new javax.swing.JButton();
        jBtSalvarParticipantes = new javax.swing.JButton();
        jBtCancelarParticipantes = new javax.swing.JButton();
        jBtAuditoriaParticipantes = new javax.swing.JButton();
        jBtPesquisaLote = new javax.swing.JButton();
        jBtLocalizarInterno = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jtotalRegistrosInternos = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jAGlobal = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextoAvaliacaoGrupo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jBtNovoAvGrupo = new javax.swing.JButton();
        jBtAlterarAvGrupo = new javax.swing.JButton();
        jBtExcluirAvGrupo = new javax.swing.JButton();
        jBtSalvarAvGrupo = new javax.swing.JButton();
        jBtCancelarAvGrupo = new javax.swing.JButton();
        jBtSairAvGrupo = new javax.swing.JButton();
        jBtAuditoriaAvGrupo = new javax.swing.JButton();
        jAIndividual = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jIdInternoAI = new javax.swing.JTextField();
        jCNCAI = new javax.swing.JTextField();
        jRegimeAVI = new javax.swing.JTextField();
        jNomeInternoAVI = new javax.swing.JTextField();
        jNomeMaeInternoAVI = new javax.swing.JTextField();
        jBtPesqInternoAVI = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextoAvalaicaoIndividual = new javax.swing.JTextArea();
        jPanel16 = new javax.swing.JPanel();
        jBtNovoAvInd = new javax.swing.JButton();
        jBtAlterarAvInd = new javax.swing.JButton();
        jBtExcluirAvInd = new javax.swing.JButton();
        jBtSalvarAvInd = new javax.swing.JButton();
        jBtCancelarAvInd = new javax.swing.JButton();
        jBtAuditoriaAvInd = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTabelaInternosAvIndividual = new javax.swing.JTable();
        jPanel47 = new javax.swing.JPanel();
        jtotalRegistrosInternosAVI = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jFotoInternoGrupo = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jBtLiberar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtLiberador = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Atendimento em Grupo Médico/Enfermagem :::...");

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jListagem.setToolTipText("Listagem");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Código:");

        jIDPesq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIDPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIDPesq.setContentAreaFilled(false);
        jBtIDPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIDPesqActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisarInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInternos.setContentAreaFilled(false);
        jBtPesquisarInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternosActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jBtPesquisarInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesqDatas, jBtPesquisarInternos});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIDPesq)
                    .addComponent(jCheckBox1))
                .addGap(3, 3, 3)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addGap(3, 3, 3)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarInternos)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAdmissaoPsicologica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdmissaoPsicologica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Pavilhão", "Local Atividade"
            }
        ));
        jTabelaAdmissaoPsicologica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdmissaoPsicologicaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaAdmissaoPsicologica);
        if (jTabelaAdmissaoPsicologica.getColumnModel().getColumnCount() > 0) {
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setMaxWidth(200);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setMaxWidth(250);
        }

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jListagemLayout = new javax.swing.GroupLayout(jListagem);
        jListagem.setLayout(jListagemLayout);
        jListagemLayout.setHorizontalGroup(
            jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jListagemLayout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jListagemLayout.setVerticalGroup(
            jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Listagem", jListagem);

        jManutencao.setToolTipText("Manutenção");

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Código");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Data");

        jCodigoAtend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoAtend.setEnabled(false);

        jDataAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtend.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Status");

        jStatusAtend.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAtend.setForeground(new java.awt.Color(204, 0, 0));
        jStatusAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAtend.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusAtend.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Responsável");

        jResponsavel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jResponsavel.setForeground(new java.awt.Color(0, 0, 204));
        jResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jResponsavel.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        jResponsavel.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jResponsavel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCodigoAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jStatusAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataAtend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel51))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel50)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
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

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jBtNovo)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluir)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvar)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jBtCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtAlterar)
                                .addComponent(jBtExcluir)
                                .addComponent(jBtSalvar)))
                        .addGap(163, 163, 163))))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtSair)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Pavilhão/Galeria");

        jComboBoxPavilhaoGaleria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhaoGaleria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPavilhaoGaleria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhaoGaleria.setEnabled(false);
        jComboBoxPavilhaoGaleria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPavilhaoGaleriaItemStateChanged(evt);
            }
        });
        jComboBoxPavilhaoGaleria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxPavilhaoGaleriaMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Observação");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("H. Inicio");

        jHorarioInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioInicio.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("H. Termino");

        jHorarioTermino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioTermino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioTermino.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Local da Atividade");

        jLocalAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLocalAtividade.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Ambiente da Atividade");

        jComboBoxAmbiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAmbiente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Dentro da Unidade Prisional", "Fora da  Unidade Prisional" }));
        jComboBoxAmbiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAmbiente.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Grupo de Atividade");

        jGrupoAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jGrupoAtividade.setEnabled(false);

        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);

        jComboBoxNivelPavilhao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNivelPavilhao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));
        jComboBoxNivelPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNivelPavilhao.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("PV");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAmbiente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLocalAtividade)
                    .addComponent(jGrupoAtividade)
                    .addComponent(jObservacao)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxPavilhaoGaleria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(21, 21, 21))
                                    .addComponent(jComboBoxNivelPavilhao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHorarioInicio, jHorarioTermino});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel13))
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPavilhaoGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNivelPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(5, 5, 5)
                .addComponent(jLocalAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGrupoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel53)
                .addGap(219, 219, 219))
        );

        javax.swing.GroupLayout jManutencaoLayout = new javax.swing.GroupLayout(jManutencao);
        jManutencao.setLayout(jManutencaoLayout);
        jManutencaoLayout.setHorizontalGroup(
            jManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jManutencaoLayout.setVerticalGroup(
            jManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jManutencaoLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Manutenção", jManutencao);

        jPlanejamento.setToolTipText("Planejamento dos Grupos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Atividades");

        jAtividades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtividades.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Recursos");

        jRecursos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRecursos.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("H.Inicial");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("H. Final");

        jHorarioInicialTema.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioInicialTema.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioInicialTema.setEnabled(false);

        jHorarioFinalTema.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioFinalTema.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioFinalTema.setEnabled(false);

        jComboBoxTurno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Matutino", "Vespertino", "Noturno" }));
        jComboBoxTurno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTurno.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Turno");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Tema");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Código");

        jCodigoTema.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoTema.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoTema.setEnabled(false);

        jComboBoxTema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxTema.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTema.setEnabled(false);
        jComboBoxTema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTemaItemStateChanged(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Tipo de Vacina");

        jComboBoxTipoVacina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoVacina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxTipoVacina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoVacina.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dose da Vacina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btGrupo.add(jRBPrimeira);
        jRBPrimeira.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPrimeira.setText("1ª Dose");
        jRBPrimeira.setEnabled(false);

        btGrupo.add(jRBSegunda);
        jRBSegunda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBSegunda.setText("2ª Dose");
        jRBSegunda.setEnabled(false);

        btGrupo.add(jRBTerceira);
        jRBTerceira.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBTerceira.setText("3ª Dose");
        jRBTerceira.setEnabled(false);

        btGrupo.add(jRBReforco);
        jRBReforco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBReforco.setText("Reforço");
        jRBReforco.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jRBPrimeira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBSegunda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBTerceira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBReforco)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBPrimeira)
                    .addComponent(jRBSegunda)
                    .addComponent(jRBTerceira)
                    .addComponent(jRBReforco))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jAtividades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jHorarioInicialTema, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30)
                            .addComponent(jCodigoTema, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxTema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jHorarioFinalTema, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jComboBoxTipoVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCodigoTema, jHorarioFinalTema, jHorarioInicialTema});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jComboBoxTipoVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jHorarioInicialTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jHorarioFinalTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabelaPlanejamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPlanejamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "H.Inicial", "H.Final", "Atividade", "Recurso"
            }
        ));
        jTabelaPlanejamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPlanejamentoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaPlanejamento);
        if (jTabelaPlanejamento.getColumnModel().getColumnCount() > 0) {
            jTabelaPlanejamento.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPlanejamento.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPlanejamento.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPlanejamento.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPlanejamento.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaPlanejamento.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaPlanejamento.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaPlanejamento.getColumnModel().getColumn(3).setMaxWidth(200);
            jTabelaPlanejamento.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaPlanejamento.getColumnModel().getColumn(4).setMaxWidth(250);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPlan.setToolTipText("Novo Registro");
        jBtNovoPlan.setContentAreaFilled(false);
        jBtNovoPlan.setEnabled(false);
        jBtNovoPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPlanActionPerformed(evt);
            }
        });

        jBtAlterarPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPlan.setToolTipText("Alterar Registro");
        jBtAlterarPlan.setContentAreaFilled(false);
        jBtAlterarPlan.setEnabled(false);
        jBtAlterarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPlanActionPerformed(evt);
            }
        });

        jBtExcluirPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirPlan.setToolTipText("Excluir Registro");
        jBtExcluirPlan.setContentAreaFilled(false);
        jBtExcluirPlan.setEnabled(false);
        jBtExcluirPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPlanActionPerformed(evt);
            }
        });

        jBtSalvarPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPlan.setToolTipText("Gravar Registro");
        jBtSalvarPlan.setContentAreaFilled(false);
        jBtSalvarPlan.setEnabled(false);
        jBtSalvarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPlanActionPerformed(evt);
            }
        });

        jBtCancelarPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPlan.setToolTipText("Cancelar Registro");
        jBtCancelarPlan.setContentAreaFilled(false);
        jBtCancelarPlan.setEnabled(false);
        jBtCancelarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPlanActionPerformed(evt);
            }
        });

        jBtAuditoriaPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPlan.setContentAreaFilled(false);
        jBtAuditoriaPlan.setEnabled(false);
        jBtAuditoriaPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPlanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jBtNovoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluirPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarPlan)
                    .addComponent(jBtExcluirPlan)
                    .addComponent(jBtSalvarPlan)
                    .addComponent(jBtCancelarPlan)
                    .addComponent(jBtAuditoriaPlan))
                .addGap(2, 2, 2))
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosPlanejamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosPlanejamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosPlanejamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        javax.swing.GroupLayout jPlanejamentoLayout = new javax.swing.GroupLayout(jPlanejamento);
        jPlanejamento.setLayout(jPlanejamentoLayout);
        jPlanejamentoLayout.setHorizontalGroup(
            jPlanejamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPlanejamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPlanejamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPlanejamentoLayout.createSequentialGroup()
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPlanejamentoLayout.setVerticalGroup(
            jPlanejamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPlanejamentoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPlanejamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Planeja.", jPlanejamento);

        jParticipantes.setToolTipText("Participantes");

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "CNC", "Nome do Interno", "Regime"
            }
        ));
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaInternos.getColumnModel().getColumn(3).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(3).setMaxWidth(350);
            jTabelaInternos.getColumnModel().getColumn(4).setMinWidth(100);
            jTabelaInternos.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jNomeInternoGrp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoGrp.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jBtPesquisarPart.setForeground(new java.awt.Color(0, 0, 204));
        jBtPesquisarPart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarPart.setToolTipText("Pesquisar Internos");
        jBtPesquisarPart.setContentAreaFilled(false);
        jBtPesquisarPart.setEnabled(false);
        jBtPesquisarPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarPartActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Interno");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Regime");

        jRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegime.setEnabled(false);

        jIdInternoGrp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoGrp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoGrp.setEnabled(false);

        jCNC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CNC");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Pavilhão");

        jPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhao.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cela");

        jCela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCela.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Dt. Nascimento");

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome da Mãe");

        jNomeMae.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMae.setEnabled(false);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoGrp)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jIdInternoGrp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarPart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 83, Short.MAX_VALUE))
                            .addComponent(jRegime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jPavilhao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCela)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jNomeMae)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20)
                            .addComponent(jLabel57))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarPart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoParticipantes.setToolTipText("Novo Registro");
        jBtNovoParticipantes.setContentAreaFilled(false);
        jBtNovoParticipantes.setEnabled(false);
        jBtNovoParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoParticipantesActionPerformed(evt);
            }
        });

        jBtAlterarParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarParticipantes.setToolTipText("Alterar Registro");
        jBtAlterarParticipantes.setContentAreaFilled(false);
        jBtAlterarParticipantes.setEnabled(false);
        jBtAlterarParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarParticipantesActionPerformed(evt);
            }
        });

        jBtExcluirParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirParticipantes.setToolTipText("Excluir Registro");
        jBtExcluirParticipantes.setContentAreaFilled(false);
        jBtExcluirParticipantes.setEnabled(false);
        jBtExcluirParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirParticipantesActionPerformed(evt);
            }
        });

        jBtSalvarParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarParticipantes.setToolTipText("Gravar Registro");
        jBtSalvarParticipantes.setContentAreaFilled(false);
        jBtSalvarParticipantes.setEnabled(false);
        jBtSalvarParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarParticipantesActionPerformed(evt);
            }
        });

        jBtCancelarParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarParticipantes.setToolTipText("Cancelar Registro");
        jBtCancelarParticipantes.setContentAreaFilled(false);
        jBtCancelarParticipantes.setEnabled(false);
        jBtCancelarParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarParticipantesActionPerformed(evt);
            }
        });

        jBtAuditoriaParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaParticipantes.setContentAreaFilled(false);
        jBtAuditoriaParticipantes.setEnabled(false);
        jBtAuditoriaParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaParticipantesActionPerformed(evt);
            }
        });

        jBtPesquisaLote.setForeground(new java.awt.Color(0, 0, 204));
        jBtPesquisaLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaLote.setText("Pesquisa Lote");
        jBtPesquisaLote.setToolTipText("Pesquisa de Internos em Lote");
        jBtPesquisaLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaLoteActionPerformed(evt);
            }
        });

        jBtLocalizarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtLocalizarInterno.setToolTipText("Buscar");
        jBtLocalizarInterno.setContentAreaFilled(false);
        jBtLocalizarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLocalizarInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jBtNovoParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterarParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluirParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvarParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelarParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtLocalizarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jBtPesquisaLote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarParticipantes, jBtCancelarParticipantes, jBtExcluirParticipantes, jBtNovoParticipantes, jBtSalvarParticipantes});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarParticipantes)
                    .addComponent(jBtExcluirParticipantes)
                    .addComponent(jBtSalvarParticipantes)
                    .addComponent(jBtCancelarParticipantes)
                    .addComponent(jBtAuditoriaParticipantes)
                    .addComponent(jBtPesquisaLote)
                    .addComponent(jBtLocalizarInterno))
                .addGap(2, 2, 2))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarParticipantes, jBtCancelarParticipantes, jBtExcluirParticipantes, jBtNovoParticipantes, jBtSalvarParticipantes});

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosInternos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel65.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jParticipantesLayout = new javax.swing.GroupLayout(jParticipantes);
        jParticipantes.setLayout(jParticipantesLayout);
        jParticipantesLayout.setHorizontalGroup(
            jParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jParticipantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jParticipantesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jParticipantesLayout.setVerticalGroup(
            jParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jParticipantesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Participantes", jParticipantes);

        jAGlobal.setToolTipText("Avaliação em Grupo");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jTextoAvaliacaoGrupo.setColumns(20);
        jTextoAvaliacaoGrupo.setRows(5);
        jTextoAvaliacaoGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane2.setViewportView(jTextoAvaliacaoGrupo);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Texto - Avaliação em Grupo");

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAvGrupo.setText("Novo");
        jBtNovoAvGrupo.setToolTipText("Novo");
        jBtNovoAvGrupo.setContentAreaFilled(false);
        jBtNovoAvGrupo.setEnabled(false);
        jBtNovoAvGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAvGrupo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAvGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAvGrupoActionPerformed(evt);
            }
        });

        jBtAlterarAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAvGrupo.setText("Alterar");
        jBtAlterarAvGrupo.setToolTipText("Alterar");
        jBtAlterarAvGrupo.setContentAreaFilled(false);
        jBtAlterarAvGrupo.setEnabled(false);
        jBtAlterarAvGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAvGrupo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAvGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAvGrupoActionPerformed(evt);
            }
        });

        jBtExcluirAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirAvGrupo.setText("Excluir");
        jBtExcluirAvGrupo.setToolTipText("Excluir");
        jBtExcluirAvGrupo.setContentAreaFilled(false);
        jBtExcluirAvGrupo.setEnabled(false);
        jBtExcluirAvGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAvGrupo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAvGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAvGrupoActionPerformed(evt);
            }
        });

        jBtSalvarAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAvGrupo.setText("Gravar");
        jBtSalvarAvGrupo.setToolTipText("Gravar");
        jBtSalvarAvGrupo.setContentAreaFilled(false);
        jBtSalvarAvGrupo.setEnabled(false);
        jBtSalvarAvGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAvGrupo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAvGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAvGrupoActionPerformed(evt);
            }
        });

        jBtCancelarAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAvGrupo.setText("Cancelar");
        jBtCancelarAvGrupo.setToolTipText("Cancelar");
        jBtCancelarAvGrupo.setContentAreaFilled(false);
        jBtCancelarAvGrupo.setEnabled(false);
        jBtCancelarAvGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAvGrupo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAvGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAvGrupoActionPerformed(evt);
            }
        });

        jBtSairAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSairAvGrupo.setText("Sair");
        jBtSairAvGrupo.setContentAreaFilled(false);
        jBtSairAvGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAvGrupo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAvGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAvGrupoActionPerformed(evt);
            }
        });

        jBtAuditoriaAvGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAvGrupo.setContentAreaFilled(false);
        jBtAuditoriaAvGrupo.setEnabled(false);
        jBtAuditoriaAvGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAvGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jBtNovoAvGrupo)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterarAvGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluirAvGrupo)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvarAvGrupo)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelarAvGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairAvGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaAvGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jBtCancelarAvGrupo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtNovoAvGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtAlterarAvGrupo)
                                .addComponent(jBtExcluirAvGrupo)
                                .addComponent(jBtSalvarAvGrupo)))
                        .addGap(163, 163, 163))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jBtSairAvGrupo)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaAvGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jAGlobalLayout = new javax.swing.GroupLayout(jAGlobal);
        jAGlobal.setLayout(jAGlobalLayout);
        jAGlobalLayout.setHorizontalGroup(
            jAGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jAGlobalLayout.setVerticalGroup(
            jAGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("A.Grupo", jAGlobal);

        jAIndividual.setToolTipText("Avaliação Individual");

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Código");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("CNC");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Regime");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Nome do Participante");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Nome da Mãe");

        jIdInternoAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAI.setEnabled(false);

        jCNCAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNCAI.setEnabled(false);

        jRegimeAVI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeAVI.setEnabled(false);

        jNomeInternoAVI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAVI.setEnabled(false);

        jNomeMaeInternoAVI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInternoAVI.setEnabled(false);

        jBtPesqInternoAVI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoAVI.setContentAreaFilled(false);
        jBtPesqInternoAVI.setEnabled(false);
        jBtPesqInternoAVI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoAVIActionPerformed(evt);
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
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jIdInternoAI, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jCNCAI, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jRegimeAVI, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqInternoAVI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeMaeInternoAVI)
                            .addComponent(jNomeInternoAVI))
                        .addContainerGap())))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(1, 1, 1)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqInternoAVI, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRegimeAVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCNCAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoAVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeMaeInternoAVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Participante", jPanel13);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jTextoAvalaicaoIndividual.setColumns(20);
        jTextoAvalaicaoIndividual.setRows(5);
        jTextoAvalaicaoIndividual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(jTextoAvalaicaoIndividual);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane2.addTab("Avaliação", jPanel14);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoAvInd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAvInd.setToolTipText("Novo Registro");
        jBtNovoAvInd.setContentAreaFilled(false);
        jBtNovoAvInd.setEnabled(false);
        jBtNovoAvInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAvIndActionPerformed(evt);
            }
        });

        jBtAlterarAvInd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAvInd.setToolTipText("Alterar Registro");
        jBtAlterarAvInd.setContentAreaFilled(false);
        jBtAlterarAvInd.setEnabled(false);
        jBtAlterarAvInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAvIndActionPerformed(evt);
            }
        });

        jBtExcluirAvInd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirAvInd.setToolTipText("Excluir Registro");
        jBtExcluirAvInd.setContentAreaFilled(false);
        jBtExcluirAvInd.setEnabled(false);
        jBtExcluirAvInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAvIndActionPerformed(evt);
            }
        });

        jBtSalvarAvInd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAvInd.setToolTipText("Gravar Registro");
        jBtSalvarAvInd.setContentAreaFilled(false);
        jBtSalvarAvInd.setEnabled(false);
        jBtSalvarAvInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAvIndActionPerformed(evt);
            }
        });

        jBtCancelarAvInd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAvInd.setToolTipText("Cancelar Registro");
        jBtCancelarAvInd.setContentAreaFilled(false);
        jBtCancelarAvInd.setEnabled(false);
        jBtCancelarAvInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAvIndActionPerformed(evt);
            }
        });

        jBtAuditoriaAvInd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAvInd.setContentAreaFilled(false);
        jBtAuditoriaAvInd.setEnabled(false);
        jBtAuditoriaAvInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAvIndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jBtNovoAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtAlterarAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtExcluirAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtSalvarAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelarAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoAvInd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarAvInd)
                    .addComponent(jBtExcluirAvInd)
                    .addComponent(jBtSalvarAvInd)
                    .addComponent(jBtCancelarAvInd)
                    .addComponent(jBtAuditoriaAvInd))
                .addGap(2, 2, 2))
        );

        jTabelaInternosAvIndividual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosAvIndividual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "CNC", "Nome do Interno", "Regime"
            }
        ));
        jTabelaInternosAvIndividual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosAvIndividualMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(jTabelaInternosAvIndividual);
        if (jTabelaInternosAvIndividual.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(3).setMinWidth(350);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(3).setMaxWidth(350);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(4).setMinWidth(100);
            jTabelaInternosAvIndividual.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosInternosAVI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInternosAVI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInternosAVI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel66.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66)
        );

        javax.swing.GroupLayout jAIndividualLayout = new javax.swing.GroupLayout(jAIndividual);
        jAIndividual.setLayout(jAIndividualLayout);
        jAIndividualLayout.setHorizontalGroup(
            jAIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAIndividualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jAIndividualLayout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jAIndividualLayout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jAIndividualLayout.setVerticalGroup(
            jAIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAIndividualLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jAIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("A.Individual", jAIndividual);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoInternoGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtLiberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtLiberar.setText("Liberar");
        jBtLiberar.setToolTipText("LiberarAtendimento");
        jBtLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLiberarActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.setToolTipText("Impressão");
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jBtLiberador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png"))); // NOI18N
        jBtLiberador.setText("Liberado");
        jBtLiberador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLiberadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtLiberar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jBtImpressao, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jBtLiberador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtImpressao, jBtLiberar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jBtLiberar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtLiberador)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 60, 642, 478);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIDPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIDPesqActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jIDPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ID para pesquisa.");
            jIDPesq.requestFocus();
        } else {
            preencherTabelaAtividadeGRU("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN PAVILHAO "
                    + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdPav=PAVILHAO.IdPav "
                    + "WHERE IdAtGrupoEnf='" + jIDPesq.getText() + "'");
        }
    }//GEN-LAST:event_jBtIDPesqActionPerformed

    private void jBtPesquisarInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternosActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
            jPesqNomeInterno.requestFocus();
        } else {
            preencherTabelaAtividadeGRU("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN PAVILHAO "
                    + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdPav=PAVILHAO.IdPav "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesquisarInternosActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicial.requestFocus();
            } else {
                if (jDataFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinal.requestFocus();
                } else {
                    if (jDataInicial.getDate().after(jDataFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        preencherTabelaAtividadeGRU("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                                + "INNER JOIN PAVILHAO "
                                + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdPav=PAVILHAO.IdPav "
                                + "WHERE DataAtend BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicial.requestFocus();
            } else {
                if (jDataFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinal.requestFocus();
                } else {
                    if (jDataInicial.getDate().after(jDataFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        preencherTabelaAtividadeGRU("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                                + "INNER JOIN PAVILHAO "
                                + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdPav=PAVILHAO.IdPav "
                                + "WHERE DataAtend BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaAtividadeGRU("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN PAVILHAO "
                    + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdPav=PAVILHAO.IdPav");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaAdmissaoPsicologicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoPsicologicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaAdmissaoPsicologica.getValueAt(jTabelaAdmissaoPsicologica.getSelectedRow(), 0);
            jIDPesq.setText(IdLanc);
            //            
            bloquearTodosBotoes();
            bloquearTodosCampos();
            limparCamposPlanejamento();
            limparCamposParticipantes();
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoPlan.setEnabled(true);
            jBtNovoParticipantes.setEnabled(true);
            jBtNovoAvGrupo.setEnabled(true);
            jBtNovoAvInd.setEnabled(true);
            //
            jComboBoxPavilhaoGaleria.removeAllItems();
            jComboBoxNivelPavilhao.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "INNER JOIN PAVILHAO "
                        + "ON ATENDIMENTO_GRUPO_ENFERMAGEM.IdPav=PAVILHAO.IdPav "
                        + "WHERE ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + IdLanc + "'");
                conecta.rs.first();
                jCodigoAtend.setText(String.valueOf(conecta.rs.getInt("IdAtGrupoEnf")));
                jStatusAtend.setText(conecta.rs.getString("StatusAtendGrupo"));
                jDataAtend.setDate(conecta.rs.getDate("DataAtend"));
                jResponsavel.setText(conecta.rs.getString("Responsavel"));
                jComboBoxPavilhaoGaleria.addItem(conecta.rs.getString("DescricaoPav"));
                jComboBoxNivelPavilhao.addItem(conecta.rs.getString("NivelPav"));
                jHorarioInicio.setText(conecta.rs.getString("HoraioInicio"));
                jHorarioTermino.setText(conecta.rs.getString("HorarioTermino"));
                jComboBoxAmbiente.setSelectedItem(conecta.rs.getString("Ambiente"));
                jLocalAtividade.setText(conecta.rs.getString("LocalAtividade"));
                jGrupoAtividade.setText(conecta.rs.getString("GrupoAtividade"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            //ABA PLANEJAMENTO
            preencherTabelaPlanejamento("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "ON PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                    + "WHERE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + IdLanc + "'");
            //ABA PARTICIPANTES
            preencherTabelaParticipantes("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + IdLanc + "'");
            //ABA AVALIAÇÃO EM GRUIPO
            buscarAvaliacaoGrupo();
            //ABA AVALIAÇÃO INDIVIDUAL
            preencherTabelaAvaliacaoIndividual("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaAdmissaoPsicologicaMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Manu) && codIncluirENF == 1) {
            acao = 1;
            bloquearTodosCampos();
            bloquearTodosBotoes();
            limparTodosCampos();
            limparTabelaPlanejamento();
            limparTabelaParticipantes();
            limparTabelaAvaliacaoIndividual();
            Novo();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Manu) && codAlterarENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                Alterar();
                preencherComboBoxPavilhao();
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
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Manu) && codExcluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarUsuarioCriador();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                    if (jStatusAtend.getText().equals("FINALIZADO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                    } else {
                        //VERIFICAR SE EXISTEM REGISTROS EM OUTRAS TABELAS RELACIONADOS A ESSE REGISTO.
                        verificarRegistros();
                        if (jCodigoAtend.getText().equals(pCODIGO_ATENDE_PLAN)
                                || jCodigoAtend.getText().equals(pCODIGO_ATENDE_PART)
                                || jCodigoAtend.getText().equals(pCODIGO_ATENDE_AVAG)
                                || jCodigoAtend.getText().equals(pCODIGO_ATENDE_AVAI)) {
                            JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse resgistro, existe(m) outro(s) registro(s) vinculado a esse.");
                        } else {
                            statusMov = "Excluiu";
                            horaMov = jHoraSistema.getText();
                            dataModFinal = jDataSistema.getText();
                            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                            if (jStatusAtend.getText().equals("FINALIZADO")) {
                                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                            } else {
                                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                        JOptionPane.YES_NO_OPTION);
                                if (resposta == JOptionPane.YES_OPTION) {
                                    objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
                                    control.excluirAtendimentoGrupoManutencaoENF(objAvalia);
                                    objLog();
                                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                    bloquearTodosBotoes();
                                    bloquearTodosCampos();
                                    limparTodosCampos();
                                    Excluir();
                                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Manu) && codGravarENF == 1) {
            if (jComboBoxPavilhaoGaleria.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o pavilhão.");
            } else if (jComboBoxAmbiente.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o ambiente da atividade em grupo.");
            } else if (jHorarioInicio.getText().equals("00:00")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário inicial da atividade em grupo.");
            } else if (jHorarioTermino.getText().equals("00:00")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário do termino da atividade em grupo.");
            } else if (jLocalAtividade.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o local da atividade em grupo.");
            } else if (jGrupoAtividade.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o grupo da atividade em grupo.");
            } else {
                objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                objAvalia.setDataAtend(jDataAtend.getDate());
                objAvalia.setResponsavel(jResponsavel.getText());
                objAvalia.setDescricaoPavilhao((String) jComboBoxPavilhaoGaleria.getSelectedItem());
                objAvalia.setAmbiente((String) jComboBoxAmbiente.getSelectedItem());
                objAvalia.setHoraioInicio(jHorarioInicio.getText());
                objAvalia.setHorarioTermino(jHorarioTermino.getText());
                objAvalia.setLocalAtividade(jLocalAtividade.getText());
                objAvalia.setGrupoAtividade(jGrupoAtividade.getText());
                objAvalia.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    // log de usuario
                    objAvalia.setUsuarioInsert(nameUser);
                    objAvalia.setDataInsert(dataModFinal);
                    objAvalia.setHorarioInsert(horaMov);
                    //
                    control.incluirAtendimentoGrupoManutencaoENF(objAvalia);
                    buscarCodigoManutencao();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosBotoes();
                    bloquearTodosCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    // log de usuario
                    objAvalia.setUsuarioUp(nameUser);
                    objAvalia.setDataUp(dataModFinal);
                    objAvalia.setHorarioUp(horaMov);
                    //
                    objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
                    control.alterarAtendimentoGrupoManutencaoENF(objAvalia);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosBotoes();
                    bloquearTodosCampos();
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
        TelaAuditoriaRegistroAtendGrupo_MANU_ENF objAudMa = new TelaAuditoriaRegistroAtendGrupo_MANU_ENF();
        TelaModuloEnfermaria.jPainelMedico.add(objAudMa);
        objAudMa.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPlanActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Plan);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Plan) && codIncluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                limparCamposPlanejamento();
                NovoPlan();
                pesquisarPlanejamento();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoPlanActionPerformed

    private void jBtAlterarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPlanActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Plan);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Plan) && codAlterarENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                AlterarPlan();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarPlanActionPerformed

    private void jBtExcluirPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPlanActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Plan);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Plan) && codExcluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarUsuarioCriador();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                    if (jStatusAtend.getText().equals("FINALIZADO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objAvalia.setIdItemPlan(Integer.valueOf(jCodigoTema.getText()));
                            control.excluirPlanejamentoENF(objAvalia);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearTodosCampos();
                            bloquearTodosBotoes();
                            limparCamposPlanejamento();
                            ExcluirPlan();
                            preencherTabelaPlanejamento("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                                    + "ON PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                                    + "WHERE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirPlanActionPerformed

    private void jBtSalvarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPlanActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Plan);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Plan) && codGravarENF == 1) {
            if (jComboBoxTema.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tema para o planejamento.");
            } else if (jComboBoxTema.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tema para o planejamento.");
            } else if (jHorarioInicialTema.getText().equals("00:00")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário inicial da atividade.");
            } else if (jHorarioFinalTema.getText().equals("00:00")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o horário final da atividade.");
            } else if (jAtividades.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe uma descrição para a atividade.");
            } else if (jRecursos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe um recurso para a atividade.");
            } else {
                objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
                objAvalia.setTema((String) jComboBoxTema.getSelectedItem());
                objAvalia.setHoraInicio(jHorarioInicialTema.getText());
                objAvalia.setHoraTermino(jHorarioFinalTema.getText());
                objAvalia.setTurno((String) jComboBoxTurno.getSelectedItem());
                objAvalia.setAtividades(jAtividades.getText());
                objAvalia.setRecursos(jRecursos.getText());
                if (acao == 3) {
                    // log de usuario
                    objAvalia.setUsuarioInsert(nameUser);
                    objAvalia.setDataInsert(dataModFinal);
                    objAvalia.setHorarioInsert(horaMov);
                    control.incluirPlanejamentoENF(objAvalia);
                    buscarCodigoPlanejamento();
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    limparCamposPlanejamento();
                    SalvarPlan();
                    preencherTabelaPlanejamento("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "ON PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                            + "WHERE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    // log de usuario
                    objAvalia.setUsuarioUp(nameUser);
                    objAvalia.setDataUp(dataModFinal);
                    objAvalia.setHorarioUp(horaMov);
                    //
                    objAvalia.setIdItemPlan(Integer.valueOf(jCodigoTema.getText()));
                    control.alterarPlanejamentoENF(objAvalia);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    limparCamposPlanejamento();
                    SalvarPlan();
                    preencherTabelaPlanejamento("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "ON PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                            + "WHERE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarPlanActionPerformed

    private void jBtCancelarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPlanActionPerformed
        // TODO add your handling code here:
        CancelarPlan();
    }//GEN-LAST:event_jBtCancelarPlanActionPerformed

    private void jBtAuditoriaPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPlanActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegistroAtendGrupo_PLAN_ENF objAudiPlan = new TelaAuditoriaRegistroAtendGrupo_PLAN_ENF();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiPlan);
        objAudiPlan.show();
    }//GEN-LAST:event_jBtAuditoriaPlanActionPerformed

    private void jTabelaPlanejamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPlanejamentoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            pCODIGO_PLAN = "" + jTabelaPlanejamento.getValueAt(jTabelaPlanejamento.getSelectedRow(), 0);
            //
            bloquearTodosBotoes();
            bloquearTodosCampos();
            jBtNovoPlan.setEnabled(true);
            jBtAlterarPlan.setEnabled(true);
            jBtExcluirPlan.setEnabled(true);
            jBtCancelarPlan.setEnabled(true);
            jBtAuditoriaPlan.setEnabled(true);
            jComboBoxTema.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "ON PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                        + "WHERE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "' "
                        + "AND PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdItemPlanEnf='" + pCODIGO_PLAN + "'");
                conecta.rs.first();
                jCodigoTema.setText(conecta.rs.getString("IdItemPlanEnf"));
                jComboBoxTema.addItem(conecta.rs.getString("Tema"));
                jHorarioInicialTema.setText(conecta.rs.getString("HoraInicio"));
                jHorarioFinalTema.setText(conecta.rs.getString("HoraTermino"));
                jComboBoxTurno.setSelectedItem(conecta.rs.getString("Turno"));
                jAtividades.setText(conecta.rs.getString("Atividades"));
                jRecursos.setText(conecta.rs.getString("Recursos"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaPlanejamentoMouseClicked

    private void jBtNovoParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoParticipantesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Inte);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Inte) && codIncluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 5;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                limparCamposParticipantes();
                NovoParticipante();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoParticipantesActionPerformed

    private void jBtAlterarParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarParticipantesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Inte);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Inte) && codAlterarENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 6;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                AlterarParticipante();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarParticipantesActionPerformed

    private void jBtExcluirParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirParticipantesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Inte);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Inte) && codExcluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarUsuarioCriador();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                    if (jStatusAtend.getText().equals("FINALIZADO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objAvalia.setIdItemPart(pCODIGO_ITEM_PARTICIPANTE);
                            control.excluirAtendimentoGrupoParticipantesENF(objAvalia);
                            objLog3();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearTodosCampos();
                            bloquearTodosBotoes();
                            limparCamposParticipantes();
                            ExcluirParticipante();
                            preencherTabelaParticipantes("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                                    + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "INNER JOIN DADOSPENAISINTERNOS "
                                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                    + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro exluído com sucesso.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirParticipantesActionPerformed

    private void jBtSalvarParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarParticipantesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Inte);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Inte) && codGravarENF == 1) {
            if (jIdInternoGrp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do participante.");
            } else if (jNomeInternoGrp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do participante.");
            } else {
                objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
                objAvalia.setIdInternoCrc(Integer.valueOf(jIdInternoGrp.getText()));
                objAvalia.setNomeInternoCrc(jNomeInternoGrp.getText());
                if (acao == 5) {
                    // log de usuario
                    objAvalia.setUsuarioInsert(nameUser);
                    objAvalia.setDataInsert(dataModFinal);
                    objAvalia.setHorarioInsert(horaMov);
                    //
                    control.incluirAtendimentoGrupoParticipantesENF(objAvalia);
                    buscarCodigoParticipantes();
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    limparCamposParticipantes();
                    SalvarPlan();
                    preencherTabelaParticipantes("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    // log de usuario
                    objAvalia.setUsuarioInsert(nameUser);
                    objAvalia.setDataInsert(dataModFinal);
                    objAvalia.setHorarioInsert(horaMov);
                    objAvalia.setIdItemPart(pCODIGO_ITEM_PARTICIPANTE);
                    control.alterarAtendimentoGrupoParticipantesENF(objAvalia);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    limparCamposParticipantes();
                    SalvarPlan();
                    preencherTabelaParticipantes("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarParticipantesActionPerformed

    private void jBtCancelarParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarParticipantesActionPerformed
        // TODO add your handling code here:
        CancelarParticipante();
    }//GEN-LAST:event_jBtCancelarParticipantesActionPerformed

    private void jBtAuditoriaParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaParticipantesActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegistroAtendGrupo_PART_ENF objAudi_PART = new TelaAuditoriaRegistroAtendGrupo_PART_ENF();
        TelaModuloEnfermaria.jPainelMedico.add(objAudi_PART);
        objAudi_PART.show();
    }//GEN-LAST:event_jBtAuditoriaParticipantesActionPerformed

    private void jBtPesquisarPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarPartActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoAtendimentoGrupoENF objPesqInterno = new TelaPesqInternoAtendimentoGrupoENF();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqInterno);
        objPesqInterno.show();
    }//GEN-LAST:event_jBtPesquisarPartActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            pCODIGO_PART = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //
            bloquearTodosBotoes();
            bloquearTodosCampos();
            jBtNovoParticipantes.setEnabled(true);
            jBtAlterarParticipantes.setEnabled(true);
            jBtExcluirParticipantes.setEnabled(true);
            jBtCancelarParticipantes.setEnabled(true);
            jBtAuditoriaParticipantes.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdItemPartEnf='" + pCODIGO_PART + "'");
                conecta.rs.first();
                pCODIGO_ITEM_PARTICIPANTE = conecta.rs.getInt("IdItemPartEnf");
                jIdInternoGrp.setText(conecta.rs.getString("IdInternoCrc"));
                jCNC.setText(conecta.rs.getString("Cnc"));
                jRegime.setText(conecta.rs.getString("Regime"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jNomeInternoGrp.setText(conecta.rs.getString("NomeInternoCrc"));
                jNomeMae.setText(conecta.rs.getString("MaeInternoCrc"));
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                jCela.setText(conecta.rs.getString("EndCelaPav"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoGrupo.setIcon(i);
                    jFotoInternoGrupo.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoGrupo.getWidth(), jFotoInternoGrupo.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoGrupo.getWidth(), jFotoInternoGrupo.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoGrupo.setIcon(icon);
                }
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAvGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVG);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVG) && codIncluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                verificarExistenciaRegistroAVG();
                objAvalia.setIdItemAvag(Integer.valueOf(jCodigoAtend.getText()));
                if (pCODIGO_AVALIACAO_GRUPO_AVG == objAvalia.getIdItemAvag()) {
                    JOptionPane.showMessageDialog(rootPane, "Já existe uma avaliação em grupo para essa atividade.");
                } else {
                    acao = 7;
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    NovoAVG();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoAvGrupoActionPerformed

    private void jBtAlterarAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAvGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVG);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVG) && codAlterarENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 8;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                AlterarAVG();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarAvGrupoActionPerformed

    private void jBtExcluirAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAvGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVG);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVG) && codExcluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarUsuarioCriador();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                    if (jStatusAtend.getText().equals("FINALIZADO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objAvalia.setIdItemAvag(pCODIGO_AVALIACAO_GRUPO);
                            control.excluirAtendimentoGrupoAVGENF(objAvalia);
                            objLog4();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearTodosCampos();
                            bloquearTodosBotoes();
                            ExcluirAVG();
                            JOptionPane.showMessageDialog(rootPane, "Registro exluído com sucesso.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirAvGrupoActionPerformed

    private void jBtSalvarAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAvGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVG);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVG) && codGravarENF == 1) {
            objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
            objAvalia.setTextoAvalaiacaoGrupo(jTextoAvaliacaoGrupo.getText());
            //VERIFICAR SE JÁ EXISTE ALGUM REGISTRO, NÃO PODE DUPLICAR
            verificarExistenciaRegistroAVG();
            if (acao == 7) {
                objAvalia.setIdItemAvag(Integer.valueOf(jCodigoAtend.getText()));
                if (pCODIGO_AVALIACAO_GRUPO_AVG == objAvalia.getIdItemAvag()) {
                    JOptionPane.showMessageDialog(rootPane, "Já existe uma avaliação em grupo para essa atividade.");
                } else {
                    // log de usuario
                    objAvalia.setUsuarioInsert(nameUser);
                    objAvalia.setDataInsert(dataModFinal);
                    objAvalia.setHorarioInsert(horaMov);
                    //
                    control.incluirAtendimentoGrupoAVGENF(objAvalia);
                    buscarCodigoAVG();
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    SalvarAVG();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
            if (acao == 8) {
                // log de usuario
                objAvalia.setUsuarioUp(nameUser);
                objAvalia.setDataUp(dataModFinal);
                objAvalia.setHorarioUp(horaMov);
                //
                objAvalia.setIdItemAvag(pCODIGO_AVALIACAO_GRUPO);
                control.alterarAtendimentoGrupoAVGENF(objAvalia);
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearTodosCampos();
                bloquearTodosBotoes();
                SalvarAVG();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarAvGrupoActionPerformed

    private void jBtCancelarAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAvGrupoActionPerformed
        // TODO add your handling code here:
        CancelarAVG();
    }//GEN-LAST:event_jBtCancelarAvGrupoActionPerformed

    private void jBtSairAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAvGrupoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAvGrupoActionPerformed

    private void jBtAuditoriaAvGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAvGrupoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegistroAtendGrupo_AGRU_ENF objAudi_AG = new TelaAuditoriaRegistroAtendGrupo_AGRU_ENF();
        TelaModuloEnfermaria.jPainelMedico.add(objAudi_AG);
        objAudi_AG.show();
    }//GEN-LAST:event_jBtAuditoriaAvGrupoActionPerformed

    private void jBtNovoAvIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAvIndActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVI) && codIncluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 9;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                limparCamposAVI();
                NovoAVGI();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoAvIndActionPerformed

    private void jBtAlterarAvIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAvIndActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVI) && codAlterarENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 10;
                bloquearTodosCampos();
                bloquearTodosBotoes();
                AlterarAVGI();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarAvIndActionPerformed

    private void jBtExcluirAvIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAvIndActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVI) && codExcluirENF == 1) {
            objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarUsuarioCriador();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                    if (jStatusAtend.getText().equals("FINALIZADO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objAvalia.setIdItemAvai(pCODIGO_AVALIACAO_GRUPO_AVGI);
                            control.excluirAtendimentoGrupoAVGIENF(objAvalia);
                            objLog5();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearTodosCampos();
                            bloquearTodosBotoes();
                            limparCamposAVI();
                            ExcluirAVGI();
                            preencherTabelaAvaliacaoIndividual("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM "
                                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                                    + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "INNER JOIN DADOSPENAISINTERNOS "
                                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                    + "WHERE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro exluído com sucesso.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirAvIndActionPerformed

    private void jBtSalvarAvIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAvIndActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_AVI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_AVI) && codGravarENF == 1) {
            if (jIdInternoAI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do participante.");
            } else if (jNomeInternoAVI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do participante.");
            } else {
                objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
                objAvalia.setIdInternoCrc(Integer.valueOf(jIdInternoAI.getText()));
                objAvalia.setNomeInternoCrc(jNomeInternoAVI.getText());
                objAvalia.setTextoAvalaiacaoInd(jTextoAvalaicaoIndividual.getText());
                if (acao == 9) {
                    // log de usuario
                    objAvalia.setUsuarioInsert(nameUser);
                    objAvalia.setDataInsert(dataModFinal);
                    objAvalia.setHorarioInsert(horaMov);
                    //
                    control.incluirAtendimentoGrupoAVGIENF(objAvalia);
                    buscarCodigoAVI();
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    limparCamposAVI();
                    SalvarAVG();
                    preencherTabelaAvaliacaoIndividual("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 10) {
                    // log de usuario
                    objAvalia.setUsuarioUp(nameUser);
                    objAvalia.setDataUp(dataModFinal);
                    objAvalia.setHorarioUp(horaMov);
                    //
                    objAvalia.setIdItemAvai(pCODIGO_AVALIACAO_GRUPO_AVGI);
                    control.alterarAtendimentoGrupoAVGIENF(objAvalia);
                    buscarCodigoAVI();
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosCampos();
                    bloquearTodosBotoes();
                    limparCamposAVI();
                    SalvarAVG();
                    preencherTabelaAvaliacaoIndividual("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                            + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN DADOSPENAISINTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                            + "WHERE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarAvIndActionPerformed

    private void jBtCancelarAvIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAvIndActionPerformed
        // TODO add your handling code here:
        CancelarAVGI();
    }//GEN-LAST:event_jBtCancelarAvIndActionPerformed

    private void jBtAuditoriaAvIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAvIndActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegistroAtendGrupo_AIGRU_ENF objAudi_AIG = new TelaAuditoriaRegistroAtendGrupo_AIGRU_ENF();
        TelaModuloEnfermaria.jPainelMedico.add(objAudi_AIG);
        objAudi_AIG.show();
    }//GEN-LAST:event_jBtAuditoriaAvIndActionPerformed

    private void jBtPesqInternoAVIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoAVIActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoAtendimentoGrupoAVI_ENF objPesqIntAVI = new TelaPesqInternoAtendimentoGrupoAVI_ENF();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqIntAVI);
        objPesqIntAVI.show();
    }//GEN-LAST:event_jBtPesqInternoAVIActionPerformed

    private void jTabelaInternosAvIndividualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosAvIndividualMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            pCODIGO_AVI = "" + jTabelaInternosAvIndividual.getValueAt(jTabelaInternosAvIndividual.getSelectedRow(), 0);
            //
            bloquearTodosBotoes();
            bloquearTodosCampos();
            jBtNovoAvInd.setEnabled(true);
            jBtAlterarAvInd.setEnabled(true);
            jBtExcluirAvInd.setEnabled(true);
            jBtCancelarAvInd.setEnabled(true);
            jBtAuditoriaAvInd.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM.IdItemAvaiEnf='" + pCODIGO_AVI + "'");
                conecta.rs.first();
                pCODIGO_AVALIACAO_GRUPO_AVGI = conecta.rs.getInt("IdItemAvaiEnf");
                jIdInternoAI.setText(conecta.rs.getString("IdInternoCrc"));
                jCNCAI.setText(conecta.rs.getString("Cnc"));
                jRegimeAVI.setText(conecta.rs.getString("Regime"));
                jNomeInternoAVI.setText(conecta.rs.getString("NomeInternoCrc"));
                jNomeMaeInternoAVI.setText(conecta.rs.getString("MaeInternoCrc"));
                jTextoAvalaicaoIndividual.setText(conecta.rs.getString("TextoAvalaiacaoInd"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoGrupo.setIcon(i);
                    jFotoInternoGrupo.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoGrupo.getWidth(), jFotoInternoGrupo.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoGrupo.getWidth(), jFotoInternoGrupo.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoGrupo.setIcon(icon);
                }
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternosAvIndividualMouseClicked

    private void jBtLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(botaoLiberar_ENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(botaoLiberar_ENF) && codAbrirENF == 1) {
            Integer row1 = jTabelaInternos.getRowCount();
            if (row1 == 0) {
                JOptionPane.showMessageDialog(rootPane, "Não existe participantes cadastrados.");
            } else if (row1 == 1) {
                JOptionPane.showMessageDialog(rootPane, "A quantidade de participantes é pequena para o aatendimento em grupo.");
            } else {
                objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
                if (jStatusAtend.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
                } else {
                    verificarLiberacao();
                    mostrarTelaAG();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtLiberarActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        Integer row0 = jTabelaInternos.getRowCount();
        if (row0 == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe participantes cadastrados.");
        } else if (row0 == 1) {
            JOptionPane.showMessageDialog(rootPane, "A quantidade de participantes é pequena para o aatendimento em grupo.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioAtendimentoGrupoInternosENF.jasper";
                conecta.executaSQL("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                        + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'"
                        + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
                HashMap parametros = new HashMap();
                parametros.put("pCODIGO_ATIVIDADE", jCodigoAtend.getText());
                parametros.put("nomeUsuario", nameUser);
                parametros.put("pUNIDADE_PRISIONAL", descricaoUnidade);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório Atendimento em Grupo - Enfermagem");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtLiberadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLiberadorActionPerformed
        // TODO add your handling code here:
        if (jCodigoAtend.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar primeiro um registro.");
        } else {
            TelaLiberadorRegistroAtendGrupo_ENF objLibera = new TelaLiberadorRegistroAtendGrupo_ENF();
            TelaModuloEnfermaria.jPainelMedico.add(objLibera);
            objLibera.show();
        }
    }//GEN-LAST:event_jBtLiberadorActionPerformed

    private void jBtPesquisaLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaLoteActionPerformed
        // TODO add your handling code here:
        objAvalia.setStatusAtendGrupo(jStatusAtend.getText());
        if (jStatusAtend.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            if (acao == 5 || acao == 6) {
                mostrarPesquisaLote();
                jBtNovoParticipantes.setEnabled(true);
                jBtNovoAvGrupo.setEnabled(true);
                jBtAlterarAvGrupo.setEnabled(true);
                jBtExcluirAvGrupo.setEnabled(true);
                jBtNovoAvInd.setEnabled(true);
                //
                jBtNovo.setEnabled(true);
                jBtAlterar.setEnabled(true);
                jBtExcluir.setEnabled(true);
                jBtAuditoria.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Você não está no modo de inserção ou edição para modificar o registro selecionado.\nClique não botão novo ou alterar.");
            }
        }
    }//GEN-LAST:event_jBtPesquisaLoteActionPerformed

    private void jComboBoxPavilhaoGaleriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPavilhaoGaleriaItemStateChanged
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            if (evt.getStateChange() == evt.SELECTED) {
                jComboBoxNivelPavilhao.removeAllItems();
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM "
                            + "PAVILHAO WHERE DescricaoPav='" + jComboBoxPavilhaoGaleria.getSelectedItem() + "'");
                    conecta.rs.first();
                    jComboBoxNivelPavilhao.addItem(conecta.rs.getString("NivelPav"));
                } catch (Exception e) {
                }
                conecta.desconecta();
            }
        }
    }//GEN-LAST:event_jComboBoxPavilhaoGaleriaItemStateChanged

    private void jComboBoxPavilhaoGaleriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPavilhaoGaleriaMouseClicked
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            jComboBoxNivelPavilhao.removeAllItems();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAVILHAO "
                        + "WHERE DescricaoPav='" + jComboBoxPavilhaoGaleria.getSelectedItem() + "'");
                conecta.rs.first();
                jComboBoxNivelPavilhao.addItem(conecta.rs.getString("NivelPav"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jComboBoxPavilhaoGaleriaMouseClicked

    private void jBtLocalizarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizarInternoActionPerformed
        // TODO add your handling code here:
        Integer row = jTabelaInternos.getRowCount();
        if (row == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existem internos a serem pesquisados, a tabela está vazia.");
        } else {
            TelaLocalizarParticipantes_ENF objLocal = new TelaLocalizarParticipantes_ENF();
            TelaModuloEnfermaria.jPainelMedico.add(objLocal);
            objLocal.show();
        }
    }//GEN-LAST:event_jBtLocalizarInternoActionPerformed

    private void jComboBoxTemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTemaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxTema.getSelectedItem().equals("Vacinas")) {
            pesquisarPlanejamento();
            opcaoVacinas(true);
            pesquisarTipoVacina();
        } else {
            opcaoVacinas(!true);
        }
    }//GEN-LAST:event_jComboBoxTemaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btGrupo;
    private javax.swing.JPanel jAGlobal;
    private javax.swing.JPanel jAIndividual;
    private javax.swing.JTextField jAtividades;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarAvGrupo;
    private javax.swing.JButton jBtAlterarAvInd;
    public static javax.swing.JButton jBtAlterarParticipantes;
    private javax.swing.JButton jBtAlterarPlan;
    public static javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaAvGrupo;
    private javax.swing.JButton jBtAuditoriaAvInd;
    public static javax.swing.JButton jBtAuditoriaParticipantes;
    private javax.swing.JButton jBtAuditoriaPlan;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarAvGrupo;
    private javax.swing.JButton jBtCancelarAvInd;
    public static javax.swing.JButton jBtCancelarParticipantes;
    private javax.swing.JButton jBtCancelarPlan;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirAvGrupo;
    private javax.swing.JButton jBtExcluirAvInd;
    public static javax.swing.JButton jBtExcluirParticipantes;
    private javax.swing.JButton jBtExcluirPlan;
    private javax.swing.JButton jBtIDPesq;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtLiberador;
    private javax.swing.JButton jBtLiberar;
    private javax.swing.JButton jBtLocalizarInterno;
    public static javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoAvGrupo;
    private javax.swing.JButton jBtNovoAvInd;
    public static javax.swing.JButton jBtNovoParticipantes;
    private javax.swing.JButton jBtNovoPlan;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInternoAVI;
    public static javax.swing.JButton jBtPesquisaLote;
    private javax.swing.JButton jBtPesquisarInternos;
    public static javax.swing.JButton jBtPesquisarPart;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairAvGrupo;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarAvGrupo;
    private javax.swing.JButton jBtSalvarAvInd;
    public static javax.swing.JButton jBtSalvarParticipantes;
    private javax.swing.JButton jBtSalvarPlan;
    public static javax.swing.JTextField jCNC;
    public static javax.swing.JTextField jCNCAI;
    public static javax.swing.JTextField jCela;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCodigoAtend;
    public static javax.swing.JTextField jCodigoTema;
    private javax.swing.JComboBox<String> jComboBoxAmbiente;
    public static javax.swing.JComboBox<String> jComboBoxNivelPavilhao;
    public static javax.swing.JComboBox<String> jComboBoxPavilhaoGaleria;
    private javax.swing.JComboBox<String> jComboBoxTema;
    private javax.swing.JComboBox<String> jComboBoxTipoVacina;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    public static com.toedter.calendar.JDateChooser jDataAtend;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    public static javax.swing.JLabel jFotoInternoGrupo;
    private javax.swing.JTextField jGrupoAtividade;
    private javax.swing.JFormattedTextField jHorarioFinalTema;
    private javax.swing.JFormattedTextField jHorarioInicialTema;
    private javax.swing.JFormattedTextField jHorarioInicio;
    private javax.swing.JFormattedTextField jHorarioTermino;
    private javax.swing.JTextField jIDPesq;
    public static javax.swing.JTextField jIdInternoAI;
    public static javax.swing.JTextField jIdInternoGrp;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jListagem;
    private javax.swing.JTextField jLocalAtividade;
    private javax.swing.JPanel jManutencao;
    public static javax.swing.JTextField jNomeInternoAVI;
    public static javax.swing.JTextField jNomeInternoGrp;
    public static javax.swing.JTextField jNomeMae;
    public static javax.swing.JTextField jNomeMaeInternoAVI;
    private javax.swing.JTextField jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jParticipantes;
    public static javax.swing.JTextField jPavilhao;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JPanel jPlanejamento;
    private javax.swing.JRadioButton jRBPrimeira;
    private javax.swing.JRadioButton jRBReforco;
    private javax.swing.JRadioButton jRBSegunda;
    private javax.swing.JRadioButton jRBTerceira;
    private javax.swing.JTextField jRecursos;
    public static javax.swing.JTextField jRegime;
    public static javax.swing.JTextField jRegimeAVI;
    private javax.swing.JTextField jResponsavel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextField jStatusAtend;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAdmissaoPsicologica;
    public static javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaInternosAvIndividual;
    private javax.swing.JTable jTabelaPlanejamento;
    private javax.swing.JTextArea jTextoAvalaicaoIndividual;
    private javax.swing.JTextArea jTextoAvaliacaoGrupo;
    private javax.swing.JLabel jtotalRegistros;
    public static javax.swing.JLabel jtotalRegistrosInternos;
    private javax.swing.JLabel jtotalRegistrosInternosAVI;
    private javax.swing.JLabel jtotalRegistrosPlanejamento;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        // ABA MANUTENÇÃO
        jCodigoAtend.setBackground(Color.white);
        jStatusAtend.setBackground(Color.white);
        jDataAtend.setBackground(Color.white);
        jResponsavel.setBackground(Color.white);
        jComboBoxPavilhaoGaleria.setBackground(Color.white);
        jComboBoxAmbiente.setBackground(Color.white);
        jHorarioInicio.setBackground(Color.white);
        jHorarioTermino.setBackground(Color.white);
        jLocalAtividade.setBackground(Color.white);
        jGrupoAtividade.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        // ABA PLANEJAMENTO
        jCodigoTema.setBackground(Color.white);
        jComboBoxTema.setBackground(Color.white);
        jHorarioInicialTema.setBackground(Color.white);
        jHorarioFinalTema.setBackground(Color.white);
        jComboBoxTurno.setBackground(Color.white);
        jAtividades.setBackground(Color.white);
        jRecursos.setBackground(Color.white);
        // ABA PARTICIPANTES
        jIdInternoGrp.setBackground(Color.white);
        jCNC.setBackground(Color.white);
        jRegime.setBackground(Color.white);
        jDataNascimento.setBackground(Color.white);
        jNomeInternoGrp.setBackground(Color.white);
        jNomeMae.setBackground(Color.white);
        jPavilhao.setBackground(Color.white);
        jCela.setBackground(Color.white);
        // AVALIAÇÃO E M GRUPO
        jTextoAvaliacaoGrupo.setBackground(Color.white);
        // AVALIAÇÃO INDIVIDUAL
        jIdInternoAI.setBackground(Color.white);
        jCNCAI.setBackground(Color.white);
        jRegimeAVI.setBackground(Color.white);
        jNomeInternoAVI.setBackground(Color.white);
        jNomeMaeInternoAVI.setBackground(Color.white);
    }

    public void formatarCampos() {
        jTextoAvaliacaoGrupo.setLineWrap(true);
        jTextoAvaliacaoGrupo.setWrapStyleWord(true);
        //
        jTextoAvalaicaoIndividual.setLineWrap(true);
        jTextoAvalaicaoIndividual.setWrapStyleWord(true);
    }

    public void opcaoVacinas(boolean flag) {
        jComboBoxTipoVacina.setEnabled(flag);
        jRBPrimeira.setEnabled(flag);
        jRBSegunda.setEnabled(flag);
        jRBTerceira.setEnabled(flag);
        jRBReforco.setEnabled(flag);
    }

    public void bloquearTodosBotoes() {
        // ABA MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        // ABA PLANEJAMENTO
        jBtNovoPlan.setEnabled(!true);
        jBtAlterarPlan.setEnabled(!true);
        jBtExcluirPlan.setEnabled(!true);
        jBtSalvarPlan.setEnabled(!true);
        jBtCancelarPlan.setEnabled(!true);
        jBtAuditoriaPlan.setEnabled(!true);
        // ABA PARTICIPANTES
        jBtNovoParticipantes.setEnabled(!true);
        jBtAlterarParticipantes.setEnabled(!true);
        jBtExcluirParticipantes.setEnabled(!true);
        jBtSalvarParticipantes.setEnabled(!true);
        jBtCancelarParticipantes.setEnabled(!true);
        jBtAuditoriaParticipantes.setEnabled(!true);
        jBtPesquisarPart.setEnabled(!true);
        // ABA AVALIAÇÃO EM GRUPO
        jBtNovoAvGrupo.setEnabled(!true);
        jBtAlterarAvGrupo.setEnabled(!true);
        jBtExcluirAvGrupo.setEnabled(!true);
        jBtSalvarAvGrupo.setEnabled(!true);
        jBtCancelarAvGrupo.setEnabled(!true);
        jBtAuditoriaAvGrupo.setEnabled(!true);
        // ABA AVALIAÇÃO INDIVIDUAL
        jBtNovoAvInd.setEnabled(!true);
        jBtAlterarAvInd.setEnabled(!true);
        jBtExcluirAvInd.setEnabled(!true);
        jBtSalvarAvInd.setEnabled(!true);
        jBtCancelarAvInd.setEnabled(!true);
        jBtAuditoriaAvInd.setEnabled(!true);
        jBtPesqInternoAVI.setEnabled(!true);
    }

    public void bloquearTodosCampos() {
        // ABA MANUTENÇÃO
        jCodigoAtend.setEnabled(!true);
        jStatusAtend.setEnabled(!true);
        jDataAtend.setEnabled(!true);
        jResponsavel.setEnabled(!true);
        jComboBoxPavilhaoGaleria.setEnabled(!true);
        jComboBoxAmbiente.setEnabled(!true);
        jHorarioInicio.setEnabled(!true);
        jHorarioTermino.setEnabled(!true);
        jLocalAtividade.setEnabled(!true);
        jGrupoAtividade.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // ABA PLANEJAMENTO
        jCodigoTema.setEnabled(!true);
        jComboBoxTurno.setEnabled(!true);
        jComboBoxTema.setEnabled(!true);
        jHorarioInicialTema.setEnabled(!true);
        jHorarioFinalTema.setEnabled(!true);
        jAtividades.setEnabled(!true);
        jRecursos.setEnabled(!true);
        // ABA PARTICIPANTES
        jIdInternoGrp.setEnabled(!true);
        jCNC.setEnabled(!true);
        jRegime.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInternoGrp.setEnabled(!true);
        jNomeMae.setEnabled(!true);
        jPavilhao.setEnabled(!true);
        jCela.setEnabled(!true);
        // AVALIAÇÃO E M GRUPO
        jTextoAvaliacaoGrupo.setEnabled(!true);
        // AVALIAÇÃO INDIVIDUAL
        jIdInternoAI.setEnabled(!true);
        jCNCAI.setEnabled(!true);
        jRegimeAVI.setEnabled(!true);
        jNomeInternoAVI.setEnabled(!true);
        jNomeMaeInternoAVI.setEnabled(!true);
        jTextoAvalaicaoIndividual.setEnabled(!true);
    }

    public void limparTodosCampos() {
        // ABA MANUTENÇÃO
        jCodigoAtend.setText("");
        jStatusAtend.setText("");
        jDataAtend.setDate(null);
        jResponsavel.setText("");
        jComboBoxPavilhaoGaleria.setSelectedItem("Selecione...");
        jComboBoxAmbiente.setSelectedItem("Selecione...");
        jHorarioInicio.setText("");
        jHorarioTermino.setText("");
        jLocalAtividade.setText("");
        jGrupoAtividade.setText("");
        jObservacao.setText("");
        // ABA PLANEJAMENTO
        jCodigoTema.setText("");
        jComboBoxTurno.setSelectedItem("Selecione...");
        jComboBoxTema.setSelectedItem("Selecione...");
        jHorarioInicialTema.setText("");
        jHorarioFinalTema.setText("");
        jAtividades.setText("");
        jRecursos.setText("");
        // ABA PARTICIPANTES
        jIdInternoGrp.setText("");
        jCNC.setText("");
        jRegime.setText("");
        jDataNascimento.setDate(null);
        jNomeInternoGrp.setText("");
        jNomeMae.setText("");
        jPavilhao.setText("");
        jCela.setText("");
        jFotoInternoGrupo.setIcon(null);
        // AVALIAÇÃO E M GRUPO
        jTextoAvaliacaoGrupo.setText("");
        // AVALIAÇÃO INDIVIDUAL
        jIdInternoAI.setText("");
        jCNCAI.setText("");
        jRegimeAVI.setText("");
        jNomeInternoAVI.setText("");
        jNomeMaeInternoAVI.setText("");
    }

    public void limparCamposPlanejamento() {
        jCodigoTema.setText("");
        jComboBoxTurno.setSelectedItem("Selecione...");
        jComboBoxTema.setSelectedItem("Selecione...");
        jHorarioInicialTema.setText("");
        jHorarioFinalTema.setText("");
        jAtividades.setText("");
        jRecursos.setText("");
    }

    public void limparCamposParticipantes() {
        jIdInternoGrp.setText("");
        jCNC.setText("");
        jRegime.setText("");
        jDataNascimento.setDate(null);
        jNomeInternoGrp.setText("");
        jNomeMae.setText("");
        jPavilhao.setText("");
        jCela.setText("");
        jFotoInternoGrupo.setIcon(null);
    }

    public void limparCamposAVG() {
        jTextoAvaliacaoGrupo.setText("");
    }

    public void limparCamposAVI() {
        jIdInternoAI.setText("");
        jCNCAI.setText("");
        jRegimeAVI.setText("");
        jNomeInternoAVI.setText("");
        jNomeMaeInternoAVI.setText("");
        jTextoAvalaicaoIndividual.setText("");
    }

    public void Novo() {
        jStatusAtend.setText("ABERTO");
        jDataAtend.setCalendar(Calendar.getInstance());
        jResponsavel.setText(nameUser);
        jHorarioInicio.setText("00:00");
        jHorarioTermino.setText("00:00");
        //
        jComboBoxPavilhaoGaleria.setEnabled(true);
        jComboBoxAmbiente.setEnabled(true);
        jHorarioInicio.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        jLocalAtividade.setEnabled(true);
        jGrupoAtividade.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jComboBoxPavilhaoGaleria.setEnabled(true);
        jComboBoxAmbiente.setEnabled(true);
        jHorarioInicio.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        jLocalAtividade.setEnabled(true);
        jGrupoAtividade.setEnabled(true);
        jObservacao.setEnabled(true);
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
        jBtNovoPlan.setEnabled(true);
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void Cancelar() {
        if (jCodigoAtend.getText().equals("")) {
            limparTodosCampos();
            bloquearTodosBotoes();
            bloquearTodosCampos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearTodosBotoes();
            bloquearTodosCampos();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoPlan.setEnabled(true);
            jBtNovoParticipantes.setEnabled(true);
            jBtNovoAvGrupo.setEnabled(true);
            jBtNovoAvInd.setEnabled(true);
        }
    }

    public void buscarCodigoManutencao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM");
            conecta.rs.last();
            jCodigoAtend.setText(conecta.rs.getString("IdAtGrupoEnf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void pesquisarPlanejamento() {
        jComboBoxTema.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PLANEJAMENTO_ATIVIDADES_GRUPO "
                    + "WHERE Sigla='" + pSIGLA + "' "
                    + "ORDER BY DescricaoPlaneja,Setor");
            conecta.rs.first();
            do {
                jComboBoxTema.addItem(conecta.rs.getString("DescricaoPlaneja"));
            } while (conecta.rs.next());
            jComboBoxTema.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }
    
    public void pesquisarTipoVacina() {
        jComboBoxTipoVacina.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TIPOS_VACINAS "
                    + "ORDER BY DescricaoVacina");
            conecta.rs.first();
            do {
                jComboBoxTipoVacina.addItem(conecta.rs.getString("DescricaoVacina"));
            } while (conecta.rs.next());
            jComboBoxTipoVacina.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void verificarRegistros() {
        conecta.abrirConexao();
        //PLANEJAMENTO DE ATENDIMENTO
        try {
            conecta.executaSQL("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "WHERE IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            pCODIGO_ATENDE_PLAN = conecta.rs.getString("IdAtGrupoEnf");
        } catch (Exception e) {
        }
        //PARTICIPANTES
        try {
            conecta.executaSQL("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "WHERE IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            pCODIGO_ATENDE_PART = conecta.rs.getString("IdAtGrupoEnf");
        } catch (Exception e) {
        }
        //AVALIAÇÃO EM GRUPO
        try {
            conecta.executaSQL("SELECT * FROM AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "WHERE IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            pCODIGO_ATENDE_AVAG = conecta.rs.getString("IdAtGrupoPsi");
        } catch (Exception e) {
        }
        //AVALIAÇÃO INDIVIDUAL
        try {
            conecta.executaSQL("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "WHERE IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            pCODIGO_ATENDE_AVAI = conecta.rs.getString("IdAtGrupoEnf");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoPlan() {
        jHorarioInicialTema.setText("00:00");
        jHorarioFinalTema.setText("00:00");
        //        
        jComboBoxTema.setEnabled(true);
        jHorarioInicialTema.setEnabled(true);
        jHorarioFinalTema.setEnabled(true);
        jComboBoxTurno.setEnabled(true);
        jAtividades.setEnabled(true);
        jRecursos.setEnabled(true);
        //
        jBtSalvarPlan.setEnabled(true);
        jBtCancelarPlan.setEnabled(true);
    }

    public void AlterarPlan() {
        jComboBoxTema.setEnabled(true);
        jHorarioInicialTema.setEnabled(true);
        jHorarioFinalTema.setEnabled(true);
        jComboBoxTurno.setEnabled(true);
        jAtividades.setEnabled(true);
        jRecursos.setEnabled(true);
        //
        jBtSalvarPlan.setEnabled(true);
        jBtCancelarPlan.setEnabled(true);
    }

    public void ExcluirPlan() {
        jBtNovoPlan.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void SalvarPlan() {
        jBtNovoPlan.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void CancelarPlan() {
        bloquearTodosBotoes();
        bloquearTodosCampos();
        limparCamposPlanejamento();
        jBtNovoPlan.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void buscarCodigoPlanejamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM");
            conecta.rs.last();
            jCodigoTema.setText(conecta.rs.getString("IdItemPlanEnf"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void NovoParticipante() {
        jBtPesquisarPart.setEnabled(true);
        jBtSalvarParticipantes.setEnabled(true);
        jBtCancelarParticipantes.setEnabled(true);
    }

    public void AlterarParticipante() {
        jBtPesquisarPart.setEnabled(true);
        jBtSalvarParticipantes.setEnabled(true);
        jBtCancelarParticipantes.setEnabled(true);
    }

    public void ExcluirParticipante() {
        jBtNovoParticipantes.setEnabled(true);
        //
        jBtNovoPlan.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarParticipante() {
        jBtNovoParticipantes.setEnabled(true);
        //
        jBtNovoPlan.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarParticipante() {
        bloquearTodosBotoes();
        bloquearTodosCampos();
        limparCamposParticipantes();
        jBtNovoParticipantes.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoPlan.setEnabled(true);
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void buscarCodigoParticipantes() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM");
            conecta.rs.last();
            pCODIGO_ITEM_PARTICIPANTE = conecta.rs.getInt("IdItemPartEnf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void NovoAVG() {
        jTextoAvaliacaoGrupo.setText("");
        jTextoAvaliacaoGrupo.setEnabled(true);
        //
        jBtSalvarAvGrupo.setEnabled(true);
        jBtCancelarAvGrupo.setEnabled(true);
    }

    public void AlterarAVG() {
        jTextoAvaliacaoGrupo.setEnabled(true);
        //
        jBtSalvarAvGrupo.setEnabled(true);
        jBtCancelarAvGrupo.setEnabled(true);
    }

    public void ExcluirAVG() {
        jTextoAvaliacaoGrupo.setText("");
        jBtNovoAvGrupo.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoPlan.setEnabled(true);
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void SalvarAVG() {
        jBtNovoAvGrupo.setEnabled(true);
        jBtAlterarAvGrupo.setEnabled(true);
        jBtExcluirAvGrupo.setEnabled(true);
        jBtAuditoriaAvGrupo.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoPlan.setEnabled(true);
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void CancelarAVG() {
        bloquearTodosBotoes();
        bloquearTodosCampos();
        jBtNovoAvGrupo.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovoPlan.setEnabled(true);
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoAvInd.setEnabled(true);
    }

    public void buscarCodigoAVG() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM");
            conecta.rs.last();
            pCODIGO_AVALIACAO_GRUPO = conecta.rs.getInt("IdItemAvagEnf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void buscarAvaliacaoGrupo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "ON AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                    + "WHERE AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            pCODIGO_AVALIACAO_GRUPO = conecta.rs.getInt("IdItemAvagEnf");
            jTextoAvaliacaoGrupo.setText(conecta.rs.getString("TextoAvalaiacaoGrupo"));
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        if (pCODIGO_AVALIACAO_GRUPO != 0) {
            jBtNovoAvGrupo.setEnabled(true);
            jBtAlterarAvGrupo.setEnabled(true);
            jBtExcluirAvGrupo.setEnabled(true);
            jBtAuditoriaAvGrupo.setEnabled(true);
        }
    }

    public void verificarExistenciaRegistroAVG() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "WHERE IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            pCODIGO_AVALIACAO_GRUPO_AVG = conecta.rs.getInt("IdAtGrupoEnf");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoAVGI() {
        jTextoAvalaicaoIndividual.setEnabled(true);
        //
        jBtPesqInternoAVI.setEnabled(true);
        jBtSalvarAvInd.setEnabled(true);
        jBtCancelarAvInd.setEnabled(true);
    }

    public void AlterarAVGI() {
        jTextoAvalaicaoIndividual.setEnabled(true);
        //
        jBtPesqInternoAVI.setEnabled(true);
        jBtSalvarAvInd.setEnabled(true);
        jBtCancelarAvInd.setEnabled(true);
    }

    public void ExcluirAVGI() {
        jBtNovoAvInd.setEnabled(true);
        //
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoPlan.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarAVGI() {
        jBtNovoAvInd.setEnabled(true);
        //
        jBtNovoAvGrupo.setEnabled(true);
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoPlan.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarAVGI() {
        bloquearTodosBotoes();
        bloquearTodosCampos();
        limparCamposAVI();
        jBtNovoAvInd.setEnabled(true);
        //
        jBtNovoAvGrupo.setEnabled(true);
        jBtAlterarAvGrupo.setEnabled(true);
        jBtExcluirAvGrupo.setEnabled(true);
        jBtAuditoriaAvGrupo.setEnabled(true);
        //
        jBtNovoParticipantes.setEnabled(true);
        jBtNovoPlan.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCodigoAVI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM ");
            conecta.rs.last();
            pCODIGO_AVALIACAO_GRUPO_AVGI = conecta.rs.getInt("IdItemAvaiEnf");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarLiberacao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP ");
            conecta.rs.first();
            pCODIGO_AVALIACAO_GRUPO_AVGI = conecta.rs.getInt("IdItemAvaiEnf");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //ABA MANUTENÇÃO
    public void preencherTabelaAtividadeGRU(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Pavilhão", "Local Atividade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataAtend");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAtGrupoEnf"), dataEntrada, conecta.rs.getString("StatusAtendGrupo"), conecta.rs.getString("DescricaoPav"), conecta.rs.getString("LocalAtividade")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPsicologica.setModel(modelo);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoPsicologica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPsicologica.setAutoResizeMode(jTabelaAdmissaoPsicologica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPsicologica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Pavilhão", "Local Atividade"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPsicologica.setModel(modelo);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaAdmissaoPsicologica.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdmissaoPsicologica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPsicologica.setAutoResizeMode(jTabelaAdmissaoPsicologica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPsicologica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    //ABA PLANEJAMENTO
    public void preencherTabelaPlanejamento(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "H.Inicial", "H.Final", "Atividade", "Recurso"};
        conecta.abrirConexao();
        count0 = 0;
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count0 = count0 + 1;
                jtotalRegistrosPlanejamento.setText(Integer.toString(count0)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItemPlanEnf"), conecta.rs.getString("HoraInicio"), conecta.rs.getString("HoraTermino"), conecta.rs.getString("Atividades"), conecta.rs.getString("Recursos")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPlanejamento.setModel(modelo);
        jTabelaPlanejamento.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPlanejamento.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPlanejamento.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPlanejamento.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaPlanejamento.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaPlanejamento.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPlanejamento.getTableHeader().setReorderingAllowed(false);
        jTabelaPlanejamento.setAutoResizeMode(jTabelaPlanejamento.AUTO_RESIZE_OFF);
        jTabelaPlanejamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPlanejamento();
        conecta.desconecta();
    }

    public void alinharCamposTabelaPlanejamento() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPlanejamento.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPlanejamento.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPlanejamento.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaPlanejamento() {
        count0 = 0;
        jtotalRegistrosPlanejamento.setText(Integer.toString(count0));
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "H.Inicial", "H.Final", "Atividade", "Recurso"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPlanejamento.setModel(modelo);
        jTabelaPlanejamento.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPlanejamento.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPlanejamento.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPlanejamento.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTabelaPlanejamento.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPlanejamento.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaPlanejamento.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPlanejamento.getTableHeader().setReorderingAllowed(false);
        jTabelaPlanejamento.setAutoResizeMode(jTabelaPlanejamento.AUTO_RESIZE_OFF);
        jTabelaPlanejamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    //ABA PARTICIPANTES
    public void preencherTabelaParticipantes(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count1 = 0;
            do {
                count1 = count1 + 1;
                jtotalRegistrosInternos.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItemPartEnf"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("Cnc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaParticipantes();
        conecta.desconecta();
    }

    public void alinharCamposTabelaParticipantes() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(2).setCellRenderer(direita);
    }

    public void limparTabelaParticipantes() {
        count1 = 0;
        jtotalRegistrosInternos.setText(Integer.toString(count1));
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    //ABA AVALIAÇÃO INDIVIDUAL
    public void preencherTabelaAvaliacaoIndividual(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count2 = 0;
            do {
                count2 = count2 + 1;
                jtotalRegistrosInternosAVI.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItemAvaiEnf"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("Cnc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosAvIndividual.setModel(modelo);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternosAvIndividual.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosAvIndividual.setAutoResizeMode(jTabelaInternosAvIndividual.AUTO_RESIZE_OFF);
        jTabelaInternosAvIndividual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAvaliacaoIndividual();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAvaliacaoIndividual() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setCellRenderer(direita);
    }

    public void limparTabelaAvaliacaoIndividual() {
        count2 = 0;
        jtotalRegistrosInternosAVI.setText(Integer.toString(count2));
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosAvIndividual.setModel(modelo);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternosAvIndividual.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternosAvIndividual.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosAvIndividual.setAutoResizeMode(jTabelaInternosAvIndividual.AUTO_RESIZE_OFF);
        jTabelaInternosAvIndividual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherComboBoxPavilhao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhaoGaleria.addItem(conecta.rs.getString("DescricaoPav"));
                jComboBoxNivelPavilhao.addItem(conecta.rs.getString("NivelPav"));
            } while (conecta.rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos!!!\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarUsuarioCriador() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTO_GRUPO_ENFERMAGEM "
                    + "WHERE IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
            conecta.rs.first();
            nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAtend.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoTema.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(pCODIGO_ITEM_PARTICIPANTE);
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(pCODIGO_AVALIACAO_GRUPO);
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(pCODIGO_AVALIACAO_GRUPO_AVGI));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
