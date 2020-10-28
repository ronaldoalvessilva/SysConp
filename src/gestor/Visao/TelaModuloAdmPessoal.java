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
public class TelaModuloAdmPessoal extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    private TelaDepartamento objDp = null;
    private TelaCargo objCargos = null;
    private TelaCidadesAdmPessoal objCidades = null;
    private TelaPaisesAdmPessoal objPais = null;
    private TelaFuncionarios objFunc = null;
    private TelaConsultaPopulacaoAdm objPopAdm = null;
    private TelaRecadosCrcAdmPessoal objAgendaRecAP = null;
    private TelaAprovadorSolicitacaoCompras objAproSoli = null;
    private TelaSolicitacaoComprasMateriaisGerencia objSolCompGer = null;
    private TelaSolicitantesCompras objSoliComp = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaAprovarSolicitacaoCompras objAprovaSol = null;
    private TelaAtividadesMensalUnidade objAtividadeMU = null;
    private ConsultaGerencialColaboradoresUnidade objConsCola = null;
    private TelaEntradaSaidasColaboradores objEntradaSaidaFunc = null;
    //
    String usuarioLogado, dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
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
    String statusFunc = "Ativo"; // STATUS DO COLABORADOR PARA RELATÓRIO
    //
    // TELAS DE ACESSOS AO MÓDULO FINANCEIRO
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    public static String nomeModuloADM = "ADMPESSOAL";
    // MENU CADASTRO    
    public static String telaCadastroDepartamento_ADM = "Cadastro:Departamento:Manutenção";
    public static String telaCargos_ADM = "Cadastro:Cargos:Manutenção";
    public static String telaCidades_ADM = "Cadastro:Cidades:Manutenção";
    public static String telaPaises_ADM = "Cadastro:Paises:Manutenção";
    public static String telaColaboradoresFC_ADM = "Cadastro:Cadastro de Colaboradores:Ficha Cadastral:Manutenção";
    public static String telaColaboradoresFCEnd_ADM = "Cadastro:Cadastro de Colaboradores:Ficha Cadastral:Endereço";
    public static String telaColaboradoresFCDoc_ADM = "Cadastro:Cadastro de Colaboradores:Ficha Cadastral:Documentos";
    public static String telaColaboradoresFCDep_ADM = "Cadastro:Cadastro de Colaboradores:Ficha Cadastral:Dependentes";
    //CONSULTA
    public static String telaPesquisaGlobalColaboradores_ADM = "Consulta:Pesquisa Global de Colaboradores";
    // MOVIMENTAÇÃO
    public static String telaAprovadoresSC_ADM = "Movimentação:Aprovadores de Solicitações de Compras:Manutenção";
    //
    public static String telaSolicitantesC_ADM = "Movimentação:Solicitantes de Compras:Manutenção";
    public static String telaSolicitantesSOL_ADM = "Movimentação:Solicitantes de Compras:Solicitantes";
    //
    public static String telaSolicitacaoC_ADM = "Movimentação:Solicitação de Compras:Manutenção";
    public static String telaSolicitacaoCP_ADM = "Movimentação:Solicitação de Compras:Produtos";
    //
    public static String telaAprovadorSC_ADM = "Movimentação:Aprovar Solicitações de Compras:Solicitações de Compras";
    public static String telaAprovarItensSC_ADM = "Movimentação:Aprovar Itens Solicitação de Compras:Itens";
    //ATIVIDADES MENSAL REALIZADA PELA UNIDADE
    public static String telaAtividadeMensalManu_ADM = "Cadastro:Atividades Mensal da Unidade:Manutenção";
    public static String telaAtividadeMensalSS_ADM = "Cadastro:Atividades Mensal da Unidade:Serviço Social";
    public static String telaAtividadeMensalAL_ADM = "Cadastro:Atividades Mensal da Unidade:Alimentação Fornecida";
    public static String telaAtividadeMensalAI_ADM = "Cadastro:Atividades Mensal da Unidade:Atendimento ao Interno";
    public static String telaAtividadeMensalADI_ADM = "Cadastro:Atividades Mensal da Unidade:Atendimento Educação ao Interno";
    public static String telaAtividadeMensalASMI_ADM = "Cadastro:Atividades Mensal da Unidade:Assistência Material do Interno";
    public static String telaAtividadeMensalSI_ADM = "Cadastro:Atividades Mensal da Unidade:Segurança ao Interno";
    public static String telaAtividadeMensalAJ_ADM = "Cadastro:Atividades Mensal da Unidade:Assistência Jurídica";
    public static String telaAtividadeMensalALI_ADM = "Cadastro:Atividades Mensal da Unidade:Assistência Laborativa";
    //
    public static String telaEntradasSaidasColaboradoresManu_ADM = "Movimentação:Entradas e Saídas Colaboradores na Unidade:Manutenção";
    public static String telaEntradasSaidasColaboradoresCola_ADM = "Movimentação:Entradas e Saídas Colaboradores na Unidade:Colaboradores";
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCD = "";
    String pNomeC = "";
    String pNomeLC = "";
    String pNomeLP = "";
    // COLABORADORES
    String pNomeCO = "";
    String pNomeCOE = "";
    String pNomeCOD = "";
    String pNomeCODE = "";
    // MOVIMENTAÇÃO
    String pNomeAP = "";
    //
    String pNomeSO = "";
    String pNomeSOS = "";
    //
    String pNomeSI = "";
    String pNomeSIP = "";
    //
    String pNomeAPR = "";
    String pNomeAPROI = "";
    //ATIVIDADE MENSAL DA UNIDADE
    String pNomeAMUM = "";
    String pNomeASS = "";
    String pNomeAL = "";
    String pNomeAI = "";
    String pNomeADI = "";
    String pNomeASMI = "";
    String pNomeSEI = "";
    String pNomeAJ = "";
    String pNomeALI = "";
    //
    String pNomePGC = "";
    //
    String pNomeESCM = "";
    String pNomeESCC = "";

//    pNomeESCM
//            pNomeESCc
//    telaEntradasSaidasColaboradoresManu_ADM
//    telaEntradasSaidasColaboradoresCola_ADM
    public static int codigoUserADM = 0;
    public static int codUserAcessoADM = 0;
    public static int codigoUserGroupADM = 0;
    public static int codAbrirADM = 0;
    public static int codIncluirADM = 0;
    public static int codAlterarADM = 0;
    public static int codExcluirADM = 0;
    public static int codGravarADM = 0;
    public static int codConsultarADM = 0;
    public static int codigoGrupoADM = 0;
    public static String nomeGrupoADM = "";
    public static String nomeTelaADM = "";
    //

    /**
     * Creates new form TelaTriagem
     */
    public TelaModuloAdmPessoal() {
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

        jPainelAdmPessoal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        jDepartamentos = new javax.swing.JMenuItem();
        jCargos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jDiversos = new javax.swing.JMenu();
        jPais = new javax.swing.JMenuItem();
        jCidades = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Colaborador = new javax.swing.JMenu();
        FichaCadastral = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jAtividadesMensalUnidade = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        jAgendaRecados = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jSair = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        jPopulacaoCarcerariaAgentes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jConsultaGlobalColaboradores = new javax.swing.JMenuItem();
        ControleAprovacaoCompras = new javax.swing.JMenu();
        AprovadoresSolicitacaoCompras = new javax.swing.JMenuItem();
        SolicitantesCompras = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        SolicitacaoComprasAdm = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        AprovarSolicitacoesCompras = new javax.swing.JMenuItem();
        AprovarPedidosCompras = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        jEntradasSaidaColaboradores = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        RelatorioDepartamento = new javax.swing.JMenuItem();
        RelatorioCargos = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        RelatorioPaises = new javax.swing.JMenuItem();
        RelatorioCidades = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jRelatorioFichaCadastral = new javax.swing.JMenuItem();
        ListagemColaboradoresAtivoInativo = new javax.swing.JMenuItem();
        ListagemColaboradores = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        FrequenciaColaboradoresPorDepartamento = new javax.swing.JMenuItem();
        RelatorioIndividualColaboradorFrequencia = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jRelatorioTotaisProdutividade = new javax.swing.JMenuItem();
        jRelatorioTotaisProdutividadePorTecnico = new javax.swing.JMenuItem();
        jMenuPRORES = new javax.swing.JMenu();
        jMenuItemPRORES = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jRelatorioAtividadesMensalUnidade = new javax.swing.JMenuItem();
        jRelatorioPopulacaoAlimenticia = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Gerência Administrativa {GA} :::...");
        setPreferredSize(new java.awt.Dimension(840, 653));

        jPainelAdmPessoal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelAdmPessoal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelAdmPessoalLayout = new javax.swing.GroupLayout(jPainelAdmPessoal);
        jPainelAdmPessoal.setLayout(jPainelAdmPessoalLayout);
        jPainelAdmPessoalLayout.setHorizontalGroup(
            jPainelAdmPessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelAdmPessoalLayout.setVerticalGroup(
            jPainelAdmPessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        Cadastros.setText("Cadastro");

        jDepartamentos.setText("Departamento");
        jDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDepartamentosActionPerformed(evt);
            }
        });
        Cadastros.add(jDepartamentos);

        jCargos.setText("Cargos");
        jCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCargosActionPerformed(evt);
            }
        });
        Cadastros.add(jCargos);
        Cadastros.add(jSeparator8);

        jDiversos.setText("Localidades");

        jPais.setText("Paises");
        jPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaisActionPerformed(evt);
            }
        });
        jDiversos.add(jPais);

        jCidades.setText("Cidades");
        jCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCidadesActionPerformed(evt);
            }
        });
        jDiversos.add(jCidades);

        Cadastros.add(jDiversos);
        Cadastros.add(jSeparator4);

        Colaborador.setText("Colaboradores");

        FichaCadastral.setText("Ficha Cadastral");
        FichaCadastral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FichaCadastralActionPerformed(evt);
            }
        });
        Colaborador.add(FichaCadastral);

        Cadastros.add(Colaborador);
        Cadastros.add(jSeparator1);

        jAtividadesMensalUnidade.setText("AMRI - Atividades Mensal Realizada na Unidade");
        jAtividadesMensalUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtividadesMensalUnidadeActionPerformed(evt);
            }
        });
        Cadastros.add(jAtividadesMensalUnidade);
        Cadastros.add(jSeparator14);

        AgendaCompromissos.setText("Agenda de Compromissos Pessal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaCompromissos);

        jAgendaRecados.setText("Agenda de Recados");
        jAgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(jAgendaRecados);
        Cadastros.add(jSeparator10);

        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });
        Cadastros.add(jSair);

        jMenuBar1.add(Cadastros);

        Consultas.setText("Consultas");

        jPopulacaoCarcerariaAgentes.setText("População de Internos e Agentes");
        jPopulacaoCarcerariaAgentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPopulacaoCarcerariaAgentesActionPerformed(evt);
            }
        });
        Consultas.add(jPopulacaoCarcerariaAgentes);
        Consultas.add(jSeparator2);

        jConsultaGlobalColaboradores.setForeground(new java.awt.Color(204, 0, 0));
        jConsultaGlobalColaboradores.setText("Pesquisa Global de Colaboradores");
        jConsultaGlobalColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaGlobalColaboradoresActionPerformed(evt);
            }
        });
        Consultas.add(jConsultaGlobalColaboradores);

        jMenuBar1.add(Consultas);

        ControleAprovacaoCompras.setText("Controle de Compras");

        AprovadoresSolicitacaoCompras.setText("Aprovadores de Solicitações de Compras");
        AprovadoresSolicitacaoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprovadoresSolicitacaoComprasActionPerformed(evt);
            }
        });
        ControleAprovacaoCompras.add(AprovadoresSolicitacaoCompras);

        SolicitantesCompras.setText("Solicitantes de Compras");
        SolicitantesCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitantesComprasActionPerformed(evt);
            }
        });
        ControleAprovacaoCompras.add(SolicitantesCompras);
        ControleAprovacaoCompras.add(jSeparator9);

        SolicitacaoComprasAdm.setText("Solicitação de Compras");
        SolicitacaoComprasAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitacaoComprasAdmActionPerformed(evt);
            }
        });
        ControleAprovacaoCompras.add(SolicitacaoComprasAdm);
        ControleAprovacaoCompras.add(jSeparator3);

        AprovarSolicitacoesCompras.setForeground(new java.awt.Color(255, 0, 0));
        AprovarSolicitacoesCompras.setText("Aprovar Solicitações Compras");
        AprovarSolicitacoesCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprovarSolicitacoesComprasActionPerformed(evt);
            }
        });
        ControleAprovacaoCompras.add(AprovarSolicitacoesCompras);

        AprovarPedidosCompras.setForeground(new java.awt.Color(0, 0, 255));
        AprovarPedidosCompras.setText("Aprovar Pedidos de Compras");
        AprovarPedidosCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprovarPedidosComprasActionPerformed(evt);
            }
        });
        ControleAprovacaoCompras.add(AprovarPedidosCompras);

        jMenuBar1.add(ControleAprovacaoCompras);

        Movimentacao.setText("Movimentação");

        jEntradasSaidaColaboradores.setText("Entradas e Saídas de Colaboradores");
        jEntradasSaidaColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntradasSaidaColaboradoresActionPerformed(evt);
            }
        });
        Movimentacao.add(jEntradasSaidaColaboradores);

        jMenuBar1.add(Movimentacao);

        Relatorios.setText("Relatórios");

        RelatorioDepartamento.setText("Relatório de Departamentos");
        RelatorioDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDepartamentoActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioDepartamento);

        RelatorioCargos.setText("Relatório de Cargos");
        RelatorioCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCargosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCargos);
        Relatorios.add(jSeparator5);

        RelatorioPaises.setText("Relatório de Países");
        RelatorioPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPaisesActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioPaises);

        RelatorioCidades.setText("Relatório de Cidades");
        RelatorioCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCidadesActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCidades);
        Relatorios.add(jSeparator6);

        jMenu4.setText("Relatório de Colaboradores");

        jRelatorioFichaCadastral.setText("Ficha Cadastral");
        jRelatorioFichaCadastral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioFichaCadastralActionPerformed(evt);
            }
        });
        jMenu4.add(jRelatorioFichaCadastral);

        ListagemColaboradoresAtivoInativo.setText("Listagem de Colaboradores Ativo/Inativo");
        ListagemColaboradoresAtivoInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemColaboradoresAtivoInativoActionPerformed(evt);
            }
        });
        jMenu4.add(ListagemColaboradoresAtivoInativo);

        ListagemColaboradores.setText("Relatório de Colaboradores por Departamento");
        ListagemColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemColaboradoresActionPerformed(evt);
            }
        });
        jMenu4.add(ListagemColaboradores);

        jMenuItem11.setText("Frequência de Colaboradores  - (Portaria)");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        FrequenciaColaboradoresPorDepartamento.setText("Frequência de Colaboradores por Departameto - (Portaria)");
        FrequenciaColaboradoresPorDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrequenciaColaboradoresPorDepartamentoActionPerformed(evt);
            }
        });
        jMenu4.add(FrequenciaColaboradoresPorDepartamento);

        RelatorioIndividualColaboradorFrequencia.setForeground(new java.awt.Color(0, 0, 204));
        RelatorioIndividualColaboradorFrequencia.setText("Relatório Individual de Colaboradores (Frequência)");
        RelatorioIndividualColaboradorFrequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioIndividualColaboradorFrequenciaActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioIndividualColaboradorFrequencia);

        Relatorios.add(jMenu4);
        Relatorios.add(jSeparator7);

        jMenuItem13.setText("Relatório de Registro Entrada e Saída de Visitas Portaria/Departamento");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem13);
        Relatorios.add(jSeparator11);

        jMenuItem3.setText("Relatório de População de Internos Nominal - CRC");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem3);

        jMenuItem10.setText("Mapa de Confere de Internos - Segurança");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem10);

        jMenuItem12.setText("Relatório de Frequência de Internos - (Portaria)");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem12);
        Relatorios.add(jSeparator12);

        jMenuItem7.setForeground(new java.awt.Color(204, 0, 0));
        jMenuItem7.setText("Relatório de Entrada/Saída Veiculos da Unidade Prisional");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem7);
        Relatorios.add(jSeparator13);

        jRelatorioTotaisProdutividade.setText("Relatório de Totalizadores de Atendimentos");
        jRelatorioTotaisProdutividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioTotaisProdutividadeActionPerformed(evt);
            }
        });
        Relatorios.add(jRelatorioTotaisProdutividade);

        jRelatorioTotaisProdutividadePorTecnico.setText("Relatório de Totalizadores de Atendimentos Por Técnicos");
        jRelatorioTotaisProdutividadePorTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioTotaisProdutividadePorTecnicoActionPerformed(evt);
            }
        });
        Relatorios.add(jRelatorioTotaisProdutividadePorTecnico);

        jMenuPRORES.setText("Relatórios PRORES");

        jMenuItemPRORES.setText("Relatório Quantitativo Total Atendimento PSP");
        jMenuItemPRORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPRORESActionPerformed(evt);
            }
        });
        jMenuPRORES.add(jMenuItemPRORES);

        Relatorios.add(jMenuPRORES);
        Relatorios.add(jSeparator15);

        jRelatorioAtividadesMensalUnidade.setText("Relatório de Atividades Mensal Realizadas na Unidade");
        jRelatorioAtividadesMensalUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioAtividadesMensalUnidadeActionPerformed(evt);
            }
        });
        Relatorios.add(jRelatorioAtividadesMensalUnidade);

        jRelatorioPopulacaoAlimenticia.setText("Relatório de População Alimentícia");
        jRelatorioPopulacaoAlimenticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioPopulacaoAlimenticiaActionPerformed(evt);
            }
        });
        Relatorios.add(jRelatorioPopulacaoAlimenticia);

        jMenuBar1.add(Relatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelAdmPessoal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelAdmPessoal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDepartamentosActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaCadastroDepartamento_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaCadastroDepartamento_ADM) && codAbrirADM == 1) {
            if (objDp == null || objDp.isClosed()) {
                objDp = new TelaDepartamento();
                jPainelAdmPessoal.add(objDp);
                objDp.setVisible(true);
            } else {
                if (objDp.isVisible()) {
                    if (objDp.isIcon()) { // Se esta minimizado
                        try {
                            objDp.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objDp.toFront(); // traz para frente
                        objDp.pack();//volta frame 
                    }
                } else {
                    objDp = new TelaDepartamento();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objDp);//adicona frame ao JDesktopPane  
                    objDp.setVisible(true);
                }
            }
            try {
                objDp.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jDepartamentosActionPerformed

    private void jCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCargosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCargos_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaCargos_ADM) && codAbrirADM == 1) {
            if (objCargos == null || objCargos.isClosed()) {
                objCargos = new TelaCargo();
                jPainelAdmPessoal.add(objCargos);
                objCargos.setVisible(true);
            } else {
                if (objCargos.isVisible()) {
                    if (objCargos.isIcon()) { // Se esta minimizado
                        try {
                            objCargos.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCargos.toFront(); // traz para frente
                        objCargos.pack();//volta frame 
                    }
                } else {
                    objCargos = new TelaCargo();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objCargos);//adicona frame ao JDesktopPane  
                    objCargos.setVisible(true);
                }
            }
            try {
                objCargos.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCargosActionPerformed

    private void jCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCidadesActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaCidades_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaCidades_ADM) && codAbrirADM == 1) {
            if (objCidades == null || objCidades.isClosed()) {
                objCidades = new TelaCidadesAdmPessoal();
                jPainelAdmPessoal.add(objCidades);
                objCidades.setVisible(true);
            } else {
                if (objCidades.isVisible()) {
                    if (objCidades.isIcon()) { // Se esta minimizado
                        try {
                            objCidades.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCidades.toFront(); // traz para frente
                        objCidades.pack();//volta frame 
                    }
                } else {
                    objCidades = new TelaCidadesAdmPessoal();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objCidades);//adicona frame ao JDesktopPane  
                    objCidades.setVisible(true);
                }
            }
            try {
                objCidades.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCidadesActionPerformed

    private void jPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaisActionPerformed
        // TODO add your handling code here:     
        buscarAcessoUsuario(telaPaises_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaPaises_ADM) && codAbrirADM == 1) {
            if (objPais == null || objPais.isClosed()) {
                objPais = new TelaPaisesAdmPessoal();
                jPainelAdmPessoal.add(objPais);
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
                    objPais = new TelaPaisesAdmPessoal();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPais);//adicona frame ao JDesktopPane  
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
    }//GEN-LAST:event_jPaisActionPerformed

    private void RelatorioDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDepartamentoActionPerformed
        // TODO add your handling code here:
        //Relatório de Departamentos (LISTAGEM)
        conecta.abrirConexao();
        String path = "reports/GerenciaAdministrativa/ListagemDepartamento.jasper";// indica o caminmhodo relatório
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS");
            HashMap map = new HashMap();
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, map, relatResul);
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Departamentos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            // jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }

    }//GEN-LAST:event_RelatorioDepartamentoActionPerformed

    private void RelatorioCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCargosActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        String path = "reports/GerenciaAdministrativa/relatorioCargos.jasper";
        try {
            conecta.executaSQL("SELECT * FROM CARGOS");
            HashMap map = new HashMap();
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, map, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Cargos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioCargosActionPerformed

    private void RelatorioPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPaisesActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        String path = "reports/GerenciaAdministrativa/relatorioPaises.jasper";
        try {
            conecta.executaSQL("SELECT * FROM PAISES");
            HashMap map = new HashMap();
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
            JasperPrint jpPrint = JasperFillManager.fillReport(path, map, relatResul);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Países");
            jv.setVisible(true);
            jv.toFront();
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioPaisesActionPerformed

    private void RelatorioCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCidadesActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/GerenciaAdministrativa/relatorioCidades.jasper";
            conecta.executaSQL("SELECT * FROM CIDADES ORDER BY NomeCidade");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Cidades");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioCidadesActionPerformed

    private void FichaCadastralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FichaCadastralActionPerformed
        // TODO add your handling code here:
        // APAGAR A TELA DE COLABORADOR - TelaColaborador();
        buscarAcessoUsuario(telaColaboradoresFC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaColaboradoresFC_ADM) && codAbrirADM == 1) {
            if (objFunc == null || objFunc.isClosed()) {
                objFunc = new TelaFuncionarios();
                jPainelAdmPessoal.add(objFunc);
                objFunc.setVisible(true);
            } else {
                if (objFunc.isVisible()) {
                    if (objFunc.isIcon()) { // Se esta minimizado
                        try {
                            objFunc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objFunc.toFront(); // traz para frente
                        objFunc.pack();//volta frame 
                    }
                } else {
                    objFunc = new TelaFuncionarios();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objFunc);//adicona frame ao JDesktopPane  
                    objFunc.setVisible(true);
                }
            }
            try {
                objFunc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_FichaCadastralActionPerformed

    private void jPopulacaoCarcerariaAgentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPopulacaoCarcerariaAgentesActionPerformed
        // TODO add your handling code here:
        if (objPopAdm == null || objPopAdm.isClosed()) {
            objPopAdm = new TelaConsultaPopulacaoAdm();
            jPainelAdmPessoal.add(objPopAdm);
            objPopAdm.setVisible(true);
        } else {
            if (objPopAdm.isVisible()) {
                if (objPopAdm.isIcon()) { // Se esta minimizado
                    try {
                        objPopAdm.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objPopAdm.toFront(); // traz para frente
                    objPopAdm.pack();//volta frame 
                }
            } else {
                objPopAdm = new TelaConsultaPopulacaoAdm();
                TelaModuloAdmPessoal.jPainelAdmPessoal.add(objPopAdm);//adicona frame ao JDesktopPane  
                objPopAdm.setVisible(true);
            }
        }
        try {
            objPopAdm.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jPopulacaoCarcerariaAgentesActionPerformed

    private void jAgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objAgendaRecAP == null || objAgendaRecAP.isClosed()) {
            objAgendaRecAP = new TelaRecadosCrcAdmPessoal();
            jPainelAdmPessoal.add(objAgendaRecAP);
            objAgendaRecAP.setVisible(true);
        } else {
            if (objAgendaRecAP.isVisible()) {
                if (objAgendaRecAP.isIcon()) { // Se esta minimizado
                    try {
                        objAgendaRecAP.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgendaRecAP.toFront(); // traz para frente
                    objAgendaRecAP.pack();//volta frame 
                }
            } else {
                objAgendaRecAP = new TelaRecadosCrcAdmPessoal();
                TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAgendaRecAP);//adicona frame ao JDesktopPane  
                objAgendaRecAP.setVisible(true);
            }
        }
        try {
            objAgendaRecAP.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jAgendaRecadosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TelaRelPopulacaoInternosNominal objRelPopNon = new TelaRelPopulacaoInternosNominal();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelPopNon);
        objRelPopNon.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereAdmPessoal mapConf = new TelaRelMapaConfereAdmPessoal();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(mapConf);
        mapConf.show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradoresPortaria objRelFuncPort = new TelaRelatorioEntradaSaidaColaboradoresPortaria();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelFuncPort);
        objRelFuncPort.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        TelaRelAtividadeLaborExternaAdm relFreqInternosLabExt = new TelaRelAtividadeLaborExternaAdm();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(relFreqInternosLabExt);
        relFreqInternosLabExt.show();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void AprovadoresSolicitacaoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprovadoresSolicitacaoComprasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadoresSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovadoresSC_ADM) && codAbrirADM == 1) {
            if (objAproSoli == null || objAproSoli.isClosed()) {
                objAproSoli = new TelaAprovadorSolicitacaoCompras();
                jPainelAdmPessoal.add(objAproSoli);
                objAproSoli.setVisible(true);
            } else {
                if (objAproSoli.isVisible()) {
                    if (objAproSoli.isIcon()) { // Se esta minimizado
                        try {
                            objAproSoli.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAproSoli.toFront(); // traz para frente
                        objAproSoli.pack();//volta frame 
                    }
                } else {
                    objAproSoli = new TelaAprovadorSolicitacaoCompras();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAproSoli);//adicona frame ao JDesktopPane  
                    objAproSoli.setVisible(true);
                }
            }
            try {
                objAproSoli.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AprovadoresSolicitacaoComprasActionPerformed

    private void SolicitacaoComprasAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitacaoComprasAdmActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSolicitacaoC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaSolicitacaoC_ADM) && codAbrirADM == 1) {
            if (objSolCompGer == null || objSolCompGer.isClosed()) {
                objSolCompGer = new TelaSolicitacaoComprasMateriaisGerencia();
                jPainelAdmPessoal.add(objSolCompGer);
                objSolCompGer.setVisible(true);
            } else {
                if (objSolCompGer.isVisible()) {
                    if (objSolCompGer.isIcon()) { // Se esta minimizado
                        try {
                            objSolCompGer.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSolCompGer.toFront(); // traz para frente
                        objSolCompGer.pack();//volta frame 
                    }
                } else {
                    objSolCompGer = new TelaSolicitacaoComprasMateriaisGerencia();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objSolCompGer);//adicona frame ao JDesktopPane  
                    objSolCompGer.setVisible(true);
                }
            }
            try {
                objSolCompGer.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SolicitacaoComprasAdmActionPerformed

    private void SolicitantesComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitantesComprasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSolicitantesC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaSolicitantesC_ADM) && codAbrirADM == 1) {
            if (objSoliComp == null || objSoliComp.isClosed()) {
                objSoliComp = new TelaSolicitantesCompras();
                jPainelAdmPessoal.add(objSoliComp);
                objSoliComp.setVisible(true);
            } else {
                if (objSoliComp.isVisible()) {
                    if (objSoliComp.isIcon()) { // Se esta minimizado
                        try {
                            objSoliComp.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSoliComp.toFront(); // traz para frente
                        objSoliComp.pack();//volta frame 
                    }
                } else {
                    objSoliComp = new TelaSolicitantesCompras();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objSoliComp);//adicona frame ao JDesktopPane  
                    objSoliComp.setVisible(true);
                }
            }
            try {
                objSoliComp.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SolicitantesComprasActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelAdmPessoal.add(objAgEventos);
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
                TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void AprovarSolicitacoesComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprovarSolicitacoesComprasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAprovadorSC_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAprovadorSC_ADM) && codAbrirADM == 1) {
            if (objAprovaSol == null || objAprovaSol.isClosed()) {
                objAprovaSol = new TelaAprovarSolicitacaoCompras();
                jPainelAdmPessoal.add(objAprovaSol);
                objAprovaSol.setVisible(true);
            } else {
                if (objAprovaSol.isVisible()) {
                    if (objAprovaSol.isIcon()) { // Se esta minimizado
                        try {
                            objAprovaSol.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAprovaSol.toFront(); // traz para frente
                        objAprovaSol.pack();//volta frame 
                    }
                } else {
                    objAprovaSol = new TelaAprovarSolicitacaoCompras();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAprovaSol);//adicona frame ao JDesktopPane  
                    objAprovaSol.setVisible(true);
                }
            }
            try {
                objAprovaSol.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AprovarSolicitacoesComprasActionPerformed

    private void AprovarPedidosComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprovarPedidosComprasActionPerformed
        // TODO add your handling code here:
//        buscarAcessoUsuario(telaSolicitantesC_ADM);
//        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaSolicitantesC_ADM) && codAbrirADM == 1) {
        JOptionPane.showMessageDialog(null, "Em Construção...");
//        } else {
//            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
//        }
    }//GEN-LAST:event_AprovarPedidosComprasActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortaria objRelEntSai = new TelaRelatorioEntradaSaidaVisitasPortaria();
        // TelaModuloPortarias.jPainelPortarias.add(objRelEntSai);
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelEntSai);
        objRelEntSai.show();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void ListagemColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemColaboradoresActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/GerenciaAdministrativa/RelatorioGeralColaboradores.jasper";
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
    }//GEN-LAST:event_ListagemColaboradoresActionPerformed

    private void FrequenciaColaboradoresPorDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrequenciaColaboradoresPorDepartamentoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradorPorDepartamento objRelFuncDepto = new TelaRelatorioEntradaSaidaColaboradorPorDepartamento();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelFuncDepto);
        objRelFuncDepto.show();
    }//GEN-LAST:event_FrequenciaColaboradoresPorDepartamentoActionPerformed

    private void ListagemColaboradoresAtivoInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemColaboradoresAtivoInativoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioStatusColaborador objRelaColaAtivoIna = new TelaRelatorioStatusColaborador();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelaColaAtivoIna);
        objRelaColaAtivoIna.show();
    }//GEN-LAST:event_ListagemColaboradoresAtivoInativoActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVeiculosUnidadePenal objRelVeicUni = new TelaRelatorioEntradaSaidaVeiculosUnidadePenal();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelVeicUni);
        objRelVeicUni.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void RelatorioIndividualColaboradorFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioIndividualColaboradorFrequenciaActionPerformed
        // TODO add your handling code here:TelaRelatorioEntradaSaidaColaboradoresPortariaIndividual
        TelaRelatorioEntradaSaidaColaboradoresPortariaIndividual objRelFuncPortInd = new TelaRelatorioEntradaSaidaColaboradoresPortariaIndividual();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelFuncPortInd);
        objRelFuncPortInd.show();
    }//GEN-LAST:event_RelatorioIndividualColaboradorFrequenciaActionPerformed

    private void jRelatorioTotaisProdutividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioTotaisProdutividadeActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        conecta.abrirConexao();
        String path = "reports/GerenciaAdministrativa/TotaisProres/RelatorioTotaisProres.jasper";
        try {
            conecta.executaSQL("SELECT TOP 1 * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=REGISTRO_ATENDIMENTO_INTERNO_PSP.IdInternoCrc "
                    + "WHERE  Atendido LIKE 'Sim' ");
            HashMap parametros = new HashMap();
            parametros.put("pUsuario", nameUser);
            parametros.put("pUnidade", descricaoUnidade);
            // Sub Relatório
            try {
                parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
            } catch (SQLException ex) {
            }
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Indicadores Totais");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jRelatorioTotaisProdutividadeActionPerformed

    private void jRelatorioTotaisProdutividadePorTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioTotaisProdutividadePorTecnicoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioProducaoTotalTecnicos objRelProdM = new TelaRelatorioProducaoTotalTecnicos();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelProdM);
        objRelProdM.show();
    }//GEN-LAST:event_jRelatorioTotaisProdutividadePorTecnicoActionPerformed

    private void jMenuItemPRORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPRORESActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        String path = "reports/GerenciaAdministrativa/RelatorioQuantitativoTotalAtendimentoPSP.jasper";
        try {
            conecta.executaSQL("SELECT DISTINCT NomeDepartamento,\n"
                    + "                Sum(Qtd) AS Qtd\n"
                    + "FROM   REGISTRO_ATENDIMENTO_INTERNO_PSP\n"
                    + "       INNER JOIN DEPARTAMENTOS\n"
                    + "               ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdDepartamento = DEPARTAMENTOS.IdDepartamento\n"
                    + "GROUP  BY NomeDepartamento,\n"
                    + "          Qtd\n"
                    + "HAVING Sum(Qtd) >= 1  ");
            HashMap parametros = new HashMap();
            parametros.put("pUsuario", nameUser);
            parametros.put("pUnidade", descricaoUnidade);
            // Sub Relatório
            try {
                parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
            } catch (SQLException ex) {
            }
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Quantitativo Total Atendimento PSP");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItemPRORESActionPerformed

    private void jAtividadesMensalUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtividadesMensalUnidadeActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtividadeMensalManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaAtividadeMensalManu_ADM) && codAbrirADM == 1) {
            if (objAtividadeMU == null || objAtividadeMU.isClosed()) {
                objAtividadeMU = new TelaAtividadesMensalUnidade();
                jPainelAdmPessoal.add(objAtividadeMU);
                objAtividadeMU.setVisible(true);
            } else {
                if (objAtividadeMU.isVisible()) {
                    if (objAtividadeMU.isIcon()) { // Se esta minimizado
                        try {
                            objAtividadeMU.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtividadeMU.toFront(); // traz para frente
                        objAtividadeMU.pack();//volta frame 
                    }
                } else {
                    objAtividadeMU = new TelaAtividadesMensalUnidade();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAtividadeMU);//adicona frame ao JDesktopPane  
                    objAtividadeMU.setVisible(true);
                }
            }
            try {
                objAtividadeMU.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jAtividadesMensalUnidadeActionPerformed

    private void jConsultaGlobalColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaGlobalColaboradoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPesquisaGlobalColaboradores_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaPesquisaGlobalColaboradores_ADM) && codAbrirADM == 1) {
            if (objConsCola == null || objConsCola.isClosed()) {
                objConsCola = new ConsultaGerencialColaboradoresUnidade();
                jPainelAdmPessoal.add(objConsCola);
                objConsCola.setVisible(true);
            } else {
                if (objConsCola.isVisible()) {
                    if (objConsCola.isIcon()) { // Se esta minimizado
                        try {
                            objConsCola.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objConsCola.toFront(); // traz para frente
                        objConsCola.pack();//volta frame 
                    }
                } else {
                    objConsCola = new ConsultaGerencialColaboradoresUnidade();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objConsCola);//adicona frame ao JDesktopPane  
                    objConsCola.setVisible(true);
                }
            }
            try {
                objConsCola.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jConsultaGlobalColaboradoresActionPerformed

    private void jRelatorioAtividadesMensalUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioAtividadesMensalUnidadeActionPerformed
        // TODO add your handling code here:
        RelatorioAtividadesMensalRealizadaUnidade objRelAtividade = new RelatorioAtividadesMensalRealizadaUnidade();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelAtividade);
        objRelAtividade.show();
    }//GEN-LAST:event_jRelatorioAtividadesMensalUnidadeActionPerformed

    private void jRelatorioPopulacaoAlimenticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioPopulacaoAlimenticiaActionPerformed
        // TODO add your handling code here:RelatorioPopulacaoAlimenticia
        RelatorioPopulacaoAlimenticia objRelPopAlimenta = new RelatorioPopulacaoAlimenticia();
        TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRelPopAlimenta);
        objRelPopAlimenta.show();
    }//GEN-LAST:event_jRelatorioPopulacaoAlimenticiaActionPerformed

    private void jRelatorioFichaCadastralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioFichaCadastralActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Em construção...");
    }//GEN-LAST:event_jRelatorioFichaCadastralActionPerformed

    private void jEntradasSaidaColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntradasSaidaColaboradoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradasSaidasColaboradoresManu_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaEntradasSaidasColaboradoresManu_ADM) && codAbrirADM == 1) {
            if (objEntradaSaidaFunc == null || objEntradaSaidaFunc.isClosed()) {
                objEntradaSaidaFunc = new TelaEntradaSaidasColaboradores();
                jPainelAdmPessoal.add(objEntradaSaidaFunc);
                objEntradaSaidaFunc.setVisible(true);
            } else {
                if (objEntradaSaidaFunc.isVisible()) {
                    if (objEntradaSaidaFunc.isIcon()) { // Se esta minimizado
                        try {
                            objEntradaSaidaFunc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntradaSaidaFunc.toFront(); // traz para frente
                        objEntradaSaidaFunc.pack();//volta frame 
                    }
                } else {
                    objEntradaSaidaFunc = new TelaEntradaSaidasColaboradores();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objEntradaSaidaFunc);//adicona frame ao JDesktopPane  
                    objEntradaSaidaFunc.setVisible(true);
                }
            }
            try {
                objEntradaSaidaFunc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEntradasSaidaColaboradoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AprovadoresSolicitacaoCompras;
    private javax.swing.JMenuItem AprovarPedidosCompras;
    private javax.swing.JMenuItem AprovarSolicitacoesCompras;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenu Colaborador;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu ControleAprovacaoCompras;
    private javax.swing.JMenuItem FichaCadastral;
    private javax.swing.JMenuItem FrequenciaColaboradoresPorDepartamento;
    private javax.swing.JMenuItem ListagemColaboradores;
    private javax.swing.JMenuItem ListagemColaboradoresAtivoInativo;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem RelatorioCargos;
    private javax.swing.JMenuItem RelatorioCidades;
    private javax.swing.JMenuItem RelatorioDepartamento;
    private javax.swing.JMenuItem RelatorioIndividualColaboradorFrequencia;
    private javax.swing.JMenuItem RelatorioPaises;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem SolicitacaoComprasAdm;
    private javax.swing.JMenuItem SolicitantesCompras;
    private javax.swing.JMenuItem jAgendaRecados;
    private javax.swing.JMenuItem jAtividadesMensalUnidade;
    private javax.swing.JMenuItem jCargos;
    private javax.swing.JMenuItem jCidades;
    private javax.swing.JMenuItem jConsultaGlobalColaboradores;
    private javax.swing.JMenuItem jDepartamentos;
    private javax.swing.JMenu jDiversos;
    private javax.swing.JMenuItem jEntradasSaidaColaboradores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemPRORES;
    private javax.swing.JMenu jMenuPRORES;
    public static javax.swing.JDesktopPane jPainelAdmPessoal;
    private javax.swing.JMenuItem jPais;
    private javax.swing.JMenuItem jPopulacaoCarcerariaAgentes;
    private javax.swing.JMenuItem jRelatorioAtividadesMensalUnidade;
    private javax.swing.JMenuItem jRelatorioFichaCadastral;
    private javax.swing.JMenuItem jRelatorioPopulacaoAlimenticia;
    private javax.swing.JMenuItem jRelatorioTotaisProdutividade;
    private javax.swing.JMenuItem jRelatorioTotaisProdutividadePorTecnico;
    private javax.swing.JMenuItem jSair;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
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
                TelaModuloAdmPessoal.jPainelAdmPessoal.add(objRecados);
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
                    + "WHERE NomeTela='" + telaCadastroDepartamento_ADM + "'");
            conecta.rs.first();
            pNomeCD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCargos_ADM + "'");
            conecta.rs.first();
            pNomeC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCidades_ADM + "'");
            conecta.rs.first();
            pNomeLC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPaises_ADM + "'");
            conecta.rs.first();
            pNomeLP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaColaboradoresFC_ADM + "'");
            conecta.rs.first();
            pNomeCO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaColaboradoresFCEnd_ADM + "'");
            conecta.rs.first();
            pNomeCOE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaColaboradoresFCDoc_ADM + "'");
            conecta.rs.first();
            pNomeCOD = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaColaboradoresFCDep_ADM + "'");
            conecta.rs.first();
            pNomeCODE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CONSULTA  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPesquisaGlobalColaboradores_ADM + "'");
            conecta.rs.first();
            pNomePGC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprovadoresSC_ADM + "'");
            conecta.rs.first();
            pNomeAP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitantesC_ADM + "'");
            conecta.rs.first();
            pNomeSI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoC_ADM + "'");
            conecta.rs.first();
            pNomeSO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitantesSOL_ADM + "'");
            conecta.rs.first();
            pNomeSOS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSolicitacaoCP_ADM + "'");
            conecta.rs.first();
            pNomeSIP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprovadorSC_ADM + "'");
            conecta.rs.first();
            pNomeAPR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAprovarItensSC_ADM + "'");
            conecta.rs.first();
            pNomeAPROI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ATIVIDADES MENSAL UNIDADE
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalManu_ADM + "'");
            conecta.rs.first();
            pNomeAMUM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalSS_ADM + "'");
            conecta.rs.first();
            pNomeASS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalAL_ADM + "'");
            conecta.rs.first();
            pNomeAL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalAI_ADM + "'");
            conecta.rs.first();
            pNomeAI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalADI_ADM + "'");
            conecta.rs.first();
            pNomeADI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalASMI_ADM + "'");
            conecta.rs.first();
            pNomeASMI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalSI_ADM + "'");
            conecta.rs.first();
            pNomeSEI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalAJ_ADM + "'");
            conecta.rs.first();
            pNomeAJ = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtividadeMensalALI_ADM + "'");
            conecta.rs.first();
            pNomeALI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradasSaidasColaboradoresManu_ADM + "'");
            conecta.rs.first();
            pNomeESCM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradasSaidasColaboradoresCola_ADM + "'");
            conecta.rs.first();
            pNomeESCC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // INICIO DA COMPARAÇÃO
        if (!pNomeCD.equals(telaCadastroDepartamento_ADM) || pNomeCD == null || pNomeCD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroDepartamento_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeC.equals(telaCargos_ADM) || pNomeC == null || pNomeC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCargos_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLC.equals(telaCidades_ADM) || pNomeLC == null || pNomeLC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCidades_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLP.equals(telaPaises_ADM) || pNomeLP == null || pNomeLP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPaises_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCO.equals(telaColaboradoresFC_ADM) || pNomeCO == null || pNomeCO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaColaboradoresFC_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCOE.equals(telaColaboradoresFCEnd_ADM) || pNomeCOE == null || pNomeCOE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaColaboradoresFCEnd_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCOD.equals(telaColaboradoresFCDoc_ADM) || pNomeCOD == null || pNomeCOD.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaColaboradoresFCDoc_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCODE.equals(telaColaboradoresFCDep_ADM) || pNomeCODE == null || pNomeCODE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaColaboradoresFCDep_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CONSULTA  
        if (!pNomePGC.equals(telaPesquisaGlobalColaboradores_ADM) || pNomePGC == null || pNomePGC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPesquisaGlobalColaboradores_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeAP.equals(telaAprovadoresSC_ADM) || pNomeAP == null || pNomeAP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprovadoresSC_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSI.equals(telaSolicitantesC_ADM) || pNomeSI == null || pNomeSI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitantesC_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSO.equals(telaSolicitacaoC_ADM) || pNomeSO == null || pNomeSO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoC_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSOS.equals(telaSolicitantesSOL_ADM) || pNomeSOS == null || pNomeSOS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitantesSOL_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSIP.equals(telaSolicitacaoCP_ADM) || pNomeSIP == null || pNomeSIP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSolicitacaoCP_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPR.equals(telaAprovadorSC_ADM) || pNomeAPR == null || pNomeAPR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprovadorSC_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPROI.equals(telaAprovarItensSC_ADM) || pNomeAPROI == null || pNomeAPROI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAprovarItensSC_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ATIVIDADES MENSAL UNIDADE
        if (!pNomeAMUM.equals(telaAprovarItensSC_ADM) || pNomeAMUM == null || pNomeAMUM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalManu_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeASS.equals(telaAtividadeMensalSS_ADM) || pNomeASS == null || pNomeASS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalSS_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAL.equals(telaAtividadeMensalAL_ADM) || pNomeAL == null || pNomeAL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalAL_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAI.equals(telaAtividadeMensalAI_ADM) || pNomeAI == null || pNomeAI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalAI_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeADI.equals(telaAtividadeMensalADI_ADM) || pNomeADI == null || pNomeADI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalADI_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeASMI.equals(telaAtividadeMensalASMI_ADM) || pNomeASMI == null || pNomeASMI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalASMI_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSEI.equals(telaAtividadeMensalSI_ADM) || pNomeSEI == null || pNomeSEI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalSI_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAJ.equals(telaAtividadeMensalAJ_ADM) || pNomeAJ == null || pNomeAJ.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalAJ_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeALI.equals(telaAtividadeMensalAJ_ADM) || pNomeALI == null || pNomeALI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtividadeMensalALI_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCM.equals(telaEntradasSaidasColaboradoresManu_ADM) || pNomeESCM == null || pNomeESCM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradasSaidasColaboradoresManu_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCC.equals(telaEntradasSaidasColaboradoresCola_ADM) || pNomeESCC == null || pNomeESCC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradasSaidasColaboradoresCola_ADM);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloADM + "'");
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
            codigoUserADM = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserADM + "'");
            conecta.rs.first();
            codigoUserGroupADM = conecta.rs.getInt("IdUsuario");
            codigoGrupoADM = conecta.rs.getInt("IdGrupo");
            nomeGrupoADM = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserADM + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoADM = conecta.rs.getInt("IdUsuario");
            codAbrirADM = conecta.rs.getInt("Abrir");
            codIncluirADM = conecta.rs.getInt("Incluir");
            codAlterarADM = conecta.rs.getInt("Alterar");
            codExcluirADM = conecta.rs.getInt("Excluir");
            codGravarADM = conecta.rs.getInt("Gravar");
            codConsultarADM = conecta.rs.getInt("Consultar");
            nomeTelaADM = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
