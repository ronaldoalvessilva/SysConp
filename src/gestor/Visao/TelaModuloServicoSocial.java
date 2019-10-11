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
public class TelaModuloServicoSocial extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();

    private TelaVisitaSocial objVsocial = null;
    private TelaRolVisitas objRolVis = null;
    private TelaControleLigacoesSS objContLiga = null;
    private TelaAtendimentoSocial objAtenSocial = null;
    private TelaMovHistoricoTecnico objMovTec = null;
    private TelaAtendimentoFamiliar objAtendFam = null;
    private TelaConsultaProntuarioInternoCrc objConInt = null;
    private TelaConsultaLocalInterno objConLocal = null;
    private TelaRecadosServicoSocial objAgeRecSs = null;
    private TelaDocumetosInternosServicoSocial objListaDocInternos = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaAprovadoresOcorrenciaVisitasInternosServicoSocial objAprovaOcr = null;
    private TelaAprovacaoServicoSocial objBloqLibOcr = null;
    private TelaOcorrenciaServicoSocial objOcrSSocial = null;
    private TelaPerfilCarcerario objPerfilCar = null;
    private TelaVisitaSocialReligiosa objVisitaRel = null;
    private TelaInstituicaoReligiosa objInstRel = null;
    private TelaRolVisitasReligiosas objRolVisitaRel = null;
    private TelaAtualizacaoDocumentosServicoSocial objAtuaDoc = null;
    private TelaCancelamentoVisitasInterno objCancelaVis = null;
    private TelaHistoricoAvaliacaoSocial objHistAvaSocial = null;
    private TelaHistoricoAvaliacaoEmprego objAvaEmp = null;
    private TelaPAI_NOVO objPaiNovo = null;
    private TelaRegistroInternosAtendimentoSS objRegBio = null;
    private TelaRegistroInternosAtendimentoImpressoSS objAutoImp = null;
    private TelaSolicitacaoAuxilioReclusao objSoliPedRec = null;
//    private TelaIndicadoresAcompanhamento objIndAcomp = null;
    private TelaCancelamentoAtendimentoPSP objCancelaAtend = null;
    //
    public static String nomeModuloSERV = "SERVICO";
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    String statusRol = "ABERTO";
    //
    String dataInicial, dataFinal;
    String statusEntrada = "ENTRADA NA UNIDADE";
    String statusRetorno = "RETORNO A UNIDADE";
    String recebeVisita = "Não";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    //
    String cartaoSUS = "";
    String cartaoRG = "";
    String cartaoCPF = "";
    //
    public static int codigoUserSS = 0;
    public static int codUserAcessoSS = 0;
    public static int codigoUserGroupSS = 0;
    public static int codAbrirSS = 0;
    public static int codIncluirSS = 0;
    public static int codAlterarSS = 0;
    public static int codExcluirSS = 0;
    public static int codGravarSS = 0;
    public static int codConsultarSS = 0;
    public static int codigoGrupoSS = 0;
    public static String nomeGrupoSS = "";
    public static String nomeTelaSS = "";
    // TELAS DE ACESSOS AO MÓDULO SERVIÇO SOCIAL
    public static String nomeModuloSS = "SERVICO SOCIAL";
    // MENU CADASTRO    
    public static String telaCadastroVisitasSS = "Cadastro:Visitantes:Manutenção";
    public static String telaRolVisitasSS = "Cadastro:Rol de Visitas:Manutenção";
    public static String telaRolVisitasVisitantesSS = "Cadastro:Rol de Visitas:Visitas";
    public static String telaRolVisitasInternosSS = "Cadastro:Rol de Visitas:Internos";
    public static String telaListaDocumentosSS = "Cadastro:Lista de Documentos de Internos:Manutenção";
    public static String telaInstituicaoRelSS = "Cadastro:Instituição Religiosa:Manutenção";
    public static String telaVisitantesRelSS = "Cadastro:Visitantes Religiosos:Manutenção";
    public static String telaRolVisitantesRelSS = "Cadastro:Rol de Visitas Religiosa:Manutenção";
    public static String telaRolVisitantesRelVisitaSS = "Cadastro:Rol de Visitas Religiosa:Visitas";
    public static String telaAprovadoresOcrSS = "Cadastro:Aprovadores de Ocorrências Indisciplinas Visitas:Manutenção";
    public static String telaRegistroAtendimentoBioSS = "Cadastro:Registro de Atendimento Internos Biometria Serviços Social:Manutenção";
    public static String telaRegistroAtendimentoImpressaoBioSSocial = "Cadastro:Registro de Autorização Impressa Serviços Social:Liberação";
    public static String telaCancelAtendInternoSS = "Cadastro:Cancelamento Assinatura Interno/Impressão - SSO:Manutenção";
    // MOVIMENTAÇÃO
    public static String telaAdmissaoInternosServicoSocial = "Movimentação:Admissão de Internos:Admissão";
    public static String telaEvolucaoServicoSocial = "Movimentação:Admissão de Internos:Evolução";
    public static String telaPerfilPopCarcerariaSS = "Movimentação:Pérfil Carcerário:Manutenção";
    public static String telaPerfilPopCarcerariaPerfilSS = "Movimentação:Pérfil Carcerário:Pérfil Carcerário";
    public static String telaAtualizacaoDocSS = "Movimentação:Atualização de Documentos Internos:Manutenção";
    public static String telaAtendimentoFamiliaSS = "Movimentação:Atendimento Familia:Manutenção";
    public static String telaAtendimentoFamilia_EVO_SS = "Movimentação:Atendimento Familia:Evolução";
    public static String telaCancelaVisitaSS = "Movimentação:Cancelamento de Visitantes:Manutenção";
    public static String telaCancelaVisitaVistasExtSS = "Movimentação:Cancelamento de Visitantes:Visitas Externas";
    public static String telaCancelaVisitaVistasIntSS = "Movimentação:Cancelamento de Visitantes:Visitas Internas";
    //P.A.I.
    public static String telaPAISS = "Movimentação:P.A.I. - Serviços Social:Manutenção";
    public static String telaPaiCCGF_SS = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social";
    public static String telaPaiCCGFFam_SS = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social:Familia";
    public static String telaPaiCCGFVis_SS = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social:Visita";
    public static String telaPaiCCGFVisInt_SS = "Movimentação:P.A.I.:C.C.G.F. - Serviços Social:Visita Intima";
    public static String telaPaiDEME_SS = "Movimentação:P.A.I.:D.E.M.E. - Serviços Social";
    public static String telaPaiDPTL_SS = "Movimentação:P.A.I.:D.P.T.L. - Serviços Social";
    public static String telaPaiDJ_SS = "Movimentação:P.A.I.:D.J. - Serviços Social";
    public static String telaPaiDS_SS = "Movimentação:P.A.I.:D.S. - Serviços Social";
    public static String telaPaiEAPI1_SS = "Movimentação:P.A.I.:E.A.P.I.-1 - Serviços Social";
    public static String telaPaiEAPI2_SS = "Movimentação:P.A.I.:E.A.P.I.-2 - Serviços Social";
    public static String telaPaiEPAI_SS = "Movimentação:P.A.I.:E-PAI - Serviços Social";
    //
    public static String telaBloqueioLiberacaoVisitasSS = "Movimentação:Bloqueio/Desbloqueio de Ocorrência Portaria - Serviços Social:Manutenção";
    public static String telaBloqueioLiberacaoOcorrenciaSS = "Movimentação:Bloqueio/Desbloqueio de Ocorrência Portaria - Serviços Social:Ocorrência";
    public static String telaControleLigacoesTelSS = "Movimentação:Controle de Ligações:Manutenção";
    public static String telaOcorrenciasSS = "Movimentação:Ocorrências do Serviço Social:Manutenção";
    //
    public static String telaHistAvaSocial_SS = "Movimentação:Historico de Avaliação Social - I:Manutenção";
    public static String telaHistAvaEmprego_SS = "Movimentação:Historico de Avaliação de Emprego - II:Manutenção";
    //
    public static String telaSolicitacaoAuxilioReclusao = "Movimentação:Solicitação Atestado Reclusão - Serviço Social";
    public static String telaBiometriaVisita = "Movimentação:Solicitação Atestado Reclusão - Serviço Social:Biometria Visita";
    public static String telaBiometriaInterno = "Movimentação:Solicitação Atestado Reclusão - Serviço Social:Biometria Interno";
    //
    public static String telaIndAcompanhaManuSS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:Manutenção";
    public static String telaIndAcompanhaAbaESS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:Enfermaria";
    public static String telaIndAcompanhaAbaPSS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:Pedagogia";
    public static String telaIndAcompanhaAbaCSS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:Juridico/CRC";
    public static String telaIndAcompanhaAbaTSS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:TO";
    public static String telaIndAcompanhaAbaPSISS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:Psicologia";
    public static String telaIndAcompanhaAbaSSS = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/SS:Serviço Social";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCV = "";
    String pNomeRV = "";
    String pNomeRVV = "";
    String pNomeRVI = "";
    String pNomeLD = "";
    String pNomeIR = "";
    String pNomeVR = "";
    String pNomeRVR = "";
    String pNomeRVRV = "";
    String pNomeAO = "";
    String pNomeRAB_SS = "";
    String pNomeRAIB_SS = "";
    String pNomeCAII = "";
    // MOVIMENTAÇÃO
    String pNomeAEI = "";
    String pNomeAEIE = "";
    String pNomePPC = "";
    String pNomePPCP = "";
    String pNomeAD = "";
    String pNomeAF = "";
    String pNomeAFE = "";
    String pNomeCVS = "";
    String pNomeCVVE = "";
    String pNomeCVVI = "";
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
    String pNomeBLV = "";
    String pNomeBLO = "";
    String pNomeCLT = "";
    String pNomeOCO = "";
    String pNomeHAS_I = "";
    String pNomeHAE_II = "";
    //
    String pNomeSAR = "";
    String pNomeSARV = "";
    String pNomeSARI = "";
    //PRORES
    String pNomeIAM = "";
    String pNomeIAE = "";
    String pNomeIAP = "";
    String pNomeIAC = "";
    String pNomeIAT = "";
    String pNomeIAPS = "";
    String pNomeIAS = "";
    //
    public static int pQUANTIDADE_ATENDIDA = 1;

    //  
    /**
     * Creates new form TelaServioSocial
     */
    public TelaModuloServicoSocial() {
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

        jPainelServicoSocial = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Vistantes = new javax.swing.JMenuItem();
        RolVisitas = new javax.swing.JMenuItem();
        ListaDocumentosInternos = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        InstituicaoReligiosa = new javax.swing.JMenuItem();
        VisitantesReligiosos = new javax.swing.JMenuItem();
        RolVisitasReligiosas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        AprovadoresOcorrenciasVisitasPortaria = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        jRegistroAtendeInternoBio = new javax.swing.JMenuItem();
        RegistroAtendimentoImpresso = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jCancelamentoRegistroAtendimento = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        ProntuariosInternos = new javax.swing.JMenuItem();
        LocalizacaoInternos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        HistoricosMovimentacaoTec = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AdmissaoInternos = new javax.swing.JMenuItem();
        PerfilPopulacaoCarceraria = new javax.swing.JMenuItem();
        AtualizacaoDocumentosInternos = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        AtendimentoFamiliar = new javax.swing.JMenuItem();
        CancelarVisitaInterno = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        jPaiNOVO = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        BloqueioLiberacaoVisitasInternos = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ControleLigacoes = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jOcorrenciasServicoSocial = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        HistoricoAvaliacaoSocial = new javax.swing.JMenuItem();
        HistoricoAvaliacaoEmprego = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jSolicitacaoAtestadoReclusao = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jRolVisitas = new javax.swing.JMenuItem();
        RelatorioVisitasGrauParentesco = new javax.swing.JMenuItem();
        RelatorioCadastroVisitas = new javax.swing.JMenuItem();
        RelatorioVisitasPorIdade = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jRelatorioVisitasInternos = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        CartaoSus = new javax.swing.JMenuItem();
        RG = new javax.swing.JMenuItem();
        CPF = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        CartaoSUS = new javax.swing.JMenuItem();
        DocumentoRG = new javax.swing.JMenuItem();
        DocumentoCPF = new javax.swing.JMenuItem();
        RelatorioDocumentosInternosServicoSocial = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        RelatorioPrevisaoSaidaInternos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        RelatorioGeralInternosPavilhao = new javax.swing.JMenuItem();
        RelatorioConfere = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        RelatorioInternoPorIdade = new javax.swing.JMenuItem();
        RelatorioInternosLocalidade = new javax.swing.JMenu();
        RelatorioInternosPorCidade = new javax.swing.JMenuItem();
        RelatorioInternosPorBairro = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jRelatorioAtendimentoInternos = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jRelatorioQuantidadeAtendimentoFamiliar = new javax.swing.JMenuItem();
        jRelatorioGeralQuantidadeAtendimentoFamiliar = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Serviço Social ::: ...");

        jPainelServicoSocial.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelServicoSocial.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelServicoSocialLayout = new javax.swing.GroupLayout(jPainelServicoSocial);
        jPainelServicoSocial.setLayout(jPainelServicoSocialLayout);
        jPainelServicoSocialLayout.setHorizontalGroup(
            jPainelServicoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelServicoSocialLayout.setVerticalGroup(
            jPainelServicoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        Vistantes.setText("Visitantes");
        Vistantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VistantesActionPerformed(evt);
            }
        });
        jMenu1.add(Vistantes);

        RolVisitas.setForeground(new java.awt.Color(204, 0, 0));
        RolVisitas.setText("Rol de Visitas Externa/Internas");
        RolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolVisitasActionPerformed(evt);
            }
        });
        jMenu1.add(RolVisitas);

        ListaDocumentosInternos.setText("Lista de Documentos de Internos");
        ListaDocumentosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaDocumentosInternosActionPerformed(evt);
            }
        });
        jMenu1.add(ListaDocumentosInternos);
        jMenu1.add(jSeparator15);

        InstituicaoReligiosa.setText("Instituição Religiosa");
        InstituicaoReligiosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstituicaoReligiosaActionPerformed(evt);
            }
        });
        jMenu1.add(InstituicaoReligiosa);

        VisitantesReligiosos.setText("Visitantes Religiosos");
        VisitantesReligiosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitantesReligiososActionPerformed(evt);
            }
        });
        jMenu1.add(VisitantesReligiosos);

        RolVisitasReligiosas.setText("Rol de Visitas Religiosas");
        RolVisitasReligiosas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolVisitasReligiosasActionPerformed(evt);
            }
        });
        jMenu1.add(RolVisitasReligiosas);
        jMenu1.add(jSeparator1);

        AprovadoresOcorrenciasVisitasPortaria.setForeground(new java.awt.Color(0, 0, 255));
        AprovadoresOcorrenciasVisitasPortaria.setText("Aprovador Ocorrência Portaria (Visitas Internos)");
        AprovadoresOcorrenciasVisitasPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprovadoresOcorrenciasVisitasPortariaActionPerformed(evt);
            }
        });
        jMenu1.add(AprovadoresOcorrenciasVisitasPortaria);
        jMenu1.add(jSeparator10);

        jMenu9.setForeground(new java.awt.Color(0, 102, 0));
        jMenu9.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        jRegistroAtendeInternoBio.setForeground(new java.awt.Color(0, 153, 0));
        jRegistroAtendeInternoBio.setText("Registra Atendimento por Biometria");
        jRegistroAtendeInternoBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroAtendeInternoBioActionPerformed(evt);
            }
        });
        jMenu9.add(jRegistroAtendeInternoBio);

        RegistroAtendimentoImpresso.setForeground(new java.awt.Color(0, 0, 204));
        RegistroAtendimentoImpresso.setText("Registro Atendimento por Impressão");
        RegistroAtendimentoImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoImpressoActionPerformed(evt);
            }
        });
        jMenu9.add(RegistroAtendimentoImpresso);
        jMenu9.add(jSeparator21);

        jCancelamentoRegistroAtendimento.setText("Cancelar  Registro de Atendimento de Interno");
        jCancelamentoRegistroAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelamentoRegistroAtendimentoActionPerformed(evt);
            }
        });
        jMenu9.add(jCancelamentoRegistroAtendimento);

        jMenu1.add(jMenu9);
        jMenu1.add(jSeparator14);

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
        jMenu1.add(jSeparator16);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        jMenu1.add(Sair);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Consultas");

        ProntuariosInternos.setText("Prontuário de Internos");
        ProntuariosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProntuariosInternosActionPerformed(evt);
            }
        });
        jMenu5.add(ProntuariosInternos);

        LocalizacaoInternos.setText("Localização de Internos");
        LocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalizacaoInternosActionPerformed(evt);
            }
        });
        jMenu5.add(LocalizacaoInternos);
        jMenu5.add(jSeparator3);

        HistoricosMovimentacaoTec.setText("Historico de Movimentação");
        HistoricosMovimentacaoTec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricosMovimentacaoTecActionPerformed(evt);
            }
        });
        jMenu5.add(HistoricosMovimentacaoTec);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Movimentação");

        AdmissaoInternos.setText("Admissão/Evolução de Internos");
        AdmissaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissaoInternosActionPerformed(evt);
            }
        });
        jMenu2.add(AdmissaoInternos);

        PerfilPopulacaoCarceraria.setForeground(new java.awt.Color(255, 0, 0));
        PerfilPopulacaoCarceraria.setText("Perfil da População Carcerária");
        PerfilPopulacaoCarceraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilPopulacaoCarcerariaActionPerformed(evt);
            }
        });
        jMenu2.add(PerfilPopulacaoCarceraria);

        AtualizacaoDocumentosInternos.setText("Atualização de Documentos de Internos");
        AtualizacaoDocumentosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizacaoDocumentosInternosActionPerformed(evt);
            }
        });
        jMenu2.add(AtualizacaoDocumentosInternos);
        jMenu2.add(jSeparator13);

        AtendimentoFamiliar.setText("Atendimento Familiar");
        AtendimentoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoFamiliarActionPerformed(evt);
            }
        });
        jMenu2.add(AtendimentoFamiliar);

        CancelarVisitaInterno.setText("Cancelar Visita de Interno");
        CancelarVisitaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarVisitaInternoActionPerformed(evt);
            }
        });
        jMenu2.add(CancelarVisitaInterno);
        jMenu2.add(jSeparator19);

        jMenu8.setText("P.A.I. - Programa de Assistência Individualizado");

        jPaiNOVO.setForeground(new java.awt.Color(204, 0, 0));
        jPaiNOVO.setText("P.A.I. - Programa de Assistência Individualizado - NOVO");
        jPaiNOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaiNOVOActionPerformed(evt);
            }
        });
        jMenu8.add(jPaiNOVO);

        jMenuItem1.setText("Monitoramento Mensal do Programa de Assistência Individualizada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenu2.add(jMenu8);
        jMenu2.add(jSeparator11);

        BloqueioLiberacaoVisitasInternos.setForeground(new java.awt.Color(0, 153, 0));
        BloqueioLiberacaoVisitasInternos.setText("Bloqueio/Liberação de Visitas - Internos");
        BloqueioLiberacaoVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloqueioLiberacaoVisitasInternosActionPerformed(evt);
            }
        });
        jMenu2.add(BloqueioLiberacaoVisitasInternos);
        jMenu2.add(jSeparator9);

        ControleLigacoes.setText("Controle de Ligações Telefonicas");
        ControleLigacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleLigacoesActionPerformed(evt);
            }
        });
        jMenu2.add(ControleLigacoes);
        jMenu2.add(jSeparator12);

        jOcorrenciasServicoSocial.setText("Ocorrências do Serviço Social");
        jOcorrenciasServicoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcorrenciasServicoSocialActionPerformed(evt);
            }
        });
        jMenu2.add(jOcorrenciasServicoSocial);
        jMenu2.add(jSeparator4);

        HistoricoAvaliacaoSocial.setText("Histórico de Avaliação Social");
        HistoricoAvaliacaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoAvaliacaoSocialActionPerformed(evt);
            }
        });
        jMenu2.add(HistoricoAvaliacaoSocial);

        HistoricoAvaliacaoEmprego.setText("Historico de Avaliação de Emprego");
        HistoricoAvaliacaoEmprego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoAvaliacaoEmpregoActionPerformed(evt);
            }
        });
        jMenu2.add(HistoricoAvaliacaoEmprego);
        jMenu2.add(jSeparator20);

        jSolicitacaoAtestadoReclusao.setForeground(new java.awt.Color(0, 0, 204));
        jSolicitacaoAtestadoReclusao.setText("Solicitação de Atestado de  Reclusão");
        jSolicitacaoAtestadoReclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSolicitacaoAtestadoReclusaoActionPerformed(evt);
            }
        });
        jMenu2.add(jSolicitacaoAtestadoReclusao);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jRolVisitas.setText("Rol de Visitas");
        jRolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRolVisitasActionPerformed(evt);
            }
        });
        jMenu3.add(jRolVisitas);

        RelatorioVisitasGrauParentesco.setText("Relatório de Visitas de Internos por Grau de Parentesco");
        RelatorioVisitasGrauParentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasGrauParentescoActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioVisitasGrauParentesco);

        RelatorioCadastroVisitas.setText("Relatório de Cadastro de Visitas");
        RelatorioCadastroVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroVisitasActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioCadastroVisitas);

        RelatorioVisitasPorIdade.setText("Relatório de Visitas por Idade");
        RelatorioVisitasPorIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasPorIdadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioVisitasPorIdade);

        jMenuItem4.setText("Relatório de Internos que não recebe Visitas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jRelatorioVisitasInternos.setText("Relatório de Visitas de Internos");
        jRelatorioVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioVisitasInternosActionPerformed(evt);
            }
        });
        jMenu3.add(jRelatorioVisitasInternos);
        jMenu3.add(jSeparator17);

        jMenu6.setText("Relatório de Internos sem Documentos");

        CartaoSus.setText("Internos sem Cartão SUS");
        CartaoSus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaoSusActionPerformed(evt);
            }
        });
        jMenu6.add(CartaoSus);

        RG.setText("Internos sem R.G.");
        RG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGActionPerformed(evt);
            }
        });
        jMenu6.add(RG);

        CPF.setText("Internos sem C.P.F.");
        CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFActionPerformed(evt);
            }
        });
        jMenu6.add(CPF);

        jMenu3.add(jMenu6);

        jMenu7.setText("Relatório de Documentos de Internos");

        CartaoSUS.setText("Cartão do SUS");
        CartaoSUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaoSUSActionPerformed(evt);
            }
        });
        jMenu7.add(CartaoSUS);

        DocumentoRG.setText("R.G.");
        DocumentoRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentoRGActionPerformed(evt);
            }
        });
        jMenu7.add(DocumentoRG);

        DocumentoCPF.setText("C.P.F.");
        DocumentoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentoCPFActionPerformed(evt);
            }
        });
        jMenu7.add(DocumentoCPF);

        jMenu3.add(jMenu7);

        RelatorioDocumentosInternosServicoSocial.setText("Relatório de Internos com Documentos no Serviço Social");
        RelatorioDocumentosInternosServicoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDocumentosInternosServicoSocialActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioDocumentosInternosServicoSocial);
        jMenu3.add(jSeparator18);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entradas de Interno na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaInternosUnidade);
        jMenu3.add(jSeparator5);

        jMenuItem16.setText("Relatório de Admissão de Internos");
        jMenuItem16.setEnabled(false);
        jMenu3.add(jMenuItem16);

        jMenuItem11.setText("Relatório de Atendimento Familiar");
        jMenuItem11.setEnabled(false);
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Relatorio de Atendimento a Internos");
        jMenuItem12.setEnabled(false);
        jMenu3.add(jMenuItem12);
        jMenu3.add(jSeparator6);

        jMenuItem13.setText("Relatório de Ligações Telefônicas de Internos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);
        jMenu3.add(jSeparator7);

        RelatorioPrevisaoSaidaInternos.setText("Relatório de Previsão de Saída de Internos");
        RelatorioPrevisaoSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaInternosActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioPrevisaoSaidaInternos);
        jMenu3.add(jSeparator8);

        jMenu4.setText("Relatórios de Localização de Internos");

        RelatorioGeralInternosPavilhao.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralInternosPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralInternosPavilhaoActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioGeralInternosPavilhao);

        RelatorioConfere.setText("Relatório de Confere por Cela");
        RelatorioConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioConfereActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioConfere);

        jMenu3.add(jMenu4);
        jMenu3.add(jSeparator2);

        RelatorioInternoPorIdade.setText("Relatório de Internos por Idade");
        RelatorioInternoPorIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternoPorIdadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioInternoPorIdade);

        RelatorioInternosLocalidade.setText("Relatorio de Internos por Localidade");

        RelatorioInternosPorCidade.setText("Relatório de Internos por Cidade");
        RelatorioInternosPorCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosPorCidadeActionPerformed(evt);
            }
        });
        RelatorioInternosLocalidade.add(RelatorioInternosPorCidade);

        RelatorioInternosPorBairro.setText("Relatório de Internos por Bairro");
        RelatorioInternosPorBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosPorBairroActionPerformed(evt);
            }
        });
        RelatorioInternosLocalidade.add(RelatorioInternosPorBairro);

        jMenu3.add(RelatorioInternosLocalidade);
        jMenu3.add(jSeparator22);

        jRelatorioAtendimentoInternos.setForeground(new java.awt.Color(0, 102, 51));
        jRelatorioAtendimentoInternos.setText("Relatório de Quantitativo de Atendimento");
        jRelatorioAtendimentoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioAtendimentoInternosActionPerformed(evt);
            }
        });
        jMenu3.add(jRelatorioAtendimentoInternos);
        jMenu3.add(jSeparator23);

        jRelatorioQuantidadeAtendimentoFamiliar.setForeground(new java.awt.Color(204, 0, 0));
        jRelatorioQuantidadeAtendimentoFamiliar.setText("Relatório Quantitativo de Internos na Casa Com Familiares acompanhados");
        jRelatorioQuantidadeAtendimentoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioQuantidadeAtendimentoFamiliarActionPerformed(evt);
            }
        });
        jMenu3.add(jRelatorioQuantidadeAtendimentoFamiliar);

        jRelatorioGeralQuantidadeAtendimentoFamiliar.setForeground(new java.awt.Color(0, 0, 255));
        jRelatorioGeralQuantidadeAtendimentoFamiliar.setText("Relatório Quantitativo de Internos Com Familiares acompanhados");
        jRelatorioGeralQuantidadeAtendimentoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioGeralQuantidadeAtendimentoFamiliarActionPerformed(evt);
            }
        });
        jMenu3.add(jRelatorioGeralQuantidadeAtendimentoFamiliar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelServicoSocial)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelServicoSocial)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void VistantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VistantesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroVisitasSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaCadastroVisitasSS) && codAbrirSS == 1) {
            if (objVsocial == null || objVsocial.isClosed()) {
                objVsocial = new TelaVisitaSocial();
                jPainelServicoSocial.add(objVsocial);
                objVsocial.setVisible(true);
            } else {
                if (objVsocial.isVisible()) {
                    if (objVsocial.isIcon()) { // Se esta minimizado
                        try {
                            objVsocial.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objVsocial.toFront(); // traz para frente
                        objVsocial.pack();//volta frame 
                    }
                } else {
                    objVsocial = new TelaVisitaSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objVsocial);//adicona frame ao JDesktopPane  
                    objVsocial.setVisible(true);
                }
            }
            try {
                objVsocial.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VistantesActionPerformed

    private void RolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolVisitasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRolVisitasSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaRolVisitasSS) && codAbrirSS == 1) {
            if (objRolVis == null || objRolVis.isClosed()) {
                objRolVis = new TelaRolVisitas();
                jPainelServicoSocial.add(objRolVis);
                objRolVis.setVisible(true);
            } else {
                if (objRolVis.isVisible()) {
                    if (objRolVis.isIcon()) { // Se esta minimizado
                        try {
                            objRolVis.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRolVis.toFront(); // traz para frente
                        objRolVis.pack();//volta frame 
                    }
                } else {
                    objRolVis = new TelaRolVisitas();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objRolVis);//adicona frame ao JDesktopPane  
                    objRolVis.setVisible(true);
                }
            }
            try {
                objRolVis.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RolVisitasActionPerformed

    private void ControleLigacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleLigacoesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaControleLigacoesTelSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaControleLigacoesTelSS) && codAbrirSS == 1) {
            if (objContLiga == null || objContLiga.isClosed()) {
                objContLiga = new TelaControleLigacoesSS();
                jPainelServicoSocial.add(objContLiga);
                objContLiga.setVisible(true);
            } else {
                if (objContLiga.isVisible()) {
                    if (objContLiga.isIcon()) { // Se esta minimizado
                        try {
                            objContLiga.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objContLiga.toFront(); // traz para frente
                        objContLiga.pack();//volta frame 
                    }
                } else {
                    objContLiga = new TelaControleLigacoesSS();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objContLiga);//adicona frame ao JDesktopPane  
                    objContLiga.setVisible(true);
                }
            }
            try {
                objContLiga.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ControleLigacoesActionPerformed

    private void AdmissaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmissaoInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoInternosServicoSocial);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAdmissaoInternosServicoSocial) && codAbrirSS == 1) {
            if (objAtenSocial == null || objAtenSocial.isClosed()) {
                objAtenSocial = new TelaAtendimentoSocial();
                jPainelServicoSocial.add(objAtenSocial);
                objAtenSocial.setVisible(true);
            } else {
                if (objAtenSocial.isVisible()) {
                    if (objAtenSocial.isIcon()) { // Se esta minimizado
                        try {
                            objAtenSocial.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtenSocial.toFront(); // traz para frente
                        objAtenSocial.pack();//volta frame 
                    }
                } else {
                    objAtenSocial = new TelaAtendimentoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objAtenSocial);//adicona frame ao JDesktopPane  
                    objAtenSocial.setVisible(true);
                }
            }
            try {
                objAtenSocial.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AdmissaoInternosActionPerformed

    private void HistoricosMovimentacaoTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricosMovimentacaoTecActionPerformed
        // TODO add your handling code here:
        if (objMovTec == null || objMovTec.isClosed()) {
            objMovTec = new TelaMovHistoricoTecnico();
            jPainelServicoSocial.add(objMovTec);
            objMovTec.setVisible(true);
        } else {
            if (objMovTec.isVisible()) {
                if (objMovTec.isIcon()) { // Se esta minimizado
                    try {
                        objMovTec.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMovTec.toFront(); // traz para frente
                    objMovTec.pack();//volta frame 
                }
            } else {
                objMovTec = new TelaMovHistoricoTecnico();
                TelaModuloServicoSocial.jPainelServicoSocial.add(objMovTec);//adicona frame ao JDesktopPane  
                objMovTec.setVisible(true);
            }
        }
        try {
            objMovTec.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricosMovimentacaoTecActionPerformed

    private void AtendimentoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoFamiliarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoFamiliaSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAtendimentoFamiliaSS) && codAbrirSS == 1) {
            if (objAtendFam == null || objAtendFam.isClosed()) {
                objAtendFam = new TelaAtendimentoFamiliar();
                jPainelServicoSocial.add(objAtendFam);
                objAtendFam.setVisible(true);
            } else {
                if (objAtendFam.isVisible()) {
                    if (objAtendFam.isIcon()) { // Se esta minimizado
                        try {
                            objAtendFam.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtendFam.toFront(); // traz para frente
                        objAtendFam.pack();//volta frame 
                    }
                } else {
                    objAtendFam = new TelaAtendimentoFamiliar();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objAtendFam);//adicona frame ao JDesktopPane  
                    objAtendFam.setVisible(true);
                }
            }
            try {
                objAtendFam.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoFamiliarActionPerformed

    private void ProntuariosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProntuariosInternosActionPerformed
        // TODO add your handling code here:
        if (objConInt == null || objConInt.isClosed()) {
            objConInt = new TelaConsultaProntuarioInternoCrc();
            jPainelServicoSocial.add(objConInt);
            objConInt.setVisible(true);
        } else {
            if (objConInt.isVisible()) {
                if (objConInt.isIcon()) { // Se esta minimizado
                    try {
                        objConInt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConInt.toFront(); // traz para frente
                    objConInt.pack();//volta frame 
                }
            } else {
                objConInt = new TelaConsultaProntuarioInternoCrc();
                TelaModuloServicoSocial.jPainelServicoSocial.add(objConInt);//adicona frame ao JDesktopPane  
                objConInt.setVisible(true);
            }
        }
        try {
            objConInt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProntuariosInternosActionPerformed

    private void LocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objConLocal == null || objConLocal.isClosed()) {
            objConLocal = new TelaConsultaLocalInterno();
            jPainelServicoSocial.add(objConLocal);
            objConLocal.setVisible(true);
        } else {
            if (objConLocal.isVisible()) {
                if (objConLocal.isIcon()) { // Se esta minimizado
                    try {
                        objConLocal.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConLocal.toFront(); // traz para frente
                    objConLocal.pack();//volta frame 
                }
            } else {
                objConLocal = new TelaConsultaLocalInterno();
                TelaModuloServicoSocial.jPainelServicoSocial.add(objConLocal);//adicona frame ao JDesktopPane  
                objConLocal.setVisible(true);
            }
        }
        try {
            objConLocal.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalizacaoInternosActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objAgeRecSs == null || objAgeRecSs.isClosed()) {
            objAgeRecSs = new TelaRecadosServicoSocial();
            jPainelServicoSocial.add(objAgeRecSs);
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
                objAgeRecSs = new TelaRecadosServicoSocial();
                TelaModuloServicoSocial.jPainelServicoSocial.add(objAgeRecSs);//adicona frame ao JDesktopPane  
                objAgeRecSs.setVisible(true);
            }
        }
        try {
            objAgeRecSs.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void jRolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRolVisitasActionPerformed
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
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jRolVisitasActionPerformed

    private void ListaDocumentosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaDocumentosInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaListaDocumentosSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaListaDocumentosSS) && codAbrirSS == 1) {
            if (objListaDocInternos == null || objListaDocInternos.isClosed()) {
                objListaDocInternos = new TelaDocumetosInternosServicoSocial();
                jPainelServicoSocial.add(objListaDocInternos);
                objListaDocInternos.setVisible(true);
            } else {
                if (objListaDocInternos.isVisible()) {
                    if (objListaDocInternos.isIcon()) { // Se esta minimizado
                        try {
                            objListaDocInternos.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objListaDocInternos.toFront(); // traz para frente
                        objListaDocInternos.pack();//volta frame 
                    }
                } else {
                    objListaDocInternos = new TelaDocumetosInternosServicoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objListaDocInternos);//adicona frame ao JDesktopPane  
                    objListaDocInternos.setVisible(true);
                }
            }
            try {
                objListaDocInternos.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ListaDocumentosInternosActionPerformed

    private void RelatorioPrevisaoSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaServicoSocial objRelPrevSaiInter = new TelaRelatorioPrevisaoSaidaServicoSocial();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelPrevSaiInter);
        objRelPrevSaiInter.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaInternosActionPerformed

    private void RelatorioConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConf = new TelaRelatorioConfere();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelConf);
        objRelConf.show();
    }//GEN-LAST:event_RelatorioConfereActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioLigacoesInternos objRelLiga = new TelaRelatorioLigacoesInternos();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelLiga);
        objRelLiga.show();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void RelatorioInternosPorCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosPorCidadeActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosPorCidade.jasper";
            conecta.executaSQL("SELECT MatriculaCrc, NomeInternoCrc, CidadeCrc FROM PRONTUARIOSCRC WHERE SituacaoCrc='" + statusEntrada + "'OR SituacaoCrc='" + statusRetorno + "'ORDER BY CidadeCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("statusEntrada", statusEntrada);
            parametros.put("statusSaida", statusRetorno);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos por Cidade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioInternosPorCidadeActionPerformed

    private void RelatorioInternoPorIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternoPorIdadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPorIdade objIdade = new TelaRelatorioPorIdade();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objIdade);
        objIdade.show();
    }//GEN-LAST:event_RelatorioInternoPorIdadeActionPerformed

    private void RelatorioInternosPorBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosPorBairroActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosPorBairro.jasper";
            conecta.executaSQL("SELECT MatriculaCrc, NomeInternoCrc, CidadeCrc,BairroCrc FROM PRONTUARIOSCRC WHERE SituacaoCrc='" + statusEntrada + "'OR SituacaoCrc='" + statusRetorno + "'ORDER BY CidadeCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("statusEntrada", statusEntrada);
            parametros.put("statusSaida", statusRetorno);
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
    }//GEN-LAST:event_RelatorioInternosPorBairroActionPerformed

    private void RelatorioVisitasPorIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVisitasPorIdadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioVisitaPorIdade objRelVisitasIdade = new TelaRelatorioVisitaPorIdade();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelVisitasIdade);
        objRelVisitasIdade.show();
    }//GEN-LAST:event_RelatorioVisitasPorIdadeActionPerformed

    private void RelatorioCadastroVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroVisitasActionPerformed
        // TODO add your handling code here:
        TelaRelatorioCadastroVisitasInternos objRelVisitasInt = new TelaRelatorioCadastroVisitasInternos();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelVisitasInt);
        objRelVisitasInt.show();
    }//GEN-LAST:event_RelatorioCadastroVisitasActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelServicoSocial.add(objAgEventos);
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
                TelaModuloServicoSocial.jPainelServicoSocial.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void RelatorioVisitasGrauParentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVisitasGrauParentescoActionPerformed
        // TODO add your handling code here:
        TelaRelVisitasGrauParentesco objRelParent = new TelaRelVisitasGrauParentesco();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelParent);
        objRelParent.show();
    }//GEN-LAST:event_RelatorioVisitasGrauParentescoActionPerformed

    private void AprovadoresOcorrenciasVisitasPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprovadoresOcorrenciasVisitasPortariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadoresOcrSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAprovadoresOcrSS) && codAbrirSS == 1) {
            if (objAprovaOcr == null || objAprovaOcr.isClosed()) {
                objAprovaOcr = new TelaAprovadoresOcorrenciaVisitasInternosServicoSocial();
                jPainelServicoSocial.add(objAprovaOcr);
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
                    objAprovaOcr = new TelaAprovadoresOcorrenciaVisitasInternosServicoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objAprovaOcr);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_AprovadoresOcorrenciasVisitasPortariaActionPerformed

    private void BloqueioLiberacaoVisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloqueioLiberacaoVisitasInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaBloqueioLiberacaoVisitasSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaBloqueioLiberacaoVisitasSS) && codAbrirSS == 1) {
            if (objBloqLibOcr == null || objBloqLibOcr.isClosed()) {
                objBloqLibOcr = new TelaAprovacaoServicoSocial();
                jPainelServicoSocial.add(objBloqLibOcr);
                objBloqLibOcr.setVisible(true);
            } else {
                if (objBloqLibOcr.isVisible()) {
                    if (objBloqLibOcr.isIcon()) { // Se esta minimizado
                        try {
                            objBloqLibOcr.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objBloqLibOcr.toFront(); // traz para frente
                        objBloqLibOcr.pack();//volta frame 
                    }
                } else {
                    objBloqLibOcr = new TelaAprovacaoServicoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objBloqLibOcr);//adicona frame ao JDesktopPane  
                    objBloqLibOcr.setVisible(true);
                }
            }
            try {
                objBloqLibOcr.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_BloqueioLiberacaoVisitasInternosActionPerformed

    private void jOcorrenciasServicoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcorrenciasServicoSocialActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciasSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaOcorrenciasSS) && codAbrirSS == 1) {
            if (objOcrSSocial == null || objOcrSSocial.isClosed()) {
                objOcrSSocial = new TelaOcorrenciaServicoSocial();
                jPainelServicoSocial.add(objOcrSSocial);
                objOcrSSocial.setVisible(true);
            } else {
                if (objOcrSSocial.isVisible()) {
                    if (objOcrSSocial.isIcon()) { // Se esta minimizado
                        try {
                            objOcrSSocial.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcrSSocial.toFront(); // traz para frente
                        objOcrSSocial.pack();//volta frame 
                    }
                } else {
                    objOcrSSocial = new TelaOcorrenciaServicoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objOcrSSocial);//adicona frame ao JDesktopPane  
                    objOcrSSocial.setVisible(true);
                }
            }
            try {
                objOcrSSocial.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jOcorrenciasServicoSocialActionPerformed

    private void PerfilPopulacaoCarcerariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilPopulacaoCarcerariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPerfilPopCarcerariaSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaPerfilPopCarcerariaSS) && codAbrirSS == 1) {
            if (objPerfilCar == null || objPerfilCar.isClosed()) {
                objPerfilCar = new TelaPerfilCarcerario();
                jPainelServicoSocial.add(objPerfilCar);
                objPerfilCar.setVisible(true);
            } else {
                if (objPerfilCar.isVisible()) {
                    if (objPerfilCar.isIcon()) { // Se esta minimizado
                        try {
                            objPerfilCar.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPerfilCar.toFront(); // traz para frente
                        objPerfilCar.pack();//volta frame 
                    }
                } else {
                    objPerfilCar = new TelaPerfilCarcerario();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objPerfilCar);//adicona frame ao JDesktopPane  
                    objPerfilCar.setVisible(true);
                }
            }
            try {
                objPerfilCar.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_PerfilPopulacaoCarcerariaActionPerformed

    private void RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosSemCartaoRG.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.RgInternoCrc='" + cartaoRG + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.RgInternoCrc='" + cartaoSUS + "' "
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
            jv.setTitle("Listagem de Internos sem RG");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RGActionPerformed

    private void CartaoSusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaoSusActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosSemCartaoSUS.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.CartaoSus='" + cartaoSUS + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.CartaoSus='" + cartaoSUS + "' "
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
            jv.setTitle("Listagem de Internos sem Cartão do SUS");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_CartaoSusActionPerformed

    private void CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosSemCartaoCPF.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.CpfInternoCrc='" + cartaoCPF + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.CpfInternoCrc='" + cartaoCPF + "' "
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
            jv.setTitle("Listagem de Internos sem CPF");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_CPFActionPerformed

    private void VisitantesReligiososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitantesReligiososActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaVisitantesRelSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaVisitantesRelSS) && codAbrirSS == 1) {
            if (objVisitaRel == null || objVisitaRel.isClosed()) {
                objVisitaRel = new TelaVisitaSocialReligiosa();
                jPainelServicoSocial.add(objVisitaRel);
                objVisitaRel.setVisible(true);
            } else {
                if (objVisitaRel.isVisible()) {
                    if (objVisitaRel.isIcon()) { // Se esta minimizado
                        try {
                            objVisitaRel.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objVisitaRel.toFront(); // traz para frente
                        objVisitaRel.pack();//volta frame 
                    }
                } else {
                    objVisitaRel = new TelaVisitaSocialReligiosa();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objVisitaRel);//adicona frame ao JDesktopPane  
                    objVisitaRel.setVisible(true);
                }
            }
            try {
                objVisitaRel.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VisitantesReligiososActionPerformed

    private void InstituicaoReligiosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstituicaoReligiosaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaInstituicaoRelSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaInstituicaoRelSS) && codAbrirSS == 1) {
            if (objInstRel == null || objInstRel.isClosed()) {
                objInstRel = new TelaInstituicaoReligiosa();
                jPainelServicoSocial.add(objInstRel);
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
                    objInstRel = new TelaInstituicaoReligiosa();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objInstRel);//adicona frame ao JDesktopPane  
                    objInstRel.setVisible(true);
                }
            }
            try {
                objInstRel.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_InstituicaoReligiosaActionPerformed

    private void RolVisitasReligiosasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolVisitasReligiosasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRolVisitantesRelSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaRolVisitantesRelSS) && codAbrirSS == 1) {
            if (objRolVisitaRel == null || objRolVisitaRel.isClosed()) {
                objRolVisitaRel = new TelaRolVisitasReligiosas();
                jPainelServicoSocial.add(objRolVisitaRel);
                objRolVisitaRel.setVisible(true);
            } else {
                if (objRolVisitaRel.isVisible()) {
                    if (objRolVisitaRel.isIcon()) { // Se esta minimizado
                        try {
                            objRolVisitaRel.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRolVisitaRel.toFront(); // traz para frente
                        objRolVisitaRel.pack();//volta frame 
                    }
                } else {
                    objRolVisitaRel = new TelaRolVisitasReligiosas();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objRolVisitaRel);//adicona frame ao JDesktopPane  
                    objRolVisitaRel.setVisible(true);
                }
            }
            try {
                objRolVisitaRel.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RolVisitasReligiosasActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void AtualizacaoDocumentosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizacaoDocumentosInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtualizacaoDocSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaAtualizacaoDocSS) && codAbrirSS == 1) {
            if (objAtuaDoc == null || objAtuaDoc.isClosed()) {
                objAtuaDoc = new TelaAtualizacaoDocumentosServicoSocial();
                jPainelServicoSocial.add(objAtuaDoc);
                objAtuaDoc.setVisible(true);
            } else {
                if (objAtuaDoc.isVisible()) {
                    if (objAtuaDoc.isIcon()) { // Se esta minimizado
                        try {
                            objAtuaDoc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtuaDoc.toFront(); // traz para frente
                        objAtuaDoc.pack();//volta frame 
                    }
                } else {
                    objAtuaDoc = new TelaAtualizacaoDocumentosServicoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objAtuaDoc);//adicona frame ao JDesktopPane  
                    objAtuaDoc.setVisible(true);
                }
            }
            try {
                objAtuaDoc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtualizacaoDocumentosInternosActionPerformed

    private void CancelarVisitaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarVisitaInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelaVisitaSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaCancelaVisitaSS) && codAbrirSS == 1) {
            if (objCancelaVis == null || objCancelaVis.isClosed()) {
                objCancelaVis = new TelaCancelamentoVisitasInterno();
                jPainelServicoSocial.add(objCancelaVis);
                objCancelaVis.setVisible(true);
            } else {
                if (objCancelaVis.isVisible()) {
                    if (objCancelaVis.isIcon()) { // Se esta minimizado
                        try {
                            objCancelaVis.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCancelaVis.toFront(); // traz para frente
                        objCancelaVis.pack();//volta frame 
                    }
                } else {
                    objCancelaVis = new TelaCancelamentoVisitasInterno();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objCancelaVis);//adicona frame ao JDesktopPane  
                    objCancelaVis.setVisible(true);
                }
            }
            try {
                objCancelaVis.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CancelarVisitaInternoActionPerformed

    private void HistoricoAvaliacaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoAvaliacaoSocialActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaHistAvaSocial_SS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaHistAvaSocial_SS) && codAbrirSS == 1) {
            if (objHistAvaSocial == null || objHistAvaSocial.isClosed()) {
                objHistAvaSocial = new TelaHistoricoAvaliacaoSocial();
                jPainelServicoSocial.add(objHistAvaSocial);
                objHistAvaSocial.setVisible(true);
            } else {
                if (objHistAvaSocial.isVisible()) {
                    if (objHistAvaSocial.isIcon()) { // Se esta minimizado
                        try {
                            objHistAvaSocial.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objHistAvaSocial.toFront(); // traz para frente
                        objHistAvaSocial.pack();//volta frame 
                    }
                } else {
                    objHistAvaSocial = new TelaHistoricoAvaliacaoSocial();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objHistAvaSocial);//adicona frame ao JDesktopPane  
                    objHistAvaSocial.setVisible(true);
                }
            }
            try {
                objHistAvaSocial.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_HistoricoAvaliacaoSocialActionPerformed

    private void HistoricoAvaliacaoEmpregoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoAvaliacaoEmpregoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaHistAvaEmprego_SS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaHistAvaEmprego_SS) && codAbrirSS == 1) {
            if (objAvaEmp == null || objAvaEmp.isClosed()) {
                objAvaEmp = new TelaHistoricoAvaliacaoEmprego();
                jPainelServicoSocial.add(objAvaEmp);
                objAvaEmp.setVisible(true);
            } else {
                if (objAvaEmp.isVisible()) {
                    if (objAvaEmp.isIcon()) { // Se esta minimizado
                        try {
                            objAvaEmp.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAvaEmp.toFront(); // traz para frente
                        objAvaEmp.pack();//volta frame 
                    }
                } else {
                    objAvaEmp = new TelaHistoricoAvaliacaoEmprego();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objAvaEmp);//adicona frame ao JDesktopPane  
                    objAvaEmp.setVisible(true);
                }
            }
            try {
                objAvaEmp.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_HistoricoAvaliacaoEmpregoActionPerformed

    private void CartaoSUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaoSUSActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosComCartaoSUS.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.CartaoSus!='" + cartaoSUS + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.CartaoSus!='" + cartaoSUS + "' "
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
            jv.setTitle("Listagem de Internos com Cartão do SUS");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_CartaoSUSActionPerformed

    private void DocumentoRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentoRGActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosComCartaoRG.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.RgInternoCrc!='" + cartaoRG + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.RgInternoCrc!='" + cartaoSUS + "' "
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
            jv.setTitle("Listagem de Internos com R.G.");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_DocumentoRGActionPerformed

    private void DocumentoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentoCPFActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosComCartaoCPF.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.CpfInternoCrc!='" + cartaoCPF + "' "
                    + "AND SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.CpfInternoCrc!='" + cartaoCPF + "' "
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
    }//GEN-LAST:event_DocumentoCPFActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:

        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosSemVisitas.jasper";
            conecta.executaSQL("SELECT * FROM ATENDIMENTOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ATENDIMENTOSOCIAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ATENDIMENTOSOCIAL.RecebeVisita='" + recebeVisita + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + statusEntrada + "' "
                    + "OR ATENDIMENTOSOCIAL.RecebeVisita='" + recebeVisita + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + statusRetorno + "'");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("entrada", statusEntrada);
            parametros.put("retorno", statusRetorno);
            parametros.put("descricaoUnidade", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Internos Sem Visita");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
    }//GEN-LAST:event_RelatorioGeralInternosPavilhaoActionPerformed

    private void RelatorioDocumentosInternosServicoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDocumentosInternosServicoSocialActionPerformed
        // TODO add your handling code here:
        TelaDocumentosInternosServicoSocial objRelDoc = new TelaDocumentosInternosServicoSocial();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelDoc);
        objRelDoc.show();
    }//GEN-LAST:event_RelatorioDocumentosInternosServicoSocialActionPerformed

    private void jPaiNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaiNOVOActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPAISS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaPAISS) && codAbrirSS == 1) {
            if (objPaiNovo == null || objPaiNovo.isClosed()) {
                objPaiNovo = new TelaPAI_NOVO();
                jPainelServicoSocial.add(objPaiNovo);
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
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objPaiNovo);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_jPaiNOVOActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção...");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jRelatorioVisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioVisitasInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasInternos objRelVisitasInt = new TelaRelatorioEntradaSaidaVisitasInternos();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelVisitasInt);
        objRelVisitasInt.show();
    }//GEN-LAST:event_jRelatorioVisitasInternosActionPerformed

    private void jRegistroAtendeInternoBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroAtendeInternoBioActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoBioSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaRegistroAtendimentoBioSS) && codAbrirSS == 1) {
            if (objRegBio == null || objRegBio.isClosed()) {
                objRegBio = new TelaRegistroInternosAtendimentoSS();
                jPainelServicoSocial.add(objRegBio);
                objRegBio.setVisible(true);
            } else {
                if (objRegBio.isVisible()) {
                    if (objRegBio.isIcon()) { // Se esta minimizado
                        try {
                            objRegBio.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegBio.toFront(); // traz para frente
                        objRegBio.pack();//volta frame 
                    }
                } else {
                    objRegBio = new TelaRegistroInternosAtendimentoSS();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objRegBio);//adicona frame ao JDesktopPane  
                    objRegBio.setVisible(true);
                }
            }
            try {
                objRegBio.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistroAtendeInternoBioActionPerformed

    private void RegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoImpressaoBioSSocial);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaRegistroAtendimentoImpressaoBioSSocial) && codAbrirSS == 1) {
            if (objAutoImp == null || objAutoImp.isClosed()) {
                objAutoImp = new TelaRegistroInternosAtendimentoImpressoSS();
                jPainelServicoSocial.add(objAutoImp);
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
                    objAutoImp = new TelaRegistroInternosAtendimentoImpressoSS();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objAutoImp);//adicona frame ao JDesktopPane  
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

    private void jSolicitacaoAtestadoReclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSolicitacaoAtestadoReclusaoActionPerformed
        // TODO add your handling code here:TelaSolicitacaoAuxilioReclusao
        buscarAcessoUsuario(telaSolicitacaoAuxilioReclusao);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaSolicitacaoAuxilioReclusao) && codAbrirSS == 1) {
            if (objSoliPedRec == null || objSoliPedRec.isClosed()) {
                objSoliPedRec = new TelaSolicitacaoAuxilioReclusao();
                jPainelServicoSocial.add(objSoliPedRec);
                objSoliPedRec.setVisible(true);
            } else {
                if (objSoliPedRec.isVisible()) {
                    if (objSoliPedRec.isIcon()) { // Se esta minimizado
                        try {
                            objSoliPedRec.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSoliPedRec.toFront(); // traz para frente
                        objSoliPedRec.pack();//volta frame 
                    }
                } else {
                    objSoliPedRec = new TelaSolicitacaoAuxilioReclusao();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objSoliPedRec);//adicona frame ao JDesktopPane  
                    objSoliPedRec.setVisible(true);
                }
            }
            try {
                objSoliPedRec.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jSolicitacaoAtestadoReclusaoActionPerformed

    private void jRelatorioAtendimentoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioAtendimentoInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioProducaoSS objRelProdSS = new TelaRelatorioProducaoSS();
        TelaModuloServicoSocial.jPainelServicoSocial.add(objRelProdSS);
        objRelProdSS.show();
    }//GEN-LAST:event_jRelatorioAtendimentoInternosActionPerformed

    private void jRelatorioQuantidadeAtendimentoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioQuantidadeAtendimentoFamiliarActionPerformed
        // TODO add your handling code here:
         try {
                            conecta.abrirConexao();
                            String path = "reports/RelatorioQuantitativoFamiliarAcomp.jasper";
                            conecta.executaSQL("SELECT DISTINCT P.IdInternoCrc,\n"
                                    + "P.NomeInternoCrc,\n"
                                    + "V.IdVisita AS Cadastradas,\n"
                                    + "H.IdVisita AS Visitaram,\n"
                                    + " A.IdVisita AS Atendidas FROM PRONTUARIOSCRC AS P\n"
                                    + "INNER JOIN VERIFICA_DOCUMENTOS_VISITA AS V ON P.IdInternoCrc=V.IdInternoCrc\n"
                                    + "LEFT JOIN HISTORICOVISITASINTERNOS AS H ON V.IdVisita=H.IdVisita\n"
                                    + "LEFT JOIN ATENDIMENTOFAMILIAR AS A ON H.IdVisita=A.IdVisita\n"
                                    + "WHERE  P.SituacaoCrc LIKE 'ENTRADA NA UNIDADE' OR P.SituacaoCrc LIKE 'RETORNO A UNIDADE'\n" 
                                    + "ORDER BY P.NomeInternoCrc");
                            HashMap parametros = new HashMap();
//                            parametros.put("dataInicial", dataInicial); // Descomentar linha caso mude a chamada do relatório por data.
//                            parametros.put("dataFinal", dataFinal); // Descomentar linha caso mude a chamada do relatório por data.
                            parametros.put("pUsuario", nameUser);
                            parametros.put("pUnidade", descricaoUnidade);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Relatório de Acompanhamento Familiar.");
                            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                            jv.toFront(); // Traz o relatorio para frente da aplicação            
                            conecta.desconecta();
                        } catch (JRException e) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                        }
         
        //--> Descomentar as três linhas abaixo e comentar codigo acima caso mude a chamada do relatório por data.
        //TelaRelatorioQuantidadeAconpanhamentoFamiliar objRelAF = new TelaRelatorioQuantidadeAconpanhamentoFamiliar();
        //TelaModuloServicoSocial.jPainelServicoSocial.add(objRelAF);
        //objRelAF.show();
    }//GEN-LAST:event_jRelatorioQuantidadeAtendimentoFamiliarActionPerformed

    private void jCancelamentoRegistroAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelamentoRegistroAtendimentoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelAtendInternoSS);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoSS.equals("ADMINISTRADORES") || codigoUserSS == codUserAcessoSS && nomeTelaSS.equals(telaCancelAtendInternoSS) && codAbrirSS == 1) {
            if (objCancelaAtend == null || objCancelaAtend.isClosed()) {
                objCancelaAtend = new TelaCancelamentoAtendimentoPSP();
                jPainelServicoSocial.add(objCancelaAtend);
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
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objCancelaAtend);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_jCancelamentoRegistroAtendimentoActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jRelatorioGeralQuantidadeAtendimentoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioGeralQuantidadeAtendimentoFamiliarActionPerformed
        // TODO add your handling code here:
        try {
                            conecta.abrirConexao();
                            String path = "reports/RelatorioQuantitativoFamiliarAcompGeral.jasper";
                            conecta.executaSQL("SELECT DISTINCT P.IdInternoCrc,\n"
                                    + "P.NomeInternoCrc,\n"
                                    + "V.IdVisita AS Cadastradas,\n"
                                    + "H.IdVisita AS Visitaram,\n"
                                    + " A.IdVisita AS Atendidas FROM PRONTUARIOSCRC AS P\n"
                                    + "INNER JOIN VERIFICA_DOCUMENTOS_VISITA AS V ON P.IdInternoCrc=V.IdInternoCrc\n"
                                    + "LEFT JOIN HISTORICOVISITASINTERNOS AS H ON V.IdVisita=H.IdVisita\n"
                                    + "LEFT JOIN ATENDIMENTOFAMILIAR AS A ON H.IdVisita=A.IdVisita\n"
                                    + "ORDER BY P.NomeInternoCrc");
                            HashMap parametros = new HashMap();//                          
                            parametros.put("pUsuario", nameUser);
                            parametros.put("pUnidade", descricaoUnidade);
                            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                            jv.setTitle("Relatório de Acompanhamento Familiar.");
                            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                            jv.toFront(); // Traz o relatorio para frente da aplicação            
                            conecta.desconecta();
                        } catch (JRException e) {
                            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
                        }
         
    }//GEN-LAST:event_jRelatorioGeralQuantidadeAtendimentoFamiliarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdmissaoInternos;
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem AprovadoresOcorrenciasVisitasPortaria;
    private javax.swing.JMenuItem AtendimentoFamiliar;
    private javax.swing.JMenuItem AtualizacaoDocumentosInternos;
    private javax.swing.JMenuItem BloqueioLiberacaoVisitasInternos;
    private javax.swing.JMenuItem CPF;
    private javax.swing.JMenuItem CancelarVisitaInterno;
    private javax.swing.JMenuItem CartaoSUS;
    private javax.swing.JMenuItem CartaoSus;
    private javax.swing.JMenuItem ControleLigacoes;
    private javax.swing.JMenuItem DocumentoCPF;
    private javax.swing.JMenuItem DocumentoRG;
    private javax.swing.JMenuItem HistoricoAvaliacaoEmprego;
    private javax.swing.JMenuItem HistoricoAvaliacaoSocial;
    private javax.swing.JMenuItem HistoricosMovimentacaoTec;
    private javax.swing.JMenuItem InstituicaoReligiosa;
    private javax.swing.JMenuItem ListaDocumentosInternos;
    private javax.swing.JMenuItem LocalizacaoInternos;
    private javax.swing.JMenuItem PerfilPopulacaoCarceraria;
    private javax.swing.JMenuItem ProntuariosInternos;
    private javax.swing.JMenuItem RG;
    private javax.swing.JMenuItem RegistroAtendimentoImpresso;
    private javax.swing.JMenuItem RelatorioCadastroVisitas;
    private javax.swing.JMenuItem RelatorioConfere;
    private javax.swing.JMenuItem RelatorioDocumentosInternosServicoSocial;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioGeralInternosPavilhao;
    private javax.swing.JMenuItem RelatorioInternoPorIdade;
    private javax.swing.JMenu RelatorioInternosLocalidade;
    private javax.swing.JMenuItem RelatorioInternosPorBairro;
    private javax.swing.JMenuItem RelatorioInternosPorCidade;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaInternos;
    private javax.swing.JMenuItem RelatorioVisitasGrauParentesco;
    private javax.swing.JMenuItem RelatorioVisitasPorIdade;
    private javax.swing.JMenuItem RolVisitas;
    private javax.swing.JMenuItem RolVisitasReligiosas;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem VisitantesReligiosos;
    private javax.swing.JMenuItem Vistantes;
    private javax.swing.JMenuItem jCancelamentoRegistroAtendimento;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jOcorrenciasServicoSocial;
    private javax.swing.JMenuItem jPaiNOVO;
    public static javax.swing.JDesktopPane jPainelServicoSocial;
    private javax.swing.JMenuItem jRegistroAtendeInternoBio;
    private javax.swing.JMenuItem jRelatorioAtendimentoInternos;
    private javax.swing.JMenuItem jRelatorioGeralQuantidadeAtendimentoFamiliar;
    private javax.swing.JMenuItem jRelatorioQuantidadeAtendimentoFamiliar;
    private javax.swing.JMenuItem jRelatorioVisitasInternos;
    private javax.swing.JMenuItem jRolVisitas;
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
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jSolicitacaoAtestadoReclusao;
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
                TelaModuloServicoSocial.jPainelServicoSocial.add(objRecados);
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
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroVisitasSS + "'");
            conecta.rs.first();
            pNomeCV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRolVisitasSS + "'");
            conecta.rs.first();
            pNomeRV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRolVisitasVisitantesSS + "'");
            conecta.rs.first();
            pNomeRVV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRolVisitasInternosSS + "'");
            conecta.rs.first();
            pNomeRVI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaListaDocumentosSS + "'");
            conecta.rs.first();
            pNomeLD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInstituicaoRelSS + "'");
            conecta.rs.first();
            pNomeIR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaVisitantesRelSS + "'");
            conecta.rs.first();
            pNomeVR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRolVisitantesRelSS + "'");
            conecta.rs.first();
            pNomeRVR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRolVisitantesRelVisitaSS + "'");
            conecta.rs.first();
            pNomeRVRV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprovadoresOcrSS + "'");
            conecta.rs.first();
            pNomeAO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoBioSS + "'");
            conecta.rs.first();
            pNomeRAB_SS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoImpressaoBioSSocial + "'");
            conecta.rs.first();
            pNomeRAIB_SS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelAtendInternoSS + "'");
            conecta.rs.first();
            pNomeCAII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MANUTENÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoInternosServicoSocial + "'");
            conecta.rs.first();
            pNomeAEI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEvolucaoServicoSocial + "'");
            conecta.rs.first();
            pNomeAEIE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilPopCarcerariaSS + "'");
            conecta.rs.first();
            pNomePPC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPerfilPopCarcerariaPerfilSS + "'");
            conecta.rs.first();
            pNomePPCP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtualizacaoDocSS + "'");
            conecta.rs.first();
            pNomeAD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoFamiliaSS + "'");
            conecta.rs.first();
            pNomeAF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoFamilia_EVO_SS + "'");
            conecta.rs.first();
            pNomeAFE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelaVisitaSS + "'");
            conecta.rs.first();
            pNomeCVS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelaVisitaVistasExtSS + "'");
            conecta.rs.first();
            pNomeCVVE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelaVisitaVistasIntSS + "'");
            conecta.rs.first();
            pNomeCVVI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //P.A.I.
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPAISS + "'");
            conecta.rs.first();
            pNomePPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGF_SS + "'");
            conecta.rs.first();
            pNomePCCGF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFFam_SS + "'");
            conecta.rs.first();
            pNomePCCGFa = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVis_SS + "'");
            conecta.rs.first();
            pNomePCCGFVis = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVis_SS + "'");
            conecta.rs.first();
            pNomePCCGFVis = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiCCGFVisInt_SS + "'");
            conecta.rs.first();
            pNomePCCGFVisInt = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDEME_SS + "'");
            conecta.rs.first();
            pNomePDEME = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDPTL_SS + "'");
            conecta.rs.first();
            pNomePDPTL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDJ_SS + "'");
            conecta.rs.first();
            pNomePDJ = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiDS_SS + "'");
            conecta.rs.first();
            pNomePDS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEAPI1_SS + "'");
            conecta.rs.first();
            pNomePEADPI1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEAPI2_SS + "'");
            conecta.rs.first();
            pNomePEADPI2 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaiEPAI_SS + "'");
            conecta.rs.first();
            pNomePEPAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBloqueioLiberacaoVisitasSS + "'");
            conecta.rs.first();
            pNomeBLV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBloqueioLiberacaoOcorrenciaSS + "'");
            conecta.rs.first();
            pNomeBLO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleLigacoesTelSS + "'");
            conecta.rs.first();
            pNomeCLT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciasSS + "'");
            conecta.rs.first();
            pNomeOCO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaHistAvaSocial_SS + "'");
            conecta.rs.first();
            pNomeHAS_I = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaHistAvaEmprego_SS + "'");
            conecta.rs.first();
            pNomeHAE_II = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoAuxilioReclusao + "'");
            conecta.rs.first();
            pNomeSAR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBiometriaVisita + "'");
            conecta.rs.first();
            pNomeSARV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBiometriaInterno + "'");
            conecta.rs.first();
            pNomeSARI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PRORES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaManuSS + "'");
            conecta.rs.first();
            pNomeIAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaESS + "'");
            conecta.rs.first();
            pNomeIAE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaPSS + "'");
            conecta.rs.first();
            pNomeIAP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaCSS + "'");
            conecta.rs.first();
            pNomeIAC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaTSS + "'");
            conecta.rs.first();
            pNomeIAT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaPSISS + "'");
            conecta.rs.first();
            pNomeIAPS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaSSS + "'");
            conecta.rs.first();
            pNomeIAS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // INICIO DA COMPARAÇÃO
        if (!pNomeCV.equals(telaCadastroVisitasSS) || pNomeCV == null || pNomeCV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroVisitasSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRV.equals(telaRolVisitasSS) || pNomeRV == null || pNomeRV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRolVisitasSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRVV.equals(telaRolVisitasVisitantesSS) || pNomeRVV == null || pNomeRVV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRolVisitasVisitantesSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRVI.equals(telaRolVisitasInternosSS) || pNomeRVI == null || pNomeRVI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRolVisitasInternosSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLD.equals(telaListaDocumentosSS) || pNomeLD == null || pNomeLD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaListaDocumentosSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIR.equals(telaInstituicaoRelSS) || pNomeIR == null || pNomeIR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInstituicaoRelSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeVR.equals(telaVisitantesRelSS) || pNomeVR == null || pNomeVR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaVisitantesRelSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRVR.equals(telaRolVisitantesRelSS) || pNomeRVR == null || pNomeRVR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRolVisitantesRelSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRVRV.equals(telaRolVisitantesRelVisitaSS) || pNomeRVRV == null || pNomeRVRV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRolVisitantesRelVisitaSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAO.equals(telaAprovadoresOcrSS) || pNomeAO == null || pNomeAO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprovadoresOcrSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAB_SS.equals(telaRegistroAtendimentoBioSS) || pNomeRAB_SS == null || pNomeRAB_SS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoBioSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAIB_SS.equals(telaRegistroAtendimentoImpressaoBioSSocial) || pNomeRAIB_SS == null || pNomeRAIB_SS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoImpressaoBioSSocial);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAII.equals(telaCancelAtendInternoSS) || pNomeCAII == null || pNomeCAII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelAtendInternoSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeAEI.equals(telaAdmissaoInternosServicoSocial) || pNomeAEI == null || pNomeAEI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoInternosServicoSocial);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAEIE.equals(telaEvolucaoServicoSocial) || pNomeAEIE == null || pNomeAEIE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEvolucaoServicoSocial);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePPC.equals(telaPerfilPopCarcerariaSS) || pNomePPC == null || pNomePPC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilPopCarcerariaSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePPCP.equals(telaPerfilPopCarcerariaPerfilSS) || pNomePPCP == null || pNomePPCP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPerfilPopCarcerariaPerfilSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAD.equals(telaAtualizacaoDocSS) || pNomeAD == null || pNomeAD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtualizacaoDocSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAF.equals(telaAtendimentoFamiliaSS) || pNomeAF == null || pNomeAF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoFamiliaSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAFE.equals(telaAtendimentoFamilia_EVO_SS) || pNomeAFE == null || pNomeAFE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoFamilia_EVO_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCVS.equals(telaCancelaVisitaSS) || pNomeCVS == null || pNomeCVS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelaVisitaSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCVVE.equals(telaCancelaVisitaVistasExtSS) || pNomeCVVE == null || pNomeCVVE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelaVisitaVistasExtSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCVVI.equals(telaCancelaVisitaVistasIntSS) || pNomeCVVI == null || pNomeCVVI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelaVisitaVistasIntSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //P.A.I.
        if (!pNomePPM.equals(telaPAISS) || pNomePPM == null || pNomePPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPAISS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGF.equals(telaPaiCCGF_SS) || pNomePCCGF == null || pNomePCCGF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGF_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFa.equals(telaPaiCCGFFam_SS) || pNomePCCGFa == null || pNomePCCGFa.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFFam_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFVis.equals(telaPaiCCGFVis_SS) || pNomePCCGFVis == null || pNomePCCGFVis.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFVis_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePCCGFVisInt.equals(telaPaiCCGFVisInt_SS) || pNomePCCGFVisInt == null || pNomePCCGFVisInt.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiCCGFVisInt_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDEME.equals(telaPaiDEME_SS) || pNomePDEME == null || pNomePDEME.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDEME_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDPTL.equals(telaPaiDPTL_SS) || pNomePDPTL == null || pNomePDPTL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDPTL_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDJ.equals(telaPaiDJ_SS) || pNomePDJ == null || pNomePDJ.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDJ_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePDS.equals(telaPaiDS_SS) || pNomePDS == null || pNomePDS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiDS_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEADPI1.equals(telaPaiEAPI1_SS) || pNomePEADPI1 == null || pNomePEADPI1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEAPI1_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEADPI2.equals(telaPaiEAPI2_SS) || pNomePEADPI2 == null || pNomePEADPI2.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEAPI2_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePEPAI.equals(telaPaiEPAI_SS) || pNomePEPAI == null || pNomePEPAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaiEPAI_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBLV.equals(telaBloqueioLiberacaoVisitasSS) || pNomeBLV == null || pNomeBLV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBloqueioLiberacaoVisitasSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBLO.equals(telaBloqueioLiberacaoOcorrenciaSS) || pNomeBLO == null || pNomeBLO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBloqueioLiberacaoOcorrenciaSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCLT.equals(telaControleLigacoesTelSS) || pNomeCLT == null || pNomeCLT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleLigacoesTelSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCO.equals(telaOcorrenciasSS) || pNomeOCO == null || pNomeOCO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciasSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeHAS_I.equals(telaHistAvaSocial_SS) || pNomeHAS_I == null || pNomeHAS_I.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaHistAvaSocial_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeHAE_II.equals(telaHistAvaEmprego_SS) || pNomeHAE_II == null || pNomeHAE_II.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaHistAvaEmprego_SS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSAR.equals(telaSolicitacaoAuxilioReclusao) || pNomeSAR == null || pNomeSAR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoAuxilioReclusao);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSARV.equals(telaBiometriaVisita) || pNomeSARV == null || pNomeSARV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBiometriaVisita);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSARI.equals(telaBiometriaInterno) || pNomeSARI == null || pNomeSARI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBiometriaInterno);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PRORES
        if (!pNomeIAM.equals(telaIndAcompanhaManuSS) || pNomeIAM == null || pNomeIAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaManuSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAE.equals(telaIndAcompanhaAbaESS) || pNomeIAE == null || pNomeIAE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaESS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAP.equals(telaIndAcompanhaAbaPSS) || pNomeIAP == null || pNomeIAP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaPSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAC.equals(telaIndAcompanhaAbaCSS) || pNomeIAC == null || pNomeIAC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaCSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAT.equals(telaIndAcompanhaAbaTSS) || pNomeIAT == null || pNomeIAT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaTSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAPS.equals(telaIndAcompanhaAbaPSISS) || pNomeIAPS == null || pNomeIAPS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaPSISS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAS.equals(telaIndAcompanhaAbaSSS) || pNomeIAS == null || pNomeIAS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaSSS);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        conecta.desconecta();
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloSS + "'");
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
            codigoUserSS = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserSS + "'");
            conecta.rs.first();
            codigoUserGroupSS = conecta.rs.getInt("IdUsuario");
            codigoGrupoSS = conecta.rs.getInt("IdGrupo");
            nomeGrupoSS = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserSS + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoSS = conecta.rs.getInt("IdUsuario");
            codAbrirSS = conecta.rs.getInt("Abrir");
            codIncluirSS = conecta.rs.getInt("Incluir");
            codAlterarSS = conecta.rs.getInt("Alterar");
            codExcluirSS = conecta.rs.getInt("Excluir");
            codGravarSS = conecta.rs.getInt("Gravar");
            codConsultarSS = conecta.rs.getInt("Consultar");
            nomeTelaSS = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
