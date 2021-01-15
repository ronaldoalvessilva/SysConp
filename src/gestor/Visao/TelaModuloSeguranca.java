/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleTelasSistema;
import gestor.Controle.converterDataStringDataDate;
import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleImplementacoes;
import gestor.Modelo.CadastroTelasSistema;
import gestor.Modelo.ParametrosCrc;
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
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloSeguranca.jPainelSeguranca;
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
public class TelaModuloSeguranca extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    ParametrosCrc objParCrc = new ParametrosCrc();
    ControleImplementacoes controlImp = new ControleImplementacoes();
    //
    private TelaLocacaoInterno objLoca = null;
    private TelaTransCelas objTransCelas = null;
    private TelaRecadosSeguranca objRecaSegu = null;
    private TelaPavilhao objPav = null;
    private TelaCelas objCelas = null;
    private TelaPopulacao objPop = null;
    private TelaRolVisitasPortaria objRolVisitas = null;
    private TelaVisitaInternosSeguranca objViInter = null;
    private TelaConsultaAgendaEscoltaPortaria objConAgenda = null;
    private TelaMovHistoricoTecSeguranca objHistMovSeg = null;
    private TelaConsultaEntSaiIntPortSeguranca objConSaidaInt = null;
    private TelaConsultaLocalInternoSeguranca objLocalInter = null;
    private TelaConsultaProntuarioInternoCrc objConsultaInternoSeg = null;
    private TelaOcorrenciaSeguranca objOcoSegu = null;
    private TelaConsultaListaPassagemInternosSeg oblConListaPass = null;
    private TelaMovimentacaoCrcSeguranca objHistCrc = null;
    private TelaControleDepositoSeguranca objControlValores = null;
    private TelaPertences objPertences = null;
    private TelaEntradaObjetosPertences objEntraObj = null;
    private TelaLocalEstoquePertences objLocalPert = null;
    private TelaObjetosProcedimento objObjetos = null;
    private TelaRegistroObjetosProcedimentos objRegistroProc = null;
    private TelaSaidaObjetosPertences objSaidaObjPertences = null;
    private TelaEventoDisciplinar objEventoDiscpliar = null;
    private TelaLocalEventoIndisciplinar objLocalEve = null;
    private TelaNaturezaEventoIndisciplinar objNaturezaEven = null;
    private TelaRetirarPenalidadeInterno objRetirarPenal = null;
    private TelaRequisicaoMateriaisInternosSEAC objReqSEAC = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaAprovadoresOcorrenciaVisitasInternosSeguranca objAprovaOcr = null;
    private TelaBloqueioLiberacaoVisitasPortariaSeguranca objBloq = null;
    private TelaRegimentoInternoDisciplinar objRegDisciplina = null;
    private TelaConsultaInternosIsolamento objConIsola = null;
    private TelaConsultaConfere objConsultaConf = null;
    private BaralhoCrimeUnidadePrisional objBC = null;
    //
    private TelaGrupoArmas objGrupoArma = null;
    private TelaGrupoEPIs objGrupoEPIs = null;
    private TelaAcessoriosArmasEPIs objAcessoriosEPI = null;
    private TelaArmas objArmas = null;
    private TelaEquipamentosEPI objEPI = null;
    //
    String pathFoto;
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado. 
    //
    String tipoEmpresa = "Interna";
    String statusInterno = "Ativo";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    //
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    String situacaoTran = "TRANSFERENCIA"; // Todas as Transferencias
    String situacaoNull = ""; // Cadastrado mas não foi feito entrada
    String situacaoSai = "SAIDA TEMPORARIA";
    //
    String nomePavilhao1 = "PAVILHAO I";
    String nomePavilhao2 = "PAVILHAO II";
    // TELAS DE ACESSOS AO MÓDULO FINANCEIRO
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    public static String nomeModuloSEG = "SEGURANCA";
    // MENU CADASTRO    
    public static String telaPavilhao = "Cadastro:Pavilhão:Manutenção";
    public static String telaCelas = "Cadastro:Celas:Manutenção";
    public static String telaPopulacaoInternosAgentes = "Cadastro:População Internos e Agentes";
    public static String telaObjetosProcedimentos = "Cadastro:Objetos do Procedimento:Manutenção";
    public static String telaLocalEvento = "Cadastro:Local Evento:Manutenção";
    public static String telaTipoFaltaDisciplinar = "Cadastro:Tipos de Falta Disciplinar";
    public static String telaRequisicaoMateriaisInternos = "Cadastro:Requisição de Materiais Internos:Manutenção";
    public static String telaRequisicaoMateriaisInternosProdutos = "Cadastro:Requisição de Materiais Internos:Produtos";
    public static String telaAprovadorOcorrenciaVisitasPortaria = "Cadastro:Aprovador de Ocorrência Visitas Portaria:Manutenção";
    // CONTROLE DE PERTENCES DE INTERNOS
    public static String telaObjetosInternos = "Controle de Pertences:Objetos Internos:Manutenção";
    public static String telaLocalPertencesInternos = "Controle de Pertences:Local Pertences Internos:Manutenção";
    public static String telaEntradaPertencesManutencao = "Controle de Pertences:Entrada Pertences:Manutenção";
    public static String telaEntradaPertencesPertences = "Controle de Pertences:Entrada Pertences:Pertences";
    public static String telaSaidaPertencesInternos = "Controle de Pertences:Saida Pertences Internos:Manutenção";
    public static String telaSaidaPertencesPertences = "Controle de Pertences:Saida Pertences Internos:Pertences";
    // MOVIMENTAÇÃO
    public static String telaLocacaoInternosManutencao = "Movimentação:Locação Internos:Manutenção";
    public static String telaLocacaoInternos = "Movimentação:Locação Internos:Internos";
    public static String telaTransferenciaPavilhaoCela = "Movimentação:Transferencia Pavilhao Cela:Manutenção";
    public static String telaControleValores = "Movimentação:Controle Valores:Manutenção";
    public static String telaControleValoresInterno = "Movimentação:Controle Valores:Interno";
    public static String telaRegistroObjetoProcedimento = "Movimentação:Registro Objeto Procedimento:Manutenção";
    public static String telaRegistroObjetoProcedimentoPavilhao = "Movimentação:Registro Objeto Procedimento:Pavilhão Celas";
    public static String telaRegistroObjetoObjetos = "Movimentação:Registro Objeto Procedimento:Objetos Encontrados";
    public static String telaRegistroObjetoAgentes = "Movimentação:Registro Objeto Procedimento:Agentes";
    public static String telaRegistroEvendoDisciplinar = "Movimentação:Registro Evendo Disciplinar:Manutenção";
    public static String telaRegistroEvendoDisciplinarAutor = "Movimentação:Registro Evendo Disciplinar:Autor";
    public static String telaRegistroEvendoDisciplinarVitima = "Movimentação:Registro Evendo Disciplinar:Vitima";
    public static String telaRegistroEvendoDisciplinarVitimaFunc = "Movimentação:Registro Evendo Disciplinar:Vitima Colaborador";
    public static String telaRegistroEvendoDisciplinarTestemunha = "Movimentação:Registro Evendo Disciplinar:Testemunha";
    public static String telaRegistroEvendoDisciplinarTestemunhaFunc = "Movimentação:Registro Evendo Disciplinar:Testemunha Colaborador";
    public static String telaRegistroEvendoDisciplinarObjstos = "Movimentação:Registro Evendo Disciplinar:Objetos";
    public static String telaRegistroEvendoDisciplinarHistorico = "Movimentação:Registro Evendo Disciplinar:Histórico";
    public static String telaAplicarRegistroPenalidadeDisciplinas = "Movimentação:Aplicar Registro Penalidade Disciplinas:Manutenção";
    public static String telaAplicarRegistroPenalidadeDisciplinasAutor = "Movimentação:Aplicar Registro Penalidade Disciplinas:Autor";
    public static String telaAplicarRegistroPenalidadeDisciplinasOCR = "Movimentação:Aplicar Registro Penalidade Disciplinas:Ocorrência";
    public static String telaRetirarPenalidade = "Movimentação:Retirar Penalidade:Manutenção";
    public static String telaRetirarPenalidadeInternos = "Movimentação:Retirar Penalidade:Internos";
    public static String telaLivroOcorrencias = "Movimentação:Livro Ocorrencias:Manutenção";
    public static String telaBloqueioLiberacaoVisitasPortaria = "Movimentação:Bloqueio Liberação Visitas Portaria:Manutenção";
    //
    public static String telaBaralhoCrimeUnidadePrisional = "Movimentação:Organograma do Crime:Manutenção";
    //CONTROLE DE ARMAS E EPI
    public static String telaGrupoArmas = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Grupos Armas:Manutenção";
    public static String telaGrupoEPIs = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Grupos EPI´s:Manutenção";
    public static String telaAcessoriosAREPIs = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Acessórios:Manutenção";
    public static String telaArmas = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Armas:Manutenção";
    public static String telaArmasQRCode = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Armas:QRCode";
    public static String telaArmasCODIGO_barras = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Armas:Código Barras";
    public static String telaArmasAcessorios = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Armas:Acessórios";
    public static String telaArmasHistorico = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Armas:Histórico";
    //
    public static String telaEquipamentosEPI = "Controle de Armas e EPI´s:Cadastros Armas, EPI´s e Acessórios:Equipamentos de Segurança/EPI:Manutenção";
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomePA = "";
    String pNomeCE = "";
    String pNomePIA = "";
    String pNomeOP = "";
    String pNomeLE = "";
    String pNomeTFD = "";
    String pNomeRMI = "";
    String pNomeRMIP = "";
    String pNomeAOVP = "";
    // CONTROLE DE PERTENCES
    String pNomeOI = "";
    String pNomeLPI = "";
    String pNomeEPM = "";
    String pNomeEPMP = "";
    String pNomeSPI = "";
    String pNomeSPP = "";
    // MANUTENÇÃO
    String pNomeLIM = "";
    String pNomeLI = "";
    String pNomeTPC = "";
    String pNomeCV = "";
    String pNomeCVI = "";
    //
    String pNomeROP = "";
    String pNomeROPP = "";
    String pNomeROPO = "";
    String pNomeROPA = "";
    //
    String pNomeRED = "";
    String pNomeREDA = "";
    String pNomeREDV = "";
    String pNomeREDVF = "";
    String pNomeREDT = "";
    String pNomeREDTF = "";
    String pNomeREDO = "";
    String pNomeREDH = "";
    String pNomeARPD = "";
    String pNomeARPDA = "";
    String pNomeARPDO = "";
    String pNomeRP = "";
    String pNomeRPI = "";
    String pNomeLO = "";
    String pNomeBLVP = "";
    //
    String pNomeBC = "";
    //
    String pNomeGR = "";
    String pNomeGEPIs = "";
    String pNomeACESS = "";
    String pNomeARMAs = "";
    String pNomeQRCode = "";
    String pNomeCB = "";
    String pNomeACES = "";
    String pNomeHIST = "";
    //
    String pNomeEPIManu = "";
    //
    public static int codigoUser = 0;
    public static int codUserAcesso = 0;
    public static int codigoUserGroup = 0;
    public static int codAbrir = 0;
    public static int codIncluir = 0;
    public static int codAlterar = 0;
    public static int codExcluir = 0;
    public static int codGravar = 0;
    public static int codConsultar = 0;
    public static int codigoGrupo = 0;
    public static String nomeGrupo = "";
    public static String nomeTela = "";

    /**
     * Creates new form TelaSeguranca
     */
    public TelaModuloSeguranca() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        pesquisarTelasAcessos();
        PESQUISAR_LIBERACAO_implementacao();
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

        jPainelSeguranca = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastro = new javax.swing.JMenu();
        PavilhaoeCelas = new javax.swing.JMenu();
        Pavilhao = new javax.swing.JMenuItem();
        Celas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        PopulacaoInternosAgentes = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        ObjetosProcedimentos = new javax.swing.JMenuItem();
        LocalEvento = new javax.swing.JMenuItem();
        TipoFalta = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        RequisicaoMateriaisInternos = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        AprovadorOcorrenciaVisitasPortaria = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        SairTelaSeguranca = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        RolVisitas = new javax.swing.JMenuItem();
        VisitasInternos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ProntuarioInternos = new javax.swing.JMenuItem();
        LocalInternos = new javax.swing.JMenuItem();
        jConsultaInternosIsolamento = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        AgendaEscolta = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        ControleSaidaLaborativa = new javax.swing.JMenuItem();
        ListaPassagem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        HistoricosInternos = new javax.swing.JMenu();
        HistoricoCrc = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jConfere = new javax.swing.JMenuItem();
        jControleArmasEPI = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jGruposArmas = new javax.swing.JMenuItem();
        jGruposEPIS = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        jAcessorios = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        jCadastroArmas = new javax.swing.JMenuItem();
        jEquipamentosSegurancaEPI = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jMovimentacaoArmas = new javax.swing.JMenu();
        jInventario = new javax.swing.JMenuItem();
        jEntradasArmas = new javax.swing.JMenuItem();
        jSaidasArmas = new javax.swing.JMenuItem();
        jDevolucaoArmas = new javax.swing.JMenuItem();
        ControlePertences = new javax.swing.JMenu();
        ObjetosInternos = new javax.swing.JMenuItem();
        LocalPertencesInternos = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        EntradaPertences = new javax.swing.JMenuItem();
        SaidaPertencesInternos = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        LocacaoInternos = new javax.swing.JMenuItem();
        TransferenciaPavilhaoCela = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        ControleValores = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        RegistroObjetoProcedimento = new javax.swing.JMenuItem();
        ControleDisciplinarInternos = new javax.swing.JMenu();
        RegistroEvendoDisciplinar = new javax.swing.JMenuItem();
        AplicarRegistroPenalidadeDisciplinas = new javax.swing.JMenuItem();
        RetirarPenalidade = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        BloqueioLiberacaoVisitasPortaria = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jNIM = new javax.swing.JMenuItem();
        RelatoriosSeguranca = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        MenuProntuariosTodos = new javax.swing.JMenuItem();
        RelatorioInternosRegimePenal = new javax.swing.JMenuItem();
        RelatorioRegimeSexo = new javax.swing.JMenuItem();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        RelatorioRegimePenalPavilhao = new javax.swing.JMenuItem();
        RelatorioInternosBeneficios = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        jRelatorioInternosComSemTornozeleira = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        RelPavilhao = new javax.swing.JMenuItem();
        RelCelas = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        RelatorioGeralPavilhaoCelas = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        jRelatorioConfere2 = new javax.swing.JMenuItem();
        MapaConfere = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        ConferePorOrdemAlfabeticaP1 = new javax.swing.JMenuItem();
        ConfereOrdemAlfabeticaP2 = new javax.swing.JMenuItem();
        ConfereRealizadoPorPavilhao = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        RelatorioPrevisaoSaida = new javax.swing.JMenu();
        RelatorioPrevisaoSaidaInternos = new javax.swing.JMenuItem();
        RelatorioPrevSaidaDiversos = new javax.swing.JMenuItem();
        RelatorioListasPassagens = new javax.swing.JMenu();
        ListaPassagemInterna = new javax.swing.JMenuItem();
        ListaPassagemExterna = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        RelatorioFrequenciaColabordor = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        RelatorioDepositoInternos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jRelatorioVisitasAdvogadosInternosGeral = new javax.swing.JMenuItem();
        jRelatorioVisitasAdvogadosInternosPorNome = new javax.swing.JMenuItem();
        Utilitarios = new javax.swing.JMenu();
        CalculadoraPena = new javax.swing.JMenuItem();
        CalculadoraWindows = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..::: Segurança {SE} :::...");

        jPainelSeguranca.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelSeguranca.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelSegurancaLayout = new javax.swing.GroupLayout(jPainelSeguranca);
        jPainelSeguranca.setLayout(jPainelSegurancaLayout);
        jPainelSegurancaLayout.setHorizontalGroup(
            jPainelSegurancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelSegurancaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE))
        );
        jPainelSegurancaLayout.setVerticalGroup(
            jPainelSegurancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        Cadastro.setText("Cadastro");

        PavilhaoeCelas.setText("Pavilhão/Celas");

        Pavilhao.setText("Pavilhão");
        Pavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PavilhaoActionPerformed(evt);
            }
        });
        PavilhaoeCelas.add(Pavilhao);

        Celas.setText("Celas");
        Celas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelasActionPerformed(evt);
            }
        });
        PavilhaoeCelas.add(Celas);

        Cadastro.add(PavilhaoeCelas);
        Cadastro.add(jSeparator1);

        PopulacaoInternosAgentes.setText("População de Internos e Agentes");
        PopulacaoInternosAgentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopulacaoInternosAgentesActionPerformed(evt);
            }
        });
        Cadastro.add(PopulacaoInternosAgentes);
        Cadastro.add(jSeparator10);

        ObjetosProcedimentos.setText("Objetos do Procedimento de Revista");
        ObjetosProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjetosProcedimentosActionPerformed(evt);
            }
        });
        Cadastro.add(ObjetosProcedimentos);

        LocalEvento.setText("Local do Evento da Falta - RDD");
        LocalEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalEventoActionPerformed(evt);
            }
        });
        Cadastro.add(LocalEvento);

        TipoFalta.setText("Tipos de Faltas Indisciplinar - RDD");
        TipoFalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoFaltaActionPerformed(evt);
            }
        });
        Cadastro.add(TipoFalta);
        Cadastro.add(jSeparator17);

        RequisicaoMateriaisInternos.setText("Requisição de Materiais para Internos");
        RequisicaoMateriaisInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisInternosActionPerformed(evt);
            }
        });
        Cadastro.add(RequisicaoMateriaisInternos);
        Cadastro.add(jSeparator9);

        AprovadorOcorrenciaVisitasPortaria.setForeground(new java.awt.Color(0, 0, 255));
        AprovadorOcorrenciaVisitasPortaria.setText("Aprovador de Ocorrências Portaria (Visitas Internos)");
        AprovadorOcorrenciaVisitasPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprovadorOcorrenciaVisitasPortariaActionPerformed(evt);
            }
        });
        Cadastro.add(AprovadorOcorrenciaVisitasPortaria);
        Cadastro.add(jSeparator4);

        AgendaCompromisso.setText("Agenda de Compromissos Pessoal");
        AgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoActionPerformed(evt);
            }
        });
        Cadastro.add(AgendaCompromisso);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastro.add(AgendaRecados);
        Cadastro.add(jSeparator12);

        SairTelaSeguranca.setText("Sair");
        SairTelaSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairTelaSegurancaActionPerformed(evt);
            }
        });
        Cadastro.add(SairTelaSeguranca);

        jMenuBar1.add(Cadastro);

        Consultas.setText("Consultas");

        RolVisitas.setText("Rol de Visitas");
        RolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolVisitasActionPerformed(evt);
            }
        });
        Consultas.add(RolVisitas);

        VisitasInternos.setText("Visitas de Internos");
        VisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitasInternosActionPerformed(evt);
            }
        });
        Consultas.add(VisitasInternos);
        Consultas.add(jSeparator3);

        ProntuarioInternos.setText("Prontuário de Internos");
        ProntuarioInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProntuarioInternosActionPerformed(evt);
            }
        });
        Consultas.add(ProntuarioInternos);

        LocalInternos.setText("Localização de Internos");
        LocalInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalInternosActionPerformed(evt);
            }
        });
        Consultas.add(LocalInternos);

        jConsultaInternosIsolamento.setText("Internos no Isolamento");
        jConsultaInternosIsolamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaInternosIsolamentoActionPerformed(evt);
            }
        });
        Consultas.add(jConsultaInternosIsolamento);
        Consultas.add(jSeparator5);

        AgendaEscolta.setText("Agendamento de Escolta e Médico");
        AgendaEscolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaEscoltaActionPerformed(evt);
            }
        });
        Consultas.add(AgendaEscolta);
        Consultas.add(jSeparator6);

        ControleSaidaLaborativa.setText("Atividades Laborativas");
        ControleSaidaLaborativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleSaidaLaborativaActionPerformed(evt);
            }
        });
        Consultas.add(ControleSaidaLaborativa);

        ListaPassagem.setText("Lista de Passagem Laborativa");
        ListaPassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemActionPerformed(evt);
            }
        });
        Consultas.add(ListaPassagem);
        Consultas.add(jSeparator2);

        HistoricosInternos.setText("Históricos de Movimentação de Internos");

        HistoricoCrc.setText("Histórico de Entrada/Saida na Unidade Penal");
        HistoricoCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoCrcActionPerformed(evt);
            }
        });
        HistoricosInternos.add(HistoricoCrc);

        jMenuItem3.setText("Histórico Movimentação de Internos no Corpo Técnico");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        HistoricosInternos.add(jMenuItem3);

        Consultas.add(HistoricosInternos);
        Consultas.add(jSeparator21);

        jConfere.setForeground(new java.awt.Color(204, 0, 0));
        jConfere.setText("Confere");
        jConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfereActionPerformed(evt);
            }
        });
        Consultas.add(jConfere);

        jMenuBar1.add(Consultas);

        jControleArmasEPI.setText("Controle de Armas e EPI´s");

        jMenu2.setText("Cadastros Armas, EPI´s e Acessórios");

        jMenu3.setText("Grupos");

        jGruposArmas.setText("Grupos Armas");
        jGruposArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGruposArmasActionPerformed(evt);
            }
        });
        jMenu3.add(jGruposArmas);

        jGruposEPIS.setText("Grupos EPI´s");
        jGruposEPIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGruposEPISActionPerformed(evt);
            }
        });
        jMenu3.add(jGruposEPIS);

        jMenu2.add(jMenu3);
        jMenu2.add(jSeparator26);

        jAcessorios.setText("Acessórios para Armas");
        jAcessorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAcessoriosActionPerformed(evt);
            }
        });
        jMenu2.add(jAcessorios);
        jMenu2.add(jSeparator28);

        jCadastroArmas.setText("Armas");
        jCadastroArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastroArmasActionPerformed(evt);
            }
        });
        jMenu2.add(jCadastroArmas);

        jEquipamentosSegurancaEPI.setText("Equipamentos de Segurança/EPI");
        jEquipamentosSegurancaEPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEquipamentosSegurancaEPIActionPerformed(evt);
            }
        });
        jMenu2.add(jEquipamentosSegurancaEPI);

        jControleArmasEPI.add(jMenu2);
        jControleArmasEPI.add(jSeparator27);

        jMovimentacaoArmas.setText("Movimentação");

        jInventario.setText("Inventário");
        jMovimentacaoArmas.add(jInventario);

        jEntradasArmas.setText("Entradas");
        jMovimentacaoArmas.add(jEntradasArmas);

        jSaidasArmas.setText("Saídas");
        jMovimentacaoArmas.add(jSaidasArmas);

        jDevolucaoArmas.setText("Devolução");
        jMovimentacaoArmas.add(jDevolucaoArmas);

        jControleArmasEPI.add(jMovimentacaoArmas);

        jMenuBar1.add(jControleArmasEPI);

        ControlePertences.setText("Controle Pertences");

        ObjetosInternos.setText("Pertences dos Internos");
        ObjetosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjetosInternosActionPerformed(evt);
            }
        });
        ControlePertences.add(ObjetosInternos);

        LocalPertencesInternos.setText("Local Estoque Pertences de Internos");
        LocalPertencesInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalPertencesInternosActionPerformed(evt);
            }
        });
        ControlePertences.add(LocalPertencesInternos);
        ControlePertences.add(jSeparator20);

        EntradaPertences.setText("Entrada de Pertences de Internos");
        EntradaPertences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaPertencesActionPerformed(evt);
            }
        });
        ControlePertences.add(EntradaPertences);

        SaidaPertencesInternos.setText("Saida de Pertences de Internos");
        SaidaPertencesInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaidaPertencesInternosActionPerformed(evt);
            }
        });
        ControlePertences.add(SaidaPertencesInternos);

        jMenuBar1.add(ControlePertences);

        Movimentacao.setText("Movimentação");
        Movimentacao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        LocacaoInternos.setText("Locação de Internos");
        LocacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocacaoInternosActionPerformed(evt);
            }
        });
        Movimentacao.add(LocacaoInternos);

        TransferenciaPavilhaoCela.setText("Transferências Pavilhão/Celas");
        TransferenciaPavilhaoCela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferenciaPavilhaoCelaActionPerformed(evt);
            }
        });
        Movimentacao.add(TransferenciaPavilhaoCela);
        Movimentacao.add(jSeparator13);

        ControleValores.setText("Controle de Valores de Internos");
        ControleValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleValoresActionPerformed(evt);
            }
        });
        Movimentacao.add(ControleValores);
        Movimentacao.add(jSeparator18);

        RegistroObjetoProcedimento.setForeground(new java.awt.Color(204, 0, 0));
        RegistroObjetoProcedimento.setText("Registro de Procedimento de Revista de Pavilhão/Celas ");
        RegistroObjetoProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroObjetoProcedimentoActionPerformed(evt);
            }
        });
        Movimentacao.add(RegistroObjetoProcedimento);

        ControleDisciplinarInternos.setForeground(new java.awt.Color(0, 102, 0));
        ControleDisciplinarInternos.setText("Penalidade Disciplinar - (Lei nº 7.210/1984, Art. 41, Art. 53 da LEP)");

        RegistroEvendoDisciplinar.setForeground(new java.awt.Color(204, 0, 0));
        RegistroEvendoDisciplinar.setText("Registro do (Regime Disciplinar Diferenciado - RDD  - Art. 52 e 53)");
        RegistroEvendoDisciplinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroEvendoDisciplinarActionPerformed(evt);
            }
        });
        ControleDisciplinarInternos.add(RegistroEvendoDisciplinar);

        AplicarRegistroPenalidadeDisciplinas.setForeground(new java.awt.Color(0, 0, 204));
        AplicarRegistroPenalidadeDisciplinas.setText("Registro de Penalidade Disciplinar - Art. 53 e Art. 41 Parágrafo Único");
        AplicarRegistroPenalidadeDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicarRegistroPenalidadeDisciplinasActionPerformed(evt);
            }
        });
        ControleDisciplinarInternos.add(AplicarRegistroPenalidadeDisciplinas);

        RetirarPenalidade.setForeground(new java.awt.Color(0, 102, 0));
        RetirarPenalidade.setText("Retirar Penalidade Disciplina a Internos");
        RetirarPenalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarPenalidadeActionPerformed(evt);
            }
        });
        ControleDisciplinarInternos.add(RetirarPenalidade);

        Movimentacao.add(ControleDisciplinarInternos);
        Movimentacao.add(jSeparator14);

        LivroOcorrencias.setText("Livro de Ocorrências");
        LivroOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciasActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencias);
        Movimentacao.add(jSeparator19);

        BloqueioLiberacaoVisitasPortaria.setText("Bloqueio/Liberação de Visitas a Internos");
        BloqueioLiberacaoVisitasPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloqueioLiberacaoVisitasPortariaActionPerformed(evt);
            }
        });
        Movimentacao.add(BloqueioLiberacaoVisitasPortaria);
        Movimentacao.add(jSeparator24);

        jNIM.setText("NIM - Núcleo de Informações e Monitoramento");
        jNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNIMActionPerformed(evt);
            }
        });
        Movimentacao.add(jNIM);

        jMenuBar1.add(Movimentacao);

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

        RelatorioInternosRegimePenal.setText("Relatório de Internos por Regime Penal");
        RelatorioInternosRegimePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosRegimePenalActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioInternosRegimePenal);

        RelatorioRegimeSexo.setText("Relatório de Internos por Regime Penal e Sexo");
        RelatorioRegimeSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRegimeSexoActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioRegimeSexo);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioEntradaInternosUnidade);

        RelatorioRegimePenalPavilhao.setText("Relatório de Internos por Regime Penal e Pavilhão");
        RelatorioRegimePenalPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRegimePenalPavilhaoActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioRegimePenalPavilhao);

        RelatorioInternosBeneficios.setForeground(new java.awt.Color(255, 0, 0));
        RelatorioInternosBeneficios.setText("Relatório de Saida de Internos na Portaria por Beneficio");
        RelatorioInternosBeneficios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosBeneficiosActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioInternosBeneficios);
        RelatoriosSeguranca.add(jSeparator25);

        jRelatorioInternosComSemTornozeleira.setForeground(new java.awt.Color(0, 0, 204));
        jRelatorioInternosComSemTornozeleira.setText("Relatório de Internos com e Sem Tornozeleiras");
        jRelatorioInternosComSemTornozeleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioInternosComSemTornozeleiraActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(jRelatorioInternosComSemTornozeleira);
        RelatoriosSeguranca.add(jSeparator7);

        RelPavilhao.setText("Pavilhão");
        RelPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelPavilhaoActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelPavilhao);

        RelCelas.setText("Celas");
        RelCelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelCelasActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelCelas);
        RelatoriosSeguranca.add(jSeparator8);

        jMenu7.setText("Relatórios de Confere");

        RelatorioGeralPavilhaoCelas.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralPavilhaoCelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralPavilhaoCelasActionPerformed(evt);
            }
        });
        jMenu7.add(RelatorioGeralPavilhaoCelas);

        ListagemConfere.setText("Listagem de Confere I");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        jMenu7.add(ListagemConfere);

        jRelatorioConfere2.setText("Listagem de Confere II");
        jRelatorioConfere2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioConfere2ActionPerformed(evt);
            }
        });
        jMenu7.add(jRelatorioConfere2);

        MapaConfere.setText("Mapa de Confere");
        MapaConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapaConfereActionPerformed(evt);
            }
        });
        jMenu7.add(MapaConfere);
        jMenu7.add(jSeparator22);

        ConferePorOrdemAlfabeticaP1.setForeground(new java.awt.Color(0, 0, 255));
        ConferePorOrdemAlfabeticaP1.setText("Confere por Ordem Alfabetica - Pavilhão I -Galerias A,B e C - (UN)");
        ConferePorOrdemAlfabeticaP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConferePorOrdemAlfabeticaP1ActionPerformed(evt);
            }
        });
        jMenu7.add(ConferePorOrdemAlfabeticaP1);

        ConfereOrdemAlfabeticaP2.setForeground(new java.awt.Color(0, 153, 0));
        ConfereOrdemAlfabeticaP2.setText("Confere por Ordem Alfabetica - Pavilhão II - Galeria A e B - (UN)");
        ConfereOrdemAlfabeticaP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfereOrdemAlfabeticaP2ActionPerformed(evt);
            }
        });
        jMenu7.add(ConfereOrdemAlfabeticaP2);

        ConfereRealizadoPorPavilhao.setForeground(new java.awt.Color(255, 0, 0));
        ConfereRealizadoPorPavilhao.setText("Confere Realizado por Pavilhão");
        ConfereRealizadoPorPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfereRealizadoPorPavilhaoActionPerformed(evt);
            }
        });
        jMenu7.add(ConfereRealizadoPorPavilhao);

        RelatoriosSeguranca.add(jMenu7);
        RelatoriosSeguranca.add(jSeparator11);

        RelatorioPrevisaoSaida.setText("Relatórios de Previsão de Saídas");

        RelatorioPrevisaoSaidaInternos.setText("Relatório  Geral de  Previsão de Saída de Internos");
        RelatorioPrevisaoSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaInternosActionPerformed(evt);
            }
        });
        RelatorioPrevisaoSaida.add(RelatorioPrevisaoSaidaInternos);

        RelatorioPrevSaidaDiversos.setText("Relatórios de Previsão de Saída de Internos Realizados/Não Realizados");
        RelatorioPrevSaidaDiversos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevSaidaDiversosActionPerformed(evt);
            }
        });
        RelatorioPrevisaoSaida.add(RelatorioPrevSaidaDiversos);

        RelatoriosSeguranca.add(RelatorioPrevisaoSaida);

        RelatorioListasPassagens.setText("Relatório de Listas de Passagem");

        ListaPassagemInterna.setText("Relatório de Lista de Passagem Interna");
        ListaPassagemInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemInternaActionPerformed(evt);
            }
        });
        RelatorioListasPassagens.add(ListaPassagemInterna);

        ListaPassagemExterna.setText("Relatório de Lista de Passagem Externa");
        ListaPassagemExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemExternaActionPerformed(evt);
            }
        });
        RelatorioListasPassagens.add(ListaPassagemExterna);

        RelatoriosSeguranca.add(RelatorioListasPassagens);
        RelatoriosSeguranca.add(jSeparator16);

        RelatorioFrequenciaColabordor.setText("Relatório de Frequência de Colaboradores");
        RelatorioFrequenciaColabordor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioFrequenciaColabordorActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioFrequenciaColabordor);
        RelatoriosSeguranca.add(jSeparator15);

        RelatorioDepositoInternos.setText("Relatório de Depósito de Valores de Interno");
        RelatorioDepositoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDepositoInternosActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioDepositoInternos);

        jMenuItem2.setText("Relatório de Colaboradores no Procedimento de Revista");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(jMenuItem2);
        RelatoriosSeguranca.add(jSeparator23);

        jMenu1.setText("Relatórios de Visitas de Advogados aos Internos - PORTARIAS");

        jRelatorioVisitasAdvogadosInternosGeral.setText("Relatório de Visitas de Advogados - Geral");
        jRelatorioVisitasAdvogadosInternosGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioVisitasAdvogadosInternosGeralActionPerformed(evt);
            }
        });
        jMenu1.add(jRelatorioVisitasAdvogadosInternosGeral);

        jRelatorioVisitasAdvogadosInternosPorNome.setText("Relatório de Visitas Advogados aos Internos por Nome");
        jRelatorioVisitasAdvogadosInternosPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioVisitasAdvogadosInternosPorNomeActionPerformed(evt);
            }
        });
        jMenu1.add(jRelatorioVisitasAdvogadosInternosPorNome);

        RelatoriosSeguranca.add(jMenu1);

        jMenuBar1.add(RelatoriosSeguranca);

        Utilitarios.setText("Utilitários");

        CalculadoraPena.setText("Calculadora de Pena");
        CalculadoraPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculadoraPenaActionPerformed(evt);
            }
        });
        Utilitarios.add(CalculadoraPena);

        CalculadoraWindows.setText("Calculadora do Windows");
        CalculadoraWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculadoraWindowsActionPerformed(evt);
            }
        });
        Utilitarios.add(CalculadoraWindows);

        jMenuBar1.add(Utilitarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPainelSeguranca)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelSeguranca)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairTelaSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairTelaSegurancaActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_SairTelaSegurancaActionPerformed

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
            String path = "reports/CRC/ProntuariosInternosCRC.jasper";
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
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setTitle("Relatório de Internos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_MenuProntuariosTodosActionPerformed

    private void RelCelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelCelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelCelasActionPerformed

    private void PavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PavilhaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPavilhao);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaPavilhao) && codAbrir == 1) {
            if (objPav == null || objPav.isClosed()) {
                objPav = new TelaPavilhao();
                jPainelSeguranca.add(objPav);
                objPav.setVisible(true);
            } else {
                if (objPav.isVisible()) {
                    if (objPav.isIcon()) { // Se esta minimizado
                        try {
                            objPav.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPav.toFront(); // traz para frente
                        objPav.pack();//volta frame 
                    }
                } else {
                    objPav = new TelaPavilhao();
                    TelaModuloSeguranca.jPainelSeguranca.add(objPav);//adicona frame ao JDesktopPane  
                    objPav.setVisible(true);
                }
            }
            try {
                objPav.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_PavilhaoActionPerformed

    private void CelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCelas);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaCelas) && codAbrir == 1) {
            if (objCelas == null || objCelas.isClosed()) {
                objCelas = new TelaCelas();
                jPainelSeguranca.add(objCelas);
                objCelas.setVisible(true);
            } else {
                if (objCelas.isVisible()) {
                    if (objCelas.isIcon()) { // Se esta minimizado
                        try {
                            objCelas.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCelas.toFront(); // traz para frente
                        objCelas.pack();//volta frame 
                    }
                } else {
                    objCelas = new TelaCelas();
                    TelaModuloSeguranca.jPainelSeguranca.add(objCelas);//adicona frame ao JDesktopPane  
                    objCelas.setVisible(true);
                }
            }
            try {
                objCelas.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CelasActionPerformed

    private void LocacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocacaoInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocacaoInternosManutencao);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaLocacaoInternosManutencao) && codAbrir == 1) {
            if (objLoca == null || objLoca.isClosed()) {
                objLoca = new TelaLocacaoInterno();
                jPainelSeguranca.add(objLoca);
                objLoca.setVisible(true);
            } else {
                if (objLoca.isVisible()) {
                    if (objLoca.isIcon()) { // Se esta minimizado
                        try {
                            objLoca.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objLoca.toFront(); // traz para frente
                        objLoca.pack();//volta frame 
                    }
                } else {
                    objLoca = new TelaLocacaoInterno();
                    TelaModuloSeguranca.jPainelSeguranca.add(objLoca);//adicona frame ao JDesktopPane  
                    objLoca.setVisible(true);
                }
            }
            try {
                objLoca.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LocacaoInternosActionPerformed

    private void TransferenciaPavilhaoCelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferenciaPavilhaoCelaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTransferenciaPavilhaoCela);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaTransferenciaPavilhaoCela) && codAbrir == 1) {
            if (objTransCelas == null || objTransCelas.isClosed()) {
                objTransCelas = new TelaTransCelas();
                jPainelSeguranca.add(objTransCelas);
                objTransCelas.setVisible(true);
            } else {
                if (objTransCelas.isVisible()) {
                    if (objTransCelas.isIcon()) { // Se esta minimizado
                        try {
                            objTransCelas.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTransCelas.toFront(); // traz para frente
                        objTransCelas.pack();//volta frame 
                    }
                } else {
                    objTransCelas = new TelaTransCelas();
                    TelaModuloSeguranca.jPainelSeguranca.add(objTransCelas);//adicona frame ao JDesktopPane  
                    objTransCelas.setVisible(true);
                }
            }
            try {
                objTransCelas.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_TransferenciaPavilhaoCelaActionPerformed

    private void PopulacaoInternosAgentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopulacaoInternosAgentesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPopulacaoInternosAgentes);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaPopulacaoInternosAgentes) && codAbrir == 1) {
            if (objPop == null || objPop.isClosed()) {
                objPop = new TelaPopulacao();
                jPainelSeguranca.add(objPop);
                objPop.setVisible(true);
            } else {
                if (objPop.isVisible()) {
                    if (objPop.isIcon()) { // Se esta minimizado
                        try {
                            objPop.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPop.toFront(); // traz para frente
                        objPop.pack();//volta frame 
                    }
                } else {
                    objPop = new TelaPopulacao();
                    TelaModuloSeguranca.jPainelSeguranca.add(objPop);//adicona frame ao JDesktopPane  
                    objPop.setVisible(true);
                }
            }
            try {
                objPop.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_PopulacaoInternosAgentesActionPerformed

    private void RolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolVisitasActionPerformed
        // TODO add your handling code here:
        if (objRolVisitas == null || objRolVisitas.isClosed()) {
            objRolVisitas = new TelaRolVisitasPortaria();
            jPainelSeguranca.add(objRolVisitas);
            objRolVisitas.setVisible(true);
        } else {
            if (objRolVisitas.isVisible()) {
                if (objRolVisitas.isIcon()) { // Se esta minimizado
                    try {
                        objRolVisitas.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRolVisitas.toFront(); // traz para frente
                    objRolVisitas.pack();//volta frame 
                }
            } else {
                objRolVisitas = new TelaRolVisitasPortaria();
                TelaModuloSeguranca.jPainelSeguranca.add(objRolVisitas);//adicona frame ao JDesktopPane  
                objRolVisitas.setVisible(true);
            }
        }
        try {
            objRolVisitas.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RolVisitasActionPerformed

    private void VisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitasInternosActionPerformed
        // TODO add your handling code here:
        if (objViInter == null || objViInter.isClosed()) {
            objViInter = new TelaVisitaInternosSeguranca();
            jPainelSeguranca.add(objViInter);
            objViInter.setVisible(true);
        } else {
            if (objViInter.isVisible()) {
                if (objViInter.isIcon()) { // Se esta minimizado
                    try {
                        objViInter.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objViInter.toFront(); // traz para frente
                    objViInter.pack();//volta frame 
                }
            } else {
                objViInter = new TelaVisitaInternosSeguranca();
                TelaModuloSeguranca.jPainelSeguranca.add(objViInter);//adicona frame ao JDesktopPane  
                objViInter.setVisible(true);
            }
        }
        try {
            objViInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_VisitasInternosActionPerformed

    private void AgendaEscoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaEscoltaActionPerformed
        // TODO add your handling code here:
        if (objConAgenda == null || objConAgenda.isClosed()) {
            objConAgenda = new TelaConsultaAgendaEscoltaPortaria();
            jPainelSeguranca.add(objConAgenda);
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
                TelaModuloSeguranca.jPainelSeguranca.add(objConAgenda);//adicona frame ao JDesktopPane  
                objConAgenda.setVisible(true);
            }
        }
        try {
            objConAgenda.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaEscoltaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (objHistMovSeg == null || objHistMovSeg.isClosed()) {
            objHistMovSeg = new TelaMovHistoricoTecSeguranca();
            jPainelSeguranca.add(objHistMovSeg);
            objHistMovSeg.setVisible(true);
        } else {
            if (objHistMovSeg.isVisible()) {
                if (objHistMovSeg.isIcon()) { // Se esta minimizado
                    try {
                        objHistMovSeg.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistMovSeg.toFront(); // traz para frente
                    objHistMovSeg.pack();//volta frame 
                }
            } else {
                objHistMovSeg = new TelaMovHistoricoTecSeguranca();
                TelaModuloSeguranca.jPainelSeguranca.add(objHistMovSeg);//adicona frame ao JDesktopPane  
                objHistMovSeg.setVisible(true);
            }
        }
        try {
            objHistMovSeg.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void ControleSaidaLaborativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleSaidaLaborativaActionPerformed
        // TODO add your handling code here:
        if (objConSaidaInt == null || objConSaidaInt.isClosed()) {
            objConSaidaInt = new TelaConsultaEntSaiIntPortSeguranca();
            jPainelSeguranca.add(objConSaidaInt);
            objConSaidaInt.setVisible(true);
        } else {
            if (objConSaidaInt.isVisible()) {
                if (objConSaidaInt.isIcon()) { // Se esta minimizado
                    try {
                        objConSaidaInt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConSaidaInt.toFront(); // traz para frente
                    objConSaidaInt.pack();//volta frame 
                }
            } else {
                objConSaidaInt = new TelaConsultaEntSaiIntPortSeguranca();
                TelaModuloSeguranca.jPainelSeguranca.add(objConSaidaInt);//adicona frame ao JDesktopPane  
                objConSaidaInt.setVisible(true);
            }
        }
        try {
            objConSaidaInt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ControleSaidaLaborativaActionPerformed

    private void LocalInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalInter == null || objLocalInter.isClosed()) {
            objLocalInter = new TelaConsultaLocalInternoSeguranca();
            jPainelSeguranca.add(objLocalInter);
            objLocalInter.setVisible(true);
        } else {
            if (objLocalInter.isVisible()) {
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
                TelaModuloSeguranca.jPainelSeguranca.add(objLocalInter);//adicona frame ao JDesktopPane  
                objLocalInter.setVisible(true);
            }
        }
        try {
            objLocalInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalInternosActionPerformed

    private void ProntuarioInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProntuarioInternosActionPerformed
        // TODO add your handling code here:
        if (objConsultaInternoSeg == null || objConsultaInternoSeg.isClosed()) {
            objConsultaInternoSeg = new TelaConsultaProntuarioInternoCrc();
            jPainelSeguranca.add(objConsultaInternoSeg);
            objConsultaInternoSeg.setVisible(true);
        } else {
            if (objConsultaInternoSeg.isVisible()) {
                if (objConsultaInternoSeg.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaInternoSeg.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaInternoSeg.toFront(); // traz para frente
                    objConsultaInternoSeg.pack();//volta frame 
                }
            } else {
                objConsultaInternoSeg = new TelaConsultaProntuarioInternoCrc();
                TelaModuloSeguranca.jPainelSeguranca.add(objConsultaInternoSeg);//adicona frame ao JDesktopPane  
                objConsultaInternoSeg.setVisible(true);
            }
        }
        try {
            objConsultaInternoSeg.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProntuarioInternosActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecaSegu == null || objRecaSegu.isClosed()) {
            objRecaSegu = new TelaRecadosSeguranca();
            jPainelSeguranca.add(objRecaSegu);
            objRecaSegu.setVisible(true);
        } else {
            if (objRecaSegu.isVisible()) {
                if (objRecaSegu.isIcon()) { // Se esta minimizado
                    try {
                        objRecaSegu.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecaSegu.toFront(); // traz para frente
                    objRecaSegu.pack();//volta frame 
                }
            } else {
                objRecaSegu = new TelaRecadosSeguranca();
                TelaModuloSeguranca.jPainelSeguranca.add(objRecaSegu);//adicona frame ao JDesktopPane  
                objRecaSegu.setVisible(true);
            }
        }
        try {
            objRecaSegu.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void LivroOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLivroOcorrencias);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaLivroOcorrencias) && codAbrir == 1) {
            if (objOcoSegu == null || objOcoSegu.isClosed()) {
                objOcoSegu = new TelaOcorrenciaSeguranca();
                jPainelSeguranca.add(objOcoSegu);
                objOcoSegu.setVisible(true);
            } else {
                if (objOcoSegu.isVisible()) {
                    if (objOcoSegu.isIcon()) { // Se esta minimizado
                        try {
                            objOcoSegu.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcoSegu.toFront(); // traz para frente
                        objOcoSegu.pack();//volta frame 
                    }
                } else {
                    objOcoSegu = new TelaOcorrenciaSeguranca();
                    TelaModuloSeguranca.jPainelSeguranca.add(objOcoSegu);//adicona frame ao JDesktopPane  
                    objOcoSegu.setVisible(true);
                }
            }
            try {
                objOcoSegu.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciasActionPerformed

    private void ListaPassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemActionPerformed
        // TODO add your handling code here:
        if (oblConListaPass == null || oblConListaPass.isClosed()) {
            oblConListaPass = new TelaConsultaListaPassagemInternosSeg();
            jPainelSeguranca.add(oblConListaPass);
            oblConListaPass.setVisible(true);
        } else {
            if (oblConListaPass.isVisible()) {
                if (oblConListaPass.isIcon()) { // Se esta minimizado
                    try {
                        oblConListaPass.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    oblConListaPass.toFront(); // traz para frente
                    oblConListaPass.pack();//volta frame 
                }
            } else {
                oblConListaPass = new TelaConsultaListaPassagemInternosSeg();
                TelaModuloSeguranca.jPainelSeguranca.add(oblConListaPass);//adicona frame ao JDesktopPane  
                oblConListaPass.setVisible(true);
            }
        }
        try {
            oblConListaPass.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ListaPassagemActionPerformed

    private void RelatorioGeralPavilhaoCelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralPavilhaoCelasActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/GerenciaOperacional/ListagemGeralConfere.jasper";
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
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório. \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioGeralPavilhaoCelasActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void RelatorioPrevisaoSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaSeguranca objRelPrevSaiIn = new TelaRelatorioPrevisaoSaidaSeguranca();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelPrevSaiIn);
        objRelPrevSaiIn.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaInternosActionPerformed

    private void RelatorioPrevSaidaDiversosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevSaidaDiversosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevSaidaIntSegurancaDiversos objRelaPrevSaidIntDiv = new TelaRelatorioPrevSaidaIntSegurancaDiversos();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelaPrevSaidIntDiv);
        objRelaPrevSaidIntDiv.show();
    }//GEN-LAST:event_RelatorioPrevSaidaDiversosActionPerformed

    private void ListaPassagemInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemInternaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/TerapiaOcupacional/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE TipoEmpresa='" + tipoEmpresa + "'AND StatusInterno='" + statusInterno + "'ORDER BY RazaoSocial,NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("tipoEmpresa", tipoEmpresa);
            parametros.put("statusEmpresa", statusInterno);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Lista de Passagem de Internos na Unidade Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListaPassagemInternaActionPerformed

    private void ListaPassagemExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemExternaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaPassagemExternaActionPerformed

    private void HistoricoCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoCrcActionPerformed
        // TODO add your handling code here:
        if (objHistCrc == null || objHistCrc.isClosed()) {
            objHistCrc = new TelaMovimentacaoCrcSeguranca();
            jPainelSeguranca.add(objHistCrc);
            objHistCrc.setVisible(true);
        } else {
            if (objHistCrc.isVisible()) {
                if (objHistCrc.isIcon()) { // Se esta minimizado
                    try {
                        objHistCrc.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistCrc.toFront(); // traz para frente
                    objHistCrc.pack();//volta frame 
                }
            } else {
                objHistCrc = new TelaMovimentacaoCrcSeguranca();
                TelaModuloSeguranca.jPainelSeguranca.add(objHistCrc);//adicona frame ao JDesktopPane  
                objHistCrc.setVisible(true);
            }
        }
        try {
            objHistCrc.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoCrcActionPerformed

    private void MapaConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapaConfereActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereSeguranca mapop = new TelaRelMapaConfereSeguranca();
        TelaModuloSeguranca.jPainelSeguranca.add(mapop);
        mapop.show();
    }//GEN-LAST:event_MapaConfereActionPerformed

    private void RelatorioFrequenciaColabordorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioFrequenciaColabordorActionPerformed
        // TODO add your handling code here:
        TelaRelAtividadeLaborExternaSeguranca relAtiFreFunc = new TelaRelAtividadeLaborExternaSeguranca();
        TelaModuloSeguranca.jPainelSeguranca.add(relAtiFreFunc);
        relAtiFreFunc.show();
    }//GEN-LAST:event_RelatorioFrequenciaColabordorActionPerformed

    private void ControleValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleValoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaControleValores);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaControleValores) && codAbrir == 1) {
            if (objControlValores == null || objControlValores.isClosed()) {
                objControlValores = new TelaControleDepositoSeguranca();
                jPainelSeguranca.add(objControlValores);
                objControlValores.setVisible(true);
            } else {
                if (objControlValores.isVisible()) {
                    if (objControlValores.isIcon()) { // Se esta minimizado
                        try {
                            objControlValores.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objControlValores.toFront(); // traz para frente
                        objControlValores.pack();//volta frame 
                    }
                } else {
                    objControlValores = new TelaControleDepositoSeguranca();
                    TelaModuloSeguranca.jPainelSeguranca.add(objControlValores);//adicona frame ao JDesktopPane  
                    objControlValores.setVisible(true);
                }
            }
            try {
                objControlValores.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleValoresActionPerformed

    private void EntradaPertencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaPertencesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaPertencesManutencao);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaEntradaPertencesManutencao) && codAbrir == 1) {
            if (objEntraObj == null || objEntraObj.isClosed()) {
                objEntraObj = new TelaEntradaObjetosPertences();
                jPainelSeguranca.add(objEntraObj);
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
                    TelaModuloSeguranca.jPainelSeguranca.add(objEntraObj);//adicona frame ao JDesktopPane  
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

    private void RelatorioDepositoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDepositoInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioDepositosSeguranca objRelDepoInt = new TelaRelatorioDepositosSeguranca();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelDepoInt);
        objRelDepoInt.show();
    }//GEN-LAST:event_RelatorioDepositoInternosActionPerformed

    private void ObjetosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjetosInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaObjetosInternos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaObjetosInternos) && codAbrir == 1) {
            if (objPertences == null || objPertences.isClosed()) {
                objPertences = new TelaPertences();
                jPainelSeguranca.add(objPertences);
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
                    TelaModuloSeguranca.jPainelSeguranca.add(objPertences);//adicona frame ao JDesktopPane  
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

    private void ObjetosProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjetosProcedimentosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaObjetosProcedimentos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaObjetosProcedimentos) && codAbrir == 1) {
            if (objObjetos == null || objObjetos.isClosed()) {
                objObjetos = new TelaObjetosProcedimento();
                jPainelSeguranca.add(objObjetos);
                objObjetos.setVisible(true);
            } else {
                if (objObjetos.isVisible()) {
                    if (objObjetos.isIcon()) { // Se esta minimizado
                        try {
                            objObjetos.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objObjetos.toFront(); // traz para frente
                        objObjetos.pack();//volta frame 
                    }
                } else {
                    objObjetos = new TelaObjetosProcedimento();
                    TelaModuloSeguranca.jPainelSeguranca.add(objObjetos);//adicona frame ao JDesktopPane  
                    objObjetos.setVisible(true);
                }
            }
            try {
                objObjetos.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ObjetosProcedimentosActionPerformed

    private void LocalPertencesInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalPertencesInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocalPertencesInternos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaLocalPertencesInternos) && codAbrir == 1) {
            if (objLocalPert == null || objLocalPert.isClosed()) {
                objLocalPert = new TelaLocalEstoquePertences();
                jPainelSeguranca.add(objLocalPert);
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
                    TelaModuloSeguranca.jPainelSeguranca.add(objLocalPert);//adicona frame ao JDesktopPane  
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

    private void RegistroObjetoProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroObjetoProcedimentoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroObjetoProcedimento);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaRegistroObjetoProcedimento) && codAbrir == 1) {
            if (objRegistroProc == null || objRegistroProc.isClosed()) {
                objRegistroProc = new TelaRegistroObjetosProcedimentos();
                jPainelSeguranca.add(objRegistroProc);
                objRegistroProc.setVisible(true);
            } else {
                if (objRegistroProc.isVisible()) {
                    if (objRegistroProc.isIcon()) { // Se esta minimizado
                        try {
                            objRegistroProc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegistroProc.toFront(); // traz para frente
                        objRegistroProc.pack();//volta frame 
                    }
                } else {
                    objRegistroProc = new TelaRegistroObjetosProcedimentos();
                    TelaModuloSeguranca.jPainelSeguranca.add(objRegistroProc);//adicona frame ao JDesktopPane  
                    objRegistroProc.setVisible(true);
                }
            }
            try {
                objRegistroProc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroObjetoProcedimentoActionPerformed

    private void SaidaPertencesInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaidaPertencesInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaPertencesInternos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaSaidaPertencesInternos) && codAbrir == 1) {
            if (objSaidaObjPertences == null || objSaidaObjPertences.isClosed()) {
                objSaidaObjPertences = new TelaSaidaObjetosPertences();
                jPainelSeguranca.add(objSaidaObjPertences);
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
                    TelaModuloSeguranca.jPainelSeguranca.add(objSaidaObjPertences);//adicona frame ao JDesktopPane  
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

    private void RetirarPenalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarPenalidadeActionPerformed
        // TODO add your handling code here:telaRetirarPenalidade
        buscarAcessoUsuario(telaRetirarPenalidade);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaRetirarPenalidade) && codAbrir == 1) {
            if (objRetirarPenal == null || objRetirarPenal.isClosed()) {
                objRetirarPenal = new TelaRetirarPenalidadeInterno();
                jPainelSeguranca.add(objRetirarPenal);
                objRetirarPenal.setVisible(true);
            } else {
                if (objRetirarPenal.isVisible()) {
                    if (objRetirarPenal.isIcon()) { // Se esta minimizado
                        try {
                            objRetirarPenal.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRetirarPenal.toFront(); // traz para frente
                        objRetirarPenal.pack();//volta frame 
                    }
                } else {
                    objRetirarPenal = new TelaRetirarPenalidadeInterno();
                    TelaModuloSeguranca.jPainelSeguranca.add(objRetirarPenal);//adicona frame ao JDesktopPane  
                    objRetirarPenal.setVisible(true);
                }
            }
            try {
                objRetirarPenal.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RetirarPenalidadeActionPerformed

    private void RegistroEvendoDisciplinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroEvendoDisciplinarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinar);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinar) && codAbrir == 1) {
            if (objEventoDiscpliar == null || objEventoDiscpliar.isClosed()) {
                objEventoDiscpliar = new TelaEventoDisciplinar();
                jPainelSeguranca.add(objEventoDiscpliar);
                objEventoDiscpliar.setVisible(true);
            } else {
                if (objEventoDiscpliar.isVisible()) {
                    if (objEventoDiscpliar.isIcon()) { // Se esta minimizado
                        try {
                            objEventoDiscpliar.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEventoDiscpliar.toFront(); // traz para frente
                        objEventoDiscpliar.pack();//volta frame 
                    }
                } else {
                    objEventoDiscpliar = new TelaEventoDisciplinar();
                    TelaModuloSeguranca.jPainelSeguranca.add(objEventoDiscpliar);//adicona frame ao JDesktopPane  
                    objEventoDiscpliar.setVisible(true);
                }
            }
            try {
                objEventoDiscpliar.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroEvendoDisciplinarActionPerformed

    private void LocalEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalEventoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocalEvento);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaLocalEvento) && codAbrir == 1) {
            if (objLocalEve == null || objLocalEve.isClosed()) {
                objLocalEve = new TelaLocalEventoIndisciplinar();
                jPainelSeguranca.add(objLocalEve);
                objLocalEve.setVisible(true);
            } else {
                if (objLocalEve.isVisible()) {
                    if (objLocalEve.isIcon()) { // Se esta minimizado
                        try {
                            objLocalEve.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objLocalEve.toFront(); // traz para frente
                        objLocalEve.pack();//volta frame 
                    }
                } else {
                    objLocalEve = new TelaLocalEventoIndisciplinar();
                    TelaModuloSeguranca.jPainelSeguranca.add(objLocalEve);//adicona frame ao JDesktopPane  
                    objLocalEve.setVisible(true);
                }
            }
            try {
                objLocalEve.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LocalEventoActionPerformed

    private void TipoFaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoFaltaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTipoFaltaDisciplinar);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaTipoFaltaDisciplinar) && codAbrir == 1) {
            if (objNaturezaEven == null || objNaturezaEven.isClosed()) {
                objNaturezaEven = new TelaNaturezaEventoIndisciplinar();
                jPainelSeguranca.add(objNaturezaEven);
                objNaturezaEven.setVisible(true);
            } else {
                if (objNaturezaEven.isVisible()) {
                    if (objNaturezaEven.isIcon()) { // Se esta minimizado
                        try {
                            objNaturezaEven.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objNaturezaEven.toFront(); // traz para frente
                        objNaturezaEven.pack();//volta frame 
                    }
                } else {
                    objNaturezaEven = new TelaNaturezaEventoIndisciplinar();
                    TelaModuloSeguranca.jPainelSeguranca.add(objNaturezaEven);//adicona frame ao JDesktopPane  
                    objNaturezaEven.setVisible(true);
                }
            }
            try {
                objNaturezaEven.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_TipoFaltaActionPerformed

    private void RequisicaoMateriaisInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRequisicaoMateriaisInternos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaRequisicaoMateriaisInternos) && codAbrir == 1) {
            if (objReqSEAC == null || objReqSEAC.isClosed()) {
                objReqSEAC = new TelaRequisicaoMateriaisInternosSEAC();
                jPainelSeguranca.add(objReqSEAC);
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
                    TelaModuloSeguranca.jPainelSeguranca.add(objReqSEAC);//adicona frame ao JDesktopPane  
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

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelSeguranca.add(objAgEventos);
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
                TelaModuloSeguranca.jPainelSeguranca.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void AprovadorOcorrenciaVisitasPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprovadorOcorrenciaVisitasPortariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadorOcorrenciaVisitasPortaria);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaAprovadorOcorrenciaVisitasPortaria) && codAbrir == 1) {
            if (objAprovaOcr == null || objAprovaOcr.isClosed()) {
                objAprovaOcr = new TelaAprovadoresOcorrenciaVisitasInternosSeguranca();
                jPainelSeguranca.add(objAprovaOcr);
                objAprovaOcr.setVisible(true);
            } else {
                if (objAprovaOcr.isVisible()) {
                    if (objAprovaOcr.isIcon()) { // Se esta minimizado
                        try {
                            objAprovaOcr.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAprovaOcr.toFront(); // traz para frente
                        objAprovaOcr.pack();//volta frame 
                    }
                } else {
                    objAprovaOcr = new TelaAprovadoresOcorrenciaVisitasInternosSeguranca();
                    TelaModuloSeguranca.jPainelSeguranca.add(objAprovaOcr);//adicona frame ao JDesktopPane  
                    objAprovaOcr.setVisible(true);
                }
            }
            try {
                objAprovaOcr.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AprovadorOcorrenciaVisitasPortariaActionPerformed

    private void BloqueioLiberacaoVisitasPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloqueioLiberacaoVisitasPortariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBloqueioLiberacaoVisitasPortaria);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaBloqueioLiberacaoVisitasPortaria) && codAbrir == 1) {
            if (objBloq == null || objBloq.isClosed()) {
                objBloq = new TelaBloqueioLiberacaoVisitasPortariaSeguranca();
                jPainelSeguranca.add(objBloq);
                objBloq.setVisible(true);
            } else {
                if (objBloq.isVisible()) {
                    if (objBloq.isIcon()) { // Se esta minimizado
                        try {
                            objBloq.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objBloq.toFront(); // traz para frente
                        objBloq.pack();//volta frame 
                    }
                } else {
                    objBloq = new TelaBloqueioLiberacaoVisitasPortariaSeguranca();
                    TelaModuloSeguranca.jPainelSeguranca.add(objBloq);//adicona frame ao JDesktopPane  
                    objBloq.setVisible(true);
                }
            }
            try {
                objBloq.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_BloqueioLiberacaoVisitasPortariaActionPerformed

    private void AplicarRegistroPenalidadeDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicarRegistroPenalidadeDisciplinasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinas);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinas) && codAbrir == 1) {
            if (objRegDisciplina == null || objRegDisciplina.isClosed()) {
                objRegDisciplina = new TelaRegimentoInternoDisciplinar();
                jPainelSeguranca.add(objRegDisciplina);
                objRegDisciplina.setVisible(true);
            } else {
                if (objRegDisciplina.isVisible()) {
                    if (objRegDisciplina.isIcon()) { // Se esta minimizado
                        try {
                            objRegDisciplina.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegDisciplina.toFront(); // traz para frente
                        objRegDisciplina.pack();//volta frame 
                    }
                } else {
                    objRegDisciplina = new TelaRegimentoInternoDisciplinar();
                    TelaModuloSeguranca.jPainelSeguranca.add(objRegDisciplina);//adicona frame ao JDesktopPane  
                    objRegDisciplina.setVisible(true);
                }
            }
            try {
                objRegDisciplina.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AplicarRegistroPenalidadeDisciplinasActionPerformed

    private void RelatorioInternosRegimePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosRegimePenalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/CRC/ListagemPronturarioInternosRegime.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "' "
                    + "OR SituacaoCrc='" + situacaoSai + "'ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("situacaoSaida", situacaoSai);
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
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioInternosRegimePenalActionPerformed

    private void RelatorioRegimeSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRegimeSexoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioInternoRegimeSexo objRelIntSeg = new TelaRelatorioInternoRegimeSexo();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelIntSeg);
        objRelIntSeg.show();
    }//GEN-LAST:event_RelatorioRegimeSexoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioBaculejo objRelBacu = new TelaRelatorioBaculejo();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelBacu);
        objRelBacu.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void jConsultaInternosIsolamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaInternosIsolamentoActionPerformed
        // TODO add your handling code here:
        if (objConIsola == null || objConIsola.isClosed()) {
            objConIsola = new TelaConsultaInternosIsolamento();
            jPainelSeguranca.add(objConIsola);
            objConIsola.setVisible(true);
        } else {
            if (objConIsola.isVisible()) {
                if (objConIsola.isIcon()) { // Se esta minimizado
                    try {
                        objConIsola.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConIsola.toFront(); // traz para frente
                    objConIsola.pack();//volta frame 
                }
            } else {
                objConIsola = new TelaConsultaInternosIsolamento();
                TelaModuloSeguranca.jPainelSeguranca.add(objConIsola);//adicona frame ao JDesktopPane  
                objConIsola.setVisible(true);
            }
        }
        try {
            objConIsola.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jConsultaInternosIsolamentoActionPerformed

    private void jConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfereActionPerformed
        // TODO add your handling code here:
        if (objConsultaConf == null || objConsultaConf.isClosed()) {
            objConsultaConf = new TelaConsultaConfere();
            jPainelSeguranca.add(objConsultaConf);
            objConsultaConf.setVisible(true);
        } else {
            if (objConsultaConf.isVisible()) {
                if (objConsultaConf.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaConf.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaConf.toFront(); // traz para frente
                    objConsultaConf.pack();//volta frame 
                }
            } else {
                objConsultaConf = new TelaConsultaConfere();
                TelaModuloSeguranca.jPainelSeguranca.add(objConsultaConf);//adicona frame ao JDesktopPane  
                objConsultaConf.setVisible(true);
            }
        }
        try {
            objConsultaConf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jConfereActionPerformed

    private void RelatorioRegimePenalPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRegimePenalPavilhaoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioRegimePavilhao objRelRegimePavilhao = new TelaRelatorioRegimePavilhao();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelRegimePavilhao);
        objRelRegimePavilhao.show();
    }//GEN-LAST:event_RelatorioRegimePenalPavilhaoActionPerformed

    private void ConfereRealizadoPorPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfereRealizadoPorPavilhaoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfereRealizado objRelConfere = new TelaRelatorioConfereRealizado();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ConfereRealizadoPorPavilhaoActionPerformed

    private void RelatorioInternosBeneficiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosBeneficiosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidaInternosPorData objRelaSaidaPort = new TelaRelatorioSaidaInternosPorData();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelaSaidaPort);
        objRelaSaidaPort.show();
    }//GEN-LAST:event_RelatorioInternosBeneficiosActionPerformed

    private void ConferePorOrdemAlfabeticaP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConferePorOrdemAlfabeticaP1ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/GerenciaOperacional/ListagemInternosPavilhaoCela.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN LOCALINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=LOCALINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON LOCALINTERNOS.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEnt + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomePavilhao", nomePavilhao1);
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("nomeUsuario", nameUser);
            parametros.put("unidadePenal", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Confere por Ordem Alfabetica - Pavilhão I - Galerias A,B e C");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ConferePorOrdemAlfabeticaP1ActionPerformed

    private void ConfereOrdemAlfabeticaP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfereOrdemAlfabeticaP2ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/GerenciaOperacional/ListagemInternosPavilhaoCelaP2.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN LOCALINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=LOCALINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON LOCALINTERNOS.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEnt + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomePavilhao", nomePavilhao2);
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("nomeUsuario", nameUser);
            parametros.put("unidadePenal", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Confere por Ordem Alfabetica - Pavilhão II - Galerias A e B");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ConfereOrdemAlfabeticaP2ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jRelatorioVisitasAdvogadosInternosGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioVisitasAdvogadosInternosGeralActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/GerenciaOperacional/RelatorioInternosAdvogadosGeral.jasper";
            conecta.executaSQL("SELECT * FROM ENTRADASADVINTERNOS "
                    + "INNER JOIN ITENSADVOGADOINTERNOS "
                    + "ON ENTRADASADVINTERNOS.IdLanc=ITENSADVOGADOINTERNOS.Idlanc "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ENTRADASADVINTERNOS.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSADVOGADOINTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc,ENTRADASADVINTERNOS.DataEntrada");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("descricaoUnidade", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Visitas de Advogados aos Internos - Geral");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jRelatorioVisitasAdvogadosInternosGeralActionPerformed

    private void jRelatorioVisitasAdvogadosInternosPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioVisitasAdvogadosInternosPorNomeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioVisitasAdvogadosInternosPorNome objRelVAINome = new TelaRelatorioVisitasAdvogadosInternosPorNome();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelVAINome);
        objRelVAINome.show();
    }//GEN-LAST:event_jRelatorioVisitasAdvogadosInternosPorNomeActionPerformed

    private void jNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNIMActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBaralhoCrimeUnidadePrisional);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaBaralhoCrimeUnidadePrisional) && codAbrir == 1) {
            if (objBC == null || objBC.isClosed()) {
                objBC = new BaralhoCrimeUnidadePrisional();
                jPainelSeguranca.add(objBC);
                objBC.setVisible(true);
            } else {
                if (objBC.isVisible()) {
                    if (objBC.isIcon()) { // Se esta minimizado
                        try {
                            objBC.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objBC.toFront(); // traz para frente
                        objBC.pack();//volta frame 
                    }
                } else {
                    objBC = new BaralhoCrimeUnidadePrisional();
                    TelaModuloSeguranca.jPainelSeguranca.add(objBC);//adicona frame ao JDesktopPane  
                    objBC.setVisible(true);
                }
            }
            try {
                objBC.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jNIMActionPerformed

    private void jRelatorioInternosComSemTornozeleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioInternosComSemTornozeleiraActionPerformed
        // TODO add your handling code here:
        TelaRelatorioInternosTornozeleiras objRel = new TelaRelatorioInternosTornozeleiras();
        TelaModuloSeguranca.jPainelSeguranca.add(objRel);
        objRel.show();
    }//GEN-LAST:event_jRelatorioInternosComSemTornozeleiraActionPerformed

    private void RelPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelPavilhaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelPavilhaoActionPerformed

    private void jRelatorioConfere2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioConfere2ActionPerformed
        TelaRelatorioConfere2 objRelConfere = new TelaRelatorioConfere2();
        TelaModuloSeguranca.jPainelSeguranca.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_jRelatorioConfere2ActionPerformed

    private void jGruposArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGruposArmasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaGrupoArmas);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaGrupoArmas) && codAbrir == 1) {
            if (objGrupoArma == null || objGrupoArma.isClosed()) {
                objGrupoArma = new TelaGrupoArmas();
                jPainelSeguranca.add(objGrupoArma);
                objGrupoArma.setVisible(true);
            } else {
                if (objGrupoArma.isVisible()) {
                    if (objGrupoArma.isIcon()) { // Se esta minimizado
                        try {
                            objGrupoArma.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objGrupoArma.toFront(); // traz para frente
                        objGrupoArma.pack();//volta frame 
                    }
                } else {
                    objGrupoArma = new TelaGrupoArmas();
                    TelaModuloSeguranca.jPainelSeguranca.add(objGrupoArma);//adicona frame ao JDesktopPane  
                    objGrupoArma.setVisible(true);
                }
            }
            try {
                objGrupoArma.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jGruposArmasActionPerformed

    private void jGruposEPISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGruposEPISActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaGrupoEPIs);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaGrupoEPIs) && codAbrir == 1) {
            if (objGrupoEPIs == null || objGrupoEPIs.isClosed()) {
                objGrupoEPIs = new TelaGrupoEPIs();
                jPainelSeguranca.add(objGrupoEPIs);
                objGrupoEPIs.setVisible(true);
            } else {
                if (objGrupoEPIs.isVisible()) {
                    if (objGrupoEPIs.isIcon()) { // Se esta minimizado
                        try {
                            objGrupoEPIs.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objGrupoEPIs.toFront(); // traz para frente
                        objGrupoEPIs.pack();//volta frame 
                    }
                } else {
                    objGrupoEPIs = new TelaGrupoEPIs();
                    TelaModuloSeguranca.jPainelSeguranca.add(objGrupoEPIs);//adicona frame ao JDesktopPane  
                    objGrupoEPIs.setVisible(true);
                }
            }
            try {
                objGrupoEPIs.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jGruposEPISActionPerformed

    private void jAcessoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAcessoriosActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaAcessoriosAREPIs);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaAcessoriosAREPIs) && codAbrir == 1) {
            if (objAcessoriosEPI == null || objAcessoriosEPI.isClosed()) {
                objAcessoriosEPI = new TelaAcessoriosArmasEPIs();
                jPainelSeguranca.add(objAcessoriosEPI);
                objAcessoriosEPI.setVisible(true);
            } else {
                if (objAcessoriosEPI.isVisible()) {
                    if (objAcessoriosEPI.isIcon()) { // Se esta minimizado
                        try {
                            objAcessoriosEPI.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAcessoriosEPI.toFront(); // traz para frente
                        objAcessoriosEPI.pack();//volta frame 
                    }
                } else {
                    objAcessoriosEPI = new TelaAcessoriosArmasEPIs();
                    TelaModuloSeguranca.jPainelSeguranca.add(objAcessoriosEPI);//adicona frame ao JDesktopPane  
                    objAcessoriosEPI.setVisible(true);
                }
            }
            try {
                objAcessoriosEPI.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jAcessoriosActionPerformed

    private void jCadastroArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastroArmasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaArmas);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaArmas) && codAbrir == 1) {
            if (objArmas == null || objArmas.isClosed()) {
                objArmas = new TelaArmas();
                jPainelSeguranca.add(objArmas);
                objArmas.setVisible(true);
            } else {
                if (objArmas.isVisible()) {
                    if (objArmas.isIcon()) { // Se esta minimizado
                        try {
                            objArmas.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objArmas.toFront(); // traz para frente
                        objArmas.pack();//volta frame 
                    }
                } else {
                    objArmas = new TelaArmas();
                    TelaModuloSeguranca.jPainelSeguranca.add(objArmas);//adicona frame ao JDesktopPane  
                    objArmas.setVisible(true);
                }
            }
            try {
                objArmas.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCadastroArmasActionPerformed

    private void jEquipamentosSegurancaEPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEquipamentosSegurancaEPIActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEquipamentosEPI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaEquipamentosEPI) && codAbrir == 1) {
            if (objEPI == null || objArmas.isClosed()) {
                objEPI = new TelaEquipamentosEPI();
                jPainelSeguranca.add(objEPI);
                objEPI.setVisible(true);
            } else {
                if (objEPI.isVisible()) {
                    if (objEPI.isIcon()) { // Se esta minimizado
                        try {
                            objEPI.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEPI.toFront(); // traz para frente
                        objEPI.pack();//volta frame 
                    }
                } else {
                    objEPI = new TelaEquipamentosEPI();
                    TelaModuloSeguranca.jPainelSeguranca.add(objEPI);//adicona frame ao JDesktopPane  
                    objEPI.setVisible(true);
                }
            }
            try {
                objEPI.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEquipamentosSegurancaEPIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaEscolta;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem AplicarRegistroPenalidadeDisciplinas;
    private javax.swing.JMenuItem AprovadorOcorrenciaVisitasPortaria;
    private javax.swing.JMenuItem BloqueioLiberacaoVisitasPortaria;
    private javax.swing.JMenu Cadastro;
    private javax.swing.JMenuItem CalculadoraPena;
    private javax.swing.JMenuItem CalculadoraWindows;
    private javax.swing.JMenuItem Celas;
    private javax.swing.JMenuItem ConfereOrdemAlfabeticaP2;
    private javax.swing.JMenuItem ConferePorOrdemAlfabeticaP1;
    private javax.swing.JMenuItem ConfereRealizadoPorPavilhao;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu ControleDisciplinarInternos;
    private javax.swing.JMenu ControlePertences;
    private javax.swing.JMenuItem ControleSaidaLaborativa;
    private javax.swing.JMenuItem ControleValores;
    private javax.swing.JMenuItem EntradaPertences;
    private javax.swing.JMenuItem HistoricoCrc;
    private javax.swing.JMenu HistoricosInternos;
    private javax.swing.JMenuItem ListaPassagem;
    private javax.swing.JMenuItem ListaPassagemExterna;
    private javax.swing.JMenuItem ListaPassagemInterna;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LivroOcorrencias;
    private javax.swing.JMenuItem LocacaoInternos;
    private javax.swing.JMenuItem LocalEvento;
    private javax.swing.JMenuItem LocalInternos;
    private javax.swing.JMenuItem LocalPertencesInternos;
    private javax.swing.JMenuItem MapaConfere;
    public static javax.swing.JMenuItem MenuProntuariosTodos;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem ObjetosInternos;
    private javax.swing.JMenuItem ObjetosProcedimentos;
    private javax.swing.JMenuItem Pavilhao;
    private javax.swing.JMenu PavilhaoeCelas;
    private javax.swing.JMenuItem PopulacaoInternosAgentes;
    private javax.swing.JMenuItem ProntuarioInternos;
    private javax.swing.JMenuItem RegistroEvendoDisciplinar;
    private javax.swing.JMenuItem RegistroObjetoProcedimento;
    private javax.swing.JMenuItem RelCelas;
    private javax.swing.JMenuItem RelPavilhao;
    private javax.swing.JMenuItem RelatorioDepositoInternos;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioFrequenciaColabordor;
    private javax.swing.JMenuItem RelatorioGeralPavilhaoCelas;
    private javax.swing.JMenuItem RelatorioInternosBeneficios;
    private javax.swing.JMenuItem RelatorioInternosRegimePenal;
    private javax.swing.JMenu RelatorioListasPassagens;
    private javax.swing.JMenuItem RelatorioPrevSaidaDiversos;
    private javax.swing.JMenu RelatorioPrevisaoSaida;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaInternos;
    private javax.swing.JMenuItem RelatorioRegimePenalPavilhao;
    private javax.swing.JMenuItem RelatorioRegimeSexo;
    private javax.swing.JMenu RelatoriosSeguranca;
    private javax.swing.JMenuItem RequisicaoMateriaisInternos;
    private javax.swing.JMenuItem RetirarPenalidade;
    private javax.swing.JMenuItem RolVisitas;
    private javax.swing.JMenuItem SaidaPertencesInternos;
    private javax.swing.JMenuItem SairTelaSeguranca;
    private javax.swing.JMenuItem TipoFalta;
    private javax.swing.JMenuItem TransferenciaPavilhaoCela;
    private javax.swing.JMenu Utilitarios;
    private javax.swing.JMenuItem VisitasInternos;
    private javax.swing.JMenuItem jAcessorios;
    private javax.swing.JMenuItem jCadastroArmas;
    private javax.swing.JMenuItem jConfere;
    private javax.swing.JMenuItem jConsultaInternosIsolamento;
    private javax.swing.JMenu jControleArmasEPI;
    private javax.swing.JMenuItem jDevolucaoArmas;
    private javax.swing.JMenuItem jEntradasArmas;
    private javax.swing.JMenuItem jEquipamentosSegurancaEPI;
    private javax.swing.JMenuItem jGruposArmas;
    private javax.swing.JMenuItem jGruposEPIS;
    private javax.swing.JMenuItem jInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMovimentacaoArmas;
    private javax.swing.JMenuItem jNIM;
    public static javax.swing.JDesktopPane jPainelSeguranca;
    private javax.swing.JMenuItem jRelatorioConfere2;
    private javax.swing.JMenuItem jRelatorioInternosComSemTornozeleira;
    private javax.swing.JMenuItem jRelatorioVisitasAdvogadosInternosGeral;
    private javax.swing.JMenuItem jRelatorioVisitasAdvogadosInternosPorNome;
    private javax.swing.JMenuItem jSaidasArmas;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroup = conecta.rs.getInt("IdUsuario");
            codigoGrupo = conecta.rs.getInt("IdGrupo");
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcesso = conecta.rs.getInt("IdUsuario");
            codAbrir = conecta.rs.getInt("Abrir");
            codIncluir = conecta.rs.getInt("Incluir");
            codAlterar = conecta.rs.getInt("Alterar");
            codExcluir = conecta.rs.getInt("Excluir");
            codGravar = conecta.rs.getInt("Gravar");
            codConsultar = conecta.rs.getInt("Consultar");
            nomeTela = conecta.rs.getString("NomeTela");
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
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "'AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCrc objRecados = new TelaRecadosCrc();
                TelaModuloSeguranca.jPainelSeguranca.add(objRecados);
                objRecados.show();
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
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
                                + "WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
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
            //  JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar mensagem.\nERRO:" + ex);
        }
    }

    public void buscarUsuario(String nomeUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nomeUser + "'");
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

    public void verificarAgendaCompromisso() {
        buscarUsuario(nameUser);
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE UsuarioAgenda='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + dataSisConvert + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
                conecta.rs.first();
                horaLembrete = conecta.rs.getString("HoraLembrete");
                usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
                codigoAgendaComp = conecta.rs.getString("IdAgenda");
                //
                if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                    TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAgendaComp);
                    objAgendaComp.show();
                    flag = 1;
                    preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                            + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                            + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                            + "AND DataLembrete='" + dataSisConvert + "' "
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
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAgendaComp);
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
        conecta.abrirConexao();
        // CADASTRO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPavilhao + "'");
            conecta.rs.first();
            pNomePA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCelas + "'");
            conecta.rs.first();
            pNomeCE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPopulacaoInternosAgentes + "'");
            conecta.rs.first();
            pNomePIA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaObjetosProcedimentos + "'");
            conecta.rs.first();
            pNomeOP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocalEvento + "'");
            conecta.rs.first();
            pNomeLE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTipoFaltaDisciplinar + "'");
            conecta.rs.first();
            pNomeTFD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisicaoMateriaisInternos + "'");
            conecta.rs.first();
            pNomeRMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRequisicaoMateriaisInternosProdutos + "'");
            conecta.rs.first();
            pNomeRMIP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprovadorOcorrenciaVisitasPortaria + "'");
            conecta.rs.first();
            pNomeAOVP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONTROLE DE PERTENCES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaObjetosInternos + "'");
            conecta.rs.first();
            pNomeOI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocalPertencesInternos + "'");
            conecta.rs.first();
            pNomeLPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaPertencesManutencao + "'");
            conecta.rs.first();
            pNomeEPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaPertencesPertences + "'");
            conecta.rs.first();
            pNomeEPMP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSaidaPertencesInternos + "'");
            conecta.rs.first();
            pNomeSPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSaidaPertencesPertences + "'");
            conecta.rs.first();
            pNomeSPP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocacaoInternosManutencao + "'");
            conecta.rs.first();
            pNomeLIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocacaoInternos + "'");
            conecta.rs.first();
            pNomeLI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTransferenciaPavilhaoCela + "'");
            conecta.rs.first();
            pNomeTPC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleValores + "'");
            conecta.rs.first();
            pNomeCV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleValoresInterno + "'");
            conecta.rs.first();
            pNomeCVI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroObjetoProcedimento + "'");
            conecta.rs.first();
            pNomeROP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroObjetoProcedimentoPavilhao + "'");
            conecta.rs.first();
            pNomeROPP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroObjetoObjetos + "'");
            conecta.rs.first();
            pNomeROPO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroObjetoAgentes + "'");
            conecta.rs.first();
            pNomeROPA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinar + "'");
            conecta.rs.first();
            pNomeRED = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarAutor + "'");
            conecta.rs.first();
            pNomeREDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarVitima + "'");
            conecta.rs.first();
            pNomeREDV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarVitimaFunc + "'");
            conecta.rs.first();
            pNomeREDVF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarTestemunha + "'");
            conecta.rs.first();
            pNomeREDT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarTestemunhaFunc + "'");
            conecta.rs.first();
            pNomeREDTF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarObjstos + "'");
            conecta.rs.first();
            pNomeREDO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroEvendoDisciplinarHistorico + "'");
            conecta.rs.first();
            pNomeREDH = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAplicarRegistroPenalidadeDisciplinas + "'");
            conecta.rs.first();
            pNomeARPD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAplicarRegistroPenalidadeDisciplinasAutor + "'");
            conecta.rs.first();
            pNomeARPDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAplicarRegistroPenalidadeDisciplinasOCR + "'");
            conecta.rs.first();
            pNomeARPDO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRetirarPenalidade + "'");
            conecta.rs.first();
            pNomeRP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRetirarPenalidadeInternos + "'");
            conecta.rs.first();
            pNomeRPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLivroOcorrencias + "'");
            conecta.rs.first();
            pNomeLO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBloqueioLiberacaoVisitasPortaria + "'");
            conecta.rs.first();
            pNomeBLVP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBaralhoCrimeUnidadePrisional + "'");
            conecta.rs.first();
            pNomeBC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONTROLE DE ARMAS E APIS  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaGrupoArmas + "'");
            conecta.rs.first();
            pNomeGR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaGrupoEPIs + "'");
            conecta.rs.first();
            pNomeGEPIs = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAcessoriosAREPIs + "'");
            conecta.rs.first();
            pNomeACESS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaArmas + "'");
            conecta.rs.first();
            pNomeARMAs = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaArmasQRCode + "'");
            conecta.rs.first();
            pNomeQRCode = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaArmasCODIGO_barras + "'");
            conecta.rs.first();
            pNomeCB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaArmasAcessorios + "'");
            conecta.rs.first();
            pNomeACES = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaArmasHistorico + "'");
            conecta.rs.first();
            pNomeHIST = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEquipamentosEPI + "'");
            conecta.rs.first();
            pNomeEPIManu = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MENU CADASTRO
        if (!pNomePA.equals(telaPavilhao) || pNomePA == null || pNomePA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPavilhao);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCE.equals(telaCelas) || pNomeCE == null || pNomeCE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCelas);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePIA.equals(telaPopulacaoInternosAgentes) || pNomePIA == null || pNomePIA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPopulacaoInternosAgentes);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOP.equals(telaObjetosProcedimentos) || pNomeOP == null || pNomeOP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaObjetosProcedimentos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLE.equals(telaLocalEvento) || pNomeLE == null || pNomeLE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocalEvento);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTFD.equals(telaTipoFaltaDisciplinar) || pNomeTFD == null || pNomeTFD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTipoFaltaDisciplinar);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRMI.equals(telaRequisicaoMateriaisInternos) || pNomeRMI == null || pNomeRMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisicaoMateriaisInternos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRMIP.equals(telaRequisicaoMateriaisInternosProdutos) || pNomeRMIP == null || pNomeRMIP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRequisicaoMateriaisInternosProdutos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAOVP.equals(telaAprovadorOcorrenciaVisitasPortaria) || pNomeAOVP == null || pNomeAOVP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprovadorOcorrenciaVisitasPortaria);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // CONTROLE DE PERTENCES
        if (!pNomeOI.equals(telaObjetosInternos) || pNomeOI == null || pNomeOI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaObjetosInternos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLPI.equals(telaLocalPertencesInternos) || pNomeLPI == null || pNomeLPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocalPertencesInternos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEPM.equals(telaEntradaPertencesManutencao) || pNomeEPM == null || pNomeEPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaPertencesManutencao);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEPMP.equals(telaEntradaPertencesPertences) || pNomeEPMP == null || pNomeEPMP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaPertencesPertences);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSPI.equals(telaSaidaPertencesInternos) || pNomeSPI == null || pNomeSPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSaidaPertencesInternos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSPP.equals(telaSaidaPertencesPertences) || pNomeSPP == null || pNomeSPP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSaidaPertencesPertences);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeLIM.equals(telaLocacaoInternosManutencao) || pNomeLIM == null || pNomeLIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocacaoInternosManutencao);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLI.equals(telaLocacaoInternos) || pNomeLI == null || pNomeLI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocacaoInternos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTPC.equals(telaTransferenciaPavilhaoCela) || pNomeTPC == null || pNomeTPC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTransferenciaPavilhaoCela);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCV.equals(telaControleValores) || pNomeCV == null || pNomeCV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleValores);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCVI.equals(telaControleValoresInterno) || pNomeCVI == null || pNomeCVI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleValoresInterno);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeROP.equals(telaRegistroObjetoProcedimento) || pNomeROP == null || pNomeROP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroObjetoProcedimento);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeROPP.equals(telaRegistroObjetoProcedimentoPavilhao) || pNomeROPP == null || pNomeROPP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroObjetoProcedimentoPavilhao);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeROPO.equals(telaRegistroObjetoObjetos) || pNomeROPO == null || pNomeROPO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroObjetoObjetos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeROPA.equals(telaRegistroObjetoAgentes) || pNomeROPA == null || pNomeROPA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroObjetoAgentes);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDA.equals(telaRegistroEvendoDisciplinarAutor) || pNomeREDA == null || pNomeREDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarAutor);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDV.equals(telaRegistroEvendoDisciplinarVitima) || pNomeREDV == null || pNomeREDV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarVitima);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDVF.equals(telaRegistroEvendoDisciplinarVitimaFunc) || pNomeREDVF == null || pNomeREDVF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarVitimaFunc);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDT.equals(telaRegistroEvendoDisciplinarTestemunha) || pNomeREDT == null || pNomeREDT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarTestemunha);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDTF.equals(telaRegistroEvendoDisciplinarTestemunhaFunc) || pNomeREDTF == null || pNomeREDTF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarTestemunhaFunc);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDO.equals(telaRegistroEvendoDisciplinarObjstos) || pNomeREDO == null || pNomeREDO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarObjstos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeREDH.equals(telaRegistroEvendoDisciplinarHistorico) || pNomeREDH == null || pNomeREDH.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroEvendoDisciplinarHistorico);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeARPD.equals(telaAplicarRegistroPenalidadeDisciplinas) || pNomeARPD == null || pNomeARPD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAplicarRegistroPenalidadeDisciplinas);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeARPDA.equals(telaAplicarRegistroPenalidadeDisciplinasAutor) || pNomeARPDA == null || pNomeARPDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAplicarRegistroPenalidadeDisciplinasAutor);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeARPDO.equals(telaAplicarRegistroPenalidadeDisciplinasOCR) || pNomeARPDO == null || pNomeARPDO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAplicarRegistroPenalidadeDisciplinasOCR);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRP.equals(telaRetirarPenalidade) || pNomeRP == null || pNomeRP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRetirarPenalidade);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRPI.equals(telaRetirarPenalidadeInternos) || pNomeRPI == null || pNomeRPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRetirarPenalidadeInternos);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLO.equals(telaLivroOcorrencias) || pNomeLO == null || pNomeLO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLivroOcorrencias);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBLVP.equals(telaBloqueioLiberacaoVisitasPortaria) || pNomeBLVP == null || pNomeBLVP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBloqueioLiberacaoVisitasPortaria);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBC.equals(telaBaralhoCrimeUnidadePrisional) || pNomeBC == null || pNomeBC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBaralhoCrimeUnidadePrisional);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CONTROLE DE ARMAS E EPI  
        if (!pNomeGR.equals(telaGrupoArmas) || pNomeGR == null || pNomeGR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaGrupoArmas);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeGEPIs.equals(telaGrupoEPIs) || pNomeGEPIs == null || pNomeGEPIs.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaGrupoEPIs);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeACESS.equals(telaAcessoriosAREPIs) || pNomeACESS == null || pNomeACESS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAcessoriosAREPIs);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeARMAs.equals(telaArmas) || pNomeARMAs == null || pNomeARMAs.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaArmas);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeQRCode.equals(telaArmasQRCode) || pNomeQRCode == null || pNomeQRCode.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaArmasQRCode);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCB.equals(telaArmasCODIGO_barras) || pNomeCB == null || pNomeCB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaArmasCODIGO_barras);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeACES.equals(telaArmasAcessorios) || pNomeACES == null || pNomeACES.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaArmasAcessorios);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeHIST.equals(telaArmasHistorico) || pNomeHIST == null || pNomeHIST.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaArmasHistorico);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //
        if (!pNomeEPIManu.equals(telaEquipamentosEPI) || pNomeEPIManu == null || pNomeEPIManu.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEquipamentosEPI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloSEG + "'");
            conecta.rs.first();
            pCodModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
    }

    public void PESQUISAR_LIBERACAO_implementacao() {
        PESQUISAR_IMPLEMENTA_SEG_001(telaGrupoArmas);
    }

    public void PESQUISAR_IMPLEMENTA_SEG_001(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jControleArmasEPI.setVisible(!true);
            jSeparator27.setVisible(!true);
            jSeparator28.setVisible(!true);
        } else if (objParCrc.getHabilitarImp() == null) {
            jControleArmasEPI.setVisible(!true);
            jSeparator27.setVisible(!true);
            jSeparator28.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jControleArmasEPI.setVisible(!true);
            jSeparator27.setVisible(!true);
            jSeparator28.setVisible(!true);
        } else {
            jControleArmasEPI.setVisible(true);
            jSeparator27.setVisible(true);
            jSeparator28.setVisible(true);
        }
    }
}
