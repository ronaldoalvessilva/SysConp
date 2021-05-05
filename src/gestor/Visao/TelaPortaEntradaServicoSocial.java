/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoServicoSocial;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovEvolucaoServicoSocial;
import gestor.Controle.ControleMovServicoSocial;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Controle.ControleAtendSocialPortaEntrada;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AtendimentoServicoSocial;
import gestor.Modelo.EvolucaoServicoSocial;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAtendimentoSocial.codigoDepartamentoSS;
import static gestor.Visao.TelaAtendimentoSocial.jIDInterno;
import static gestor.Visao.TelaAtendimentoSocial.jTabelaEvolucaoServicoSocial;
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
import static gestor.Visao.TelaAtendimentoSocial.jIdADM_Principal;
import static gestor.Visao.TelaAtendimentoSocial.jIdEvolucao;

/**
 *
 * @author Socializa TI 02
 */
public class TelaPortaEntradaServicoSocial extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoServicoSocial objAtendSocial = new AtendimentoServicoSocial();
    ControleAtendSocialPortaEntrada control = new ControleAtendSocialPortaEntrada();
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
    String deptoTecnico = "SERVICO SOCIAL";
    int count = 0;
    int idItemEvol;
    String codEvolucao;
    // VARIVAEIS PARA SABER SE O INTERNO FOI REGISTRADO COM BIOMETRIA      
    String dataReg = "";
    Date dataRegistro = null;
    String codigoInternoAtend = "";
    String atendido = "Sim";
    String opcao = "Não";
    String tipoAtendimentoAdm = "Admissão Serviço Social";
    String tipoAtendimentoEvol = "Evolução Serviço Social";
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    String statusAtend = "ABERTO";
    //PORTA DE ENTRADA COM ORIGEM NO CRC/TRIAGEM
    String pHABILITA_ASSISTENTE_SOCIAL = "Sim";
    String pDEPARTAMENTO = "";
    String pINTERNOCRC = "";
    String pHABILITADO = "";
    String pCONFIRMA_ADMISSAO = "Sim";
    String pHabilitaSSocial = "";
    int codigoDepartamento = 0;
    String situacao = "ENTRADA NA UNIDADE";
    String sitRetorno = "RETORNO A UNIDADE";
    String codInterno;
    String nomeInternoAnterior = "";
    String pATENDIDO_PESQUISA = "Não";
    //
    String admEvolucao = "Sim";
    String statusEvolucao = "EVOLUINDO";

    /**
     * Creates new form PortaEntradaServicoSocial
     */
    public static TelaAtendimentoSocial pADMISSAO_SOCIAL;
    public static TelaPesquisaDeptoAtendimento_ADM2 pPESQUISAR_DEPARTAMENTO;
    public static TelaAuditoriaPortaEntradaSS pAUDITORIA;

    public TelaPortaEntradaServicoSocial(TelaAtendimentoSocial parent, boolean modal) {
        this.pADMISSAO_SOCIAL = parent;
        this.setModal(modal);
        setLocationRelativeTo(pADMISSAO_SOCIAL);
        initComponents();
        jTabbedPane1.setSelectedIndex(1);
        formatarCampos();
        corCampos();
    }

    public void mostrarPesquisaDepto() {
        pPESQUISAR_DEPARTAMENTO = new TelaPesquisaDeptoAtendimento_ADM2(this, true);
        pPESQUISAR_DEPARTAMENTO.setVisible(true);
    }

    public void mostrarAuditoria() {
        pAUDITORIA = new TelaAuditoriaPortaEntradaSS(this, true);
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
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jNomeInternoAD = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jIDNovoAtend = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jStatusAtend = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jDataAtendimento = new com.toedter.calendar.JDateChooser();
        jIDInternoAD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdAtend_PRINCIPAL = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        ContatoFamiliar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        JContato = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jEnderecoContato = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jCidadeContato = new javax.swing.JTextField();
        jTelefone = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jBairroContato = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jEstadoContato = new javax.swing.JTextField();
        jTelefone1 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jCelular = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
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
        jPanel12 = new javax.swing.JPanel();
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
        jPanel11 = new javax.swing.JPanel();
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
        jPanel17 = new javax.swing.JPanel();
        Consideracoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jConsideracoes = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jFotoInternoPE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Porta de Entrada - Admissão :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(jCheckBox1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel47)
                    .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAtend)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData)
                    .addComponent(jLabel48)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel50)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jNomeInternoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAD.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Nova ADM");

        jIDNovoAtend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDNovoAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDNovoAtend.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Status");

        jStatusAtend.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAtend.setForeground(new java.awt.Color(255, 0, 51));
        jStatusAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAtend.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusAtend.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Data");

        jDataAtendimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtendimento.setEnabled(false);

        jIDInternoAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInternoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInternoAD.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("ADM-PRI");

        jIdAtend_PRINCIPAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAtend_PRINCIPAL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAtend_PRINCIPAL.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52)
                            .addComponent(jIDNovoAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jIdAtend_PRINCIPAL, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jStatusAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jDataAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jIDInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jNomeInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDNovoAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdAtend_PRINCIPAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIDInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Familiar para Contato");

        JContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        JContato.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Endereço do Contato");

        jEnderecoContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEnderecoContato.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Cidade");

        jCidadeContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidadeContato.setEnabled(false);

        jTelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Telefone");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Bairro");

        jBairroContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairroContato.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Estado");

        jEstadoContato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstadoContato.setEnabled(false);

        jTelefone1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone1.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Telefone");

        jCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelular.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Celular");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JContato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)))
                                    .addComponent(jEnderecoContato))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43)
                                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addComponent(jBairroContato, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jCidadeContato, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(145, 145, 145))
                                    .addComponent(jEstadoContato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEnderecoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel43)
                        .addGap(3, 3, 3)
                        .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBairroContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCidadeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEstadoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContatoFamiliarLayout = new javax.swing.GroupLayout(ContatoFamiliar);
        ContatoFamiliar.setLayout(ContatoFamiliarLayout);
        ContatoFamiliarLayout.setHorizontalGroup(
            ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 538, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContatoFamiliarLayout.setVerticalGroup(
            ContatoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContatoFamiliarLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("C. Familiar", ContatoFamiliar);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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
        jLabel25.setText("T. Eleitor 2ª via:");

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
                .addGap(47, 47, 47)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel24)
                            .addComponent(jLabel29))
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxRG2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxRG1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCN1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCTPS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCTPS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMunicipioNascimento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxReservista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxReservista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCartorioRegistro))
                        .addGap(2, 2, 2)))
                .addGap(194, 194, 194))
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
                    .addComponent(jComboBoxCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jComboBoxCN2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jComboBoxRG1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jComboBoxCTPS1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxRG2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxCTPS2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jMunicipioNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel51)
                    .addComponent(jComboBoxReservista1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jComboBoxReservista2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel42)
                    .addComponent(jCartorioRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DocumentosLayout = new javax.swing.GroupLayout(Documentos);
        Documentos.setLayout(DocumentosLayout);
        DocumentosLayout.setHorizontalGroup(
            DocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DocumentosLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        DocumentosLayout.setVerticalGroup(
            DocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DocumentosLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Doc. 1ª e 2ª Via ", Documentos);

        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAuxReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAuxilioDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCondicaoSegurado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPessoasCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDireitoReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxAuxReclusao, jComboBoxCondicaoSegurado, jComboBoxDireitoReclusao, jComboBoxPessoasCasa, jComboBoxTrabalho});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDireitoReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxPessoasCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jComboBoxCondicaoSegurado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jComboBoxAuxilioDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxAuxReclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DadosAtendimentoLayout = new javax.swing.GroupLayout(DadosAtendimento);
        DadosAtendimento.setLayout(DadosAtendimentoLayout);
        DadosAtendimentoLayout.setHorizontalGroup(
            DadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DadosAtendimentoLayout.setVerticalGroup(
            DadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosAtendimentoLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Beneficios Gerais", DadosAtendimento);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

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
        jLabel70.setText("Esposo(a)/Comp.(a)/Solterio(a)?");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEsposaCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQtdPessoasResideCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTotalFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPossuiFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxOutrosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTipoConvivencia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQtsTrabalham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jQtdFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jQtdFilhosRela, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPaternidade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jNomeCompanheira))
                .addGap(133, 133, 133))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPaternidade, jQtdFilhos, jQtdFilhosRela, jQtsTrabalham, jTipoConvivencia});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jComboBoxEsposaCompanheira, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jTipoConvivencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jComboBoxPossuiFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jQtdFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxOutrosFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jQtdFilhosRela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTotalFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jPaternidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout OutrosLayout = new javax.swing.GroupLayout(Outros);
        Outros.setLayout(OutrosLayout);
        OutrosLayout.setHorizontalGroup(
            OutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 538, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        OutrosLayout.setVerticalGroup(
            OutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutrosLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Situação Familiar", Outros);

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Encaminhado p/ outros Setores?");

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
        jLabel62.setText("Encaminhado para tirar documentos?");
        jLabel62.setToolTipText("Encaminhado para tirar documentos?");

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
        jLabel65.setText("Encaminhado para reconhecer paternidade?");
        jLabel65.setToolTipText("Encaminhado para reconhecer paternidade?");

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
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jComboBoxCancelVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jMotivo))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxRecebeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel41)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBoxDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel62)))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jComboBoxRecPater, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel64)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDataPater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jComboBoxTirarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel63)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDataDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOutrosSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualSetor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxOutrosSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqDepartamento)
                    .addComponent(jQualSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel60)
                    .addComponent(jComboBoxCancelVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel66)
                    .addComponent(jComboBoxRecebeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jComboBoxDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxTirarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel63)
                        .addComponent(jDataDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel64)
                    .addComponent(jDataPater, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRecPater, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 538, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Diversos", jPanel4);

        jConsideracoes.setColumns(20);
        jConsideracoes.setRows(5);
        jConsideracoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jConsideracoes.setEnabled(false);
        jScrollPane1.setViewportView(jConsideracoes);

        javax.swing.GroupLayout ConsideracoesLayout = new javax.swing.GroupLayout(Consideracoes);
        Consideracoes.setLayout(ConsideracoesLayout);
        ConsideracoesLayout.setHorizontalGroup(
            ConsideracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsideracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        ConsideracoesLayout.setVerticalGroup(
            ConsideracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsideracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Considerações", Consideracoes);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo registro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar registro");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir registro");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar registro");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelaar operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar operação");
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSalvar});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAuditoria))
                .addGap(3, 3, 3))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jFotoInternoPE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jFotoInternoPE.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPE, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPE, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Admissão", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtendActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqAtend.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código para pesquisa.");
            jIDPesqAtend.requestFocus();
        } else {
            preencherAtendInterno("SELECT IdAtendSS,IdAtend,DataAtend, "
                    + "PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc, "
                    + "NomeInternoCrc,DataEntrada,SituacaoCrc "
                    + "FROM PORTA_ENTRADA_SERVICO_SOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE IdAtendSS='" + jIDPesqAtend.getText() + "' ");
        }
    }//GEN-LAST:event_jBtAtendActionPerformed

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
                        preencherAtendInterno("SELECT IdAtendSS,IdAtend,DataAtend, "
                                + "PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc, "
                                + "NomeInternoCrc,DataEntrada,SituacaoCrc "
                                + "FROM PORTA_ENTRADA_SERVICO_SOCIAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                + "WHERE DataAtend BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND PORTA_ENTRADA_SERVICO_SOCIAL.IdAtend='" + jIdADM_Principal.getText() + "' "
                                + "AND PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc='" + jIDInterno.getText() + "'");
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
                        preencherAtendInterno("SELECT IdAtendSS,IdAtend,DataAtend, "
                                + "PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc, "
                                + "NomeInternoCrc,DataEntrada,SituacaoCrc "
                                + "FROM PORTA_ENTRADA_SERVICO_SOCIAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                + "WHERE DataAtend BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND PORTA_ENTRADA_SERVICO_SOCIAL.IdAtend='" + jIdADM_Principal.getText() + "' "
                                + "AND PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc='" + jIDInterno.getText() + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa do Atendimento.");
            jPesqNomeInterno.requestFocus();
        } else {
            preencherAtendInterno("SELECT IdAtendSS,IdAtend,DataAtend, "
                    + "PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc, "
                    + "NomeInternoCrc,DataEntrada,SituacaoCrc "
                    + "FROM PORTA_ENTRADA_SERVICO_SOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInterno.getText() + "%' "
                    + "AND PORTA_ENTRADA_SERVICO_SOCIAL.IdAtend='" + jIdADM_Principal.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAtendInterno("SELECT IdAtendSS,IdAtend,DataAtend, "
                    + "PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc, "
                    + "NomeInternoCrc,DataEntrada,SituacaoCrc "
                    + "FROM PORTA_ENTRADA_SERVICO_SOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE PORTA_ENTRADA_SERVICO_SOCIAL.IdAtend='" + jIdADM_Principal.getText() + "' "
                    + "AND PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc='" + jIDInterno.getText() + "'");
        } else {
            limparTabelaAtendimentoSocial();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTabelaAtendimentoSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtendimentoSocialMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaAtendimentoSocial.getValueAt(jTabelaAtendimentoSocial.getSelectedRow(), 0);
            jIDPesqAtend.setText(idAtend);
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_SERVICO_SOCIAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=PORTA_ENTRADA_SERVICO_SOCIAL.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "WHERE IdAtendSS='" + idAtend + "'");
                conecta.rs.first();
                jIDNovoAtend.setText(String.valueOf(conecta.rs.getInt("IdAtendSS")));
                jIdAtend_PRINCIPAL.setText(String.valueOf(conecta.rs.getInt("IdAtend")));
                jDataAtendimento.setDate(conecta.rs.getDate("DataAtend"));
                jStatusAtend.setText(conecta.rs.getString("StatusAtend"));
                jIDInternoAD.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoAD.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoPE.setIcon(i);
                    jFotoInternoPE.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPE.getWidth(), jFotoInternoPE.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoPE.getWidth(), jFotoInternoPE.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoPE.setIcon(icon);
                }
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
        }
    }//GEN-LAST:event_jTabelaAtendimentoSocialMouseClicked

    private void jBtPesqDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDepartamentoActionPerformed
        // TODO add your handling code here:
        mostrarPesquisaDepto();
    }//GEN-LAST:event_jBtPesqDepartamentoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoInternosServicoSocial);
        if (codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAdmissaoInternosServicoSocial) && codIncluirSS == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES")) {
            verificarPortaEntrada();
            verificarRegistroBiometria();
            if (jIDInterno.getText().equals(pINTERNOCRC) && deptoTecnico.equals(pDEPARTAMENTO) && pHABILITADO.equals("Sim")) {
                if (pHabilitaSSocial.equals("Não")) {
                    acao = 1;
                    Novo();
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    pesquisarInternoManual();
                } else {
                    Novo();
                    //PESQUISAR CÓDIGO DO DEPARTAMENTO PARA CONTABILIZAR O ATENDIMENTO NA TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP
                    procurarDepartamento();
                    //PESQUISAR O INTERNO NO QUAL FEZ A ASSINATURA BIOMETRICA OU FOI LIBERADO PELO COLABORADOR
                    pesquisarInternoColaboradorBiometria();
                    if (jIDInternoAD.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível realizar o atendimento, esse interno não assinou pela biometria ou não foi liberado para ser atendido.");
                    } else {
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
                    objAtendSocial.setIdAtend(Integer.parseInt(jIDNovoAtend.getText()));
                    control.excluirAtendSocial(objAtendSocial);
                    objAtendSocial.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
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
            if (jDataAtendimento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do atendimento.");
                jDataAtendimento.requestFocus();
                jDataAtendimento.setBackground(Color.red);
            } else {
                if (jNomeInternoAD.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para realizar o atendimento.");
                } else {
                    if (jPeriodo.getText() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Informe uma data para o período");
                        jPeriodo.requestFocus();
                        jPeriodo.setBackground(Color.red);
                    } else {
                        verificarInternoRegistradoAdm();
                        objAtendSocial.setIdAtend(Integer.valueOf(jIdAtend_PRINCIPAL.getText()));
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
                            // Para o log do registro
                            objAtendSocial.setUsuarioInsert(nameUser);
                            objAtendSocial.setDataInsert(dataModFinal);
                            objAtendSocial.setHoraInsert(horaMov);
                            objAtendSocial.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objAtendSocial.setNomeInterno(jNomeInternoAD.getText());
                            control.incluirAtendSocial(objAtendSocial);
                            buscarCodAtend();
                            objAtendSocial.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
                            objAtendSocial.setNomeInterno(jNomeInternoAD.getText());
                            objAtendSocial.setDeptoSocial(deptoTecnico);
                            controle.incluirMovTec(objAtendSocial);
                            // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO    
                            atendido = "Sim";
                            objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objRegAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                            objRegAtend.setIdDepartamento(codigoDepartamentoSS);
                            objRegAtend.setNomeDepartamento(nomeModuloSS);
                            objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                            objRegAtend.setAtendido(atendido);
                            objRegAtend.setDataAtendimento(jDataAtendimento.getDate());
                            objRegAtend.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
                            objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                            //
                            objRegAtend.setUsuarioUp(nameUser);
                            objRegAtend.setDataUp(dataModFinal);
                            objRegAtend.setHorarioUp(horaMov);
                            controlRegAtend.alterarRegAtend(objRegAtend);
                            //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV        
                            objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                            objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objRegAtend.setNomeInternoCrc(jNomeInternoAD.getText());
                            objRegAtend.setIdDepartamento(codigoDepartamentoSS);
                            objRegAtend.setNomeDepartamento(nomeModuloSERV);
                            objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                            objRegAtend.setHorarioUp(horaMov);
                            objRegAtend.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
                            objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                            control_ATENDE.confirmarAtendimento(objRegAtend);
                            //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                            pHABILITA_ASSISTENTE_SOCIAL = "Não";
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objPortaEntrada.setNomeInternoCrc(jNomeInternoAD.getText());
                            objPortaEntrada.setHabSso(pHABILITA_ASSISTENTE_SOCIAL);
                            control_PE.alterarPortaEntradaSocial(objPortaEntrada);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            //GRAVAR UMA EVOLUÇÃO REFERENTE A ADMISSÃO (13/05/2020)
                            objEvol.setDataEvol(jDataAtendimento.getDate());
                            objEvol.setTextoEvolucao(jConsideracoes.getText());
                            objEvol.setStatusLanc(statusEvolucao);
                            // log de usuario
                            objEvol.setUsuarioInsert(nameUser);
                            objEvol.setDataInsert(dataModFinal);
                            objEvol.setHorarioInsert(horaMov);
                            objEvol.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objEvol.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
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
                        if (acao == 2) {
                            // Para o log do registro
                            objAtendSocial.setUsuarioUp(nameUser);
                            objAtendSocial.setDataUp(jDataSistema.getText());
                            objAtendSocial.setHoraUp(jHoraSistema.getText());
                            objAtendSocial.setIdAtend(Integer.valueOf(jIdAtend_PRINCIPAL.getText()));
                            objAtendSocial.setIdAtendNova(Integer.valueOf(jIDNovoAtend.getText()));
                            objAtendSocial.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objAtendSocial.setNomeInterno(jNomeInternoAD.getText());
                            control.alterarAtendSocial(objAtendSocial);
                            objAtendSocial.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
                            objAtendSocial.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objAtendSocial.setNomeInterno(jNomeInternoAD.getText());
                            objAtendSocial.setDeptoSocial(deptoTecnico);
                            controle.alterarMovTec(objAtendSocial);
                            //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                            pHABILITA_ASSISTENTE_SOCIAL = "Não";
                            objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
                            objPortaEntrada.setNomeInternoCrc(jNomeInternoAD.getText());
                            objPortaEntrada.setHabSso(pHABILITA_ASSISTENTE_SOCIAL);
                            control_PE.alterarPortaEntradaSocial(objPortaEntrada);
                            //ALTERAR EVOLUÇÃO
                            objEvol.setDataEvol(jDataAtendimento.getDate());
                            objEvol.setTextoEvolucao(jConsideracoes.getText());
                            objEvol.setStatusLanc(statusEvolucao);
                            //
                            objEvol.setUsuarioUp(nameUser);
                            objEvol.setDataUp(dataModFinal);
                            objEvol.setHorarioUp(horaMov);
                            objEvol.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
                            objEvol.setIdInternoCrc(Integer.valueOf(jIDInternoAD.getText()));
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
            objAtendSocial.setIdAtendNova(Integer.parseInt(jIDNovoAtend.getText()));
            control.finalizarAtendSocial(objAtendSocial);
            objAtendSocial.setIdAtend(Integer.valueOf(jIDNovoAtend.getText()));
            controle.finalizarMovTec(objAtendSocial);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusAtend.setText(statusAtend);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        mostrarAuditoria();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPortaEntradaServicoSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaServicoSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaServicoSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPortaEntradaServicoSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPortaEntradaServicoSocial dialog = new TelaPortaEntradaServicoSocial(pADMISSAO_SOCIAL, true);
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
    private javax.swing.JPanel Consideracoes;
    private javax.swing.JPanel ContatoFamiliar;
    private javax.swing.JPanel DadosAtendimento;
    private javax.swing.JPanel Documentos;
    private javax.swing.JTextField JContato;
    private javax.swing.JPanel Outros;
    private javax.swing.JTextField jBairroContato;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAtend;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqDepartamento;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
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
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataPater;
    private javax.swing.JTextField jEnderecoContato;
    private javax.swing.JTextField jEstadoContato;
    public static javax.swing.JLabel jFotoInternoPE;
    public static javax.swing.JTextField jIDInternoAD;
    public static javax.swing.JTextField jIDNovoAtend;
    private javax.swing.JTextField jIDPesqAtend;
    public static javax.swing.JTextField jIdAtend_PRINCIPAL;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
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
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JTextField jMotivo;
    private javax.swing.JTextField jMunicipioNascimento;
    private javax.swing.JTextField jNomeCompanheira;
    public static javax.swing.JTextField jNomeInternoAD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JTextField jPaternidade;
    private javax.swing.JTextField jPeriodo;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JTextField jQtdFilhos;
    private javax.swing.JTextField jQtdFilhosRela;
    private javax.swing.JTextField jQtdPessoasResideCasa;
    private javax.swing.JTextField jQtsTrabalham;
    public static javax.swing.JTextField jQualSetor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jStatusAtend;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAtendimentoSocial;
    private javax.swing.JFormattedTextField jTelefone;
    private javax.swing.JFormattedTextField jTelefone1;
    private javax.swing.JTextField jTipoConvivencia;
    private javax.swing.JTextField jTotalFilhos;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarPortaEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND PSPSso='" + deptoTecnico + "' "
                    + "AND HabSso='" + pHABILITA_ASSISTENTE_SOCIAL + "'");
            conecta.rs.first();
            pINTERNOCRC = conecta.rs.getString("IdInternoCrc");
            pDEPARTAMENTO = conecta.rs.getString("PSPSso");
            pHABILITADO = conecta.rs.getString("HabSso");
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
                    + "INNER JOIN ATENDIMENTOSOCIAL "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOSOCIAL.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ATENDIMENTOSOCIAL.IdInternoCrc='" + jIDInterno.getText() + " '"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + sitRetorno + "' "
                    + "AND ATENDIMENTOSOCIAL.IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            jIdAtend_PRINCIPAL.setText(String.valueOf(conecta.rs.getInt("IdAtend")));
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIDInternoAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoAD.setText(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPE.setIcon(i);
                jFotoInternoPE.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPE.getWidth(), jFotoInternoPE.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoPE.getWidth(), jFotoInternoPE.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoPE.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void procurarDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloSS + "'");
            conecta.rs.first();
            codigoDepartamento = conecta.rs.getInt("IdDepartamento");
            codigoDepartamentoSS = conecta.rs.getInt("IdDepartamento");
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
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND SituacaoCrc='" + situacao + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "' "
                    + "OR REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND SituacaoCrc='" + sitRetorno + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "'");
            conecta.rs.first();
            jIdAtend_PRINCIPAL.setText(jIdADM_Principal.getText());
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIDInternoAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoAD.setText(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPE.setIcon(i);
                jFotoInternoPE.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPE.getWidth(), jFotoInternoPE.getHeight(), Image.SCALE_DEFAULT)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoPE.getWidth(), jFotoInternoPE.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoPE.setIcon(icon);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formatarCampos() {

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
    }

    public void corCampos() {
        jIDNovoAtend.setBackground(Color.white);
        jIdAtend_PRINCIPAL.setBackground(Color.white);
        jDataAtendimento.setBackground(Color.white);
        jStatusAtend.setBackground(Color.white);
        jIDInternoAD.setBackground(Color.white);
        jNomeInternoAD.setBackground(Color.white);
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

    public void abrirCampos() {
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
        jComboBoxCN1.setEnabled(true);
        jComboBoxCN2.setEnabled(true);
        jComboBoxRG1.setEnabled(true);
        jComboBoxRG2.setEnabled(true);
        jComboBoxCPF1.setEnabled(true);
        jComboBoxCPF2.setEnabled(true);
        jComboBoxCTPS1.setEnabled(true);
        jComboBoxCTPS2.setEnabled(true);
        jComboBoxPossuiFilhos.setEnabled(true);
        jQtdFilhos.setEnabled(true);
        jTotalFilhos.setEnabled(true);
        jComboBoxOutrosFilhos.setEnabled(true);
        jQtdFilhosRela.setEnabled(true);
        jPaternidade.setEnabled(true);
        jComboBoxDefensor.setEnabled(true);
        jConsideracoes.setEnabled(true);
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

    public void limparCampos() {
        jIDNovoAtend.setText("");
        jIdAtend_PRINCIPAL.setText("");
        jDataAtendimento.setDate(null);
        jStatusAtend.setText("");
        jIDInternoAD.setText("");
        jNomeInternoAD.setText("");
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
        jQtdFilhos.setText("0");
        jTotalFilhos.setText("0");
        jQtdFilhosRela.setText("0");
        jPaternidade.setText("0");
        jConsideracoes.setText("");
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

    public void bloquearCampos() {
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
        jComboBoxCN1.setEnabled(!true);
        jComboBoxCN2.setEnabled(!true);
        jComboBoxRG1.setEnabled(!true);
        jComboBoxRG2.setEnabled(!true);
        jComboBoxCPF1.setEnabled(!true);
        jComboBoxCPF2.setEnabled(!true);
        jComboBoxCTPS1.setEnabled(!true);
        jComboBoxCTPS2.setEnabled(!true);
        jComboBoxPossuiFilhos.setEnabled(!true);
        jQtdFilhos.setEnabled(!true);
        jTotalFilhos.setEnabled(!true);
        jComboBoxOutrosFilhos.setEnabled(!true);
        jQtdFilhosRela.setEnabled(!true);
        jPaternidade.setEnabled(!true);
        jComboBoxDefensor.setEnabled(!true);
        jConsideracoes.setEnabled(!true);
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

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Novo() {
        limparCampos();
        abrirCampos();
        bloquearBotoes();
        jStatusAtend.setText("ABERTO");
        jDataAtendimento.setCalendar(Calendar.getInstance());
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        abrirCampos();
        bloquearBotoes();
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void Cancelar() {

        if (jIDNovoAtend.getText().equals("")) {
            limparCampos();
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
        } else {
            bloquearCampos();
            bloquearBotoes();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
        }
    }

    public void buscarCodAtend() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA_SERVICO_SOCIAL");
            conecta.rs.last();
            jIDNovoAtend.setText(String.valueOf(conecta.rs.getInt("IdAtendSS")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar ATENDIMENTO \nERRO: " + ex);
        }
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
                dados.add(new Object[]{conecta.rs.getInt("IdAtendSS"), dataAtendimento, conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("SituacaoCrc")});
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

    public void verificarInternoRegistradoAdm() {

        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataAtendimento.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIDInternoAD.getText() + "' "
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDNovoAtend.getText()));
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
}
