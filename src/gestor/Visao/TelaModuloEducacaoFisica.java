/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleTelasSistema;
import gestor.Controle.converterDataStringDataDate;
import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
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
public class TelaModuloEducacaoFisica extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    private TelaConsultaProntuarioInternoCrc objriIntJu = null;
    private TelaConsultaLocalInternoJuridico objLocalIntJu = null;
    private TelaMovHistoricoTecnicoJuridico objMovJuri = null;
    private TelaRecadosJuridico objRecaJuri = null;
    private TelaOcorrenciaEducacaoFisica TelaOcorrenciaEducacaoFisica = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaRegistroInternosAtendimento_EF objRegBioEF = null;
    private TelaRegistroInternosAtendimentoImpresso_EF objAutoImp = null;
    private TelaCancelamentoAtendimentoPSP objCancelaAtend = null;
    private TelaAtendimentoGrupoEducacaoFisica objAtividadeGrupo = null;
    private TelaAtividadesEducacaoFisica objAtividadePlan = null;
    private TelaAdmissaoEvolucoEF objAdmFisica = null;
    //
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
    String menu;
    //
    public static int codigoUserEF = 0;
    public static int codUserAcessoEF = 0;
    public static int codigoUserGroupEF = 0;
    public static int codAbrirEF = 0;
    public static int codIncluirEF = 0;
    public static int codAlterarEF = 0;
    public static int codExcluirEF = 0;
    public static int codGravarEF = 0;
    public static int codConsultarEF = 0;
    public static int codigoGrupoEF = 0;
    public static String nomeGrupoEF = "";
    public static String nomeTelaEF = "";
    // TELAS DE ACESSOS AO MÓDULO PEDAGOGIA
    public static String nomeModuloEF = "EDUCACAO FISICA";
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // MENU CADASTRO   
    public static String telaAtividadesEducaFisicaManu_EF = "Cadastro:Atividades Educação Física:Manutenção";
    public static String telaRegistroAtendimentoBio_EF = "Cadastro:Registro de Atendimento Internos Biometria - EF:Manutenção";
    public static String telaRegistroAtendimentoInciarLeitor_EF = "Cadastro:Registro de Atendimento Internos Biometria - EF:Iniciar Leitor";
    public static String telaRegistroAtendimentoImpBio_EF = "Cadastro:Registro de Autorização Impressa - EF:Liberação";
    public static String telaRegistroAtendimentoColLiberador_EF = "Cadastro:Registro de Autorização Impressa - EF:Colaborador Liberador";
    public static String telaCancelAtendInterno_EF = "Cadastro:Cancelamento Assinatura Interno/Impressão - PSI:Manutenção";
    //MOVIMENTAÇÃO
    //ADMISSÃO E EVOLUÇAO
    public static String telaAdmissoManu_EF = "Movimentação:Admissão Educação Física:Manutenção";
    public static String telaAdmissoEvol_EF = "Movimentação:Admissão Educação Física:Evolução";
    //ATENDIMENTO EM GRUPO
    public static String telaIndAtendimentoGrupoEF_Manu = "Movimentação:Atendimento Internos em Grupo - EF:Mamnutenção";
    public static String telaIndAtendimentoGrupoEF_Plan = "Movimentação:Atendimento Internos em Grupo - EF:Planejamento";
    public static String telaIndAtendimentoGrupoEF_Inte = "Movimentação:Atendimento Internos em Grupo - EF:Internos";
    public static String telaIndAtendimentoGrupoEF_AVG = "Movimentação:Atendimento Internos em Grupo - EF:Avaliação em Grupo";
    public static String telaIndAtendimentoGrupoEF_AVI = "Movimentação:Atendimento Internos em Grupo - EF:Avaliação Individual";
    public static String botaoEncerrar_EF = "Movimentação:Atendimento Internos em Grupo - EF:Botao Encerrar";
    public static String botaoLiberar_EF = "Movimentação:Atendimento Internos em Grupo - EF:Botão Liberar";
    //OCORRÊNCIA
    public static String telaOcorrenciaManu_EF = "Movimentação:Ocorrência Educação Física:Manutenção";
    //CADASTROS
    String pNomeAED_EF = "";
    //BIOMETRIA
    String pNomeAB = "";
    String pNomeAIL = "";
    String pNomeIMB = "";
    String pNomeCL = "";
    String pNomeCAI = "";
    //MOVIMENTAÇÃO
    // ADMISSÃO E EVOLUÇÃO
    String pNomeAEF = "";
    String pNomeEEF = "";
    // ATIVIDADES EM GRUPO
    String pNomeAGM = "";
    String pNomePLA = "";
    String pNomeAGI = "";
    String pNomeAVG = "";
    String pNomeAVI = "";
    String pNomeBTE = "";
    String pNomeBTL = "";
    //OCORRÊNCIAS
    String pNomeOcorr_EF = "";
    //
    public static int pQUANTIDADE_ATENDIDA = 1;

    /**
     * Creates new form TelaJuridico
     */
    public TelaModuloEducacaoFisica() {
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

        jPainelEducacaoFisica = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        jPlanejamentoAtividades = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jRegistroAtendeInternoBio = new javax.swing.JMenuItem();
        RegistroAtendimentoImpresso = new javax.swing.JMenuItem();
        jCancelarRegistroAtendimentoInterno = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
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
        jAdmissaoEducacaoFisica = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jAtendimentoGrupo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencia = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        RelatorioGeralInternosPavilhao = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        RelatorioPrevisaoSaidaInternos = new javax.swing.JMenuItem();
        RelatorioAgendamentoBenecifio = new javax.swing.JMenuItem();
        RelatorioQuantitativoAtividadeLab = new javax.swing.JMenuItem();
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
        setTitle("...::: Educação Física :::...");

        jPainelEducacaoFisica.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelEducacaoFisica.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelEducacaoFisicaLayout = new javax.swing.GroupLayout(jPainelEducacaoFisica);
        jPainelEducacaoFisica.setLayout(jPainelEducacaoFisicaLayout);
        jPainelEducacaoFisicaLayout.setHorizontalGroup(
            jPainelEducacaoFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelEducacaoFisicaLayout.setVerticalGroup(
            jPainelEducacaoFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        Cadastros.setText("Cadastros");

        jPlanejamentoAtividades.setText("Planejamento de Atividades");
        jPlanejamentoAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlanejamentoAtividadesActionPerformed(evt);
            }
        });
        Cadastros.add(jPlanejamentoAtividades);
        Cadastros.add(jSeparator9);

        jMenu5.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        jRegistroAtendeInternoBio.setText("Registra Atendimento por Biometria");
        jRegistroAtendeInternoBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroAtendeInternoBioActionPerformed(evt);
            }
        });
        jMenu5.add(jRegistroAtendeInternoBio);

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

        Cadastros.add(jMenu5);
        Cadastros.add(jSeparator2);

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

        jAdmissaoEducacaoFisica.setText("Admissão/Evolução Educação Física");
        jAdmissaoEducacaoFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdmissaoEducacaoFisicaActionPerformed(evt);
            }
        });
        Movimentacao.add(jAdmissaoEducacaoFisica);
        Movimentacao.add(jSeparator5);

        jAtendimentoGrupo.setText("Atendimento de Internos em Grupo");
        jAtendimentoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtendimentoGrupoActionPerformed(evt);
            }
        });
        Movimentacao.add(jAtendimentoGrupo);
        Movimentacao.add(jSeparator1);

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
            .addComponent(jPainelEducacaoFisica)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelEducacaoFisica)
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
            jPainelEducacaoFisica.add(objriIntJu);
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
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objriIntJu);//adicona frame ao JDesktopPane  
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
            jPainelEducacaoFisica.add(objLocalIntJu);
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
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objLocalIntJu);//adicona frame ao JDesktopPane  
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
            jPainelEducacaoFisica.add(objMovJuri);
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
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objMovJuri);//adicona frame ao JDesktopPane  
                objMovJuri.setVisible(true);
            }
        }
        try {
            objMovJuri.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoActionPerformed

    private void jAdmissaoEducacaoFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdmissaoEducacaoFisicaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissoManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaAdmissoManu_EF) && codAbrirEF == 1) {
            if (objAdmFisica == null || objAdmFisica.isClosed()) {
                objAdmFisica = new TelaAdmissaoEvolucoEF();
                jPainelEducacaoFisica.add(objAdmFisica);
                objAdmFisica.setVisible(true);
            } else {
                if (objAdmFisica.isVisible()) {
                    if (objAdmFisica.isIcon()) { // Se esta minimizado
                        try {
                            objAdmFisica.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAdmFisica.toFront(); // traz para frente
                        objAdmFisica.pack();//volta frame 
                    }
                } else {
                    objAdmFisica = new TelaAdmissaoEvolucoEF();
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAdmFisica);//adicona frame ao JDesktopPane  
                    objAdmFisica.setVisible(true);
                }
            }
            try {
                objAdmFisica.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jAdmissaoEducacaoFisicaActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecaJuri == null || objRecaJuri.isClosed()) {
            objRecaJuri = new TelaRecadosJuridico();
            jPainelEducacaoFisica.add(objRecaJuri);
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
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRecaJuri);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_RelatorioGeralInternosPavilhaoActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConf = new TelaRelatorioConfere();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRelConf);
        objRelConf.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void RelatorioPrevisaoSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevSaidaIntJuridico objRelPrevSai = new TelaRelatorioPrevSaidaIntJuridico();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRelPrevSai);
        objRelPrevSai.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaInternosActionPerformed

    private void LivroOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaOcorrenciaManu_EF) && codAbrirEF == 1) {
            if (TelaOcorrenciaEducacaoFisica == null || TelaOcorrenciaEducacaoFisica.isClosed()) {
                TelaOcorrenciaEducacaoFisica = new TelaOcorrenciaEducacaoFisica();
                jPainelEducacaoFisica.add(TelaOcorrenciaEducacaoFisica);
                TelaOcorrenciaEducacaoFisica.setVisible(true);
            } else {
                if (TelaOcorrenciaEducacaoFisica.isVisible()) {
                    if (TelaOcorrenciaEducacaoFisica.isIcon()) { // Se esta minimizado
                        try {
                            TelaOcorrenciaEducacaoFisica.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        TelaOcorrenciaEducacaoFisica.toFront(); // traz para frente
                        TelaOcorrenciaEducacaoFisica.pack();//volta frame 
                    }
                } else {
                    TelaOcorrenciaEducacaoFisica = new TelaOcorrenciaEducacaoFisica();
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(TelaOcorrenciaEducacaoFisica);//adicona frame ao JDesktopPane  
                    TelaOcorrenciaEducacaoFisica.setVisible(true);
                }
            }
            try {
                TelaOcorrenciaEducacaoFisica.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_LivroOcorrenciaActionPerformed

    private void jPlanejamentoAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlanejamentoAtividadesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaManu_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaOcorrenciaManu_EF) && codAbrirEF == 1) {
            if (objAtividadePlan == null || objAtividadePlan.isClosed()) {
                objAtividadePlan = new TelaAtividadesEducacaoFisica();
                jPainelEducacaoFisica.add(objAtividadePlan);
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
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAtividadePlan);//adicona frame ao JDesktopPane  
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

    private void AgendaEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaEventosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelEducacaoFisica.add(objAgEventos);
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
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaEventosActionPerformed

    private void jAtendimentoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtendimentoGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoEF_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaIndAtendimentoGrupoEF_Manu) && codAbrirEF == 1) {
            if (objAtividadeGrupo == null || objAtividadeGrupo.isClosed()) {
                objAtividadeGrupo = new TelaAtendimentoGrupoEducacaoFisica();
                jPainelEducacaoFisica.add(objAtividadeGrupo);
                objAtividadeGrupo.setVisible(true);
            } else {
                if (objAtividadeGrupo.isVisible()) {
                    if (objAtividadeGrupo.isIcon()) { // Se esta minimizado
                        try {
                            objAtividadeGrupo.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtividadeGrupo.toFront(); // traz para frente
                        objAtividadeGrupo.pack();//volta frame 
                    }
                } else {
                    objAtividadeGrupo = new TelaAtendimentoGrupoEducacaoFisica();
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAtividadeGrupo);//adicona frame ao JDesktopPane  
                    objAtividadeGrupo.setVisible(true);
                }
            }
            try {
                objAtividadeGrupo.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jAtendimentoGrupoActionPerformed

    private void RelatorioAgendamentoBenecifioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAgendamentoBenecifioActionPerformed
        // TODO add your handling code here:
        TelaRelatorioAgendamentoBeneficiosInternos objRelAgenda = new TelaRelatorioAgendamentoBeneficiosInternos();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRelAgenda);
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
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRelIntReg);
        objRelIntReg.show();
    }//GEN-LAST:event_RelatorioInternosRegimePenalSexoActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void jRegistroAtendeInternoBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroAtendeInternoBioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoBio_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaRegistroAtendimentoBio_EF) && codAbrirEF == 1) {
            if (objRegBioEF == null || objRegBioEF.isClosed()) {
                objRegBioEF = new TelaRegistroInternosAtendimento_EF();
                jPainelEducacaoFisica.add(objRegBioEF);
                objRegBioEF.setVisible(true);
            } else {
                if (objRegBioEF.isVisible()) {
                    if (objRegBioEF.isIcon()) { // Se esta minimizado
                        try {
                            objRegBioEF.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegBioEF.toFront(); // traz para frente
                        objRegBioEF.pack();//volta frame
                    }
                } else {
                    objRegBioEF = new TelaRegistroInternosAtendimento_EF();
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRegBioEF);//adicona frame ao JDesktopPane
                    objRegBioEF.setVisible(true);
                }
            }
            try {
                objRegBioEF.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistroAtendeInternoBioActionPerformed

    private void RegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoImpBio_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaRegistroAtendimentoImpBio_EF) && codAbrirEF == 1) {
            if (objAutoImp == null || objAutoImp.isClosed()) {
                objAutoImp = new TelaRegistroInternosAtendimentoImpresso_EF();
                jPainelEducacaoFisica.add(objAutoImp);
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
                    objAutoImp = new TelaRegistroInternosAtendimentoImpresso_EF();
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAutoImp);//adicona frame ao JDesktopPane
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

    private void jCancelarRegistroAtendimentoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarRegistroAtendimentoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelAtendInterno_EF);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoEF.equals("ADMINISTRADORES") || codigoUserEF == codUserAcessoEF && nomeTelaEF.equals(telaCancelAtendInterno_EF) && codAbrirEF == 1) {
            if (objCancelaAtend == null || objCancelaAtend.isClosed()) {
                objCancelaAtend = new TelaCancelamentoAtendimentoPSP();
                jPainelEducacaoFisica.add(objCancelaAtend);
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
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objCancelaAtend);//adicona frame ao JDesktopPane
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaEventos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem CalculadoraPena;
    private javax.swing.JMenuItem CalculadoraWindows;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem HistoricoMovimentacao;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LivroOcorrencia;
    private javax.swing.JMenuItem LocalizacaoInterno;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem ProntuarioInternos;
    private javax.swing.JMenuItem RegistroAtendimentoImpresso;
    private javax.swing.JMenuItem RelatorioAgendamentoBenecifio;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioGeralInternosPavilhao;
    private javax.swing.JMenuItem RelatorioInternosRegimePenal;
    private javax.swing.JMenuItem RelatorioInternosRegimePenalSexo;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaInternos;
    private javax.swing.JMenuItem RelatorioQuantitativoAtividadeLab;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu Utilitarios;
    private javax.swing.JMenuItem jAdmissaoEducacaoFisica;
    private javax.swing.JMenuItem jAtendimentoGrupo;
    private javax.swing.JMenuItem jCalculadoraPena1;
    private javax.swing.JMenuItem jCancelarRegistroAtendimentoInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JDesktopPane jPainelEducacaoFisica;
    private javax.swing.JMenuItem jPlanejamentoAtividades;
    private javax.swing.JMenuItem jRegistroAtendeInternoBio;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
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
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAgendaComp);
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
                    TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAgendaComp);
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

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCrc objRecados = new TelaRecadosCrc();
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objRecados);
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
            //
            if (dataAgenda.equals(jDataSistema.getText()) && statusRegistroAgenda.equals(statusRegistro)) {
                TelaAlertaAgendaBeneficio objAgendaBene = new TelaAlertaAgendaBeneficio();
                TelaModuloEducacaoFisica.jPainelEducacaoFisica.add(objAgendaBene);
                objAgendaBene.show();
                preencherTabelaAgendamento();
            }
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

    // PESQUISA E CADASTRO DAS TELAS DO MÓDULO PEDAGOGIA PARA CONTROLE DE ACESSO DE USUÁRIOS.
    public void pesquisarTelasAcessos() {
        //CADASTROS
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadesEducaFisicaManu_EF + "'");
            conecta.rs.first();
            pNomeAED_EF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoBio_EF + "'");
            conecta.rs.first();
            pNomeAB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoInciarLeitor_EF + "'");
            conecta.rs.first();
            pNomeAIL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoImpBio_EF + "'");
            conecta.rs.first();
            pNomeIMB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoColLiberador_EF + "'");
            conecta.rs.first();
            pNomeCL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelAtendInterno_EF + "'");
            conecta.rs.first();
            pNomeCAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //MOVIMENTAÇÃO
        //ADMISSÃO E EVOLUÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissoManu_EF + "'");
            conecta.rs.first();
            pNomeAEF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissoEvol_EF + "'");
            conecta.rs.first();
            pNomeEEF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ATENCIMENTO EM GRUPO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoEF_Manu + "'");
            conecta.rs.first();
            pNomeAGM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoEF_Plan + "'");
            conecta.rs.first();
            pNomePLA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoEF_Inte + "'");
            conecta.rs.first();
            pNomeAGI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoEF_AVG + "'");
            conecta.rs.first();
            pNomeAVG = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoEF_AVI + "'");
            conecta.rs.first();
            pNomeAVI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + botaoEncerrar_EF + "'");
            conecta.rs.first();
            pNomeBTE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + botaoLiberar_EF + "'");
            conecta.rs.first();
            pNomeBTL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //OCORRÊNCIAS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaManu_EF + "'");
            conecta.rs.first();
            pNomeOcorr_EF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        if (!pNomeAED_EF.equals(telaAtividadesEducaFisicaManu_EF) || pNomeAED_EF == null || pNomeAED_EF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadesEducaFisicaManu_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CADASTROS
        if (!pNomeAB.equals(telaRegistroAtendimentoBio_EF) || pNomeAB == null || pNomeAB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoBio_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIL.equals(telaRegistroAtendimentoInciarLeitor_EF) || pNomeAIL == null || pNomeAIL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoInciarLeitor_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIMB.equals(telaRegistroAtendimentoImpBio_EF) || pNomeIMB == null || pNomeIMB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoImpBio_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCL.equals(telaRegistroAtendimentoColLiberador_EF) || pNomeCL == null || pNomeCL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoColLiberador_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAI.equals(telaCancelAtendInterno_EF) || pNomeCAI == null || pNomeCAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelAtendInterno_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //MOVIMENTAÇÃO
        //ADMISSÃO E EVOLUÇÃO
        if (!pNomeAEF.equals(telaAdmissoManu_EF) || pNomeAEF == null || pNomeAEF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissoManu_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEEF.equals(telaAdmissoEvol_EF) || pNomeEEF == null || pNomeEEF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissoEvol_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ATENDIMENTO EM GRUPO
        if (!pNomeAGM.equals(telaIndAtendimentoGrupoEF_Manu) || pNomeAGM == null || pNomeAGM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoEF_Manu);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePLA.equals(telaIndAtendimentoGrupoEF_Plan) || pNomePLA == null || pNomePLA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoEF_Plan);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAGI.equals(telaIndAtendimentoGrupoEF_Inte) || pNomeAGI == null || pNomeAGI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoEF_Inte);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAVG.equals(telaIndAtendimentoGrupoEF_AVG) || pNomeAVG == null || pNomeAVG.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoEF_AVG);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAVI.equals(telaIndAtendimentoGrupoEF_AVI) || pNomeAVI == null || pNomeAVI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoEF_AVI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBTE.equals(botaoEncerrar_EF) || pNomeBTE == null || pNomeBTE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(botaoEncerrar_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBTL.equals(botaoLiberar_EF) || pNomeBTL == null || pNomeBTL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(botaoLiberar_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //OCORRÊNCIAS
        if (!pNomeOcorr_EF.equals(telaOcorrenciaManu_EF) || pNomeOcorr_EF == null || pNomeOcorr_EF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaManu_EF);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloEF + "'");
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
            codigoUserEF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserEF + "'");
            conecta.rs.first();
            codigoUserGroupEF = conecta.rs.getInt("IdUsuario");
            codigoGrupoEF = conecta.rs.getInt("IdGrupo");
            nomeGrupoEF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserEF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoEF = conecta.rs.getInt("IdUsuario");
            codAbrirEF = conecta.rs.getInt("Abrir");
            codIncluirEF = conecta.rs.getInt("Incluir");
            codAlterarEF = conecta.rs.getInt("Alterar");
            codExcluirEF = conecta.rs.getInt("Excluir");
            codGravarEF = conecta.rs.getInt("Gravar");
            codConsultarEF = conecta.rs.getInt("Consultar");
            nomeTelaEF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
