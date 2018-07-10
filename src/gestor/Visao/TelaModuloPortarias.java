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
import static gestor.Visao.TelaRecadosPortaria.jBtAlterar;
import static gestor.Visao.TelaRecadosPortaria.jBtCancelar;
import static gestor.Visao.TelaRecadosPortaria.jBtConfirmar;
import static gestor.Visao.TelaRecadosPortaria.jBtExcluir;
import static gestor.Visao.TelaRecadosPortaria.jBtNovo;
import static gestor.Visao.TelaRecadosPortaria.jBtResponder;
import static gestor.Visao.TelaRecadosPortaria.jBtSalvar;
import static gestor.Visao.TelaRecadosPortaria.jComboBoxStatus;
import static gestor.Visao.TelaRecadosPortaria.jDataLanc;
import static gestor.Visao.TelaRecadosPortaria.jHoraRecado;
import static gestor.Visao.TelaRecadosPortaria.jIDLanc;
import static gestor.Visao.TelaRecadosPortaria.jNomeDestinatario;
import static gestor.Visao.TelaRecadosPortaria.jNomeRementente;
import static gestor.Visao.TelaRecadosPortaria.jRecado;
import static gestor.Visao.TelaRecadosPortaria.jTabelaTodosRecados;
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
public class TelaModuloPortarias extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    //
    private TelaEntradaSaidaVisitasInternos objEntSaiViInt = null;
    private TelaEntradaSaidaInternosPortaria objEntSaiLaborInt = null;
    private TelaEntradaSaidaAdvogadosInternos objEntSaiAdvInternos = null;
    private TelaEntradaSaidaAdvogados objEntSaiAd = null; // Para abrir uma tela uma unica vez
    private TelaEntradaSaidaVisitasDiversas objEntSaiVisiDiv = null;
    private TelaEntradaSaidaColaborador objEntSaiCola = null;
    private TelaEntradaSaidaPertences objEntradaSaidaPertences = null;
    private TelaControleDepositoPortaria objDepoPort = null;
    private TelaRegistroRetornoInternoPortaria objRetorno = null;
    private TelaRecadosPortaria objRecadosPort = null;
    private TelaEntradaSaidaVeiculosUnidade objEntSaiVeiUni = null;
    private TelaVeiculos objVeic = null;
    private TelaPertences objPert = null;
    private TelaEntradaSaidaVeiculosCargas objEntSaiVeiCarga = null;
    private TelaEntradaSaidaVeiculosTerceiros objEntSaiVeiTer = null;
    private TelaAdvogados objAd = null;
    private TelaConsultaPopulacao objConPop = null;
    private TelaVisitasDiversas objVisDi = null;
    private TelaConsultaAgendaEscoltaPortaria objAgEsPort = null;
    private TelaFuncionariosPortarias objFunPort = null;
    private TelaConsultaVisitaSocial objViSoPort = null;
    private TelaRolVisitasPortaria objRolViPor = null;
    private TelaConsultaSaidaInternos objCoSaidaInt = null;
    private TelaOcorrenciaPortaria objTexto = null;
    private TelaRegistroSaidaInternosPortaria objRegSaidaIntPort = null;
    private TelaEntradaUnidadeInternoPortaria objEntradaUndInterPort = null;
    private TelaConsultaLocalInternoPortaria objConsLocalInternos = null;
    private TelaConsultaInternosPortaria objConIntPort = null;
    private TelaNovaEntradaPortariaCrc objNovaEntrada = null;
    private TelaRegistroEntradaSaidaEducacional objRegEntSaiEdu = null;
    private TelaEntradaSaidaVisitasInternasInternos objInternasVisitas = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaOcorrenciaPortariaServicoSocial objOcorreciaVisita = null;
    private TelaEntradaSaidaInternosAlbergadosPortaria objEntSaiAlbergue = null;
    private TelaAcessosPortariaInterna objAcessTrans = null;
    private TelaEntradaSaidaOficialJustica objEntSaiOffice = null;
    private TelaOficialJustica objOfficeJustica = null;
    private TelaEntradaSaidaOficialJusticaInternos objEntSaiOfficeJusInt = null;
    private TelaAlertaSaidaInternosPortaria objSaidaPortaria = null;
    private TelaInstituicaoReligiosaPortarias objInstRel = null;
    private TelaConsultaVisitaSocialReligiosa objConVisRel = null;
    private TelaConsultaRolVisitasReligiosas objConRolRel = null;
    private TelaEntradaSaidaVisitasReligiosas objEntSaiVisitaRel = null;
    private TelaConsultaInternosIsolamento objConIsola = null;
    private TelaConsultaVisitasPortariaExterna objConRegVisita = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    String statusRol = "ABERTO";
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    String situacaoTran = "TRANSFERENCIA"; // Todas as Transferencias   
    String situacaoSai = "SAIDA TEMPORARIA";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    String statusFunc = "Ativo"; // STATUS DO COLABORADOR PARA O RELATÓRIO
    //
    String saidaConfirmada;
    String repostaSaida = "Não";
    //
    public static int codigoUserP1 = 0;
    public static int codUserAcessoP1 = 0;
    public static int codigoUserGroupP1 = 0;
    public static int codAbrirP1 = 0;
    public static int codIncluirP1 = 0;
    public static int codAlterarP1 = 0;
    public static int codExcluirP1 = 0;
    public static int codGravarP1 = 0;
    public static int codConsultarP1 = 0;
    public static int codigoGrupoP1 = 0;
    public static String nomeGrupoP1 = "";
    public static String nomeTelaP1 = "";
    // TELAS DE ACESSOS AO MÓDULO CRC
    public static String nomeModuloP1 = "PORTARIA";
    // MENU CADASTRO    
    public static String telaCadastroVeiculosManuP1 = "Cadastro:Veiculos:Manutenção";
    public static String telaCadastroPertenccesManuP1 = "Cadastro:Pertences:Manutenção";
    public static String telaCadastroAdvogadosManuP1 = "Cadastro:Advogados:Manutenção";
    public static String telaCadastroVisitasDiversasManuP1 = "Cadastro:Advogados:Manutenção";
    public static String telaCadastroOficialManuP1 = "Cadastro:Oficial Justiça:Manutenção";
    // MOVIMENTAÇÃO
    public static String telaEntradaSaidaVisitasInternosManuP1 = "Movimentação:Entrada e Saida Visitas de Internos:Manutenção";
    public static String telaEntradaSaidaVisitasInternosIntVisiP1 = "Movimentação:Entrada e Saida Visitas de Internos:Internos";
    //
    public static String telaEntradaSaidaVisitasInternasRIManuP1 = "Movimentação:Entrada e Saida (REGIME INTERNO) Visitas de Internos:Manutenção";
    public static String telaEntradaSaidaVisitasInternasIntRIVisiP1 = "Movimentação:Entrada e Saida (REGIME INTERNO) Visitas de Internos(as):Internas";
    //
    public static String telaEntradaSaidaVisitasReligiosasManuP1 = "Movimentação:Entrada e Saida de Visitas Religiosas:Manutenção";
    public static String telaEntradaSaidaVisitasReligiosasVisiP1 = "Movimentação:Entrada e Saida de Visitas Religiosas:Visitantes";
    //
    public static String telaEntradaSaidaAdIntManuP1 = "Movimentação:Entrada de Saida de Advogados de Internos:Manutenção";
    public static String telaEntradaSaidaAdIntInterP1 = "Movimentação:Entrada e Saida de Advogados de Internos:Internos";
    //   
    public static String telaEntradaSaidaAdDEPManuP1 = "Movimentação:Entrada e Saida de Advogados Departamento:Manutenção";
    public static String telaEntradaSaidaAdDEPADVP1 = "Movimentação:Entrada e Saida de Advogados Departamento:Advogados";
    //
    public static String telaEntradaSaidaOFJManuP1 = "Movimetação:Entrada e Saida de Oficial de Justiça:Manutenção";
    public static String telaEntradaSaidaOFJInteP1 = "Movimentação:Entrada e Saida de Oficial de Justiça:Internos";
    //
    public static String telaEntradaSaidaOJManuP1 = "Movimentação:Entrada e Saida de Oficial de Justiça Departamento:Manutenção";
    public static String telaEntradaSaidaOJDepP1 = "Movimentação:Entrada e Saida de Oficial de Justiça Departamento:Oficial de Justiça";
    //
    public static String telaEntradaSaidaVDManuP1 = "Movimentação:Entrada e Saida de Visitas Diversas:Manutenção";
    public static String telaEntradaSaidaVDVDP1 = "Movimentação:Entrada e Saida de Visitas Diversas:Visitas Diversas";
    //
    public static String telaEntradaSaidaCOLManuP1 = "Movimentação:Entrada e Saida de Colaborador:Manutenção";
    public static String telaEntradaSaidaCOLcolP1 = "Movimentação:Entrada e Saida de Colaborador:Colaborador";
    public static String telaEntradaSaidaCOLBioP1 = "Movimentação:Entrada e Saida de Colaborador:Biometria";
    //
    public static String telaAcessosPortariaManuP1 = "Movimentação:Acessos Portaria:Manutenção";
    public static String telaAcessosPortariaTranP1 = "Movimentação:Acessos Portaria:Transientes";
    //
    public static String telaEntradaSaidaVUManuP1 = "Movimentação:Entrada e Saida Veiculos Unidade:Manutenção";
    public static String telaEntradaSaidaVUVP1 = "Movimentação:Entrada e Saida Veiculos Unidade:Veiculos";
    //
    public static String telaEntradaSaidaESVCManuP1 = "Movimentação:Entrada e Saida Veiculos Cargas:Manutenção";
    public static String telaEntradaSaidaESVCVP1 = "Movimentação:Entrada e Saida Veiculos Cargas:Veiculos";
    //
    public static String telaEntradaSaidaESVTManuP1 = "Movimentação:Entrada e Saida de Veiculos de Terceiro:Manutenção";
    public static String telaEntradaSaidaESVTVP1 = "Movimentação:Entrada e Saida de Veiculos de Terceiro:Veiculos e Visitantes";
    //
    public static String telaEntradaSaidaLABManuP1 = "Movimentação:Entrada e Saida de Internos Laborativa:Manutenção";
    public static String telaEntradaSaidaLABIntP1 = "Movimentação:Entrada e Saida de Internos Laborativa:Internos";
    //
    public static String telaEntradaSaidaESIEEManuP1 = "Movimentação:Entrada e Saida de Internos Educação Externa:Manutenção";
    public static String telaEntradaSaidaESIEEIP1 = "Movimentação:Entrada e Saida de Internos Educação Externa:Internos";
    //
    public static String telaRegistroRetornoRIManuP1 = "Movimentação:Registro Retorno de Internos:Manutenção";
    public static String telaRegistroRetornoRIIntP1 = "Movimentação:Registro Retorno de Internos:Internos";
    public static String telaRegistroRetornoRIBioP1 = "Movimentação:Registro Retorno de Internos:Biometria";
    //
    public static String telaEntradaInternoUniPRIManuP1 = "Movimentação:Entrada de Internos Unidade Primeira Vez:Manutenção";
    public static String telaEntradaInternoUniPRIIntP1 = "Movimentação:Entrada de Internos Unidade Primeira Vez:Internos";
    //
    public static String telaNovaEntradaManuP1 = "Movimentação:Nova Entrada de Internos:Manutenção";
    public static String telaNovaEntradaIntP1 = "Movimentação:Nova Entrada de Internos:Internos";
    //
    public static String telaRegistroSaidaInternoManuP1 = "Movimentação:Registro Saida de Internos:Manutenção";
    public static String telaRegistroSaidaInternoIntP1 = "Movimentação:Registro Saida de Internos:Internos";
    //
    public static String telaRegistroSaidaInternoBioP1 = "Movimentação:Registro Saida de Internos:Biometria";
    public static String telaRegistroSaidaInternoExpP1 = "Movimentação:Registro Saida de Internos:Exportar Registro";
    //
    public static String telaEntradaSaidaAManuP1 = "Movimentação:Entrada e Saida de Albergados:Manutenção";
    public static String telaEntradaSaidaAIntP1 = "Movimentação:Entrada e Saida de Albergados:Internos";
    //
    public static String telaEntradaPertencesInternosManuP1 = "Movimentação:Entrada de Pertences de Internos:Manutenção";
    public static String telaEntradaPertencesInternosIntP1 = "Movimentação:Entrada de Pertences de Internos:Pertences";
    //
    public static String telaDepositoInternosManuP1 = "Movimentação:Deposito de Internos:Manutenção";
    public static String telaDepositoInternosIntP1 = "Movimentação:Deposito de Internos:Internos";
    //
    public static String telaOcorrenciaManuP1 = "Movimentação:Movimentação:Ocorrências Diárias:Manutenção";
    //
    public static String telaOcorrenciaDisciplinaVisitasManuP1 = "Movimentação:Ocorrência Disciplinar Visitas:Manutenção";
    public static String telaOcorrenciaDisciplinaVisitasVisiP1 = "Movimentação:Ocorrência Disciplinar Visitas:Visitantes";
    public static String telaOcorrenciaDisciplinaVisitasOcorP1 = "Movimentação:Ocorrência Disciplinar Visitas:Ocorrências";
    //
    public static String telaRelatorioPrevisaoSaidaP1 = "Relatórios:Previsão de Saída de Internos";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCVPM = "";
    String pNomeCPM = "";
    String pNomeCAM = "";
    String pNomeCVDM = "";
    String pNomeCOM = "";
    // MOVIMETAÇÃO
    String pNomeESVIM = "";
    String pNomeESVIMIV = "";
    //
    String pNomeESVIAM = "";
    String pNomeESVIAMI = "";
    //
    String pNomeESVRM = "";
    String pNomeESVRV = "";
    //
    String pNomeESAIM = "";
    String pNomeESAIMI = "";
    //
    String pNomeESADM = "";
    String pNomeESADMA = "";
    //
    String pNomeESOFJM = "";
    String pNomeESOFJI = "";
    //
    String pNomeESOJMP1 = "";
    String pNomeESOJDP1 = "";
    //
    String pNomeESVDM = "";
    String pNomeESVDV = "";
    //
    String pNomeESCM = "";
    String pNomeESCC = "";
    String pNomeESCB = "";
    //
    String pNomeAPM = "";
    String pNomeAPT = "";
    //
    String pNomeESVUM = "";
    String pNomeESVUV = "";
    //
    String pNomeESVCP1 = "";
    String pNomeESVCVP1 = "";
    //
    String pNomeESVT = "";
    String pNomeESVTV = "";
    //
    String pNomeESLM = "";
    String pNomeESLMI = "";
    //
    String pNomeESIEEM = "";
    String pNomeESIEEI = "";
    //
    String pNomeRRIM = "";
    String pNomeRRII = "";
    String pNomeRRIB = "";
    //
    String pNomeEIUPM = "";
    String pNomeEIUPI = "";
    //
    String pNomeNEM = "";
    String pNomeNEI = "";
    //
    String pNomeRSIM = "";
    String pNomeRSII = "";
    //
    String pNomeRSIB = "";
    String pNomeRSIE = "";
    //
    String pNomeESAM = "";
    String pNomeESAI = "";
    //
    String pNomeEPIM = "";
    String pNomeEPII = "";
    //
    String pNomeDIManu = "";
    String pNomeDIInt = "";
    //
    String pNomeOCR = "";
    //
    String pNomeOCDVM = "";
    String pNomeOCDVV = "";
    String pNomeOCDVO = "";
    //
    String pNomeRPSI = "";
    //

    /**
     * Creates new form TelaPortarias
     */
    public TelaModuloPortarias() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela          
        pesquisarTelasAcessos();
        threadMensagem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jPainelPortarias = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        CadastroVeiculos = new javax.swing.JMenuItem();
        CadastroPertences = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        CadastroAdvogados = new javax.swing.JMenuItem();
        VisitantesDiversos = new javax.swing.JMenuItem();
        jOficialJustica = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ConsultaFamiliaresInternos = new javax.swing.JMenuItem();
        ConsultaRolVisitas = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        InstituicaoReligiosa = new javax.swing.JMenuItem();
        VisitantesReligiosos = new javax.swing.JMenuItem();
        RolVistasReligiosas = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        ConsultaColaboradores = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        LocalInterno = new javax.swing.JMenuItem();
        RegistroProntuarioInterno = new javax.swing.JMenuItem();
        ConsultaPopulacaoCarceraria = new javax.swing.JMenuItem();
        ConsultaAgendamentoEscolta = new javax.swing.JMenuItem();
        ConsultaIsolamentoInternos = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        ConsultaRegistroVisitasPortariaExt = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        ControleAcessosPessoas = new javax.swing.JMenu();
        EntSaiVisitasInternos = new javax.swing.JMenuItem();
        jEntradaSaidaInternasInternos = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        EntradaSaidaVisitasReligiosas = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        EntSaiAdvogadosInternos = new javax.swing.JMenuItem();
        EntSaiAdvDepartamento = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        EntradaSaidaOficialJusticaInternos = new javax.swing.JMenuItem();
        EntradaSaidaOficialJusticaDepartamento = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        EnSaiVisitasDiversas = new javax.swing.JMenuItem();
        EntSaidColaborador = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jRegistroAcessosTransientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ControleAcessosVeiculos = new javax.swing.JMenu();
        ControleVeiculosUnid = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        ControleVeiculosCargas = new javax.swing.JMenuItem();
        ControleVeiculoTerceiros = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ControleAcessosInternos = new javax.swing.JMenu();
        EntSaiAtividadeLaborativa = new javax.swing.JMenuItem();
        ControleAssistenciaEducacional = new javax.swing.JMenuItem();
        RetornoInternosUnidade = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        EntradasUnidade = new javax.swing.JMenuItem();
        RegistroNovaEntrada = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        RegistrosSaidasInternos = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        ControlePertences = new javax.swing.JMenuItem();
        ControleDepositoInternos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        OcorrenciaVisitasInternos = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        RelatorioRolVisitas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVistasInternos = new javax.swing.JMenuItem();
        ListagemEntradaPertences = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        RelatorioVeiculosUnidade = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVeiculosCargas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVeiculosTerceiros = new javax.swing.JMenuItem();
        RelatorioCadastroVeiculos = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        RelatorioVisitasDiversas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVisitas = new javax.swing.JMenuItem();
        RelatorioIndisciplinarVisitasPortaria = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        RelatorioEntradaSaidaFuncDepto = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaColaboradores = new javax.swing.JMenuItem();
        RelatorioCadastroColaboradores = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenu11 = new javax.swing.JMenu();
        RelatorioEntradaSaidaAdvogadosInternos = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaAdvogadosDepartamento = new javax.swing.JMenuItem();
        RelatorioCadastroAdvogados = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        RelatorioPrevisaoSaida = new javax.swing.JMenuItem();
        RelatorioAtividadeLaborativa = new javax.swing.JMenuItem();
        RelatorioRetornosInternosUnidade = new javax.swing.JMenuItem();
        RelatorioSaidaInternosPortaria = new javax.swing.JMenuItem();
        RelatorioValoresPortaria = new javax.swing.JMenuItem();
        ListagemInternosRegimePenal = new javax.swing.JMenuItem();
        RelatorioEntradaInternos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        RelatorioOcorrencias = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem13.setText("jMenuItem13");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Controle de Portarias :::...");

        jPainelPortarias.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jPainelPortarias.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPortariasLayout = new javax.swing.GroupLayout(jPainelPortarias);
        jPainelPortarias.setLayout(jPainelPortariasLayout);
        jPainelPortariasLayout.setHorizontalGroup(
            jPainelPortariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelPortariasLayout.setVerticalGroup(
            jPainelPortariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelPortariasLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        Cadastros.setText("Cadastro");

        CadastroVeiculos.setText("Veiculos");
        CadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroVeiculosActionPerformed(evt);
            }
        });
        Cadastros.add(CadastroVeiculos);

        CadastroPertences.setText("Pertences");
        CadastroPertences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroPertencesActionPerformed(evt);
            }
        });
        Cadastros.add(CadastroPertences);
        Cadastros.add(jSeparator1);

        CadastroAdvogados.setText("Advogados");
        CadastroAdvogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroAdvogadosActionPerformed(evt);
            }
        });
        Cadastros.add(CadastroAdvogados);

        VisitantesDiversos.setText("Visitantes Diversos");
        VisitantesDiversos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitantesDiversosActionPerformed(evt);
            }
        });
        Cadastros.add(VisitantesDiversos);

        jOficialJustica.setText("Oficial de Justiça");
        jOficialJustica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOficialJusticaActionPerformed(evt);
            }
        });
        Cadastros.add(jOficialJustica);
        Cadastros.add(jSeparator4);

        AgendaCompromissos.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaCompromissos);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Cadastros.add(jMenuItem1);

        jMenuBar2.add(Cadastros);

        Consultas.setText("Consultas");

        ConsultaFamiliaresInternos.setText("Visitantes de Internos");
        ConsultaFamiliaresInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaFamiliaresInternosActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaFamiliaresInternos);

        ConsultaRolVisitas.setText("Rol de Visitas");
        ConsultaRolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaRolVisitasActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaRolVisitas);
        Consultas.add(jSeparator22);

        InstituicaoReligiosa.setText("Instituição Religiosa");
        InstituicaoReligiosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstituicaoReligiosaActionPerformed(evt);
            }
        });
        Consultas.add(InstituicaoReligiosa);

        VisitantesReligiosos.setText("Visitantes Religiosos");
        VisitantesReligiosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitantesReligiososActionPerformed(evt);
            }
        });
        Consultas.add(VisitantesReligiosos);

        RolVistasReligiosas.setText("Rol de Visitas Religiosas");
        RolVistasReligiosas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolVistasReligiosasActionPerformed(evt);
            }
        });
        Consultas.add(RolVistasReligiosas);
        Consultas.add(jSeparator20);

        ConsultaColaboradores.setText("Colaboradores");
        ConsultaColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaColaboradoresActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaColaboradores);
        Consultas.add(jSeparator21);

        LocalInterno.setText("Localização de Internos");
        LocalInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalInternoActionPerformed(evt);
            }
        });
        Consultas.add(LocalInterno);

        RegistroProntuarioInterno.setText("Registro de Prontuários de Internos");
        RegistroProntuarioInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroProntuarioInternoActionPerformed(evt);
            }
        });
        Consultas.add(RegistroProntuarioInterno);

        ConsultaPopulacaoCarceraria.setText("População Carcerária");
        ConsultaPopulacaoCarceraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaPopulacaoCarcerariaActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaPopulacaoCarceraria);

        ConsultaAgendamentoEscolta.setText("Agendamento Escolta");
        ConsultaAgendamentoEscolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaAgendamentoEscoltaActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaAgendamentoEscolta);

        ConsultaIsolamentoInternos.setForeground(new java.awt.Color(204, 0, 0));
        ConsultaIsolamentoInternos.setText("Isolamento de Internos");
        ConsultaIsolamentoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaIsolamentoInternosActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaIsolamentoInternos);
        Consultas.add(jSeparator24);

        ConsultaRegistroVisitasPortariaExt.setForeground(new java.awt.Color(0, 0, 204));
        ConsultaRegistroVisitasPortariaExt.setText("Consulta de Registros de Visitas de Internos a Portaria");
        ConsultaRegistroVisitasPortariaExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaRegistroVisitasPortariaExtActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaRegistroVisitasPortariaExt);

        jMenuBar2.add(Consultas);

        Movimentacao.setText("Movimentação");

        ControleAcessosPessoas.setText("Controle de Acessos de Pessoas");

        EntSaiVisitasInternos.setForeground(new java.awt.Color(0, 0, 255));
        EntSaiVisitasInternos.setText("Entrada/Saida de Visitas - Internos");
        EntSaiVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntSaiVisitasInternosActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntSaiVisitasInternos);

        jEntradaSaidaInternasInternos.setForeground(new java.awt.Color(204, 0, 0));
        jEntradaSaidaInternasInternos.setText("Entrada/Saida de Internas - Internos");
        jEntradaSaidaInternasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntradaSaidaInternasInternosActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(jEntradaSaidaInternasInternos);
        ControleAcessosPessoas.add(jSeparator23);

        EntradaSaidaVisitasReligiosas.setText("Entrada/Saída Visitas Religiosas");
        EntradaSaidaVisitasReligiosas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaSaidaVisitasReligiosasActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntradaSaidaVisitasReligiosas);
        ControleAcessosPessoas.add(jSeparator10);

        EntSaiAdvogadosInternos.setText("Entrada/Saída de Advogados aos Internos");
        EntSaiAdvogadosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntSaiAdvogadosInternosActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntSaiAdvogadosInternos);

        EntSaiAdvDepartamento.setText("Entrada/Saída de Advogados nos Departamentos");
        EntSaiAdvDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntSaiAdvDepartamentoActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntSaiAdvDepartamento);
        ControleAcessosPessoas.add(jSeparator11);

        EntradaSaidaOficialJusticaInternos.setText("Entrada/Saída de Oficial de Justiça aos Internos");
        EntradaSaidaOficialJusticaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaSaidaOficialJusticaInternosActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntradaSaidaOficialJusticaInternos);

        EntradaSaidaOficialJusticaDepartamento.setText("Entrada/Saida de Oficial de Justiça no Departamento");
        EntradaSaidaOficialJusticaDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaSaidaOficialJusticaDepartamentoActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntradaSaidaOficialJusticaDepartamento);
        ControleAcessosPessoas.add(jSeparator17);

        EnSaiVisitasDiversas.setText("Entrada/Saída Visitas Diversas");
        EnSaiVisitasDiversas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnSaiVisitasDiversasActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EnSaiVisitasDiversas);

        EntSaidColaborador.setText("Entrada/Saida de Colaborador");
        EntSaidColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntSaidColaboradorActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(EntSaidColaborador);
        ControleAcessosPessoas.add(jSeparator7);

        jRegistroAcessosTransientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRegistroAcessosTransientes.setForeground(new java.awt.Color(51, 153, 0));
        jRegistroAcessosTransientes.setText("Registro de Acesso nas Dependências Interna da Unidade - (R.A.D.I.U.)");
        jRegistroAcessosTransientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroAcessosTransientesActionPerformed(evt);
            }
        });
        ControleAcessosPessoas.add(jRegistroAcessosTransientes);

        Movimentacao.add(ControleAcessosPessoas);
        Movimentacao.add(jSeparator2);

        ControleAcessosVeiculos.setText("Controle de Acesso de Veiculos");

        ControleVeiculosUnid.setText("Controle de Veiculos da Unidade");
        ControleVeiculosUnid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleVeiculosUnidActionPerformed(evt);
            }
        });
        ControleAcessosVeiculos.add(ControleVeiculosUnid);
        ControleAcessosVeiculos.add(jSeparator8);

        ControleVeiculosCargas.setText("Controle de Veiculos de Cargas/Descarga com Ajudante");
        ControleVeiculosCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleVeiculosCargasActionPerformed(evt);
            }
        });
        ControleAcessosVeiculos.add(ControleVeiculosCargas);

        ControleVeiculoTerceiros.setText("Controle de Veiculos de Terceiros");
        ControleVeiculoTerceiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleVeiculoTerceirosActionPerformed(evt);
            }
        });
        ControleAcessosVeiculos.add(ControleVeiculoTerceiros);

        Movimentacao.add(ControleAcessosVeiculos);
        Movimentacao.add(jSeparator9);

        ControleAcessosInternos.setText("Controle/Registros de Acessos de Internos");

        EntSaiAtividadeLaborativa.setText("Registro de Entrada/Saida Atividades Laborativas - TO/P1");
        EntSaiAtividadeLaborativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntSaiAtividadeLaborativaActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(EntSaiAtividadeLaborativa);

        ControleAssistenciaEducacional.setForeground(new java.awt.Color(102, 0, 51));
        ControleAssistenciaEducacional.setText("Registro de Entrada/Saida Educacional Externa - PE/P1");
        ControleAssistenciaEducacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleAssistenciaEducacionalActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(ControleAssistenciaEducacional);

        RetornoInternosUnidade.setForeground(new java.awt.Color(0, 0, 255));
        RetornoInternosUnidade.setText("Registro de Retorno de Internos na Portaria - P1/CRC");
        RetornoInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoInternosUnidadeActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(RetornoInternosUnidade);
        ControleAcessosInternos.add(jSeparator19);

        EntradasUnidade.setText("Registro de Entrada na Unidade Penal - PRIMEIRA VEZ");
        EntradasUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradasUnidadeActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(EntradasUnidade);

        RegistroNovaEntrada.setForeground(new java.awt.Color(0, 153, 0));
        RegistroNovaEntrada.setText("Registro de Nova Entrada de Internos - P1/CRC");
        RegistroNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroNovaEntradaActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(RegistroNovaEntrada);
        ControleAcessosInternos.add(jSeparator12);

        RegistrosSaidasInternos.setForeground(new java.awt.Color(255, 0, 0));
        RegistrosSaidasInternos.setText("Registro de Saídas de Internos na Portaria - CRC/P1");
        RegistrosSaidasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrosSaidasInternosActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(RegistrosSaidasInternos);

        jMenuItem3.setText("Entrada/Saída de Internos Albergados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        ControleAcessosInternos.add(jMenuItem3);

        Movimentacao.add(ControleAcessosInternos);

        ControlePertences.setText("Controle de Pertences de Interno");
        ControlePertences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControlePertencesActionPerformed(evt);
            }
        });
        Movimentacao.add(ControlePertences);

        ControleDepositoInternos.setText("Controle de Depósitos Internos");
        ControleDepositoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleDepositoInternosActionPerformed(evt);
            }
        });
        Movimentacao.add(ControleDepositoInternos);
        Movimentacao.add(jSeparator3);

        LivroOcorrencias.setText("Livro de Ocorrências");
        LivroOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciasActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencias);
        Movimentacao.add(jSeparator5);

        OcorrenciaVisitasInternos.setForeground(new java.awt.Color(0, 0, 255));
        OcorrenciaVisitasInternos.setText("Ocorrências Indisciplinar de Visitas Internos");
        OcorrenciaVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcorrenciaVisitasInternosActionPerformed(evt);
            }
        });
        Movimentacao.add(OcorrenciaVisitasInternos);

        jMenuBar2.add(Movimentacao);

        Relatorios.setText("Relatórios");

        RelatorioRolVisitas.setText("Rol de Visitas");
        RelatorioRolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRolVisitasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioRolVisitas);

        RelatorioEntradaSaidaVistasInternos.setText("Relatório de Visitas de Internos");
        RelatorioEntradaSaidaVistasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVistasInternosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaSaidaVistasInternos);

        ListagemEntradaPertences.setText("Listagem de Pertences");
        ListagemEntradaPertences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemEntradaPertencesActionPerformed(evt);
            }
        });
        Relatorios.add(ListagemEntradaPertences);
        Relatorios.add(jSeparator18);

        jMenu9.setText("Relatório de Entrada/Saída de  Veículos na Unidade Penal");

        RelatorioVeiculosUnidade.setText("Veículos da Unidade");
        RelatorioVeiculosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVeiculosUnidadeActionPerformed(evt);
            }
        });
        jMenu9.add(RelatorioVeiculosUnidade);

        RelatorioEntradaSaidaVeiculosCargas.setText("Veículos de Cargas");
        RelatorioEntradaSaidaVeiculosCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVeiculosCargasActionPerformed(evt);
            }
        });
        jMenu9.add(RelatorioEntradaSaidaVeiculosCargas);

        RelatorioEntradaSaidaVeiculosTerceiros.setText("Veículos de Terceiros");
        RelatorioEntradaSaidaVeiculosTerceiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVeiculosTerceirosActionPerformed(evt);
            }
        });
        jMenu9.add(RelatorioEntradaSaidaVeiculosTerceiros);

        Relatorios.add(jMenu9);

        RelatorioCadastroVeiculos.setText("Listagem de Cadastro de Veículos");
        RelatorioCadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroVeiculosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCadastroVeiculos);
        Relatorios.add(jSeparator13);

        RelatorioVisitasDiversas.setText("Relatório de Visitas Diversas por Departamento/Motivo Visita");
        RelatorioVisitasDiversas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasDiversasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioVisitasDiversas);

        RelatorioEntradaSaidaVisitas.setText("Relatório de Registro de Entrada/Saída Geral de Visitas por Departamento");
        RelatorioEntradaSaidaVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVisitasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaSaidaVisitas);

        RelatorioIndisciplinarVisitasPortaria.setText("Relatório de Ocorrência Indisciplinar de Visitas na Portaria");
        RelatorioIndisciplinarVisitasPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioIndisciplinarVisitasPortariaActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioIndisciplinarVisitasPortaria);
        Relatorios.add(jSeparator15);

        jMenu3.setText("Relatórios de frequência de Colaboradores na Unidade Penal");

        RelatorioEntradaSaidaFuncDepto.setText("Relatório Entrada/Saída Colaborador Por Departamento");
        RelatorioEntradaSaidaFuncDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaFuncDeptoActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaSaidaFuncDepto);

        RelatorioEntradaSaidaColaboradores.setText("Relatório de Entrada/Saída de Colaboradores");
        RelatorioEntradaSaidaColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaColaboradoresActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaSaidaColaboradores);

        Relatorios.add(jMenu3);

        RelatorioCadastroColaboradores.setText("Listagem de Colaboradores");
        RelatorioCadastroColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroColaboradoresActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCadastroColaboradores);
        Relatorios.add(jSeparator16);

        jMenu11.setText("Relatório de Entrada/Saída de Advogados");

        RelatorioEntradaSaidaAdvogadosInternos.setText("Visitas a Internos");
        RelatorioEntradaSaidaAdvogadosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaAdvogadosInternosActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioEntradaSaidaAdvogadosInternos);

        RelatorioEntradaSaidaAdvogadosDepartamento.setText("A Departamentos");
        RelatorioEntradaSaidaAdvogadosDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioEntradaSaidaAdvogadosDepartamento);

        Relatorios.add(jMenu11);

        RelatorioCadastroAdvogados.setText("Listagem de Cadastro de Advogados");
        RelatorioCadastroAdvogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroAdvogadosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCadastroAdvogados);
        Relatorios.add(jSeparator14);

        RelatorioPrevisaoSaida.setForeground(new java.awt.Color(204, 0, 0));
        RelatorioPrevisaoSaida.setText("Relatório Previsão de Saída de Internos");
        RelatorioPrevisaoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioPrevisaoSaida);

        RelatorioAtividadeLaborativa.setText("Relatório Entrada/Saida de Internos com Atividades Laborativas");
        RelatorioAtividadeLaborativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAtividadeLaborativaActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioAtividadeLaborativa);

        RelatorioRetornosInternosUnidade.setText("Relatório de Retornos a Unidade de Internos");
        RelatorioRetornosInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRetornosInternosUnidadeActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioRetornosInternosUnidade);

        RelatorioSaidaInternosPortaria.setText("Relatório de Saida de Internos na Portaria por Beneficio");
        RelatorioSaidaInternosPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioSaidaInternosPortariaActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioSaidaInternosPortaria);

        RelatorioValoresPortaria.setText("Relatório de Depósitos de Valores para Internos");
        RelatorioValoresPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioValoresPortariaActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioValoresPortaria);

        ListagemInternosRegimePenal.setText("Listagem de Internos por Regime Penal");
        ListagemInternosRegimePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemInternosRegimePenalActionPerformed(evt);
            }
        });
        Relatorios.add(ListagemInternosRegimePenal);

        RelatorioEntradaInternos.setText("Relatório de Entrada de Internos na Unidade Penal");
        RelatorioEntradaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaInternos);
        Relatorios.add(jSeparator6);

        RelatorioOcorrencias.setText("Relatório de Ocorrências");
        RelatorioOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioOcorrenciasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioOcorrencias);

        jMenuBar2.add(Relatorios);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPortarias)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPortarias)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ConsultaPopulacaoCarcerariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaPopulacaoCarcerariaActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objConPop == null || objConPop.isClosed()) {
            objConPop = new TelaConsultaPopulacao();
            jPainelPortarias.add(objConPop);
            objConPop.setVisible(true);
        } else {
            if (objConPop.isVisible()) {
                if (objConPop.isIcon()) { // Se esta minimizado
                    try {
                        objConPop.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConPop.toFront(); // traz para frente
                    objConPop.pack();//volta frame 
                }
            } else {
                objConPop = new TelaConsultaPopulacao();
                TelaModuloPortarias.jPainelPortarias.add(objConPop);//adicona frame ao JDesktopPane  
                objConPop.setVisible(true);
            }
        }
        try {
            objConPop.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaPopulacaoCarcerariaActionPerformed

    private void CadastroAdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroAdvogadosActionPerformed
        // TODO add your handling code here:   
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCadastroAdvogadosManuP1) && codAbrirP1 == 1) {
            if (objAd == null || objAd.isClosed()) {
                objAd = new TelaAdvogados();
                jPainelPortarias.add(objAd);
                objAd.setVisible(true);
            } else {
                if (objAd.isVisible()) {
                    if (objAd.isIcon()) { // Se esta minimizado
                        try {
                            objAd.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAd.toFront(); // traz para frente
                        objAd.pack();//volta frame 
                    }
                } else {
                    objAd = new TelaAdvogados();
                    TelaModuloPortarias.jPainelPortarias.add(objAd);//adicona frame ao JDesktopPane  
                    objAd.setVisible(true);
                }
            }
            try {
                objAd.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CadastroAdvogadosActionPerformed

    private void CadastroPertencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroPertencesActionPerformed
        // TODO add your handling code here:      
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCadastroPertenccesManuP1) && codAbrirP1 == 1) {
            if (objPert == null || objPert.isClosed()) {
                objPert = new TelaPertences();
                jPainelPortarias.add(objPert);
                objPert.setVisible(true);
            } else {
                if (objPert.isVisible()) {
                    if (objPert.isIcon()) { // Se esta minimizado
                        try {
                            objPert.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPert.toFront(); // traz para frente
                        objPert.pack();//volta frame 
                    }
                } else {
                    objPert = new TelaPertences();
                    TelaModuloPortarias.jPainelPortarias.add(objPert);//adicona frame ao JDesktopPane  
                    objPert.setVisible(true);
                }
            }
            try {
                objPert.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CadastroPertencesActionPerformed

    private void CadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroVeiculosActionPerformed
        // TODO add your handling code here:      
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCadastroVeiculosManuP1) && codAbrirP1 == 1) {
            if (objVeic == null || objVeic.isClosed()) {
                objVeic = new TelaVeiculos();
                jPainelPortarias.add(objVeic);
                objVeic.setVisible(true);
            } else {
                if (objVeic.isVisible()) {
                    if (objVeic.isIcon()) { // Se esta minimizado
                        try {
                            objVeic.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objVeic.toFront(); // traz para frente
                        objVeic.pack();//volta frame 
                    }
                } else {
                    objVeic = new TelaVeiculos();
                    TelaModuloPortarias.jPainelPortarias.add(objVeic);//adicona frame ao JDesktopPane  
                    objVeic.setVisible(true);
                }
            }
            try {
                objVeic.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CadastroVeiculosActionPerformed

    private void VisitantesDiversosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitantesDiversosActionPerformed
        // TODO add your handling code here:     
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCadastroVisitasDiversasManuP1) && codAbrirP1 == 1) {
            if (objVisDi == null || objVisDi.isClosed()) {
                objVisDi = new TelaVisitasDiversas();
                jPainelPortarias.add(objVisDi);
                objVisDi.setVisible(true);
            } else {
                if (objVisDi.isVisible()) {
                    if (objVisDi.isIcon()) { // Se esta minimizado
                        try {
                            objVisDi.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objVisDi.toFront(); // traz para frente
                        objVisDi.pack();//volta frame 
                    }
                } else {
                    objVisDi = new TelaVisitasDiversas();
                    TelaModuloPortarias.jPainelPortarias.add(objVisDi);//adicona frame ao JDesktopPane  
                    objVisDi.setVisible(true);
                }
            }
            try {
                objVisDi.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VisitantesDiversosActionPerformed

    private void ConsultaAgendamentoEscoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaAgendamentoEscoltaActionPerformed
        // TODO add your handling code here:        
        // Abrir uma única tela, funcionando
        if (objAgEsPort == null || objAgEsPort.isClosed()) {
            objAgEsPort = new TelaConsultaAgendaEscoltaPortaria();
            jPainelPortarias.add(objAgEsPort);
            objAgEsPort.setVisible(true);
        } else {
            if (objAgEsPort.isVisible()) {
                if (objAgEsPort.isIcon()) { // Se esta minimizado
                    try {
                        objAgEsPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgEsPort.toFront(); // traz para frente
                    objAgEsPort.pack();//volta frame 
                }
            } else {
                objAgEsPort = new TelaConsultaAgendaEscoltaPortaria();
                TelaModuloPortarias.jPainelPortarias.add(objAgEsPort);//adicona frame ao JDesktopPane  
                objAgEsPort.setVisible(true);
            }
        }
        try {
            objAgEsPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaAgendamentoEscoltaActionPerformed

    private void ConsultaColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaColaboradoresActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objFunPort == null || objFunPort.isClosed()) {
            objFunPort = new TelaFuncionariosPortarias();
            jPainelPortarias.add(objFunPort);
            objFunPort.setVisible(true);
        } else {
            if (objFunPort.isVisible()) {
                if (objFunPort.isIcon()) { // Se esta minimizado
                    try {
                        objFunPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFunPort.toFront(); // traz para frente
                    objFunPort.pack();//volta frame 
                }
            } else {
                objFunPort = new TelaFuncionariosPortarias();
                TelaModuloPortarias.jPainelPortarias.add(objFunPort);//adicona frame ao JDesktopPane  
                objFunPort.setVisible(true);
            }
        }
        try {
            objFunPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaColaboradoresActionPerformed

    private void ConsultaFamiliaresInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaFamiliaresInternosActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objViSoPort == null || objViSoPort.isClosed()) {
            objViSoPort = new TelaConsultaVisitaSocial();
            jPainelPortarias.add(objViSoPort);
            objViSoPort.setVisible(true);
        } else {
            if (objViSoPort.isVisible()) {
                if (objViSoPort.isIcon()) { // Se esta minimizado
                    try {
                        objViSoPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objViSoPort.toFront(); // traz para frente
                    objViSoPort.pack();//volta frame 
                }
            } else {
                objViSoPort = new TelaConsultaVisitaSocial();
                TelaModuloPortarias.jPainelPortarias.add(objViSoPort);//adicona frame ao JDesktopPane  
                objViSoPort.setVisible(true);
            }
        }
        try {
            objViSoPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaFamiliaresInternosActionPerformed

    private void ConsultaRolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaRolVisitasActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objRolViPor == null || objRolViPor.isClosed()) {
            objRolViPor = new TelaRolVisitasPortaria();
            jPainelPortarias.add(objRolViPor);
            objRolViPor.setVisible(true);
        } else {
            if (objRolViPor.isVisible()) {
                if (objRolViPor.isIcon()) { // Se esta minimizado
                    try {
                        objRolViPor.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRolViPor.toFront(); // traz para frente
                    objRolViPor.pack();//volta frame 
                }
            } else {
                objRolViPor = new TelaRolVisitasPortaria();
                TelaModuloPortarias.jPainelPortarias.add(objRolViPor);//adicona frame ao JDesktopPane  
                objRolViPor.setVisible(true);
            }
        }
        try {
            objRolViPor.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaRolVisitasActionPerformed

    private void EntSaidColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntSaidColaboradorActionPerformed
        // TODO add your handling code here:      
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaCOLManuP1) && codAbrirP1 == 1) {
            if (objEntSaiCola == null || objEntSaiCola.isClosed()) {
                objEntSaiCola = new TelaEntradaSaidaColaborador();
                jPainelPortarias.add(objEntSaiCola);
                objEntSaiCola.setVisible(true);
            } else {
                if (objEntSaiCola.isVisible()) {
                    if (objEntSaiCola.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiCola.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiCola.toFront(); // traz para frente
                        objEntSaiCola.pack();//volta frame 
                    }
                } else {
                    objEntSaiCola = new TelaEntradaSaidaColaborador();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiCola);//adicona frame ao JDesktopPane  
                    objEntSaiCola.setVisible(true);
                }
            }
            try {
                objEntSaiCola.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntSaidColaboradorActionPerformed

    private void EnSaiVisitasDiversasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSaiVisitasDiversasActionPerformed
        // TODO add your handling code here: telaEntradaSaidaVDManuP1       
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVDManuP1) && codAbrirP1 == 1) {
            if (objEntSaiVisiDiv == null || objEntSaiVisiDiv.isClosed()) {
                objEntSaiVisiDiv = new TelaEntradaSaidaVisitasDiversas();
                jPainelPortarias.add(objEntSaiVisiDiv);
                objEntSaiVisiDiv.setVisible(true);
            } else {
                if (objEntSaiVisiDiv.isVisible()) {
                    if (objEntSaiVisiDiv.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVisiDiv.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVisiDiv.toFront(); // traz para frente
                        objEntSaiVisiDiv.pack();//volta frame 
                    }
                } else {
                    objEntSaiVisiDiv = new TelaEntradaSaidaVisitasDiversas();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiVisiDiv);//adicona frame ao JDesktopPane  
                    objEntSaiVisiDiv.setVisible(true);
                }
            }
            try {
                objEntSaiVisiDiv.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EnSaiVisitasDiversasActionPerformed

    private void EntSaiAdvDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntSaiAdvDepartamentoActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdDEPManuP1) && codAbrirP1 == 1) {
            if (objEntSaiAd == null || objEntSaiAd.isClosed()) {
                objEntSaiAd = new TelaEntradaSaidaAdvogados();
                jPainelPortarias.add(objEntSaiAd);
                objEntSaiAd.setVisible(true);
            } else {
                if (objEntSaiAd.isVisible()) {
                    if (objEntSaiAd.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiAd.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiAd.toFront(); // traz para frente
                        objEntSaiAd.pack();//volta frame 
                    }
                } else {
                    objEntSaiAd = new TelaEntradaSaidaAdvogados();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiAd);//adicona frame ao JDesktopPane  
                    objEntSaiAd.setVisible(true);
                }
            }
            try {
                objEntSaiAd.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntSaiAdvDepartamentoActionPerformed

    private void EntSaiVisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntSaiVisitasInternosActionPerformed
        // TODO add your handling code here:    
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternosManuP1) && codAbrirP1 == 1) {
            if (objEntSaiViInt == null || objEntSaiViInt.isClosed()) {
                objEntSaiViInt = new TelaEntradaSaidaVisitasInternos();
                jPainelPortarias.add(objEntSaiViInt);
                objEntSaiViInt.setVisible(true);
            } else {
                if (objEntSaiViInt.isVisible()) {
                    if (objEntSaiViInt.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiViInt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiViInt.toFront(); // traz para frente
                        objEntSaiViInt.pack();//volta frame 
                    }
                } else {
                    objEntSaiViInt = new TelaEntradaSaidaVisitasInternos();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiViInt);//adicona frame ao JDesktopPane  
                    objEntSaiViInt.setVisible(true);
                }
            }
            try {
                objEntSaiViInt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntSaiVisitasInternosActionPerformed

    private void EntSaiAdvogadosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntSaiAdvogadosInternosActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAdIntManuP1) && codAbrirP1 == 1) {
            if (objEntSaiAdvInternos == null || objEntSaiAdvInternos.isClosed()) {
                objEntSaiAdvInternos = new TelaEntradaSaidaAdvogadosInternos();
                jPainelPortarias.add(objEntSaiAdvInternos);
                objEntSaiAdvInternos.setVisible(true);
            } else {
                if (objEntSaiAdvInternos.isVisible()) {
                    if (objEntSaiAdvInternos.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiAdvInternos.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiAdvInternos.toFront(); // traz para frente
                        objEntSaiAdvInternos.pack();//volta frame 
                    }
                } else {
                    objEntSaiAdvInternos = new TelaEntradaSaidaAdvogadosInternos();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiAdvInternos);//adicona frame ao JDesktopPane  
                    objEntSaiAdvInternos.setVisible(true);
                }
            }
            try {
                objEntSaiAdvInternos.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntSaiAdvogadosInternosActionPerformed

    private void ControlePertencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControlePertencesActionPerformed
        // TODO add your handling code here:  
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaPertencesInternosManuP1) && codAbrirP1 == 1) {
            if (objEntradaSaidaPertences == null || objEntradaSaidaPertences.isClosed()) {
                objEntradaSaidaPertences = new TelaEntradaSaidaPertences();
                jPainelPortarias.add(objEntradaSaidaPertences);
                objEntradaSaidaPertences.setVisible(true);
            } else {
                if (objEntradaSaidaPertences.isVisible()) {
                    if (objEntradaSaidaPertences.isIcon()) { // Se esta minimizado
                        try {
                            objEntradaSaidaPertences.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntradaSaidaPertences.toFront(); // traz para frente
                        objEntradaSaidaPertences.pack();//volta frame 
                    }
                } else {
                    objEntradaSaidaPertences = new TelaEntradaSaidaPertences();
                    TelaModuloPortarias.jPainelPortarias.add(objEntradaSaidaPertences);//adicona frame ao JDesktopPane  
                    objEntradaSaidaPertences.setVisible(true);
                }
            }
            try {
                objEntradaSaidaPertences.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControlePertencesActionPerformed

    private void ControleVeiculoTerceirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleVeiculoTerceirosActionPerformed
        // TODO add your handling code here:telaEntradaSaidaESVTManuP1
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESVTManuP1) && codAbrirP1 == 1) {
            if (objEntSaiVeiTer == null || objEntSaiVeiTer.isClosed()) {
                objEntSaiVeiTer = new TelaEntradaSaidaVeiculosTerceiros();
                jPainelPortarias.add(objEntSaiVeiTer);
                objEntSaiVeiTer.setVisible(true);
            } else {
                if (objEntSaiVeiTer.isVisible()) {
                    if (objEntSaiVeiTer.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVeiTer.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVeiTer.toFront(); // traz para frente
                        objEntSaiVeiTer.pack();//volta frame 
                    }
                } else {
                    objEntSaiVeiTer = new TelaEntradaSaidaVeiculosTerceiros();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiVeiTer);//adicona frame ao JDesktopPane  
                    objEntSaiVeiTer.setVisible(true);
                }
            }
            try {
                objEntSaiVeiTer.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleVeiculoTerceirosActionPerformed

    private void ControleVeiculosUnidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleVeiculosUnidActionPerformed
        // TODO add your handling code here:   
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVUManuP1) && codAbrirP1 == 1) {
            if (objEntSaiVeiUni == null || objEntSaiVeiUni.isClosed()) {
                objEntSaiVeiUni = new TelaEntradaSaidaVeiculosUnidade();
                jPainelPortarias.add(objEntSaiVeiUni);
                objEntSaiVeiUni.setVisible(true);
            } else {
                if (objEntSaiVeiUni.isVisible()) {
                    if (objEntSaiVeiUni.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVeiUni.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVeiUni.toFront(); // traz para frente
                        objEntSaiVeiUni.pack();//volta frame 
                    }
                } else {
                    objEntSaiVeiUni = new TelaEntradaSaidaVeiculosUnidade();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiVeiUni);//adicona frame ao JDesktopPane  
                    objEntSaiVeiUni.setVisible(true);
                }
            }
            try {
                objEntSaiVeiUni.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleVeiculosUnidActionPerformed

    private void ControleVeiculosCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleVeiculosCargasActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESVCManuP1) && codAbrirP1 == 1) {
            if (objEntSaiVeiCarga == null || objEntSaiVeiCarga.isClosed()) {
                objEntSaiVeiCarga = new TelaEntradaSaidaVeiculosCargas();
                jPainelPortarias.add(objEntSaiVeiCarga);
                objEntSaiVeiCarga.setVisible(true);
            } else {
                if (objEntSaiVeiCarga.isVisible()) {
                    if (objEntSaiVeiCarga.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVeiCarga.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVeiCarga.toFront(); // traz para frente
                        objEntSaiVeiCarga.pack();//volta frame 
                    }
                } else {
                    objEntSaiVeiCarga = new TelaEntradaSaidaVeiculosCargas();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiVeiCarga);//adicona frame ao JDesktopPane  
                    objEntSaiVeiCarga.setVisible(true);
                }
            }
            try {
                objEntSaiVeiCarga.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleVeiculosCargasActionPerformed

    private void ControleDepositoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleDepositoInternosActionPerformed
        // TODO add your handling code here:   
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaDepositoInternosManuP1) && codAbrirP1 == 1) {
            if (objDepoPort == null || objDepoPort.isClosed()) {
                objDepoPort = new TelaControleDepositoPortaria();
                jPainelPortarias.add(objDepoPort);
                objDepoPort.setVisible(true);
            } else {
                if (objDepoPort.isVisible()) {
                    if (objDepoPort.isIcon()) { // Se esta minimizado
                        try {
                            objDepoPort.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objDepoPort.toFront(); // traz para frente
                        objDepoPort.pack();//volta frame 
                    }
                } else {
                    objDepoPort = new TelaControleDepositoPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objDepoPort);//adicona frame ao JDesktopPane  
                    objDepoPort.setVisible(true);
                }
            }
            try {
                objDepoPort.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleDepositoInternosActionPerformed

    private void EntSaiAtividadeLaborativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntSaiAtividadeLaborativaActionPerformed
        // TODO add your handling code here:   
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaLABManuP1) && codAbrirP1 == 1) {
            if (objEntSaiLaborInt == null || objEntSaiLaborInt.isClosed()) {
                objEntSaiLaborInt = new TelaEntradaSaidaInternosPortaria();
                jPainelPortarias.add(objEntSaiLaborInt);
                objEntSaiLaborInt.setVisible(true);
            } else {
                if (objEntSaiLaborInt.isVisible()) {
                    if (objEntSaiLaborInt.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiLaborInt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiLaborInt.toFront(); // traz para frente
                        objEntSaiLaborInt.pack();//volta frame 
                    }
                } else {
                    objEntSaiLaborInt = new TelaEntradaSaidaInternosPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiLaborInt);//adicona frame ao JDesktopPane  
                    objEntSaiLaborInt.setVisible(true);
                }
            }
            try {
                objEntSaiLaborInt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntSaiAtividadeLaborativaActionPerformed

    private void RetornoInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoInternosUnidadeActionPerformed
        // TODO add your handling code here:   
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIManuP1) && codAbrirP1 == 1) {
            if (objRetorno == null || objRetorno.isClosed()) {
                objRetorno = new TelaRegistroRetornoInternoPortaria();
                jPainelPortarias.add(objRetorno);
                objRetorno.setVisible(true);
            } else {
                if (objRetorno.isVisible()) {
                    if (objRetorno.isIcon()) { // Se esta minimizado
                        try {
                            objRetorno.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRetorno.toFront(); // traz para frente
                        objRetorno.pack();//volta frame 
                    }
                } else {
                    objRetorno = new TelaRegistroRetornoInternoPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objRetorno);//adicona frame ao JDesktopPane  
                    objRetorno.setVisible(true);
                }
            }
            try {
                objRetorno.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RetornoInternosUnidadeActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:        
        // Abrir uma única tela, funcionando
        if (objRecadosPort == null || objRecadosPort.isClosed()) {
            objRecadosPort = new TelaRecadosPortaria();
            jPainelPortarias.add(objRecadosPort);
            objRecadosPort.setVisible(true);
        } else {
            if (objRecadosPort.isVisible()) {
                if (objRecadosPort.isIcon()) { // Se esta minimizado
                    try {
                        objRecadosPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadosPort.toFront(); // traz para frente
                    objRecadosPort.pack();//volta frame 
                }
            } else {
                objRecadosPort = new TelaRecadosPortaria();
                TelaModuloPortarias.jPainelPortarias.add(objRecadosPort);//adicona frame ao JDesktopPane  
                objRecadosPort.setVisible(true);
            }
        }
        try {
            objRecadosPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void LivroOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciasActionPerformed
        // TODO add your handling code here:   
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaManuP1) && codAbrirP1 == 1) {
            if (objTexto == null || objTexto.isClosed()) {
                objTexto = new TelaOcorrenciaPortaria();
                jPainelPortarias.add(objTexto);
                objTexto.setVisible(true);
            } else {
                if (objTexto.isVisible()) {
                    if (objTexto.isIcon()) { // Se esta minimizado
                        try {
                            objTexto.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTexto.toFront(); // traz para frente
                        objTexto.pack();//volta frame 
                    }
                } else {
                    objTexto = new TelaOcorrenciaPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objTexto);//adicona frame ao JDesktopPane  
                    objTexto.setVisible(true);
                }
            }
            try {
                objTexto.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciasActionPerformed

    private void RelatorioRolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRolVisitasActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RolVisitas.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ROLVISITAS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ROLVISITAS.IdInternoCrc "
                    + "INNER JOIN ITENSROL "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSROL.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ITENSROL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE StatusRol='" + statusRol + "'");
            HashMap parametros = new HashMap();
            parametros.put("statusRol", statusRol);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Rol de Visitas"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO. :" + e);
        }
    }//GEN-LAST:event_RelatorioRolVisitasActionPerformed

    private void RegistrosSaidasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrosSaidasInternosActionPerformed
        // TODO add your handling code here:  
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoManuP1) && codAbrirP1 == 1) {
            if (objRegSaidaIntPort == null || objRegSaidaIntPort.isClosed()) {
                objRegSaidaIntPort = new TelaRegistroSaidaInternosPortaria();
                jPainelPortarias.add(objRegSaidaIntPort);
                objRegSaidaIntPort.setVisible(true);
            } else {
                if (objRegSaidaIntPort.isVisible()) {
                    if (objRegSaidaIntPort.isIcon()) { // Se esta minimizado
                        try {
                            objRegSaidaIntPort.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegSaidaIntPort.toFront(); // traz para frente
                        objRegSaidaIntPort.pack();//volta frame 
                    }
                } else {
                    objRegSaidaIntPort = new TelaRegistroSaidaInternosPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objRegSaidaIntPort);//adicona frame ao JDesktopPane  
                    objRegSaidaIntPort.setVisible(true);
                }
            }
            try {
                objRegSaidaIntPort.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistrosSaidasInternosActionPerformed

    private void EntradasUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradasUnidadeActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaInternoUniPRIManuP1) && codAbrirP1 == 1) {
            if (objEntradaUndInterPort == null || objEntradaUndInterPort.isClosed()) {
                objEntradaUndInterPort = new TelaEntradaUnidadeInternoPortaria();
                jPainelPortarias.add(objEntradaUndInterPort);
                objEntradaUndInterPort.setVisible(true);
            } else {
                if (objEntradaUndInterPort.isVisible()) {
                    if (objEntradaUndInterPort.isIcon()) { // Se esta minimizado
                        try {
                            objEntradaUndInterPort.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntradaUndInterPort.toFront(); // traz para frente
                        objEntradaUndInterPort.pack();//volta frame 
                    }
                } else {
                    objEntradaUndInterPort = new TelaEntradaUnidadeInternoPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objEntradaUndInterPort);//adicona frame ao JDesktopPane  
                    objEntradaUndInterPort.setVisible(true);
                }
            }
            try {
                objEntradaUndInterPort.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntradasUnidadeActionPerformed

    private void LocalInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalInternoActionPerformed
        // TODO add your handling code here:
        if (objConsLocalInternos == null || objConsLocalInternos.isClosed()) {
            objConsLocalInternos = new TelaConsultaLocalInternoPortaria();
            jPainelPortarias.add(objConsLocalInternos);
            objConsLocalInternos.setVisible(true);
        } else {
            if (objConsLocalInternos.isVisible()) {
                if (objConsLocalInternos.isIcon()) { // Se esta minimizado
                    try {
                        objConsLocalInternos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsLocalInternos.toFront(); // traz para frente
                    objConsLocalInternos.pack();//volta frame 
                }
            } else {
                objConsLocalInternos = new TelaConsultaLocalInternoPortaria();
                TelaModuloPortarias.jPainelPortarias.add(objConsLocalInternos);//adicona frame ao JDesktopPane  
                objConsLocalInternos.setVisible(true);
            }
        }
        try {
            objConsLocalInternos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalInternoActionPerformed

    private void RelatorioPrevisaoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRelatorioPrevisaoSaidaP1) && codAbrirP1 == 1) {
            TelaRelatorioPrevisaoSaidaPortaria objPrevSaiPorta = new TelaRelatorioPrevisaoSaidaPortaria();
            TelaModuloPortarias.jPainelPortarias.add(objPrevSaiPorta);
            objPrevSaiPorta.show();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RelatorioPrevisaoSaidaActionPerformed

    private void RelatorioEntradaSaidaVistasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVistasInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasInternos objRelVisitasInt = new TelaRelatorioEntradaSaidaVisitasInternos();
        TelaModuloPortarias.jPainelPortarias.add(objRelVisitasInt);
        objRelVisitasInt.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVistasInternosActionPerformed

    private void RelatorioVeiculosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVeiculosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVeiculosUnidadePenal objRelVeicUni = new TelaRelatorioEntradaSaidaVeiculosUnidadePenal();
        TelaModuloPortarias.jPainelPortarias.add(objRelVeicUni);
        objRelVeicUni.show();
    }//GEN-LAST:event_RelatorioVeiculosUnidadeActionPerformed

    private void RelatorioEntradaSaidaVeiculosCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVeiculosCargasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioEntradaSaidaVeiculosCargasActionPerformed

    private void RelatorioEntradaSaidaVeiculosTerceirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVeiculosTerceirosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioEntradaSaidaVeiculosTerceirosActionPerformed

    private void RelatorioCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroVeiculosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioCadastroVeiculosActionPerformed

    private void RelatorioVisitasDiversasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVisitasDiversasActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento objRelVisitasMot = new TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento();
        TelaModuloPortarias.jPainelPortarias.add(objRelVisitasMot);
        objRelVisitasMot.show();
    }//GEN-LAST:event_RelatorioVisitasDiversasActionPerformed

    private void RelatorioEntradaSaidaColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaColaboradoresActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradoresPortaria objRelFuncPort = new TelaRelatorioEntradaSaidaColaboradoresPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objRelFuncPort);
        objRelFuncPort.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaColaboradoresActionPerformed

    private void RelatorioCadastroColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroColaboradoresActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioGeralColaboradores.jasper";
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE StatusFunc='" + statusFunc + "' "
                    + "ORDER BY NomeDepartamento,NomeFunc");
            HashMap parametros = new HashMap();
            parametros.put("statusFunc", statusFunc);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Colaboradores por Departamento");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioCadastroColaboradoresActionPerformed

    private void RelatorioEntradaSaidaAdvogadosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaAdvogadosInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaAdvogadosInternos objRelAdv = new TelaRelatorioEntradaSaidaAdvogadosInternos();
        TelaModuloPortarias.jPainelPortarias.add(objRelAdv);
        objRelAdv.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaAdvogadosInternosActionPerformed

    private void RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed

    private void RelatorioCadastroAdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroAdvogadosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioCadastroAdvogadosActionPerformed

    private void RelatorioAtividadeLaborativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAtividadeLaborativaActionPerformed
        // TODO add your handling code here:
        TelaRelAtividadeLaborExterna relAtiviLabExt = new TelaRelAtividadeLaborExterna();
        TelaModuloPortarias.jPainelPortarias.add(relAtiviLabExt);
        relAtiviLabExt.show();
    }//GEN-LAST:event_RelatorioAtividadeLaborativaActionPerformed

    private void RelatorioRetornosInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRetornosInternosUnidadeActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioRetornosInternosUnidadeActionPerformed

    private void RelatorioValoresPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioValoresPortariaActionPerformed
        // TODO add your handling code here:      
        TelaRelatorioDepositosPortaria objRelValores = new TelaRelatorioDepositosPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objRelValores);
        objRelValores.show();
    }//GEN-LAST:event_RelatorioValoresPortariaActionPerformed

    private void ListagemEntradaPertencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemEntradaPertencesActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_ListagemEntradaPertencesActionPerformed

    private void RelatorioOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioOcorrenciasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioOcorrenciasActionPerformed

    private void ListagemInternosRegimePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemInternosRegimePenalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosRegime.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "' "
                    + "OR SituacaoCrc='" + situacaoRet + "'ORDER BY NomeInternoCrc");
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
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListagemInternosRegimePenalActionPerformed

    private void RegistroProntuarioInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroProntuarioInternoActionPerformed
        // TODO add your handling code here:
        if (objConIntPort == null || objConIntPort.isClosed()) {
            objConIntPort = new TelaConsultaInternosPortaria();
            jPainelPortarias.add(objConIntPort);
            objConIntPort.setVisible(true);
        } else {
            if (objConIntPort.isVisible()) {
                if (objConIntPort.isIcon()) { // Se esta minimizado
                    try {
                        objConIntPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConIntPort.toFront(); // traz para frente
                    objConIntPort.pack();//volta frame 
                }
            } else {
                objConIntPort = new TelaConsultaInternosPortaria();
                TelaModuloPortarias.jPainelPortarias.add(objConIntPort);//adicona frame ao JDesktopPane  
                objConIntPort.setVisible(true);
            }
        }
        try {
            objConIntPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RegistroProntuarioInternoActionPerformed

    private void RegistroNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroNovaEntradaActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaNovaEntradaManuP1) && codAbrirP1 == 1) {
            if (objNovaEntrada == null || objNovaEntrada.isClosed()) {
                objNovaEntrada = new TelaNovaEntradaPortariaCrc();
                jPainelPortarias.add(objNovaEntrada);
                objNovaEntrada.setVisible(true);
            } else {
                if (objNovaEntrada.isVisible()) {
                    if (objNovaEntrada.isIcon()) { // Se esta minimizado
                        try {
                            objNovaEntrada.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objNovaEntrada.toFront(); // traz para frente
                        objNovaEntrada.pack();//volta frame 
                    }
                } else {
                    objNovaEntrada = new TelaNovaEntradaPortariaCrc();
                    TelaModuloPortarias.jPainelPortarias.add(objNovaEntrada);//adicona frame ao JDesktopPane  
                    objNovaEntrada.setVisible(true);
                }
            }
            try {
                objNovaEntrada.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroNovaEntradaActionPerformed

    private void ControleAssistenciaEducacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleAssistenciaEducacionalActionPerformed
        // TODO add your handling code here:telaEntradaSaidaESIEEManuP1
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaESIEEManuP1) && codAbrirP1 == 1) {
            if (objRegEntSaiEdu == null || objRegEntSaiEdu.isClosed()) {
                objRegEntSaiEdu = new TelaRegistroEntradaSaidaEducacional();
                jPainelPortarias.add(objRegEntSaiEdu);
                objRegEntSaiEdu.setVisible(true);
            } else {
                if (objRegEntSaiEdu.isVisible()) {
                    if (objRegEntSaiEdu.isIcon()) { // Se esta minimizado
                        try {
                            objRegEntSaiEdu.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegEntSaiEdu.toFront(); // traz para frente
                        objRegEntSaiEdu.pack();//volta frame 
                    }
                } else {
                    objRegEntSaiEdu = new TelaRegistroEntradaSaidaEducacional();
                    TelaModuloPortarias.jPainelPortarias.add(objRegEntSaiEdu);//adicona frame ao JDesktopPane  
                    objRegEntSaiEdu.setVisible(true);
                }
            }
            try {
                objRegEntSaiEdu.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleAssistenciaEducacionalActionPerformed

    private void jEntradaSaidaInternasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntradaSaidaInternasInternosActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasInternasRIManuP1) && codAbrirP1 == 1) {
            if (objInternasVisitas == null || objInternasVisitas.isClosed()) {
                objInternasVisitas = new TelaEntradaSaidaVisitasInternasInternos();
                jPainelPortarias.add(objInternasVisitas);
                objInternasVisitas.setVisible(true);
            } else {
                if (objInternasVisitas.isVisible()) {
                    if (objInternasVisitas.isIcon()) { // Se esta minimizado
                        try {
                            objInternasVisitas.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objInternasVisitas.toFront(); // traz para frente
                        objInternasVisitas.pack();//volta frame 
                    }
                } else {
                    objInternasVisitas = new TelaEntradaSaidaVisitasInternasInternos();
                    TelaModuloPortarias.jPainelPortarias.add(objInternasVisitas);//adicona frame ao JDesktopPane  
                    objInternasVisitas.setVisible(true);
                }
            }
            try {
                objInternasVisitas.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEntradaSaidaInternasInternosActionPerformed

    private void RelatorioSaidaInternosPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioSaidaInternosPortariaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidaInternosPorData objRelaSaidaPort = new TelaRelatorioSaidaInternosPorData();
        TelaModuloPortarias.jPainelPortarias.add(objRelaSaidaPort);
        objRelaSaidaPort.show();
    }//GEN-LAST:event_RelatorioSaidaInternosPortariaActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelPortarias.add(objAgEventos);
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
                TelaModuloPortarias.jPainelPortarias.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void RelatorioEntradaSaidaVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVisitasActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaGeral objRelEntSai = new TelaRelatorioEntradaSaidaVisitasPortariaGeral();
        TelaModuloPortarias.jPainelPortarias.add(objRelEntSai);
        objRelEntSai.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVisitasActionPerformed

    private void OcorrenciaVisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcorrenciaVisitasInternosActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasManuP1) && codAbrirP1 == 1) {
            if (objOcorreciaVisita == null || objOcorreciaVisita.isClosed()) {
                objOcorreciaVisita = new TelaOcorrenciaPortariaServicoSocial();
                jPainelPortarias.add(objOcorreciaVisita);
                objOcorreciaVisita.setVisible(true);
            } else {
                if (objOcorreciaVisita.isVisible()) {
                    if (objOcorreciaVisita.isIcon()) { // Se esta minimizado
                        try {
                            objOcorreciaVisita.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcorreciaVisita.toFront(); // traz para frente
                        objOcorreciaVisita.pack();//volta frame 
                    }
                } else {
                    objOcorreciaVisita = new TelaOcorrenciaPortariaServicoSocial();
                    TelaModuloPortarias.jPainelPortarias.add(objOcorreciaVisita);//adicona frame ao JDesktopPane  
                    objOcorreciaVisita.setVisible(true);
                }
            }
            try {
                objOcorreciaVisita.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_OcorrenciaVisitasInternosActionPerformed

    private void RelatorioIndisciplinarVisitasPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioIndisciplinarVisitasPortariaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioGeralOcorrenciaIndisciplinarVisitasPortaria.jasper";
            conecta.executaSQL("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                    + "INNER JOIN OCORRENCIA_INDISCIPLINA_PORTARIA "
                    + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita");
            HashMap parametros = new HashMap();
            parametros.put("nameUser", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Ocorrências Indisciplinar de Visitas - Portaria"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioIndisciplinarVisitasPortariaActionPerformed

    private void RelatorioEntradaSaidaFuncDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaFuncDeptoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradorPorDepartamento objRelFuncDepto = new TelaRelatorioEntradaSaidaColaboradorPorDepartamento();
        TelaModuloPortarias.jPainelPortarias.add(objRelFuncDepto);
        objRelFuncDepto.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaFuncDeptoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaAManuP1) && codAbrirP1 == 1) {
            if (objEntSaiAlbergue == null || objEntSaiAlbergue.isClosed()) {
                objEntSaiAlbergue = new TelaEntradaSaidaInternosAlbergadosPortaria();
                jPainelPortarias.add(objEntSaiAlbergue);
                objEntSaiAlbergue.setVisible(true);
            } else {
                if (objEntSaiAlbergue.isVisible()) {
                    if (objEntSaiAlbergue.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiAlbergue.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiAlbergue.toFront(); // traz para frente
                        objEntSaiAlbergue.pack();//volta frame 
                    }
                } else {
                    objEntSaiAlbergue = new TelaEntradaSaidaInternosAlbergadosPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiAlbergue);//adicona frame ao JDesktopPane  
                    objEntSaiAlbergue.setVisible(true);
                }
            }
            try {
                objEntSaiAlbergue.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jRegistroAcessosTransientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroAcessosTransientesActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaAcessosPortariaManuP1) && codAbrirP1 == 1) {
            if (objAcessTrans == null || objAcessTrans.isClosed()) {
                objAcessTrans = new TelaAcessosPortariaInterna();
                jPainelPortarias.add(objAcessTrans);
                objAcessTrans.setVisible(true);
            } else {
                if (objAcessTrans.isVisible()) {
                    if (objAcessTrans.isIcon()) { // Se esta minimizado
                        try {
                            objAcessTrans.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAcessTrans.toFront(); // traz para frente
                        objAcessTrans.pack();//volta frame 
                    }
                } else {
                    objAcessTrans = new TelaAcessosPortariaInterna();
                    TelaModuloPortarias.jPainelPortarias.add(objAcessTrans);//adicona frame ao JDesktopPane  
                    objAcessTrans.setVisible(true);
                }
            }
            try {
                objAcessTrans.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistroAcessosTransientesActionPerformed

    private void jOficialJusticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOficialJusticaActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCadastroOficialManuP1) && codAbrirP1 == 1) {
            if (objOfficeJustica == null || objOfficeJustica.isClosed()) {
                objOfficeJustica = new TelaOficialJustica();
                jPainelPortarias.add(objOfficeJustica);
                objOfficeJustica.setVisible(true);
            } else {
                if (objOfficeJustica.isVisible()) {
                    if (objOfficeJustica.isIcon()) { // Se esta minimizado
                        try {
                            objOfficeJustica.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOfficeJustica.toFront(); // traz para frente
                        objOfficeJustica.pack();//volta frame 
                    }
                } else {
                    objOfficeJustica = new TelaOficialJustica();
                    TelaModuloPortarias.jPainelPortarias.add(objOfficeJustica);//adicona frame ao JDesktopPane  
                    objOfficeJustica.setVisible(true);
                }
            }
            try {
                objOfficeJustica.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jOficialJusticaActionPerformed

    private void EntradaSaidaOficialJusticaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaSaidaOficialJusticaInternosActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaOFJManuP1) && codAbrirP1 == 1) {
            if (objEntSaiOfficeJusInt == null || objEntSaiOfficeJusInt.isClosed()) {
                objEntSaiOfficeJusInt = new TelaEntradaSaidaOficialJusticaInternos();
                jPainelPortarias.add(objEntSaiOfficeJusInt);
                objEntSaiOfficeJusInt.setVisible(true);
            } else {
                if (objEntSaiOfficeJusInt.isVisible()) {
                    if (objEntSaiOfficeJusInt.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiOfficeJusInt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiOfficeJusInt.toFront(); // traz para frente
                        objEntSaiOfficeJusInt.pack();//volta frame 
                    }
                } else {
                    objEntSaiOfficeJusInt = new TelaEntradaSaidaOficialJusticaInternos();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiOfficeJusInt);//adicona frame ao JDesktopPane  
                    objEntSaiOfficeJusInt.setVisible(true);
                }
            }
            try {
                objEntSaiOfficeJusInt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntradaSaidaOficialJusticaInternosActionPerformed

    private void EntradaSaidaOficialJusticaDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaSaidaOficialJusticaDepartamentoActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaOJManuP1) && codAbrirP1 == 1) {
            if (objEntSaiOffice == null || objEntSaiOffice.isClosed()) {
                objEntSaiOffice = new TelaEntradaSaidaOficialJustica();
                jPainelPortarias.add(objEntSaiOffice);
                objEntSaiOffice.setVisible(true);
            } else {
                if (objEntSaiOffice.isVisible()) {
                    if (objEntSaiOffice.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiOffice.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiOffice.toFront(); // traz para frente
                        objEntSaiOffice.pack();//volta frame 
                    }
                } else {
                    objEntSaiOffice = new TelaEntradaSaidaOficialJustica();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiOffice);//adicona frame ao JDesktopPane  
                    objEntSaiOffice.setVisible(true);
                }
            }
            try {
                objEntSaiOffice.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntradaSaidaOficialJusticaDepartamentoActionPerformed

    private void VisitantesReligiososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitantesReligiososActionPerformed
        // TODO add your handling code here:
        if (objConVisRel == null || objConVisRel.isClosed()) {
            objConVisRel = new TelaConsultaVisitaSocialReligiosa();
            jPainelPortarias.add(objConVisRel);
            objConVisRel.setVisible(true);
        } else {
            if (objConVisRel.isVisible()) {
                if (objConVisRel.isIcon()) { // Se esta minimizado
                    try {
                        objConVisRel.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConVisRel.toFront(); // traz para frente
                    objConVisRel.pack();//volta frame 
                }
            } else {
                objConVisRel = new TelaConsultaVisitaSocialReligiosa();
                TelaModuloPortarias.jPainelPortarias.add(objConVisRel);//adicona frame ao JDesktopPane  
                objConVisRel.setVisible(true);
            }
        }
        try {
            objConVisRel.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_VisitantesReligiososActionPerformed

    private void RolVistasReligiosasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolVistasReligiosasActionPerformed
        // TODO add your handling code here:
        if (objConRolRel == null || objConRolRel.isClosed()) {
            objConRolRel = new TelaConsultaRolVisitasReligiosas();
            jPainelPortarias.add(objConRolRel);
            objConRolRel.setVisible(true);
        } else {
            if (objConRolRel.isVisible()) {
                if (objConRolRel.isIcon()) { // Se esta minimizado
                    try {
                        objConRolRel.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConRolRel.toFront(); // traz para frente
                    objConRolRel.pack();//volta frame 
                }
            } else {
                objConRolRel = new TelaConsultaRolVisitasReligiosas();
                TelaModuloPortarias.jPainelPortarias.add(objConRolRel);//adicona frame ao JDesktopPane  
                objConRolRel.setVisible(true);
            }
        }
        try {
            objConRolRel.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RolVistasReligiosasActionPerformed

    private void EntradaSaidaVisitasReligiosasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaSaidaVisitasReligiosasActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaEntradaSaidaVisitasReligiosasManuP1) && codAbrirP1 == 1) {
            if (objEntSaiVisitaRel == null || objEntSaiVisitaRel.isClosed()) {
                objEntSaiVisitaRel = new TelaEntradaSaidaVisitasReligiosas();
                jPainelPortarias.add(objEntSaiVisitaRel);
                objEntSaiVisitaRel.setVisible(true);
            } else {
                if (objEntSaiVisitaRel.isVisible()) {
                    if (objEntSaiVisitaRel.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVisitaRel.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVisitaRel.toFront(); // traz para frente
                        objEntSaiVisitaRel.pack();//volta frame 
                    }
                } else {
                    objEntSaiVisitaRel = new TelaEntradaSaidaVisitasReligiosas();
                    TelaModuloPortarias.jPainelPortarias.add(objEntSaiVisitaRel);//adicona frame ao JDesktopPane  
                    objEntSaiVisitaRel.setVisible(true);
                }
            }
            try {
                objEntSaiVisitaRel.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntradaSaidaVisitasReligiosasActionPerformed

    private void InstituicaoReligiosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstituicaoReligiosaActionPerformed
        // TODO add your handling code here:
        if (objInstRel == null || objInstRel.isClosed()) {
            objInstRel = new TelaInstituicaoReligiosaPortarias();
            jPainelPortarias.add(objInstRel);
            objInstRel.setVisible(true);
        } else {
            if (objInstRel.isVisible()) {
                if (objInstRel.isIcon()) { // Se esta minimizado
                    try {
                        objInstRel.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInstRel.toFront(); // traz para frente
                    objInstRel.pack();//volta frame
                }
            } else {
                objInstRel = new TelaInstituicaoReligiosaPortarias();
                TelaModuloPortarias.jPainelPortarias.add(objInstRel);//adicona frame ao JDesktopPane
                objInstRel.setVisible(true);
            }
        }
        try {
            objInstRel.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InstituicaoReligiosaActionPerformed

    private void RelatorioEntradaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInterPort = new TelaRelatorioEntradas();
        TelaModuloPortarias.jPainelPortarias.add(objRelEntradaInterPort);
        objRelEntradaInterPort.show();
    }//GEN-LAST:event_RelatorioEntradaInternosActionPerformed

    private void ConsultaIsolamentoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaIsolamentoInternosActionPerformed
        // TODO add your handling code here:
        if (objConIsola == null || objConIsola.isClosed()) {
            objConIsola = new TelaConsultaInternosIsolamento();
            jPainelPortarias.add(objConIsola);
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
                TelaModuloPortarias.jPainelPortarias.add(objConIsola);//adicona frame ao JDesktopPane
                objConIsola.setVisible(true);
            }
        }
        try {
            objConIsola.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaIsolamentoInternosActionPerformed

    private void ConsultaRegistroVisitasPortariaExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaRegistroVisitasPortariaExtActionPerformed
        // TODO add your handling code here:
        if (objConRegVisita == null || objConRegVisita.isClosed()) {
            objConRegVisita = new TelaConsultaVisitasPortariaExterna();
            jPainelPortarias.add(objConRegVisita);
            objConRegVisita.setVisible(true);
        } else {
            if (objConRegVisita.isVisible()) {
                if (objConRegVisita.isIcon()) { // Se esta minimizado
                    try {
                        objConRegVisita.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConRegVisita.toFront(); // traz para frente
                    objConRegVisita.pack();//volta frame
                }
            } else {
                objConRegVisita = new TelaConsultaVisitasPortariaExterna();
                TelaModuloPortarias.jPainelPortarias.add(objConRegVisita);//adicona frame ao JDesktopPane
                objConRegVisita.setVisible(true);
            }
        }
        try {
            objConRegVisita.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }       
    }//GEN-LAST:event_ConsultaRegistroVisitasPortariaExtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem CadastroAdvogados;
    private javax.swing.JMenuItem CadastroPertences;
    private javax.swing.JMenuItem CadastroVeiculos;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem ConsultaAgendamentoEscolta;
    private javax.swing.JMenuItem ConsultaColaboradores;
    private javax.swing.JMenuItem ConsultaFamiliaresInternos;
    private javax.swing.JMenuItem ConsultaIsolamentoInternos;
    private javax.swing.JMenuItem ConsultaPopulacaoCarceraria;
    private javax.swing.JMenuItem ConsultaRegistroVisitasPortariaExt;
    private javax.swing.JMenuItem ConsultaRolVisitas;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu ControleAcessosInternos;
    private javax.swing.JMenu ControleAcessosPessoas;
    private javax.swing.JMenu ControleAcessosVeiculos;
    private javax.swing.JMenuItem ControleAssistenciaEducacional;
    private javax.swing.JMenuItem ControleDepositoInternos;
    private javax.swing.JMenuItem ControlePertences;
    private javax.swing.JMenuItem ControleVeiculoTerceiros;
    private javax.swing.JMenuItem ControleVeiculosCargas;
    private javax.swing.JMenuItem ControleVeiculosUnid;
    private javax.swing.JMenuItem EnSaiVisitasDiversas;
    private javax.swing.JMenuItem EntSaiAdvDepartamento;
    private javax.swing.JMenuItem EntSaiAdvogadosInternos;
    private javax.swing.JMenuItem EntSaiAtividadeLaborativa;
    private javax.swing.JMenuItem EntSaiVisitasInternos;
    private javax.swing.JMenuItem EntSaidColaborador;
    private javax.swing.JMenuItem EntradaSaidaOficialJusticaDepartamento;
    private javax.swing.JMenuItem EntradaSaidaOficialJusticaInternos;
    private javax.swing.JMenuItem EntradaSaidaVisitasReligiosas;
    private javax.swing.JMenuItem EntradasUnidade;
    private javax.swing.JMenuItem InstituicaoReligiosa;
    private javax.swing.JMenuItem ListagemEntradaPertences;
    private javax.swing.JMenuItem ListagemInternosRegimePenal;
    private javax.swing.JMenuItem LivroOcorrencias;
    private javax.swing.JMenuItem LocalInterno;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem OcorrenciaVisitasInternos;
    private javax.swing.JMenuItem RegistroNovaEntrada;
    private javax.swing.JMenuItem RegistroProntuarioInterno;
    private javax.swing.JMenuItem RegistrosSaidasInternos;
    private javax.swing.JMenuItem RelatorioAtividadeLaborativa;
    private javax.swing.JMenuItem RelatorioCadastroAdvogados;
    private javax.swing.JMenuItem RelatorioCadastroColaboradores;
    private javax.swing.JMenuItem RelatorioCadastroVeiculos;
    private javax.swing.JMenuItem RelatorioEntradaInternos;
    private javax.swing.JMenuItem RelatorioEntradaSaidaAdvogadosDepartamento;
    private javax.swing.JMenuItem RelatorioEntradaSaidaAdvogadosInternos;
    private javax.swing.JMenuItem RelatorioEntradaSaidaColaboradores;
    private javax.swing.JMenuItem RelatorioEntradaSaidaFuncDepto;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVeiculosCargas;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVeiculosTerceiros;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVisitas;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVistasInternos;
    private javax.swing.JMenuItem RelatorioIndisciplinarVisitasPortaria;
    private javax.swing.JMenuItem RelatorioOcorrencias;
    private javax.swing.JMenuItem RelatorioPrevisaoSaida;
    private javax.swing.JMenuItem RelatorioRetornosInternosUnidade;
    private javax.swing.JMenuItem RelatorioRolVisitas;
    private javax.swing.JMenuItem RelatorioSaidaInternosPortaria;
    private javax.swing.JMenuItem RelatorioValoresPortaria;
    private javax.swing.JMenuItem RelatorioVeiculosUnidade;
    private javax.swing.JMenuItem RelatorioVisitasDiversas;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem RetornoInternosUnidade;
    private javax.swing.JMenuItem RolVistasReligiosas;
    private javax.swing.JMenuItem VisitantesDiversos;
    private javax.swing.JMenuItem VisitantesReligiosos;
    private javax.swing.JMenuItem jEntradaSaidaInternasInternos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jOficialJustica;
    public static javax.swing.JDesktopPane jPainelPortarias;
    private javax.swing.JMenuItem jRegistroAcessosTransientes;
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
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado();
                verificarAgendaCompromisso();
                verificarSaidaInternos();
            }
        }, periodo, tempo);
    }

    // Executar programa externo da webcam
    public void webCam() {
        try {
            Process p = Runtime.getRuntime().exec("C:\\SysConp\\MyCam/MyCam.exe");
            if (p.exitValue() == 0) {
                System.out.println("Programa terminou normalmente");
            }
        } catch (Exception e) {
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
                // Abrir uma única tela, Tela de Recados Portaria
                if (objRecadosPort == null || objRecadosPort.isClosed()) {
                    objRecadosPort = new TelaRecadosPortaria();
                    jPainelPortarias.add(objRecadosPort);
                    objRecadosPort.setVisible(true);
                } else {
                    if (objRecadosPort.isVisible()) {
                        if (objRecadosPort.isIcon()) { // Se esta minimizado
                            try {
                                objRecadosPort.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecadosPort.toFront(); // traz para frente
                            objRecadosPort.pack();//volta frame 
                        }
                    } else {
                        objRecadosPort = new TelaRecadosPortaria();
                        TelaModuloPortarias.jPainelPortarias.add(objRecadosPort);//adicona frame ao JDesktopPane  
                        objRecadosPort.setVisible(true);
                    }
                }
                try {
                    objRecadosPort.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE USUARIOS.NomeUsuario='" + nameUser + "' "
                        + "AND AGENDARECADOS.StatusAgenda='" + statusAgenda + "'");
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
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.(AGENDA RECADOS)\nERRO: " + e);
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
        String[] Colunas = new String[]{"Código", " Data", " Remetente", " Destinatário"};
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
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                    + "WHERE UsuarioAgenda='" + nameUser + "' "
                    + "AND StatusAgenda='" + statusAgenda + "' "
                    + "AND DataLembrete='" + jDataSistema.getText() + "' "
                    + "AND HoraLembrete<='" + jHoraSistema.getText() + "'");
            conecta.rs.first();
            horaLembrete = conecta.rs.getString("HoraLembrete");
            usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
            codigoAgendaComp = conecta.rs.getString("IdAgenda");
            //
            if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                TelaModuloPortarias.jPainelPortarias.add(objAgendaComp);
                objAgendaComp.show();
                flag = 1;
                preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                        + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + jDataSistema.getText() + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText() + "' "
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
                                + "AND HoraLembrete<='" + jHoraSistema.getText() + "' "
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

    public void verificarSaidaInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSCRCPORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE SaidaConfirmada='" + repostaSaida + "'");
            conecta.rs.first();
            saidaConfirmada = conecta.rs.getString("SaidaConfirmada");
            if (saidaConfirmada.equals("Não")) {
                if (objSaidaPortaria == null || objSaidaPortaria.isClosed()) {
                    objSaidaPortaria = new TelaAlertaSaidaInternosPortaria();
                    TelaModuloPortarias.jPainelPortarias.add(objSaidaPortaria);
                    objSaidaPortaria.setVisible(true);
                } else {
                    if (objSaidaPortaria.isVisible()) {
                        if (objSaidaPortaria.isIcon()) { // Se esta minimizado
                            try {
                                objSaidaPortaria.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objSaidaPortaria.toFront(); // traz para frente
                            objSaidaPortaria.pack();//volta frame 
                        }
                    } else {
                        objSaidaPortaria = new TelaAlertaSaidaInternosPortaria();
                        TelaModuloPortarias.jPainelPortarias.add(objSaidaPortaria);;//adicona frame ao JDesktopPane  
                        objSaidaPortaria.setVisible(true);
                    }
                }
                try {
                    objSaidaPortaria.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            }
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroVeiculosManuP1 + "'");
            conecta.rs.first();
            pNomeCVPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroPertenccesManuP1 + "'");
            conecta.rs.first();
            pNomeCPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroAdvogadosManuP1 + "'");
            conecta.rs.first();
            pNomeCAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroVisitasDiversasManuP1 + "'");
            conecta.rs.first();
            pNomeCVDM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroOficialManuP1 + "'");
            conecta.rs.first();
            pNomeCOM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdIntManuP1 + "'");
            conecta.rs.first();
            pNomeESAIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdIntInterP1 + "'");
            conecta.rs.first();
            pNomeESAIMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdDEPManuP1 + "'");
            conecta.rs.first();
            pNomeESADM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdDEPADVP1 + "'");
            conecta.rs.first();
            pNomeESADMA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVisitasInternosManuP1 + "'");
            conecta.rs.first();
            pNomeESVIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVisitasInternosIntVisiP1 + "'");
            conecta.rs.first();
            pNomeESVIMIV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVisitasInternasRIManuP1 + "'");
            conecta.rs.first();
            pNomeESVIAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVisitasInternasIntRIVisiP1 + "'");
            conecta.rs.first();
            pNomeESVIAMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVisitasReligiosasManuP1 + "'");
            conecta.rs.first();
            pNomeESVRM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVisitasReligiosasVisiP1 + "'");
            conecta.rs.first();
            pNomeESVRV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdIntManuP1 + "'");
            conecta.rs.first();
            pNomeESAIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdIntInterP1 + "'");
            conecta.rs.first();
            pNomeESAIMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaOFJManuP1 + "'");
            conecta.rs.first();
            pNomeESOFJM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaOFJInteP1 + "'");
            conecta.rs.first();
            pNomeESOFJI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaOJManuP1 + "'");
            conecta.rs.first();
            pNomeESOJMP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaOJDepP1 + "'");
            conecta.rs.first();
            pNomeESOJDP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVDManuP1 + "'");
            conecta.rs.first();
            pNomeESVDM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVDVDP1 + "'");
            conecta.rs.first();
            pNomeESVDV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaCOLManuP1 + "'");
            conecta.rs.first();
            pNomeESCM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaCOLcolP1 + "'");
            conecta.rs.first();
            pNomeESCC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaCOLBioP1 + "'");
            conecta.rs.first();
            pNomeESCB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAcessosPortariaManuP1 + "'");
            conecta.rs.first();
            pNomeAPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAcessosPortariaTranP1 + "'");
            conecta.rs.first();
            pNomeAPT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVUManuP1 + "'");
            conecta.rs.first();
            pNomeESVUM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVUVP1 + "'");
            conecta.rs.first();
            pNomeESVUV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVCManuP1 + "'");
            conecta.rs.first();
            pNomeESVCP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVCVP1 + "'");
            conecta.rs.first();
            pNomeESVCVP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVTManuP1 + "'");
            conecta.rs.first();
            pNomeESVT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVTVP1 + "'");
            conecta.rs.first();
            pNomeESVTV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaLABManuP1 + "'");
            conecta.rs.first();
            pNomeESLM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaLABIntP1 + "'");
            conecta.rs.first();
            pNomeESLMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESIEEManuP1 + "'");
            conecta.rs.first();
            pNomeESIEEM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESIEEIP1 + "'");
            conecta.rs.first();
            pNomeESIEEI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroRetornoRIManuP1 + "'");
            conecta.rs.first();
            pNomeRRIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroRetornoRIIntP1 + "'");
            conecta.rs.first();
            pNomeRRII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroRetornoRIBioP1 + "'");
            conecta.rs.first();
            pNomeRRIB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaInternoUniPRIManuP1 + "'");
            conecta.rs.first();
            pNomeEIUPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaInternoUniPRIIntP1 + "'");
            conecta.rs.first();
            pNomeEIUPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaNovaEntradaManuP1 + "'");
            conecta.rs.first();
            pNomeNEM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaNovaEntradaIntP1 + "'");
            conecta.rs.first();
            pNomeNEI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroSaidaInternoManuP1 + "'");
            conecta.rs.first();
            pNomeRSIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroSaidaInternoIntP1 + "'");
            conecta.rs.first();
            pNomeRSII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroSaidaInternoBioP1 + "'");
            conecta.rs.first();
            pNomeRSIB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroSaidaInternoExpP1 + "'");
            conecta.rs.first();
            pNomeRSIE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAManuP1 + "'");
            conecta.rs.first();
            pNomeRRIB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAIntP1 + "'");
            conecta.rs.first();
            pNomeESAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaPertencesInternosManuP1 + "'");
            conecta.rs.first();
            pNomeEPIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaPertencesInternosIntP1 + "'");
            conecta.rs.first();
            pNomeEPII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDepositoInternosManuP1 + "'");
            conecta.rs.first();
            pNomeDIManu = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDepositoInternosIntP1 + "'");
            conecta.rs.first();
            pNomeDIInt = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaManuP1 + "'");
            conecta.rs.first();
            pNomeOCR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaDisciplinaVisitasManuP1 + "'");
            conecta.rs.first();
            pNomeOCDVM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaDisciplinaVisitasVisiP1 + "'");
            conecta.rs.first();
            pNomeOCDVV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaDisciplinaVisitasOcorP1 + "'");
            conecta.rs.first();
            pNomeOCDVO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //RELATÓRIOS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRelatorioPrevisaoSaidaP1 + "'");
            conecta.rs.first();
            pNomeRPSI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CADASTRO
        if (!pNomeCVPM.equals(telaCadastroVeiculosManuP1) || pNomeCVPM == null || pNomeCVPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroVeiculosManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCPM.equals(telaCadastroPertenccesManuP1) || pNomeCPM == null || pNomeCPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroPertenccesManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAM.equals(telaCadastroAdvogadosManuP1) || pNomeCAM == null || pNomeCAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroAdvogadosManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAM.equals(telaCadastroVisitasDiversasManuP1) || pNomeCAM == null || pNomeCAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroVisitasDiversasManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCOM.equals(telaCadastroOficialManuP1) || pNomeCOM == null || pNomeCOM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroOficialManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeESVIM.equals(telaEntradaSaidaVisitasInternosManuP1) || pNomeESVIM == null || pNomeESVIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroVisitasDiversasManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVIMIV.equals(telaEntradaSaidaVisitasInternosIntVisiP1) || pNomeESVIMIV == null || pNomeESVIMIV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVisitasInternosIntVisiP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVIAM.equals(telaEntradaSaidaVisitasInternasRIManuP1) || pNomeESVIAM == null || pNomeESVIAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVisitasInternasRIManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVIAMI.equals(telaEntradaSaidaVisitasInternasIntRIVisiP1) || pNomeESVIAMI == null || pNomeESVIAMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVisitasInternasIntRIVisiP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVRM.equals(telaEntradaSaidaVisitasReligiosasManuP1) || pNomeESVRM == null || pNomeESVRM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVisitasReligiosasManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVRV.equals(telaEntradaSaidaVisitasReligiosasVisiP1) || pNomeESVRV == null || pNomeESVRV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVisitasReligiosasVisiP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESAIM.equals(telaEntradaSaidaAdIntManuP1) || pNomeESAIM == null || pNomeESAIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAdIntManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESAIMI.equals(telaEntradaSaidaAdIntInterP1) || pNomeESAIMI == null || pNomeESAIMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAdIntInterP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESADM.equals(telaEntradaSaidaAdDEPManuP1) || pNomeESADM == null || pNomeESADM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAdDEPManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESADMA.equals(telaEntradaSaidaAdDEPADVP1) || pNomeESADMA == null || pNomeESADMA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAdIntInterP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESOFJM.equals(telaEntradaSaidaOFJManuP1) || pNomeESOFJM == null || pNomeESOFJM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaOFJManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESOFJI.equals(telaEntradaSaidaOFJInteP1) || pNomeESOFJI == null || pNomeESOFJI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaOFJInteP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESOJMP1.equals(telaEntradaSaidaOJManuP1) || pNomeESOJMP1 == null || pNomeESOJMP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaOJManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESOJDP1.equals(telaEntradaSaidaOJDepP1) || pNomeESOJDP1 == null || pNomeESOJDP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaOJDepP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVDM.equals(telaEntradaSaidaVDManuP1) || pNomeESVDM == null || pNomeESVDM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVDManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVDV.equals(telaEntradaSaidaVDVDP1) || pNomeESVDV == null || pNomeESVDV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVDVDP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCM.equals(telaEntradaSaidaCOLManuP1) || pNomeESCM == null || pNomeESCM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaCOLManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCC.equals(telaEntradaSaidaCOLcolP1) || pNomeESCC == null || pNomeESCC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaCOLcolP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCB.equals(telaEntradaSaidaCOLBioP1) || pNomeESCB == null || pNomeESCB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaCOLBioP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPM.equals(telaAcessosPortariaManuP1) || pNomeAPM == null || pNomeAPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAcessosPortariaManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPT.equals(telaAcessosPortariaTranP1) || pNomeAPT == null || pNomeAPT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAcessosPortariaTranP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVUM.equals(telaEntradaSaidaVUManuP1) || pNomeESVUM == null || pNomeESVUM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVUManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVUV.equals(telaEntradaSaidaVUVP1) || pNomeESVUV == null || pNomeESVUV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVUVP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVCP1.equals(telaEntradaSaidaESVCManuP1) || pNomeESVCP1 == null || pNomeESVCP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVCManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVCVP1.equals(telaEntradaSaidaESVCVP1) || pNomeESVCVP1 == null || pNomeESVCVP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVCVP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVT.equals(telaEntradaSaidaESVTManuP1) || pNomeESVT == null || pNomeESVT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVCManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVTV.equals(telaEntradaSaidaESVTVP1) || pNomeESVTV == null || pNomeESVTV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVCVP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESLM.equals(telaEntradaSaidaLABManuP1) || pNomeESLM == null || pNomeESLM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaLABManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESLMI.equals(telaEntradaSaidaLABIntP1) || pNomeESLMI == null || pNomeESLMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaLABIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESIEEM.equals(telaEntradaSaidaESIEEManuP1) || pNomeESIEEM == null || pNomeESIEEM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESIEEManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESIEEI.equals(telaEntradaSaidaESIEEIP1) || pNomeESIEEI == null || pNomeESIEEI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESIEEIP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRRIM.equals(telaRegistroRetornoRIManuP1) || pNomeRRIM == null || pNomeRRIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroRetornoRIManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRRII.equals(telaRegistroRetornoRIIntP1) || pNomeRRII == null || pNomeRRII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroRetornoRIIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRRIB.equals(telaRegistroRetornoRIBioP1) || pNomeRRIB == null || pNomeRRIB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroRetornoRIBioP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEIUPM.equals(telaEntradaInternoUniPRIManuP1) || pNomeEIUPM == null || pNomeEIUPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaInternoUniPRIManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEIUPI.equals(telaEntradaInternoUniPRIIntP1) || pNomeEIUPI == null || pNomeEIUPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaInternoUniPRIIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeNEM.equals(telaNovaEntradaManuP1) || pNomeNEM == null || pNomeNEM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaNovaEntradaManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeNEI.equals(telaNovaEntradaIntP1) || pNomeNEI == null || pNomeNEI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaNovaEntradaIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRSIM.equals(telaRegistroSaidaInternoManuP1) || pNomeRSIM == null || pNomeRSIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroSaidaInternoManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRSII.equals(telaRegistroSaidaInternoIntP1) || pNomeRSII == null || pNomeRSII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroSaidaInternoIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRSIB.equals(telaRegistroSaidaInternoBioP1) || pNomeRSIB == null || pNomeRSIB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroSaidaInternoBioP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRSIE.equals(telaRegistroSaidaInternoExpP1) || pNomeRSIE == null || pNomeRSIE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroSaidaInternoExpP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRRIB.equals(telaEntradaSaidaAManuP1) || pNomeRRIB == null || pNomeRRIB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESAI.equals(telaEntradaSaidaAIntP1) || pNomeESAI == null || pNomeESAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEPIM.equals(telaEntradaPertencesInternosManuP1) || pNomeEPIM == null || pNomeEPIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaPertencesInternosManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEPII.equals(telaEntradaPertencesInternosIntP1) || pNomeEPII == null || pNomeEPII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaPertencesInternosIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDIManu.equals(telaDepositoInternosManuP1) || pNomeDIManu == null || pNomeDIManu.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDepositoInternosManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDIInt.equals(telaDepositoInternosIntP1) || pNomeDIInt == null || pNomeDIInt.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDepositoInternosIntP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCR.equals(telaOcorrenciaManuP1) || pNomeOCR == null || pNomeOCR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCDVM.equals(telaOcorrenciaDisciplinaVisitasManuP1) || pNomeOCDVM == null || pNomeOCDVM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaDisciplinaVisitasManuP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCDVV.equals(telaOcorrenciaDisciplinaVisitasVisiP1) || pNomeOCDVV == null || pNomeOCDVV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaDisciplinaVisitasVisiP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCDVO.equals(telaOcorrenciaDisciplinaVisitasOcorP1) || pNomeOCDVO == null || pNomeOCDVO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaDisciplinaVisitasOcorP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //RELATÓRIOS            
        if (!pNomeRPSI.equals(telaRelatorioPrevisaoSaidaP1) || pNomeRPSI == null || pNomeRPSI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRelatorioPrevisaoSaidaP1);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloP1 + "'");
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
            codigoUserP1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1 + "'");
            conecta.rs.first();
            codigoUserGroupP1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1 = conecta.rs.getInt("IdUsuario");
            codAbrirP1 = conecta.rs.getInt("Abrir");
            codIncluirP1 = conecta.rs.getInt("Incluir");
            codAlterarP1 = conecta.rs.getInt("Alterar");
            codExcluirP1 = conecta.rs.getInt("Excluir");
            codGravarP1 = conecta.rs.getInt("Gravar");
            codConsultarP1 = conecta.rs.getInt("Consultar");
            nomeTelaP1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
    // T4ela de Consulta de internos portaria
    //TelaConsultaSaidaInternos();
}
