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
import static gestor.Visao.TelaAgendaCompromissos.jDataLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jHoraInicio;
import static gestor.Visao.TelaAgendaCompromissos.jHoraLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jHoraTermino;
import static gestor.Visao.TelaAgendaCompromissos.jNomeUsuarioAgenda;
import static gestor.Visao.TelaAgendaCompromissos.jTabelaAgendaEventos;
import static gestor.Visao.TelaAgendaCompromissos.jTextoEvento;
import static gestor.Visao.TelaAlertaAgendaBeneficio.jTabelaAgendaInternos;
import static gestor.Visao.TelaAgendaCompromissos.jDataInicio;
import static gestor.Visao.TelaAgendaCompromissos.jDataTermino;
import static gestor.Visao.TelaAgendaCompromissos.jtotalRegistros;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloServicoSocial.codAbrirSS;
import static gestor.Visao.TelaModuloServicoSocial.codUserAcessoSS;
import static gestor.Visao.TelaModuloServicoSocial.codigoUserSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeGrupoSS;
import static gestor.Visao.TelaModuloServicoSocial.nomeTelaSS;
import static gestor.Visao.TelaModuloServicoSocial.telaPAISS;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class TelaModuloJuridico extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    //
    private TelaConsultaProntuarioInternoCrc objriIntJu = null;
    private TelaConsultaLocalInternoJuridico objLocalIntJu = null;
    private TelaMovHistoricoTecnicoJuridico objMovJuri = null;
    private TelaAtendimentoJuridico objAtedJuri = null;
    private TelaRecadosJuridico objRecaJuri = null;
    private TelaAtendimentoFamiliarJuridico objAtenFam = null;
    private TelaOcorrenciaJuridico objOcorreJuridico = null;
    private TelaAtividadeRealizadas objAtivRea = null;
    private TelaAudienciaJustificativa objAudJus = null;
    private TelaFichaJuridica objFichaJuri = null;
    private TelaAmparoLegal objAmparo = null;
    private TelaNaturezaPrisao objNatP = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaAgendamentoBeneficiosInterno objAgendaBene = null;
    private TelaPAI_NOVO objPaiNovo = null;
    private TelaRegistroInternosAtendimentoJURI objRegAtendJURI = null;
    private TelaRegistroInternosAtendimentoImpressoJURI objAutoImp = null;
    //
    public static String nomeModuloJURI = "JURIDICO";
    Calendar agenda = new GregorianCalendar();
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    Date dataAgendaComp;
    public static String nomeUrl = "cmd.exe /C start http://www.jf.jus.br/portaljf//";
    String dataAgenda;
    String statusRegistro = "Não Realizado";
    String statusRegistroAgenda = "Não Realizado";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
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
    public static int codigoUserJURI = 0;
    public static int codUserAcessoJURI = 0;
    public static int codigoUserGroupJURI = 0;
    public static int codAbrirJURI = 0;
    public static int codIncluirJURI = 0;
    public static int codAlterarJURI = 0;
    public static int codExcluirJURI = 0;
    public static int codGravarJURI = 0;
    public static int codConsultarJURI = 0;
    public static int codigoGrupoJURI = 0;
    public static String nomeGrupoJURI = "";
    public static String nomeTelaJURI = "";
    //
    public static String nomeModuloJURIDICO = "JURIDICO";
    // MENU CADASTRO   
    public static String telaAtividadesJuridicasJURI = "Cadastro:Atividades Juridicas:Manutenção";
    public static String telaAmparaoLegalJURI = "Cadastro:Amparo Legal:Manutenção";
    public static String telaNaturezaPrisaoJURI = "Cadastro:Natureza da Prisão:Manutenção";
    public static String telaRegistroBiometriaJURI = "Cadastro:Registro Interno para Atendimento - Juridico:Manutenção";
    public static String telaRegistroBiometriaInciarLeitorJURI = "Cadastro:Registro Interno para Atendimento - Juridico:Iniciar Leitor";
    // REGISTRO DE INTERNO IMPRESSO
    public static String telaRegistroAtenImpJURI = "Cadastro:Registro de Atendimento de Internos Impresso - Juridico";
    public static String telaRegistroLibAtenImpJURI = "Cadastro:Registro de Atendimento de Internos Impresso - Juridico:Liberação";
    //CONSULTA   
    public static String telaConsultaProntuarioInternosDocJURI = "Consulta:Prontuario:Documentos";
    // MOVIMENTAÇÃO
    public static String telaAtendimentoJuridicoManuJURI = "Movimentação:Atendimento Juridico:Manutenção";
    public static String telaAtendimentoJuridicoaAtividadesJURI = "Movimentação:Atendimento Juridico:Atividades";
    public static String telaAtendimentoJuridicoEvolucaoJURI = "Movimentação:Evolução Juridica de Internos";
    //
    public static String telaCadastroFichaJuridicaManutencaoJURI = "Movimentação:Cadastro de Ficha Juridica:Manutenção";
    public static String telaCadastroFichaJuridicaProcessoJURI = "Movimentação:Cadastro de Ficha Juridica:Processos";
    public static String telaCadastroFichaJuridicaIncidênciaPenalJURI = "Movimentação:Cadastro de Ficha Juridica:Incidência Penal";
    public static String telaCadastroFichaJuridicaDocumentosProcessoJURI = "Movimentação:Cadastro de Ficha Juridica:Documentos Processo";
    //
    public static String telaAgendamentoBeneficioManuJURI = "Movimentação:Agendamento de Benefícios:Manutenção";
    //
    public static String telaAtendimentoFamiliarManuJURI = "Movimentação:AtendimentoFamiliar:Manutenção";
    //
    public static String telaAudienciaJustificativaManuJURI = "Movimentação:Audiência de Justificativa:Manutenção";
    //
    public static String telaOcorrenciaJURI = "Movimentação:Ocorrências Diárias - Juídico:Manutenção";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeAJ = "";
    String pNomeAL = "";
    String pNomeNP = "";
    String pNomeRB = "";
    String pNomeRBIL = "";
    String pNomeRAI = "";
    String pNomeRLAI = "";
    // MENU CONULTA
    String pNomeCPID = "";
    // ATENDIMENTO JURIDICO
    String pNomeAJM_JURI = "";
    String pNomeAJA_JURI = "";
    String pNomeAJE_JURI = "";
    // FICHA JURIDICA
    String pNomeCFJM_JURI = "";
    String pNomeCFJP_JURI = "";
    String pNomeCFJI_JURI = "";
    String pNomeCFJD_JURI = "";
    //
    String pNomeABM_JURI = "";
    //
    String pNomeAFM_JURI = "";
    //
    String pNomeADJM_JURI = "";
    //
    String pNomeOcrJURI = "";

    /**
     * Creates new form TelaJuridico
     */
    public TelaModuloJuridico() {
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

        jPainelJuridico = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        AtividadesJuridicas = new javax.swing.JMenuItem();
        AmparoLegal = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        NaturezaPrisao = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        RegistroAtendimentoBiometrico = new javax.swing.JMenuItem();
        RegsitroAtendimentoImpressao = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        AgendaEventos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ProntuarioInternos = new javax.swing.JMenuItem();
        LocalizacaoInterno = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        HistoricoMovimentacao = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        AtendimentoJuridico = new javax.swing.JMenuItem();
        jPai = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        Beneficios = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        AtendimentoFamiliar = new javax.swing.JMenuItem();
        AtendimentoJudiciario = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencia = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        RelatorioGeralInternosPavilhao = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        RelatorioPrevisaoSaidaInternos = new javax.swing.JMenuItem();
        RelatorioAgendamentoBenecifio = new javax.swing.JMenuItem();
        RelatorioQuantitativoAtividadeLab = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        RrelatorioSaidaBeneficio = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RelatorioInternosRegimePenal = new javax.swing.JMenuItem();
        RelatorioInternosRegimePenalSexo = new javax.swing.JMenuItem();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        Utilitarios = new javax.swing.JMenu();
        CalculadoraPena = new javax.swing.JMenuItem();
        jCalculadoraPena1 = new javax.swing.JMenuItem();
        CalculadoraWindows = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Jurídico :::...");

        jPainelJuridico.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelJuridico.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelJuridicoLayout = new javax.swing.GroupLayout(jPainelJuridico);
        jPainelJuridico.setLayout(jPainelJuridicoLayout);
        jPainelJuridicoLayout.setHorizontalGroup(
            jPainelJuridicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelJuridicoLayout.setVerticalGroup(
            jPainelJuridicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelJuridicoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        Cadastros.setText("Cadastros");

        AtividadesJuridicas.setText("Atividades Juridicas");
        AtividadesJuridicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtividadesJuridicasActionPerformed(evt);
            }
        });
        Cadastros.add(AtividadesJuridicas);

        AmparoLegal.setText("Amparo Legal");
        AmparoLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmparoLegalActionPerformed(evt);
            }
        });
        Cadastros.add(AmparoLegal);
        Cadastros.add(jSeparator9);

        NaturezaPrisao.setText("Natureza da Prisão");
        NaturezaPrisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NaturezaPrisaoActionPerformed(evt);
            }
        });
        Cadastros.add(NaturezaPrisao);
        Cadastros.add(jSeparator2);

        jMenu1.setForeground(new java.awt.Color(0, 102, 0));
        jMenu1.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        RegistroAtendimentoBiometrico.setForeground(new java.awt.Color(255, 0, 0));
        RegistroAtendimentoBiometrico.setText("Registrar  Atendimento por Biometria");
        RegistroAtendimentoBiometrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoBiometricoActionPerformed(evt);
            }
        });
        jMenu1.add(RegistroAtendimentoBiometrico);

        RegsitroAtendimentoImpressao.setForeground(new java.awt.Color(0, 0, 204));
        RegsitroAtendimentoImpressao.setText("Registro Atendimento por Impressão");
        RegsitroAtendimentoImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegsitroAtendimentoImpressaoActionPerformed(evt);
            }
        });
        jMenu1.add(RegsitroAtendimentoImpressao);

        Cadastros.add(jMenu1);
        Cadastros.add(jSeparator10);

        AgendaEventos.setText("Agenda de Compromissos Pessoal");
        AgendaEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaEventosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaEventos);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);
        Cadastros.add(jSeparator4);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        Consultas.setText("Consultas");

        ProntuarioInternos.setText("Prontuários de Internos");
        ProntuarioInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProntuarioInternosActionPerformed(evt);
            }
        });
        Consultas.add(ProntuarioInternos);

        LocalizacaoInterno.setText("Localização de Internos");
        LocalizacaoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalizacaoInternoActionPerformed(evt);
            }
        });
        Consultas.add(LocalizacaoInterno);
        Consultas.add(jSeparator6);

        HistoricoMovimentacao.setText("Histórico de Movimentação de Internos");
        HistoricoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovimentacaoActionPerformed(evt);
            }
        });
        Consultas.add(HistoricoMovimentacao);

        jMenuBar1.add(Consultas);

        Movimentacao.setText("Movimentação");

        AtendimentoJuridico.setText("Admissão/Atendimento Jurídico");
        AtendimentoJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoJuridicoActionPerformed(evt);
            }
        });
        Movimentacao.add(AtendimentoJuridico);

        jPai.setForeground(new java.awt.Color(0, 0, 255));
        jPai.setText("P.A.I. - Programa de Assistência Individualizado - NOVO");
        jPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaiActionPerformed(evt);
            }
        });
        Movimentacao.add(jPai);
        Movimentacao.add(jSeparator5);

        jMenuItem1.setText("Ficha Jurídica");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Movimentacao.add(jMenuItem1);

        Beneficios.setText("Agendamento de Benefícios de Internos");
        Beneficios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeneficiosActionPerformed(evt);
            }
        });
        Movimentacao.add(Beneficios);
        Movimentacao.add(jSeparator1);

        AtendimentoFamiliar.setText("Atendimento Familiar");
        AtendimentoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoFamiliarActionPerformed(evt);
            }
        });
        Movimentacao.add(AtendimentoFamiliar);

        AtendimentoJudiciario.setText("Audiência de Justificativa");
        AtendimentoJudiciario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoJudiciarioActionPerformed(evt);
            }
        });
        Movimentacao.add(AtendimentoJudiciario);
        Movimentacao.add(jSeparator7);

        LivroOcorrencia.setText("Livro de Ocorrências");
        LivroOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciaActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencia);

        jMenuBar1.add(Movimentacao);

        Relatorios.setText("Relatórios");

        RelatorioGeralInternosPavilhao.setText("Relatório Geral de Internos no Pavilão/Celas");
        RelatorioGeralInternosPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralInternosPavilhaoActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioGeralInternosPavilhao);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        Relatorios.add(ListagemConfere);
        Relatorios.add(jSeparator3);

        RelatorioPrevisaoSaidaInternos.setText("Relatório de Previsão de Saída de Internos");
        RelatorioPrevisaoSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaInternosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioPrevisaoSaidaInternos);

        RelatorioAgendamentoBenecifio.setText("Relatório de Agendamento de Benefícios");
        RelatorioAgendamentoBenecifio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAgendamentoBenecifioActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioAgendamentoBenecifio);

        RelatorioQuantitativoAtividadeLab.setText("Relatório Quantitativo Atividade Laborativa");
        RelatorioQuantitativoAtividadeLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioQuantitativoAtividadeLabActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioQuantitativoAtividadeLab);

        jMenu2.setForeground(new java.awt.Color(0, 102, 0));
        jMenu2.setText("Relatórios de Saídas de Internos da Unidade");

        RrelatorioSaidaBeneficio.setForeground(new java.awt.Color(0, 0, 204));
        RrelatorioSaidaBeneficio.setText("Relatório de Saídas Por Beneficio");
        RrelatorioSaidaBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RrelatorioSaidaBeneficioActionPerformed(evt);
            }
        });
        jMenu2.add(RrelatorioSaidaBeneficio);

        jMenuItem3.setForeground(new java.awt.Color(204, 0, 0));
        jMenuItem3.setText("Relatório de Saída de Internos na Portaria");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        Relatorios.add(jMenu2);
        Relatorios.add(jSeparator8);

        RelatorioInternosRegimePenal.setText("Relatório de Internos por Regime Penal");
        RelatorioInternosRegimePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosRegimePenalActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioInternosRegimePenal);

        RelatorioInternosRegimePenalSexo.setText("Relatório de Internos por Regime Penal e Sexo");
        RelatorioInternosRegimePenalSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosRegimePenalSexoActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioInternosRegimePenalSexo);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaInternosUnidade);

        jMenuBar1.add(Relatorios);

        Utilitarios.setText("Utilitários");

        CalculadoraPena.setText("Calculadora de Pena");
        CalculadoraPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculadoraPenaActionPerformed(evt);
            }
        });
        Utilitarios.add(CalculadoraPena);

        jCalculadoraPena1.setText("Calculadora de Pena 1");
        jCalculadoraPena1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalculadoraPena1ActionPerformed(evt);
            }
        });
        Utilitarios.add(jCalculadoraPena1);

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
            .addComponent(jPainelJuridico)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelJuridico)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void CalculadoraPenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculadoraPenaActionPerformed
        // TODO add your handling code here:
        calcPena();
    }//GEN-LAST:event_CalculadoraPenaActionPerformed

    private void CalculadoraWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculadoraWindowsActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_CalculadoraWindowsActionPerformed

    private void ProntuarioInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProntuarioInternosActionPerformed
        // TODO add your handling code here: 
        if (objriIntJu == null || objriIntJu.isClosed()) {
            objriIntJu = new TelaConsultaProntuarioInternoCrc();
            jPainelJuridico.add(objriIntJu);
            objriIntJu.setVisible(true);
        } else {
            if (objriIntJu.isVisible()) {
                if (objriIntJu.isIcon()) { // Se esta minimizado
                    try {
                        objriIntJu.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objriIntJu.toFront(); // traz para frente
                    objriIntJu.pack();//volta frame 
                }
            } else {
                objriIntJu = new TelaConsultaProntuarioInternoCrc();
                TelaModuloJuridico.jPainelJuridico.add(objriIntJu);//adicona frame ao JDesktopPane  
                objriIntJu.setVisible(true);
            }
        }
        try {
            objriIntJu.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProntuarioInternosActionPerformed

    private void LocalizacaoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalizacaoInternoActionPerformed
        // TODO add your handling code here:
        if (objLocalIntJu == null || objLocalIntJu.isClosed()) {
            objLocalIntJu = new TelaConsultaLocalInternoJuridico();
            jPainelJuridico.add(objLocalIntJu);
            objLocalIntJu.setVisible(true);
        } else {
            if (objLocalIntJu.isVisible()) {
                if (objLocalIntJu.isIcon()) { // Se esta minimizado
                    try {
                        objLocalIntJu.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalIntJu.toFront(); // traz para frente
                    objLocalIntJu.pack();//volta frame 
                }
            } else {
                objLocalIntJu = new TelaConsultaLocalInternoJuridico();
                TelaModuloJuridico.jPainelJuridico.add(objLocalIntJu);//adicona frame ao JDesktopPane  
                objLocalIntJu.setVisible(true);
            }
        }
        try {
            objLocalIntJu.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalizacaoInternoActionPerformed

    private void HistoricoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovimentacaoActionPerformed
        // TODO add your handling code here:
        if (objMovJuri == null || objMovJuri.isClosed()) {
            objMovJuri = new TelaMovHistoricoTecnicoJuridico();
            jPainelJuridico.add(objMovJuri);
            objMovJuri.setVisible(true);
        } else {
            if (objMovJuri.isVisible()) {
                if (objMovJuri.isIcon()) { // Se esta minimizado
                    try {
                        objMovJuri.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMovJuri.toFront(); // traz para frente
                    objMovJuri.pack();//volta frame 
                }
            } else {
                objMovJuri = new TelaMovHistoricoTecnicoJuridico();
                TelaModuloJuridico.jPainelJuridico.add(objMovJuri);//adicona frame ao JDesktopPane  
                objMovJuri.setVisible(true);
            }
        }
        try {
            objMovJuri.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoActionPerformed

    private void AtendimentoJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoJuridicoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoManuJURI) && codAbrirJURI == 1) {
            if (objAtedJuri == null || objAtedJuri.isClosed()) {
                objAtedJuri = new TelaAtendimentoJuridico();
                jPainelJuridico.add(objAtedJuri);
                objAtedJuri.setVisible(true);
            } else {
                if (objAtedJuri.isVisible()) {
                    if (objAtedJuri.isIcon()) { // Se esta minimizado
                        try {
                            objAtedJuri.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtedJuri.toFront(); // traz para frente
                        objAtedJuri.pack();//volta frame 
                    }
                } else {
                    objAtedJuri = new TelaAtendimentoJuridico();
                    TelaModuloJuridico.jPainelJuridico.add(objAtedJuri);//adicona frame ao JDesktopPane  
                    objAtedJuri.setVisible(true);
                }
            }
            try {
                objAtedJuri.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoJuridicoActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecaJuri == null || objRecaJuri.isClosed()) {
            objRecaJuri = new TelaRecadosJuridico();
            jPainelJuridico.add(objRecaJuri);
            objRecaJuri.setVisible(true);
        } else {
            if (objRecaJuri.isVisible()) {
                if (objRecaJuri.isIcon()) { // Se esta minimizado
                    try {
                        objRecaJuri.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecaJuri.toFront(); // traz para frente
                    objRecaJuri.pack();//volta frame 
                }
            } else {
                objRecaJuri = new TelaRecadosJuridico();
                TelaModuloJuridico.jPainelJuridico.add(objRecaJuri);//adicona frame ao JDesktopPane  
                objRecaJuri.setVisible(true);
            }
        }
        try {
            objRecaJuri.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void RelatorioGeralInternosPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralInternosPavilhaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemGeralConfere.jasper";
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO INNER JOIN PRONTUARIOSCRC ON ITENSLOCACAOINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc INNER JOIN CELAS ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela INNER JOIN PAVILHAO ON CELAS.IdPav=PAVILHAO.IdPav ORDER BY DescricaoPav,PRONTUARIOSCRC.NomeInternoCrc,CELAS.EndCelaPav");
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
    }//GEN-LAST:event_RelatorioGeralInternosPavilhaoActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConf = new TelaRelatorioConfere();
        TelaModuloJuridico.jPainelJuridico.add(objRelConf);
        objRelConf.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void RelatorioPrevisaoSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevSaidaIntJuridico objRelPrevSai = new TelaRelatorioPrevSaidaIntJuridico();
        TelaModuloJuridico.jPainelJuridico.add(objRelPrevSai);
        objRelPrevSai.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaInternosActionPerformed

    private void AtendimentoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoFamiliarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoFamiliarManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoFamiliarManuJURI) && codAbrirJURI == 1) {
            if (objAtenFam == null || objAtenFam.isClosed()) {
                objAtenFam = new TelaAtendimentoFamiliarJuridico();
                jPainelJuridico.add(objAtenFam);
                objAtenFam.setVisible(true);
            } else {
                if (objAtenFam.isVisible()) {
                    if (objAtenFam.isIcon()) { // Se esta minimizado
                        try {
                            objAtenFam.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtenFam.toFront(); // traz para frente
                        objAtenFam.pack();//volta frame 
                    }
                } else {
                    objAtenFam = new TelaAtendimentoFamiliarJuridico();
                    TelaModuloJuridico.jPainelJuridico.add(objAtenFam);//adicona frame ao JDesktopPane  
                    objAtenFam.setVisible(true);
                }
            }
            try {
                objAtenFam.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoFamiliarActionPerformed

    private void LivroOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaOcorrenciaJURI) && codAbrirJURI == 1) {
            if (objOcorreJuridico == null || objOcorreJuridico.isClosed()) {
                objOcorreJuridico = new TelaOcorrenciaJuridico();
                jPainelJuridico.add(objOcorreJuridico);
                objOcorreJuridico.setVisible(true);
            } else {
                if (objOcorreJuridico.isVisible()) {
                    if (objOcorreJuridico.isIcon()) { // Se esta minimizado
                        try {
                            objOcorreJuridico.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcorreJuridico.toFront(); // traz para frente
                        objOcorreJuridico.pack();//volta frame 
                    }
                } else {
                    objOcorreJuridico = new TelaOcorrenciaJuridico();
                    TelaModuloJuridico.jPainelJuridico.add(objOcorreJuridico);//adicona frame ao JDesktopPane  
                    objOcorreJuridico.setVisible(true);
                }
            }
            try {
                objOcorreJuridico.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciaActionPerformed

    private void AtividadesJuridicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtividadesJuridicasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtividadesJuridicasJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtividadesJuridicasJURI) && codAbrirJURI == 1) {
            if (objAtivRea == null || objAtivRea.isClosed()) {
                objAtivRea = new TelaAtividadeRealizadas();
                jPainelJuridico.add(objAtivRea);
                objAtivRea.setVisible(true);
            } else {
                if (objAtivRea.isVisible()) {
                    if (objAtivRea.isIcon()) { // Se esta minimizado
                        try {
                            objAtivRea.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtivRea.toFront(); // traz para frente
                        objAtivRea.pack();//volta frame 
                    }
                } else {
                    objAtivRea = new TelaAtividadeRealizadas();
                    TelaModuloJuridico.jPainelJuridico.add(objAtivRea);//adicona frame ao JDesktopPane  
                    objAtivRea.setVisible(true);
                }
            }
            try {
                objAtivRea.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtividadesJuridicasActionPerformed

    private void AtendimentoJudiciarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoJudiciarioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAudienciaJustificativaManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAudienciaJustificativaManuJURI) && codAbrirJURI == 1) {
            if (objAudJus == null || objAudJus.isClosed()) {
                objAudJus = new TelaAudienciaJustificativa();
                jPainelJuridico.add(objAudJus);
                objAudJus.setVisible(true);
            } else {
                if (objAudJus.isVisible()) {
                    if (objAudJus.isIcon()) { // Se esta minimizado
                        try {
                            objAudJus.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAudJus.toFront(); // traz para frente
                        objAudJus.pack();//volta frame 
                    }
                } else {
                    objAudJus = new TelaAudienciaJustificativa();
                    TelaModuloJuridico.jPainelJuridico.add(objAudJus);//adicona frame ao JDesktopPane  
                    objAudJus.setVisible(true);
                }
            }
            try {
                objAudJus.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoJudiciarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroFichaJuridicaManutencaoJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaCadastroFichaJuridicaManutencaoJURI) && codAbrirJURI == 1) {
            if (objFichaJuri == null || objFichaJuri.isClosed()) {
                objFichaJuri = new TelaFichaJuridica();
                jPainelJuridico.add(objFichaJuri);
                objFichaJuri.setVisible(true);
            } else {
                if (objFichaJuri.isVisible()) {
                    if (objFichaJuri.isIcon()) { // Se esta minimizado
                        try {
                            objFichaJuri.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objFichaJuri.toFront(); // traz para frente
                        objFichaJuri.pack();//volta frame 
                    }
                } else {
                    objFichaJuri = new TelaFichaJuridica();
                    TelaModuloJuridico.jPainelJuridico.add(objFichaJuri);//adicona frame ao JDesktopPane  
                    objFichaJuri.setVisible(true);
                }
            }
            try {
                objFichaJuri.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void AmparoLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmparoLegalActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAmparaoLegalJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAmparaoLegalJURI) && codAbrirJURI == 1) {
            if (objAmparo == null || objAmparo.isClosed()) {
                objAmparo = new TelaAmparoLegal();
                jPainelJuridico.add(objAmparo);
                objAmparo.setVisible(true);
            } else {
                if (objAmparo.isVisible()) {
                    if (objAmparo.isIcon()) { // Se esta minimizado
                        try {
                            objAmparo.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAmparo.toFront(); // traz para frente
                        objAmparo.pack();//volta frame 
                    }
                } else {
                    objAmparo = new TelaAmparoLegal();
                    TelaModuloJuridico.jPainelJuridico.add(objAmparo);//adicona frame ao JDesktopPane  
                    objAmparo.setVisible(true);
                }
            }
            try {
                objAmparo.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AmparoLegalActionPerformed

    private void NaturezaPrisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NaturezaPrisaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaNaturezaPrisaoJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaNaturezaPrisaoJURI) && codAbrirJURI == 1) {
            if (objNatP == null || objNatP.isClosed()) {
                objNatP = new TelaNaturezaPrisao();
                jPainelJuridico.add(objNatP);
                objNatP.setVisible(true);
            } else {
                if (objNatP.isVisible()) {
                    if (objNatP.isIcon()) { // Se esta minimizado
                        try {
                            objNatP.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objNatP.toFront(); // traz para frente
                        objNatP.pack();//volta frame 
                    }
                } else {
                    objNatP = new TelaNaturezaPrisao();
                    TelaModuloJuridico.jPainelJuridico.add(objNatP);//adicona frame ao JDesktopPane  
                    objNatP.setVisible(true);
                }
            }
            try {
                objNatP.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_NaturezaPrisaoActionPerformed

    private void AgendaEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaEventosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelJuridico.add(objAgEventos);
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
                TelaModuloJuridico.jPainelJuridico.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaEventosActionPerformed

    private void BeneficiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeneficiosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAgendamentoBeneficioManuJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAgendamentoBeneficioManuJURI) && codAbrirJURI == 1) {
            if (objAgendaBene == null || objAgendaBene.isClosed()) {
                objAgendaBene = new TelaAgendamentoBeneficiosInterno();
                jPainelJuridico.add(objAgendaBene);
                objAgendaBene.setVisible(true);
            } else {
                if (objAgendaBene.isVisible()) {
                    if (objAgendaBene.isIcon()) { // Se esta minimizado
                        try {
                            objAgendaBene.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAgendaBene.toFront(); // traz para frente
                        objAgendaBene.pack();//volta frame 
                    }
                } else {
                    objAgendaBene = new TelaAgendamentoBeneficiosInterno();
                    TelaModuloJuridico.jPainelJuridico.add(objAgendaBene);//adicona frame ao JDesktopPane  
                    objAgendaBene.setVisible(true);
                }
            }
            try {
                objAgendaBene.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_BeneficiosActionPerformed

    private void RelatorioAgendamentoBenecifioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAgendamentoBenecifioActionPerformed
        // TODO add your handling code here:
        TelaRelatorioAgendamentoBeneficiosInternos objRelAgenda = new TelaRelatorioAgendamentoBeneficiosInternos();
        TelaModuloJuridico.jPainelJuridico.add(objRelAgenda);
        objRelAgenda.show();
    }//GEN-LAST:event_RelatorioAgendamentoBenecifioActionPerformed

    private void RelatorioQuantitativoAtividadeLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioQuantitativoAtividadeLabActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioAtividadesLaborativa.jasper";
            conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_LABORATIVA_EXTERNA "
                    + "INNER JOIN FREQUENCIA_LABORATIVA_EXTERNA "
                    + "ON ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdFreqLab=FREQUENCIA_LABORATIVA_EXTERNA.IdFreqLab "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY PRONTUARIOSCRC.IdInternoCrc, ITENS_FREQUENCIA_LABORATIVA_EXTERNA.IdItem, ITENS_FREQUENCIA_LABORATIVA_EXTERNA.AnoReferencia");
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
    }//GEN-LAST:event_RelatorioQuantitativoAtividadeLabActionPerformed

    private void jCalculadoraPena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalculadoraPena1ActionPerformed
        // TODO add your handling code here:
        calcPena1();
    }//GEN-LAST:event_jCalculadoraPena1ActionPerformed

    private void RelatorioInternosRegimePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosRegimePenalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosRegime.jasper";
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
            parametros.put("descricaoUnidade", descricaoUnidade);
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

    private void RelatorioInternosRegimePenalSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosRegimePenalSexoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioInternoRegimeSexo objRelIntReg = new TelaRelatorioInternoRegimeSexo();
        TelaModuloJuridico.jPainelJuridico.add(objRelIntReg);
        objRelIntReg.show();
    }//GEN-LAST:event_RelatorioInternosRegimePenalSexoActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloJuridico.jPainelJuridico.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void jPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaiActionPerformed
        // TODO add your handling code here:
        //ACCESSO DIFERENCIADO, A ORIGEM É O SERVIÇO SOCIAL, CADASTRAR O MÓDULO PARA O JURIDICO COM PERMISSÃO DE NÃO
        // E LIBERAR SOMENTE A TELA PRINCIPAL E A ABA DJ, QUE PERTENCE AO JURIDICO
        buscarAcessoUsuario(telaPAISS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaPAISS) && codAbrirSS == 1) {
            if (objPaiNovo == null || objPaiNovo.isClosed()) {
                objPaiNovo = new TelaPAI_NOVO();
                jPainelJuridico.add(objPaiNovo);
                objPaiNovo.setVisible(true);
            } else {
                if (objPaiNovo.isVisible()) {
                    if (objPaiNovo.isIcon()) { // Se esta minimizado
                        try {
                            objPaiNovo.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPaiNovo.toFront(); // traz para frente
                        objPaiNovo.pack();//volta frame 
                    }
                } else {
                    objPaiNovo = new TelaPAI_NOVO();
                    TelaModuloJuridico.jPainelJuridico.add(objPaiNovo);//adicona frame ao JDesktopPane  
                    objPaiNovo.setVisible(true);
                }
            }
            try {
                objPaiNovo.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jPaiActionPerformed

    private void RegistroAtendimentoBiometricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoBiometricoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroBiometriaJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaRegistroBiometriaJURI) && codAbrirJURI == 1) {
            if (objRegAtendJURI == null || objRegAtendJURI.isClosed()) {
                objRegAtendJURI = new TelaRegistroInternosAtendimentoJURI();
                jPainelJuridico.add(objRegAtendJURI);
                objRegAtendJURI.setVisible(true);
            } else {
                if (objRegAtendJURI.isVisible()) {
                    if (objRegAtendJURI.isIcon()) { // Se esta minimizado
                        try {
                            objRegAtendJURI.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegAtendJURI.toFront(); // traz para frente
                        objRegAtendJURI.pack();//volta frame 
                    }
                } else {
                    objRegAtendJURI = new TelaRegistroInternosAtendimentoJURI();
                    TelaModuloJuridico.jPainelJuridico.add(objRegAtendJURI);//adicona frame ao JDesktopPane  
                    objRegAtendJURI.setVisible(true);
                }
            }
            try {
                objRegAtendJURI.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroAtendimentoBiometricoActionPerformed

    private void RegsitroAtendimentoImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegsitroAtendimentoImpressaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtenImpJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaRegistroAtenImpJURI) && codAbrirJURI == 1) {
            if (objAutoImp == null || objAutoImp.isClosed()) {
                objAutoImp = new TelaRegistroInternosAtendimentoImpressoJURI();
                jPainelJuridico.add(objAutoImp);
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
                    objAutoImp = new TelaRegistroInternosAtendimentoImpressoJURI();
                    TelaModuloJuridico.jPainelJuridico.add(objAutoImp);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_RegsitroAtendimentoImpressaoActionPerformed

    private void RrelatorioSaidaBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RrelatorioSaidaBeneficioActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidas objRelaSaidas = new TelaRelatorioSaidas();
        TelaModuloJuridico.jPainelJuridico.add(objRelaSaidas);
        objRelaSaidas.show();
    }//GEN-LAST:event_RrelatorioSaidaBeneficioActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidaInternosPorData objRelaSaidaPort = new TelaRelatorioSaidaInternosPorData();
        TelaModuloJuridico.jPainelJuridico.add(objRelaSaidaPort);
        objRelaSaidaPort.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaEventos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem AmparoLegal;
    private javax.swing.JMenuItem AtendimentoFamiliar;
    private javax.swing.JMenuItem AtendimentoJudiciario;
    private javax.swing.JMenuItem AtendimentoJuridico;
    private javax.swing.JMenuItem AtividadesJuridicas;
    private javax.swing.JMenuItem Beneficios;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem CalculadoraPena;
    private javax.swing.JMenuItem CalculadoraWindows;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem HistoricoMovimentacao;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LivroOcorrencia;
    private javax.swing.JMenuItem LocalizacaoInterno;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem NaturezaPrisao;
    private javax.swing.JMenuItem ProntuarioInternos;
    private javax.swing.JMenuItem RegistroAtendimentoBiometrico;
    private javax.swing.JMenuItem RegsitroAtendimentoImpressao;
    private javax.swing.JMenuItem RelatorioAgendamentoBenecifio;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioGeralInternosPavilhao;
    private javax.swing.JMenuItem RelatorioInternosRegimePenal;
    private javax.swing.JMenuItem RelatorioInternosRegimePenalSexo;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaInternos;
    private javax.swing.JMenuItem RelatorioQuantitativoAtividadeLab;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem RrelatorioSaidaBeneficio;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu Utilitarios;
    private javax.swing.JMenuItem jCalculadoraPena1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jPai;
    public static javax.swing.JDesktopPane jPainelJuridico;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
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
                verificarRecado(); // Verificar recados a cada 5 minutos    
                buscarAgendamentoInternos();  // VERIFICAR AGENDAMENTO POR DATA
                verificarAgendaCompromisso(); // VERIFICA SE EXISTE MENSAGEM COM DATA E HORA (COMPROMISSO)
            }
        }, periodo, tempo);
    }

// Chama a calculadora de pena para o java
    public void calcPena() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calcpena.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void calcPena1() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start Calculadora.exe");
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
                TelaModuloJuridico.jPainelJuridico.add(objAgendaComp);
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
                TelaModuloJuridico.jPainelJuridico.add(objRecados);
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

    public void buscarAgendamentoInternos() {
        //JOptionPane.showMessageDialog(null, "Data do Sistema é: " + jDataSistema.getText());
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_BENEFICIO_INTERNOS "
                    + "WHERE DataAg<='" + jDataSistema.getText() + "' "
                    + "AND StatusReg='" + statusRegistro + "'");
            conecta.rs.first();
            // Formatar a data Agenda
            dataAgenda = conecta.rs.getString("DataAg");
            String dia = dataAgenda.substring(8, 10);
            String mes = dataAgenda.substring(5, 7);
            String ano = dataAgenda.substring(0, 4);
            dataAgenda = dia + "/" + mes + "/" + ano;
            TelaAlertaAgendaBeneficio objAgendaBene = new TelaAlertaAgendaBeneficio();
            TelaModuloJuridico.jPainelJuridico.add(objAgendaBene);
            objAgendaBene.show();
            preencherTabelaAgendamento();
        } catch (Exception e) {
        }
    }

    public void preencherTabelaAgendamento() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Agendamento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_AGENDA_BENEFICIO_INTERNOS "
                    + "INNER JOIN AGENDA_BENEFICIO_INTERNOS "
                    + "ON ITENS_AGENDA_BENEFICIO_INTERNOS.IdReg=AGENDA_BENEFICIO_INTERNOS.IdReg "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_AGENDA_BENEFICIO_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE AGENDA_BENEFICIO_INTERNOS.DataAg<='" + jDataSistema.getText() + "' "
                    + "AND StatusReg='" + statusRegistro + "'");
            conecta.rs.first();
            do {
                // Formatar a data Saida
                dataAgenda = conecta.rs.getString("DataAg");
                String dia = dataAgenda.substring(8, 10);
                String mes = dataAgenda.substring(5, 7);
                String ano = dataAgenda.substring(0, 4);
                dataAgenda = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataAgenda});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAgendaInternos.setModel(modelo);
        jTabelaAgendaInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAgendaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAgendaInternos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaAgendaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAgendaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaAgendaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAgendaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaAgendaInternos.setAutoResizeMode(jTabelaAgendaInternos.AUTO_RESIZE_OFF);
        jTabelaAgendaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAgendaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAgendaInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
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
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadesJuridicasJURI + "'");
            conecta.rs.first();
            pNomeAJ = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAmparaoLegalJURI + "'");
            conecta.rs.first();
            pNomeAL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaNaturezaPrisaoJURI + "'");
            conecta.rs.first();
            pNomeNP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroBiometriaJURI + "'");
            conecta.rs.first();
            pNomeRB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroBiometriaInciarLeitorJURI + "'");
            conecta.rs.first();
            pNomeRBIL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtenImpJURI + "'");
            conecta.rs.first();
            pNomeRAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroLibAtenImpJURI + "'");
            conecta.rs.first();
            pNomeRLAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONSULTA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaConsultaProntuarioInternosDocJURI + "'");
            conecta.rs.first();
            pNomeCPID = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO 
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoJuridicoManuJURI + "'");
            conecta.rs.first();
            pNomeAJM_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoJuridicoaAtividadesJURI + "'");
            conecta.rs.first();
            pNomeAJA_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoJuridicoEvolucaoJURI + "'");
            conecta.rs.first();
            pNomeAJE_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAgendamentoBeneficioManuJURI + "'");
            conecta.rs.first();
            pNomeABM_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroFichaJuridicaManutencaoJURI + "'");
            conecta.rs.first();
            pNomeCFJM_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroFichaJuridicaProcessoJURI + "'");
            conecta.rs.first();
            pNomeCFJP_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroFichaJuridicaIncidênciaPenalJURI + "'");
            conecta.rs.first();
            pNomeCFJI_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroFichaJuridicaDocumentosProcessoJURI + "'");
            conecta.rs.first();
            pNomeCFJD_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoFamiliarManuJURI + "'");
            conecta.rs.first();
            pNomeAFM_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAudienciaJustificativaManuJURI + "'");
            conecta.rs.first();
            pNomeADJM_JURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaJURI + "'");
            conecta.rs.first();
            pNomeOcrJURI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MENU CADASTRO
        if (!pNomeAJ.equals(telaAtividadesJuridicasJURI) || pNomeAJ == null || pNomeAJ.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadesJuridicasJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAL.equals(telaAmparaoLegalJURI) || pNomeAL == null || pNomeAL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAmparaoLegalJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeNP.equals(telaNaturezaPrisaoJURI) || pNomeNP == null || pNomeNP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaNaturezaPrisaoJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRB.equals(telaRegistroBiometriaJURI) || pNomeRB == null || pNomeRB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroBiometriaJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRBIL.equals(telaRegistroBiometriaInciarLeitorJURI) || pNomeRBIL == null || pNomeRBIL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroBiometriaInciarLeitorJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAI.equals(telaRegistroAtenImpJURI) || pNomeRAI == null || pNomeRAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtenImpJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRLAI.equals(telaRegistroLibAtenImpJURI) || pNomeRLAI == null || pNomeRLAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroLibAtenImpJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MENU CONSULTA
        if (!pNomeCPID.equals(telaConsultaProntuarioInternosDocJURI) || pNomeCPID == null || pNomeCPID.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaConsultaProntuarioInternosDocJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeAJM_JURI.equals(telaAtendimentoJuridicoManuJURI) || pNomeAJM_JURI == null || pNomeAJM_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoJuridicoManuJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAJA_JURI.equals(telaAtendimentoJuridicoaAtividadesJURI) || pNomeAJA_JURI == null || pNomeAJA_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoJuridicoaAtividadesJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAJE_JURI.equals(telaAtendimentoJuridicoEvolucaoJURI) || pNomeAJE_JURI == null || pNomeAJE_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoJuridicoEvolucaoJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeABM_JURI.equals(telaAgendamentoBeneficioManuJURI) || pNomeABM_JURI == null || pNomeABM_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAgendamentoBeneficioManuJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCFJM_JURI.equals(telaCadastroFichaJuridicaManutencaoJURI) || pNomeCFJM_JURI == null || pNomeCFJM_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroFichaJuridicaManutencaoJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCFJP_JURI.equals(telaCadastroFichaJuridicaProcessoJURI) || pNomeCFJP_JURI == null || pNomeCFJP_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroFichaJuridicaProcessoJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCFJI_JURI.equals(telaCadastroFichaJuridicaIncidênciaPenalJURI) || pNomeCFJI_JURI == null || pNomeCFJI_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroFichaJuridicaIncidênciaPenalJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCFJD_JURI.equals(telaCadastroFichaJuridicaDocumentosProcessoJURI) || pNomeCFJD_JURI == null || pNomeCFJD_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroFichaJuridicaDocumentosProcessoJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //
        if (!pNomeAFM_JURI.equals(telaAtendimentoFamiliarManuJURI) || pNomeAFM_JURI == null || pNomeAFM_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoFamiliarManuJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeADJM_JURI.equals(telaAudienciaJustificativaManuJURI) || pNomeADJM_JURI == null || pNomeADJM_JURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAudienciaJustificativaManuJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOcrJURI.equals(telaOcorrenciaJURI) || pNomeOcrJURI == null || pNomeOcrJURI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaJURI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloJURI + "'");
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
}
