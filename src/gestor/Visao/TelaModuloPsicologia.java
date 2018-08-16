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
public class TelaModuloPsicologia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
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
    // MENU CONSULTA    
    public static String telaConsultaProntuarioInternosDocPSI = "Consulta:Prontuario:Documentos";
    // MOVIMENTAÇÃO
    public static String telaMovimentacaoAdmIntManuPSI = "Movimentação:Admissão de Internos:Manutenção";
    public static String telaMovimentacaoEvolIntPSI = "Movimentação:Evolução Psicológica de Internos";
    public static String telaMovimentacaoPareIntPSI = "Movimentação:Parecer Psicológico de Internos";
    //
    public static String telaMovimentacaoAvalPsiIntPSI = "Movimentação:Avaliação Psicologica:Manutenção";
    //P.A.I.
    public static String telaPAIS_PSI = "Movimentação:P.A.I.:Manutenção";
    public static String telaPaiCCGF_PSI = "Movimentação:P.A.I.:C.C.G.F.";
    public static String telaPaiCCGFFam_PSI = "Movimentação:P.A.I.:C.C.G.F.:Familia";
    public static String telaPaiCCGFVis_PSI = "Movimentação:P.A.I.:C.C.G.F.:Visita";
    public static String telaPaiCCGFVisInt_PSI = "Movimentação:P.A.I.:C.C.G.F.:Visita Intima";
    public static String telaPaiDEME_PSI = "Movimentação:P.A.I.:D.E.M.E.";
    public static String telaPaiDPTL_PSI = "Movimentação:P.A.I.:D.P.T.L.";
    public static String telaPaiDJ_PSI = "Movimentação:P.A.I.:D.J.";
    public static String telaPaiDS_PSI = "Movimentação:P.A.I.:D.S.";
    public static String telaPaiEAPI1_PSI = "Movimentação:P.A.I.:E.A.P.I.-1";
    public static String telaPaiEAPI2_PSI = "Movimentação:P.A.I.:E.A.P.I.-2";
    public static String telaPaiEPAI_PSI = "Movimentação:P.A.I.:E-PAI";
    //
    public static String telaPerfilSocialManuPSI = "Movimentação:Perfil Carcerário:Manutenção";
    public static String telaPerfilSocialPerfCarPSI = "Movimentação:Perfil Carcerário:Perfil Carcerário";
    //
    public static String telaMovimetacaoOcrPSI = "Movimetação:Movimentação:Ocorrências Diárias:Manutenção";
    // 
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCAAI = "";
    // MENU CONSULTA
    String pNomeCPID = "";
    // MOVIMENTAÇÃO
    String pNomeMAIM = "";
    String pNomeMEP = "";
    String pNomeMPI = "";
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

    //pNomePSM
    //pNomePSPC
    //telaPerfilSocialManuPSI
    //telaPerfilSocialPerfCarPSI
    /**
     * Creates new form TelaPsicologia
     */
    public TelaModuloPsicologia() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        threadMensagem(); // A cada 5 minutos verifica mensagem 
        pesquisarTelasAcessos();
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
        AgendaAtendimentoInternos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jRegistroAtendeInternoBio = new javax.swing.JMenuItem();
        RegistroAtendimentoImpresso = new javax.swing.JMenuItem();
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
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jPaiNovo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jPerfilCarcerario = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Psicologia :::...");

        jPainelPsicologia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jPainelPsicologia.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPsicologiaLayout = new javax.swing.GroupLayout(jPainelPsicologia);
        jPainelPsicologia.setLayout(jPainelPsicologiaLayout);
        jPainelPsicologiaLayout.setHorizontalGroup(
            jPainelPsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelPsicologiaLayout.setVerticalGroup(
            jPainelPsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelPsicologiaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        AgendaAtendimentoInternos.setText("Agenda Atendimento a Internos");
        AgendaAtendimentoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaAtendimentoInternosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaAtendimentoInternos);
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

        jMenu5.setForeground(new java.awt.Color(0, 102, 0));
        jMenu5.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        jRegistroAtendeInternoBio.setForeground(new java.awt.Color(0, 102, 0));
        jRegistroAtendeInternoBio.setText("Registra Atendimento por Biometria");
        jRegistroAtendeInternoBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroAtendeInternoBioActionPerformed(evt);
            }
        });
        jMenu5.add(jRegistroAtendeInternoBio);

        RegistroAtendimentoImpresso.setForeground(new java.awt.Color(0, 0, 204));
        RegistroAtendimentoImpresso.setText("Registro Atendimento por Impressão");
        RegistroAtendimentoImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoImpressoActionPerformed(evt);
            }
        });
        jMenu5.add(RegistroAtendimentoImpresso);

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
        jMenu2.add(jSeparator5);

        jPaiNovo.setForeground(new java.awt.Color(0, 0, 255));
        jPaiNovo.setText("P.A.I. - Programa de Assistência Individualizado - NOVO");
        jPaiNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaiNovoActionPerformed(evt);
            }
        });
        jMenu2.add(jPaiNovo);
        jMenu2.add(jSeparator4);

        jPerfilCarcerario.setForeground(new java.awt.Color(255, 0, 0));
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

        jMenu3.setText("Relatórios");

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

        jMenu3.add(RelatoriosConfere);
        jMenu3.add(jSeparator1);

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

        jMenu3.add(ListagemAtividadesLaborativas);

        RelatorioAconpanhamentoFamiliar.setText("Relatório de Acompanhamento Laborativo de Internos");
        RelatorioAconpanhamentoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAconpanhamentoFamiliarActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioAconpanhamentoFamiliar);

        ListagemFrequenciaExterna.setText("Atividade laborativa Externa (Frequência)");
        ListagemFrequenciaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemFrequenciaExternaActionPerformed(evt);
            }
        });
        jMenu3.add(ListagemFrequenciaExterna);
        jMenu3.add(jSeparator2);

        RelatorioVisitasInternos.setText("Relatório de Visitas aos Internos");
        RelatorioVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasInternosActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioVisitasInternos);
        jMenu3.add(jSeparator8);

        RelatorioEntradaUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaUnidadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaUnidade);

        jMenuBar1.add(jMenu3);

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
            String path = "reports/RelatorioListaPassagemInterna.jasper";
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
            String path = "reports/RelatorioListaPassagemInterna.jasper";
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
        // TODO add your handling code here:buscarAcessoUsuario(telaCadastroVisitasSS);
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
    }//GEN-LAST:event_jRegistroAtendeInternoBioActionPerformed

    private void RegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistroAtendimentoImpressoActionPerformed


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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jPaiNovo;
    public static javax.swing.JDesktopPane jPainelPsicologia;
    private javax.swing.JMenuItem jPerfilCarcerario;
    private javax.swing.JMenuItem jRegistroAtendeInternoBio;
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
                TelaModuloPsicologia.jPainelPsicologia.add(objAgendaComp);
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
                                + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nomeUsuarioCompromisso + "'AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "'AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'AND IdAgenda='" + codigoAgendaComp + "'");
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
        //CONSULTA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaConsultaProntuarioInternosDocPSI + "'");
            conecta.rs.first();
            pNomeCPID = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CADASTRO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroAgendaAtendimentoInternoManuPSI + "'");
            conecta.rs.first();
            pNomeCAAI = conecta.rs.getString("NomeTela");
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
        //  CADASTRO
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
}
