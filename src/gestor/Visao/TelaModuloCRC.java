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
import static gestor.Visao.TelaAlertaEvadidos.jTabelaIntEvadidos;
import static gestor.Visao.TelaAlertaEvadidosSaidaTemporario.jTabelaIntEvadidosSaidaTemporaria;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaVerificacaoRetornoSaidasPortariaCrc.jTabelaEntradaSaidaPortariaCrc;
import static gestor.Visao.TelaVerificacaoRetornoSaidasPortariaCrc.jtotalRegistrosVerifica;
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
public class TelaModuloCRC extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    //
    private TelaRecadosCrc objRecados = null;
    private TelaRetornoInterno objRetorno = null;
    private TelaEntradasLote objLote = null;
    private TelaSaidaInterno objSaida = null;
    private TelaTransfInterno objTransf = null;
    private TelaRetornoRecaptura objRetCap = null;
    private TelaRetornoEspontaneo objRetornoEspontaneo = null;
    private TelaMovimentacaoCrc objTelaMov = null;
    private TelaAgendaEscolta objEscolta = null;
    private TelaConsultaLocalInterno objLocalInter = null;
    private TelaConsultaPopulacaoCRC objconPop = null;
    private TelaProntuarioCrc objTriCrc = null;
    private TelaCidades objCidades = null;
    private TelaPaises objPais = null;
    private TelaUnidadePenal objUnP = null;
    private TelaOperacaoCrc objTop = null;
    private TelaObservacoesInternos objCaracInternos = null;
    private TelaRetornoAudiencia objRetornoAud = null;
    private TelaAlertaEntradaInternosPortaria objEntradasPortarias = null;
    private TelaPrevisaoSaidaInternos objRevSaida = null;
    private TelaCancelRegistroPortaria objCanRegPort = null;
    private TelaRetornoMedico objRetMedico = null;
    private TelaRetornoPorTransferencia objRetPorTrans = null;
    private TelaMudancaRegimeRegressao objMudaRegimePro = null;
    private TelaMudancaRegimeProgressao objMudaRegimeProgressao = null;
    private TelaEvadidosSaidaTemporariaManual objEvasaoManual = null;
    private TelaNaoCumprimentoAlvara objNaoAlvara = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaConsultaInternosEvadidos objConIntEvadidos = null;
    private TelaListaPassagemInternosAlbergados objListaPassaAlberg = null;
    private TelaObitoInternoExterna objObito = null;
    private ConsultaGerencialInternosUnidade objConsultaGIU = null;
    private TelaEmissaoAtestadoReclusao objAtestadoRec = null;
    private TelaValidadorAtestadoReclusao objValidaAtestado = null;
    private TelaRevalidacaoAtestadoReclusao objAtestadoValidaAtestado = null;
    private TelaSolicitacaoAuxilioReclusaoCRC objSolicitaAtestaRec = null;
    private TelaEmissaoAtestadoReclusaoCRC objEmissaoARC = null;
    // 
    String usuarioLogado, dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    String situacaoTran = "TRANSFERENCIA"; // Todas as Transferencias
    String situacaoNull = ""; // Cadastrado mas não foi feito entrada
    String situacaoSai = "SAIDA TEMPORARIA";
    //
    int idInterno = 0;
    String horarioEntrada = "00:00";
    String evadido = ""; // Se no campo da tabela ITENSLABINTERNO estiver preenchido não mostrar os evadidos.   
    String NrDocRetorno = "";
    String NrDocRetornoNull = null;
    String dataEntrada, dataSaida, dataSaidaTemp;
    public static boolean Cadastro;
    //
    String idRetorniInt;
    String dataRetorno, dataPrevRetorno;
    String confirmaRetorno;
    String idLanc;
    String dataBrasil;
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    //
    int tempo = (1000 * 60) * 10;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    //
    String confirmaEntrada = "Não"; // Variavel que verificar os alerta de enttrada de interno na unidade
    String statusEntrada = "ENTRADA NA UNIDADE";
    String statusRetorno = "RETORNO A UNIDADE";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    // VERIFICAÇÃO DE ENTRADA REFERENTE A SAIDAS MEDICO, AUDIENCIA E OUTROS
    String dataEntradaV, dataSaidaV;
    String horaRetorno = "";
    String confirmacaoCrc = "Não"; // CONFIRMAÇÃO DO CRC
    String confirmacaoPort = "Sim"; // CONFIRMAÇÃO DA PORTARIA
    String cartaoSUS = "";
    String cartaoRG = "";
    String cartaoCPF = "";
    String pCnc = "";
    String dataInicial;
    String dataFinal;
    //
    public static int codigoUserCRC = 0;
    public static int codUserAcessoCRC = 0;
    public static int codigoUserGroupCRC = 0;
    public static int codAbrirCRC = 0;
    public static int codIncluirCRC = 0;
    public static int codAlterarCRC = 0;
    public static int codExcluirCRC = 0;
    public static int codGravarCRC = 0;
    public static int codConsultarCRC = 0;
    public static int codigoGrupoCRC = 0;
    public static String nomeGrupoCRC = "";
    public static String nomeTelaCRC = "";
    // TELAS DE ACESSOS AO MÓDULO CRC
    public static String nomeModuloCRC = "CRC";
    // MENU CADASTRO    
    public static String telaConsultaGerencialInternosExternaCRC = "Consulta:Consulta Gerencial Internos Unidade";
    public static String telaEmissaoAtestadoReclusao = "Movimentação:Emissão Atestado de Reclusão:Manutenção";
    public static String liberacaoAtestadoCRC = "Movimentação:Emissão Atestado de Reclusão:Liberação";
    public static String impressaoAtestadoCRC = "Movimentação:Emissão Atestado de Reclusão:Impressão";
    public static String validadorAtestadoCRC = "Movimentação:Validar Atestado de Reclusão";
    //
    public static String revalidarAtestadoCRC = "Movimentação: Revalidar Atestado de Reclusão:Manutenção";
    public static String liberacaoRevAtestadoCRC = "Movimentação:Revalidação Atestado de Reclusão:Liberação";
    public static String impressaoRevalidarAtCRC = "Movimentação:Revalidação Atestado de Reclusão:Impressão";
    //
    public static String solicitaAtestaReclusoCRC = "Movimentação:Solicitação Atestado de Reclusão - CRC:Manutenção";
    public static String emissaoAtestaRecCRC = "Movimentação:Emissão Atestado de Reclusão - CRC:Manutenção";
    public static String liberacaoAtestado_CRC = "Movimentação:Emissão Atestado de Reclusão - CRC:Liberação";
    public static String impressaoAtestado_CRC = "Movimentação:Emissão Atestado de Reclusão - CRC:Impressão";
    public static String validadorAtestado_CRC = "Movimentação:Validar Atestado de Reclusão - CRC";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCGIE = "";
    // MENU MOVIMENTAÇÃO
    String pNomeEAR = "";
    String pNomeLA = "";
    String pNomeIA = "";
    String pNomeVA = "";
    //
    String pNomeRAR = "";
    String pNomeLRA = "";
    String pNomeIRV = "";
    //
    String pNomeEARC = "";
    String pNomeLARC = "";
    String pNomeIARC = "";
    String pNomeVARC = "";
    //

    /**
     * Creates new form TelaCRC
     */
    public TelaModuloCRC() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela  
        buscarEvadido(); // verificar internos evadidos saida laborativa
        buscarEvadidoSaidaTemporaria(); // Verifcar internos evadidos saida temporaria
        pesquisarTelasAcessos();
        //  verificarRetornoInternos();
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

        jMenuItem8 = new javax.swing.JMenuItem();
        jPainelCRC = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jTipoOperacao = new javax.swing.JMenuItem();
        jUnidadePenal = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jPaises = new javax.swing.JMenuItem();
        jCidades = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jProntuariosIntrernos = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jSair = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPopulacaoCarceraria = new javax.swing.JMenuItem();
        jLocalizacaoInternos = new javax.swing.JMenuItem();
        ConsultaEvasaoInternos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        HistoricoMovimentacao = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        jConsultaGeralInternosExterna = new javax.swing.JMenuItem();
        jMenuMovimentacao = new javax.swing.JMenu();
        jEntradaInternos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        RetornoInternosPorTransferencia = new javax.swing.JMenuItem();
        RetornoRecaptura = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        RetornoSaidaMedico = new javax.swing.JMenuItem();
        RetornoAudiencia = new javax.swing.JMenuItem();
        RetornoEspontaneo = new javax.swing.JMenuItem();
        RetornoSaidaTemporaria = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        PrevisaoSaida = new javax.swing.JMenuItem();
        jSaidaInternos = new javax.swing.JMenuItem();
        jTransferenciaInternos = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        ListaPassagemInternosAlbergados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jAgendamentoEscolta = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        CancelarRegistro = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        MudancaRegimePenalRegressao = new javax.swing.JMenuItem();
        MudancaRegimePenalProgressao = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        EvasaoInternos = new javax.swing.JMenuItem();
        jLancamentoObitoInterno = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator29 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        jEmissaoAtestadoReclusao = new javax.swing.JMenuItem();
        jValidacaoAtestadoReclusao = new javax.swing.JMenuItem();
        jRevalidarAtestadoReclusao = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jSolicitacaoAtestadoReclusaoCRC = new javax.swing.JMenuItem();
        jEmissaoAtestadoReclusaoCRC = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        RelatorioProntuarios = new javax.swing.JMenu();
        ListagemGeralProntuarios = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        RelatorioInternos = new javax.swing.JMenu();
        RelatorioNaturalidade = new javax.swing.JMenuItem();
        RellatorioIdade = new javax.swing.JMenuItem();
        RelatorioEscolaridade = new javax.swing.JMenuItem();
        RelInternoEtinia = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        PorNCN = new javax.swing.JMenuItem();
        RelatorioArtigo = new javax.swing.JMenuItem();
        RelatorioTempoPena = new javax.swing.JMenuItem();
        RelatorioEstadoCivil = new javax.swing.JMenuItem();
        RelatorioUnidadePenal = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        RelatorioRegimePenal = new javax.swing.JMenuItem();
        RelatorioRegimePenalSexo = new javax.swing.JMenuItem();
        RelatorioPorSexo = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        RelatorioPorCidade = new javax.swing.JMenuItem();
        RelatorioPorBairro = new javax.swing.JMenuItem();
        ListagemCadastroInternos = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        CartaoSUS = new javax.swing.JMenuItem();
        RG = new javax.swing.JMenuItem();
        CPF = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        CartaoSUS1 = new javax.swing.JMenuItem();
        DocumentoRG = new javax.swing.JMenuItem();
        DocumentoCPF = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ListagemInternosUnidadeEntrada = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        RelatorioPrevisaoSaida = new javax.swing.JMenuItem();
        RelatorioPrevisaoSaidaIntNaoReal = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ListagemSaidasTemporaria = new javax.swing.JMenuItem();
        RelatorioSaidaInternosPortaria = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        RelatorioHorarioEntradaSaida = new javax.swing.JMenuItem();
        RelatorioMovAdvogadosInternos = new javax.swing.JMenuItem();
        RelatorioMovVisitasInternos = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jRelatorioEvadidos = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        RelatoriosConfere = new javax.swing.JMenu();
        MapaConfere = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        RelatorioPopulacaoInternosNominal = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jListagemPaises = new javax.swing.JMenuItem();
        jListagemCidade = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        RelatorioMudancaRegime = new javax.swing.JMenu();
        RelProgressao = new javax.swing.JMenuItem();
        RelRegressao = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jListagemUnidadePenal = new javax.swing.JMenuItem();
        jMenuUtilitarios = new javax.swing.JMenu();
        jCalculadoraPena = new javax.swing.JMenuItem();
        jCalculadoraWindows = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        GerarPopulacaoInternosNominal = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Coordenação de Registro e Controle - CRC ::: ...");

        jPainelCRC.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CRC - Coordenação de Registros e Controle");

        jPainelCRC.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPainelCRC.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelCRCLayout = new javax.swing.GroupLayout(jPainelCRC);
        jPainelCRC.setLayout(jPainelCRCLayout);
        jPainelCRCLayout.setHorizontalGroup(
            jPainelCRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelCRCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelCRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPainelCRCLayout.setVerticalGroup(
            jPainelCRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelCRCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jMenuCadastros.setText("Cadastro");

        jTipoOperacao.setText("Tipo de Operação");
        jTipoOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTipoOperacaoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jTipoOperacao);

        jUnidadePenal.setText("Unidade Penal");
        jUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnidadePenalActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jUnidadePenal);
        jMenuCadastros.add(jSeparator3);

        jMenu5.setText("Localidades");

        jPaises.setText("Paises");
        jPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaisesActionPerformed(evt);
            }
        });
        jMenu5.add(jPaises);

        jCidades.setText("Cidades");
        jCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCidadesActionPerformed(evt);
            }
        });
        jMenu5.add(jCidades);

        jMenuCadastros.add(jMenu5);
        jMenuCadastros.add(jSeparator4);

        jProntuariosIntrernos.setText("Prontuários de Internos");
        jProntuariosIntrernos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProntuariosIntrernosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jProntuariosIntrernos);
        jMenuCadastros.add(jSeparator5);

        AgendaCompromisso.setText("Agenda de Compromissos Pesssoal");
        AgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(AgendaCompromisso);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(AgendaRecados);
        jMenuCadastros.add(jSeparator21);

        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jSair);

        jMenuBar1.add(jMenuCadastros);

        jMenu6.setText("Consultas");

        jPopulacaoCarceraria.setText("População Carcerária");
        jPopulacaoCarceraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPopulacaoCarcerariaActionPerformed(evt);
            }
        });
        jMenu6.add(jPopulacaoCarceraria);

        jLocalizacaoInternos.setText("Localização de Internos");
        jLocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLocalizacaoInternosActionPerformed(evt);
            }
        });
        jMenu6.add(jLocalizacaoInternos);

        ConsultaEvasaoInternos.setText("Evasão de Internos");
        ConsultaEvasaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaEvasaoInternosActionPerformed(evt);
            }
        });
        jMenu6.add(ConsultaEvasaoInternos);
        jMenu6.add(jSeparator8);

        HistoricoMovimentacao.setText("Histórico de Movimentação Externa");
        HistoricoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovimentacaoActionPerformed(evt);
            }
        });
        jMenu6.add(HistoricoMovimentacao);
        jMenu6.add(jSeparator26);

        jConsultaGeralInternosExterna.setForeground(new java.awt.Color(204, 0, 0));
        jConsultaGeralInternosExterna.setText("Consulta Gerencial de  Internos nas Unidades Externas - CGIUE");
        jConsultaGeralInternosExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaGeralInternosExternaActionPerformed(evt);
            }
        });
        jMenu6.add(jConsultaGeralInternosExterna);

        jMenuBar1.add(jMenu6);

        jMenuMovimentacao.setText("Movimentação");

        jEntradaInternos.setText("Entrada de Internos na Unidade");
        jEntradaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntradaInternosActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jEntradaInternos);

        jMenu1.setText("Nova Entrada e Retornos de Internos na Unidade");

        RetornoInternosPorTransferencia.setText("Nova Entrada - Retorno de Internos por Transferência");
        RetornoInternosPorTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoInternosPorTransferenciaActionPerformed(evt);
            }
        });
        jMenu1.add(RetornoInternosPorTransferencia);

        RetornoRecaptura.setText("Nova Entrada - Retorno de Internos por Recaptura");
        RetornoRecaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoRecapturaActionPerformed(evt);
            }
        });
        jMenu1.add(RetornoRecaptura);
        jMenu1.add(jSeparator14);

        RetornoSaidaMedico.setForeground(new java.awt.Color(255, 0, 0));
        RetornoSaidaMedico.setText("Retorno de Saída para Médico/Outros Retornos");
        RetornoSaidaMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoSaidaMedicoActionPerformed(evt);
            }
        });
        jMenu1.add(RetornoSaidaMedico);

        RetornoAudiencia.setText("Retorno de Saída para Audiência");
        RetornoAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoAudienciaActionPerformed(evt);
            }
        });
        jMenu1.add(RetornoAudiencia);

        RetornoEspontaneo.setText("Retorno Espontâneo ");
        RetornoEspontaneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoEspontaneoActionPerformed(evt);
            }
        });
        jMenu1.add(RetornoEspontaneo);

        RetornoSaidaTemporaria.setText("Retorno de Saída Temporaria");
        RetornoSaidaTemporaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetornoSaidaTemporariaActionPerformed(evt);
            }
        });
        jMenu1.add(RetornoSaidaTemporaria);

        jMenuMovimentacao.add(jMenu1);
        jMenuMovimentacao.add(jSeparator1);

        PrevisaoSaida.setText("Previsão de Saída de Internos da Unidade");
        PrevisaoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevisaoSaidaActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(PrevisaoSaida);

        jSaidaInternos.setText("Saida de Internos da Unidade");
        jSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaidaInternosActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jSaidaInternos);

        jTransferenciaInternos.setText("Transferência de Internos da Unidade");
        jTransferenciaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTransferenciaInternosActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jTransferenciaInternos);
        jMenuMovimentacao.add(jSeparator20);

        ListaPassagemInternosAlbergados.setText("Lista de Passagem Internos Albergados");
        ListaPassagemInternosAlbergados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemInternosAlbergadosActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(ListaPassagemInternosAlbergados);
        jMenuMovimentacao.add(jSeparator2);

        jAgendamentoEscolta.setText("Agendamento de Escolta e Médicos");
        jAgendamentoEscolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgendamentoEscoltaActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jAgendamentoEscolta);
        jMenuMovimentacao.add(jSeparator13);

        CancelarRegistro.setText("Cancelar Registro Entrada Internos Portaria");
        CancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarRegistroActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(CancelarRegistro);
        jMenuMovimentacao.add(jSeparator15);

        jMenu3.setText("Mudança de Regime Penal");

        MudancaRegimePenalRegressao.setText("Mudança de Regime - Regressão");
        MudancaRegimePenalRegressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MudancaRegimePenalRegressaoActionPerformed(evt);
            }
        });
        jMenu3.add(MudancaRegimePenalRegressao);

        MudancaRegimePenalProgressao.setText("Mudança de Regime - Progressão");
        MudancaRegimePenalProgressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MudancaRegimePenalProgressaoActionPerformed(evt);
            }
        });
        jMenu3.add(MudancaRegimePenalProgressao);

        jMenuMovimentacao.add(jMenu3);
        jMenuMovimentacao.add(jSeparator16);

        EvasaoInternos.setText("Lançamento de Internos Evadidos");
        EvasaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvasaoInternosActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(EvasaoInternos);

        jLancamentoObitoInterno.setForeground(new java.awt.Color(0, 153, 0));
        jLancamentoObitoInterno.setText("Lançamento de Óbito de Internos - Externa");
        jLancamentoObitoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLancamentoObitoInternoActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jLancamentoObitoInterno);
        jMenuMovimentacao.add(jSeparator17);

        jMenuItem4.setText("Cumprimento/Não Cumprimento Alvará");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jMenuItem4);
        jMenuMovimentacao.add(jSeparator29);

        jMenu9.setForeground(new java.awt.Color(204, 0, 0));
        jMenu9.setText("Emissão/Validação do Atestado de Reclusão - Serviço Social/CRC");

        jEmissaoAtestadoReclusao.setForeground(new java.awt.Color(204, 0, 0));
        jEmissaoAtestadoReclusao.setText("Emissão de Atestado de Reclusão Carcerária");
        jEmissaoAtestadoReclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmissaoAtestadoReclusaoActionPerformed(evt);
            }
        });
        jMenu9.add(jEmissaoAtestadoReclusao);

        jValidacaoAtestadoReclusao.setForeground(new java.awt.Color(0, 0, 204));
        jValidacaoAtestadoReclusao.setText("Validação do Atestado de Reclusão Carcerária");
        jValidacaoAtestadoReclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jValidacaoAtestadoReclusaoActionPerformed(evt);
            }
        });
        jMenu9.add(jValidacaoAtestadoReclusao);

        jRevalidarAtestadoReclusao.setForeground(new java.awt.Color(0, 153, 0));
        jRevalidarAtestadoReclusao.setText("Revalidar Atestado de Reclusão (INSS)");
        jRevalidarAtestadoReclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRevalidarAtestadoReclusaoActionPerformed(evt);
            }
        });
        jMenu9.add(jRevalidarAtestadoReclusao);

        jMenuMovimentacao.add(jMenu9);

        jMenu10.setForeground(new java.awt.Color(0, 0, 204));
        jMenu10.setText("Solicitação/Emissão Atestado Reclusão - CRC");

        jSolicitacaoAtestadoReclusaoCRC.setText("Solicitação de Atestado de Reclusão - CRC");
        jSolicitacaoAtestadoReclusaoCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSolicitacaoAtestadoReclusaoCRCActionPerformed(evt);
            }
        });
        jMenu10.add(jSolicitacaoAtestadoReclusaoCRC);

        jEmissaoAtestadoReclusaoCRC.setText("Emissão de Atestado de Reclusão - CRC");
        jEmissaoAtestadoReclusaoCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmissaoAtestadoReclusaoCRCActionPerformed(evt);
            }
        });
        jMenu10.add(jEmissaoAtestadoReclusaoCRC);

        jMenuMovimentacao.add(jMenu10);

        jMenuBar1.add(jMenuMovimentacao);

        jMenuRelatorios.setText("Relatórios");

        RelatorioProntuarios.setText("Relatórios de Prontuários");
        RelatorioProntuarios.setBorderPainted(true);

        ListagemGeralProntuarios.setText("Prontuários de Internos - Geral");
        ListagemGeralProntuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemGeralProntuariosActionPerformed(evt);
            }
        });
        RelatorioProntuarios.add(ListagemGeralProntuarios);

        jMenuItem5.setText("Prontuários de Internos na Unidade");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        RelatorioProntuarios.add(jMenuItem5);

        jMenuRelatorios.add(RelatorioProntuarios);

        RelatorioInternos.setText("Relatórios de Internos");

        RelatorioNaturalidade.setText("Por Naturalidade");
        RelatorioNaturalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioNaturalidadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioNaturalidade);

        RellatorioIdade.setText("Por Idade");
        RellatorioIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RellatorioIdadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RellatorioIdade);

        RelatorioEscolaridade.setText("Por Escolaridade");
        RelatorioEscolaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEscolaridadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioEscolaridade);

        RelInternoEtinia.setText("Por Etnia");
        RelInternoEtinia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelInternoEtiniaActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelInternoEtinia);
        RelatorioInternos.add(jSeparator25);

        PorNCN.setForeground(new java.awt.Color(255, 0, 0));
        PorNCN.setText("Por CNC");
        PorNCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorNCNActionPerformed(evt);
            }
        });
        RelatorioInternos.add(PorNCN);

        RelatorioArtigo.setText("Por Artigo");
        RelatorioArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioArtigoActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioArtigo);

        RelatorioTempoPena.setText("Por Tempo de Pena");
        RelatorioTempoPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioTempoPenaActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioTempoPena);

        RelatorioEstadoCivil.setText("Por Estado Civil");
        RelatorioEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstadoCivilActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioEstadoCivil);

        RelatorioUnidadePenal.setText("Por Unidade Penal");
        RelatorioUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioUnidadePenalActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioUnidadePenal);
        RelatorioInternos.add(jSeparator24);

        RelatorioRegimePenal.setText("Por Regime Penal");
        RelatorioRegimePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRegimePenalActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioRegimePenal);

        RelatorioRegimePenalSexo.setText("Por Regime Penal e Sexo");
        RelatorioRegimePenalSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRegimePenalSexoActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioRegimePenalSexo);

        RelatorioPorSexo.setText("Por Sexo");
        RelatorioPorSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPorSexoActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioPorSexo);
        RelatorioInternos.add(jSeparator19);

        RelatorioPorCidade.setText("Por Cidade");
        RelatorioPorCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPorCidadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioPorCidade);

        RelatorioPorBairro.setText("Por Bairro");
        RelatorioPorBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPorBairroActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioPorBairro);

        jMenuRelatorios.add(RelatorioInternos);

        ListagemCadastroInternos.setText("Listagem de Cadastro de Prontuários");
        ListagemCadastroInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemCadastroInternosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(ListagemCadastroInternos);
        jMenuRelatorios.add(jSeparator22);

        jMenu7.setText("Relatório de Internos sem Documentação");

        CartaoSUS.setText("Internos sem Cartão de SUS");
        CartaoSUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaoSUSActionPerformed(evt);
            }
        });
        jMenu7.add(CartaoSUS);

        RG.setText("Internos sem R.G.");
        RG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGActionPerformed(evt);
            }
        });
        jMenu7.add(RG);

        CPF.setText("Internos sem C.P.F.");
        CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFActionPerformed(evt);
            }
        });
        jMenu7.add(CPF);

        jMenuRelatorios.add(jMenu7);

        jMenu8.setText("Relatório de Documentos de Internos");

        CartaoSUS1.setText("Cartão do SUS");
        CartaoSUS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaoSUS1ActionPerformed(evt);
            }
        });
        jMenu8.add(CartaoSUS1);

        DocumentoRG.setText("R.G.");
        DocumentoRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentoRGActionPerformed(evt);
            }
        });
        jMenu8.add(DocumentoRG);

        DocumentoCPF.setText("C.P.F.");
        DocumentoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentoCPFActionPerformed(evt);
            }
        });
        jMenu8.add(DocumentoCPF);

        jMenuRelatorios.add(jMenu8);
        jMenuRelatorios.add(jSeparator7);

        ListagemInternosUnidadeEntrada.setText("Listagem de Entradas de Internos na Unidade");
        ListagemInternosUnidadeEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemInternosUnidadeEntradaActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(ListagemInternosUnidadeEntrada);
        jMenuRelatorios.add(jSeparator12);

        jMenu2.setText("Relatórios de Previsão de Saidas de Internos");

        RelatorioPrevisaoSaida.setText("Relatório Geral de Previsão de Saída");
        RelatorioPrevisaoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioPrevisaoSaida);

        RelatorioPrevisaoSaidaIntNaoReal.setText("Relatórios de Previsão de Saída de Internos Realizadas");
        RelatorioPrevisaoSaidaIntNaoReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaIntNaoRealActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioPrevisaoSaidaIntNaoReal);

        jMenuRelatorios.add(jMenu2);

        jMenu4.setText("Relatórios de Saída de Internos da Unidade");

        ListagemSaidasTemporaria.setText("Relatório de Saídas Por Beneficio");
        ListagemSaidasTemporaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemSaidasTemporariaActionPerformed(evt);
            }
        });
        jMenu4.add(ListagemSaidasTemporaria);

        RelatorioSaidaInternosPortaria.setText("Relatório de Saída de Internos na Portaria");
        RelatorioSaidaInternosPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioSaidaInternosPortariaActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioSaidaInternosPortaria);
        jMenu4.add(jSeparator23);

        RelatorioHorarioEntradaSaida.setText("Relatório de Horários de Entrada e Saída de Internos");
        RelatorioHorarioEntradaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioHorarioEntradaSaidaActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioHorarioEntradaSaida);

        jMenuRelatorios.add(jMenu4);

        RelatorioMovAdvogadosInternos.setForeground(new java.awt.Color(204, 0, 0));
        RelatorioMovAdvogadosInternos.setText("Relatório de Movimentação de Advogados aos Internos");
        RelatorioMovAdvogadosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioMovAdvogadosInternosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(RelatorioMovAdvogadosInternos);

        RelatorioMovVisitasInternos.setForeground(new java.awt.Color(0, 0, 204));
        RelatorioMovVisitasInternos.setText("Relatório de Movimentação das Visitas Internos");
        RelatorioMovVisitasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioMovVisitasInternosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(RelatorioMovVisitasInternos);
        jMenuRelatorios.add(jSeparator18);

        jRelatorioEvadidos.setText("Listagem de Internos Evadidos");
        jRelatorioEvadidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioEvadidosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jRelatorioEvadidos);
        jMenuRelatorios.add(jSeparator11);

        RelatoriosConfere.setText("Relatórios de Confere");

        MapaConfere.setText("Mapa de Confere");
        MapaConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapaConfereActionPerformed(evt);
            }
        });
        RelatoriosConfere.add(MapaConfere);

        jMenuItem1.setText("Relatório Geral de Internos no Pavilhão/Celas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        RelatoriosConfere.add(jMenuItem1);

        jMenuItem2.setText("Listagem de Confere");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        RelatoriosConfere.add(jMenuItem2);

        jMenuRelatorios.add(RelatoriosConfere);

        RelatorioPopulacaoInternosNominal.setText("Relatório de População de Internos Nominal");
        RelatorioPopulacaoInternosNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPopulacaoInternosNominalActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(RelatorioPopulacaoInternosNominal);
        jMenuRelatorios.add(jSeparator6);

        jListagemPaises.setText("Listagem de Países");
        jListagemPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListagemPaisesActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jListagemPaises);

        jListagemCidade.setText("Listagem de Cidades");
        jListagemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListagemCidadeActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jListagemCidade);
        jMenuRelatorios.add(jSeparator9);

        RelatorioMudancaRegime.setText("Relatório de Mudança de Regime");

        RelProgressao.setText("Relatório de Progressão de Regime Penal");
        RelProgressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelProgressaoActionPerformed(evt);
            }
        });
        RelatorioMudancaRegime.add(RelProgressao);

        RelRegressao.setText("Relatório de Regressão de Regime Penal");
        RelRegressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelRegressaoActionPerformed(evt);
            }
        });
        RelatorioMudancaRegime.add(RelRegressao);

        jMenuRelatorios.add(RelatorioMudancaRegime);
        jMenuRelatorios.add(jSeparator10);

        jListagemUnidadePenal.setText("Listagem de Unidade Penal/Delegacias");
        jListagemUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListagemUnidadePenalActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jListagemUnidadePenal);

        jMenuBar1.add(jMenuRelatorios);

        jMenuUtilitarios.setText("Utilitários");

        jCalculadoraPena.setText("Calculadora de Pena");
        jCalculadoraPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalculadoraPenaActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jCalculadoraPena);

        jCalculadoraWindows.setText("Calculadora do Windows");
        jCalculadoraWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalculadoraWindowsActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jCalculadoraWindows);
        jMenuUtilitarios.add(jSeparator28);

        jMenuItem3.setText("Fechamento de Movimentação de Internos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(jMenuItem3);
        jMenuUtilitarios.add(jSeparator27);

        GerarPopulacaoInternosNominal.setText("Gerar População Nominal");
        GerarPopulacaoInternosNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarPopulacaoInternosNominalActionPerformed(evt);
            }
        });
        jMenuUtilitarios.add(GerarPopulacaoInternosNominal);

        jMenuBar1.add(jMenuUtilitarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelCRC)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelCRC)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCalculadoraPenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalculadoraPenaActionPerformed
        // TODO add your handling code here:
        calcPena();
    }//GEN-LAST:event_jCalculadoraPenaActionPerformed

    private void jCalculadoraWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalculadoraWindowsActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_jCalculadoraWindowsActionPerformed

    private void jEntradaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntradaInternosActionPerformed
        // TODO add your handling code here:
        if (objLote == null || objLote.isClosed()) {
            objLote = new TelaEntradasLote();
            jPainelCRC.add(objLote);
            objLote.setVisible(true);
        } else {
            if (objLote.isVisible()) {
                if (objLote.isIcon()) { // Se esta minimizado
                    try {
                        objLote.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLote.toFront(); // traz para frente
                    objLote.pack();//volta frame 
                }
            } else {
                objLote = new TelaEntradasLote();
                TelaModuloCRC.jPainelCRC.add(objLote);//adicona frame ao JDesktopPane  
                objLote.setVisible(true);
            }
        }
        try {
            objLote.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jEntradaInternosActionPerformed

    private void HistoricoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovimentacaoActionPerformed
        // TODO add your handling code here:
        if (objTelaMov == null || objTelaMov.isClosed()) {
            objTelaMov = new TelaMovimentacaoCrc();
            jPainelCRC.add(objTelaMov);
            objTelaMov.setVisible(true);
        } else {
            if (objTelaMov.isVisible()) {
                if (objTelaMov.isIcon()) { // Se esta minimizado
                    try {
                        objTelaMov.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTelaMov.toFront(); // traz para frente
                    objTelaMov.pack();//volta frame 
                }
            } else {
                objTelaMov = new TelaMovimentacaoCrc();
                TelaModuloCRC.jPainelCRC.add(objTelaMov);//adicona frame ao JDesktopPane  
                objTelaMov.setVisible(true);
            }
        }
        try {
            objTelaMov.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoActionPerformed

    private void jSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaidaInternosActionPerformed
        // TODO add your handling code here:
        if (objSaida == null || objSaida.isClosed()) {
            objSaida = new TelaSaidaInterno();
            jPainelCRC.add(objSaida);
            objSaida.setVisible(true);
        } else {
            if (objSaida.isVisible()) {
                if (objSaida.isIcon()) { // Se esta minimizado
                    try {
                        objSaida.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objSaida.toFront(); // traz para frente
                    objSaida.pack();//volta frame 
                }
            } else {
                objSaida = new TelaSaidaInterno();
                TelaModuloCRC.jPainelCRC.add(objSaida);//adicona frame ao JDesktopPane  
                objSaida.setVisible(true);
            }
        }
        try {
            objSaida.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jSaidaInternosActionPerformed

    private void jTransferenciaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTransferenciaInternosActionPerformed
        // TODO add your handling code here:
        if (objTransf == null || objTransf.isClosed()) {
            objTransf = new TelaTransfInterno();
            jPainelCRC.add(objTransf);
            objTransf.setVisible(true);
        } else {
            if (objTransf.isVisible()) {
                if (objTransf.isIcon()) { // Se esta minimizado
                    try {
                        objTransf.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTransf.toFront(); // traz para frente
                    objTransf.pack();//volta frame 
                }
            } else {
                objTransf = new TelaTransfInterno();
                TelaModuloCRC.jPainelCRC.add(objTransf);//adicona frame ao JDesktopPane  
                objTransf.setVisible(true);
            }
        }
        try {
            objTransf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jTransferenciaInternosActionPerformed

    private void jAgendamentoEscoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgendamentoEscoltaActionPerformed
        // TODO add your handling code here:
        if (objEscolta == null || objEscolta.isClosed()) {
            objEscolta = new TelaAgendaEscolta();
            jPainelCRC.add(objEscolta);
            objEscolta.setVisible(true);
        } else {
            if (objEscolta.isVisible()) {
                if (objEscolta.isIcon()) { // Se esta minimizado
                    try {
                        objEscolta.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEscolta.toFront(); // traz para frente
                    objEscolta.pack();//volta frame 
                }
            } else {
                objEscolta = new TelaAgendaEscolta();
                TelaModuloCRC.jPainelCRC.add(objEscolta);//adicona frame ao JDesktopPane  
                objEscolta.setVisible(true);
            }
        }
        try {
            objEscolta.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jAgendamentoEscoltaActionPerformed

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jLocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalInter == null || objLocalInter.isClosed()) {
            objLocalInter = new TelaConsultaLocalInterno();
            jPainelCRC.add(objLocalInter);
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
                TelaModuloCRC.jPainelCRC.add(objLocalInter);//adicona frame ao JDesktopPane  
                objLocalInter.setVisible(true);
            }
        }
        try {
            objLocalInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jLocalizacaoInternosActionPerformed

    private void jPopulacaoCarcerariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPopulacaoCarcerariaActionPerformed
        // TODO add your handling code here:
        if (objconPop == null || objconPop.isClosed()) {
            objconPop = new TelaConsultaPopulacaoCRC();
            jPainelCRC.add(objconPop);
            objconPop.setVisible(true);
        } else {
            if (objconPop.isVisible()) {
                if (objconPop.isIcon()) { // Se esta minimizado
                    try {
                        objconPop.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objconPop.toFront(); // traz para frente
                    objconPop.pack();//volta frame 
                }
            } else {
                objconPop = new TelaConsultaPopulacaoCRC();
                TelaModuloCRC.jPainelCRC.add(objconPop);//adicona frame ao JDesktopPane  
                objconPop.setVisible(true);
            }
        }
        try {
            objconPop.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jPopulacaoCarcerariaActionPerformed

    private void jProntuariosIntrernosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProntuariosIntrernosActionPerformed
        // TODO add your handling code here:
        if (objTriCrc == null || objTriCrc.isClosed()) {
            objTriCrc = new TelaProntuarioCrc();
            jPainelCRC.add(objTriCrc);
            objTriCrc.setVisible(true);
        } else {
            if (objTriCrc.isVisible()) {
                if (objTriCrc.isIcon()) { // Se esta minimizado
                    try {
                        objTriCrc.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTriCrc.toFront(); // traz para frente
                    objTriCrc.pack();//volta frame 
                }
            } else {
                objTriCrc = new TelaProntuarioCrc();
                TelaModuloCRC.jPainelCRC.add(objTriCrc);//adicona frame ao JDesktopPane  
                objTriCrc.setVisible(true);
            }
        }
        try {
            objTriCrc.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jProntuariosIntrernosActionPerformed

    private void jCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCidadesActionPerformed
        // TODO add your handling code here:
        if (objCidades == null || objCidades.isClosed()) {
            objCidades = new TelaCidades();
            jPainelCRC.add(objCidades);
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
                objCidades = new TelaCidades();
                TelaModuloCRC.jPainelCRC.add(objCidades);//adicona frame ao JDesktopPane  
                objCidades.setVisible(true);
            }
        }
        try {
            objCidades.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jCidadesActionPerformed

    private void jPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaisesActionPerformed
        // TODO add your handling code here:
        if (objPais == null || objPais.isClosed()) {
            objPais = new TelaPaises();
            jPainelCRC.add(objPais);
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
                objPais = new TelaPaises();
                TelaModuloCRC.jPainelCRC.add(objPais);//adicona frame ao JDesktopPane  
                objPais.setVisible(true);
            }
        }
        try {
            objPais.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jPaisesActionPerformed

    private void jUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnidadePenalActionPerformed
        // TODO add your handling code here:    
        if (objUnP == null || objUnP.isClosed()) {
            objUnP = new TelaUnidadePenal();
            jPainelCRC.add(objUnP);
            objUnP.setVisible(true);
        } else {
            if (objUnP.isVisible()) {
                if (objUnP.isIcon()) { // Se esta minimizado
                    try {
                        objUnP.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objUnP.toFront(); // traz para frente
                    objUnP.pack();//volta frame 
                }
            } else {
                objUnP = new TelaUnidadePenal();
                TelaModuloCRC.jPainelCRC.add(objUnP);//adicona frame ao JDesktopPane  
                objUnP.setVisible(true);
            }
        }
        try {
            objUnP.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jUnidadePenalActionPerformed

    private void jTipoOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoOperacaoActionPerformed
        // TODO add your handling code here:
        if (objTop == null || objTop.isClosed()) {
            objTop = new TelaOperacaoCrc();
            jPainelCRC.add(objTop);
            objTop.setVisible(true);
        } else {
            if (objTop.isVisible()) {
                if (objTop.isIcon()) { // Se esta minimizado
                    try {
                        objTop.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTop.toFront(); // traz para frente
                    objTop.pack();//volta frame 
                }
            } else {
                objTop = new TelaOperacaoCrc();
                TelaModuloCRC.jPainelCRC.add(objTop);//adicona frame ao JDesktopPane  
                objTop.setVisible(true);
            }
        }
        try {
            objTop.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jTipoOperacaoActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objRecados == null || objRecados.isClosed()) {
            objRecados = new TelaRecadosCrc();
            jPainelCRC.add(objRecados);
            objRecados.setVisible(true);
        } else {
            if (objRecados.isVisible()) {
                if (objRecados.isIcon()) { // Se esta minimizado
                    try {
                        objRecados.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecados.toFront(); // traz para frente
                    objRecados.pack();//volta frame 
                }
            } else {
                objRecados = new TelaRecadosCrc();
                TelaModuloCRC.jPainelCRC.add(objRecados);//adicona frame ao JDesktopPane  
                objRecados.setVisible(true);
            }
        }
        try {
            objRecados.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void ListagemGeralProntuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemGeralProntuariosActionPerformed
        // TODO add your handling code here:   r 
//        TelaGerarRelatorio gr = new TelaGerarRelatorio();
//        TelaModuloCRC.jPainelCRC.add(gr);
//        gr.show();
        try {
            conecta.abrirConexao();
            String path = "reports/ProntuariosInternosCrc.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES "
                    + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE "
                    + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmho do relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Prontuário de Internos"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListagemGeralProntuariosActionPerformed

    private void ListagemInternosUnidadeEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemInternosUnidadeEntradaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntrada = new TelaRelatorioEntradas();
        TelaModuloCRC.jPainelCRC.add(objRelEntrada);
        objRelEntrada.show();
    }//GEN-LAST:event_ListagemInternosUnidadeEntradaActionPerformed

    private void ListagemSaidasTemporariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemSaidasTemporariaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidas objRelaSaidas = new TelaRelatorioSaidas();
        TelaModuloCRC.jPainelCRC.add(objRelaSaidas);
        objRelaSaidas.show();
    }//GEN-LAST:event_ListagemSaidasTemporariaActionPerformed

    private void RetornoRecapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoRecapturaActionPerformed
        // TODO add your handling code here:        
        if (objRetCap == null || objRetCap.isClosed()) {
            objRetCap = new TelaRetornoRecaptura();
            jPainelCRC.add(objRetCap);
            objRetCap.setVisible(true);
        } else {
            if (objRetCap.isVisible()) {
                if (objRetCap.isIcon()) { // Se esta minimizado
                    try {
                        objRetCap.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRetCap.toFront(); // traz para frente
                    objRetCap.pack();//volta frame 
                }
            } else {
                objRetCap = new TelaRetornoRecaptura();
                TelaModuloCRC.jPainelCRC.add(objRetCap);//adicona frame ao JDesktopPane  
                objRetCap.setVisible(true);
            }
        }
        try {
            objRetCap.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RetornoRecapturaActionPerformed

    private void RelatorioNaturalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioNaturalidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioNaturalidade objRelNat = new TelaRelatorioNaturalidade();
        TelaModuloCRC.jPainelCRC.add(objRelNat);
        objRelNat.show();
    }//GEN-LAST:event_RelatorioNaturalidadeActionPerformed

    private void RellatorioIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RellatorioIdadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPorIdade objIdade = new TelaRelatorioPorIdade();
        TelaModuloCRC.jPainelCRC.add(objIdade);
        objIdade.show();
    }//GEN-LAST:event_RellatorioIdadeActionPerformed

    private void jListagemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListagemCidadeActionPerformed
        // TODO add your handling code here:        
        try {
            conecta.abrirConexao();
            String path = "reports/relatorioCidades.jasper";
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
    }//GEN-LAST:event_jListagemCidadeActionPerformed

    private void jListagemUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListagemUnidadePenalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioUnidadePenal.jasper";
            conecta.executaSQL("SELECT * FROM UNIDADE ORDER BY DescricaoUnid");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Unidade Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jListagemUnidadePenalActionPerformed

    private void jListagemPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListagemPaisesActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPaises.jasper";
            conecta.executaSQL("SELECT * FROM PAISES ORDER BY NomePais");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Países");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jListagemPaisesActionPerformed

    private void ListagemCadastroInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemCadastroInternosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemCadastroPronturarioInternos.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Cadastro de Internos na Unidade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListagemCadastroInternosActionPerformed

    private void RelatorioEscolaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEscolaridadeActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosEscolaridade.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + statusRetorno + "' "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("situacaoEnt", statusEntrada);
            parametros.put("situacaoRet", statusRetorno);
            parametros.put("unidadePenal", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Internos por Escolaridade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioEscolaridadeActionPerformed

    private void RelatorioArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioArtigoActionPerformed
        // TODO add your handling code here:
        RelatorioArtigo objRelTempPena = new RelatorioArtigo();
        TelaModuloCRC.jPainelCRC.add((objRelTempPena));
        objRelTempPena.show();
    }//GEN-LAST:event_RelatorioArtigoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TelaFechamentoCrc objFechaCrc = new TelaFechamentoCrc();
        TelaModuloCRC.jPainelCRC.add(objFechaCrc);
        objFechaCrc.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void RelatorioRegimePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRegimePenalActionPerformed
        // TODO add your handling code here:
        // Remodelar esse relatório com o regime e sexo dos internos. (Feito em 26/11/2014)
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
    }//GEN-LAST:event_RelatorioRegimePenalActionPerformed

    private void RelatorioEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstadoCivilActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosEstadoCivil.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + statusEntrada + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + statusRetorno + "' "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("situacaoEnt", statusEntrada);
            parametros.put("situacaoRet", statusRetorno);
            parametros.put("descricaoUnidade", descricaoUnidade);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos Por Estado Civil");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioEstadoCivilActionPerformed

    private void RelatorioUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioUnidadePenalActionPerformed
        // TODO add your handling code here:
        RelatorioUnidadePenal objRelUnidade = new RelatorioUnidadePenal();
        TelaModuloCRC.jPainelCRC.add(objRelUnidade);
        objRelUnidade.show();
    }//GEN-LAST:event_RelatorioUnidadePenalActionPerformed

    private void RelatorioTempoPenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioTempoPenaActionPerformed
        // TODO add your handling code here:
        RelatorioTempoPena objRelTempoPena = new RelatorioTempoPena();
        TelaModuloCRC.jPainelCRC.add(objRelTempoPena);
        objRelTempoPena.show();
    }//GEN-LAST:event_RelatorioTempoPenaActionPerformed

    private void RetornoEspontaneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoEspontaneoActionPerformed
        // TODO add your handling code here:
        if (objRetornoEspontaneo == null || objRetornoEspontaneo.isClosed()) {
            objRetornoEspontaneo = new TelaRetornoEspontaneo();
            jPainelCRC.add(objRetornoEspontaneo);
            objRetornoEspontaneo.setVisible(true);
        } else {
            if (objRetornoEspontaneo.isVisible()) {
                if (objRetornoEspontaneo.isIcon()) { // Se esta minimizado
                    try {
                        objRetornoEspontaneo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRetornoEspontaneo.toFront(); // traz para frente
                    objRetornoEspontaneo.pack();//volta frame 
                }
            } else {
                objRetornoEspontaneo = new TelaRetornoEspontaneo();
                TelaModuloCRC.jPainelCRC.add(objLote);//adicona frame ao JDesktopPane  
                objRetornoEspontaneo.setVisible(true);
            }
        }
        try {
            objRetornoEspontaneo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RetornoEspontaneoActionPerformed

    private void jRelatorioEvadidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioEvadidosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioDataEvasao objRelIntEvadidos = new TelaRelatorioDataEvasao();
        TelaModuloCRC.jPainelCRC.add(objRelIntEvadidos);
        objRelIntEvadidos.show();
    }//GEN-LAST:event_jRelatorioEvadidosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ProntuariosInternosUnidadePenalCRC.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES ON PRONTUARIOSCRC.IdPais=PAISES.IdPais INNER JOIN CIDADES ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "'ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Prontuário de Internos na Unidade"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void RetornoSaidaTemporariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoSaidaTemporariaActionPerformed
        // TODO add your handling code here:      
        if (objRetorno == null || objRetorno.isClosed()) {
            objRetorno = new TelaRetornoInterno();
            jPainelCRC.add(objRetorno);
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
                objRetorno = new TelaRetornoInterno();
                TelaModuloCRC.jPainelCRC.add(objRetorno);//adicona frame ao JDesktopPane  
                objRetorno.setVisible(true);
            }
        }
        try {
            objRetorno.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RetornoSaidaTemporariaActionPerformed

    private void RetornoAudienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoAudienciaActionPerformed
        // TODO add your handling code here:
        if (objRetornoAud == null || objRetornoAud.isClosed()) {
            objRetornoAud = new TelaRetornoAudiencia();
            jPainelCRC.add(objRetornoAud);
            objRetornoAud.setVisible(true);
        } else {
            if (objRetornoAud.isVisible()) {
                if (objRetornoAud.isIcon()) { // Se esta minimizado
                    try {
                        objRetornoAud.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRetornoAud.toFront(); // traz para frente
                    objRetornoAud.pack();//volta frame 
                }
            } else {
                objRetornoAud = new TelaRetornoAudiencia();
                TelaModuloCRC.jPainelCRC.add(objRetornoAud);//adicona frame ao JDesktopPane  
                objRetornoAud.setVisible(true);
            }
        }
        try {
            objRetornoAud.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RetornoAudienciaActionPerformed

    private void PrevisaoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevisaoSaidaActionPerformed
        // TODO add your handling code here:
        if (objRevSaida == null || objRevSaida.isClosed()) {
            objRevSaida = new TelaPrevisaoSaidaInternos();
            jPainelCRC.add(objRevSaida);
            objRevSaida.setVisible(true);
        } else {
            if (objRevSaida.isVisible()) {
                if (objRevSaida.isIcon()) { // Se esta minimizado
                    try {
                        objRevSaida.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRevSaida.toFront(); // traz para frente
                    objRevSaida.pack();//volta frame 
                }
            } else {
                objRevSaida = new TelaPrevisaoSaidaInternos();
                TelaModuloCRC.jPainelCRC.add(objRevSaida);//adicona frame ao JDesktopPane  
                objRevSaida.setVisible(true);
            }
        }
        try {
            objRevSaida.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_PrevisaoSaidaActionPerformed

    private void RelatorioPrevisaoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaCrc objRelPrevSai = new TelaRelatorioPrevisaoSaidaCrc();
        TelaModuloCRC.jPainelCRC.add(objRelPrevSai);
        objRelPrevSai.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaActionPerformed

    private void RelatorioPrevisaoSaidaIntNaoRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaIntNaoRealActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaDivCrc objRelPrevSaiIntDiv = new TelaRelatorioPrevisaoSaidaDivCrc();
        TelaModuloCRC.jPainelCRC.add(objRelPrevSaiIntDiv);
        objRelPrevSaiIntDiv.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaIntNaoRealActionPerformed

    private void CancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarRegistroActionPerformed
        // TODO add your handling code here:
        if (objCanRegPort == null || objCanRegPort.isClosed()) {
            objCanRegPort = new TelaCancelRegistroPortaria();
            jPainelCRC.add(objCanRegPort);
            objCanRegPort.setVisible(true);
        } else {
            if (objCanRegPort.isVisible()) {
                if (objCanRegPort.isIcon()) { // Se esta minimizado
                    try {
                        objCanRegPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCanRegPort.toFront(); // traz para frente
                    objCanRegPort.pack();//volta frame 
                }
            } else {
                objCanRegPort = new TelaCancelRegistroPortaria();
                TelaModuloCRC.jPainelCRC.add(objCanRegPort);//adicona frame ao JDesktopPane  
                objCanRegPort.setVisible(true);
            }
        }
        try {
            objCanRegPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_CancelarRegistroActionPerformed

    private void MapaConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapaConfereActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereCrc mappopc = new TelaRelMapaConfereCrc();
        TelaModuloCRC.jPainelCRC.add(mappopc);
        mappopc.show();
    }//GEN-LAST:event_MapaConfereActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
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
            parametros.put("descricaoUnidade", descricaoUnidade);
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere relConf = new TelaRelatorioConfere();
        TelaModuloCRC.jPainelCRC.add(relConf);
        relConf.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void GerarPopulacaoInternosNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarPopulacaoInternosNominalActionPerformed
        // TODO add your handling code here:
        TelaGerarPopulacaoNominalCrc objPopNomCrc = new TelaGerarPopulacaoNominalCrc();
        TelaModuloCRC.jPainelCRC.add(objPopNomCrc);
        objPopNomCrc.show();
    }//GEN-LAST:event_GerarPopulacaoInternosNominalActionPerformed

    private void RelatorioPopulacaoInternosNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPopulacaoInternosNominalActionPerformed
        // TODO add your handling code here:        
        TelaRelPopulacaoInternosNominal objRelPop = new TelaRelPopulacaoInternosNominal();
        TelaModuloCRC.jPainelCRC.add(objRelPop);
        objRelPop.show();
    }//GEN-LAST:event_RelatorioPopulacaoInternosNominalActionPerformed

    private void RetornoSaidaMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoSaidaMedicoActionPerformed
        // TODO add your handling code here:
        if (objRetMedico == null || objRetMedico.isClosed()) {
            objRetMedico = new TelaRetornoMedico();
            jPainelCRC.add(objRetMedico);
            objRetMedico.setVisible(true);
        } else {
            if (objRetMedico.isVisible()) {
                if (objRetMedico.isIcon()) { // Se esta minimizado
                    try {
                        objRetMedico.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRetMedico.toFront(); // traz para frente
                    objRetMedico.pack();//volta frame 
                }
            } else {
                objRetMedico = new TelaRetornoMedico();
                TelaModuloCRC.jPainelCRC.add(objRetMedico);//adicona frame ao JDesktopPane  
                objRetMedico.setVisible(true);
            }
        }
        try {
            objRetMedico.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RetornoSaidaMedicoActionPerformed

    private void RetornoInternosPorTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetornoInternosPorTransferenciaActionPerformed
        // TODO add your handling code here:
        if (objRetPorTrans == null || objRetPorTrans.isClosed()) {
            objRetPorTrans = new TelaRetornoPorTransferencia();
            jPainelCRC.add(objRetPorTrans);
            objRetPorTrans.setVisible(true);
        } else {
            if (objRetPorTrans.isVisible()) {
                if (objRetPorTrans.isIcon()) { // Se esta minimizado
                    try {
                        objRetPorTrans.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRetPorTrans.toFront(); // traz para frente
                    objRetPorTrans.pack();//volta frame 
                }
            } else {
                objRetPorTrans = new TelaRetornoPorTransferencia();
                TelaModuloCRC.jPainelCRC.add(objRetPorTrans);//adicona frame ao JDesktopPane  
                objRetPorTrans.setVisible(true);
            }
        }
        try {
            objRetPorTrans.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RetornoInternosPorTransferenciaActionPerformed

    private void MudancaRegimePenalRegressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MudancaRegimePenalRegressaoActionPerformed
        // TODO add your handling code here:
        if (objMudaRegimePro == null || objMudaRegimePro.isClosed()) {
            objMudaRegimePro = new TelaMudancaRegimeRegressao();
            jPainelCRC.add(objMudaRegimePro);
            objMudaRegimePro.setVisible(true);
        } else {
            if (objMudaRegimePro.isVisible()) {
                if (objMudaRegimePro.isIcon()) { // Se esta minimizado
                    try {
                        objMudaRegimePro.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMudaRegimePro.toFront(); // traz para frente
                    objMudaRegimePro.pack();//volta frame 
                }
            } else {
                objMudaRegimePro = new TelaMudancaRegimeRegressao();
                TelaModuloCRC.jPainelCRC.add(objMudaRegimePro);//adicona frame ao JDesktopPane  
                objMudaRegimePro.setVisible(true);
            }
        }
        try {
            objMudaRegimePro.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_MudancaRegimePenalRegressaoActionPerformed

    private void MudancaRegimePenalProgressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MudancaRegimePenalProgressaoActionPerformed
        // TODO add your handling code here:       
        if (objMudaRegimeProgressao == null || objMudaRegimeProgressao.isClosed()) {
            objMudaRegimeProgressao = new TelaMudancaRegimeProgressao();
            jPainelCRC.add(objMudaRegimeProgressao);
            objMudaRegimeProgressao.setVisible(true);
        } else {
            if (objMudaRegimeProgressao.isVisible()) {
                if (objMudaRegimeProgressao.isIcon()) { // Se esta minimizado
                    try {
                        objMudaRegimeProgressao.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMudaRegimeProgressao.toFront(); // traz para frente
                    objMudaRegimeProgressao.pack();//volta frame 
                }
            } else {
                objMudaRegimeProgressao = new TelaMudancaRegimeProgressao();
                TelaModuloCRC.jPainelCRC.add(objMudaRegimeProgressao);//adicona frame ao JDesktopPane  
                objMudaRegimeProgressao.setVisible(true);
            }
        }
        try {
            objMudaRegimeProgressao.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_MudancaRegimePenalProgressaoActionPerformed

    private void RelProgressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelProgressaoActionPerformed
        // TODO add your handling code here:  
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioMudancaRegimeProgressao.jasper";
            conecta.executaSQL("SELECT * FROM SENTENCAS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SENTENCAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSPROGRESSAOREGIME "
                    + "ON SENTENCAS.IdInternoCrc=ITENSPROGRESSAOREGIME.IdInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Mudança de Regime Prisional de Internos - PROGRESSÃO");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
        conecta.desconecta();
    }//GEN-LAST:event_RelProgressaoActionPerformed

    private void RelRegressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelRegressaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioMudancaRegimeRegressao.jasper";
            conecta.executaSQL("SELECT * FROM SENTENCAS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SENTENCAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSREGRESSAOREGIME "
                    + "ON SENTENCAS.IdInternoCrc=ITENSREGRESSAOREGIME.IdInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Mudança de Regime Prisional de Internos - REGRESSÃO");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
        conecta.desconecta();
    }//GEN-LAST:event_RelRegressaoActionPerformed

    private void EvasaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvasaoInternosActionPerformed
        // TODO add your handling code here:
        if (objEvasaoManual == null || objEvasaoManual.isClosed()) {
            objEvasaoManual = new TelaEvadidosSaidaTemporariaManual();
            jPainelCRC.add(objEvasaoManual);
            objEvasaoManual.setVisible(true);
        } else {
            if (objEvasaoManual.isVisible()) {
                if (objEvasaoManual.isIcon()) { // Se esta minimizado
                    try {
                        objEvasaoManual.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEvasaoManual.toFront(); // traz para frente
                    objEvasaoManual.pack();//volta frame 
                }
            } else {
                objEvasaoManual = new TelaEvadidosSaidaTemporariaManual();
                TelaModuloCRC.jPainelCRC.add(objEvasaoManual);//adicona frame ao JDesktopPane  
                objEvasaoManual.setVisible(true);
            }
        }
        try {
            objEvasaoManual.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EvasaoInternosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (objNaoAlvara == null || objNaoAlvara.isClosed()) {
            objNaoAlvara = new TelaNaoCumprimentoAlvara();
            jPainelCRC.add(objNaoAlvara);
            objNaoAlvara.setVisible(true);
        } else {
            if (objNaoAlvara.isVisible()) {
                if (objNaoAlvara.isIcon()) { // Se esta minimizado
                    try {
                        objNaoAlvara.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objNaoAlvara.toFront(); // traz para frente
                    objNaoAlvara.pack();//volta frame 
                }
            } else {
                objNaoAlvara = new TelaNaoCumprimentoAlvara();
                TelaModuloCRC.jPainelCRC.add(objNaoAlvara);//adicona frame ao JDesktopPane  
                objNaoAlvara.setVisible(true);
            }
        }
        try {
            objNaoAlvara.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void RelatorioPorCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPorCidadeActionPerformed
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
    }//GEN-LAST:event_RelatorioPorCidadeActionPerformed

    private void RelatorioPorBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPorBairroActionPerformed
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
    }//GEN-LAST:event_RelatorioPorBairroActionPerformed

    private void RelatorioSaidaInternosPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioSaidaInternosPortariaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidaInternosPorData objRelaSaidaPort = new TelaRelatorioSaidaInternosPorData();
        TelaModuloCRC.jPainelCRC.add(objRelaSaidaPort);
        objRelaSaidaPort.show();
    }//GEN-LAST:event_RelatorioSaidaInternosPortariaActionPerformed

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelCRC.add(objAgEventos);
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
                TelaModuloCRC.jPainelCRC.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void ConsultaEvasaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaEvasaoInternosActionPerformed
        // TODO add your handling code here:
        if (objConIntEvadidos == null || objConIntEvadidos.isClosed()) {
            objConIntEvadidos = new TelaConsultaInternosEvadidos();
            jPainelCRC.add(objConIntEvadidos);
            objConIntEvadidos.setVisible(true);
        } else {
            if (objConIntEvadidos.isVisible()) {
                if (objConIntEvadidos.isIcon()) { // Se esta minimizado
                    try {
                        objConIntEvadidos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConIntEvadidos.toFront(); // traz para frente
                    objConIntEvadidos.pack();//volta frame 
                }
            } else {
                objConIntEvadidos = new TelaConsultaInternosEvadidos();
                TelaModuloCRC.jPainelCRC.add(objConIntEvadidos);//adicona frame ao JDesktopPane  
                objConIntEvadidos.setVisible(true);
            }
        }
        try {
            objConIntEvadidos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaEvasaoInternosActionPerformed

    private void CartaoSUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaoSUSActionPerformed
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
    }//GEN-LAST:event_CartaoSUSActionPerformed

    private void ListaPassagemInternosAlbergadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemInternosAlbergadosActionPerformed
        // TODO add your handling code here:
        if (objListaPassaAlberg == null || objListaPassaAlberg.isClosed()) {
            objListaPassaAlberg = new TelaListaPassagemInternosAlbergados();
            jPainelCRC.add(objListaPassaAlberg);
            objListaPassaAlberg.setVisible(true);
        } else {
            if (objListaPassaAlberg.isVisible()) {
                if (objListaPassaAlberg.isIcon()) { // Se esta minimizado
                    try {
                        objListaPassaAlberg.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objListaPassaAlberg.toFront(); // traz para frente
                    objListaPassaAlberg.pack();//volta frame 
                }
            } else {
                objListaPassaAlberg = new TelaListaPassagemInternosAlbergados();
                TelaModuloCRC.jPainelCRC.add(objListaPassaAlberg);//adicona frame ao JDesktopPane  
                objListaPassaAlberg.setVisible(true);
            }
        }
        try {
            objListaPassaAlberg.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ListaPassagemInternosAlbergadosActionPerformed

    private void RelatorioRegimePenalSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRegimePenalSexoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioInternoRegimeSexo objRelInt = new TelaRelatorioInternoRegimeSexo();
        TelaModuloCRC.jPainelCRC.add(objRelInt);
        objRelInt.show();
    }//GEN-LAST:event_RelatorioRegimePenalSexoActionPerformed

    private void RelatorioPorSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPorSexoActionPerformed
        // TODO add your handling code here
        TelaRelatorioInternoPorSexo objRelIntSexo = new TelaRelatorioInternoPorSexo();
        TelaModuloCRC.jPainelCRC.add(objRelIntSexo);
        objRelIntSexo.show();
    }//GEN-LAST:event_RelatorioPorSexoActionPerformed

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

    private void CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosSemCartaoCPF.jasper";
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
            jv.setTitle("Listagem de Internos sem CPF");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_CPFActionPerformed

    private void CartaoSUS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaoSUS1ActionPerformed
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
    }//GEN-LAST:event_CartaoSUS1ActionPerformed

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
            jv.setTitle("Listagem de Internos com C.P.F.");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_DocumentoCPFActionPerformed

    private void RelatorioHorarioEntradaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioHorarioEntradaSaidaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaPorHorario objRelaSaidaPortHora = new TelaRelatorioEntradaSaidaPorHorario();
        TelaModuloCRC.jPainelCRC.add(objRelaSaidaPortHora);
        objRelaSaidaPortHora.show();
    }//GEN-LAST:event_RelatorioHorarioEntradaSaidaActionPerformed

    private void PorNCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorNCNActionPerformed
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
    }//GEN-LAST:event_PorNCNActionPerformed

    private void jLancamentoObitoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLancamentoObitoInternoActionPerformed
        // TODO add your handling code here:
        if (objObito == null || objObito.isClosed()) {
            objObito = new TelaObitoInternoExterna();
            jPainelCRC.add(objObito);
            objObito.setVisible(true);
        } else {
            if (objObito.isVisible()) {
                if (objObito.isIcon()) { // Se esta minimizado
                    try {
                        objObito.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objObito.toFront(); // traz para frente
                    objObito.pack();//volta frame 
                }
            } else {
                objObito = new TelaObitoInternoExterna();
                TelaModuloCRC.jPainelCRC.add(objObito);//adicona frame ao JDesktopPane  
                objObito.setVisible(true);
            }
        }
        try {
            objObito.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jLancamentoObitoInternoActionPerformed

    private void RelInternoEtiniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelInternoEtiniaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioInternosEtnia objRelET = new TelaRelatorioInternosEtnia();
        TelaModuloCRC.jPainelCRC.add(objRelET);
        objRelET.show();
    }//GEN-LAST:event_RelInternoEtiniaActionPerformed

    private void jConsultaGeralInternosExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaGeralInternosExternaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaConsultaGerencialInternosExternaCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaConsultaGerencialInternosExternaCRC) && codAbrirCRC == 1) {
            if (objConsultaGIU == null || objConsultaGIU.isClosed()) {
                objConsultaGIU = new ConsultaGerencialInternosUnidade();
                jPainelCRC.add(objConsultaGIU);
                objConsultaGIU.setVisible(true);
            } else {
                if (objConsultaGIU.isVisible()) {
                    if (objConsultaGIU.isIcon()) { // Se esta minimizado
                        try {
                            objConsultaGIU.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objConsultaGIU.toFront(); // traz para frente
                        objConsultaGIU.pack();//volta frame 
                    }
                } else {
                    objConsultaGIU = new ConsultaGerencialInternosUnidade();
                    TelaModuloCRC.jPainelCRC.add(objConsultaGIU);//adicona frame ao JDesktopPane  
                    objConsultaGIU.setVisible(true);
                }
            }
            try {
                objConsultaGIU.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jConsultaGeralInternosExternaActionPerformed

    private void RelatorioMovAdvogadosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioMovAdvogadosInternosActionPerformed
        // TODO add your handling code here:
        TelaRelMovimentacaoAdvogadosInterno objRelMovAdv = new TelaRelMovimentacaoAdvogadosInterno();
        TelaModuloCRC.jPainelCRC.add(objRelMovAdv);
        objRelMovAdv.show();
    }//GEN-LAST:event_RelatorioMovAdvogadosInternosActionPerformed

    private void RelatorioMovVisitasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioMovVisitasInternosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RolVisitasMasEndereco.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ROLVISITAS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ROLVISITAS.IdInternoCrc "
                    + "INNER JOIN ITENSROL "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSROL.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ITENSROL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc LIKE '" + situacaoEnt + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc LIKE '" + situacaoRet + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("descricaoUnidade", descricaoUnidade);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Visitas aos Internos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado             
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioMovVisitasInternosActionPerformed

    private void jEmissaoAtestadoReclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmissaoAtestadoReclusaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmissaoAtestadoReclusao);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaEmissaoAtestadoReclusao) && codAbrirCRC == 1) {
            if (objAtestadoRec == null || objAtestadoRec.isClosed()) {
                objAtestadoRec = new TelaEmissaoAtestadoReclusao();
                jPainelCRC.add(objAtestadoRec);
                objAtestadoRec.setVisible(true);
            } else {
                if (objAtestadoRec.isVisible()) {
                    if (objAtestadoRec.isIcon()) { // Se esta minimizado
                        try {
                            objAtestadoRec.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtestadoRec.toFront(); // traz para frente
                        objAtestadoRec.pack();//volta frame 
                    }
                } else {
                    objAtestadoRec = new TelaEmissaoAtestadoReclusao();
                    TelaModuloCRC.jPainelCRC.add(objAtestadoRec);//adicona frame ao JDesktopPane  
                    objAtestadoRec.setVisible(true);
                }
            }
            try {
                objAtestadoRec.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEmissaoAtestadoReclusaoActionPerformed

    private void jValidacaoAtestadoReclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jValidacaoAtestadoReclusaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(validadorAtestadoCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(validadorAtestadoCRC) && codAbrirCRC == 1) {
            if (objValidaAtestado == null || objValidaAtestado.isClosed()) {
                objValidaAtestado = new TelaValidadorAtestadoReclusao();
                jPainelCRC.add(objValidaAtestado);
                objValidaAtestado.setVisible(true);
            } else {
                if (objValidaAtestado.isVisible()) {
                    if (objValidaAtestado.isIcon()) { // Se esta minimizado
                        try {
                            objValidaAtestado.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objValidaAtestado.toFront(); // traz para frente
                        objValidaAtestado.pack();//volta frame 
                    }
                } else {
                    objValidaAtestado = new TelaValidadorAtestadoReclusao();
                    TelaModuloCRC.jPainelCRC.add(objValidaAtestado);//adicona frame ao JDesktopPane  
                    objValidaAtestado.setVisible(true);
                }
            }
            try {
                objValidaAtestado.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jValidacaoAtestadoReclusaoActionPerformed

    private void jRevalidarAtestadoReclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRevalidarAtestadoReclusaoActionPerformed
        // TODO add your handling code here:TelaRevalidacaoAtestadoReclusao
        buscarAcessoUsuario(validadorAtestadoCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(validadorAtestadoCRC) && codAbrirCRC == 1) {
            if (objAtestadoValidaAtestado == null || objAtestadoValidaAtestado.isClosed()) {
                objAtestadoValidaAtestado = new TelaRevalidacaoAtestadoReclusao();
                jPainelCRC.add(objAtestadoValidaAtestado);
                objAtestadoValidaAtestado.setVisible(true);
            } else {
                if (objAtestadoValidaAtestado.isVisible()) {
                    if (objAtestadoValidaAtestado.isIcon()) { // Se esta minimizado
                        try {
                            objAtestadoValidaAtestado.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtestadoValidaAtestado.toFront(); // traz para frente
                        objAtestadoValidaAtestado.pack();//volta frame 
                    }
                } else {
                    objAtestadoValidaAtestado = new TelaRevalidacaoAtestadoReclusao();
                    TelaModuloCRC.jPainelCRC.add(objAtestadoValidaAtestado);//adicona frame ao JDesktopPane  
                    objAtestadoValidaAtestado.setVisible(true);
                }
            }
            try {
                objAtestadoValidaAtestado.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRevalidarAtestadoReclusaoActionPerformed

    private void jSolicitacaoAtestadoReclusaoCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSolicitacaoAtestadoReclusaoCRCActionPerformed
        // TODO add your handling code here:TelaSolicitacaoAuxilioReclusaoCRC
        buscarAcessoUsuario(solicitaAtestaReclusoCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(solicitaAtestaReclusoCRC) && codAbrirCRC == 1) {
            if (objSolicitaAtestaRec == null || objSolicitaAtestaRec.isClosed()) {
                objSolicitaAtestaRec = new TelaSolicitacaoAuxilioReclusaoCRC();
                jPainelCRC.add(objSolicitaAtestaRec);
                objSolicitaAtestaRec.setVisible(true);
            } else {
                if (objSolicitaAtestaRec.isVisible()) {
                    if (objSolicitaAtestaRec.isIcon()) { // Se esta minimizado
                        try {
                            objSolicitaAtestaRec.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSolicitaAtestaRec.toFront(); // traz para frente
                        objSolicitaAtestaRec.pack();//volta frame 
                    }
                } else {
                    objSolicitaAtestaRec = new TelaSolicitacaoAuxilioReclusaoCRC();
                    TelaModuloCRC.jPainelCRC.add(objSolicitaAtestaRec);//adicona frame ao JDesktopPane  
                    objSolicitaAtestaRec.setVisible(true);
                }
            }
            try {
                objSolicitaAtestaRec.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jSolicitacaoAtestadoReclusaoCRCActionPerformed

    private void jEmissaoAtestadoReclusaoCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmissaoAtestadoReclusaoCRCActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(emissaoAtestaRecCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(emissaoAtestaRecCRC) && codAbrirCRC == 1) {
            if (objEmissaoARC == null || objEmissaoARC.isClosed()) {
                objEmissaoARC = new TelaEmissaoAtestadoReclusaoCRC();
                jPainelCRC.add(objEmissaoARC);
                objEmissaoARC.setVisible(true);
            } else {
                if (objEmissaoARC.isVisible()) {
                    if (objEmissaoARC.isIcon()) { // Se esta minimizado
                        try {
                            objEmissaoARC.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEmissaoARC.toFront(); // traz para frente
                        objEmissaoARC.pack();//volta frame 
                    }
                } else {
                    objEmissaoARC = new TelaEmissaoAtestadoReclusaoCRC();
                    TelaModuloCRC.jPainelCRC.add(objEmissaoARC);//adicona frame ao JDesktopPane  
                    objEmissaoARC.setVisible(true);
                }
            }
            try {
                objEmissaoARC.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEmissaoAtestadoReclusaoCRCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem CPF;
    private javax.swing.JMenuItem CancelarRegistro;
    private javax.swing.JMenuItem CartaoSUS;
    private javax.swing.JMenuItem CartaoSUS1;
    private javax.swing.JMenuItem ConsultaEvasaoInternos;
    private javax.swing.JMenuItem DocumentoCPF;
    private javax.swing.JMenuItem DocumentoRG;
    private javax.swing.JMenuItem EvasaoInternos;
    private javax.swing.JMenuItem GerarPopulacaoInternosNominal;
    private javax.swing.JMenuItem HistoricoMovimentacao;
    private javax.swing.JMenuItem ListaPassagemInternosAlbergados;
    private javax.swing.JMenuItem ListagemCadastroInternos;
    private javax.swing.JMenuItem ListagemGeralProntuarios;
    private javax.swing.JMenuItem ListagemInternosUnidadeEntrada;
    private javax.swing.JMenuItem ListagemSaidasTemporaria;
    private javax.swing.JMenuItem MapaConfere;
    private javax.swing.JMenuItem MudancaRegimePenalProgressao;
    private javax.swing.JMenuItem MudancaRegimePenalRegressao;
    private javax.swing.JMenuItem PorNCN;
    private javax.swing.JMenuItem PrevisaoSaida;
    private javax.swing.JMenuItem RG;
    private javax.swing.JMenuItem RelInternoEtinia;
    private javax.swing.JMenuItem RelProgressao;
    private javax.swing.JMenuItem RelRegressao;
    private javax.swing.JMenuItem RelatorioArtigo;
    private javax.swing.JMenuItem RelatorioEscolaridade;
    private javax.swing.JMenuItem RelatorioEstadoCivil;
    private javax.swing.JMenuItem RelatorioHorarioEntradaSaida;
    private javax.swing.JMenu RelatorioInternos;
    private javax.swing.JMenuItem RelatorioMovAdvogadosInternos;
    private javax.swing.JMenuItem RelatorioMovVisitasInternos;
    private javax.swing.JMenu RelatorioMudancaRegime;
    private javax.swing.JMenuItem RelatorioNaturalidade;
    private javax.swing.JMenuItem RelatorioPopulacaoInternosNominal;
    private javax.swing.JMenuItem RelatorioPorBairro;
    private javax.swing.JMenuItem RelatorioPorCidade;
    private javax.swing.JMenuItem RelatorioPorSexo;
    private javax.swing.JMenuItem RelatorioPrevisaoSaida;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaIntNaoReal;
    private javax.swing.JMenu RelatorioProntuarios;
    private javax.swing.JMenuItem RelatorioRegimePenal;
    private javax.swing.JMenuItem RelatorioRegimePenalSexo;
    private javax.swing.JMenuItem RelatorioSaidaInternosPortaria;
    private javax.swing.JMenuItem RelatorioTempoPena;
    private javax.swing.JMenuItem RelatorioUnidadePenal;
    private javax.swing.JMenu RelatoriosConfere;
    private javax.swing.JMenuItem RellatorioIdade;
    private javax.swing.JMenuItem RetornoAudiencia;
    private javax.swing.JMenuItem RetornoEspontaneo;
    private javax.swing.JMenuItem RetornoInternosPorTransferencia;
    private javax.swing.JMenuItem RetornoRecaptura;
    private javax.swing.JMenuItem RetornoSaidaMedico;
    private javax.swing.JMenuItem RetornoSaidaTemporaria;
    private javax.swing.JMenuItem jAgendamentoEscolta;
    private javax.swing.JMenuItem jCalculadoraPena;
    private javax.swing.JMenuItem jCalculadoraWindows;
    private javax.swing.JMenuItem jCidades;
    private javax.swing.JMenuItem jConsultaGeralInternosExterna;
    private javax.swing.JMenuItem jEmissaoAtestadoReclusao;
    private javax.swing.JMenuItem jEmissaoAtestadoReclusaoCRC;
    private javax.swing.JMenuItem jEntradaInternos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jLancamentoObitoInterno;
    private javax.swing.JMenuItem jListagemCidade;
    private javax.swing.JMenuItem jListagemPaises;
    private javax.swing.JMenuItem jListagemUnidadePenal;
    private javax.swing.JMenuItem jLocalizacaoInternos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu jMenuMovimentacao;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuUtilitarios;
    public static javax.swing.JDesktopPane jPainelCRC;
    private javax.swing.JMenuItem jPaises;
    private javax.swing.JMenuItem jPopulacaoCarceraria;
    private javax.swing.JMenuItem jProntuariosIntrernos;
    private javax.swing.JMenuItem jRelatorioEvadidos;
    private javax.swing.JMenuItem jRevalidarAtestadoReclusao;
    private javax.swing.JMenuItem jSaidaInternos;
    private javax.swing.JMenuItem jSair;
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
    private javax.swing.JPopupMenu.Separator jSeparator29;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jSolicitacaoAtestadoReclusaoCRC;
    private javax.swing.JMenuItem jTipoOperacao;
    private javax.swing.JMenuItem jTransferenciaInternos;
    private javax.swing.JMenuItem jUnidadePenal;
    private javax.swing.JMenuItem jValidacaoAtestadoReclusao;
    // End of variables declaration//GEN-END:variables

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado(); // Verificar recados a cada 5 minutos
                verificarAlertaPortaria(); // verificar alertas de entradas de internos na portaria a cada 5 minutos.
                verificarRetornoInternos(); // VERIFICA O RETORNO DOS INTERNOS DA SAIDA AUDIENCIA, MEDICO E OUTROS
                verificarAgendaCompromisso();
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

// Chama a calculadora de pena para o java
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
                // Abrir uma úica tela, funcionando
                if (objRecados == null || objRecados.isClosed()) {
                    objRecados = new TelaRecadosCrc();
                    TelaModuloCRC.jPainelCRC.add(objRecados);
                    objRecados.setVisible(true);
                } else {
                    if (objRecados.isVisible()) {
                        if (objRecados.isIcon()) { // Se esta minimizado
                            try {
                                objRecados.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecados.toFront(); // traz para frente
                            objRecados.pack();//volta frame 
                        }
                    } else {
                        objRecados = new TelaRecadosCrc();
                        TelaModuloCRC.jPainelCRC.add(objRecados);//adicona frame ao JDesktopPane  
                        objRecados.setVisible(true);
                    }
                }
                try {
                    objRecados.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
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

    public void buscarEvadido() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO WHERE HorarioEntrada='" + horarioEntrada + "' AND DataSaida!='" + jDataSistema.getText() + "'AND Evadido='" + evadido + "'");
            conecta.rs.first();
            dataSaida = conecta.rs.getString("DataSaida");
            // Formatar a data Saida
            dataSaida = conecta.rs.getString("DataSaida");
            String dia = dataSaida.substring(8, 10);
            String mes = dataSaida.substring(5, 7);
            String ano = dataSaida.substring(0, 4);
            dataSaida = dia + "/" + mes + "/" + ano;
            if (dataSaida == null ? jDataSistema.getText() != null : !dataSaida.equals(jDataSistema.getText())) {
                TelaAlertaEvadidos objEvas = new TelaAlertaEvadidos();
                TelaModuloCRC.jPainelCRC.add(objEvas);
                objEvas.show();
                preencherTabelaEvadido();
            }
        } catch (SQLException ex) {
        }
    }

    public void preencherTabelaEvadido() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nr.Doc.", "Código", "Nome do Interno", "Data Entrada", "Horário", "Data Saída", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLABORINTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLABORINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE Evadido='" + evadido + "' AND HorarioEntrada='" + horarioEntrada + "'");
            conecta.rs.first();
            do {
                // Formatar a data Saida
                dataSaida = conecta.rs.getString("DataSaida");
                String dia = dataSaida.substring(8, 10);
                String mes = dataSaida.substring(5, 7);
                String ano = dataSaida.substring(0, 4);
                dataSaida = dia + "/" + mes + "/" + ano;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidos.setModel(modelo);
        jTabelaIntEvadidos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaIntEvadidos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidos.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidos.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaIntEvadidos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaIntEvadidos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaIntEvadidos.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaIntEvadidos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaIntEvadidos.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidos.setAutoResizeMode(jTabelaIntEvadidos.AUTO_RESIZE_OFF);
        jTabelaIntEvadidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaIntEvadidos();
        conecta.desconecta();
    }

    public void alinharTabelaIntEvadidos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaIntEvadidos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaIntEvadidos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaIntEvadidos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaIntEvadidos.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }

    public void buscarEvadidoSaidaTemporaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MOVISR WHERE NrDocRetorno='" + NrDocRetorno + "'OR NrDocRetorno='" + NrDocRetornoNull + "'");
            conecta.rs.first();
            idLanc = conecta.rs.getString("IdSaida");
            dataRetorno = conecta.rs.getString("DataRetorno");
            // Convertendo a data do banco yyyy/MM/dd para dd/MM/yyyy           
            dataPrevRetorno = conecta.rs.getString("DataPrevRetorno");
            if (dataPrevRetorno != null) {
                String dia = dataPrevRetorno.substring(8, 10);
                String mes = dataPrevRetorno.substring(5, 7);
                String ano = dataPrevRetorno.substring(0, 4);
                dataPrevRetorno = dia + "/" + mes + "/" + ano;
            }
        } catch (SQLException ex) {
        }
        if (dataRetorno == null && dataPrevRetorno != null) {
            if (dataPrevRetorno.compareTo(jDataSistema.getText()) <= 0) { // Comparando as datas
                TelaAlertaEvadidosSaidaTemporario objEvadidoSaidaTemp = new TelaAlertaEvadidosSaidaTemporario();
                TelaModuloCRC.jPainelCRC.add(objEvadidoSaidaTemp);
                objEvadidoSaidaTemp.show();
                preencherTabelaEvadidoSaidaTemporaria("SELECT * FROM MOVISR "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON MOVISR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE NrDocRetorno='" + NrDocRetorno + "' "
                        + "AND DataPrevRetorno <'" + jDataSistema.getText() + "' "
                        + "AND DataEvasao='" + dataEvasao + "'");
            }
        }
    }

    public void preencherTabelaEvadidoSaidaTemporaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nr.Doc.", "Código", "Nome do Interno", "Data Saída", "Data Prev. Retorno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Saida
                dataSaidaTemp = conecta.rs.getString("DataSaida");
                String diap = dataSaidaTemp.substring(8, 10);
                String mesp = dataSaidaTemp.substring(5, 7);
                String anop = dataSaidaTemp.substring(0, 4);
                dataSaidaTemp = diap + "/" + mesp + "/" + anop;
                // Formatar a data Entrada
                dataPrevRetorno = conecta.rs.getString("DataPrevRetorno");
                String diar = dataPrevRetorno.substring(8, 10);
                String mesr = dataPrevRetorno.substring(5, 7);
                String anor = dataPrevRetorno.substring(0, 4);
                dataPrevRetorno = diar + "/" + mesr + "/" + anor;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaidaTemp, dataPrevRetorno});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaIntEvadidosSaidaTemporaria.setModel(modelo);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaIntEvadidosSaidaTemporaria.getTableHeader().setReorderingAllowed(false);
        jTabelaIntEvadidosSaidaTemporaria.setAutoResizeMode(jTabelaIntEvadidosSaidaTemporaria.AUTO_RESIZE_OFF);
        jTabelaIntEvadidosSaidaTemporaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEvadidos();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaEvadidos() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaIntEvadidosSaidaTemporaria.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    //Verificar se existem interos registrados na portaria
    public void verificarAlertaPortaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSENTRADAPORTARIA "
                    + "WHERE ConfirmaEntrada='" + confirmaEntrada + "'");
            conecta.rs.first();
            confirmaEntrada = conecta.rs.getString("ConfirmaEntrada");
            if (confirmaEntrada.equals("Não")) {
                if (objEntradasPortarias == null || objEntradasPortarias.isClosed()) {
                    objEntradasPortarias = new TelaAlertaEntradaInternosPortaria();
                    TelaModuloCRC.jPainelCRC.add(objEntradasPortarias);
                    objEntradasPortarias.setVisible(true);
                } else {
                    if (objEntradasPortarias.isVisible()) {
                        if (objEntradasPortarias.isIcon()) { // Se esta minimizado
                            try {
                                objEntradasPortarias.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objEntradasPortarias.toFront(); // traz para frente
                            objEntradasPortarias.pack();//volta frame 
                        }
                    } else {
                        objEntradasPortarias = new TelaAlertaEntradaInternosPortaria();
                        TelaModuloCRC.jPainelCRC.add(objEntradasPortarias);//adicona frame ao JDesktopPane  
                        objEntradasPortarias.setVisible(true);
                    }
                }
                try {
                    objEntradasPortarias.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            }
        } catch (SQLException ex) {
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
                TelaModuloCRC.jPainelCRC.add(objAgendaComp);
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

    public void verificarRetornoInternos() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                    + "WHERE DataEntrada='" + jDataSistema.getText() + "' "
                    + "AND RetCrc='" + confirmacaoCrc + "' "
                    + "OR DataEntrada!='" + jDataSistema.getText() + "' "
                    + "AND RetCrc='" + confirmacaoCrc + "'");
            conecta.rs.first();
            dataEntradaV = conecta.rs.getString("DataEntrada");
            // Formatar a data Saida
            dataEntradaV = conecta.rs.getString("DataEntrada");
            String dia = dataEntradaV.substring(8, 10);
            String mes = dataEntradaV.substring(5, 7);
            String ano = dataEntradaV.substring(0, 4);
            dataEntradaV = dia + "/" + mes + "/" + ano;
            TelaVerificacaoRetornoSaidasPortariaCrc objRetornoInternos = new TelaVerificacaoRetornoSaidasPortariaCrc();
            TelaModuloCRC.jPainelCRC.add(objRetornoInternos);
            objRetornoInternos.show();
            verificarSaidaMedicoAudiencia();
        } catch (SQLException ex) {
        }
    }

    public void verificarSaidaMedicoAudiencia() {
        // confirmaCrc = "Não" E horaRetorno TEM QUE SER DIFERENTE DE VAZIO
        // String horaRetorno = "";
        // String confirmacaoCrc = "Não";
        count = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Doc.Retorno", "Data Retorno", "Hora", "Código", "Nome do Interno "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE RetCrc='" + confirmacaoCrc + "' AND HoraEntrada!='" + horaRetorno + "'");
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntradaV = conecta.rs.getString("DataEntrada");
                String diae = dataEntradaV.substring(8, 10);
                String mese = dataEntradaV.substring(5, 7);
                String anoe = dataEntradaV.substring(0, 4);
                dataEntradaV = diae + "/" + mese + "/" + anoe;
                jtotalRegistrosVerifica.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("DocEntrada"), dataEntradaV, conecta.rs.getString("HoraEntrada"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaSaidaPortariaCrc.setModel(modelo);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEntradaSaidaPortariaCrc.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaSaidaPortariaCrc.setAutoResizeMode(jTabelaEntradaSaidaPortariaCrc.AUTO_RESIZE_OFF);
        jTabelaEntradaSaidaPortariaCrc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEntradaSaidaPortariaCrc();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaEntradaSaidaPortariaCrc() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(0).setCellRenderer(direita);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaEntradaSaidaPortariaCrc.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaConsultaGerencialInternosExternaCRC + "'");
            conecta.rs.first();
            pNomeCGIE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEmissaoAtestadoReclusao + "'");
            conecta.rs.first();
            pNomeEAR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + liberacaoAtestadoCRC + "'");
            conecta.rs.first();
            pNomeLA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + impressaoAtestadoCRC + "'");
            conecta.rs.first();
            pNomeIA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + validadorAtestadoCRC + "'");
            conecta.rs.first();
            pNomeVA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + revalidarAtestadoCRC + "'");
            conecta.rs.first();
            pNomeRAR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + liberacaoRevAtestadoCRC + "'");
            conecta.rs.first();
            pNomeLRA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + impressaoRevalidarAtCRC + "'");
            conecta.rs.first();
            pNomeIRV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + emissaoAtestaRecCRC + "'");
            conecta.rs.first();
            pNomeEARC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + liberacaoAtestado_CRC + "'");
            conecta.rs.first();
            pNomeLARC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + impressaoAtestado_CRC + "'");
            conecta.rs.first();
            pNomeIARC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + validadorAtestado_CRC + "'");
            conecta.rs.first();
            pNomeVARC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        if (!pNomeCGIE.equals(telaConsultaGerencialInternosExternaCRC) || pNomeCGIE == null || pNomeCGIE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaConsultaGerencialInternosExternaCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEAR.equals(telaEmissaoAtestadoReclusao) || pNomeEAR == null || pNomeEAR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEmissaoAtestadoReclusao);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLA.equals(liberacaoAtestadoCRC) || pNomeLA == null || pNomeLA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(liberacaoAtestadoCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIA.equals(impressaoAtestadoCRC) || pNomeIA == null || pNomeIA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(impressaoAtestadoCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeVA.equals(validadorAtestadoCRC) || pNomeVA == null || pNomeVA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(validadorAtestadoCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAR.equals(revalidarAtestadoCRC) || pNomeRAR == null || pNomeRAR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(revalidarAtestadoCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLRA.equals(liberacaoRevAtestadoCRC) || pNomeLRA == null || pNomeLRA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(liberacaoRevAtestadoCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIRV.equals(impressaoRevalidarAtCRC) || pNomeIRV == null || pNomeIRV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(impressaoRevalidarAtCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEARC.equals(emissaoAtestaRecCRC) || pNomeEARC == null || pNomeEARC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(emissaoAtestaRecCRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLARC.equals(liberacaoAtestado_CRC) || pNomeLARC == null || pNomeLARC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(liberacaoAtestado_CRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIARC.equals(impressaoAtestado_CRC) || pNomeIARC == null || pNomeIARC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(impressaoAtestado_CRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeVARC.equals(validadorAtestado_CRC) || pNomeVARC == null || pNomeVARC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(validadorAtestado_CRC);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloCRC + "'");
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
            codigoUserCRC = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserCRC + "'");
            conecta.rs.first();
            codigoUserGroupCRC = conecta.rs.getInt("IdUsuario");
            codigoGrupoCRC = conecta.rs.getInt("IdGrupo");
            nomeGrupoCRC = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserCRC + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoCRC = conecta.rs.getInt("IdUsuario");
            codAbrirCRC = conecta.rs.getInt("Abrir");
            codIncluirCRC = conecta.rs.getInt("Incluir");
            codAlterarCRC = conecta.rs.getInt("Alterar");
            codExcluirCRC = conecta.rs.getInt("Excluir");
            codGravarCRC = conecta.rs.getInt("Gravar");
            codConsultarCRC = conecta.rs.getInt("Consultar");
            nomeTelaCRC = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
    //  Verificar depois a utilização dessa tela no projeto
//            TelaConsultaRetornoInternos objConsultaRetornoInterno = new TelaConsultaRetornoInternos();
//        TelaModuloCRC.jPainelCRC.add(objConsultaRetornoInterno);
//        objConsultaRetornoInterno.show();
}
