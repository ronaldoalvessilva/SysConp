/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdmissaoEvolucaoEF;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovEFEvolucao;
import gestor.Controle.ControleMovEducacaiFisica;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Controle.listarAdmissaoDatas;
import gestor.Controle.listarAdmissaoInternos;
import gestor.Controle.listarTodosRegistros;
import gestor.Controle.listarTodosRegistrosEvolucao;
import gestor.Controle.listarTodosRegistrosEvolucao_REGISTRO;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEvolucaoEducacaoFisica;
import gestor.Modelo.AdmissaoPsicologica;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEducacaoFisica.codAbrirEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codAlterarEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codConsultarEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codExcluirEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codGravarEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codIncluirEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codUserAcessoEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codigoGrupoEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codigoUserEF;
import static gestor.Visao.TelaModuloEducacaoFisica.codigoUserGroupEF;
import static gestor.Visao.TelaModuloEducacaoFisica.nomeGrupoEF;
import static gestor.Visao.TelaModuloEducacaoFisica.nomeModuloEF;
import static gestor.Visao.TelaModuloEducacaoFisica.nomeTelaEF;
import static gestor.Visao.TelaModuloEducacaoFisica.telaAdmissoEvol_EF;
import static gestor.Visao.TelaModuloEducacaoFisica.telaAdmissoManu_EF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloTerapiaOcupacional.pQUANTIDADE_ATENDIDA;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaAdmissaoEvolucoEF extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEvolucaoEducacaoFisica objAdmissao = new AdmissaoEvolucaoEducacaoFisica();
    ControleAdmissaoEvolucaoEF control = new ControleAdmissaoEvolucaoEF();
    listarTodosRegistros listaTodos = new listarTodosRegistros();
    listarAdmissaoDatas listarPorData = new listarAdmissaoDatas();
    listarAdmissaoInternos listarPorNome = new listarAdmissaoInternos();
    //EVOLUÇÃO
    listarTodosRegistrosEvolucao listaEvo = new listarTodosRegistrosEvolucao();
    listarTodosRegistrosEvolucao_REGISTRO lista_REGISTRO = new listarTodosRegistrosEvolucao_REGISTRO();
    //
    AdmissaoPsicologica objAdmPsi = new AdmissaoPsicologica();
    ControleMovEducacaiFisica controle = new ControleMovEducacaiFisica();
    ControleMovEFEvolucao controleEvo = new ControleMovEFEvolucao();
    // INFORMAR QUE O INTERNO FOI ATENDIDO NA ADMISSÃO E NA EVOLUÇÃO
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
    // PARA O ATENDIMENTO NA TV
    ControleConfirmacaoAtendimento control_ATENDE = new ControleConfirmacaoAtendimento();
    //PORTA DE ENTRADA
    PortaEntrada objPortaEntrada = new PortaEntrada();
    ControlePortaEntrada control_PE = new ControlePortaEntrada();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Educação Física:Admissão Educação Física:Manutenção";
    String nomeModuloTela1 = "Educação Física:Admissão Educação Física:Evolução";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //    
    int acao;
    int flag;
    int count = 0;
    String dataInicial, dataFinal;
    public static int pTOTAL_REGISTROS_ATIVIDADES = 0;
    String nomeUserRegistro = "";
    String pCODIGO_INTERNO = "";
    String pID_EVOLUCAO = "";
    String caminho = "";
    String pDATA_PESQUISA_TABELA = "";
    String pHabilitaEducacaoFisica = "";
    public static int codigoDepartamentoEF = 0;
    public static int idItemEvolucao = 0;
    String pDATA_PESQUISA_EVOLUCAO = "";
    String pADMISSAO_EVOLUCAO = "Sim";
    String pADM_EVOLUCAO = "";
    public static String pIDEVOLUCAO = "";
    //RESPONDE COMO NÃO PARA NÃO FAZER OUTRA ADMISSÃO QUANDO O INTERNO CHEGAR PELA PRIMEIRA VEZ
    String pHABILITA_EDUCACAO_FISICA = "Não";
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    String atendido = "Sim";
    String tipoAtendimentoAdm = "Admissão Educação Física";
    String tipoAtendimentoEvol = "Evolução Educação Física";
    String deptoTecnico = "EDUCAÇÃO FÍSICA";
    String dataReg = "";
    String codigoInternoAtend = "";
    String opcao = "Não";
    String statusEvolucao = "EVOLUINDO";
    //

    /**
     * Creates new form TelaAdmissaoEvolucoEF
     */
    public static TelaAdmissaoEF_SECUNDARIA pADM_secundaria;

    public TelaAdmissaoEvolucoEF() {
        initComponents();
        corCampos();
        formataCampos();
    }

    public void mostrarTelaNovaAdm() {
        pADM_secundaria = new TelaAdmissaoEF_SECUNDARIA(this, true);
        pADM_secundaria.setVisible(true);
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
        jPanel15 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jID_REGISTRO_Pesquisa = new javax.swing.JTextField();
        jBtIDPesq = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesquisarInternos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaAdmissaoEF = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdRegistroEF = new javax.swing.JTextField();
        jStatusEF = new javax.swing.JTextField();
        jDataRegistroEF = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jIdInternoEF = new javax.swing.JTextField();
        jNomeInternoEF = new javax.swing.JTextField();
        jMatriculaEF = new javax.swing.JTextField();
        jDataNascimentoEF = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPesoEF = new javax.swing.JTextField();
        jAlturaEF = new javax.swing.JTextField();
        jBtPesquisarInterno = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtNovaAdmissao = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxAtividadeFisica = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFrequenciaSemanal = new javax.swing.JTextField();
        jComboBoxNivelCondicionamento = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxRestricaoAtividadeFisica = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jQualRestricaoFisica = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxProblemaCardiaco = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jQualProblemaCardiaco = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxAlgumTipoCirurgia = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jEspecificarCirurgia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxProblemaOrtopedico = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxHabitoFumar = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jQuantosCigarros = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxAlgumMedicamento = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jEspecificarMedicamento = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxDiabetico = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxPressaoSanguinea = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxDoresPeito = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxDesmaio = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextoEvolucaoAdmissao = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEvolucaoEF = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jIdInternoEEF = new javax.swing.JTextField();
        jNomeInternoEEF = new javax.swing.JTextField();
        jDataEvolucaoEF = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextoEvolucaoEF = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jFotoInternoEF = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Admissão/Evolução Educação Física :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Código:");

        jID_REGISTRO_Pesquisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REGISTRO_Pesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIDPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIDPesq.setContentAreaFilled(false);
        jBtIDPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIDPesqActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Data Final:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Nome Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisarInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInternos.setContentAreaFilled(false);
        jBtPesquisarInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(232, 232, 232)
                            .addComponent(jCheckBox1))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jID_REGISTRO_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jBtPesquisarInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jID_REGISTRO_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIDPesq)
                    .addComponent(jCheckBox1))
                .addGap(3, 3, 3)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel31)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInternos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAdmissaoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdmissaoEF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaAdmissaoEF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdmissaoEFMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaAdmissaoEF);
        if (jTabelaAdmissaoEF.getColumnModel().getColumnCount() > 0) {
            jTabelaAdmissaoEF.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAdmissaoEF.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAdmissaoEF.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAdmissaoEF.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAdmissaoEF.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoEF.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoEF.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaAdmissaoEF.getColumnModel().getColumn(3).setMaxWidth(300);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdRegistroEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistroEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistroEF.setEnabled(false);

        jStatusEF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusEF.setForeground(new java.awt.Color(204, 0, 0));
        jStatusEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusEF.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusEF.setEnabled(false);

        jDataRegistroEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistroEF.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jIdRegistroEF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jStatusEF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataRegistroEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistroEF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistroEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Interno");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nascimento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Matricula");

        jIdInternoEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoEF.setEnabled(false);

        jNomeInternoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEF.setEnabled(false);

        jMatriculaEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaEF.setEnabled(false);

        jDataNascimentoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimentoEF.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Peso");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Altura");

        jPesoEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPesoEF.setText("0");
        jPesoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPesoEF.setEnabled(false);

        jAlturaEF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAlturaEF.setText("0");
        jAlturaEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlturaEF.setEnabled(false);

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setToolTipText("Pesquisar Interno");
        jBtPesquisarInterno.setContentAreaFilled(false);
        jBtPesquisarInterno.setEnabled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoEF)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIdInternoEF, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jMatriculaEF, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jDataNascimentoEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jPesoEF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jAlturaEF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdInternoEF, jMatriculaEF});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarInterno)
                    .addComponent(jAlturaEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesoEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascimentoEF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
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

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
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
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtNovaAdmissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/290718163923_16.png"))); // NOI18N
        jBtNovaAdmissao.setToolTipText("Nova Admissão");
        jBtNovaAdmissao.setEnabled(false);
        jBtNovaAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaAdmissaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtNovaAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovaAdmissao, jBtNovo, jBtSair, jBtSalvar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtSair)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterar))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Praticava algum tipo de atividade física?");

        jComboBoxAtividadeFisica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAtividadeFisica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxAtividadeFisica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAtividadeFisica.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Com que frequência semanal? ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nível de condicionamento:");

        jFrequenciaSemanal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFrequenciaSemanal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFrequenciaSemanal.setEnabled(false);

        jComboBoxNivelCondicionamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNivelCondicionamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Sedentário", "Ativo", "Atleta" }));
        jComboBoxNivelCondicionamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNivelCondicionamento.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Restrição a prática de atividade física?");
        jLabel13.setToolTipText("Algum médico disse que você tem alguma restrição a prática de atividade física?");

        jComboBoxRestricaoAtividadeFisica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRestricaoAtividadeFisica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxRestricaoAtividadeFisica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRestricaoAtividadeFisica.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Qual?");

        jQualRestricaoFisica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualRestricaoFisica.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Possui algum tipo de problema cardíaco?");

        jComboBoxProblemaCardiaco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProblemaCardiaco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxProblemaCardiaco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProblemaCardiaco.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Qual?");

        jQualProblemaCardiaco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualProblemaCardiaco.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAtividadeFisica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxRestricaoAtividadeFisica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFrequenciaSemanal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBoxNivelCondicionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProblemaCardiaco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualProblemaCardiaco, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualRestricaoFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jQualProblemaCardiaco, jQualRestricaoFisica});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxAtividadeFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jFrequenciaSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxNivelCondicionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxRestricaoAtividadeFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jQualRestricaoFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxProblemaCardiaco, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jQualProblemaCardiaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane2.addTab("Parte - I", jPanel8);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Foi submetido a algum tipo de cirurgia?  ");

        jComboBoxAlgumTipoCirurgia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlgumTipoCirurgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxAlgumTipoCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlgumTipoCirurgia.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Especifique:");

        jEspecificarCirurgia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEspecificarCirurgia.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Alguma lesão ou problema ortopédico?");
        jLabel19.setToolTipText("Você tem alguma lesão ou problema ortopédico (ex.: bursite, fratura, dores no joelho, dores nas costas, etc...)?  ");

        jComboBoxProblemaOrtopedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProblemaOrtopedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxProblemaOrtopedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProblemaOrtopedico.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Tem ou teve o hábito de fumar?");

        jComboBoxHabitoFumar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHabitoFumar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxHabitoFumar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHabitoFumar.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Quantos cigarros ao dia?");

        jQuantosCigarros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosCigarros.setText("0");
        jQuantosCigarros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosCigarros.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Utiliza regular. algum medicamento?");
        jLabel22.setToolTipText("Utiliza regularmente algum tipo de medicamento?");

        jComboBoxAlgumMedicamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlgumMedicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxAlgumMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlgumMedicamento.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Especifique:");

        jEspecificarMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEspecificarMedicamento.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAlgumTipoCirurgia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEspecificarCirurgia))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProblemaOrtopedico, 0, 90, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxHabitoFumar, 0, 90, Short.MAX_VALUE)
                            .addComponent(jQuantosCigarros)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAlgumMedicamento, 0, 90, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEspecificarMedicamento)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxAlgumTipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jEspecificarCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxProblemaOrtopedico, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxHabitoFumar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuantosCigarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxAlgumMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jEspecificarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane2.addTab("Parte - II", jPanel9);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("É diabético?");

        jComboBoxDiabetico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxDiabetico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetico.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText(" Apresenta pressão sanguínea alta?  ");

        jComboBoxPressaoSanguinea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPressaoSanguinea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxPressaoSanguinea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPressaoSanguinea.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Apresenta dores no peito com frequência?  ");

        jComboBoxDoresPeito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDoresPeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxDoresPeito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDoresPeito.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Episódios de tontura, sensação desmaio? ");
        jLabel27.setToolTipText("Apresenta frequentemente episódios de tontura ou sensação de desmaio? ");

        jComboBoxDesmaio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDesmaio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxDesmaio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDesmaio.setEnabled(false);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDiabetico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPressaoSanguinea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDoresPeito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDesmaio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxDesmaio, jComboBoxDiabetico, jComboBoxDoresPeito, jComboBoxPressaoSanguinea});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDiabetico, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxPressaoSanguinea, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBoxDoresPeito, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxDesmaio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane2.addTab("Parte - III", jPanel11);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextoEvolucaoAdmissao.setColumns(20);
        jTextoEvolucaoAdmissao.setRows(5);
        jTextoEvolucaoAdmissao.setText("DIGITE AQUI A EVOLUÇÃO DA ADMISSÃO.");
        jTextoEvolucaoAdmissao.setToolTipText("");
        jTextoEvolucaoAdmissao.setEnabled(false);
        jScrollPane1.setViewportView(jTextoEvolucaoAdmissao);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane2.addTab("Evolução", jPanel13);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Admissão", jPanel2);

        jTabelaEvolucaoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoEF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Data", "Texto da Evolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaEvolucaoEF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoEFMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEvolucaoEF);
        if (jTabelaEvolucaoEF.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoEF.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaEvolucaoEF.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaEvolucaoEF.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaEvolucaoEF.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaEvolucaoEF.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaEvolucaoEF.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaEvolucaoEF.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaEvolucaoEF.getColumnModel().getColumn(3).setMaxWidth(300);
        }

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setToolTipText("Nova Evolução");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setToolTipText("Alterar Evolução");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir Evolução");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar Evolução");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setToolTipText("Cancelar Operação");
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setToolTipText("Auditoria");
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Código");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Nome do Interno");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Data");

        jIdInternoEEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoEEF.setEnabled(false);

        jNomeInternoEEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEEF.setEnabled(false);

        jDataEvolucaoEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucaoEF.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jIdInternoEEF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoEEF)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEvolucaoEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoEEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolucaoEF, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoEEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Texto da Evolução");

        jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextoEvolucaoEF.setColumns(20);
        jTextoEvolucaoEF.setRows(5);
        jTextoEvolucaoEF.setEnabled(false);
        jScrollPane4.setViewportView(jTextoEvolucaoEF);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 329, Short.MAX_VALUE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Evolução", jPanel3);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoEF, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoEF, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel19, jPanel20, jPanel21});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setBounds(300, 60, 616, 487);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIDPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIDPesqActionPerformed
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAdmissaoEF.getModel().getRowCount();
        if (jID_REGISTRO_Pesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ID para pesquisa.");
            jID_REGISTRO_Pesquisa.requestFocus();
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAdmissaoEF.getModel();
            try {
                for (AdmissaoEvolucaoEducacaoFisica dd : control.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataRegistroEF());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getIdRegistroEF(), pDATA_PESQUISA_TABELA, dd.getStatusEF(), dd.getNomeInternoEF()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAdmissaoEF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAdmissaoEF.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtIDPesqActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAdmissaoEF.getModel().getRowCount();
        if (evt.getStateChange() == evt.SELECTED) {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAdmissaoEF.getModel();
            try {
                for (AdmissaoEvolucaoEducacaoFisica dd : listaTodos.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataRegistroEF());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getIdRegistroEF(), pDATA_PESQUISA_TABELA, dd.getStatusEF(), dd.getNomeInternoEF()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAdmissaoEF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAdmissaoEF.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAtividadesMensalUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
            DefaultTableModel tblRemove = (DefaultTableModel) jTabelaAdmissaoEF.getModel();
            if (tblRemove.getRowCount() > 0) {
                for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                    tblRemove.removeRow(i);
                    tblRemove.setRowCount(0);
                    if (tblRemove.getRowCount() < i) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                    }
                }
            }
            pTOTAL_REGISTROS_ATIVIDADES = 0;
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAdmissaoEF.getModel().getRowCount();
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else if (jDataPesFinal.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
            jDataPesFinal.requestFocus();
        } else if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAdmissaoEF.getModel();
            try {
                for (AdmissaoEvolucaoEducacaoFisica dd : listarPorData.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataRegistroEF());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getIdRegistroEF(), pDATA_PESQUISA_TABELA, dd.getStatusEF(), dd.getNomeInternoEF()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAdmissaoEF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAdmissaoEF.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jBtPesquisarInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternosActionPerformed
        // TODO add your handling code here:
        flag = 1;
        Integer row0 = jTabelaAdmissaoEF.getModel().getRowCount();
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Infome o nome do interno para pesquisa.");
        } else {
            DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaAdmissaoEF.getModel();
            try {
                for (AdmissaoEvolucaoEducacaoFisica dd : listarPorNome.read()) {
                    if (row0 == 0) {
                        jtotalRegistros.setText(Integer.toString(pTOTAL_REGISTROS_ATIVIDADES)); // Converter inteiro em string para exibir na tela                                
                    }
                    pDATA_PESQUISA_TABELA = String.valueOf(dd.getDataRegistroEF());
                    String dia = pDATA_PESQUISA_TABELA.substring(8, 10);
                    String mes = pDATA_PESQUISA_TABELA.substring(5, 7);
                    String ano = pDATA_PESQUISA_TABELA.substring(0, 4);
                    pDATA_PESQUISA_TABELA = dia + "/" + mes + "/" + ano;
                    dadosDestino.addRow(new Object[]{dd.getIdRegistroEF(), pDATA_PESQUISA_TABELA, dd.getStatusEF(), dd.getNomeInternoEF()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaAdmissaoEF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaAdmissaoEF.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jTabelaAdmissaoEF.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtPesquisarInternosActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoManu_EF) && codIncluirEF == 1) {
            acao = 1;
            limparTodosCampos();
            bloquearTodosBotoes(!true);
            abrirCamposAdm(true);
            limparTabelaEvolucao();
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
        buscarAcessoUsuario(telaAdmissoManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoManu_EF) && codAlterarEF == 1) {
            if (jStatusEF.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarUsuario();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    bloquearTodosBotoes(!true);
                    acao = 2;
                    abrirCamposAdm(true);
                    Alterar();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoManu_EF) && codExcluirEF == 1) {
            if (jStatusEF.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarEvolucao();
                if (jIdRegistroEF.getText().equals(pID_EVOLUCAO)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível excluir a admissão, existem evolução(ões) relacionado(s).");
                } else {
                    verificarUsuario();
                    if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            statusMov = "Excluiu";
                            horaMov = jHoraSistema.getText();
                            dataModFinal = jDataSistema.getText();
                            bloquearTodosBotoes(!true);
                            bloquearTodosCampos(!true);
                            limparTodosCampos();
                            Excluir();
                            objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                            control.excluirAdmissaoEF(objAdmissao);
                            //APAGAR HISTÓRICO DE MOVIMENTAÇÃO DO INTERNO.
                            objAdmPsi.setIdLanc(Integer.valueOf(jIdRegistroEF.getText()));
                            controle.excluirMovTec(objAdmPsi);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                        conecta.desconecta();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoManu_EF) && codGravarEF == 1) {
            DecimalFormat valorReal = new DecimalFormat("###,##00.0");
            valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jIdInternoEF.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jNomeInternoEF.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jPesoEF.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o peso do interno.");
            } else if (jAlturaEF.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a altura do interno.");
            } else if (jQuantosCigarros.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade cigarros do interno.");
            } else {
                objAdmissao.setStatusEF(jStatusEF.getText());
                objAdmissao.setDataRegistroEF(jDataRegistroEF.getDate());
                objAdmissao.setIdInternoEF(Integer.valueOf(jIdInternoEF.getText()));
                objAdmissao.setNomeInternoEF(jNomeInternoEF.getText());
                try {
                    objAdmissao.setPesoEF(valorReal.parse(jPesoEF.getText()).floatValue());
                    objAdmissao.setAlturaEF(valorReal.parse(jAlturaEF.getText()).floatValue());
                } catch (ParseException ex) {
                    Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
                }
                objAdmissao.setAtividadeFisica((String) jComboBoxAtividadeFisica.getSelectedItem());
                objAdmissao.setFrequenciaSemanal(jFrequenciaSemanal.getText());
                objAdmissao.setNivelCondicionamento((String) jComboBoxNivelCondicionamento.getSelectedItem());
                objAdmissao.setRestricaoAtividadeFisica((String) jComboBoxRestricaoAtividadeFisica.getSelectedItem());
                objAdmissao.setQualRestricaoFisica(jQualRestricaoFisica.getText());
                objAdmissao.setProblemaCardiaco((String) jComboBoxProblemaCardiaco.getSelectedItem());
                objAdmissao.setQualProblemaCardiaco(jQualProblemaCardiaco.getText());
                objAdmissao.setAlgumTipoCirurgia((String) jComboBoxAlgumTipoCirurgia.getSelectedItem());
                objAdmissao.setEspecificarCirurgia(jEspecificarCirurgia.getText());
                objAdmissao.setProblemaOrtopedico((String) jComboBoxProblemaOrtopedico.getSelectedItem());
                objAdmissao.setHabitoFumar((String) jComboBoxHabitoFumar.getSelectedItem());
                objAdmissao.setQuantosCigarros(Integer.valueOf(jQuantosCigarros.getText()));
                objAdmissao.setAlgumMedicamento((String) jComboBoxAlgumMedicamento.getSelectedItem());
                objAdmissao.setEspecificarMedicamento(jEspecificarMedicamento.getText());
                objAdmissao.setDiabetico((String) jComboBoxDiabetico.getSelectedItem());
                objAdmissao.setPressaoSanguinea((String) jComboBoxPressaoSanguinea.getSelectedItem());
                objAdmissao.setDoresPeito((String) jComboBoxDoresPeito.getSelectedItem());
                objAdmissao.setDesmaio((String) jComboBoxDesmaio.getSelectedItem());
                objAdmissao.setTextoEvolucaoAdmissao(jTextoEvolucaoAdmissao.getText());
                if (acao == 1) {
                    verificarAdmissao();
                    if (jIdInternoEF.getText().equals(pCODIGO_INTERNO)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já fez admissão anteriormente nessa tela.");
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja cadastrar uma nova admissão na aba complementar?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            bloquearTodosBotoes(!true);
                            jBtNovo.setEnabled(true);
                            pesquisarInternoExistente();
                            mostrarTelaNovaAdm();
                        }
                    } else {
                        // log de usuario
                        objAdmissao.setUsuarioInsert(nameUser);
                        objAdmissao.setDataInsert(dataModFinal);
                        objAdmissao.setHorarioInsert(horaMov);
                        //
                        control.incluirAdmissaoEF(objAdmissao);
                        buscarCodigoAdm();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //MOVIMENTO TÉCNICO DO INTENO NO PSP
                        objAdmPsi.setStatusLanc(jStatusEF.getText());
                        objAdmPsi.setDataLanc(jDataRegistroEF.getDate());
                        objAdmPsi.setIdLanc(Integer.valueOf(jIdRegistroEF.getText()));
                        objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                        objAdmPsi.setNomeInterno(jNomeInternoEF.getText());
                        objAdmPsi.setDeptoPsicologico(deptoTecnico);
                        controle.incluirMovTec(objAdmPsi);
                        // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO   
                        atendido = "Sim";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoEF.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoEF);
                        objRegAtend.setNomeDepartamento(nomeModuloEF);
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataRegistroEF.getDate());
                        objRegAtend.setIdAtend(Integer.valueOf(jIdRegistroEF.getText()));
                        objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                        //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                        objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoEF.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoEF);
                        objRegAtend.setNomeDepartamento(nomeModuloEF);
                        objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                        objRegAtend.setHorarioUp(horaMov);
                        objRegAtend.setIdAtend(Integer.valueOf(jIdRegistroEF.getText()));
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                        control_ATENDE.confirmarAtendimento(objRegAtend);
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                        pHABILITA_EDUCACAO_FISICA = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInternoEF.getText());
                        objPortaEntrada.setHabEdu(pHABILITA_EDUCACAO_FISICA);
                        control_PE.alterarPortaEntradaEducacao(objPortaEntrada);
                        //GRAVAR EVOLUÇÃO DA ADMISSÃO
                        objAdmissao.setIdInternoEF(Integer.valueOf(jIdInternoEF.getText()));
                        objAdmissao.setNomeInternoEF(jNomeInternoEF.getText());
                        objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                        objAdmissao.setDataEvolucaoEF(jDataRegistroEF.getDate());
                        objAdmissao.setTextoEvolucaoEF(jTextoEvolucaoAdmissao.getText());
                        objAdmissao.setAdmEvo(pADMISSAO_EVOLUCAO);
                        control.incluir_EVOLUCAO_EF(objAdmissao);
                        buscarCodigoEvolucao();
                        limparTabelaEvolucao();
                        preencherEvolucao_REGISTRO_EF();
                        objLog1();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        bloquearTodosBotoes(!true);
                        bloquearTodosCampos(!true);
                        Salvar();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    // log de usuario
                    objAdmissao.setUsuarioUp(nameUser);
                    objAdmissao.setDataUp(dataModFinal);
                    objAdmissao.setHorarioUp(horaMov);
                    //
                    objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                    control.alterarAdmissaoEF(objAdmissao);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //MOVIMENTO TÉCNICO
                    objAdmPsi.setStatusLanc(jStatusEF.getText());
                    objAdmPsi.setDataLanc(jDataRegistroEF.getDate());
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdRegistroEF.getText()));
                    objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                    objAdmPsi.setNomeInterno(jNomeInternoEF.getText());
                    objAdmPsi.setDeptoPsicologico(deptoTecnico);
                    controle.alterarMovTec(objAdmPsi);
                    //EVOLUÇÃO DA ADMISSÃO
                    objAdmissao.setIdInternoEF(Integer.valueOf(jIdInternoEF.getText()));
                    objAdmissao.setNomeInternoEF(jNomeInternoEF.getText());
                    objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                    objAdmissao.setDataEvolucaoEF(jDataRegistroEF.getDate());
                    objAdmissao.setTextoEvolucaoEF(jTextoEvolucaoAdmissao.getText());
                    objAdmissao.setAdmEvo(pADMISSAO_EVOLUCAO);
                    control.alterar_EVOLUCAO_EF_ADM(objAdmissao);
                    limparTabelaEvolucao();
                    preencherEvolucao_REGISTRO_EF();
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosBotoes(!true);
                    bloquearTodosCampos(!true);
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

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        if (jStatusEF.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Esse registro já foi FINALIZADO.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                statusMov = "Finalizou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                String pSTATUS_FINALIZADO = "FINALIZADO";
                objAdmissao.setStatusEF(pSTATUS_FINALIZADO);
                objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                control.finalizarAdmissaoEF(objAdmissao);
                //
                objAdmPsi.setStatusLanc(pSTATUS_FINALIZADO);
                objAdmPsi.setIdLanc(Integer.parseInt(jIdRegistroEF.getText()));
                controle.finalizarMovTec(objAdmPsi);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearTodosCampos(!true);
                Finalizar();
                JOptionPane.showMessageDialog(rootPane, "Registro finalizado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtNovaAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaAdmissaoActionPerformed
        // TODO add your handling code here:
        if (jIdRegistroEF.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É ncessário selecionara admissão antiga.");
        } else {
            mostrarTelaNovaAdm();
        }
    }//GEN-LAST:event_jBtNovaAdmissaoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoEF audPsi = new TelaAuditoriaAdmissaoEF();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(audPsi);
        audPsi.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        verificarRegistroBiometria();
        if (pHabilitaEducacaoFisica.equals("Não")) {
            TelaPesqInternoAdmEducacaoFisica objPesqIntAdmPsi = new TelaPesqInternoAdmEducacaoFisica();
            TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objPesqIntAdmPsi);
            objPesqIntAdmPsi.show();
        } else {
            TelaPesqInternoAtendEFBio objPesqIntBio = new TelaPesqInternoAtendEFBio();
            TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objPesqIntBio);
            objPesqIntBio.show();
        }
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoEvol_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoEvol_EF) && codIncluirEF == 1) {
            if (jStatusEF.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarInternoRegistradoAdm();
                if (atendido == null) {
                    JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
                } else if (atendido.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
                } else if (atendido.equals("Sim")) {
                    JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
                } else if (atendido.equals("Não")) {
                    verificarUsuario();
                    if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                        bloquearTodosBotoes(!true);
                        acao = 3;
                        abrirCamposEvolucao(true);
                        NovaEvolucao();
                        statusMov = "Incluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                        conecta.desconecta();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoEvol_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoEvol_EF) && codAlterarEF == 1) {
            if (jStatusEF.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarEvolucaoAdmissao();
                if (pADM_EVOLUCAO == null) {
                    verificarUsuario_EVOLUCAO();
                    if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                        bloquearTodosBotoes(!true);
                        acao = 4;
                        abrirCamposEvolucao(true);
                        AlterarEvolucao();
                        statusMov = "Alterou";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                        conecta.desconecta();
                    }
                } else if (pADM_EVOLUCAO.equals("")) {
                    verificarUsuario_EVOLUCAO();
                    if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                        bloquearTodosBotoes(!true);
                        acao = 4;
                        abrirCamposEvolucao(true);
                        AlterarEvolucao();
                        statusMov = "Alterou";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                        conecta.desconecta();
                    }
                } else if (pADM_EVOLUCAO.equals("Sim")) {
                    JOptionPane.showMessageDialog(rootPane, "Essa evolução não poderá ser alterada nessa tela, será necessário alterar na admissão.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoEvol_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoEvol_EF) && codExcluirEF == 1) {
            if (jStatusEF.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarUsuario_EVOLUCAO();
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        statusMov = "Excluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                        bloquearTodosBotoes(!true);
                        bloquearTodosCampos(!true);
                        limparCamposEvolucao();
                        limparTabelaEvolucao();
                        Excluir();
                        objAdmissao.setIdItem(idItemEvolucao);
                        control.excluir_EVOLUCAO_EF(objAdmissao);
                        objLog1();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoEvol_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoEvol_EF) && codGravarEF == 1) {
            if (jIdInternoEEF.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jNomeInternoEEF.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else {
                objAdmissao.setIdInternoEF(Integer.valueOf(jIdInternoEF.getText()));
                objAdmissao.setNomeInternoEF(jNomeInternoEF.getText());
                objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                objAdmissao.setDataEvolucaoEF(jDataEvolucaoEF.getDate());
                objAdmissao.setTextoEvolucaoEF(jTextoEvolucaoEF.getText());
                objAdmissao.setStatusEF(statusEvolucao);
                if (acao == 3) {
                    // log de usuario
                    objAdmissao.setUsuarioInsert(nameUser);
                    objAdmissao.setDataInsert(dataModFinal);
                    objAdmissao.setHorarioInsert(horaMov);
                    control.incluir_EVOLUCAO_EF(objAdmissao);
                    buscarCodigoEvolucao();
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //MOVIMENTO TÉCNICO DO INTENO NO PSP
                    objAdmPsi.setStatusLanc(jStatusEF.getText());
                    objAdmPsi.setDataLanc(jDataRegistroEF.getDate());
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdRegistroEF.getText()));
                    objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                    objAdmPsi.setNomeInterno(jNomeInternoEF.getText());
                    objAdmPsi.setDeptoPsicologico(deptoTecnico);
                    controleEvo.incluirMovTec(objAdmPsi);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO   
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoEF.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoEF);
                    objRegAtend.setNomeDepartamento(nomeModuloEF);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataRegistroEF.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdRegistroEF.getText()));
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoEF.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoEF);
                    objRegAtend.setNomeDepartamento(nomeModuloEF);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdRegistroEF.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    bloquearTodosBotoes(!true);
                    bloquearTodosCampos(!true);
                    SalvarEvolucao();
                    limparTabelaEvolucao();
                    preencherEvolucao_REGISTRO_EF();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    objAdmissao.setUsuarioUp(nameUser);
                    objAdmissao.setDataUp(dataModFinal);
                    objAdmissao.setHorarioUp(horaMov);
                    objAdmissao.setIdInternoEF(Integer.valueOf(jIdInternoEF.getText()));
                    objAdmissao.setNomeInternoEF(jNomeInternoEF.getText());
                    objAdmissao.setIdRegistroEF(Integer.valueOf(jIdRegistroEF.getText()));
                    objAdmissao.setDataEvolucaoEF(jDataEvolucaoEF.getDate());
                    objAdmissao.setTextoEvolucaoEF(jTextoEvolucaoEF.getText());
                    objAdmissao.setStatusEF(statusEvolucao);
                    objAdmissao.setIdItem(Integer.valueOf(pIDEVOLUCAO));
                    control.alterar_EVOLUCAO_EF(objAdmissao);
                    //MOVIMENTO TÉCNICO DO INTENO NO PSP                    
                    objAdmPsi.setDataLanc(jDataRegistroEF.getDate());
                    objAdmPsi.setIdLanc(Integer.valueOf(jIdRegistroEF.getText()));
                    objAdmPsi.setIdInternoCrc(Integer.valueOf(jIdInternoEF.getText()));
                    objAdmPsi.setNomeInterno(jNomeInternoEF.getText());
                    objAdmPsi.setDeptoPsicologico(deptoTecnico);
                    controleEvo.alterarMovTec(objAdmPsi);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearTodosBotoes(!true);
                    bloquearTodosCampos(!true);
                    SalvarEvolucao();
                    limparTabelaEvolucao();
                    preencherEvolucao_REGISTRO_EF();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        limparCamposEvolucao();
        bloquearTodosBotoes(!true);
        bloquearTodosCampos(!true);
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoEF objEvolu = new TelaAuditoriaEvolucaoEF();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objEvolu);
        objEvolu.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaEvolucaoEFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoEFMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            limparCamposEvolucao();
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            pIDEVOLUCAO = "" + jTabelaEvolucaoEF.getValueAt(jTabelaEvolucaoEF.getSelectedRow(), 0);
            try {
                for (AdmissaoEvolucaoEducacaoFisica pp : lista_REGISTRO.read()) {
                    idItemEvolucao = pp.getIdItem();
                    jIdInternoEEF.setText(String.valueOf(pp.getIdInternoEF()));
                    jNomeInternoEEF.setText(pp.getNomeInternoEF());
                    jDataEvolucaoEF.setDate(pp.getDataEvolucaoEF());
                    jTextoEvolucaoEF.setText(pp.getTextoEvolucaoEF());
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTabelaEvolucaoEFMouseClicked

    private void jTabelaAdmissaoEFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoEFMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String pREGISTRO_ADM = "" + jTabelaAdmissaoEF.getValueAt(jTabelaAdmissaoEF.getSelectedRow(), 0);
            jID_REGISTRO_Pesquisa.setText(pREGISTRO_ADM);
            pesquisarInternoExistente();
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovaAdmissao.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //EVOLUÇAO
            limparCamposEvolucao();
            limparTabelaEvolucao();
            preencherEvolucaoEF();
            jBtNovaEvolucao.setEnabled(true);
        }
    }//GEN-LAST:event_jTabelaAdmissaoEFMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAlturaEF;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIDPesq;
    private javax.swing.JButton jBtNovaAdmissao;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtPesquisarInternos;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxAlgumMedicamento;
    private javax.swing.JComboBox<String> jComboBoxAlgumTipoCirurgia;
    private javax.swing.JComboBox<String> jComboBoxAtividadeFisica;
    private javax.swing.JComboBox<String> jComboBoxDesmaio;
    private javax.swing.JComboBox<String> jComboBoxDiabetico;
    private javax.swing.JComboBox<String> jComboBoxDoresPeito;
    private javax.swing.JComboBox<String> jComboBoxHabitoFumar;
    private javax.swing.JComboBox<String> jComboBoxNivelCondicionamento;
    private javax.swing.JComboBox<String> jComboBoxPressaoSanguinea;
    private javax.swing.JComboBox<String> jComboBoxProblemaCardiaco;
    private javax.swing.JComboBox<String> jComboBoxProblemaOrtopedico;
    private javax.swing.JComboBox<String> jComboBoxRestricaoAtividadeFisica;
    private com.toedter.calendar.JDateChooser jDataEvolucaoEF;
    public static com.toedter.calendar.JDateChooser jDataNascimentoEF;
    public static com.toedter.calendar.JDateChooser jDataPesFinal;
    public static com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistroEF;
    private javax.swing.JTextField jEspecificarCirurgia;
    private javax.swing.JTextField jEspecificarMedicamento;
    public static javax.swing.JLabel jFotoInternoEF;
    private javax.swing.JTextField jFrequenciaSemanal;
    public static javax.swing.JTextField jID_REGISTRO_Pesquisa;
    private javax.swing.JTextField jIdInternoEEF;
    public static javax.swing.JTextField jIdInternoEF;
    public static javax.swing.JTextField jIdRegistroEF;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaEF;
    private javax.swing.JTextField jNomeInternoEEF;
    public static javax.swing.JTextField jNomeInternoEF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesoEF;
    public static javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JTextField jQualProblemaCardiaco;
    private javax.swing.JTextField jQualRestricaoFisica;
    private javax.swing.JTextField jQuantosCigarros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusEF;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAdmissaoEF;
    public static javax.swing.JTable jTabelaEvolucaoEF;
    private javax.swing.JTextArea jTextoEvolucaoAdmissao;
    private javax.swing.JTextArea jTextoEvolucaoEF;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void pesquisarInternoExistente() {
        bloquearTodosCampos(!true);
        try {
            for (AdmissaoEvolucaoEducacaoFisica dd : control.read()) {
                jIdRegistroEF.setText(String.valueOf(dd.getIdRegistroEF()));
                jStatusEF.setText(dd.getStatusEF());
                jDataRegistroEF.setDate(dd.getDataRegistroEF());
                jIdInternoEF.setText(String.valueOf(dd.getIdInternoEF()));
                jMatriculaEF.setText(dd.getMatriculaEF());
                jDataNascimentoEF.setDate(dd.getDataNascimentoEF());
                dd.getPesoEF();
                DecimalFormat pPESO = new DecimalFormat("#,##0.00");
                String vqtdItem = pPESO.format(dd.getPesoEF());
                jPesoEF.setText(vqtdItem);
                dd.getAlturaEF();
                DecimalFormat pALTURA = new DecimalFormat("#,##0.00");
                String pALTURA_INTERNO = pALTURA.format(dd.getAlturaEF());
                jAlturaEF.setText(pALTURA_INTERNO);
                jNomeInternoEF.setText(dd.getNomeInternoEF());
                jFotoInternoEF.setIcon(null);
                // Capturando foto
                caminho = dd.getCaminhoFoto();
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoEF.setIcon(i);
                    jFotoInternoEF.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoEF.getWidth(), jFotoInternoEF.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) dd.getImagemBanco());
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoEF.getWidth(), jFotoInternoEF.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoEF.setIcon(icon);
                }
                //PARTE I
                jComboBoxAtividadeFisica.setSelectedItem(dd.getAtividadeFisica());
                jFrequenciaSemanal.setText(dd.getFrequenciaSemanal());
                jComboBoxNivelCondicionamento.setSelectedItem(dd.getNivelCondicionamento());
                jComboBoxRestricaoAtividadeFisica.setSelectedItem(dd.getAtividadeFisica());
                jQualRestricaoFisica.setText(dd.getRestricaoAtividadeFisica());
                jComboBoxProblemaCardiaco.setSelectedItem(dd.getProblemaCardiaco());
                jQualProblemaCardiaco.setText(dd.getQualProblemaCardiaco());
                //PARTE II
                jComboBoxAlgumTipoCirurgia.setSelectedItem(dd.getAlgumTipoCirurgia());
                jEspecificarCirurgia.setText(dd.getEspecificarCirurgia());
                jComboBoxProblemaOrtopedico.setSelectedItem(dd.getProblemaOrtopedico());
                jComboBoxHabitoFumar.setSelectedItem(dd.getHabitoFumar());
                jQuantosCigarros.setText(String.valueOf(dd.getQuantosCigarros()));
                jComboBoxAlgumMedicamento.setSelectedItem(dd.getAlgumMedicamento());
                jEspecificarMedicamento.setText(dd.getEspecificarMedicamento());
                //PARTE III
                jComboBoxDiabetico.setSelectedItem(dd.getDiabetico());
                jComboBoxPressaoSanguinea.setSelectedItem(dd.getPressaoSanguinea());
                jComboBoxDoresPeito.setSelectedItem(dd.getDoresPeito());
                jComboBoxDesmaio.setSelectedItem(dd.getDesmaio());
                //EVOLUÇÃO ADMISSÃO
                jTextoEvolucaoAdmissao.setText(dd.getTextoEvolucaoAdmissao());
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void corCampos() {
        jIdRegistroEF.setBackground(Color.white);
        jStatusEF.setBackground(Color.white);
        jDataRegistroEF.setBackground(Color.white);
        jIdInternoEF.setBackground(Color.white);
        jMatriculaEF.setBackground(Color.white);
        jDataNascimentoEF.setBackground(Color.white);
        jPesoEF.setBackground(Color.white);
        jAlturaEF.setBackground(Color.white);
        jNomeInternoEF.setBackground(Color.white);
        //PARTE I
        jComboBoxAtividadeFisica.setBackground(Color.white);
        jFrequenciaSemanal.setBackground(Color.white);
        jComboBoxNivelCondicionamento.setBackground(Color.white);
        jComboBoxRestricaoAtividadeFisica.setBackground(Color.white);
        jQualRestricaoFisica.setBackground(Color.white);
        jComboBoxProblemaCardiaco.setBackground(Color.white);
        jQualProblemaCardiaco.setBackground(Color.white);
        //PARTE II
        jComboBoxAlgumTipoCirurgia.setBackground(Color.white);
        jEspecificarCirurgia.setBackground(Color.white);
        jComboBoxProblemaOrtopedico.setBackground(Color.white);
        jComboBoxHabitoFumar.setBackground(Color.white);
        jQuantosCigarros.setBackground(Color.white);
        jComboBoxAlgumMedicamento.setBackground(Color.white);
        jEspecificarMedicamento.setBackground(Color.white);
        //PARTE III
        jComboBoxDiabetico.setBackground(Color.white);
        jComboBoxPressaoSanguinea.setBackground(Color.white);
        jComboBoxDoresPeito.setBackground(Color.white);
        jComboBoxDesmaio.setBackground(Color.white);
        //EVOLUÇÃO ADMISSÃO
        jTextoEvolucaoAdmissao.setBackground(Color.white);
        //EVOLUÇÃO
        jIdInternoEEF.setBackground(Color.white);
        jNomeInternoEEF.setBackground(Color.white);
        jDataEvolucaoEF.setBackground(Color.white);
        jTextoEvolucaoEF.setBackground(Color.white);
    }

    public void formataCampos() {
        jTextoEvolucaoAdmissao.setLineWrap(true);
        jTextoEvolucaoAdmissao.setWrapStyleWord(true);
        jTextoEvolucaoEF.setLineWrap(true);
        jTextoEvolucaoEF.setWrapStyleWord(true);
    }

    public void bloquearTodosCampos(boolean opcao) {
        jIdRegistroEF.setEnabled(opcao);
        jStatusEF.setEnabled(opcao);
        jDataRegistroEF.setEnabled(opcao);
        jIdInternoEF.setEnabled(opcao);
        jMatriculaEF.setEnabled(opcao);
        jDataNascimentoEF.setEnabled(opcao);
        jPesoEF.setEnabled(opcao);
        jAlturaEF.setEnabled(opcao);
        jNomeInternoEF.setEnabled(opcao);
        //PARTE I
        jComboBoxAtividadeFisica.setEnabled(opcao);
        jFrequenciaSemanal.setEnabled(opcao);
        jComboBoxNivelCondicionamento.setEnabled(opcao);
        jComboBoxRestricaoAtividadeFisica.setEnabled(opcao);
        jQualRestricaoFisica.setEnabled(opcao);
        jComboBoxProblemaCardiaco.setEnabled(opcao);
        jQualProblemaCardiaco.setEnabled(opcao);
        //PARTE II
        jComboBoxAlgumTipoCirurgia.setEnabled(opcao);
        jEspecificarCirurgia.setEnabled(opcao);
        jComboBoxProblemaOrtopedico.setEnabled(opcao);
        jComboBoxHabitoFumar.setEnabled(opcao);
        jQuantosCigarros.setEnabled(opcao);
        jComboBoxAlgumMedicamento.setEnabled(opcao);
        jEspecificarMedicamento.setEnabled(opcao);
        //PARTE III
        jComboBoxDiabetico.setEnabled(opcao);
        jComboBoxPressaoSanguinea.setEnabled(opcao);
        jComboBoxDoresPeito.setEnabled(opcao);
        jComboBoxDesmaio.setEnabled(opcao);
        //EVOLUÇÃO ADMISSÃO
        jTextoEvolucaoAdmissao.setEnabled(opcao);
        //EVOLUÇÃO
        jIdInternoEEF.setEnabled(opcao);
        jNomeInternoEEF.setEnabled(opcao);
        jDataEvolucaoEF.setEnabled(opcao);
        jTextoEvolucaoEF.setEnabled(opcao);
    }

    public void abrirCamposAdm(boolean opcao) {
        jPesoEF.setEnabled(opcao);
        jAlturaEF.setEnabled(opcao);
        //PARTE I
        jComboBoxAtividadeFisica.setEnabled(opcao);
        jFrequenciaSemanal.setEnabled(opcao);
        jComboBoxNivelCondicionamento.setEnabled(opcao);
        jComboBoxRestricaoAtividadeFisica.setEnabled(opcao);
        jQualRestricaoFisica.setEnabled(opcao);
        jComboBoxProblemaCardiaco.setEnabled(opcao);
        jQualProblemaCardiaco.setEnabled(opcao);
        //PARTE II
        jComboBoxAlgumTipoCirurgia.setEnabled(opcao);
        jEspecificarCirurgia.setEnabled(opcao);
        jComboBoxProblemaOrtopedico.setEnabled(opcao);
        jComboBoxHabitoFumar.setEnabled(opcao);
        jQuantosCigarros.setEnabled(opcao);
        jComboBoxAlgumMedicamento.setEnabled(opcao);
        jEspecificarMedicamento.setEnabled(opcao);
        //PARTE III
        jComboBoxDiabetico.setEnabled(opcao);
        jComboBoxPressaoSanguinea.setEnabled(opcao);
        jComboBoxDoresPeito.setEnabled(opcao);
        jComboBoxDesmaio.setEnabled(opcao);
        //EVOLUÇÃO ADMISSÃO
        jTextoEvolucaoAdmissao.setEnabled(opcao);
    }

    public void abrirCamposEvolucao(boolean opcao) {
        jTextoEvolucaoEF.setEnabled(opcao);
    }

    public void bloquearTodosBotoes(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtNovaAdmissao.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        jBtPesquisarInterno.setEnabled(opcao);
        //
        jBtNovaEvolucao.setEnabled(opcao);
        jBtAlterarEvolucao.setEnabled(opcao);
        jBtExcluirEvolucao.setEnabled(opcao);
        jBtSalvarEvolucao.setEnabled(opcao);
        jBtCancelarEvolucao.setEnabled(opcao);
        jBtAuditoriaEvolucao.setEnabled(opcao);
    }

    public void bloquearBotoesAdm(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtNovaAdmissao.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        jBtPesquisarInterno.setEnabled(opcao);
    }

    public void bloquearBotoesEvolucao(boolean opcao) {
        jBtNovaEvolucao.setEnabled(opcao);
        jBtAlterarEvolucao.setEnabled(opcao);
        jBtExcluirEvolucao.setEnabled(opcao);
        jBtSalvarEvolucao.setEnabled(opcao);
        jBtCancelarEvolucao.setEnabled(opcao);
        jBtAuditoriaEvolucao.setEnabled(opcao);
    }

    public void limparTodosCampos() {
        jIdRegistroEF.setText("");
        jStatusEF.setText("");
        jDataRegistroEF.setDate(null);
        jIdInternoEF.setText("");
        jMatriculaEF.setText("");
        jDataNascimentoEF.setDate(null);
        jPesoEF.setText("");
        jAlturaEF.setText("");
        jNomeInternoEF.setText("");
        jFotoInternoEF.setIcon(null);
        //PARTE I
        jComboBoxAtividadeFisica.setSelectedItem("Não");
        jFrequenciaSemanal.setText("");
        jComboBoxNivelCondicionamento.setSelectedItem("Selecione..");
        jComboBoxRestricaoAtividadeFisica.setSelectedItem("Não");
        jQualRestricaoFisica.setText("");
        jComboBoxProblemaCardiaco.setSelectedItem("Não");
        jQualProblemaCardiaco.setText("");
        //PARTE II
        jComboBoxAlgumTipoCirurgia.setSelectedItem("Não");
        jEspecificarCirurgia.setText("");
        jComboBoxProblemaOrtopedico.setSelectedItem("Não");
        jComboBoxHabitoFumar.setSelectedItem("Não");
        jQuantosCigarros.setText("");
        jComboBoxAlgumMedicamento.setSelectedItem("Não");
        jEspecificarMedicamento.setText("");
        //PARTE III
        jComboBoxDiabetico.setSelectedItem("Não");
        jComboBoxPressaoSanguinea.setSelectedItem("Não");
        jComboBoxDoresPeito.setSelectedItem("Não");
        jComboBoxDesmaio.setSelectedItem("Não");
        //EVOLUÇÃO ADMISSÃO
        jTextoEvolucaoAdmissao.setText("");
        //EVOLUÇÃO
        jIdInternoEEF.setText("");
        jNomeInternoEEF.setText("");
        jDataEvolucaoEF.setDate(null);
        jTextoEvolucaoEF.setText("");
    }

    public void limparCamposEvolucao() {
        jIdInternoEEF.setText("");
        jNomeInternoEEF.setText("");
        jDataEvolucaoEF.setDate(null);
        jTextoEvolucaoEF.setText("");
    }

    public void Novo() {
        jStatusEF.setText("ABERTO");
        jDataRegistroEF.setCalendar(Calendar.getInstance());
        jTextoEvolucaoAdmissao.setText("DIGITE AQUI A EVOLUÇÃO DA ADMISSÃO.");
        jPesoEF.setText("0");
        jAlturaEF.setText("0");
        jQuantosCigarros.setText("0");
        jBtPesquisarInterno.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jBtPesquisarInterno.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        jPesoEF.setText("0");
        jAlturaEF.setText("0");
        jQuantosCigarros.setText("0");
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtNovaAdmissao.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistroEF.getText().equals("")) {
            bloquearTodosCampos(!true);
            bloquearTodosBotoes(!true);
            limparTodosCampos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearTodosCampos(!true);
            bloquearTodosBotoes(!true);
            jBtNovo.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovaAdmissao.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovaEvolucao.setEnabled(true);
        }
    }

    public void Finalizar() {
        jBtNovo.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCodigoAdm() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA");
            conecta.rs.last();
            jIdRegistroEF.setText(conecta.rs.getString("IdRegistroEF"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o código do lançamento");
        }
        conecta.desconecta();
    }

    public void verificarAdmissao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA "
                    + "WHERE IdInternoCrc='" + jIdInternoEF.getText() + "'");
            conecta.rs.first();
            pCODIGO_INTERNO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaEducacaoFisica = conecta.rs.getString("BiometriaEF");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaEvolucao() {
        jIdInternoEEF.setText(jIdInternoEF.getText());
        jNomeInternoEEF.setText(jNomeInternoEF.getText());
        jDataEvolucaoEF.setCalendar(Calendar.getInstance());
        //
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
    }

    public void AlterarEvolucao() {
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
    }

    public void ExcluirEvolucao() {
        jIdInternoEEF.setText("");
        jNomeInternoEEF.setText("");
        jDataEvolucaoEF.setDate(null);
        jTextoEvolucaoEF.setText("");
        jBtNovaEvolucao.setEnabled(true);
    }

    public void SalvarEvolucao() {
        jIdInternoEEF.setText("");
        jNomeInternoEEF.setText("");
        jDataEvolucaoEF.setDate(null);
        jTextoEvolucaoEF.setText("");
        jBtNovaEvolucao.setEnabled(true);
    }

    public void CancelarEvolucao() {
        jIdInternoEEF.setText("");
        jNomeInternoEEF.setText("");
        jDataEvolucaoEF.setDate(null);
        jBtNovaEvolucao.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCodigoEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_EDUCACAO_FISICA");
            conecta.rs.last();
            idItemEvolucao = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o código do lançamento");
        }
        conecta.desconecta();
    }

    public void verificarUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_EDUCACAO_FISICA "
                    + "WHERE IdRegistroEF='" + jIdRegistroEF.getText() + "'");
            conecta.rs.first();
            nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
        }
        conecta.desconecta();
    }

    public void verificarUsuario_EVOLUCAO() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_EDUCACAO_FISICA "
                    + "WHERE IdRegistroEF='" + jIdRegistroEF.getText() + "'");
            conecta.rs.first();
            nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
        }
        conecta.desconecta();
    }

    public void verificarEvolucaoAdmissao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_EDUCACAO_FISICA "
                    + "WHERE IdRegistroEF='" + jIdRegistroEF.getText() + "' "
                    + "AND IdItem='" + pIDEVOLUCAO + "'");
            conecta.rs.first();
            pADM_EVOLUCAO = conecta.rs.getString("AdmEvo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_EDUCACAO_FISICA "
                    + "WHERE IdRegistroEF='" + jIdRegistroEF.getText() + "'");
            conecta.rs.first();
            pID_EVOLUCAO = conecta.rs.getString("IdRegistroEF");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
        }
        conecta.desconecta();
    }

    public void verificarInternoRegistradoAdm() {

        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataRegistroEF.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIdInternoEF.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoEF = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherEvolucaoEF() {
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaEvolucaoEF.getModel();
        try {
            for (AdmissaoEvolucaoEducacaoFisica pp : listaEvo.read()) {
                pDATA_PESQUISA_EVOLUCAO = String.valueOf(pp.getDataEvolucaoEF());
                String diaEvo = pDATA_PESQUISA_EVOLUCAO.substring(8, 10);
                String mesEvo = pDATA_PESQUISA_EVOLUCAO.substring(5, 7);
                String anoEvo = pDATA_PESQUISA_EVOLUCAO.substring(0, 4);
                pDATA_PESQUISA_EVOLUCAO = diaEvo + "/" + mesEvo + "/" + anoEvo;
                dadosDestino.addRow(new Object[]{pp.getIdItem(), pp.getIdRegistroEF(), pDATA_PESQUISA_EVOLUCAO, pp.getTextoEvolucaoEF()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaAdmissaoEF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaEvolucaoEF.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaEvolucaoEF.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaEvolucaoEF.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherEvolucao_REGISTRO_EF() {
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaEvolucaoEF.getModel();
        try {
            for (AdmissaoEvolucaoEducacaoFisica pp : lista_REGISTRO.read()) {
                pDATA_PESQUISA_EVOLUCAO = String.valueOf(pp.getDataEvolucaoEF());
                String dia = pDATA_PESQUISA_EVOLUCAO.substring(8, 10);
                String mes = pDATA_PESQUISA_EVOLUCAO.substring(5, 7);
                String ano = pDATA_PESQUISA_EVOLUCAO.substring(0, 4);
                pDATA_PESQUISA_EVOLUCAO = dia + "/" + mes + "/" + ano;
                dadosDestino.addRow(new Object[]{pp.getIdItem(), pp.getIdRegistroEF(), pDATA_PESQUISA_EVOLUCAO, pp.getTextoEvolucaoEF()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaAdmissaoEF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaEvolucaoEF.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaEvolucaoEF.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaEvolucaoEF.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAdmissaoEvolucoEF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabelaEvolucao() {
        // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
        DefaultTableModel tblRemove = (DefaultTableModel) jTabelaEvolucaoEF.getModel();
        if (tblRemove.getRowCount() > 0) {
            for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                tblRemove.removeRow(i);
                tblRemove.setRowCount(0);
                if (tblRemove.getRowCount() < i) {
                    tblRemove.removeRow(i);
                    tblRemove.setRowCount(0);
                }
            }
        }
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserEF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserEF + "'");
            conecta.rs.first();
            codigoUserGroupEF = conecta.rs.getInt("IdUsuario");
            codigoGrupoEF = conecta.rs.getInt("IdGrupo");
            nomeGrupoEF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserEF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoEF = conecta.rs.getInt("IdUsuario");
            codAbrirEF = conecta.rs.getInt("Abrir");
            codIncluirEF = conecta.rs.getInt("Incluir");
            codAlterarEF = conecta.rs.getInt("Alterar");
            codExcluirEF = conecta.rs.getInt("Excluir");
            codGravarEF = conecta.rs.getInt("Gravar");
            codConsultarEF = conecta.rs.getInt("Consultar");
            nomeTelaEF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroEF.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroEF.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
