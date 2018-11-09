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
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaRecadosCrc.jBtAlterar;
import static gestor.Visao.TelaRecadosCrc.jBtCancelar;
import static gestor.Visao.TelaRecadosCrc.jBtConfirmar;
import static gestor.Visao.TelaRecadosCrc.jBtExcluir;
import static gestor.Visao.TelaRecadosCrc.jBtNovo;
import static gestor.Visao.TelaRecadosCrc.jBtResponder;
import static gestor.Visao.TelaRecadosCrc.jBtSalvar;
import static gestor.Visao.TelaRecadosCrc.jComboBoxStatus;
import static gestor.Visao.TelaRecadosCrc.jDataLanc;
import static gestor.Visao.TelaRecadosCrc.jHoraRecado;
import static gestor.Visao.TelaRecadosCrc.jIDLanc;
import static gestor.Visao.TelaRecadosCrc.jNomeDestinatario;
import static gestor.Visao.TelaRecadosCrc.jNomeRementente;
import static gestor.Visao.TelaRecadosCrc.jRecado;
import static gestor.Visao.TelaRecadosCrc.jTabelaTodosRecados;
import java.beans.PropertyVetoException;
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
public class TelaModuloEnfermaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    //
    private TelaRecadosEnfermaria objRecEnfermaria = null;
    private TelaConsultaAgendaEscolta objConAgenEscolta = null;
    private TelaEvolucaoTecEnfermagem objEvolTecEnfer = null;
    private TelaAdmissaoEnfermagem objAdmEnfermagem = null;
    private TelaMovHistoricoTecMedico objMovTecMedico = null;
    private TelaAdmissaoMedica objAdmMedico = null;
    private TelaConsultaLocalInternoMedico objLocalIntMedico = null;
    private TelaConsultaProntuarioInternoCrc objProntMedicoInt = null;
    private TelaOcorrenciaMedica objOcorreMedica = null;
    private TelaCadastroDoencas objCadDoenca = null;
    private TelaAprazamentoMedicacoes objAbraMed = null;
    private TelaLocalArmazenamentoEnfermaria objLocalEnf = null;
    private TelaSolicitacaoProdutosENFAR objSolProd = null;
    private TelaAprovadorSolicitacaoMedicamentosENFA objUserAproSol = null;
    private TelaSolicitantesMedicamentos objSoliciante = null;
    private TelaMotivoSaidaProdutosENFAR objMotENFAR = null;
    private TelaDevolucaoMedicamentosEnfermariaFarmacia objDevolMed = null;
    private TelaConsultaEstoqueENF objConsEstoMedi = null;
    private TelaRequisicaoAvulsaMedicamentosENF objReqSaidENF = null;
    private TelaEstornoRequisicaoMateriaisENF objEstornoReqMed = null;
    private TelaRequisicaoMedicamentosInternos objRequisicaoMedInternos = null;
    private TelaAvaliacaoMedicaPsiquiatrica objAvalicaioMedica = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaTiposExames objTipoEx = null;
    private TelaSolicitacaoExamesMedicoPsiquiatrico objSoliExame = null;
    private TelaTiposVacinas objTipoVac = null;
    private TelaCalendarioVacinasInternos objCalVacina = null;
    private TelaHistoricoDoencasFamiliar objHistDoencaAtual = null;
    private TelaEncaminhamentoInternosCirurgiasEspecialistas objEncaInteCE = null;
    private TelaMovimentacaoExternaInternos objHistMovExt = null;
    private TelaPerfilCarcerarioEnfermaria objPerfilCarEnf = null;
    private TelaPAI_NOVO objPaiMed = null;
    private TelaRegistroInternosAtendimento objRegIntAtend = null;
    private TelaTiposTratamentos objTipoTrata = null;
    private TelaRegistroInternosAtendimentoImpresso objAutoImp = null;
    //    
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente"; // PARA AS AGENDAS, RECADO E COMPROMISSO
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    //
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    //
    String cartaoSUS = "";
    public static int codigoUserENF = 0;
    public static int codUserAcessoENF = 0;
    public static int codigoUserGroupENF = 0;
    public static int codAbrirENF = 0;
    public static int codIncluirENF = 0;
    public static int codAlterarENF = 0;
    public static int codExcluirENF = 0;
    public static int codGravarENF = 0;
    public static int codConsultarENF = 0;
    public static int codigoGrupoENF = 0;
    public static String nomeGrupoENF = "";
    public static String nomeTelaENF = "";
    // TELAS DE ACESSOS AO MÓDULO ENFERMARIA
    public static String nomeModuloENFER = "ENFERMARIA";
    // MENU CADASTRO    
    public static String telaAcessoCadastroDoencasENF = "Cadastro:Cadastro de Doenças:Manutenção";
    public static String telaTipoExamesENF = "Cadastro:Tipos de Exames:Manutenção";
    public static String telaTiposVacinasENF = "Cadastro:Tipos de Vacinas:Manutenção";
    public static String telaLocalArmazenaENF = "Cadastro:Local de Armazenamento:Manutenção";
    public static String telaSolicitantesMedicamentosENF = "Cadastro:Solicitantes de Medicamentos:Manutenção";
    public static String telaAprovadorSolicitacaoENF = "Cadastro:Aprovador Solicitação de Medicamentos:Manutenção";
    public static String telaMotivoSaidaProdutoENF = "Cadastro:Motivo de Saída de Produtos:Manutenção";
    public static String telaRegistroIntAtendENF = "Cadastro:Registro Interno para Atendimento:Manutenção";
    public static String telaRegistroIntAtendInciarLeitorENF = "Cadastro:Registro Interno para Atendimento:Iniciar Leitor";
    // MENU CONTROLE DE MEDICAMENTOS
    public static String telaSolicitacaoMateriaisManuENF = "Controle Medicamentos:Solicitação de Materiais:Manutenção";
    public static String telaSolicitacaoMateriaisProdENF = "Controle Medicamentos:Solicitação de Materiais:Produtos";
    public static String telaDevolucaoMedicamentosManuENF = "Controle Medicamentos:Devolução de Medicamentos:Manutenção";
    public static String telaDevolucaoMedicamentosItensENF = "Controle Medicamentos:Devolução de Medicamentos:Itens";
    public static String telaRequisicaoMedicaInterManuENF = "Controle Medicamentos:Requisição de Medicamentos Interno:Manutenção";
    public static String telaRequisicaoMedicaInterItensENF = "Controle Medicamentos:Requisição de Medicamentos Interno:Itens";
    public static String telaRequisiçãoAvulsaMateriaisManutENF = "Controle Medicamentos:Requisição Avulsa de Materiais:Manutenção";
    public static String telaRequisiçãoAvulsaMateriaisManutItensENF = "Controle Medicamentos:Requisição Avulsa de Materiais:Itens";
    public static String telaEstornoRequisiçãoMateriaisManutENF = "Controle Medicamentos:Estorno Requisição de Materiais:Manutenção";
    public static String telaEstornoRequisiçãoMateriaisManutItensENF = "Controle Medicamentos:Estorno Requisição de Materiais:Itens";
    // MOVIMENTAÇÃO - MÉDICO
    public static String telaAcessoProntuarioMedicoENF = "Movimentação:Admissão Médica de Internos:Manutenção";
    public static String telaEvolucaoPsiquiatricaENF = "Movimentação:Admissão Médica de Internos:Evolução Psiquiatrica";
    public static String telaEvolucaoMedicaENF = "Movimentação:Admissão Médica de Internos:Evolução Médica";
    public static String telaPrescricaoMedicaENF = "Movimentação:Admissão Médica de Internos:Prescrição Médica/Psiquiatrica";
    public static String telaAtestadoMedicoENF = "Movimentação:Admissão Médica de Internos:Atestado Médico/Psiquiatrico";
    public static String telaDietaMedicaENF = "Movimentação:Admissão Médica de Internos:Dieta Médica/Psiquiatrica";
    //
    public static String telaAvaliaSaudeMedPsiENF = "Movimentação:Avaliação de Saúde Médica/Psiquiatrica de Internos:Manutenção";
    public static String telaAvaliaSaudeMedPsiTratENF = "Movimentação:Avaliação de Saúde Médica/Psiquiatrica de Internos:Tratamento";
    public static String telaSolicitacaoExamesIntManuENF = "Movimentação:Solicitação de Exames de Internos:Manutenção";
    public static String telaSolicitacaoExamesIntManuExameENF = "Movimentação:Solicitação de Exames de Internos:Exames";
    public static String telaEncamInterCiruEspeManuENF = "Movimentação:Encaminhamento de Internos Cirurgia/Especialidades:Manutenção";
    public static String telaEncamInterCiruEspeManuEncaENF = "Movimentação:Encaminhamento de Internos Cirurgia/Especialidades:Encaminhamento";
    // MENU ENFERMAGEM
    public static String telaAdmissaoEnfeIntManuENF = "Movimentação:Admissão Enfermeira de Internos:Manutenção";
    public static String telaAdmissãoEnfeIntAEFP1ENF = "Movimentação:Admissão Enfermeira de Internos:AEF-P1";
    public static String telaAdmissãoEnfeIntAEFP2ENF = "Movimentação:Admissão Enfermeira de Internos:AEF-P2";
    public static String telaAdmissãoEnfeIntAEFP3ENF = "Movimentação:Admissão Enfermeira de Internos:AEF-P3";
    public static String telaAdmissãoEnfeIntAEFP4ENF = "Movimentação:Admissão Enfermeira de Internos:AEF-P4";
    public static String telaAdmissaoEnfeIntEvolENF = "Movimentação:Admissão Enfermeira de Internos:Evolução";
    //
    public static String telaCalendarioVacinasIntManuENF = "Movimentação:Calendário de Vacinas de Internos:Manutenção";
    public static String telaCalendarioVacinasIntVaciENF = "Movimentação:Calendário de Vacinas de Internos:Vacinas";
    public static String telaHistDoencaFamManuENF = "Movimentação:Histórico Doenças Familiar:Manutenção";
    public static String telaHistDoencaFamPatParENF = "Movimentação:Histórico Doenças Familiar:Patologias/Parentesco";
    // MENU TÉCNICO ENFERMAGEM
    public static String telaAtendTecEnfIntManuENF = "Movimentação:Atendimento Técnica Enfermeira de Internos:Manutenção";
    public static String telaAtendTecEnfIntEvolENF = "Movimentação:Atendimento Técnica Enfermeira de Internos:Evolução";
    //
    public static String telaAprazaMedManuENF = "Movimentação:Aprazamento de Medicamentos:Manutenção";
    public static String telaAprazaMedItensENF = "Movimentação:Aprazamento de Medicamentos:Itens";
    //
    public static String telaPerfilCarManuENF = "Movimentação:Perfil Carcerário:Manutenção";
    public static String telaPerfilCarPerCarENF = "Movimentação:Perfil Carcerário:Perfil Carcerário";
    //P.A.I.
    public static String telaPaiManu = "Movimentação:P.A.I.:Manutenção";
    public static String telaPaiCCGF = "Movimentação:P.A.I.:C.C.G.F.";
    public static String telaPaiCCGFFam = "Movimentação:P.A.I.:C.C.G.F.:Familia";
    public static String telaPaiCCGFVis = "Movimentação:P.A.I.:C.C.G.F.:Visita";
    public static String telaPaiCCGFVisInt = "Movimentação:P.A.I.:C.C.G.F.:Visita Intima";
    public static String telaPaiDEME = "Movimentação:P.A.I.:D.E.M.E.";
    public static String telaPaiDPTL = "Movimentação:P.A.I.:D.P.T.L.";
    public static String telaPaiDJ = "Movimentação:P.A.I.:D.J.";
    public static String telaPaiDS = "Movimentação:P.A.I.:D.S.";
    public static String telaPaiEAPI1 = "Movimentação:P.A.I.:E.A.P.I.-1";
    public static String telaPaiEAPI2 = "Movimentação:P.A.I.:E.A.P.I.-2";
    public static String telaPaiEPAI = "Movimentação:P.A.I.:E-PAI";
    //
    public static String telaOcorrenciaDiaManuENF = "Movimentação:Ocorrências Diárias:Manutenção";
    public static String telaTipoTratamentoManu = "Cadastro:Tipo de Tratamentos:Manutenção";
    //
    public static String telaConsultaProntuarioInternosDocENF = "Consulta:Prontuario:Documentos";
    // REGISTRO DE INTERNO IMPRESSO
    public static String telaRegistroAtenImpENF = "Cadastro:Registro de Atendimento de Internos Impresso";
    public static String telaRegistroLibAtenImpENF = "Cadastro:Registro de Atendimento de Internos Impresso:Liberação";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeACD = "";
    String pNomeTE = "";
    String pNomeTV = "";
    String pNomeLA = "";
    String pNomeSM = "";
    String pNomeAS = "";
    String pNomeMSP = "";
    String pNomeRIA = "";
    String pNomeRIAIL = "";
    // MENU CONTROLE DE MEDICAMENTOS
    String pNomeSMM = "";
    String pNomeSMP = "";
    String pNomeDMM = "";
    String pNomeDMI = "";
    String pNomeRMIM = "";
    String pNomeRMII = "";
    String pNomeRAMM = "";
    String pNomeRAMMI = "";
    String pNomeERMM = "";
    String pNomeERMMI = "";
    // MOVIMENTAÇÃO - MÉDICO
    String pNomeAPM = "";
    String pNomeEP = "";
    String pNomeEM = "";
    String pNomePM = "";
    String pNomeAM = "";
    String pNomeDM = "";
    //
    String pNomeAMP = "";
    String pNomeAMPT = "";
    String pNomeSEIM = "";
    String pNomeSEIME = "";
    String pNomeEICEM = "";
    String pNomeEICEE = "";
    // MENU ENFERMAGEM
    String pNomeAEIM = "";
    String pNomeAEIE = "";
    String pNomeAEIP1 = "";
    String pNomeAEIP2 = "";
    String pNomeAEIP3 = "";
    String pNomeAEIP4 = "";
    String pNomeCVIM = "";
    String pNomeCVIV = "";
    String pNomeHDFM = "";
    String pNomeHDFPP = "";
    // MENU TÉCNICO ENFERMAGEM
    String pNomeATEIM = "";
    String pNomeATEIE = "";
    //
    String pNomeAMM = "";
    String pNomeAMI = "";
    //
    String pNomePCN = "";
    String pNomePCPC = "";
    // P.A.I.
    String pNomePPM = "";
    String pNomePCCGF = "";
    String pNomePCCGFa = "";
    String pNomePCCGFVis = "";
    String pNomePCCGFVisInt = "";
    String pNomePDEME = "";
    String pNomePDPTL = "";
    String pNomePDJ = "";
    String pNomePDS = "";
    String pNomePEADPI1 = "";
    String pNomePEADPI2 = "";
    String pNomePEPAI = "";
    //
    String pNomeODM = "";
    String pNomeTTM = "";
    //
    String pNomeCPID = "";
    //
    String pNomeRAII = "";
    //    
    String pNomeRLAI = "";

    /**
     * Creates new form TelaMedico
     */
    public TelaModuloEnfermaria() {
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

        jPainelMedico = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        CadastroDoencas = new javax.swing.JMenuItem();
        jTiposExames = new javax.swing.JMenuItem();
        jTiposVacinas = new javax.swing.JMenuItem();
        jTiposTratameto = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        LocalEstoqueEnfermaria = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        SolicitantesMedicamentos = new javax.swing.JMenuItem();
        AprovadorSolicitacaoMedicamentos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMotivoDevolucaoProdutos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        AgendaEventos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        RegistrarInternoAtendimento = new javax.swing.JMenuItem();
        RegistroAtendimentoImpresso = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        ControleMedicamentos = new javax.swing.JMenu();
        SolicitacaoMedicamentosFarmacia = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        DevolucaoMedicamentos = new javax.swing.JMenuItem();
        RequisicaoMedicamentosInternos = new javax.swing.JMenuItem();
        RequisicaoProdutosMedicaoAvulsa = new javax.swing.JMenuItem();
        EstornoSaidaAvulsa = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        EstoqueMedicamentos = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ProntuarioInternos = new javax.swing.JMenuItem();
        LocalizacaoInternos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        AgendaEscoltaCrc = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        HistoricoMovInternos = new javax.swing.JMenuItem();
        jMovimentacaoExternaInterno = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        AdmissaoMedicaPsiquiatrica = new javax.swing.JMenuItem();
        AvaliacaoSaudeMedicaPsiquiatrica = new javax.swing.JMenuItem();
        SolicitacaoExameMedico = new javax.swing.JMenuItem();
        jEncaminhamentosCirurgiasEspecialistas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        AdmissoaEnfermagem = new javax.swing.JMenuItem();
        jCalendarioVacinas = new javax.swing.JMenuItem();
        JHistoricoDoencaFamilia = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        AtendimentoTecEnfermagem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Aprazementomedicoes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        JPerfilCarcerario = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencia = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        RelatorioGeralPavilhaoCelas = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        MapaConfere = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        RelatorioInternosUnidadePenal = new javax.swing.JMenuItem();
        relatorioInternosSemCartaoSUS = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Controle Médico/Psiquiatrico :::...");

        jPainelMedico.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jPainelMedico.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelMedicoLayout = new javax.swing.GroupLayout(jPainelMedico);
        jPainelMedico.setLayout(jPainelMedicoLayout);
        jPainelMedicoLayout.setHorizontalGroup(
            jPainelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelMedicoLayout.setVerticalGroup(
            jPainelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelMedicoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        Cadastros.setText("Cadastro");

        CadastroDoencas.setText("Patologias");
        CadastroDoencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroDoencasActionPerformed(evt);
            }
        });
        Cadastros.add(CadastroDoencas);

        jTiposExames.setText("Tipos de Exames");
        jTiposExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTiposExamesActionPerformed(evt);
            }
        });
        Cadastros.add(jTiposExames);

        jTiposVacinas.setText("Tipos de Vacinas");
        jTiposVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTiposVacinasActionPerformed(evt);
            }
        });
        Cadastros.add(jTiposVacinas);

        jTiposTratameto.setForeground(new java.awt.Color(0, 0, 204));
        jTiposTratameto.setText("Tipos de Tratamentos");
        jTiposTratameto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTiposTratametoActionPerformed(evt);
            }
        });
        Cadastros.add(jTiposTratameto);
        Cadastros.add(jSeparator10);

        LocalEstoqueEnfermaria.setText("Local de Armazenamento");
        LocalEstoqueEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalEstoqueEnfermariaActionPerformed(evt);
            }
        });
        Cadastros.add(LocalEstoqueEnfermaria);
        Cadastros.add(jSeparator5);

        SolicitantesMedicamentos.setText("Solicitantes de Medicamentos na Farmácia");
        SolicitantesMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitantesMedicamentosActionPerformed(evt);
            }
        });
        Cadastros.add(SolicitantesMedicamentos);

        AprovadorSolicitacaoMedicamentos.setText("Aprovador Solicitação de Medicamentos");
        AprovadorSolicitacaoMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprovadorSolicitacaoMedicamentosActionPerformed(evt);
            }
        });
        Cadastros.add(AprovadorSolicitacaoMedicamentos);
        Cadastros.add(jSeparator6);

        jMotivoDevolucaoProdutos.setText("Motivos da Devolução Produtos/Medicamentos");
        jMotivoDevolucaoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMotivoDevolucaoProdutosActionPerformed(evt);
            }
        });
        Cadastros.add(jMotivoDevolucaoProdutos);
        Cadastros.add(jSeparator7);

        AgendaEventos.setText("Agenda de Compromissos Pessoal");
        AgendaEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaEventosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaEventos);

        AgendaRecados.setText("Agenda Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);
        Cadastros.add(jSeparator17);

        jMenu2.setForeground(new java.awt.Color(0, 102, 0));
        jMenu2.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        RegistrarInternoAtendimento.setForeground(new java.awt.Color(204, 0, 0));
        RegistrarInternoAtendimento.setText("Registrar  Atendimento por Biometria");
        RegistrarInternoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarInternoAtendimentoActionPerformed(evt);
            }
        });
        jMenu2.add(RegistrarInternoAtendimento);

        RegistroAtendimentoImpresso.setForeground(new java.awt.Color(0, 0, 204));
        RegistroAtendimentoImpresso.setText("Registro Atendimento por Impressão");
        RegistroAtendimentoImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoImpressoActionPerformed(evt);
            }
        });
        jMenu2.add(RegistroAtendimentoImpresso);

        Cadastros.add(jMenu2);
        Cadastros.add(jSeparator8);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        ControleMedicamentos.setText("Controle Medicamentos");

        SolicitacaoMedicamentosFarmacia.setText("Solicitação de Produtos/Medicamentos na Farmácia");
        SolicitacaoMedicamentosFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitacaoMedicamentosFarmaciaActionPerformed(evt);
            }
        });
        ControleMedicamentos.add(SolicitacaoMedicamentosFarmacia);
        ControleMedicamentos.add(jSeparator9);

        jMenu1.setText("Saída de Produtos/Medicamentos");

        DevolucaoMedicamentos.setText("Devolução de Produtos/Medicamentos a Farmácia");
        DevolucaoMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevolucaoMedicamentosActionPerformed(evt);
            }
        });
        jMenu1.add(DevolucaoMedicamentos);

        RequisicaoMedicamentosInternos.setForeground(new java.awt.Color(0, 0, 255));
        RequisicaoMedicamentosInternos.setText("Requisição de Medicamentos para Internos");
        RequisicaoMedicamentosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMedicamentosInternosActionPerformed(evt);
            }
        });
        jMenu1.add(RequisicaoMedicamentosInternos);

        RequisicaoProdutosMedicaoAvulsa.setText("Requisição Avulsa de Produtos/Medicação");
        RequisicaoProdutosMedicaoAvulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoProdutosMedicaoAvulsaActionPerformed(evt);
            }
        });
        jMenu1.add(RequisicaoProdutosMedicaoAvulsa);

        EstornoSaidaAvulsa.setText("Estorno de Saida Avulsa de Produtos/Medicação");
        EstornoSaidaAvulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstornoSaidaAvulsaActionPerformed(evt);
            }
        });
        jMenu1.add(EstornoSaidaAvulsa);

        ControleMedicamentos.add(jMenu1);
        ControleMedicamentos.add(jSeparator11);

        EstoqueMedicamentos.setText("Consulta de Estoque de Medicamentos");
        EstoqueMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstoqueMedicamentosActionPerformed(evt);
            }
        });
        ControleMedicamentos.add(EstoqueMedicamentos);

        jMenuBar1.add(ControleMedicamentos);

        Consultas.setText("Consultas Diversas");

        ProntuarioInternos.setForeground(new java.awt.Color(204, 0, 0));
        ProntuarioInternos.setText("Prontuários de Internos - {PRONTUÁRIO ÚNICO}");
        ProntuarioInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProntuarioInternosActionPerformed(evt);
            }
        });
        Consultas.add(ProntuarioInternos);

        LocalizacaoInternos.setText("Local de Internos");
        LocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalizacaoInternosActionPerformed(evt);
            }
        });
        Consultas.add(LocalizacaoInternos);
        Consultas.add(jSeparator3);

        AgendaEscoltaCrc.setText("Agendamento Escolta -  CRC");
        AgendaEscoltaCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaEscoltaCrcActionPerformed(evt);
            }
        });
        Consultas.add(AgendaEscoltaCrc);
        Consultas.add(jSeparator12);

        HistoricoMovInternos.setText("Histórico de Movimentação de Internos");
        HistoricoMovInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovInternosActionPerformed(evt);
            }
        });
        Consultas.add(HistoricoMovInternos);

        jMovimentacaoExternaInterno.setText("Histórico de Movimentação Externa de Internos ");
        jMovimentacaoExternaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMovimentacaoExternaInternoActionPerformed(evt);
            }
        });
        Consultas.add(jMovimentacaoExternaInterno);

        jMenuBar1.add(Consultas);

        Movimentacao.setText("Movimentação");

        AdmissaoMedicaPsiquiatrica.setText("Prontuario e Evolução Médica/Psiquiátrica - Admissão");
        AdmissaoMedicaPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissaoMedicaPsiquiatricaActionPerformed(evt);
            }
        });
        Movimentacao.add(AdmissaoMedicaPsiquiatrica);

        AvaliacaoSaudeMedicaPsiquiatrica.setText("Avaliação de Saúde Médica/Psiquiátrica");
        AvaliacaoSaudeMedicaPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvaliacaoSaudeMedicaPsiquiatricaActionPerformed(evt);
            }
        });
        Movimentacao.add(AvaliacaoSaudeMedicaPsiquiatrica);

        SolicitacaoExameMedico.setText("Solicitações de Exames Médicos");
        SolicitacaoExameMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitacaoExameMedicoActionPerformed(evt);
            }
        });
        Movimentacao.add(SolicitacaoExameMedico);

        jEncaminhamentosCirurgiasEspecialistas.setText("Encaminhamento de Cirurgias e Especialistas para Internos");
        jEncaminhamentosCirurgiasEspecialistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEncaminhamentosCirurgiasEspecialistasActionPerformed(evt);
            }
        });
        Movimentacao.add(jEncaminhamentosCirurgiasEspecialistas);
        Movimentacao.add(jSeparator1);

        AdmissoaEnfermagem.setText("Admissão/Evolução Enfermagem");
        AdmissoaEnfermagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissoaEnfermagemActionPerformed(evt);
            }
        });
        Movimentacao.add(AdmissoaEnfermagem);

        jCalendarioVacinas.setText("Calendário de Vacinas");
        jCalendarioVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalendarioVacinasActionPerformed(evt);
            }
        });
        Movimentacao.add(jCalendarioVacinas);

        JHistoricoDoencaFamilia.setText("Histórico de Doenças na Familia");
        JHistoricoDoencaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JHistoricoDoencaFamiliaActionPerformed(evt);
            }
        });
        Movimentacao.add(JHistoricoDoencaFamilia);
        Movimentacao.add(jSeparator13);

        AtendimentoTecEnfermagem.setText("Atendimento Técnico de Enfermagem");
        AtendimentoTecEnfermagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoTecEnfermagemActionPerformed(evt);
            }
        });
        Movimentacao.add(AtendimentoTecEnfermagem);
        Movimentacao.add(jSeparator2);

        Aprazementomedicoes.setText("Aprazamento de Medicações");
        Aprazementomedicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprazementomedicoesActionPerformed(evt);
            }
        });
        Movimentacao.add(Aprazementomedicoes);
        Movimentacao.add(jSeparator4);

        JPerfilCarcerario.setForeground(new java.awt.Color(255, 0, 0));
        JPerfilCarcerario.setText("Perfil da População Carcerária");
        JPerfilCarcerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPerfilCarcerarioActionPerformed(evt);
            }
        });
        Movimentacao.add(JPerfilCarcerario);

        jMenuItem3.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItem3.setText("P.A.I. - Programa de Assistência Individualizado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Movimentacao.add(jMenuItem3);
        Movimentacao.add(jSeparator14);

        LivroOcorrencia.setText("Livro de Ocorrência");
        LivroOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciaActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencia);

        jMenuBar1.add(Movimentacao);

        Relatorios.setText("Relatórios");

        jMenu7.setText("Relatórios de Confere");

        RelatorioGeralPavilhaoCelas.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralPavilhaoCelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralPavilhaoCelasActionPerformed(evt);
            }
        });
        jMenu7.add(RelatorioGeralPavilhaoCelas);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        jMenu7.add(ListagemConfere);

        MapaConfere.setText("Mapa de Confere");
        MapaConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapaConfereActionPerformed(evt);
            }
        });
        jMenu7.add(MapaConfere);

        Relatorios.add(jMenu7);
        Relatorios.add(jSeparator16);

        jMenuItem2.setText("Relatório de Previsão de Saída de Internos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem2);

        RelatorioInternosUnidadePenal.setText("Relatório de Internos na Unidade Penal");
        RelatorioInternosUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosUnidadePenalActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioInternosUnidadePenal);

        relatorioInternosSemCartaoSUS.setText("Relatório de Internos sem Cartão SUS");
        relatorioInternosSemCartaoSUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioInternosSemCartaoSUSActionPerformed(evt);
            }
        });
        Relatorios.add(relatorioInternosSemCartaoSUS);
        Relatorios.add(jSeparator15);

        jMenuItem4.setText("Relatório de Entrada de Internos na Unidade");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem4);

        jMenuBar1.add(Relatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelMedico)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelMedico)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void ProntuarioInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProntuarioInternosActionPerformed
        // TODO add your handling code here:
        if (objProntMedicoInt == null || objProntMedicoInt.isClosed()) {
            objProntMedicoInt = new TelaConsultaProntuarioInternoCrc();
            jPainelMedico.add(objProntMedicoInt);
            objProntMedicoInt.setVisible(true);
        } else {
            if (objProntMedicoInt.isVisible()) {
                if (objProntMedicoInt.isIcon()) { // Se esta minimizado
                    try {
                        objProntMedicoInt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objProntMedicoInt.toFront(); // traz para frente
                    objProntMedicoInt.pack();//volta frame 
                }
            } else {
                objProntMedicoInt = new TelaConsultaProntuarioInternoCrc();
                TelaModuloEnfermaria.jPainelMedico.add(objProntMedicoInt);//adicona frame ao JDesktopPane  
                objProntMedicoInt.setVisible(true);
            }
        }
        try {
            objProntMedicoInt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProntuarioInternosActionPerformed

    private void LocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalIntMedico == null || objLocalIntMedico.isClosed()) {
            objLocalIntMedico = new TelaConsultaLocalInternoMedico();
            jPainelMedico.add(objLocalIntMedico);
            objLocalIntMedico.setVisible(true);
        } else {
            if (objLocalIntMedico.isVisible()) {
                if (objLocalIntMedico.isIcon()) { // Se esta minimizado
                    try {
                        objLocalIntMedico.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalIntMedico.toFront(); // traz para frente
                    objLocalIntMedico.pack();//volta frame 
                }
            } else {
                objLocalIntMedico = new TelaConsultaLocalInternoMedico();
                TelaModuloEnfermaria.jPainelMedico.add(objLocalIntMedico);//adicona frame ao JDesktopPane  
                objLocalIntMedico.setVisible(true);
            }
        }
        try {
            objLocalIntMedico.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalizacaoInternosActionPerformed

    private void AdmissaoMedicaPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmissaoMedicaPsiquiatricaActionPerformed
        // TODO add your handling code here:       
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codAbrirENF == 1) {
            if (objAdmMedico == null || objAdmMedico.isClosed()) {
                objAdmMedico = new TelaAdmissaoMedica();
                jPainelMedico.add(objAdmMedico);
                objAdmMedico.setVisible(true);
            } else {
                if (objAdmMedico.isVisible()) {
                    if (objAdmMedico.isIcon()) { // Se esta minimizado
                        try {
                            objAdmMedico.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAdmMedico.toFront(); // traz para frente
                        objAdmMedico.pack();//volta frame 
                    }
                } else {
                    objAdmMedico = new TelaAdmissaoMedica();
                    TelaModuloEnfermaria.jPainelMedico.add(objAdmMedico);//adicona frame ao JDesktopPane  
                    objAdmMedico.setVisible(true);
                }
            }
            try {
                objAdmMedico.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AdmissaoMedicaPsiquiatricaActionPerformed

    private void HistoricoMovInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovInternosActionPerformed
        // TODO add your handling code here:
        if (objMovTecMedico == null || objMovTecMedico.isClosed()) {
            objMovTecMedico = new TelaMovHistoricoTecMedico();
            jPainelMedico.add(objMovTecMedico);
            objMovTecMedico.setVisible(true);
        } else {
            if (objMovTecMedico.isVisible()) {
                if (objMovTecMedico.isIcon()) { // Se esta minimizado
                    try {
                        objMovTecMedico.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMovTecMedico.toFront(); // traz para frente
                    objMovTecMedico.pack();//volta frame 
                }
            } else {
                objMovTecMedico = new TelaMovHistoricoTecMedico();
                TelaModuloEnfermaria.jPainelMedico.add(objMovTecMedico);//adicona frame ao JDesktopPane  
                objMovTecMedico.setVisible(true);
            }
        }
        try {
            objMovTecMedico.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovInternosActionPerformed

    private void AdmissoaEnfermagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmissoaEnfermagemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoEnfeIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAdmissaoEnfeIntManuENF) && codAbrirENF == 1) {
            if (objAdmEnfermagem == null || objAdmEnfermagem.isClosed()) {
                objAdmEnfermagem = new TelaAdmissaoEnfermagem();
                jPainelMedico.add(objAdmEnfermagem);
                objAdmEnfermagem.setVisible(true);
            } else {
                if (objAdmEnfermagem.isVisible()) {
                    if (objAdmEnfermagem.isIcon()) { // Se esta minimizado
                        try {
                            objAdmEnfermagem.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAdmEnfermagem.toFront(); // traz para frente
                        objAdmEnfermagem.pack();//volta frame 
                    }
                } else {
                    objAdmEnfermagem = new TelaAdmissaoEnfermagem();
                    TelaModuloEnfermaria.jPainelMedico.add(objAdmEnfermagem);//adicona frame ao JDesktopPane  
                    objAdmEnfermagem.setVisible(true);
                }
            }
            try {
                objAdmEnfermagem.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AdmissoaEnfermagemActionPerformed

    private void AtendimentoTecEnfermagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoTecEnfermagemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendTecEnfIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAtendTecEnfIntManuENF) && codAbrirENF == 1) {
            if (objEvolTecEnfer == null || objEvolTecEnfer.isClosed()) {
                objEvolTecEnfer = new TelaEvolucaoTecEnfermagem();
                jPainelMedico.add(objEvolTecEnfer);
                objEvolTecEnfer.setVisible(true);
            } else {
                if (objEvolTecEnfer.isVisible()) {
                    if (objEvolTecEnfer.isIcon()) { // Se esta minimizado
                        try {
                            objEvolTecEnfer.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEvolTecEnfer.toFront(); // traz para frente
                        objEvolTecEnfer.pack();//volta frame 
                    }
                } else {
                    objEvolTecEnfer = new TelaEvolucaoTecEnfermagem();
                    TelaModuloEnfermaria.jPainelMedico.add(objEvolTecEnfer);//adicona frame ao JDesktopPane  
                    objEvolTecEnfer.setVisible(true);
                }
            }
            try {
                objEvolTecEnfer.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoTecEnfermagemActionPerformed

    private void AprazementomedicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprazementomedicoesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprazaMedManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAprazaMedManuENF) && codAbrirENF == 1) {
            if (objAbraMed == null || objAbraMed.isClosed()) {
                objAbraMed = new TelaAprazamentoMedicacoes();
                jPainelMedico.add(objAbraMed);
                objAbraMed.setVisible(true);
            } else {
                if (objAbraMed.isVisible()) {
                    if (objAbraMed.isIcon()) { // Se esta minimizado
                        try {
                            objAbraMed.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAbraMed.toFront(); // traz para frente
                        objAbraMed.pack();//volta frame 
                    }
                } else {
                    objAbraMed = new TelaAprazamentoMedicacoes();
                    TelaModuloEnfermaria.jPainelMedico.add(objAbraMed);//adicona frame ao JDesktopPane  
                    objAbraMed.setVisible(true);
                }
            }
            try {
                objAbraMed.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AprazementomedicoesActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecEnfermaria == null || objRecEnfermaria.isClosed()) {
            objRecEnfermaria = new TelaRecadosEnfermaria();
            jPainelMedico.add(objRecEnfermaria);
            objRecEnfermaria.setVisible(true);
        } else {
            if (objRecEnfermaria.isVisible()) {
                if (objRecEnfermaria.isIcon()) { // Se esta minimizado
                    try {
                        objRecEnfermaria.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecEnfermaria.toFront(); // traz para frente
                    objRecEnfermaria.pack();//volta frame 
                }
            } else {
                objRecEnfermaria = new TelaRecadosEnfermaria();
                TelaModuloEnfermaria.jPainelMedico.add(objRecEnfermaria);//adicona frame ao JDesktopPane  
                objRecEnfermaria.setVisible(true);
            }
        }
        try {
            objRecEnfermaria.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void AgendaEscoltaCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaEscoltaCrcActionPerformed
        // TODO add your handling code here:
        if (objConAgenEscolta == null || objConAgenEscolta.isClosed()) {
            objConAgenEscolta = new TelaConsultaAgendaEscolta();
            jPainelMedico.add(objConAgenEscolta);
            objConAgenEscolta.setVisible(true);
        } else {
            if (objConAgenEscolta.isVisible()) {
                if (objConAgenEscolta.isIcon()) { // Se esta minimizado
                    try {
                        objConAgenEscolta.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConAgenEscolta.toFront(); // traz para frente
                    objConAgenEscolta.pack();//volta frame 
                }
            } else {
                objConAgenEscolta = new TelaConsultaAgendaEscolta();
                TelaModuloEnfermaria.jPainelMedico.add(objConAgenEscolta);//adicona frame ao JDesktopPane  
                objConAgenEscolta.setVisible(true);
            }
        }
        try {
            objConAgenEscolta.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaEscoltaCrcActionPerformed

    private void LivroOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDiaManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaOcorrenciaDiaManuENF) && codAbrirENF == 1) {
            if (objOcorreMedica == null || objOcorreMedica.isClosed()) {
                objOcorreMedica = new TelaOcorrenciaMedica();
                jPainelMedico.add(objOcorreMedica);
                objOcorreMedica.setVisible(true);
            } else {
                if (objOcorreMedica.isVisible()) {
                    if (objOcorreMedica.isIcon()) { // Se esta minimizado
                        try {
                            objOcorreMedica.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcorreMedica.toFront(); // traz para frente
                        objOcorreMedica.pack();//volta frame 
                    }
                } else {
                    objOcorreMedica = new TelaOcorrenciaMedica();
                    TelaModuloEnfermaria.jPainelMedico.add(objOcorreMedica);//adicona frame ao JDesktopPane  
                    objOcorreMedica.setVisible(true);
                }
            }
            try {
                objOcorreMedica.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciaActionPerformed

    private void CadastroDoencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroDoencasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoCadastroDoencasENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoCadastroDoencasENF) && codAbrirENF == 1) {
            if (objCadDoenca == null || objCadDoenca.isClosed()) {
                objCadDoenca = new TelaCadastroDoencas();
                jPainelMedico.add(objCadDoenca);
                objCadDoenca.setVisible(true);
            } else {
                if (objCadDoenca.isVisible()) {
                    if (objCadDoenca.isIcon()) { // Se esta minimizado
                        try {
                            objCadDoenca.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCadDoenca.toFront(); // traz para frente
                        objCadDoenca.pack();//volta frame 
                    }
                } else {
                    objCadDoenca = new TelaCadastroDoencas();
                    TelaModuloEnfermaria.jPainelMedico.add(objCadDoenca);//adicona frame ao JDesktopPane  
                    objCadDoenca.setVisible(true);
                }
            }
            try {
                objCadDoenca.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CadastroDoencasActionPerformed

    private void LocalEstoqueEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalEstoqueEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocalArmazenaENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaLocalArmazenaENF) && codAbrirENF == 1) {
            if (objLocalEnf == null || objLocalEnf.isClosed()) {
                objLocalEnf = new TelaLocalArmazenamentoEnfermaria();
                jPainelMedico.add(objLocalEnf);
                objLocalEnf.setVisible(true);
            } else {
                if (objLocalEnf.isVisible()) {
                    if (objLocalEnf.isIcon()) { // Se esta minimizado
                        try {
                            objLocalEnf.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objLocalEnf.toFront(); // traz para frente
                        objLocalEnf.pack();//volta frame 
                    }
                } else {
                    objLocalEnf = new TelaLocalArmazenamentoEnfermaria();
                    TelaModuloEnfermaria.jPainelMedico.add(objLocalEnf);//adicona frame ao JDesktopPane  
                    objLocalEnf.setVisible(true);
                }
            }
            try {
                objLocalEnf.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LocalEstoqueEnfermariaActionPerformed

    private void SolicitacaoMedicamentosFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitacaoMedicamentosFarmaciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSolicitacaoMateriaisManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaSolicitacaoMateriaisManuENF) && codAbrirENF == 1) {
            if (objSolProd == null || objSolProd.isClosed()) {
                objSolProd = new TelaSolicitacaoProdutosENFAR();
                jPainelMedico.add(objSolProd);
                objSolProd.setVisible(true);
            } else {
                if (objSolProd.isVisible()) {
                    if (objSolProd.isIcon()) { // Se esta minimizado
                        try {
                            objSolProd.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSolProd.toFront(); // traz para frente
                        objSolProd.pack();//volta frame 
                    }
                } else {
                    objSolProd = new TelaSolicitacaoProdutosENFAR();
                    TelaModuloEnfermaria.jPainelMedico.add(objSolProd);//adicona frame ao JDesktopPane  
                    objSolProd.setVisible(true);
                }
            }
            try {
                objSolProd.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SolicitacaoMedicamentosFarmaciaActionPerformed

    private void AprovadorSolicitacaoMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprovadorSolicitacaoMedicamentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadorSolicitacaoENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAprovadorSolicitacaoENF) && codAbrirENF == 1) {
            if (objUserAproSol == null || objUserAproSol.isClosed()) {
                objUserAproSol = new TelaAprovadorSolicitacaoMedicamentosENFA();
                jPainelMedico.add(objUserAproSol);
                objUserAproSol.setVisible(true);
            } else {
                if (objUserAproSol.isVisible()) {
                    if (objUserAproSol.isIcon()) { // Se esta minimizado
                        try {
                            objUserAproSol.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objUserAproSol.toFront(); // traz para frente
                        objUserAproSol.pack();//volta frame 
                    }
                } else {
                    objUserAproSol = new TelaAprovadorSolicitacaoMedicamentosENFA();
                    TelaModuloEnfermaria.jPainelMedico.add(objUserAproSol);//adicona frame ao JDesktopPane  
                    objUserAproSol.setVisible(true);
                }
            }
            try {
                objUserAproSol.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AprovadorSolicitacaoMedicamentosActionPerformed

    private void SolicitantesMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitantesMedicamentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSolicitantesMedicamentosENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaSolicitantesMedicamentosENF) && codAbrirENF == 1) {
            if (objSoliciante == null || objSoliciante.isClosed()) {
                objSoliciante = new TelaSolicitantesMedicamentos();
                jPainelMedico.add(objSoliciante);
                objSoliciante.setVisible(true);
            } else {
                if (objSoliciante.isVisible()) {
                    if (objSoliciante.isIcon()) { // Se esta minimizado
                        try {
                            objSoliciante.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSoliciante.toFront(); // traz para frente
                        objSoliciante.pack();//volta frame 
                    }
                } else {
                    objSoliciante = new TelaSolicitantesMedicamentos();
                    TelaModuloEnfermaria.jPainelMedico.add(objSoliciante);//adicona frame ao JDesktopPane  
                    objSoliciante.setVisible(true);
                }
            }
            try {
                objSoliciante.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SolicitantesMedicamentosActionPerformed

    private void jMotivoDevolucaoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMotivoDevolucaoProdutosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMotivoSaidaProdutoENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaMotivoSaidaProdutoENF) && codAbrirENF == 1) {
            if (objMotENFAR == null || objMotENFAR.isClosed()) {
                objMotENFAR = new TelaMotivoSaidaProdutosENFAR();
                jPainelMedico.add(objMotENFAR);
                objMotENFAR.setVisible(true);
            } else {
                if (objMotENFAR.isVisible()) {
                    if (objMotENFAR.isIcon()) { // Se esta minimizado
                        try {
                            objMotENFAR.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objMotENFAR.toFront(); // traz para frente
                        objMotENFAR.pack();//volta frame 
                    }
                } else {
                    objMotENFAR = new TelaMotivoSaidaProdutosENFAR();
                    TelaModuloEnfermaria.jPainelMedico.add(objMotENFAR);//adicona frame ao JDesktopPane  
                    objMotENFAR.setVisible(true);
                }
            }
            try {
                objMotENFAR.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jMotivoDevolucaoProdutosActionPerformed

    private void DevolucaoMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolucaoMedicamentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDevolucaoMedicamentosManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaDevolucaoMedicamentosManuENF) && codAbrirENF == 1) {
            if (objDevolMed == null || objDevolMed.isClosed()) {
                objDevolMed = new TelaDevolucaoMedicamentosEnfermariaFarmacia();
                jPainelMedico.add(objDevolMed);
                objDevolMed.setVisible(true);
            } else {
                if (objDevolMed.isVisible()) {
                    if (objDevolMed.isIcon()) { // Se esta minimizado
                        try {
                            objDevolMed.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objDevolMed.toFront(); // traz para frente
                        objDevolMed.pack();//volta frame 
                    }
                } else {
                    objDevolMed = new TelaDevolucaoMedicamentosEnfermariaFarmacia();
                    TelaModuloEnfermaria.jPainelMedico.add(objDevolMed);//adicona frame ao JDesktopPane  
                    objDevolMed.setVisible(true);
                }
            }
            try {
                objDevolMed.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_DevolucaoMedicamentosActionPerformed

    private void RequisicaoProdutosMedicaoAvulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoProdutosMedicaoAvulsaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisiçãoAvulsaMateriaisManutENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisiçãoAvulsaMateriaisManutENF) && codAbrirENF == 1) {
            if (objReqSaidENF == null || objReqSaidENF.isClosed()) {
                objReqSaidENF = new TelaRequisicaoAvulsaMedicamentosENF();
                jPainelMedico.add(objReqSaidENF);
                objReqSaidENF.setVisible(true);
            } else {
                if (objReqSaidENF.isVisible()) {
                    if (objReqSaidENF.isIcon()) { // Se esta minimizado
                        try {
                            objReqSaidENF.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objReqSaidENF.toFront(); // traz para frente
                        objReqSaidENF.pack();//volta frame 
                    }
                } else {
                    objReqSaidENF = new TelaRequisicaoAvulsaMedicamentosENF();
                    TelaModuloEnfermaria.jPainelMedico.add(objReqSaidENF);//adicona frame ao JDesktopPane  
                    objReqSaidENF.setVisible(true);
                }
            }
            try {
                objReqSaidENF.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RequisicaoProdutosMedicaoAvulsaActionPerformed

    private void EstoqueMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstoqueMedicamentosActionPerformed
        // TODO add your handling code here:
        if (objConsEstoMedi == null || objConsEstoMedi.isClosed()) {
            objConsEstoMedi = new TelaConsultaEstoqueENF();
            jPainelMedico.add(objConsEstoMedi);
            objConsEstoMedi.setVisible(true);
        } else {
            if (objConsEstoMedi.isVisible()) {
                if (objConsEstoMedi.isIcon()) { // Se esta minimizado
                    try {
                        objConsEstoMedi.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsEstoMedi.toFront(); // traz para frente
                    objConsEstoMedi.pack();//volta frame 
                }
            } else {
                objConsEstoMedi = new TelaConsultaEstoqueENF();
                TelaModuloEnfermaria.jPainelMedico.add(objConsEstoMedi);//adicona frame ao JDesktopPane  
                objConsEstoMedi.setVisible(true);
            }
        }
        try {
            objConsEstoMedi.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EstoqueMedicamentosActionPerformed

    private void EstornoSaidaAvulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstornoSaidaAvulsaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEstornoRequisiçãoMateriaisManutENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaEstornoRequisiçãoMateriaisManutENF) && codAbrirENF == 1) {
            if (objEstornoReqMed == null || objEstornoReqMed.isClosed()) {
                objEstornoReqMed = new TelaEstornoRequisicaoMateriaisENF();
                jPainelMedico.add(objEstornoReqMed);
                objEstornoReqMed.setVisible(true);
            } else {
                if (objEstornoReqMed.isVisible()) {
                    if (objEstornoReqMed.isIcon()) { // Se esta minimizado
                        try {
                            objEstornoReqMed.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEstornoReqMed.toFront(); // traz para frente
                        objEstornoReqMed.pack();//volta frame 
                    }
                } else {
                    objEstornoReqMed = new TelaEstornoRequisicaoMateriaisENF();
                    TelaModuloEnfermaria.jPainelMedico.add(objEstornoReqMed);//adicona frame ao JDesktopPane  
                    objEstornoReqMed.setVisible(true);
                }
            }
            try {
                objEstornoReqMed.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EstornoSaidaAvulsaActionPerformed

    private void AvaliacaoSaudeMedicaPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvaliacaoSaudeMedicaPsiquiatricaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAvaliaSaudeMedPsiENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAvaliaSaudeMedPsiENF) && codAbrirENF == 1) {
            if (objAvalicaioMedica == null || objAvalicaioMedica.isClosed()) {
                objAvalicaioMedica = new TelaAvaliacaoMedicaPsiquiatrica();
                jPainelMedico.add(objAvalicaioMedica);
                objAvalicaioMedica.setVisible(true);
            } else {
                if (objAvalicaioMedica.isVisible()) {
                    if (objAvalicaioMedica.isIcon()) { // Se esta minimizado
                        try {
                            objAvalicaioMedica.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAvalicaioMedica.toFront(); // traz para frente
                        objAvalicaioMedica.pack();//volta frame 
                    }
                } else {
                    objAvalicaioMedica = new TelaAvaliacaoMedicaPsiquiatrica();
                    TelaModuloEnfermaria.jPainelMedico.add(objAvalicaioMedica);//adicona frame ao JDesktopPane  
                    objAvalicaioMedica.setVisible(true);
                }
            }
            try {
                objAvalicaioMedica.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AvaliacaoSaudeMedicaPsiquiatricaActionPerformed

    private void RequisicaoMedicamentosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMedicamentosInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMedicaInterManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRequisicaoMedicaInterManuENF) && codAbrirENF == 1) {
            if (objRequisicaoMedInternos == null || objRequisicaoMedInternos.isClosed()) {
                objRequisicaoMedInternos = new TelaRequisicaoMedicamentosInternos();
                jPainelMedico.add(objRequisicaoMedInternos);
                objRequisicaoMedInternos.setVisible(true);
            } else {
                if (objRequisicaoMedInternos.isVisible()) {
                    if (objRequisicaoMedInternos.isIcon()) { // Se esta minimizado
                        try {
                            objRequisicaoMedInternos.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRequisicaoMedInternos.toFront(); // traz para frente
                        objRequisicaoMedInternos.pack();//volta frame 
                    }
                } else {
                    objRequisicaoMedInternos = new TelaRequisicaoMedicamentosInternos();
                    TelaModuloEnfermaria.jPainelMedico.add(objRequisicaoMedInternos);//adicona frame ao JDesktopPane  
                    objRequisicaoMedInternos.setVisible(true);
                }
            }
            try {
                objRequisicaoMedInternos.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RequisicaoMedicamentosInternosActionPerformed

    private void RelatorioGeralPavilhaoCelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralPavilhaoCelasActionPerformed
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
                    + "ON CELAS.IdPav=PAVILHAO.IdPav ORDER BY DescricaoPav,PRONTUARIOSCRC.NomeInternoCrc,CELAS.EndCelaPav");
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
    }//GEN-LAST:event_RelatorioGeralPavilhaoCelasActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloEnfermaria.jPainelMedico.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void MapaConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapaConfereActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereSeguranca mapop = new TelaRelMapaConfereSeguranca();
        TelaModuloEnfermaria.jPainelMedico.add(mapop);
        mapop.show();
    }//GEN-LAST:event_MapaConfereActionPerformed

    private void AgendaEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaEventosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelMedico.add(objAgEventos);
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
                TelaModuloEnfermaria.jPainelMedico.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaEventosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaDiversasTerapia objRelPrevSaiInt = new TelaRelatorioPrevisaoSaidaDiversasTerapia();
        TelaModuloEnfermaria.jPainelMedico.add(objRelPrevSaiInt);
        objRelPrevSaiInt.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void RelatorioInternosUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosUnidadePenalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosRegime.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "' "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos Por Regime Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO: " + e);
        }
    }//GEN-LAST:event_RelatorioInternosUnidadePenalActionPerformed

    private void jTiposExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTiposExamesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTipoExamesENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaTipoExamesENF) && codAbrirENF == 1) {
            if (objTipoEx == null || objTipoEx.isClosed()) {
                objTipoEx = new TelaTiposExames();
                jPainelMedico.add(objTipoEx);
                objTipoEx.setVisible(true);
            } else {
                if (objTipoEx.isVisible()) {
                    if (objTipoEx.isIcon()) { // Se esta minimizado
                        try {
                            objTipoEx.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTipoEx.toFront(); // traz para frente
                        objTipoEx.pack();//volta frame 
                    }
                } else {
                    objTipoEx = new TelaTiposExames();
                    TelaModuloEnfermaria.jPainelMedico.add(objTipoEx);//adicona frame ao JDesktopPane  
                    objTipoEx.setVisible(true);
                }
            }
            try {
                objTipoEx.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jTiposExamesActionPerformed

    private void SolicitacaoExameMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitacaoExameMedicoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSolicitacaoExamesIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaSolicitacaoExamesIntManuENF) && codAbrirENF == 1) {
            if (objSoliExame == null || objSoliExame.isClosed()) {
                objSoliExame = new TelaSolicitacaoExamesMedicoPsiquiatrico();
                jPainelMedico.add(objSoliExame);
                objSoliExame.setVisible(true);
            } else {
                if (objSoliExame.isVisible()) {
                    if (objSoliExame.isIcon()) { // Se esta minimizado
                        try {
                            objSoliExame.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSoliExame.toFront(); // traz para frente
                        objSoliExame.pack();//volta frame 
                    }
                } else {
                    objSoliExame = new TelaSolicitacaoExamesMedicoPsiquiatrico();
                    TelaModuloEnfermaria.jPainelMedico.add(objSoliExame);//adicona frame ao JDesktopPane  
                    objSoliExame.setVisible(true);
                }
            }
            try {
                objSoliExame.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SolicitacaoExameMedicoActionPerformed

    private void jTiposVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTiposVacinasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTiposVacinasENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaTiposVacinasENF) && codAbrirENF == 1) {
            if (objTipoVac == null || objTipoVac.isClosed()) {
                objTipoVac = new TelaTiposVacinas();
                jPainelMedico.add(objTipoVac);
                objTipoVac.setVisible(true);
            } else {
                if (objTipoVac.isVisible()) {
                    if (objTipoVac.isIcon()) { // Se esta minimizado
                        try {
                            objTipoVac.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTipoVac.toFront(); // traz para frente
                        objTipoVac.pack();//volta frame 
                    }
                } else {
                    objTipoVac = new TelaTiposVacinas();
                    TelaModuloEnfermaria.jPainelMedico.add(objTipoVac);//adicona frame ao JDesktopPane  
                    objTipoVac.setVisible(true);
                }
            }
            try {
                objTipoVac.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jTiposVacinasActionPerformed

    private void jCalendarioVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalendarioVacinasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCalendarioVacinasIntManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaCalendarioVacinasIntManuENF) && codAbrirENF == 1) {
            if (objCalVacina == null || objCalVacina.isClosed()) {
                objCalVacina = new TelaCalendarioVacinasInternos();
                jPainelMedico.add(objCalVacina);
                objCalVacina.setVisible(true);
            } else {
                if (objCalVacina.isVisible()) {
                    if (objCalVacina.isIcon()) { // Se esta minimizado
                        try {
                            objCalVacina.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCalVacina.toFront(); // traz para frente
                        objCalVacina.pack();//volta frame 
                    }
                } else {
                    objCalVacina = new TelaCalendarioVacinasInternos();
                    TelaModuloEnfermaria.jPainelMedico.add(objCalVacina);//adicona frame ao JDesktopPane  
                    objCalVacina.setVisible(true);
                }
            }
            try {
                objCalVacina.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCalendarioVacinasActionPerformed

    private void JHistoricoDoencaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JHistoricoDoencaFamiliaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaHistDoencaFamManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaHistDoencaFamManuENF) && codAbrirENF == 1) {
            if (objHistDoencaAtual == null || objHistDoencaAtual.isClosed()) {
                objHistDoencaAtual = new TelaHistoricoDoencasFamiliar();
                jPainelMedico.add(objHistDoencaAtual);
                objHistDoencaAtual.setVisible(true);
            } else {
                if (objHistDoencaAtual.isVisible()) {
                    if (objHistDoencaAtual.isIcon()) { // Se esta minimizado
                        try {
                            objHistDoencaAtual.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objHistDoencaAtual.toFront(); // traz para frente
                        objHistDoencaAtual.pack();//volta frame 
                    }
                } else {
                    objHistDoencaAtual = new TelaHistoricoDoencasFamiliar();
                    TelaModuloEnfermaria.jPainelMedico.add(objHistDoencaAtual);//adicona frame ao JDesktopPane  
                    objHistDoencaAtual.setVisible(true);
                }
            }
            try {
                objHistDoencaAtual.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_JHistoricoDoencaFamiliaActionPerformed

    private void jEncaminhamentosCirurgiasEspecialistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEncaminhamentosCirurgiasEspecialistasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEncamInterCiruEspeManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaEncamInterCiruEspeManuENF) && codAbrirENF == 1) {
            if (objEncaInteCE == null || objEncaInteCE.isClosed()) {
                objEncaInteCE = new TelaEncaminhamentoInternosCirurgiasEspecialistas();
                jPainelMedico.add(objEncaInteCE);
                objEncaInteCE.setVisible(true);
            } else {
                if (objEncaInteCE.isVisible()) {
                    if (objEncaInteCE.isIcon()) { // Se esta minimizado
                        try {
                            objEncaInteCE.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEncaInteCE.toFront(); // traz para frente
                        objEncaInteCE.pack();//volta frame 
                    }
                } else {
                    objEncaInteCE = new TelaEncaminhamentoInternosCirurgiasEspecialistas();
                    TelaModuloEnfermaria.jPainelMedico.add(objEncaInteCE);//adicona frame ao JDesktopPane  
                    objEncaInteCE.setVisible(true);
                }
            }
            try {
                objEncaInteCE.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEncaminhamentosCirurgiasEspecialistasActionPerformed

    private void jMovimentacaoExternaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMovimentacaoExternaInternoActionPerformed
        // TODO add your handling code here:
        if (objHistMovExt == null || objHistMovExt.isClosed()) {
            objHistMovExt = new TelaMovimentacaoExternaInternos();
            jPainelMedico.add(objHistMovExt);
            objHistMovExt.setVisible(true);
        } else {
            if (objHistMovExt.isVisible()) {
                if (objHistMovExt.isIcon()) { // Se esta minimizado
                    try {
                        objHistMovExt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistMovExt.toFront(); // traz para frente
                    objHistMovExt.pack();//volta frame 
                }
            } else {
                objHistMovExt = new TelaMovimentacaoExternaInternos();
                TelaModuloEnfermaria.jPainelMedico.add(objHistMovExt);//adicona frame ao JDesktopPane  
                objHistMovExt.setVisible(true);
            }
        }
        try {
            objHistMovExt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMovimentacaoExternaInternoActionPerformed

    private void relatorioInternosSemCartaoSUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioInternosSemCartaoSUSActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosSemCartaoSUS.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE PRONTUARIOSCRC.CartaoSus='" + cartaoSUS + "' AND SituacaoCrc='" + situacaoEnt + "' OR PRONTUARIOSCRC.CartaoSus='" + cartaoSUS + "' AND SituacaoCrc='" + situacaoRet + "'ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos por Cidade e Bairro");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_relatorioInternosSemCartaoSUSActionPerformed

    private void JPerfilCarcerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPerfilCarcerarioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPerfilCarManuENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaPerfilCarManuENF) && codAbrirENF == 1) {
            if (objPerfilCarEnf == null || objPerfilCarEnf.isClosed()) {
                objPerfilCarEnf = new TelaPerfilCarcerarioEnfermaria();
                jPainelMedico.add(objPerfilCarEnf);
                objPerfilCarEnf.setVisible(true);
            } else {
                if (objPerfilCarEnf.isVisible()) {
                    if (objPerfilCarEnf.isIcon()) { // Se esta minimizado
                        try {
                            objPerfilCarEnf.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPerfilCarEnf.toFront(); // traz para frente
                        objPerfilCarEnf.pack();//volta frame 
                    }
                } else {
                    objPerfilCarEnf = new TelaPerfilCarcerarioEnfermaria();
                    TelaModuloEnfermaria.jPainelMedico.add(objPerfilCarEnf);//adicona frame ao JDesktopPane  
                    objPerfilCarEnf.setVisible(true);
                }
            }
            try {
                objPerfilCarEnf.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_JPerfilCarcerarioActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPaiManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaPaiManu) && codAbrirENF == 1) {
            if (objPaiMed == null || objPaiMed.isClosed()) {
                objPaiMed = new TelaPAI_NOVO();
                jPainelMedico.add(objPaiMed);
                objPaiMed.setVisible(true);
            } else {
                if (objPaiMed.isVisible()) {
                    if (objPaiMed.isIcon()) { // Se esta minimizado
                        try {
                            objPaiMed.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPaiMed.toFront(); // traz para frente
                        objPaiMed.pack();//volta frame 
                    }
                } else {
                    objPaiMed = new TelaPAI_NOVO();
                    TelaModuloEnfermaria.jPainelMedico.add(objPaiMed);//adicona frame ao JDesktopPane  
                    objPaiMed.setVisible(true);
                }
            }
            try {
                objPaiMed.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloEnfermaria.jPainelMedico.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void RegistrarInternoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarInternoAtendimentoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroIntAtendENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRegistroIntAtendENF) && codAbrirENF == 1) {
            if (objRegIntAtend == null || objRegIntAtend.isClosed()) {
                objRegIntAtend = new TelaRegistroInternosAtendimento();
                jPainelMedico.add(objRegIntAtend);
                objRegIntAtend.setVisible(true);
            } else {
                if (objRegIntAtend.isVisible()) {
                    if (objRegIntAtend.isIcon()) { // Se esta minimizado
                        try {
                            objRegIntAtend.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegIntAtend.toFront(); // traz para frente
                        objRegIntAtend.pack();//volta frame 
                    }
                } else {
                    objRegIntAtend = new TelaRegistroInternosAtendimento();
                    TelaModuloEnfermaria.jPainelMedico.add(objRegIntAtend);//adicona frame ao JDesktopPane  
                    objRegIntAtend.setVisible(true);
                }
            }
            try {
                objRegIntAtend.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistrarInternoAtendimentoActionPerformed

    private void jTiposTratametoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTiposTratametoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTipoTratamentoManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaTipoTratamentoManu) && codAbrirENF == 1) {
            if (objTipoTrata == null || objTipoTrata.isClosed()) {
                objTipoTrata = new TelaTiposTratamentos();
                jPainelMedico.add(objTipoTrata);
                objTipoTrata.setVisible(true);
            } else {
                if (objTipoTrata.isVisible()) {
                    if (objTipoTrata.isIcon()) { // Se esta minimizado
                        try {
                            objTipoTrata.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTipoTrata.toFront(); // traz para frente
                        objTipoTrata.pack();//volta frame 
                    }
                } else {
                    objTipoTrata = new TelaTiposTratamentos();
                    TelaModuloEnfermaria.jPainelMedico.add(objTipoTrata);//adicona frame ao JDesktopPane  
                    objTipoTrata.setVisible(true);
                }
            }
            try {
                objTipoTrata.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jTiposTratametoActionPerformed

    private void RegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtenImpENF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaRegistroAtenImpENF) && codAbrirENF == 1) {
            if (objAutoImp == null || objAutoImp.isClosed()) {
                objAutoImp = new TelaRegistroInternosAtendimentoImpresso();
                jPainelMedico.add(objAutoImp);
                objAutoImp.setVisible(true);
            } else {
                if (objAutoImp.isVisible()) {
                    if (objAutoImp.isIcon()) { // Se esta minimizado
                        try {
                            objAutoImp.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAutoImp.toFront(); // traz para frente
                        objAutoImp.pack();//volta frame 
                    }
                } else {
                    objAutoImp = new TelaRegistroInternosAtendimentoImpresso();
                    TelaModuloEnfermaria.jPainelMedico.add(objAutoImp);//adicona frame ao JDesktopPane  
                    objAutoImp.setVisible(true);
                }
            }
            try {
                objAutoImp.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroAtendimentoImpressoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdmissaoMedicaPsiquiatrica;
    private javax.swing.JMenuItem AdmissoaEnfermagem;
    private javax.swing.JMenuItem AgendaEscoltaCrc;
    private javax.swing.JMenuItem AgendaEventos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem Aprazementomedicoes;
    private javax.swing.JMenuItem AprovadorSolicitacaoMedicamentos;
    private javax.swing.JMenuItem AtendimentoTecEnfermagem;
    private javax.swing.JMenuItem AvaliacaoSaudeMedicaPsiquiatrica;
    private javax.swing.JMenuItem CadastroDoencas;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu ControleMedicamentos;
    private javax.swing.JMenuItem DevolucaoMedicamentos;
    private javax.swing.JMenuItem EstoqueMedicamentos;
    private javax.swing.JMenuItem EstornoSaidaAvulsa;
    private javax.swing.JMenuItem HistoricoMovInternos;
    private javax.swing.JMenuItem JHistoricoDoencaFamilia;
    private javax.swing.JMenuItem JPerfilCarcerario;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LivroOcorrencia;
    private javax.swing.JMenuItem LocalEstoqueEnfermaria;
    private javax.swing.JMenuItem LocalizacaoInternos;
    private javax.swing.JMenuItem MapaConfere;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem ProntuarioInternos;
    private javax.swing.JMenuItem RegistrarInternoAtendimento;
    private javax.swing.JMenuItem RegistroAtendimentoImpresso;
    private javax.swing.JMenuItem RelatorioGeralPavilhaoCelas;
    private javax.swing.JMenuItem RelatorioInternosUnidadePenal;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem RequisicaoMedicamentosInternos;
    private javax.swing.JMenuItem RequisicaoProdutosMedicaoAvulsa;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem SolicitacaoExameMedico;
    private javax.swing.JMenuItem SolicitacaoMedicamentosFarmacia;
    private javax.swing.JMenuItem SolicitantesMedicamentos;
    private javax.swing.JMenuItem jCalendarioVacinas;
    private javax.swing.JMenuItem jEncaminhamentosCirurgiasEspecialistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMotivoDevolucaoProdutos;
    private javax.swing.JMenuItem jMovimentacaoExternaInterno;
    public static javax.swing.JDesktopPane jPainelMedico;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jTiposExames;
    private javax.swing.JMenuItem jTiposTratameto;
    private javax.swing.JMenuItem jTiposVacinas;
    private javax.swing.JMenuItem relatorioInternosSemCartaoSUS;
    // End of variables declaration//GEN-END:variables

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

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado(); // Verificar recados a cada 5 minutos 
                verificarAgendaCompromisso(); // VERIFICAR AGENDA DE COMPROMISSO.
            }
        }, periodo, tempo);
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
                TelaRecadosCrc objRecados = new TelaRecadosCrc();
                TelaModuloEnfermaria.jPainelMedico.add(objRecados);
                objRecados.show();
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
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO_AGENDA: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
            //  JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar mensagem.\nERRO:" + ex);
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
//            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO_USUARIOS: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Data", " Descrição da Doença"};
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
        jTabelaTodosRecados.getTableHeader().setReorderingAllowed(false);
        jTabelaTodosRecados.setAutoResizeMode(jTabelaTodosRecados.AUTO_RESIZE_OFF);
        jTabelaTodosRecados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
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
                TelaModuloEnfermaria.jPainelMedico.add(objAgendaComp);
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

    // PESQUISA E CADASTRO DAS TELAS DO MÓDULO ENFERMARIA PARA CONTROLE DE ACESSO DE USUÁRIOS.
    public void pesquisarTelasAcessos() {
        //CADASTRO
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAcessoCadastroDoencasENF + "'");
            conecta.rs.first();
            pNomeACD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTipoExamesENF + "'");
            conecta.rs.first();
            pNomeTE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTiposVacinasENF + "'");
            conecta.rs.first();
            pNomeTV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocalArmazenaENF + "'");
            conecta.rs.first();
            pNomeLA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitantesMedicamentosENF + "'");
            conecta.rs.first();
            pNomeSM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprovadorSolicitacaoENF + "'");
            conecta.rs.first();
            pNomeAS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaMotivoSaidaProdutoENF + "'");
            conecta.rs.first();
            pNomeMSP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroIntAtendENF + "'");
            conecta.rs.first();
            pNomeRIA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTipoTratamentoManu + "'");
            conecta.rs.first();
            pNomeTTM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtenImpENF + "'");
            conecta.rs.first();
            pNomeRAII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroLibAtenImpENF + "'");
            conecta.rs.first();
            pNomeRLAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroIntAtendInciarLeitorENF + "'");
            conecta.rs.first();
            pNomeRIAIL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONTROLE DE MEDICAMENTOS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoMateriaisManuENF + "'");
            conecta.rs.first();
            pNomeSMM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoMateriaisProdENF + "'");
            conecta.rs.first();
            pNomeSMP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDevolucaoMedicamentosManuENF + "'");
            conecta.rs.first();
            pNomeDMM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDevolucaoMedicamentosItensENF + "'");
            conecta.rs.first();
            pNomeDMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisicaoMedicaInterManuENF + "'");
            conecta.rs.first();
            pNomeRMIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisicaoMedicaInterItensENF + "'");
            conecta.rs.first();
            pNomeRMII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisiçãoAvulsaMateriaisManutENF + "'");
            conecta.rs.first();
            pNomeRAMM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisiçãoAvulsaMateriaisManutItensENF + "'");
            conecta.rs.first();
            pNomeRAMMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEstornoRequisiçãoMateriaisManutENF + "'");
            conecta.rs.first();
            pNomeERMM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEstornoRequisiçãoMateriaisManutItensENF + "'");
            conecta.rs.first();
            pNomeERMMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAcessoProntuarioMedicoENF + "'");
            conecta.rs.first();
            pNomeAPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEvolucaoPsiquiatricaENF + "'");
            conecta.rs.first();
            pNomeEP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEvolucaoMedicaENF + "'");
            conecta.rs.first();
            pNomeEM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPrescricaoMedicaENF + "'");
            conecta.rs.first();
            pNomePM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtestadoMedicoENF + "'");
            conecta.rs.first();
            pNomeAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDietaMedicaENF + "'");
            conecta.rs.first();
            pNomeDM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAvaliaSaudeMedPsiENF + "'");
            conecta.rs.first();
            pNomeAMP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAvaliaSaudeMedPsiTratENF + "'");
            conecta.rs.first();
            pNomeAMPT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoExamesIntManuENF + "'");
            conecta.rs.first();
            pNomeSEIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoExamesIntManuExameENF + "'");
            conecta.rs.first();
            pNomeSEIME = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEncamInterCiruEspeManuENF + "'");
            conecta.rs.first();
            pNomeEICEM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEncamInterCiruEspeManuEncaENF + "'");
            conecta.rs.first();
            pNomeEICEE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoEnfeIntManuENF + "'");
            conecta.rs.first();
            pNomeAEIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoEnfeIntEvolENF + "'");
            conecta.rs.first();
            pNomeAEIE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissãoEnfeIntAEFP1ENF + "'");
            conecta.rs.first();
            pNomeAEIP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissãoEnfeIntAEFP2ENF + "'");
            conecta.rs.first();
            pNomeAEIP2 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissãoEnfeIntAEFP3ENF + "'");
            conecta.rs.first();
            pNomeAEIP3 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissãoEnfeIntAEFP4ENF + "'");
            conecta.rs.first();
            pNomeAEIP4 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCalendarioVacinasIntManuENF + "'");
            conecta.rs.first();
            pNomeCVIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCalendarioVacinasIntVaciENF + "'");
            conecta.rs.first();
            pNomeCVIV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaHistDoencaFamManuENF + "'");
            conecta.rs.first();
            pNomeHDFM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaHistDoencaFamPatParENF + "'");
            conecta.rs.first();
            pNomeHDFPP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendTecEnfIntManuENF + "'");
            conecta.rs.first();
            pNomeATEIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendTecEnfIntEvolENF + "'");
            conecta.rs.first();
            pNomeATEIE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprazaMedManuENF + "'");
            conecta.rs.first();
            pNomeAMM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprazaMedItensENF + "'");
            conecta.rs.first();
            pNomeAMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilCarManuENF + "'");
            conecta.rs.first();
            pNomePCN = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilCarPerCarENF + "'");
            conecta.rs.first();
            pNomePCPC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiManu + "'");
            conecta.rs.first();
            pNomePPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGF + "'");
            conecta.rs.first();
            pNomePCCGF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFFam + "'");
            conecta.rs.first();
            pNomePCCGFa = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVis + "'");
            conecta.rs.first();
            pNomePCCGFVis = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVis + "'");
            conecta.rs.first();
            pNomePCCGFVis = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVisInt + "'");
            conecta.rs.first();
            pNomePCCGFVisInt = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDEME + "'");
            conecta.rs.first();
            pNomePDEME = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDPTL + "'");
            conecta.rs.first();
            pNomePDPTL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDJ + "'");
            conecta.rs.first();
            pNomePDJ = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDS + "'");
            conecta.rs.first();
            pNomePDS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEAPI1 + "'");
            conecta.rs.first();
            pNomePEADPI1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEAPI2 + "'");
            conecta.rs.first();
            pNomePEADPI2 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEPAI + "'");
            conecta.rs.first();
            pNomePEPAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaDiaManuENF + "'");
            conecta.rs.first();
            pNomeODM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONSULTA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaConsultaProntuarioInternosDocENF + "'");
            conecta.rs.first();
            pNomeCPID = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CADASTRO
        if (!pNomeACD.equals(telaAcessoCadastroDoencasENF) || pNomeACD == null || pNomeACD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAcessoCadastroDoencasENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTE.equals(telaTipoExamesENF) || pNomeTE == null || pNomeTE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTipoExamesENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTV.equals(telaTiposVacinasENF) || pNomeTV == null || pNomeTV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTiposVacinasENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLA.equals(telaLocalArmazenaENF) || pNomeLA == null || pNomeLA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocalArmazenaENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSM.equals(telaSolicitantesMedicamentosENF) || pNomeSM == null || pNomeSM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitantesMedicamentosENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAS.equals(telaAprovadorSolicitacaoENF) || pNomeAS == null || pNomeAS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprovadorSolicitacaoENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeMSP.equals(telaMotivoSaidaProdutoENF) || pNomeMSP == null || pNomeMSP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaMotivoSaidaProdutoENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAII.equals(telaRegistroAtenImpENF) || pNomeRAII == null || pNomeRAII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtenImpENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRLAI.equals(telaRegistroLibAtenImpENF) || pNomeRLAI == null || pNomeRLAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroLibAtenImpENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRIAIL.equals(telaRegistroIntAtendInciarLeitorENF) || pNomeRIAIL == null || pNomeRIAIL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroIntAtendInciarLeitorENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // CONTROLE DE MEDICAMENTOS
        if (!pNomeSMM.equals(telaSolicitacaoMateriaisManuENF) || pNomeSMM == null || pNomeSMM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoMateriaisManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSMP.equals(telaSolicitacaoMateriaisProdENF) || pNomeSMP == null || pNomeSMP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoMateriaisProdENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDMM.equals(telaDevolucaoMedicamentosManuENF) || pNomeDMM == null || pNomeDMM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDevolucaoMedicamentosManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDMI.equals(telaDevolucaoMedicamentosItensENF) || pNomeDMI == null || pNomeDMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDevolucaoMedicamentosItensENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRMIM.equals(telaRequisicaoMedicaInterManuENF) || pNomeRMIM == null || pNomeRMIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisicaoMedicaInterManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRMII.equals(telaRequisicaoMedicaInterItensENF) || pNomeRMII == null || pNomeRMII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisicaoMedicaInterItensENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAMM.equals(telaRequisiçãoAvulsaMateriaisManutENF) || pNomeRAMM == null || pNomeRAMM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisiçãoAvulsaMateriaisManutENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAMMI.equals(telaRequisiçãoAvulsaMateriaisManutItensENF) || pNomeRAMMI == null || pNomeRAMMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisiçãoAvulsaMateriaisManutItensENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeERMM.equals(telaEstornoRequisiçãoMateriaisManutENF) || pNomeERMM == null || pNomeERMM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEstornoRequisiçãoMateriaisManutENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeERMMI.equals(telaEstornoRequisiçãoMateriaisManutItensENF) || pNomeERMMI == null || pNomeERMMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEstornoRequisiçãoMateriaisManutItensENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //MOVIMENTAÇÃO
        if (!pNomeAPM.equals(telaAcessoProntuarioMedicoENF) || pNomeAPM == null || pNomeAPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAcessoProntuarioMedicoENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEP.equals(telaEvolucaoPsiquiatricaENF) || pNomeEP == null || pNomeEP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEvolucaoPsiquiatricaENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEM.equals(telaEvolucaoMedicaENF) || pNomeEM == null || pNomeEM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEvolucaoMedicaENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePM.equals(telaPrescricaoMedicaENF) || pNomePM == null || pNomePM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPrescricaoMedicaENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAM.equals(telaAtestadoMedicoENF) || pNomeAM == null || pNomeAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtestadoMedicoENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDM.equals(telaDietaMedicaENF) || pNomeDM == null || pNomeDM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDietaMedicaENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAMP.equals(telaAvaliaSaudeMedPsiENF) || pNomeAMP == null || pNomeAMP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAvaliaSaudeMedPsiENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAMPT.equals(telaAvaliaSaudeMedPsiTratENF) || pNomeAMPT == null || pNomeAMPT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAvaliaSaudeMedPsiTratENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSEIM.equals(telaSolicitacaoExamesIntManuENF) || pNomeSEIM == null || pNomeSEIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoExamesIntManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSEIME.equals(telaSolicitacaoExamesIntManuExameENF) || pNomeSEIME == null || pNomeSEIME.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoExamesIntManuExameENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEICEM.equals(telaEncamInterCiruEspeManuENF) || pNomeEICEM == null || pNomeEICEM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEncamInterCiruEspeManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEICEE.equals(telaEncamInterCiruEspeManuEncaENF) || pNomeEICEE == null || pNomeEICEE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEncamInterCiruEspeManuEncaENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIM.equals(telaAdmissaoEnfeIntManuENF) || pNomeAEIM == null || pNomeAEIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoEnfeIntManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIE.equals(telaAdmissaoEnfeIntEvolENF) || pNomeAEIE == null || pNomeAEIE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoEnfeIntEvolENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIP1.equals(telaAdmissãoEnfeIntAEFP1ENF) || pNomeAEIP1 == null || pNomeAEIP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissãoEnfeIntAEFP1ENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIP2.equals(telaAdmissãoEnfeIntAEFP2ENF) || pNomeAEIP2 == null || pNomeAEIP2.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissãoEnfeIntAEFP2ENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIP3.equals(telaAdmissãoEnfeIntAEFP3ENF) || pNomeAEIP3 == null || pNomeAEIP3.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissãoEnfeIntAEFP3ENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIP4.equals(telaAdmissãoEnfeIntAEFP4ENF) || pNomeAEIP4 == null || pNomeAEIP4.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissãoEnfeIntAEFP4ENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCVIM.equals(telaCalendarioVacinasIntManuENF) || pNomeCVIM == null || pNomeCVIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCalendarioVacinasIntManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCVIV.equals(telaCalendarioVacinasIntVaciENF) || pNomeCVIV == null || pNomeCVIV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCalendarioVacinasIntVaciENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeHDFM.equals(telaHistDoencaFamManuENF) || pNomeHDFM == null || pNomeHDFM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaHistDoencaFamManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeHDFPP.equals(telaHistDoencaFamPatParENF) || pNomeHDFPP == null || pNomeHDFPP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaHistDoencaFamPatParENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeATEIM.equals(telaAtendTecEnfIntManuENF) || pNomeATEIM == null || pNomeATEIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendTecEnfIntManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeATEIE.equals(telaAtendTecEnfIntEvolENF) || pNomeATEIE == null || pNomeATEIE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendTecEnfIntEvolENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAMM.equals(telaAprazaMedManuENF) || pNomeAMM == null || pNomeAMM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprazaMedManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAMI.equals(telaAprazaMedItensENF) || pNomeAMI == null || pNomeAMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprazaMedItensENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCN.equals(telaPerfilCarManuENF) || pNomePCN == null || pNomePCN.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilCarManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCPC.equals(telaPerfilCarPerCarENF) || pNomePCPC == null || pNomePCPC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilCarPerCarENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePPM.equals(telaPaiManu) || pNomePPM == null || pNomePPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiManu);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGF.equals(telaPaiCCGF) || pNomePCCGF == null || pNomePCCGF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFa.equals(telaPaiCCGFFam) || pNomePCCGFa == null || pNomePCCGFa.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFFam);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFVis.equals(telaPaiCCGFVis) || pNomePCCGFVis == null || pNomePCCGFVis.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFVis);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFVisInt.equals(telaPaiCCGFVisInt) || pNomePCCGFVisInt == null || pNomePCCGFVisInt.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFVisInt);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDEME.equals(telaPaiDEME) || pNomePDEME == null || pNomePDEME.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDEME);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDPTL.equals(telaPaiDPTL) || pNomePDPTL == null || pNomePDPTL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDPTL);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDJ.equals(telaPaiDJ) || pNomePDJ == null || pNomePDJ.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDJ);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDS.equals(telaPaiDS) || pNomePDS == null || pNomePDS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEADPI1.equals(telaPaiEAPI1) || pNomePEADPI1 == null || pNomePEADPI1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEAPI1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEADPI2.equals(telaPaiEAPI2) || pNomePEADPI2 == null || pNomePEADPI2.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEAPI2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEPAI.equals(telaPaiEPAI) || pNomePEPAI == null || pNomePEPAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEPAI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeODM.equals(telaOcorrenciaDiaManuENF) || pNomeODM == null || pNomeODM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaDiaManuENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRIA.equals(telaRegistroIntAtendENF) || pNomeRIA == null || pNomeRIA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroIntAtendENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTTM.equals(telaTipoTratamentoManu) || pNomeTTM == null || pNomeTTM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTipoTratamentoManu);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // CONSULTA
        if (!pNomeCPID.equals(telaConsultaProntuarioInternosDocENF) || pNomeCPID == null || pNomeCPID.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaConsultaProntuarioInternosDocENF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloENFER + "'");
            conecta.rs.first();
            pCodModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
    }
}
