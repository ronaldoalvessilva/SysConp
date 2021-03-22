/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtualizaInternoKits;
import gestor.Controle.ControleComposicaoKit;
import gestor.Controle.ControleItensRequisicaoMateriaisInternos;
import gestor.Controle.ControleListarGravarProdutosKitCompleto;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePavilhaoInternosMontaKitInicial;
import gestor.Controle.ControlePavilhaoMontaKitAnual;
import gestor.Controle.ControlePavilhaoMontaKitDecendial;
import gestor.Controle.ControlePavilhaoMontaKitMensal;
import gestor.Controle.ControlePavilhaoMontaKitQuinzenal;
import gestor.Controle.ControlePavilhaoMontaKitSemestral;
import gestor.Controle.ControleProdutosKitLote;
import gestor.Controle.ControleSelecaoKitsCompleto;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleBaixaLoteKitHigiene;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.ItensRequisicaoMateriaisInternos;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PavilhaoInternoMontaKit;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import gestor.Modelo.ProdutoInternosKitLote;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAlmoxarifado.botaoProgramarKitAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codAbrirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codAlterarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codConsultarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codExcluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codGravarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codIncluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codUserAcessoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserGroupAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeTelaAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMontagemPagamentoKitAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMontagemPagamentoKitCompletoIntAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMontagemPagamentoKitCompletoProdAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMontagemPagamentoKitPavIntAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMontagemPagamentoKitProdutosAL;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronaldo - INICIO DO DESENVOLVIMENTO DO KIT 22/07/2018 AS 09:57:12HS -
 * LOCAL (ITABUNA)
 */
public class TelaMontagemPagamentoKitInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    // FASE - 1
    ComposicaoKit objComp = new ComposicaoKit();
    ControleComposicaoKit control = new ControleComposicaoKit();
    // FASE - 2
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();
    ControlePavilhaoInternosMontaKitInicial controle = new ControlePavilhaoInternosMontaKitInicial();
    ControlePavilhaoMontaKitDecendial controleKD = new ControlePavilhaoMontaKitDecendial();
    ControlePavilhaoMontaKitQuinzenal controleKQ = new ControlePavilhaoMontaKitQuinzenal();
    ControlePavilhaoMontaKitMensal controleKM = new ControlePavilhaoMontaKitMensal();
    ControlePavilhaoMontaKitSemestral controleKS = new ControlePavilhaoMontaKitSemestral();
    ControlePavilhaoMontaKitAnual controleKA = new ControlePavilhaoMontaKitAnual();
    //QUANDO EXCLUIR OS INTERNOS SELECIONADOS
    ControleAtualizaInternoKits controleKits = new ControleAtualizaInternoKits();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    // FASE - 3  
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    // LOTE_PRODUTOS_AC
    ItensRequisicaoMateriaisInternos objItensReqMatInter = new ItensRequisicaoMateriaisInternos();
    // DAR BAIXA ESTOQUE (LOTE_PRODUTOS_AC)
    ControleItensRequisicaoMateriaisInternos controleLote = new ControleItensRequisicaoMateriaisInternos();
    ControleProdutosKitLote controleProd = new ControleProdutosKitLote();
    //
    ControleBaixaLoteKitHigiene CONTROLE = new ControleBaixaLoteKitHigiene();
    // FASE - 4
    // GRAVAR OU EXCLUIR REGISTRO DOS INTERNOS NO KIT COMPLETO
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();
    ControleSelecaoKitsCompleto controleIntSelec = new ControleSelecaoKitsCompleto();
    // GRAVAR OU EXCLUIR OS PRODUTOS DOS INTERNOS COM KIT COMPLETO
    ControleListarGravarProdutosKitCompleto controleProdKit = new ControleListarGravarProdutosKitCompleto();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Dados Iniciais/FASE - 1";
    String nomeModuloTela2 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:Pavilhão/FASE - 2";
    String nomeModuloTela3 = "Almoxarifado:Montagem de Pagamento do Kit de Interno:FASE - 3";
    //
    int flag = 0;
    int acao = 0;
    String dataEntrada = "";
    String statusMov = "";
    String horaMov = "";
    String dataModFinal = "";
    String statusKit = "Ativo";
    public static int count = 0;
    int count1 = 0; // PARA TABELA DE INTERNOS SELECIONADOS
    int count2 = 0;
    int count3 = 0;
    //
    String codRequisicao = "";
    String codRequisicao1 = "";
    String codRequisicao2 = "";
    String codRequisicao3 = "";

    String caminho;
    int Inicial = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitDecimal = 0;
    int kitAnual = 0;
    int kitSemetral = 0;
    //
    public static double qtdItem = 0;
    public static String qtdItemTab;
    public static double qtdItemAnterior = 0; // SALDO ANTERIOR A SER CALCULADO SE FOR ALTERADO PELO USUARIO
    public static double novoSaldoAtual = 0; //SALDO CALCULADO APOS ALTERAR A QUANTIDADE DO ITEM
    //
    int codigoKit = 0;
    // CÓDIGO DO REGISTRO DE MONTAGEM DO KIT (codigoPesquisaKit) 
    // E DOS PRODUTOS DOS KITS (codigoPesquisaKitItem)
    public static int codigoPesquisaKit = 0;
    public static int codigoPesquisaKitItem = 0;
    // ABA PAVILHÃO/INTERNOS
    public static int pCODIGO_pavilhao = 0;
    String situacaoEntrada = "ENTRADA NA UNIDADE";
    String situacaoRetorno = "RETORNO A UNIDADE";
    String idInterno;
    String cncInterno;
    String nomeInterno;
    public static int qtdInternos = 0;
    public static int qtdInternosKD = 0;
    public static int qtdInternosSelec = 0;
    public static int qtdInternosKitComp = 0;
    public static int qtdProdutosKitComo = 0;
    int qtdTotal = 0;
    int idRegPavInt = 0;
    //
    int codProd = 0;
    int codEstoque = 0;
    float saldoEstoque = 0;
    float estoqueAtual = 0;
    public static String idItem;
    float qtdEstoque = 0;
    float qtdKit = 0;
    public static int idKit = 0;
    public static int qtdProd = 0;
    int IdRegProdKit = 0;
    int pGravadoDB = 0;
    int idInternoComp;
    String pUtili = "Não";
    public static int tipoKitCI = 0; // INFORMA A PESQUISA SE O TIPO DE KIT É COMPLETO OU INCOMPLETO
    String codigoRegExcluir = ""; // CÓDIGO PARA SABER SE PODE EXCLUIR O REGISTRO DA TABELA INTERNOS KIT COMPLETO
    String codigoInternoCrc = ""; // CÓDIGO DO INTERNO PARA EXCLUSÃO DO KIT
    int codigoInternoPav = 0; // CÓDIGO DO INTERNO PARA EXCLUI-LO NA SELEÇÃO
    //
    String codigoProdExclui = ""; // CÓDIGO DO PRODUTO PARA PESQUISA A SER EXCLUIDO DEPOIS DE SELECIONADO
    int codigoProdutoExclui = 0; // CÓDIGO DO PRODUTO A SER EXCLUIDO DEPOIS DE SELECIONADO
    public static int pTipoKitCI = 0; // TIPO DE KIT PARA AUXILIAR A EXCLUIR UM OU TODOS OS REGISTROS (PRODUTOS) DA TABELA
    //
    String opcaoKit = "Não";
    // 1 - INICIAL, 2 - DECENTIAL, 3 - QUINZENAL, 4 - MENSAL, 5 - SEMESTRAL E 6 - ANUAL.
    //
    String kitUtilizado = "Não";
    //   
    public static int pCodigoAlmxarifado = 0;
    String pcodigoProduto = "";
    String pRegistroComp = "";
    //
    public static Integer pPESQUISA_ID_kit = null;
    public static String idProduto;
    //
    public static String nomeProduto;

    /**
     * Creates new form TelaMontagemPagamentoKitInterno
     */
    public static TelaPesquisaKitComp pesqKit;
    public static TelaPesquisaColaboradorMontagemKitAL pesqCola;
    public static TelaPesquisaMontagemKitHigiene pesqMontaReg;
    public static TelaConsultaEstoqueMontagemKit pesqSaldoEstoque;
    public static TelaThreadInternosSelecionados montaThread;
    public static TelaEstoqueProdutosKit estoqueProdkit;
    public static TelaSelecaoInternosKitCompleto kitCompleto;
    public static TelaGravarInternosKitCompleto gravarIntComp;
    public static TelaSelecaoProdutosKitsCompletoIncompleto selecaoProdutosKit;
    public static TelaGravarProdutosKitCompleto gravarProdutosKitComp;
    public static TelaPrevisaoKitHigiene previsaoKit;
    public static TelaFinalizarKitHigiene finalEstoque;
    public static TelaConsultaPavilhaoKit pavKit;
    public static TelaConsultaProgramacaoKit consulPav;
    public static TelaEstoqueProdutosKitBaixaLote pBAIXA_ESTOQUE_lote;

    public TelaMontagemPagamentoKitInterno() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampos();
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jBtProgramarKit.setVisible(true);
        } else {
            jBtProgramarKit.setVisible(!true);
        }
    }

    public void mostrarBuscaKit() {
        pesqKit = new TelaPesquisaKitComp(this, true);
        pesqKit.setVisible(true);
    }

    public void mostrarColaborador() {
        pesqCola = new TelaPesquisaColaboradorMontagemKitAL(this, true);
        pesqCola.setVisible(true);
    }

    public void mostrarPesquisas() {
        pesqMontaReg = new TelaPesquisaMontagemKitHigiene(this, true);
        pesqMontaReg.setVisible(true);
    }

    public void mostraEstoque() {
        pesqSaldoEstoque = new TelaConsultaEstoqueMontagemKit(this, true);
        pesqSaldoEstoque.setVisible(true);
    }

    public void mostrarThread() {
        montaThread = new TelaThreadInternosSelecionados(this, true);
        montaThread.setVisible(true);
    }

    public void mostrarEstoqueProdutosKit() {
        estoqueProdkit = new TelaEstoqueProdutosKit(this, true);
        estoqueProdkit.setVisible(true);
    }

    public void mostrarSelecaoInternos() {
        kitCompleto = new TelaSelecaoInternosKitCompleto(this, true);
        kitCompleto.setVisible(true);
    }

    public void mostarTelaGrava() {
        gravarIntComp = new TelaGravarInternosKitCompleto(this, true);
        gravarIntComp.setVisible(true);
    }

    public void listarProdutosKit() {
        selecaoProdutosKit = new TelaSelecaoProdutosKitsCompletoIncompleto(this, true);
        selecaoProdutosKit.setVisible(true);
    }

    public void mostrarTelaGravacaoProdutoKitCompleto() {
        gravarProdutosKitComp = new TelaGravarProdutosKitCompleto(this, true);
        gravarProdutosKitComp.setVisible(true);
    }

    public void mostrarTelaPrevisaoKit() {
        previsaoKit = new TelaPrevisaoKitHigiene(this, true);
        previsaoKit.setVisible(true);
    }

    public void mostrarFinalizacao() {
        finalEstoque = new TelaFinalizarKitHigiene(this, true);
        finalEstoque.setVisible(true);
    }

    public void mostrarPavilhao() {
        pavKit = new TelaConsultaPavilhaoKit(this, true);
        pavKit.setVisible(true);
    }

    public void mostrarProgramacao() {
        consulPav = new TelaConsultaProgramacaoKit(this, true);
        consulPav.setVisible(true);
    }

    public void mostrarBaixaLote() {
        pBAIXA_ESTOQUE_lote = new TelaEstoqueProdutosKitBaixaLote(this, true);
        pBAIXA_ESTOQUE_lote.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jRBtKitInicial = new javax.swing.JRadioButton();
        jRBtKitQuinzenal = new javax.swing.JRadioButton();
        jRBtKitMensal = new javax.swing.JRadioButton();
        jRBtKitDecendial = new javax.swing.JRadioButton();
        jRBtKitSemestral = new javax.swing.JRadioButton();
        jRBtKitAnual = new javax.swing.JRadioButton();
        jBtPesquisarKit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaGeralProdutosKit = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jBtAlterar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtHelp = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jIdFunc = new javax.swing.JTextField();
        jNomeColaborador = new javax.swing.JTextField();
        jDepartamentoColaborador = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jFotoColaborador = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jtotalProdutosKit = new javax.swing.JLabel();
        jBtPesquisarColaborador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxPavilhoes = new javax.swing.JComboBox<>();
        jBtPesquisarInternosPavilhao = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalInternosPavilhao = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jBtNovoPavInternos = new javax.swing.JButton();
        jBtExcluirPavInternosTodos = new javax.swing.JButton();
        jBtSelecionarUmInterno = new javax.swing.JButton();
        jBtSelecionarTodosInternos = new javax.swing.JButton();
        jBtSalvarPavInternos = new javax.swing.JButton();
        jBtAuditoriaPavInternos = new javax.swing.JButton();
        jBtCancelarPavilhaoInterno = new javax.swing.JButton();
        jBtExcluirUmInterno = new javax.swing.JButton();
        jBtExcluirTodosInternos = new javax.swing.JButton();
        jBtSaldoEstoque = new javax.swing.JButton();
        jBtExcluirInternosUmaUm = new javax.swing.JButton();
        jBtConsultarPavilhao = new javax.swing.JButton();
        jBtProgramacao = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternosSelecionados = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jtotalInternosSelecionados = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaProdutos = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCodigoProd = new javax.swing.JTextField();
        jUnidadeProd = new javax.swing.JTextField();
        jDescricaoProd = new javax.swing.JTextField();
        jQuantidadeProdEstoque = new javax.swing.JFormattedTextField();
        jQuantidadeKit = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jQtdAtendida = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jQuantidadeInternos = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jtotalProdutosKitInternos = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jBtAlterarProduto = new javax.swing.JButton();
        jBtNovoProduto = new javax.swing.JButton();
        jBtExcluirProduto = new javax.swing.JButton();
        jBtSalvarProduto = new javax.swing.JButton();
        jBtCancelarProduto = new javax.swing.JButton();
        jBtAuditoriaProduto = new javax.swing.JButton();
        jBtConsultarEstoque = new javax.swing.JButton();
        jBtSelecionarProdutos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaInternosKitCompleto = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jtotalInternosKitCompleto = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jBtAdicionarTodosInternos = new javax.swing.JButton();
        jBtSalvarInternosSelecionados = new javax.swing.JButton();
        jBtExcluirTodosInternosSelecionados = new javax.swing.JButton();
        jBtExcluirUmInternoAgrupado = new javax.swing.JButton();
        jBtAuditoriaKitCompletoFase4A = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTabelaProdutosKitCompleto = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jtotalProdutosKitCompleto = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jBtAdicionarProdutosKitCompleto = new javax.swing.JButton();
        jBtExcluirTodosProdutos = new javax.swing.JButton();
        jBtExcluirProdutoSelecionado = new javax.swing.JButton();
        jBtSalvarProdutoBanco = new javax.swing.JButton();
        jBtAuditoriaKitProdutoCompleto = new javax.swing.JButton();
        jBtProgramarKit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdRegistroComp = new javax.swing.JTextField();
        jStatusComp = new javax.swing.JTextField();
        jDataComp = new com.toedter.calendar.JDateChooser();
        jBtPesquisaComp = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Preparção dos Kits de Higiene de Internos - Em Lote :::...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_16.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tipos de Kits", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        grupoBotoes.add(jRBtKitInicial);
        jRBtKitInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitInicial.setText("Inicial");
        jRBtKitInicial.setEnabled(false);
        jRBtKitInicial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitInicialItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitQuinzenal);
        jRBtKitQuinzenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitQuinzenal.setText("Quinzenal");
        jRBtKitQuinzenal.setEnabled(false);
        jRBtKitQuinzenal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitQuinzenalItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitMensal);
        jRBtKitMensal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitMensal.setText("Mensal");
        jRBtKitMensal.setEnabled(false);
        jRBtKitMensal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitMensalItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitDecendial);
        jRBtKitDecendial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitDecendial.setText("Decendial");
        jRBtKitDecendial.setEnabled(false);
        jRBtKitDecendial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitDecendialItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitSemestral);
        jRBtKitSemestral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitSemestral.setText("Semestral");
        jRBtKitSemestral.setEnabled(false);
        jRBtKitSemestral.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitSemestralItemStateChanged(evt);
            }
        });

        grupoBotoes.add(jRBtKitAnual);
        jRBtKitAnual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitAnual.setText("Anual");
        jRBtKitAnual.setEnabled(false);
        jRBtKitAnual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBtKitAnualItemStateChanged(evt);
            }
        });

        jBtPesquisarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisarKit.setToolTipText("Pesquisar Kit de Higiêne");
        jBtPesquisarKit.setContentAreaFilled(false);
        jBtPesquisarKit.setEnabled(false);
        jBtPesquisarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarKitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitDecendial)
                    .addComponent(jRBtKitInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitQuinzenal)
                    .addComponent(jRBtKitSemestral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitAnual)
                    .addComponent(jRBtKitMensal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jBtPesquisarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBtKitMensal)
                    .addComponent(jRBtKitQuinzenal)
                    .addComponent(jRBtKitInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBtKitDecendial)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRBtKitAnual)
                        .addComponent(jRBtKitSemestral)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtPesquisarKit)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabelaGeralProdutosKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaGeralProdutosKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição Produtos", "Un.", "Quant."
            }
        ));
        jScrollPane3.setViewportView(jTabelaGeralProdutosKit);
        if (jTabelaGeralProdutosKit.getColumnModel().getColumnCount() > 0) {
            jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Ajuda_8446_16x16.png"))); // NOI18N
        jBtHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtNovo)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtHelp))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtExcluir, jBtNovo, jBtSalvar});

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Colaborador Responsável", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Colaborador");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Departamento");

        jIdFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFunc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFunc.setEnabled(false);

        jNomeColaborador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaborador.setEnabled(false);

        jDepartamentoColaborador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoColaborador.setEnabled(false);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jFotoColaborador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFotoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeColaborador)
                            .addComponent(jDepartamentoColaborador)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 216, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDepartamentoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jScrollPane5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setEnabled(false);
        jScrollPane5.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel69.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel69))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalProdutosKit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jBtPesquisarColaborador.setForeground(new java.awt.Color(0, 153, 153));
        jBtPesquisarColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarColaborador.setText("Adicionar Colaborador");
        jBtPesquisarColaborador.setEnabled(false);
        jBtPesquisarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtPesquisarColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisarColaborador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("FASE - 1", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/290718163923_16.png")), jPanel1, "Tipo de Kit de Higiêne e Colaborador Resonsável por Entregar os Produtos na Base do Pavilhão."); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pavilhão e Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pavilhão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jComboBoxPavilhoes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPavilhoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhoes.setEnabled(false);

        jBtPesquisarInternosPavilhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisarInternosPavilhao.setToolTipText("Pesquisar Internos por Pavilhão");
        jBtPesquisarInternosPavilhao.setContentAreaFilled(false);
        jBtPesquisarInternosPavilhao.setEnabled(false);
        jBtPesquisarInternosPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternosPavilhaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPavilhoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesquisarInternosPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPavilhoes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInternosPavilhao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jTabelaInternos.setAutoCreateRowSorter(true);
        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setForeground(new java.awt.Color(204, 0, 0));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNC", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosPavilhao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosPavilhao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosPavilhao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Seleção", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 51))); // NOI18N

        jBtNovoPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPavInternos.setText("Novo");
        jBtNovoPavInternos.setEnabled(false);
        jBtNovoPavInternos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtNovoPavInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPavInternosActionPerformed(evt);
            }
        });

        jBtExcluirPavInternosTodos.setForeground(new java.awt.Color(204, 0, 0));
        jBtExcluirPavInternosTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPavInternosTodos.setText("Excluir Todos");
        jBtExcluirPavInternosTodos.setEnabled(false);
        jBtExcluirPavInternosTodos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirPavInternosTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPavInternosTodosActionPerformed(evt);
            }
        });

        jBtSelecionarUmInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionarUmInterno.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionarUmInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131515_16.png"))); // NOI18N
        jBtSelecionarUmInterno.setToolTipText("Adicionar interno selecionado na tabela a direita");
        jBtSelecionarUmInterno.setEnabled(false);
        jBtSelecionarUmInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarUmInternoActionPerformed(evt);
            }
        });

        jBtSelecionarTodosInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSelecionarTodosInternos.setForeground(new java.awt.Color(0, 102, 0));
        jBtSelecionarTodosInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131115_16.png"))); // NOI18N
        jBtSelecionarTodosInternos.setToolTipText("Adicionar todos os internos para tabela a direita");
        jBtSelecionarTodosInternos.setEnabled(false);
        jBtSelecionarTodosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarTodosInternosActionPerformed(evt);
            }
        });

        jBtSalvarPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPavInternos.setText("Gravar");
        jBtSalvarPavInternos.setEnabled(false);
        jBtSalvarPavInternos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSalvarPavInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPavInternosActionPerformed(evt);
            }
        });

        jBtAuditoriaPavInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPavInternos.setContentAreaFilled(false);
        jBtAuditoriaPavInternos.setEnabled(false);
        jBtAuditoriaPavInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPavInternosActionPerformed(evt);
            }
        });

        jBtCancelarPavilhaoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPavilhaoInterno.setText("Cancelar");
        jBtCancelarPavilhaoInterno.setEnabled(false);
        jBtCancelarPavilhaoInterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtCancelarPavilhaoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPavilhaoInternoActionPerformed(evt);
            }
        });

        jBtExcluirUmInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExcluirUmInterno.setForeground(new java.awt.Color(204, 0, 0));
        jBtExcluirUmInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131526_16.png"))); // NOI18N
        jBtExcluirUmInterno.setToolTipText("Excluir interno selecionado");
        jBtExcluirUmInterno.setEnabled(false);
        jBtExcluirUmInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirUmInternoActionPerformed(evt);
            }
        });

        jBtExcluirTodosInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExcluirTodosInternos.setForeground(new java.awt.Color(204, 0, 0));
        jBtExcluirTodosInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131210_16.png"))); // NOI18N
        jBtExcluirTodosInternos.setToolTipText("Excluir todos os internos selecionados");
        jBtExcluirTodosInternos.setEnabled(false);
        jBtExcluirTodosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTodosInternosActionPerformed(evt);
            }
        });

        jBtSaldoEstoque.setForeground(new java.awt.Color(0, 0, 255));
        jBtSaldoEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtSaldoEstoque.setText("S.Estoque");
        jBtSaldoEstoque.setToolTipText("Consultar Estoque de Produtos");
        jBtSaldoEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSaldoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSaldoEstoqueActionPerformed(evt);
            }
        });

        jBtExcluirInternosUmaUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirInternosUmaUm.setText("Excluir Um/Um");
        jBtExcluirInternosUmaUm.setEnabled(false);
        jBtExcluirInternosUmaUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternosUmaUmActionPerformed(evt);
            }
        });

        jBtConsultarPavilhao.setForeground(new java.awt.Color(0, 102, 0));
        jBtConsultarPavilhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtConsultarPavilhao.setText("C. Pavilhão");
        jBtConsultarPavilhao.setToolTipText("Consultar Pavilhão Selecionado");
        jBtConsultarPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConsultarPavilhaoActionPerformed(evt);
            }
        });

        jBtProgramacao.setForeground(new java.awt.Color(204, 0, 0));
        jBtProgramacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Pedagogia_18.png"))); // NOI18N
        jBtProgramacao.setText("C.Programa");
        jBtProgramacao.setToolTipText("Consultar Programação do Kit");
        jBtProgramacao.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jBtProgramacao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtProgramacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jBtSelecionarUmInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtSelecionarTodosInternos, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addComponent(jBtAuditoriaPavInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtExcluirUmInterno)
                                .addComponent(jBtExcluirTodosInternos))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtSaldoEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtNovoPavInternos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jBtSalvarPavInternos)
                                        .addComponent(jBtCancelarPavilhaoInterno))
                                    .addComponent(jBtExcluirPavInternosTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jBtExcluirInternosUmaUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jBtProgramacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtConsultarPavilhao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelarPavilhaoInterno, jBtExcluirInternosUmaUm, jBtExcluirPavInternosTodos, jBtExcluirTodosInternos, jBtExcluirUmInterno, jBtNovoPavInternos, jBtSaldoEstoque, jBtSalvarPavInternos, jBtSelecionarTodosInternos, jBtSelecionarUmInterno});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jBtNovoPavInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPavInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPavilhaoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPavInternosTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInternosUmaUm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSelecionarUmInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSelecionarTodosInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirUmInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirTodosInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtProgramacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtConsultarPavilhao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSaldoEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaPavInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Internos Selecionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jTabelaInternosSelecionados.setAutoCreateRowSorter(true);
        jTabelaInternosSelecionados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosSelecionados.setForeground(new java.awt.Color(0, 102, 0));
        jTabelaInternosSelecionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNC", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaInternosSelecionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosSelecionadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternosSelecionados);
        if (jTabelaInternosSelecionados.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosSelecionados.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternosSelecionados.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternosSelecionados.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternosSelecionados.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternosSelecionados.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternosSelecionados.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel68.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FASE - 2", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/user-group-forum-icone-3716-16.png")), jPanel2, "Pavilhão e Internos para Entrega do Kit de Higiêne"); // NOI18N

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Produtos do Kit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 0, 0))); // NOI18N

        jTabelaProdutos.setAutoCreateRowSorter(true);
        jTabelaProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Un.", "Quant."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaProdutos);
        if (jTabelaProdutos.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaProdutos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaProdutos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaProdutos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaProdutos.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaProdutos.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaProdutos.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaProdutos.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaProdutos.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaProdutos.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Un.");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Q.Estoque");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Descrição");

        jCodigoProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoProd.setToolTipText("Código do Produto.");
        jCodigoProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoProd.setEnabled(false);

        jUnidadeProd.setToolTipText("Unidade de Armazenamento do Produto.");
        jUnidadeProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidadeProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jUnidadeProd.setEnabled(false);

        jDescricaoProd.setToolTipText("Descrição do Produto.");
        jDescricaoProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDescricaoProd.setEnabled(false);

        jQuantidadeProdEstoque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidadeProdEstoque.setForeground(new java.awt.Color(0, 102, 0));
        jQuantidadeProdEstoque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidadeProdEstoque.setToolTipText("Quantidade de Produto disponivel em Estoque.");
        jQuantidadeProdEstoque.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQuantidadeProdEstoque.setEnabled(false);

        jQuantidadeKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidadeKit.setForeground(new java.awt.Color(204, 0, 0));
        jQuantidadeKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidadeKit.setToolTipText("Quantidade de Produto por Kit de Higiêne.");
        jQuantidadeKit.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jQuantidadeKit.setEnabled(false);
        jQuantidadeKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Qtd. Tipo Kit");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Qtd. Atende");

        jQtdAtendida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQtdAtendida.setForeground(new java.awt.Color(0, 0, 204));
        jQtdAtendida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdAtendida.setToolTipText("Quantidade Total de Produto a ser Atendida aos Internos.");
        jQtdAtendida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdAtendida.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Qtd.Internos");

        jQuantidadeInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQuantidadeInternos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidadeInternos.setToolTipText("Quantidade de Internos para entrega do Kit de Higiêne.");
        jQuantidadeInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidadeInternos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQuantidadeInternos.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescricaoProd)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jUnidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQuantidadeProdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jQuantidadeKit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jQtdAtendida, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jQuantidadeInternos))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtdAtendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUnidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantidadeProdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantidadeKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantidadeInternos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel70.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel70))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70)
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalProdutosKitInternos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jBtAlterarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarProduto.setText("Alterar");
        jBtAlterarProduto.setEnabled(false);
        jBtAlterarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarProdutoActionPerformed(evt);
            }
        });

        jBtNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoProduto.setText("Novo");
        jBtNovoProduto.setToolTipText("");
        jBtNovoProduto.setEnabled(false);
        jBtNovoProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoProdutoActionPerformed(evt);
            }
        });

        jBtExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirProduto.setText("Excluir");
        jBtExcluirProduto.setEnabled(false);
        jBtExcluirProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirProdutoActionPerformed(evt);
            }
        });

        jBtSalvarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarProduto.setText("Gravar");
        jBtSalvarProduto.setEnabled(false);
        jBtSalvarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarProdutoActionPerformed(evt);
            }
        });

        jBtCancelarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarProduto.setText("Cancelar");
        jBtCancelarProduto.setEnabled(false);
        jBtCancelarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarProdutoActionPerformed(evt);
            }
        });

        jBtAuditoriaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaProduto.setContentAreaFilled(false);
        jBtAuditoriaProduto.setEnabled(false);
        jBtAuditoriaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaProdutoActionPerformed(evt);
            }
        });

        jBtConsultarEstoque.setForeground(new java.awt.Color(102, 0, 102));
        jBtConsultarEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtConsultarEstoque.setText("C. Estoque");
        jBtConsultarEstoque.setToolTipText("Consultar Produtos de Estoque do Kit de Higiêne");
        jBtConsultarEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtConsultarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConsultarEstoqueActionPerformed(evt);
            }
        });

        jBtSelecionarProdutos.setForeground(new java.awt.Color(204, 0, 0));
        jBtSelecionarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtSelecionarProdutos.setText("S. Produtos");
        jBtSelecionarProdutos.setToolTipText("Selecionar produtos para saída");
        jBtSelecionarProdutos.setEnabled(false);
        jBtSelecionarProdutos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSelecionarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarProdutosActionPerformed(evt);
            }
        });

        jButton1.setText("G.Lote");
        jButton1.setToolTipText("Consulta e grava todos os produtos do kit de higiêne em lote");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtNovoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtAlterarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(jBtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtSalvarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtCancelarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBtConsultarEstoque))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBtSelecionarProdutos))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jBtAuditoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarProduto, jBtCancelarProduto, jBtConsultarEstoque, jBtExcluirProduto, jBtNovoProduto, jBtSalvarProduto, jBtSelecionarProdutos, jButton1});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtSelecionarProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jBtNovoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarProduto)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jBtConsultarEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtAuditoriaProduto)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarProduto, jBtCancelarProduto, jBtConsultarEstoque, jBtExcluirProduto, jBtNovoProduto, jBtSalvarProduto, jBtSelecionarProdutos, jButton1});

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FASE - 3", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_16.png")), jPanel16, "Saida dos Produtos de Estoque para atender o Kit de Higiêne"); // NOI18N

        jTabbedPane2.setForeground(new java.awt.Color(0, 102, 0));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Internos com Kits Completos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jTabelaInternosKitCompleto.setAutoCreateRowSorter(true);
        jTabelaInternosKitCompleto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosKitCompleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaInternosKitCompleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosKitCompletoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaInternosKitCompleto);
        if (jTabelaInternosKitCompleto.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosKitCompleto.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaInternosKitCompleto.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaInternosKitCompleto.getColumnModel().getColumn(1).setMinWidth(300);
            jTabelaInternosKitCompleto.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel71.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71)
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosKitCompleto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosKitCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosKitCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Add/Excluir Internos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jBtAdicionarTodosInternos.setForeground(new java.awt.Color(0, 102, 0));
        jBtAdicionarTodosInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtAdicionarTodosInternos.setText("Add. Internos");
        jBtAdicionarTodosInternos.setToolTipText("Adicionar os internos que terão o kit de higiêne completo");
        jBtAdicionarTodosInternos.setEnabled(false);
        jBtAdicionarTodosInternos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAdicionarTodosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarTodosInternosActionPerformed(evt);
            }
        });

        jBtSalvarInternosSelecionados.setForeground(new java.awt.Color(0, 0, 204));
        jBtSalvarInternosSelecionados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvarInternosSelecionados.setText("Gravar no DB");
        jBtSalvarInternosSelecionados.setToolTipText("Gravar todos os registros dos internos selecionados no banco de dados.");
        jBtSalvarInternosSelecionados.setEnabled(false);
        jBtSalvarInternosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSalvarInternosSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternosSelecionadosActionPerformed(evt);
            }
        });

        jBtExcluirTodosInternosSelecionados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104428_16.png"))); // NOI18N
        jBtExcluirTodosInternosSelecionados.setText("Excluir Todos");
        jBtExcluirTodosInternosSelecionados.setToolTipText("Excluir todos internos adicionados para o kit de higiêne completo");
        jBtExcluirTodosInternosSelecionados.setEnabled(false);
        jBtExcluirTodosInternosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirTodosInternosSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTodosInternosSelecionadosActionPerformed(evt);
            }
        });

        jBtExcluirUmInternoAgrupado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirUmInternoAgrupado.setText("Excluir Um");
        jBtExcluirUmInternoAgrupado.setEnabled(false);
        jBtExcluirUmInternoAgrupado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirUmInternoAgrupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirUmInternoAgrupadoActionPerformed(evt);
            }
        });

        jBtAuditoriaKitCompletoFase4A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaKitCompletoFase4A.setToolTipText("Auditoria");
        jBtAuditoriaKitCompletoFase4A.setContentAreaFilled(false);
        jBtAuditoriaKitCompletoFase4A.setEnabled(false);
        jBtAuditoriaKitCompletoFase4A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaKitCompletoFase4AActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSalvarInternosSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirUmInternoAgrupado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExcluirTodosInternosSelecionados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAdicionarTodosInternos)
                    .addComponent(jBtAuditoriaKitCompletoFase4A, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdicionarTodosInternos, jBtExcluirTodosInternosSelecionados, jBtExcluirUmInternoAgrupado, jBtSalvarInternosSelecionados});

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jBtAdicionarTodosInternos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirTodosInternosSelecionados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirUmInternoAgrupado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInternosSelecionados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaKitCompletoFase4A)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jTabelaProdutosKitCompleto.setAutoCreateRowSorter(true);
        jTabelaProdutosKitCompleto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKitCompleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Un.", "Qtd."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaProdutosKitCompleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProdutosKitCompletoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTabelaProdutosKitCompleto);
        if (jTabelaProdutosKitCompleto.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(2).setMinWidth(50);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(2).setMaxWidth(50);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaProdutosKitCompleto.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel72.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel72))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72)
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalProdutosKitCompleto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalProdutosKitCompleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Add/Excluir Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jBtAdicionarProdutosKitCompleto.setForeground(new java.awt.Color(0, 102, 0));
        jBtAdicionarProdutosKitCompleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/7183_16x16.png"))); // NOI18N
        jBtAdicionarProdutosKitCompleto.setText("Add. Produtos");
        jBtAdicionarProdutosKitCompleto.setEnabled(false);
        jBtAdicionarProdutosKitCompleto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAdicionarProdutosKitCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarProdutosKitCompletoActionPerformed(evt);
            }
        });

        jBtExcluirTodosProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104428_16.png"))); // NOI18N
        jBtExcluirTodosProdutos.setText("Excluir Todos");
        jBtExcluirTodosProdutos.setEnabled(false);
        jBtExcluirTodosProdutos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirTodosProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTodosProdutosActionPerformed(evt);
            }
        });

        jBtExcluirProdutoSelecionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/6127_16x16.png"))); // NOI18N
        jBtExcluirProdutoSelecionado.setText("Excluir Um");
        jBtExcluirProdutoSelecionado.setEnabled(false);
        jBtExcluirProdutoSelecionado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtExcluirProdutoSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirProdutoSelecionadoActionPerformed(evt);
            }
        });

        jBtSalvarProdutoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/310718101618_16.png"))); // NOI18N
        jBtSalvarProdutoBanco.setText("Gravar no DB");
        jBtSalvarProdutoBanco.setEnabled(false);
        jBtSalvarProdutoBanco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSalvarProdutoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarProdutoBancoActionPerformed(evt);
            }
        });

        jBtAuditoriaKitProdutoCompleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaKitProdutoCompleto.setToolTipText("Auditoria");
        jBtAuditoriaKitProdutoCompleto.setContentAreaFilled(false);
        jBtAuditoriaKitProdutoCompleto.setEnabled(false);
        jBtAuditoriaKitProdutoCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaKitProdutoCompletoActionPerformed(evt);
            }
        });

        jBtProgramarKit.setForeground(new java.awt.Color(0, 102, 0));
        jBtProgramarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/calculator_edit.png"))); // NOI18N
        jBtProgramarKit.setText("Programar Kits");
        jBtProgramarKit.setToolTipText("Programar Kits, Decendial, Quinzenal Mensal, Semestral e Anual");
        jBtProgramarKit.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jBtProgramarKit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtProgramarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtProgramarKitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAdicionarProdutosKitCompleto)
                    .addComponent(jBtExcluirTodosProdutos)
                    .addComponent(jBtExcluirProdutoSelecionado)
                    .addComponent(jBtSalvarProdutoBanco)
                    .addComponent(jBtAuditoriaKitProdutoCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtProgramarKit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdicionarProdutosKitCompleto, jBtExcluirProdutoSelecionado, jBtExcluirTodosProdutos, jBtProgramarKit, jBtSalvarProdutoBanco});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jBtAdicionarProdutosKitCompleto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirTodosProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirProdutoSelecionado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarProdutoBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaKitProdutoCompleto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtProgramarKit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 396, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("ASSOCIAÇÃO INTERNOS/PRODUTOS", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_16.png")), jPanel23); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("FASE - 4 (FINAL)", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png")), jPanel9, "Agrupar os Produtos do Kit de Higiene aos Internos"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados Iniciais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data:");

        jIdRegistroComp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistroComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistroComp.setEnabled(false);

        jStatusComp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusComp.setForeground(new java.awt.Color(204, 0, 0));
        jStatusComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusComp.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusComp.setEnabled(false);

        jDataComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataComp.setEnabled(false);

        jBtPesquisaComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtPesquisaComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCompActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(0, 102, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStatusComp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtFinalizar)
                .addGap(66, 66, 66)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jBtPesquisaComp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSair)
                    .addComponent(jBtPesquisaComp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jBtFinalizar)
                    .addComponent(jDataComp, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jStatusComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(200, 30, 895, 559);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codIncluirAL == 1) {
            acao = 1;
            bloquearBotoes();
            bloquearCampos();
            limparCampos();
            limparTabelaItensKit();
            limparTabelasAbaPavIntComp();
            limparTabelaProdutosInternos();
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codAlterarAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                Integer rows = jTabelaInternosSelecionados.getRowCount();
                if (rows == 0) {
                    acao = 2;
                    bloquearBotoes();
                    bloquearCampos();
                    Alterar();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    acao = 2;
                    bloquearBotoes();
                    bloquearCampos();
                    jBtSalvar.setEnabled(true);
                    jBtCancelar.setEnabled(true);
                    jBtPesquisarColaborador.setEnabled(true);
                    jObservacao.setEnabled(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codExcluirAL == 1) {
            objComp.setStatusComp(jStatusComp.getText());
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                verificarDadosIniciais();
                //
                if (jIdRegistroComp.getText().equals(codRequisicao)
                        || jIdRegistroComp.getText().equals(codRequisicao1)
                        || jIdRegistroComp.getText().equals(codRequisicao2)
                        || jIdRegistroComp.getText().equals(codRequisicao3)) {
                    JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objComp.setIdRegistroComp(Integer.parseInt(jIdRegistroComp.getText()));
                        control.excluirComposicaoKitlInternos(objComp);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        bloquearBotoes();
                        bloquearCampos();
                        limparCampos();
                        limparTabelaItensKit();
                        limparTabelasAbaPavIntComp();
                        Excluir();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitAL) && codGravarAL == 1) {
            if (jDataComp.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do registro.");
            } else if (codigoPesquisaKit == 0 && codigoPesquisaKitItem == 0) {
                JOptionPane.showMessageDialog(rootPane, "Os códigos do tipo de kit e dos produtos dos kits estão nulos, faça uma nova pesquisa.");
            } else if (jIdFunc.getText().equals("") && jNomeColaborador.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o colaborador responsável.");
            } else {
                objComp.setDataComp(jDataComp.getDate());
                objComp.setStatusComp(jStatusComp.getText());
                objComp.setIdKit(codigoPesquisaKit);
                objComp.setIdItem(codigoPesquisaKitItem);
                objComp.setIdFunc(Integer.valueOf(jIdFunc.getText()));
                objComp.setNomeColaborador(jNomeColaborador.getText());
                objComp.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objComp.setUsuarioInsert(nameUser);
                    objComp.setDataInsert(dataModFinal);
                    objComp.setHorarioInsert(horaMov);
                    control.incluirComposicaoKitlInternos(objComp);
                    buscarCodigoDadosIniciais();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objComp.setUsuarioUp(nameUser);
                    objComp.setDataUp(dataModFinal);
                    objComp.setHorarioUp(horaMov);
                    objComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                    control.alterarComposicaoKitlInternos(objComp);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    bloquearBotoes();
                    bloquearCampos();
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosSelecionados.getRowCount();
        if (rows == 0) {
            bloquearBotoes();
            bloquearCampos();
            Cancelar();
        } else {
            bloquearBotoes();
            bloquearCampos();
            Cancelar();
            jBtNovoPavInternos.setEnabled(!true);
            jBtExcluirPavInternosTodos.setEnabled(true);
        }
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        count = 0;
        count1 = 0;
        count2 = 0;
        qtdInternos = 0;
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaComposicaoKit objAudKit0 = new TelaAuditoriaComposicaoKit();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudKit0);
        objAudKit0.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jRBtKitInicialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitInicialItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + codigoPesquisaKit + "'");
        }
        pTipoKitCI = 1;
    }//GEN-LAST:event_jRBtKitInicialItemStateChanged

    private void jRBtKitQuinzenalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitQuinzenalItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + codigoPesquisaKit + "'");
        }
        pTipoKitCI = 3;
    }//GEN-LAST:event_jRBtKitQuinzenalItemStateChanged

    private void jRBtKitMensalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitMensalItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + codigoPesquisaKit + "'");
        }
        pTipoKitCI = 4;
    }//GEN-LAST:event_jRBtKitMensalItemStateChanged

    private void jRBtKitDecendialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitDecendialItemStateChanged
        // TODO add your handling code here:          
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + codigoPesquisaKit + "'");
        }
        pTipoKitCI = 2;
    }//GEN-LAST:event_jRBtKitDecendialItemStateChanged

    private void jRBtKitSemestralItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitSemestralItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + codigoPesquisaKit + "'");
        }
        pTipoKitCI = 5;
    }//GEN-LAST:event_jRBtKitSemestralItemStateChanged

    private void jRBtKitAnualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBtKitAnualItemStateChanged
        // TODO add your handling code here:
        count = 0;
        if (evt.getStateChange() == evt.SELECTED) {
            preencherTabelaItensKit("SELECT * FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + codigoPesquisaKit + "'");
        }
        pTipoKitCI = 6;
    }//GEN-LAST:event_jRBtKitAnualItemStateChanged

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        if (jStatusComp.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(null, "Esse registro já foi FINALIZADO.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                mostrarFinalizacao();
            }
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtPesquisarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarKitActionPerformed
        // TODO add your handling code here:
        mostrarBuscaKit();
    }//GEN-LAST:event_jBtPesquisarKitActionPerformed

    private void jBtPesquisarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarColaboradorActionPerformed
        // TODO add your handling code here:
        mostrarColaborador();
    }//GEN-LAST:event_jBtPesquisarColaboradorActionPerformed

    private void jBtPesquisaCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCompActionPerformed
        // TODO add your handling code here:
        bloquearBotoes();
        bloquearCampos();
        mostrarPesquisas();
        Integer rows = jTabelaInternosSelecionados.getRowCount();
        if (rows != 0) {
            jBtNovoPavInternos.setEnabled(true);
            jBtExcluirPavInternosTodos.setEnabled(true);
            jBtExcluirInternosUmaUm.setEnabled(true);
            //
            jBtNovoProduto.setEnabled(true);
        } else {
            jBtNovoPavInternos.setEnabled(true);
        }
    }//GEN-LAST:event_jBtPesquisaCompActionPerformed

    private void jBtNovoPavInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPavInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitPavIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitPavIntAL) && codIncluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                Integer rows = jTabelaInternosSelecionados.getRowCount();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                if (rows == 0) {
                    bloquearBotoes();
                    bloquearCampos();
                    NovoPavilhaoInterno();
                    pesquisarPavilhao();
                } else {
                    bloquearBotoes();
                    bloquearCampos();
                    NovoPavilhaoInterno();
                    pesquisarPavilhao();
                    jBtExcluirPavInternosTodos.setEnabled(!true);
                    jBtExcluirInternosUmaUm.setEnabled(!true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoPavInternosActionPerformed

    private void jBtExcluirPavInternosTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPavInternosTodosActionPerformed
        // TODO add your handling code here:        
        Integer rows = jTabelaInternosKitCompleto.getRowCount();
        Integer row = jTabelaProdutosKitCompleto.getRowCount();
        Integer row1 = jTabelaProdutos.getRowCount();
        buscarAcessoUsuario(telaMontagemPagamentoKitPavIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitPavIntAL) && codExcluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                if (rows != 0 || row != 0 || row1 != 0) {
                    JOptionPane.showMessageDialog(null, "Não é possível excluir os registros dessa tabela, os mesmos estão sendo utilizados em outro local.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // ALTERAR O CAMPO Utilizado NA TABELA KITS_INICIAL_INTERNOS
                        for (int i = 0; i < jTabelaInternosSelecionados.getRowCount(); i++) {
                            objProCrc.setKitIPago(opcaoKit);
                            objProCrc.setIdInterno((int) jTabelaInternosSelecionados.getValueAt(i, 0));
                            controleKits.atualizarInternoKitInicial(objProCrc);
                        }
                        objPavInt.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                        controle.excluirPavilhaoInternos(objPavInt);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        bloquearBotoes();
                        bloquearCampos();
                        limparTabelasAbaPavIntComp();
                        ExcluirPavilhaoInterno();
                        JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirPavInternosTodosActionPerformed

    private void jBtSalvarPavInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPavInternosActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaMontagemPagamentoKitPavIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitPavIntAL) && codGravarAL == 1) {
            mostrarThread();
            bloquearBotoes();
            bloquearCampos();
            SalvarPavilhaoInterno();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarPavInternosActionPerformed

    private void jBtCancelarPavilhaoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPavilhaoInternoActionPerformed
        // TODO add your handling code here:
        bloquearBotoes();
        bloquearCampos();
        CancelarPavilhaoInterno();
    }//GEN-LAST:event_jBtCancelarPavilhaoInternoActionPerformed

    private void jBtSelecionarUmInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarUmInternoActionPerformed
        // TODO add your handling code here:  
        Integer row = jTabelaInternosSelecionados.getRowCount();
        boolean encontrou = !true;
        if (jTabelaInternos.getSelectedRowCount() != 0 && row == 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores  
            if (row == 0) {
                count2 = count2 + 1;
                qtdInternos = qtdInternos - 1;
                jtotalInternosSelecionados.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
            } else if (row != 0) {
                qtdTotal = count2 + qtdInternosKD;
                jtotalInternosSelecionados.setText(Integer.toString(qtdTotal)); // Converter inteiro em string para exibir na tela                                
            }
            //Pega os models das listas, para fazer as inserções e remoções
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternos.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
            //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
            Object[] obj = {jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0), jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1), jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2)};
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            //Adiciona no destino e remove da origem
            modelDestino.addRow(obj);
            modelOrigem.removeRow(jTabelaInternos.getSelectedRow());
        } else if (jTabelaInternos.getSelectedRowCount() != 0 && row != 0) {
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternos.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
            // VERIFICAR SE O PRODUTO JÁ EXISTE NA TABELA, SE EXITIR AVISA.
            for (int i = 0; i < jTabelaInternosSelecionados.getRowCount(); i++) {
                String codInter = "" + jTabelaInternosSelecionados.getValueAt(i, 0).toString();
                if (idInterno.equals(codInter)) {
                    encontrou = true;
                    break;
                } else {
                    encontrou = !true;
                }
            }
            if (encontrou == true) {
                JOptionPane.showMessageDialog(rootPane, "Interno já foi selecionado, escolha outro.");
            } else if (encontrou == !true) {
                count2 = count2 + 1;
                qtdInternos = qtdInternos - 1;
                jtotalInternosSelecionados.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                //Adiciona no destino e remove da origem
                Object[] obj = {jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0), jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1), jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2)};
                modelDestino.addRow(obj);
                modelOrigem.removeRow(jTabelaInternos.getSelectedRow());
            }
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
            //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.                    
        }
    }//GEN-LAST:event_jBtSelecionarUmInternoActionPerformed

    private void jBtSelecionarTodosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarTodosInternosActionPerformed
        // TODO add your handling code here:
        flag = 0;
        count2 = 0;
        qtdInternos = 0;
        Integer rows = jTabelaInternos.getModel().getRowCount();
        Integer row0 = jTabelaInternosSelecionados.getModel().getRowCount();
        if (rows != 0) {
            //KIT INICIAL
            if (pTipoKitCI == 1) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controle.read()) {
                        if (row0 == 0) {
                            jtotalInternosSelecionados.setText(jtotalInternosPavilhao.getText()); // Converter inteiro em string para exibir na tela     
                        } else {
                            qtdTotal = qtdInternosSelec + qtdInternos;
                            jtotalInternosSelecionados.setText(Integer.toString(qtdTotal)); // Converter inteiro em string para exibir na tela                                
                        }
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
                DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
                if (tblRemove.getRowCount() > 0) {
                    for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                        if (tblRemove.getRowCount() < i) {
                            tblRemove.removeRow(i);
                            tblRemove.setRowCount(0);
                        }
                    }
                }
                // LIMPAR O TOTALIZADOR DA TABELA
                jtotalInternosPavilhao.setText("");
                //KIT DECENDIAL
            } else if (pTipoKitCI == 2) {
                qtdInternos = 0;
                qtdInternosKD = 0;
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKD.read()) {
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                    if (row0 == 0) {
                        jtotalInternosSelecionados.setText(Integer.toString(qtdInternos));
                        qtdTotal = qtdInternos;
                    } else if (row0 != 0) {
                        qtdTotal += qtdInternosKD;
                        jtotalInternosSelecionados.setText(Integer.toString(qtdTotal)); // Converter inteiro em string para exibir na tela                                
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
                DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
                if (tblRemove.getRowCount() > 0) {
                    for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                        if (tblRemove.getRowCount() < i) {
                            tblRemove.removeRow(i);
                            tblRemove.setRowCount(0);
                        }
                    }
                }
                // LIMPAR O TOTALIZADOR DA TABELA
                jtotalInternosPavilhao.setText("0");
                qtdInternos = 0;
                //KIT QUINZENAL
            } else if (pTipoKitCI == 3) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKQ.read()) {
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                        jtotalInternosSelecionados.setText(jtotalInternosPavilhao.getText()); // Converter inteiro em string para exibir na tela     
//                    jtotalInternosSelecionados.setText(Integer.toString(qtdInternosSelec + qtdInternos)); // Converter inteiro em string para exibir na tela                                                         
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
                DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
                if (tblRemove.getRowCount() > 0) {
                    for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                        if (tblRemove.getRowCount() < i) {
                            tblRemove.removeRow(i);
                            tblRemove.setRowCount(0);
                        }
                    }
                }
                // LIMPAR O TOTALIZADOR DA TABELA
                jtotalInternosPavilhao.setText("");
                //KIT MENSAL
            } else if (pTipoKitCI == 4) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKM.read()) {
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                        jtotalInternosSelecionados.setText(jtotalInternosPavilhao.getText()); // Converter inteiro em string para exibir na tela                 
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
                DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
                if (tblRemove.getRowCount() > 0) {
                    for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                        if (tblRemove.getRowCount() < i) {
                            tblRemove.removeRow(i);
                            tblRemove.setRowCount(0);
                        }
                    }
                }
                // LIMPAR O TOTALIZADOR DA TABELA
                jtotalInternosPavilhao.setText("");
                //KIT SEMESTRAL
            } else if (pTipoKitCI == 5) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKS.read()) {
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                        jtotalInternosSelecionados.setText(jtotalInternosPavilhao.getText()); // Converter inteiro em string para exibir na tela     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
                DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
                if (tblRemove.getRowCount() > 0) {
                    for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                        if (tblRemove.getRowCount() < i) {
                            tblRemove.removeRow(i);
                            tblRemove.setRowCount(0);
                        }
                    }
                }
                // LIMPAR O TOTALIZADOR DA TABELA
                jtotalInternosPavilhao.setText("");
                //KIT ANUAL
            } else if (pTipoKitCI == 6) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKA.read()) {
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                        jtotalInternosSelecionados.setText(jtotalInternosPavilhao.getText()); // Converter inteiro em string para exibir na tela                                                                 
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosSelecionados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                // APAGAR TODOS OS REGISTROS DA TABELA COPIADA
                DefaultTableModel tblRemove = (DefaultTableModel) jTabelaInternos.getModel();
                if (tblRemove.getRowCount() > 0) {
                    for (int i = 0; i <= tblRemove.getRowCount(); i++) {
                        tblRemove.removeRow(i);
                        tblRemove.setRowCount(0);
                        if (tblRemove.getRowCount() < i) {
                            tblRemove.removeRow(i);
                            tblRemove.setRowCount(0);
                        }
                    }
                }
                // LIMPAR O TOTALIZADOR DA TABELA
                jtotalInternosPavilhao.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "A tabela com os internos a serem selecionados, não contém itens.");
        }
    }//GEN-LAST:event_jBtSelecionarTodosInternosActionPerformed

    private void jBtExcluirUmInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirUmInternoActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosSelecionados.getModel().getRowCount();
        Integer row0 = jTabelaInternos.getModel().getRowCount();
        if (rows != 0) {
            if (jTabelaInternosSelecionados.getSelectedRowCount() != 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores               
                if (row0 == 0) {
                    qtdInternos = 0;
                    qtdInternos++;
                    count2 = 0;
                    count2 = qtdTotal - 1;
                    jtotalInternosSelecionados.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                    jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                } else if (row0 != 0) {
                    qtdInternos++;
                    count2 = count2 - 1;
                    jtotalInternosSelecionados.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                    jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                }
                //Pega os models das listas, para fazer as inserções e remoções
                DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternos.getModel();
                //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
                Object[] obj = {jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 0), jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 1), jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 2)};
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                //Adiciona no destino e remove da origem
                modelDestino.addRow(obj);
                modelOrigem.removeRow(jTabelaInternosSelecionados.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
                //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.            
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe dados a ser excluído.");
        }
    }//GEN-LAST:event_jBtExcluirUmInternoActionPerformed

    private void jBtExcluirTodosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTodosInternosActionPerformed
        // TODO add your handling code here:
        flag = 0;
        Integer rows = jTabelaInternosSelecionados.getModel().getRowCount();
        if (pTipoKitCI == 1) {
            if (rows != 0) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controle.read()) {
                        jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalInternosSelecionados.setText("");
            // KIT DECENDIAL
        } else if (pTipoKitCI == 2) {
            if (rows != 0) {
                // APAGAR DADOS DA TABELA ANTES DE POPULAR
                while (jTabelaInternos.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
                }
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKD.read()) {
                        jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalInternosSelecionados.setText("");
            //KIT QUINZENAL
        } else if (pTipoKitCI == 3) {
            if (rows != 0) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKQ.read()) {
                        jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalInternosSelecionados.setText("");
            //KIT MENSAL
        } else if (pTipoKitCI == 4) {
            if (rows != 0) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKM.read()) {
                        jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalInternosSelecionados.setText("");
            //KIT SEMESTRAL
        } else if (pTipoKitCI == 5) {
            if (rows != 0) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKS.read()) {
                        jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalInternosSelecionados.setText("");
            //KIT ANUAL
        } else if (pTipoKitCI == 6) {
            if (rows != 0) {
                DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKA.read()) {
                        jtotalInternosPavilhao.setText(jtotalInternosSelecionados.getText()); // Converter inteiro em string para exibir na tela                                     
                        dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            // APAGAR DADOS DA TABELA
            while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
            }
            // LIMPAR O TOTALIZADOR DA TABELA
            jtotalInternosSelecionados.setText("");
        }
    }//GEN-LAST:event_jBtExcluirTodosInternosActionPerformed

    private void jBtPesquisarInternosPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternosPavilhaoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxPavilhoes.getSelectedItem() == null || jComboBoxPavilhoes.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar o pavilhão para incluir os internos.");
        } else {
            count1 = 0;
            qtdInternos = 0;
            qtdInternosKD = 0;
            //LIMPAR A TABELA
            while (jTabelaInternos.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
            }
            jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
            // PESQUISA DE INTERNOS QUANDO O KIT FOR INICIAL.
            // KIT INICIAL
            if (pTipoKitCI == 1) {
                qtdInternos = 0;
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controle.read()) {
                        pCODIGO_pavilhao = dd.getIdPav();
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                // KIT DECENDIAL
            } else if (pTipoKitCI == 2) {
//                qtdInternosKD = 0;
//                qtdInternos = 0;
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKD.read()) {
                        pCODIGO_pavilhao = dd.getIdPav();
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                // KIT QUINZENAL
            } else if (pTipoKitCI == 3) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKQ.read()) {
                        pCODIGO_pavilhao = dd.getIdPav();
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                // KIT MENSAL
            } else if (pTipoKitCI == 4) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKM.read()) {
                        pCODIGO_pavilhao = dd.getIdPav();
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                // KIT SEMESTRAL
            } else if (pTipoKitCI == 5) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKS.read()) {
                        pCODIGO_pavilhao = dd.getIdPav();
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                // KIT ANUAL
            } else if (pTipoKitCI == 6) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternos.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : controleKA.read()) {
                        pCODIGO_pavilhao = dd.getIdPav();
                        jtotalInternosPavilhao.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jBtPesquisarInternosPavilhaoActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            cncInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            nomeInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 2);
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtSaldoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSaldoEstoqueActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitPavIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitPavIntAL) && codConsultarAL == 1) {
            if (jIdRegistroComp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessario pesquisar o registro de montagem do kit para consultar o saldo de estoque.");
            } else {
                mostraEstoque();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSaldoEstoqueActionPerformed

    private void jBtSelecionarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarProdutosActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosSelecionados.getRowCount();
        if (rows != 0) {
            mostrarEstoqueProdutosKit();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe internos para seleção de produtos.");
        }
    }//GEN-LAST:event_jBtSelecionarProdutosActionPerformed

    private void jBtNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoProdutoActionPerformed
        // TODO add your handling code here:telaMontagemPagamentoKitProdutosAL
        buscarAcessoUsuario(telaMontagemPagamentoKitProdutosAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitProdutosAL) && codIncluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                Integer rows = jTabelaInternosSelecionados.getRowCount();
                if (rows != 0) {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    acao = 3;
                    bloquearCampos();
                    bloquearBotoes();
                    NovoProduto();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não existe internos selecionados para incluir produtos.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoProdutoActionPerformed

    private void jBtAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarProdutoActionPerformed
        // TODO add your handling code here:
        Integer row0 = jTabelaInternosKitCompleto.getRowCount();
        Integer row1 = jTabelaProdutosKitCompleto.getRowCount();
        //CRIAR METODO PARA IMPEDIR DE ALTERAR, CASO O PRODUTO TENHA SIDO UTILIZADO NA ASSOCIAÇÃO DO KIT
        buscarAcessoUsuario(telaMontagemPagamentoKitProdutosAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitProdutosAL) && codAlterarAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else if (row0 == 0 && row1 == 0) {
                acao = 4;
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                bloquearCampos();
                bloquearBotoes();
                AlterarProduto();
            } else {
                JOptionPane.showMessageDialog(null, "Não é possível modificar os registros dessa tela, existem registros vinculados a essa tabela.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAlterarProdutoActionPerformed

    private void jBtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirProdutoActionPerformed
        // TODO add your handling code here:  
        //CRIAR METODO PARA IMPEDIR DE EXCLUIR, CASO O PRODUTO TENHA SIDO UTILIZADO NA ASSOCIAÇÃO DO KIT
        buscarAcessoUsuario(telaMontagemPagamentoKitProdutosAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitProdutosAL) && codExcluirAL == 1) {
            objComp.setStatusComp(jStatusComp.getText());
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                Integer rows = jTabelaInternosKitCompleto.getRowCount();
                Integer row = jTabelaProdutosKitCompleto.getRowCount();
                if (rows != 0 || row != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe registro em outra tabela.");
                } else {
                    DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
                    qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
                    statusMov = "Excluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodigoProd.getText()));
                        pegarSaldoEstoque(objItensReqMatInter.getIdProd());
                        try {
                            objProdKit.setQuantidadeProd(qtdReal.parse(jQtdAtendida.getText()).intValue());
                        } catch (ParseException ex) {
                        }
                        // CALCULA O NOVO SALDO DE ESTOQUE
                        estoqueAtual = saldoEstoque + objProdKit.getQuantidadeProd();
                        // ATUALIZA O SALDO NA TABELA LOTE_PRODUTOS_AC
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodigoProd.getText()));
                        objItensReqMatInter.setQtdItem(estoqueAtual);
                        controleLote.alterarEstoqueMaterais(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_AC  
                        //EXCLUIR DA TABELA ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE
                        objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                        objProdKit.setIdProd(Integer.valueOf(jCodigoProd.getText()));
                        controleProd.excluirProdutosKitInternos(objProdKit);
                        //
                        bloquearCampos();
                        bloquearBotoes();
                        ExcluirProduto();
                        LIMPAR_TABELA_Produtos();
                        PREENCHER_TABELA_Produtos();
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirProdutoActionPerformed

    private void jBtSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarProdutoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitProdutosAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitProdutosAL) && codGravarAL == 1) {
            DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
            qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jCodigoProd.getText().equals("") && jDescricaoProd.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o produto para ser dados saída de estoque.");
            } else if (jQtdAtendida.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade do produto para ser dados saída de estoque.");
            } else {
                objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                objProdKit.setIdProd(Integer.valueOf(jCodigoProd.getText()));
                objProdKit.setDescricaoProduto(jDescricaoProd.getText());
                objProdKit.setIdKit(idKit);
                objProdKit.setpUtili(pUtili);
                try {
                    objProdKit.setQuantidadeProd(qtdReal.parse(jQtdAtendida.getText()).intValue());
                } catch (ParseException ex) {
                }
                verificarProdutoIncluido();
                if (acao == 3) {
                    if (jIdRegistroComp.getText().equals(pRegistroComp) && jCodigoProd.getText().equals(pcodigoProduto)) {
                        JOptionPane.showMessageDialog(null, "Produto já foi incluído nesse registro.");
                    } else {
                        objProdKit.setUsuarioInsert(nameUser);
                        objProdKit.setDataInsert(dataModFinal);
                        objProdKit.setHorarioInsert(horaMov);
                        // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE
                        pegarSaldoEstoque(objProdKit.getIdProd());
                        //
                        if (saldoEstoque >= objProdKit.getQuantidadeProd()) {
                            // CALCULA O NOVO SALDO DE ESTOQUE
                            estoqueAtual = saldoEstoque - objProdKit.getQuantidadeProd();
                            // TABELA ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE
                            controleProd.incluirProdutosKitInternos(objProdKit);
                            buscarProdutoKit();
                            //
                            objItensReqMatInter.setIdProd(Integer.valueOf(jCodigoProd.getText()));
                            objItensReqMatInter.setQtdItem(estoqueAtual);
                            controleLote.alterarEstoqueMaterais(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_AC   
                            objLog3();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearCampos();
                            bloquearBotoes();
                            limparCamposProdutos();
                            SalvarProduto();
                            LIMPAR_TABELA_Produtos();
                            PREENCHER_TABELA_Produtos();
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Saldo de Estoque insuficiente para atender esse registro.");
                        }
                    }
                }
                if (acao == 4) {
                    objProdKit.setUsuarioUp(nameUser);
                    objProdKit.setDataUp(dataModFinal);
                    objProdKit.setHorarioUp(horaMov);
                    // PEGA PRODUTO PARA CALCULAR SALDO DE ESTOQUE
                    pegarSaldoEstoque(objProdKit.getIdProd());
                    // CALCULA O NOVO SALDO DE ESTOQUE 
                    novoSaldoAtual = (float) (qtdItemAnterior + saldoEstoque); // SOMA O SALDO DA TABELA LOTE COM A TABELA ITENS_REQUISICAO           
                    //
                    if (novoSaldoAtual >= objProdKit.getQuantidadeProd()) {
                        estoqueAtual = (float) (novoSaldoAtual - objProdKit.getQuantidadeProd()); // DEDUZ O SALDO DE ESTOQUE E GRAVA                                     
                        try {
                            objProdKit.setQuantidadeProd(qtdReal.parse(jQtdAtendida.getText()).intValue());
                        } catch (ParseException ex) {
                        }
                        // TABELA ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE
                        controleProd.alterarProdutosKitInternos(objProdKit);
                        // TABELA ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE
                        objItensReqMatInter.setIdProd(Integer.valueOf(jCodigoProd.getText()));
                        objItensReqMatInter.setQtdItem(estoqueAtual);
                        controleLote.alterarEstoqueMaterais(objItensReqMatInter); // TABELA DE LOTE_PRODUTOS_AC 
                        bloquearCampos();
                        bloquearBotoes();
                        limparCamposProdutos();
                        SalvarProduto();
                        LIMPAR_TABELA_Produtos();
                        PREENCHER_TABELA_Produtos();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Quantidade requisitada é maior que o saldo de estoque.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarProdutoActionPerformed

    private void jBtCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarProdutoActionPerformed
        // TODO add your handling code here:
        bloquearCampos();
        bloquearBotoes();
        limparCamposProdutos();
        CancelarProduto();
    }//GEN-LAST:event_jBtCancelarProdutoActionPerformed

    private void jBtConsultarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConsultarEstoqueActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitPavIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitPavIntAL) && codConsultarAL == 1) {
            if (jIdRegistroComp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessario pesquisar o registro de montagem do kit para consultar o saldo de estoque.");
            } else {
                mostraEstoque();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtConsultarEstoqueActionPerformed

    private void jBtAuditoriaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaProdutoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaComposicaoKitProdutos objAudiKitProd = new TelaAuditoriaComposicaoKitProdutos();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiKitProd);
        objAudiKitProd.show();
    }//GEN-LAST:event_jBtAuditoriaProdutoActionPerformed

    private void jTabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProdutosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        Integer rows = jTabelaProdutos.getRowCount();
        if (rows != 0) {
            if (flag == 1) {
                nomeProduto = "" + jTabelaProdutos.getValueAt(jTabelaProdutos.getSelectedRow(), 2);
                jDescricaoProd.setText(nomeProduto);
                idProduto = "" + jTabelaProdutos.getValueAt(jTabelaProdutos.getSelectedRow(), 1);
                jCodigoProd.setText(idProduto);
                idItem = "" + jTabelaProdutos.getValueAt(jTabelaProdutos.getSelectedRow(), 0);
                bloquearBotoes();
                bloquearCampos();
                //
                jBtNovoProduto.setEnabled(true);
                jBtAlterarProduto.setEnabled(true);
                jBtExcluirProduto.setEnabled(true);
                jBtSalvarProduto.setEnabled(!true);
                jBtCancelarProduto.setEnabled(true);
                jBtAuditoriaProduto.setEnabled(true);
                //
                CONTROLE.EXIBIR_PRODUTO_gravado(objProdKit);
                jCodigoProd.setText(String.valueOf(objProdKit.getIdProd()));
                jDescricaoProd.setText(objProdKit.getDescricaoProduto());
                idItem = String.valueOf(objProdKit.getIdRegProdKit());
                pPESQUISA_ID_kit = objProdKit.getIdKit();
                jUnidadeProd.setText(objProdKit.getUnidadeProd());
                // QUANTIDADE DO ESTOQUE                                                  
                qtdEstoque = objProdKit.getQtdEstoque();
                DecimalFormat vu = new DecimalFormat("##,###0.00");
                String qtE = vu.format(qtdEstoque);
                jQuantidadeProdEstoque.setText(qtE);
                // PEGA QUANTIDADE PARA CALCULAR SE O USUARIO ALTERAR A QUANTIDADE.
                qtdItemAnterior = objProdKit.getQuantidadeProd();
                qtdItem = objProdKit.getQuantidadeProd();
                DecimalFormat vi = new DecimalFormat("##,###0.00");
                String vqtdItem = vi.format(qtdItem);
                jQtdAtendida.setText(vqtdItem);
                // QUANTIDADE DE INTERNOS
                jQuantidadeInternos.setText(jtotalInternosSelecionados.getText());
                pPESQUISAR_QUANTIDADE_Item();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto para alterar ou excluir.");
        }
    }//GEN-LAST:event_jTabelaProdutosMouseClicked

    private void jBtAdicionarTodosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarTodosInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoIntAL) && codIncluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                acao = 5;
                tipoKitCI = 1;
                mostrarSelecaoInternos();
                bloquearBotoes();
                bloquearCampos();
                jBtSalvarInternosSelecionados.setEnabled(true);
                jBtExcluirTodosInternosSelecionados.setEnabled(true);
                jBtExcluirUmInternoAgrupado.setEnabled(true);
                jBtSalvarInternosSelecionados.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAdicionarTodosInternosActionPerformed

    private void jBtExcluirTodosInternosSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTodosInternosSelecionadosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoIntAL) && codExcluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarInternosDB();//
                if (jIdRegistroComp.getText().equals(codigoRegExcluir)) {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir todos registros do banco de dados?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objGravaIntComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                        controleIntSelec.excluirTodosInternosKitCompleto(objGravaIntComp);
                        // APAGAR DADOS DA TABELA
                        while (jTabelaInternosKitCompleto.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaInternosKitCompleto.getModel()).removeRow(0);
                        }
                        JOptionPane.showMessageDialog(null, "Registros excluídos com sucesso.");
                    }
                } else {
                    Integer rows = jTabelaInternosKitCompleto.getRowCount();
                    if (rows != 0) {
                        // APAGAR DADOS DA TABELA
                        while (jTabelaInternosKitCompleto.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaInternosKitCompleto.getModel()).removeRow(0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existe registros a serem excluído.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirTodosInternosSelecionadosActionPerformed

    private void jBtExcluirUmInternoAgrupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirUmInternoAgrupadoActionPerformed
        // TODO add your handling code here:   
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoIntAL) && codExcluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarInternoDBUm();
                if (jIdRegistroComp.getText().equals(codigoRegExcluir) && Integer.valueOf(codigoInternoCrc).equals(idInternoComp)) {
                    if (jTabelaInternosKitCompleto.getSelectedRowCount() != 0) {
                        String pUtili = "Não";
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registros selecioado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            qtdInternosKitComp = qtdInternosKitComp - 1;
                            objGravaIntComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                            objGravaIntComp.setIdInternoCrc(idInternoComp);
                            controleIntSelec.excluirInternosKitCompleto(objGravaIntComp);
                            // FAZ UM UPDATE NA TABELA INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS INTERNOS PARA 
                            // O KIT COMPLETO - NO CASO DA EXCLUSÃO, O INTERNO RETORNA A LISTA DE NÃO UTILIZADOS NO IT COMPLETO
                            objGravaIntComp.setUtili(pUtili);
                            controleIntSelec.atualizarInternosPavilhao(objGravaIntComp);
                            //
                            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosKitCompleto.getModel();
                            modelOrigem.removeRow(jTabelaInternosKitCompleto.getSelectedRow());
                            jtotalInternosKitCompleto.setText(Integer.toString(qtdInternosKitComp)); // Converter inteiro em string para exibir na tela 
                            JOptionPane.showMessageDialog(null, "Registros excluídos com sucesso.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para excluir o registros da tabela.");
                        //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.                        
                    }
                } else {
                    if (jTabelaInternosKitCompleto.getSelectedRowCount() != 0) {
                        qtdInternos = qtdInternos - 1;
                        DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosKitCompleto.getModel();
                        modelOrigem.removeRow(jTabelaInternosKitCompleto.getSelectedRow());
                        jtotalInternosKitCompleto.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
                        //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.                        
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirUmInternoAgrupadoActionPerformed

    private void jBtSalvarInternosSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternosSelecionadosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoIntAL) && codGravarAL == 1) {
            Integer rows = jTabelaInternosKitCompleto.getRowCount();
            if (rows != 0) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente confirmar essa operação?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    mostarTelaGrava();
                    jBtAdicionarProdutosKitCompleto.setEnabled(true);
                    jBtSalvarInternosSelecionados.setEnabled(!true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não existem registros de internos a ser gravado no banco de dados.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarInternosSelecionadosActionPerformed

    private void jTabelaInternosKitCompletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosKitCompletoMouseClicked
        // TODO add your handling code here:
        acao = 0;
        Integer rows = jTabelaInternosKitCompleto.getRowCount();
        flag = 1;
        if (rows != 0) {
            if (flag == 1) {
                codigoInternoCrc = "" + jTabelaInternosKitCompleto.getValueAt(jTabelaInternosKitCompleto.getSelectedRow(), 0);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                            + "AND ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + codigoInternoCrc + "'");
                    conecta.rs.first();
                    idInternoComp = conecta.rs.getInt("IdInternoCrc");
                    pGravadoDB = conecta.rs.getInt("Gravado");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
                }
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro para excluir.");
        }
    }//GEN-LAST:event_jTabelaInternosKitCompletoMouseClicked

    private void jBtAdicionarProdutosKitCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarProdutosKitCompletoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoProdAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoProdAL) && codIncluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                Integer row = jTabelaInternosKitCompleto.getRowCount();
                if (row != 0) {
                    listarProdutosKit();
                    jBtExcluirTodosProdutos.setEnabled(true);
                    jBtExcluirProdutoSelecionado.setEnabled(true);
                    jBtSalvarProdutoBanco.setEnabled(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAdicionarProdutosKitCompletoActionPerformed

    private void jBtExcluirTodosProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTodosProdutosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoProdAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoProdAL) && codExcluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarTodosProdutosDB();
                Integer rows = jTabelaProdutosKitCompleto.getRowCount();
                if (jIdRegistroComp.getText().equals(codigoRegExcluir)) {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir todos registros do banco de dados?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // FAZ UM UPDATE NA TABELA ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS PRODUTO PARA 
                        // O KIT COMPLETO - NO CASO DA EXCLUSÃO, O PRODUTO RETORNA A LISTA DE NÃO UTILIZADOS NO KIT COMPLETO
                        // FAZ UM UPDATE ANTES DE EXCLUIR
                        for (int i = 0; i < jTabelaProdutosKitCompleto.getRowCount(); i++) {
                            objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                            objProdKit.setTipoKitCI(pTipoKitCI);
                            objProdKit.setpUtili(pUtili);
                            objProdKit.setIdProd((int) jTabelaProdutosKitCompleto.getValueAt(i, 0));
                            controleProdKit.atualizarProdutoUtilizadoKit(objProdKit);
                        }
                        // DELETA TODOS OS REGISTROS DA TABELA (ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO)
                        objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                        objProdKit.setTipoKitCI(pTipoKitCI);
                        controleProdKit.excluirTodosProdutosKitCompletoIncompleto(objProdKit);
                        // APAGAR DADOS DA TABELA
                        while (jTabelaProdutosKitCompleto.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaProdutosKitCompleto.getModel()).removeRow(0);
                        }
                        jtotalProdutosKitCompleto.setText(Integer.toString(qtdInternosKitComp)); // Converter inteiro em string para exibir na tela 
                        JOptionPane.showMessageDialog(null, "Registros excluídos com sucesso.");
                    }
                } else {
                    if (rows != 0) {
                        // APAGAR DADOS DA TABELA
                        while (jTabelaProdutosKitCompleto.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaInternosKitCompleto.getModel()).removeRow(0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existe registros a serem excluído.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirTodosProdutosActionPerformed

    private void jBtExcluirProdutoSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirProdutoSelecionadoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoProdAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoProdAL) && codExcluirAL == 1) {
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                verificarUmProdutoDB();
                if (jIdRegistroComp.getText().equals(codigoRegExcluir) && Integer.valueOf(codigoProdExclui).equals(codigoProdutoExclui)) {
                    if (jTabelaProdutosKitCompleto.getSelectedRowCount() != 0) {
                        String pUtili = "Não";
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registros selecioado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
//                    qtdInternosKitComp = qtdInternosKitComp - 1;
                            objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                            objProdKit.setIdProd(codigoProdutoExclui);
                            objProdKit.setTipoKitCI(pTipoKitCI);
                            controleProdKit.excluirTodosProdutosKitCompletoIncompleto(objProdKit);
                            // FAZ UM UPDATE NA TABELA ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE INFORMANDO A UTILIZAÇÃO DOS PRODUTO PARA 
                            // O KIT COMPLETO - NO CASO DA EXCLUSÃO, O PRODUTO RETORNA A LISTA DE NÃO UTILIZADOS NO KIT COMPLETO
                            objProdKit.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                            objProdKit.setTipoKitCI(pTipoKitCI);
                            objProdKit.setpUtili(pUtili);
                            objProdKit.setIdProd(Integer.valueOf(codigoProdExclui));
                            controleProdKit.atualizarProdutoUtilizadoKit(objProdKit);
                            //
                            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaProdutosKitCompleto.getModel();
                            modelOrigem.removeRow(jTabelaProdutosKitCompleto.getSelectedRow());
//                    jtotalInternosKitCompleto.setText(Integer.toString(qtdInternosKitComp)); // Converter inteiro em string para exibir na tela 
                            JOptionPane.showMessageDialog(null, "Registros excluídos com sucesso.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para excluir o registro da tabela.");
                        //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.                        
                    }
                } else {
                    if (jTabelaProdutosKitCompleto.getSelectedRowCount() != 0) {
//                qtdInternos = qtdInternos - 1;
                        DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaProdutosKitCompleto.getModel();
                        modelOrigem.removeRow(jTabelaProdutosKitCompleto.getSelectedRow());
//                jtotalInternosKitCompleto.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para excluir o registro da tabela.");
                        //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.                        
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirProdutoSelecionadoActionPerformed

    private void jBtSalvarProdutoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarProdutoBancoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMontagemPagamentoKitCompletoProdAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitCompletoProdAL) && codGravarAL == 1) {
            Integer row = jTabelaProdutosKitCompleto.getRowCount();
            if (row != 0) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente confirmar essa operação?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    mostrarTelaGravacaoProdutoKitCompleto();
                    jBtFinalizar.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não existem dados a serem gravados.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarProdutoBancoActionPerformed

    private void jTabelaProdutosKitCompletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProdutosKitCompletoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        codigoProdExclui = "" + jTabelaProdutosKitCompleto.getValueAt(jTabelaProdutosKitCompleto.getSelectedRow(), 0);
        if (flag == 1) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                        + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + codigoProdExclui + "'");
                conecta.rs.first();
                codigoProdutoExclui = conecta.rs.getInt("IdProd");
                pTipoKitCI = conecta.rs.getInt("TipoKitCI");
                pGravadoDB = conecta.rs.getInt("Gravado");
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaProdutosKitCompletoMouseClicked

    private void jBtExcluirInternosUmaUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternosUmaUmActionPerformed
        // TODO add your handling code here:
        Integer row = jTabelaInternosSelecionados.getRowCount();
        Integer rows = jTabelaInternosKitCompleto.getRowCount();
        Integer rowss = jTabelaProdutosKitCompleto.getRowCount();
        buscarAcessoUsuario(telaMontagemPagamentoKitPavIntAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMontagemPagamentoKitPavIntAL) && codExcluirAL == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusComp.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(null, "Não é possível modificar esse registro, o mesmo encontra-se FINALIZADO.");
            } else {
                if (rows != 0 || rowss != 0) {
                    JOptionPane.showMessageDialog(null, "Não é possível excluir esse registro, existem itens relacionados a esse registro.");
                } else {
                    if (row == 0) {
                        JOptionPane.showMessageDialog(null, "Não existe dados na tabela a ser excluído");
                    } else if (jTabelaInternosSelecionados.getSelectedRowCount() != 0) {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            count2 = count2 - 1;
                            qtdInternos = qtdInternos + 1;
                            //
                            objProCrc.setKitIPago(opcaoKit);
                            objProCrc.setIdInterno(codigoInternoPav);
                            controleKits.atualizarInternoKitInicial(objProCrc);
                            //
                            objPavInt.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                            objPavInt.setIdInternoCrc(codigoInternoPav);
                            controle.excluirInternosUmPorUm(objPavInt);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            bloquearBotoes();
                            bloquearCampos();
                            ExcluirPavilhaoInterno();
                            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosSelecionados.getModel();
                            modelOrigem.removeRow(jTabelaInternosSelecionados.getSelectedRow());
                            jtotalInternosSelecionados.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                            jtotalInternosPavilhao.setText(Integer.toString(qtdInternos));
                            JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para excluir o registros da tabela.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirInternosUmaUmActionPerformed

    private void jTabelaInternosSelecionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosSelecionadosMouseClicked
        // TODO add your handling code here:
        acao = 0;
        Integer rows = jTabelaInternosSelecionados.getRowCount();
        flag = 1;
        if (rows != 0) {
            if (flag == 1) {
                codigoInternoCrc = "" + jTabelaInternosSelecionados.getValueAt(jTabelaInternosSelecionados.getSelectedRow(), 0);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM INTERNOS_PAVILHAO_KIT_LOTE "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                            + "AND INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc='" + codigoInternoCrc + "'");
                    conecta.rs.first();
                    codigoInternoPav = conecta.rs.getInt("IdInternoCrc");
                } catch (SQLException e) {
                    //  JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
                }
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro para excluir.");
        }
    }//GEN-LAST:event_jTabelaInternosSelecionadosMouseClicked

    private void jBtProgramarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtProgramarKitActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(botaoProgramarKitAL);
//        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(botaoProgramarKitAL) && codIncluirAL == 1) {
        if (!nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jBtProgramarKit.setEnabled(!true);
        } else {
            if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
                if (jStatusComp.getText().equals("FINALIZADO")) {
                    mostrarTelaPrevisaoKit();
                } else {
                    JOptionPane.showMessageDialog(null, "É necessário FINALIZAR O registro para poder fazer a programação do próximo kit.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
            }
        }
    }//GEN-LAST:event_jBtProgramarKitActionPerformed

    private void jBtConsultarPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConsultarPavilhaoActionPerformed
        // TODO add your handling code here:
        Integer row0 = jTabelaInternosSelecionados.getRowCount();
        if (row0 != 0) {
            mostrarPavilhao();
        }
    }//GEN-LAST:event_jBtConsultarPavilhaoActionPerformed

    private void jBtAuditoriaPavInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPavInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaComposicaoKitSelecInternos objAudKitSelec = new TelaAuditoriaComposicaoKitSelecInternos();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudKitSelec);
        objAudKitSelec.show();
    }//GEN-LAST:event_jBtAuditoriaPavInternosActionPerformed

    private void jBtAuditoriaKitCompletoFase4AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaKitCompletoFase4AActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaComposicaoKitFase4A objAudiF4A = new TelaAuditoriaComposicaoKitFase4A();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiF4A);
        objAudiF4A.show();
    }//GEN-LAST:event_jBtAuditoriaKitCompletoFase4AActionPerformed

    private void jBtAuditoriaKitProdutoCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaKitProdutoCompletoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaComposicaoKitFase4B objAudiF4B = new TelaAuditoriaComposicaoKitFase4B();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiF4B);
        objAudiF4B.show();
    }//GEN-LAST:event_jBtAuditoriaKitProdutoCompletoActionPerformed

    private void jBtProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtProgramacaoActionPerformed
        // TODO add your handling code here:
        mostrarProgramacao();
    }//GEN-LAST:event_jBtProgramacaoActionPerformed

    private void jBtHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtHelpActionPerformed
        // TODO add your handling code here:
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File("C:\\SysConp\\Manuais\\1 - REQUISITOS PARA COMPOR KIT DE HIGIENE DO CUSTODIADO.pdf\\"));
        } catch (IOException ex) {
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtHelpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosSelecionados.getRowCount();
        if (rows != 0) {
            mostrarBaixaLote();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe internos para seleção de produtos.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotoes;
    public static javax.swing.JButton jBtAdicionarProdutosKitCompleto;
    public static javax.swing.JButton jBtAdicionarTodosInternos;
    public static javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarProduto;
    public static javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaKitCompletoFase4A;
    private javax.swing.JButton jBtAuditoriaKitProdutoCompleto;
    public static javax.swing.JButton jBtAuditoriaPavInternos;
    private javax.swing.JButton jBtAuditoriaProduto;
    public static javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtCancelarPavilhaoInterno;
    private javax.swing.JButton jBtCancelarProduto;
    private javax.swing.JButton jBtConsultarEstoque;
    private javax.swing.JButton jBtConsultarPavilhao;
    public static javax.swing.JButton jBtExcluir;
    public static javax.swing.JButton jBtExcluirInternosUmaUm;
    public static javax.swing.JButton jBtExcluirPavInternosTodos;
    private javax.swing.JButton jBtExcluirProduto;
    private javax.swing.JButton jBtExcluirProdutoSelecionado;
    public static javax.swing.JButton jBtExcluirTodosInternos;
    private javax.swing.JButton jBtExcluirTodosInternosSelecionados;
    private javax.swing.JButton jBtExcluirTodosProdutos;
    public static javax.swing.JButton jBtExcluirUmInterno;
    private javax.swing.JButton jBtExcluirUmInternoAgrupado;
    public static javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtHelp;
    public static javax.swing.JButton jBtNovo;
    public static javax.swing.JButton jBtNovoPavInternos;
    public static javax.swing.JButton jBtNovoProduto;
    private javax.swing.JButton jBtPesquisaComp;
    private javax.swing.JButton jBtPesquisarColaborador;
    private javax.swing.JButton jBtPesquisarInternosPavilhao;
    private javax.swing.JButton jBtPesquisarKit;
    private javax.swing.JButton jBtProgramacao;
    public static javax.swing.JButton jBtProgramarKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSaldoEstoque;
    public static javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInternosSelecionados;
    public static javax.swing.JButton jBtSalvarPavInternos;
    private javax.swing.JButton jBtSalvarProduto;
    private javax.swing.JButton jBtSalvarProdutoBanco;
    public static javax.swing.JButton jBtSelecionarProdutos;
    public static javax.swing.JButton jBtSelecionarTodosInternos;
    public static javax.swing.JButton jBtSelecionarUmInterno;
    private javax.swing.JButton jButton1;
    public static javax.swing.JTextField jCodigoProd;
    public static javax.swing.JComboBox<String> jComboBoxPavilhoes;
    public static com.toedter.calendar.JDateChooser jDataComp;
    public static javax.swing.JTextField jDepartamentoColaborador;
    public static javax.swing.JTextField jDescricaoProd;
    public static javax.swing.JLabel jFotoColaborador;
    public static javax.swing.JTextField jIdFunc;
    public static javax.swing.JTextField jIdRegistroComp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeColaborador;
    public static javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jQtdAtendida;
    public static javax.swing.JTextField jQuantidadeInternos;
    public static javax.swing.JFormattedTextField jQuantidadeKit;
    public static javax.swing.JFormattedTextField jQuantidadeProdEstoque;
    public static javax.swing.JRadioButton jRBtKitAnual;
    public static javax.swing.JRadioButton jRBtKitDecendial;
    public static javax.swing.JRadioButton jRBtKitInicial;
    public static javax.swing.JRadioButton jRBtKitMensal;
    public static javax.swing.JRadioButton jRBtKitQuinzenal;
    public static javax.swing.JRadioButton jRBtKitSemestral;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JTextField jStatusComp;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTable jTabelaGeralProdutosKit;
    public static javax.swing.JTable jTabelaInternos;
    public static javax.swing.JTable jTabelaInternosKitCompleto;
    public static javax.swing.JTable jTabelaInternosSelecionados;
    public static javax.swing.JTable jTabelaProdutos;
    public static javax.swing.JTable jTabelaProdutosKitCompleto;
    public static javax.swing.JTextField jUnidadeProd;
    public static javax.swing.JLabel jtotalInternosKitCompleto;
    public static javax.swing.JLabel jtotalInternosPavilhao;
    public static javax.swing.JLabel jtotalInternosSelecionados;
    public static javax.swing.JLabel jtotalProdutosKit;
    public static javax.swing.JLabel jtotalProdutosKitCompleto;
    public static javax.swing.JLabel jtotalProdutosKitInternos;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        //DADOS INICIAIS E ABA GERAL
        jIdRegistroComp.setBackground(Color.white);
        jStatusComp.setBackground(Color.white);
        jDataComp.setBackground(Color.white);
        jIdFunc.setBackground(Color.white);
        jNomeColaborador.setBackground(Color.white);
        jDepartamentoColaborador.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        // ABA FASE - 3
        jCodigoProd.setBackground(Color.white);
        jQtdAtendida.setBackground(Color.white);
        jUnidadeProd.setBackground(Color.white);
        jQuantidadeProdEstoque.setBackground(Color.white);
        jQuantidadeKit.setBackground(Color.white);
        jDescricaoProd.setBackground(Color.white);
        jQuantidadeInternos.setBackground(Color.white);
    }

    public void bloquearCampos() {
        // FASE - 1
        jIdRegistroComp.setEnabled(!true);
        jStatusComp.setEnabled(!true);
        jDataComp.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jRBtKitInicial.setEnabled(!true);
        jRBtKitQuinzenal.setEnabled(!true);
        jRBtKitMensal.setEnabled(!true);
        jRBtKitDecendial.setEnabled(!true);
        jRBtKitSemestral.setEnabled(!true);
        jRBtKitAnual.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // FASE - 2
        jComboBoxPavilhoes.setEnabled(!true);
        // FASE - 3
        jCodigoProd.setEnabled(!true);
        jQtdAtendida.setEnabled(!true);
        jUnidadeProd.setEnabled(!true);
        jQuantidadeProdEstoque.setEnabled(!true);
        jQuantidadeKit.setEnabled(!true);
        jDescricaoProd.setEnabled(!true);
    }

    public void bloquearBotoes() {
        // FASE - 1 
        jBtFinalizar.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtPesquisarKit.setEnabled(!true);
        jBtPesquisarColaborador.setEnabled(!true);
        // FASE - 2
        jBtNovoPavInternos.setEnabled(!true);
        jBtExcluirPavInternosTodos.setEnabled(!true);
        jBtSalvarPavInternos.setEnabled(!true);
        jBtCancelarPavilhaoInterno.setEnabled(!true);
        //
        jBtSelecionarUmInterno.setEnabled(!true);
        jBtSelecionarTodosInternos.setEnabled(!true);
        jBtExcluirUmInterno.setEnabled(!true);
        jBtExcluirTodosInternos.setEnabled(!true);
        //
        jBtPesquisarInternosPavilhao.setEnabled(!true);
        jBtAuditoriaPavInternos.setEnabled(!true);
        // FASE - 3
        jBtNovoProduto.setEnabled(!true);
        jBtAlterarProduto.setEnabled(!true);
        jBtExcluirProduto.setEnabled(!true);
        jBtSalvarProduto.setEnabled(!true);
        jBtCancelarProduto.setEnabled(!true);
        jBtAuditoriaProduto.setEnabled(!true);
        jBtSelecionarProdutos.setEnabled(!true);
        //FASE -4
        jBtAdicionarProdutosKitCompleto.setEnabled(!true);
        jBtExcluirTodosProdutos.setEnabled(!true);
        jBtExcluirProdutoSelecionado.setEnabled(!true);
        jBtSalvarProdutoBanco.setEnabled(!true);
    }

    public void limparCampos() {
        // FASE - 1
        jIdRegistroComp.setText("");
        jStatusComp.setText("");
        jDataComp.setDate(null);
        jIdFunc.setText("");
        jNomeColaborador.setText("");
        jDepartamentoColaborador.setText("");
        jFotoColaborador.setIcon(null);
        jObservacao.setText("");
        // FASE - 2
        jComboBoxPavilhoes.setSelectedItem("Selecione...");
        // FASE - 3
        jCodigoProd.setText("");
        jQtdAtendida.setText("");
        jUnidadeProd.setText("");
        jQuantidadeProdEstoque.setText("");
        jQuantidadeKit.setText("");
        jDescricaoProd.setText("");
        jQuantidadeInternos.setText("");
    }

    public void limparCamposProdutos() {
        // FASE - 3
        jCodigoProd.setText("");
        jQtdAtendida.setText("");
        jUnidadeProd.setText("");
        jQuantidadeProdEstoque.setText("");
        jQuantidadeKit.setText("");
        jDescricaoProd.setText("");
        jQuantidadeInternos.setText("");
    }

    public void limparTabelasAbaPavIntComp() {
        // APAGAR DADOS DA TABELA PAVILHÃO/INTERNOS
        while (jTabelaInternos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PAVILHÃO/INTERNOS
        jtotalInternosPavilhao.setText("");
        // APAGAR DADOS DA TABELA INTERNOS SELECIONADOS
        while (jTabelaInternosSelecionados.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternosSelecionados.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA INTERNOS SELECIONADOS
        jtotalInternosSelecionados.setText("");
    }

    public void limparTabelaProdutosInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaProdutos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutos.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS
        jtotalProdutosKitInternos.setText("");
        // APAGAR DADOS DA TABELA INTERNOS SELECIONADOS
        while (jTabelaInternosKitCompleto.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternosKitCompleto.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA INTERNOS SELECIONADOS
        jtotalInternosKitCompleto.setText("");
        // LIMPAR TABELA DE PRODUTOS SELECIONADOS PARA BAIXA
        while (jTabelaProdutosKitCompleto.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutosKitCompleto.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS SELECIONADOS PARA BAIXA
        jtotalProdutosKitCompleto.setText("");
    }

    // FASE - 1
    public void Novo() {
        // FASE - 1     
        jStatusComp.setText("ABERTO");
        jDataComp.setCalendar(Calendar.getInstance());
        //  
        jObservacao.setEnabled(true);
        //
        jBtPesquisarKit.setEnabled(true);
        jBtPesquisarColaborador.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jObservacao.setEnabled(true);
        //
        Integer row0 = jTabelaProdutos.getRowCount();
        Integer row1 = jTabelaInternosKitCompleto.getRowCount();
        Integer row2 = jTabelaProdutosKitCompleto.getRowCount();
        if (row0 != 0 || row1 != 0 || row2 != 0) {
            jBtPesquisarKit.setEnabled(!true);
        } else {
            jBtPesquisarKit.setEnabled(true);
        }
        jBtPesquisarColaborador.setEnabled(true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // FASE - 2
        jBtNovoPavInternos.setEnabled(true);
        jBtPesquisarInternosPavilhao.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdRegistroComp.getText().equals("")) {
            limparCampos();
            limparTabelaItensKit();
            limparTabelasAbaPavIntComp();
            jBtNovo.setEnabled(true);
        } else {
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            // ABA PAVILHÕES/INTERNOS
            jBtNovoPavInternos.setEnabled(true);
            //ABA PRODUTOS DO ALMOXARIFADO
            jBtNovoProduto.setEnabled(true);
            //
            jBtAdicionarTodosInternos.setEnabled(true);
            jBtAdicionarProdutosKitCompleto.setEnabled(true);
        }
    }

    public void buscarCodigoDadosIniciais() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE");
            conecta.rs.last();
            jIdRegistroComp.setText(conecta.rs.getString("IdRegistroComp"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarDadosIniciais() {

        conecta.abrirConexao();
        //REGISTRO DE INTERNOS PRÉ SELECIONADOS PARA O KIT
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM INTERNOS_PAVILHAO_KIT_LOTE "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codRequisicao = conecta.rs.getString("IdRegistroComp");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codRequisicao1 = conecta.rs.getString("IdRegistroComp");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codRequisicao2 = conecta.rs.getString("IdRegistroComp");
        } catch (SQLException ex) {
        }
        //
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codRequisicao3 = conecta.rs.getString("IdRegistroComp");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // FASE - 2
    public void NovoPavilhaoInterno() {
        jComboBoxPavilhoes.setEnabled(true);
        //
        jBtPesquisarInternosPavilhao.setEnabled(true);
        jBtSalvarPavInternos.setEnabled(true);
        jBtCancelarPavilhaoInterno.setEnabled(true);
        //
        jBtSelecionarUmInterno.setEnabled(true);
        jBtSelecionarTodosInternos.setEnabled(true);
        jBtExcluirUmInterno.setEnabled(true);
        jBtExcluirTodosInternos.setEnabled(true);
    }

    public void AlterarPavilhaoInterno() {
        jBtSalvarPavInternos.setEnabled(true);
        jBtCancelarPavilhaoInterno.setEnabled(true);
        jBtSelecionarUmInterno.setEnabled(true);
        jBtSelecionarTodosInternos.setEnabled(true);
        jBtExcluirUmInterno.setEnabled(true);
        jBtExcluirTodosInternos.setEnabled(true);
    }

    public void ExcluirPavilhaoInterno() {
        // FASE - 1
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void SalvarPavilhaoInterno() {
        // FASE - 1
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // FASE - 2
        jBtNovoPavInternos.setEnabled(true);
        jBtExcluirPavInternosTodos.setEnabled(true);
        jBtExcluirInternosUmaUm.setEnabled(true);
        jBtAuditoriaPavInternos.setEnabled(true);
        // FASE - 3
        jBtNovoProduto.setEnabled(true);
        // FASE - 4
        jBtAdicionarTodosInternos.setEnabled(true);
        jBtAdicionarProdutosKitCompleto.setEnabled(true);
    }

    public void CancelarPavilhaoInterno() {
        // FASE - 1
        jBtNovoPavInternos.setEnabled(true);
        jBtExcluirPavInternosTodos.setEnabled(true);
        jBtExcluirInternosUmaUm.setEnabled(true);
        jBtSelecionarUmInterno.setEnabled(true);
        jBtSelecionarTodosInternos.setEnabled(true);
        jBtExcluirUmInterno.setEnabled(true);
        jBtExcluirTodosInternos.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        Integer row0 = jTabelaInternosSelecionados.getRowCount();
        if (row0 != 0) {
            jBtNovoProduto.setEnabled(true);
            jBtAdicionarTodosInternos.setEnabled(true);
            jBtAdicionarProdutosKitCompleto.setEnabled(true);
        }
    }

    public void pesquisarPavilhao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdPav, "
                    + "DescricaoPav "
                    + "FROM PAVILHAO ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhoes.addItem(conecta.rs.getString("DescricaoPav"));
                pCODIGO_pavilhao = conecta.rs.getInt("IdPav");
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoRegistroPavilhaoInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegPavInt "
                    + "FROM PAVILHAO_INTERNOS_KIT_LOTE");
            conecta.rs.last();
            idRegPavInt = conecta.rs.getInt("IdRegPavInt");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    // FASE - 3
    public void NovoProduto() {
        jQtdAtendida.setEnabled(true);
        //
        jBtSelecionarProdutos.setEnabled(true);
        jBtSalvarProduto.setEnabled(true);
        jBtCancelarProduto.setEnabled(true);
    }

    public void AlterarProduto() {
        jQtdAtendida.setEnabled(true);
        jBtSelecionarProdutos.setEnabled(true);
        jBtSalvarProduto.setEnabled(true);
        jBtCancelarProduto.setEnabled(true);
    }

    public void ExcluirProduto() {
        jBtNovoProduto.setEnabled(true);
    }

    public void SalvarProduto() {
        // FASE  - 3
        jBtNovoProduto.setEnabled(true);
        // FASE - 1
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //FASE - 4
        jBtAdicionarTodosInternos.setEnabled(true);
    }

    public void CancelarProduto() {
        // FASE  - 3
        jBtNovoProduto.setEnabled(true);
        // FASE - 1
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //FASE - 4
        Integer row0 = jTabelaInternosKitCompleto.getRowCount();
//        Integer row1 = jTabelaProdutosKitCompleto.getRowCount();
        jBtAdicionarTodosInternos.setEnabled(true);
        if (row0 != 0) {
            jBtAdicionarProdutosKitCompleto.setEnabled(true);
        }
    }

    public void pPESQUISAR_QUANTIDADE_Item() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdKit, "
                    + "IdProd, "
                    + "QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "WHERE IdKit='" + pPESQUISA_ID_kit + " '"
                    + "AND IdProd='" + idProduto + "'");
            conecta.rs.first();
            qtdKit = conecta.rs.getFloat("QuantItem");
            DecimalFormat vti = new DecimalFormat("##,###0.00");
            String qtk = vti.format(qtdKit);
            jQuantidadeKit.setText(qtk);
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void buscarProdutoKit() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegProdKit "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE");
            conecta.rs.last();
            IdRegProdKit = conecta.rs.getInt("IdRegProdKit");
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void pegarSaldoEstoque(int idProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdProd, "
                    + "IdItem, "
                    + "Qtd "
                    + "FROM LOTE_PRODUTOS_AC WHERE IdProd='" + idProd + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
            codEstoque = conecta.rs.getInt("IdItem");
            saldoEstoque = conecta.rs.getFloat("Qtd");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarProdutoIncluido() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp, "
                    + "IdProd "
                    + "FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                    + "AND IdProd='" + jCodigoProd.getText() + "'");
            conecta.rs.first();
            pcodigoProduto = conecta.rs.getString("IdProd");
            pRegistroComp = conecta.rs.getString("IdRegistroComp");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //VERIFICAR SE NA TABELA TEM REGISTRO CORRESPONDENTE AO LANÇAMENTO, PARA PODER EXCLUIR TODOS.
    public void verificarInternosDB() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codigoRegExcluir = conecta.rs.getString("IdRegistroComp");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoDBUm() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp, "
                    + "IdInternoCrc "
                    + "FROM "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                    + "AND IdInternoCrc='" + codigoInternoCrc + "'");
            conecta.rs.first();
            codigoRegExcluir = conecta.rs.getString("IdRegistroComp");
            codigoInternoCrc = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // METODO PARA BUSCAR O PRODUTO E EXCLUIR TODOS DA TABELA ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO
    public void verificarTodosProdutosDB() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codigoRegExcluir = conecta.rs.getString("IdRegistroComp");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarUmProdutoDB() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistroComp "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "WHERE IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            conecta.rs.first();
            codigoRegExcluir = conecta.rs.getString("IdRegistroComp");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaItensKit(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Un.", "Qtd."};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            codigoKit = conecta.rs.getInt("IdKit");
            count1 = 0;
            do {
                count = count + 1;
                qtdItem = conecta.rs.getFloat("QuantItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                jtotalProdutosKit.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), qtdItemTab});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGeralProdutosKit.setModel(modelo);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaGeralProdutosKit.getTableHeader().setReorderingAllowed(false);
        jTabelaGeralProdutosKit.setAutoResizeMode(jTabelaGeralProdutosKit.AUTO_RESIZE_OFF);
        jTabelaGeralProdutosKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItensKit();
        conecta.desconecta();
    }

    public void limparTabelaItensKit() {
        count = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição Produto", "Un.", "Qtd."};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGeralProdutosKit.setModel(modelo);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaGeralProdutosKit.getTableHeader().setReorderingAllowed(false);
        jTabelaGeralProdutosKit.setAutoResizeMode(jTabelaGeralProdutosKit.AUTO_RESIZE_OFF);
        jTabelaGeralProdutosKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtotalProdutosKit.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
        jtotalProdutosKit.setText("");
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaItensKit() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaGeralProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaGeralProdutosKit.getColumnModel().getColumn(3).setCellRenderer(direita);
    }

    public void preencherTabelaItensInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Descrição do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                jtotalInternosPavilhao.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("CNC"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinarCamposTabelaInternos();
        conecta.desconecta();
    }

    public void alinarCamposTabelaInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaInternos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Descrição do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaTodosInternosSelecionados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Descrição do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                jtotalInternosPavilhao.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("CNC"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosSelecionados.setModel(modelo);
        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosSelecionados.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternosSelecionados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosSelecionados.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosSelecionados.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternosSelecionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinarCamposTabelaInternosSelecionados();
    }

    public void alinarCamposTabelaInternosSelecionados() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        //
        jTabelaInternosSelecionados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternosSelecionados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void PREENCHER_TABELA_Produtos() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaProdutos.getModel();
        try {
            for (ProdutoInternosKitLote dd : CONTROLE.MOSTRAR_TABELA_PRODUTO_gravado()) {
                //
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(dd.getQuantidadeProd());
                qtdItemTab = vqtdItem;
                //              
                jtotalProdutosKitInternos.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdRegProdKit(), dd.getIdProd(), dd.getDescricaoProduto(), dd.getUnidadeProd(), qtdItemTab});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
                esquerda.setHorizontalAlignment(SwingConstants.LEFT);
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                direita.setHorizontalAlignment(SwingConstants.RIGHT);
                //
                jTabelaProdutos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                jTabelaProdutos.getColumnModel().getColumn(2).setCellRenderer(direita);
                jTabelaProdutos.getColumnModel().getColumn(4).setCellRenderer(direita);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaEstoqueProdutosKitBaixaLote.class.getName()).log(Level.SEVERE, null, ex);
        }
//        ArrayList dados = new ArrayList();
//        String[] Colunas = new String[]{"Item", "Código", "Descrição Produto", "Un.", "Quant."};
//        conecta.abrirConexao();
//        try {
//            conecta.executaSQL(sql);
//            conecta.rs.first();
//            count = 0;
//            do {
//                count = count + 1;
//                jtotalProdutosKitInternos.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
//                dados.add(new Object[]{conecta.rs.getInt("IdRegProdKit"), conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), conecta.rs.getInt("QuantProd")});
//            } while (conecta.rs.next());
//        } catch (SQLException ex) {
//        }
//        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
//        jTabelaProdutos.setModel(modelo);
//        jTabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
//        jTabelaProdutos.getColumnModel().getColumn(0).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(70);
//        jTabelaProdutos.getColumnModel().getColumn(1).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(300);
//        jTabelaProdutos.getColumnModel().getColumn(2).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(50);
//        jTabelaProdutos.getColumnModel().getColumn(3).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(70);
//        jTabelaProdutos.getColumnModel().getColumn(4).setResizable(false);
//        jTabelaProdutos.getTableHeader().setReorderingAllowed(false);
//        jTabelaProdutos.setAutoResizeMode(jTabelaProdutos.AUTO_RESIZE_OFF);
//        jTabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        alinharCamposTabelaProdutos();
//        conecta.desconecta();
    }

    public void LIMPAR_TABELA_Produtos() {
        // APAGAR DADOS DA TABELA
        while (jTabelaProdutos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutos.getModel()).removeRow(0);
        }
//        ArrayList dados = new ArrayList();
//        String[] Colunas = new String[]{"Item", "Código", "Descrição Produto", "Un.", "Quant."};
//        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
//        jTabelaProdutos.setModel(modelo);
//        jTabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
//        jTabelaProdutos.getColumnModel().getColumn(0).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(70);
//        jTabelaProdutos.getColumnModel().getColumn(1).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(300);
//        jTabelaProdutos.getColumnModel().getColumn(2).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(50);
//        jTabelaProdutos.getColumnModel().getColumn(3).setResizable(false);
//        jTabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(70);
//        jTabelaProdutos.getColumnModel().getColumn(4).setResizable(false);
//        jTabelaProdutos.getTableHeader().setReorderingAllowed(false);
//        jTabelaProdutos.setAutoResizeMode(jTabelaProdutos.AUTO_RESIZE_OFF);
//        jTabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        modelo.getLinhas().clear();
    }

//    public void alinharCamposTabelaProdutos() {
//        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
//        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
//        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
//        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
//        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
//        direita.setHorizontalAlignment(SwingConstants.RIGHT);
//        //
//        jTabelaProdutos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
//        jTabelaProdutos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
//        jTabelaProdutos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
//        jTabelaProdutos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
//    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistroComp.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdUsuario, "
                    + "NomeUsuario "
                    + "FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserAL = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT "
                    + "USUARIOS_GRUPOS.IdUsuario, "
                    + "USUARIOS_GRUPOS.IdGrupo, "
                    + "GRUPOUSUARIOS.NomeGrupo "
                    + "FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserAL + "'");
            conecta.rs.first();
            codigoUserGroupAL = conecta.rs.getInt("IdUsuario");
            codigoGrupoAL = conecta.rs.getInt("IdGrupo");
            nomeGrupoAL = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT "
                    + "IdUsuario, "
                    + "Abrir, "
                    + "Incluir, "
                    + "Alterar, "
                    + "Excluir, "
                    + "Gravar, "
                    + "Consultar, "
                    + "NomeTela "
                    + "FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserAL + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoAL = conecta.rs.getInt("IdUsuario");
            codAbrirAL = conecta.rs.getInt("Abrir");
            codIncluirAL = conecta.rs.getInt("Incluir");
            codAlterarAL = conecta.rs.getInt("Alterar");
            codExcluirAL = conecta.rs.getInt("Excluir");
            codGravarAL = conecta.rs.getInt("Gravar");
            codConsultarAL = conecta.rs.getInt("Consultar");
            nomeTelaAL = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
