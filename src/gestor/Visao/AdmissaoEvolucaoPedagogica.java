/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdmissaoPsicologica;
import gestor.Controle.ControleEducacaoFamilia;
import gestor.Controle.ControleEvolucaoPedagogia;
import gestor.Controle.ControleFemininoPedagogia;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovPedagogia;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Controle.ControleSocializacao;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.LimiteDigitosNum;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AdmissaoPedagogica;
import gestor.Modelo.EvolucaoPedagogica;
import gestor.Modelo.FamiliaAdmissaoPedagogica;
import gestor.Modelo.FemininoAdmissaoPedago;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroAtendimentoInternos;
import gestor.Modelo.SocializacaoAdmPedagogica;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPedagogia.codAbrirPEDA;
import static gestor.Visao.TelaModuloPedagogia.codAlterarPEDA;
import static gestor.Visao.TelaModuloPedagogia.codConsultarPEDA;
import static gestor.Visao.TelaModuloPedagogia.codExcluirPEDA;
import static gestor.Visao.TelaModuloPedagogia.codGravarPEDA;
import static gestor.Visao.TelaModuloPedagogia.codIncluirPEDA;
import static gestor.Visao.TelaModuloPedagogia.codUserAcessoPEDA;
import static gestor.Visao.TelaModuloPedagogia.codigoGrupoPEDA;
import static gestor.Visao.TelaModuloPedagogia.codigoUserGroupPEDA;
import static gestor.Visao.TelaModuloPedagogia.codigoUserPEDA;
import static gestor.Visao.TelaModuloPedagogia.nomeGrupoPEDA;
import static gestor.Visao.TelaModuloPedagogia.nomeTelaPEDA;
import static gestor.Visao.TelaModuloPedagogia.telaAdmissaoFami_PEDA;
import static gestor.Visao.TelaModuloPedagogia.telaAdmissaoManu_PEDA;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
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
public class AdmissaoEvolucaoPedagogica extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPedagogica objAdmPedago = new AdmissaoPedagogica();
    ControleAdmissaoPsicologica control = new ControleAdmissaoPsicologica();
    ControleMovPedagogia controleMov = new ControleMovPedagogia();
    //
    FamiliaAdmissaoPedagogica objFamAdmPedago = new FamiliaAdmissaoPedagogica();
    ControleEducacaoFamilia controle = new ControleEducacaoFamilia();
    //
    SocializacaoAdmPedagogica objSociaAdmPedago = new SocializacaoAdmPedagogica();
    ControleSocializacao controleSocial = new ControleSocializacao();
    //
    FemininoAdmissaoPedago objFemPedago = new FemininoAdmissaoPedago();
    ControleFemininoPedagogia controleFem = new ControleFemininoPedagogia();
    //
    EvolucaoPedagogica objEvolucaoAdmPedago = new EvolucaoPedagogica();
    ControleEvolucaoPedagogia controleEvol = new ControleEvolucaoPedagogia();
    // INFORMAR QUE O INTERNO FOI ATENDIDO NA ADMISSÃO E NA EVOLUÇÃO
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Pedagogia:Admissão";
    String nomeModuloTela2 = "Pedagogia:Educação/Familia:Internos";
    String nomeModuloTela3 = "Pedagogia:Socialização/Preferências:Internos";
    String nomeModuloTela4 = "Pedagogia:Feminino:Internos";
    String nomeModuloTela5 = "Pedagogia:Evolução:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao, flag;
    int count = 0;
    String dataInicial, dataFinal, dataCadastro, dataEvolucao;
    String caminho;
    // CÓDIGOS DE PESQUISAS PARA EVITAR EXCLUSÃO DESNECESSÁRIA
    String codigoInternoFamilia, codigoInternoSocializa, codigoInternoFeminino, codigoInternoEvolucao;
    //
    int codigoFam, codigoSocia, codigoFem, codigoEvol;
    //
    int introvertido;
    int afetuoso;
    int obediente;
    int resistente;
    int cooperador;
    int medroso;
    int inseguro;
    int outros;
    // AGENDAMENTO
    public static String departamentoAgenda = "PEDAGOGIA";
    String deptoTecnico = "PEDAGOGIA";
    String nomeDepartamento;
    String codigoStatusReg;
    String codigoInterno;
    // FAMILIA  
    String codigoAdm; // CÓDIGO PARA VERIFICAR SE JÁ FOI INCLUÍDO O REGISTRO FAMILIA, NÃO PERMITIR CADASTRAR MAIS DE UM
    String codigoInternoFAM;
    // SOCIALIZAÇÃO
    String codigoAdmSocial;
    String codigoInternoSocial;
    // FEMININO
    String codigoAdmFem;
    String codigoInternoFem;
    // VARIVAEIS PARA SABER SE O INTERNO FOI REGISTRADO COM BIOMETRIA      
    String dataReg = "";
    Date dataRegistro = null;
    String codigoInternoAtend = "";
    String atendido = "Sim";
    String opcao = "Não";
    public static int codigoDepartamentoPEDA = 0;
    String tipoAtendimentoAdm = "Admissão Pedagogia";
    String tipoAtendimentoEvol = "Evolução Pedagogia";
    String pHabilitaPEDA = "";

    /**
     * Creates new form AdmissaoEvolucaoPsicologica
     */
    public static AgendamentoAtendimentoPedagogia agendaAtendimentoPed;

    public AdmissaoEvolucaoPedagogica() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarAgendaAtendimento() {
        agendaAtendimentoPed = new AgendamentoAtendimentoPedagogia(this, true);
        agendaAtendimentoPed.setVisible(true);
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
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtDataLanc = new javax.swing.JButton();
        jBtNomeInterno = new javax.swing.JButton();
        jIDPesqLan = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jBtIdLanc = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaAdmissaoPedagogica = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        Admissao = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCodigoAdmissao = new javax.swing.JTextField();
        jStatusAdm = new javax.swing.JTextField();
        jDataAdm = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jIdInternoAdm = new javax.swing.JTextField();
        jNomeInternoAdm = new javax.swing.JTextField();
        jDataNascimentoInternoAdm = new com.toedter.calendar.JDateChooser();
        jNaturalidadeInternoAdm = new javax.swing.JTextField();
        jBtPesquisarInterno = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMaeInternoAdm = new javax.swing.JTextField();
        jPaiInternoAdm = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jFotoInternoPedagogia = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jUltimaEscola = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSerieAno = new javax.swing.JTextField();
        jTurno = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        EducacaoFamilia = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxRelacaoPai = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxRelacaoMae = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jComboBoxIrmaos = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jComboBoxPaisLerEscrever = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxPaisSeparados = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jReligiao = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxLider = new javax.swing.JComboBox();
        jComboBoxRelacionamento = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jIdadeAndou = new javax.swing.JTextField();
        jIdadeFalou = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jQualDificuldadeFala = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jComunicacao = new javax.swing.JTextArea();
        jComboBoxDificuldadeFala = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jBtNovaFamilia = new javax.swing.JButton();
        jBtAlterarFamilia = new javax.swing.JButton();
        jBtExcluirFamilia = new javax.swing.JButton();
        jBtSalvarFamilia = new javax.swing.JButton();
        jBtCancelarFamilia = new javax.swing.JButton();
        jBtAuditoriaFamilia = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxRepetiuAno = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jPorqueRepetiuAno = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxProblemaProfessor = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jQualProblemaProfessor = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jComoAtitudeSala = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jComboBoxFaltaEscola = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        jPorqueFaltaEscola = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jComboBoxAchaEscola = new javax.swing.JComboBox();
        Socializacao = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jAmigosFacilidade = new javax.swing.JTextField();
        jIntrovertido = new javax.swing.JCheckBox();
        jAfetuoso = new javax.swing.JCheckBox();
        jObediente = new javax.swing.JCheckBox();
        jResistente = new javax.swing.JCheckBox();
        jCooperador = new javax.swing.JCheckBox();
        jMedroso = new javax.swing.JCheckBox();
        jInseguro = new javax.swing.JCheckBox();
        jOutros = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jQualOutros = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jIdadeEscolar = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jAdaptacao = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jRepetencias = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jComboBoxFamiliarPresente = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxAntecedentes = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jQualProblemaAprendizado = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jObservacaoSocializacao = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jBtNovaSocializacao = new javax.swing.JButton();
        jBtAlterarSocializacao = new javax.swing.JButton();
        jBtExcluirSocializacao = new javax.swing.JButton();
        jBtSalvarSocializacao = new javax.swing.JButton();
        jBtCancelarSocializacao = new javax.swing.JButton();
        jBtAuditoriaSocializacao = new javax.swing.JButton();
        Feminino = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jComboBoxFilhoDesejado = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jComboBoxQueriaEngravidar = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        jComboBoxFoiAcidental = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxPerturbou = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextoComoFoiGestacao = new javax.swing.JTextArea();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextoComoFoiParto = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jBtNovoFeminino = new javax.swing.JButton();
        jBtAlterarFeminino = new javax.swing.JButton();
        jBtExcluirFeminino = new javax.swing.JButton();
        jBtSalvarFeminino = new javax.swing.JButton();
        jBtCancelarFeminino = new javax.swing.JButton();
        jBtAuditoriaFeminino = new javax.swing.JButton();
        Evolucao = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTabelaEvolucaoPedagoga = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jCodigoEvolucao = new javax.swing.JTextField();
        jNomeInternoEvolucao = new javax.swing.JTextField();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextoEvolucao = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxEncaminharSetorEvo = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jDataEncaminhamentoEvo = new com.toedter.calendar.JDateChooser();
        jHoraEnvioEvo = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jBtAgendamentoAtendimento = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Admissão/Evolução Pedagógica :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Nome do Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Data Final:");

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDataLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLanc.setContentAreaFilled(false);
        jBtDataLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLancActionPerformed(evt);
            }
        });

        jBtNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomeInterno.setContentAreaFilled(false);
        jBtNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeInternoActionPerformed(evt);
            }
        });

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Código:");

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox9.setText("Todos");
        jCheckBox9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox9ItemStateChanged(evt);
            }
        });

        jBtIdLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdLanc.setContentAreaFilled(false);
        jBtIdLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdLancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox9))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jPesqNomeInterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDataLanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAdmissaoPedagogica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdmissaoPedagogica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ));
        jTabelaAdmissaoPedagogica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdmissaoPedagogicaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaAdmissaoPedagogica);
        if (jTabelaAdmissaoPedagogica.getColumnModel().getColumnCount() > 0) {
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setMinWidth(370);
            jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setMaxWidth(370);
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
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
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
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jCodigoAdmissao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoAdmissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoAdmissao.setEnabled(false);

        jStatusAdm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAdm.setForeground(new java.awt.Color(255, 0, 0));
        jStatusAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAdm.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusAdm.setEnabled(false);

        jDataAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAdm.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome Completo do Interno");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nascimento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Naturalidade");

        jIdInternoAdm.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAdm.setEnabled(false);

        jNomeInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAdm.setEnabled(false);

        jDataNascimentoInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimentoInternoAdm.setEnabled(false);

        jNaturalidadeInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturalidadeInternoAdm.setEnabled(false);

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setToolTipText("Pesquisar Interno");
        jBtPesquisarInterno.setContentAreaFilled(false);
        jBtPesquisarInterno.setEnabled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Mãe:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Pai:");

        jMaeInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaeInternoAdm.setEnabled(false);

        jPaiInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPaiInternoAdm.setEnabled(false);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPedagogia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPedagogia, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCodigoAdmissao)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jStatusAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jIdInternoAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5))
                                    .addGap(205, 205, 205))
                                .addComponent(jNomeInternoAdm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNaturalidadeInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataNascimentoInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPaiInternoAdm)
                                    .addComponent(jMaeInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCodigoAdmissao, jIdInternoAdm});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jIdInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesquisarInterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jNomeInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNaturalidadeInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataNascimentoInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMaeInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jPaiInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Última escola que frequentou");

        jUltimaEscola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUltimaEscola.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Série/Ano");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Turno");

        jSerieAno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSerieAno.setEnabled(false);

        jTurno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTurno.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jUltimaEscola)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSerieAno, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTurno)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUltimaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSerieAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
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

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
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

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar)
                .addComponent(jBtSair)
                .addComponent(jBtFinalizar)
                .addComponent(jBtAuditoria))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Observação:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout AdmissaoLayout = new javax.swing.GroupLayout(Admissao);
        Admissao.setLayout(AdmissaoLayout);
        AdmissaoLayout.setHorizontalGroup(
            AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmissaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AdmissaoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AdmissaoLayout.setVerticalGroup(
            AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmissaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdmissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admissão", Admissao);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Relaciona-se bem: ");

        jComboBoxRelacaoPai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRelacaoPai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRelacaoPai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRelacaoPai.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Com o pai?");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Com a mãe?");

        jComboBoxRelacaoMae.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRelacaoMae.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRelacaoMae.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRelacaoMae.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("irmãos?");

        jComboBoxIrmaos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIrmaos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxIrmaos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIrmaos.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Os pais sabem ler e escrever?");

        jComboBoxPaisLerEscrever.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPaisLerEscrever.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não sei" }));
        jComboBoxPaisLerEscrever.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPaisLerEscrever.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Pais(Separados)?");

        jComboBoxPaisSeparados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPaisSeparados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPaisSeparados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPaisSeparados.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Religião:");

        jReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReligiao.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel38))
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxPaisLerEscrever, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxRelacaoPai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxRelacaoMae, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxIrmaos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPaisSeparados, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jReligiao)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel39)
                    .addComponent(jComboBoxRelacaoMae, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jComboBoxIrmaos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRelacaoPai, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jComboBoxPaisLerEscrever, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxPaisSeparados, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Relacionamento com colegas?");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("É lider?");

        jComboBoxLider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLider.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxLider.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLider.setEnabled(false);

        jComboBoxRelacionamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRelacionamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRelacionamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRelacionamento.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxLider, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jComboBoxLider, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Idade que andou:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Idade que falou:");

        jIdadeAndou.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeAndou.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeAndou.setEnabled(false);

        jIdadeFalou.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeFalou.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeFalou.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Alguma dificuldade na fala?");

        jQualDificuldadeFala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDificuldadeFala.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Comunicação:");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jComunicacao.setColumns(20);
        jComunicacao.setRows(5);
        jComunicacao.setEnabled(false);
        jScrollPane3.setViewportView(jComunicacao);

        jComboBoxDificuldadeFala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDificuldadeFala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não sei" }));
        jComboBoxDificuldadeFala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDificuldadeFala.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Qual?");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxDificuldadeFala, 0, 1, Short.MAX_VALUE)
                    .addComponent(jIdadeAndou, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdadeFalou, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualDificuldadeFala)))
                .addGap(10, 10, 10))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdadeAndou, jIdadeFalou});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jIdadeAndou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jIdadeFalou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jQualDificuldadeFala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDificuldadeFala, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovaFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaFamilia.setText("Novo");
        jBtNovaFamilia.setContentAreaFilled(false);
        jBtNovaFamilia.setEnabled(false);
        jBtNovaFamilia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaFamilia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaFamilia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaFamiliaActionPerformed(evt);
            }
        });

        jBtAlterarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarFamilia.setText("Alterar");
        jBtAlterarFamilia.setContentAreaFilled(false);
        jBtAlterarFamilia.setEnabled(false);
        jBtAlterarFamilia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarFamilia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFamilia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarFamiliaActionPerformed(evt);
            }
        });

        jBtExcluirFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFamilia.setText("Excluir");
        jBtExcluirFamilia.setContentAreaFilled(false);
        jBtExcluirFamilia.setEnabled(false);
        jBtExcluirFamilia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirFamilia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFamilia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFamiliaActionPerformed(evt);
            }
        });

        jBtSalvarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarFamilia.setText("Gravar");
        jBtSalvarFamilia.setContentAreaFilled(false);
        jBtSalvarFamilia.setEnabled(false);
        jBtSalvarFamilia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarFamilia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFamilia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarFamiliaActionPerformed(evt);
            }
        });

        jBtCancelarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarFamilia.setText("Cancelar");
        jBtCancelarFamilia.setContentAreaFilled(false);
        jBtCancelarFamilia.setEnabled(false);
        jBtCancelarFamilia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarFamilia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFamilia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarFamiliaActionPerformed(evt);
            }
        });

        jBtAuditoriaFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaFamilia.setToolTipText("Auditoria");
        jBtAuditoriaFamilia.setContentAreaFilled(false);
        jBtAuditoriaFamilia.setEnabled(false);
        jBtAuditoriaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jBtNovaFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovaFamilia)
                .addComponent(jBtAlterarFamilia)
                .addComponent(jBtExcluirFamilia)
                .addComponent(jBtSalvarFamilia)
                .addComponent(jBtCancelarFamilia)
                .addComponent(jBtAuditoriaFamilia))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Repetiu ano?");

        jComboBoxRepetiuAno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRepetiuAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRepetiuAno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRepetiuAno.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Por que?");

        jPorqueRepetiuAno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorqueRepetiuAno.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Houve problema com professor?");

        jComboBoxProblemaProfessor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProblemaProfessor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxProblemaProfessor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProblemaProfessor.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Qual?");

        jQualProblemaProfessor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualProblemaProfessor.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Como é a atitude em sala de aula?");

        jComoAtitudeSala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComoAtitudeSala.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Falta muito a escola?");

        jComboBoxFaltaEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFaltaEscola.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFaltaEscola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFaltaEscola.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Por que?");

        jPorqueFaltaEscola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorqueFaltaEscola.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("O que você acha da escola?");

        jComboBoxAchaEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAchaEscola.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Há uma abertura", "Um diálogo", "Tradicional" }));
        jComboBoxAchaEscola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAchaEscola.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRepetiuAno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel44))
                    .addComponent(jLabel45)
                    .addComponent(jLabel47)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jComboBoxProblemaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualProblemaProfessor))
                    .addComponent(jComoAtitudeSala)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jComboBoxFaltaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPorqueFaltaEscola))
                    .addComponent(jPorqueRepetiuAno)
                    .addComponent(jComboBoxAchaEscola, 0, 299, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxRepetiuAno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jPorqueRepetiuAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxProblemaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jQualProblemaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jComoAtitudeSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jComboBoxFaltaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jPorqueFaltaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jComboBoxAchaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EducacaoFamiliaLayout = new javax.swing.GroupLayout(EducacaoFamilia);
        EducacaoFamilia.setLayout(EducacaoFamiliaLayout);
        EducacaoFamiliaLayout.setHorizontalGroup(
            EducacaoFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EducacaoFamiliaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EducacaoFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EducacaoFamiliaLayout.createSequentialGroup()
                        .addGroup(EducacaoFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EducacaoFamiliaLayout.setVerticalGroup(
            EducacaoFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EducacaoFamiliaLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Educação/Família", EducacaoFamilia);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Faz amigos com facilidade?");

        jAmigosFacilidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAmigosFacilidade.setEnabled(false);

        jIntrovertido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIntrovertido.setText("Introvertido");
        jIntrovertido.setEnabled(false);

        jAfetuoso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAfetuoso.setText("Afetuoso");
        jAfetuoso.setEnabled(false);

        jObediente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jObediente.setText("Obediente");
        jObediente.setEnabled(false);

        jResistente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jResistente.setText("Resistente");
        jResistente.setEnabled(false);

        jCooperador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCooperador.setText("Cooperador");
        jCooperador.setEnabled(false);

        jMedroso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMedroso.setText("Medroso");
        jMedroso.setEnabled(false);

        jInseguro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInseguro.setText("Inseguro");
        jInseguro.setEnabled(false);

        jOutros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jOutros.setText("Outros");
        jOutros.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Qual?");

        jQualOutros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualOutros.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAmigosFacilidade))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jMedroso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jInseguro))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jIntrovertido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAfetuoso)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jObediente)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jOutros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jResistente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCooperador))
                            .addComponent(jQualOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jAmigosFacilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIntrovertido)
                    .addComponent(jAfetuoso)
                    .addComponent(jObediente)
                    .addComponent(jResistente)
                    .addComponent(jCooperador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMedroso)
                    .addComponent(jInseguro)
                    .addComponent(jOutros)
                    .addComponent(jLabel24)
                    .addComponent(jQualOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Vida Escolar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Idade em que entrou na escola:");

        jIdadeEscolar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeEscolar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeEscolar.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Adaptação:");

        jAdaptacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAdaptacao.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Repetências:");

        jRepetencias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRepetencias.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("A família presente na vida escolar?");

        jComboBoxFamiliarPresente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFamiliarPresente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        jComboBoxFamiliarPresente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFamiliarPresente.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Há antecedentes familiares com problemas de saúde ou aprendizagem?");

        jComboBoxAntecedentes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAntecedentes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não sei" }));
        jComboBoxAntecedentes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAntecedentes.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Qual problema de saúde ou apredizado?");

        jQualProblemaAprendizado.setColumns(20);
        jQualProblemaAprendizado.setRows(5);
        jQualProblemaAprendizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualProblemaAprendizado.setEnabled(false);
        jScrollPane4.setViewportView(jQualProblemaAprendizado);

        jObservacaoSocializacao.setColumns(20);
        jObservacaoSocializacao.setRows(5);
        jObservacaoSocializacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoSocializacao.setEnabled(false);
        jScrollPane5.setViewportView(jObservacaoSocializacao);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Observação:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdadeEscolar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFamiliarPresente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAntecedentes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jAdaptacao)
                                    .addComponent(jRepetencias)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(jIdadeEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBoxFamiliarPresente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jAdaptacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jRepetencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovaSocializacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaSocializacao.setText("Novo");
        jBtNovaSocializacao.setContentAreaFilled(false);
        jBtNovaSocializacao.setEnabled(false);
        jBtNovaSocializacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaSocializacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaSocializacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaSocializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaSocializacaoActionPerformed(evt);
            }
        });

        jBtAlterarSocializacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarSocializacao.setText("Alterar");
        jBtAlterarSocializacao.setContentAreaFilled(false);
        jBtAlterarSocializacao.setEnabled(false);
        jBtAlterarSocializacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarSocializacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSocializacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSocializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarSocializacaoActionPerformed(evt);
            }
        });

        jBtExcluirSocializacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirSocializacao.setText("Excluir");
        jBtExcluirSocializacao.setContentAreaFilled(false);
        jBtExcluirSocializacao.setEnabled(false);
        jBtExcluirSocializacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirSocializacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSocializacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSocializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirSocializacaoActionPerformed(evt);
            }
        });

        jBtSalvarSocializacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarSocializacao.setText("Gravar");
        jBtSalvarSocializacao.setContentAreaFilled(false);
        jBtSalvarSocializacao.setEnabled(false);
        jBtSalvarSocializacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarSocializacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSocializacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSocializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarSocializacaoActionPerformed(evt);
            }
        });

        jBtCancelarSocializacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarSocializacao.setText("Cancelar");
        jBtCancelarSocializacao.setContentAreaFilled(false);
        jBtCancelarSocializacao.setEnabled(false);
        jBtCancelarSocializacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarSocializacao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSocializacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSocializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarSocializacaoActionPerformed(evt);
            }
        });

        jBtAuditoriaSocializacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaSocializacao.setToolTipText("Auditoria");
        jBtAuditoriaSocializacao.setContentAreaFilled(false);
        jBtAuditoriaSocializacao.setEnabled(false);
        jBtAuditoriaSocializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaSocializacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jBtNovaSocializacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarSocializacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirSocializacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarSocializacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarSocializacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaSocializacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovaSocializacao)
                .addComponent(jBtAlterarSocializacao)
                .addComponent(jBtExcluirSocializacao)
                .addComponent(jBtSalvarSocializacao)
                .addComponent(jBtCancelarSocializacao)
                .addComponent(jBtAuditoriaSocializacao))
        );

        javax.swing.GroupLayout SocializacaoLayout = new javax.swing.GroupLayout(Socializacao);
        Socializacao.setLayout(SocializacaoLayout);
        SocializacaoLayout.setHorizontalGroup(
            SocializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SocializacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SocializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SocializacaoLayout.setVerticalGroup(
            SocializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SocializacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Socialização e Preferências", Socializacao);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Filho(a) desejado(a)?");

        jComboBoxFilhoDesejado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFilhoDesejado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFilhoDesejado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFilhoDesejado.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Você queria engravidar?");

        jComboBoxQueriaEngravidar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQueriaEngravidar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxQueriaEngravidar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQueriaEngravidar.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Foi acidental?");

        jComboBoxFoiAcidental.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFoiAcidental.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFoiAcidental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFoiAcidental.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Perturbou a vida do casal ou de um dos pais?");

        jComboBoxPerturbou.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPerturbou.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPerturbou.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPerturbou.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Como foi a gestação? (cuidados pré-natais, doenças, sintomas, alimentação.)");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextoComoFoiGestacao.setColumns(20);
        jTextoComoFoiGestacao.setRows(5);
        jTextoComoFoiGestacao.setEnabled(false);
        jScrollPane2.setViewportView(jTextoComoFoiGestacao);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Como foi o parto?(sofrimento fetal, má oxigenação, lesões).");

        jScrollPane9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextoComoFoiParto.setColumns(20);
        jTextoComoFoiParto.setRows(5);
        jTextoComoFoiParto.setEnabled(false);
        jScrollPane9.setViewportView(jTextoComoFoiParto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFoiAcidental, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFilhoDesejado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel54))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel52)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxQueriaEngravidar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPerturbou, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jComboBoxFilhoDesejado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(jComboBoxQueriaEngravidar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jComboBoxFoiAcidental, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jComboBoxPerturbou, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoFeminino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoFeminino.setText("Novo");
        jBtNovoFeminino.setContentAreaFilled(false);
        jBtNovoFeminino.setEnabled(false);
        jBtNovoFeminino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoFeminino.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFeminino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoFemininoActionPerformed(evt);
            }
        });

        jBtAlterarFeminino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarFeminino.setText("Alterar");
        jBtAlterarFeminino.setContentAreaFilled(false);
        jBtAlterarFeminino.setEnabled(false);
        jBtAlterarFeminino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarFeminino.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFeminino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarFemininoActionPerformed(evt);
            }
        });

        jBtExcluirFeminino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFeminino.setText("Excluir");
        jBtExcluirFeminino.setContentAreaFilled(false);
        jBtExcluirFeminino.setEnabled(false);
        jBtExcluirFeminino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirFeminino.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFeminino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFemininoActionPerformed(evt);
            }
        });

        jBtSalvarFeminino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarFeminino.setText("Gravar");
        jBtSalvarFeminino.setContentAreaFilled(false);
        jBtSalvarFeminino.setEnabled(false);
        jBtSalvarFeminino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarFeminino.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFeminino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarFemininoActionPerformed(evt);
            }
        });

        jBtCancelarFeminino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarFeminino.setText("Cancelar");
        jBtCancelarFeminino.setContentAreaFilled(false);
        jBtCancelarFeminino.setEnabled(false);
        jBtCancelarFeminino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarFeminino.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFeminino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarFemininoActionPerformed(evt);
            }
        });

        jBtAuditoriaFeminino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaFeminino.setToolTipText("Auditoria");
        jBtAuditoriaFeminino.setContentAreaFilled(false);
        jBtAuditoriaFeminino.setEnabled(false);
        jBtAuditoriaFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaFemininoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jBtNovoFeminino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarFeminino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirFeminino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarFeminino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarFeminino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaFeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovoFeminino)
                .addComponent(jBtAlterarFeminino)
                .addComponent(jBtExcluirFeminino)
                .addComponent(jBtSalvarFeminino)
                .addComponent(jBtCancelarFeminino)
                .addComponent(jBtAuditoriaFeminino))
        );

        javax.swing.GroupLayout FemininoLayout = new javax.swing.GroupLayout(Feminino);
        Feminino.setLayout(FemininoLayout);
        FemininoLayout.setHorizontalGroup(
            FemininoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FemininoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FemininoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        FemininoLayout.setVerticalGroup(
            FemininoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FemininoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Feminino", Feminino);

        jTabelaEvolucaoPedagoga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoPedagoga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Evolução"
            }
        ));
        jTabelaEvolucaoPedagoga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoPedagogaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTabelaEvolucaoPedagoga);
        if (jTabelaEvolucaoPedagoga.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setMinWidth(390);
            jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setMaxWidth(390);
        }

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Data");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Nome Completo do Interno");

        jCodigoEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoEvolucao.setEnabled(false);

        jNomeInternoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolucao.setEnabled(false);

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCodigoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoEvolucao)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir Evolução");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar Evolução");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setToolTipText("Cancelar Evolução");
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setToolTipText("Auditoria Evolução");
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        jTextoEvolucao.setColumns(20);
        jTextoEvolucao.setRows(5);
        jTextoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucao.setEnabled(false);
        jScrollPane8.setViewportView(jTextoEvolucao);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Qual Setor foi Encamihado? ");

        jComboBoxEncaminharSetorEvo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEncaminharSetorEvo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxEncaminharSetorEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEncaminharSetorEvo.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Data");

        jDataEncaminhamentoEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEncaminhamentoEvo.setEnabled(false);

        jHoraEnvioEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraEnvioEvo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jHoraEnvioEvo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraEnvioEvo.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Horário");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxEncaminharSetorEvo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEncaminhamentoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHoraEnvioEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel58)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                    .addComponent(jLabel59)
                    .addGap(74, 74, 74)
                    .addComponent(jLabel60)
                    .addGap(25, 25, 25)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxEncaminharSetorEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEncaminhamentoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraEnvioEvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel60)
                        .addComponent(jLabel59)
                        .addComponent(jLabel58))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        jBtAgendamentoAtendimento.setForeground(new java.awt.Color(0, 0, 255));
        jBtAgendamentoAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png"))); // NOI18N
        jBtAgendamentoAtendimento.setText("Agendar");
        jBtAgendamentoAtendimento.setToolTipText("Agenda Atendimento Psicologico");
        jBtAgendamentoAtendimento.setEnabled(false);
        jBtAgendamentoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAgendamentoAtendimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EvolucaoLayout = new javax.swing.GroupLayout(Evolucao);
        Evolucao.setLayout(EvolucaoLayout);
        EvolucaoLayout.setHorizontalGroup(
            EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EvolucaoLayout.createSequentialGroup()
                        .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAgendamentoAtendimento)
                        .addGap(26, 26, 26)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane8)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        EvolucaoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        EvolucaoLayout.setVerticalGroup(
            EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtAlterarEvolucao)
                        .addComponent(jBtExcluirEvolucao)
                        .addComponent(jBtSalvarEvolucao)
                        .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtAuditoriaEvolucao)
                        .addComponent(jBtNovaEvolucao))
                    .addComponent(jBtAgendamentoAtendimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EvolucaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jTabbedPane1.addTab("Evolução", Evolucao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(350, 40, 565, 511);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
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
                    preencherTodasAdmissao("SELECT * FROM ADMISSAO_PEDAGOGIA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE DataAdm BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquisa.");
        } else {
            preencherTodasAdmissaoNomes("SELECT * FROM ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jCheckBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox9ItemStateChanged
//         TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasAdmissao("SELECT * FROM ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox9ItemStateChanged

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            preencherTodasAdmissao("SELECT * FROM ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdAdm='" + jIDPesqLan.getText() + "'");
        }
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jTabelaAdmissaoPedagogicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdmissaoPedagogicaMouseClicked
        // TODO add your handling code here:        
        if (flag == 1) {
            String IdLanc = "" + jTabelaAdmissaoPedagogica.getValueAt(jTabelaAdmissaoPedagogica.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovaFamilia.setEnabled(true);
            jBtNovaSocializacao.setEnabled(true);
            jBtNovoFeminino.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            jBtAgendamentoAtendimento.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAO_PEDAGOGIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "WHERE IdAdm='" + IdLanc + "'");
                conecta.rs.first();
                jCodigoAdmissao.setText(String.valueOf(conecta.rs.getInt("IdAdm")));
                jStatusAdm.setText(conecta.rs.getString("StatusAdm"));
                jDataAdm.setDate(conecta.rs.getDate("DataAdm"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPedagogia.setIcon(i);
                jFotoInternoPedagogia.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPedagogia.getWidth(), jFotoInternoPedagogia.getHeight(), Image.SCALE_DEFAULT)));
                //
                jIdInternoAdm.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoAdm.setText(conecta.rs.getString("NomeInternoCrc"));
                jNaturalidadeInternoAdm.setText(conecta.rs.getString("NomeCidade"));
                jDataNascimentoInternoAdm.setDate(conecta.rs.getDate("DataNasciCrc"));
                jMaeInternoAdm.setText(conecta.rs.getString("MaeInternoCrc"));
                jPaiInternoAdm.setText(conecta.rs.getString("PaiInternoCrc"));
                jUltimaEscola.setText(conecta.rs.getString("UltimaEscola"));
                jSerieAno.setText(conecta.rs.getString("SerieAno"));
                jTurno.setText(conecta.rs.getString("Turno"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            //EDUCAÇÃO E FAMILIA
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FAMILIA_ADMISSAO_PEDAGOGIA "
                        + "INNER JOIN ADMISSAO_PEDAGOGIA "
                        + "ON FAMILIA_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                        + "WHERE FAMILIA_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
                conecta.rs.first();
                codigoFam = conecta.rs.getInt("IdFam");
                jComboBoxRelacaoPai.setSelectedItem(conecta.rs.getString("RelacaoPai"));
                jComboBoxRelacaoMae.setSelectedItem(conecta.rs.getString("RelacaoMae"));
                jComboBoxIrmaos.setSelectedItem(conecta.rs.getString("Irmaos"));
                jComboBoxPaisLerEscrever.setSelectedItem(conecta.rs.getString("PaisLerEscrever"));
                jComboBoxPaisSeparados.setSelectedItem(conecta.rs.getString("PaisSeparados"));
                jReligiao.setText(conecta.rs.getString("Religiao"));
                jIdadeAndou.setText(conecta.rs.getString("IdadeAndou"));
                jIdadeFalou.setText(conecta.rs.getString("IdadeFalou"));
                jComboBoxDificuldadeFala.setSelectedItem(conecta.rs.getString("DificuldadeFala"));
                jQualDificuldadeFala.setText(conecta.rs.getString("QualDificuldadeFala"));
                jComunicacao.setText(conecta.rs.getString("Comunicacao"));
                jComboBoxRelacionamento.setSelectedItem(conecta.rs.getString("Relacionamento"));
                jComboBoxLider.setSelectedItem(conecta.rs.getString("Lider"));
                jComboBoxRepetiuAno.setSelectedItem(conecta.rs.getString("RepetiuAno"));
                jPorqueRepetiuAno.setText(conecta.rs.getString("PorqueRepetiuAno"));
                jComboBoxProblemaProfessor.setSelectedItem(conecta.rs.getString("ProblemaProfessor"));
                jQualProblemaProfessor.setText(conecta.rs.getString("QualProblemaProfessor"));
                jComoAtitudeSala.setText(conecta.rs.getString("ComoAtitudeSala"));
                jComboBoxFaltaEscola.setSelectedItem(conecta.rs.getString("FaltaEscola"));
                jPorqueFaltaEscola.setText(conecta.rs.getString("PorqueFaltaEscola"));
                jComboBoxAchaEscola.setSelectedItem(conecta.rs.getString("AchaEscola"));
                if (codigoFam != 0) {
                    jBtNovaFamilia.setEnabled(true);
                    jBtAlterarFamilia.setEnabled(true);
                    jBtExcluirFamilia.setEnabled(true);
                    jBtSalvarFamilia.setEnabled(!true);
                    jBtCancelarFamilia.setEnabled(!true);
                    jBtAuditoriaFamilia.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // SOCIALIZAÇÃO
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA "
                        + "INNER JOIN ADMISSAO_PEDAGOGIA "
                        + "ON SOCIALIZACAO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                        + "WHERE SOCIALIZACAO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
                conecta.rs.first();
                codigoSocia = conecta.rs.getInt("IdSocial");
                jAmigosFacilidade.setText(conecta.rs.getString("AmigosFacilidade"));
                introvertido = conecta.rs.getInt("Introvertido");
                if (introvertido == 0) {
                    jIntrovertido.setSelected(true);
                } else if (introvertido == 1) {
                    jIntrovertido.setSelected(!true);
                }
                afetuoso = conecta.rs.getInt("Afetuoso");
                if (afetuoso == 0) {
                    jAfetuoso.setSelected(true);
                } else if (afetuoso == 1) {
                    jAfetuoso.setSelected(!true);
                }
                obediente = conecta.rs.getInt("Obediente");
                if (obediente == 0) {
                    jObediente.setSelected(true);
                } else if (obediente == 1) {
                    jObediente.setSelected(!true);
                }
                resistente = conecta.rs.getInt("Resistente");
                if (resistente == 0) {
                    jResistente.setSelected(true);
                } else if (resistente == 1) {
                    jResistente.setSelected(!true);
                }
                cooperador = conecta.rs.getInt("Cooperador");
                if (cooperador == 0) {
                    jCooperador.setSelected(true);
                } else if (cooperador == 1) {
                    jCooperador.setSelected(!true);
                }
                medroso = conecta.rs.getInt("Medroso");
                if (medroso == 0) {
                    jMedroso.setSelected(true);
                } else if (medroso == 1) {
                    jMedroso.setSelected(!true);
                }
                inseguro = conecta.rs.getInt("Inseguro");
                if (inseguro == 0) {
                    jInseguro.setSelected(true);
                } else if (inseguro == 1) {
                    jInseguro.setSelected(!true);
                }
                outros = conecta.rs.getInt("Outros");
                if (outros == 0) {
                    jOutros.setSelected(true);
                } else if (outros == 1) {
                    jOutros.setSelected(!true);
                }
                jQualOutros.setText(conecta.rs.getString("QualOutros"));
                jIdadeEscolar.setText(conecta.rs.getString("IdadeEscolar"));
                jComboBoxFamiliarPresente.setSelectedItem(conecta.rs.getString("FamiliarPresente"));
                jAdaptacao.setText(conecta.rs.getString("Adaptacao"));
                jRepetencias.setText(conecta.rs.getString("Repetencias"));
                jComboBoxAntecedentes.setSelectedItem(conecta.rs.getString("Antecedentes"));
                jQualProblemaAprendizado.setText(conecta.rs.getString("QualProblemaAprendizado"));
                jObservacaoSocializacao.setText(conecta.rs.getString("ObservacaoSocializacao"));
                if (codigoSocia != 0) {
                    jBtNovaSocializacao.setEnabled(true);
                    jBtAlterarSocializacao.setEnabled(true);
                    jBtExcluirSocializacao.setEnabled(true);
                    jBtSalvarSocializacao.setEnabled(!true);
                    jBtCancelarSocializacao.setEnabled(!true);
                    jBtAuditoriaSocializacao.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // FEMININO
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM FEMININO_ADMISSAO_PEDAGOGIA "
                        + "INNER JOIN ADMISSAO_PEDAGOGIA "
                        + "ON FEMININO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                        + "WHERE FEMININO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
                conecta.rs.first();
                codigoFem = conecta.rs.getInt("IdFemAdm");
                jComboBoxFilhoDesejado.setSelectedItem(conecta.rs.getString("FilhoDesejado"));
                jComboBoxQueriaEngravidar.setSelectedItem(conecta.rs.getString("QueriaEngravidar"));
                jComboBoxFoiAcidental.setSelectedItem(conecta.rs.getString("FoiAcidental"));
                jComboBoxPerturbou.setSelectedItem(conecta.rs.getString("Perturbou"));
                jTextoComoFoiGestacao.setText(conecta.rs.getString("ComoFoiGestacao"));
                jTextoComoFoiParto.setText(conecta.rs.getString("ComoFoiParto"));
                if (codigoFem != 0) {
                    jBtNovoFeminino.setEnabled(true);
                    jBtAlterarFeminino.setEnabled(true);
                    jBtExcluirFeminino.setEnabled(true);
                    jBtSalvarFeminino.setEnabled(!true);
                    jBtCancelarFeminino.setEnabled(!true);
                    jBtAuditoriaFeminino.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // EVOLUÇÃO
            jCodigoEvolucao.setText("");
            jDataEvolucao.setDate(null);
            jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione...");
            jDataEncaminhamentoEvo.setDate(null);
            jHoraEnvioEvo.setText("");
            jTextoEvolucao.setText("");
            preencherEvolucaoPedagogia("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN ADMISSAO_PEDAGOGIA "
                    + "ON EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
        }
        conecta.desconecta();
    }//GEN-LAST:event_jTabelaAdmissaoPedagogicaMouseClicked

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        verificarRegistroBiometria();
        if (pHabilitaPEDA.equals("Não")) {
            TelaPesqInternoAdmPedagogia objPesqAdmPeda = new TelaPesqInternoAdmPedagogia();
            TelaModuloPedagogia.jPainelPedagogia.add(objPesqAdmPeda);
            objPesqAdmPeda.show();
        } else {
            TelaPesqInternoAtendPedaBio objPesqAdmPedaBio = new TelaPesqInternoAtendPedaBio();
            TelaModuloPedagogia.jPainelPedagogia.add(objPesqAdmPedaBio);
            objPesqAdmPedaBio.show();
        }
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoManu_PEDA) && codIncluirPEDA == 1) {
            acao = 1;
            limparTodosCampos();
            bloquearBotoes();
            limparTabelaEvolucao();
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoManu_PEDA) && codAlterarPEDA == 1) {
            objAdmPedago.setStatusAdm(jStatusAdm.getText());
            if (jStatusAdm.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                bloquearCampos();
                bloquearBotoes();
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoManu_PEDA) && codExcluirPEDA == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            verificarRegistros();
            objAdmPedago.setStatusAdm(jStatusAdm.getText());
            if (jStatusAdm.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdInternoAdm.getText().equals(codigoInternoEvolucao)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir essa admissão, existe evolução para esse interno.");
                } else if (jIdInternoAdm.getText().equals(codigoInternoFeminino)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir essa admissão, existe registro na aba Feminino para esse interno.");
                } else if (jIdInternoAdm.getText().equals(codigoInternoSocializa)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir essa admissão, existe registro na aba Socialização e Preferências para esse interno.");
                } else if (jIdInternoAdm.getText().equals(codigoInternoFamilia)) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir essa admissão, existe registro na aba Socialização e Preferências para esse interno.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        limparTodosCampos();
                        bloquearCampos();
                        bloquearBotoes();
                        // MOVIMENTAÇÃO CORPO TÉCNICO
                        objAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
                        objAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
                        objAdmPedago.setDeptoPedagogia(deptoTecnico);
                        controleMov.excluirMovTec(objAdmPedago);
                        //
                        control.excluirAdmissaoEscolar(objAdmPedago);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Excluir();
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoManu_PEDA) && codGravarPEDA == 1) {
            if (jIdInternoAdm.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jDataAdm.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da admissão.");
            } else {
                objAdmPedago.setStatusAdm(jStatusAdm.getText());
                objAdmPedago.setDataAdm(jDataAdm.getDate());
                objAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                objAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
                objAdmPedago.setUltimaEscola(jUltimaEscola.getText());
                objAdmPedago.setSerieAno(jSerieAno.getText());
                objAdmPedago.setTurno(jTurno.getText());
                objAdmPedago.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objAdmPedago.setUsuarioInsert(nameUser);
                    objAdmPedago.setDataInsert(dataModFinal);
                    objAdmPedago.setHorarioInsert(horaMov);
                    //
                    control.incluirAdmissaoEscolar(objAdmPedago);
                    buscarCodigo();
                    // MOVIMENTAÇÃO CORPO TÉCNICO
                    objAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
                    objAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objAdmPedago.setDeptoPedagogia(deptoTecnico);
                    controleMov.incluirMovTec(objAdmPedago);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO                             
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoPEDA);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataAdm.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jCodigoAdmissao.getText()));
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objAdmPedago.setUsuarioUp(nameUser);
                    objAdmPedago.setDataUp(dataModFinal);
                    objAdmPedago.setHorarioUp(horaMov);
                    //
                    objAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
                    control.alterarAdmissaoEscolar(objAdmPedago);
                    // MOVIMENTAÇÃO CORPO TÉCNICO
                    objAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
                    objAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objAdmPedago.setDeptoPedagogia(deptoTecnico);
                    controleMov.alterarMovTec(objAdmPedago);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO                             
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoPEDA);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataAdm.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jCodigoAdmissao.getText()));
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_PEDAGOGIA WHERE IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            jStatusAdm.setText(conecta.rs.getString("StatusAdm"));
            if (jStatusAdm.getText().equals("FINALIZADO")) {
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
        TelaAuditoriaAdmissaoPedagogia objAudAdmPed = new TelaAuditoriaAdmissaoPedagogia();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudAdmPed);
        objAudAdmPed.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaFamiliaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoFami_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoFami_PEDA) && codIncluirPEDA == 1) {
            objAdmPedago.setStatusAdm(jStatusAdm.getText());
            if (jStatusAdm.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                bloquearCampos();
                bloquearBotoes();
                NovaFamilia();
                corCampos();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovaFamiliaActionPerformed

    private void jBtAlterarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarFamiliaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoFami_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoFami_PEDA) && codAlterarPEDA == 1) {
            objAdmPedago.setStatusAdm(jStatusAdm.getText());
            if (jStatusAdm.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                bloquearCampos();
                bloquearBotoes();
                AlterarFamilia();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarFamiliaActionPerformed

    private void jBtExcluirFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFamiliaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoFami_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoFami_PEDA) && codExcluirPEDA == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAdmPedago.setStatusAdm(jStatusAdm.getText());
            if (jStatusAdm.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objFamAdmPedago.setIdFam(codigoFam);
                    controle.excluirFamiliaAdmissaoEscolar(objFamAdmPedago);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                    bloquearCampos();
                    bloquearBotoes();
                    ExcluirFamilia();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirFamiliaActionPerformed

    private void jBtSalvarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarFamiliaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoFami_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoFami_PEDA) && codGravarPEDA == 1) {
            verificarFamilia();
            if (jIdadeAndou.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe uma idade que andou, ou deixe o campo com valor zero.");
            } else if (jIdadeFalou.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe uma idade que falou, ou deixe o campo com valor zero.");
            } else {
                objFamAdmPedago.setRelacaoPai((String) jComboBoxRelacaoPai.getSelectedItem());
                objFamAdmPedago.setRelacaoMae((String) jComboBoxRelacaoMae.getSelectedItem());
                objFamAdmPedago.setIrmaos((String) jComboBoxIrmaos.getSelectedItem());
                objFamAdmPedago.setPaisLerEscrever((String) jComboBoxPaisLerEscrever.getSelectedItem());
                objFamAdmPedago.setPaisSeparados((String) jComboBoxPaisSeparados.getSelectedItem());
                objFamAdmPedago.setReligiao(jReligiao.getText());
                objFamAdmPedago.setIdadeAndou(Integer.valueOf(jIdadeAndou.getText()));
                objFamAdmPedago.setIdadeFalou(Integer.valueOf(jIdadeFalou.getText()));
                objFamAdmPedago.setDificuldadeFala((String) jComboBoxDificuldadeFala.getSelectedItem());
                objFamAdmPedago.setQualDificuldadeFala(jQualDificuldadeFala.getText());
                objFamAdmPedago.setComunicacao(jComunicacao.getText());
                objFamAdmPedago.setRelacionamento((String) jComboBoxRelacionamento.getSelectedItem());
                objFamAdmPedago.setLider((String) jComboBoxLider.getSelectedItem());
                objFamAdmPedago.setRepetiuAno((String) jComboBoxRepetiuAno.getSelectedItem());
                objFamAdmPedago.setPorqueRepetiuAno(jPorqueRepetiuAno.getText());
                objFamAdmPedago.setProblemaProfessor((String) jComboBoxProblemaProfessor.getSelectedItem());
                objFamAdmPedago.setQualProblemaProfessor(jQualProblemaProfessor.getText());
                objFamAdmPedago.setComoAtitudeSala(jComoAtitudeSala.getText());
                objFamAdmPedago.setFaltaEscola((String) jComboBoxFaltaEscola.getSelectedItem());
                objFamAdmPedago.setPorqueFaltaEscola(jPorqueFaltaEscola.getText());
                objFamAdmPedago.setAchaEscola((String) jComboBoxAchaEscola.getSelectedItem());
                objFamAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                objFamAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
                objFamAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
                if (acao == 3) {
                    if (jCodigoAdmissao.getText().equals(codigoAdm) && jIdInternoAdm.getText().equals(codigoInternoFAM)) {
                        JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                    } else {
                        objFamAdmPedago.setUsuarioInsert(nameUser);
                        objFamAdmPedago.setDataInsert(dataModFinal);
                        objFamAdmPedago.setHorarioInsert(horaMov);
                        //
                        controle.incluirFamiliaAdmissaoEscolar(objFamAdmPedago);
                        buscarFamilia();
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        bloquearCampos();
                        bloquearBotoes();
                        SalvarFamilia();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 4) {
                    objFamAdmPedago.setUsuarioUp(nameUser);
                    objFamAdmPedago.setDataUp(dataModFinal);
                    objFamAdmPedago.setHorarioUp(horaMov);
                    //
                    objFamAdmPedago.setIdFam(codigoFam);
                    controle.alterarFamiliaAdmissaoEscolar(objFamAdmPedago);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearCampos();
                    bloquearBotoes();
                    SalvarFamilia();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarFamiliaActionPerformed

    private void jBtCancelarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarFamiliaActionPerformed
        // TODO add your handling code here:
        CancelarFamilia();
    }//GEN-LAST:event_jBtCancelarFamiliaActionPerformed

    private void jBtAuditoriaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaFamiliaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoPedagogiaFam objAudFamPed = new TelaAuditoriaAdmissaoPedagogiaFam();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudFamPed);
        objAudFamPed.show();
    }//GEN-LAST:event_jBtAuditoriaFamiliaActionPerformed

    private void jBtNovaSocializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaSocializacaoActionPerformed
        // TODO add your handling code here:
        objAdmPedago.setStatusAdm(jStatusAdm.getText());
        if (jStatusAdm.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser modificada, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 5;
            bloquearCampos();
            bloquearBotoes();
            corCampos();
            NovaSocializacao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtNovaSocializacaoActionPerformed

    private void jBtAlterarSocializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarSocializacaoActionPerformed
        // TODO add your handling code here:
        objAdmPedago.setStatusAdm(jStatusAdm.getText());
        if (jStatusAdm.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 6;
            bloquearCampos();
            bloquearBotoes();
            corCampos();
            AlterarSocializacao();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtAlterarSocializacaoActionPerformed

    private void jBtExcluirSocializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirSocializacaoActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        objAdmPedago.setStatusAdm(jStatusAdm.getText());
        if (jStatusAdm.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser excluída, o mesmo encontra-se FINALIZADO");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSociaAdmPedago.setIdSocial(codigoSocia);
                controleSocial.excluirAdmissaoSocializaEscolar(objSociaAdmPedago);
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                bloquearCampos();
                bloquearBotoes();
                ExcluirSocializacao();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtExcluirSocializacaoActionPerformed

    private void jBtSalvarSocializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarSocializacaoActionPerformed
        // TODO add your handling code here:
        verificarSocializacao();
        if (jIdadeEscolar.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um valor para a idade em que entrou na escola ou preencha o campo com valor zero.");
        } else {
            objSociaAdmPedago.setAmigosFacilidade(jAmigosFacilidade.getText());
            if (jIntrovertido.isSelected()) {
                introvertido = 0;
            } else if (!jIntrovertido.isSelected()) {
                introvertido = 1;
            }
            objSociaAdmPedago.setIntrovertido(introvertido);
            if (jAfetuoso.isSelected()) {
                afetuoso = 0;
            } else if (!jAfetuoso.isSelected()) {
                afetuoso = 1;
            }
            objSociaAdmPedago.setAfetuoso(afetuoso);
            if (jObediente.isSelected()) {
                obediente = 0;
            } else if (!jObediente.isSelected()) {
                obediente = 1;
            }
            objSociaAdmPedago.setObediente(obediente);
            if (jResistente.isSelected()) {
                resistente = 0;
            } else if (!jResistente.isSelected()) {
                resistente = 1;
            }
            objSociaAdmPedago.setResistente(resistente);
            if (jCooperador.isSelected()) {
                cooperador = 0;
            } else if (!jCooperador.isSelected()) {
                cooperador = 1;
            }
            objSociaAdmPedago.setCooperador(cooperador);
            if (jMedroso.isSelected()) {
                medroso = 0;
            } else if (!jMedroso.isSelected()) {
                medroso = 1;
            }
            objSociaAdmPedago.setMedroso(medroso);
            if (jInseguro.isSelected()) {
                inseguro = 0;
            } else if (jInseguro.isSelected()) {
                inseguro = 1;
            }
            objSociaAdmPedago.setInseguro(inseguro);
            if (jOutros.isSelected()) {
                outros = 0;
            } else if (!jOutros.isSelected()) {
                outros = 1;
            }
            objSociaAdmPedago.setOutros(outros);
            objSociaAdmPedago.setQualOutros(jQualOutros.getText());
            objSociaAdmPedago.setIdadeEscolar(Integer.valueOf(jIdadeEscolar.getText()));
            objSociaAdmPedago.setFamiliarPresente((String) jComboBoxFamiliarPresente.getSelectedItem());
            objSociaAdmPedago.setAdaptacao(jAdaptacao.getText());
            objSociaAdmPedago.setRepetencias(jRepetencias.getText());
            objSociaAdmPedago.setAntecedentes((String) jComboBoxAntecedentes.getSelectedItem());
            objSociaAdmPedago.setQualProblemaAprendizado(jQualProblemaAprendizado.getText());
            objSociaAdmPedago.setObservacaoSocializacao(jObservacaoSocializacao.getText());
            objSociaAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
            objSociaAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
            objSociaAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
            if (acao == 5) {
                if (jCodigoAdmissao.getText().equals(codigoAdmSocial) && jIdInternoAdm.getText().equals(codigoInternoSocial)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objSociaAdmPedago.setUsuarioInsert(nameUser);
                    objSociaAdmPedago.setDataInsert(dataModFinal);
                    objSociaAdmPedago.setHorarioInsert(horaMov);
                    //
                    controleSocial.incluirAdmissaoSocializaEscolar(objSociaAdmPedago);
                    buscarSocializacao();
                    //
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
                    bloquearCampos();
                    bloquearBotoes();
                    SalvarSocializacao();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
            if (acao == 6) {
                objSociaAdmPedago.setUsuarioUp(nameUser);
                objSociaAdmPedago.setDataUp(dataModFinal);
                objSociaAdmPedago.setHorarioUp(horaMov);
                //
                objSociaAdmPedago.setIdSocial(codigoSocia);
                controleSocial.alterarAdmissaoSocializaEscolar(objSociaAdmPedago);
                //
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
                bloquearCampos();
                bloquearBotoes();
                SalvarSocializacao();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarSocializacaoActionPerformed

    private void jBtCancelarSocializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarSocializacaoActionPerformed
        // TODO add your handling code here:
        CancelarSocializacao();
    }//GEN-LAST:event_jBtCancelarSocializacaoActionPerformed

    private void jBtAuditoriaSocializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaSocializacaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoPedagogiaSocia objAudiSociaPed = new TelaAuditoriaAdmissaoPedagogiaSocia();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudiSociaPed);
        objAudiSociaPed.show();
    }//GEN-LAST:event_jBtAuditoriaSocializacaoActionPerformed

    private void jBtNovoFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoFemininoActionPerformed
        // TODO add your handling code here:
        objAdmPedago.setStatusAdm(jStatusAdm.getText());
        if (jStatusAdm.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser modificada, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 7;
            bloquearCampos();
            bloquearBotoes();
            corCampos();
            NovaFeminina();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtNovoFemininoActionPerformed

    private void jBtAlterarFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarFemininoActionPerformed
        // TODO add your handling code here:
        objAdmPedago.setStatusAdm(jStatusAdm.getText());
        if (jStatusAdm.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser modificada, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 8;
            bloquearCampos();
            bloquearBotoes();
            corCampos();
            AlterarFeminina();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtAlterarFemininoActionPerformed

    private void jBtExcluirFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFemininoActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        objAdmPedago.setStatusAdm(jStatusAdm.getText());
        if (jStatusAdm.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Essa admissão de internos não poderá ser excluída, o mesmo encontra-se FINALIZADO");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objFemPedago.setIdFemAdm(codigoFem);
                controleFem.excluirAdmissaoFemininoEscolar(objFemPedago);
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                bloquearCampos();
                bloquearBotoes();
                ExcluirFeminina();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtExcluirFemininoActionPerformed

    private void jBtSalvarFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarFemininoActionPerformed
        // TODO add your handling code here:
        verificarFeminina();
        objFemPedago.setFilhoDesejado((String) jComboBoxFilhoDesejado.getSelectedItem());
        objFemPedago.setQueriaEngravidar((String) jComboBoxQueriaEngravidar.getSelectedItem());
        objFemPedago.setFoiAcidental((String) jComboBoxFoiAcidental.getSelectedItem());
        objFemPedago.setPerturbou((String) jComboBoxPerturbou.getSelectedItem());
        objFemPedago.setComoFoiGestacao(jTextoComoFoiGestacao.getText());
        objFemPedago.setComoFoiParto(jTextoComoFoiParto.getText());
        objFemPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
        objFemPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
        objFemPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
        if (acao == 7) {
            if (jCodigoAdmissao.getText().equals(codigoAdmFem) && jIdInternoAdm.getText().equals(codigoInternoFem)) {
                JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
            } else {
                objFemPedago.setUsuarioInsert(nameUser);
                objFemPedago.setDataInsert(dataModFinal);
                objFemPedago.setHorarioInsert(horaMov);
                //
                controleFem.incluirAdmissaoFemininoEscolar(objFemPedago);
                buscarFeminina();
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                bloquearCampos();
                bloquearBotoes();
                SalvarFeminina();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
        if (acao == 8) {
            objFemPedago.setUsuarioUp(nameUser);
            objFemPedago.setDataUp(dataModFinal);
            objFemPedago.setHorarioUp(horaMov);
            //
            objFemPedago.setIdFemAdm(codigoFem);
            controleFem.alterarAdmissaoFemininoEscolar(objFemPedago);
            objLog4();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            bloquearBotoes();
            SalvarFeminina();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
        }
    }//GEN-LAST:event_jBtSalvarFemininoActionPerformed

    private void jBtCancelarFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarFemininoActionPerformed
        // TODO add your handling code here:
        CancelarFeminina();
    }//GEN-LAST:event_jBtCancelarFemininoActionPerformed

    private void jBtAuditoriaFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaFemininoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoPedagogiaFem objAudFemPed = new TelaAuditoriaAdmissaoPedagogiaFem();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudFemPed);
        objAudFemPed.show();
    }//GEN-LAST:event_jBtAuditoriaFemininoActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:
        verificarInternoRegistradoAdm();
        if (atendido == null) {
            JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
        } else if (atendido.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
        } else if (atendido.equals("Sim")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
        } else if (atendido.equals("Não")) {
            acao = 9;
            bloquearCampos();
            bloquearBotoes();
            corCampos();
            NovaEvolucao();
            preencherComboBoxDepartamento();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        acao = 10;
        bloquearCampos();
        bloquearBotoes();
        corCampos();
        AlterarEvolucao();
        preencherComboBoxDepartamento();
        statusMov = "Alterar";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objEvolucaoAdmPedago.setIdEvolucao(Integer.valueOf(jCodigoEvolucao.getText()));
            controleEvol.excluirEvolucaoPed(objEvolucaoAdmPedago);
            objLog5();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            bloquearBotoes();
            ExcluirEvolucao();
            preencherEvolucaoPedagogia("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN ADMISSAO_PEDAGOGIA "
                    + "ON EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        if (!jComboBoxEncaminharSetorEvo.getSelectedItem().equals("Selecione...") && jDataEncaminhamentoEvo.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar a data do agendamento.");
        } else if (!jComboBoxEncaminharSetorEvo.getSelectedItem().equals("Selecione...") && jHoraEnvioEvo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar a hora do agendamento.");
        } else if (jDataEvolucao.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar a data da evolução.");
        } else {
            objEvolucaoAdmPedago.setDataEvolucao(jDataEvolucao.getDate());
            objEvolucaoAdmPedago.setNomeDepartamento((String) jComboBoxEncaminharSetorEvo.getSelectedItem());
            objEvolucaoAdmPedago.setDataEncaminhamento(jDataEncaminhamentoEvo.getDate());
            objEvolucaoAdmPedago.setHoraEncaminhamento(jHoraEnvioEvo.getText());
            objEvolucaoAdmPedago.setHistorico(jTextoEvolucao.getText());
            objEvolucaoAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
            objEvolucaoAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
            objEvolucaoAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
            if (acao == 9) {
                objEvolucaoAdmPedago.setUsuarioInsert(nameUser);
                objEvolucaoAdmPedago.setDataInsert(dataModFinal);
                objEvolucaoAdmPedago.setHorarioInsert(horaMov);
                //
                controleEvol.incluirEvolucaoPed(objEvolucaoAdmPedago);
                buscarEvolucao();
                // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                atendido = "Sim";
                objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                objRegAtend.setIdDepartamento(codigoDepartamentoPEDA);
                objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                objRegAtend.setAtendido(atendido);
                objRegAtend.setDataAtendimento(jDataEvolucao.getDate());
                objRegAtend.setIdAtend(Integer.valueOf(jCodigoAdmissao.getText()));
                objRegAtend.setIdEvol(Integer.valueOf(jCodigoEvolucao.getText()));
                objRegAtend.setAtendeEvol(atendido);
                //
                objRegAtend.setUsuarioUp(nameUser);
                objRegAtend.setDataUp(dataModFinal);
                objRegAtend.setHorarioUp(horaMov);
                controlRegAtend.alterarRegEvol(objRegAtend);
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarEvolucao();
                preencherEvolucaoPedagogia("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA "
                        + "INNER JOIN ADMISSAO_PEDAGOGIA "
                        + "ON EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 10) {
                objEvolucaoAdmPedago.setUsuarioUp(nameUser);
                objEvolucaoAdmPedago.setDataUp(dataModFinal);
                objEvolucaoAdmPedago.setHorarioUp(horaMov);
                //
                objEvolucaoAdmPedago.setIdEvolucao(Integer.valueOf(jCodigoEvolucao.getText()));
                controleEvol.alterarEvolucaoPed(objEvolucaoAdmPedago);
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarEvolucao();
                preencherEvolucaoPedagogia("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA "
                        + "INNER JOIN ADMISSAO_PEDAGOGIA "
                        + "ON EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAO_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE EVOLUCAO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoPedagogiaEvolucao objAudiEvo = new TelaAuditoriaAdmissaoPedagogiaEvolucao();
        TelaModuloPedagogia.jPainelPedagogia.add(objAudiEvo);
        objAudiEvo.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jBtAgendamentoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAgendamentoAtendimentoActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("") && jCodigoAdmissao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário gravar primeiro a admissão para poder fazer o agendamento.");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA "
                        + "INNER JOIN ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA "
                        + "ON AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA.IdReg=ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA.IdReg "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA.IdInternoCrc='" + jIdInternoAdm.getText() + "'");
                conecta.rs.first();
                nomeDepartamento = conecta.rs.getString("Departamento");
                codigoStatusReg = conecta.rs.getString("StatusReg");
                codigoInterno = conecta.rs.getString("IdInternoCrc");
            } catch (Exception e) {
            }
            if (jIdInternoAdm.getText().equals(codigoInterno) && nomeDepartamento.equals("PEDAGOGIA") && codigoStatusReg.equals("Não Realizado")) {
                JOptionPane.showMessageDialog(rootPane, "Já existe um agendamento para esse interno nesse departamento.");
            } else {
                mostrarAgendaAtendimento();
            }
        }
    }//GEN-LAST:event_jBtAgendamentoAtendimentoActionPerformed

    private void jTabelaEvolucaoPedagogaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoPedagogaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String IdEvolucao = "" + jTabelaEvolucaoPedagoga.getValueAt(jTabelaEvolucaoPedagoga.getSelectedRow(), 0);
            jCodigoEvolucao.setText(IdEvolucao);
            //           
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            //                   
            jComboBoxEncaminharSetorEvo.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA WHERE IdEvolucao='" + IdEvolucao + "'");
                conecta.rs.first();
                jCodigoEvolucao.setText(conecta.rs.getString("IdEvolucao"));
                jDataEvolucao.setDate(conecta.rs.getDate("DataEvolucao"));
                jNomeInternoEvolucao.setText(jNomeInternoAdm.getText());
                jComboBoxEncaminharSetorEvo.addItem(conecta.rs.getString("NomeDepartamento"));
                jDataEncaminhamentoEvo.setDate(conecta.rs.getDate("DataEncaminhamento"));
                jHoraEnvioEvo.setText(conecta.rs.getString("HoraEncaminhamento"));
                jTextoEvolucao.setText(conecta.rs.getString("TextoEvolucao"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro na seleção...\nERRO: " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoPedagogaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admissao;
    private javax.swing.JPanel EducacaoFamilia;
    private javax.swing.JPanel Evolucao;
    private javax.swing.JPanel Feminino;
    private javax.swing.JPanel Socializacao;
    private javax.swing.JTextField jAdaptacao;
    private javax.swing.JCheckBox jAfetuoso;
    private javax.swing.JTextField jAmigosFacilidade;
    private javax.swing.JButton jBtAgendamentoAtendimento;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAlterarFamilia;
    private javax.swing.JButton jBtAlterarFeminino;
    private javax.swing.JButton jBtAlterarSocializacao;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtAuditoriaFamilia;
    private javax.swing.JButton jBtAuditoriaFeminino;
    private javax.swing.JButton jBtAuditoriaSocializacao;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtCancelarFamilia;
    private javax.swing.JButton jBtCancelarFeminino;
    private javax.swing.JButton jBtCancelarSocializacao;
    private javax.swing.JButton jBtDataLanc;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtExcluirFamilia;
    private javax.swing.JButton jBtExcluirFeminino;
    private javax.swing.JButton jBtExcluirSocializacao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtNomeInterno;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovaFamilia;
    private javax.swing.JButton jBtNovaSocializacao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoFeminino;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jBtSalvarFamilia;
    private javax.swing.JButton jBtSalvarFeminino;
    private javax.swing.JButton jBtSalvarSocializacao;
    private javax.swing.JCheckBox jCheckBox9;
    public static javax.swing.JTextField jCodigoAdmissao;
    public static javax.swing.JTextField jCodigoEvolucao;
    private javax.swing.JComboBox jComboBoxAchaEscola;
    private javax.swing.JComboBox jComboBoxAntecedentes;
    private javax.swing.JComboBox jComboBoxDificuldadeFala;
    private javax.swing.JComboBox jComboBoxEncaminharSetorEvo;
    private javax.swing.JComboBox jComboBoxFaltaEscola;
    private javax.swing.JComboBox jComboBoxFamiliarPresente;
    private javax.swing.JComboBox jComboBoxFilhoDesejado;
    private javax.swing.JComboBox jComboBoxFoiAcidental;
    private javax.swing.JComboBox jComboBoxIrmaos;
    private javax.swing.JComboBox jComboBoxLider;
    private javax.swing.JComboBox jComboBoxPaisLerEscrever;
    private javax.swing.JComboBox jComboBoxPaisSeparados;
    private javax.swing.JComboBox jComboBoxPerturbou;
    private javax.swing.JComboBox jComboBoxProblemaProfessor;
    private javax.swing.JComboBox jComboBoxQueriaEngravidar;
    private javax.swing.JComboBox jComboBoxRelacaoMae;
    private javax.swing.JComboBox jComboBoxRelacaoPai;
    private javax.swing.JComboBox jComboBoxRelacionamento;
    private javax.swing.JComboBox jComboBoxRepetiuAno;
    private javax.swing.JTextField jComoAtitudeSala;
    private javax.swing.JTextArea jComunicacao;
    private javax.swing.JCheckBox jCooperador;
    private com.toedter.calendar.JDateChooser jDataAdm;
    private com.toedter.calendar.JDateChooser jDataEncaminhamentoEvo;
    private com.toedter.calendar.JDateChooser jDataEvolucao;
    public static com.toedter.calendar.JDateChooser jDataNascimentoInternoAdm;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JLabel jFotoInternoPedagogia;
    private javax.swing.JFormattedTextField jHoraEnvioEvo;
    private javax.swing.JTextField jIDPesqLan;
    public static javax.swing.JTextField jIdInternoAdm;
    private javax.swing.JTextField jIdadeAndou;
    private javax.swing.JFormattedTextField jIdadeEscolar;
    private javax.swing.JTextField jIdadeFalou;
    private javax.swing.JCheckBox jInseguro;
    private javax.swing.JCheckBox jIntrovertido;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMaeInternoAdm;
    private javax.swing.JCheckBox jMedroso;
    public static javax.swing.JTextField jNaturalidadeInternoAdm;
    public static javax.swing.JTextField jNomeInternoAdm;
    private javax.swing.JTextField jNomeInternoEvolucao;
    private javax.swing.JCheckBox jObediente;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JTextArea jObservacaoSocializacao;
    private javax.swing.JCheckBox jOutros;
    public static javax.swing.JTextField jPaiInternoAdm;
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
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JTextField jPorqueFaltaEscola;
    private javax.swing.JTextField jPorqueRepetiuAno;
    private javax.swing.JTextField jQualDificuldadeFala;
    private javax.swing.JTextField jQualOutros;
    private javax.swing.JTextArea jQualProblemaAprendizado;
    private javax.swing.JTextField jQualProblemaProfessor;
    private javax.swing.JTextField jReligiao;
    private javax.swing.JTextField jRepetencias;
    private javax.swing.JCheckBox jResistente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jSerieAno;
    private javax.swing.JTextField jStatusAdm;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAdmissaoPedagogica;
    private javax.swing.JTable jTabelaEvolucaoPedagoga;
    private javax.swing.JTextArea jTextoComoFoiGestacao;
    private javax.swing.JTextArea jTextoComoFoiParto;
    private javax.swing.JTextArea jTextoEvolucao;
    private javax.swing.JTextField jTurno;
    private javax.swing.JTextField jUltimaEscola;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        // ADMISSÃO
        jUltimaEscola.setDocument(new LimiteDigitosAlfa(75));
        jSerieAno.setDocument(new LimiteDigitosAlfa(37));
        jTurno.setDocument(new LimiteDigitosAlfa(43));
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        // EDUCAÇÃO/FAMILIA
        jReligiao.setDocument(new LimiteDigitosAlfa(75));
        jIdadeAndou.setDocument(new LimiteDigitosNum(5));
        jIdadeFalou.setDocument(new LimiteDigitosNum(5));
        jQualDificuldadeFala.setDocument(new LimiteDigitosAlfa(40));
        jPorqueRepetiuAno.setDocument(new LimiteDigitosAlfa(49));
        jQualProblemaProfessor.setDocument(new LimiteDigitosAlfa(33));
        jComoAtitudeSala.setDocument(new LimiteDigitosAlfa(49));
        jPorqueFaltaEscola.setDocument(new LimiteDigitosAlfa(30));
        jComunicacao.setLineWrap(true);
        jComunicacao.setWrapStyleWord(true);
        // SOCIALIZAÇÃO E PREFERENCIAS
        jAmigosFacilidade.setDocument(new LimiteDigitosAlfa(56));
        jQualOutros.setDocument(new LimiteDigitosAlfa(34));
        jIdadeEscolar.setDocument(new LimiteDigitosNum(5));
        jAdaptacao.setDocument(new LimiteDigitosAlfa(69));
        jRepetencias.setDocument(new LimiteDigitosAlfa(69));

        jQualProblemaAprendizado.setLineWrap(true);
        jQualProblemaAprendizado.setWrapStyleWord(true);
        jObservacaoSocializacao.setLineWrap(true);
        jObservacaoSocializacao.setWrapStyleWord(true);
        // FEMININO
        jTextoComoFoiGestacao.setLineWrap(true);
        jTextoComoFoiGestacao.setWrapStyleWord(true);
        jTextoComoFoiParto.setLineWrap(true);
        jTextoComoFoiParto.setWrapStyleWord(true);
        //EVOLUÇÃO
        jTextoEvolucao.setLineWrap(true);
        jTextoEvolucao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jCodigoAdmissao.setBackground(Color.white);
        jStatusAdm.setBackground(Color.white);
        jDataAdm.setBackground(Color.white);
        jIdInternoAdm.setBackground(Color.white);
        jNomeInternoAdm.setBackground(Color.white);
        jNaturalidadeInternoAdm.setBackground(Color.white);
        jDataNascimentoInternoAdm.setBackground(Color.white);
        jMaeInternoAdm.setBackground(Color.white);
        jPaiInternoAdm.setBackground(Color.white);
        jUltimaEscola.setBackground(Color.white);
        jSerieAno.setBackground(Color.white);
        jTurno.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        // EDUCAÇÃO/FAMILIA
        jComboBoxRelacaoPai.setBackground(Color.white);
        jComboBoxRelacaoMae.setBackground(Color.white);
        jComboBoxIrmaos.setBackground(Color.white);
        jComboBoxPaisLerEscrever.setBackground(Color.white);
        jComboBoxPaisSeparados.setBackground(Color.white);
        jReligiao.setBackground(Color.white);
        jIdadeAndou.setBackground(Color.white);
        jIdadeFalou.setBackground(Color.white);
        jQualDificuldadeFala.setBackground(Color.white);
        jComunicacao.setBackground(Color.white);
        jComboBoxRelacionamento.setBackground(Color.white);
        jComboBoxLider.setBackground(Color.white);
        jComboBoxRepetiuAno.setBackground(Color.white);
        jPorqueRepetiuAno.setBackground(Color.white);
        jComboBoxProblemaProfessor.setBackground(Color.white);
        jQualProblemaProfessor.setBackground(Color.white);
        jComoAtitudeSala.setBackground(Color.white);
        jComboBoxFaltaEscola.setBackground(Color.white);
        jPorqueFaltaEscola.setBackground(Color.white);
        jComboBoxAchaEscola.setBackground(Color.white);
        // SOCIALIZAÇÃO
        jAmigosFacilidade.setBackground(Color.white);
        jQualOutros.setBackground(Color.white);
        jIdadeEscolar.setBackground(Color.white);
        jComboBoxFamiliarPresente.setBackground(Color.white);
        jAdaptacao.setBackground(Color.white);
        jRepetencias.setBackground(Color.white);
        jComboBoxAntecedentes.setBackground(Color.white);
        jQualProblemaAprendizado.setBackground(Color.white);
        jObservacaoSocializacao.setBackground(Color.white);
        //FEMININO
        jComboBoxFilhoDesejado.setBackground(Color.white);
        jComboBoxQueriaEngravidar.setBackground(Color.white);
        jComboBoxFoiAcidental.setBackground(Color.white);
        jComboBoxPerturbou.setBackground(Color.white);
        jTextoComoFoiGestacao.setBackground(Color.white);
        jTextoComoFoiParto.setBackground(Color.white);
        // EVOLUÇAO
        jCodigoEvolucao.setBackground(Color.white);
        jDataEvolucao.setBackground(Color.white);
        jNomeInternoEvolucao.setBackground(Color.white);
        jTextoEvolucao.setBackground(Color.white);
    }

    public void bloquearCampos() {
        jCodigoAdmissao.setEnabled(!true);
        jStatusAdm.setEnabled(!true);
        jDataAdm.setEnabled(!true);
        jIdInternoAdm.setEnabled(!true);
        jNomeInternoAdm.setEnabled(!true);
        jNaturalidadeInternoAdm.setEnabled(!true);
        jDataNascimentoInternoAdm.setEnabled(!true);
        jMaeInternoAdm.setEnabled(!true);
        jPaiInternoAdm.setEnabled(!true);
        jUltimaEscola.setEnabled(!true);
        jSerieAno.setEnabled(!true);
        jTurno.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // FAMILIA
        jComboBoxRelacaoPai.setEnabled(!true);
        jComboBoxRelacaoMae.setEnabled(!true);
        jComboBoxIrmaos.setEnabled(!true);
        jComboBoxPaisLerEscrever.setEnabled(!true);
        jComboBoxPaisSeparados.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jIdadeAndou.setEnabled(!true);
        jIdadeFalou.setEnabled(!true);
        jComboBoxDificuldadeFala.setEnabled(!true);
        jQualDificuldadeFala.setEnabled(!true);
        jQualDificuldadeFala.setEnabled(!true);
        jComunicacao.setEnabled(!true);
        jComboBoxRelacionamento.setEnabled(!true);
        jComboBoxLider.setEnabled(!true);
        jComboBoxRepetiuAno.setEnabled(!true);
        jPorqueRepetiuAno.setEnabled(!true);
        jComboBoxProblemaProfessor.setEnabled(!true);
        jQualProblemaProfessor.setEnabled(!true);
        jComoAtitudeSala.setEnabled(!true);
        jComboBoxFaltaEscola.setEnabled(!true);
        jPorqueFaltaEscola.setEnabled(!true);
        jComboBoxAchaEscola.setEnabled(!true);
        // SOCIALIZAÇÃO
        jAmigosFacilidade.setEnabled(!true);
        jIntrovertido.setEnabled(!true);
        jAfetuoso.setEnabled(!true);
        jObediente.setEnabled(!true);
        jResistente.setEnabled(!true);
        jCooperador.setEnabled(!true);
        jMedroso.setEnabled(!true);
        jInseguro.setEnabled(!true);
        jOutros.setEnabled(!true);
        jQualOutros.setEnabled(!true);
        jIdadeEscolar.setEnabled(!true);
        jComboBoxFamiliarPresente.setEnabled(!true);
        jAdaptacao.setEnabled(!true);
        jRepetencias.setEnabled(!true);
        jComboBoxAntecedentes.setEnabled(!true);
        jQualProblemaAprendizado.setEnabled(!true);
        jObservacaoSocializacao.setEnabled(!true);
        //FEMININO
        jComboBoxFilhoDesejado.setEnabled(!true);
        jComboBoxQueriaEngravidar.setEnabled(!true);
        jComboBoxFoiAcidental.setEnabled(!true);
        jComboBoxPerturbou.setEnabled(!true);
        jTextoComoFoiGestacao.setEnabled(!true);
        jTextoComoFoiParto.setEnabled(!true);
        // EVOLUÇAO
        jCodigoEvolucao.setEnabled(!true);
        jDataEvolucao.setEnabled(!true);
        jNomeInternoEvolucao.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
    }

    public void limparTodosCampos() {
        jCodigoAdmissao.setText("");
        jStatusAdm.setText("");
        jDataAdm.setDate(null);
        jFotoInternoPedagogia.setIcon(null);
        jIdInternoAdm.setText("");
        jNomeInternoAdm.setText("");
        jNaturalidadeInternoAdm.setText("");
        jDataNascimentoInternoAdm.setDate(null);
        jMaeInternoAdm.setText("");
        jPaiInternoAdm.setText("");
        jUltimaEscola.setText("");
        jSerieAno.setText("");
        jTurno.setText("");
        jObservacao.setText("");
        // FAMILIA
        jComboBoxRelacaoPai.setSelectedItem("Não");
        jComboBoxRelacaoMae.setSelectedItem("Não");
        jComboBoxIrmaos.setSelectedItem("Não");
        jComboBoxPaisLerEscrever.setSelectedItem("Não");
        jComboBoxPaisSeparados.setSelectedItem("Não");
        jReligiao.setText("");
        jIdadeAndou.setText("0");
        jIdadeFalou.setText("0");
        jComboBoxDificuldadeFala.setSelectedItem("Não");
        jQualDificuldadeFala.setText("");
        jQualDificuldadeFala.setText("");
        jComunicacao.setText("");
        jComboBoxRelacionamento.setSelectedItem("Não");
        jComboBoxLider.setSelectedItem("Não");
        jComboBoxRepetiuAno.setSelectedItem("Não");
        jPorqueRepetiuAno.setText("");
        jComboBoxProblemaProfessor.setSelectedItem("Não");
        jQualProblemaProfessor.setText("");
        jComoAtitudeSala.setText("");
        jComboBoxFaltaEscola.setSelectedItem("Não");
        jPorqueFaltaEscola.setText("");
        jComboBoxAchaEscola.setSelectedItem("Não");
        // SOCIALIZAÇÃO
        jAmigosFacilidade.setText("");
        jIntrovertido.setSelected(!true);
        jAfetuoso.setSelected(!true);
        jObediente.setSelected(!true);
        jResistente.setSelected(!true);
        jCooperador.setSelected(!true);
        jMedroso.setSelected(!true);
        jInseguro.setSelected(!true);
        jOutros.setSelected(!true);
        jQualOutros.setText("");
        jIdadeEscolar.setText("0");
        jComboBoxFamiliarPresente.setSelectedItem("Não");
        jAdaptacao.setText("");
        jRepetencias.setText("");
        jComboBoxAntecedentes.setSelectedItem("Não");
        jQualProblemaAprendizado.setText("");
        jObservacaoSocializacao.setText("");
        //FEMININO
        jComboBoxFilhoDesejado.setSelectedItem("Não");
        jComboBoxQueriaEngravidar.setSelectedItem("Não");
        jComboBoxFoiAcidental.setSelectedItem("Não");
        jComboBoxPerturbou.setSelectedItem("Não");
        jTextoComoFoiGestacao.setText("");
        jTextoComoFoiParto.setText("");
        // EVOLUÇAO
        jCodigoEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucao.setText("");
        jTextoEvolucao.setText("");
    }

    public void bloquearBotoes() {
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // EDUCAÇÃO/FAMILIA
        jBtNovaFamilia.setEnabled(!true);
        jBtAlterarFamilia.setEnabled(!true);
        jBtExcluirFamilia.setEnabled(!true);
        jBtSalvarFamilia.setEnabled(!true);
        jBtCancelarFamilia.setEnabled(!true);
        jBtAuditoriaFamilia.setEnabled(!true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(!true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(!true);
        // FEMININO
        jBtNovoFeminino.setEnabled(!true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void Novo() {
        jStatusAdm.setText("ABERTO");
        jDataAdm.setCalendar(Calendar.getInstance());
        //
        jDataAdm.setEnabled(true);
        jUltimaEscola.setEnabled(true);
        jSerieAno.setEnabled(true);
        jTurno.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesquisarInterno.setEnabled(true);
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
        jDataAdm.setEnabled(true);
        jUltimaEscola.setEnabled(true);
        jSerieAno.setEnabled(true);
        jTurno.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesquisarInterno.setEnabled(true);
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
        jBtPesquisarInterno.setEnabled(!true);
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
        jBtPesquisarInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // FAMILIA/SOCIALIZAÇÃO/EVOLUÇÃO
        jBtNovaFamilia.setEnabled(true);
        jBtNovaSocializacao.setEnabled(true);
        jBtNovoFeminino.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void Cancelar() {
        if (jCodigoAdmissao.getText().equals("")) {
            limparTodosCampos();
            bloquearCampos();
            //
            jBtPesquisarInterno.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            bloquearCampos();
            //
            jBtPesquisarInterno.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // FAMILIA/SOCIALIZAÇÃO/EVOLUÇÃO
            jBtNovaFamilia.setEnabled(true);
            jBtNovaSocializacao.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
        }
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
            objAdmPedago.setStatusAdm(statusLanc);
            objAdmPedago.setIdAdm(Integer.parseInt(jCodigoAdmissao.getText()));
            control.finalizarAdmissaoEscolar(objAdmPedago);
            // MOVIMENTAÇÃO CORPO TÉCNICO
            objAdmPedago.setIdAdm(Integer.valueOf(jCodigoAdmissao.getText()));
            objAdmPedago.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
            objAdmPedago.setNomeInternoCrc(jNomeInternoAdm.getText());
            objAdmPedago.setDeptoPedagogia(deptoTecnico);
            controleMov.finalizarMovTec(objAdmPedago);
            //
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusAdm.setText("FINALIZADO");
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_PEDAGOGIA");
            conecta.rs.last();
            jCodigoAdmissao.setText(conecta.rs.getString("IdAdm"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarRegistros() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FAMILIA_ADMISSAO_PEDAGOGIA WHERE IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoInternoFamilia = conecta.rs.getString("IdInternoCrc");
            //
            conecta.executaSQL("SELECT * FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA WHERE IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoInternoSocializa = conecta.rs.getString("IdInternoCrc");
            //
            conecta.executaSQL("SELECT * FROM FEMININO_ADMISSAO_PEDAGOGIA WHERE IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoInternoFeminino = conecta.rs.getString("IdInternoCrc");
            //
            conecta.executaSQL("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA WHERE IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoInternoEvolucao = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaFamilia() {
        jComboBoxRelacaoPai.setSelectedItem("Não");
        jComboBoxRelacaoMae.setSelectedItem("Não");
        jComboBoxIrmaos.setSelectedItem("Não");
        jComboBoxPaisLerEscrever.setSelectedItem("Não");
        jComboBoxPaisSeparados.setSelectedItem("Não");
        jReligiao.setText("");
        jIdadeAndou.setText("0");
        jIdadeFalou.setText("0");
        jComboBoxDificuldadeFala.setSelectedItem("Não");
        jQualDificuldadeFala.setText("");
        jQualDificuldadeFala.setText("");
        jComunicacao.setText("");
        jComboBoxRelacionamento.setSelectedItem("Não");
        jComboBoxLider.setSelectedItem("Não");
        jComboBoxRepetiuAno.setSelectedItem("Não");
        jPorqueRepetiuAno.setText("");
        jComboBoxProblemaProfessor.setSelectedItem("Não");
        jQualProblemaProfessor.setText("");
        jComoAtitudeSala.setText("");
        jComboBoxFaltaEscola.setSelectedItem("Não");
        jPorqueFaltaEscola.setText("");
        jComboBoxAchaEscola.setSelectedItem("Não");
        //
        jComboBoxRelacaoPai.setEnabled(true);
        jComboBoxRelacaoMae.setEnabled(true);
        jComboBoxIrmaos.setEnabled(true);
        jComboBoxPaisLerEscrever.setEnabled(true);
        jComboBoxPaisSeparados.setEnabled(true);
        jReligiao.setEnabled(true);
        jIdadeAndou.setEnabled(true);
        jIdadeFalou.setEnabled(true);
        jComboBoxDificuldadeFala.setEnabled(true);
        jQualDificuldadeFala.setEnabled(true);
        jQualDificuldadeFala.setEnabled(true);
        jComunicacao.setEnabled(true);
        jComboBoxRelacionamento.setEnabled(true);
        jComboBoxLider.setEnabled(true);
        jComboBoxRepetiuAno.setEnabled(true);
        jPorqueRepetiuAno.setEnabled(true);
        jComboBoxProblemaProfessor.setEnabled(true);
        jQualProblemaProfessor.setEnabled(true);
        jComoAtitudeSala.setEnabled(true);
        jComboBoxFaltaEscola.setEnabled(true);
        jPorqueFaltaEscola.setEnabled(true);
        jComboBoxAchaEscola.setEnabled(true);
        //
        jBtNovaFamilia.setEnabled(!true);
        jBtAlterarFamilia.setEnabled(!true);
        jBtExcluirFamilia.setEnabled(!true);
        jBtSalvarFamilia.setEnabled(true);
        jBtCancelarFamilia.setEnabled(true);
        jBtAuditoriaFamilia.setEnabled(!true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(!true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(!true);
        //
        jBtNovoFeminino.setEnabled(!true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void AlterarFamilia() {
        jComboBoxRelacaoPai.setEnabled(true);
        jComboBoxRelacaoMae.setEnabled(true);
        jComboBoxIrmaos.setEnabled(true);
        jComboBoxPaisLerEscrever.setEnabled(true);
        jComboBoxPaisSeparados.setEnabled(true);
        jReligiao.setEnabled(true);
        jIdadeAndou.setEnabled(true);
        jIdadeFalou.setEnabled(true);
        jComboBoxDificuldadeFala.setEnabled(true);
        jQualDificuldadeFala.setEnabled(true);
        jQualDificuldadeFala.setEnabled(true);
        jComunicacao.setEnabled(true);
        jComboBoxRelacionamento.setEnabled(true);
        jComboBoxLider.setEnabled(true);
        jComboBoxRepetiuAno.setEnabled(true);
        jPorqueRepetiuAno.setEnabled(true);
        jComboBoxProblemaProfessor.setEnabled(true);
        jQualProblemaProfessor.setEnabled(true);
        jComoAtitudeSala.setEnabled(true);
        jComboBoxFaltaEscola.setEnabled(true);
        jPorqueFaltaEscola.setEnabled(true);
        jComboBoxAchaEscola.setEnabled(true);
        //
        jBtNovaFamilia.setEnabled(!true);
        jBtAlterarFamilia.setEnabled(!true);
        jBtExcluirFamilia.setEnabled(!true);
        jBtSalvarFamilia.setEnabled(true);
        jBtCancelarFamilia.setEnabled(true);
        jBtAuditoriaFamilia.setEnabled(!true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(!true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(!true);
        //
        jBtNovoFeminino.setEnabled(!true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirFamilia() {

        jComboBoxRelacaoPai.setSelectedItem("Não");
        jComboBoxRelacaoMae.setSelectedItem("Não");
        jComboBoxIrmaos.setSelectedItem("Não");
        jComboBoxPaisLerEscrever.setSelectedItem("Não");
        jComboBoxPaisSeparados.setSelectedItem("Não");
        jReligiao.setText("");
        jIdadeAndou.setText("0");
        jIdadeFalou.setText("0");
        jComboBoxDificuldadeFala.setSelectedItem("Não");
        jQualDificuldadeFala.setText("");
        jQualDificuldadeFala.setText("");
        jComunicacao.setText("");
        jComboBoxRelacionamento.setSelectedItem("Não");
        jComboBoxLider.setSelectedItem("Não");
        jComboBoxRepetiuAno.setSelectedItem("Não");
        jPorqueRepetiuAno.setText("");
        jComboBoxProblemaProfessor.setSelectedItem("Não");
        jQualProblemaProfessor.setText("");
        jComoAtitudeSala.setText("");
        jComboBoxFaltaEscola.setSelectedItem("Não");
        jPorqueFaltaEscola.setText("");
        jComboBoxAchaEscola.setSelectedItem("Não");
        //
        jBtNovaFamilia.setEnabled(true);
        jBtAlterarFamilia.setEnabled(true);
        jBtExcluirFamilia.setEnabled(true);
        jBtSalvarFamilia.setEnabled(!true);
        jBtCancelarFamilia.setEnabled(!true);
        jBtAuditoriaFamilia.setEnabled(true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(true);
        jBtAlterarSocializacao.setEnabled(true);
        jBtExcluirSocializacao.setEnabled(true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(true);
        //
        jBtNovoFeminino.setEnabled(true);
        jBtAlterarFeminino.setEnabled(true);
        jBtExcluirFeminino.setEnabled(true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarFamilia() {
        jBtNovaFamilia.setEnabled(true);
        jBtAlterarFamilia.setEnabled(true);
        jBtExcluirFamilia.setEnabled(true);
        jBtSalvarFamilia.setEnabled(!true);
        jBtCancelarFamilia.setEnabled(!true);
        jBtAuditoriaFamilia.setEnabled(true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(true);
        jBtAlterarSocializacao.setEnabled(true);
        jBtExcluirSocializacao.setEnabled(true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(true);
        //
        jBtNovoFeminino.setEnabled(true);
        jBtAlterarFeminino.setEnabled(true);
        jBtExcluirFeminino.setEnabled(true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarFamilia() {
        jComboBoxRelacaoPai.setEnabled(!true);
        jComboBoxRelacaoMae.setEnabled(!true);
        jComboBoxIrmaos.setEnabled(!true);
        jComboBoxPaisLerEscrever.setEnabled(!true);
        jComboBoxPaisSeparados.setEnabled(!true);
        jReligiao.setEnabled(!true);
        jIdadeAndou.setEnabled(!true);
        jIdadeFalou.setEnabled(!true);
        jComboBoxDificuldadeFala.setEnabled(!true);
        jQualDificuldadeFala.setEnabled(!true);
        jQualDificuldadeFala.setEnabled(!true);
        jComunicacao.setEnabled(!true);
        jComboBoxRelacionamento.setEnabled(!true);
        jComboBoxLider.setEnabled(!true);
        jComboBoxRepetiuAno.setEnabled(!true);
        jPorqueRepetiuAno.setEnabled(!true);
        jComboBoxProblemaProfessor.setEnabled(!true);
        jQualProblemaProfessor.setEnabled(!true);
        jComoAtitudeSala.setEnabled(!true);
        jComboBoxFaltaEscola.setEnabled(!true);
        jPorqueFaltaEscola.setEnabled(!true);
        jComboBoxAchaEscola.setEnabled(!true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FAMILIA_ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN ADMISSAO_PEDAGOGIA "
                    + "ON FAMILIA_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                    + "WHERE FAMILIA_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoFam = conecta.rs.getInt("IdFam");
            jComboBoxRelacaoPai.setSelectedItem(conecta.rs.getString("RelacaoPai"));
            jComboBoxRelacaoMae.setSelectedItem(conecta.rs.getString("RelacaoMae"));
            jComboBoxIrmaos.setSelectedItem(conecta.rs.getString("Irmaos"));
            jComboBoxPaisLerEscrever.setSelectedItem(conecta.rs.getString("PaisLerEscrever"));
            jComboBoxPaisSeparados.setSelectedItem(conecta.rs.getString("PaisSeparados"));
            jReligiao.setText(conecta.rs.getString("Religiao"));
            jIdadeAndou.setText(conecta.rs.getString("IdadeAndou"));
            jIdadeFalou.setText(conecta.rs.getString("IdadeFalou"));
            jComboBoxDificuldadeFala.setSelectedItem(conecta.rs.getString("DificuldadeFala"));
            jQualDificuldadeFala.setText(conecta.rs.getString("DificuldadeFala"));
            jComunicacao.setText(conecta.rs.getString("Comunicacao"));
            jComboBoxRelacionamento.setSelectedItem(conecta.rs.getString("Relacionamento"));
            jComboBoxLider.setSelectedItem(conecta.rs.getString("Lider"));
            jComboBoxRepetiuAno.setSelectedItem(conecta.rs.getString("RepetiuAno"));
            jPorqueRepetiuAno.setText(conecta.rs.getString("PorqueRepetiuAno"));
            jComboBoxProblemaProfessor.setSelectedItem(conecta.rs.getString("ProblemaProfessor"));
            jQualProblemaProfessor.setText(conecta.rs.getString("QualProblemaProfessor"));
            jComoAtitudeSala.setText(conecta.rs.getString("ComoAtitudeSala"));
            jComboBoxFaltaEscola.setSelectedItem(conecta.rs.getString("FaltaEscola"));
            jPorqueFaltaEscola.setText(conecta.rs.getString("PorqueFaltaEscola"));
            jComboBoxAchaEscola.setSelectedItem(conecta.rs.getString("AchaEscola"));
            if (codigoFam != 0) {
                jBtNovaFamilia.setEnabled(true);
                jBtAlterarFamilia.setEnabled(true);
                jBtExcluirFamilia.setEnabled(true);
                jBtSalvarFamilia.setEnabled(!true);
                jBtCancelarFamilia.setEnabled(!true);
                jBtAuditoriaFamilia.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarFamilia() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FAMILIA_ADMISSAO_PEDAGOGIA");
            conecta.rs.last();
            codigoFam = conecta.rs.getInt("IdFam");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarFamilia() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FAMILIA_ADMISSAO_PEDAGOGIA "
                    + "WHERE IdAdm='" + jCodigoAdmissao.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoAdm.getText() + "'");
            conecta.rs.first();
            codigoAdm = conecta.rs.getString("IdAdm");
            codigoInternoFAM = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaSocializacao() {
        jAmigosFacilidade.setText("");
        jIntrovertido.setSelected(!true);
        jAfetuoso.setSelected(!true);
        jObediente.setSelected(!true);
        jResistente.setSelected(!true);
        jCooperador.setSelected(!true);
        jMedroso.setSelected(!true);
        jInseguro.setSelected(!true);
        jOutros.setSelected(!true);
        jQualOutros.setText("");
        jIdadeEscolar.setText("0");
        jComboBoxFamiliarPresente.setSelectedItem("Não");
        jAdaptacao.setText("");
        jRepetencias.setText("");
        jComboBoxAntecedentes.setSelectedItem("Não");
        jQualProblemaAprendizado.setText("");
        jObservacaoSocializacao.setText("");
        //
        jAmigosFacilidade.setEnabled(true);
        jIntrovertido.setEnabled(true);
        jAfetuoso.setEnabled(true);
        jObediente.setEnabled(true);
        jResistente.setEnabled(true);
        jCooperador.setEnabled(true);
        jMedroso.setEnabled(true);
        jInseguro.setEnabled(true);
        jOutros.setEnabled(true);
        jQualOutros.setEnabled(true);
        jIdadeEscolar.setEnabled(true);
        jComboBoxFamiliarPresente.setEnabled(true);
        jAdaptacao.setEnabled(true);
        jRepetencias.setEnabled(true);
        jComboBoxAntecedentes.setEnabled(true);
        jQualProblemaAprendizado.setEnabled(true);
        jObservacaoSocializacao.setEnabled(true);
        //
        jBtNovaSocializacao.setEnabled(!true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(true);
        jBtCancelarSocializacao.setEnabled(true);
        jBtAuditoriaSocializacao.setEnabled(!true);
    }

    public void AlterarSocializacao() {
        jAmigosFacilidade.setEnabled(true);
        jIntrovertido.setEnabled(true);
        jAfetuoso.setEnabled(true);
        jObediente.setEnabled(true);
        jResistente.setEnabled(true);
        jCooperador.setEnabled(true);
        jMedroso.setEnabled(true);
        jInseguro.setEnabled(true);
        jOutros.setEnabled(true);
        jQualOutros.setEnabled(true);
        jIdadeEscolar.setEnabled(true);
        jComboBoxFamiliarPresente.setEnabled(true);
        jAdaptacao.setEnabled(true);
        jRepetencias.setEnabled(true);
        jComboBoxAntecedentes.setEnabled(true);
        jQualProblemaAprendizado.setEnabled(true);
        jObservacaoSocializacao.setEnabled(true);
        //
        jBtNovaSocializacao.setEnabled(!true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(true);
        jBtCancelarSocializacao.setEnabled(true);
        jBtAuditoriaSocializacao.setEnabled(!true);
    }

    public void ExcluirSocializacao() {
        jAmigosFacilidade.setText("");
        jIntrovertido.setSelected(!true);
        jAfetuoso.setSelected(!true);
        jObediente.setSelected(!true);
        jResistente.setSelected(!true);
        jCooperador.setSelected(!true);
        jMedroso.setSelected(!true);
        jInseguro.setSelected(!true);
        jOutros.setSelected(!true);
        jQualOutros.setText("");
        jIdadeEscolar.setText("0");
        jComboBoxFamiliarPresente.setSelectedItem("Não");
        jAdaptacao.setText("");
        jRepetencias.setText("");
        jComboBoxAntecedentes.setSelectedItem("Não");
        jQualProblemaAprendizado.setText("");
        jObservacaoSocializacao.setText("");
        //
        jAmigosFacilidade.setEnabled(!true);
        jIntrovertido.setEnabled(!true);
        jAfetuoso.setEnabled(!true);
        jObediente.setEnabled(!true);
        jResistente.setEnabled(!true);
        jCooperador.setEnabled(!true);
        jMedroso.setEnabled(!true);
        jInseguro.setEnabled(!true);
        jOutros.setEnabled(!true);
        jQualOutros.setEnabled(!true);
        jIdadeEscolar.setEnabled(!true);
        jComboBoxFamiliarPresente.setEnabled(!true);
        jAdaptacao.setEnabled(!true);
        jRepetencias.setEnabled(!true);
        jComboBoxAntecedentes.setEnabled(!true);
        jQualProblemaAprendizado.setEnabled(!true);
        jObservacaoSocializacao.setEnabled(!true);
        //
        jBtNovaSocializacao.setEnabled(true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(true);
        jBtAuditoriaSocializacao.setEnabled(!true);
    }

    public void SalvarSocializacao() {
        jAmigosFacilidade.setEnabled(!true);
        jIntrovertido.setEnabled(!true);
        jAfetuoso.setEnabled(!true);
        jObediente.setEnabled(!true);
        jResistente.setEnabled(!true);
        jCooperador.setEnabled(!true);
        jMedroso.setEnabled(!true);
        jInseguro.setEnabled(!true);
        jOutros.setEnabled(!true);
        jQualOutros.setEnabled(!true);
        jIdadeEscolar.setEnabled(!true);
        jComboBoxFamiliarPresente.setEnabled(!true);
        jAdaptacao.setEnabled(!true);
        jRepetencias.setEnabled(!true);
        jComboBoxAntecedentes.setEnabled(!true);
        jQualProblemaAprendizado.setEnabled(!true);
        jObservacaoSocializacao.setEnabled(!true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(true);
        jBtAlterarSocializacao.setEnabled(true);
        jBtExcluirSocializacao.setEnabled(true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(true);
        // FEMININO
        jBtNovoFeminino.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EDUCAÇÃO/FAMILIA
        jBtNovaFamilia.setEnabled(true);
    }

    public void CancelarSocializacao() {
        jAmigosFacilidade.setEnabled(!true);
        jIntrovertido.setEnabled(!true);
        jAfetuoso.setEnabled(!true);
        jObediente.setEnabled(!true);
        jResistente.setEnabled(!true);
        jCooperador.setEnabled(!true);
        jMedroso.setEnabled(!true);
        jInseguro.setEnabled(!true);
        jOutros.setEnabled(!true);
        jQualOutros.setEnabled(!true);
        jIdadeEscolar.setEnabled(!true);
        jComboBoxFamiliarPresente.setEnabled(!true);
        jAdaptacao.setEnabled(!true);
        jRepetencias.setEnabled(!true);
        jComboBoxAntecedentes.setEnabled(!true);
        jQualProblemaAprendizado.setEnabled(!true);
        jObservacaoSocializacao.setEnabled(!true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN ADMISSAO_PEDAGOGIA "
                    + "ON SOCIALIZACAO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                    + "WHERE SOCIALIZACAO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoSocia = conecta.rs.getInt("IdSocial");
            jAmigosFacilidade.setText(conecta.rs.getString("AmigosFacilidade"));
            introvertido = conecta.rs.getInt("Introvertido");
            if (introvertido == 0) {
                jIntrovertido.setSelected(true);
            } else if (introvertido == 1) {
                jIntrovertido.setSelected(!true);
            }
            afetuoso = conecta.rs.getInt("Afetuoso");
            if (afetuoso == 0) {
                jAfetuoso.setSelected(true);
            } else if (afetuoso == 1) {
                jAfetuoso.setSelected(!true);
            }
            obediente = conecta.rs.getInt("Obediente");
            if (obediente == 0) {
                jObediente.setSelected(true);
            } else if (obediente == 1) {
                jObediente.setSelected(!true);
            }
            resistente = conecta.rs.getInt("Resistente");
            if (resistente == 0) {
                jResistente.setSelected(true);
            } else if (resistente == 1) {
                jResistente.setSelected(!true);
            }
            cooperador = conecta.rs.getInt("Cooperador");
            if (cooperador == 0) {
                jCooperador.setSelected(true);
            } else if (cooperador == 1) {
                jCooperador.setSelected(!true);
            }
            medroso = conecta.rs.getInt("Medroso");
            if (medroso == 0) {
                jMedroso.setSelected(true);
            } else if (medroso == 1) {
                jMedroso.setSelected(!true);
            }
            inseguro = conecta.rs.getInt("Inseguro");
            if (inseguro == 0) {
                jInseguro.setSelected(true);
            } else if (inseguro == 1) {
                jInseguro.setSelected(!true);
            }
            outros = conecta.rs.getInt("Outros");
            if (outros == 0) {
                jOutros.setSelected(true);
            } else if (outros == 1) {
                jOutros.setSelected(!true);
            }
            jQualOutros.setText(conecta.rs.getString("QualOutros"));
            jIdadeEscolar.setText(conecta.rs.getString("IdadeEscolar"));
            jComboBoxFamiliarPresente.setSelectedItem(conecta.rs.getString("FamiliarPresente"));
            jAdaptacao.setText(conecta.rs.getString("Adaptacao"));
            jRepetencias.setText(conecta.rs.getString("Repetencias"));
            jComboBoxAntecedentes.setSelectedItem(conecta.rs.getString("Antecedentes"));
            jQualProblemaAprendizado.setText(conecta.rs.getString("QualProblemaAprendizado"));
            jObservacaoSocializacao.setText(conecta.rs.getString("ObservacaoSocializacao"));
            if (codigoSocia != 0) {
                jBtNovaSocializacao.setEnabled(true);
                jBtAlterarSocializacao.setEnabled(true);
                jBtExcluirSocializacao.setEnabled(true);
                jBtSalvarSocializacao.setEnabled(!true);
                jBtCancelarSocializacao.setEnabled(!true);
                jBtAuditoriaSocializacao.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarSocializacao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA");
            conecta.rs.last();
            codigoSocia = conecta.rs.getInt("IdSocial");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarSocializacao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA "
                    + "WHERE IdAdm='" + jCodigoAdmissao.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoAdm.getText() + "'");
            conecta.rs.first();
            codigoAdmSocial = conecta.rs.getString("IdAdm");
            codigoInternoSocial = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaFeminina() {
        jComboBoxFilhoDesejado.setSelectedItem("Não");
        jComboBoxQueriaEngravidar.setSelectedItem("Não");
        jComboBoxFoiAcidental.setSelectedItem("Não");
        jComboBoxPerturbou.setSelectedItem("Não");
        jTextoComoFoiGestacao.setText("");
        jTextoComoFoiParto.setText("");
        //
        jComboBoxFilhoDesejado.setEnabled(true);
        jComboBoxQueriaEngravidar.setEnabled(true);
        jComboBoxFoiAcidental.setEnabled(true);
        jComboBoxPerturbou.setEnabled(true);
        jTextoComoFoiGestacao.setEnabled(true);
        jTextoComoFoiParto.setEnabled(true);
        //
        jBtNovoFeminino.setEnabled(!true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
    }

    public void AlterarFeminina() {
        jComboBoxFilhoDesejado.setEnabled(true);
        jComboBoxQueriaEngravidar.setEnabled(true);
        jComboBoxFoiAcidental.setEnabled(true);
        jComboBoxPerturbou.setEnabled(true);
        jTextoComoFoiGestacao.setEnabled(true);
        jTextoComoFoiParto.setEnabled(true);
        //
        jBtNovoFeminino.setEnabled(!true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
    }

    public void ExcluirFeminina() {
        jComboBoxFilhoDesejado.setSelectedItem("Não");
        jComboBoxQueriaEngravidar.setSelectedItem("Não");
        jComboBoxFoiAcidental.setSelectedItem("Não");
        jComboBoxPerturbou.setSelectedItem("Não");
        jTextoComoFoiGestacao.setText("");
        jTextoComoFoiParto.setText("");
        //
        jComboBoxFilhoDesejado.setEnabled(!true);
        jComboBoxQueriaEngravidar.setEnabled(!true);
        jComboBoxFoiAcidental.setEnabled(!true);
        jComboBoxPerturbou.setEnabled(!true);
        jTextoComoFoiGestacao.setEnabled(!true);
        jTextoComoFoiParto.setEnabled(!true);
        //
        jBtNovoFeminino.setEnabled(true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
    }

    public void SalvarFeminina() {
        jComboBoxFilhoDesejado.setEnabled(!true);
        jComboBoxQueriaEngravidar.setEnabled(!true);
        jComboBoxFoiAcidental.setEnabled(!true);
        jComboBoxPerturbou.setEnabled(!true);
        jTextoComoFoiGestacao.setEnabled(!true);
        jTextoComoFoiParto.setEnabled(!true);
        // FEMININO
        jBtNovoFeminino.setEnabled(true);
        jBtAlterarFeminino.setEnabled(true);
        jBtExcluirFeminino.setEnabled(true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(true);
        jBtAuditoriaFeminino.setEnabled(true);
        // EVOLUÇÃO
        jBtNovaEvolucao.setEnabled(true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EDUCAÇÃO/FAMILIA
        jBtNovaFamilia.setEnabled(true);
        //
        jBtNovaSocializacao.setEnabled(true);
    }

    public void CancelarFeminina() {
        jComboBoxFilhoDesejado.setEnabled(!true);
        jComboBoxQueriaEngravidar.setEnabled(!true);
        jComboBoxFoiAcidental.setEnabled(!true);
        jComboBoxPerturbou.setEnabled(!true);
        jTextoComoFoiGestacao.setEnabled(!true);
        jTextoComoFoiParto.setEnabled(!true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FEMININO_ADMISSAO_PEDAGOGIA "
                    + "INNER JOIN ADMISSAO_PEDAGOGIA "
                    + "ON FEMININO_ADMISSAO_PEDAGOGIA.IdAdm=ADMISSAO_PEDAGOGIA.IdAdm "
                    + "WHERE FEMININO_ADMISSAO_PEDAGOGIA.IdAdm='" + jCodigoAdmissao.getText() + "'");
            conecta.rs.first();
            codigoFem = conecta.rs.getInt("IdFemAdm");
            jComboBoxFilhoDesejado.setSelectedItem(conecta.rs.getString("FilhoDesejado"));
            jComboBoxQueriaEngravidar.setSelectedItem(conecta.rs.getString("QueriaEngravidar"));
            jComboBoxFoiAcidental.setSelectedItem(conecta.rs.getString("FoiAcidental"));
            jComboBoxPerturbou.setSelectedItem(conecta.rs.getString("Perturbou"));
            jTextoComoFoiGestacao.setText(conecta.rs.getString("ComoFoiGestacao"));
            jTextoComoFoiParto.setText(conecta.rs.getString("ComoFoiParto"));
            if (codigoFem != 0) {
                jBtNovoFeminino.setEnabled(true);
                jBtAlterarFeminino.setEnabled(true);
                jBtExcluirFeminino.setEnabled(true);
                jBtSalvarFeminino.setEnabled(!true);
                jBtCancelarFeminino.setEnabled(!true);
                jBtAuditoriaFeminino.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }

    public void buscarFeminina() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FEMININO_ADMISSAO_PEDAGOGIA");
            conecta.rs.last();
            codigoFem = conecta.rs.getInt("IdFemAdm");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarFeminina() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FEMININO_ADMISSAO_PEDAGOGIA "
                    + "WHERE IdAdm='" + jCodigoAdmissao.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoAdm.getText() + "'");
            conecta.rs.first();
            codigoAdmFem = conecta.rs.getString("IdAdm");
            codigoInternoFem = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaEvolucao() {
        jCodigoEvolucao.setText("");
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jNomeInternoEvolucao.setText(jNomeInternoAdm.getText());
        jComboBoxEncaminharSetorEvo.setSelectedItem("Seleciione...");
        jDataEncaminhamentoEvo.setCalendar(Calendar.getInstance());
        jHoraEnvioEvo.setText(jHoraSistema.getText());
        jTextoEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(true);
        jComboBoxEncaminharSetorEvo.setEnabled(true);
        jDataEncaminhamentoEvo.setEnabled(true);
        jHoraEnvioEvo.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        jDataEvolucao.setEnabled(true);
        jComboBoxEncaminharSetorEvo.setEnabled(true);
        jDataEncaminhamentoEvo.setEnabled(true);
        jHoraEnvioEvo.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jCodigoEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucao.setText("");
        jComboBoxEncaminharSetorEvo.setSelectedItem("Seleciione...");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("");
        jTextoEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EDUCAÇÃO/FAMILIA
        jBtNovaFamilia.setEnabled(true);
        jBtAlterarFamilia.setEnabled(!true);
        jBtExcluirFamilia.setEnabled(!true);
        jBtSalvarFamilia.setEnabled(!true);
        jBtCancelarFamilia.setEnabled(!true);
        jBtAuditoriaFamilia.setEnabled(!true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(!true);
        //FEMININO
        jBtNovoFeminino.setEnabled(true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
    }

    public void SalvarEvolucao() {
        jDataEvolucao.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // EDUCAÇÃO/FAMILIA
        jBtNovaFamilia.setEnabled(true);
        jBtAlterarFamilia.setEnabled(!true);
        jBtExcluirFamilia.setEnabled(!true);
        jBtSalvarFamilia.setEnabled(!true);
        jBtCancelarFamilia.setEnabled(!true);
        jBtAuditoriaFamilia.setEnabled(!true);
        // SOCIALIZAÇÃO
        jBtNovaSocializacao.setEnabled(true);
        jBtAlterarSocializacao.setEnabled(!true);
        jBtExcluirSocializacao.setEnabled(!true);
        jBtSalvarSocializacao.setEnabled(!true);
        jBtCancelarSocializacao.setEnabled(!true);
        jBtAuditoriaSocializacao.setEnabled(!true);
        //FEMININO
        jBtNovoFeminino.setEnabled(true);
        jBtAlterarFeminino.setEnabled(!true);
        jBtExcluirFeminino.setEnabled(!true);
        jBtSalvarFeminino.setEnabled(!true);
        jBtCancelarFeminino.setEnabled(!true);
        jBtAuditoriaFeminino.setEnabled(!true);
    }

    public void CancelarEvolucao() {
        if (jCodigoEvolucao.getText().equals("")) {
            jDataEvolucao.setDate(null);
            jNomeInternoEvolucao.setText("");
            jComboBoxEncaminharSetorEvo.setSelectedItem("Seleciione...");
            jDataEncaminhamentoEvo.setDate(null);
            jHoraEnvioEvo.setText("");
            jTextoEvolucao.setText("");
            //
            jDataEvolucao.setEnabled(!true);
            jComboBoxEncaminharSetorEvo.setEnabled(!true);
            jDataEncaminhamentoEvo.setEnabled(!true);
            jHoraEnvioEvo.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // EDUCAÇÃO/FAMILIA
            jBtNovaFamilia.setEnabled(true);
            jBtAlterarFamilia.setEnabled(!true);
            jBtExcluirFamilia.setEnabled(!true);
            jBtSalvarFamilia.setEnabled(!true);
            jBtCancelarFamilia.setEnabled(!true);
            jBtAuditoriaFamilia.setEnabled(!true);
            // SOCIALIZAÇÃO
            jBtNovaSocializacao.setEnabled(true);
            jBtAlterarSocializacao.setEnabled(!true);
            jBtExcluirSocializacao.setEnabled(!true);
            jBtSalvarSocializacao.setEnabled(!true);
            jBtCancelarSocializacao.setEnabled(!true);
            jBtAuditoriaSocializacao.setEnabled(!true);
            //FEMININO
            jBtNovoFeminino.setEnabled(true);
            jBtAlterarFeminino.setEnabled(!true);
            jBtExcluirFeminino.setEnabled(!true);
            jBtSalvarFeminino.setEnabled(!true);
            jBtCancelarFeminino.setEnabled(!true);
            jBtAuditoriaFeminino.setEnabled(!true);
        } else {
            jDataEvolucao.setEnabled(!true);
            jComboBoxEncaminharSetorEvo.setEnabled(!true);
            jDataEncaminhamentoEvo.setEnabled(!true);
            jHoraEnvioEvo.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            // ADMISSÃO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // EDUCAÇÃO/FAMILIA
            jBtNovaFamilia.setEnabled(true);
            jBtAlterarFamilia.setEnabled(!true);
            jBtExcluirFamilia.setEnabled(!true);
            jBtSalvarFamilia.setEnabled(!true);
            jBtCancelarFamilia.setEnabled(!true);
            jBtAuditoriaFamilia.setEnabled(!true);
            // SOCIALIZAÇÃO
            jBtNovaSocializacao.setEnabled(true);
            jBtAlterarSocializacao.setEnabled(!true);
            jBtExcluirSocializacao.setEnabled(!true);
            jBtSalvarSocializacao.setEnabled(!true);
            jBtCancelarSocializacao.setEnabled(!true);
            jBtAuditoriaSocializacao.setEnabled(!true);
            //FEMININO
            jBtNovoFeminino.setEnabled(true);
            jBtAlterarFeminino.setEnabled(!true);
            jBtExcluirFeminino.setEnabled(!true);
            jBtSalvarFeminino.setEnabled(!true);
            jBtCancelarFeminino.setEnabled(!true);
            jBtAuditoriaFeminino.setEnabled(!true);
        }
    }

    public void buscarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_ADMISSAO_PEDAGOGIA");
            conecta.rs.last();
            jCodigoEvolucao.setText(conecta.rs.getString("IdEvolucao"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void preencherComboBoxDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxEncaminharSetorEvo.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos!!!\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void preencherTodasAdmissao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código ", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataCadastro = conecta.rs.getString("DataAdm");
                String dia = dataCadastro.substring(8, 10);
                String mes = dataCadastro.substring(5, 7);
                String ano = dataCadastro.substring(0, 4);
                dataCadastro = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAdm"), dataCadastro, conecta.rs.getString("StatusAdm"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPedagogica.setModel(modelo);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setPreferredWidth(370);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPedagogica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPedagogica.setAutoResizeMode(jTabelaAdmissaoPedagogica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPedagogica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaMatriculas();
        conecta.desconecta();
    }

    public void preencherTodasAdmissaoNomes(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código ", "Data ", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataCadastro = conecta.rs.getString("DataAdm");
                String dia = dataCadastro.substring(8, 10);
                String mes = dataCadastro.substring(5, 7);
                String ano = dataCadastro.substring(0, 4);
                dataCadastro = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAdm"), dataCadastro, conecta.rs.getString("StatusAdm"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPedagogica.setModel(modelo);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setPreferredWidth(370);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPedagogica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPedagogica.setAutoResizeMode(jTabelaAdmissaoPedagogica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPedagogica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaMatriculas();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código ", "Data", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdmissaoPedagogica.setModel(modelo);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setPreferredWidth(370);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdmissaoPedagogica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPedagogica.getTableHeader().setReorderingAllowed(false);
        jTabelaAdmissaoPedagogica.setAutoResizeMode(jTabelaAdmissaoPedagogica.AUTO_RESIZE_OFF);
        jTabelaAdmissaoPedagogica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaMatriculas() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAdmissaoPedagogica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherEvolucaoPedagogia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataEvolucao = conecta.rs.getString("DataEvolucao");
                String diae = dataEvolucao.substring(8, 10);
                String mese = dataEvolucao.substring(5, 7);
                String anoe = dataEvolucao.substring(0, 4);
                dataEvolucao = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvolucao"), dataEvolucao, conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPedagoga.setModel(modelo);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setPreferredWidth(390);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPedagoga.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPedagoga.setAutoResizeMode(jTabelaEvolucaoPedagoga.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPedagoga.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucao();
        conecta.desconecta();
    }

    public void alinharCamposTabelaEvolucao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPedagoga.setModel(modelo);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setPreferredWidth(390);
        jTabelaEvolucaoPedagoga.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPedagoga.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPedagoga.setAutoResizeMode(jTabelaEvolucaoPedagoga.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPedagoga.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAdmissao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAdmissao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAdmissao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAdmissao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAdmissao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void verificarInternoRegistradoAdm() {

        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataAdm.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoPEDA = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaPEDA = conecta.rs.getString("BiometriaPeda");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserPEDA = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserPEDA + "'");
            conecta.rs.first();
            codigoUserGroupPEDA = conecta.rs.getInt("IdUsuario");
            codigoGrupoPEDA = conecta.rs.getInt("IdGrupo");
            nomeGrupoPEDA = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserPEDA + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoPEDA = conecta.rs.getInt("IdUsuario");
            codAbrirPEDA = conecta.rs.getInt("Abrir");
            codIncluirPEDA = conecta.rs.getInt("Incluir");
            codAlterarPEDA = conecta.rs.getInt("Alterar");
            codExcluirPEDA = conecta.rs.getInt("Excluir");
            codGravarPEDA = conecta.rs.getInt("Gravar");
            codConsultarPEDA = conecta.rs.getInt("Consultar");
            nomeTelaPEDA = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
