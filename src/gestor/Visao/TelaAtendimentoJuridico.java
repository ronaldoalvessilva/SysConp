/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEvolucaoJuridico;
import gestor.Controle.ControleItensAtividadeJuridico;
import gestor.Controle.ControleJuridico;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovJuridico;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AtendimentoJuridico;
import gestor.Modelo.EvolucaoJuridico;
import gestor.Modelo.ItensAtividadeJuridico;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloJuridico.codAlterarJURI;
import static gestor.Visao.TelaModuloJuridico.codExcluirJURI;
import static gestor.Visao.TelaModuloJuridico.codGravarJURI;
import static gestor.Visao.TelaModuloJuridico.codIncluirJURI;
import static gestor.Visao.TelaModuloJuridico.codConsultarJURI;
import static gestor.Visao.TelaModuloJuridico.codAbrirJURI;
import static gestor.Visao.TelaModuloJuridico.codigoGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserGroupJURI;
import static gestor.Visao.TelaModuloJuridico.codUserAcessoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserJURI;
import static gestor.Visao.TelaModuloJuridico.nomeGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.nomeTelaJURI;
import static gestor.Visao.TelaModuloJuridico.telaAtendimentoJuridicoEvolucaoJURI;
import static gestor.Visao.TelaModuloJuridico.telaAtendimentoJuridicoManuJURI;
import static gestor.Visao.TelaModuloJuridico.telaAtendimentoJuridicoaAtividadesJURI;
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
public class TelaAtendimentoJuridico extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoJuridico objAtendJuri = new AtendimentoJuridico();
    EvolucaoJuridico objEvolu = new EvolucaoJuridico();
    ControleJuridico control = new ControleJuridico();
    ControleMovJuridico controle = new ControleMovJuridico();
    ControleEvolucaoJuridico controleJuri = new ControleEvolucaoJuridico();
    ItensAtividadeJuridico objAtivi = new ItensAtividadeJuridico();
    ControleItensAtividadeJuridico controleItens = new ControleItensAtividadeJuridico();
    // INFORMAR QUE O INTERNO FOI ATENDIDO NA ADMISSÃO E NA EVOLUÇÃO
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
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
    int acao, flag, idItem;
    String dataInicial, dataFinal, dataEntrada, dataEvolucao, dataAtiv;
    String deptoTecnico = "JURIDICO";
    String caminho;
    String statusEvolucao = "EVOLUINDO";
    String situacaoInternoCrc; // Situação do Interno, se ainda está na unidade
    int count;
    //
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
    public static int codigoDepartamentoJURI = 0;
    String tipoAtendimentoAdm = "Admissão Juridico";
    String tipoAtendimentoEvol = "Evolução Juridico";
    //
    String pHabilitaJuridico = "";
    //
    String codigoEvolucao;
    String admEvolucao = "Sim";
    // VETOR PARA GRAVAR CÓDIGO ATIVIDADE NA TELA ATIVIDADES.
    public static int pAtividadeRela[];

    /**
     * Creates new form TelaAtendimentoJuridico
     */
    public static AgendaBeneficiosInternos agendabeneficios;
    public static TelaAtividadesRealizadasADM atividadesADM;

    public TelaAtendimentoJuridico() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampos();
        //REMOVE A ABA DA TELA
        jTabbedPane1.remove(AtividadesRealizadas);
    }

    public void mostrarTela() {
        agendabeneficios = new AgendaBeneficiosInternos(this, true);
        agendabeneficios.setVisible(true);
    }

    public void mostrarAtividadesRealizadas() {
        atividadesADM = new TelaAtividadesRealizadasADM(this, true);
        atividadesADM.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Listagem = new javax.swing.JPanel();
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
        jPanel34 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        Manutencao = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIDInternoJuridico = new javax.swing.JTextField();
        jNomeInternoJuridico = new javax.swing.JTextField();
        jBtPesqInternoJuridico = new javax.swing.JButton();
        jMatriculaPenaJuridico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDataNascInternoJuri = new com.toedter.calendar.JDateChooser();
        jDataCondIntJuri = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jIDLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
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
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jEvolucaoAdmissao = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxTipoAdvogado = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEncaminharSetor = new javax.swing.JComboBox();
        jDataEncaminhamento = new com.toedter.calendar.JDateChooser();
        jComboBoxResposta = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jHoraEnvio = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jFotoInternoJuridico = new javax.swing.JLabel();
        AtividadesRealizadas = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdAtiv = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jAtividadeRealizada = new javax.swing.JTextField();
        jBtPesqAtividade = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jNomeInternoAtividade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDataAtividade = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jBtNovaAtividade = new javax.swing.JButton();
        jBtAlterarAtividade = new javax.swing.JButton();
        jBtExcluirAtividade = new javax.swing.JButton();
        jBtSalvarAtividade = new javax.swing.JButton();
        jBtCancelarAtividade = new javax.swing.JButton();
        jBtAuditoriaAtividade = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaAtividades = new javax.swing.JTable();
        Evolucao = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jIdEvolucao = new javax.swing.JTextField();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jNomeInternoEvolucao = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaEvolucaoJuridica = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEvolucao = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxTipoAdvogadoEvo = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxEncaminharSetorEvo = new javax.swing.JComboBox();
        jDataEncaminhamentoEvo = new com.toedter.calendar.JDateChooser();
        jComboBoxRespostaEvo = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jHoraEnvioEvo = new javax.swing.JFormattedTextField();
        jBtAgendarBeneficio = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setClosable(true);
        setIconifiable(true);
        setTitle("....::: Atendimento Juridico {JU} :::...");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
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
                {null, null, null, null, null}
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

        javax.swing.GroupLayout ListagemLayout = new javax.swing.GroupLayout(Listagem);
        Listagem.setLayout(ListagemLayout);
        ListagemLayout.setHorizontalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(ListagemLayout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ListagemLayout.setVerticalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", Listagem);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Matricula Penal");

        jIDInternoJuridico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInternoJuridico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInternoJuridico.setEnabled(false);

        jNomeInternoJuridico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoJuridico.setEnabled(false);

        jBtPesqInternoJuridico.setForeground(new java.awt.Color(51, 102, 0));
        jBtPesqInternoJuridico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoJuridico.setToolTipText("Pesquisar Interno");
        jBtPesqInternoJuridico.setContentAreaFilled(false);
        jBtPesqInternoJuridico.setEnabled(false);
        jBtPesqInternoJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoJuridicoActionPerformed(evt);
            }
        });

        jMatriculaPenaJuridico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenaJuridico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenaJuridico.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nascimento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Condenação");

        jDataNascInternoJuri.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascInternoJuri.setEnabled(false);

        jDataCondIntJuri.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCondIntJuri.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Atend.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Status");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data");

        jIDLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIDInternoJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jStatusLanc)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jBtPesqInternoJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jMatriculaPenaJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDataCondIntJuri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jDataNascInternoJuri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addComponent(jNomeInternoJuridico)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIDInternoJuridico, jIDLanc});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataNascInternoJuri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCondIntJuri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenaJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInternoJuridico)
                    .addComponent(jIDInternoJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoJuridico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addGap(27, 27, 27)
                .addComponent(jBtAdividadesRealizadasADM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelar)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtAuditoria)
                            .addComponent(jBtAdividadesRealizadasADM))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evolução da Admissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jEvolucaoAdmissao.setColumns(20);
        jEvolucaoAdmissao.setRows(5);
        jEvolucaoAdmissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEvolucaoAdmissao.setEnabled(false);
        jScrollPane5.setViewportView(jEvolucaoAdmissao);

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
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tipo  de Advogado");

        jComboBoxTipoAdvogado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoAdvogado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Unidade", "Particular", "Defensor Público" }));
        jComboBoxTipoAdvogado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoAdvogado.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Encaminhado para outro Setor");

        jComboBoxEncaminharSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEncaminharSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxEncaminharSetor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEncaminharSetor.setEnabled(false);
        jComboBoxEncaminharSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEncaminharSetorActionPerformed(evt);
            }
        });

        jDataEncaminhamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEncaminhamento.setEnabled(false);

        jComboBoxResposta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxResposta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Não", "Sim" }));
        jComboBoxResposta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxResposta.setEnabled(false);
        jComboBoxResposta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRespostaItemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Qual Setor foi Encamihado? ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Horário");

        jHoraEnvio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraEnvio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jHoraEnvio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraEnvio.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxEncaminharSetor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipoAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxResposta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jHoraEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEncaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEncaminharSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoJuridico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoJuridico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ManutencaoLayout = new javax.swing.GroupLayout(Manutencao);
        Manutencao.setLayout(ManutencaoLayout);
        ManutencaoLayout.setHorizontalGroup(
            ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManutencaoLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ManutencaoLayout.setVerticalGroup(
            ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Admissão", Manutencao);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atividades Realizadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIdAtiv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAtiv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAtiv.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Descrição da Atividade");

        jAtividadeRealizada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtividadeRealizada.setEnabled(false);

        jBtPesqAtividade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqAtividade.setForeground(new java.awt.Color(255, 0, 0));
        jBtPesqAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqAtividade.setToolTipText("Pesquisar");
        jBtPesqAtividade.setContentAreaFilled(false);
        jBtPesqAtividade.setEnabled(false);
        jBtPesqAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqAtividadeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Código");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nome Completo do Interno");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jNomeInternoAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAtividade.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data");

        jDataAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtividade.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jIdAtiv)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jNomeInternoAtividade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jAtividadeRealizada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdAtiv, jIdInterno});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAtividadeRealizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqAtividade))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jAtividadeRealizada, jNomeInternoAtividade});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdAtiv, jIdInterno});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovaAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaAtividade.setText("Novo");
        jBtNovaAtividade.setToolTipText("Novo");
        jBtNovaAtividade.setContentAreaFilled(false);
        jBtNovaAtividade.setEnabled(false);
        jBtNovaAtividade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaAtividade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaAtividade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaAtividadeActionPerformed(evt);
            }
        });

        jBtAlterarAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAtividade.setText("Alterar");
        jBtAlterarAtividade.setToolTipText("Alterar");
        jBtAlterarAtividade.setContentAreaFilled(false);
        jBtAlterarAtividade.setEnabled(false);
        jBtAlterarAtividade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAtividade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAtividade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAtividadeActionPerformed(evt);
            }
        });

        jBtExcluirAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAtividade.setText("Excluir");
        jBtExcluirAtividade.setToolTipText("Excluir");
        jBtExcluirAtividade.setContentAreaFilled(false);
        jBtExcluirAtividade.setEnabled(false);
        jBtExcluirAtividade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAtividade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAtividade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAtividadeActionPerformed(evt);
            }
        });

        jBtSalvarAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAtividade.setText("Gravar");
        jBtSalvarAtividade.setToolTipText("Gravar");
        jBtSalvarAtividade.setContentAreaFilled(false);
        jBtSalvarAtividade.setEnabled(false);
        jBtSalvarAtividade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAtividade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAtividade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAtividadeActionPerformed(evt);
            }
        });

        jBtCancelarAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAtividade.setText("Cancelar");
        jBtCancelarAtividade.setToolTipText("Cancelar");
        jBtCancelarAtividade.setContentAreaFilled(false);
        jBtCancelarAtividade.setEnabled(false);
        jBtCancelarAtividade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAtividade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAtividade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAtividadeActionPerformed(evt);
            }
        });

        jBtAuditoriaAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAtividade.setToolTipText("Auditoria");
        jBtAuditoriaAtividade.setContentAreaFilled(false);
        jBtAuditoriaAtividade.setEnabled(false);
        jBtAuditoriaAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAtividadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jBtNovaAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovaAtividade)
                .addComponent(jBtAlterarAtividade)
                .addComponent(jBtExcluirAtividade)
                .addComponent(jBtSalvarAtividade)
                .addComponent(jBtCancelarAtividade)
                .addComponent(jBtAuditoriaAtividade))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarAtividade, jBtCancelarAtividade, jBtExcluirAtividade, jBtNovaAtividade, jBtSalvarAtividade});

        jTabelaAtividades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                " Código ", "Descrição das Atividades", "Data"
            }
        ));
        jTabelaAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtividadesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaAtividades);
        if (jTabelaAtividades.getColumnModel().getColumnCount() > 0) {
            jTabelaAtividades.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(1).setMinWidth(460);
            jTabelaAtividades.getColumnModel().getColumn(1).setMaxWidth(460);
            jTabelaAtividades.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaAtividades.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        javax.swing.GroupLayout AtividadesRealizadasLayout = new javax.swing.GroupLayout(AtividadesRealizadas);
        AtividadesRealizadas.setLayout(AtividadesRealizadasLayout);
        AtividadesRealizadasLayout.setHorizontalGroup(
            AtividadesRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AtividadesRealizadasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AtividadesRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                .addContainerGap())
        );
        AtividadesRealizadasLayout.setVerticalGroup(
            AtividadesRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AtividadesRealizadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Atividades Realizadas", AtividadesRealizadas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evolução", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Código");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Data Evolução");

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome Completo do Interno");

        jNomeInternoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolucao.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jNomeInternoEvolucao)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel10))
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaEvolucaoJuridica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoJuridica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Evolução"
            }
        ));
        jTabelaEvolucaoJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoJuridicaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaEvolucaoJuridica);
        if (jTabelaEvolucaoJuridica.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setMinWidth(470);
            jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setMaxWidth(470);
        }

        jEvolucao.setColumns(20);
        jEvolucao.setRows(5);
        jEvolucao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEvolucao.setEnabled(false);
        jScrollPane1.setViewportView(jEvolucao);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setToolTipText("Novo");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setToolTipText("Alterar");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setToolTipText("Cancelar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBtAlterarEvolucao)
                .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jBtExcluirEvolucao)
                .addComponent(jBtCancelarEvolucao)
                .addComponent(jBtNovaEvolucao))
            .addComponent(jBtAuditoriaEvolucao)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarEvolucao, jBtAuditoriaEvolucao, jBtCancelarEvolucao, jBtExcluirEvolucao, jBtNovaEvolucao, jBtSalvarEvolucao});

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Tipo  de Advogado");

        jComboBoxTipoAdvogadoEvo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoAdvogadoEvo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Unidade", "Particular", "Defensor Público" }));
        jComboBoxTipoAdvogadoEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoAdvogadoEvo.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Encaminhado para outro Setor");

        jComboBoxEncaminharSetorEvo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEncaminharSetorEvo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxEncaminharSetorEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEncaminharSetorEvo.setEnabled(false);
        jComboBoxEncaminharSetorEvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEncaminharSetorEvoActionPerformed(evt);
            }
        });

        jDataEncaminhamentoEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEncaminhamentoEvo.setEnabled(false);

        jComboBoxRespostaEvo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRespostaEvo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Não", "Sim" }));
        jComboBoxRespostaEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRespostaEvo.setEnabled(false);
        jComboBoxRespostaEvo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRespostaEvoItemStateChanged(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Qual Setor foi Encamihado? ");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Horário");

        jHoraEnvioEvo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraEnvioEvo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jHoraEnvioEvo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHoraEnvioEvo.setEnabled(false);

        jBtAgendarBeneficio.setForeground(new java.awt.Color(255, 0, 0));
        jBtAgendarBeneficio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/270818133638_16.png"))); // NOI18N
        jBtAgendarBeneficio.setToolTipText("Agendar Beneficio");
        jBtAgendarBeneficio.setEnabled(false);
        jBtAgendarBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAgendarBeneficioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(0, 271, Short.MAX_VALUE))
                            .addComponent(jComboBoxEncaminharSetorEvo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEncaminhamentoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jHoraEnvioEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxTipoAdvogadoEvo, 0, 282, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(125, 125, 125))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jComboBoxRespostaEvo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtAgendarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAgendarBeneficio)
                    .addComponent(jComboBoxRespostaEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoAdvogadoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxEncaminharSetorEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEncaminhamentoEvo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHoraEnvioEvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout EvolucaoLayout = new javax.swing.GroupLayout(Evolucao);
        Evolucao.setLayout(EvolucaoLayout);
        EvolucaoLayout.setHorizontalGroup(
            EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EvolucaoLayout.setVerticalGroup(
            EvolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Evolução", Evolucao);

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

        setBounds(300, 10, 654, 559);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIDPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIDPesqActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o ID para pesquisa.");
            jIDPesq.requestFocus();
        } else {
            preencherAtendimetoJuridico("SELECT * FROM ATENDIMENTOJURIDICO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ATENDIMENTOJURIDICO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ATENDIMENTOJURIDICO.IdLanc='" + jIDPesq.getText() + "'");
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
            preencherAtendimetoJuridico("SELECT * FROM ATENDIMENTOJURIDICO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ATENDIMENTOJURIDICO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
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
                    preencherAtendimetoJuridico("SELECT * FROM ATENDIMENTOJURIDICO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ATENDIMENTOJURIDICO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codIncluirJURI == 1) {
            acao = 1;
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
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codAlterarJURI == 1) {
            objAtendJuri.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                preencherComboBoxDepartamento();
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
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codExcluirJURI == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAtendJuri.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse antedimento não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o atendimento selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    control.excluirAtendJuridico(objAtendJuri);
                    objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());;
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    controle.excluirMovTec(objAtendJuri);
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
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de atendimento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                objAtendJuri.setStatusLanc(jStatusLanc.getText());
                objAtendJuri.setDataLanc(jDataLanc.getDate());
                objAtendJuri.setObservacao(jEvolucaoAdmissao.getText());
                objAtendJuri.setDataEnca(jDataEncaminhamento.getDate());
                objAtendJuri.setSetorEncaminhameto((String) jComboBoxEncaminharSetor.getSelectedItem());
                objAtendJuri.setTipoAdvogado((String) jComboBoxTipoAdvogado.getSelectedItem());
                objAtendJuri.setHoraEnvio(jHoraEnvio.getText());
                objAtendJuri.setResposta((String) jComboBoxResposta.getSelectedItem());
                if (acao == 1) {
                    // log de usuario
                    objAtendJuri.setUsuarioInsert(nameUser);
                    objAtendJuri.setDataInsert(dataModFinal);
                    objAtendJuri.setHoraInsert(horaMov);
                    objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
                    control.incluirAtendJuridico(objAtendJuri);
                    buscarID();
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
                    objAtendJuri.setDeptoJuridico(deptoTecnico);
                    controle.incluirMovTec(objAtendJuri);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO                             
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoJuridico.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoJURI);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataLanc.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIDLanc.getText()));
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    // PRIMEIRA EVOLUÇÃO EM CONJUNTO COM A ADMISSÃO
                    objEvolu.setDataEvo(jDataLanc.getDate());
                    objEvolu.setDataEnca(jDataEncaminhamento.getDate());
                    objEvolu.setTipoAdvogado((String) jComboBoxTipoAdvogado.getSelectedItem());
                    objEvolu.setResposta((String) jComboBoxResposta.getSelectedItem());
                    objEvolu.setHoraEnvio(jHoraEnvio.getText());
                    objEvolu.setSetorEncaminhamento((String) jComboBoxEncaminharSetor.getSelectedItem());
                    objEvolu.setEvolucao(jEvolucaoAdmissao.getText());
                    objEvolu.setAdmEvo(admEvolucao);
                    // log de usuario
                    objEvolu.setUsuarioInsert(nameUser);
                    objEvolu.setDataInsert(jDataSistema.getText());
                    objEvolu.setHorarioInsert(jHoraSistema.getText());
                    //
                    objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    controleJuri.incluirEvolucaoJuridico(objEvolu);
                    // BUSCAR O CÓDIGO DA EVOLUÇÃO CASO O USUÁRIO QUEIRA ALTERAR A EVOLUÇÃO INICIAL.
                    buscarIdEvolucao();
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                            + "WHERE IdLanc='" + jIDLanc.getText() + "'");
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    // log de usuario
                    objAtendJuri.setUsuarioUp(nameUser);
                    objAtendJuri.setDataUp(dataModFinal);
                    objAtendJuri.setHoraUp(horaMov);
                    objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    control.alterarAtendJuridico(objAtendJuri);
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
                    objAtendJuri.setDeptoJuridico(deptoTecnico);
                    controle.alterarMovTec(objAtendJuri);
                    // Se o interno for modificado, altera também na tabela de ITENSATENDIMENTOJURI.
                    objAtendJuri.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objAtivi.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objAtivi.setNomeInternoCrc(jNomeInternoJuridico.getText());
                    controleItens.alterarInternoAtividade(objAtivi);
                    // Modifica o código do interno na tabela EVOLUCAOJURIDICO
                    objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objEvolu.setNomeInternoCrc(jNomeInternoJuridico.getText());
                    controleJuri.alterarInternoEvolucaoJuridico(objEvolu);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    // MODIFICAR A EVOLUÇÃO CASO SEJA MODIFICADA
                    // log de usuario
                    objEvolu.setUsuarioUp(nameUser);
                    objEvolu.setDataUp(jDataSistema.getText());
                    objEvolu.setHorarioUp(jHoraSistema.getText());
                    //
                    objEvolu.setDataEvo(jDataLanc.getDate());
                    objEvolu.setDataEnca(jDataEncaminhamento.getDate());
                    objEvolu.setTipoAdvogado((String) jComboBoxTipoAdvogado.getSelectedItem());
                    objEvolu.setResposta((String) jComboBoxResposta.getSelectedItem());
                    objEvolu.setHoraEnvio(jHoraEnvio.getText());
                    objEvolu.setSetorEncaminhamento((String) jComboBoxEncaminharSetor.getSelectedItem());
                    objEvolu.setEvolucao(jEvolucaoAdmissao.getText());
                    objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objEvolu.setIdEvo(Integer.valueOf(codigoEvolucao));
                    controleJuri.alterarEvolucaoJuridico(objEvolu);
                    preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                            + "WHERE IdLanc='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
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
            conecta.executaSQL("SELECT * FROM ATENDIMENTOJURIDICO WHERE IdLanc='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

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
            jBtNovaEvolucao.setEnabled(true);
            jBtNovaAtividade.setEnabled(true);
            jBtAgendarBeneficio.setEnabled(true);
            //
            jIdInterno.setText("");
            jNomeInternoAtividade.setText("");
            jDataAtividade.setDate(null);
            jIdAtiv.setText("");
            jAtividadeRealizada.setText("");
            jIdEvolucao.setText("");
            jNomeInternoEvolucao.setText("");
            jDataEvolucao.setDate(null);
            //
            jDataLanc.setEnabled(!true);
            jIdInterno.setEnabled(!true);
            jNomeInternoAtividade.setEnabled(!true);
            jDataAtividade.setEnabled(!true);
            jIdAtiv.setEnabled(!true);
            jAtividadeRealizada.setEnabled(!true);
            jIdEvolucao.setEnabled(!true);
            jNomeInternoEvolucao.setEnabled(!true);
            jDataEvolucao.setEnabled(!true);
            jBtPesqInternoJuridico.setEnabled(!true);
            jComboBoxTipoAdvogado.setEnabled(!true);
            jComboBoxResposta.setEnabled(!true);
            jComboBoxEncaminharSetor.setEnabled(!true);
            jEvolucaoAdmissao.setEnabled(!true);
            //
            jIdEvolucao.setText("");
            jAtividadeRealizada.setText("");
            jDataEvolucao.setDate(null);
            jEvolucao.setText("");
            preencherComboBoxDepartamento();
            // LIMPAR AS TABELAS ANTES DE EXIBIR AS OUTRAS
            limparTabelaAtividades();
            limparTabelaEvolucao();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATENDIMENTOJURIDICO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ATENDIMENTOJURIDICO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "WHERE ATENDIMENTOJURIDICO.IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jIDInternoJuridico.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoJuridico.setText(conecta.rs.getString("NomeInternoCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoJuridico.setIcon(i);
                jFotoInternoJuridico.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoJuridico.getWidth(), jFotoInternoJuridico.getHeight(), Image.SCALE_DEFAULT)));
                jMatriculaPenaJuridico.setText(conecta.rs.getString("MatriculaCrc"));
                jDataNascInternoJuri.setDate(conecta.rs.getDate("DataNasciCrc"));
                jDataCondIntJuri.setDate(conecta.rs.getDate("DataCondenacao"));
                jComboBoxTipoAdvogado.setSelectedItem(conecta.rs.getString("TipoAdvogado"));
                jComboBoxResposta.setSelectedItem(conecta.rs.getString("Resposta"));
                jDataEncaminhamento.setDate(conecta.rs.getDate("DataEnca"));
                jHoraEnvio.setText(conecta.rs.getString("HoraEnvio"));
                jEvolucaoAdmissao.setText(conecta.rs.getString("Observacao"));
                if (jComboBoxEncaminharSetor.getSelectedItem() != null || jComboBoxEncaminharSetor.getSelectedItem().equals("")) {
                    jComboBoxEncaminharSetor.setSelectedItem(conecta.rs.getString("SetorEncaminhamento"));
                }
            } catch (SQLException e) {
            }
            preencherAtividadeJuri("SELECT * FROM ITENSATENDIMENTOJURI "
                    + "INNER JOIN ATIVIDADESJURIDICOS "
                    + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                    + "INNER JOIN ATENDIMENTOJURIDICO "
                    + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                    + "WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "' "
                    + "AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
            preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                    + "INNER JOIN ATENDIMENTOJURIDICO "
                    + "ON EVOLUCAOJURIDICO.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                    + "WHERE EVOLUCAOJURIDICO.IdLanc='" + jIDLanc.getText() + "' "
                    + "AND EVOLUCAOJURIDICO.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
        }
        conecta.desconecta();
    }//GEN-LAST:event_jTabelaAtendimentoJuridicoMouseClicked

    private void jBtPesqInternoJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoJuridicoActionPerformed
        // TODO add your handling code here:
        verificarRegistroBiometria();
        if (pHabilitaJuridico.equals("Não")) {
            TelaPesqInternoAtendJuridico objPesqInterJuridico = new TelaPesqInternoAtendJuridico();
            TelaModuloJuridico.jPainelJuridico.add(objPesqInterJuridico);
            objPesqInterJuridico.show();
        } else {
            TelaPesqInternoAtendJuridicoBio objPesqInterJuridico = new TelaPesqInternoAtendJuridicoBio();
            TelaModuloJuridico.jPainelJuridico.add(objPesqInterJuridico);
            objPesqInterJuridico.show();
        }
    }//GEN-LAST:event_jBtPesqInternoJuridicoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAtendimetoJuridico("SELECT * FROM ATENDIMENTOJURIDICO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ATENDIMENTOJURIDICO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAtendJuri objAudiJuri = new TelaAuditoriaAtendJuri();
        TelaModuloJuridico.jPainelJuridico.add(objAudiJuri);
        objAudiJuri.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoEvolucaoJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoEvolucaoJURI) && codIncluirJURI == 1) {
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
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoEvolucaoJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoEvolucaoJURI) && codAlterarJURI == 1) {
            verificarEvolucaoAdmissao();
            if (admEvolucao == null) {
                acao = 4;
                AlterarEvolucao();
                preencherComboBoxDepartamento();
            } else if (admEvolucao.equals("")) {
                acao = 4;
                AlterarEvolucao();
                preencherComboBoxDepartamento();
            } else if (admEvolucao.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Essa evolução não poderá ser alterada nessa tela, será necessário alterar na admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoEvolucaoJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoEvolucaoJURI) && codExcluirJURI == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a evolução selecionada?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEvolu.setIdEvo(Integer.valueOf(jIdEvolucao.getText()));
                objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                controleJuri.excluirEvolucaoJuridico(objEvolu);
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                ExcluirEvolucao();
                preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO WHERE IdLanc='" + jIDLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoEvolucaoJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoEvolucaoJURI) && codGravarJURI == 1) {
            verificarSituacaoInternoCrc();
            deptoTecnico = "EVOLUÇÃO NO JURIDICO";
            if (jDataEvolucao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de evolução.");
                jDataEvolucao.requestFocus();
            } else {
                objEvolu.setDataEvo(jDataEvolucao.getDate());
                objEvolu.setDataEnca(jDataEncaminhamentoEvo.getDate());
                objEvolu.setTipoAdvogado((String) jComboBoxTipoAdvogadoEvo.getSelectedItem());
                objEvolu.setResposta((String) jComboBoxRespostaEvo.getSelectedItem());
                objEvolu.setHoraEnvio(jHoraEnvioEvo.getText());
                objEvolu.setSetorEncaminhamento((String) jComboBoxEncaminharSetorEvo.getSelectedItem());
                objEvolu.setEvolucao(jEvolucao.getText());
                if (acao == 3) {
                    if (situacaoInternoCrc.equals("ENTRADA NA UNIDADE") || situacaoInternoCrc.equals("RETORNO A UNIDADE")) {
                        // log de usuario
                        objEvolu.setUsuarioInsert(nameUser);
                        objEvolu.setDataInsert(jDataSistema.getText());
                        objEvolu.setHorarioInsert(jHoraSistema.getText());
                        //
                        objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                        objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                        controleJuri.incluirEvolucaoJuridico(objEvolu);
                        //
                        buscarIdEvolucao();
                        //
                        objAtendJuri.setIdLanc(Integer.valueOf(jIdEvolucao.getText()));
                        objAtendJuri.setStatusLanc(statusEvolucao);
                        objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
                        objAtendJuri.setDeptoJuridico(deptoTecnico);
                        objAtendJuri.setDataLanc(jDataEvolucao.getDate());
                        controle.incluirMovTec(objAtendJuri);
                        // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                        atendido = "Sim";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoJuridico.getText());
                        objRegAtend.setIdDepartamento(codigoDepartamentoJURI);
                        objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataEvolucao.getDate());
                        objRegAtend.setIdAtend(Integer.valueOf(jIDLanc.getText()));
                        objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucao.getText()));
                        objRegAtend.setAtendeEvol(atendido);
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegEvol(objRegAtend);
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                                + "WHERE IdLanc='" + jIDLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarEvolucao();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno não se encontra mais na unidade.");
                    }
                }
                if (acao == 4) {
                    if (situacaoInternoCrc.equals("ENTRADA NA UNIDADE") || situacaoInternoCrc.equals("RETORNO A UNIDADE")) {
                        // log de usuario
                        objEvolu.setUsuarioUp(nameUser);
                        objEvolu.setDataUp(jDataSistema.getText());
                        objEvolu.setHorarioUp(jHoraSistema.getText());
                        //
                        objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                        objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                        objEvolu.setIdEvo(Integer.valueOf(jIdEvolucao.getText()));
                        controleJuri.alterarEvolucaoJuridico(objEvolu);
                        //
                        objAtendJuri.setIdLanc(Integer.valueOf(jIdEvolucao.getText()));
                        objAtendJuri.setStatusLanc(statusEvolucao);
                        objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
                        objAtendJuri.setDeptoJuridico(deptoTecnico);
                        objAtendJuri.setDataLanc(jDataEvolucao.getDate());
                        controle.alterarMovTec(objAtendJuri);
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                                + "WHERE IdLanc='" + jIDLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarEvolucao();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno não se encontra mais na unidade.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoJuridico audiEvoJu = new TelaAuditoriaEvolucaoJuridico();
        TelaModuloJuridico.jPainelJuridico.add(audiEvoJu);
        audiEvoJu.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaEvolucaoJuridicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoJuridicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdEvolucao = "" + jTabelaEvolucaoJuridica.getValueAt(jTabelaEvolucaoJuridica.getSelectedRow(), 0);
            jIdEvolucao.setText(IdEvolucao);
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            try {
                conecta.abrirConexao();
                conecta.executaSQL("SELECT * FROM EVOLUCAOJURIDICO WHERE IdEvo='" + IdEvolucao + "'");
                conecta.rs.first();
                jIdEvolucao.setText(conecta.rs.getString("IdEvo"));
                jDataEvolucao.setDate(conecta.rs.getDate("DataEvo"));
                jNomeInternoEvolucao.setText(jNomeInternoJuridico.getText());
                jEvolucao.setText(conecta.rs.getString("Evolucao"));
                //
                jComboBoxTipoAdvogadoEvo.setSelectedItem(conecta.rs.getString("TipoAdvogado"));
                jComboBoxRespostaEvo.setSelectedItem(conecta.rs.getString("Resposta"));
                jDataEncaminhamentoEvo.setDate(conecta.rs.getDate("DataEnca"));
                jHoraEnvioEvo.setText(conecta.rs.getString("HoraEnvio"));
                if (jComboBoxEncaminharSetorEvo.getSelectedItem() != null || jComboBoxEncaminharSetorEvo.getSelectedItem().equals("")) {
                    jComboBoxEncaminharSetorEvo.setSelectedItem(conecta.rs.getString("SetorEncaminhamento"));
                }
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoJuridicaMouseClicked

    private void jBtNovaAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaAtividadeActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codIncluirJURI == 1) {
            acao = 5;
            NovaAtividade();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovaAtividadeActionPerformed

    private void jBtAlterarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAtividadeActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codAlterarJURI == 1) {
            acao = 6;
            AlterarAtividade();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarAtividadeActionPerformed

    private void jBtExcluirAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAtividadeActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codExcluirJURI == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAtendJuri.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir  a atividade selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtivi.setIdItem(Integer.valueOf(idItem));
                    controleItens.excluirAtividade(objAtivi);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirAtividade();
                    preencherAtividadeJuri("SELECT * FROM ITENSATENDIMENTOJURI INNER JOIN ATIVIDADESJURIDICOS ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv INNER JOIN ATENDIMENTOJURIDICO ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirAtividadeActionPerformed

    private void jBtSalvarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAtividadeActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codGravarJURI == 1) {
            verificarSituacaoInternoCrc();
            if (jDataAtividade.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da atividade.");
            } else {
                if (jAtividadeRealizada.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe qual é a atividade.");
                } else {
                    objAtivi.setDataItem(jDataAtividade.getDate());
                    objAtivi.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    if (acao == 5) {
                        if (situacaoInternoCrc.equals("ENTRADA NA UNIDADE") || situacaoInternoCrc.equals("RETORNO A UNIDADE")) {
                            // log de usuario
                            objAtivi.setUsuarioInsert(nameUser);
                            objAtivi.setDataInsert(dataModFinal);
                            objAtivi.setHorarioInsert(horaMov);
                            objAtivi.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                            objAtivi.setDescricaoAtividade(jAtividadeRealizada.getText());
                            controleItens.incluirAtividade(objAtivi);
                            buscarCodAtividade();
                            //
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherAtividadeJuri("SELECT * FROM ITENSATENDIMENTOJURI "
                                    + "INNER JOIN ATIVIDADESJURIDICOS "
                                    + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                                    + "INNER JOIN ATENDIMENTOJURIDICO "
                                    + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                                    + "WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "' "
                                    + "AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
                            SalvarAtividade();
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Esse interno não se encontra mais na unidade.");
                        }
                    }
                    if (acao == 6) {
                        if (situacaoInternoCrc.equals("ENTRADA NA UNIDADE") || situacaoInternoCrc.equals("RETORNO A UNIDADE")) {
                            // log de usuario
                            objAtivi.setUsuarioUp(nameUser);
                            objAtivi.setDataUp(dataModFinal);
                            objAtivi.setHorarioUp(horaMov);
                            objAtivi.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                            objAtivi.setDescricaoAtividade(jAtividadeRealizada.getText());
                            objAtivi.setIdAtiv(Integer.valueOf(jIdAtiv.getText()));
                            objAtivi.setIdItem(Integer.valueOf(idItem));
                            controleItens.alterarAtividade(objAtivi);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                            preencherAtividadeJuri("SELECT * FROM ITENSATENDIMENTOJURI "
                                    + "INNER JOIN ATIVIDADESJURIDICOS "
                                    + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                                    + "INNER JOIN ATENDIMENTOJURIDICO "
                                    + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                                    + "WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "'AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                            SalvarAtividade();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Esse interno não se encontra mais na unidade.");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarAtividadeActionPerformed

    private void jBtCancelarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAtividadeActionPerformed
        // TODO add your handling code here:
        CancelarAtividade();
    }//GEN-LAST:event_jBtCancelarAtividadeActionPerformed

    private void jBtAuditoriaAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAtividadeActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAtividadesRealizadasItensJu objAudiItensAtiv = new TelaAuditoriaAtividadesRealizadasItensJu();
        TelaModuloJuridico.jPainelJuridico.add(objAudiItensAtiv);
        objAudiItensAtiv.show();
    }//GEN-LAST:event_jBtAuditoriaAtividadeActionPerformed

    private void jBtPesqAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqAtividadeActionPerformed
        // TODO add your handling code here:
        TelaPesqAtiviadadesJuridicas objPesqAtiv = new TelaPesqAtiviadadesJuridicas();
        TelaModuloJuridico.jPainelJuridico.add(objPesqAtiv);
        objPesqAtiv.show();
    }//GEN-LAST:event_jBtPesqAtividadeActionPerformed

    private void jTabelaAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtividadesMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String DescicaoAtiv = "" + jTabelaAtividades.getValueAt(jTabelaAtividades.getSelectedRow(), 1);
            jBtNovaAtividade.setEnabled(!true);
            jBtAlterarAtividade.setEnabled(true);
            jBtExcluirAtividade.setEnabled(true);
            jBtSalvarAtividade.setEnabled(!true);
            jBtCancelarAtividade.setEnabled(true);
            jBtAuditoriaAtividade.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSATENDIMENTOJURI "
                        + "INNER JOIN ATIVIDADESJURIDICOS "
                        + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                        + "INNER JOIN ATENDIMENTOJURIDICO "
                        + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                        + "WHERE DescricaoAtiv='" + DescicaoAtiv + "' "
                        + "AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(jIDInternoJuridico.getText());
                jNomeInternoAtividade.setText(jNomeInternoJuridico.getText());
                idItem = conecta.rs.getInt("IdItem");
                jIdAtiv.setText(String.valueOf(conecta.rs.getInt("IdAtiv")));
                jDataAtividade.setDate(conecta.rs.getDate("DataItem"));
                jAtividadeRealizada.setText(conecta.rs.getString("DescricaoAtiv"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaAtividadesMouseClicked

    private void jComboBoxRespostaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRespostaItemStateChanged
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            if (jComboBoxResposta.getSelectedItem().equals("Sim")) {
                jDataEncaminhamento.setCalendar(Calendar.getInstance());
                jHoraEnvio.setText(jHoraSistema.getText());
                jDataEncaminhamento.setEnabled(true);
                jComboBoxEncaminharSetor.setEnabled(true);
                jHoraEnvio.setEnabled(true);
            } else {
                jDataEncaminhamento.setDate(null);
                jHoraEnvio.setText("");
                jDataEncaminhamento.setEnabled(!true);
                jComboBoxEncaminharSetor.setSelectedItem("Selecione");
                jComboBoxEncaminharSetor.setEnabled(!true);
                jComboBoxResposta.setEnabled(!true);
                jHoraEnvio.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jComboBoxRespostaItemStateChanged

    private void jComboBoxEncaminharSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEncaminharSetorActionPerformed
        // TODO add your handling code here:
        preencherComboBoxDepartamento();
    }//GEN-LAST:event_jComboBoxEncaminharSetorActionPerformed

    private void jComboBoxRespostaEvoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRespostaEvoItemStateChanged
        // TODO add your handling code here:   
        if (acao == 3 || acao == 4) {
            if (jComboBoxRespostaEvo.getSelectedItem().equals("Sim")) {
                jDataEncaminhamentoEvo.setCalendar(Calendar.getInstance());
                jHoraEnvioEvo.setText(jHoraSistema.getText());
                jDataEncaminhamentoEvo.setEnabled(true);
                jComboBoxEncaminharSetorEvo.setEnabled(true);
                jHoraEnvioEvo.setEnabled(true);
            } else {
                jDataEncaminhamentoEvo.setDate(null);
                jHoraEnvioEvo.setText("");
                jDataEncaminhamentoEvo.setEnabled(!true);
                jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione");
                jComboBoxEncaminharSetorEvo.setEnabled(!true);
                jComboBoxRespostaEvo.setEnabled(true);
                jHoraEnvioEvo.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jComboBoxRespostaEvoItemStateChanged

    private void jComboBoxEncaminharSetorEvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEncaminharSetorEvoActionPerformed
        // TODO add your handling code here:
        preencherComboBoxDepartamento();
    }//GEN-LAST:event_jComboBoxEncaminharSetorEvoActionPerformed

    private void jBtAgendarBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAgendarBeneficioActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_BENEFICIO_INTERNOS "
                    + "INNER JOIN ITENS_AGENDA_BENEFICIO_INTERNOS "
                    + "ON AGENDA_BENEFICIO_INTERNOS.IdReg=ITENS_AGENDA_BENEFICIO_INTERNOS.IdReg "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_AGENDA_BENEFICIO_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_AGENDA_BENEFICIO_INTERNOS.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
            conecta.rs.first();
            codigoTipoBeneficio = conecta.rs.getString("TipoBeneficio");
            codigoStatusReg = conecta.rs.getString("StatusReg");
            codigoInterno = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        if (jIDInternoJuridico.getText().equals(codigoInterno) && beneficioSaidaTmp.equals(codigoTipoBeneficio) && statusAgenda.equals(codigoStatusReg)) {
            int resposta = JOptionPane.showConfirmDialog(this, "Já existe um agendamento de SAÍDA TEMPORARIA para esse interno.Deseja fazer outro agendamento de SAÍDA TEMPORARIA?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                mostrarTela();
            }
        } else if (jIDInternoJuridico.getText().equals(codigoInterno) && beneficioProgressao.equals(codigoTipoBeneficio) && statusAgenda.equals(codigoStatusReg)) {
            int resposta = JOptionPane.showConfirmDialog(this, "Já existe um agendamento de PROGRESSÃO DE REGIME para esse interno.Deseja fazer outro agendamento de PROGRESSÃO DE REGIME?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                mostrarTela();
            }
        } else if (jIDInternoJuridico.getText().equals(codigoInterno) && beneficioLivramento.equals(codigoTipoBeneficio) && statusAgenda.equals(codigoStatusReg)) {
            int resposta = JOptionPane.showConfirmDialog(this, "Já existe um agendamento de LIVRAMENTO CONDICIOAL para esse interno.Deseja fazer outro agendamento de LIVRAMENTO CONDICIOAL?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                mostrarTela();
            }
        } else if (jIDInternoJuridico.getText().equals(codigoInterno) && beneficioAlvara.equals(codigoTipoBeneficio) && statusAgenda.equals(codigoStatusReg)) {
            int resposta = JOptionPane.showConfirmDialog(this, "Já existe um agendamento de ALVARÁ DE SOLTURA para esse interno.Deseja fazer outro agendamento de ALVARÁ DE SOLTURA?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                mostrarTela();
            }
        } else {
            mostrarTela();
        }
    }//GEN-LAST:event_jBtAgendarBeneficioActionPerformed

    private void jBtAdividadesRealizadasADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdividadesRealizadasADMActionPerformed
        // TODO add your handling code here:
        if (jIDLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário fazer primeiro a admissão, deppois registrar as atividades.");
        } else if (jIDInternoJuridico.getText().equals("") && jNomeInternoJuridico.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar o nome do interno antes de cadastrar as atividades a serem realizadas.");
        } else {
            mostrarAtividadesRealizadas();
        }
    }//GEN-LAST:event_jBtAdividadesRealizadasADMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AtividadesRealizadas;
    private javax.swing.JPanel Evolucao;
    private javax.swing.JPanel Listagem;
    private javax.swing.JPanel Manutencao;
    public static javax.swing.JTextField jAtividadeRealizada;
    private javax.swing.JButton jBtAdividadesRealizadasADM;
    private javax.swing.JButton jBtAgendarBeneficio;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarAtividade;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaAtividade;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarAtividade;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirAtividade;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIDPesq;
    private javax.swing.JButton jBtNovaAtividade;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqAtividade;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInternoJuridico;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarAtividade;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JComboBox jComboBoxEncaminharSetor;
    private javax.swing.JComboBox jComboBoxEncaminharSetorEvo;
    private javax.swing.JComboBox jComboBoxResposta;
    private javax.swing.JComboBox jComboBoxRespostaEvo;
    private javax.swing.JComboBox jComboBoxTipoAdvogado;
    private javax.swing.JComboBox jComboBoxTipoAdvogadoEvo;
    private com.toedter.calendar.JDateChooser jDataAtividade;
    public static com.toedter.calendar.JDateChooser jDataCondIntJuri;
    private com.toedter.calendar.JDateChooser jDataEncaminhamento;
    private com.toedter.calendar.JDateChooser jDataEncaminhamentoEvo;
    private com.toedter.calendar.JDateChooser jDataEvolucao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private com.toedter.calendar.JDateChooser jDataLanc;
    public static com.toedter.calendar.JDateChooser jDataNascInternoJuri;
    private javax.swing.JTextArea jEvolucao;
    private javax.swing.JTextArea jEvolucaoAdmissao;
    public static javax.swing.JLabel jFotoInternoJuridico;
    private javax.swing.JFormattedTextField jHoraEnvio;
    private javax.swing.JFormattedTextField jHoraEnvioEvo;
    public static javax.swing.JTextField jIDInternoJuridico;
    public static javax.swing.JTextField jIDLanc;
    private javax.swing.JTextField jIDPesq;
    public static javax.swing.JTextField jIdAtiv;
    public static javax.swing.JTextField jIdEvolucao;
    private javax.swing.JTextField jIdInterno;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaPenaJuridico;
    private javax.swing.JTextField jNomeInternoAtividade;
    private javax.swing.JTextField jNomeInternoEvolucao;
    public static javax.swing.JTextField jNomeInternoJuridico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAtendimentoJuridico;
    private javax.swing.JTable jTabelaAtividades;
    private javax.swing.JTable jTabelaEvolucaoJuridica;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jEvolucao.setLineWrap(true);
        jEvolucao.setWrapStyleWord(true);
        //      
        jEvolucaoAdmissao.setLineWrap(true);
        jEvolucaoAdmissao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIDLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jIDInternoJuridico.setBackground(Color.white);
        jNomeInternoJuridico.setBackground(Color.white);
        jMatriculaPenaJuridico.setBackground(Color.white);
        jDataNascInternoJuri.setBackground(Color.white);
        jDataCondIntJuri.setBackground(Color.white);
        jFotoInternoJuridico.setBackground(Color.white);
        jIdEvolucao.setBackground(Color.white);
        jEvolucao.setBackground(Color.white);
        jNomeInternoEvolucao.setBackground(Color.white);
        jEvolucaoAdmissao.setBackground(Color.white);
        jHoraEnvio.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInternoAtividade.setBackground(Color.white);
        jIdAtiv.setBackground(Color.white);
        jAtividadeRealizada.setBackground(Color.white);
    }

    public void Novo() {

        jIDLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jIDInternoJuridico.setText("");
        jFotoInternoJuridico.setIcon(null);
        jNomeInternoJuridico.setText("");
        jMatriculaPenaJuridico.setText("");
        jDataNascInternoJuri.setDate(null);
        jDataCondIntJuri.setDate(null);
        jFotoInternoJuridico.setIcon(null);
        jEvolucaoAdmissao.setText("");
        jComboBoxResposta.setEnabled(true);
        if (acao == 1) {
            if (jComboBoxResposta.getSelectedItem().equals("Sim")) {
                jDataEncaminhamento.setCalendar(Calendar.getInstance());
                jHoraEnvio.setText(jHoraSistema.getText());
                jDataEncaminhamento.setEnabled(true);
                jComboBoxEncaminharSetor.setEnabled(true);
                jComboBoxTipoAdvogado.setEnabled(true);
                jHoraEnvio.setEnabled(true);
            } else {
                jComboBoxEncaminharSetor.setSelectedItem("Selecione");
                jComboBoxEncaminharSetor.setSelectedItem("Selecione");
                jComboBoxResposta.setSelectedItem("Selecione");
                //
                jDataEncaminhamento.setDate(null);
                jHoraEnvio.setText("");
                jDataEncaminhamento.setEnabled(!true);
                jComboBoxEncaminharSetor.setEnabled(!true);
                jHoraEnvio.setEnabled(!true);
            }
        }
        jComboBoxTipoAdvogado.setSelectedItem("Selecione");
        jEvolucao.setText("");
        //
        jIDPesq.setEnabled(!true);
        jPesqNomeInterno.setEnabled(!true);
        jDataInicial.setEnabled(!true);
        jDataFinal.setEnabled(!true);
        jBtIDPesq.setEnabled(!true);
        jBtPesqNomeInterno.setEnabled(!true);
        jBtPesqDatas.setEnabled(!true);
        //
        jDataLanc.setEnabled(true);
        jBtPesqInternoJuridico.setEnabled(true);
        jEvolucaoAdmissao.setEnabled(true);
        jComboBoxTipoAdvogado.setEnabled(true);
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
        jNomeInternoEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        limparTabelaEvolucao();
        limparTabelaAtividades();
        //
        jBtNovaAtividade.setEnabled(!true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(!true);
        jBtCancelarAtividade.setEnabled(!true);
        jBtAuditoriaAtividade.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void Alterar() {
        jDataLanc.setEnabled(true);
        jBtPesqInternoJuridico.setEnabled(true);
        jEvolucaoAdmissao.setEnabled(true);
        jComboBoxTipoAdvogado.setEnabled(true);
        jComboBoxResposta.setEnabled(true);
        if (acao == 2) {
            if (jComboBoxResposta.getSelectedItem().equals("Sim")) {
                jDataEncaminhamento.setEnabled(true);
                jComboBoxEncaminharSetor.setEnabled(true);
                jComboBoxTipoAdvogado.setEnabled(true);
                jHoraEnvio.setEnabled(true);
            } else {
                jDataEncaminhamento.setEnabled(!true);
                jComboBoxEncaminharSetor.setEnabled(!true);
                jHoraEnvio.setEnabled(!true);
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
        //
        jBtNovaAtividade.setEnabled(!true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(!true);
        jBtCancelarAtividade.setEnabled(!true);
        jBtAuditoriaAtividade.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void Excluir() {
        jIDLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jIDInternoJuridico.setText("");
        jFotoInternoJuridico.setIcon(null);
        jNomeInternoJuridico.setText("");
        jMatriculaPenaJuridico.setText("");
        jDataNascInternoJuri.setDate(null);
        jDataCondIntJuri.setDate(null);
        jFotoInternoJuridico.setIcon(null);
        jEvolucaoAdmissao.setText("");
        jDataEncaminhamento.setDate(null);
        jComboBoxEncaminharSetor.setSelectedItem("Selecione");
        jComboBoxTipoAdvogado.setSelectedItem("Selecione");
        jComboBoxEncaminharSetor.setSelectedItem("Selecione");
        jComboBoxResposta.setSelectedItem("Selecione");
        jEvolucao.setText("");
        //
        jDataLanc.setEnabled(!true);
        jBtPesqInternoJuridico.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxResposta.setEnabled(!true);
        jHoraEnvio.setEnabled(!true);
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
        //
    }

    public void Salvar() {
        jDataLanc.setEnabled(!true);
        jBtPesqInternoJuridico.setEnabled(!true);
        jEvolucaoAdmissao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxResposta.setEnabled(!true);
        jHoraEnvio.setEnabled(!true);
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
        //
        jBtNovaAtividade.setEnabled(true);
        jBtNovaEvolucao.setEnabled(true);
    }

    public void Cancelar() {
        if (jIDLanc.getText().equals("")) {
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jIDInternoJuridico.setText("");
            jFotoInternoJuridico.setIcon(null);
            jNomeInternoJuridico.setText("");
            jMatriculaPenaJuridico.setText("");
            jDataNascInternoJuri.setDate(null);
            jDataCondIntJuri.setDate(null);
            jFotoInternoJuridico.setIcon(null);
            jDataEncaminhamento.setDate(null);
            jComboBoxEncaminharSetor.setSelectedItem("Selecione");
            jComboBoxTipoAdvogado.setSelectedItem("Selecione");
            jComboBoxEncaminharSetor.setSelectedItem("Selecione");
            jComboBoxResposta.setSelectedItem("Selecione");
            jEvolucao.setText("");
            jBtAuditoria.setEnabled(!true);
            //
            jDataLanc.setEnabled(!true);
            jBtPesqInternoJuridico.setEnabled(!true);
            jDataEncaminhamento.setEnabled(!true);
            jComboBoxEncaminharSetor.setEnabled(!true);
            jComboBoxTipoAdvogado.setEnabled(!true);
            jComboBoxEncaminharSetor.setEnabled(!true);
            jComboBoxResposta.setEnabled(!true);
            jHoraEnvio.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            jBtPesqInternoJuridico.setEnabled(!true);
            jDataEncaminhamento.setEnabled(!true);
            jComboBoxEncaminharSetor.setEnabled(!true);
            jComboBoxTipoAdvogado.setEnabled(!true);
            jComboBoxEncaminharSetor.setEnabled(!true);
            jComboBoxResposta.setEnabled(!true);
            jHoraEnvio.setEnabled(!true);
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

    public void NovaAtividade() {
        //
        jIdInterno.setText(jIDInternoJuridico.getText());
        jNomeInternoAtividade.setText(jNomeInternoJuridico.getText());
        jDataAtividade.setCalendar(Calendar.getInstance());
        jIdAtiv.setText("");
        jAtividadeRealizada.setText("");
        //
        jDataAtividade.setEnabled(true);
        jBtPesqAtividade.setEnabled(true);
        //
        jEvolucaoAdmissao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        //
        jBtPesqInternoJuridico.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovaAtividade.setEnabled(!true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(true);
        jBtCancelarAtividade.setEnabled(true);
        jBtAuditoriaAtividade.setEnabled(!true);
        // Desabilita campos da tela de evolução
        jIdEvolucao.setEnabled(!true);
        jNomeInternoEvolucao.setEnabled(!true);
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        // Desabilita os botões da evolução
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarAtividade() {
        //
        jDataAtividade.setEnabled(true);
        jBtPesqAtividade.setEnabled(true);
        //
        jEvolucaoAdmissao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        //
        jBtPesqInternoJuridico.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtNovaAtividade.setEnabled(!true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(true);
        jBtCancelarAtividade.setEnabled(true);
        jBtAuditoriaAtividade.setEnabled(!true);
        // Desabilita campos da tela de evolução
        jIdEvolucao.setEnabled(!true);
        jNomeInternoEvolucao.setEnabled(!true);
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        // Desabilita os botões da evolução
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirAtividade() {
        //
        jIdInterno.setText("");
        jNomeInternoAtividade.setText("");
        jDataAtividade.setDate(null);
        jIdAtiv.setText("");
        jAtividadeRealizada.setText("");
        //
        jDataAtividade.setEnabled(!true);
        jBtPesqAtividade.setEnabled(!true);
        //
        jEvolucaoAdmissao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        // Atendimento
        jBtPesqInternoJuridico.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaAtividade.setEnabled(!true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(true);
        jBtCancelarAtividade.setEnabled(true);
        jBtAuditoriaAtividade.setEnabled(!true);
        // Desabilita campos da tela de evolução         
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        // Desabilita os botões da evolução
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarAtividade() {
        jIdInterno.setText("");
        jNomeInternoAtividade.setText("");
        jDataAtividade.setDate(null);
        jIdAtiv.setText("");
        jAtividadeRealizada.setText("");
        //
        jDataAtividade.setEnabled(!true);
        jBtPesqAtividade.setEnabled(!true);
        //
        jEvolucaoAdmissao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        // Atendimento
        jBtPesqInternoJuridico.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaAtividade.setEnabled(true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(!true);
        jBtCancelarAtividade.setEnabled(true);
        jBtAuditoriaAtividade.setEnabled(!true);
        // Desabilita campos da tela de evolução         
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        // Desabilita os botões da evolução
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void CancelarAtividade() {
        if (jIdAtiv.getText().equals("")) {
            jIdInterno.setText("");
            jNomeInternoAtividade.setText("");
            jDataAtividade.setCalendar(Calendar.getInstance());
            jIdAtiv.setText("");
            jAtividadeRealizada.setText("");
            //
            jDataAtividade.setEnabled(!true);
            jBtPesqAtividade.setEnabled(!true);
            //
        }
        //
        jDataAtividade.setEnabled(!true);
        jBtPesqAtividade.setEnabled(!true);
        //
        jEvolucaoAdmissao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(!true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        jComboBoxTipoAdvogado.setEnabled(!true);
        // Atendimento
        jBtPesqInternoJuridico.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtNovaAtividade.setEnabled(true);
        jBtAlterarAtividade.setEnabled(!true);
        jBtExcluirAtividade.setEnabled(!true);
        jBtSalvarAtividade.setEnabled(!true);
        jBtCancelarAtividade.setEnabled(!true);
        jBtAuditoriaAtividade.setEnabled(!true);
        // Desabilita campos da tela de evolução         
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        // Desabilita os botões da evolução
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void NovaEvolucao() {
        jIdEvolucao.setText("");
        jNomeInternoEvolucao.setText(jNomeInternoJuridico.getText());
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(true);
        jEvolucao.setEnabled(true);
        jComboBoxTipoAdvogadoEvo.setEnabled(true);
        jComboBoxRespostaEvo.setEnabled(true);
        jBtAgendarBeneficio.setEnabled(!true);
        //
        if (acao == 3) {
            if (jComboBoxRespostaEvo.getSelectedItem().equals("Sim")) {
                jDataEncaminhamentoEvo.setCalendar(Calendar.getInstance());
                jHoraEnvioEvo.setText(jHoraSistema.getText());
                jDataEncaminhamentoEvo.setEnabled(true);
                jComboBoxEncaminharSetorEvo.setEnabled(true);
                jComboBoxTipoAdvogadoEvo.setEnabled(true);
                jHoraEnvioEvo.setEnabled(true);
            } else {
                jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione");
                jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione");
                jComboBoxRespostaEvo.setSelectedItem("Selecione");
                //
                jDataEncaminhamentoEvo.setDate(null);
                jHoraEnvioEvo.setText("");
                jDataEncaminhamentoEvo.setEnabled(!true);
                jComboBoxEncaminharSetorEvo.setEnabled(!true);
                jHoraEnvioEvo.setEnabled(!true);
            }
        }
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        //
        jDataEvolucao.setEnabled(true);
        jEvolucao.setEnabled(true);
        jComboBoxTipoAdvogadoEvo.setEnabled(true);
        jComboBoxRespostaEvo.setEnabled(true);
        if (acao == 4) {
            if (jComboBoxRespostaEvo.getSelectedItem().equals("Sim")) {
                jDataEncaminhamentoEvo.setCalendar(Calendar.getInstance());
                jHoraEnvioEvo.setText(jHoraSistema.getText());
                jComboBoxEncaminharSetorEvo.setEnabled(true);
                jDataEncaminhamentoEvo.setEnabled(true);
                jHoraEnvioEvo.setEnabled(true);
            } else {
                jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione");
                jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione");
                jComboBoxRespostaEvo.setSelectedItem("Selecione");
                //
                jDataEncaminhamentoEvo.setDate(null);
                jHoraEnvioEvo.setText("");
                jDataEncaminhamentoEvo.setEnabled(!true);
                jComboBoxEncaminharSetorEvo.setEnabled(!true);
                jHoraEnvioEvo.setEnabled(!true);
            }
        }
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jIdEvolucao.setText("");
        jAtividadeRealizada.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        jNomeInternoEvolucao.setText("");

        //
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        jComboBoxTipoAdvogadoEvo.setEnabled(!true);
        jComboBoxRespostaEvo.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jBtAgendarBeneficio.setEnabled(true);
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
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarEvolucao() {
        jIdEvolucao.setText("");
        jNomeInternoEvolucao.setText("");
        jAtividadeRealizada.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        jDataEncaminhamento.setEnabled(true);
        jHoraEnvio.setEnabled(true);
        jComboBoxEncaminharSetor.setEnabled(!true);
        //
        jComboBoxTipoAdvogadoEvo.setEnabled(!true);
        jComboBoxRespostaEvo.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jBtAgendarBeneficio.setEnabled(true);
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
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarEvolucao() {
        acao = 0;
        jIdEvolucao.setText("");
        jNomeInternoEvolucao.setText("");
        jAtividadeRealizada.setText("");
        jDataEvolucao.setDate(null);
        jEvolucao.setText("");
        jBtAgendarBeneficio.setEnabled(true);
        //
        jDataEvolucao.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        jComboBoxTipoAdvogadoEvo.setEnabled(!true);
        jComboBoxRespostaEvo.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jBtAgendarBeneficio.setEnabled(true);
        //
        jComboBoxTipoAdvogadoEvo.setSelectedItem("Selecione");
        jComboBoxRespostaEvo.setSelectedItem("Selecione");
        jComboBoxEncaminharSetorEvo.setSelectedItem("Selecione");
        jDataEncaminhamentoEvo.setDate(null);
        jHoraEnvioEvo.setText("");
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
        jBtAuditoria.setEnabled(true);
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
            objAtendJuri.setIdLanc(Integer.parseInt(jIDLanc.getText()));
            control.finalizarAtendJuridico(objAtendJuri);
            controle.finalizarMovTec(objAtendJuri);
            jStatusLanc.setText("FINALIZADO");
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            // Habilitar/Desabilitar campos       
            jDataLanc.setEnabled(!true);
            jBtPesqInternoJuridico.setEnabled(!true);
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

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATENDIMENTOJURIDICO");
            conecta.rs.last();
            jIDLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID do lançamento");
        }
    }

    public void buscarCodAtividade() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSATENDIMENTOJURI");
            conecta.rs.last();
            jIdAtiv.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código da atividade.");
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

    public void verificarSituacaoInternoCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
            conecta.rs.first();
            situacaoInternoCrc = conecta.rs.getString("SituacaoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID da evolução");
        }
        conecta.desconecta();
    }

    // VERIFICAR SE A EVOLUÇÃO FAZ PARTE DA ADMISSÃO, OU SEJA, QUANDO É FEITA A ADMISSÃO DO INTERNO
    // É GRAVADO AUTOMÁTICAMETE UMA EVOLUÇÃO PARA O INTERNO.
    public void verificarEvolucaoAdmissao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOJURIDICO WHERE IdLanc='" + jIDLanc.getText() + "' "
                    + "AND IdEvo='" + jIdEvolucao.getText() + "'");
            conecta.rs.first();
            admEvolucao = conecta.rs.getString("AdmEvo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherComboBoxDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxEncaminharSetor.addItem(conecta.rs.getString("NomeDepartamento"));
                jComboBoxEncaminharSetorEvo.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos!!!\nERRO: " + ERROR);
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Observacao")});
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
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Evolucao")});
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

    public void preencherAtividadeJuri(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição das Atividades", "Data"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataAtiv = conecta.rs.getString("DataItem");
                String diap = dataAtiv.substring(8, 10);
                String mesp = dataAtiv.substring(5, 7);
                String anop = dataAtiv.substring(0, 4);
                dataAtiv = diap + "/" + mesp + "/" + anop;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("DescricaoAtiv"), dataAtiv});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtividades.setModel(modelo);
        jTabelaAtividades.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(1).setPreferredWidth(460);
        jTabelaAtividades.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAtividades.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtividades.getTableHeader().setReorderingAllowed(false);
        jTabelaAtividades.setAutoResizeMode(jTabelaAtividades.AUTO_RESIZE_OFF);
        jTabelaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAtividades();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAtividades() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtividades.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtividades.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaAtividades() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição das Atividades", "Data"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtividades.setModel(modelo);
        jTabelaAtividades.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(1).setPreferredWidth(460);
        jTabelaAtividades.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAtividades.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtividades.getTableHeader().setReorderingAllowed(false);
        jTabelaAtividades.setAutoResizeMode(jTabelaAtividades.AUTO_RESIZE_OFF);
        jTabelaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
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

        objLogSys.setIdLancMov(Integer.valueOf(jIdAtiv.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdEvolucao.getText()));
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
        dataReg = formatoAmerica.format(jDataLanc.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIDInternoJuridico.getText() + "' "
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
}
