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
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
//import static gestor.Visao.TelaModuloServicoSocial.codAbrirSS;
import static gestor.Visao.TelaModuloServicoSocial.codUserAcessoSS;
import static gestor.Visao.TelaModuloServicoSocial.codigoUserSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeGrupoSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeTelaSS;
//import static gestor.Visao.TelaModuloServicoSocial.telaPAISS;
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
public class TelaModuloTerapiaOcupacional extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    private TelaEmpresasLaborativas objEmpLab = null;
    private TelaListaEsperaTO objListaEsperaLab = null;
    private TelaListaPassagemInternos objAgendaLabor = null;
    private TelaConsultaLocalInterno objLocalInter = null;
    private TelaConsultaProntuarioInternoCrc objConsInter = null;
    private TelaMovHistoricoTecTerapiaOcupacional objMovHistTerapia = null;
    private TelaEntradaSaidaEmpresaLabor objFichaAtvLabor = null;
    private TelaRecadosTerapiaOcupacional objRecadoTeraOcu = null;
    private TelaAtendimentoTerapiaOcupacional objAtendTera = null;
    private TelaOcorrenciaTerapiaOcupacional objOcorreTeraOcupa = null;
    private TelaFrequenciaMensalInternosTO objFreqMen = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaTriagemTerapiaOcupacional objTriagemOcupa = null;
    private TelaPerfilCarcerarioTerapiaOcupacional objPerfilCarrTO = null;
    private TelaPAI_NOVO objPaiTO = null;
    private TelaCursosDiversosTerapiaOcupacional objCursosTO = null;
    private TelaProfissoes objProf = null;
    private TelaOcupacoes objOcupa = null;
    private TelaMovimentacaoCrcTO objMovCrcTo = null;
    private TelaRegistroInternosAtendimentoTO objRegInt = null;
    private TelaRegistroInternosAtendimentoImpressoTO objRegAtenImp = null;
    //
    public static String nomeModuloTERA = "TERAPIA";
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    String tipoEmpresa = "Interna";
    String tipoEmpresaExt = "Externa";
    String statusInterno = "Ativo";
    String dataInicial, dataFinal;
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
    //
    String pCnc = "";
    String statusEntrada = "ENTRADA NA UNIDADE";
    String statusRetorno = "RETORNO A UNIDADE";
    //
    public static int codigoUserTO = 0;
    public static int codUserAcessoTO = 0;
    public static int codigoUserGroupTO = 0;
    public static int codAbrirTO = 0;
    public static int codIncluirTO = 0;
    public static int codAlterarTO = 0;
    public static int codExcluirTO = 0;
    public static int codGravarTO = 0;
    public static int codConsultarTO = 0;
    public static int codigoGrupoTO = 0;
    public static String nomeGrupoTO = "";
    public static String nomeTelaTO = "";
    //
    public static String nomeModuloTO = "TERAPIA OCUPACIONAL";
    // MENU CADASTRO
    public static String telaEmpresasLabManuTO = "Cadastro:Empresas Laborativas:Manutenção";
    //
    public static String telaFichaAtividadeLabManuTO = "Cadastro:Ficha Atividade Laborativa:Manutenção";
    public static String telaFichaAtividadeLabIntTO = "Cadastro:Ficha Atividade Laborativa:Internos";
    //
    public static String telaProfissoesManuTO = "Cadastro:Profissões:Manutenção";
    //
    public static String telaOcupacoesManuTO = "Cadastro:Ocupações:Manutenção";
    //
    public static String telaCursosDiversosManuTO = "Cadastro:Cursos Diversos:Manutenção";
    //
    public static String telaListaEsperaManuTO = "Cadastro:Lista de Espera de Internos:Manutenção";
    public static String telaListaEsperaIntTO = "Cadastro:Lista de Espera de Internos:Internos";
    //
    public static String telaListaPassagemManuTO = "Cadastro:Lista de Passagem:Manutenção";
    public static String telaListaPassagemIntTO = "Cadastro:Lista de Passagem:Internos";
    // REGISTRO DE ATENDIMENTO INTERNOS BIOMETRIA
    public static String telaRegistroIntAtendTO = "Cadastro:Registro de Atendimento de Internos TO:Biometria";
    public static String telaRegistroIntAtendInciarLeitorTO = "Cadastro:Registro Atendendimento Internos TO:Inciar Leitor";
    // REGSTRO DE ATENDIMENTO IMPRESSO COM AUTORIZAÇÃO
    public static String telaRegistroAtenImpTO = "Cadastro:Registro Atendimento Impresso TO:Manutenção";
    public static String telaRegistroLibAtenImpTO = "Cadastro:Registro Atendimento Impresso Liberação TO:Liberação";
    // MENU MOVIMENTAÇÃO
    public static String telaTriagemOcupacionalManuTO = "Movimentação:Triagem Ocupacional Internos:Manutenção";
    // ATENDIMENTO TERAPIA OCUPACIONAL
    public static String telaAtendimentoInternoManuTO = "Movimentação:Atendimento Internos:Manutenção";
    public static String telaAtendimentoInternoAvaITO = "Movimentação:Atendimento Internos:Avaliação I";
    public static String telaAtendimentoInternoAvaIITO = "Movimentação:Atendimento Internos:Avaliação II";
    public static String telaAtendimentoInternoHistEduTO = "Movimentação:Atendimento Internos:Histórico Educacional";
    public static String telaAtendimentoInternoHistLabTO = "Movimentação:Atendimento Internos:Histórico Laborativo";
    public static String telaAtendimentoInternoEvolTO = "Movimentação:Evolução Atendimento:Internos";
    // FREQUENCIA EXTERNA
    public static String telaFrequenciaMensalExternaManuTO = "Movimentação:Frequência Mensal Externa de Internos TO-I:Manutenção";
    public static String telaFrequenciaMensalExternaIntTO = "Movimentação:Frequência Mensal Externa de Internos TO-II:Internos";
    // PERFIL CARCERÁRIO
    public static String telaPerfilCarcerarioManuTO = "Movimentação:Perfil Carcerário TO-I:Manutenção";
    public static String telaPerfilCarcerarioPerfilTO = "Movimentação:Perfil Carcerário TO-II:Perfil Carcerário";    
     //P.A.I. - CADASTRADO NO SERVIÇO SOCIAL
    public static String telaPAISS_TO = "Movimentação:P.A.I. - Serviços Social:Manutenção";
    public static String telaPaiCCGF_TO = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social";
    public static String telaPaiCCGFFam_TO = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social:Familia";
    public static String telaPaiCCGFVis_TO = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social:Visita";
    public static String telaPaiCCGFVisInt_TO = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social:Visita Intima";
    public static String telaPaiDEME_TO = "Movimentação:P.A.I.:D.E.M.E. - Serviços Social";
    public static String telaPaiDPTL_TO = "Movimentação:P.A.I.:D.P.T.L. - Serviços Social";
    public static String telaPaiDJ_TO = "Movimentação:P.A.I.:D.J. - Serviços Social";
    public static String telaPaiDS_TO = "Movimentação:P.A.I.:D.S. - Serviços Social";
    public static String telaPaiEAPI1_TO = "Movimentação:P.A.I.:E.A.P.I.-1 - Serviços Social";
    public static String telaPaiEAPI2_TO = "Movimentação:P.A.I.:E.A.P.I.-2 - Serviços Social";
    public static String telaPaiEPAI_TO = "Movimentação:P.A.I.:E-PAI - Serviços Social";
    // OCORRENCIA
    public static String telaOcorrenciaTO = "Movimentação:Ocorrências Diárias TO:Manutenção";
    // MENU CADASTRO
    String pNomeELB_TO = "";
    //
    String pNomeFALM_TO = "";
    String pNomeFALI_TO = "";
    //
    String pNomePM_TO = "";
    //
    String pNomeOM_TO = "";
    //
    String pNomeCD_TO = "";
    //
    String pNomeLEM_TO = "";
    String pNomeLEI_TO = "";
    //
    String pNomeLPM_TO = "";
    String pNomeLPI_TO = "";
    // REGISTRO ATENDIMENTO INTERNO - MANUTENÇÃO
    String pNomeRAI_TO = "";
    String pNomeRAIIL_TO = "";
    // REGISTRO ATENDIMENTO INTERNO - IMPRESSÃO
    String pNomeRAIM_TO = "";
    String pNomeRAIL_TO = "";
    // MOVIMENTAÇÃO
    // TRIAGEM
    String pNomeTOM_TO = "";
    //
    String pNomeFMEM_TO = "";
    //  ATENDIMENTO TERAPIA OCUPACIONAL
    String pNomeAIM_TO = "";
    String pNomeAIAI_TO = "";
    String pNomeAIAII_TO = "";
    String pNomeAIHE_TO = "";
    String pNomeAIHL_TO = "";
    String pNomeAIE_TO = "";
    //FREQUENCIA MENSAL
    String pNomeFMEI_TO = "";
    // PERFIL CARCERÁRIO
    String pNomePCM_TO = "";
    String pNomePCP_TO = "";
    // PAI TEM ACESSO CONTROLADO A PARTIR DO MÓDULO DO SERVIÇO SOCIAL    
    // OCORRENCIA
    String pNomeO_TO = "";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO

    /**
     * Creates new form TelaTerapia
     */
    public TelaModuloTerapiaOcupacional() {
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

        jPainelTerapia = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        EmpresasLaborativas = new javax.swing.JMenuItem();
        FichaAtividadeLaborativa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        Profissoes = new javax.swing.JMenuItem();
        Ocupacoes = new javax.swing.JMenuItem();
        CursosProfissionalizantes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        ListaEsperaTO = new javax.swing.JMenuItem();
        ListaPassagemInternos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        RegistroAtendimentoBiografia = new javax.swing.JMenuItem();
        RegistroAtendimentoPorImpressao = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        HistoricoMovimentacaoTecnica = new javax.swing.JMenuItem();
        jHistoricoMovimentacaoExterna = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        TriagemOcupacional = new javax.swing.JMenuItem();
        AtendimentoLaborativo = new javax.swing.JMenuItem();
        ControleDiasTrabalhados = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jPerfilCarcerario = new javax.swing.JMenuItem();
        PAI_NOVO = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        OcorrenciasLaborativa = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        RelatorioConfere = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        RelatorioListaInterna = new javax.swing.JMenuItem();
        RelatorioListaExterna = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        RelatorioFichaLaborativa = new javax.swing.JMenuItem();
        AtivaLaborativaExterna = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        RelatorioInternosCNC = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Terapia Ocupacional :::...");

        jPainelTerapia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelTerapia.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelTerapiaLayout = new javax.swing.GroupLayout(jPainelTerapia);
        jPainelTerapia.setLayout(jPainelTerapiaLayout);
        jPainelTerapiaLayout.setHorizontalGroup(
            jPainelTerapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelTerapiaLayout.setVerticalGroup(
            jPainelTerapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelTerapiaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        EmpresasLaborativas.setText("Empresas Laborativas");
        EmpresasLaborativas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpresasLaborativasActionPerformed(evt);
            }
        });
        jMenu1.add(EmpresasLaborativas);

        FichaAtividadeLaborativa.setText("Ficha de Atividade Laborativa");
        FichaAtividadeLaborativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FichaAtividadeLaborativaActionPerformed(evt);
            }
        });
        jMenu1.add(FichaAtividadeLaborativa);
        jMenu1.add(jSeparator1);

        jMenu8.setText("Profissões/Ocupações");

        Profissoes.setText("Profissões");
        Profissoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfissoesActionPerformed(evt);
            }
        });
        jMenu8.add(Profissoes);

        Ocupacoes.setText("Ocupações");
        Ocupacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcupacoesActionPerformed(evt);
            }
        });
        jMenu8.add(Ocupacoes);

        jMenu1.add(jMenu8);

        CursosProfissionalizantes.setText("Cursos Profissionalizantes");
        CursosProfissionalizantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursosProfissionalizantesActionPerformed(evt);
            }
        });
        jMenu1.add(CursosProfissionalizantes);
        jMenu1.add(jSeparator4);

        ListaEsperaTO.setText("Lista de Espera Laborativa");
        ListaEsperaTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaEsperaTOActionPerformed(evt);
            }
        });
        jMenu1.add(ListaEsperaTO);

        ListaPassagemInternos.setText("Lista de Passagem de Internos");
        ListaPassagemInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemInternosActionPerformed(evt);
            }
        });
        jMenu1.add(ListaPassagemInternos);
        jMenu1.add(jSeparator2);

        jMenu9.setForeground(new java.awt.Color(0, 102, 0));
        jMenu9.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        RegistroAtendimentoBiografia.setForeground(new java.awt.Color(204, 0, 0));
        RegistroAtendimentoBiografia.setText("Registrar  Atendimento por Biometria");
        RegistroAtendimentoBiografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoBiografiaActionPerformed(evt);
            }
        });
        jMenu9.add(RegistroAtendimentoBiografia);

        RegistroAtendimentoPorImpressao.setForeground(new java.awt.Color(0, 0, 204));
        RegistroAtendimentoPorImpressao.setText("Registro Atendimento por Impressão");
        RegistroAtendimentoPorImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoPorImpressaoActionPerformed(evt);
            }
        });
        jMenu9.add(RegistroAtendimentoPorImpressao);

        jMenu1.add(jMenu9);
        jMenu1.add(jSeparator11);

        AgendaCompromisso.setText("Agenda de Compromissos Pessoal");
        AgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaCompromisso);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaRecados);
        jMenu1.add(jSeparator10);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        jMenu1.add(Sair);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Consultas");

        jMenuItem4.setText("Prontuários de Internos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Localização de Internos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);
        jMenu4.add(jSeparator7);

        HistoricoMovimentacaoTecnica.setText("Histórico de Movimentação de Internos");
        HistoricoMovimentacaoTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovimentacaoTecnicaActionPerformed(evt);
            }
        });
        jMenu4.add(HistoricoMovimentacaoTecnica);

        jHistoricoMovimentacaoExterna.setText("Histórico de Movimentação de Internos Externa");
        jHistoricoMovimentacaoExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHistoricoMovimentacaoExternaActionPerformed(evt);
            }
        });
        jMenu4.add(jHistoricoMovimentacaoExterna);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Movimentação");

        TriagemOcupacional.setText("Triagem Ocupacional");
        TriagemOcupacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TriagemOcupacionalActionPerformed(evt);
            }
        });
        jMenu2.add(TriagemOcupacional);

        AtendimentoLaborativo.setText("Admissão/Evolução Laborativa");
        AtendimentoLaborativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoLaborativoActionPerformed(evt);
            }
        });
        jMenu2.add(AtendimentoLaborativo);

        ControleDiasTrabalhados.setText("Controle de Dias Trabalhados");
        ControleDiasTrabalhados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleDiasTrabalhadosActionPerformed(evt);
            }
        });
        jMenu2.add(ControleDiasTrabalhados);
        jMenu2.add(jSeparator3);

        jPerfilCarcerario.setForeground(new java.awt.Color(255, 0, 0));
        jPerfilCarcerario.setText("Perfil da População Carcerária");
        jPerfilCarcerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPerfilCarcerarioActionPerformed(evt);
            }
        });
        jMenu2.add(jPerfilCarcerario);

        PAI_NOVO.setForeground(new java.awt.Color(0, 0, 255));
        PAI_NOVO.setText("P.A.I. - Programa de Assitência Individual");
        PAI_NOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAI_NOVOActionPerformed(evt);
            }
        });
        jMenu2.add(PAI_NOVO);
        jMenu2.add(jSeparator6);

        OcorrenciasLaborativa.setText("Livro de Ocorrências");
        OcorrenciasLaborativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcorrenciasLaborativaActionPerformed(evt);
            }
        });
        jMenu2.add(OcorrenciasLaborativa);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        jMenuItem2.setText("Relatório de Previsão de Saída de Internos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu5.setText("Relatórios de Confere");

        jMenuItem3.setText("Relatório Geral de Internos no Pavilhão/Celas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        RelatorioConfere.setText("Relatório de Confere por Cela");
        RelatorioConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioConfereActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioConfere);

        jMenu3.add(jMenu5);
        jMenu3.add(jSeparator5);

        jMenu6.setText("Relatório de Lista de Passagem");

        RelatorioListaInterna.setText("Relatório de Lista de Passagem Empresa Internas");
        RelatorioListaInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioListaInternaActionPerformed(evt);
            }
        });
        jMenu6.add(RelatorioListaInterna);

        RelatorioListaExterna.setText("Relatório de Lista de Passagem Empresa Externas");
        RelatorioListaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioListaExternaActionPerformed(evt);
            }
        });
        jMenu6.add(RelatorioListaExterna);

        jMenu3.add(jMenu6);

        jMenu7.setText("Relatórios de Atividades Laborativas");

        RelatorioFichaLaborativa.setText("Ficha Atividade Laborativa");
        RelatorioFichaLaborativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioFichaLaborativaActionPerformed(evt);
            }
        });
        jMenu7.add(RelatorioFichaLaborativa);

        AtivaLaborativaExterna.setText("Atividade laborativa Externa (Frequência)");
        AtivaLaborativaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtivaLaborativaExternaActionPerformed(evt);
            }
        });
        jMenu7.add(AtivaLaborativaExterna);

        jMenu3.add(jMenu7);

        jMenuItem6.setText("Relatório Quantitativo de Atividade Laborativa");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator8);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaInternosUnidade);
        jMenu3.add(jSeparator9);

        RelatorioInternosCNC.setForeground(new java.awt.Color(204, 0, 0));
        RelatorioInternosCNC.setText("Relatório de Internos com CNC");
        RelatorioInternosCNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosCNCActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioInternosCNC);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelTerapia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelTerapia)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void EmpresasLaborativasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpresasLaborativasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmpresasLabManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaEmpresasLabManuTO) && codAbrirTO == 1) {
            if (objEmpLab == null || objEmpLab.isClosed()) {
                objEmpLab = new TelaEmpresasLaborativas();
                jPainelTerapia.add(objEmpLab);
                objEmpLab.setVisible(true);
            } else {
                if (objEmpLab.isVisible()) {
                    if (objEmpLab.isIcon()) { // Se esta minimizado
                        try {
                            objEmpLab.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEmpLab.toFront(); // traz para frente
                        objEmpLab.pack();//volta frame 
                    }
                } else {
                    objEmpLab = new TelaEmpresasLaborativas();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objEmpLab);//adicona frame ao JDesktopPane  
                    objEmpLab.setVisible(true);
                }
            }
            try {
                objEmpLab.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EmpresasLaborativasActionPerformed

    private void ListaPassagemInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaListaPassagemManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaListaPassagemManuTO) && codAbrirTO == 1) {
            if (objAgendaLabor == null || objAgendaLabor.isClosed()) {
                objAgendaLabor = new TelaListaPassagemInternos();
                jPainelTerapia.add(objAgendaLabor);
                objAgendaLabor.setVisible(true);
            } else {
                if (objAgendaLabor.isVisible()) {
                    if (objAgendaLabor.isIcon()) { // Se esta minimizado
                        try {
                            objAgendaLabor.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAgendaLabor.toFront(); // traz para frente
                        objAgendaLabor.pack();//volta frame 
                    }
                } else {
                    objAgendaLabor = new TelaListaPassagemInternos();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objAgendaLabor);//adicona frame ao JDesktopPane  
                    objAgendaLabor.setVisible(true);
                }
            }
            try {
                objAgendaLabor.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ListaPassagemInternosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if (objLocalInter == null || objLocalInter.isClosed()) {
            objLocalInter = new TelaConsultaLocalInterno();
            jPainelTerapia.add(objLocalInter);
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
                objLocalInter = new TelaConsultaLocalInterno();
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objLocalInter);//adicona frame ao JDesktopPane  
                objLocalInter.setVisible(true);
            }
        }
        try {
            objLocalInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (objConsInter == null || objConsInter.isClosed()) {
            objConsInter = new TelaConsultaProntuarioInternoCrc();
            jPainelTerapia.add(objConsInter);
            objConsInter.setVisible(true);
        } else {
            if (objConsInter.isVisible()) {
                if (objConsInter.isIcon()) { // Se esta minimizado
                    try {
                        objConsInter.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsInter.toFront(); // traz para frente
                    objConsInter.pack();//volta frame 
                }
            } else {
                objConsInter = new TelaConsultaProntuarioInternoCrc();
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objConsInter);//adicona frame ao JDesktopPane  
                objConsInter.setVisible(true);
            }
        }
        try {
            objConsInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void ListaEsperaTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaEsperaTOActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaListaEsperaManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaListaEsperaManuTO) && codAbrirTO == 1) {
            if (objListaEsperaLab == null || objListaEsperaLab.isClosed()) {
                objListaEsperaLab = new TelaListaEsperaTO();
                jPainelTerapia.add(objListaEsperaLab);
                objListaEsperaLab.setVisible(true);
            } else {
                if (objListaEsperaLab.isVisible()) {
                    if (objListaEsperaLab.isIcon()) { // Se esta minimizado
                        try {
                            objListaEsperaLab.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objListaEsperaLab.toFront(); // traz para frente
                        objListaEsperaLab.pack();//volta frame 
                    }
                } else {
                    objListaEsperaLab = new TelaListaEsperaTO();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objListaEsperaLab);//adicona frame ao JDesktopPane  
                    objListaEsperaLab.setVisible(true);
                }
            }
            try {
                objListaEsperaLab.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ListaEsperaTOActionPerformed

    private void HistoricoMovimentacaoTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovimentacaoTecnicaActionPerformed
        // TODO add your handling code here:
        if (objMovHistTerapia == null || objMovHistTerapia.isClosed()) {
            objMovHistTerapia = new TelaMovHistoricoTecTerapiaOcupacional();
            jPainelTerapia.add(objMovHistTerapia);
            objMovHistTerapia.setVisible(true);
        } else {
            if (objMovHistTerapia.isVisible()) {
                if (objMovHistTerapia.isIcon()) { // Se esta minimizado
                    try {
                        objMovHistTerapia.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMovHistTerapia.toFront(); // traz para frente
                    objMovHistTerapia.pack();//volta frame 
                }
            } else {
                objMovHistTerapia = new TelaMovHistoricoTecTerapiaOcupacional();
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objMovHistTerapia);//adicona frame ao JDesktopPane  
                objMovHistTerapia.setVisible(true);
            }
        }
        try {
            objMovHistTerapia.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoTecnicaActionPerformed

    private void FichaAtividadeLaborativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FichaAtividadeLaborativaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFichaAtividadeLabManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFichaAtividadeLabManuTO) && codAbrirTO == 1) {
            if (objFichaAtvLabor == null || objFichaAtvLabor.isClosed()) {
                objFichaAtvLabor = new TelaEntradaSaidaEmpresaLabor();
                jPainelTerapia.add(objFichaAtvLabor);
                objFichaAtvLabor.setVisible(true);
            } else {
                if (objFichaAtvLabor.isVisible()) {
                    if (objFichaAtvLabor.isIcon()) { // Se esta minimizado
                        try {
                            objFichaAtvLabor.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objFichaAtvLabor.toFront(); // traz para frente
                        objFichaAtvLabor.pack();//volta frame 
                    }
                } else {
                    objFichaAtvLabor = new TelaEntradaSaidaEmpresaLabor();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objFichaAtvLabor);//adicona frame ao JDesktopPane  
                    objFichaAtvLabor.setVisible(true);
                }
            }
            try {
                objFichaAtvLabor.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_FichaAtividadeLaborativaActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecadoTeraOcu == null || objRecadoTeraOcu.isClosed()) {
            objRecadoTeraOcu = new TelaRecadosTerapiaOcupacional();
            jPainelTerapia.add(objRecadoTeraOcu);
            objRecadoTeraOcu.setVisible(true);
        } else {
            if (objRecadoTeraOcu.isVisible()) {
                if (objRecadoTeraOcu.isIcon()) { // Se esta minimizado
                    try {
                        objRecadoTeraOcu.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadoTeraOcu.toFront(); // traz para frente
                    objRecadoTeraOcu.pack();//volta frame 
                }
            } else {
                objRecadoTeraOcu = new TelaRecadosTerapiaOcupacional();
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRecadoTeraOcu);//adicona frame ao JDesktopPane  
                objRecadoTeraOcu.setVisible(true);
            }
        }
        try {
            objRecadoTeraOcu.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void AtendimentoLaborativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoLaborativoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaAtendimentoInternoManuTO) && codAbrirTO == 1) {
            if (objAtendTera == null || objAtendTera.isClosed()) {
                objAtendTera = new TelaAtendimentoTerapiaOcupacional();
                jPainelTerapia.add(objAtendTera);
                objAtendTera.setVisible(true);
            } else {
                if (objAtendTera.isVisible()) {
                    if (objAtendTera.isIcon()) { // Se esta minimizado
                        try {
                            objAtendTera.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtendTera.toFront(); // traz para frente
                        objAtendTera.pack();//volta frame 
                    }
                } else {
                    objAtendTera = new TelaAtendimentoTerapiaOcupacional();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objAtendTera);//adicona frame ao JDesktopPane  
                    objAtendTera.setVisible(true);
                }
            }
            try {
                objAtendTera.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoLaborativoActionPerformed

    private void OcorrenciasLaborativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcorrenciasLaborativaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaOcorrenciaTO) && codAbrirTO == 1) {
            if (objOcorreTeraOcupa == null || objOcorreTeraOcupa.isClosed()) {
                objOcorreTeraOcupa = new TelaOcorrenciaTerapiaOcupacional();
                jPainelTerapia.add(objOcorreTeraOcupa);
                objOcorreTeraOcupa.setVisible(true);
            } else {
                if (objOcorreTeraOcupa.isVisible()) {
                    if (objOcorreTeraOcupa.isIcon()) { // Se esta minimizado
                        try {
                            objOcorreTeraOcupa.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcorreTeraOcupa.toFront(); // traz para frente
                        objOcorreTeraOcupa.pack();//volta frame 
                    }
                } else {
                    objOcorreTeraOcupa = new TelaOcorrenciaTerapiaOcupacional();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objOcorreTeraOcupa);//adicona frame ao JDesktopPane  
                    objOcorreTeraOcupa.setVisible(true);
                }
            }
            try {
                objOcorreTeraOcupa.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_OcorrenciasLaborativaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaDiversasTerapia objRelPrevSaiInt = new TelaRelatorioPrevisaoSaidaDiversasTerapia();
        TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRelPrevSaiInt);
        objRelPrevSaiInt.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void RelatorioConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfTera = new TelaRelatorioConfere();
        TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRelConfTera);
        objRelConfTera.show();
    }//GEN-LAST:event_RelatorioConfereActionPerformed

    private void RelatorioListaInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioListaInternaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE EMPRESALAB.TipoEmpresa='" + tipoEmpresa + "' "
                    + "AND ITENSAGENDALABORATIVA.StatusInterno='" + statusInterno + "' "
                    + "ORDER BY RazaoSocial,NomeInternoCrc");
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
    }//GEN-LAST:event_RelatorioListaInternaActionPerformed

    private void RelatorioListaExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioListaExternaActionPerformed
        // TODO add your handling code here:       
        // Bloqueado momentaneamente em 11/03/2015, retomar assim que possível.
//        TelaRelatorioListagemExternaInterna objRelAmbos = new TelaRelatorioListagemExternaInterna();
//        TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRelAmbos);
//        objRelAmbos.show();
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE EMPRESALAB.TipoEmpresa='" + tipoEmpresaExt + "' "
                    + "AND ITENSAGENDALABORATIVA.StatusInterno='" + statusInterno + "' "
                    + "ORDER BY RazaoSocial,NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("tipoEmpresa", tipoEmpresaExt);
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
    }//GEN-LAST:event_RelatorioListaExternaActionPerformed

    private void AtivaLaborativaExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtivaLaborativaExternaActionPerformed
        // TODO add your handling code here:
        TelaRelAtividadeLaborExterna relAtiviLabExt = new TelaRelAtividadeLaborExterna();
        TelaModuloTerapiaOcupacional.jPainelTerapia.add(relAtiviLabExt);
        relAtiviLabExt.show();
    }//GEN-LAST:event_AtivaLaborativaExternaActionPerformed

    private void RelatorioFichaLaborativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioFichaLaborativaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioAcompanhamentoLaborativoTempo.jasper";
            conecta.executaSQL("SELECT * FROM ITENSFICHALAB  "
                    + "INNER JOIN FICHALABORATIVA "
                    + "ON ITENSFICHALAB.IdLanc=FICHALABORATIVA.IdLanc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON FICHALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSFICHALAB.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY NomeInternoCrc,DataInicio");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Tempo Laborativo de Interno");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioFichaLaborativaActionPerformed

    private void ControleDiasTrabalhadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleDiasTrabalhadosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFrequenciaMensalExternaManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaFrequenciaMensalExternaManuTO) && codAbrirTO == 1) {
            if (objFreqMen == null || objFreqMen.isClosed()) {
                objFreqMen = new TelaFrequenciaMensalInternosTO();
                jPainelTerapia.add(objFreqMen);
                objFreqMen.setVisible(true);
            } else {
                if (objFreqMen.isVisible()) {
                    if (objFreqMen.isIcon()) { // Se esta minimizado
                        try {
                            objFreqMen.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objFreqMen.toFront(); // traz para frente
                        objFreqMen.pack();//volta frame 
                    }
                } else {
                    objFreqMen = new TelaFrequenciaMensalInternosTO();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objFreqMen);//adicona frame ao JDesktopPane  
                    objFreqMen.setVisible(true);
                }
            }
            try {
                objFreqMen.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleDiasTrabalhadosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioAtividadesLaborativa.jasper";
            conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_LABORATIVA_EXTERNA "
                    + "INNER JOIN FREQUENCIA_LABORATIVA_EXTERNA "
                    + "ON ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdFreqLab=FREQUENCIA_LABORATIVA_EXTERNA.IdFreqLab "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY PRONTUARIOSCRC.IdInternoCrc,ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdItem,ITENS_FREQUENCIA_LABORATIVA_EXTERNA.AnoReferencia");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Quantitativo Atividade Laborativa de Interno");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelTerapia.add(objAgEventos);
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
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void TriagemOcupacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TriagemOcupacionalActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTriagemOcupacionalManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaTriagemOcupacionalManuTO) && codAbrirTO == 1) {
            if (objTriagemOcupa == null || objTriagemOcupa.isClosed()) {
                objTriagemOcupa = new TelaTriagemTerapiaOcupacional();
                jPainelTerapia.add(objTriagemOcupa);
                objTriagemOcupa.setVisible(true);
            } else {
                if (objTriagemOcupa.isVisible()) {
                    if (objTriagemOcupa.isIcon()) { // Se esta minimizado
                        try {
                            objTriagemOcupa.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTriagemOcupa.toFront(); // traz para frente
                        objTriagemOcupa.pack();//volta frame 
                    }
                } else {
                    objTriagemOcupa = new TelaTriagemTerapiaOcupacional();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objTriagemOcupa);//adicona frame ao JDesktopPane  
                    objTriagemOcupa.setVisible(true);
                }
            }
            try {
                objTriagemOcupa.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_TriagemOcupacionalActionPerformed

    private void jPerfilCarcerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPerfilCarcerarioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPerfilCarcerarioManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaPerfilCarcerarioManuTO) && codAbrirTO == 1) {
            if (objPerfilCarrTO == null || objPerfilCarrTO.isClosed()) {
                objPerfilCarrTO = new TelaPerfilCarcerarioTerapiaOcupacional();
                jPainelTerapia.add(objPerfilCarrTO);
                objPerfilCarrTO.setVisible(true);
            } else {
                if (objPerfilCarrTO.isVisible()) {
                    if (objPerfilCarrTO.isIcon()) { // Se esta minimizado
                        try {
                            objPerfilCarrTO.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPerfilCarrTO.toFront(); // traz para frente
                        objPerfilCarrTO.pack();//volta frame 
                    }
                } else {
                    objPerfilCarrTO = new TelaPerfilCarcerarioTerapiaOcupacional();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objPerfilCarrTO);//adicona frame ao JDesktopPane  
                    objPerfilCarrTO.setVisible(true);
                }
            }
            try {
                objPerfilCarrTO.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jPerfilCarcerarioActionPerformed

    private void PAI_NOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAI_NOVOActionPerformed
        // TODO add your handling code here:
        //ACCESSO DIFERENCIADO, A ORIGEM É O SERVIÇO SOCIAL, CADASTRAR O MÓDULO PARA A TERAPIA OCUPACIONAL COM PERMISSÃO DE NÃO
        // E LIBERAR SOMENTE A TELA PRINCIPAL E A ABA DPTL, QUE PERTENCE A TO
        buscarAcessoUsuario(telaPAISS_TO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaPAISS_TO) && codAbrirTO == 1) {
            if (objPaiTO == null || objPaiTO.isClosed()) {
                objPaiTO = new TelaPAI_NOVO();
                jPainelTerapia.add(objPaiTO);
                objPaiTO.setVisible(true);
            } else {
                if (objPaiTO.isVisible()) {
                    if (objPaiTO.isIcon()) { // Se esta minimizado
                        try {
                            objPaiTO.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPaiTO.toFront(); // traz para frente
                        objPaiTO.pack();//volta frame 
                    }
                } else {
                    objPaiTO = new TelaPAI_NOVO();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objPaiTO);//adicona frame ao JDesktopPane  
                    objPaiTO.setVisible(true);
                }
            }
            try {
                objPaiTO.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_PAI_NOVOActionPerformed

    private void CursosProfissionalizantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursosProfissionalizantesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCursosDiversosManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaCursosDiversosManuTO) && codAbrirTO == 1) {
            if (objCursosTO == null || objCursosTO.isClosed()) {
                objCursosTO = new TelaCursosDiversosTerapiaOcupacional();
                jPainelTerapia.add(objCursosTO);
                objCursosTO.setVisible(true);
            } else {
                if (objCursosTO.isVisible()) {
                    if (objCursosTO.isIcon()) { // Se esta minimizado
                        try {
                            objCursosTO.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCursosTO.toFront(); // traz para frente
                        objCursosTO.pack();//volta frame 
                    }
                } else {
                    objCursosTO = new TelaCursosDiversosTerapiaOcupacional();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objCursosTO);//adicona frame ao JDesktopPane  
                    objCursosTO.setVisible(true);
                }
            }
            try {
                objCursosTO.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CursosProfissionalizantesActionPerformed

    private void ProfissoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfissoesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProfissoesManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaProfissoesManuTO) && codAbrirTO == 1) {
            if (objProf == null || objProf.isClosed()) {
                objProf = new TelaProfissoes();
                jPainelTerapia.add(objProf);
                objProf.setVisible(true);
            } else {
                if (objProf.isVisible()) {
                    if (objProf.isIcon()) { // Se esta minimizado
                        try {
                            objProf.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objProf.toFront(); // traz para frente
                        objProf.pack();//volta frame 
                    }
                } else {
                    objProf = new TelaProfissoes();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objProf);//adicona frame ao JDesktopPane  
                    objProf.setVisible(true);
                }
            }
            try {
                objProf.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ProfissoesActionPerformed

    private void OcupacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcupacoesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcupacoesManuTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaOcupacoesManuTO) && codAbrirTO == 1) {
            if (objOcupa == null || objOcupa.isClosed()) {
                objOcupa = new TelaOcupacoes();
                jPainelTerapia.add(objOcupa);
                objOcupa.setVisible(true);
            } else {
                if (objOcupa.isVisible()) {
                    if (objOcupa.isIcon()) { // Se esta minimizado
                        try {
                            objOcupa.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcupa.toFront(); // traz para frente
                        objOcupa.pack();//volta frame 
                    }
                } else {
                    objOcupa = new TelaOcupacoes();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objOcupa);//adicona frame ao JDesktopPane  
                    objOcupa.setVisible(true);
                }
            }
            try {
                objOcupa.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_OcupacoesActionPerformed

    private void jHistoricoMovimentacaoExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHistoricoMovimentacaoExternaActionPerformed
        // TODO add your handling code here: 
        if (objMovCrcTo == null || objMovCrcTo.isClosed()) {
            objMovCrcTo = new TelaMovimentacaoCrcTO();
            jPainelTerapia.add(objMovCrcTo);
            objMovCrcTo.setVisible(true);
        } else {
            if (objMovCrcTo.isVisible()) {
                if (objMovCrcTo.isIcon()) { // Se esta minimizado
                    try {
                        objMovCrcTo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMovCrcTo.toFront(); // traz para frente
                    objMovCrcTo.pack();//volta frame 
                }
            } else {
                objMovCrcTo = new TelaMovimentacaoCrcTO();
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objMovCrcTo);//adicona frame ao JDesktopPane  
                objMovCrcTo.setVisible(true);
            }
        }
        try {
            objMovCrcTo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jHistoricoMovimentacaoExternaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
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
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void RelatorioInternosCNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosCNCActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosComCartaoCNC.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.Cnc!='" + pCnc + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.Cnc!='" + pCnc + "' "
                    + "AND SituacaoCrc='" + statusRetorno + "' "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("situacaoEntrada", statusEntrada);
            parametros.put("situacaoRetorno", statusRetorno);
            parametros.put("nomeUnidade", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos com C.P.F.");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioInternosCNCActionPerformed

    private void RegistroAtendimentoBiografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoBiografiaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroIntAtendTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaRegistroIntAtendTO) && codAbrirTO == 1) {
            if (objRegInt == null || objRegInt.isClosed()) {
                objRegInt = new TelaRegistroInternosAtendimentoTO();
                jPainelTerapia.add(objRegInt);
                objRegInt.setVisible(true);
            } else {
                if (objRegInt.isVisible()) {
                    if (objRegInt.isIcon()) { // Se esta minimizado
                        try {
                            objRegInt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegInt.toFront(); // traz para frente
                        objRegInt.pack();//volta frame 
                    }
                } else {
                    objRegInt = new TelaRegistroInternosAtendimentoTO();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRegInt);//adicona frame ao JDesktopPane  
                    objRegInt.setVisible(true);
                }
            }
            try {
                objRegInt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroAtendimentoBiografiaActionPerformed

    private void RegistroAtendimentoPorImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoPorImpressaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtenImpTO);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTO.equals("ADMINISTRADORES") || codigoUserTO == codUserAcessoTO && nomeTelaTO.equals(telaRegistroAtenImpTO) && codAbrirTO == 1) {
            if (objRegAtenImp == null || objRegAtenImp.isClosed()) {
                objRegAtenImp = new TelaRegistroInternosAtendimentoImpressoTO();
                jPainelTerapia.add(objRegAtenImp);
                objRegAtenImp.setVisible(true);
            } else {
                if (objRegAtenImp.isVisible()) {
                    if (objRegAtenImp.isIcon()) { // Se esta minimizado
                        try {
                            objRegAtenImp.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegAtenImp.toFront(); // traz para frente
                        objRegAtenImp.pack();//volta frame 
                    }
                } else {
                    objRegAtenImp = new TelaRegistroInternosAtendimentoImpressoTO();
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRegAtenImp);//adicona frame ao JDesktopPane  
                    objRegAtenImp.setVisible(true);
                }
            }
            try {
                objRegAtenImp.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroAtendimentoPorImpressaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem AtendimentoLaborativo;
    private javax.swing.JMenuItem AtivaLaborativaExterna;
    private javax.swing.JMenuItem ControleDiasTrabalhados;
    private javax.swing.JMenuItem CursosProfissionalizantes;
    private javax.swing.JMenuItem EmpresasLaborativas;
    private javax.swing.JMenuItem FichaAtividadeLaborativa;
    private javax.swing.JMenuItem HistoricoMovimentacaoTecnica;
    private javax.swing.JMenuItem ListaEsperaTO;
    private javax.swing.JMenuItem ListaPassagemInternos;
    private javax.swing.JMenuItem OcorrenciasLaborativa;
    private javax.swing.JMenuItem Ocupacoes;
    private javax.swing.JMenuItem PAI_NOVO;
    private javax.swing.JMenuItem Profissoes;
    private javax.swing.JMenuItem RegistroAtendimentoBiografia;
    private javax.swing.JMenuItem RegistroAtendimentoPorImpressao;
    private javax.swing.JMenuItem RelatorioConfere;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioFichaLaborativa;
    private javax.swing.JMenuItem RelatorioInternosCNC;
    private javax.swing.JMenuItem RelatorioListaExterna;
    private javax.swing.JMenuItem RelatorioListaInterna;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem TriagemOcupacional;
    private javax.swing.JMenuItem jHistoricoMovimentacaoExterna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JDesktopPane jPainelTerapia;
    private javax.swing.JMenuItem jPerfilCarcerario;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
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
                TelaModuloTerapiaOcupacional.jPainelTerapia.add(objRecados);
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
                conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS WHERE UsuarioAgenda='" + nameUser + "' "
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
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objAgendaComp);
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
                conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS WHERE UsuarioAgenda='" + nameUser + "' "
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
                    TelaModuloTerapiaOcupacional.jPainelTerapia.add(objAgendaComp);
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

    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
        // MENU CADASTRO
        // EMPRESA LABORATIVA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEmpresasLabManuTO + "'");
            conecta.rs.first();
            pNomeELB_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //FICHA ATIVIDADE LABORATIVA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFichaAtividadeLabManuTO + "'");
            conecta.rs.first();
            pNomeFALM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFichaAtividadeLabIntTO + "'");
            conecta.rs.first();
            pNomeFALI_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaProfissoesManuTO + "'");
            conecta.rs.first();
            pNomePM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcupacoesManuTO + "'");
            conecta.rs.first();
            pNomeOM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCursosDiversosManuTO + "'");
            conecta.rs.first();
            pNomeCD_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaListaEsperaManuTO + "'");
            conecta.rs.first();
            pNomeLEM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaListaEsperaIntTO + "'");
            conecta.rs.first();
            pNomeLEI_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaListaPassagemManuTO + "'");
            conecta.rs.first();
            pNomeLPM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaListaPassagemIntTO + "'");
            conecta.rs.first();
            pNomeLPI_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // REGISTRO DE ATENDIMENTO INTERNOS - BOMETRIA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroIntAtendTO + "'");
            conecta.rs.first();
            pNomeRAI_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroIntAtendInciarLeitorTO + "'");
            conecta.rs.first();
            pNomeRAIIL_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // REGISTRO DE ATENDIMENTO INTERNO - IMPRESSÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtenImpTO + "'");
            conecta.rs.first();
            pNomeRAIM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroLibAtenImpTO + "'");
            conecta.rs.first();
            pNomeRAIL_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTriagemOcupacionalManuTO + "'");
            conecta.rs.first();
            pNomeTOM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // ATENDIMENTO TERAPIA OCUPACIONAL
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoManuTO + "'");
            conecta.rs.first();
            pNomeAIM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoAvaITO + "'");
            conecta.rs.first();
            pNomeAIAI_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoAvaIITO + "'");
            conecta.rs.first();
            pNomeAIAII_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoHistEduTO + "'");
            conecta.rs.first();
            pNomeAIHE_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoHistLabTO + "'");
            conecta.rs.first();
            pNomeAIHL_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoEvolTO + "'");
            conecta.rs.first();
            pNomeAIE_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //FREQUENCIA EXTERNA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFrequenciaMensalExternaManuTO + "'");
            conecta.rs.first();
            pNomeFMEM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFrequenciaMensalExternaIntTO + "'");
            conecta.rs.first();
            pNomeFMEI_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // PERFIL CARCERARIO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilCarcerarioManuTO + "'");
            conecta.rs.first();
            pNomePCM_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilCarcerarioPerfilTO + "'");
            conecta.rs.first();
            pNomePCP_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PAI_NOVO
        //OCORRENCIA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaTO + "'");
            conecta.rs.first();
            pNomeO_TO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MENU CADASTRO
        if (!pNomeELB_TO.equals(telaEmpresasLabManuTO) || pNomeELB_TO == null || pNomeELB_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEmpresasLabManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeFALM_TO.equals(telaFichaAtividadeLabManuTO) || pNomeFALM_TO == null || pNomeFALM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFichaAtividadeLabManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeFALI_TO.equals(telaFichaAtividadeLabIntTO) || pNomeFALI_TO == null || pNomeFALI_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFichaAtividadeLabIntTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePM_TO.equals(telaProfissoesManuTO) || pNomePM_TO == null || pNomePM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaProfissoesManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOM_TO.equals(telaOcupacoesManuTO) || pNomeOM_TO == null || pNomeOM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcupacoesManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCD_TO.equals(telaCursosDiversosManuTO) || pNomeCD_TO == null || pNomeCD_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCursosDiversosManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLEM_TO.equals(telaListaEsperaManuTO) || pNomeLEM_TO == null || pNomeLEM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaListaEsperaManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLEI_TO.equals(telaListaEsperaIntTO) || pNomeLEI_TO == null || pNomeLEI_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaListaEsperaIntTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLPM_TO.equals(telaListaPassagemManuTO) || pNomeLPM_TO == null || pNomeLPM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaListaPassagemManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLPI_TO.equals(telaListaPassagemIntTO) || pNomeLPI_TO == null || pNomeLPI_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaListaPassagemIntTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // REGISTRO DE ATENDIMENTO DE INTERNO - DIGITAL
        if (!pNomeRAI_TO.equals(telaRegistroIntAtendTO) || pNomeRAI_TO == null || pNomeRAI_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroIntAtendTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAIIL_TO.equals(telaRegistroIntAtendInciarLeitorTO) || pNomeRAIIL_TO == null || pNomeRAIIL_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroIntAtendInciarLeitorTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // REGISTRO DE ATENDIMENTO DE INTERNO LIBERAÇÃO IMPRESSÃO
        if (!pNomeRAIM_TO.equals(telaRegistroAtenImpTO) || pNomeRAIM_TO == null || pNomeRAIM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtenImpTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAIL_TO.equals(telaRegistroLibAtenImpTO) || pNomeRAIL_TO == null || pNomeRAIL_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroLibAtenImpTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //MOVIMENTAÇÃO
        if (!pNomeTOM_TO.equals(telaTriagemOcupacionalManuTO) || pNomeTOM_TO == null || pNomeTOM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTriagemOcupacionalManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // ATENTIMENTO TERAPIA OCUPACIONAL
        if (!pNomeAIM_TO.equals(telaAtendimentoInternoManuTO) || pNomeAIM_TO == null || pNomeAIM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIAI_TO.equals(telaAtendimentoInternoAvaITO) || pNomeAIAI_TO == null || pNomeAIAI_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoAvaITO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIAII_TO.equals(telaAtendimentoInternoAvaIITO) || pNomeAIAII_TO == null || pNomeAIAII_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoAvaIITO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIHE_TO.equals(telaAtendimentoInternoHistEduTO) || pNomeAIHE_TO == null || pNomeAIHE_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoHistEduTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIHL_TO.equals(telaAtendimentoInternoHistLabTO) || pNomeAIHL_TO == null || pNomeAIHL_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoHistLabTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIE_TO.equals(telaAtendimentoInternoEvolTO) || pNomeAIE_TO == null || pNomeAIE_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoEvolTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // FREQUENCIA EXTERNA
        if (!pNomeFMEM_TO.equals(telaFrequenciaMensalExternaManuTO) || pNomeFMEM_TO == null || pNomeFMEM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFrequenciaMensalExternaManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeFMEI_TO.equals(telaFrequenciaMensalExternaIntTO) || pNomeFMEI_TO == null || pNomeFMEI_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFrequenciaMensalExternaIntTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // PERFIL CARCERARIO
        if (!pNomePCM_TO.equals(telaPerfilCarcerarioManuTO) || pNomePCM_TO == null || pNomePCM_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilCarcerarioManuTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCP_TO.equals(telaPerfilCarcerarioPerfilTO) || pNomePCP_TO == null || pNomePCP_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilCarcerarioPerfilTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PAI_NOVO

        //OCORRENCIA
        if (!pNomeO_TO.equals(telaOcorrenciaTO) || pNomeO_TO == null || pNomeO_TO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaTO);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }
    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.

    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloTO + "'");
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
            codigoUserTO = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserTO + "'");
            conecta.rs.first();
            codigoUserGroupTO = conecta.rs.getInt("IdUsuario");
            codigoGrupoTO = conecta.rs.getInt("IdGrupo");
            nomeGrupoTO = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserTO + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoTO = conecta.rs.getInt("IdUsuario");
            codAbrirTO = conecta.rs.getInt("Abrir");
            codIncluirTO = conecta.rs.getInt("Incluir");
            codAlterarTO = conecta.rs.getInt("Alterar");
            codExcluirTO = conecta.rs.getInt("Excluir");
            codGravarTO = conecta.rs.getInt("Gravar");
            codConsultarTO = conecta.rs.getInt("Consultar");
            nomeTelaTO = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
