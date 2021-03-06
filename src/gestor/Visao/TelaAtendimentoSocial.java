/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtendSocial;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoServicoSocial;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovEvolucaoServicoSocial;
import gestor.Controle.ControleMovServicoSocial;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControlePortaEntrada;
import gestor.Modelo.AtendimentoServicoSocial;
import gestor.Modelo.EvolucaoServicoSocial;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloServicoSocial.codAbrirSS;
import static gestor.Visao.TelaModuloServicoSocial.codAlterarSS;
import static gestor.Visao.TelaModuloServicoSocial.codConsultarSS;
import static gestor.Visao.TelaModuloServicoSocial.codExcluirSS;
import static gestor.Visao.TelaModuloServicoSocial.codGravarSS;
import static gestor.Visao.TelaModuloServicoSocial.codIncluirSS;
import static gestor.Visao.TelaModuloServicoSocial.codUserAcessoSS;
import static gestor.Visao.TelaModuloServicoSocial.codigoGrupoSS;
import static gestor.Visao.TelaModuloServicoSocial.codigoUserSS;
import static gestor.Visao.TelaModuloServicoSocial.codigoUserGroupSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeGrupoSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeModuloSERV;
import static gestor.Visao.TelaModuloServicoSocial.nomeModuloSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeTelaSS;
import static gestor.Visao.TelaModuloServicoSocial.pQUANTIDADE_ATENDIDA;
import static gestor.Visao.TelaModuloServicoSocial.telaAdmissaoInternosServicoSocial;
import static gestor.Visao.TelaModuloServicoSocial.telaEvolucaoServicoSocial;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author user
 */
public class TelaAtendimentoSocial extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoServicoSocial objAtendSocial = new AtendimentoServicoSocial();
    ControleAtendSocial control = new ControleAtendSocial();
    ControleMovServicoSocial controle = new ControleMovServicoSocial();
    EvolucaoServicoSocial objEvol = new EvolucaoServicoSocial();
    ControleMovEvolucaoServicoSocial controlMovEvolSSocial = new ControleMovEvolucaoServicoSocial();
    ControleEvolucaoServicoSocial controleEvol = new ControleEvolucaoServicoSocial();
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
    String nomeModuloTela = "Serviço Social:Admissão Interno Social:Manutenção";
    String nomeModuloTela1 = "Serviço Social:Admissão Interno Social:Evolução";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao;
    int flag;
    String dataAtendimento;
    String dataEntrada;
    String dataInicial;
    String dataFinal, dataEvolu;
    String caminho;
    String deptoTecnico = "SERVIÇO SOCIAL";
    String statusAtend = "ABERTO";
    String statusEvolucao = "EVOLUINDO";
    int count = 0;
    int idItemEvol;
    String codEvolucao;
    // VARIVAEIS PARA SABER SE O INTERNO FOI REGISTRADO COM BIOMETRIA      
    String dataReg = "";
    Date dataRegistro = null;
    String codigoInternoAtend = "";
    String atendido = "Sim";
    String opcao = "Não";
    public static int codigoDepartamentoSS = 0;
    String tipoAtendimentoAdm = "Admissão Serviço Social";
    String tipoAtendimentoEvol = "Evolução Serviço Social";
    //
    String pHabilitaSSocial = "";
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    String pCODIGO_INTERNO = "";
    //EVOLUÇÃO DA ADMISSÃO
    String admEvolucao = "Sim";
    String nomeUserRegistro;
    String pHABILITA_SS = "Não";

    /**
     * Creates new form AtendimentoSocial
     */
    public static TelaIndicacaoVisitasInternos indicacaoVisitas;
    public static TelaPortaEntradaServicoSocial pPORTA_ENTRADA;

    public TelaAtendimentoSocial() {
        super();
        initComponents();
        setResizable(false);
        formatCampos();
        corCampo();
    }

    public void mostrarTelaIdicacaoVisitas() {
        indicacaoVisitas = new TelaIndicacaoVisitasInternos(this, true);
        indicacaoVisitas.setVisible(true);
    }

    public void mostrarPortaEntrada() {
        pPORTA_ENTRADA = new TelaPortaEntradaServicoSocial(this, true);
        pPORTA_ENTRADA.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jIDPesqAtend = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtAtend = new javax.swing.JButton();
        jBtPesqData = new javax.swing.JButton();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaAtendimentoSocial = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jIDInterno = new javax.swing.JTextField();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMaeInterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPaiInterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jEstadoCivil = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jProfissao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jNaturalidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jEscolaridade = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jReligiao = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        ContatoFamiliar = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        JContato = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTelefone = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jTelefone1 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jEnderecoContato = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jBairroContato = new javax.swing.JTextField();
        jCelular = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jCidadeContato = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jEstadoContato = new javax.swing.JTextField();
        Documentos = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jComboBoxCPF2 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxCTPS1 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jComboBoxCTPS2 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxCN1 = new javax.swing.JComboBox();
        jComboBoxCN2 = new javax.swing.JComboBox();
        jComboBoxRG1 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxRG2 = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxCPF1 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxTitulo1 = new javax.swing.JComboBox();
        jComboBoxTitulo2 = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxReservista1 = new javax.swing.JComboBox();
        jComboBoxReservista2 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jMunicipioNascimento = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jCartorioRegistro = new javax.swing.JTextField();
        DadosAtendimento = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxTrabalho = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxDireitoReclusao = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxAuxReclusao = new javax.swing.JComboBox();
        jPeriodo = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jComboBoxAuxilioDoenca = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jComboBoxCondicaoSegurado = new javax.swing.JComboBox();
        jComboBoxPessoasCasa = new javax.swing.JComboBox();
        Outros = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jComboBoxPossuiFilhos = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxOutrosFilhos = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jQtdFilhos = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jQtdFilhosRela = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTotalFilhos = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPaternidade = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jQtdPessoasResideCasa = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jQtsTrabalham = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jComboBoxEsposaCompanheira = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        jNomeCompanheira = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTipoConvivencia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxOutrosSetores = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jQualSetor = new javax.swing.JTextField();
        jBtPesqDepartamento = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jComboBoxCancelVisita = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        jMotivo = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jComboBoxTirarDoc = new javax.swing.JComboBox();
        jLabel63 = new javax.swing.JLabel();
        jDataDoc = new com.toedter.calendar.JDateChooser();
        jDataPater = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jComboBoxRecPater = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        jComboBoxRecebeVisita = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jComboBoxDefensor = new javax.swing.JComboBox();
        Consideracoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jConsideracoes = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtImprimir = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtNovaPortaEntrada = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jIdADM_Principal = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jDataAtendimento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jStatusAtend = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        FotoInterno = new javax.swing.JLabel();
        jBtIndicacaoVisitas = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEvolucaoServicoSocial = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jIdEvolucao = new javax.swing.JTextField();
        jNomeInternoEvolServicoSocial = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jDataEvolu = new com.toedter.calendar.JDateChooser();
        jPanel42 = new javax.swing.JPanel();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextoEvolucao = new javax.swing.JTextArea();
        jLabel56 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel39.setText("jLabel39");

        jLabel71.setText("jLabel71");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Admissão de Internos Serviço Social :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Código:");

        jIDPesqAtend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data Inicial:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Data Final:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Nome Interno:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtAtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtAtend.setContentAreaFilled(false);
        jBtAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtendActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel49)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(108, 108, 108)
                            .addComponent(jCheckBox1))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtend, jBtPesqData, jBtPesqNomeInterno});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAtend)
                    .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqData)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel50)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAtend, jBtPesqData, jBtPesqNomeInterno});

        jTabelaAtendimentoSocial.setAutoCreateRowSorter(true);
        jTabelaAtendimentoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtendimentoSocial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Nome do Interno", "Data Entrada", "Situação na Unidade"
            }
        ));
        jTabelaAtendimentoSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtendimentoSocialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaAtendimentoSocial);
        if (jTabelaAtendimentoSocial.getColumnModel().getColumnCount() > 0) {
            jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setMinWidth(180);
            jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setMaxWidth(180);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jIDInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInterno.setEnabled(false);

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar Interno");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Mãe:");

        jMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaeInterno.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Pai:");

        jPaiInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPaiInterno.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("E. Civil:");

        jEstadoCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstadoCivil.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Data Nasc:");

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Profissão:");

        jProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissao.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Natural:");

        jNaturalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturalidade.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Escolaridade:");

        jEscolaridade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEscolaridade.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Religião:");

        jReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReligiao.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(jIDInterno))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProfissao)
                                    .addComponent(jNaturalidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jReligiao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPaiInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jEscolaridade, jEstadoCivil, jReligiao});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jMaeInterno, jPaiInterno});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jPaiInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Familiar para Contato");

        JContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        JContato.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Telefone");

        jTelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Telefone");

        jTelefone1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone1.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Endereço do Contato");

        jEnderecoContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEnderecoContato.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Bairro");

        jBairroContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairroContato.setEnabled(false);

        jCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelular.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Celular");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Cidade");

        jCidadeContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidadeContato.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Estado");

        jEstadoContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstadoContato.setEnabled(false);

        javax.swing.GroupLayout ContatoFamiliarLayout = new javax.swing.GroupLayout(ContatoFamiliar);
        ContatoFamiliar.setLayout(ContatoFamiliarLayout);
        ContatoFamiliarLayout.setHorizontalGroup(
            ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCidadeContato)
                    .addComponent(jEnderecoContato)
                    .addComponent(JContato)
                    .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                        .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel44))
                        .addGap(0, 179, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(124, 124, 124))
                    .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                        .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBairroContato, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                .addComponent(jEstadoContato))
                            .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                                        .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43))))
                        .addContainerGap())))
        );

        ContatoFamiliarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCelular, jTelefone, jTelefone1});

        ContatoFamiliarLayout.setVerticalGroup(
            ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14))
                    .addComponent(jLabel13))
                .addGap(3, 3, 3)
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEnderecoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBairroContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCidadeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEstadoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel43)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        ContatoFamiliarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTelefone, jTelefone1});

        jTabbedPane2.addTab("Contato Familiar", ContatoFamiliar);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jComboBoxCPF2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCPF2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCPF2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCPF2.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Registro Geral 2ª via:");

        jComboBoxCTPS1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCTPS1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCTPS1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCTPS1.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("CPF 1ª via:");

        jComboBoxCTPS2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCTPS2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCTPS2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCTPS2.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("CPF 2ª via:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("CTPS 1ª via:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("CTPS 2ª via:");

        jComboBoxCN1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCN1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCN1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCN1.setEnabled(false);

        jComboBoxCN2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCN2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCN2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCN2.setEnabled(false);

        jComboBoxRG1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRG1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRG1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRG1.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Certidão Nascimento 1ª via:");

        jComboBoxRG2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRG2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRG2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRG2.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Certidão Nascimento 2 ª via:");

        jComboBoxCPF1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCPF1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCPF1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCPF1.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Registro Geral 1ª via:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Titulo de Eleitor 1ª via:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Titulo de Eleitor 2ª via:");

        jComboBoxTitulo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTitulo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTitulo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTitulo1.setEnabled(false);

        jComboBoxTitulo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTitulo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTitulo2.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Reservista 1ª via:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Reservista 2ª via:");

        jComboBoxReservista1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReservista1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReservista1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReservista1.setEnabled(false);

        jComboBoxReservista2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReservista2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReservista2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReservista2.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Municipio de Nascimento:");

        jMunicipioNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMunicipioNascimento.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Cartório Registro:");

        jCartorioRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCartorioRegistro.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCN1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCN2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxRG1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxRG2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxCPF1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxCTPS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxCTPS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(jLabel54))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jMunicipioNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCartorioRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxReservista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxReservista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(219, 219, 219))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxCPF1, jComboBoxCPF2, jComboBoxCTPS1, jComboBoxCTPS2});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel26)
                    .addComponent(jComboBoxCN1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxCN2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jComboBoxRG1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jComboBoxCTPS1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jComboBoxReservista1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxRG2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxCTPS2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jComboBoxReservista2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jMunicipioNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jCartorioRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxCN1, jComboBoxCN2, jComboBoxCPF1, jComboBoxRG1, jComboBoxRG2});

        javax.swing.GroupLayout DocumentosLayout = new javax.swing.GroupLayout(Documentos);
        Documentos.setLayout(DocumentosLayout);
        DocumentosLayout.setHorizontalGroup(
            DocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
        );
        DocumentosLayout.setVerticalGroup(
            DocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DocumentosLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Documentos 1ª e 2ª Via ", Documentos);

        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Contribuiu para Previdência Social ou Similar?");

        jComboBoxTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTrabalho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Não sabe" }));
        jComboBoxTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTrabalho.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Por mais de 12 meses consecutivos?");

        jComboBoxDireitoReclusao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDireitoReclusao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDireitoReclusao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDireitoReclusao.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("No ano anterior a prisão estava contribuindo?");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Ultima Contribuição?");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Direito ao Auxilio Reclusão?");

        jComboBoxAuxReclusao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAuxReclusao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAuxReclusao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAuxReclusao.setEnabled(false);

        jPeriodo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPeriodo.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Recebe algum benefício?");

        jComboBoxAuxilioDoenca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAuxilioDoenca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não recebe", "Não sabe", "Auxilio Doenca", "BPC/Loas", " " }));
        jComboBoxAuxilioDoenca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAuxilioDoenca.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Estava na Condição de Segurado?");

        jComboBoxCondicaoSegurado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCondicaoSegurado.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxCondicaoSegurado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCondicaoSegurado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCondicaoSegurado.setEnabled(false);

        jComboBoxPessoasCasa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPessoasCasa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPessoasCasa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPessoasCasa.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxDireitoReclusao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTrabalho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPeriodo)
                            .addComponent(jComboBoxAuxReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxAuxilioDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPessoasCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCondicaoSegurado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxCondicaoSegurado, jComboBoxDireitoReclusao, jComboBoxPessoasCasa, jComboBoxTrabalho});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxAuxReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDireitoReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxPessoasCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jComboBoxCondicaoSegurado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jComboBoxAuxilioDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout DadosAtendimentoLayout = new javax.swing.GroupLayout(DadosAtendimento);
        DadosAtendimento.setLayout(DadosAtendimentoLayout);
        DadosAtendimentoLayout.setHorizontalGroup(
            DadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DadosAtendimentoLayout.setVerticalGroup(
            DadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Beneficios Gerais", DadosAtendimento);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Possui filhos com atual companheira?");

        jComboBoxPossuiFilhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPossuiFilhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "sim" }));
        jComboBoxPossuiFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPossuiFilhos.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Filhos de outros relacionamentos?");

        jComboBoxOutrosFilhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOutrosFilhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "sim" }));
        jComboBoxOutrosFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOutrosFilhos.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Quantos?");

        jQtdFilhos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdFilhos.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Quantos?");

        jQtdFilhosRela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdFilhosRela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdFilhosRela.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Total filhos não registrados?");

        jTotalFilhos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotalFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotalFilhos.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("A reconhecer paternidade?");

        jPaternidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPaternidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPaternidade.setEnabled(false);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Quantas Pessoas Residem na Casa?");

        jQtdPessoasResideCasa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdPessoasResideCasa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdPessoasResideCasa.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Quantos Trabalham?");

        jQtsTrabalham.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtsTrabalham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtsTrabalham.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Esposo(a)/Companheiro(a)/Solterio(a)?");

        jComboBoxEsposaCompanheira.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEsposaCompanheira.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "E", "C", "S" }));
        jComboBoxEsposaCompanheira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEsposaCompanheira.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Nome Esposo(a)/Companheiro(a):");

        jNomeCompanheira.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeCompanheira.setEnabled(false);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Tempo de Convivência:");

        jTipoConvivencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTipoConvivencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoConvivencia.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel38)
                            .addComponent(jLabel36)
                            .addComponent(jLabel68)
                            .addComponent(jLabel72)
                            .addComponent(jLabel70))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxOutrosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTotalFilhos)
                                    .addComponent(jQtdPessoasResideCasa))
                                .addGap(115, 115, 115))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEsposaCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxPossuiFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jQtdFilhosRela, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jQtdFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jQtsTrabalham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPaternidade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTipoConvivencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jNomeCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxOutrosFilhos, jComboBoxPossuiFilhos, jPaternidade, jQtdFilhos, jQtdFilhosRela, jQtdPessoasResideCasa, jQtsTrabalham, jTipoConvivencia, jTotalFilhos});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jComboBoxEsposaCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jTipoConvivencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jNomeCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jQtdPessoasResideCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtsTrabalham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQtdFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxPossuiFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxOutrosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jQtdFilhosRela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel38)
                    .addComponent(jTotalFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jPaternidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout OutrosLayout = new javax.swing.GroupLayout(Outros);
        Outros.setLayout(OutrosLayout);
        OutrosLayout.setHorizontalGroup(
            OutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
        );
        OutrosLayout.setVerticalGroup(
            OutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Situação Familiar", Outros);

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Encaminhado para outros Setores?");

        jComboBoxOutrosSetores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOutrosSetores.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxOutrosSetores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxOutrosSetores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOutrosSetores.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Qual?");

        jQualSetor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualSetor.setEnabled(false);

        jBtPesqDepartamento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jBtPesqDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDepartamento.setContentAreaFilled(false);
        jBtPesqDepartamento.setEnabled(false);
        jBtPesqDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDepartamentoActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Cancelar Visita?");

        jComboBoxCancelVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCancelVisita.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxCancelVisita.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCancelVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCancelVisita.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Motivo:");

        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Enc. para tirar documentos?");

        jComboBoxTirarDoc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTirarDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTirarDoc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTirarDoc.setEnabled(false);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Data:");

        jDataDoc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataDoc.setEnabled(false);

        jDataPater.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPater.setEnabled(false);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Data:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Enc. para reconhecer paternidade?");

        jComboBoxRecPater.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRecPater.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRecPater.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRecPater.setEnabled(false);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Recebe Visita?");

        jComboBoxRecebeVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRecebeVisita.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRecebeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRecebeVisita.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Defensor:");

        jComboBoxDefensor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDefensor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defensor Público", "Ad. Particular", "Ad. da Unidade" }));
        jComboBoxDefensor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDefensor.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxRecPater, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTirarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCancelVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOutrosSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jDataPater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRecebeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jQualSetor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jDataDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel41)
                            .addGap(2, 2, 2)
                            .addComponent(jComboBoxDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxCancelVisita, jComboBoxOutrosSetores, jComboBoxRecPater, jComboBoxTirarDoc});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxOutrosSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jQualSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel60)
                    .addComponent(jComboBoxCancelVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(jMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxTirarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(jDataDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jComboBoxDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel65)
                    .addComponent(jComboBoxRecPater, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(jDataPater, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(jComboBoxRecebeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Diversos", jPanel4);

        jConsideracoes.setColumns(20);
        jConsideracoes.setRows(5);
        jConsideracoes.setText("[DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...]");
        jConsideracoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jConsideracoes.setEnabled(false);
        jScrollPane1.setViewportView(jConsideracoes);

        javax.swing.GroupLayout ConsideracoesLayout = new javax.swing.GroupLayout(Consideracoes);
        Consideracoes.setLayout(ConsideracoesLayout);
        ConsideracoesLayout.setHorizontalGroup(
            ConsideracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsideracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );
        ConsideracoesLayout.setVerticalGroup(
            ConsideracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsideracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Considerações", Consideracoes);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimir.setText("Imprimir");
        jBtImprimir.setContentAreaFilled(false);
        jBtImprimir.setEnabled(false);
        jBtImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtImprimir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirActionPerformed(evt);
            }
        });

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/low-security-breach-icone-4155-16.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(255, 0, 0));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
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

        jBtNovaPortaEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/290718163923_16.png"))); // NOI18N
        jBtNovaPortaEntrada.setToolTipText("Nova Porta de entrada");
        jBtNovaPortaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaPortaEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
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
                .addComponent(jBtImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtNovaPortaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtSair)
                .addGap(33, 33, 33)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovo)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtCancelar))
                    .addComponent(jBtImprimir))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtSair))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoria))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtFinalizar))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtNovaPortaEntrada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Código:");

        jIdADM_Principal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_Principal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_Principal.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Data:");

        jDataAtendimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtendimento.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Status:");

        jStatusAtend.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAtend.setForeground(new java.awt.Color(255, 0, 51));
        jStatusAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAtend.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusAtend.setEnabled(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdADM_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStatusAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jIdADM_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jStatusAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jDataAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Admissão ");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jBtIndicacaoVisitas.setForeground(new java.awt.Color(153, 0, 0));
        jBtIndicacaoVisitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/user-group-forum-icone-3716-16.png"))); // NOI18N
        jBtIndicacaoVisitas.setText("Indicação Visitas");
        jBtIndicacaoVisitas.setEnabled(false);
        jBtIndicacaoVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIndicacaoVisitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtIndicacaoVisitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIndicacaoVisitas))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        jTabbedPane1.addTab("Admissão", jPanel3);

        jTabelaEvolucaoServicoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoServicoSocial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq.", "Data", "Evolução Serviço Social"
            }
        ));
        jTabelaEvolucaoServicoSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoServicoSocialMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEvolucaoServicoSocial);
        if (jTabelaEvolucaoServicoSocial.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(2).setMinWidth(560);
            jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(2).setMaxWidth(560);
        }

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jNomeInternoEvolServicoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolServicoSocial.setEnabled(false);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Código");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Nome Completo do Interno");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Data");

        jDataEvolu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolu.setEnabled(false);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoEvolServicoSocial))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99)
                    .addComponent(jDataEvolu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNomeInternoEvolServicoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDataEvolu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setText("Novo");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setText("Alterar");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setText("Excluir");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setText("Gravar");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setText("Cancelar");
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

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarEvolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaEvolucao)
                    .addComponent(jBtCancelarEvolucao)
                    .addComponent(jBtSalvarEvolucao)
                    .addComponent(jBtExcluirEvolucao)
                    .addComponent(jBtAlterarEvolucao)
                    .addComponent(jBtNovaEvolucao))
                .addGap(65, 65, 65))
        );

        jTextoEvolucao.setColumns(20);
        jTextoEvolucao.setRows(5);
        jTextoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucao.setEnabled(false);
        jScrollPane4.setViewportView(jTextoEvolucao);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Texto da Evolução");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Evolução", jPanel17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(220, 5, 691, 568);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoInternosServicoSocial);
        if (codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAdmissaoInternosServicoSocial) && codIncluirSS == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES")) {
            acao = 1;
            Novo();
            corCampo();
            verificarInternoRegistradoAdm();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoInternosServicoSocial);
        if (codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAdmissaoInternosServicoSocial) && codAlterarSS == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES")) {
            objAtendSocial.setStatusAtend(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampo();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoInternosServicoSocial);
        if (codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAdmissaoInternosServicoSocial) && codExcluirSS == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAtendSocial.setStatusAtend(jStatusAtend.getText());
            if (jStatusAtend.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser excluido, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o ATENDIMENTO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtendSocial.setIdAtend(Integer.parseInt(jIdADM_Principal.getText()));
                    control.excluirAtendSocial(objAtendSocial);
                    objAtendSocial.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                    controle.excluirMovTec(objAtendSocial);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoInternosServicoSocial);
        if (codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAdmissaoInternosServicoSocial) && codGravarSS == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES")) {
            verificarAdmissao();
            if (jDataAtendimento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do atendimento.");
                jDataAtendimento.requestFocus();
                jDataAtendimento.setBackground(Color.red);
            } else {
                if (jNomeInterno.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para realizar o atendimento.");
                } else {
                    if (jPeriodo.getText() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Informe uma data para o período");
                        jPeriodo.requestFocus();
                        jPeriodo.setBackground(Color.red);
                    } else {
                        verificarInternoRegistradoAdm();
                        objAtendSocial.setDataAtend(jDataAtendimento.getDate());
                        objAtendSocial.setStatusAtend(statusAtend);
                        // Aba Dados Familiares
                        objAtendSocial.setContatoAtend(JContato.getText());
                        objAtendSocial.setEnderecoAtend(jEnderecoContato.getText());
                        objAtendSocial.setBairroAtend(jBairroContato.getText());
                        objAtendSocial.setCidadeAtend(jCidadeContato.getText());
                        objAtendSocial.setEstadoAtend(jEstadoContato.getText());
                        objAtendSocial.setTelefoneAtend(jTelefone.getText());
                        objAtendSocial.setTelefone1Atend(jTelefone1.getText());
                        objAtendSocial.setCelualarAtend(jCelular.getText());
                        // Aba Dados do Atendimento
                        objAtendSocial.setCartTrabAtend((String) jComboBoxTrabalho.getSelectedItem());
                        objAtendSocial.setPeriodo(jPeriodo.getText());
                        objAtendSocial.setRecebeRecluAtend((String) jComboBoxAuxReclusao.getSelectedItem());
                        // 
                        objAtendSocial.setDireitoAuxAtend((String) jComboBoxDireitoReclusao.getSelectedItem());
                        //objAtendSocial.setRecebeBolAtend((String) jComboBoxBolsaFamilia.getSelectedItem());
                        //
                        objAtendSocial.setQtdPessoasAtend((String) jComboBoxPessoasCasa.getSelectedItem());
                        objAtendSocial.setQtdTrabaAtend(jQtsTrabalham.getText());
                        // Aba Dados Documentação
                        objAtendSocial.setCN1Atend((String) jComboBoxCN1.getSelectedItem());
                        objAtendSocial.setCN2Atend((String) jComboBoxCN2.getSelectedItem());
                        objAtendSocial.setRG1Atend((String) jComboBoxRG1.getSelectedItem());
                        objAtendSocial.setRG2atend((String) jComboBoxRG2.getSelectedItem());
                        objAtendSocial.setCPF1Atend((String) jComboBoxCPF1.getSelectedItem());
                        objAtendSocial.setCPF2Atend((String) jComboBoxCPF2.getSelectedItem());
                        objAtendSocial.setCTPS1Atend((String) jComboBoxCTPS1.getSelectedItem());
                        objAtendSocial.setCTPS2Atend((String) jComboBoxCTPS2.getSelectedItem());
                        // Aba Outros                
                        objAtendSocial.setPossuiFilhosAtend((String) jComboBoxPossuiFilhos.getSelectedItem());//
                        objAtendSocial.setQtdFilhosAtend(jQtdFilhos.getText());//
                        objAtendSocial.setFilhosNaoRegAtend(jTotalFilhos.getText());//
                        // 
                        objAtendSocial.setOutrosFilhosAtend((String) jComboBoxOutrosFilhos.getSelectedItem()); //
                        objAtendSocial.setQtdFilhos2Atend(jQtdFilhosRela.getText());//
                        objAtendSocial.setPaternidadeAtend(jPaternidade.getText());//

                        objAtendSocial.setDefensorAtend((String) jComboBoxDefensor.getSelectedItem());
                        //Aba Considerações
                        objAtendSocial.setConsiderAtend(jConsideracoes.getText());
                        objAtendSocial.setDeptoSocial(deptoTecnico);
                        // IMPLEMENTAÇÃO EM 07/07/2016
                        objAtendSocial.setMunicipioNascimento(jMunicipioNascimento.getText());
                        objAtendSocial.setTituloEleito1((String) jComboBoxTitulo1.getSelectedItem());
                        objAtendSocial.setTituloEleitor2((String) jComboBoxTitulo2.getSelectedItem());
                        objAtendSocial.setReservista1((String) jComboBoxReservista1.getSelectedItem());
                        objAtendSocial.setReservista2((String) jComboBoxReservista2.getSelectedItem());
                        objAtendSocial.setCartorioRegistro(jCartorioRegistro.getText());
                        objAtendSocial.setCondicaoSegurado((String) jComboBoxCondicaoSegurado.getSelectedItem());
                        objAtendSocial.setRecebeBeneficio((String) jComboBoxAuxilioDoenca.getSelectedItem());
                        objAtendSocial.setEsposaCompanheira((String) jComboBoxEsposaCompanheira.getSelectedItem());
                        objAtendSocial.setTempoConvivencia(jTipoConvivencia.getText());
                        objAtendSocial.setNomeEsposaConvivencia(jNomeCompanheira.getText());
                        objAtendSocial.setQtdPessoasResiCasa(jQtdPessoasResideCasa.getText());
                        objAtendSocial.setEncaminhaOutrosSetore((String) jComboBoxOutrosSetores.getSelectedItem());
                        objAtendSocial.setQualSetor(jQualSetor.getText());
                        objAtendSocial.setCancelarVisita((String) jComboBoxCancelVisita.getSelectedItem());
                        objAtendSocial.setMotivo(jMotivo.getText());
                        objAtendSocial.setEncaminhaTirarDoc((String) jComboBoxTirarDoc.getSelectedItem());
                        objAtendSocial.setDataEncaminharTiraDoc(jDataDoc.getDate());
                        objAtendSocial.setEncaminarReconhecerPaternidade((String) jComboBoxRecPater.getSelectedItem());
                        objAtendSocial.setDataEncaRecPaterna(jDataPater.getDate());
                        objAtendSocial.setRecebeVisita((String) jComboBoxRecebeVisita.getSelectedItem());
                        //                                                                                                                                                                                                                                                                                                         
                        if (acao == 1) {
                            if (jIDInterno.getText().equals(pCODIGO_INTERNO)) {
                                JOptionPane.showMessageDialog(rootPane, "Esse interno já fez admissão anteriormente nessa tela.");
                                int resposta = JOptionPane.showConfirmDialog(this, "Deseja cadastrar uma nova admissão na aba complementar?", "Confirmação",
                                        JOptionPane.YES_NO_OPTION);
                                if (resposta == JOptionPane.YES_OPTION) {
                                    pesquisarInternoExistente();
                                    mostrarPortaEntrada();
                                }
                            } else {
                                // Para o log do registro
                                objAtendSocial.setUsuarioInsert(nameUser);
                                objAtendSocial.setDataInsert(dataModFinal);
                                objAtendSocial.setHoraInsert(horaMov);
                                objAtendSocial.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                objAtendSocial.setNomeInterno(jNomeInterno.getText());
                                control.incluirAtendSocial(objAtendSocial);
                                buscarCodAtend();
                                objAtendSocial.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                                objAtendSocial.setNomeInterno(jNomeInterno.getText());
                                objAtendSocial.setDeptoSocial(deptoTecnico);
                                controle.incluirMovTec(objAtendSocial);
                                // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO    
                                atendido = "Sim";
                                objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                                objRegAtend.setIdDepartamento(codigoDepartamentoSS);
                                objRegAtend.setNomeDepartamento(nomeModuloSS);
                                objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                                objRegAtend.setAtendido(atendido);
                                objRegAtend.setDataAtendimento(jDataAtendimento.getDate());
                                objRegAtend.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                                objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                                //
                                objRegAtend.setUsuarioUp(nameUser);
                                objRegAtend.setDataUp(dataModFinal);
                                objRegAtend.setHorarioUp(horaMov);
                                controlRegAtend.alterarRegAtend(objRegAtend);
                                //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                                objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                                objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                                objRegAtend.setIdDepartamento(codigoDepartamentoSS);
                                objRegAtend.setNomeDepartamento(nomeModuloSERV);
                                objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                                objRegAtend.setHorarioUp(horaMov);
                                objRegAtend.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                                objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                                control_ATENDE.confirmarAtendimento(objRegAtend);
                                //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                                pHABILITA_SS = "Não";
                                objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                objPortaEntrada.setNomeInternoCrc(jNomeInterno.getText());
                                objPortaEntrada.setHabSso(pHABILITA_SS);
                                control_PE.alterarPortaEntradaSocial(objPortaEntrada);
                                //GRAVAR UMA EVOLUÇÃO REFERENTE A ADMISSÃO (13/05/2020)
                                objEvol.setDataEvol(jDataAtendimento.getDate());
                                objEvol.setTextoEvolucao(jConsideracoes.getText());
                                objEvol.setStatusLanc(statusEvolucao);
                                // log de usuario
                                objEvol.setUsuarioInsert(nameUser);
                                objEvol.setDataInsert(dataModFinal);
                                objEvol.setHorarioInsert(horaMov);
                                objEvol.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                objEvol.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                                objEvol.setAdmEvo(admEvolucao);
                                controleEvol.incluirEvolucaoServicoSocial(objEvol);
                                buscarEvolucao();
                                preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                                        + "WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
                                objLog();
                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                JOptionPane.showMessageDialog(rootPane, "Atendimento gravado com sucesso.\nCaso já tenha concluido o atendimento,\nclique no botão finalizar para evitar que\n o mesmo seja alterado ou excluido.");
                                Salvar();
                            }
                        }
                        if (acao == 2) {
                            // Para o log do registro
                            objAtendSocial.setUsuarioUp(nameUser);
                            objAtendSocial.setDataUp(jDataSistema.getText());
                            objAtendSocial.setHoraUp(jHoraSistema.getText());
                            objAtendSocial.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                            objAtendSocial.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                            objAtendSocial.setNomeInterno(jNomeInterno.getText());
                            control.alterarAtendSocial(objAtendSocial);
                            objAtendSocial.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                            objAtendSocial.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                            objAtendSocial.setNomeInterno(jNomeInterno.getText());
                            objAtendSocial.setDeptoSocial(deptoTecnico);
                            controle.alterarMovTec(objAtendSocial);
                            //ALTERAR EVOLUÇÃO
                            objEvol.setDataEvol(jDataAtendimento.getDate());
                            objEvol.setTextoEvolucao(jConsideracoes.getText());
                            objEvol.setStatusLanc(statusEvolucao);
                            //
                            objEvol.setUsuarioUp(nameUser);
                            objEvol.setDataUp(dataModFinal);
                            objEvol.setHorarioUp(horaMov);
                            objEvol.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                            objEvol.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                            objEvol.setAdmEvo(admEvolucao);
                            controleEvol.alterarEvolucaoServicoSocialADM(objEvol);
                            preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                                    + "WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Atendimento gravado com sucesso.\nCaso já tenha concluido o atendimento,\nclique no botão finalizar para evitar que\n o mesmo seja alterado ou excluido.");
                            Salvar();
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirActionPerformed
        // TODO add your handling code here:
        Relatorio();
    }//GEN-LAST:event_jBtImprimirActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        verificarRegistroBiometria();
        if (pHabilitaSSocial.equals("Não")) {
            TelaPesqInternoAtendSocial objAtendS = new TelaPesqInternoAtendSocial();
            TelaModuloServicoSocial.jPainelServicoSocial.add(objAtendS);
            objAtendS.show();
        } else {
            TelaPesqInternoAtendSocialBio objAtendSBio = new TelaPesqInternoAtendSocialBio();
            TelaModuloServicoSocial.jPainelServicoSocial.add(objAtendSBio);
            objAtendSBio.show();
        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa do Atendimento.");
            jPesqNomeInterno.requestFocus();
        } else {
            preencherAtendInterno("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
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
                        preencherAtendInterno("SELECT * FROM ATENDIMENTOSOCIAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                + "WHERE DataAtend BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
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
                        preencherAtendInterno("SELECT * FROM ATENDIMENTOSOCIAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                + "WHERE DataAtend BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jTabelaAtendimentoSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtendimentoSocialMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaAtendimentoSocial.getValueAt(jTabelaAtendimentoSocial.getSelectedRow(), 0);
            jIDPesqAtend.setText(idAtend);
            //jDataRol.setDate(jDataRol.getDate());
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtIndicacaoVisitas.setEnabled(true);
            //
            bloquearCamposPesquisa();
            jBtNovaEvolucao.setEnabled(true);
            jIdEvolucao.setText("");
            jNomeInternoEvolServicoSocial.setText("");
            jTextoEvolucao.setText("");
            jDataEvolu.setDate(null);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "WHERE IdAtend='" + idAtend + "'");
                conecta.rs.first();
                jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdAtend")));
                jDataAtendimento.setDate(conecta.rs.getDate("DataAtend"));
                jStatusAtend.setText(conecta.rs.getString("StatusAtend"));
                jIDInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conecta.rs.getString("PaiInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoInterno.setIcon(i);
                    FotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInterno.getWidth(), FotoInterno.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInterno.getWidth(), FotoInterno.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInterno.setIcon(icon);
                }
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jEstadoCivil.setText(conecta.rs.getString("EstadoCivilCrc"));
                jProfissao.setText(conecta.rs.getString("ProfissaoCrc"));
                jReligiao.setText(conecta.rs.getString("ReligiaoCrc"));
                jNaturalidade.setText(conecta.rs.getString("NomeCidade"));
                jEscolaridade.setText(conecta.rs.getString("EscolaridadeCrc"));
                //
                JContato.setText(conecta.rs.getString("ContatoAtend"));
                jTelefone.setText(conecta.rs.getString("TelefoneAtend"));
                jTelefone1.setText(conecta.rs.getString("Telefone1Atend"));
                jCelular.setText(conecta.rs.getString("CelularAtend"));
                jEnderecoContato.setText(conecta.rs.getString("EnderecoAtend"));
                jBairroContato.setText(conecta.rs.getString("BairroAtend"));
                jCidadeContato.setText(conecta.rs.getString("CidadeAtend"));
                jEstadoContato.setText(conecta.rs.getString("EstadoAtend"));
                //
                jComboBoxTrabalho.setSelectedItem(conecta.rs.getString("CartTrabAtend"));
                jPeriodo.setText(conecta.rs.getString("Periodo"));
                jComboBoxDireitoReclusao.setSelectedItem(conecta.rs.getString("RecebeRecluAtend"));
                jComboBoxAuxReclusao.setSelectedItem(conecta.rs.getString("DireitoAuxAtend"));
                jComboBoxPessoasCasa.setSelectedItem(conecta.rs.getString("QtdPessoasAtend"));
                jQtsTrabalham.setText(conecta.rs.getString("QtdTrabaAtend"));
                //
                jComboBoxCN1.setSelectedItem(conecta.rs.getString("CN1Atend"));
                jComboBoxCN2.setSelectedItem(conecta.rs.getString("CN2Atend"));
                jComboBoxRG1.setSelectedItem(conecta.rs.getString("RG1Atend"));
                jComboBoxRG2.setSelectedItem(conecta.rs.getString("RG2Atend"));
                jComboBoxCPF1.setSelectedItem(conecta.rs.getString("CPF1Atend"));
                jComboBoxCPF2.setSelectedItem(conecta.rs.getString("CPF2Atend"));
                jComboBoxCTPS1.setSelectedItem(conecta.rs.getString("CTPS1Atend"));
                jComboBoxCTPS2.setSelectedItem(conecta.rs.getString("CTPS2Atend"));
                //
                jComboBoxPossuiFilhos.setSelectedItem(conecta.rs.getString("PossuiFilhosAtend"));
                jQtdFilhos.setText(conecta.rs.getString("QtdFilhosAtend"));
                jTotalFilhos.setText(conecta.rs.getString("FilhosNaoRegAtend"));
                jComboBoxOutrosFilhos.setSelectedItem(conecta.rs.getString("OutrosFilhosAtend"));
                jQtdFilhosRela.setText(conecta.rs.getString("QtdFilhos2Atend"));
                jPaternidade.setText(conecta.rs.getString("PaternidadeAtend"));
                jComboBoxDefensor.setSelectedItem(conecta.rs.getString("DefensorAtend"));
                //
                jConsideracoes.setText(conecta.rs.getString("ConsiderAtend"));
                // IMPLEMENTAÇÃO EM 07/07/2016
                jMunicipioNascimento.setText(conecta.rs.getString("MunicipioNascimento"));
                jComboBoxTitulo1.setSelectedItem(conecta.rs.getString("Tituloeleito1"));
                jComboBoxTitulo2.setSelectedItem(conecta.rs.getString("Tituloeleito2"));
                jComboBoxReservista1.setSelectedItem(conecta.rs.getString("Reservista1"));
                jComboBoxReservista2.setSelectedItem(conecta.rs.getString("Reservista2"));
                jCartorioRegistro.setText(conecta.rs.getString("CartorioRegistro"));
                jComboBoxCondicaoSegurado.setSelectedItem(conecta.rs.getString("CondicaoSegurado"));
                jComboBoxAuxilioDoenca.setSelectedItem(conecta.rs.getString("RecebeBeneficio"));
                jComboBoxEsposaCompanheira.setSelectedItem(conecta.rs.getString("EsposoCompanheiro"));
                jTipoConvivencia.setText(conecta.rs.getString("TempoConvivencia"));
                jNomeCompanheira.setText(conecta.rs.getString("NomeEsposoCompanheiro"));
                jQtdPessoasResideCasa.setText(conecta.rs.getString("PessoasResideCasa"));
                jComboBoxOutrosSetores.setSelectedItem(conecta.rs.getString("EncaOutroSetor"));
                jQualSetor.setText(conecta.rs.getString("QualSetor"));
                jComboBoxCancelVisita.setSelectedItem(conecta.rs.getString("CancelarVisita"));
                jMotivo.setText(conecta.rs.getString("MotivoCancelarVisita"));
                jComboBoxTirarDoc.setSelectedItem(conecta.rs.getString("EncaTirarDoc"));
                jDataDoc.setDate(conecta.rs.getDate("DataEncaDoc"));
                jComboBoxRecPater.setSelectedItem(conecta.rs.getString("EncaRecPaternidade"));
                jDataPater.setDate(conecta.rs.getDate("DataRecPaternidade"));
                jComboBoxRecebeVisita.setSelectedItem(conecta.rs.getString("RecebeVisita"));
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
            preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                    + "WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaAtendimentoSocialMouseClicked

    private void jBtAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtendActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqAtend.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código para pesquisa.");
            jIDPesqAtend.requestFocus();
        } else {
            preencherAtendInterno("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE IdAtend='" + jIDPesqAtend.getText() + "'");
        }
    }//GEN-LAST:event_jBtAtendActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusAtend = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse atendimento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o ATENDIMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAtendSocial.setStatusAtend(statusAtend);
            objAtendSocial.setIdAtend(Integer.parseInt(jIdADM_Principal.getText()));
            control.finalizarAtendSocial(objAtendSocial);
            objAtendSocial.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
            controle.finalizarMovTec(objAtendSocial);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusAtend.setText(statusAtend);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodosAtend("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc");
        } else {
            limparTabelaAtendimentoSocial();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAtendimentoSocial objAudSerSo = new TelaAuditoriaAtendimentoSocial();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudSerSo);
        objAudSerSo.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here: telaEvolucaoServicoSocial
        buscarAcessoUsuario(telaEvolucaoServicoSocial);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaEvolucaoServicoSocial) && codIncluirSS == 1) {
            verificarInternoRegistradoAdm();
            if (atendido == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Não")) {
                acao = 3;
                NovaEvolucao();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEvolucaoServicoSocial);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaEvolucaoServicoSocial) && codAlterarSS == 1) {
            verificarEvolucaoAdmissao();
            if (admEvolucao == null) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                            + "WHERE IdItem='" + jIdEvolucao.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 4;
                    AlterarEvolucao();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("")) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                            + "WHERE IdItem='" + jIdEvolucao.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 4;
                    AlterarEvolucao();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Essa evolução não poderá ser alterada nessa tela, será necessário alterar na admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEvolucaoServicoSocial);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaEvolucaoServicoSocial) && codExcluirSS == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a evolução selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEvol.setIdAtend(Integer.parseInt(jIdADM_Principal.getText()));
                controleEvol.excluirEvolucaoServicoSocial(objEvol);
                objEvol.setIdAtend(Integer.parseInt(jIdADM_Principal.getText()));
                objEvol.setIdItem(idItemEvol);
                controlMovEvolSSocial.excluirMovServicoSocial(objEvol);
                objLog1();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                ExcluirEvolucao();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEvolucaoServicoSocial);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaEvolucaoServicoSocial) && codGravarSS == 1) {
            if (jDataEvolu.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da evolução do interno.");
                jDataEvolu.requestFocus();
                jDataEvolu.setBackground(Color.red);
            } else if (jTextoEvolucao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não existe texto para evolução.");
            } else {
                objEvol.setDataEvol(jDataEvolu.getDate());
                objEvol.setTextoEvolucao(jTextoEvolucao.getText());
                objEvol.setStatusLanc(statusEvolucao);
                if (acao == 3) {
                    // log de usuario
                    objEvol.setUsuarioInsert(nameUser);
                    objEvol.setDataInsert(dataModFinal);
                    objEvol.setHorarioInsert(horaMov);
                    objEvol.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objEvol.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                    controleEvol.incluirEvolucaoServicoSocial(objEvol);
                    //
                    buscarEvolucao();
                    objEvol.setDeptoMedico(deptoTecnico);
                    objEvol.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objEvol.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                    objEvol.setNomeInterno(jNomeInternoEvolServicoSocial.getText());
                    controlMovEvolSSocial.incluirMovServicoSocial(objEvol); // Histórico de Movimento Técnico
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoSS);
                    objRegAtend.setNomeDepartamento(nomeModuloSS);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataEvolu.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                    objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucao.getText()));
                    objRegAtend.setAtendeEvol(atendido);
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegEvol(objRegAtend);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInterno.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoSS);
                    objRegAtend.setNomeDepartamento(nomeModuloSERV);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdEvolucao.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                            + "WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarEvolucao();
                }
                if (acao == 4) {
                    // log de usuario
                    objEvol.setUsuarioUp(nameUser);
                    objEvol.setDataUp(dataModFinal);
                    objEvol.setHorarioUp(horaMov);
                    objEvol.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                    objEvol.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objEvol.setIdItem(idItemEvol);
                    controleEvol.alterarEvolucaoServicoSocial(objEvol);
                    //
                    objEvol.setDeptoMedico(deptoTecnico);
                    objEvol.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                    objEvol.setIdAtend(Integer.valueOf(jIdADM_Principal.getText()));
                    objEvol.setIdItem(idItemEvol);
                    objEvol.setNomeInterno(jNomeInternoEvolServicoSocial.getText());
                    controlMovEvolSSocial.alterarMovServicoSocial(objEvol);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                            + "WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarEvolucao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoServicoSocial objAudiEvolSS = new TelaAuditoriaEvolucaoServicoSocial();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objAudiEvolSS);
        objAudiEvolSS.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaEvolucaoServicoSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoServicoSocialMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idItem = "" + jTabelaEvolucaoServicoSocial.getValueAt(jTabelaEvolucaoServicoSocial.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovaEvolucao.setEnabled(!true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL WHERE IdAtend='" + jIdADM_Principal.getText() + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdEvolucao.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemEvol = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeInternoEvolServicoSocial.setText(jNomeInterno.getText());
                jDataEvolu.setDate(conecta.rs.getDate("DataEvol"));
                jTextoEvolucao.setText(conecta.rs.getString("TextoEvolucao"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoServicoSocialMouseClicked

    private void jBtPesqDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDepartamentoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaDeptoAtendimento objDepto = new TelaPesquisaDeptoAtendimento();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objDepto);
        objDepto.show();
    }//GEN-LAST:event_jBtPesqDepartamentoActionPerformed

    private void jBtIndicacaoVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIndicacaoVisitasActionPerformed
        // TODO add your handling code here:
        if (jIdADM_Principal.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Antes de fazer a indicação das visitas, será necessário gravar o atendimento antes.");
        } else {
            mostrarTelaIdicacaoVisitas();
        }
    }//GEN-LAST:event_jBtIndicacaoVisitasActionPerformed

    private void jBtNovaPortaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaPortaEntradaActionPerformed
        // TODO add your handling code here:
        if (jIdADM_Principal.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Antes de fazer a indicação das visitas, será necessário gravar o atendimento antes.");
        } else {
            mostrarPortaEntrada();
        }
    }//GEN-LAST:event_jBtNovaPortaEntradaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Consideracoes;
    private javax.swing.JPanel ContatoFamiliar;
    private javax.swing.JPanel DadosAtendimento;
    private javax.swing.JPanel Documentos;
    public static javax.swing.JLabel FotoInterno;
    private javax.swing.JTextField JContato;
    private javax.swing.JPanel Outros;
    private javax.swing.JTextField jBairroContato;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAtend;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImprimir;
    private javax.swing.JButton jBtIndicacaoVisitas;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovaPortaEntrada;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqDepartamento;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JTextField jCartorioRegistro;
    private javax.swing.JFormattedTextField jCelular;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jCidadeContato;
    private javax.swing.JComboBox jComboBoxAuxReclusao;
    private javax.swing.JComboBox jComboBoxAuxilioDoenca;
    private javax.swing.JComboBox jComboBoxCN1;
    private javax.swing.JComboBox jComboBoxCN2;
    private javax.swing.JComboBox jComboBoxCPF1;
    private javax.swing.JComboBox jComboBoxCPF2;
    private javax.swing.JComboBox jComboBoxCTPS1;
    private javax.swing.JComboBox jComboBoxCTPS2;
    private javax.swing.JComboBox jComboBoxCancelVisita;
    private javax.swing.JComboBox jComboBoxCondicaoSegurado;
    private javax.swing.JComboBox jComboBoxDefensor;
    private javax.swing.JComboBox jComboBoxDireitoReclusao;
    private javax.swing.JComboBox jComboBoxEsposaCompanheira;
    private javax.swing.JComboBox jComboBoxOutrosFilhos;
    private javax.swing.JComboBox jComboBoxOutrosSetores;
    private javax.swing.JComboBox jComboBoxPessoasCasa;
    private javax.swing.JComboBox jComboBoxPossuiFilhos;
    private javax.swing.JComboBox jComboBoxRG1;
    private javax.swing.JComboBox jComboBoxRG2;
    private javax.swing.JComboBox jComboBoxRecPater;
    private javax.swing.JComboBox jComboBoxRecebeVisita;
    private javax.swing.JComboBox jComboBoxReservista1;
    private javax.swing.JComboBox jComboBoxReservista2;
    private javax.swing.JComboBox jComboBoxTirarDoc;
    private javax.swing.JComboBox jComboBoxTitulo1;
    private javax.swing.JComboBox jComboBoxTitulo2;
    private javax.swing.JComboBox jComboBoxTrabalho;
    private javax.swing.JTextArea jConsideracoes;
    private com.toedter.calendar.JDateChooser jDataAtendimento;
    private com.toedter.calendar.JDateChooser jDataDoc;
    private com.toedter.calendar.JDateChooser jDataEvolu;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    public static com.toedter.calendar.JDateChooser jDataNascimento;
    private com.toedter.calendar.JDateChooser jDataPater;
    private javax.swing.JTextField jEnderecoContato;
    public static javax.swing.JTextField jEscolaridade;
    public static javax.swing.JTextField jEstadoCivil;
    private javax.swing.JTextField jEstadoContato;
    public static javax.swing.JTextField jIDInterno;
    private javax.swing.JTextField jIDPesqAtend;
    public static javax.swing.JTextField jIdADM_Principal;
    public static javax.swing.JTextField jIdEvolucao;
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
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    public static javax.swing.JTextField jMaeInterno;
    private javax.swing.JTextField jMotivo;
    private javax.swing.JTextField jMunicipioNascimento;
    public static javax.swing.JTextField jNaturalidade;
    private javax.swing.JTextField jNomeCompanheira;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jNomeInternoEvolServicoSocial;
    public static javax.swing.JTextField jPaiInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jPaternidade;
    private javax.swing.JTextField jPeriodo;
    private javax.swing.JTextField jPesqNomeInterno;
    public static javax.swing.JTextField jProfissao;
    private javax.swing.JTextField jQtdFilhos;
    private javax.swing.JTextField jQtdFilhosRela;
    private javax.swing.JTextField jQtdPessoasResideCasa;
    private javax.swing.JTextField jQtsTrabalham;
    public static javax.swing.JTextField jQualSetor;
    public static javax.swing.JTextField jReligiao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTextField jStatusAtend;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAtendimentoSocial;
    public static javax.swing.JTable jTabelaEvolucaoServicoSocial;
    private javax.swing.JFormattedTextField jTelefone;
    private javax.swing.JFormattedTextField jTelefone1;
    private javax.swing.JTextArea jTextoEvolucao;
    private javax.swing.JTextField jTipoConvivencia;
    private javax.swing.JTextField jTotalFilhos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void bloquearCamposPesquisa() {
        //
        jDataAtendimento.setEnabled(!true);
        JContato.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jEnderecoContato.setEnabled(!true);
        jBairroContato.setEnabled(!true);
        jCidadeContato.setEnabled(!true);
        jEstadoContato.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jPeriodo.setEnabled(!true);
        jComboBoxAuxReclusao.setEnabled(!true);
        jComboBoxDireitoReclusao.setEnabled(!true);
        jComboBoxPessoasCasa.setEnabled(!true);
        jQtsTrabalham.setEnabled(!true);
        //
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        //
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        //
        jConsideracoes.setEnabled(!true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(!true);
        jComboBoxTitulo1.setEnabled(!true);
        jComboBoxTitulo2.setEnabled(!true);
        jComboBoxReservista1.setEnabled(!true);
        jComboBoxReservista2.setEnabled(!true);
        jCartorioRegistro.setEnabled(!true);
        jComboBoxCondicaoSegurado.setEnabled(!true);
        jComboBoxAuxilioDoenca.setEnabled(!true);
        jComboBoxEsposaCompanheira.setEnabled(!true);
        jTipoConvivencia.setEnabled(!true);
        jNomeCompanheira.setEnabled(!true);
        jQtdPessoasResideCasa.setEnabled(!true);
        jComboBoxOutrosSetores.setEnabled(!true);
        jQualSetor.setEnabled(!true);
        jComboBoxCancelVisita.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jComboBoxTirarDoc.setEnabled(!true);
        jDataDoc.setEnabled(!true);
        jComboBoxRecPater.setEnabled(!true);
        jDataPater.setEnabled(!true);
        jComboBoxRecebeVisita.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtPesqInterno.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtIndicacaoVisitas.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void formatCampos() {

        JContato.setDocument(new LimiteDigitosAlfa(80));
        jEnderecoContato.setDocument(new LimiteDigitosAlfa(80));
        jCidadeContato.setDocument(new LimiteDigitosAlfa(80));
        jBairroContato.setDocument(new LimiteDigitosAlfa(50));
        jEstadoContato.setDocument(new LimiteDigitosAlfa(50));
        jQtsTrabalham.setDocument(new LimiteDigitosNum(4));
        jQtdFilhos.setDocument(new LimiteDigitosNum(4));
        jTotalFilhos.setDocument(new LimiteDigitosNum(4));
        jQtdFilhosRela.setDocument(new LimiteDigitosNum(4));
        jPaternidade.setDocument(new LimiteDigitosNum(4));
        jPeriodo.setDocument(new LimiteDigitosAlfa(25));
        //
        jMunicipioNascimento.setDocument(new LimiteDigitosAlfa(100));
        jCartorioRegistro.setDocument(new LimiteDigitosAlfa(80));
        jTipoConvivencia.setDocument(new LimiteDigitosAlfa(10));
        jNomeCompanheira.setDocument(new LimiteDigitosAlfa(60));
        jQtdPessoasResideCasa.setDocument(new LimiteDigitosNum(4));
        jQualSetor.setDocument(new LimiteDigitosAlfa(40));
        jMotivo.setDocument(new LimiteDigitosAlfa(50));
        //
        try {
            MaskFormatter telefone = new MaskFormatter("(###)-####-####");
            jTelefone.setFormatterFactory(new DefaultFormatterFactory(telefone));
            MaskFormatter telefoneEnd = new MaskFormatter("(###)-####-####");
            jTelefone1.setFormatterFactory(new DefaultFormatterFactory(telefoneEnd));
            MaskFormatter celularEnd = new MaskFormatter("(###)-####-####");
            jCelular.setFormatterFactory(new DefaultFormatterFactory(celularEnd));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel formatar os campos telefones.");
        }
        jConsideracoes.setLineWrap(true);
        jConsideracoes.setWrapStyleWord(true);
        //
        jTextoEvolucao.setLineWrap(true);
        jTextoEvolucao.setWrapStyleWord(true);
    }

    public void corCampo() {

        jIdADM_Principal.setBackground(Color.white);
        jDataAtendimento.setBackground(Color.white);
        jStatusAtend.setBackground(Color.white);
        jIDInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jMaeInterno.setBackground(Color.white);
        jPaiInterno.setBackground(Color.white);
        jEstadoCivil.setBackground(Color.white);
        jDataNascimento.setBackground(Color.white);
        jReligiao.setBackground(Color.white);
        jProfissao.setBackground(Color.white);
        jNaturalidade.setBackground(Color.white);
        jEscolaridade.setBackground(Color.white);
        //
        JContato.setBackground(Color.white);
        jTelefone.setBackground(Color.white);
        jTelefone1.setBackground(Color.white);
        jCelular.setBackground(Color.white);
        jEnderecoContato.setBackground(Color.white);
        jBairroContato.setBackground(Color.white);
        jCidadeContato.setBackground(Color.white);
        jEstadoContato.setBackground(Color.white);
        jComboBoxTrabalho.setBackground(Color.white);
        jPeriodo.setBackground(Color.white);
        jComboBoxAuxReclusao.setBackground(Color.white);
        jComboBoxDireitoReclusao.setBackground(Color.white);
        jComboBoxPessoasCasa.setBackground(Color.white);
        jQtsTrabalham.setBackground(Color.white);
        //
        jComboBoxCN1.setBackground(Color.white);
        jComboBoxCN2.setBackground(Color.white);
        jComboBoxRG1.setBackground(Color.white);
        jComboBoxRG2.setBackground(Color.white);
        jComboBoxCPF1.setBackground(Color.white);
        jComboBoxCPF2.setBackground(Color.white);
        jComboBoxCTPS1.setBackground(Color.white);
        jComboBoxCTPS2.setBackground(Color.white);
        //
        jComboBoxPossuiFilhos.setBackground(Color.white);
        jQtdFilhos.setBackground(Color.white);
        jTotalFilhos.setBackground(Color.white);
        jComboBoxOutrosFilhos.setBackground(Color.white);
        jQtdFilhosRela.setBackground(Color.white);
        jPaternidade.setBackground(Color.white);
        jComboBoxDefensor.setBackground(Color.white);
        //  jComboBoxPartFamilia.setBackground(Color.white);
        //
        jConsideracoes.setBackground(Color.white);
        //
        jIdEvolucao.setBackground(Color.white);
        jNomeInternoEvolServicoSocial.setBackground(Color.white);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setBackground(Color.white);
        jComboBoxTitulo1.setBackground(Color.white);
        jComboBoxTitulo2.setBackground(Color.white);
        jComboBoxReservista1.setBackground(Color.white);
        jComboBoxReservista2.setBackground(Color.white);
        jCartorioRegistro.setBackground(Color.white);
        jComboBoxCondicaoSegurado.setBackground(Color.white);
        jComboBoxAuxilioDoenca.setBackground(Color.white);
        jComboBoxEsposaCompanheira.setBackground(Color.white);
        jTipoConvivencia.setBackground(Color.white);
        jNomeCompanheira.setBackground(Color.white);
        jQtdPessoasResideCasa.setBackground(Color.white);
        jComboBoxOutrosSetores.setBackground(Color.white);
        jQualSetor.setBackground(Color.white);
        jComboBoxCancelVisita.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
        jComboBoxTirarDoc.setBackground(Color.white);
        jDataDoc.setBackground(Color.white);
        jComboBoxRecPater.setBackground(Color.white);
        jDataPater.setBackground(Color.white);
        jComboBoxRecebeVisita.setBackground(Color.white);
    }

    public void verificarAdmissao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            pCODIGO_INTERNO = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Novo() {
        //Limpar campos
        jIdADM_Principal.setText("");
        jDataAtendimento.setCalendar(Calendar.getInstance());
        jStatusAtend.setText("ABERTO");
        jIDInterno.setText("");
        jNomeInterno.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jEstadoCivil.setText("");
        jDataNascimento.setDate(null);
        jReligiao.setText("");
        jProfissao.setText("");
        FotoInterno.setIcon(null);
        jNaturalidade.setText("");
        jEscolaridade.setText("");
        //
        JContato.setText("");
        jTelefone.setText("");
        jTelefone1.setText("");
        jCelular.setText("");
        jEnderecoContato.setText("");
        jBairroContato.setText("");
        jCidadeContato.setText("");
        jEstadoContato.setText("");
        jPeriodo.setText("");
        jComboBoxPessoasCasa.setSelectedItem("Não");
        jQtsTrabalham.setText("0");
        //
        jQtdFilhos.setText("0");
        jTotalFilhos.setText("0");
        jQtdFilhosRela.setText("0");
        jPaternidade.setText("0");
        //
        jConsideracoes.setText("[DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...]");
        // Habilitar/Desabilitar botões
        jBtPesqInterno.setEnabled(true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtIndicacaoVisitas.setEnabled(!true);
        //        
        jDataAtendimento.setEnabled(true);
        //
        JContato.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefone1.setEnabled(true);
        jCelular.setEnabled(true);
        jEnderecoContato.setEnabled(true);
        jBairroContato.setEnabled(true);
        jCidadeContato.setEnabled(true);
        jEstadoContato.setEnabled(true);
        jComboBoxTrabalho.setEnabled(true);
        jPeriodo.setEnabled(true);
        jComboBoxAuxReclusao.setEnabled(true);
        jComboBoxDireitoReclusao.setEnabled(true);
        jComboBoxPessoasCasa.setEnabled(true);
        jQtsTrabalham.setEnabled(true);
        //
        jComboBoxCN1.setEnabled(true);
        jComboBoxCN2.setEnabled(true);
        jComboBoxRG1.setEnabled(true);
        jComboBoxRG2.setEnabled(true);
        jComboBoxCPF1.setEnabled(true);
        jComboBoxCPF2.setEnabled(true);
        jComboBoxCTPS1.setEnabled(true);
        jComboBoxCTPS2.setEnabled(true);
        //      
        jComboBoxTrabalho.setSelectedItem("Não");
        jComboBoxAuxReclusao.setSelectedItem("Não");
        jComboBoxDireitoReclusao.setSelectedItem("Não");
        jComboBoxCN1.setSelectedItem("Não");
        jComboBoxCN2.setSelectedItem("Não");
        jComboBoxRG1.setSelectedItem("Não");
        jComboBoxRG2.setSelectedItem("Não");
        jComboBoxCPF1.setSelectedItem("Não");
        jComboBoxCPF2.setSelectedItem("Não");
        jComboBoxCTPS1.setSelectedItem("Não");
        jComboBoxCTPS2.setSelectedItem("Não");
        jComboBoxPossuiFilhos.setSelectedItem("Não");
        jComboBoxOutrosFilhos.setSelectedItem("Não");
        jComboBoxDefensor.setSelectedItem("Não");
        //
        jComboBoxPossuiFilhos.setEnabled(true);
        jQtdFilhos.setEnabled(true);
        jTotalFilhos.setEnabled(true);
        jComboBoxOutrosFilhos.setEnabled(true);
        jQtdFilhosRela.setEnabled(true);
        jPaternidade.setEnabled(true);
        jComboBoxDefensor.setEnabled(true);
        //
        jConsideracoes.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        limparTabelaEvolucao();
        jIdEvolucao.setText("");
        jNomeInternoEvolServicoSocial.setText("");
        jTextoEvolucao.setText("");
        jDataEvolu.setDate(null);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(true);
        jComboBoxTitulo1.setEnabled(true);
        jComboBoxTitulo2.setEnabled(true);
        jComboBoxReservista1.setEnabled(true);
        jComboBoxReservista2.setEnabled(true);
        jCartorioRegistro.setEnabled(true);
        jComboBoxCondicaoSegurado.setEnabled(true);
        jComboBoxAuxilioDoenca.setEnabled(true);
        jComboBoxEsposaCompanheira.setEnabled(true);
        jTipoConvivencia.setEnabled(true);
        jNomeCompanheira.setEnabled(true);
        jQtdPessoasResideCasa.setEnabled(true);
        jComboBoxOutrosSetores.setEnabled(true);
        jQualSetor.setEnabled(true);
        jComboBoxCancelVisita.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxTirarDoc.setEnabled(true);
        jDataDoc.setEnabled(true);
        jComboBoxRecPater.setEnabled(true);
        jDataPater.setEnabled(true);
        jComboBoxRecebeVisita.setEnabled(true);
        jBtPesqDepartamento.setEnabled(true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setText("");
        jComboBoxTitulo1.setSelectedItem("Não");
        jComboBoxTitulo2.setSelectedItem("Não");
        jComboBoxReservista1.setSelectedItem("Não");
        jComboBoxReservista2.setSelectedItem("Não");
        jCartorioRegistro.setText("");
        jComboBoxCondicaoSegurado.setSelectedItem("Não");
        jComboBoxAuxilioDoenca.setSelectedItem("Não");
        jComboBoxEsposaCompanheira.setSelectedItem("Não");
        jTipoConvivencia.setText("");
        jNomeCompanheira.setText("");
        jQtdPessoasResideCasa.setText("");
        jComboBoxOutrosSetores.setSelectedItem("Não");
        jQualSetor.setText("");
        jComboBoxCancelVisita.setSelectedItem("Não");
        jMotivo.setText("");
        jComboBoxTirarDoc.setSelectedItem("Não");
        jDataDoc.setDate(null);
        jComboBoxRecPater.setSelectedItem("Não");
        jDataPater.setDate(null);
        jComboBoxRecebeVisita.setSelectedItem("Não");
    }

    public void Alterar() {

        // Habilitar/Desabilitar botões
        jBtPesqInterno.setEnabled(true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtIndicacaoVisitas.setEnabled(true);

        //
        jDataAtendimento.setEnabled(true);
        //
        JContato.setEnabled(true);
        jTelefone.setEnabled(true);
        jTelefone1.setEnabled(true);
        jCelular.setEnabled(true);
        jEnderecoContato.setEnabled(true);
        jBairroContato.setEnabled(true);
        jCidadeContato.setEnabled(true);
        jEstadoContato.setEnabled(true);
        jComboBoxTrabalho.setEnabled(true);
        jPeriodo.setEnabled(true);
        jComboBoxAuxReclusao.setEnabled(true);
        jComboBoxDireitoReclusao.setEnabled(true);
        jComboBoxPessoasCasa.setEnabled(true);
        jQtsTrabalham.setEnabled(true);
        //
        jComboBoxCN1.setEnabled(true);
        jComboBoxCN2.setEnabled(true);
        jComboBoxRG1.setEnabled(true);
        jComboBoxRG2.setEnabled(true);
        jComboBoxCPF1.setEnabled(true);
        jComboBoxCPF2.setEnabled(true);
        jComboBoxCTPS1.setEnabled(true);
        jComboBoxCTPS2.setEnabled(true);
        //
        jComboBoxPossuiFilhos.setEnabled(true);
        jQtdFilhos.setEnabled(true);
        jTotalFilhos.setEnabled(true);
        jComboBoxOutrosFilhos.setEnabled(true);
        jQtdFilhosRela.setEnabled(true);
        jPaternidade.setEnabled(true);
        jComboBoxDefensor.setEnabled(true);
        //
        jConsideracoes.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(true);
        jComboBoxTitulo1.setEnabled(true);
        jComboBoxTitulo2.setEnabled(true);
        jComboBoxReservista1.setEnabled(true);
        jComboBoxReservista2.setEnabled(true);
        jCartorioRegistro.setEnabled(true);
        jComboBoxCondicaoSegurado.setEnabled(true);
        jComboBoxAuxilioDoenca.setEnabled(true);
        jComboBoxEsposaCompanheira.setEnabled(true);
        jTipoConvivencia.setEnabled(true);
        jNomeCompanheira.setEnabled(true);
        jQtdPessoasResideCasa.setEnabled(true);
        jComboBoxOutrosSetores.setEnabled(true);
        jQualSetor.setEnabled(true);
        jComboBoxCancelVisita.setEnabled(true);
        jMotivo.setEnabled(true);
        jComboBoxTirarDoc.setEnabled(true);
        jDataDoc.setEnabled(true);
        jComboBoxRecPater.setEnabled(true);
        jDataPater.setEnabled(true);
        jComboBoxRecebeVisita.setEnabled(true);
        jBtPesqDepartamento.setEnabled(true);
    }

    public void Excluir() {

        // Habilitar/Desabilitar botões
        jBtPesqInterno.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtIndicacaoVisitas.setEnabled(!true);
        //Limpar campos
        jIDPesqAtend.setText("");
        jDataAtendimento.setDate(null);
        jStatusAtend.setText("");
        jIDInterno.setText("");
        jNomeInterno.setText("");
        jMaeInterno.setText("");
        jPaiInterno.setText("");
        jEstadoCivil.setText("");
        jDataNascimento.setDate(null);
        jReligiao.setText("");
        jProfissao.setText("");
        FotoInterno.setIcon(null);
        jNaturalidade.setText("");
        jEscolaridade.setText("");
        //
        JContato.setText("");
        jTelefone.setText("");
        jTelefone1.setText("");
        jCelular.setText("");
        jEnderecoContato.setText("");
        jBairroContato.setText("");
        jCidadeContato.setText("");
        jEstadoContato.setText("");
        jComboBoxTrabalho.setSelectedItem(null);
        jPeriodo.setText("");
        jComboBoxAuxReclusao.setSelectedItem(null);
        jComboBoxDireitoReclusao.setSelectedItem(null);
        jComboBoxPessoasCasa.setSelectedItem("Não");
        jQtsTrabalham.setText("");
        //
        jComboBoxCN1.setSelectedItem(null);
        jComboBoxCN2.setSelectedItem(null);
        jComboBoxRG1.setSelectedItem(null);
        jComboBoxRG2.setSelectedItem(null);
        jComboBoxCPF1.setSelectedItem(null);
        jComboBoxCPF2.setSelectedItem(null);
        jComboBoxCTPS1.setSelectedItem(null);
        jComboBoxCTPS2.setSelectedItem(null);
        //
        jComboBoxPossuiFilhos.setSelectedItem(null);
        jQtdFilhos.setText("");
        jTotalFilhos.setText("");
        jComboBoxOutrosFilhos.setSelectedItem(null);
        jQtdFilhosRela.setText("");
        jPaternidade.setText("");
        jComboBoxDefensor.setSelectedItem(null);
        //
        jConsideracoes.setText("");
        // Habilitar/Desabilitar botões
        jBtPesqInterno.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        //
        jDataAtendimento.setEnabled(!true);
        JContato.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jEnderecoContato.setEnabled(!true);
        jBairroContato.setEnabled(!true);
        jCidadeContato.setEnabled(!true);
        jEstadoContato.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jPeriodo.setEnabled(!true);
        jComboBoxAuxReclusao.setEnabled(!true);
        jComboBoxDireitoReclusao.setEnabled(!true);
        jComboBoxPessoasCasa.setEnabled(!true);
        jQtsTrabalham.setEnabled(!true);
        //
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        //
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        //    jComboBoxPartFamilia.setEnabled(!true);
        //
        jConsideracoes.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(!true);
        jComboBoxTitulo1.setEnabled(!true);
        jComboBoxTitulo2.setEnabled(!true);
        jComboBoxReservista1.setEnabled(!true);
        jComboBoxReservista2.setEnabled(!true);
        jCartorioRegistro.setEnabled(!true);
        jComboBoxCondicaoSegurado.setEnabled(!true);
        jComboBoxAuxilioDoenca.setEnabled(!true);
        jComboBoxEsposaCompanheira.setEnabled(!true);
        jTipoConvivencia.setEnabled(!true);
        jNomeCompanheira.setEnabled(!true);
        jQtdPessoasResideCasa.setEnabled(!true);
        jComboBoxOutrosSetores.setEnabled(!true);
        jQualSetor.setEnabled(!true);
        jComboBoxCancelVisita.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jComboBoxTirarDoc.setEnabled(!true);
        jDataDoc.setEnabled(!true);
        jComboBoxRecPater.setEnabled(!true);
        jDataPater.setEnabled(!true);
        jComboBoxRecebeVisita.setEnabled(!true);
        jBtPesqDepartamento.setEnabled(!true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setText("");
        jComboBoxTitulo1.setSelectedItem("Não");
        jComboBoxTitulo2.setSelectedItem("Não");
        jComboBoxReservista1.setSelectedItem("Não");
        jComboBoxReservista2.setSelectedItem("Não");
        jCartorioRegistro.setText("");
        jComboBoxCondicaoSegurado.setSelectedItem("Não");
        jComboBoxAuxilioDoenca.setSelectedItem("Não");
        jComboBoxEsposaCompanheira.setSelectedItem("Não");
        jTipoConvivencia.setText("");
        jNomeCompanheira.setText("");
        jQtdPessoasResideCasa.setText("");
        jComboBoxOutrosSetores.setSelectedItem("Não");
        jQualSetor.setText("");
        jComboBoxCancelVisita.setSelectedItem("Não");
        jMotivo.setText("");
        jComboBoxTirarDoc.setSelectedItem("Não");
        jDataDoc.setDate(null);
        jComboBoxRecPater.setSelectedItem("Não");
        jDataPater.setDate(null);
        jComboBoxRecebeVisita.setSelectedItem("Não");
    }

    public void Salvar() {

        // Habilitar/Desabilitar botões
        jBtPesqInterno.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtIndicacaoVisitas.setEnabled(true);
        //
        jDataAtendimento.setEnabled(!true);
        JContato.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jEnderecoContato.setEnabled(!true);
        jBairroContato.setEnabled(!true);
        jCidadeContato.setEnabled(!true);
        jEstadoContato.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jPeriodo.setEnabled(!true);
        jComboBoxAuxReclusao.setEnabled(!true);
        jComboBoxDireitoReclusao.setEnabled(!true);
        //    jComboBoxBolsaFamilia.setEnabled(!true);
        jComboBoxPessoasCasa.setEnabled(!true);
        jQtsTrabalham.setEnabled(!true);
        //
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        //
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        //
        jConsideracoes.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(!true);
        jComboBoxTitulo1.setEnabled(!true);
        jComboBoxTitulo2.setEnabled(!true);
        jComboBoxReservista1.setEnabled(!true);
        jComboBoxReservista2.setEnabled(!true);
        jCartorioRegistro.setEnabled(!true);
        jComboBoxCondicaoSegurado.setEnabled(!true);
        jComboBoxAuxilioDoenca.setEnabled(!true);
        jComboBoxEsposaCompanheira.setEnabled(!true);
        jTipoConvivencia.setEnabled(!true);
        jNomeCompanheira.setEnabled(!true);
        jQtdPessoasResideCasa.setEnabled(!true);
        jComboBoxOutrosSetores.setEnabled(!true);
        jQualSetor.setEnabled(!true);
        jComboBoxCancelVisita.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jComboBoxTirarDoc.setEnabled(!true);
        jDataDoc.setEnabled(!true);
        jComboBoxRecPater.setEnabled(!true);
        jDataPater.setEnabled(!true);
        jComboBoxRecebeVisita.setEnabled(!true);
        jBtPesqDepartamento.setEnabled(!true);
    }

    public void Cancelar() {

        if (jIdADM_Principal.getText().equals("")) {
            //Limpar campos
            jIDPesqAtend.setText("");
            jDataAtendimento.setDate(null);
            jStatusAtend.setText("");
            jIDInterno.setText("");
            jNomeInterno.setText("");
            jMaeInterno.setText("");
            jPaiInterno.setText("");
            jEstadoCivil.setText("");
            jDataNascimento.setDate(null);
            jReligiao.setText("");
            jProfissao.setText("");
            FotoInterno.setIcon(null);
            jNaturalidade.setText("");
            jEscolaridade.setText("");
            //
            JContato.setText("");
            jTelefone.setText("");
            jTelefone1.setText("");
            jCelular.setText("");
            jEnderecoContato.setText("");
            jBairroContato.setText("");
            jCidadeContato.setText("");
            jEstadoContato.setText("");
            jComboBoxTrabalho.setSelectedItem(null);
            jPeriodo.setText("");
            jComboBoxAuxReclusao.setSelectedItem(null);
            jComboBoxDireitoReclusao.setSelectedItem(null);
            jComboBoxPessoasCasa.setSelectedItem("Não");
            jQtsTrabalham.setText("");
            //
            jComboBoxCN1.setSelectedItem(null);
            jComboBoxCN2.setSelectedItem(null);
            jComboBoxRG1.setSelectedItem(null);
            jComboBoxRG2.setSelectedItem(null);
            jComboBoxCPF1.setSelectedItem(null);
            jComboBoxCPF2.setSelectedItem(null);
            jComboBoxCTPS1.setSelectedItem(null);
            jComboBoxCTPS2.setSelectedItem(null);
            //
            jComboBoxPossuiFilhos.setSelectedItem(null);
            jQtdFilhos.setText("");
            jTotalFilhos.setText("");
            jComboBoxOutrosFilhos.setSelectedItem(null);
            jQtdFilhosRela.setText("");
            jPaternidade.setText("");
            jComboBoxDefensor.setSelectedItem(null);
            //
            jConsideracoes.setText("");
            // IMPLEMENTAÇÃO EM 07/07/2016
            jMunicipioNascimento.setText("");
            jComboBoxTitulo1.setSelectedItem("Não");
            jComboBoxTitulo2.setSelectedItem("Não");
            jComboBoxReservista1.setSelectedItem("Não");
            jComboBoxReservista2.setSelectedItem("Não");
            jCartorioRegistro.setText("");
            jComboBoxCondicaoSegurado.setSelectedItem("Não");
            jComboBoxAuxilioDoenca.setSelectedItem("Não");
            jComboBoxEsposaCompanheira.setSelectedItem("Não");
            jTipoConvivencia.setText("");
            jNomeCompanheira.setText("");
            jQtdPessoasResideCasa.setText("");
            jComboBoxOutrosSetores.setSelectedItem("Não");
            jQualSetor.setText("");
            jComboBoxCancelVisita.setSelectedItem("Não");
            jMotivo.setText("");
            jComboBoxTirarDoc.setSelectedItem("Não");
            jDataDoc.setDate(null);
            jComboBoxRecPater.setSelectedItem("Não");
            jDataPater.setDate(null);
            jComboBoxRecebeVisita.setSelectedItem("Não");
            // Habilitar/Desabilitar botões
            jBtPesqInterno.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //
            jDataAtendimento.setEnabled(!true);
            JContato.setEnabled(!true);
            jTelefone.setEnabled(!true);
            jTelefone1.setEnabled(!true);
            jCelular.setEnabled(!true);
            jEnderecoContato.setEnabled(!true);
            jBairroContato.setEnabled(!true);
            jCidadeContato.setEnabled(!true);
            jEstadoContato.setEnabled(!true);
            jComboBoxTrabalho.setEnabled(!true);
            jPeriodo.setEnabled(!true);
            jComboBoxAuxReclusao.setEnabled(!true);
            jComboBoxDireitoReclusao.setEnabled(!true);
            jComboBoxPessoasCasa.setEnabled(!true);
            jQtsTrabalham.setEnabled(!true);
            //
            jComboBoxCN1.setEnabled(!true);
            jComboBoxCN2.setEnabled(!true);
            jComboBoxRG1.setEnabled(!true);
            jComboBoxRG2.setEnabled(!true);
            jComboBoxCPF1.setEnabled(!true);
            jComboBoxCPF2.setEnabled(!true);
            jComboBoxCTPS1.setEnabled(!true);
            jComboBoxCTPS2.setEnabled(!true);
            //
            jComboBoxPossuiFilhos.setEnabled(!true);
            jQtdFilhos.setEnabled(!true);
            jTotalFilhos.setEnabled(!true);
            jComboBoxOutrosFilhos.setEnabled(!true);
            jQtdFilhosRela.setEnabled(!true);
            jPaternidade.setEnabled(!true);
            jComboBoxDefensor.setEnabled(!true);
            jConsideracoes.setEnabled(!true);
            // IMPLEMENTAÇÃO EM 07/07/2016
            jMunicipioNascimento.setEnabled(!true);
            jComboBoxTitulo1.setEnabled(!true);
            jComboBoxTitulo2.setEnabled(!true);
            jComboBoxReservista1.setEnabled(!true);
            jComboBoxReservista2.setEnabled(!true);
            jCartorioRegistro.setEnabled(!true);
            jComboBoxCondicaoSegurado.setEnabled(!true);
            jComboBoxAuxilioDoenca.setEnabled(!true);
            jComboBoxEsposaCompanheira.setEnabled(!true);
            jTipoConvivencia.setEnabled(!true);
            jNomeCompanheira.setEnabled(!true);
            jQtdPessoasResideCasa.setEnabled(!true);
            jComboBoxOutrosSetores.setEnabled(!true);
            jQualSetor.setEnabled(!true);
            jComboBoxCancelVisita.setEnabled(!true);
            jMotivo.setEnabled(!true);
            jComboBoxTirarDoc.setEnabled(!true);
            jDataDoc.setEnabled(!true);
            jComboBoxRecPater.setEnabled(!true);
            jDataPater.setEnabled(!true);
            jComboBoxRecebeVisita.setEnabled(!true);
            jBtPesqDepartamento.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(!true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            //
            jDataAtendimento.setEnabled(!true);
            JContato.setEnabled(!true);
            jTelefone.setEnabled(!true);
            jTelefone1.setEnabled(!true);
            jCelular.setEnabled(!true);
            jEnderecoContato.setEnabled(!true);
            jBairroContato.setEnabled(!true);
            jCidadeContato.setEnabled(!true);
            jEstadoContato.setEnabled(!true);
            jComboBoxTrabalho.setEnabled(!true);
            jPeriodo.setEnabled(!true);
            jComboBoxAuxReclusao.setEnabled(!true);
            jComboBoxDireitoReclusao.setEnabled(!true);
            jComboBoxPessoasCasa.setEnabled(!true);
            jQtsTrabalham.setEnabled(!true);
            //
            jComboBoxCN1.setEnabled(!true);
            jComboBoxCN2.setEnabled(!true);
            jComboBoxRG1.setEnabled(!true);
            jComboBoxRG2.setEnabled(!true);
            jComboBoxCPF1.setEnabled(!true);
            jComboBoxCPF2.setEnabled(!true);
            jComboBoxCTPS1.setEnabled(!true);
            jComboBoxCTPS2.setEnabled(!true);
            //
            jComboBoxPossuiFilhos.setEnabled(!true);
            jQtdFilhos.setEnabled(!true);
            jTotalFilhos.setEnabled(!true);
            jComboBoxOutrosFilhos.setEnabled(!true);
            jQtdFilhosRela.setEnabled(!true);
            jPaternidade.setEnabled(!true);
            jComboBoxDefensor.setEnabled(!true);
            jConsideracoes.setEnabled(!true);
            // IMPLEMENTAÇÃO EM 07/07/2016
            jMunicipioNascimento.setEnabled(!true);
            jComboBoxTitulo1.setEnabled(!true);
            jComboBoxTitulo2.setEnabled(!true);
            jComboBoxReservista1.setEnabled(!true);
            jComboBoxReservista2.setEnabled(!true);
            jCartorioRegistro.setEnabled(!true);
            jComboBoxCondicaoSegurado.setEnabled(!true);
            jComboBoxAuxilioDoenca.setEnabled(!true);
            jComboBoxEsposaCompanheira.setEnabled(!true);
            jTipoConvivencia.setEnabled(!true);
            jNomeCompanheira.setEnabled(!true);
            jQtdPessoasResideCasa.setEnabled(!true);
            jComboBoxOutrosSetores.setEnabled(!true);
            jQualSetor.setEnabled(!true);
            jComboBoxCancelVisita.setEnabled(!true);
            jMotivo.setEnabled(!true);
            jComboBoxTirarDoc.setEnabled(!true);
            jDataDoc.setEnabled(!true);
            jComboBoxRecPater.setEnabled(!true);
            jDataPater.setEnabled(!true);
            jComboBoxRecebeVisita.setEnabled(!true);
            jBtPesqDepartamento.setEnabled(!true);
        }
    }

    public void Relatorio() {

    }

    public void NovaEvolucao() {
        jIdEvolucao.setText("");
        jNomeInternoEvolServicoSocial.setText(jNomeInterno.getText());
        jDataEvolu.setCalendar(Calendar.getInstance());
        jTextoEvolucao.setText("");
        //
        jDataEvolu.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jDataAtendimento.setEnabled(!true);
        JContato.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jEnderecoContato.setEnabled(!true);
        jBairroContato.setEnabled(!true);
        jCidadeContato.setEnabled(!true);
        jEstadoContato.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jPeriodo.setEnabled(!true);
        jComboBoxAuxReclusao.setEnabled(!true);
        jComboBoxDireitoReclusao.setEnabled(!true);
        //   jComboBoxBolsaFamilia.setEnabled(!true);
        jComboBoxPessoasCasa.setEnabled(!true);
        jQtsTrabalham.setEnabled(!true);
        //
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        //
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        //    jComboBoxPartFamilia.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtIndicacaoVisitas.setEnabled(!true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(!true);
        jComboBoxTitulo1.setEnabled(!true);
        jComboBoxTitulo2.setEnabled(!true);
        jComboBoxReservista1.setEnabled(!true);
        jComboBoxReservista2.setEnabled(!true);
        jCartorioRegistro.setEnabled(!true);
        jComboBoxCondicaoSegurado.setEnabled(!true);
        jComboBoxAuxilioDoenca.setEnabled(!true);
        jComboBoxEsposaCompanheira.setEnabled(!true);
        jTipoConvivencia.setEnabled(!true);
        jNomeCompanheira.setEnabled(!true);
        jQtdPessoasResideCasa.setEnabled(!true);
        jComboBoxOutrosSetores.setEnabled(!true);
        jQualSetor.setEnabled(!true);
        jComboBoxCancelVisita.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jComboBoxTirarDoc.setEnabled(!true);
        jDataDoc.setEnabled(!true);
        jComboBoxRecPater.setEnabled(!true);
        jDataPater.setEnabled(!true);
        jComboBoxRecebeVisita.setEnabled(!true);
        jBtPesqDepartamento.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        jDataEvolu.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jDataAtendimento.setEnabled(!true);
        JContato.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jEnderecoContato.setEnabled(!true);
        jBairroContato.setEnabled(!true);
        jCidadeContato.setEnabled(!true);
        jEstadoContato.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jPeriodo.setEnabled(!true);
        jComboBoxAuxReclusao.setEnabled(!true);
        jComboBoxDireitoReclusao.setEnabled(!true);
        //   jComboBoxBolsaFamilia.setEnabled(!true);
        jComboBoxPessoasCasa.setEnabled(!true);
        jQtsTrabalham.setEnabled(!true);
        //
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        //
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtIndicacaoVisitas.setEnabled(!true);
        // IMPLEMENTAÇÃO EM 07/07/2016
        jMunicipioNascimento.setEnabled(!true);
        jComboBoxTitulo1.setEnabled(!true);
        jComboBoxTitulo2.setEnabled(!true);
        jComboBoxReservista1.setEnabled(!true);
        jComboBoxReservista2.setEnabled(!true);
        jCartorioRegistro.setEnabled(!true);
        jComboBoxCondicaoSegurado.setEnabled(!true);
        jComboBoxAuxilioDoenca.setEnabled(!true);
        jComboBoxEsposaCompanheira.setEnabled(!true);
        jTipoConvivencia.setEnabled(!true);
        jNomeCompanheira.setEnabled(!true);
        jQtdPessoasResideCasa.setEnabled(!true);
        jComboBoxOutrosSetores.setEnabled(!true);
        jQualSetor.setEnabled(!true);
        jComboBoxCancelVisita.setEnabled(!true);
        jMotivo.setEnabled(!true);
        jComboBoxTirarDoc.setEnabled(!true);
        jDataDoc.setEnabled(!true);
        jComboBoxRecPater.setEnabled(!true);
        jDataPater.setEnabled(!true);
        jComboBoxRecebeVisita.setEnabled(!true);
        jBtPesqDepartamento.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jIdEvolucao.setText("");
        jNomeInternoEvolServicoSocial.setText("");
        jDataEvolu.setDate(null);
        jTextoEvolucao.setText("");
        //
        jDataEvolu.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jDataAtendimento.setEnabled(!true);
        JContato.setEnabled(!true);
        jTelefone.setEnabled(!true);
        jTelefone1.setEnabled(!true);
        jCelular.setEnabled(!true);
        jEnderecoContato.setEnabled(!true);
        jBairroContato.setEnabled(!true);
        jCidadeContato.setEnabled(!true);
        jEstadoContato.setEnabled(!true);
        jComboBoxTrabalho.setEnabled(!true);
        jPeriodo.setEnabled(!true);
        jComboBoxAuxReclusao.setEnabled(!true);
        jComboBoxDireitoReclusao.setEnabled(!true);
        //     jComboBoxBolsaFamilia.setEnabled(!true);
        jComboBoxPessoasCasa.setEnabled(!true);
        jQtsTrabalham.setEnabled(!true);
        //
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        //
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        //    jComboBoxPartFamilia.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtIndicacaoVisitas.setEnabled(true);
    }

    public void SalvarEvolucao() {
        //
        jDataEvolu.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //        
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtIndicacaoVisitas.setEnabled(true);
    }

    public void CancelarEvolucao() {
        if (jIdEvolucao.getText().equals("")) {
            jIdEvolucao.setText("");
            jNomeInternoEvolServicoSocial.setText("");
            jDataEvolu.setDate(null);
            jTextoEvolucao.setText("");
            //
            jDataEvolu.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtIndicacaoVisitas.setEnabled(true);
        } else if (!jIdEvolucao.getText().equals("")) {
            jDataEvolu.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtIndicacaoVisitas.setEnabled(true);
        }
    }

    public void buscarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //Buscar código de entrada
    public void buscarCodAtend() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL");
            conecta.rs.last();
            jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdAtend")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar ATENDIMENTO \nERRO: " + ex);
        }
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodosAtend(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data Atend.", "Nome do Interno", "Data Entrada", " Situação na Unidade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                // Formatar a data Entrada
                dataAtendimento = conecta.rs.getString("DataAtend");
                String dia = dataAtendimento.substring(8, 10);
                String mes = dataAtendimento.substring(5, 7);
                String ano = dataAtendimento.substring(0, 4);
                dataAtendimento = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAtend"), dataAtendimento, conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("SituacaoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoSocial.setModel(modelo);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAtendimentoSocial.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoSocial.setAutoResizeMode(jTabelaAtendimentoSocial.AUTO_RESIZE_OFF);
        jTabelaAtendimentoSocial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaAtendimentoSocial();
        conecta.desconecta();
    }

    public void preencherAtendInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome do Interno", "Data Entrada", "Situação na Unidade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                // Formatar a data Entrada
                dataAtendimento = conecta.rs.getString("DataAtend");
                String dia = dataAtendimento.substring(8, 10);
                String mes = dataAtendimento.substring(5, 7);
                String ano = dataAtendimento.substring(0, 4);
                dataAtendimento = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAtend"), dataAtendimento, conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("SituacaoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoSocial.setModel(modelo);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAtendimentoSocial.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoSocial.setAutoResizeMode(jTabelaAtendimentoSocial.AUTO_RESIZE_OFF);
        jTabelaAtendimentoSocial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaAtendimentoSocial();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaAtendimentoSocial() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void limparTabelaAtendimentoSocial() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Nome do Interno", "Data Entrada", "Situação na Unidade"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoSocial.setModel(modelo);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaAtendimentoSocial.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAtendimentoSocial.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoSocial.setAutoResizeMode(jTabelaAtendimentoSocial.AUTO_RESIZE_OFF);
        jTabelaAtendimentoSocial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaEvolucaoServicoSocial(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Data", "Evolução Serviço Social"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataEvolu = conecta.rs.getString("DataEvol");
                String diav = dataEvolu.substring(8, 10);
                String mesv = dataEvolu.substring(5, 7);
                String anov = dataEvolu.substring(0, 4);
                dataEvolu = diav + "/" + mesv + "/" + anov;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEvolu, conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoServicoSocial.setModel(modelo);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(2).setPreferredWidth(560);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoServicoSocial.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoServicoSocial.setAutoResizeMode(jTabelaEvolucaoServicoSocial.AUTO_RESIZE_OFF);
        jTabelaEvolucaoServicoSocial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucao();
        conecta.desconecta();
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Data", "Evolução Serviço Social"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoServicoSocial.setModel(modelo);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(2).setPreferredWidth(560);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoServicoSocial.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoServicoSocial.setAutoResizeMode(jTabelaEvolucaoServicoSocial.AUTO_RESIZE_OFF);
        jTabelaEvolucaoServicoSocial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaEvolucao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoServicoSocial.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdADM_Principal.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(jIdADM_Principal.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserSS = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserSS + "'");
            conecta.rs.first();
            codigoUserGroupSS = conecta.rs.getInt("IdUsuario");
            codigoGrupoSS = conecta.rs.getInt("IdGrupo");
            nomeGrupoSS = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserSS + "' "
                    + "AND NomeTela='" + nomeTela + "'");
            conecta.rs.first();
            codUserAcessoSS = conecta.rs.getInt("IdUsuario");
            codAbrirSS = conecta.rs.getInt("Abrir");
            codIncluirSS = conecta.rs.getInt("Incluir");
            codAlterarSS = conecta.rs.getInt("Alterar");
            codExcluirSS = conecta.rs.getInt("Excluir");
            codGravarSS = conecta.rs.getInt("Gravar");
            codConsultarSS = conecta.rs.getInt("Consultar");
            nomeTelaSS = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoRegistradoAdm() {

        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataAtendimento.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoSS = conecta.rs.getInt("IdDepartamento");
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
            pHabilitaSSocial = conecta.rs.getString("AtendInterSocial");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarInternoExistente() {
        bloquearCamposPesquisa();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "WHERE ATENDIMENTOSOCIAL.IdInternoCrc'" + jIDInterno.getText() + "'");
            conecta.rs.first();
            jIdADM_Principal.setText(String.valueOf(conecta.rs.getInt("IdAtend")));
            jDataAtendimento.setDate(conecta.rs.getDate("DataAtend"));
            jStatusAtend.setText(conecta.rs.getString("StatusAtend"));
            jIDInterno.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
            jMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
            jPaiInterno.setText(conecta.rs.getString("PaiInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                FotoInterno.setIcon(i);
                FotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInterno.getWidth(), FotoInterno.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(FotoInterno.getWidth(), FotoInterno.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                FotoInterno.setIcon(icon);
            }
            jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
            jEstadoCivil.setText(conecta.rs.getString("EstadoCivilCrc"));
            jProfissao.setText(conecta.rs.getString("ProfissaoCrc"));
            jReligiao.setText(conecta.rs.getString("ReligiaoCrc"));
            jNaturalidade.setText(conecta.rs.getString("NomeCidade"));
            jEscolaridade.setText(conecta.rs.getString("EscolaridadeCrc"));
            //
            JContato.setText(conecta.rs.getString("ContatoAtend"));
            jTelefone.setText(conecta.rs.getString("TelefoneAtend"));
            jTelefone1.setText(conecta.rs.getString("Telefone1Atend"));
            jCelular.setText(conecta.rs.getString("CelularAtend"));
            jEnderecoContato.setText(conecta.rs.getString("EnderecoAtend"));
            jBairroContato.setText(conecta.rs.getString("BairroAtend"));
            jCidadeContato.setText(conecta.rs.getString("CidadeAtend"));
            jEstadoContato.setText(conecta.rs.getString("EstadoAtend"));
            //
            jComboBoxTrabalho.setSelectedItem(conecta.rs.getString("CartTrabAtend"));
            jPeriodo.setText(conecta.rs.getString("Periodo"));
            jComboBoxDireitoReclusao.setSelectedItem(conecta.rs.getString("RecebeRecluAtend"));
            jComboBoxAuxReclusao.setSelectedItem(conecta.rs.getString("DireitoAuxAtend"));
            jComboBoxPessoasCasa.setSelectedItem(conecta.rs.getString("QtdPessoasAtend"));
            jQtsTrabalham.setText(conecta.rs.getString("QtdTrabaAtend"));
            //
            jComboBoxCN1.setSelectedItem(conecta.rs.getString("CN1Atend"));
            jComboBoxCN2.setSelectedItem(conecta.rs.getString("CN2Atend"));
            jComboBoxRG1.setSelectedItem(conecta.rs.getString("RG1Atend"));
            jComboBoxRG2.setSelectedItem(conecta.rs.getString("RG2Atend"));
            jComboBoxCPF1.setSelectedItem(conecta.rs.getString("CPF1Atend"));
            jComboBoxCPF2.setSelectedItem(conecta.rs.getString("CPF2Atend"));
            jComboBoxCTPS1.setSelectedItem(conecta.rs.getString("CTPS1Atend"));
            jComboBoxCTPS2.setSelectedItem(conecta.rs.getString("CTPS2Atend"));
            //
            jComboBoxPossuiFilhos.setSelectedItem(conecta.rs.getString("PossuiFilhosAtend"));
            jQtdFilhos.setText(conecta.rs.getString("QtdFilhosAtend"));
            jTotalFilhos.setText(conecta.rs.getString("FilhosNaoRegAtend"));
            jComboBoxOutrosFilhos.setSelectedItem(conecta.rs.getString("OutrosFilhosAtend"));
            jQtdFilhosRela.setText(conecta.rs.getString("QtdFilhos2Atend"));
            jPaternidade.setText(conecta.rs.getString("PaternidadeAtend"));
            jComboBoxDefensor.setSelectedItem(conecta.rs.getString("DefensorAtend"));
            //
            jConsideracoes.setText(conecta.rs.getString("ConsiderAtend"));
            // IMPLEMENTAÇÃO EM 07/07/2016
            jMunicipioNascimento.setText(conecta.rs.getString("MunicipioNascimento"));
            jComboBoxTitulo1.setSelectedItem(conecta.rs.getString("Tituloeleito1"));
            jComboBoxTitulo2.setSelectedItem(conecta.rs.getString("Tituloeleito2"));
            jComboBoxReservista1.setSelectedItem(conecta.rs.getString("Reservista1"));
            jComboBoxReservista2.setSelectedItem(conecta.rs.getString("Reservista2"));
            jCartorioRegistro.setText(conecta.rs.getString("CartorioRegistro"));
            jComboBoxCondicaoSegurado.setSelectedItem(conecta.rs.getString("CondicaoSegurado"));
            jComboBoxAuxilioDoenca.setSelectedItem(conecta.rs.getString("RecebeBeneficio"));
            jComboBoxEsposaCompanheira.setSelectedItem(conecta.rs.getString("EsposoCompanheiro"));
            jTipoConvivencia.setText(conecta.rs.getString("TempoConvivencia"));
            jNomeCompanheira.setText(conecta.rs.getString("NomeEsposoCompanheiro"));
            jQtdPessoasResideCasa.setText(conecta.rs.getString("PessoasResideCasa"));
            jComboBoxOutrosSetores.setSelectedItem(conecta.rs.getString("EncaOutroSetor"));
            jQualSetor.setText(conecta.rs.getString("QualSetor"));
            jComboBoxCancelVisita.setSelectedItem(conecta.rs.getString("CancelarVisita"));
            jMotivo.setText(conecta.rs.getString("MotivoCancelarVisita"));
            jComboBoxTirarDoc.setSelectedItem(conecta.rs.getString("EncaTirarDoc"));
            jDataDoc.setDate(conecta.rs.getDate("DataEncaDoc"));
            jComboBoxRecPater.setSelectedItem(conecta.rs.getString("EncaRecPaternidade"));
            jDataPater.setDate(conecta.rs.getDate("DataRecPaternidade"));
            jComboBoxRecebeVisita.setSelectedItem(conecta.rs.getString("RecebeVisita"));
            //
            conecta.desconecta();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
        }
        preencherTabelaEvolucaoServicoSocial("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                + "WHERE IdAtend='" + jIdADM_Principal.getText() + "'");
    }

    // VERIFICAR SE A EVOLUÇÃO FAZ PARTE DA ADMISSÃO, OU SEJA, QUANDO É FEITA A ADMISSÃO DO INTERNO
    // É GRAVADO AUTOMÁTICAMETE UMA EVOLUÇÃO PARA O INTERNO.
    public void verificarEvolucaoAdmissao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_ATENDIMENTO_SOCIAL "
                    + "WHERE IdAtend='" + jIdADM_Principal.getText() + "' "
                    + "AND IdItem='" + jIdEvolucao.getText() + "'");
            conecta.rs.first();
            admEvolucao = conecta.rs.getString("AdmEvo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
