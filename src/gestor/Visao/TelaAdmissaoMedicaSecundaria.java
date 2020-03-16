/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdmissaoMedicaAdicional;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoMedica;
import gestor.Controle.ControleEvolucaoPsiquiatrica;
import gestor.Controle.ControleItensDoencaAdicional;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovDiagnosticoMedico;
import gestor.Controle.ControleMovEvolucaoMedica;
import gestor.Controle.ControleMovMedico;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AdmissaoMedica;
import gestor.Modelo.EvolucaoMedica;
import gestor.Modelo.EvolucaoPsiquiatrica;
import gestor.Modelo.ItensDoencas;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAdmissaoMedica.codigoDepartamentoENF;
import static gestor.Visao.TelaAdmissaoMedica.jIdAdm;
import static gestor.Visao.TelaAdmissaoMedica.jIdEvolucaoMedica;
import static gestor.Visao.TelaAdmissaoMedica.jIdEvolucaoPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jIdInternoAdm;
import static gestor.Visao.TelaAdmissaoMedica.jTabelaEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jTabelaEvolucaoMedica;
import static gestor.Visao.TelaAdmissaoMedica.jTextoEvolucaoPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jTotalRegistrosMed;
import static gestor.Visao.TelaAdmissaoMedica.jTotalRegistrosPsi;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeModuloENFER;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAcessoProntuarioMedicoENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaAdmissaoMedicaSecundaria extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoMedica objAdmMedico = new AdmissaoMedica();
    ControleAdmissaoMedicaAdicional control = new ControleAdmissaoMedicaAdicional();
    ControleMovMedico controle = new ControleMovMedico();
    ItensDoencas objItensDoenca = new ItensDoencas();
    ControleItensDoencaAdicional controlePat = new ControleItensDoencaAdicional();
    //
    EvolucaoPsiquiatrica objEvolPsiquiatrica = new EvolucaoPsiquiatrica();
    ControleEvolucaoPsiquiatrica controlEvolPsiquiatrica = new ControleEvolucaoPsiquiatrica();
    ControleMovDiagnosticoMedico controlMovDiag = new ControleMovDiagnosticoMedico();
    //
    EvolucaoMedica objEvolMedica = new EvolucaoMedica();
    ControleEvolucaoMedica controleEvoluMed = new ControleEvolucaoMedica(); // Controle Evolução Médica
    ControleMovEvolucaoMedica controleMovEvolu = new ControleMovEvolucaoMedica(); // Controle Movimentação Histórico Evolução
    //
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
    String nomeModuloTela = "Movimentação:Admissão Médica de Internos Adicionais:Manutenção";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao = 0;
    int flag = 0;
    String codDoenca; //CÓDIGO DA DOENCA PARA UTILIZAR NA ALTERAÇÃO,
    // VERIFICAR ANTES SE IRÁ USAR ESSAS VARIAVEIS QUE IMPEDE A EXCLUSÃO DA ADMISSÃO
    String codAdm, codPsiquiatrico, codMedico, codPrescricao, codAtestado, codDieta;
    String codInterno; // VARIÁVEL QUE IMPEDI MUDAR O REGISTRO DE ADMISSÃO, CASO JÁ EXISTA ANAMNESES, PRESCRIÇÃO, ATEDTADO OU DIETA.
    String deptoTecnico = "ENFERMARIA";
    String atendido = "Sim";
    int tipoDiagnosticoMed;
    String admEvolucao = "Sim";
    int pQUANTIDADE_ATENDIDA = 1;
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    //
    String pCODIGO_INTERNO = "";
    String tipoAtendimentoAdm = "Admissão Médica/Psiquiatrica";
    String nomeInternoAnterior = "";
    String dataInicial, dataFinal, dataEntrada, dataEvolPsiquiatrica, dataEvolu, dataPrescricao, dataAtestado;
    String caminho;
    int count = 0;
    int idItem = 0;
    String pHabilitaMedico = "";
    int codigoDepartamento = 0;
    String situacao = "ENTRADA NA UNIDADE";
    String sitRetorno = "RETORNO A UNIDADE";
    String pATENDIDO_PESQUISA = "Não";
    int idItemEvolPsiquiatrico, idItemEvol, idItemPrescricao, idItemAtestado, idItemDieta;
    int countm = 0;
    int countp = 0;
    //PORTA DE ENTRADA COM ORIGEM NO CRC/TRIAGEM
    String pHABILITA_MEDICO = "Sim";
    String pDEPARTAMENTO = "";
    String pINTERNOCRC = "";
    String pHABILITADO = "";
    String pCONFIRMA_ADMISSAO = "Sim";

    /**
     * Creates new form TelaAdmissaoMedicaSecundaria
     */
    public static TelaAdmissaoMedica pADM_MEDICA;
    public static TelaBuscarDoencasAdicional pADM_DOENCA;
    public static TelaAuditoriaAdmissaoMedicaAD pAUDITORIA;

    public TelaAdmissaoMedicaSecundaria(TelaAdmissaoMedica parent, boolean modal) {
        this.pADM_MEDICA = parent;
        this.setModal(modal);
        setLocationRelativeTo(pADM_MEDICA);
        initComponents();
        jTabbedPane1.setSelectedIndex(1);
        formatarCampos();
        corCampos();
        tabelaPatologias();
    }

    public void mostrarDoencasAdicional() {
        pADM_DOENCA = new TelaBuscarDoencasAdicional(this, true);
        pADM_DOENCA.setVisible(true);
    }

    public void mostrarAuditoria() {
        pAUDITORIA = new TelaAuditoriaAdmissaoMedicaAD(this, true);
        pAUDITORIA.setVisible(true);
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
        jLabel36 = new javax.swing.JLabel();
        jPesqNomeInternoAdmissaoAD = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jIDPesqAtendAD = new javax.swing.JTextField();
        jBtIdPesqAtend = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jDataInicialAD = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jDataFinalAD = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaMedicoAD = new javax.swing.JTable();
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
        jLabel4 = new javax.swing.JLabel();
        jIdAdmPrincipal = new javax.swing.JTextField();
        jIdAdmAdicional = new javax.swing.JTextField();
        jStatusLancAD = new javax.swing.JTextField();
        jDataAdmAD = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jIdInternoAdmAD = new javax.swing.JTextField();
        jMatriculaPenal = new javax.swing.JTextField();
        jSexoAD = new javax.swing.JTextField();
        jNomeInternoAdmAD = new javax.swing.JTextField();
        jNomeMaeInternoAD = new javax.swing.JTextField();
        jDataNascAdmAD = new com.toedter.calendar.JDateChooser();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Exames = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jABD = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jAR = new javax.swing.JTextField();
        jAGU = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jEXT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jACV = new javax.swing.JTextField();
        jCABPESC = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxAR = new javax.swing.JComboBox();
        jComboBoxAGU = new javax.swing.JComboBox();
        jComboBoxEXT = new javax.swing.JComboBox();
        jComboBoxACV = new javax.swing.JComboBox();
        jComboBoxCAB = new javax.swing.JComboBox();
        jComboBoxABD = new javax.swing.JComboBox();
        Patologias = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jIdItem = new javax.swing.JTextField();
        jDescricaoPatologia = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jCid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaPatologiaADD = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jBtBuscar = new javax.swing.JButton();
        jBtAdicionarPatologia = new javax.swing.JButton();
        jBtExcluirPatologia = new javax.swing.JButton();
        Cirurgias = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxIgnoradoAtualizado = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jCirurgiasPrevisas = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTratamentoCurso = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxVacinas = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        jComboBoxAlergias = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        jQuaisAlergias = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jComboBoxUsaMedicamento = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        jQualMedicacaoUsa = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxOutrasAlergias = new javax.swing.JComboBox();
        jQuaisOutrasAlergias = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        OutrasInformacoes = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jComboBoxDrogas = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jQualDrogas = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxEtilismo = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jQualEtilismo = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxTabagismo = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jQuantoTempoTabagismo = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jComboBoxDrogasInjetavel = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jQualTipoDrograInjet = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxSexualidade = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jComboBoxNumeroParceiro = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jComboBoxUsaPreserva = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jComboBoxTipoSanguineo = new javax.swing.JComboBox();
        jComboBoxFatorRH = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jDiagnosticoInicial = new javax.swing.JTextArea();
        jLabel78 = new javax.swing.JLabel();
        jComboBoxTipoDiagnostico = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jFotoInternoAdmAD = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Admissão Médica Secundária :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Nome :");

        jPesqNomeInternoAdmissaoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Código:");

        jIDPesqAtendAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqAtendAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIdPesqAtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdPesqAtend.setContentAreaFilled(false);
        jBtIdPesqAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdPesqAtendActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data Inicial:");

        jDataInicialAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Data Final:");

        jDataFinalAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
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
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesqAtendAD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jPesqNomeInternoAdmissaoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jDataInicialAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataFinalAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdPesqAtend)
                    .addComponent(jIDPesqAtendAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel48)
                    .addComponent(jDataInicialAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jDataFinalAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInternoAdmissaoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaMedicoAD.setAutoCreateRowSorter(true);
        jTabelaMedicoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaMedicoAD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome Completo do Interno", "Situação"
            }
        ));
        jTabelaMedicoAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMedicoADMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaMedicoAD);
        if (jTabelaMedicoAD.getColumnModel().getColumnCount() > 0) {
            jTabelaMedicoAD.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaMedicoAD.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaMedicoAD.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaMedicoAD.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaMedicoAD.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaMedicoAD.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaMedicoAD.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaMedicoAD.getColumnModel().getColumn(3).setMaxWidth(300);
            jTabelaMedicoAD.getColumnModel().getColumn(4).setMinWidth(200);
            jTabelaMedicoAD.getColumnModel().getColumn(4).setMaxWidth(200);
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
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Adm.Principal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Adm.Adicional");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Admissão");

        jIdAdmPrincipal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAdmPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAdmPrincipal.setEnabled(false);

        jIdAdmAdicional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAdmAdicional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAdmAdicional.setEnabled(false);

        jStatusLancAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLancAD.setForeground(new java.awt.Color(204, 0, 0));
        jStatusLancAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLancAD.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusLancAD.setEnabled(false);

        jDataAdmAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAdmAD.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jIdAdmPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jIdAdmAdicional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 250, Short.MAX_VALUE))
                    .addComponent(jStatusLancAD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDataAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusLancAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdAdmAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdAdmPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Matricula Penal");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Sexo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("D. Nascimento");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome do Interno");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome da Mãe");

        jIdInternoAdmAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAdmAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAdmAD.setEnabled(false);

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jSexoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSexoAD.setEnabled(false);

        jNomeInternoAdmAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAdmAD.setEnabled(false);

        jNomeMaeInternoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInternoAD.setEnabled(false);

        jDataNascAdmAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascAdmAD.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jIdInternoAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSexoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jDataNascAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jNomeInternoAdmAD)
                        .addComponent(jNomeMaeInternoAD, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIdInternoAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSexoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDataNascAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoAdmAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeMaeInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTabbedPane2.setForeground(new java.awt.Color(0, 102, 0));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("ABD:");

        jABD.setToolTipText("Exame Abdominal");
        jABD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jABD.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("AR:");

        jAR.setToolTipText("Avaliação Respiratória");
        jAR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAR.setEnabled(false);

        jAGU.setToolTipText("Aparelho Genito Urinário");
        jAGU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAGU.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("AGU:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("EXT:");

        jEXT.setToolTipText("Avaliação das Extremidades");
        jEXT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEXT.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("ACV:");

        jACV.setToolTipText("Avaliação Cardio Vascular");
        jACV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jACV.setEnabled(false);

        jCABPESC.setToolTipText("Exame de Cabeça e Pescoço");
        jCABPESC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCABPESC.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("CAB/PESC:");

        jComboBoxAR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxAR.setToolTipText("Não, Sim, NDN");
        jComboBoxAR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAR.setEnabled(false);

        jComboBoxAGU.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAGU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxAGU.setToolTipText("Não, Sim, NDN");
        jComboBoxAGU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAGU.setEnabled(false);

        jComboBoxEXT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEXT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxEXT.setToolTipText("Não, Sim, NDN");
        jComboBoxEXT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEXT.setEnabled(false);

        jComboBoxACV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxACV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxACV.setToolTipText("Não, Sim, NDN");
        jComboBoxACV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxACV.setEnabled(false);

        jComboBoxCAB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCAB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxCAB.setToolTipText("Não, Sim, NDN");
        jComboBoxCAB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCAB.setEnabled(false);

        jComboBoxABD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxABD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxABD.setToolTipText("Não, Sim, NDN");
        jComboBoxABD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxABD.setEnabled(false);

        javax.swing.GroupLayout ExamesLayout = new javax.swing.GroupLayout(Exames);
        Exames.setLayout(ExamesLayout);
        ExamesLayout.setHorizontalGroup(
            ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxACV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxABD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jCABPESC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jACV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEXT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAGU, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(jABD))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        ExamesLayout.setVerticalGroup(
            ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAR, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jAGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAGU, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jACV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxACV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jCABPESC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCAB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jABD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxABD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Exames Fisícos", Exames);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Código");

        jIdItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdItem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdItem.setEnabled(false);

        jDescricaoPatologia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoPatologia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDescricaoPatologia.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Descrição da Patologia");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("CID");

        jCid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCid.setEnabled(false);

        jTabelaPatologiaADD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPatologiaADD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição da Patologia", "CID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPatologiaADD.setEnabled(false);
        jTabelaPatologiaADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPatologiaADDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaPatologiaADD);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscar.setText("Buscar");
        jBtBuscar.setEnabled(false);
        jBtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarActionPerformed(evt);
            }
        });

        jBtAdicionarPatologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtAdicionarPatologia.setText("Incluir");
        jBtAdicionarPatologia.setEnabled(false);
        jBtAdicionarPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarPatologiaActionPerformed(evt);
            }
        });

        jBtExcluirPatologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPatologia.setText("Excluir");
        jBtExcluirPatologia.setEnabled(false);
        jBtExcluirPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPatologiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtExcluirPatologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAdicionarPatologia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jBtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAdicionarPatologia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPatologia)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatologiasLayout = new javax.swing.GroupLayout(Patologias);
        Patologias.setLayout(PatologiasLayout);
        PatologiasLayout.setHorizontalGroup(
            PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatologiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatologiasLayout.createSequentialGroup()
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatologiasLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel38))
                            .addGroup(PatologiasLayout.createSequentialGroup()
                                .addComponent(jIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDescricaoPatologia)))
                        .addGap(10, 10, 10)
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jCid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PatologiasLayout.setVerticalGroup(
            PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatologiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatologiasLayout.createSequentialGroup()
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel35)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDescricaoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Patologias", Patologias);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jComboBoxIgnoradoAtualizado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIgnoradoAtualizado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Atualizada", "Ignorada" }));
        jComboBoxIgnoradoAtualizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIgnoradoAtualizado.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Cirúrgias prévias? Qual?");

        jCirurgiasPrevisas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCirurgiasPrevisas.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Trat. em Curso? Qual?");

        jTratamentoCurso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTratamentoCurso.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Vacinas");

        jComboBoxVacinas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVacinas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", " " }));
        jComboBoxVacinas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVacinas.setEnabled(false);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Alergias?");

        jComboBoxAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlergias.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Quais?");

        jQuaisAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisAlergias.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Usa Medi.");

        jComboBoxUsaMedicamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsaMedicamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", " " }));
        jComboBoxUsaMedicamento.setToolTipText("Usa Medicação");
        jComboBoxUsaMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsaMedicamento.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Qual?");

        jQualMedicacaoUsa.setToolTipText("Qual Medicação");
        jQualMedicacaoUsa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualMedicacaoUsa.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("O. Alergias");

        jComboBoxOutrasAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOutrasAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxOutrasAlergias.setToolTipText("Outras Alergias");
        jComboBoxOutrasAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOutrasAlergias.setEnabled(false);

        jQuaisOutrasAlergias.setToolTipText("Quais Outras Alergias");
        jQuaisOutrasAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisOutrasAlergias.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Quais Outras Alergias?");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Status Vacina");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCirurgiasPrevisas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTratamentoCurso)
                                .addContainerGap())))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52)
                            .addComponent(jComboBoxOutrasAlergias, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxUsaMedicamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel53))
                                .addGap(74, 74, 74))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jQuaisOutrasAlergias, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQualMedicacaoUsa))
                                .addGap(7, 7, 7)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jComboBoxIgnoradoAtualizado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jQuaisAlergias))
                                .addContainerGap())))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCirurgiasPrevisas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTratamentoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jQuaisAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQualMedicacaoUsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxUsaMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel66))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxOutrasAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQuaisOutrasAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxIgnoradoAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout CirurgiasLayout = new javax.swing.GroupLayout(Cirurgias);
        Cirurgias.setLayout(CirurgiasLayout);
        CirurgiasLayout.setHorizontalGroup(
            CirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CirurgiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CirurgiasLayout.setVerticalGroup(
            CirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CirurgiasLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Inf. Diversas", Cirurgias);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Drogas:");

        jComboBoxDrogas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDrogas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDrogas.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Qual?:");

        jQualDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDrogas.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Etilismo:");

        jComboBoxEtilismo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEtilismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEtilismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEtilismo.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Qual e Quanto?:");

        jQualEtilismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualEtilismo.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Tabagismo:");

        jComboBoxTabagismo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTabagismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTabagismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTabagismo.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Qto e por qto tempo?:");

        jQuantoTempoTabagismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantoTempoTabagismo.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Droga Injetável:");

        jComboBoxDrogasInjetavel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDrogasInjetavel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDrogasInjetavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDrogasInjetavel.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Qual Tipo?:");

        jQualTipoDrograInjet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualTipoDrograInjet.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Sexualidade:");

        jComboBoxSexualidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSexualidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Heterosssexual", "Bissexual", "Homossexual" }));
        jComboBoxSexualidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexualidade.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Número de Parceiros por Ano:");

        jComboBoxNumeroParceiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNumeroParceiro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "Um", "Dois", "Três", "Mais" }));
        jComboBoxNumeroParceiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNumeroParceiro.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Usa Preservativos:");

        jComboBoxUsaPreserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsaPreserva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nunca", "Sempre", "Algumas vezes" }));
        jComboBoxUsaPreserva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsaPreserva.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Tipo Sanguíneo:");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Fator RH:");

        jComboBoxTipoSanguineo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "O", "A", "B", "AB" }));
        jComboBoxTipoSanguineo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoSanguineo.setEnabled(false);

        jComboBoxFatorRH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFatorRH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Negativo", "Positivo" }));
        jComboBoxFatorRH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFatorRH.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel43)
                    .addComponent(jLabel56)
                    .addComponent(jLabel41)
                    .addComponent(jLabel45)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jComboBoxDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualDrogas))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jComboBoxEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jComboBoxTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jQuantoTempoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxUsaPreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxSexualidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel59)
                                        .addGroup(jPanel19Layout.createSequentialGroup()
                                            .addComponent(jLabel61)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel62)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxNumeroParceiro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxFatorRH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jComboBoxDrogasInjetavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualTipoDrograInjet, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jQualDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jComboBoxDrogasInjetavel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jQualTipoDrograInjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jQualEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jQuantoTempoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxSexualidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBoxNumeroParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jComboBoxUsaPreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFatorRH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OutrasInformacoesLayout = new javax.swing.GroupLayout(OutrasInformacoes);
        OutrasInformacoes.setLayout(OutrasInformacoesLayout);
        OutrasInformacoesLayout.setHorizontalGroup(
            OutrasInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutrasInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OutrasInformacoesLayout.setVerticalGroup(
            OutrasInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Outras Informações", OutrasInformacoes);

        jDiagnosticoInicial.setColumns(20);
        jDiagnosticoInicial.setRows(5);
        jDiagnosticoInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDiagnosticoInicial.setEnabled(false);
        jScrollPane17.setViewportView(jDiagnosticoInicial);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(204, 0, 0));
        jLabel78.setText("Tipo de Diagnóstico:");

        jComboBoxTipoDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoDiagnostico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Diagnóstico Clínico", "Diagnóstico Psiquiatrico" }));
        jComboBoxTipoDiagnostico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoDiagnostico.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoDiagnostico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel78)
                    .addComponent(jComboBoxTipoDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane2.addTab("Diagnóstico Inicial", jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoInternoAdmAD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAdmAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAdmAD, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

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

        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
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

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addGap(2, 2, 2)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel4, jPanel6});

        jTabbedPane1.addTab("Admissão", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaPatologiaADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPatologiaADDMouseClicked
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            jBtBuscar.setEnabled(true);
            jBtExcluirPatologia.setEnabled(true);
            if (flag == 1) {
                String codItem = "" + jTabelaPatologiaADD.getValueAt(jTabelaPatologiaADD.getSelectedRow(), 0);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENS_ADMISSAO_DOENCAS_ADICIONAL "
                            + "INNER JOIN DOENCAS "
                            + "ON ITENS_ADMISSAO_DOENCAS_ADICIONAL.IdDoenca=DOENCAS.IdDoenca "
                            + "WHERE IdAdmADI='" + jIdAdmAdicional.getText() + "' "
                            + "AND ITENS_ADMISSAO_DOENCAS_ADICIONAL.IdDoenca='" + codItem + "'");
                    conecta.rs.first();
                    jIdItem.setText(conecta.rs.getString("IdDoenca")); //Coluna 0
                    jDescricaoPatologia.setText(conecta.rs.getString("Descricao"));
                    jCid.setText(conecta.rs.getString("Cid"));
                    conecta.desconecta();
                } catch (SQLException ex) {
                }
            }
        }
    }//GEN-LAST:event_jTabelaPatologiaADDMouseClicked

    private void jBtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarActionPerformed
        // TODO add your handling code here:
        mostrarDoencasAdicional();
    }//GEN-LAST:event_jBtBuscarActionPerformed

    private void jBtAdicionarPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarPatologiaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmDoencas = (DefaultTableModel) jTabelaPatologiaADD.getModel();
        // dtmDoencas.addRow(new Object [] {jIdPato.getText(),jDescricaoPato.getText()});
        objItensDoenca.setIdDoenca(Integer.valueOf(jIdItem.getText()));
        objItensDoenca.setDescricaoDoenca(jDescricaoPatologia.getText());
        Object campos[] = {objItensDoenca.getIdDoenca(), objItensDoenca.getDescricaoDoenca(), jCid.getText()};
        dtmDoencas.addRow(campos);
        jIdItem.setText("");
        jDescricaoPatologia.setText("");
        jCid.setText("");
    }//GEN-LAST:event_jBtAdicionarPatologiaActionPerformed

    private void jBtExcluirPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPatologiaActionPerformed
        // TODO add your handling code here:
        if (jTabelaPatologiaADD.getSelectedRow() != -1) {
            DefaultTableModel dtm = (DefaultTableModel) jTabelaPatologiaADD.getModel();
            dtm.removeRow(jTabelaPatologiaADD.getSelectedRow());
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                objItensDoenca.setIdItem(Integer.valueOf(jIdItem.getText()));
                controlePat.excluirDoencas(objItensDoenca);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
        }
    }//GEN-LAST:event_jBtExcluirPatologiaActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            verificarPortaEntrada();
            verificarRegistroBiometria();
            if (jIdInternoAdm.getText().equals(pINTERNOCRC) && deptoTecnico.equals(pDEPARTAMENTO) && pHABILITADO.equals("Sim")) {
                if (pHabilitaMedico.equals("Não")) {
                    Novo();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    limpaTabelaDoencas();
                    acao = 1;
                    pesquisarInternoManual();
                } else {
                    //PESQUISAR CÓDIGO DO DEPARTAMENTO PARA CONTABILIZAR O ATENDIMENTO NA TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP
                    procurarDepartamento();
                    //PESQUISAR O INTERNO NO QUAL FEZ A ASSINATURA BIOMETRICA OU FOI LIBERADO PELO COLABORADOR
                    pesquisarInternoColaboradorBiometria();
                    if (jIdInternoAdmAD.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível realizar o atendimento, esse interno não assinou pela biometria ou não foi liberado para ser atendido.");
                    } else {
                        limpaTabelaDoencas();
                        Novo();
                        acao = 1;
                        statusMov = "Incluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já existe uma admissão para esse interno, por isso não é possível fazer uma nova admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            objAdmMedico.setStatusLanc(jStatusLancAD.getText());
            if (jStatusLancAD.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a modificar prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            atendido = "Não";
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAdmMedico.setStatusLanc(jStatusLancAD.getText());
            if (jStatusLancAD.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser excluido, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdAdm.getText().equals(codPsiquiatrico)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Anamnese Psiquiatrica para o interno.");
                } else if (jIdAdm.getText().equals(codMedico)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Anamnese Médica para o interno.");
                } else if (jIdAdm.getText().equals(codPrescricao)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Prescrição Médica para o interno.");
                } else if (jIdAdm.getText().equals(codAtestado)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe um Atestado Médico para o interno.");
                } else if (jIdAdm.getText().equals(codDieta)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Dieta Médica para o interno.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o ATENDIMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objItensDoenca.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
                        controlePat.excluirDoencas(objItensDoenca);
                        //
                        objAdmMedico.setIdLanc(Integer.parseInt(jIdAdmAdicional.getText()));
                        control.excluirAdmissaoMedica(objAdmMedico);
                        //
                        objAdmMedico.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
                        controle.excluirMovTec(objAdmMedico);
                        // MODIFICAR A SITUAÇÃO DO ATENDIMENTO DEIXANDO COMO "Não" FOI ATENDIDO.
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoAdmAD.getText());
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataAdmAD.getDate());
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                        //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO.
                        pCONFIRMA_ADMISSAO = "Não";
                        objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                        objPortaEntrada.setNomeInternoCrc(jNomeInternoAdmAD.getText());
                        objPortaEntrada.setHabMed(pHABILITA_MEDICO);
                        control_PE.alterarPortaEntradaMedica(objPortaEntrada);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        Excluir();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaPatologiaADD.getModel().getRowCount();
            verificarDoencas();
            if (jDataAdmAD.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data para admissão.");
                jDataAdmAD.requestFocus();
                jDataAdmAD.setBackground(Color.red);
            } else if (jNomeInternoAdmAD.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o interno para o atendimento.");
            } else if (rows == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe pelo menos um tipo de patologia.");
            } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de diagnóstico.");
            } else {
                objAdmMedico.setStatusLanc(jStatusLancAD.getText());
                objAdmMedico.setDataLanc(jDataAdmAD.getDate());
                objAdmMedico.setAr(jAR.getText());
                objAdmMedico.setAcv(jACV.getText());
                objAdmMedico.setAgu(jAGU.getText());
                objAdmMedico.setCabPesc(jCABPESC.getText());
                objAdmMedico.setExt(jEXT.getText());
                objAdmMedico.setAbd(jABD.getText());
                objAdmMedico.setDiagnostico(jTextoEvolucaoPsiquiatrica.getText());
                objAdmMedico.setCirurgiasPrevisas(jCirurgiasPrevisas.getText());
                objAdmMedico.setTratamentoCurso(jTratamentoCurso.getText());
                objAdmMedico.setDrogas((String) jComboBoxDrogas.getSelectedItem());
                objAdmMedico.setQualDrogas(jQualDrogas.getText());
                objAdmMedico.setEtilismo((String) jComboBoxEtilismo.getSelectedItem());
                objAdmMedico.setQualEtilismo(jQualEtilismo.getText());
                objAdmMedico.setTabagismo((String) jComboBoxTabagismo.getSelectedItem());
                objAdmMedico.setQuantoTempoTabagismo(jQuantoTempoTabagismo.getText());
                objAdmMedico.setVacinas((String) jComboBoxVacinas.getSelectedItem());
                objAdmMedico.setAtualizadaIgnorada((String) jComboBoxIgnoradoAtualizado.getSelectedItem());
                // INCLUSÃO DE NOVOS CAMPOS NA ADMISSÃO EM 15/06/2016
                objAdmMedico.setComboBoxAR((String) jComboBoxAR.getSelectedItem());
                objAdmMedico.setComboBoxACV((String) jComboBoxACV.getSelectedItem());
                objAdmMedico.setComboBoxAGU((String) jComboBoxAGU.getSelectedItem());
                objAdmMedico.setComboBoxCAB((String) jComboBoxCAB.getSelectedItem());
                objAdmMedico.setComboBoxEXT((String) jComboBoxEXT.getSelectedItem());
                objAdmMedico.setComboBoxABD((String) jComboBoxABD.getSelectedItem());
                objAdmMedico.setAlergia((String) jComboBoxAlergias.getSelectedItem());
                objAdmMedico.setQuaisAlergias(jQuaisAlergias.getText());
                objAdmMedico.setDrogasInjetavel((String) jComboBoxDrogasInjetavel.getSelectedItem());
                objAdmMedico.setQualTipoDrograInjet(jQualTipoDrograInjet.getText());
                objAdmMedico.setSexualidade((String) jComboBoxSexualidade.getSelectedItem());
                objAdmMedico.setNumeroParceiros((String) jComboBoxNumeroParceiro.getSelectedItem());
                objAdmMedico.setUsoPreservativos((String) jComboBoxUsaPreserva.getSelectedItem());
                objAdmMedico.setTipoSanguineo((String) jComboBoxTipoSanguineo.getSelectedItem());
                objAdmMedico.setFatorRH((String) jComboBoxFatorRH.getSelectedItem());
                objAdmMedico.setUsaMedicamentos((String) jComboBoxUsaMedicamento.getSelectedItem());
                objAdmMedico.setQualMedicacaoUsa(jQualMedicacaoUsa.getText());
                objAdmMedico.setOutrasAlergias((String) jComboBoxOutrasAlergias.getSelectedItem());
                objAdmMedico.setQuaisOutrasAlergias(jQuaisOutrasAlergias.getText());
                objAdmMedico.setDiagnostico(jDiagnosticoInicial.getText());
                objAdmMedico.setAdmEvo(admEvolucao);
                if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Clínico")) {
                    tipoDiagnosticoMed = 0;
                } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Psiquiatrico")) {
                    tipoDiagnosticoMed = 1;
                }
                objAdmMedico.setTipoDiagnostico(tipoDiagnosticoMed);
                if (acao == 1) {
                    // log de usuario
                    objAdmMedico.setUsuarioInsert(nameUser);
                    objAdmMedico.setDataInsert(dataModFinal);
                    objAdmMedico.setHoraInsert(horaMov);
                    objAdmMedico.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdmAD.getText());
                    objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    control.incluirAdmissaoMedica(objAdmMedico);
                    buscarID();
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdmAD.getText());
                    objAdmMedico.setDeptoMedico(deptoTecnico);
                    controle.incluirMovTec(objAdmMedico);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdmAD.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENF);
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataAdmAD.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdAdmAdicional.getText()));
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                    pHABILITA_MEDICO = "Não";
                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                    objPortaEntrada.setNomeInternoCrc(jNomeInternoAdmAD.getText());
                    objPortaEntrada.setHabMed(pHABILITA_MEDICO);
                    control_PE.alterarPortaEntradaMedica(objPortaEntrada);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    incluirItensDoencas();
                    if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Clínico")) {
                        objEvolMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolMedica.setDataEvolu(jDataAdmAD.getDate());
                        objEvolMedica.setTextoEvolucao(jDiagnosticoInicial.getText());
                        objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objEvolMedica.setNomeInternoEvoluMedica(jNomeInternoAdmAD.getText());
                        // log de usuario
                        objEvolMedica.setUsuarioInsert(nameUser);
                        objEvolMedica.setDataInsert(dataModFinal);
                        objEvolMedica.setHoraInsert(horaMov);
                        objEvolMedica.setAdmEvo(admEvolucao);
                        controleEvoluMed.incluirEvolucaoMedica(objEvolMedica);
                        //
                        buscarEvolucao();
                        preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Psiquiatrico")) {
                        objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objEvolPsiquiatrica.setDataDiag(jDataAdmAD.getDate());
                        objEvolPsiquiatrica.setEvolucaoPsiquiatrica(jDiagnosticoInicial.getText());
                        //
                        objEvolPsiquiatrica.setUsuarioInsert(nameUser);
                        objEvolPsiquiatrica.setDataInsert(dataModFinal);
                        objEvolPsiquiatrica.setHorarioInsert(horaMov);
                        objEvolMedica.setAdmEvo(admEvolucao);
                        controlEvolPsiquiatrica.incluirEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                        //
                        buscarCodEvolPsiquiatrica();
                        preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    }
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdmAD.getText());
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdAdm.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    // log de usuario
                    objAdmMedico.setUsuarioUp(nameUser);
                    objAdmMedico.setDataUp(dataModFinal);
                    objAdmMedico.setHoraUp(horaMov);
                    //
                    objAdmMedico.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdmAD.getText());
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
                    control.alterarAdmissaoMedica(objAdmMedico);
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdmAD.getText());
                    objAdmMedico.setDeptoMedico(deptoTecnico);
                    controle.alterarMovTec(objAdmMedico);
                    //
                    objItensDoenca.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
                    controlePat.excluirDoencas(objItensDoenca);
                    incluirItensDoencas();
                    // SE O INTERNO FOR MODIFICADO
                    if (!jIdInternoAdmAD.getText().equals(codInterno)) {
                        atendido = "Não";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(codInterno));
                        objRegAtend.setNomeInternoCrc(nomeInternoAnterior);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataAdmAD.getDate());
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                    }
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdmAD.getText());
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataAdmAD.getDate());
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Clínico")) {
                        objEvolMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolMedica.setDataEvolu(jDataAdmAD.getDate());
                        objEvolMedica.setTextoEvolucao(jDiagnosticoInicial.getText());
                        objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                        objEvolMedica.setNomeInternoEvoluMedica(jNomeInternoAdmAD.getText());
                        // log de usuario
                        objEvolMedica.setUsuarioInsert(nameUser);
                        objEvolMedica.setDataInsert(dataModFinal);
                        objEvolMedica.setHoraInsert(horaMov);
                        objEvolMedica.setIdItem(idItemEvol);
                        controleEvoluMed.alterarEvolucaoMedica(objEvolMedica);
                        //
                        preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Psiquiatrico")) {
                        objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdmAD.getText()));
                        objEvolPsiquiatrica.setDataDiag(jDataAdmAD.getDate());
                        objEvolPsiquiatrica.setEvolucaoPsiquiatrica(jDiagnosticoInicial.getText());
                        //
                        objEvolPsiquiatrica.setUsuarioInsert(nameUser);
                        objEvolPsiquiatrica.setDataInsert(dataModFinal);
                        objEvolPsiquiatrica.setHorarioInsert(horaMov);
                        objEvolPsiquiatrica.setIdItem(idItemEvolPsiquiatrico);
                        controlEvolPsiquiatrica.alterarEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                        //
                        preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    }
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                    acao = 0;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        acao = 0;
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL WHERE IdAdmADI='" + jIdAdmAdicional.getText() + "'");
            conecta.rs.first();
            jStatusLancAD.setText(conecta.rs.getString("StatusLanc"));
            if (jStatusLancAD.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado.\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        mostrarAuditoria();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        jTabelaMedicoAD.setVisible(true);
        preencherAdmissaoMedica("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ADMISSAO_MEDICA_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoAdmissaoAD.getText() + "%'");
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtIdPesqAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdPesqAtendActionPerformed
        // TODO add your handling code here:
        flag = 1;
        jTabelaMedicoAD.setVisible(true);
        preencherAdmissaoMedica("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ADMISSAO_MEDICA_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE IdAdmADI='" + jIDPesqAtendAD.getText() + "'");
    }//GEN-LAST:event_jBtIdPesqAtendActionPerformed

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataInicialAD.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicialAD.requestFocus();
            } else {
                if (jDataFinalAD.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinalAD.requestFocus();
                } else {
                    if (jDataInicialAD.getDate().after(jDataFinalAD.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataInicialAD.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinalAD.getDate().getTime());
                        jTabelaMedicoAD.setVisible(true);
                        preencherAdmissaoMedica("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_MEDICA_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataInicialAD.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicialAD.requestFocus();
            } else {
                if (jDataFinalAD.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinalAD.requestFocus();
                } else {
                    if (jDataInicialAD.getDate().after(jDataFinalAD.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataInicialAD.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinalAD.getDate().getTime());
                        jTabelaMedicoAD.setVisible(true);
                        preencherAdmissaoMedica("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_MEDICA_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAdmissaoMedica("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_MEDICA_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.IdinternoCrc='" + jIdInternoAdm.getText() + "'");
        } else {
            count = 0;
            jtotalRegistros.setText("");
            limparTabelaAdmissao();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaMedicoADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMedicoADMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaMedicoAD.getValueAt(jTabelaMedicoAD.getSelectedRow(), 0);
            jIDPesqAtendAD.setText(IdLanc);
            //
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            limparCampos();
            limpaTabelaDoencas();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAO_MEDICA_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ADMISSAO_MEDICA_ADICIONAL.IdAdmADI='" + jIDPesqAtendAD.getText() + "'");
                conecta.rs.first();
                jIdAdmPrincipal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jIdAdmAdicional.setText(String.valueOf(conecta.rs.getInt("IdAdmADI")));
                jStatusLancAD.setText(conecta.rs.getString("StatusLanc"));
                jDataAdmAD.setDate(conecta.rs.getDate("DataLanc"));
                // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
                codInterno = conecta.rs.getString("IdInternoCrc");
                nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
                jIdInternoAdmAD.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoAdmAD.setText(conecta.rs.getString("NomeInternoCrc"));
                jDataNascAdmAD.setDate(conecta.rs.getDate("DataNasciCrc"));
                jSexoAD.setText(conecta.rs.getString("SexoCrc"));
                jNomeMaeInternoAD.setText(conecta.rs.getString("MaeInternoCrc"));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoAdmAD.setIcon(i);
                    jFotoInternoAdmAD.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoAdmAD.getWidth(), jFotoInternoAdmAD.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoAdmAD.getWidth(), jFotoInternoAdmAD.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoAdmAD.setIcon(icon);
                }
                jAR.setText(conecta.rs.getString("AR"));
                jACV.setText(conecta.rs.getString("ACV"));
                jAGU.setText(conecta.rs.getString("AGU"));
                jCABPESC.setText(conecta.rs.getString("CABPESC"));
                jEXT.setText(conecta.rs.getString("EXT"));
                jABD.setText(conecta.rs.getString("ABD"));
                //jDiagnostico.setText("Diagnostico");
                jCirurgiasPrevisas.setText(conecta.rs.getString("CirurgiasPrevisas"));
                jTratamentoCurso.setText(conecta.rs.getString("TratamentoCurso"));
                jQualDrogas.setText(conecta.rs.getString("QualDrogas"));
                jQualEtilismo.setText(conecta.rs.getString("QualEtilismo"));
                jQuantoTempoTabagismo.setText(conecta.rs.getString("QuantoTempoTabagismo"));
                jComboBoxDrogas.setSelectedItem(conecta.rs.getString("Drogas"));
                jComboBoxEtilismo.setSelectedItem(conecta.rs.getString("Etilismo"));
                jComboBoxTabagismo.setSelectedItem(conecta.rs.getString("Tabagismo"));
                jComboBoxVacinas.setSelectedItem(conecta.rs.getString("Vacinas"));
                jComboBoxIgnoradoAtualizado.setSelectedItem(conecta.rs.getString("AtualizaIgnora"));
                // ATUALIZAÇÃO DE CAMPOS EM 15/06/2016
                jComboBoxAR.setSelectedItem(conecta.rs.getString("CombBoxAR"));
                jComboBoxACV.setSelectedItem(conecta.rs.getString("CombBoxACV"));
                jComboBoxAGU.setSelectedItem(conecta.rs.getString("CombBoxAGU"));
                jComboBoxCAB.setSelectedItem(conecta.rs.getString("CombBoxCABPESC"));
                jComboBoxEXT.setSelectedItem(conecta.rs.getString("CombBoxEXT"));
                jComboBoxABD.setSelectedItem(conecta.rs.getString("CombBoxABD"));
                jComboBoxAlergias.setSelectedItem(conecta.rs.getString("Alergia"));
                jQuaisAlergias.setText(conecta.rs.getString("QuaisAlergias"));
                jComboBoxDrogasInjetavel.setSelectedItem(conecta.rs.getString("DrogaInjetavel"));
                jQualTipoDrograInjet.setText(conecta.rs.getString("QualTipoDrogaInjet"));
                jComboBoxSexualidade.setSelectedItem(conecta.rs.getString("Sexualidade"));
                jComboBoxNumeroParceiro.setSelectedItem(conecta.rs.getString("NumeroPareceiro"));
                jComboBoxUsaPreserva.setSelectedItem(conecta.rs.getString("UsaPreserva"));
                jComboBoxTipoSanguineo.setSelectedItem(conecta.rs.getString("TipoSangue"));
                jComboBoxFatorRH.setSelectedItem(conecta.rs.getString("FatorRh"));
                jComboBoxUsaMedicamento.setSelectedItem(conecta.rs.getString("UsaMedicamento"));
                jQualMedicacaoUsa.setText(conecta.rs.getString("QualMedicamento"));
                jComboBoxOutrasAlergias.setSelectedItem(conecta.rs.getString("OutrasAlergias"));
                jQuaisOutrasAlergias.setText(conecta.rs.getString("QuaisOutrasAlergias"));
                jDiagnosticoInicial.setText(conecta.rs.getString("DiagnosticoInicial"));
                tipoDiagnosticoMed = conecta.rs.getInt("TipoDiag");
                if (tipoDiagnosticoMed == 0) {
                    jComboBoxTipoDiagnostico.setSelectedItem("Diagnóstico Clínico");
                } else if (tipoDiagnosticoMed == 1) {
                    jComboBoxTipoDiagnostico.setSelectedItem("Diagnóstico Psiquiatrico");
                }
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_ADMISSAO_DOENCAS_ADICIONAL "
                        + "INNER JOIN DOENCAS "
                        + "ON ITENS_ADMISSAO_DOENCAS_ADICIONAL.IdDoenca=DOENCAS.IdDoenca "
                        + "WHERE ITENS_ADMISSAO_DOENCAS_ADICIONAL.IdAdmADI='" + jIdAdmAdicional.getText() + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItemDAD");
                DefaultTableModel dtmDoencas = (DefaultTableModel) jTabelaPatologiaADD.getModel();
                dtmDoencas.getDataVector().clear(); // limpa a tabela
                do {
                    dtmDoencas.addRow(new Object[]{conecta.rs.getInt("IdDoenca"), conecta.rs.getString("Descricao"), conecta.rs.getString("Cid")});
                } while (conecta.rs.next());

            } catch (SQLException ex) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaMedicoADMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoMedicaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoMedicaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoMedicaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdmissaoMedicaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAdmissaoMedicaSecundaria dialog = new TelaAdmissaoMedicaSecundaria(pADM_MEDICA, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cirurgias;
    private javax.swing.JPanel Exames;
    private javax.swing.JPanel OutrasInformacoes;
    private javax.swing.JPanel Patologias;
    private javax.swing.JTextField jABD;
    private javax.swing.JTextField jACV;
    private javax.swing.JTextField jAGU;
    private javax.swing.JTextField jAR;
    public static javax.swing.JButton jBtAdicionarPatologia;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtBuscar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirPatologia;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdPesqAtend;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JTextField jCABPESC;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCid;
    private javax.swing.JTextField jCirurgiasPrevisas;
    private javax.swing.JComboBox jComboBoxABD;
    private javax.swing.JComboBox jComboBoxACV;
    private javax.swing.JComboBox jComboBoxAGU;
    private javax.swing.JComboBox jComboBoxAR;
    private javax.swing.JComboBox jComboBoxAlergias;
    private javax.swing.JComboBox jComboBoxCAB;
    private javax.swing.JComboBox jComboBoxDrogas;
    private javax.swing.JComboBox jComboBoxDrogasInjetavel;
    private javax.swing.JComboBox jComboBoxEXT;
    private javax.swing.JComboBox jComboBoxEtilismo;
    private javax.swing.JComboBox jComboBoxFatorRH;
    private javax.swing.JComboBox jComboBoxIgnoradoAtualizado;
    private javax.swing.JComboBox jComboBoxNumeroParceiro;
    private javax.swing.JComboBox jComboBoxOutrasAlergias;
    private javax.swing.JComboBox jComboBoxSexualidade;
    private javax.swing.JComboBox jComboBoxTabagismo;
    private javax.swing.JComboBox<String> jComboBoxTipoDiagnostico;
    private javax.swing.JComboBox jComboBoxTipoSanguineo;
    private javax.swing.JComboBox jComboBoxUsaMedicamento;
    private javax.swing.JComboBox jComboBoxUsaPreserva;
    private javax.swing.JComboBox jComboBoxVacinas;
    public static com.toedter.calendar.JDateChooser jDataAdmAD;
    private com.toedter.calendar.JDateChooser jDataFinalAD;
    private com.toedter.calendar.JDateChooser jDataInicialAD;
    public static com.toedter.calendar.JDateChooser jDataNascAdmAD;
    public static javax.swing.JTextField jDescricaoPatologia;
    private javax.swing.JTextArea jDiagnosticoInicial;
    private javax.swing.JTextField jEXT;
    public static javax.swing.JLabel jFotoInternoAdmAD;
    private javax.swing.JTextField jIDPesqAtendAD;
    public static javax.swing.JTextField jIdAdmAdicional;
    public static javax.swing.JTextField jIdAdmPrincipal;
    public static javax.swing.JTextField jIdInternoAdmAD;
    public static javax.swing.JTextField jIdItem;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMatriculaPenal;
    public static javax.swing.JTextField jNomeInternoAdmAD;
    public static javax.swing.JTextField jNomeMaeInternoAD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
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
    private javax.swing.JTextField jPesqNomeInternoAdmissaoAD;
    private javax.swing.JTextField jQuaisAlergias;
    private javax.swing.JTextField jQuaisOutrasAlergias;
    private javax.swing.JTextField jQualDrogas;
    private javax.swing.JTextField jQualEtilismo;
    private javax.swing.JTextField jQualMedicacaoUsa;
    private javax.swing.JTextField jQualTipoDrograInjet;
    private javax.swing.JTextField jQuantoTempoTabagismo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jSexoAD;
    public static javax.swing.JTextField jStatusLancAD;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaMedicoAD;
    private javax.swing.JTable jTabelaPatologiaADD;
    private javax.swing.JTextField jTratamentoCurso;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        // TELA DE ADMISSÃO MÉDICA/PSIQUIATRICA
        jIdAdmPrincipal.setBackground(Color.white);
        jIdAdmAdicional.setBackground(Color.white);
        jStatusLancAD.setBackground(Color.white);
        jDataAdmAD.setBackground(Color.white);
        jIdInternoAdmAD.setBackground(Color.white);
        jNomeInternoAdmAD.setBackground(Color.white);
        jDataNascAdmAD.setBackground(Color.white);
        jSexoAD.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jNomeMaeInternoAD.setBackground(Color.white);
        jFotoInternoAdmAD.setBackground(Color.white);
        jComboBoxAR.setBackground(Color.white);
        jComboBoxACV.setBackground(Color.white);
        jComboBoxAGU.setBackground(Color.white);
        jComboBoxCAB.setBackground(Color.white);
        jComboBoxEXT.setBackground(Color.white);
        jComboBoxABD.setBackground(Color.white);
        jAR.setBackground(Color.white);
        jACV.setBackground(Color.white);
        jAGU.setBackground(Color.white);
        jCABPESC.setBackground(Color.white);
        jEXT.setBackground(Color.white);
        jABD.setBackground(Color.white);
        jCirurgiasPrevisas.setBackground(Color.white);
        jTratamentoCurso.setBackground(Color.white);
        jQualDrogas.setBackground(Color.white);
        jComboBoxDrogasInjetavel.setBackground(Color.white);
        jQualTipoDrograInjet.setBackground(Color.white);
        jQualEtilismo.setBackground(Color.white);
        jComboBoxDrogas.setBackground(Color.white);
        jComboBoxEtilismo.setBackground(Color.white);
        jComboBoxTabagismo.setBackground(Color.white);
        jQuantoTempoTabagismo.setBackground(Color.white);
        jComboBoxSexualidade.setBackground(Color.white);
        jComboBoxNumeroParceiro.setBackground(Color.white);
        jComboBoxUsaPreserva.setBackground(Color.white);
        jComboBoxTipoSanguineo.setBackground(Color.white);
        jComboBoxFatorRH.setBackground(Color.white);
        jComboBoxVacinas.setBackground(Color.white);
        jComboBoxIgnoradoAtualizado.setBackground(Color.white);
        jComboBoxAlergias.setBackground(Color.white);
        jQuaisAlergias.setBackground(Color.white);
        jIdItem.setBackground(Color.white);
        jDescricaoPatologia.setBackground(Color.white);
        jCid.setBackground(Color.white);
        jQualMedicacaoUsa.setBackground(Color.white);
        jQuaisOutrasAlergias.setBackground(Color.white);
    }

    public void formatarCampos() {
        jDiagnosticoInicial.setLineWrap(true);
        jDiagnosticoInicial.setWrapStyleWord(true);
    }

    public void limparCampos() {
        jIdAdmAdicional.setText("");
        jStatusLancAD.setText("ABERTO");
        jDataAdmAD.setCalendar(Calendar.getInstance());
        jIdInternoAdmAD.setText("");
        jNomeInternoAdmAD.setText("");
        jDataNascAdmAD.setDate(null);
        jSexoAD.setText("");
        jMatriculaPenal.setText("");
        jNomeMaeInternoAD.setText("");
        jFotoInternoAdmAD.setIcon(null);
        jComboBoxAR.setSelectedItem("Não");
        jComboBoxACV.setSelectedItem("Não");
        jComboBoxAGU.setSelectedItem("Não");
        jComboBoxCAB.setSelectedItem("Não");
        jComboBoxEXT.setSelectedItem("Não");
        jComboBoxABD.setSelectedItem("Não");
        jAR.setText("");
        jACV.setText("");
        jAGU.setText("");
        jCABPESC.setText("");
        jEXT.setText("");
        jABD.setText("");
        jCirurgiasPrevisas.setText("");
        jTratamentoCurso.setText("");
        jQualDrogas.setText("");
        jComboBoxDrogasInjetavel.setSelectedItem("Não");
        jQualTipoDrograInjet.setText("");
        jQualEtilismo.setText("");
        jComboBoxDrogas.setSelectedItem("Não");
        jComboBoxEtilismo.setSelectedItem("Não");
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTempoTabagismo.setText("");
        jComboBoxSexualidade.setSelectedItem("Heterosssexual");
        jComboBoxNumeroParceiro.setSelectedItem("Um");
        jComboBoxUsaPreserva.setSelectedItem("Nunca");
        jComboBoxTipoSanguineo.setSelectedItem("O");
        jComboBoxFatorRH.setSelectedItem("Negativo");
        jComboBoxVacinas.setSelectedItem("Não");
        jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisAlergias.setText("");
        jComboBoxUsaMedicamento.setSelectedItem("Não");
        jQualMedicacaoUsa.setText("");
        jComboBoxOutrasAlergias.setSelectedItem("Não");
        jQuaisOutrasAlergias.setText("");
        jDiagnosticoInicial.setText("");
        jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
    }

    public void verificarPortaEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                    + "AND PSPMed='" + deptoTecnico + "' "
                    + "AND HabMed='" + pHABILITA_MEDICO + "'");
            conecta.rs.first();
            pINTERNOCRC = conecta.rs.getString("IdInternoCrc");
            pDEPARTAMENTO = conecta.rs.getString("PSPEnf");
            pHABILITADO = conecta.rs.getString("HabMed");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarInternoManual() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ADMISSAOMEDICA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOMEDICA.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ADMISSAOMEDICA.IdInternoCrc='" + jIdInternoAdm.getText() + " '"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + sitRetorno + "' "
                    + "AND ADMISSAOMEDICA.IdInternoCrc='" + jIdInternoAdm.getText() + "'");
            conecta.rs.first();
            jIdAdmPrincipal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoAdmAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoAdmAD.setText(conecta.rs.getString("NomeInternoCrc"));
            jDataNascAdmAD.setDate(conecta.rs.getDate("DataNasciCrc"));
            jSexoAD.setText(conecta.rs.getString("SexoCrc"));
            jNomeMaeInternoAD.setText(conecta.rs.getString("MaeInternoCrc"));
            jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoAdmAD.setIcon(i);
                jFotoInternoAdmAD.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoAdmAD.getWidth(), jFotoInternoAdmAD.getHeight(), Image.SCALE_DEFAULT)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoAdmAD.getWidth(), jFotoInternoAdmAD.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoAdmAD.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarInternoColaboradorBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE "
                    + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIdInternoAdmAD.getText() + "' "
                    + "AND SituacaoCrc='" + situacao + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "' "
                    + "OR REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIdInternoAdmAD.getText() + "' "
                    + "AND SituacaoCrc='" + sitRetorno + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "'");
            conecta.rs.first();
            jIdAdmPrincipal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIdInternoAdmAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoAdmAD.setText(conecta.rs.getString("NomeInternoCrc"));
            jDataNascAdmAD.setDate(conecta.rs.getDate("DataNasciCrc"));
            jSexoAD.setText(conecta.rs.getString("SexoCrc"));
            jNomeMaeInternoAD.setText(conecta.rs.getString("MaeInternoCrc"));
            jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoAdmAD.setIcon(i);
                jFotoInternoAdmAD.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoAdmAD.getWidth(), jFotoInternoAdmAD.getHeight(), Image.SCALE_DEFAULT)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoAdmAD.getWidth(), jFotoInternoAdmAD.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoAdmAD.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodEvolPsiquiatrica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA");
            conecta.rs.last();
            jIdEvolucaoPsiquiatrica.setText(conecta.rs.getString("IdItem"));
            idItemEvolPsiquiatrico = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA");
            conecta.rs.last();
            jIdEvolucaoMedica.setText(conecta.rs.getString("IdItem"));
            idItemEvol = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaMedico = conecta.rs.getString("BiometriaMedicos");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void procurarDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloENFER + "'");
            conecta.rs.first();
            codigoDepartamento = conecta.rs.getInt("IdDepartamento");
            codigoDepartamentoENF = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Novo() {
        //Limpar Campos para inclusão
        jIdAdmAdicional.setText("");
        jStatusLancAD.setText("ABERTO");
        jDataAdmAD.setCalendar(Calendar.getInstance());
        jIdInternoAdmAD.setText("");
        jNomeInternoAdmAD.setText("");
        jDataNascAdmAD.setDate(null);
        jSexoAD.setText("");
        jMatriculaPenal.setText("");
        jNomeMaeInternoAD.setText("");
        jFotoInternoAdmAD.setIcon(null);
        jComboBoxAR.setSelectedItem("Não");
        jComboBoxACV.setSelectedItem("Não");
        jComboBoxAGU.setSelectedItem("Não");
        jComboBoxCAB.setSelectedItem("Não");
        jComboBoxEXT.setSelectedItem("Não");
        jComboBoxABD.setSelectedItem("Não");
        jAR.setText("");
        jACV.setText("");
        jAGU.setText("");
        jCABPESC.setText("");
        jEXT.setText("");
        jABD.setText("");
        jCirurgiasPrevisas.setText("");
        jTratamentoCurso.setText("");
        jQualDrogas.setText("");
        jComboBoxDrogasInjetavel.setSelectedItem("Não");
        jQualTipoDrograInjet.setText("");
        jQualEtilismo.setText("");
        jComboBoxDrogas.setSelectedItem("Não");
        jComboBoxEtilismo.setSelectedItem("Não");
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTempoTabagismo.setText("");
        jComboBoxSexualidade.setSelectedItem("Heterosssexual");
        jComboBoxNumeroParceiro.setSelectedItem("Um");
        jComboBoxUsaPreserva.setSelectedItem("Nunca");
        jComboBoxTipoSanguineo.setSelectedItem("O");
        jComboBoxFatorRH.setSelectedItem("Negativo");
        jComboBoxVacinas.setSelectedItem("Não");
        jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisAlergias.setText("");
        jComboBoxUsaMedicamento.setSelectedItem("Não");
        jQualMedicacaoUsa.setText("");
        jComboBoxOutrasAlergias.setSelectedItem("Não");
        jQuaisOutrasAlergias.setText("");
        jDiagnosticoInicial.setText("");
        jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jComboBoxAR.setEnabled(true);
        jComboBoxACV.setEnabled(true);
        jComboBoxAGU.setEnabled(true);
        jComboBoxCAB.setEnabled(true);
        jComboBoxEXT.setEnabled(true);
        jComboBoxABD.setEnabled(true);
        jAR.setEnabled(true);
        jACV.setEnabled(true);
        jAGU.setEnabled(true);
        jCABPESC.setEnabled(true);
        jEXT.setEnabled(true);
        jABD.setEnabled(true);
        jCirurgiasPrevisas.setEnabled(true);
        jTratamentoCurso.setEnabled(true);
        jQualDrogas.setEnabled(true);
        jComboBoxDrogasInjetavel.setEnabled(true);
        jQualTipoDrograInjet.setEnabled(true);
        jQualEtilismo.setEnabled(true);
        jComboBoxDrogas.setEnabled(true);
        jComboBoxEtilismo.setEnabled(true);
        jComboBoxTabagismo.setEnabled(true);
        jQuantoTempoTabagismo.setEnabled(true);
        jComboBoxSexualidade.setEnabled(true);
        jComboBoxNumeroParceiro.setEnabled(true);
        jComboBoxUsaPreserva.setEnabled(true);
        jComboBoxTipoSanguineo.setEnabled(true);
        jComboBoxFatorRH.setEnabled(true);
        jComboBoxVacinas.setEnabled(true);
        jComboBoxIgnoradoAtualizado.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jComboBoxUsaMedicamento.setEnabled(true);
        jQualMedicacaoUsa.setEnabled(true);
        jComboBoxOutrasAlergias.setEnabled(true);
        jQuaisOutrasAlergias.setEnabled(true);
        jDiagnosticoInicial.setEnabled(true);
        jComboBoxTipoDiagnostico.setEnabled(true);
        //
        jIdItem.setText("");
        jDescricaoPatologia.setText("");
        jCid.setText("");
        jBtBuscar.setEnabled(true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setText("");
    }

    public void Alterar() {
        jDataAdmAD.setEnabled(true);
        jComboBoxAR.setEnabled(true);
        jComboBoxACV.setEnabled(true);
        jComboBoxAGU.setEnabled(true);
        jComboBoxCAB.setEnabled(true);
        jComboBoxEXT.setEnabled(true);
        jComboBoxABD.setEnabled(true);
        jAR.setEnabled(true);
        jACV.setEnabled(true);
        jAGU.setEnabled(true);
        jCABPESC.setEnabled(true);
        jEXT.setEnabled(true);
        jABD.setEnabled(true);
        jCirurgiasPrevisas.setEnabled(true);
        jTratamentoCurso.setEnabled(true);
        jQualDrogas.setEnabled(true);
        jComboBoxDrogasInjetavel.setEnabled(true);
        jQualTipoDrograInjet.setEnabled(true);
        jQualEtilismo.setEnabled(true);
        jComboBoxDrogas.setEnabled(true);
        jComboBoxEtilismo.setEnabled(true);
        jComboBoxTabagismo.setEnabled(true);
        jQuantoTempoTabagismo.setEnabled(true);
        jComboBoxSexualidade.setEnabled(true);
        jComboBoxNumeroParceiro.setEnabled(true);
        jComboBoxUsaPreserva.setEnabled(true);
        jComboBoxTipoSanguineo.setEnabled(true);
        jComboBoxFatorRH.setEnabled(true);
        jComboBoxVacinas.setEnabled(true);
        jComboBoxIgnoradoAtualizado.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jComboBoxUsaMedicamento.setEnabled(true);
        jQualMedicacaoUsa.setEnabled(true);
        jComboBoxOutrasAlergias.setEnabled(true);
        jQuaisOutrasAlergias.setEnabled(true);
        jDiagnosticoInicial.setEnabled(true);
        jComboBoxTipoDiagnostico.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtBuscar.setEnabled(true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        jTabelaPatologiaADD.setEnabled(true);
    }

    public void Excluir() {
        //Limpar Campos para inclusão
        jIdAdm.setText("");
        jStatusLancAD.setText("");
        jDataAdmAD.setDate(null);
        jIdInternoAdmAD.setText("");
        jNomeInternoAdmAD.setText("");
        jDataNascAdmAD.setDate(null);
        jSexoAD.setText("");
        jMatriculaPenal.setText("");
        jNomeMaeInternoAD.setText("");
        jFotoInternoAdmAD.setIcon(null);
        jComboBoxAR.setSelectedItem("Não");
        jComboBoxACV.setSelectedItem("Não");
        jComboBoxAGU.setSelectedItem("Não");
        jComboBoxCAB.setSelectedItem("Não");
        jComboBoxEXT.setSelectedItem("Não");
        jComboBoxABD.setSelectedItem("Não");
        jAR.setText("");
        jACV.setText("");
        jAGU.setText("");
        jCABPESC.setText("");
        jEXT.setText("");
        jABD.setText("");
        jCirurgiasPrevisas.setText("");
        jTratamentoCurso.setText("");
        jQualDrogas.setText("");
        jComboBoxDrogasInjetavel.setSelectedItem("Não");
        jQualTipoDrograInjet.setText("");
        jQualEtilismo.setText("");
        jComboBoxDrogas.setSelectedItem("Não");
        jComboBoxEtilismo.setSelectedItem("Não");
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTempoTabagismo.setText("");
        jComboBoxSexualidade.setSelectedItem("Heterosssexual");
        jComboBoxNumeroParceiro.setSelectedItem("Um");
        jComboBoxUsaPreserva.setSelectedItem("Nunca");
        jComboBoxTipoSanguineo.setSelectedItem("O");
        jComboBoxFatorRH.setSelectedItem("Negativo");
        jComboBoxVacinas.setSelectedItem("Não");
        jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisAlergias.setText("");
        jComboBoxUsaMedicamento.setSelectedItem("Não");
        jQualMedicacaoUsa.setText("");
        jComboBoxOutrasAlergias.setSelectedItem("Não");
        jQuaisOutrasAlergias.setText("");
        jDiagnosticoInicial.setText("");
        jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
        //Habilitar/Desabilitar Campos
        jDataAdmAD.setEnabled(!true);
        jComboBoxAR.setEnabled(!true);
        jComboBoxACV.setEnabled(!true);
        jComboBoxAGU.setEnabled(!true);
        jComboBoxCAB.setEnabled(!true);
        jComboBoxEXT.setEnabled(!true);
        jComboBoxABD.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jComboBoxDrogasInjetavel.setEnabled(!true);
        jQualTipoDrograInjet.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxSexualidade.setEnabled(!true);
        jComboBoxNumeroParceiro.setEnabled(!true);
        jComboBoxUsaPreserva.setEnabled(!true);
        jComboBoxTipoSanguineo.setEnabled(!true);
        jComboBoxFatorRH.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jComboBoxUsaMedicamento.setEnabled(!true);
        jQualMedicacaoUsa.setEnabled(!true);
        jComboBoxOutrasAlergias.setEnabled(!true);
        jQuaisOutrasAlergias.setEnabled(!true);
        jDiagnosticoInicial.setEnabled(!true);
        jComboBoxTipoDiagnostico.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtBuscar.setEnabled(!true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setText("");
    }

    public void Salvar() {
        jDataAdmAD.setEnabled(!true);
        jComboBoxAR.setEnabled(!true);
        jComboBoxACV.setEnabled(!true);
        jComboBoxAGU.setEnabled(!true);
        jComboBoxCAB.setEnabled(!true);
        jComboBoxEXT.setEnabled(!true);
        jComboBoxABD.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jComboBoxDrogasInjetavel.setEnabled(!true);
        jQualTipoDrograInjet.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxSexualidade.setEnabled(!true);
        jComboBoxNumeroParceiro.setEnabled(!true);
        jComboBoxUsaPreserva.setEnabled(!true);
        jComboBoxTipoSanguineo.setEnabled(!true);
        jComboBoxFatorRH.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jComboBoxUsaMedicamento.setEnabled(!true);
        jQualMedicacaoUsa.setEnabled(!true);
        jComboBoxOutrasAlergias.setEnabled(!true);
        jQuaisOutrasAlergias.setEnabled(!true);
        jDiagnosticoInicial.setEnabled(!true);
        jComboBoxTipoDiagnostico.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtBuscar.setEnabled(!true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdAdm.getText().equals("")) {
            jIdAdm.setText("");
            jStatusLancAD.setText("");
            jDataAdmAD.setDate(null);
            jIdInternoAdmAD.setText("");
            jNomeInternoAdmAD.setText("");
            jDataNascAdmAD.setDate(null);
            jSexoAD.setText("");
            jMatriculaPenal.setText("");
            jNomeMaeInternoAD.setText("");
            jFotoInternoAdmAD.setIcon(null);
            jComboBoxAR.setSelectedItem("Não");
            jComboBoxACV.setSelectedItem("Não");
            jComboBoxAGU.setSelectedItem("Não");
            jComboBoxCAB.setSelectedItem("Não");
            jComboBoxEXT.setSelectedItem("Não");
            jComboBoxABD.setSelectedItem("Não");
            jAR.setText("");
            jACV.setText("");
            jAGU.setText("");
            jCABPESC.setText("");
            jEXT.setText("");
            jABD.setText("");
            jCirurgiasPrevisas.setText("");
            jTratamentoCurso.setText("");
            jQualDrogas.setText("");
            jComboBoxDrogasInjetavel.setSelectedItem("Não");
            jQualTipoDrograInjet.setText("");
            jQualEtilismo.setText("");
            jComboBoxDrogas.setSelectedItem("Não");
            jComboBoxEtilismo.setSelectedItem("Não");
            jComboBoxTabagismo.setSelectedItem("Não");
            jQuantoTempoTabagismo.setText("");
            jComboBoxSexualidade.setSelectedItem("Heterosssexual");
            jComboBoxNumeroParceiro.setSelectedItem("Um");
            jComboBoxUsaPreserva.setSelectedItem("Nunca");
            jComboBoxTipoSanguineo.setSelectedItem("O");
            jComboBoxFatorRH.setSelectedItem("Negativo");
            jComboBoxVacinas.setSelectedItem("Não");
            jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
            jComboBoxAlergias.setSelectedItem("Não");
            jQuaisAlergias.setText("");
            jComboBoxUsaMedicamento.setSelectedItem("Não");
            jQualMedicacaoUsa.setText("");
            jComboBoxOutrasAlergias.setSelectedItem("Não");
            jQuaisOutrasAlergias.setText("");
            jDiagnosticoInicial.setText("");
            jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
            //
            jDataAdmAD.setEnabled(!true);
            jComboBoxAR.setEnabled(!true);
            jComboBoxACV.setEnabled(!true);
            jComboBoxAGU.setEnabled(!true);
            jComboBoxCAB.setEnabled(!true);
            jComboBoxEXT.setEnabled(!true);
            jComboBoxABD.setEnabled(!true);
            jAR.setEnabled(!true);
            jACV.setEnabled(!true);
            jAGU.setEnabled(!true);
            jCABPESC.setEnabled(!true);
            jEXT.setEnabled(!true);
            jABD.setEnabled(!true);
            jCirurgiasPrevisas.setEnabled(!true);
            jTratamentoCurso.setEnabled(!true);
            jQualDrogas.setEnabled(!true);
            jComboBoxDrogasInjetavel.setEnabled(!true);
            jQualTipoDrograInjet.setEnabled(!true);
            jQualEtilismo.setEnabled(!true);
            jComboBoxDrogas.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jComboBoxTabagismo.setEnabled(!true);
            jQuantoTempoTabagismo.setEnabled(!true);
            jComboBoxSexualidade.setEnabled(!true);
            jComboBoxNumeroParceiro.setEnabled(!true);
            jComboBoxUsaPreserva.setEnabled(!true);
            jComboBoxTipoSanguineo.setEnabled(!true);
            jComboBoxFatorRH.setEnabled(!true);
            jComboBoxVacinas.setEnabled(!true);
            jComboBoxIgnoradoAtualizado.setEnabled(!true);
            jComboBoxAlergias.setEnabled(!true);
            jQuaisAlergias.setEnabled(!true);
            jComboBoxUsaMedicamento.setEnabled(!true);
            jQualMedicacaoUsa.setEnabled(!true);
            jComboBoxOutrasAlergias.setEnabled(!true);
            jQuaisOutrasAlergias.setEnabled(!true);
            jDiagnosticoInicial.setEnabled(!true);
            jComboBoxTipoDiagnostico.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //
            jIdItem.setText("");
            jDescricaoPatologia.setText("");
            jCid.setText("");
            jBtBuscar.setEnabled(!true);
        } else {
            jDataAdmAD.setEnabled(!true);
            jComboBoxAR.setEnabled(!true);
            jComboBoxACV.setEnabled(!true);
            jComboBoxAGU.setEnabled(!true);
            jComboBoxCAB.setEnabled(!true);
            jComboBoxEXT.setEnabled(!true);
            jComboBoxABD.setEnabled(!true);
            jAR.setEnabled(!true);
            jACV.setEnabled(!true);
            jAGU.setEnabled(!true);
            jCABPESC.setEnabled(!true);
            jEXT.setEnabled(!true);
            jABD.setEnabled(!true);
            jCirurgiasPrevisas.setEnabled(!true);
            jTratamentoCurso.setEnabled(!true);
            jQualDrogas.setEnabled(!true);
            jComboBoxDrogasInjetavel.setEnabled(!true);
            jQualTipoDrograInjet.setEnabled(!true);
            jQualEtilismo.setEnabled(!true);
            jComboBoxDrogas.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jComboBoxTabagismo.setEnabled(!true);
            jQuantoTempoTabagismo.setEnabled(!true);
            jComboBoxSexualidade.setEnabled(!true);
            jComboBoxNumeroParceiro.setEnabled(!true);
            jComboBoxUsaPreserva.setEnabled(!true);
            jComboBoxTipoSanguineo.setEnabled(!true);
            jComboBoxFatorRH.setEnabled(!true);
            jComboBoxVacinas.setEnabled(!true);
            jComboBoxIgnoradoAtualizado.setEnabled(!true);
            jComboBoxAlergias.setEnabled(!true);
            jQuaisAlergias.setEnabled(!true);
            jComboBoxUsaMedicamento.setEnabled(!true);
            jQualMedicacaoUsa.setEnabled(!true);
            jComboBoxOutrasAlergias.setEnabled(!true);
            jQuaisOutrasAlergias.setEnabled(!true);
            jDiagnosticoInicial.setEnabled(!true);
            jComboBoxTipoDiagnostico.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtBuscar.setEnabled(!true);
            jBtAdicionarPatologia.setEnabled(!true);
            jBtExcluirPatologia.setEnabled(!true);
            jIdItem.setText("");
            jDescricaoPatologia.setText("");
            jCid.setText("");
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusAtend = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse atendimento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o ATENDIMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAdmMedico.setStatusLanc(statusAtend);
            objAdmMedico.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
            control.finalizarAdmissaoMedica(objAdmMedico);
            objAdmMedico.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
            controle.finalizarMovTec(objAdmMedico);
            jStatusLancAD.setText(statusAtend);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataAdmAD.setEnabled(!true);
            jAR.setEnabled(!true);
            jACV.setEnabled(!true);
            jAGU.setEnabled(!true);
            jCABPESC.setEnabled(!true);
            jEXT.setEnabled(!true);
            jABD.setEnabled(!true);
            jCirurgiasPrevisas.setEnabled(!true);
            jTratamentoCurso.setEnabled(!true);
            jQualDrogas.setEnabled(!true);
            jQualEtilismo.setEnabled(!true);
            jQuantoTempoTabagismo.setEnabled(!true);
            jComboBoxDrogas.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jComboBoxTabagismo.setEnabled(!true);
            jComboBoxVacinas.setEnabled(!true);
            jComboBoxIgnoradoAtualizado.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_MEDICA_ADICIONAL");
            conecta.rs.last();
            jIdAdmAdicional.setText(String.valueOf(conecta.rs.getInt("IdAdmADI")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar ATENDIMENTO. \nERRO: " + ex);
        }
    }

    public void tabelaPatologias() {

        jTabelaPatologiaADD.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPatologiaADD.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPatologiaADD.getColumnModel().getColumn(1).setPreferredWidth(320);
        jTabelaPatologiaADD.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPatologiaADD.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPatologiaADD.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPatologiaADD.getTableHeader().setReorderingAllowed(false);
        jTabelaPatologiaADD.setAutoResizeMode(jTabelaPatologiaADD.AUTO_RESIZE_OFF);
        jTabelaPatologiaADD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPatologia();
    }

    public void alinharCamposTabelaPatologia() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPatologiaADD.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void incluirItensDoencas() {
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaPatologiaADD.getRowCount(); i++) {
            objItensDoenca.setIdLanc(Integer.valueOf(jIdAdmAdicional.getText()));
            objItensDoenca.setDataLanc(jDataAdmAD.getDate());
            objItensDoenca.setIdDoenca((int) jTabelaPatologiaADD.getValueAt(i, 0));
            objItensDoenca.setDescricaoDoenca((String) jTabelaPatologiaADD.getValueAt(i, 1));
            objItensDoenca.getDescricaoDoenca();
            controlePat.incluirDoencas(objItensDoenca);
        }
    }

    public void alterarItensDoencas() {
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaPatologiaADD.getRowCount(); i++) {
            verificarDoencas();
            if (jIdAdm.getText().equals(codAdm) && jTabelaPatologiaADD.getValueAt(i, 0) != codDoenca) {
                objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                objAdmMedico.setNomeInterno(jNomeInternoAdmAD.getText());
                objAdmMedico.setDeptoMedico(deptoTecnico);
                incluirItensDoencas();

            } else {
                objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                objItensDoenca.setDataLanc(jDataAdmAD.getDate());
                objItensDoenca.setIdDoenca((int) jTabelaPatologiaADD.getValueAt(i, 0));
                objItensDoenca.setDescricaoDoenca((String) jTabelaPatologiaADD.getValueAt(i, 1));
                objItensDoenca.getDescricaoDoenca();
                controlePat.alterarDoencas(objItensDoenca);
            }
        }
    }

    public void verificarDoencas() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_ADMISSAO_DOENCAS_ADICIONAL "
                    + "WHERE IdAdmADI='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codAdm = conecta.rs.getString("IdAdmADI");
            codDoenca = conecta.rs.getString("IdDoenca");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherAdmissaoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Situação"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdAdmADI"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("SituacaoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMedicoAD.setModel(modelo);
        jTabelaMedicoAD.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaMedicoAD.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMedicoAD.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMedicoAD.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaMedicoAD.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaMedicoAD.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMedicoAD.getTableHeader().setReorderingAllowed(false);
        jTabelaMedicoAD.setAutoResizeMode(jTabelaMedicoAD.AUTO_RESIZE_OFF);
        jTabelaMedicoAD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAdmissao();
        conecta.desconecta();
    }

    public void limparTabelaAdmissao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Situação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMedicoAD.setModel(modelo);
        jTabelaMedicoAD.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaMedicoAD.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMedicoAD.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMedicoAD.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaMedicoAD.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMedicoAD.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTabelaMedicoAD.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMedicoAD.getTableHeader().setReorderingAllowed(false);
        jTabelaMedicoAD.setAutoResizeMode(jTabelaMedicoAD.AUTO_RESIZE_OFF);
        jTabelaMedicoAD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaAdmissao() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaMedicoAD.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaMedicoAD.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaMedicoAD.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limpaTabelaDoencas() {

        while (jTabelaPatologiaADD.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaPatologiaADD.getModel()).removeRow(0);
        }
    }

    public void preencherTabelaEvolucaoPsiquiatrica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "PA", "Anotação/Evolução Psiquiatrica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countp = 0;
            do {
                idItemEvolPsiquiatrico = conecta.rs.getInt("IdItem");
                countp = countp + 1;
                dataEvolPsiquiatrica = conecta.rs.getString("DataEvol");
                String diag = dataEvolPsiquiatrica.substring(8, 10);
                String mesg = dataEvolPsiquiatrica.substring(5, 7);
                String anog = dataEvolPsiquiatrica.substring(0, 4);
                dataEvolPsiquiatrica = diag + "/" + mesg + "/" + anog;
                jTotalRegistrosPsi.setText(Integer.toString(countp)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEvolPsiquiatrica, conecta.rs.getString("Patologia"), conecta.rs.getString("EvolucaoPsiquiatrica")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolPsiquiatrica.setModel(modelo);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolPsiquiatrica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolPsiquiatrica.setAutoResizeMode(jTabelaEvolPsiquiatrica.AUTO_RESIZE_OFF);
        jTabelaEvolPsiquiatrica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucaoPsiquiatrica();
        conecta.desconecta();
    }

    public void preencherTabelaEvolucaoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "PA", "Anotação/Evolução Médica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countm = 0;
            do {
                idItemEvol = conecta.rs.getInt("IdItem");
                countm = countm + 1;
                dataEvolu = conecta.rs.getString("DataEvolu");
                String diav = dataEvolu.substring(8, 10);
                String mesv = dataEvolu.substring(5, 7);
                String anov = dataEvolu.substring(0, 4);
                dataEvolu = diav + "/" + mesv + "/" + anov;
                jTotalRegistrosMed.setText(Integer.toString(countm)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEvolu, conecta.rs.getString("Patologia"), conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoMedica.setModel(modelo);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolucaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoMedica.setAutoResizeMode(jTabelaEvolucaoMedica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucaoMedica();
        conecta.desconecta();
    }

    public void alinharCamposTabelaEvolucaoMedica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void alinharCamposTabelaEvolucaoPsiquiatrica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdmAdicional.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
