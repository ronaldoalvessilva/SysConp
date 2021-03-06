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
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
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
public class TelaModuloPsicologia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    ParametrosCrc objParCrc = new ParametrosCrc();
    ControleImplementacoes controlImp = new ControleImplementacoes();
    //
    private TelaConsultaProntuarioInternoCrc objIntPsi = null;
    private TelaAdmissaoPsicologica objAdmPsi = null;
    private TelaConsultaLocalInternoPsicologia objConLocalIntPsi = null;
    private TelaAvaliacaoPsicologica objAvaPsi = null;
    private TelaMovHistoricoTecPsicologia objMovHisPsi = null;
    private TelaRecadosPsicologia objRecPsi = null;
    private TelaOcorrenciaPsicologia objOcorrPsi = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaPerfilCarcerarioPsicologia objPerfilPSI = null;
    private TelaAgendamentoAtendimentoInternos objAgendaAtendInt = null;
    private TelaMovimentacaoCrcPsicologia objMoviCrc = null;
    private TelaPAI_NOVO_Psicologia objPAI_NOVO = null;
    private TelaRegistroInternosAtendimentoPSI objRegBioPSI = null;
    private TelaRegistroInternosAtendimentoImpressoPSI objAutoImp = null;
//    private TelaIndicadoresAcompanhamento objIndAcomp = null;
    private TelaCancelamentoAtendimentoPSP objCancelaAtend = null;
    private TelaTiposTratamentoPsicologico objTipoTrata = null;
    private TelaAtendimentoGrupoPSI objAtendGrupo = null;
    private TelaAtividadesEducacaoFisica objAtividadePlan = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado. 
    //
    String tipoEmpresa = "Interna";
    String tipoEmpresaExt = "Externa";
    String statusInterno = "Ativo";
    //
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    //
    public static int codigoUserPSI = 0;
    public static int codUserAcessoPSI = 0;
    public static int codigoUserGroupPSI = 0;
    public static int codAbrirPSI = 0;
    public static int codIncluirPSI = 0;
    public static int codAlterarPSI = 0;
    public static int codExcluirPSI = 0;
    public static int codGravarPSI = 0;
    public static int codConsultarPSI = 0;
    public static int codigoGrupoPSI = 0;
    public static String nomeGrupoPSI = "";
    public static String nomeTelaPSI = "";
    //
    public static String nomeModuloPSICOLOGIA = "PSICOLOGIA";
    // CADASTRO
    public static String telaCadastroAgendaAtendimentoInternoManuPSI = "Cadastro:Agenda Atendimento a Internos:Manutenção";
    public static String telaRegistroAtendimentoBioPSI = "Cadastro:Registro de Atendimento Internos Biometria:Manutenção";
    public static String telaRegistroAtendimentoInciarLeitorPSI = "Cadastro:Registro de Atendimento Internos Biometria:Iniciar Leitor";
    public static String telaRegistroAtendimentoImpBioPSI = "Cadastro:Registro de Autorização Impressa:Liberação";
    public static String telaRegistroAtendimentoColLiberadorPSI = "Cadastro:Registro de Autorização Impressa:Colaborador Liberador";
    public static String telaCancelAtendInternoPSI = "Cadastro:Cancelamento Assinatura Interno/Impressão - PSI:Manutenção";
    public static String telaCadastroTipoTratamentoPSI = "Cadastro:Tipos de Tratamento:Manutenção";
    //PLANEJAMENTO DE ATIVIDADES EM GRUPO
    public static String telaPlanejamentoAtividadesManu_PS = "Cadastro:Planejamento Atividades em Grupo - PS:Manutenção";
    // MENU CONSULTA    
    public static String telaConsultaProntuarioInternosDocPSI = "Consulta:Prontuario:Documentos";
    // MOVIMENTAÇÃO
    public static String telaMovimentacaoAdmIntManuPSI = "Movimentação:Admissão de Internos:Manutenção";
    public static String telaMovimentacaoEvolIntPSI = "Movimentação:Evolução Psicológica de Internos";
    public static String telaMovimentacaoPareIntPSI = "Movimentação:Parecer Psicológico de Internos";
    public static String telaTratamentoPsicologicoPSI = "Tratamento Psicologico";
    //
    public static String telaMovimentacaoAvalPsiIntPSI = "Movimentação:Avaliação Psicologica:Manutenção";
    //P.A.I.
    public static String telaPAIS_PSI = "Movimentação:P.A.I. - Psicologia:Manutenção";
    public static String telaPaiCCGF_PSI = "Movimentação:P.A.I.:C.C.G.F. - Psicologia";
    public static String telaPaiCCGFFam_PSI = "Movimentação:P.A.I.:C.C.G.F. - Psicologia:Familia";
    public static String telaPaiCCGFVis_PSI = "Movimentação:P.A.I.:C.C.G.F. - Psicologia:Visita";
    public static String telaPaiCCGFVisInt_PSI = "Movimentação:P.A.I.:C.C.G.F. - Psicologia:Visita Intima";
    public static String telaPaiDEME_PSI = "Movimentação:P.A.I.:D.E.M.E. - Psicologia";
    public static String telaPaiDPTL_PSI = "Movimentação:P.A.I.:D.P.T.L. - Psicologia";
    public static String telaPaiDJ_PSI = "Movimentação:P.A.I.:D.J. - Psicologia";
    public static String telaPaiDS_PSI = "Movimentação:P.A.I.:D.S. - Psicologia";
    public static String telaPaiEAPI1_PSI = "Movimentação:P.A.I.:E.A.P.I.-1 - Psicologia";
    public static String telaPaiEAPI2_PSI = "Movimentação:P.A.I.:E.A.P.I.-2 - Psicologia";
    public static String telaPaiEPAI_PSI = "Movimentação:P.A.I.:E-PAI - Psicologia";
    //
    public static String telaPerfilSocialManuPSI = "Movimentação:Perfil Carcerário:Manutenção";
    public static String telaPerfilSocialPerfCarPSI = "Movimentação:Perfil Carcerário:Perfil Carcerário";
    //
    public static String telaMovimetacaoOcrPSI = "Movimetação:Movimentação:Ocorrências Diárias:Manutenção";
    //
    public static String telaIndAcompanhaManuPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:Manutenção";
    public static String telaIndAcompanhaAbaEPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:Enfermaria";
    public static String telaIndAcompanhaAbaPPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:Pedagogia";
    public static String telaIndAcompanhaAbaCPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:Juridico/CRC";
    public static String telaIndAcompanhaAbaTPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:TO";
    public static String telaIndAcompanhaAbaPSIPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:Psicologia";
    public static String telaIndAcompanhaAbaSPSI = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PS:Serviço Social";
    //
    public static String telaIndAtendimentoGrupoPSI_Manu = "Movimentação:Atendimento Internos em Grupo:Mamnutenção";
    public static String telaIndAtendimentoGrupoPSI_Plan = "Movimentação:Atendimento Internos em Grupo:Planejamento";
    public static String telaIndAtendimentoGrupoPSI_Inte = "Movimentação:Atendimento Internos em Grupo:Internos";
    public static String telaIndAtendimentoGrupoPSI_AVG = "Movimentação:Atendimento Internos em Grupo:Avaliação em Grupo";
    public static String telaIndAtendimentoGrupoPSI_AVI = "Movimentação:Atendimento Internos em Grupo:Avaliação Individual";
    public static String botaoEncerrar_PSI = "Movimentação:Atendimento Internos em Grupo:Botao Encerrar";
    public static String botaoLiberar_PSI = "Movimentação:Atendimento Internos em Grupo:Botão Liberar";
    //         
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCAAI = "";
    String pNomeRABP = "";
    String pNomeRAIB = "";
    String pNomeRAIL = "";
    String pNomeRACL = "";
    String pNomeCAII = "";
    String pNomeTTP = "";
    //PLANEJAMENTO DE ATIVIDADES EM GRUPO
    String pNomePAG_PS = "";
    // MENU CONSULTA
    String pNomeCPID = "";
    // MOVIMENTAÇÃO
    String pNomeMAIM = "";
    String pNomeMEP = "";
    String pNomeMPI = "";
    String pNomeTP = "";
    //    
    String pNomeMAP = "";
    //P.A.I.
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
    String pNomePSM = "";
    String pNomePSPC = "";
    //
    String pNomeMO = "";
    //PRORES
    String pNomeIAM = "";
    String pNomeIAE = "";
    String pNomeIAP = "";
    String pNomeIAC = "";
    String pNomeIAT = "";
    String pNomeIAPS = "";
    String pNomeIAS = "";
    // ATIVIDADES EM GRUPO
    String pNomeAGM = "";
    String pNomePLA = "";
    String pNomeAGI = "";
    String pNomeAVG = "";
    String pNomeAVI = "";
    //
    String pNomeBTE = "";
    String pNomeBTL = "";
    //
    public static int pQUANTIDADE_ATENDIDA = 1;

    /**
     * Creates new form TelaPsicologia
     */
    public TelaModuloPsicologia() {
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

        jPainelPsicologia = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jTipoTratamentoPsicologico = new javax.swing.JMenuItem();
        AgendaAtendimentoInternos = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jPlanejamentoAtividades = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jRegistroAtendeInternoBio = new javax.swing.JMenuItem();
        RegistroAtendimentoImpresso = new javax.swing.JMenuItem();
        jCancelarRegistroAtendimentoInterno = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ConsultaProntuarioInternos = new javax.swing.JMenuItem();
        ConsultaLocalizacaoInternos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        HistoricoMovimentacao = new javax.swing.JMenuItem();
        HistoricoExterno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AdmissaoPsicologica = new javax.swing.JMenuItem();
        AvaliacaoPsicologica = new javax.swing.JMenuItem();
        jAtendimentoPsicologicoGrupo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jPaiNovo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jPerfilCarcerario = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        jRelatorioAtendimentoInternos = new javax.swing.JMenu();
        RelatoriosConfere = new javax.swing.JMenu();
        RelatorioGeralConfere = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ListagemAtividadesLaborativas = new javax.swing.JMenu();
        AtividadesInternas = new javax.swing.JMenuItem();
        AtividadesExternas = new javax.swing.JMenuItem();
        RelatorioAconpanhamentoFamiliar = new javax.swing.JMenuItem();
        ListagemFrequenciaExterna = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        RelatorioVisitasInternos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaUnidade = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jRelatorioAtendimentoPsicologico = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Psicologia :::...");

        jPainelPsicologia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelPsicologia.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPsicologiaLayout = new javax.swing.GroupLayout(jPainelPsicologia);
        jPainelPsicologia.setLayout(jPainelPsicologiaLayout);
        jPainelPsicologiaLayout.setHorizontalGroup(
            jPainelPsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelPsicologiaLayout.setVerticalGroup(
            jPainelPsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        jTipoTratamentoPsicologico.setText("Tipos de Tratamentos Psicologicos");
        jTipoTratamentoPsicologico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTipoTratamentoPsicologicoActionPerformed(evt);
            }
        });
        jMenu1.add(jTipoTratamentoPsicologico);

        AgendaAtendimentoInternos.setText("Agenda Atendimento a Internos");
        AgendaAtendimentoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaAtendimentoInternosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaAtendimentoInternos);
        jMenu1.add(jSeparator11);

        jPlanejamentoAtividades.setText("Planejamento de Atividades em Grupo");
        jPlanejamentoAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlanejamentoAtividadesActionPerformed(evt);
            }
        });
        jMenu1.add(jPlanejamentoAtividades);
        jMenu1.add(jSeparator6);

        AgendaCompromissos.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaCompromissos);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaRecados);
        jMenu1.add(jSeparator3);

        jMenu5.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        jRegistroAtendeInternoBio.setForeground(new java.awt.Color(0, 0, 204));
        jRegistroAtendeInternoBio.setText("Registra Atendimento por Biometria");
        jRegistroAtendeInternoBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroAtendeInternoBioActionPerformed(evt);
            }
        });
        jMenu5.add(jRegistroAtendeInternoBio);

        RegistroAtendimentoImpresso.setForeground(new java.awt.Color(0, 102, 0));
        RegistroAtendimentoImpresso.setText("Registro Atendimento por Impressão");
        RegistroAtendimentoImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoImpressoActionPerformed(evt);
            }
        });
        jMenu5.add(RegistroAtendimentoImpresso);

        jCancelarRegistroAtendimentoInterno.setText("Cancelar  Registro de Atendimento de Interno");
        jCancelarRegistroAtendimentoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarRegistroAtendimentoInternoActionPerformed(evt);
            }
        });
        jMenu5.add(jCancelarRegistroAtendimentoInterno);

        jMenu1.add(jMenu5);
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

        ConsultaProntuarioInternos.setText("Prontuários de Internos");
        ConsultaProntuarioInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaProntuarioInternosActionPerformed(evt);
            }
        });
        jMenu4.add(ConsultaProntuarioInternos);

        ConsultaLocalizacaoInternos.setText("Localização de Internos");
        ConsultaLocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaLocalizacaoInternosActionPerformed(evt);
            }
        });
        jMenu4.add(ConsultaLocalizacaoInternos);
        jMenu4.add(jSeparator7);

        HistoricoMovimentacao.setText("Histórico Movimentação de Internos");
        HistoricoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovimentacaoActionPerformed(evt);
            }
        });
        jMenu4.add(HistoricoMovimentacao);

        HistoricoExterno.setText("Histórico Movimentação de Internos - Externa");
        HistoricoExterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoExternoActionPerformed(evt);
            }
        });
        jMenu4.add(HistoricoExterno);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Movimentação");

        AdmissaoPsicologica.setText("Admissão/Evolução Psicologica");
        AdmissaoPsicologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissaoPsicologicaActionPerformed(evt);
            }
        });
        jMenu2.add(AdmissaoPsicologica);

        AvaliacaoPsicologica.setText("Avaliação Psicologica");
        AvaliacaoPsicologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvaliacaoPsicologicaActionPerformed(evt);
            }
        });
        jMenu2.add(AvaliacaoPsicologica);

        jAtendimentoPsicologicoGrupo.setText("Atendimento Psicologico em Grupo");
        jAtendimentoPsicologicoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtendimentoPsicologicoGrupoActionPerformed(evt);
            }
        });
        jMenu2.add(jAtendimentoPsicologicoGrupo);
        jMenu2.add(jSeparator5);

        jPaiNovo.setText("P.A.I. - Programa de Assistência Individualizado - NOVO");
        jPaiNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaiNovoActionPerformed(evt);
            }
        });
        jMenu2.add(jPaiNovo);
        jMenu2.add(jSeparator4);

        jPerfilCarcerario.setText("Perfil da População Carcerária");
        jPerfilCarcerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPerfilCarcerarioActionPerformed(evt);
            }
        });
        jMenu2.add(jPerfilCarcerario);
        jMenu2.add(jSeparator9);

        LivroOcorrencias.setText("Livro de Ocorrências");
        LivroOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciasActionPerformed(evt);
            }
        });
        jMenu2.add(LivroOcorrencias);

        jMenuBar1.add(jMenu2);

        jRelatorioAtendimentoInternos.setText("Relatórios");

        RelatoriosConfere.setText("Relatórios de Confere");

        RelatorioGeralConfere.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralConfereActionPerformed(evt);
            }
        });
        RelatoriosConfere.add(RelatorioGeralConfere);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        RelatoriosConfere.add(ListagemConfere);

        jRelatorioAtendimentoInternos.add(RelatoriosConfere);
        jRelatorioAtendimentoInternos.add(jSeparator1);

        ListagemAtividadesLaborativas.setText("Listagem de Internos com Atividades Laborativas");

        AtividadesInternas.setText("Atividades Internas");
        AtividadesInternas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtividadesInternasActionPerformed(evt);
            }
        });
        ListagemAtividadesLaborativas.add(AtividadesInternas);

        AtividadesExternas.setText("Atividades Externas");
        AtividadesExternas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtividadesExternasActionPerformed(evt);
            }
        });
        ListagemAtividadesLaborativas.add(AtividadesExternas);

        jRelatorioAtendimentoInternos.add(ListagemAtividadesLaborativas);

        RelatorioAconpanhamentoFamiliar.setText("Relatório de Acompanhamento Laborativo de Internos");
        RelatorioAconpanhamentoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAconpanhamentoFamiliarActionPerformed(evt);
            }
        });
        jRelatorioAtendimentoInternos.add(RelatorioAconpanhamentoFamiliar);

        ListagemFrequenciaExterna.setText("Atividade laborativa Externa (Frequência)");
        ListagemFrequenciaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemFrequenciaExternaActionPerformed(evt);
            }
        });
        jRelatorioAtendimentoInternos.add(ListagemFrequenciaExterna);
        jRelatorioAtendimentoInternos.add(jSeparator2);

        RelatorioVisitasInternos.setText("Relatório de Visitas aos Internos");
        RelatorioVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasInternosActionPerformed(evt);
            }
        });
        jRelatorioAtendimentoInternos.add(RelatorioVisitasInternos);
        jRelatorioAtendimentoInternos.add(jSeparator8);

        RelatorioEntradaUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaUnidadeActionPerformed(evt);
            }
        });
        jRelatorioAtendimentoInternos.add(RelatorioEntradaUnidade);
        jRelatorioAtendimentoInternos.add(jSeparator12);

        jRelatorioAtendimentoPsicologico.setForeground(new java.awt.Color(0, 102, 51));
        jRelatorioAtendimentoPsicologico.setText("Relatório de Atendimento Internos");
        jRelatorioAtendimentoPsicologico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioAtendimentoPsicologicoActionPerformed(evt);
            }
        });
        jRelatorioAtendimentoInternos.add(jRelatorioAtendimentoPsicologico);
        jRelatorioAtendimentoInternos.add(jSeparator13);

        jMenuItem1.setForeground(new java.awt.Color(204, 0, 0));
        jMenuItem1.setText("Relatório Tratamento Psicologico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jRelatorioAtendimentoInternos.add(jMenuItem1);

        jMenuBar1.add(jRelatorioAtendimentoInternos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPsicologia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPsicologia)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void ConsultaProntuarioInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaProntuarioInternosActionPerformed
        // TODO add your handling code here:
        if (objIntPsi == null || objIntPsi.isClosed()) {
            objIntPsi = new TelaConsultaProntuarioInternoCrc();
            jPainelPsicologia.add(objIntPsi);
            objIntPsi.setVisible(true);
        } else {
            if (objIntPsi.isVisible()) {
                if (objIntPsi.isIcon()) { // Se esta minimizado
                    try {
                        objIntPsi.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objIntPsi.toFront(); // traz para frente
                    objIntPsi.pack();//volta frame 
                }
            } else {
                objIntPsi = new TelaConsultaProntuarioInternoCrc();
                TelaModuloPsicologia.jPainelPsicologia.add(objIntPsi);//adicona frame ao JDesktopPane  
                objIntPsi.setVisible(true);
            }
        }
        try {
            objIntPsi.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaProntuarioInternosActionPerformed

    private void ConsultaLocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaLocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objConLocalIntPsi == null || objConLocalIntPsi.isClosed()) {
            objConLocalIntPsi = new TelaConsultaLocalInternoPsicologia();
            jPainelPsicologia.add(objConLocalIntPsi);
            objConLocalIntPsi.setVisible(true);
        } else {
            if (objConLocalIntPsi.isVisible()) {
                if (objConLocalIntPsi.isIcon()) { // Se esta minimizado
                    try {
                        objConLocalIntPsi.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConLocalIntPsi.toFront(); // traz para frente
                    objConLocalIntPsi.pack();//volta frame 
                }
            } else {
                objConLocalIntPsi = new TelaConsultaLocalInternoPsicologia();
                TelaModuloPsicologia.jPainelPsicologia.add(objConLocalIntPsi);//adicona frame ao JDesktopPane  
                objConLocalIntPsi.setVisible(true);
            }
        }
        try {
            objConLocalIntPsi.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaLocalizacaoInternosActionPerformed

    private void AdmissaoPsicologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmissaoPsicologicaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAdmIntManuPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAdmIntManuPSI) && codAbrirPSI == 1) {
            if (objAdmPsi == null || objAdmPsi.isClosed()) {
                objAdmPsi = new TelaAdmissaoPsicologica();
                jPainelPsicologia.add(objAdmPsi);
                objAdmPsi.setVisible(true);
            } else {
                if (objAdmPsi.isVisible()) {
                    if (objAdmPsi.isIcon()) { // Se esta minimizado
                        try {
                            objAdmPsi.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAdmPsi.toFront(); // traz para frente
                        objAdmPsi.pack();//volta frame 
                    }
                } else {
                    objAdmPsi = new TelaAdmissaoPsicologica();
                    TelaModuloPsicologia.jPainelPsicologia.add(objAdmPsi);//adicona frame ao JDesktopPane  
                    objAdmPsi.setVisible(true);
                }
            }
            try {
                objAdmPsi.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AdmissaoPsicologicaActionPerformed

    private void AvaliacaoPsicologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvaliacaoPsicologicaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoAvalPsiIntPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimentacaoAvalPsiIntPSI) && codAbrirPSI == 1) {
            if (objAvaPsi == null || objAvaPsi.isClosed()) {
                objAvaPsi = new TelaAvaliacaoPsicologica();
                jPainelPsicologia.add(objAvaPsi);
                objAvaPsi.setVisible(true);
            } else {
                if (objAvaPsi.isVisible()) {
                    if (objAvaPsi.isIcon()) { // Se esta minimizado
                        try {
                            objAvaPsi.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAvaPsi.toFront(); // traz para frente
                        objAvaPsi.pack();//volta frame 
                    }
                } else {
                    objAvaPsi = new TelaAvaliacaoPsicologica();
                    TelaModuloPsicologia.jPainelPsicologia.add(objAvaPsi);//adicona frame ao JDesktopPane  
                    objAvaPsi.setVisible(true);
                }
            }
            try {
                objAvaPsi.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AvaliacaoPsicologicaActionPerformed

    private void HistoricoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovimentacaoActionPerformed
        // TODO add your handling code here:
        if (objMovHisPsi == null || objMovHisPsi.isClosed()) {
            objMovHisPsi = new TelaMovHistoricoTecPsicologia();
            jPainelPsicologia.add(objMovHisPsi);
            objMovHisPsi.setVisible(true);
        } else {
            if (objMovHisPsi.isVisible()) {
                if (objMovHisPsi.isIcon()) { // Se esta minimizado
                    try {
                        objMovHisPsi.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMovHisPsi.toFront(); // traz para frente
                    objMovHisPsi.pack();//volta frame 
                }
            } else {
                objMovHisPsi = new TelaMovHistoricoTecPsicologia();
                TelaModuloPsicologia.jPainelPsicologia.add(objMovHisPsi);//adicona frame ao JDesktopPane  
                objMovHisPsi.setVisible(true);
            }
        }
        try {
            objMovHisPsi.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecPsi == null || objRecPsi.isClosed()) {
            objRecPsi = new TelaRecadosPsicologia();
            jPainelPsicologia.add(objRecPsi);
            objRecPsi.setVisible(true);
        } else {
            if (objRecPsi.isVisible()) {
                if (objRecPsi.isIcon()) { // Se esta minimizado
                    try {
                        objRecPsi.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecPsi.toFront(); // traz para frente
                    objRecPsi.pack();//volta frame 
                }
            } else {
                objRecPsi = new TelaRecadosPsicologia();
                TelaModuloPsicologia.jPainelPsicologia.add(objRecPsi);//adicona frame ao JDesktopPane  
                objRecPsi.setVisible(true);
            }
        }
        try {
            objRecPsi.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void LivroOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimetacaoOcrPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaMovimetacaoOcrPSI) && codAbrirPSI == 1) {
            if (objOcorrPsi == null || objOcorrPsi.isClosed()) {
                objOcorrPsi = new TelaOcorrenciaPsicologia();
                jPainelPsicologia.add(objOcorrPsi);
                objOcorrPsi.setVisible(true);
            } else {
                if (objOcorrPsi.isVisible()) {
                    if (objOcorrPsi.isIcon()) { // Se esta minimizado
                        try {
                            objOcorrPsi.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcorrPsi.toFront(); // traz para frente
                        objOcorrPsi.pack();//volta frame 
                    }
                } else {
                    objOcorrPsi = new TelaOcorrenciaPsicologia();
                    TelaModuloPsicologia.jPainelPsicologia.add(objOcorrPsi);//adicona frame ao JDesktopPane  
                    objOcorrPsi.setVisible(true);
                }
            }
            try {
                objOcorrPsi.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciasActionPerformed

    private void RelatorioGeralConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralConfereActionPerformed
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
    }//GEN-LAST:event_RelatorioGeralConfereActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloPsicologia.jPainelPsicologia.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void AtividadesInternasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtividadesInternasActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/TerapiaOcupacional/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE ITENSAGENDALABORATIVA.TipoEmpresa='" + tipoEmpresa + "' "
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
    }//GEN-LAST:event_AtividadesInternasActionPerformed

    private void AtividadesExternasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtividadesExternasActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/TerapiaOcupacional/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE ITENSAGENDALABORATIVA.TipoEmpresa='" + tipoEmpresaExt + "' "
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
    }//GEN-LAST:event_AtividadesExternasActionPerformed

    private void ListagemFrequenciaExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemFrequenciaExternaActionPerformed
        // TODO add your handling code here:
        TelaRelAtividadeLaborExterna relAtiviLabExt = new TelaRelAtividadeLaborExterna();
        TelaModuloPsicologia.jPainelPsicologia.add(relAtiviLabExt);
        relAtiviLabExt.show();
    }//GEN-LAST:event_ListagemFrequenciaExternaActionPerformed

    private void RelatorioVisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVisitasInternosActionPerformed
        // TODO add your handling code here:
        TelaRelVisitasInternosPsi relVisitasInternos = new TelaRelVisitasInternosPsi();
        TelaModuloPsicologia.jPainelPsicologia.add(relVisitasInternos);
        relVisitasInternos.show();
    }//GEN-LAST:event_RelatorioVisitasInternosActionPerformed

    private void RelatorioAconpanhamentoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAconpanhamentoFamiliarActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/TerapiaOcupacional/RelatorioAcompanhamentoLaborativoTempo.jasper";
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
    }//GEN-LAST:event_RelatorioAconpanhamentoFamiliarActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelPsicologia.add(objAgEventos);
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
                TelaModuloPsicologia.jPainelPsicologia.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void jPerfilCarcerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPerfilCarcerarioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPerfilSocialManuPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaPerfilSocialManuPSI) && codAbrirPSI == 1) {
            if (objPerfilPSI == null || objPerfilPSI.isClosed()) {
                objPerfilPSI = new TelaPerfilCarcerarioPsicologia();
                jPainelPsicologia.add(objPerfilPSI);
                objPerfilPSI.setVisible(true);
            } else {
                if (objPerfilPSI.isVisible()) {
                    if (objPerfilPSI.isIcon()) { // Se esta minimizado
                        try {
                            objPerfilPSI.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPerfilPSI.toFront(); // traz para frente
                        objPerfilPSI.pack();//volta frame 
                    }
                } else {
                    objPerfilPSI = new TelaPerfilCarcerarioPsicologia();
                    TelaModuloPsicologia.jPainelPsicologia.add(objPerfilPSI);//adicona frame ao JDesktopPane  
                    objPerfilPSI.setVisible(true);
                }
            }
            try {
                objPerfilPSI.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jPerfilCarcerarioActionPerformed

    private void AgendaAtendimentoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaAtendimentoInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroAgendaAtendimentoInternoManuPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaCadastroAgendaAtendimentoInternoManuPSI) && codAbrirPSI == 1) {
            if (objAgendaAtendInt == null || objAgendaAtendInt.isClosed()) {
                objAgendaAtendInt = new TelaAgendamentoAtendimentoInternos();
                jPainelPsicologia.add(objAgendaAtendInt);
                objAgendaAtendInt.setVisible(true);
            } else {
                if (objAgendaAtendInt.isVisible()) {
                    if (objAgendaAtendInt.isIcon()) { // Se esta minimizado
                        try {
                            objAgendaAtendInt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAgendaAtendInt.toFront(); // traz para frente
                        objAgendaAtendInt.pack();//volta frame 
                    }
                } else {
                    objAgendaAtendInt = new TelaAgendamentoAtendimentoInternos();
                    TelaModuloPsicologia.jPainelPsicologia.add(objAgendaAtendInt);//adicona frame ao JDesktopPane  
                    objAgendaAtendInt.setVisible(true);
                }
            }
            try {
                objAgendaAtendInt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AgendaAtendimentoInternosActionPerformed

    private void HistoricoExternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoExternoActionPerformed
        // TODO add your handling code here:
        if (objMoviCrc == null || objMoviCrc.isClosed()) {
            objMoviCrc = new TelaMovimentacaoCrcPsicologia();
            jPainelPsicologia.add(objMoviCrc);
            objMoviCrc.setVisible(true);
        } else {
            if (objMoviCrc.isVisible()) {
                if (objMoviCrc.isIcon()) { // Se esta minimizado
                    try {
                        objMoviCrc.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMoviCrc.toFront(); // traz para frente
                    objMoviCrc.pack();//volta frame 
                }
            } else {
                objMoviCrc = new TelaMovimentacaoCrcPsicologia();
                TelaModuloPsicologia.jPainelPsicologia.add(objMoviCrc);//adicona frame ao JDesktopPane  
                objMoviCrc.setVisible(true);
            }
        }
        try {
            objMoviCrc.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoExternoActionPerformed

    private void RelatorioEntradaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloPsicologia.jPainelPsicologia.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaUnidadeActionPerformed

    private void jPaiNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaiNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPAIS_PSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaPAIS_PSI) && codAbrirPSI == 1) {
            if (objPAI_NOVO == null || objPAI_NOVO.isClosed()) {
                objPAI_NOVO = new TelaPAI_NOVO_Psicologia();
                jPainelPsicologia.add(objPAI_NOVO);
                objPAI_NOVO.setVisible(true);
            } else {
                if (objPAI_NOVO.isVisible()) {
                    if (objPAI_NOVO.isIcon()) { // Se esta minimizado
                        try {
                            objPAI_NOVO.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPAI_NOVO.toFront(); // traz para frente
                        objPAI_NOVO.pack();//volta frame 
                    }
                } else {
                    objPAI_NOVO = new TelaPAI_NOVO_Psicologia();
                    TelaModuloPsicologia.jPainelPsicologia.add(objPAI_NOVO);//adicona frame ao JDesktopPane  
                    objPAI_NOVO.setVisible(true);
                }
            }
            try {
                objPAI_NOVO.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jPaiNovoActionPerformed

    private void jRegistroAtendeInternoBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroAtendeInternoBioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoBioPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaRegistroAtendimentoBioPSI) && codAbrirPSI == 1) {
            if (objRegBioPSI == null || objRegBioPSI.isClosed()) {
                objRegBioPSI = new TelaRegistroInternosAtendimentoPSI();
                jPainelPsicologia.add(objRegBioPSI);
                objRegBioPSI.setVisible(true);
            } else {
                if (objRegBioPSI.isVisible()) {
                    if (objRegBioPSI.isIcon()) { // Se esta minimizado
                        try {
                            objRegBioPSI.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegBioPSI.toFront(); // traz para frente
                        objRegBioPSI.pack();//volta frame 
                    }
                } else {
                    objRegBioPSI = new TelaRegistroInternosAtendimentoPSI();
                    TelaModuloPsicologia.jPainelPsicologia.add(objRegBioPSI);//adicona frame ao JDesktopPane  
                    objRegBioPSI.setVisible(true);
                }
            }
            try {
                objRegBioPSI.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistroAtendeInternoBioActionPerformed

    private void RegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoImpBioPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaRegistroAtendimentoImpBioPSI) && codAbrirPSI == 1) {
            if (objAutoImp == null || objAutoImp.isClosed()) {
                objAutoImp = new TelaRegistroInternosAtendimentoImpressoPSI();
                jPainelPsicologia.add(objAutoImp);
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
                    objAutoImp = new TelaRegistroInternosAtendimentoImpressoPSI();
                    TelaModuloPsicologia.jPainelPsicologia.add(objAutoImp);//adicona frame ao JDesktopPane  
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

    private void jRelatorioAtendimentoPsicologicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioAtendimentoPsicologicoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioProducaoPsicologia objRelProdPsi = new TelaRelatorioProducaoPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objRelProdPsi);
        objRelProdPsi.show();
    }//GEN-LAST:event_jRelatorioAtendimentoPsicologicoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioTratamentoPsicologia objRelTP = new TelaRelatorioTratamentoPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objRelTP);
        objRelTP.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jCancelarRegistroAtendimentoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarRegistroAtendimentoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelAtendInternoPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaCancelAtendInternoPSI) && codAbrirPSI == 1) {
            if (objCancelaAtend == null || objCancelaAtend.isClosed()) {
                objCancelaAtend = new TelaCancelamentoAtendimentoPSP();
                jPainelPsicologia.add(objCancelaAtend);
                objCancelaAtend.setVisible(true);
            } else {
                if (objCancelaAtend.isVisible()) {
                    if (objCancelaAtend.isIcon()) { // Se esta minimizado
                        try {
                            objCancelaAtend.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCancelaAtend.toFront(); // traz para frente
                        objCancelaAtend.pack();//volta frame 
                    }
                } else {
                    objCancelaAtend = new TelaCancelamentoAtendimentoPSP();
                    TelaModuloPsicologia.jPainelPsicologia.add(objCancelaAtend);//adicona frame ao JDesktopPane  
                    objCancelaAtend.setVisible(true);
                }
            }
            try {
                objCancelaAtend.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCancelarRegistroAtendimentoInternoActionPerformed

    private void jTipoTratamentoPsicologicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoTratamentoPsicologicoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroTipoTratamentoPSI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaCadastroTipoTratamentoPSI) && codAbrirPSI == 1) {
            if (objTipoTrata == null || objTipoTrata.isClosed()) {
                objTipoTrata = new TelaTiposTratamentoPsicologico();
                jPainelPsicologia.add(objTipoTrata);
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
                    objTipoTrata = new TelaTiposTratamentoPsicologico();
                    TelaModuloPsicologia.jPainelPsicologia.add(objTipoTrata);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_jTipoTratamentoPsicologicoActionPerformed

    private void jAtendimentoPsicologicoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtendimentoPsicologicoGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoPSI_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaIndAtendimentoGrupoPSI_Manu) && codAbrirPSI == 1) {
            if (objAtendGrupo == null || objAtendGrupo.isClosed()) {
                objAtendGrupo = new TelaAtendimentoGrupoPSI();
                jPainelPsicologia.add(objAtendGrupo);
                objAtendGrupo.setVisible(true);
            } else {
                if (objAtendGrupo.isVisible()) {
                    if (objAtendGrupo.isIcon()) { // Se esta minimizado
                        try {
                            objAtendGrupo.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtendGrupo.toFront(); // traz para frente
                        objAtendGrupo.pack();//volta frame 
                    }
                } else {
                    objAtendGrupo = new TelaAtendimentoGrupoPSI();
                    TelaModuloPsicologia.jPainelPsicologia.add(objAtendGrupo);//adicona frame ao JDesktopPane  
                    objAtendGrupo.setVisible(true);
                }
            }
            try {
                objAtendGrupo.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jAtendimentoPsicologicoGrupoActionPerformed

    private void jPlanejamentoAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlanejamentoAtividadesActionPerformed
        // TODO add your handling code here:
         buscarAcessoUsuario(telaPlanejamentoAtividadesManu_PS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPSI.equals("ADMINISTRADORES") || codigoUserPSI == codUserAcessoPSI && nomeTelaPSI.equals(telaPlanejamentoAtividadesManu_PS) && codAbrirPSI == 1) {
            if (objAtividadePlan == null || objAtividadePlan.isClosed()) {
                objAtividadePlan = new TelaAtividadesEducacaoFisica();
                jPainelPsicologia.add(objAtividadePlan);
                objAtividadePlan.setVisible(true);
            } else {
                if (objAtividadePlan.isVisible()) {
                    if (objAtividadePlan.isIcon()) { // Se esta minimizado
                        try {
                            objAtividadePlan.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtividadePlan.toFront(); // traz para frente
                        objAtividadePlan.pack();//volta frame 
                    }
                } else {
                    objAtividadePlan = new TelaAtividadesEducacaoFisica();
                    TelaModuloPsicologia.jPainelPsicologia.add(objAtividadePlan);//adicona frame ao JDesktopPane  
                    objAtividadePlan.setVisible(true);
                }
            }
            try {
                objAtividadePlan.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jPlanejamentoAtividadesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdmissaoPsicologica;
    private javax.swing.JMenuItem AgendaAtendimentoInternos;
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem AtividadesExternas;
    private javax.swing.JMenuItem AtividadesInternas;
    private javax.swing.JMenuItem AvaliacaoPsicologica;
    private javax.swing.JMenuItem ConsultaLocalizacaoInternos;
    private javax.swing.JMenuItem ConsultaProntuarioInternos;
    private javax.swing.JMenuItem HistoricoExterno;
    private javax.swing.JMenuItem HistoricoMovimentacao;
    private javax.swing.JMenu ListagemAtividadesLaborativas;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem ListagemFrequenciaExterna;
    private javax.swing.JMenuItem LivroOcorrencias;
    private javax.swing.JMenuItem RegistroAtendimentoImpresso;
    private javax.swing.JMenuItem RelatorioAconpanhamentoFamiliar;
    private javax.swing.JMenuItem RelatorioEntradaUnidade;
    private javax.swing.JMenuItem RelatorioGeralConfere;
    private javax.swing.JMenuItem RelatorioVisitasInternos;
    private javax.swing.JMenu RelatoriosConfere;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem jAtendimentoPsicologicoGrupo;
    private javax.swing.JMenuItem jCancelarRegistroAtendimentoInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jPaiNovo;
    public static javax.swing.JDesktopPane jPainelPsicologia;
    private javax.swing.JMenuItem jPerfilCarcerario;
    private javax.swing.JMenuItem jPlanejamentoAtividades;
    private javax.swing.JMenuItem jRegistroAtendeInternoBio;
    private javax.swing.JMenu jRelatorioAtendimentoInternos;
    private javax.swing.JMenuItem jRelatorioAtendimentoPsicologico;
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
    private javax.swing.JMenuItem jTipoTratamentoPsicologico;
    // End of variables declaration//GEN-END:variables

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

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCrc objRecados = new TelaRecadosCrc();
                TelaModuloPsicologia.jPainelPsicologia.add(objRecados);
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

    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
        //CADASTRO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroAgendaAtendimentoInternoManuPSI + "'");
            conecta.rs.first();
            pNomeCAAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoBioPSI + "'");
            conecta.rs.first();
            pNomeRABP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoImpBioPSI + "'");
            conecta.rs.first();
            pNomeRAIB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoInciarLeitorPSI + "'");
            conecta.rs.first();
            pNomeRAIL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoColLiberadorPSI + "'");
            conecta.rs.first();
            pNomeRACL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelAtendInternoPSI + "'");
            conecta.rs.first();
            pNomeCAII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroTipoTratamentoPSI + "'");
            conecta.rs.first();
            pNomeTTP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PLANEJAMENTO DE ATIVIDADES EM GRUPO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPlanejamentoAtividadesManu_PS + "'");
            conecta.rs.first();
            pNomePAG_PS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CONSULTA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaConsultaProntuarioInternosDocPSI + "'");
            conecta.rs.first();
            pNomeCPID = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaMovimentacaoAdmIntManuPSI + "'");
            conecta.rs.first();
            pNomeMAIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaMovimentacaoEvolIntPSI + "'");
            conecta.rs.first();
            pNomeMEP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaMovimentacaoPareIntPSI + "'");
            conecta.rs.first();
            pNomeMPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTratamentoPsicologicoPSI + "'");
            conecta.rs.first();
            pNomeTP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaMovimentacaoAvalPsiIntPSI + "'");
            conecta.rs.first();
            pNomeMAP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //P.A.I.
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPAIS_PSI + "'");
            conecta.rs.first();
            pNomePPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGF_PSI + "'");
            conecta.rs.first();
            pNomePCCGF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFFam_PSI + "'");
            conecta.rs.first();
            pNomePCCGFa = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVis_PSI + "'");
            conecta.rs.first();
            pNomePCCGFVis = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVis_PSI + "'");
            conecta.rs.first();
            pNomePCCGFVis = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVisInt_PSI + "'");
            conecta.rs.first();
            pNomePCCGFVisInt = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDEME_PSI + "'");
            conecta.rs.first();
            pNomePDEME = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDPTL_PSI + "'");
            conecta.rs.first();
            pNomePDPTL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDJ_PSI + "'");
            conecta.rs.first();
            pNomePDJ = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDS_PSI + "'");
            conecta.rs.first();
            pNomePDS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEAPI1_PSI + "'");
            conecta.rs.first();
            pNomePEADPI1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEAPI2_PSI + "'");
            conecta.rs.first();
            pNomePEADPI2 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEPAI_PSI + "'");
            conecta.rs.first();
            pNomePEPAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaMovimetacaoOcrPSI + "'");
            conecta.rs.first();
            pNomeMO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilSocialManuPSI + "'");
            conecta.rs.first();
            pNomePSM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilSocialPerfCarPSI + "'");
            conecta.rs.first();
            pNomePSPC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PRORES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaManuPSI + "'");
            conecta.rs.first();
            pNomeIAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaEPSI + "'");
            conecta.rs.first();
            pNomeIAE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaPPSI + "'");
            conecta.rs.first();
            pNomeIAP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaCPSI + "'");
            conecta.rs.first();
            pNomeIAC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaTPSI + "'");
            conecta.rs.first();
            pNomeIAT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaPSIPSI + "'");
            conecta.rs.first();
            pNomeIAPS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaSPSI + "'");
            conecta.rs.first();
            pNomeIAS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ATIVIDADE EM GRUPO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPSI_Manu + "'");
            conecta.rs.first();
            pNomeAGM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPSI_Inte + "'");
            conecta.rs.first();
            pNomeAGI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPSI_Plan + "'");
            conecta.rs.first();
            pNomePLA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPSI_AVG + "'");
            conecta.rs.first();
            pNomeAVG = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPSI_AVI + "'");
            conecta.rs.first();
            pNomeAVI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + botaoEncerrar_PSI + "'");
            conecta.rs.first();
            pNomeBTE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + botaoLiberar_PSI + "'");
            conecta.rs.first();
            pNomeBTL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //  CADASTRO        
        if (!pNomeRABP.equals(telaRegistroAtendimentoBioPSI) || pNomeRABP == null || pNomeRABP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoBioPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAIB.equals(telaRegistroAtendimentoImpBioPSI) || pNomeRAIB == null || pNomeRAIB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoImpBioPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAIL.equals(telaRegistroAtendimentoInciarLeitorPSI) || pNomeRAIL == null || pNomeRAIL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoInciarLeitorPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRACL.equals(telaRegistroAtendimentoColLiberadorPSI) || pNomeRACL == null || pNomeRACL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoColLiberadorPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAII.equals(telaCancelAtendInternoPSI) || pNomeCAII == null || pNomeCAII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelAtendInternoPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTTP.equals(telaCadastroTipoTratamentoPSI) || pNomeTTP == null || pNomeTTP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroTipoTratamentoPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PLANEJAMENTO DE ATIVIDADES EM GRUPO
        if (!pNomePAG_PS.equals(telaPlanejamentoAtividadesManu_PS) || pNomePAG_PS == null || pNomePAG_PS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPlanejamentoAtividadesManu_PS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CONSULTA
        if (!pNomeCAAI.equals(telaCadastroAgendaAtendimentoInternoManuPSI) || pNomeCAAI == null || pNomeCAAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroAgendaAtendimentoInternoManuPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MENU CONSULTA
        if (!pNomeCPID.equals(telaConsultaProntuarioInternosDocPSI) || pNomeCPID == null || pNomeCPID.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaConsultaProntuarioInternosDocPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeMAIM.equals(telaMovimentacaoAdmIntManuPSI) || pNomeMAIM == null || pNomeMAIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaMovimentacaoAdmIntManuPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeMEP.equals(telaMovimentacaoEvolIntPSI) || pNomeMEP == null || pNomeMEP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaMovimentacaoEvolIntPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeMPI.equals(telaMovimentacaoPareIntPSI) || pNomeMPI == null || pNomeMPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaMovimentacaoPareIntPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTP.equals(telaTratamentoPsicologicoPSI) || pNomeTP == null || pNomeTP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTratamentoPsicologicoPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeMAP.equals(telaMovimentacaoAvalPsiIntPSI) || pNomeMAP == null || pNomeMAP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaMovimentacaoAvalPsiIntPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //P.A.I.
        if (!pNomePPM.equals(telaPAIS_PSI) || pNomePPM == null || pNomePPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPAIS_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGF.equals(telaPaiCCGF_PSI) || pNomePCCGF == null || pNomePCCGF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGF_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFa.equals(telaPaiCCGFFam_PSI) || pNomePCCGFa == null || pNomePCCGFa.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFFam_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFVis.equals(telaPaiCCGFVis_PSI) || pNomePCCGFVis == null || pNomePCCGFVis.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFVis_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFVisInt.equals(telaPaiCCGFVisInt_PSI) || pNomePCCGFVisInt == null || pNomePCCGFVisInt.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFVisInt_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDEME.equals(telaPaiDEME_PSI) || pNomePDEME == null || pNomePDEME.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDEME_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDPTL.equals(telaPaiDPTL_PSI) || pNomePDPTL == null || pNomePDPTL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDPTL_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDJ.equals(telaPaiDJ_PSI) || pNomePDJ == null || pNomePDJ.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDJ_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDS.equals(telaPaiDS_PSI) || pNomePDS == null || pNomePDS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDS_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEADPI1.equals(telaPaiEAPI1_PSI) || pNomePEADPI1 == null || pNomePEADPI1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEAPI1_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEADPI2.equals(telaPaiEAPI2_PSI) || pNomePEADPI2 == null || pNomePEADPI2.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEAPI2_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEPAI.equals(telaPaiEPAI_PSI) || pNomePEPAI == null || pNomePEPAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEPAI_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeMO.equals(telaMovimetacaoOcrPSI) || pNomeMO == null || pNomeMO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaMovimetacaoOcrPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePSM.equals(telaPerfilSocialManuPSI) || pNomePSM == null || pNomePSM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilSocialManuPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePSPC.equals(telaPerfilSocialPerfCarPSI) || pNomePSPC == null || pNomePSPC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilSocialPerfCarPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PRORES
        if (!pNomeIAM.equals(telaIndAcompanhaManuPSI) || pNomeIAM == null || pNomeIAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaManuPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAE.equals(telaIndAcompanhaAbaEPSI) || pNomeIAE == null || pNomeIAE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaEPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAP.equals(telaIndAcompanhaAbaPPSI) || pNomeIAP == null || pNomeIAP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaPPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAC.equals(telaIndAcompanhaAbaCPSI) || pNomeIAC == null || pNomeIAC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaCPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAT.equals(telaIndAcompanhaAbaTPSI) || pNomeIAT == null || pNomeIAT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaTPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAPS.equals(telaIndAcompanhaAbaPSIPSI) || pNomeIAPS == null || pNomeIAPS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaPSIPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAS.equals(telaIndAcompanhaAbaSPSI) || pNomeIAS == null || pNomeIAS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaSPSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ATIVIDADES EM GRUPO
        if (!pNomeAGM.equals(telaIndAtendimentoGrupoPSI_Manu) || pNomeAGM == null || pNomeAGM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPSI_Manu);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAGI.equals(telaIndAtendimentoGrupoPSI_Inte) || pNomeAGI == null || pNomeAGI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPSI_Inte);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePLA.equals(telaIndAtendimentoGrupoPSI_Plan) || pNomePLA == null || pNomePLA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPSI_Plan);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAVG.equals(telaIndAtendimentoGrupoPSI_AVG) || pNomeAVG == null || pNomeAVG.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPSI_AVG);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAVI.equals(telaIndAtendimentoGrupoPSI_AVI) || pNomeAVI == null || pNomeAVI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPSI_AVI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBTE.equals(botaoEncerrar_PSI) || pNomeBTE == null || pNomeBTE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(botaoEncerrar_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBTL.equals(botaoLiberar_PSI) || pNomeBTL == null || pNomeBTL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(botaoLiberar_PSI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloPSICOLOGIA + "'");
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
            codigoUserPSI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserPSI + "'");
            conecta.rs.first();
            codigoUserGroupPSI = conecta.rs.getInt("IdUsuario");
            codigoGrupoPSI = conecta.rs.getInt("IdGrupo");
            nomeGrupoPSI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserPSI + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoPSI = conecta.rs.getInt("IdUsuario");
            codAbrirPSI = conecta.rs.getInt("Abrir");
            codIncluirPSI = conecta.rs.getInt("Incluir");
            codAlterarPSI = conecta.rs.getInt("Alterar");
            codExcluirPSI = conecta.rs.getInt("Excluir");
            codGravarPSI = conecta.rs.getInt("Gravar");
            codConsultarPSI = conecta.rs.getInt("Consultar");
            nomeTelaPSI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
    
    public void PESQUISAR_LIBERACAO_implementacao() {
        PESQUISAR_IMPLEMENTA_ENF_001(telaCadastroAgendaAtendimentoInternoManuPSI);
        PESQUISAR_IMPLEMENTA_ENF_002(telaPlanejamentoAtividadesManu_PS);
        PESQUISAR_IMPLEMENTA_ENF_003(telaIndAtendimentoGrupoPSI_Manu);
    }

    public void PESQUISAR_IMPLEMENTA_ENF_001(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            AgendaAtendimentoInternos.setVisible(!true);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            AgendaAtendimentoInternos.setVisible(true);
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            AgendaAtendimentoInternos.setVisible(true);
        } else if (objParCrc.getHabilitarImp() == null) {
            AgendaAtendimentoInternos.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            AgendaAtendimentoInternos.setVisible(!true);
        } else {
            AgendaAtendimentoInternos.setVisible(true);
        }
    }

    public void PESQUISAR_IMPLEMENTA_ENF_002(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jPlanejamentoAtividades.setVisible(!true);
            jSeparator6.setVisible(!true);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jPlanejamentoAtividades.setVisible(true);
            jSeparator6.setVisible(true);
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jPlanejamentoAtividades.setVisible(true);
            jSeparator6.setVisible(true);
        } else if (objParCrc.getHabilitarImp() == null) {
            jPlanejamentoAtividades.setVisible(!true);
            jSeparator6.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jPlanejamentoAtividades.setVisible(!true);
            jSeparator6.setVisible(!true);
        } else {
            jPlanejamentoAtividades.setVisible(true);
            jSeparator6.setVisible(true);
        }
    }
    
    public void PESQUISAR_IMPLEMENTA_ENF_003(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAtendimentoPsicologicoGrupo.setVisible(!true);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAtendimentoPsicologicoGrupo.setVisible(true);
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAtendimentoPsicologicoGrupo.setVisible(true);
        } else if (objParCrc.getHabilitarImp() == null) {
            jAtendimentoPsicologicoGrupo.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jAtendimentoPsicologicoGrupo.setVisible(!true);
        } else {
            jAtendimentoPsicologicoGrupo.setVisible(true);
        }
    }
}
