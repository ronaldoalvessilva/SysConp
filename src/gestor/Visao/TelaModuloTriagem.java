/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleTelasSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.CadastroTelasSistema;
import static gestor.Visao.TelaAgendaCompromissos.jAssunto;
import static gestor.Visao.TelaAgendaCompromissos.jBtAlterarComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtCancelarComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtConfirmarCompromisso;
import static gestor.Visao.TelaAgendaCompromissos.jBtExcluirComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtNovoComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtSalvarComp;
import static gestor.Visao.TelaAgendaCompromissos.jCodigoAgendaComp;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxConclusao;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxPrioridade;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxStatusComp;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxTipoEvento;
import static gestor.Visao.TelaAgendaCompromissos.jDataEvento;
import static gestor.Visao.TelaAgendaCompromissos.jDataInicio;
import static gestor.Visao.TelaAgendaCompromissos.jDataLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jDataTermino;
import static gestor.Visao.TelaAgendaCompromissos.jHoraInicio;
import static gestor.Visao.TelaAgendaCompromissos.jHoraLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jHoraTermino;
import static gestor.Visao.TelaAgendaCompromissos.jNomeUsuarioAgenda;
import static gestor.Visao.TelaAgendaCompromissos.jTabelaAgendaEventos;
import static gestor.Visao.TelaAgendaCompromissos.jTextoEvento;
import static gestor.Visao.TelaAgendaCompromissos.jtotalRegistros;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaRecadosTriagem.jBtAlterar;
import static gestor.Visao.TelaRecadosTriagem.jBtCancelar;
import static gestor.Visao.TelaRecadosTriagem.jBtConfirmar;
import static gestor.Visao.TelaRecadosTriagem.jBtExcluir;
import static gestor.Visao.TelaRecadosTriagem.jBtNovo;
import static gestor.Visao.TelaRecadosTriagem.jBtResponder;
import static gestor.Visao.TelaRecadosTriagem.jBtSalvar;
import static gestor.Visao.TelaRecadosTriagem.jComboBoxStatus;
import static gestor.Visao.TelaRecadosTriagem.jDataLanc;
import static gestor.Visao.TelaRecadosTriagem.jHoraRecado;
import static gestor.Visao.TelaRecadosTriagem.jIDLanc;
import static gestor.Visao.TelaRecadosTriagem.jNomeDestinatario;
import static gestor.Visao.TelaRecadosTriagem.jNomeRementente;
import static gestor.Visao.TelaRecadosTriagem.jRecado;
import static gestor.Visao.TelaRecadosTriagem.jTabelaTodosRecados;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ronaldo
 */
public class TelaModuloTriagem extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    //
    String pathFoto;
    //
    private TelaRecadosTriagem objRecados = null;
    private TelaProntuarioTriagem objProTri = null;
    private TelaUnidadePenal objUnP = null;
    private TelaPaises objPais = null;
    private TelaCidades objCida = null;
    private TelaConsultaAgendaEscoltaPortaria objConAgenda = null;
    private TelaConsultaLocalInternoSeguranca objLocalInter = null;
    private TelaRecadosTriagem objAgeRecSs = null;
    private TelaAlertaEntradaInternosPortaria objEntradasPortarias = null;
    private TelaMovimentacaoCrcTriagem objTelaMov = null;
    private TelaConsultaInternosEvadidos objConIntEvadidos = null;
    private TelaControleDepositoTriagem objContrlDepTria = null;
    //
    private TelaPertences objPertences = null;
    private TelaLocalEstoquePertences objLocalPert = null;
    private TelaEntradaObjetosPertences objEntraObj = null;
    private TelaSaidaObjetosPertences objSaidaObjPertences = null;
    private TelaRequisicaoMateriaisInternosSEAC objReqSEAC = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaPagamentoKitInterno objKitTria = null;
    private TelaEntradasLote objEntradaInt = null;
    private TelaPreLocaoInternos objPreLocacaoInternos = null;
    //
    String usuarioLogado, dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    String confirmaEntrada = "Não"; // Variavel que verificar os alerta de enttrada de interno na unidade
    //
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    //   
    public static int codigoUserTRI = 0;
    public static int codUserAcessoTRI = 0;
    public static int codigoUserGroupTRI = 0;
    public static int codAbrirTRI = 0;
    public static int codIncluirTRI = 0;
    public static int codAlterarTRI = 0;
    public static int codExcluirTRI = 0;
    public static int codGravarTRI = 0;
    public static int codConcultarTRI = 0;
    public static int codigoGrupoTRI = 0;
    public static String nomeGrupoTRI = "";
    public static String nomeTelaTRI = "";
    // TELAS DE ACESSOS AO MÓDULO CRC
    public static String nomeModuloTRIAGEM = "TRIAGEM";
    // MENU CADASTRO    
    public static String telaCadastroUnidadePrisionalTRI = "Cadastro:Unidades Penais:Manutenção";
    public static String telaCadastroPaisesTRI = "Cadastro:Localidades:Paises:Manutenção";
    public static String telaCadastroCidadesTRI = "Cadastro:Localidades:Cidades:Manutenção";
    public static String telaCadastroProntuarioManuTRI = "Cadastro:Prontuario de Internos:Manutenção";
    public static String telaCadastroProntuarioPrintTRI = "Cadastro:Prontuario de Internos:Impressão Prontuário";
    public static String telaCadastroProntuarioBioTRI = "Cadastro:Prontuario de Internos:Biometria de Internos";
    public static String telaCadastroProntuarioImportTRI = "Cadastro:Prontuario de Internos:Importação de Prontuários";
    public static String telaCadastroProntuarioObsTRI = "Cadastro:Prontuario de Internos:Observação";
    public static String telaCadastroProntuarioBuscarEntTRI = "Cadastro:Prontuario de Internos:Buscar Entrada de Internos Portaria";
    public static String telaCadastroProntuarioPecFreTRI = "Cadastro:Prontuario de Internos:Peculiaridade Frente";
    public static String telaCadastroProntuarioPecCosTRI = "Cadastro:Prontuario de Internos:Peculiaridade Costa";
    // CONTROLE DE PERTENCES   
    public static String telaObjetosInternosTRI = "Controle de Pertences:Objetos Internos:Manutenção";
    public static String telaLocalPertencesInternosTRI = "Controle de Pertences:Local Pertences Internos:Manutenção";
    public static String telaEntradaPertencesManutencaoTRI = "Controle de Pertences:Entrada Pertences:Manutenção";
    public static String telaEntradaPertencesPertencesTRI = "Controle de Pertences:Entrada Pertences:Pertences";
    public static String telaSaidaPertencesInternosTRI = "Controle de Pertences:Saida Pertences Internos:Manutenção";
    public static String telaSaidaPertencesPertencesTRI = "Controle de Pertences:Saida Pertences Internos:Pertences";
    public static String telaRequisicaoMateriaisInternosTRI = "Controle de Pertences:Requisição de Materiais Internos:Manutenção";
    public static String telaRequisicaoMateriaisInternosProdutosTRI = "Controle de Pertences:Requisição de Materiais Internos:Produtos";
    //
    public static String telaControleDepositoTRI = "Controle de Pertences:Controle de Valores:Manutenção";
    public static String telaControleDepositoInternosTRI = "Controle de Pertences:Controle de Valores:Internos";
    // MOVIMENTAÇÃO
    public static String telaEntregaMaterialUsoTRI = "Movimentação:Entrega de Material Uso Pessoal:Manutenção";
    public static String telaEntregaMaterialUsoInternosTRI = "Movimentação:Entrega de Material Uso Pessoal:Internos";
    public static String telaEntregaMaterialUsoInternosBioTRI = "Movimentação:Entrega de Material Uso Pessoal:Biometria";
    public static String telaInicializarLeitorTRI = "Movimentação:Entrega de Material Uso Pessoal:Inicializar leitor";
    public static String telaEntredaInternosManuTRI = "Movimentação:Entrada de Internos:Manutenção";
    public static String telaEntredaInternosIntTRI = "Movimentação:Entrada de Internos:Internos";
    public static String telaPreLocacaoInternosManuTRI = "Movimentação:Pré-Locação:Manutenção";
    public static String telaPreLocacaoInternosIntTRI = "Movimentação:Pré-Locação:Internos";

    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCUP = "";
    String pNomeCLP = "";
    String pNomeCLC = "";
    String pNomePM = "";
    String pNomePMP = "";
    String pNomePMB = "";
    String pNomePMI = "";
    String pNomePMO = "";
    String pNomePMBE = "";
    String pNomePMPF = "";
    String pNomePMPC = "";
    // MENU CONTROLE PERTENCES    
    String pNomeOI = "";
    String pNomeLPI = "";
    String pNomeEPM = "";
    String pNomeEPMP = "";
    String pNomeSPI = "";
    String pNomeSPP = "";
    String pNomeRMI = "";
    String pNomeRMIP = "";
    // CONTROLE DE DEPOSITOS NA TRIAGEM
    String pNomeCDT = "";
    String pNomeCDTI = "";
    // MOVIMENTAÇÃO
    String pNomeEMUP = "";
    String pNomeEMUPI = "";
    String pNomeEMUIB = "";
    String pNomeIL = "";
    String pNomeEIN = "";
    String pNomeEINI = "";
    String pNomePLM = "";
    String pNomePLMI = "";

    /**
     * Creates new form TelaSeguranca
     */
    public TelaModuloTriagem() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        pesquisarTelasAcessos();
        threadMensagem(); // A cada 5 minutos verifica mensagem  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jPainelTriagem = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jUnidadePenal = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuDiversos = new javax.swing.JMenu();
        jLocalidadePaises = new javax.swing.JMenuItem();
        jLocalidadeCidades = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jProntuarioInterno = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        jAgendaRecados = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        SairTelaSeguranca = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jConsultaLocalizacaoInternos = new javax.swing.JMenuItem();
        jConsultaEscolta = new javax.swing.JMenuItem();
        EvasaoInternos = new javax.swing.JMenuItem();
        HistoricoMovimentacaoInternos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        ObjetosInternos = new javax.swing.JMenuItem();
        LocalPertencesInternos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        EntradaPertences = new javax.swing.JMenuItem();
        SaidaPertencesInternos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RequisicaoMateriaisInternos = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jControleValoresInternos = new javax.swing.JMenuItem();
        jMovimentacao = new javax.swing.JMenu();
        EntregaMaterialUsoPessoal = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        EntradaInternosUnidade = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jPreLocacaoInternos = new javax.swing.JMenuItem();
        RelatoriosSeguranca = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        MenuProntuariosTodos = new javax.swing.JMenuItem();
        RelatorioPrevisaoSaidaInternos = new javax.swing.JMenuItem();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        RelatorioPavilhao = new javax.swing.JMenuItem();
        RelatorioCelas = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        ListagemGeralPavilhao = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        RelatorioValoresInternos = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        RelatorioPreLocacaoInternos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        CalculadoraPena = new javax.swing.JMenuItem();
        CalculadoraWindows = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..::: Controle de Triagem de Internos {CRC}:::...");

        jPainelTriagem.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jPainelTriagem.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelTriagemLayout = new javax.swing.GroupLayout(jPainelTriagem);
        jPainelTriagem.setLayout(jPainelTriagemLayout);
        jPainelTriagemLayout.setHorizontalGroup(
            jPainelTriagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelTriagemLayout.setVerticalGroup(
            jPainelTriagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelTriagemLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        jUnidadePenal.setText("Unidade Penal");
        jUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnidadePenalActionPerformed(evt);
            }
        });
        jMenu1.add(jUnidadePenal);
        jMenu1.add(jSeparator5);

        jMenuDiversos.setText("Localidades");

        jLocalidadePaises.setText("Paises");
        jLocalidadePaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLocalidadePaisesActionPerformed(evt);
            }
        });
        jMenuDiversos.add(jLocalidadePaises);

        jLocalidadeCidades.setText("Cidades");
        jLocalidadeCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLocalidadeCidadesActionPerformed(evt);
            }
        });
        jMenuDiversos.add(jLocalidadeCidades);

        jMenu1.add(jMenuDiversos);
        jMenu1.add(jSeparator4);

        jProntuarioInterno.setText("Prontuário de Interno");
        jProntuarioInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProntuarioInternoActionPerformed(evt);
            }
        });
        jMenu1.add(jProntuarioInterno);
        jMenu1.add(jSeparator1);

        AgendaCompromissos.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaCompromissos);

        jAgendaRecados.setText("Agenda Recados");
        jAgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgendaRecadosActionPerformed(evt);
            }
        });
        jMenu1.add(jAgendaRecados);
        jMenu1.add(jSeparator10);

        SairTelaSeguranca.setText("Sair");
        SairTelaSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairTelaSegurancaActionPerformed(evt);
            }
        });
        jMenu1.add(SairTelaSeguranca);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Consultas");

        jConsultaLocalizacaoInternos.setText("Localização de Internos");
        jConsultaLocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaLocalizacaoInternosActionPerformed(evt);
            }
        });
        jMenu3.add(jConsultaLocalizacaoInternos);

        jConsultaEscolta.setText("Agendamento de Escolta e Médico");
        jConsultaEscolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaEscoltaActionPerformed(evt);
            }
        });
        jMenu3.add(jConsultaEscolta);

        EvasaoInternos.setText("Evasão de Internos");
        EvasaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvasaoInternosActionPerformed(evt);
            }
        });
        jMenu3.add(EvasaoInternos);

        HistoricoMovimentacaoInternos.setText("Histórico Movimentação");
        HistoricoMovimentacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovimentacaoInternosActionPerformed(evt);
            }
        });
        jMenu3.add(HistoricoMovimentacaoInternos);

        jMenuBar1.add(jMenu3);

        jMenu7.setText("Controle Pertences");

        ObjetosInternos.setText("Pertences dos Internos");
        ObjetosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjetosInternosActionPerformed(evt);
            }
        });
        jMenu7.add(ObjetosInternos);

        LocalPertencesInternos.setText("Local Estoque Pertences de Internos");
        LocalPertencesInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalPertencesInternosActionPerformed(evt);
            }
        });
        jMenu7.add(LocalPertencesInternos);
        jMenu7.add(jSeparator7);

        EntradaPertences.setText("Entrada de Pertences de Internos");
        EntradaPertences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaPertencesActionPerformed(evt);
            }
        });
        jMenu7.add(EntradaPertences);

        SaidaPertencesInternos.setText("Saida de Pertences de Internos");
        SaidaPertencesInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaidaPertencesInternosActionPerformed(evt);
            }
        });
        jMenu7.add(SaidaPertencesInternos);
        jMenu7.add(jSeparator8);

        RequisicaoMateriaisInternos.setText("Requisição de Materiais para Internos");
        RequisicaoMateriaisInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisInternosActionPerformed(evt);
            }
        });
        jMenu7.add(RequisicaoMateriaisInternos);
        jMenu7.add(jSeparator9);

        jControleValoresInternos.setText("Controle de Valores de Internos");
        jControleValoresInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jControleValoresInternosActionPerformed(evt);
            }
        });
        jMenu7.add(jControleValoresInternos);

        jMenuBar1.add(jMenu7);

        jMovimentacao.setText("Movimentação");

        EntregaMaterialUsoPessoal.setText("Entrega Material Uso Pessoal");
        EntregaMaterialUsoPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntregaMaterialUsoPessoalActionPerformed(evt);
            }
        });
        jMovimentacao.add(EntregaMaterialUsoPessoal);
        jMovimentacao.add(jSeparator11);

        EntradaInternosUnidade.setText("Entrada de Internos na Unidade");
        EntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaInternosUnidadeActionPerformed(evt);
            }
        });
        jMovimentacao.add(EntradaInternosUnidade);
        jMovimentacao.add(jSeparator13);

        jPreLocacaoInternos.setForeground(new java.awt.Color(0, 153, 0));
        jPreLocacaoInternos.setText("Pré-Locação de Internos");
        jPreLocacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPreLocacaoInternosActionPerformed(evt);
            }
        });
        jMovimentacao.add(jPreLocacaoInternos);

        jMenuBar1.add(jMovimentacao);

        RelatoriosSeguranca.setText("Relatórios");

        jMenu6.setText("Relatórios Prontuários");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        MenuProntuariosTodos.setText("Prontuários de Internos");
        MenuProntuariosTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProntuariosTodosActionPerformed(evt);
            }
        });
        jMenu6.add(MenuProntuariosTodos);

        RelatoriosSeguranca.add(jMenu6);

        RelatorioPrevisaoSaidaInternos.setText("Relatório de Previsão de Saída de Internos");
        RelatorioPrevisaoSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaInternosActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioPrevisaoSaidaInternos);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioEntradaInternosUnidade);
        RelatoriosSeguranca.add(jSeparator3);

        RelatorioPavilhao.setText("Pavilhão");
        RelatoriosSeguranca.add(RelatorioPavilhao);

        RelatorioCelas.setText("Celas");
        RelatorioCelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCelasActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioCelas);
        RelatoriosSeguranca.add(jSeparator2);

        jMenu2.setText("Confere");

        ListagemGeralPavilhao.setText("Relatório Geral de Internos no Pavilhão/Celas");
        ListagemGeralPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemGeralPavilhaoActionPerformed(evt);
            }
        });
        jMenu2.add(ListagemGeralPavilhao);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        jMenu2.add(ListagemConfere);

        jMenuItem4.setText("Mapa de Confere");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        RelatoriosSeguranca.add(jMenu2);
        RelatoriosSeguranca.add(jSeparator6);

        RelatorioValoresInternos.setText("Relatório de Depósito de Valores de Interno");
        RelatorioValoresInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioValoresInternosActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioValoresInternos);
        RelatoriosSeguranca.add(jSeparator12);

        RelatorioPreLocacaoInternos.setForeground(new java.awt.Color(204, 0, 0));
        RelatorioPreLocacaoInternos.setText("Relatório Geral de Pré-Locação de Internos");
        RelatorioPreLocacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPreLocacaoInternosActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioPreLocacaoInternos);

        jMenuBar1.add(RelatoriosSeguranca);

        jMenu4.setText("Utilitários");

        CalculadoraPena.setText("Calculadora de Pena");
        CalculadoraPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculadoraPenaActionPerformed(evt);
            }
        });
        jMenu4.add(CalculadoraPena);

        CalculadoraWindows.setText("Calculadora do Windows");
        CalculadoraWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculadoraWindowsActionPerformed(evt);
            }
        });
        jMenu4.add(CalculadoraWindows);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelTriagem)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelTriagem)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairTelaSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairTelaSegurancaActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_SairTelaSegurancaActionPerformed

    private void jProntuarioInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProntuarioInternoActionPerformed
        // TODO add your handling code here:       
        buscarAcessoUsuario(telaCadastroProntuarioManuTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroProntuarioManuTRI) && codAbrirTRI == 1) {
            if (objProTri == null || objProTri.isClosed()) {
                objProTri = new TelaProntuarioTriagem();
                jPainelTriagem.add(objProTri);
                objProTri.setVisible(true);
            } else {
                if (objProTri.isVisible()) {
                    if (objProTri.isIcon()) { // Se esta minimizado
                        try {
                            objProTri.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objProTri.toFront(); // traz para frente
                        objProTri.pack();//volta frame 
                    }
                } else {
                    objProTri = new TelaProntuarioTriagem();
                    TelaModuloTriagem.jPainelTriagem.add(objProTri);//adicona frame ao JDesktopPane  
                    objProTri.setVisible(true);
                }
            }
            try {
                objProTri.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jProntuarioInternoActionPerformed

    private void jUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnidadePenalActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroUnidadePrisionalTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroUnidadePrisionalTRI) && codAbrirTRI == 1) {
            if (objUnP == null || objUnP.isClosed()) {
                objUnP = new TelaUnidadePenal();
                jPainelTriagem.add(objUnP);
                objUnP.setVisible(true);
            } else {
                if (objUnP.isVisible()) {
                    if (objUnP.isIcon()) { // Se esta minimizado
                        try {
                            objUnP.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objUnP.toFront(); // traz para frente
                        objUnP.pack();//volta frame 
                    }
                } else {
                    objUnP = new TelaUnidadePenal();
                    TelaModuloTriagem.jPainelTriagem.add(objUnP);//adicona frame ao JDesktopPane  
                    objUnP.setVisible(true);
                }
            }
            try {
                objUnP.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jUnidadePenalActionPerformed

    private void CalculadoraPenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculadoraPenaActionPerformed
        // TODO add your handling code here:
        calcPena();
    }//GEN-LAST:event_CalculadoraPenaActionPerformed

    private void CalculadoraWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculadoraWindowsActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_CalculadoraWindowsActionPerformed

    private void MenuProntuariosTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProntuariosTodosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ProntuariosInternosCrc.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES "
                    + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES "
                    + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE "
                    + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Internos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório. \n\nERRO :" + e);
        }
    }//GEN-LAST:event_MenuProntuariosTodosActionPerformed

    private void RelatorioCelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelatorioCelasActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jLocalidadePaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLocalidadePaisesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroPaisesTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroPaisesTRI) && codAbrirTRI == 1) {
            if (objPais == null || objPais.isClosed()) {
                objPais = new TelaPaises();
                jPainelTriagem.add(objPais);
                objPais.setVisible(true);
            } else {
                if (objPais.isVisible()) {
                    if (objPais.isIcon()) { // Se esta minimizado
                        try {
                            objPais.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPais.toFront(); // traz para frente
                        objPais.pack();//volta frame 
                    }
                } else {
                    objPais = new TelaPaises();
                    TelaModuloTriagem.jPainelTriagem.add(objPais);//adicona frame ao JDesktopPane  
                    objPais.setVisible(true);
                }
            }
            try {
                objPais.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jLocalidadePaisesActionPerformed

    private void jLocalidadeCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLocalidadeCidadesActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaCadastroCidadesTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaCadastroCidadesTRI) && codAbrirTRI == 1) {
            if (objCida == null || objCida.isClosed()) {
                objCida = new TelaCidades();
                jPainelTriagem.add(objCida);
                objCida.setVisible(true);
            } else {
                if (objCida.isVisible()) {
                    if (objCida.isIcon()) { // Se esta minimizado
                        try {
                            objCida.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCida.toFront(); // traz para frente
                        objCida.pack();//volta frame 
                    }
                } else {
                    objCida = new TelaCidades();
                    TelaModuloTriagem.jPainelTriagem.add(objCida);//adicona frame ao JDesktopPane  
                    objCida.setVisible(true);
                }
            }
            try {
                objCida.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jLocalidadeCidadesActionPerformed

    private void jConsultaEscoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaEscoltaActionPerformed
        // TODO add your handling code here:
        if (objConAgenda == null || objConAgenda.isClosed()) {
            objConAgenda = new TelaConsultaAgendaEscoltaPortaria();
            jPainelTriagem.add(objConAgenda);
            objConAgenda.setVisible(true);
        } else {
            if (objConAgenda.isVisible()) {
                if (objConAgenda.isIcon()) { // Se esta minimizado
                    try {
                        objConAgenda.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConAgenda.toFront(); // traz para frente
                    objConAgenda.pack();//volta frame 
                }
            } else {
                objConAgenda = new TelaConsultaAgendaEscoltaPortaria();
                TelaModuloTriagem.jPainelTriagem.add(objConAgenda);//adicona frame ao JDesktopPane  
                objConAgenda.setVisible(true);
            }
        }
        try {
            objConAgenda.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jConsultaEscoltaActionPerformed

    private void jConsultaLocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaLocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalInter == null || objLocalInter.isClosed()) {
            objLocalInter = new TelaConsultaLocalInternoSeguranca();
            jPainelTriagem.add(objLocalInter);
            objLocalInter.setVisible(true);
        } else {
            if (objConAgenda.isVisible()) {
                if (objLocalInter.isIcon()) { // Se esta minimizado
                    try {
                        objLocalInter.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalInter.toFront(); // traz para frente
                    objLocalInter.pack();//volta frame 
                }
            } else {
                objLocalInter = new TelaConsultaLocalInternoSeguranca();
                TelaModuloTriagem.jPainelTriagem.add(objLocalInter);//adicona frame ao JDesktopPane  
                objLocalInter.setVisible(true);
            }
        }
        try {
            objLocalInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jConsultaLocalizacaoInternosActionPerformed

    private void jAgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objAgeRecSs == null || objAgeRecSs.isClosed()) {
            objAgeRecSs = new TelaRecadosTriagem();
            jPainelTriagem.add(objAgeRecSs);
            objAgeRecSs.setVisible(true);
        } else {
            if (objAgeRecSs.isVisible()) {
                if (objAgeRecSs.isIcon()) { // Se esta minimizado
                    try {
                        objAgeRecSs.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgeRecSs.toFront(); // traz para frente
                    objAgeRecSs.pack();//volta frame 
                }
            } else {
                objAgeRecSs = new TelaRecadosTriagem();
                TelaModuloTriagem.jPainelTriagem.add(objAgeRecSs);//adicona frame ao JDesktopPane  
                objAgeRecSs.setVisible(true);
            }
        }
        try {
            objAgeRecSs.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jAgendaRecadosActionPerformed

    private void RelatorioPrevisaoSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaTriagem objRelPrevSaiIntTria = new TelaRelatorioPrevisaoSaidaTriagem();
        TelaModuloTriagem.jPainelTriagem.add(objRelPrevSaiIntTria);
        objRelPrevSaiIntTria.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaInternosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereSeguranca mapop = new TelaRelMapaConfereSeguranca();
        TelaModuloTriagem.jPainelTriagem.add(mapop);
        mapop.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloTriagem.jPainelTriagem.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void ListagemGeralPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemGeralPavilhaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemGeralConfere.jasper";
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLOCACAOINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "ORDER BY DescricaoPav,PRONTUARIOSCRC.NomeInternoCrc,CELAS.EndCelaPav");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem Geral de Confere");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListagemGeralPavilhaoActionPerformed

    private void EvasaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvasaoInternosActionPerformed
        // TODO add your handling code here:
        if (objConIntEvadidos == null || objConIntEvadidos.isClosed()) {
            objConIntEvadidos = new TelaConsultaInternosEvadidos();
            jPainelTriagem.add(objConIntEvadidos);
            objConIntEvadidos.setVisible(true);
        } else {
            if (objConIntEvadidos.isVisible()) {
                if (objConIntEvadidos.isIcon()) { // Se esta minimizado
                    try {
                        objConIntEvadidos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConIntEvadidos.toFront(); // traz para frente
                    objConIntEvadidos.pack();//volta frame 
                }
            } else {
                objConIntEvadidos = new TelaConsultaInternosEvadidos();
                TelaModuloTriagem.jPainelTriagem.add(objConIntEvadidos);//adicona frame ao JDesktopPane  
                objConIntEvadidos.setVisible(true);
            }
        }
        try {
            objConIntEvadidos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EvasaoInternosActionPerformed

    private void HistoricoMovimentacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovimentacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objTelaMov == null || objTelaMov.isClosed()) {
            objTelaMov = new TelaMovimentacaoCrcTriagem();
            jPainelTriagem.add(objTelaMov);
            objTelaMov.setVisible(true);
        } else {
            if (objTelaMov.isVisible()) {
                if (objTelaMov.isIcon()) { // Se esta minimizado
                    try {
                        objTelaMov.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTelaMov.toFront(); // traz para frente
                    objTelaMov.pack();//volta frame 
                }
            } else {
                objTelaMov = new TelaMovimentacaoCrcTriagem();
                TelaModuloTriagem.jPainelTriagem.add(objTelaMov);//adicona frame ao JDesktopPane  
                objTelaMov.setVisible(true);
            }
        }
        try {
            objTelaMov.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoInternosActionPerformed

    private void jControleValoresInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jControleValoresInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaControleDepositoTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaControleDepositoTRI) && codAbrirTRI == 1) {
            if (objContrlDepTria == null || objContrlDepTria.isClosed()) {
                objContrlDepTria = new TelaControleDepositoTriagem();
                jPainelTriagem.add(objContrlDepTria);
                objContrlDepTria.setVisible(true);
            } else {
                if (objContrlDepTria.isVisible()) {
                    if (objContrlDepTria.isIcon()) { // Se esta minimizado
                        try {
                            objContrlDepTria.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objContrlDepTria.toFront(); // traz para frente
                        objContrlDepTria.pack();//volta frame 
                    }
                } else {
                    objContrlDepTria = new TelaControleDepositoTriagem();
                    TelaModuloTriagem.jPainelTriagem.add(objContrlDepTria);//adicona frame ao JDesktopPane  
                    objContrlDepTria.setVisible(true);
                }
            }
            try {
                objContrlDepTria.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jControleValoresInternosActionPerformed

    private void RelatorioValoresInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioValoresInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioDepositosTriagem objRelDepoInt = new TelaRelatorioDepositosTriagem();
        TelaModuloTriagem.jPainelTriagem.add(objRelDepoInt);
        objRelDepoInt.show();
    }//GEN-LAST:event_RelatorioValoresInternosActionPerformed

    private void ObjetosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjetosInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaObjetosInternosTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaObjetosInternosTRI) && codAbrirTRI == 1) {
            if (objPertences == null || objPertences.isClosed()) {
                objPertences = new TelaPertences();
                jPainelTriagem.add(objPertences);
                objPertences.setVisible(true);
            } else {
                if (objPertences.isVisible()) {
                    if (objPertences.isIcon()) { // Se esta minimizado
                        try {
                            objPertences.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPertences.toFront(); // traz para frente
                        objPertences.pack();//volta frame
                    }
                } else {
                    objPertences = new TelaPertences();
                    TelaModuloTriagem.jPainelTriagem.add(objPertences);//adicona frame ao JDesktopPane
                    objPertences.setVisible(true);
                }
            }
            try {
                objPertences.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ObjetosInternosActionPerformed

    private void LocalPertencesInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalPertencesInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocalPertencesInternosTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaLocalPertencesInternosTRI) && codAbrirTRI == 1) {
            if (objLocalPert == null || objLocalPert.isClosed()) {
                objLocalPert = new TelaLocalEstoquePertences();
                jPainelTriagem.add(objLocalPert);
                objLocalPert.setVisible(true);
            } else {
                if (objLocalPert.isVisible()) {
                    if (objLocalPert.isIcon()) { // Se esta minimizado
                        try {
                            objLocalPert.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objLocalPert.toFront(); // traz para frente
                        objLocalPert.pack();//volta frame
                    }
                } else {
                    objLocalPert = new TelaLocalEstoquePertences();
                    TelaModuloTriagem.jPainelTriagem.add(objLocalPert);//adicona frame ao JDesktopPane
                    objLocalPert.setVisible(true);
                }
            }
            try {
                objLocalPert.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LocalPertencesInternosActionPerformed

    private void EntradaPertencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaPertencesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaPertencesManutencaoTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntradaPertencesManutencaoTRI) && codAbrirTRI == 1) {
            if (objEntraObj == null || objEntraObj.isClosed()) {
                objEntraObj = new TelaEntradaObjetosPertences();
                jPainelTriagem.add(objEntraObj);
                objEntraObj.setVisible(true);
            } else {
                if (objEntraObj.isVisible()) {
                    if (objEntraObj.isIcon()) { // Se esta minimizado
                        try {
                            objEntraObj.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntraObj.toFront(); // traz para frente
                        objEntraObj.pack();//volta frame
                    }
                } else {
                    objEntraObj = new TelaEntradaObjetosPertences();
                    TelaModuloTriagem.jPainelTriagem.add(objEntraObj);//adicona frame ao JDesktopPane
                    objEntraObj.setVisible(true);
                }
            }
            try {
                objEntraObj.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntradaPertencesActionPerformed

    private void SaidaPertencesInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaidaPertencesInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaPertencesInternosTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaSaidaPertencesInternosTRI) && codAbrirTRI == 1) {
            if (objSaidaObjPertences == null || objSaidaObjPertences.isClosed()) {
                objSaidaObjPertences = new TelaSaidaObjetosPertences();
                jPainelTriagem.add(objSaidaObjPertences);
                objSaidaObjPertences.setVisible(true);
            } else {
                if (objSaidaObjPertences.isVisible()) {
                    if (objSaidaObjPertences.isIcon()) { // Se esta minimizado
                        try {
                            objSaidaObjPertences.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSaidaObjPertences.toFront(); // traz para frente
                        objSaidaObjPertences.pack();//volta frame
                    }
                } else {
                    objSaidaObjPertences = new TelaSaidaObjetosPertences();
                    TelaModuloTriagem.jPainelTriagem.add(objSaidaObjPertences);//adicona frame ao JDesktopPane
                    objSaidaObjPertences.setVisible(true);
                }
            }
            try {
                objSaidaObjPertences.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SaidaPertencesInternosActionPerformed

    private void RequisicaoMateriaisInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMateriaisInternosProdutosTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaRequisicaoMateriaisInternosProdutosTRI) && codAbrirTRI == 1) {
            if (objReqSEAC == null || objReqSEAC.isClosed()) {
                objReqSEAC = new TelaRequisicaoMateriaisInternosSEAC();
                jPainelTriagem.add(objReqSEAC);
                objReqSEAC.setVisible(true);
            } else {
                if (objReqSEAC.isVisible()) {
                    if (objReqSEAC.isIcon()) { // Se esta minimizado
                        try {
                            objReqSEAC.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objReqSEAC.toFront(); // traz para frente
                        objReqSEAC.pack();//volta frame
                    }
                } else {
                    objReqSEAC = new TelaRequisicaoMateriaisInternosSEAC();
                    TelaModuloTriagem.jPainelTriagem.add(objReqSEAC);//adicona frame ao JDesktopPane
                    objReqSEAC.setVisible(true);
                }
            }
            try {
                objReqSEAC.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RequisicaoMateriaisInternosActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelTriagem.add(objAgEventos);
            objAgEventos.setVisible(true);
        } else {
            if (objAgEventos.isVisible()) {
                if (objAgEventos.isIcon()) { // Se esta minimizado
                    try {
                        objAgEventos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgEventos.toFront(); // traz para frente
                    objAgEventos.pack();//volta frame 
                }
            } else {
                objAgEventos = new TelaAgendaCompromissos();
                TelaModuloTriagem.jPainelTriagem.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloTriagem.jPainelTriagem.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void EntregaMaterialUsoPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntregaMaterialUsoPessoalActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codAbrirTRI == 1) {
            if (objKitTria == null || objKitTria.isClosed()) {
                objKitTria = new TelaPagamentoKitInterno();
                jPainelTriagem.add(objKitTria);
                objKitTria.setVisible(true);
            } else {
                if (objKitTria.isVisible()) {
                    if (objKitTria.isIcon()) { // Se esta minimizado
                        try {
                            objKitTria.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objKitTria.toFront(); // traz para frente
                        objKitTria.pack();//volta frame 
                    }
                } else {
                    objKitTria = new TelaPagamentoKitInterno();
                    TelaModuloTriagem.jPainelTriagem.add(objKitTria);//adicona frame ao JDesktopPane  
                    objKitTria.setVisible(true);
                }
            }
            try {
                objKitTria.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntregaMaterialUsoPessoalActionPerformed

    private void EntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:telaEntredaInternosManuTRI
        buscarAcessoUsuario(telaEntredaInternosManuTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntredaInternosManuTRI) && codAbrirTRI == 1) {
            if (objEntradaInt == null || objEntradaInt.isClosed()) {
                objEntradaInt = new TelaEntradasLote();
                jPainelTriagem.add(objEntradaInt);
                objEntradaInt.setVisible(true);
            } else {
                if (objEntradaInt.isVisible()) {
                    if (objEntradaInt.isIcon()) { // Se esta minimizado
                        try {
                            objEntradaInt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntradaInt.toFront(); // traz para frente
                        objEntradaInt.pack();//volta frame 
                    }
                } else {
                    objEntradaInt = new TelaEntradasLote();
                    TelaModuloTriagem.jPainelTriagem.add(objEntradaInt);//adicona frame ao JDesktopPane  
                    objEntradaInt.setVisible(true);
                }
            }
            try {
                objEntradaInt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntradaInternosUnidadeActionPerformed

    private void jPreLocacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPreLocacaoInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPreLocacaoInternosManuTRI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaPreLocacaoInternosManuTRI) && codAbrirTRI == 1) {
            if (objPreLocacaoInternos == null || objPreLocacaoInternos.isClosed()) {
                objPreLocacaoInternos = new TelaPreLocaoInternos();
                jPainelTriagem.add(objPreLocacaoInternos);
                objPreLocacaoInternos.setVisible(true);
            } else {
                if (objPreLocacaoInternos.isVisible()) {
                    if (objPreLocacaoInternos.isIcon()) { // Se esta minimizado
                        try {
                            objPreLocacaoInternos.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPreLocacaoInternos.toFront(); // traz para frente
                        objPreLocacaoInternos.pack();//volta frame 
                    }
                } else {
                    objPreLocacaoInternos = new TelaPreLocaoInternos();
                    TelaModuloTriagem.jPainelTriagem.add(objPreLocacaoInternos);//adicona frame ao JDesktopPane  
                    objPreLocacaoInternos.setVisible(true);
                }
            }
            try {
                objPreLocacaoInternos.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jPreLocacaoInternosActionPerformed

    private void RelatorioPreLocacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPreLocacaoInternosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioPreLocacaoInternosTriagemGeral.jasper";
            conecta.executaSQL("SELECT * FROM PRE_LOCACAO_INTERNOS "
                    + "INNER JOIN ITENS_PRE_LOCACAO_INTERNOS "
                    + "ON PRE_LOCACAO_INTERNOS.CodigoReg=ITENS_PRE_LOCACAO_INTERNOS.CodigoReg "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PRE_LOCACAO_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN PAVILHAO "
                    + "ON ITENS_PRE_LOCACAO_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "ORDER BY PRE_LOCACAO_INTERNOS.CodigoReg,PRONTUARIOSCRC.NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("descricaoUnidade", descricaoUnidade);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Geral de Pré-Locação de Internos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório. \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioPreLocacaoInternosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem CalculadoraPena;
    private javax.swing.JMenuItem CalculadoraWindows;
    private javax.swing.JMenuItem EntradaInternosUnidade;
    private javax.swing.JMenuItem EntradaPertences;
    private javax.swing.JMenuItem EntregaMaterialUsoPessoal;
    private javax.swing.JMenuItem EvasaoInternos;
    private javax.swing.JMenuItem HistoricoMovimentacaoInternos;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem ListagemGeralPavilhao;
    private javax.swing.JMenuItem LocalPertencesInternos;
    public static javax.swing.JMenuItem MenuProntuariosTodos;
    private javax.swing.JMenuItem ObjetosInternos;
    private javax.swing.JMenuItem RelatorioCelas;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioPavilhao;
    private javax.swing.JMenuItem RelatorioPreLocacaoInternos;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaInternos;
    private javax.swing.JMenuItem RelatorioValoresInternos;
    private javax.swing.JMenu RelatoriosSeguranca;
    private javax.swing.JMenuItem RequisicaoMateriaisInternos;
    private javax.swing.JMenuItem SaidaPertencesInternos;
    private javax.swing.JMenuItem SairTelaSeguranca;
    private javax.swing.JMenuItem jAgendaRecados;
    private javax.swing.JMenuItem jConsultaEscolta;
    private javax.swing.JMenuItem jConsultaLocalizacaoInternos;
    private javax.swing.JMenuItem jControleValoresInternos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jLocalidadeCidades;
    private javax.swing.JMenuItem jLocalidadePaises;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDiversos;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jMovimentacao;
    public static javax.swing.JDesktopPane jPainelTriagem;
    private javax.swing.JMenuItem jPreLocacaoInternos;
    private javax.swing.JMenuItem jProntuarioInterno;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jUnidadePenal;
    // End of variables declaration//GEN-END:variables

    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado(); // Verificar recados a cada 5 minutos
                verificarAlertaPortaria(); // verificar alertas de entradas de internos na portaria a cada 5 minutos.
                verificarAgendaCompromisso();
            }
        }, periodo, tempo);
    }

    public void calcPena() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calcpena.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
// Calculadora do Windows

    public void CalcWindows() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calc.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                    + "WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                // Abrir uma úica tela, funcionando
                if (objRecados == null || objRecados.isClosed()) {
                    objRecados = new TelaRecadosTriagem();
                    TelaModuloCRC.jPainelCRC.add(objRecados);
                    objRecados.setVisible(true);
                } else {
                    if (objRecados.isVisible()) {
                        if (objRecados.isIcon()) { // Se esta minimizado
                            try {
                                objRecados.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecados.toFront(); // traz para frente
                            objRecados.pack();//volta frame 
                        }
                    } else {
                        objRecados = new TelaRecadosTriagem();
                        TelaModuloTriagem.jPainelTriagem.add(objRecados);//adicona frame ao JDesktopPane  
                        objRecados.setVisible(true);
                    }
                }
                try {
                    objRecados.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "'");
                if (flag == 1) {
                    jBtNovo.setEnabled(true);
                    jBtAlterar.setEnabled(true);
                    jBtExcluir.setEnabled(true);
                    jBtSalvar.setEnabled(!true);
                    jBtCancelar.setEnabled(true);
                    jBtResponder.setEnabled(true);
                    jBtConfirmar.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                                + "INNER JOIN USUARIOS "
                                + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                                + "WHERE NomeUsuario='" + nameUser + "' "
                                + "AND StatusAgenda='" + statusAgenda + "'");
                        conecta.rs.last();
                        jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                        jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                        jHoraRecado.setText(conecta.rs.getString("Horario"));
                        jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jNomeRementente.setText(conecta.rs.getString("NomeUsuarioLogado"));
                        jNomeDestinatario.setText(conecta.rs.getString("NomeUsuario"));
                        jRecado.setText(conecta.rs.getString("Recados"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void buscarUsuario(String nomeUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
            nomeUsuarioCompromisso = conecta.rs.getString("NomeUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{" ID", " Data", " Remetente", " Destinatário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.last();
            do {
                // Formatar a data Entrada
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataLanc, conecta.rs.getString("NomeUsuarioLogado"), conecta.rs.getString("NomeUsuario")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTodosRecados.setModel(modelo);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setPreferredWidth(52);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTodosRecados.getTableHeader().setReorderingAllowed(false);
        jTabelaTodosRecados.setAutoResizeMode(jTabelaTodosRecados.AUTO_RESIZE_OFF);
        jTabelaTodosRecados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    //Verificar se existem interos registrados na portaria
    public void verificarAlertaPortaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA "
                    + "WHERE ConfirmaEntrada='" + confirmaEntrada + "'");
            conecta.rs.first();
            confirmaEntrada = conecta.rs.getString("ConfirmaEntrada");
            if (confirmaEntrada.equals("Não")) {
                if (objEntradasPortarias == null || objEntradasPortarias.isClosed()) {
                    objEntradasPortarias = new TelaAlertaEntradaInternosPortaria();
                    TelaModuloTriagem.jPainelTriagem.add(objEntradasPortarias);
                    objEntradasPortarias.setVisible(true);
                } else {
                    if (objEntradasPortarias.isVisible()) {
                        if (objEntradasPortarias.isIcon()) { // Se esta minimizado
                            try {
                                objEntradasPortarias.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objEntradasPortarias.toFront(); // traz para frente
                            objEntradasPortarias.pack();//volta frame 
                        }
                    } else {
                        objEntradasPortarias = new TelaAlertaEntradaInternosPortaria();
                        TelaModuloTriagem.jPainelTriagem.add(objEntradasPortarias);//adicona frame ao JDesktopPane  
                        objRecados.setVisible(true);
                    }
                }
                try {
                    objEntradasPortarias.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void verificarAgendaCompromisso() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                    + "WHERE UsuarioAgenda='" + nameUser + "' "
                    + "AND StatusAgenda='" + statusAgenda + "' "
                    + "AND DataLembrete='" + jDataSistema.getText() + "' "
                    + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
            conecta.rs.first();
            horaLembrete = conecta.rs.getString("HoraLembrete");
            usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
            codigoAgendaComp = conecta.rs.getString("IdAgenda");
            //
            if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                TelaModuloTriagem.jPainelTriagem.add(objAgendaComp);
                objAgendaComp.show();
                flag = 1;
                preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                        + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + jDataSistema.getText() + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "' "
                        + "AND IdAgenda='" + codigoAgendaComp + "'");
                if (flag == 1) {
                    jBtNovoComp.setEnabled(true);
                    jBtAlterarComp.setEnabled(true);
                    jBtExcluirComp.setEnabled(true);
                    jBtSalvarComp.setEnabled(!true);
                    jBtCancelarComp.setEnabled(true);
                    jBtConfirmarCompromisso.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                                + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nomeUsuarioCompromisso + "' "
                                + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                                + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "' "
                                + "AND IdAgenda='" + codigoAgendaComp + "'");
                        conecta.rs.first();
                        jCodigoAgendaComp.setText(String.valueOf(conecta.rs.getInt("IdAgenda")));
                        jComboBoxStatusComp.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jComboBoxTipoEvento.setSelectedItem(conecta.rs.getString("TipoEvento"));
                        jDataEvento.setDate(conecta.rs.getDate("DataAgenda"));
                        jAssunto.setText(conecta.rs.getString("Assunto"));
                        jComboBoxPrioridade.setSelectedItem(conecta.rs.getString("Prioridade"));
                        jComboBoxConclusao.setSelectedItem(conecta.rs.getString("Conclusao"));
                        jDataInicio.setDate(conecta.rs.getDate("DataInicio"));
                        jDataTermino.setDate(conecta.rs.getDate("DataTermino"));
                        jHoraInicio.setText(conecta.rs.getString("HoraInicio"));
                        jHoraTermino.setText(conecta.rs.getString("HoraTermino"));
                        jDataLembrete.setDate(conecta.rs.getDate("DataLembrete"));
                        jHoraLembrete.setText(conecta.rs.getString("HoraLembrete"));
                        jTextoEvento.setText(conecta.rs.getString("Texto"));
                        jNomeUsuarioAgenda.setText(conecta.rs.getString("UsuarioAgenda"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void preencherTabelaAgendaCompromisso(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código ", "Data", "Status", "Assunto", "Usuário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataAgenda = conecta.rs.getString("DataAgenda");
                String dia = dataAgenda.substring(8, 10);
                String mes = dataAgenda.substring(5, 7);
                String ano = dataAgenda.substring(0, 4);
                dataAgenda = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdAgenda"), dataAgenda, conecta.rs.getString("StatusAgenda"), conecta.rs.getString("Assunto"), conecta.rs.getString("UsuarioAgenda")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAgendaEventos.setModel(modelo);
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaAgendaEventos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaAgendaEventos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAgendaEventos.setAutoResizeMode(jTabelaAgendaEventos.AUTO_RESIZE_OFF);
        jTabelaAgendaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroUnidadePrisionalTRI + "'");
            conecta.rs.first();
            pNomeCUP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroPaisesTRI + "'");
            conecta.rs.first();
            pNomeCLP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroCidadesTRI + "'");
            conecta.rs.first();
            pNomeCLC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioManuTRI + "'");
            conecta.rs.first();
            pNomePM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioPrintTRI + "'");
            conecta.rs.first();
            pNomePMP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioBioTRI + "'");
            conecta.rs.first();
            pNomePMB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioImportTRI + "'");
            conecta.rs.first();
            pNomePMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioObsTRI + "'");
            conecta.rs.first();
            pNomePMO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioBuscarEntTRI + "'");
            conecta.rs.first();
            pNomePMBE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioPecFreTRI + "'");
            conecta.rs.first();
            pNomePMPF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroProntuarioPecCosTRI + "'");
            conecta.rs.first();
            pNomePMPC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONTROLE DE PERTENCES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaObjetosInternosTRI + "'");
            conecta.rs.first();
            pNomeOI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocalPertencesInternosTRI + "'");
            conecta.rs.first();
            pNomeLPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaPertencesManutencaoTRI + "'");
            conecta.rs.first();
            pNomeEPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaPertencesPertencesTRI + "'");
            conecta.rs.first();
            pNomeEPMP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSaidaPertencesInternosTRI + "'");
            conecta.rs.first();
            pNomeSPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSaidaPertencesPertencesTRI + "'");
            conecta.rs.first();
            pNomeSPP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisicaoMateriaisInternosTRI + "'");
            conecta.rs.first();
            pNomeRMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisicaoMateriaisInternosProdutosTRI + "'");
            conecta.rs.first();
            pNomeRMIP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleDepositoTRI + "'");
            conecta.rs.first();
            pNomeCDT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleDepositoInternosTRI + "'");
            conecta.rs.first();
            pNomeCDTI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntregaMaterialUsoTRI + "'");
            conecta.rs.first();
            pNomeEMUP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntregaMaterialUsoInternosTRI + "'");
            conecta.rs.first();
            pNomeEMUPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntregaMaterialUsoInternosBioTRI + "'");
            conecta.rs.first();
            pNomeEMUIB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInicializarLeitorTRI + "'");
            conecta.rs.first();
            pNomeIL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntredaInternosManuTRI + "'");
            conecta.rs.first();
            pNomeEIN = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntredaInternosIntTRI + "'");
            conecta.rs.first();
            pNomeEINI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPreLocacaoInternosManuTRI + "'");
            conecta.rs.first();
            pNomePLM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPreLocacaoInternosIntTRI + "'");
            conecta.rs.first();
            pNomePLMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MENU CADASTRO
        if (!pNomeCUP.equals(telaCadastroUnidadePrisionalTRI) || pNomeCUP == null || pNomeCUP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroUnidadePrisionalTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCLP.equals(telaCadastroPaisesTRI) || pNomeCLP == null || pNomeCLP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroPaisesTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCLC.equals(telaCadastroCidadesTRI) || pNomeCLC == null || pNomeCLC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroCidadesTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePM.equals(telaCadastroProntuarioManuTRI) || pNomePM == null || pNomePM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioManuTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMP.equals(telaCadastroProntuarioPrintTRI) || pNomePMP == null || pNomePMP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioPrintTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMB.equals(telaCadastroProntuarioBioTRI) || pNomePMB == null || pNomePMB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioBioTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMI.equals(telaCadastroProntuarioImportTRI) || pNomePMI == null || pNomePMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioImportTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMO.equals(telaCadastroProntuarioObsTRI) || pNomePMO == null || pNomePMO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioObsTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMBE.equals(telaCadastroProntuarioBuscarEntTRI) || pNomePMBE == null || pNomePMBE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioBuscarEntTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMPF.equals(telaCadastroProntuarioPecFreTRI) || pNomePMPF == null || pNomePMPF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioPecFreTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePMPC.equals(telaCadastroProntuarioPecCosTRI) || pNomePMPC == null || pNomePMPC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroProntuarioPecCosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // CONTROLE DE PERTENCES
        if (!pNomeOI.equals(telaObjetosInternosTRI) || pNomeOI == null || pNomeOI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaObjetosInternosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLPI.equals(telaLocalPertencesInternosTRI) || pNomeLPI == null || pNomeLPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocalPertencesInternosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEPM.equals(telaEntradaPertencesManutencaoTRI) || pNomeEPM == null || pNomeEPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaPertencesManutencaoTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEPMP.equals(telaEntradaPertencesPertencesTRI) || pNomeEPMP == null || pNomeEPMP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaPertencesPertencesTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSPI.equals(telaSaidaPertencesInternosTRI) || pNomeSPI == null || pNomeSPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSaidaPertencesInternosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSPP.equals(telaSaidaPertencesPertencesTRI) || pNomeSPP == null || pNomeSPP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSaidaPertencesPertencesTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRMI.equals(telaRequisicaoMateriaisInternosTRI) || pNomeRMI == null || pNomeRMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisicaoMateriaisInternosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRMIP.equals(telaRequisicaoMateriaisInternosProdutosTRI) || pNomeRMIP == null || pNomeRMIP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisicaoMateriaisInternosProdutosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCDT.equals(telaControleDepositoTRI) || pNomeCDT == null || pNomeCDT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleDepositoTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCDTI.equals(telaControleDepositoInternosTRI) || pNomeCDTI == null || pNomeCDTI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleDepositoInternosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeEMUP.equals(telaEntregaMaterialUsoTRI) || pNomeEMUP == null || pNomeEMUP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntregaMaterialUsoTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEMUPI.equals(telaEntregaMaterialUsoInternosTRI) || pNomeEMUPI == null || pNomeEMUPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntregaMaterialUsoInternosTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEMUIB.equals(telaEntregaMaterialUsoInternosBioTRI) || pNomeEMUIB == null || pNomeEMUIB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntregaMaterialUsoInternosBioTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIL.equals(telaInicializarLeitorTRI) || pNomeIL == null || pNomeIL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInicializarLeitorTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEIN.equals(telaEntredaInternosManuTRI) || pNomeEIN == null || pNomeEIN.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntredaInternosManuTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEINI.equals(telaEntredaInternosIntTRI) || pNomeEINI == null || pNomeEINI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntredaInternosIntTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePLM.equals(telaPreLocacaoInternosManuTRI) || pNomePLM == null || pNomePLM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPreLocacaoInternosManuTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }

        if (!pNomePLMI.equals(telaPreLocacaoInternosIntTRI) || pNomePLMI == null || pNomePLMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPreLocacaoInternosIntTRI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloTRIAGEM + "'");
            conecta.rs.first();
            pCodModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
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
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
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
}
