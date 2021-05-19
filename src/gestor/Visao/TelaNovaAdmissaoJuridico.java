/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleEvolucaoJuridico;
import gestor.Controle.ControleItensAtividadeJuridico;
import gestor.Controle.ControleJuridicoNovaAdmissao;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovJuridico_NOVA_ADM;
import gestor.Controle.ControlePortaEntrada;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoJuridico;
import gestor.Modelo.EvolucaoJuridico;
import gestor.Modelo.ItensAtividadeJuridico;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PortaEntrada;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAtendimentoJuridico.codigoDepartamentoJURI;
import static gestor.Visao.TelaAtendimentoJuridico.jAtividadeRealizada;
import static gestor.Visao.TelaAtendimentoJuridico.jComboBoxEncaminharSetorEvo;
import static gestor.Visao.TelaAtendimentoJuridico.jEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jIDInternoJuridico;
import static gestor.Visao.TelaAtendimentoJuridico.jIDLanc;
import static gestor.Visao.TelaAtendimentoJuridico.jIdAtiv;
import static gestor.Visao.TelaAtendimentoJuridico.jIdEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jTabelaEvolucaoJuridica;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloJuridico.codAbrirJURI;
import static gestor.Visao.TelaModuloJuridico.codAlterarJURI;
import static gestor.Visao.TelaModuloJuridico.codConsultarJURI;
import static gestor.Visao.TelaModuloJuridico.codExcluirJURI;
import static gestor.Visao.TelaModuloJuridico.codGravarJURI;
import static gestor.Visao.TelaModuloJuridico.codIncluirJURI;
import static gestor.Visao.TelaModuloJuridico.codUserAcessoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserGroupJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserJURI;
import static gestor.Visao.TelaModuloJuridico.nomeGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.nomeModuloJURI;
import static gestor.Visao.TelaModuloJuridico.nomeModuloJURIDICO;
import static gestor.Visao.TelaModuloJuridico.nomeTelaJURI;
import static gestor.Visao.TelaModuloJuridico.pQUANTIDADE_ATENDIDA;
import static gestor.Visao.TelaModuloJuridico.telaAtendimentoJuridicoManuJURI;
import static gestor.Visao.TelaModuloJuridico.telaAtendimentoJuridicoaAtividadesJURI;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronal
 */
public class TelaNovaAdmissaoJuridico extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoJuridico objAtendJuri = new AtendimentoJuridico();
    EvolucaoJuridico objEvolu = new EvolucaoJuridico();
    ControleJuridicoNovaAdmissao control = new ControleJuridicoNovaAdmissao();
    ControleMovJuridico_NOVA_ADM controle = new ControleMovJuridico_NOVA_ADM();
    ControleEvolucaoJuridico controleJuri = new ControleEvolucaoJuridico();
    ItensAtividadeJuridico objAtivi = new ItensAtividadeJuridico();
    ControleItensAtividadeJuridico controleItens = new ControleItensAtividadeJuridico();
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
    String nomeModuloTela = "Juridico:Atendimento:Manutenção";
    String nomeModuloTela2 = "Juridico:Atendimento:Atividades";
    String nomeModuloTela3 = "Juridico:Atendimento:Evolução de Internos";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    int flag, idItem;
    String dataInicial, dataFinal, dataEntrada, dataEvolucao, dataAtiv;
    String deptoTecnico = "JURIDICO";
    String caminho;
    String statusEvolucao = "EVOLUINDO";
    String situacaoInternoCrc; // Situação do Interno, se ainda está na unidade
    int count;
    String statusAgenda = "Não Realizado";
    String beneficioSaidaTmp = "Saída Temporária";
    String beneficioProgressao = "Progressão de Regime";
    String beneficioLivramento = "Livramento Condicional";
    String beneficioAlvara = "Alvará de Soltura";
    String codigoTipoBeneficio;
    String codigoStatusReg;
    String codigoInterno;
    // VARIVAEIS PARA SABER SE O INTERNO FOI REGISTRADO COM BIOMETRIA      
    String dataReg = "";
    Date dataRegistro = null;
    String codigoInternoAtend = "";
    String atendido = "Sim";
    String opcao = "Não";

    String tipoAtendimentoAdm = "Admissão Juridico";
    String tipoAtendimentoEvol = "Evolução Juridico";
    String pHabilitaJuridico = "";
    public static int pAcao_AD = 0;
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";
    //
    String pCODIGO_INTERNO = "";
    //
    String codigoEvolucao;
    int codigoDepartamento = 0;
    String admEvolucao = "Sim";
    String situacao = "ENTRADA NA UNIDADE";
    String sitRetorno = "RETORNO A UNIDADE";
    String pATENDIDO_PESQUISA = "Não";
    //PORTA DE ENTRADA COM ORIGEM NO CRC/TRIAGEM
    String pHABILITA_JURIDICO = "Sim";
    String pDEPARTAMENTO = "";
    String pINTERNOCRC = "";
    String pHABILITADO = "";
    String pCONFIRMA_ADMISSAO = "Sim";
    String codInterno; // VARIÁVEL QUE IMPEDI MUDAR O REGISTRO DE ADMISSÃO, CASO JÁ EXISTA ANAMNESES.
    String nomeInternoAnterior = "";

    /**
     * Creates new form TelaNovaAdmissaoJuridico
     */
    public static TelaAtendimentoJuridico pADMISSAO_JURIDICO;
    public static TelaAtividadesRealizadasADM_NOVA pNOVA_ATIVIDADE;
    public static TelaAuditoriaNovaADM_JURI pAUDITORIA;

    public TelaNovaAdmissaoJuridico(TelaAtendimentoJuridico parent, boolean modal) {
        this.pADMISSAO_JURIDICO = parent;
        this.setModal(modal);
        setLocationRelativeTo(pADMISSAO_JURIDICO);
        initComponents();
        jTabbedPane1.setSelectedIndex(1);
        corCampos();
        formatarCampos();
    }

    public void mostrarNovaAtividade() {
        pNOVA_ATIVIDADE = new TelaAtividadesRealizadasADM_NOVA(this, true);
        pNOVA_ATIVIDADE.setVisible(true);
    }

    public void mostarAuditoria() {
        pAUDITORIA = new TelaAuditoriaNovaADM_JURI(this, true);
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
        jPanel37 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jIDPesq = new javax.swing.JTextField();
        jBtIDPesq = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaAtendimentoJuridico = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIDInternoJuridicoAD = new javax.swing.JTextField();
        jNomeInternoJuridicoAD = new javax.swing.JTextField();
        jMatriculaPenaJuridico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDataNascInternoJuriAD = new com.toedter.calendar.JDateChooser();
        jDataCondIntJuriAD = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxTipoAdvogadoAD = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEncaminharSetorAD = new javax.swing.JComboBox();
        jDataEncaminhamentoAD = new com.toedter.calendar.JDateChooser();
        jComboBoxRespostaAD = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jHoraEnvioAD = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jEvolucaoAdmissaoAD = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAdividadesRealizadasADM = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jIdADM_JURI = new javax.swing.JTextField();
        jStatusLancAD = new javax.swing.JTextField();
        jDataLancAD = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jIdAdmPrincipal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Admissão Jurídico :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código:");

        jIDPesq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIDPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIDPesq.setContentAreaFilled(false);
        jBtIDPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIDPesqActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel19))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel22))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxTodos)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jIDPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIDPesq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaAtendimentoJuridico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtendimentoJuridico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "     Data", "   Status", "         Nome Completo do Interno", "            Observação"
            }
        ));
        jTabelaAtendimentoJuridico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtendimentoJuridicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaAtendimentoJuridico);
        if (jTabelaAtendimentoJuridico.getColumnModel().getColumnCount() > 0) {
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setMinWidth(335);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setMaxWidth(335);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setMinWidth(335);
            jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setMaxWidth(335);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Matricula Penal");

        jIDInternoJuridicoAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInternoJuridicoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInternoJuridicoAD.setEnabled(false);

        jNomeInternoJuridicoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoJuridicoAD.setEnabled(false);

        jMatriculaPenaJuridico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenaJuridico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenaJuridico.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nascimento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Condenação");

        jDataNascInternoJuriAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascInternoJuriAD.setEnabled(false);

        jDataCondIntJuriAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCondIntJuriAD.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIDInternoJuridicoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jMatriculaPenaJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataCondIntJuriAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jDataNascInternoJuriAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoJuridicoAD))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDInternoJuridicoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenaJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCondIntJuriAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascInternoJuriAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoJuridicoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tipo  de Advogado");

        jComboBoxTipoAdvogadoAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoAdvogadoAD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Unidade", "Particular", "Defensor Público" }));
        jComboBoxTipoAdvogadoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoAdvogadoAD.setEnabled(false);
        jComboBoxTipoAdvogadoAD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoAdvogadoADItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Encaminhado para outro Setor");

        jComboBoxEncaminharSetorAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEncaminharSetorAD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxEncaminharSetorAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEncaminharSetorAD.setEnabled(false);
        jComboBoxEncaminharSetorAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEncaminharSetorADActionPerformed(evt);
            }
        });

        jDataEncaminhamentoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEncaminhamentoAD.setEnabled(false);

        jComboBoxRespostaAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRespostaAD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Não", "Sim" }));
        jComboBoxRespostaAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRespostaAD.setEnabled(false);
        jComboBoxRespostaAD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRespostaADItemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Qual Setor foi Encamihado? ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Horário");

        jHoraEnvioAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraEnvioAD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jHoraEnvioAD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraEnvioAD.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxEncaminharSetorAD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipoAdvogadoAD, 0, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxRespostaAD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEncaminhamentoAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jHoraEnvioAD, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxRespostaAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEncaminhamentoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraEnvioAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoAdvogadoAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEncaminharSetorAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Evolução da Admissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jEvolucaoAdmissaoAD.setColumns(20);
        jEvolucaoAdmissaoAD.setRows(5);
        jEvolucaoAdmissaoAD.setText("[DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...]");
        jEvolucaoAdmissaoAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEvolucaoAdmissaoAD.setEnabled(false);
        jScrollPane5.setViewportView(jEvolucaoAdmissaoAD);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
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
        jBtExcluir.setToolTipText("Excluir");
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
        jBtSalvar.setToolTipText("Gravar");
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
        jBtCancelar.setToolTipText("Cancelar");
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
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtFinalizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

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

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAdividadesRealizadasADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-16.png"))); // NOI18N
        jBtAdividadesRealizadasADM.setToolTipText("Atividades Realizadas");
        jBtAdividadesRealizadasADM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAdividadesRealizadasADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdividadesRealizadasADMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBtAdividadesRealizadasADM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdividadesRealizadasADM, jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair)
                    .addComponent(jBtAdividadesRealizadasADM)
                    .addComponent(jBtAuditoria))
                .addGap(4, 4, 4))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Atend.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Status");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data");

        jIdADM_JURI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdADM_JURI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdADM_JURI.setEnabled(false);

        jStatusLancAD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLancAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLancAD.setEnabled(false);

        jDataLancAD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLancAD.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Adm.Principal");

        jIdAdmPrincipal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAdmPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAdmPrincipal.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jIdAdmPrincipal))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdADM_JURI, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jStatusLancAD))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataLancAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusLancAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdAdmPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdADM_JURI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLancAD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

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

    private void jBtIDPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIDPesqActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ID para pesquisa.");
            jIDPesq.requestFocus();
        } else {
            preencherAtendimetoJuridico("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdADM_JURI.IdADM_JURI='" + jIDPesq.getText() + "'");
        }
    }//GEN-LAST:event_jBtIDPesqActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa.");
            jPesqNomeInterno.requestFocus();
        } else {
            preencherAtendimetoJuridico("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%' "
                    + "AND ADMISSAO_JURIDICO_ADICIONAL.IdLanc='" + jIDLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
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
                        preencherAtendimetoJuridico("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "AND ADMISSAO_JURIDICO_ADICIONAL.IdLanc='" + jIDLanc.getText() + "' "
                                + "AND ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
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
                        preencherAtendimetoJuridico("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "' "
                                + "ADMISSAO_JURIDICO_ADICIONAL.IdLanc='" + jIDLanc.getText() + "' "
                                + "AND ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAtendimetoJuridico("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ADMISSAO_JURIDICO_ADICIONAL.IdLanc='" + jIDLanc.getText() + "' "
                    + "AND ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaAtendimentoJuridicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtendimentoJuridicoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String IdLanc = "" + jTabelaAtendimentoJuridico.getValueAt(jTabelaAtendimentoJuridico.getSelectedRow(), 0);
            //
            jIDPesq.setText(IdLanc);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            preencherComboBoxDepartamento();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAO_JURIDICO_ADICIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "WHERE ADMISSAO_JURIDICO_ADICIONAL.IdADM_JURI='" + IdLanc + "'");
                conecta.rs.first();
                jIdAdmPrincipal.setText(jIDLanc.getText());
                jIdADM_JURI.setText(String.valueOf(conecta.rs.getInt("IdADM_JURI")));
                jStatusLancAD.setText(conecta.rs.getString("StatusLanc"));
                jDataLancAD.setDate(conecta.rs.getDate("DataLanc"));
                jIDInternoJuridicoAD.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoJuridicoAD.setText(conecta.rs.getString("NomeInternoCrc"));
                jMatriculaPenaJuridico.setText(conecta.rs.getString("MatriculaCrc"));
                jDataNascInternoJuriAD.setDate(conecta.rs.getDate("DataNasciCrc"));
                jDataCondIntJuriAD.setDate(conecta.rs.getDate("DataCondenacao"));
                jComboBoxTipoAdvogadoAD.setSelectedItem(conecta.rs.getString("TipoAdvogado"));
                jComboBoxRespostaAD.setSelectedItem(conecta.rs.getString("Resposta"));
                jDataEncaminhamentoAD.setDate(conecta.rs.getDate("DataEnca"));
                jHoraEnvioAD.setText(conecta.rs.getString("HoraEnvio"));
                jEvolucaoAdmissaoAD.setText(conecta.rs.getString("Observacao"));
                if (jComboBoxEncaminharSetorAD.getSelectedItem() != null || jComboBoxEncaminharSetorAD.getSelectedItem().equals("")) {
                    jComboBoxEncaminharSetorAD.setSelectedItem(conecta.rs.getString("SetorEncaminhamento"));
                }
            } catch (SQLException e) {
            }
        }
        conecta.desconecta();
    }//GEN-LAST:event_jTabelaAtendimentoJuridicoMouseClicked

    private void jComboBoxEncaminharSetorADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEncaminharSetorADActionPerformed
        // TODO add your handling code here:
        preencherComboBoxDepartamento();
    }//GEN-LAST:event_jComboBoxEncaminharSetorADActionPerformed

    private void jComboBoxRespostaADItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRespostaADItemStateChanged
        // TODO add your handling code here:
        if (pAcao_AD == 1 || pAcao_AD == 2) {
            if (jComboBoxRespostaAD.getSelectedItem().equals("Sim")) {
                jDataEncaminhamentoAD.setCalendar(Calendar.getInstance());
                jHoraEnvioAD.setText(jHoraSistema.getText());
                jDataEncaminhamentoAD.setEnabled(true);
                jComboBoxEncaminharSetorAD.setEnabled(true);
                jHoraEnvioAD.setEnabled(true);
            } else {
                jDataEncaminhamentoAD.setDate(null);
                jHoraEnvioAD.setText("");
                jDataEncaminhamentoAD.setEnabled(!true);
                jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
                jComboBoxEncaminharSetorAD.setEnabled(!true);
                jComboBoxRespostaAD.setEnabled(!true);
                jHoraEnvioAD.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jComboBoxRespostaADItemStateChanged

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codIncluirJURI == 1) {
            verificarPortaEntrada();
            verificarRegistroBiometria();
            if (jIDInternoJuridico.getText().equals(pINTERNOCRC) && deptoTecnico.equals(pDEPARTAMENTO) && pHABILITADO.equals("Sim")) {
                if (pHabilitaJuridico.equals("Não")) {
                    pAcao_AD = 1;
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
                    if (jIDInternoJuridicoAD.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível realizar o atendimento, esse interno não assinou pela biometria ou não foi liberado para ser atendido.");
                    } else {
                        pAcao_AD = 1;
                        statusMov = "Incluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já existe uma admissão para esse interno, por isso não é possível fazer uma nova admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codAlterarJURI == 1) {
            objAtendJuri.setStatusLanc(jStatusLancAD.getText());
            if (jStatusLancAD.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                pAcao_AD = 2;
                Alterar();
                preencherComboBoxDepartamento();
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
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codExcluirJURI == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAtendJuri.setStatusLanc(jStatusLancAD.getText());
            if (jStatusLancAD.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o atendimento selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtendJuri.setIdADM_JURI(Integer.valueOf(jIdADM_JURI.getText()));
                    control.excluirAtendJuridicoNOVA(objAtendJuri);
                    objAtendJuri.setNomeInterno(jNomeInternoJuridicoAD.getText());;
                    objAtendJuri.setIdADM_JURI(Integer.valueOf(jIdADM_JURI.getText()));
                    controle.excluirMovTecNOVA(objAtendJuri);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codGravarJURI == 1) {
            if (jDataLancAD.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de atendimento.");
                jDataLancAD.requestFocus();
                jDataLancAD.setBackground(Color.red);
            } else {
                objAtendJuri.setStatusLanc(jStatusLancAD.getText());
                objAtendJuri.setDataLanc(jDataLancAD.getDate());
                objAtendJuri.setObservacao(jEvolucaoAdmissaoAD.getText());
                objAtendJuri.setDataEnca(jDataEncaminhamentoAD.getDate());
                objAtendJuri.setSetorEncaminhameto((String) jComboBoxEncaminharSetorAD.getSelectedItem());
                objAtendJuri.setTipoAdvogado((String) jComboBoxTipoAdvogadoAD.getSelectedItem());
                objAtendJuri.setHoraEnvio(jHoraEnvioAD.getText());
                objAtendJuri.setResposta((String) jComboBoxRespostaAD.getSelectedItem());
                if (pAcao_AD == 1) {
                    // log de usuario
                    objAtendJuri.setUsuarioInsert(nameUser);
                    objAtendJuri.setDataInsert(dataModFinal);
                    objAtendJuri.setHoraInsert(horaMov);
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objAtendJuri.setIdInternoCrc(Integer.valueOf(jIDInternoJuridicoAD.getText()));
                    objAtendJuri.setNomeInterno(jNomeInternoJuridicoAD.getText());
                    control.incluirAtendJuridicoNOVA(objAtendJuri);
                    buscarID();
                    objAtendJuri.setIdADM_JURI(Integer.valueOf(jIdADM_JURI.getText()));
                    objAtendJuri.setNomeInterno(jNomeInternoJuridicoAD.getText());
                    objAtendJuri.setDeptoJuridico(deptoTecnico);
                    controle.incluirMovTecNOVA(objAtendJuri);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoJuridicoAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoJuridicoAD.getText());//
                    objRegAtend.setIdDepartamento(codigoDepartamentoJURI);
                    objRegAtend.setNomeDepartamento(nomeModuloJURIDICO);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataLancAD.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdADM_JURI.getText()));
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoJuridicoAD.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoJuridicoAD.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoJURI);
                    objRegAtend.setNomeDepartamento(nomeModuloJURIDICO);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdADM_JURI.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    //CONFIRMA A REALIZAÇÃO ADMISSÃO DO INTERNO, IMPEDINDO QUE FAÇA OUTRA ADMISSÃO
                    pHABILITA_JURIDICO = "Não";
                    objPortaEntrada.setIdInternoCrc(Integer.valueOf(jIDInternoJuridicoAD.getText()));
                    objPortaEntrada.setNomeInternoCrc(jNomeInternoJuridicoAD.getText());
                    objPortaEntrada.setHabJur(pHABILITA_JURIDICO);
                    control_PE.alterarPortaEntradaJuridico(objPortaEntrada);
                    // PRIMEIRA EVOLUÇÃO EM CONJUNTO COM A ADMISSÃO
                    objEvolu.setDataEvo(jDataLancAD.getDate());
                    objEvolu.setDataEnca(jDataEncaminhamentoAD.getDate());
                    objEvolu.setTipoAdvogado((String) jComboBoxTipoAdvogadoAD.getSelectedItem());
                    objEvolu.setResposta((String) jComboBoxRespostaAD.getSelectedItem());
                    objEvolu.setHoraEnvio(jHoraEnvioAD.getText());
                    objEvolu.setSetorEncaminhamento((String) jComboBoxEncaminharSetorEvo.getSelectedItem());
                    objEvolu.setEvolucao(jEvolucaoAdmissaoAD.getText());
                    objEvolu.setAdmEvo(admEvolucao);
                    // log de usuario
                    objEvolu.setUsuarioInsert(nameUser);
                    objEvolu.setDataInsert(jDataSistema.getText());
                    objEvolu.setHorarioInsert(jHoraSistema.getText());
                    //
                    objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objEvolu.setAdmEvo(admEvolucao);
                    controleJuri.incluirEvolucaoJuridico(objEvolu);
                    // BUSCAR O CÓDIGO DA EVOLUÇÃO CASO O USUÁRIO QUEIRA ALTERAR A EVOLUÇÃO INICIAL.
                    buscarIdEvolucao();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                        
                    //
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                            + "WHERE IdLanc='" + jIDLanc.getText() + "'");
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (pAcao_AD == 2) {
                    // log de usuario
                    objAtendJuri.setUsuarioUp(nameUser);
                    objAtendJuri.setDataUp(dataModFinal);
                    objAtendJuri.setHoraUp(horaMov);
                    objAtendJuri.setIdInternoCrc(Integer.valueOf(jIDInternoJuridicoAD.getText()));
                    objAtendJuri.setNomeInterno(jNomeInternoJuridicoAD.getText());
                    objAtendJuri.setIdLanc(Integer.valueOf(jIdADM_JURI.getText()));
                    control.alterarAtendJuridicoNOVA(objAtendJuri);
                    objAtendJuri.setIdADM_JURI(Integer.valueOf(jIdADM_JURI.getText()));
                    objAtendJuri.setNomeInterno(jNomeInternoJuridicoAD.getText());
                    objAtendJuri.setDeptoJuridico(deptoTecnico);
                    controle.alterarMovTecNOVA(objAtendJuri);
                    // Se o interno for modificado, altera também na tabela de ITENSATENDIMENTOJURI.
                    objAtendJuri.setIdLanc(Integer.valueOf(jIdADM_JURI.getText()));
                    objAtivi.setIdInternoCrc(Integer.valueOf(jIDInternoJuridicoAD.getText()));
                    objAtivi.setNomeInternoCrc(jNomeInternoJuridicoAD.getText());
                    controleItens.alterarInternoAtividade(objAtivi);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    // MODIFICAR A EVOLUÇÃO CASO SEJA MODIFICADA
                    // log de usuario
                    objEvolu.setUsuarioUp(nameUser);
                    objEvolu.setDataUp(jDataSistema.getText());
                    objEvolu.setHorarioUp(jHoraSistema.getText());
                    //
                    objEvolu.setDataEvo(jDataLancAD.getDate());
                    objEvolu.setDataEnca(jDataEncaminhamentoAD.getDate());
                    objEvolu.setTipoAdvogado((String) jComboBoxTipoAdvogadoAD.getSelectedItem());
                    objEvolu.setResposta((String) jComboBoxRespostaAD.getSelectedItem());
                    objEvolu.setHoraEnvio(jHoraEnvioAD.getText());
                    objEvolu.setSetorEncaminhamento((String) jComboBoxEncaminharSetorEvo.getSelectedItem());
                    objEvolu.setEvolucao(jEvolucaoAdmissaoAD.getText());
                    objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objEvolu.setIdEvo(Integer.valueOf(codigoEvolucao));
                    controleJuri.alterarEvolucaoJuridico(objEvolu);
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                            + "WHERE IdLanc='" + jIDLanc.getText() + "'");
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

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL "
                    + "WHERE IdADM_JURI='" + jIdADM_JURI.getText() + "'");
            conecta.rs.first();
            jStatusLancAD.setText(conecta.rs.getString("StatusLanc"));
            if (jStatusLancAD.getText().equals("FINALIZADO")) {
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
        if (jIdADM_JURI.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro para verificar a auditoria.");
        } else {
            mostarAuditoria();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAdividadesRealizadasADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdividadesRealizadasADMActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codAbrirJURI == 1) {
            if (jIdADM_JURI.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer primeiro a admissão, depois registrar as atividades.");
            } else if (jIDInternoJuridicoAD.getText().equals("") && jNomeInternoJuridicoAD.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do interno antes de cadastrar as atividades a serem realizadas.");
            } else {
                mostrarNovaAtividade();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAdividadesRealizadasADMActionPerformed

    private void jComboBoxTipoAdvogadoADItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoAdvogadoADItemStateChanged
        // TODO add your handling code here:
        if (pAcao_AD == 1 || pAcao_AD == 2) {
            if (jComboBoxTipoAdvogadoAD.getSelectedItem().equals("Unidade")) {
                jComboBoxRespostaAD.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jComboBoxTipoAdvogadoADItemStateChanged

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
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoJuridico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoJuridico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoJuridico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAdmissaoJuridico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaNovaAdmissaoJuridico dialog = new TelaNovaAdmissaoJuridico(pADMISSAO_JURIDICO, true);
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
    private javax.swing.JButton jBtAdividadesRealizadasADM;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIDPesq;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JComboBox jComboBoxEncaminharSetorAD;
    private javax.swing.JComboBox jComboBoxRespostaAD;
    private javax.swing.JComboBox jComboBoxTipoAdvogadoAD;
    public static com.toedter.calendar.JDateChooser jDataCondIntJuriAD;
    private com.toedter.calendar.JDateChooser jDataEncaminhamentoAD;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLancAD;
    public static com.toedter.calendar.JDateChooser jDataNascInternoJuriAD;
    private javax.swing.JTextArea jEvolucaoAdmissaoAD;
    private javax.swing.JFormattedTextField jHoraEnvioAD;
    public static javax.swing.JTextField jIDInternoJuridicoAD;
    private javax.swing.JTextField jIDPesq;
    public static javax.swing.JTextField jIdADM_JURI;
    public static javax.swing.JTextField jIdAdmPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaPenaJuridico;
    public static javax.swing.JTextField jNomeInternoJuridicoAD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextField jStatusLancAD;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAtendimentoJuridico;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdAdmPrincipal.setBackground(Color.white);
        jIdADM_JURI.setBackground(Color.white);
        jStatusLancAD.setBackground(Color.white);
        jDataLancAD.setBackground(Color.white);
        jIDInternoJuridicoAD.setBackground(Color.white);
        jNomeInternoJuridicoAD.setBackground(Color.white);
        jMatriculaPenaJuridico.setBackground(Color.white);
        jDataNascInternoJuriAD.setBackground(Color.white);
        jDataCondIntJuriAD.setBackground(Color.white);
        jIdEvolucao.setBackground(Color.white);
        jEvolucao.setBackground(Color.white);
        jEvolucaoAdmissaoAD.setBackground(Color.white);
        jHoraEnvioAD.setBackground(Color.white);
        jIdAtiv.setBackground(Color.white);
        jAtividadeRealizada.setBackground(Color.white);
    }

    public void formatarCampos() {
        jEvolucaoAdmissaoAD.setLineWrap(true);
        jEvolucaoAdmissaoAD.setWrapStyleWord(true);
    }

    public void Novo() {
        jIdADM_JURI.setText("");
        jStatusLancAD.setText("ABERTO");
        jDataLancAD.setCalendar(Calendar.getInstance());
        jIDInternoJuridicoAD.setText("");
        jNomeInternoJuridicoAD.setText("");
        jMatriculaPenaJuridico.setText("");
        jDataNascInternoJuriAD.setDate(null);
        jDataCondIntJuriAD.setDate(null);
        jEvolucaoAdmissaoAD.setText("[DIGITE AQUI O TEXTO DA EVOLUÇÃO DA ADMISSÃO...]");
        jComboBoxTipoAdvogadoAD.setEnabled(true);
        jComboBoxRespostaAD.setEnabled(true);
        if (pAcao_AD == 1) {
            if (jComboBoxRespostaAD.getSelectedItem().equals("Sim")) {
                jDataEncaminhamentoAD.setCalendar(Calendar.getInstance());
                jHoraEnvioAD.setText(jHoraSistema.getText());
                jDataEncaminhamentoAD.setEnabled(true);
                jComboBoxEncaminharSetorAD.setEnabled(true);
                jComboBoxTipoAdvogadoAD.setEnabled(true);
                jHoraEnvioAD.setEnabled(true);
            } else {
                jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
                jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
                jComboBoxRespostaAD.setSelectedItem("Selecione");
                //
                jDataEncaminhamentoAD.setDate(null);
                jHoraEnvioAD.setText("");
                jDataEncaminhamentoAD.setEnabled(!true);
                jComboBoxEncaminharSetorAD.setEnabled(!true);
                jHoraEnvioAD.setEnabled(!true);
            }
        }
        jComboBoxTipoAdvogadoAD.setSelectedItem("Selecione");
        //
        jIDPesq.setEnabled(!true);
        jPesqNomeInterno.setEnabled(!true);
        jDataInicial.setEnabled(!true);
        jDataFinal.setEnabled(!true);
        jBtIDPesq.setEnabled(!true);
        jCheckBoxTodos.setEnabled(!true);
        jBtPesqDatas.setEnabled(!true);
        //
        jDataLancAD.setEnabled(!true);
        jEvolucaoAdmissaoAD.setEnabled(true);
        jComboBoxTipoAdvogadoAD.setEnabled(true);
        jComboBoxRespostaAD.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIdEvolucao.setText("");
        jAtividadeRealizada.setText("");
    }

    public void Alterar() {
        jDataLancAD.setEnabled(!true);
        jEvolucaoAdmissaoAD.setEnabled(true);
        jComboBoxTipoAdvogadoAD.setEnabled(true);
        jComboBoxRespostaAD.setEnabled(true);
        if (pAcao_AD == 2) {
            if (jComboBoxRespostaAD.getSelectedItem().equals("Sim")) {
                jDataEncaminhamentoAD.setEnabled(true);
                jComboBoxEncaminharSetorAD.setEnabled(true);
                jComboBoxTipoAdvogadoAD.setEnabled(true);
                jHoraEnvioAD.setEnabled(true);
            } else {
                jDataEncaminhamentoAD.setEnabled(!true);
                jComboBoxEncaminharSetorAD.setEnabled(!true);
                jHoraEnvioAD.setEnabled(!true);
            }
        }
        jEvolucao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIDPesq.setEnabled(!true);
        jPesqNomeInterno.setEnabled(!true);
        jDataInicial.setEnabled(!true);
        jDataFinal.setEnabled(!true);
        jBtIDPesq.setEnabled(!true);
        jBtPesqNomeInterno.setEnabled(!true);
        jBtPesqDatas.setEnabled(!true);
        jCheckBoxTodos.setEnabled(!true);
    }

    public void Excluir() {
        jIdAdmPrincipal.setText("");
        jIdADM_JURI.setText("");
        jStatusLancAD.setText("");
        jDataLancAD.setDate(null);
        jIDInternoJuridicoAD.setText("");
        jNomeInternoJuridicoAD.setText("");
        jMatriculaPenaJuridico.setText("");
        jDataNascInternoJuriAD.setDate(null);
        jDataCondIntJuriAD.setDate(null);
        jEvolucaoAdmissaoAD.setText("");
        jDataEncaminhamentoAD.setDate(null);
        jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
        jComboBoxTipoAdvogadoAD.setSelectedItem("Selecione");
        jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
        jComboBoxRespostaAD.setSelectedItem("Selecione");
        jEvolucao.setText("");
        //
        jDataLancAD.setEnabled(!true);
        jDataEncaminhamentoAD.setEnabled(!true);
        jComboBoxEncaminharSetorAD.setEnabled(!true);
        jComboBoxTipoAdvogadoAD.setEnabled(!true);
        jComboBoxEncaminharSetorAD.setEnabled(!true);
        jComboBoxRespostaAD.setEnabled(!true);
        jHoraEnvioAD.setEnabled(!true);
        //
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jIDPesq.setEnabled(true);
        jPesqNomeInterno.setEnabled(true);
        jDataInicial.setEnabled(true);
        jDataFinal.setEnabled(true);
        jBtIDPesq.setEnabled(true);
        jBtPesqNomeInterno.setEnabled(true);
        jBtPesqDatas.setEnabled(true);
        jCheckBoxTodos.setEnabled(true);
    }

    public void Salvar() {
        jDataLancAD.setEnabled(!true);
        jEvolucaoAdmissaoAD.setEnabled(!true);
        jDataEncaminhamentoAD.setEnabled(!true);
        jComboBoxEncaminharSetorAD.setEnabled(!true);
        jComboBoxTipoAdvogadoAD.setEnabled(!true);
        jComboBoxEncaminharSetorAD.setEnabled(!true);
        jComboBoxRespostaAD.setEnabled(!true);
        jHoraEnvioAD.setEnabled(!true);
        //
        jEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jIDPesq.setEnabled(true);
        jPesqNomeInterno.setEnabled(true);
        jDataInicial.setEnabled(true);
        jDataFinal.setEnabled(true);
        jBtIDPesq.setEnabled(true);
        jBtPesqNomeInterno.setEnabled(true);
        jBtPesqDatas.setEnabled(true);
        jCheckBoxTodos.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdADM_JURI.getText().equals("")) {
            jIdAdmPrincipal.setText("");
            jStatusLancAD.setText("");
            jDataLancAD.setDate(null);
            jIDInternoJuridicoAD.setText("");
            jNomeInternoJuridicoAD.setText("");
            jMatriculaPenaJuridico.setText("");
            jDataNascInternoJuriAD.setDate(null);
            jDataCondIntJuriAD.setDate(null);
            jDataEncaminhamentoAD.setDate(null);
            jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
            jComboBoxTipoAdvogadoAD.setSelectedItem("Selecione");
            jComboBoxEncaminharSetorAD.setSelectedItem("Selecione");
            jComboBoxRespostaAD.setSelectedItem("Selecione");
            jEvolucao.setText("");
            jBtAuditoria.setEnabled(!true);
            //
            jDataLancAD.setEnabled(!true);
            jDataEncaminhamentoAD.setEnabled(!true);
            jComboBoxEncaminharSetorAD.setEnabled(!true);
            jComboBoxTipoAdvogadoAD.setEnabled(!true);
            jComboBoxEncaminharSetorAD.setEnabled(!true);
            jComboBoxRespostaAD.setEnabled(!true);
            jHoraEnvioAD.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //
            jIDPesq.setEnabled(true);
            jPesqNomeInterno.setEnabled(true);
            jDataInicial.setEnabled(true);
            jDataFinal.setEnabled(true);
            jBtIDPesq.setEnabled(true);
            jBtPesqDatas.setEnabled(true);
            jCheckBoxTodos.setEnabled(true);
        } else {
            jDataLancAD.setEnabled(!true);
            jDataEncaminhamentoAD.setEnabled(!true);
            jComboBoxEncaminharSetorAD.setEnabled(!true);
            jComboBoxTipoAdvogadoAD.setEnabled(!true);
            jComboBoxEncaminharSetorAD.setEnabled(!true);
            jComboBoxRespostaAD.setEnabled(!true);
            jHoraEnvioAD.setEnabled(!true);
            //
            jEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jIDPesq.setEnabled(true);
            jPesqNomeInterno.setEnabled(true);
            jDataInicial.setEnabled(true);
            jDataFinal.setEnabled(true);
            jBtIDPesq.setEnabled(true);
            jBtPesqNomeInterno.setEnabled(true);
            jBtPesqDatas.setEnabled(true);
            jCheckBoxTodos.setEnabled(true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAO_JURIDICO_ADICIONAL");
            conecta.rs.last();
            jIdADM_JURI.setText(conecta.rs.getString("IdADM_JURI"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID do lançamento");
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
            objAtendJuri.setStatusLanc(statusLanc);
            objAtendJuri.setIdADM_JURI(Integer.parseInt(jIdADM_JURI.getText()));
            control.finalizarAtendJuridicoNOVA(objAtendJuri);
            controle.finalizarMovTecNOVA(objAtendJuri);
            jStatusLancAD.setText("FINALIZADO");
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            // Habilitar/Desabilitar campos       
            jDataLancAD.setEnabled(!true);
            jEvolucao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
    }

    public void buscarIdEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOJURIDICO");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdEvo"));
            codigoEvolucao = conecta.rs.getString("IdEvo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID da evolução");
        }
    }

    public void preencherComboBoxDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxEncaminharSetorAD.addItem(conecta.rs.getString("NomeDepartamento"));
                jComboBoxEncaminharSetorEvo.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos!!!\nERRO: " + ERROR);
        }
        conecta.desconecta();
    }

    public void procurarDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloJURI + "'");
            conecta.rs.first();
            codigoDepartamento = conecta.rs.getInt("IdDepartamento");
            codigoDepartamentoJURI = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherAtendimetoJuridico(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Observação"};
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
                jtotalRegistros.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdADM_JURI"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoJuridico.setModel(modelo);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAtendimentoJuridico.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoJuridico.setAutoResizeMode(jTabelaAtendimentoJuridico.AUTO_RESIZE_OFF);
        jTabelaAtendimentoJuridico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAtendimento();
        conecta.desconecta();
    }

    public void preencherAtendimetoJuridicoInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Evolução do Interno"};
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
                jtotalRegistros.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdADM_JURI"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Evolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoJuridico.setModel(modelo);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAtendimentoJuridico.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoJuridico.setAutoResizeMode(jTabelaAtendimentoJuridico.AUTO_RESIZE_OFF);
        jTabelaAtendimentoJuridico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAtendimento();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtendimentoJuridico.setModel(modelo);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setPreferredWidth(335);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setPreferredWidth(335);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAtendimentoJuridico.getTableHeader().setReorderingAllowed(false);
        jTabelaAtendimentoJuridico.setAutoResizeMode(jTabelaAtendimentoJuridico.AUTO_RESIZE_OFF);
        jTabelaAtendimentoJuridico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaAtendimento() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAtendimentoJuridico.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherEvolucaoPsicologia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                codigoEvolucao = conecta.rs.getString("IdEvo");
                // Formatar a data Entrada
                dataEvolucao = conecta.rs.getString("DataEvo");
                String diae = dataEvolucao.substring(8, 10);
                String mese = dataEvolucao.substring(5, 7);
                String anoe = dataEvolucao.substring(0, 4);
                dataEvolucao = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvo"), dataEvolucao, conecta.rs.getString("Evolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoJuridica.setModel(modelo);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setPreferredWidth(470);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoJuridica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoJuridica.setAutoResizeMode(jTabelaEvolucaoJuridica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoJuridica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaEvolucao();
        conecta.desconecta();
    }

    public void alinharTabelaEvolucao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoJuridica.setModel(modelo);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setPreferredWidth(470);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoJuridica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoJuridica.setAutoResizeMode(jTabelaEvolucaoJuridica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoJuridica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdADM_JURI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserJURI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserJURI + "'");
            conecta.rs.first();
            codigoUserGroupJURI = conecta.rs.getInt("IdUsuario");
            codigoGrupoJURI = conecta.rs.getInt("IdGrupo");
            nomeGrupoJURI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserJURI + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoJURI = conecta.rs.getInt("IdUsuario");
            codAbrirJURI = conecta.rs.getInt("Abrir");
            codIncluirJURI = conecta.rs.getInt("Incluir");
            codAlterarJURI = conecta.rs.getInt("Alterar");
            codExcluirJURI = conecta.rs.getInt("Excluir");
            codGravarJURI = conecta.rs.getInt("Gravar");
            codConsultarJURI = conecta.rs.getInt("Consultar");
            nomeTelaJURI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoRegistradoAdm() {

        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataLancAD.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIDInternoJuridicoAD.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoJURI = conecta.rs.getInt("IdDepartamento");
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
            pHabilitaJuridico = conecta.rs.getString("AdmissaoJuridico");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarPortaEntrada() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PORTA_ENTRADA "
                    + "WHERE IdInternoCrc='" + jIDInternoJuridico.getText() + "' "
                    + "AND PSPJur='" + deptoTecnico + "' "
                    + "AND HabJur='" + pHABILITA_JURIDICO + "'");
            conecta.rs.first();
            pINTERNOCRC = conecta.rs.getString("IdInternoCrc");
            pDEPARTAMENTO = conecta.rs.getString("PSPJur");
            pHABILITADO = conecta.rs.getString("HabJur");
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
                    + "INNER JOIN ATENDIMENTOJURIDICO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ATENDIMENTOJURIDICO.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ATENDIMENTOJURIDICO.IdInternoCrc='" + jIDInternoJuridico.getText() + " '"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + sitRetorno + "' "
                    + "AND ATENDIMENTOJURIDICO.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
            conecta.rs.first();
            jIdAdmPrincipal.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            jDataLancAD.setDate(conecta.rs.getDate("DataLanc"));
            jIDInternoJuridicoAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoJuridicoAD.setText(conecta.rs.getString("NomeInternoCrc"));
            jMatriculaPenaJuridico.setText(conecta.rs.getString("MatriculaCrc"));
            jDataNascInternoJuriAD.setDate(conecta.rs.getDate("DataNasciCrc"));
            jDataCondIntJuriAD.setDate(conecta.rs.getDate("DataCondenacao"));
            jComboBoxTipoAdvogadoAD.setSelectedItem(conecta.rs.getString("TipoAdvogado"));
            jComboBoxRespostaAD.setSelectedItem(conecta.rs.getString("Resposta"));
            jDataEncaminhamentoAD.setDate(conecta.rs.getDate("DataEnca"));
            jHoraEnvioAD.setText(conecta.rs.getString("HoraEnvio"));
            jEvolucaoAdmissaoAD.setText(conecta.rs.getString("Observacao"));
            if (jComboBoxEncaminharSetorAD.getSelectedItem() != null || jComboBoxEncaminharSetorAD.getSelectedItem().equals("")) {
                jComboBoxEncaminharSetorAD.setSelectedItem(conecta.rs.getString("SetorEncaminhamento"));
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
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIDInternoJuridico.getText() + "' "
                    + "AND SituacaoCrc='" + situacao + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "' "
                    + "OR REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc='" + jIDInternoJuridico.getText() + "' "
                    + "AND SituacaoCrc='" + sitRetorno + "' "
                    + "AND Atendido='" + pATENDIDO_PESQUISA + "' "
                    + "AND IdDepartamento='" + codigoDepartamento + "'");
            conecta.rs.first();
            jIdAdmPrincipal.setText(jIDLanc.getText());
            // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
            codInterno = conecta.rs.getString("IdInternoCrc");
            nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
            jIDInternoJuridicoAD.setText(conecta.rs.getString("IdInternoCrc"));
            jNomeInternoJuridicoAD.setText(conecta.rs.getString("NomeInternoCrc"));
            jDataNascInternoJuriAD.setDate(conecta.rs.getDate("DataNasciCrc"));
            jMatriculaPenaJuridico.setText(conecta.rs.getString("MatriculaCrc"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
