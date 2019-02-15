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
import static gestor.Visao.TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TelaModuloBaseDois extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //   
    private TelaRecadosBaseSegurancaAuxiliar objRecaSeguAux = null;
    private TelaPopulacaoBaseSeguranca objPop = null;
    private TelaMovHistoricoTecBaseSegurancaAuxiliar objHistMovSegAux = null;
    private TelaConsultaLocalInternoBaseSeguranca objLocalInter = null;
    private TelaOcorrenciaBaseDois objOcoSeguAux = null;
    private TelaConsultaListaPassagemInternosSeg oblConListaPass = null;
    private TelaMovimentacaoCrcBaseSegurancaAuxiliar objHistCrcAux = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaConsultaAdvogadosDir objConsuAdv = null;
    private TelaLocacaoInternoBGPA objLoca = null;
    private TelaTransCelasBGPA objTransCelasBGPA = null;
    private TelaRolVisitasPortaria objRolVisitas = null;
    private TelaPavilhaoBGPA objPav = null;
    private TelaCelasBGPA objCelas = null;
    private TelaConsultaOficialJusticaBGP objConsultaOFJUS = null;
    private TelaPagamentoKitInterno objKitBase = null;
    private TelaAlertaPreLocacaoTriagem objAlertaPreLocacaoB2 = null;
    private TelaAlertaBasesPavilhoesBaseDois objAlertaVPIB2 = null;
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
    public static int codigoUserB2 = 0;
    public static int codUserAcessoB2 = 0;
    public static int codigoUserGroupB2 = 0;
    public static int codAbrirB2 = 0;
    public static int codIncluirB2 = 0;
    public static int codAlterarB2 = 0;
    public static int codExcluirB2 = 0;
    public static int codGravarB2 = 0;
    public static int codConsultarB2 = 0;
    public static int codigoGrupoB2 = 0;
    public static String nomeGrupoB2 = "";
    public static String nomeTelaB2 = "";
    // TELAS DE ACESSOS AO MÓDULO ENFERMARIA
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    public static String nomeModuloB2 = "BASE PAVILHAO DOIS";
    // MENU CADASTRO
    public static String telaPavilhaoB2 = "Cadastro:Pavilhão:Manutenção-B2";
    public static String telaCelasB2 = "Cadastro:Celas:Manutenção-B2";
    public static String telaPopulacaoInternosAgentesB2 = "Cadastro:População Internos e Agentes-B2";
    // MOVIMENTAÇÃO
    public static String telaLocacaoInternosManutencaoB2 = "Movimentação:Locação Internos:Manutenção-B2";
    public static String telaLocacaoInternosB2 = "Movimentação:Locação Internos:Internos-B2";
    public static String telaTransferenciaPavilhaoCelaB2 = "Movimentação:Transferencia Pavilhao Cela:Manutenção-B2";
    public static String telaLivroOcorrenciasB2 = "Movimentação:Livro Ocorrencias:Manutenção-B2";
    public static String telaEntregaMaterialUsoB2 = "Movimentação:Entrega de Material Uso Pessoal:Manutenção-B2";
    public static String telaEntregaMaterialUsoInternosB2 = "Movimentação:Entrega de Material Uso Pessoal:Internos-B2";
    public static String telaEntregaMaterialUsoInternosBioB2 = "Movimentação:Entrega de Material Uso Pessoal:Biometria-B2";
    public static String telaInicializarLeitorB2 = "Movimentação:Entrega de Material Uso Pessoal:Inicializar leitor-B2";
    //
    public static String telaAlertaVisitantesPortariaB2 = "Consulta:Alerta Visitas Internos/Advogados/Oficial de Justiça-B2";
    //
    // MENU CADASTRO
    String pNomePA = "";
    String pNomeCE = "";
    String pNomePIA = "";
    // MOVIMENTAÇÃO
    String pNomeLIM = "";
    String pNomeLI = "";
    String pNomeTPC = "";
    String pNomeLO = "";
    String pNomeEMUP = "";
    String pNomeEMUPI = "";
    String pNomeEMUIB = "";
    String pNomeIL = "";
    //
    String pNomeCAVP = "";
    //
    String preLocacao = "";
    String confirmaLocacao = "Não";
    // VARIAVEIS PARA CRIAR ALERTA NAS BASES DOS PAVILHÕES
    public static int codigoPavilhao = 0;
    public static String descricaoPavilhao = "";
    String nivelPavilhao = "";
    public static String nomePavilhao1 = "PAVILHAO II";
    public static String nomePavilhao2 = "PAVILHAO B";
    public static String nomePavilhao3 = "TRIAGEM";
    String confirmarVisitas = "Não";
    int pBuscaPavilhao1 = 0;
    String pBuscaConfirmacao = "";
    String alertaPavilhao = "";
    String pHabilitado = "Habilitado";

    /**
     * Creates new form TelaSeguranca
     */
    public TelaModuloBaseDois() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jPainelBasePavilhaoAuxiliar = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastro = new javax.swing.JMenu();
        PavilhaoCelaBpa = new javax.swing.JMenu();
        Pavilhao = new javax.swing.JMenuItem();
        Celas = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        PopulacaoInternosAgentesBpa = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        SairTelaSeguranca = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        RolVisitas = new javax.swing.JMenuItem();
        LocalInternos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jConsultaAdvogados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jOficialJustica = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ListaPassagem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        HistoricosInternos = new javax.swing.JMenu();
        HistoricoCrc = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jAlertaVisitantesPavilhao = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        LocacaoInternosBpa = new javax.swing.JMenuItem();
        TransferenciaPavilhaoCelasBpa = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        EntregaMaterialUsoPessoal = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        RelatoriosSeguranca = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        RelatorioGeralPavilhaoCelas = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        MapaConfere = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        ListaPassagemInterna = new javax.swing.JMenuItem();
        ListaPassagemExterna = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        RelatorioPreLocacaoInternoTriagem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..::: BGP - Base Pavilhão II - {BASESEG} :::...");

        jPainelBasePavilhaoAuxiliar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelBasePavilhaoAuxiliar.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelBasePavilhaoAuxiliarLayout = new javax.swing.GroupLayout(jPainelBasePavilhaoAuxiliar);
        jPainelBasePavilhaoAuxiliar.setLayout(jPainelBasePavilhaoAuxiliarLayout);
        jPainelBasePavilhaoAuxiliarLayout.setHorizontalGroup(
            jPainelBasePavilhaoAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelBasePavilhaoAuxiliarLayout.setVerticalGroup(
            jPainelBasePavilhaoAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelBasePavilhaoAuxiliarLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        Cadastro.setText("Cadastro");

        PavilhaoCelaBpa.setText("Pavilhão/Celas");

        Pavilhao.setText("Pavilhão");
        Pavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PavilhaoActionPerformed(evt);
            }
        });
        PavilhaoCelaBpa.add(Pavilhao);

        Celas.setText("Celas");
        Celas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelasActionPerformed(evt);
            }
        });
        PavilhaoCelaBpa.add(Celas);

        Cadastro.add(PavilhaoCelaBpa);
        Cadastro.add(jSeparator4);

        PopulacaoInternosAgentesBpa.setText("População de Internos e Agentes");
        PopulacaoInternosAgentesBpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopulacaoInternosAgentesBpaActionPerformed(evt);
            }
        });
        Cadastro.add(PopulacaoInternosAgentesBpa);
        Cadastro.add(jSeparator3);

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

        LocalInternos.setText("Localização de Internos");
        LocalInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalInternosActionPerformed(evt);
            }
        });
        Consultas.add(LocalInternos);
        Consultas.add(jSeparator6);

        jConsultaAdvogados.setText("Advogados");
        jConsultaAdvogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaAdvogadosActionPerformed(evt);
            }
        });
        Consultas.add(jConsultaAdvogados);
        Consultas.add(jSeparator1);

        jOficialJustica.setText("Oficial de Justiça");
        jOficialJustica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOficialJusticaActionPerformed(evt);
            }
        });
        Consultas.add(jOficialJustica);
        Consultas.add(jSeparator7);

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
        Consultas.add(jSeparator13);

        jAlertaVisitantesPavilhao.setForeground(new java.awt.Color(204, 0, 0));
        jAlertaVisitantesPavilhao.setText("Alerta de Visitantes na Portaria Interna");
        jAlertaVisitantesPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlertaVisitantesPavilhaoActionPerformed(evt);
            }
        });
        Consultas.add(jAlertaVisitantesPavilhao);

        jMenuBar1.add(Consultas);

        Movimentacao.setText("Movimentação");
        Movimentacao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        LocacaoInternosBpa.setText("Locação de Internos");
        LocacaoInternosBpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocacaoInternosBpaActionPerformed(evt);
            }
        });
        Movimentacao.add(LocacaoInternosBpa);

        TransferenciaPavilhaoCelasBpa.setText("Transferência de Pavilhão/Cela");
        TransferenciaPavilhaoCelasBpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferenciaPavilhaoCelasBpaActionPerformed(evt);
            }
        });
        Movimentacao.add(TransferenciaPavilhaoCelasBpa);
        Movimentacao.add(jSeparator5);

        EntregaMaterialUsoPessoal.setText("Entrega Material Uso Pessoal");
        EntregaMaterialUsoPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntregaMaterialUsoPessoalActionPerformed(evt);
            }
        });
        Movimentacao.add(EntregaMaterialUsoPessoal);
        Movimentacao.add(jSeparator8);

        LivroOcorrencias.setText("Livro de Ocorrências");
        LivroOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciasActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencias);

        jMenuBar1.add(Movimentacao);

        RelatoriosSeguranca.setText("Relatórios");

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

        RelatoriosSeguranca.add(jMenu7);
        RelatoriosSeguranca.add(jSeparator11);

        ListaPassagemInterna.setText("Relatório de Lista de Passagem Interna");
        ListaPassagemInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemInternaActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(ListaPassagemInterna);

        ListaPassagemExterna.setText("Relatório de Lista de Passagem Externa");
        ListaPassagemExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemExternaActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(ListaPassagemExterna);
        RelatoriosSeguranca.add(jSeparator9);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioEntradaInternosUnidade);
        RelatoriosSeguranca.add(jSeparator10);

        RelatorioPreLocacaoInternoTriagem.setForeground(new java.awt.Color(204, 0, 0));
        RelatorioPreLocacaoInternoTriagem.setText("Relatório Geral de Pré-Locação de Internos - Triagem");
        RelatorioPreLocacaoInternoTriagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPreLocacaoInternoTriagemActionPerformed(evt);
            }
        });
        RelatoriosSeguranca.add(RelatorioPreLocacaoInternoTriagem);

        jMenuBar1.add(RelatoriosSeguranca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelBasePavilhaoAuxiliar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelBasePavilhaoAuxiliar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairTelaSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairTelaSegurancaActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_SairTelaSegurancaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (objHistMovSegAux == null || objHistMovSegAux.isClosed()) {
            objHistMovSegAux = new TelaMovHistoricoTecBaseSegurancaAuxiliar();
            jPainelBasePavilhaoAuxiliar.add(objHistMovSegAux);
            objHistMovSegAux.setVisible(true);
        } else {
            if (objHistMovSegAux.isVisible()) {
                if (objHistMovSegAux.isIcon()) { // Se esta minimizado
                    try {
                        objHistMovSegAux.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistMovSegAux.toFront(); // traz para frente
                    objHistMovSegAux.pack();//volta frame 
                }
            } else {
                objHistMovSegAux = new TelaMovHistoricoTecBaseSegurancaAuxiliar();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objHistMovSegAux);//adicona frame ao JDesktopPane  
                objHistMovSegAux.setVisible(true);
            }
        }
        try {
            objHistMovSegAux.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void LocalInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalInter == null || objLocalInter.isClosed()) {
            objLocalInter = new TelaConsultaLocalInternoBaseSeguranca();
            jPainelBasePavilhaoAuxiliar.add(objLocalInter);
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
                objLocalInter = new TelaConsultaLocalInternoBaseSeguranca();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objLocalInter);//adicona frame ao JDesktopPane  
                objLocalInter.setVisible(true);
            }
        }
        try {
            objLocalInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalInternosActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecaSeguAux == null || objRecaSeguAux.isClosed()) {
            objRecaSeguAux = new TelaRecadosBaseSegurancaAuxiliar();
            jPainelBasePavilhaoAuxiliar.add(objRecaSeguAux);
            objRecaSeguAux.setVisible(true);
        } else {
            if (objRecaSeguAux.isVisible()) {
                if (objRecaSeguAux.isIcon()) { // Se esta minimizado
                    try {
                        objRecaSeguAux.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecaSeguAux.toFront(); // traz para frente
                    objRecaSeguAux.pack();//volta frame 
                }
            } else {
                objRecaSeguAux = new TelaRecadosBaseSegurancaAuxiliar();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objRecaSeguAux);//adicona frame ao JDesktopPane  
                objRecaSeguAux.setVisible(true);
            }
        }
        try {
            objRecaSeguAux.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void LivroOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLivroOcorrenciasB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaLivroOcorrenciasB2) && codAbrirB2 == 1) {
            if (objOcoSeguAux == null || objOcoSeguAux.isClosed()) {
                objOcoSeguAux = new TelaOcorrenciaBaseDois();
                jPainelBasePavilhaoAuxiliar.add(objOcoSeguAux);
                objOcoSeguAux.setVisible(true);
            } else {
                if (objOcoSeguAux.isVisible()) {
                    if (objOcoSeguAux.isIcon()) { // Se esta minimizado
                        try {
                            objOcoSeguAux.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOcoSeguAux.toFront(); // traz para frente
                        objOcoSeguAux.pack();//volta frame 
                    }
                } else {
                    objOcoSeguAux = new TelaOcorrenciaBaseDois();
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objOcoSeguAux);//adicona frame ao JDesktopPane  
                    objOcoSeguAux.setVisible(true);
                }
            }
            try {
                objOcoSeguAux.setSelected(true);
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
            jPainelBasePavilhaoAuxiliar.add(oblConListaPass);
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
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(oblConListaPass);//adicona frame ao JDesktopPane  
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
        TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void ListaPassagemInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemInternaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE TipoEmpresa='" + tipoEmpresa + "' "
                    + "AND StatusInterno='" + statusInterno + "'ORDER BY RazaoSocial,NomeInternoCrc");
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
        if (objHistCrcAux == null || objHistCrcAux.isClosed()) {
            objHistCrcAux = new TelaMovimentacaoCrcBaseSegurancaAuxiliar();
            jPainelBasePavilhaoAuxiliar.add(objHistCrcAux);
            objHistCrcAux.setVisible(true);
        } else {
            if (objHistCrcAux.isVisible()) {
                if (objHistCrcAux.isIcon()) { // Se esta minimizado
                    try {
                        objHistCrcAux.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistCrcAux.toFront(); // traz para frente
                    objHistCrcAux.pack();//volta frame 
                }
            } else {
                objHistCrcAux = new TelaMovimentacaoCrcBaseSegurancaAuxiliar();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objHistCrcAux);//adicona frame ao JDesktopPane  
                objHistCrcAux.setVisible(true);
            }
        }
        try {
            objHistCrcAux.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoCrcActionPerformed

    private void MapaConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapaConfereActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereSeguranca mapop = new TelaRelMapaConfereSeguranca();
        TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(mapop);
        mapop.show();
    }//GEN-LAST:event_MapaConfereActionPerformed

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelBasePavilhaoAuxiliar.add(objAgEventos);
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
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void jConsultaAdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaAdvogadosActionPerformed
        // TODO add your handling code here:
        if (objConsuAdv == null || objConsuAdv.isClosed()) {
            objConsuAdv = new TelaConsultaAdvogadosDir();
            jPainelBasePavilhaoAuxiliar.add(objConsuAdv);
            objConsuAdv.setVisible(true);
        } else {
            if (objConsuAdv.isVisible()) {
                if (objConsuAdv.isIcon()) { // Se esta minimizado
                    try {
                        objConsuAdv.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsuAdv.toFront(); // traz para frente
                    objConsuAdv.pack();//volta frame 
                }
            } else {
                objConsuAdv = new TelaConsultaAdvogadosDir();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objConsuAdv);//adicona frame ao JDesktopPane  
                objConsuAdv.setVisible(true);
            }
        }
        try {
            objConsuAdv.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jConsultaAdvogadosActionPerformed

    private void RolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolVisitasActionPerformed
        // TODO add your handling code here:
        if (objRolVisitas == null || objRolVisitas.isClosed()) {
            objRolVisitas = new TelaRolVisitasPortaria();
            jPainelBasePavilhaoAuxiliar.add(objRolVisitas);
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
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objRolVisitas);//adicona frame ao JDesktopPane  
                objRolVisitas.setVisible(true);
            }
        }
        try {
            objRolVisitas.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RolVisitasActionPerformed

    private void jOficialJusticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOficialJusticaActionPerformed
        // TODO add your handling code here:
        if (objConsultaOFJUS == null || objConsultaOFJUS.isClosed()) {
            objConsultaOFJUS = new TelaConsultaOficialJusticaBGP();
            jPainelBasePavilhaoAuxiliar.add(objConsultaOFJUS);
            objConsultaOFJUS.setVisible(true);
        } else {
            if (objConsultaOFJUS.isVisible()) {
                if (objConsultaOFJUS.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaOFJUS.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaOFJUS.toFront(); // traz para frente
                    objConsultaOFJUS.pack();//volta frame
                }
            } else {
                objConsultaOFJUS = new TelaConsultaOficialJusticaBGP();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objConsultaOFJUS);//adicona frame ao JDesktopPane
                objConsultaOFJUS.setVisible(true);
            }
        }
        try {
            objConsultaOFJUS.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jOficialJusticaActionPerformed

    private void PavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PavilhaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPavilhaoB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaPavilhaoB2) && codAbrirB2 == 1) {
            if (objPav == null || objPav.isClosed()) {
                objPav = new TelaPavilhaoBGPA();
                jPainelBasePavilhaoAuxiliar.add(objPav);
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
                    objPav = new TelaPavilhaoBGPA();
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objPav);//adicona frame ao JDesktopPane
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
        buscarAcessoUsuario(telaCelasB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaCelasB2) && codAbrirB2 == 1) {
            if (objCelas == null || objCelas.isClosed()) {
                objCelas = new TelaCelasBGPA();
                jPainelBasePavilhaoAuxiliar.add(objCelas);
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
                    objCelas = new TelaCelasBGPA();
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objCelas);//adicona frame ao JDesktopPane
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

    private void PopulacaoInternosAgentesBpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopulacaoInternosAgentesBpaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPopulacaoInternosAgentesB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaPopulacaoInternosAgentesB2) && codAbrirB2 == 1) {
            if (objPop == null || objPop.isClosed()) {
                objPop = new TelaPopulacaoBaseSeguranca();
                jPainelBasePavilhaoAuxiliar.add(objPop);
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
                    objPop = new TelaPopulacaoBaseSeguranca();
                    TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objPop);//adicona frame ao JDesktopPane
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
    }//GEN-LAST:event_PopulacaoInternosAgentesBpaActionPerformed

    private void LocacaoInternosBpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocacaoInternosBpaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocacaoInternosManutencaoB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaLocacaoInternosManutencaoB2) && codAbrirB2 == 1) {
            if (objLoca == null || objLoca.isClosed()) {
                objLoca = new TelaLocacaoInternoBGPA();
                jPainelBasePavilhaoAuxiliar.add(objLoca);
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
                    objLoca = new TelaLocacaoInternoBGPA();
                    TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objLoca);//adicona frame ao JDesktopPane
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
    }//GEN-LAST:event_LocacaoInternosBpaActionPerformed

    private void TransferenciaPavilhaoCelasBpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferenciaPavilhaoCelasBpaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTransferenciaPavilhaoCelaB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaTransferenciaPavilhaoCelaB2) && codAbrirB2 == 1) {
            if (objTransCelasBGPA == null || objTransCelasBGPA.isClosed()) {
                objTransCelasBGPA = new TelaTransCelasBGPA();
                jPainelBasePavilhaoAuxiliar.add(objTransCelasBGPA);
                objTransCelasBGPA.setVisible(true);
            } else {
                if (objTransCelasBGPA.isVisible()) {
                    if (objTransCelasBGPA.isIcon()) { // Se esta minimizado
                        try {
                            objTransCelasBGPA.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTransCelasBGPA.toFront(); // traz para frente
                        objTransCelasBGPA.pack();//volta frame
                    }
                } else {
                    objTransCelasBGPA = new TelaTransCelasBGPA();
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objTransCelasBGPA);//adicona frame ao JDesktopPane
                    objTransCelasBGPA.setVisible(true);
                }
            }
            try {
                objTransCelasBGPA.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_TransferenciaPavilhaoCelasBpaActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void EntregaMaterialUsoPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntregaMaterialUsoPessoalActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codAbrirB2 == 1) {
            if (objKitBase == null || objKitBase.isClosed()) {
                objKitBase = new TelaPagamentoKitInterno();
                jPainelBasePavilhaoAuxiliar.add(objKitBase);
                objKitBase.setVisible(true);
            } else {
                if (objKitBase.isVisible()) {
                    if (objKitBase.isIcon()) { // Se esta minimizado
                        try {
                            objKitBase.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objKitBase.toFront(); // traz para frente
                        objKitBase.pack();//volta frame
                    }
                } else {
                    objKitBase = new TelaPagamentoKitInterno();
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objKitBase);//adicona frame ao JDesktopPane
                    objKitBase.setVisible(true);
                }
            }
            try {
                objKitBase.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EntregaMaterialUsoPessoalActionPerformed

    private void RelatorioPreLocacaoInternoTriagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPreLocacaoInternoTriagemActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioPreLocacaoInternosTriagemGeral.jasper";
            conecta.executaSQL("SELECT * FROM PRE_LOCACAO_INTERNOS "
                    + "INNER JOIN ITENS_PRE_LOCACAO_INTERNOS "
                    + "ON PRE_LOCACAO_INTERNOS.CodigoReg=ITENS_PRE_LOCACAO_INTERNOS.CodigoReg "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PRE_LOCACAO_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN PAVILHAO "
                    + "ON ITENS_PRE_LOCACAO_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "ORDER BY PRE_LOCACAO_INTERNOS.CodigoReg,PRONTUARIOSCRC.NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("descricaoUnidade", descricaoUnidade);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao  
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Geral de Pré-Locação de Internos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório. \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioPreLocacaoInternoTriagemActionPerformed

    private void jAlertaVisitantesPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlertaVisitantesPavilhaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAlertaVisitantesPortariaB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaAlertaVisitantesPortariaB2) && codAbrirB2 == 1) {
            if (objAlertaVPIB2 == null || objAlertaVPIB2.isClosed()) {
                objAlertaVPIB2 = new TelaAlertaBasesPavilhoesBaseDois();
                jPainelBasePavilhaoAuxiliar.add(objAlertaVPIB2);
                objAlertaVPIB2.setVisible(true);
            } else {
                if (objAlertaVPIB2.isVisible()) {
                    if (objAlertaVPIB2.isIcon()) { // Se esta minimizado
                        try {
                            objAlertaVPIB2.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAlertaVPIB2.toFront(); // traz para frente
                        objAlertaVPIB2.pack();//volta frame
                    }
                } else {
                    objAlertaVPIB2 = new TelaAlertaBasesPavilhoesBaseDois();
                    TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objAlertaVPIB2);//adicona frame ao JDesktopPane
                    objAlertaVPIB2.setVisible(true);
                }
            }
            try {
                objAlertaVPIB2.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jAlertaVisitantesPavilhaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenu Cadastro;
    public static javax.swing.JMenuItem Celas;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem EntregaMaterialUsoPessoal;
    private javax.swing.JMenuItem HistoricoCrc;
    private javax.swing.JMenu HistoricosInternos;
    private javax.swing.JMenuItem ListaPassagem;
    private javax.swing.JMenuItem ListaPassagemExterna;
    private javax.swing.JMenuItem ListaPassagemInterna;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LivroOcorrencias;
    public static javax.swing.JMenuItem LocacaoInternosBpa;
    private javax.swing.JMenuItem LocalInternos;
    private javax.swing.JMenuItem MapaConfere;
    private javax.swing.JMenu Movimentacao;
    public static javax.swing.JMenuItem Pavilhao;
    public static javax.swing.JMenu PavilhaoCelaBpa;
    public static javax.swing.JMenuItem PopulacaoInternosAgentesBpa;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioGeralPavilhaoCelas;
    private javax.swing.JMenuItem RelatorioPreLocacaoInternoTriagem;
    private javax.swing.JMenu RelatoriosSeguranca;
    private javax.swing.JMenuItem RolVisitas;
    private javax.swing.JMenuItem SairTelaSeguranca;
    public static javax.swing.JMenuItem TransferenciaPavilhaoCelasBpa;
    private javax.swing.JMenuItem jAlertaVisitantesPavilhao;
    private javax.swing.JMenuItem jConsultaAdvogados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jOficialJustica;
    public static javax.swing.JDesktopPane jPainelBasePavilhaoAuxiliar;
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
    // End of variables declaration//GEN-END:variables

    public void verificarParamentro() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            preLocacao = conecta.rs.getString("PreLocacaoB1");
        } catch (SQLException ex) {
            Logger.getLogger(TelaModuloBaseDois.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserB2 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserB2 + "'");
            conecta.rs.first();
            codigoUserGroupB2 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB2 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB2 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserB2 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoB2 = conecta.rs.getInt("IdUsuario");
            codAbrirB2 = conecta.rs.getInt("Abrir");
            codIncluirB2 = conecta.rs.getInt("Incluir");
            codAlterarB2 = conecta.rs.getInt("Alterar");
            codExcluirB2 = conecta.rs.getInt("Excluir");
            codGravarB2 = conecta.rs.getInt("Gravar");
            codConsultarB2 = conecta.rs.getInt("Consultar");
            nomeTelaB2 = conecta.rs.getString("NomeTela");
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
                verificarAlertaTriagem();
                alertaVisitantes();
            }
        }, periodo, tempo);
    }

    public void verificarAlertaTriagem() {
        verificarParamentro();
        if (preLocacao.equals("Habilitado")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_EXPORTADO_LOCACAO_INTERNOS "
                        + "WHERE ConfirmaBase='" + confirmaLocacao + "'");
                conecta.rs.first();
                confirmaLocacao = conecta.rs.getString("ConfirmaBase");
                if (confirmaLocacao.equals("Não")) {
                    if (objAlertaPreLocacaoB2 == null || objAlertaPreLocacaoB2.isClosed()) {
                        objAlertaPreLocacaoB2 = new TelaAlertaPreLocacaoTriagem();
                        TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAlertaPreLocacaoB2);
                        objAlertaPreLocacaoB2.setVisible(true);
                    } else {
                        if (objAlertaPreLocacaoB2.isVisible()) {
                            if (objAlertaPreLocacaoB2.isIcon()) { // Se esta minimizado
                                try {
                                    objAlertaPreLocacaoB2.setIcon(false); // maximiniza
                                } catch (PropertyVetoException ex) {
                                }
                            } else {
                                objAlertaPreLocacaoB2.toFront(); // traz para frente
                                objAlertaPreLocacaoB2.pack();//volta frame 
                            }
                        } else {
                            objAlertaPreLocacaoB2 = new TelaAlertaPreLocacaoTriagem();
                            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAlertaPreLocacaoB2);//adicona frame ao JDesktopPane  
                            objAlertaPreLocacaoB2.setVisible(true);
                        }
                    }
                    try {
                        objAlertaPreLocacaoB2.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            } catch (SQLException ex) {
            }
            conecta.desconecta();
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
                TelaRecadosBaseSegurancaAuxiliar objRecadosAux = new TelaRecadosBaseSegurancaAuxiliar();
                TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objRecadosAux);
                objRecadosAux.show();
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

    public void alertaVisitantes() {

        buscarParamentroVisitas();
        if (!alertaPavilhao.equals("") && alertaPavilhao.equals(pHabilitado)) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            conecta.abrirConexao();
            try {
                conecta.abrirConexao();
                conecta.executaSQL("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN PAVILHAO "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                        + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                        + "AND Confirmacao='" + confirmarVisitas + "'");
                conecta.rs.first();
                pBuscaPavilhao1 = conecta.rs.getInt("IdPav");
                pBuscaConfirmacao = conecta.rs.getString("Confirmacao");
            } catch (Exception e) {
            }
            if (codigoPavilhao == pBuscaPavilhao1 && pBuscaConfirmacao.equals("Não")) {
                buscarAcessoUsuario(telaAlertaVisitantesPortariaB2);
                if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaAlertaVisitantesPortariaB2) && codAbrirB2 == 1) {
                    if (objAlertaVPIB2 == null || objAlertaVPIB2.isClosed()) {
                        objAlertaVPIB2 = new TelaAlertaBasesPavilhoesBaseDois();
                        jPainelBasePavilhaoAuxiliar.add(objAlertaVPIB2);
                        objAlertaVPIB2.setVisible(true);
                    } else {
                        if (objAlertaVPIB2.isVisible()) {
                            if (objAlertaVPIB2.isIcon()) { // Se esta minimizado
                                try {
                                    objAlertaVPIB2.setIcon(false); // maximiniza
                                } catch (PropertyVetoException ex) {
                                }
                            } else {
                                objAlertaVPIB2.toFront(); // traz para frente
                                objAlertaVPIB2.pack();//volta frame
                            }
                        } else {
                            objAlertaVPIB2 = new TelaAlertaBasesPavilhoesBaseDois();
                            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objAlertaVPIB2);//adicona frame ao JDesktopPane
                            objAlertaVPIB2.setVisible(true);
                        }
                    }
                    try {
                        objAlertaVPIB2.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Existe visitantes chegando no pavilhão, porém você não tem acesso, solicite liberação ao administrador.");
                }
            }
        }
    }

    public void buscarPavilhao(String descricao, String descricao2, String descricao3) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav LIKE'%" + descricao + "%' "
                    + "OR DescricaoPav LIKE'%" + descricao2 + "%' "
                    + "OR DescricaoPav LIKE'%" + descricao3 + "%'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdPav");
            descricaoPavilhao = conecta.rs.getString("DescricaoPav");
        } catch (SQLException ex) {

        }
        conecta.desconecta();
    }

    // BUSCAR PARAMETRO PARA ALERTA DOS VISITANTES
    public void buscarParamentroVisitas() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC ");
            conecta.rs.first();
            alertaPavilhao = conecta.rs.getString("HabilitarAlertaVisitasBaseI");
        } catch (SQLException ex) {
        }
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
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAgendaComp);
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
                    TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAgendaComp);
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
        // CADASTRO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPavilhaoB2 + "'");
            conecta.rs.first();
            pNomePA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCelasB2 + "'");
            conecta.rs.first();
            pNomeCE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPopulacaoInternosAgentesB2 + "'");
            conecta.rs.first();
            pNomePIA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocacaoInternosManutencaoB2 + "'");
            conecta.rs.first();
            pNomeLIM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocacaoInternosB2 + "'");
            conecta.rs.first();
            pNomeLI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTransferenciaPavilhaoCelaB2 + "'");
            conecta.rs.first();
            pNomeTPC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLivroOcorrenciasB2 + "'");
            conecta.rs.first();
            pNomeLO = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntregaMaterialUsoB2 + "'");
            conecta.rs.first();
            pNomeEMUP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntregaMaterialUsoInternosB2 + "'");
            conecta.rs.first();
            pNomeEMUPI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntregaMaterialUsoInternosBioB2 + "'");
            conecta.rs.first();
            pNomeEMUIB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInicializarLeitorB2 + "'");
            conecta.rs.first();
            pNomeIL = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // CONSULTA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAlertaVisitantesPortariaB2 + "'");
            conecta.rs.first();
            pNomeCAVP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MENU CADASTRO
        if (!pNomePA.equals(telaPavilhaoB2) || pNomePA == null || pNomePA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPavilhaoB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCE.equals(telaCelasB2) || pNomeCE == null || pNomeCE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCelasB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePIA.equals(telaPopulacaoInternosAgentesB2) || pNomePIA == null || pNomePIA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPopulacaoInternosAgentesB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // MOVIMENTAÇÃO
        if (!pNomeLIM.equals(telaLocacaoInternosManutencaoB2) || pNomeLIM == null || pNomeLIM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocacaoInternosManutencaoB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLI.equals(telaLocacaoInternosB2) || pNomeLI == null || pNomeLI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocacaoInternosB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTPC.equals(telaTransferenciaPavilhaoCelaB2) || pNomeTPC == null || pNomeTPC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTransferenciaPavilhaoCelaB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLO.equals(telaLivroOcorrenciasB2) || pNomeLO == null || pNomeLO.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLivroOcorrenciasB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEMUP.equals(telaEntregaMaterialUsoB2) || pNomeEMUP == null || pNomeEMUP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntregaMaterialUsoB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEMUPI.equals(telaEntregaMaterialUsoInternosB2) || pNomeEMUPI == null || pNomeEMUPI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntregaMaterialUsoInternosB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEMUIB.equals(telaEntregaMaterialUsoInternosBioB2) || pNomeEMUIB == null || pNomeEMUIB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntregaMaterialUsoInternosBioB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIL.equals(telaInicializarLeitorB2) || pNomeIL == null || pNomeIL.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInicializarLeitorB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // CONSULTA
        if (!pNomeCAVP.equals(telaAlertaVisitantesPortariaB2) || pNomeCAVP == null || pNomeCAVP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAlertaVisitantesPortariaB2);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloB2 + "'");
            conecta.rs.first();
            pCodModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
    }
}
