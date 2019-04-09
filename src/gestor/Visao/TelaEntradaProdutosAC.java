/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtualizaDadosUltimaCompra;
import gestor.Controle.ControleAtualizaSaldoInventarioAC;
import gestor.Controle.ControleEfetivaLoteAC;
import gestor.Controle.ControleHistoricoCompraProdutoAC;
import gestor.Controle.ControleHistoricoMovimentacaoAC;
import gestor.Controle.ControleItensCompras;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleNFeCompras;
import gestor.Controle.ControleParcelasCompras;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.HistoricoCompraAcervo;
import gestor.Modelo.HistoricoMovimentacaoEstoque;
import gestor.Modelo.HistoricoProdutoFornecedor;
import gestor.Modelo.ItensNfeCompras;
import gestor.Modelo.LogSistema;
import gestor.Modelo.NotaFiscalCompra;
import gestor.Modelo.ParcelasPagtoCompras;
import gestor.Modelo.ProdutoMedicamento;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAlmoxarifado.codAlterarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codExcluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codGravarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codIncluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codUserAcessoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserGroupAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeTelaAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codAbrirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codConsultarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMovimentacaoNotaFiscaItensAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMovimentacaoNotaFiscaParcelasAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaMovimentcaoNotaFiscaManuAL;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaEntradaProdutosAC extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    NotaFiscalCompra objNFEComprasv = new NotaFiscalCompra();
    ControleNFeCompras control = new ControleNFeCompras();
    ItensNfeCompras objItensCompras = new ItensNfeCompras();
    ControleItensCompras controle = new ControleItensCompras();
    ParcelasPagtoCompras objParCompras = new ParcelasPagtoCompras();
    ControleParcelasCompras controlParCompras = new ControleParcelasCompras();
    //
    ControleHistoricoCompraProdutoAC controleHist = new ControleHistoricoCompraProdutoAC();
    HistoricoCompraAcervo objHistCompra = new HistoricoCompraAcervo();
    //
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();
    ControleHistoricoMovimentacaoAC controlHistMov = new ControleHistoricoMovimentacaoAC();
    ControleAtualizaSaldoInventarioAC controleSaldo = new ControleAtualizaSaldoInventarioAC();
    ControleEfetivaLoteAC controlLote = new ControleEfetivaLoteAC();
    ControleAtualizaDadosUltimaCompra controlAtualCompras = new ControleAtualizaDadosUltimaCompra();
    HistoricoProdutoFornecedor objHistorForn = new HistoricoProdutoFornecedor();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Almoxarifado:Entrada Produtos:Dados NFE";
    String nomeModuloTela2 = "Almoxarifado:Entrada Produtos:Itens";
    String nomeModuloTela3 = "Almoxarifado:Entrada Produtos:Parcelas";
    //
    int flag;
    int acao;
    String dataInicial, dataFinal;
    String dataEntrada, dataEmissao, dataVctoParcela;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String codEntrada, codParcela;
    //
    double valorBaseCalculoICMS = 0;
    double valorICMS = 0;
    double baseCalculoICMSSub = 0;
    double valorICMSSub = 0;
    double valorTotalProdutos = 0;
    double valorTotalFrete = 0;
    double valorTotalSeguro = 0;
    //double valorTotalSeguros = 0;
    double valorTotalDesconto = 0;
    double valorTotalIPI = 0;
    double valorTotalNota = 0;
    double valorTotalNFE = 0; // Para tela de pesquisa na tabela principal
    double valorTotalNFE2 = 0;
    double valorParcelaTabela2 = 0;
    double valorTotalParcelas1 = 0;
    String valorTotalParccelas2;
    String valorTotalNFeFinal2;
    String valorTotalNFeFinal;
    String valorParcelaTabela;
    String valorTotalParcelas;
    String statusProd = "Ativo";
    public static String idItem;
    public static String qtdItemTab;
    double valorUnitario = 0;
    double aliquotaIcms = 0;
    double aliquotaIpi = 0;
    double valorUniFrete = 0;
    double valorTlFrete = 0;
    public static double qtdItem = 0;
    double valorParcela = 0;
    double valorTotalParcela = 0;
    int count;
    String dataValidade;
    double valorUnitario1 = 0;
    String valorUnitario2;
    //
    int codProduto;
    String numeroLote;
    int saldoAtual;
    String tipoInventario;
    double qtdEstoque = 0;
    Date date = null;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String nomeOperacao = "Compras de Materiais para Consumo";
    String modulo = "A";
    String codProd; // VERIFICAR SE O PRODUTO JÁ FOI INCLUIDO NA NOTA FISCAL.
    String codNf; // VERIFICAR SE O PRODUTO JÁ FOI INCLUIDO NA NOTA FISCAL.
    String loteProd;

    //
    /**
     * Creates new form TelaEntradaProdutos
     */
    public TelaEntradaProdutosAC() {
        initComponents();
        corCampos();
        formatarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jNomeFornecedor = new javax.swing.JTextField();
        jCodigoDoc = new javax.swing.JTextField();
        jNumeroNFe = new javax.swing.JTextField();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqDatas = new javax.swing.JButton();
        jBtPesqNFe = new javax.swing.JButton();
        jBtPesqFornecedor = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaNFeCompras = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jModelo = new javax.swing.JTextField();
        jSerie = new javax.swing.JTextField();
        jNrNFe = new javax.swing.JTextField();
        jDataEmissao = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDescricaoFornecedor = new javax.swing.JTextField();
        jComboBoxFormaPagto = new javax.swing.JComboBox();
        jComboBoxTipoDocumento = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jBtPesDescricaoFornecedor = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jStatusNFe = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jIdLocal = new javax.swing.JTextField();
        jBtPesqLocalArmazenamento = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jBaseCalculoICMS = new javax.swing.JTextField();
        jValorICMS = new javax.swing.JTextField();
        jBaseCalculoICMSSub = new javax.swing.JTextField();
        jValorICMSSub = new javax.swing.JTextField();
        jValorTotalNota = new javax.swing.JTextField();
        jValorTotalIPI = new javax.swing.JTextField();
        jValorTotalDesconto = new javax.swing.JTextField();
        jValorTotalSeguro = new javax.swing.JTextField();
        jValorTotalFrete = new javax.swing.JTextField();
        jValorTotalProdutos = new javax.swing.JFormattedTextField();
        jPanel12 = new javax.swing.JPanel();
        jBtCancelar = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtFinalizar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jIdProd = new javax.swing.JTextField();
        jDescricaoProduto = new javax.swing.JTextField();
        jCodigoBarras = new javax.swing.JTextField();
        jUnidade = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jPedidoCompras = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLote = new javax.swing.JTextField();
        jBtBuscarPedidoCompra = new javax.swing.JButton();
        jBtBuscarProduto = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jReferencia = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jQuantidade = new javax.swing.JFormattedTextField();
        jValorUnitario = new javax.swing.JFormattedTextField();
        jAliquotoICMS = new javax.swing.JFormattedTextField();
        jAliquotaIPI = new javax.swing.JFormattedTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jValorTotalItem = new javax.swing.JFormattedTextField();
        jDataVcto = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jtotalItens = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaItensNFeCompras = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jBtCancelarItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtNovoItem = new javax.swing.JButton();
        jBtAuditoriaItem = new javax.swing.JButton();
        jBtSair1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jDataVctoParcela = new com.toedter.calendar.JDateChooser();
        jValorParcela = new javax.swing.JFormattedTextField();
        jValorTotalDocumento = new javax.swing.JFormattedTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jDescricaoFornecedorParcela = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jCodParcela = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaParcelas = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jBtCancelarParcela = new javax.swing.JButton();
        jBtSalvarParcela = new javax.swing.JButton();
        jBtExcluirParcela = new javax.swing.JButton();
        jBtAlterarParcela = new javax.swing.JButton();
        jBtNovaParcela = new javax.swing.JButton();
        jBtAuditoriaParcela = new javax.swing.JButton();
        jBtSair2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField13.setText("jTextField13");

        jTextField22.setText("jTextField22");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Nfe de Compra de Produtos :::...");
        setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Código:");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("NFe:");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Data Inicial:");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Data Final:");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Fornecedor:");

        jNomeFornecedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCodigoDoc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoDoc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNumeroNFe.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNumeroNFe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jBtPesqNFe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNFe.setContentAreaFilled(false);
        jBtPesqNFe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNFeActionPerformed(evt);
            }
        });

        jBtPesqFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqFornecedor.setContentAreaFilled(false);
        jBtPesqFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqFornecedorActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel72)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jCodigoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNumeroNFe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqNFe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxTodos))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesqCodigo, jBtPesqDatas, jBtPesqFornecedor, jBtPesqNFe});

        jPanel24Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataPesFinal, jNumeroNFe});

        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel70)
                    .addComponent(jCodigoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo)
                    .addComponent(jLabel71)
                    .addComponent(jNumeroNFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNFe)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jBtPesqFornecedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtPesqCodigo, jBtPesqDatas, jBtPesqFornecedor, jBtPesqNFe});

        jTabelaNFeCompras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaNFeCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Dt.Emissão", "Status NFE", "Dt.Entrada", "Fornecedor", "Data Val."
            }
        ));
        jTabelaNFeCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaNFeComprasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaNFeCompras);
        if (jTabelaNFeCompras.getColumnModel().getColumnCount() > 0) {
            jTabelaNFeCompras.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaNFeCompras.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaNFeCompras.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaNFeCompras.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaNFeCompras.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaNFeCompras.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaNFeCompras.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaNFeCompras.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaNFeCompras.getColumnModel().getColumn(4).setMinWidth(280);
            jTabelaNFeCompras.getColumnModel().getColumn(4).setMaxWidth(280);
            jTabelaNFeCompras.getColumnModel().getColumn(5).setMinWidth(120);
            jTabelaNFeCompras.getColumnModel().getColumn(5).setMaxWidth(120);
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

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Modelo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Série");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Número NF-e");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Emissão");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdLanc.setEnabled(false);

        jModelo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jModelo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jModelo.setEnabled(false);

        jSerie.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSerie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSerie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jSerie.setEnabled(false);

        jNrNFe.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrNFe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrNFe.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNrNFe.setEnabled(false);

        jDataEmissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEmissao.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome/Razão Social do Fornecedor");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tipo Documento");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Forma de Pagamento");

        jDescricaoFornecedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoFornecedor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDescricaoFornecedor.setEnabled(false);

        jComboBoxFormaPagto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFormaPagto.setForeground(new java.awt.Color(153, 0, 51));
        jComboBoxFormaPagto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - Pagamento a Vista", "1 - Pagamento a Prazo", "2 - Fatura" }));
        jComboBoxFormaPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFormaPagto.setEnabled(false);

        jComboBoxTipoDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoDocumento.setForeground(new java.awt.Color(153, 0, 51));
        jComboBoxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - Entrada" }));
        jComboBoxTipoDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoDocumento.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data Entrada");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jBtPesDescricaoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesDescricaoFornecedor.setContentAreaFilled(false);
        jBtPesDescricaoFornecedor.setEnabled(false);
        jBtPesDescricaoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesDescricaoFornecedorActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Status");

        jStatusNFe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusNFe.setForeground(new java.awt.Color(153, 0, 153));
        jStatusNFe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusNFe.setDisabledTextColor(new java.awt.Color(153, 0, 102));
        jStatusNFe.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 255));
        jLabel23.setText("Local Estoque");

        jIdLocal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdLocal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLocal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLocal.setDisabledTextColor(new java.awt.Color(0, 0, 255));
        jIdLocal.setEnabled(false);

        jBtPesqLocalArmazenamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalArmazenamento.setContentAreaFilled(false);
        jBtPesqLocalArmazenamento.setEnabled(false);
        jBtPesqLocalArmazenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalArmazenamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 140, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jDescricaoFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jBtPesDescricaoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 140, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBoxFormaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(36, 36, 36)))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEmissao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jNrNFe, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jStatusNFe, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jIdLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqLocalArmazenamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalArmazenamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusNFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNrNFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesDescricaoFornecedor)
                    .addComponent(jDescricaoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Base C.ICMS");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Valor ICMS");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Base C.ICMS ST");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Valor I.S.");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Total Produtos");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Valor Frete");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Valor Seguro");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Valor Desconto");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Valor IPI");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Total da Nota");

        jBaseCalculoICMS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBaseCalculoICMS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jBaseCalculoICMS.setToolTipText("Base Cálculo ICMS");
        jBaseCalculoICMS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBaseCalculoICMS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jBaseCalculoICMS.setEnabled(false);

        jValorICMS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorICMS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorICMS.setToolTipText("Valor ICMS");
        jValorICMS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorICMS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorICMS.setEnabled(false);

        jBaseCalculoICMSSub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBaseCalculoICMSSub.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jBaseCalculoICMSSub.setToolTipText("Base Cálculo ICMS Sub");
        jBaseCalculoICMSSub.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBaseCalculoICMSSub.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jBaseCalculoICMSSub.setEnabled(false);

        jValorICMSSub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorICMSSub.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorICMSSub.setToolTipText("Valor ICMS Sub");
        jValorICMSSub.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorICMSSub.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorICMSSub.setEnabled(false);

        jValorTotalNota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorTotalNota.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalNota.setToolTipText("Total NFe");
        jValorTotalNota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalNota.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jValorTotalNota.setEnabled(false);

        jValorTotalIPI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorTotalIPI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalIPI.setToolTipText("Valor Total IPI");
        jValorTotalIPI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalIPI.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotalIPI.setEnabled(false);

        jValorTotalDesconto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorTotalDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalDesconto.setToolTipText("Valor Total Desconto");
        jValorTotalDesconto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalDesconto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotalDesconto.setEnabled(false);

        jValorTotalSeguro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorTotalSeguro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalSeguro.setToolTipText("Valor Total Seguro");
        jValorTotalSeguro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalSeguro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotalSeguro.setEnabled(false);

        jValorTotalFrete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jValorTotalFrete.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalFrete.setToolTipText("Valor Total Frete");
        jValorTotalFrete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalFrete.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotalFrete.setEnabled(false);

        jValorTotalProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalProdutos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalProdutos.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jValorTotalProdutos.setEnabled(false);
        jValorTotalProdutos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16)
                    .addComponent(jBaseCalculoICMS)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jValorTotalFrete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jValorICMS, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jValorTotalSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jBaseCalculoICMSSub, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18)
                    .addComponent(jValorTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jValorICMSSub, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jValorTotalIPI, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15))
                    .addComponent(jLabel21)
                    .addComponent(jValorTotalNota)
                    .addComponent(jValorTotalProdutos))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jValorICMSSub, jValorTotalIPI});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBaseCalculoICMSSub, jValorTotalDesconto});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBaseCalculoICMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorICMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBaseCalculoICMSSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorICMSSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jValorTotalFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalIPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setToolTipText("Alterar Registro");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setToolTipText("Excluir Registro");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Tela");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setToolTipText("Gravar Registro");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setToolTipText("Novo Registro");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAuditoria))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(0, 102, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar Documento");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtFinalizar)
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados NF-e", jPanel3);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Código");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Descrição do Produto");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 255));
        jLabel53.setText("Código Barras");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Unidade");

        jIdProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdProd.setEnabled(false);

        jDescricaoProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDescricaoProduto.setEnabled(false);

        jCodigoBarras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoBarras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoBarras.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoBarras.setEnabled(false);
        jCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoBarrasActionPerformed(evt);
            }
        });

        jUnidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUnidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jUnidade.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 0, 0));
        jLabel55.setText("Pedido ");

        jPedidoCompras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPedidoCompras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPedidoCompras.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPedidoCompras.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Lote");

        jLote.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLote.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jLote.setEnabled(false);

        jBtBuscarPedidoCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarPedidoCompra.setToolTipText("Pesquisar Pedido de Compra");
        jBtBuscarPedidoCompra.setContentAreaFilled(false);
        jBtBuscarPedidoCompra.setEnabled(false);
        jBtBuscarPedidoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarPedidoCompraActionPerformed(evt);
            }
        });

        jBtBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarProduto.setToolTipText("Pesquisa Produtos");
        jBtBuscarProduto.setContentAreaFilled(false);
        jBtBuscarProduto.setEnabled(false);
        jBtBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarProdutoActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Referência");

        jReferencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReferencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jReferencia.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Qtde.");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Valor UN");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("% ICMS");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("% IPI");

        jQuantidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQuantidade.setEnabled(false);

        jValorUnitario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorUnitario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorUnitario.setEnabled(false);

        jAliquotoICMS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAliquotoICMS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAliquotoICMS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jAliquotoICMS.setEnabled(false);

        jAliquotaIPI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAliquotaIPI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAliquotaIPI.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jAliquotaIPI.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Data Validade");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("V. T. Item");

        jValorTotalItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalItem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotalItem.setEnabled(false);

        jDataVcto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataVcto.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Itens");

        jtotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jtotalItens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jPedidoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtBuscarPedidoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(56, 56, 56))
                            .addComponent(jLote)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDescricaoProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jAliquotoICMS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jAliquotaIPI, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(jDataVcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtotalItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );

        jPanel21Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAliquotaIPI, jAliquotoICMS});

        jPanel21Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jValorTotalItem, jValorUnitario});

        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel57)
                    .addComponent(jLabel51)
                    .addComponent(jLabel53)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPedidoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBuscarPedidoCompra)
                    .addComponent(jIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBuscarProduto)
                    .addComponent(jDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAliquotoICMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAliquotaIPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataVcto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtotalItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabelaItensNFeCompras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensNFeCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição Produto", "Qtd.", "Valor UN", "Data Val.", "Lote"
            }
        ));
        jTabelaItensNFeCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensNFeComprasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaItensNFeCompras);
        if (jTabelaItensNFeCompras.getColumnModel().getColumnCount() > 0) {
            jTabelaItensNFeCompras.getColumnModel().getColumn(0).setMinWidth(40);
            jTabelaItensNFeCompras.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabelaItensNFeCompras.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaItensNFeCompras.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaItensNFeCompras.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaItensNFeCompras.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaItensNFeCompras.getColumnModel().getColumn(3).setMinWidth(50);
            jTabelaItensNFeCompras.getColumnModel().getColumn(3).setMaxWidth(50);
            jTabelaItensNFeCompras.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaItensNFeCompras.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaItensNFeCompras.getColumnModel().getColumn(5).setMinWidth(70);
            jTabelaItensNFeCompras.getColumnModel().getColumn(5).setMaxWidth(70);
            jTabelaItensNFeCompras.getColumnModel().getColumn(6).setMinWidth(70);
            jTabelaItensNFeCompras.getColumnModel().getColumn(6).setMaxWidth(70);
        }

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtCancelarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarItem.setText("Cancelar");
        jBtCancelarItem.setToolTipText("Cancelar Operação");
        jBtCancelarItem.setContentAreaFilled(false);
        jBtCancelarItem.setEnabled(false);
        jBtCancelarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarItemActionPerformed(evt);
            }
        });

        jBtSalvarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarItem.setText("Gravar");
        jBtSalvarItem.setToolTipText("Gravar Item");
        jBtSalvarItem.setContentAreaFilled(false);
        jBtSalvarItem.setEnabled(false);
        jBtSalvarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarItemActionPerformed(evt);
            }
        });

        jBtExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirItem.setText("Excluir");
        jBtExcluirItem.setToolTipText("Excluir Item");
        jBtExcluirItem.setContentAreaFilled(false);
        jBtExcluirItem.setEnabled(false);
        jBtExcluirItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirItemActionPerformed(evt);
            }
        });

        jBtAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarItem.setText("Alterar");
        jBtAlterarItem.setToolTipText("Alterar Item");
        jBtAlterarItem.setContentAreaFilled(false);
        jBtAlterarItem.setEnabled(false);
        jBtAlterarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarItemActionPerformed(evt);
            }
        });

        jBtNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoItem.setText("Novo");
        jBtNovoItem.setToolTipText("Novo Item");
        jBtNovoItem.setContentAreaFilled(false);
        jBtNovoItem.setEnabled(false);
        jBtNovoItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoItem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoItemActionPerformed(evt);
            }
        });

        jBtAuditoriaItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItem.setToolTipText("Auditoria Item");
        jBtAuditoriaItem.setContentAreaFilled(false);
        jBtAuditoriaItem.setEnabled(false);
        jBtAuditoriaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItemActionPerformed(evt);
            }
        });

        jBtSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair1.setText("Sair");
        jBtSair1.setToolTipText("Sair da Tela");
        jBtSair1.setContentAreaFilled(false);
        jBtSair1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jBtNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovoItem)
                .addComponent(jBtAlterarItem)
                .addComponent(jBtExcluirItem)
                .addComponent(jBtSalvarItem)
                .addComponent(jBtCancelarItem)
                .addComponent(jBtSair1)
                .addComponent(jBtAuditoriaItem))
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSalvarItem});

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Produtos", jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parcelas de Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Vencimento");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Valor Parcela R$");

        jDataVctoParcela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataVctoParcela.setEnabled(false);

        jValorParcela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorParcela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorParcela.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorParcela.setEnabled(false);

        jValorTotalDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jValorTotalDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jValorTotalDocumento.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jValorTotalDocumento.setEnabled(false);
        jValorTotalDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Valor Total R$");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Nome/Razão Social do Fornecedor");

        jDescricaoFornecedorParcela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoFornecedorParcela.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDescricaoFornecedorParcela.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Parcela");

        jCodParcela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodParcela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodParcela.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodParcela.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel69)
                                    .addComponent(jCodParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataVctoParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66)
                                    .addComponent(jValorTotalDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDescricaoFornecedorParcela))
                        .addContainerGap())))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jValorParcela, jValorTotalDocumento});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68)
                .addGap(6, 6, 6)
                .addComponent(jDescricaoFornecedorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jValorTotalDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataVctoParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jValorParcela, jValorTotalDocumento});

        jTabelaParcelas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Vencimento", "Valor Parcela", "Valor Doc."
            }
        ));
        jTabelaParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaParcelasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaParcelas);
        if (jTabelaParcelas.getColumnModel().getColumnCount() > 0) {
            jTabelaParcelas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaParcelas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaParcelas.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaParcelas.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaParcelas.getColumnModel().getColumn(2).setMinWidth(100);
            jTabelaParcelas.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabelaParcelas.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaParcelas.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtCancelarParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarParcela.setText("Cancelar");
        jBtCancelarParcela.setToolTipText("Cancelar Operação");
        jBtCancelarParcela.setContentAreaFilled(false);
        jBtCancelarParcela.setEnabled(false);
        jBtCancelarParcela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarParcela.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarParcela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarParcelaActionPerformed(evt);
            }
        });

        jBtSalvarParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarParcela.setText("Gravar");
        jBtSalvarParcela.setToolTipText("Gravar Item");
        jBtSalvarParcela.setContentAreaFilled(false);
        jBtSalvarParcela.setEnabled(false);
        jBtSalvarParcela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarParcela.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarParcela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarParcelaActionPerformed(evt);
            }
        });

        jBtExcluirParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirParcela.setText("Excluir");
        jBtExcluirParcela.setToolTipText("Excluir Item");
        jBtExcluirParcela.setContentAreaFilled(false);
        jBtExcluirParcela.setEnabled(false);
        jBtExcluirParcela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirParcela.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirParcela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirParcelaActionPerformed(evt);
            }
        });

        jBtAlterarParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarParcela.setText("Alterar");
        jBtAlterarParcela.setToolTipText("Alterar Item");
        jBtAlterarParcela.setContentAreaFilled(false);
        jBtAlterarParcela.setEnabled(false);
        jBtAlterarParcela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarParcela.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarParcela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarParcelaActionPerformed(evt);
            }
        });

        jBtNovaParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaParcela.setText("Novo");
        jBtNovaParcela.setToolTipText("Novo Item");
        jBtNovaParcela.setContentAreaFilled(false);
        jBtNovaParcela.setEnabled(false);
        jBtNovaParcela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaParcela.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaParcela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaParcelaActionPerformed(evt);
            }
        });

        jBtAuditoriaParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaParcela.setToolTipText("Auditoria Item");
        jBtAuditoriaParcela.setContentAreaFilled(false);
        jBtAuditoriaParcela.setEnabled(false);
        jBtAuditoriaParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaParcelaActionPerformed(evt);
            }
        });

        jBtSair2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair2.setText("Sair");
        jBtSair2.setToolTipText("Sair da Tela");
        jBtSair2.setContentAreaFilled(false);
        jBtSair2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSair2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jBtNovaParcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarParcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirParcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarParcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarParcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaParcela)
                    .addComponent(jBtAlterarParcela)
                    .addComponent(jBtExcluirParcela)
                    .addComponent(jBtSalvarParcela)
                    .addComponent(jBtCancelarParcela)
                    .addComponent(jBtSair2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Parcelas", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 20, 520, 523);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        if (jCodigoDoc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            pesquisarNFeCompras("SELECT * FROM NF_COMPRAS "
                    + "INNER JOIN FORNECEDORES_AC "
                    + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                    + "WHERE IdNfEntrada='" + jCodigoDoc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqNFeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNFeActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNumeroNFe.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            pesquisarNFeCompras("SELECT * FROM NF_COMPRAS "
                    + "INNER JOIN FORNECEDORES_AC "
                    + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                    + "WHERE NumeroNf='" + jNumeroNFe.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqNFeActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.pesquisarNFeCompras("SELECT * FROM NF_COMPRAS "
                    + "INNER JOIN FORNECEDORES_AC "
                    + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn");
        } else {
            jtotalRegistros.setText("");
            limparTabelaNFe();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        pesquisarNFeCompras("SELECT * FROM NF_COMPRAS "
                                + "INNER JOIN FORNECEDORES_AC "
                                + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                                + "WHERE DataEntrada BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        pesquisarNFeCompras("SELECT * FROM NF_COMPRAS "
                                + "INNER JOIN FORNECEDORES_AC "
                                + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                                + "WHERE DataEntrada BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jBtPesqFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqFornecedorActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNomeFornecedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome para pesquisa.");
        } else {
            pesquisarNFeCompras("SELECT * FROM NF_COMPRAS "
                    + "INNER JOIN FORNECEDORES_AC "
                    + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                    + "WHERE RazaoSocial LIKE'%" + jNomeFornecedor.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqFornecedorActionPerformed

    private void jTabelaNFeComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaNFeComprasMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaNFeCompras.getValueAt(jTabelaNFeCompras.getSelectedRow(), 0);
            jCodigoDoc.setText(IdLanc);
            //  jDataEmissao.setDate(jDataEmissao.getDate());
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jPedidoCompras.setText("");
            jIdProd.setText("");
            jCodigoBarras.setText("");
            jReferencia.setText("");
            jLote.setText("");
            jDescricaoProduto.setText("");
            jUnidade.setText("");
            jQuantidade.setText("0,00");
            jValorUnitario.setText("0,00");
            jAliquotoICMS.setText("0,00");
            jAliquotaIPI.setText("0,00");
            jDataVcto.setDate(null);
            jValorTotalItem.setText("0,00");
            //
            jDescricaoFornecedorParcela.setText("");
            jCodParcela.setText("");
            jDataVctoParcela.setDate(null);
            jValorParcela.setText("0,00");
            jValorTotalDocumento.setText("");
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM NF_COMPRAS "
                        + "INNER JOIN FORNECEDORES_AC "
                        + "ON NF_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                        + "WHERE IdNfEntrada='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdNfEntrada")));
                jModelo.setText(conecta.rs.getString("Modelo"));
                jSerie.setText(conecta.rs.getString("SerieNf"));
                jNrNFe.setText(conecta.rs.getString("NumeroNf"));
                jStatusNFe.setText(conecta.rs.getString("StatusNf"));
                jIdLocal.setText(conecta.rs.getString("IdLocal"));
                jDescricaoFornecedor.setText(conecta.rs.getString("RazaoSocial"));
                jDataEmissao.setDate(conecta.rs.getDate("DataEmissao"));
                jComboBoxTipoDocumento.setSelectedItem(conecta.rs.getString("TipoDocumento"));
                jComboBoxFormaPagto.setSelectedItem(conecta.rs.getString("FormaPagamento"));
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                //
                valorBaseCalculoICMS = conecta.rs.getFloat("BaseCalculoICMS");
                DecimalFormat v1 = new DecimalFormat(",###.00");
                String va1 = v1.format(valorBaseCalculoICMS);
                jBaseCalculoICMS.setText(va1);
                //
                valorICMS = conecta.rs.getFloat("ValorICMS");
                DecimalFormat v2 = new DecimalFormat(",###0.00");
                String va2 = v2.format(valorICMS);
                jValorICMS.setText(va2);
                //
                baseCalculoICMSSub = conecta.rs.getFloat("BaseCalculoICMSSub");
                DecimalFormat v3 = new DecimalFormat(",###0.00");
                String va3 = v3.format(baseCalculoICMSSub);
                jBaseCalculoICMSSub.setText(va3);
                //
                valorICMSSub = conecta.rs.getFloat("ValorICMSSub");
                DecimalFormat v4 = new DecimalFormat(",###0.00");
                String va4 = v4.format(valorICMSSub);
                jValorICMSSub.setText(va4);
                //
                valorTotalProdutos = conecta.rs.getFloat("ValorTotalProdutos");
                DecimalFormat v5 = new DecimalFormat(",###.00");
                String va5 = v5.format(valorTotalProdutos);
                jValorTotalProdutos.setText(va5);
                //         
                valorTotalFrete = conecta.rs.getFloat("ValorTotalFrete");
                DecimalFormat v6 = new DecimalFormat(",###0.00");
                String va6 = v6.format(valorTotalFrete);
                jValorTotalFrete.setText(va6);
                //
                valorTotalSeguro = conecta.rs.getFloat("ValorTotalSeguro");
                DecimalFormat v7 = new DecimalFormat(",###0.00");
                String va7 = v7.format(valorTotalSeguro);
                jValorTotalSeguro.setText(va7);
                //   
                valorTotalDesconto = conecta.rs.getFloat("ValorTotalDesconto");
                DecimalFormat v8 = new DecimalFormat(",###0.00");
                String va8 = v8.format(valorTotalDesconto);
                jValorTotalDesconto.setText(va8);
                //
                valorTotalIPI = conecta.rs.getFloat("ValorTotalIPI");
                DecimalFormat v9 = new DecimalFormat(",###0.00");
                String va9 = v9.format(valorTotalIPI);
                jValorTotalIPI.setText(va9);
                //  
                valorTotalNota = conecta.rs.getFloat("ValorTotalNFE");
                DecimalFormat v10 = new DecimalFormat(",###.00");
                String va10 = v10.format(valorTotalNota);
                jValorTotalNota.setText(va10);
                //
                jObservacao.setText(conecta.rs.getString("ObservacaoNF"));
                if (jComboBoxFormaPagto.getSelectedItem().equals("1 - Pagamento a Prazo") || jComboBoxFormaPagto.getSelectedItem().equals("2 - Fatura")) {
                    jBtNovaParcela.setEnabled(true);
                }
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível exibir registro.\nERRO: " + e);
            }
            count = 0;
            preencherTabelaItens("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                    + "INNER JOIN NF_COMPRAS "
                    + "ON ITENS_COMPRAS_MATERIAIS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_COMPRAS_MATERIAIS.IdNfEntrada='" + jIdLanc.getText() + "'");
            preencherTabelaParcelas("SELECT * FROM PARCELAS_COMPRAS "
                    + "INNER JOIN NF_COMPRAS "
                    + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                    + "INNER JOIN FORNECEDORES_AC "
                    + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                    + "WHERE NF_COMPRAS.IdNfEntrada='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaNFeComprasMouseClicked

    private void jBtPesDescricaoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesDescricaoFornecedorActionPerformed
        // TODO add your handling code here:
        TelaPesqFornecedorNFeComprasAC objPesqFor = new TelaPesqFornecedorNFeComprasAC();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objPesqFor);
        objPesqFor.show();
    }//GEN-LAST:event_jBtPesDescricaoFornecedorActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentcaoNotaFiscaManuAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentcaoNotaFiscaManuAL) && codIncluirAL == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 1;
            Novo();
            corCampos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentcaoNotaFiscaManuAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentcaoNotaFiscaManuAL) && codAlterarAL == 1) {
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa NFe não poderá ser excluida, a mesma encontra-se FINALIZADA");
            } else {
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                acao = 2;
                Alterar();
                corCampos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentcaoNotaFiscaManuAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentcaoNotaFiscaManuAL) && codExcluirAL == 1) {
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa NFe não poderá ser excluida, a mesma encontra-se FINALIZADA");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentcaoNotaFiscaManuAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentcaoNotaFiscaManuAL) && codGravarAL == 1) {
            DecimalFormat valorReal = new DecimalFormat("###,##00.0");
            valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jNrNFe.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número da NFE.");
                jNrNFe.setBackground(Color.red);
                jNrNFe.requestFocus();
            } else if (jDescricaoFornecedor.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o fornecedor do documento.");
            } else if (jDataEmissao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de emissão do documento.");
                jDataEmissao.requestFocus();
                jDataEmissao.setBackground(Color.red);
            } else if (jIdLocal.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o código do local.");
                jIdLocal.requestFocus();
                jIdLocal.setBackground(Color.red);
            } else if (jComboBoxTipoDocumento.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de documento.");
                jComboBoxTipoDocumento.requestFocus();
                jComboBoxTipoDocumento.setBackground(Color.red);
            } else if (jComboBoxFormaPagto.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe o tipo de pagamento do documento.");
                jComboBoxFormaPagto.requestFocus();
                jComboBoxFormaPagto.setBackground(Color.red);
            } else if (jDataEntrada.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada do documento.");
                jDataEntrada.requestFocus();
                jDataEntrada.setBackground(Color.red);
            } else if (jValorTotalProdutos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o valor total dos produtos.");
                jValorTotalProdutos.requestFocus();
                jValorTotalProdutos.setBackground(Color.red);
            } else if (jValorTotalNota.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o valor total da nota fiscal.");
                jValorTotalNota.requestFocus();
                jValorTotalNota.setBackground(Color.red);
            } else {
                objNFEComprasv.setModelo(jModelo.getText());
                objNFEComprasv.setSerieNf(jSerie.getText());
                objNFEComprasv.setNumeroNf(jNrNFe.getText());
                objNFEComprasv.setStatusNf(jStatusNFe.getText());
                objNFEComprasv.setIdLocal(Integer.valueOf(jIdLocal.getText()));
                objNFEComprasv.setNomeFornecedor(jDescricaoFornecedor.getText());
                objNFEComprasv.setDataEmissao(jDataEmissao.getDate());
                objNFEComprasv.setTipodocumento((String) jComboBoxTipoDocumento.getSelectedItem());
                objNFEComprasv.setFormaPagamento((String) jComboBoxFormaPagto.getSelectedItem());
                objNFEComprasv.setDataEntrada(jDataEntrada.getDate());
                try {
                    objNFEComprasv.setBaseCalculoICMS(valorReal.parse(jBaseCalculoICMS.getText()).floatValue());
                    objNFEComprasv.setValorICMS(valorReal.parse(jValorICMS.getText()).floatValue());
                    objNFEComprasv.setBaseCalculoICMS(valorReal.parse(jBaseCalculoICMS.getText()).floatValue());
                    objNFEComprasv.setValorICMSSub(valorReal.parse(jValorICMSSub.getText()).floatValue());
                    objNFEComprasv.setValorTotalProdutos(valorReal.parse(jValorTotalProdutos.getText()).floatValue());
                    objNFEComprasv.setValorTotalFrete(valorReal.parse(jValorTotalFrete.getText()).floatValue());
                    objNFEComprasv.setValorTotalSeguro(valorReal.parse(jValorTotalSeguro.getText()).floatValue());
                    objNFEComprasv.setValorTotalDesconto(valorReal.parse(jValorTotalDesconto.getText()).floatValue());
                    objNFEComprasv.setValorTotalIPI(valorReal.parse(jValorTotalIPI.getText()).floatValue());
                    objNFEComprasv.setValorTotalNFE(valorReal.parse(jValorTotalNota.getText()).floatValue());
                } catch (ParseException ex) {
                }
                objNFEComprasv.setObservacaoNF(jObservacao.getText());
                if (acao == 1) {
                    objNFEComprasv.setUsuarioInsert(nameUser);
                    objNFEComprasv.setDataInsert(dataModFinal);
                    objNFEComprasv.setHorarioInsert(horaMov);
                    control.incluirNFeCompras(objNFEComprasv);
                    buscarCodigoDoc();
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objNFEComprasv.setUsuarioUp(nameUser);
                    objNFEComprasv.setDataUp(dataModFinal);
                    objNFEComprasv.setHorarioUp(horaMov);
                    //
                    objNFEComprasv.setIdNfEntrada(Integer.valueOf(jIdLanc.getText()));
                    control.alterarNFeCompras(objNFEComprasv);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
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
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEntradasProdutosAC objAudiProdAC = new TelaAuditoriaEntradasProdutosAC();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiProdAC);
        objAudiProdAC.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtBuscarPedidoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarPedidoCompraActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Em construção.");
    }//GEN-LAST:event_jBtBuscarPedidoCompraActionPerformed

    private void jCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoBarrasActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                + "INNER JOIN LOCAL_ARMAZENAMENTO_AC "
                + "ON PRODUTOS_AC.IdLocal=LOCAL_ARMAZENAMENTO_AC.IdLocal "
                + "WHERE CodigoBarra LIKE'" + jCodigoBarras.getText() + "'AND StatusProd='" + statusProd + "'");
        try {
            if (conecta.rs.first()) {
                jIdProd.setText(String.valueOf(conecta.rs.getInt("IdProd")));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jUnidade.setText(conecta.rs.getString("UnidadeProd"));
                jReferencia.setText(conecta.rs.getString("ReferenciaProd"));
                jAliquotoICMS.setText(conecta.rs.getString("AliquotaIcms"));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Produto não cadastro.");
            }
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }//GEN-LAST:event_jCodigoBarrasActionPerformed

    private void jBtBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarProdutoActionPerformed
        // TODO add your handling code here:
        TelaPesqProdutoComprasAC objPesqProdComp = new TelaPesqProdutoComprasAC();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objPesqProdComp);
        objPesqProdComp.show();
    }//GEN-LAST:event_jBtBuscarProdutoActionPerformed

    private void jTabelaItensNFeComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensNFeComprasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idProduto = "" + jTabelaItensNFeCompras.getValueAt(jTabelaItensNFeCompras.getSelectedRow(), 1);
            jIdProd.setText(idProduto);
            String nomeProduto = "" + jTabelaItensNFeCompras.getValueAt(jTabelaItensNFeCompras.getSelectedRow(), 2);
            jDescricaoProduto.setText(nomeProduto);
            idItem = "" + jTabelaItensNFeCompras.getValueAt(jTabelaItensNFeCompras.getSelectedRow(), 0);
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAuditoriaItem.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                        + "INNER JOIN PRODUTOS_AC "
                        + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE ITENS_COMPRAS_MATERIAIS.IdNfEntrada='" + jIdLanc.getText() + "' "
                        + "AND PRODUTOS_AC.DescricaoProd='" + jDescricaoProduto.getText() + "' "
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdProd.setText(conecta.rs.getString("IdProd"));
                jDescricaoProduto.setText(conecta.rs.getString("DescricaoProd"));
                idItem = conecta.rs.getString("IdItem");
                jCodigoBarras.setText(conecta.rs.getString("CodigoBarra"));
                jReferencia.setText(conecta.rs.getString("ReferenciaProd"));
                jLote.setText(conecta.rs.getString("Lote"));
                jUnidade.setText(conecta.rs.getString("UnidadeProd"));
                //
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                jQuantidade.setText(vqtdItem);
                // Formata o valor para ser exibido na tela no formato BR                                                   
                valorUnitario = conecta.rs.getFloat("ValorUN");
                DecimalFormat vu = new DecimalFormat(",###0.00");
                String vlUnitario = vu.format(valorUnitario);
                jValorUnitario.setText(vlUnitario);
                //
                aliquotaIcms = conecta.rs.getFloat("AliquotaICMS");
                DecimalFormat aicms = new DecimalFormat(",###0.00");
                String vicms = aicms.format(aliquotaIcms);
                jAliquotoICMS.setText(vicms);
                //
                aliquotaIpi = conecta.rs.getFloat("AliquotaIPI");
                DecimalFormat aipi = new DecimalFormat(",###0.00");
                String vipi = aipi.format(aliquotaIpi);
                jAliquotaIPI.setText(vipi);
                //                
                jDataVcto.setDate(conecta.rs.getDate("DataVctoLote"));
                // 
                valorTlFrete = conecta.rs.getFloat("ValorTotalItem");
                DecimalFormat vti = new DecimalFormat(",###0.00");
                String vtItem = vti.format(valorTlFrete);
                jValorTotalItem.setText(vtItem);
                //
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaItensNFeComprasMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaItensAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaItensAL) && codIncluirAL == 1) {
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaItensAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaItensAL) && codAlterarAL == 1) {
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarItem();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaItensAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaItensAL) && codExcluirAL == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objHistCompra.setIdCompra(Integer.valueOf(jNrNFe.getText()));
                    controleHist.excluirHistoricoComprasProdutFornecedor(objHistCompra);
                    controleHist.excluirHistoricoComprasProduto(objHistCompra);
                    //
                    objItensCompras.setIdItem(Integer.valueOf(idItem));
                    controle.excluirItensCompras(objItensCompras);
                    //
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                            + "INNER JOIN NF_COMPRAS "
                            + "ON ITENS_COMPRAS_MATERIAIS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE NF_COMPRAS.IdNfEntrada='" + jIdLanc.getText() + "'");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaItensAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaItensAL) && codGravarAL == 1) {
            DecimalFormat valorReal = new DecimalFormat("#,##00.0");
            valorReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            //
            DecimalFormat valorRealUni = new DecimalFormat("#,##00.0");
            valorRealUni.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jIdProd.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o produto para esse lançamento.");
            } else if (jQuantidade.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade do produto.");
            } else if (jValorUnitario.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o valor unitário do produto.");
            } else if (jDataVcto.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de vencimento do lote.");
            } else if (jLote.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o Lote do produto.");
            } else {
                objItensCompras.setIdNfEntrada(Integer.valueOf(jIdLanc.getText()));
                objItensCompras.setDescricaoProduto(jDescricaoProduto.getText());
                objItensCompras.setLote(jLote.getText());
                objItensCompras.setDataVcto(jDataVcto.getDate());
                try {
                    objItensCompras.setQtdItem(valorReal.parse(jQuantidade.getText()).floatValue());
                    objItensCompras.setValorUN(valorReal.parse(jValorUnitario.getText()).floatValue());
                    objItensCompras.setAliquotaICMS(valorReal.parse(jAliquotoICMS.getText()).floatValue());
                    objItensCompras.setAliquotaIPI(valorReal.parse(jAliquotaIPI.getText()).floatValue());
                    objItensCompras.setValorTotalItem(valorReal.parse(jValorTotalItem.getText()).floatValue());
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInventarioProdutosAC.class.getName()).log(Level.SEVERE, null, ex);
                }
                verificarProduto();
//            if (acao == 3 && jIdProd.getText().equals(codProd) && jIdLanc.getText().equals(codNf) && jLote.getText().equals(loteProd)) {
                if (acao == 3) {
                    if (jIdProd.getText().equals(codProd) && jIdLanc.getText().equals(codNf) && jLote.getText().equals(loteProd)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse produto já foi incluído nessa nota fiscal.");
                    } else {
                        objItensCompras.setUsuarioInsert(nameUser);
                        objItensCompras.setDataInsert(dataModFinal);
                        objItensCompras.setHorarioInsert(horaMov);
                        controle.incluirItensCompras(objItensCompras);
                        buscarItem();
                        // INCLUIR PRODUTO NA TABELA HISTORICO_COMPRA_AC
                        objHistCompra.setIdCompra(Integer.valueOf(jIdLanc.getText()));
                        objHistCompra.setNfCompra(Integer.valueOf(jNrNFe.getText()));
                        objHistCompra.setNomeLivro(jDescricaoProduto.getText());
                        objHistCompra.setDataMov(jDataEntrada.getDate());
                        try {
                            objHistCompra.setQtdeCompra(valorRealUni.parse(jQuantidade.getText()).floatValue());
                            objHistCompra.setValorUnit(valorRealUni.parse(jValorUnitario.getText()).floatValue());
                            objHistCompra.setValorTotal(valorRealUni.parse(jValorTotalItem.getText()).floatValue());
                        } catch (ParseException ex) {
                        }
                        controleHist.incluirHistoricoComprasProduto(objHistCompra);
                        // ATUALIZAR DADOS DO FORNECEDOR NA TABELA DE PRODUTOS_AC   
                        objHistorForn.setIdNfEntrada(Integer.valueOf(idItem));
                        objHistorForn.setNfCompra(Integer.valueOf(jNrNFe.getText()));
                        objHistorForn.setDataMov(jDataEntrada.getDate());
                        objHistorForn.setNomeFornecedor(jDescricaoFornecedor.getText());
                        try {
                            objHistorForn.setQtdeCompra(valorRealUni.parse(jQuantidade.getText()).floatValue());
                            objHistorForn.setValorUnit(valorRealUni.parse(jValorUnitario.getText()).floatValue());
                        } catch (ParseException ex) {
                        }
                        objHistorForn.setDescricaoProduto(jDescricaoProduto.getText());
                        controlAtualCompras.incluirDadosFornecedor(objHistorForn);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaItens("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                                + "INNER JOIN NF_COMPRAS "
                                + "ON ITENS_COMPRAS_MATERIAIS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                                + "INNER JOIN PRODUTOS_AC "
                                + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                                + "WHERE ITENS_COMPRAS_MATERIAIS.IdNfEntrada='" + jIdLanc.getText() + "'");
                        SalvarItem();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 4) {
                    objItensCompras.setUsuarioUp(nameUser);
                    objItensCompras.setDataUp(dataModFinal);
                    objItensCompras.setHorarioUp(horaMov);
                    objItensCompras.setIdItem(Integer.valueOf(idItem));
                    controle.alterarItensCompras(objItensCompras);
                    // INCLUIR PRODUTO NA TABELA HISTORICO_COMPRA_AC
                    objHistCompra.setIdCompra(Integer.valueOf(jIdLanc.getText()));
                    objHistCompra.setIdLivro(Integer.valueOf(jIdProd.getText()));
                    objHistCompra.setNfCompra(Integer.valueOf(jNrNFe.getText()));
                    objHistCompra.setNomeLivro(jDescricaoProduto.getText());
                    objHistCompra.setDataMov(jDataEntrada.getDate());
                    try {
                        objHistCompra.setQtdeCompra(valorRealUni.parse(jQuantidade.getText()).floatValue());
                        objHistCompra.setValorUnit(valorRealUni.parse(jValorUnitario.getText()).floatValue());
                        objHistCompra.setValorTotal(valorRealUni.parse(jValorTotalItem.getText()).floatValue());
                    } catch (ParseException ex) {
                    }
                    controleHist.alterarHistoricoComprasProduto(objHistCompra);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaItens("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                            + "INNER JOIN NF_COMPRAS "
                            + "ON ITENS_COMPRAS_MATERIAIS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                            + "INNER JOIN PRODUTOS_AC "
                            + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                            + "WHERE ITENS_COMPRAS_MATERIAIS.IdNfEntrada='" + jIdLanc.getText() + "'");
                    SalvarItem();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarItemActionPerformed

    private void jBtCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarItemActionPerformed
        // TODO add your handling code here:
        CancelarItem();
    }//GEN-LAST:event_jBtCancelarItemActionPerformed

    private void jBtAuditoriaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItemActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEntradaProdutosAC objAudiItensAC = new TelaAuditoriaItensEntradaProdutosAC();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiItensAC);
        objAudiItensAC.show();
    }//GEN-LAST:event_jBtAuditoriaItemActionPerformed

    private void jTabelaParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaParcelasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idParcela = "" + jTabelaParcelas.getValueAt(jTabelaParcelas.getSelectedRow(), 0);
            jCodParcela.setText(idParcela);
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(!true);
            jBtAuditoriaItem.setEnabled(!true);
            //
            jBtNovaParcela.setEnabled(true);
            jBtAlterarParcela.setEnabled(true);
            jBtExcluirParcela.setEnabled(true);
            jBtSalvarParcela.setEnabled(!true);
            jBtCancelarParcela.setEnabled(true);
            jBtAuditoriaParcela.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PARCELAS_COMPRAS "
                        + "INNER JOIN NF_COMPRAS "
                        + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                        + "INNER JOIN FORNECEDORES_AC "
                        + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                        + "WHERE PARCELAS_COMPRAS.IdParc='" + jCodParcela.getText() + "'");
                conecta.rs.first();
                jDescricaoFornecedorParcela.setText(conecta.rs.getString("RazaoSocial"));
                //idItem = conecta.rs.getString("IdItem");
                jCodParcela.setText(conecta.rs.getString("IdParc"));
                jDataVctoParcela.setDate(conecta.rs.getDate("DataVcto"));
                valorParcela = conecta.rs.getFloat("ValorParcela");
                DecimalFormat vp = new DecimalFormat(",###.00");
                String vlParcela = vp.format(valorParcela);
                jValorParcela.setText(vlParcela);
                valorTotalParcela = conecta.rs.getFloat("ValorTotalParcelas");
                DecimalFormat vtp = new DecimalFormat(",###.00");
                String vTotaPar = vtp.format(valorTotalParcela);
                jValorTotalDocumento.setText(vTotaPar);
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível selecionar o registro.\nERRO: " + e);
            }
        }
    }//GEN-LAST:event_jTabelaParcelasMouseClicked

    private void jBtNovaParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaParcelaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaParcelasAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaParcelasAL) && codIncluirAL == 1) {
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 5;
                NovaParcela();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtNovaParcelaActionPerformed

    private void jBtAlterarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarParcelaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaParcelasAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaParcelasAL) && codAlterarAL == 1) {
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 6;
                AlterarParcela();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtAlterarParcelaActionPerformed

    private void jBtExcluirParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirParcelaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaParcelasAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaParcelasAL) && codExcluirAL == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objNFEComprasv.setStatusNf(jStatusNFe.getText());
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objParCompras.setIdParc(Integer.valueOf(jCodParcela.getText()));
                    controlParCompras.excluirParcelasCompras(objParCompras);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    preencherTabelaParcelas("SELECT * FROM PARCELAS_COMPRAS "
                            + "INNER JOIN NF_COMPRAS "
                            + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                            + "INNER JOIN FORNECEDORES_AC "
                            + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                            + "WHERE NF_COMPRAS.IdNfEntrada='" + objParCompras.getIdNfEntrada() + "'");
                }
                ExcluirParcela();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtExcluirParcelaActionPerformed

    private void jBtSalvarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarParcelaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaMovimentacaoNotaFiscaParcelasAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaMovimentacaoNotaFiscaParcelasAL) && codGravarAL == 1) {
            DecimalFormat valorRealParc = new DecimalFormat("###,##00.0");
            valorRealParc.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            if (jDataVctoParcela.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da parcela de pagamento.");
            } else if (jValorParcela.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o valor da parcela de pagamento.");
            } else {
                objParCompras.setIdNfEntrada(Integer.valueOf(jIdLanc.getText()));
                objParCompras.setNomeFornecedor(jDescricaoFornecedorParcela.getText());
                objParCompras.setDataVcto(jDataVctoParcela.getDate());
                try {
                    objParCompras.setValorParcela(valorRealParc.parse(jValorParcela.getText()).floatValue());
                    objParCompras.setValorTotalParcelas(valorRealParc.parse(jValorTotalDocumento.getText()).floatValue());
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInventarioProdutosAC.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (acao == 5) {
                    objParCompras.setUsuarioInsert(nameUser);
                    objParCompras.setDataInsert(dataModFinal);
                    objParCompras.setHorarioInsert(horaMov);
                    //               
                    controlParCompras.incluirParcelasCompras(objParCompras);
                    buscarCodParcela();
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaParcelas("SELECT * FROM PARCELAS_COMPRAS "
                            + "INNER JOIN NF_COMPRAS "
                            + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                            + "INNER JOIN FORNECEDORES_AC "
                            + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                            + "WHERE NF_COMPRAS.IdNfEntrada='" + jCodigoDoc.getText() + "'");
                    SalvarParcela();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    objParCompras.setUsuarioUp(nameUser);
                    objParCompras.setDataUp(dataModFinal);
                    objParCompras.setHorarioUp(horaMov);
                    //
                    objParCompras.setIdParc(Integer.valueOf(jCodParcela.getText()));
                    controlParCompras.alterarParcelasCompras(objParCompras);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaParcelas("SELECT * FROM PARCELAS_COMPRAS "
                            + "INNER JOIN NF_COMPRAS "
                            + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                            + "INNER JOIN FORNECEDORES_AC "
                            + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                            + "WHERE NF_COMPRAS.IdNfEntrada='" + jCodigoDoc.getText() + "'");
                    SalvarParcela();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtSalvarParcelaActionPerformed

    private void jBtCancelarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarParcelaActionPerformed
        // TODO add your handling code here:
        CancelarParcela();
    }//GEN-LAST:event_jBtCancelarParcelaActionPerformed

    private void jBtAuditoriaParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaParcelaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensParcelasEntradaAC objAudiParcEntraAC = new TelaAuditoriaItensParcelasEntradaAC();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAudiParcEntraAC);
        objAudiParcEntraAC.show();
    }//GEN-LAST:event_jBtAuditoriaParcelaActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM NF_COMPRAS WHERE IdNfEntrada='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            jStatusNFe.setText(conecta.rs.getString("StatusNf"));
            if (jStatusNFe.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                efetuarCompras();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair1ActionPerformed

    private void jBtSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSair2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSair2ActionPerformed

    private void jBtPesqLocalArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalArmazenamentoActionPerformed
        // TODO add your handling code here:
        TelaPesqLocalArmazenamentoNFeCompras objPesqLocalArm = new TelaPesqLocalArmazenamentoNFeCompras();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objPesqLocalArm);
        objPesqLocalArm.show();
    }//GEN-LAST:event_jBtPesqLocalArmazenamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jAliquotaIPI;
    private javax.swing.JFormattedTextField jAliquotoICMS;
    private javax.swing.JTextField jBaseCalculoICMS;
    private javax.swing.JTextField jBaseCalculoICMSSub;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarParcela;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaItem;
    private javax.swing.JButton jBtAuditoriaParcela;
    private javax.swing.JButton jBtBuscarPedidoCompra;
    private javax.swing.JButton jBtBuscarProduto;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtCancelarParcela;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtExcluirParcela;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovaParcela;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtPesDescricaoFornecedor;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqFornecedor;
    private javax.swing.JButton jBtPesqLocalArmazenamento;
    private javax.swing.JButton jBtPesqNFe;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSair1;
    private javax.swing.JButton jBtSair2;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarParcela;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JTextField jCodParcela;
    public static javax.swing.JTextField jCodigoBarras;
    private javax.swing.JTextField jCodigoDoc;
    private javax.swing.JComboBox jComboBoxFormaPagto;
    private javax.swing.JComboBox jComboBoxTipoDocumento;
    private com.toedter.calendar.JDateChooser jDataEmissao;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataVcto;
    private com.toedter.calendar.JDateChooser jDataVctoParcela;
    public static javax.swing.JTextField jDescricaoFornecedor;
    public static javax.swing.JTextField jDescricaoFornecedorParcela;
    public static javax.swing.JTextField jDescricaoProduto;
    private javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdLocal;
    public static javax.swing.JTextField jIdProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jLote;
    private javax.swing.JTextField jModelo;
    private javax.swing.JTextField jNomeFornecedor;
    private javax.swing.JTextField jNrNFe;
    private javax.swing.JTextField jNumeroNFe;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jPedidoCompras;
    private javax.swing.JFormattedTextField jQuantidade;
    public static javax.swing.JTextField jReferencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jSerie;
    private javax.swing.JTextField jStatusNFe;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaItensNFeCompras;
    private javax.swing.JTable jTabelaNFeCompras;
    private javax.swing.JTable jTabelaParcelas;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField22;
    public static javax.swing.JTextField jUnidade;
    private javax.swing.JTextField jValorICMS;
    private javax.swing.JTextField jValorICMSSub;
    private javax.swing.JFormattedTextField jValorParcela;
    private javax.swing.JTextField jValorTotalDesconto;
    private javax.swing.JFormattedTextField jValorTotalDocumento;
    private javax.swing.JTextField jValorTotalFrete;
    private javax.swing.JTextField jValorTotalIPI;
    private javax.swing.JFormattedTextField jValorTotalItem;
    private javax.swing.JTextField jValorTotalNota;
    private javax.swing.JFormattedTextField jValorTotalProdutos;
    private javax.swing.JTextField jValorTotalSeguro;
    private javax.swing.JFormattedTextField jValorUnitario;
    private javax.swing.JLabel jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {

        //
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jModelo.setBackground(Color.white);
        jSerie.setBackground(Color.white);
        jNrNFe.setBackground(Color.white);
        jStatusNFe.setBackground(Color.white);
        jIdLocal.setBackground(Color.white);
        jDescricaoFornecedor.setBackground(Color.white);
        jDataEmissao.setBackground(Color.white);
        jComboBoxTipoDocumento.setBackground(Color.white);
        jComboBoxFormaPagto.setBackground(Color.white);
        jDataEmissao.setBackground(Color.white);
        jBaseCalculoICMS.setBackground(Color.white);
        jValorICMS.setBackground(Color.white);
        jBaseCalculoICMSSub.setBackground(Color.white);
        jValorICMSSub.setBackground(Color.white);
        jValorTotalProdutos.setBackground(Color.white);
        jValorTotalFrete.setBackground(Color.white);
        jValorTotalSeguro.setBackground(Color.white);
        jValorTotalDesconto.setBackground(Color.white);
        jValorTotalIPI.setBackground(Color.white);
        jValorTotalNota.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jPedidoCompras.setBackground(Color.white);
        jIdProd.setBackground(Color.white);
        jCodigoBarras.setBackground(Color.white);
        jReferencia.setBackground(Color.white);
        jLote.setBackground(Color.white);
        jDescricaoProduto.setBackground(Color.white);
        jUnidade.setBackground(Color.white);
        jQuantidade.setBackground(Color.white);
        jValorUnitario.setBackground(Color.white);
        jAliquotoICMS.setBackground(Color.white);
        jAliquotaIPI.setBackground(Color.white);
        jDataVcto.setBackground(Color.white);
        jValorTotalItem.setBackground(Color.white);
        //
    }

    public void Novo() {
        // Limpar os campos
        jIdLanc.setText("");
        jModelo.setText("55");
        jSerie.setText("");
        jNrNFe.setText("");
        jStatusNFe.setText("ABERTO");
        jIdLocal.setText("");
        jDescricaoFornecedor.setText("");
        jDataEmissao.setCalendar(Calendar.getInstance());
        jComboBoxTipoDocumento.setSelectedItem("0 - Entrada");
        jComboBoxFormaPagto.setSelectedItem("0 - Pagamento a Vista");
        jDataEntrada.setCalendar(Calendar.getInstance());
        jBaseCalculoICMS.setText("0,00");
        jValorICMS.setText("0,00");
        jBaseCalculoICMSSub.setText("0,00");
        jValorICMSSub.setText("0,00");
        jValorTotalProdutos.setText("0,00");
        jValorTotalFrete.setText("0,00");
        jValorTotalSeguro.setText("0,00");
        jValorTotalDesconto.setText("0,00");
        jValorTotalIPI.setText("0,00");
        jValorTotalNota.setText("0,00");
        jObservacao.setText("");
        // Habilitar/Desabilitar Campos      
        jModelo.setEnabled(true);
        jSerie.setEnabled(true);
        jNrNFe.setEnabled(true);
        jDataEmissao.setEnabled(true);
        jComboBoxTipoDocumento.setEnabled(true);
        jComboBoxFormaPagto.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jBaseCalculoICMS.setEnabled(true);
        jValorICMS.setEnabled(true);
        jBaseCalculoICMSSub.setEnabled(true);
        jValorICMSSub.setEnabled(true);
        jValorTotalProdutos.setEnabled(true);
        jValorTotalFrete.setEnabled(true);
        jValorTotalSeguro.setEnabled(true);
        jValorTotalDesconto.setEnabled(true);
        jValorTotalIPI.setEnabled(true);
        jValorTotalNota.setEnabled(true);
        jObservacao.setEnabled(true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(true);
        jBtPesqLocalArmazenamento.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Limpa a tabela dos itens (Produtos)
        preencherTabelaItens("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                + "INNER JOIN NF_COMPRAS "
                + "ON ITENS_COMPRAS_MATERIAIS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                + "INNER JOIN PRODUTOS_AC "
                + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                + "WHERE NF_COMPRAS.IdNfEntrada='" + jIdLanc.getText() + "'");
        // Limpar campos dos produtos
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // Limpar tabela de parcelas
        preencherTabelaParcelas("SELECT * FROM PARCELAS_COMPRAS "
                + "INNER JOIN NF_COMPRAS "
                + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                + "INNER JOIN FORNECEDORES_AC "
                + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                + "WHERE NF_COMPRAS.IdNfEntrada='" + objParCompras.getIdNfEntrada() + "'");
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void Alterar() {
        // Habilitar/Desabilitar Campos      
        jModelo.setEnabled(true);
        jSerie.setEnabled(true);
        jNrNFe.setEnabled(true);
        jDataEmissao.setEnabled(true);
        jComboBoxTipoDocumento.setEnabled(true);
        jComboBoxFormaPagto.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jBaseCalculoICMS.setEnabled(true);
        jValorICMS.setEnabled(true);
        jBaseCalculoICMSSub.setEnabled(true);
        jValorICMSSub.setEnabled(true);
        jValorTotalProdutos.setEnabled(true);
        jValorTotalFrete.setEnabled(true);
        jValorTotalSeguro.setEnabled(true);
        jValorTotalDesconto.setEnabled(true);
        jValorTotalIPI.setEnabled(true);
        jValorTotalNota.setEnabled(true);
        jObservacao.setEnabled(true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(true);
        jBtPesqLocalArmazenamento.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Limpar campos dos produtos
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void Excluir() {
        // Limpar os campos
        jIdLanc.setText("");
        jModelo.setText("");
        jSerie.setText("");
        jNumeroNFe.setText("");
        jStatusNFe.setText("");
        jIdLocal.setText("");
        jDescricaoFornecedor.setText("");
        jDataEmissao.setDate(null);
        jComboBoxTipoDocumento.setSelectedItem(null);
        jComboBoxFormaPagto.setSelectedItem(null);
        jDataEmissao.setDate(null);
        jBaseCalculoICMS.setText("");
        jValorICMS.setText("");
        jBaseCalculoICMSSub.setText("");
        jValorICMSSub.setText("");
        jValorTotalProdutos.setText("");
        jValorTotalFrete.setText("");
        jValorTotalSeguro.setText("");
        jValorTotalDesconto.setText("");
        jValorTotalIPI.setText("");
        jValorTotalNota.setText("");
        jObservacao.setText("");
        // Habilitar/Desabilitar Campos      
        jModelo.setEnabled(!true);
        jSerie.setEnabled(!true);
        jNumeroNFe.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        jComboBoxFormaPagto.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jBaseCalculoICMS.setEnabled(!true);
        jValorICMS.setEnabled(!true);
        jBaseCalculoICMSSub.setEnabled(!true);
        jValorICMSSub.setEnabled(!true);
        jValorTotalProdutos.setEnabled(!true);
        jValorTotalFrete.setEnabled(!true);
        jValorTotalSeguro.setEnabled(!true);
        jValorTotalDesconto.setEnabled(!true);
        jValorTotalIPI.setEnabled(!true);
        jValorTotalNota.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(!true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Limpa a tabela dos itens (Produtos)
        preencherTabelaItens("SELECT * FROM ITENS_COMPRAS_MATERIAIS "
                + "INNER JOIN NF_COMPRAS "
                + "ON ITENS_COMPRAS_MATERIAIS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                + "INNER JOIN PRODUTOS_AC "
                + "ON ITENS_COMPRAS_MATERIAIS.IdProd=PRODUTOS_AC.IdProd "
                + "WHERE IdNfEntrada='" + jIdLanc.getText() + "'");
        // Limpar campos dos produtos
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // Limpar tabela de parcelas
        preencherTabelaParcelas("SELECT * FROM PARCELA_SCOMPRAS "
                + "INNER JOIN NF_COMPRAS "
                + "ON PARCELAS_COMPRAS.IdNfEntrada=NF_COMPRAS.IdNfEntrada "
                + "INNER JOIN ITENS_COMPRAS_MATERIAIS "
                + "ON PARCELAS_COMPRAS.IdItem=ITENS_COMPRAS_MATERIAIS.IdItem "
                + "INNER JOIN FORNECEDORES_ac "
                + "ON PARCELAS_COMPRAS.IdForn=FORNECEDORES_AC.IdForn "
                + "WHERE IdNfEntrada='" + objParCompras.getIdNfEntrada() + "'");
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void Salvar() {
        // Habilitar/Desabilitar Campos      
        jModelo.setEnabled(!true);
        jSerie.setEnabled(!true);
        jNrNFe.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        jComboBoxFormaPagto.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jBaseCalculoICMS.setEnabled(!true);
        jValorICMS.setEnabled(!true);
        jBaseCalculoICMSSub.setEnabled(!true);
        jValorICMSSub.setEnabled(!true);
        jValorTotalProdutos.setEnabled(!true);
        jValorTotalFrete.setEnabled(!true);
        jValorTotalSeguro.setEnabled(!true);
        jValorTotalDesconto.setEnabled(!true);
        jValorTotalIPI.setEnabled(!true);
        jValorTotalNota.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(!true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Limpar campos dos produtos
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            // Limpar os campos
            jIdLanc.setText("");
            jModelo.setText("");
            jSerie.setText("");
            jNrNFe.setText("");
            jStatusNFe.setText("ABERTO");
            jDescricaoFornecedor.setText("");
            jDataEmissao.setDate(null);
            jComboBoxTipoDocumento.setSelectedItem(null);
            jComboBoxFormaPagto.setSelectedItem(null);
            jDataEntrada.setDate(null);
            jBaseCalculoICMS.setText("");
            jValorICMS.setText("");
            jBaseCalculoICMSSub.setText("");
            jValorICMSSub.setText("");
            jValorTotalProdutos.setText("");
            jValorTotalFrete.setText("");
            jValorTotalSeguro.setText("");
            jValorTotalDesconto.setText("");
            jValorTotalIPI.setText("");
            jValorTotalNota.setText("");
            jObservacao.setText("");
            // Habilitar/Desabilitar Campos      
            jModelo.setEnabled(!true);
            jSerie.setEnabled(!true);
            jNrNFe.setEnabled(!true);
            jDataEmissao.setEnabled(!true);
            jComboBoxTipoDocumento.setEnabled(!true);
            jComboBoxFormaPagto.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jBaseCalculoICMS.setEnabled(!true);
            jValorICMS.setEnabled(!true);
            jBaseCalculoICMSSub.setEnabled(!true);
            jValorICMSSub.setEnabled(!true);
            jValorTotalProdutos.setEnabled(!true);
            jValorTotalFrete.setEnabled(!true);
            jValorTotalSeguro.setEnabled(!true);
            jValorTotalDesconto.setEnabled(!true);
            jValorTotalIPI.setEnabled(!true);
            jValorTotalNota.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // Habilitar/Desabilitar botões Dados NFe
            jBtPesDescricaoFornecedor.setEnabled(!true);
            jBtPesqLocalArmazenamento.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            // Habilitar/Desabilitar Campos      
            jModelo.setEnabled(!true);
            jSerie.setEnabled(!true);
            jNrNFe.setEnabled(!true);
            jDataEmissao.setEnabled(!true);
            jComboBoxTipoDocumento.setEnabled(!true);
            jComboBoxFormaPagto.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jBaseCalculoICMS.setEnabled(!true);
            jValorICMS.setEnabled(!true);
            jBaseCalculoICMSSub.setEnabled(!true);
            jValorICMSSub.setEnabled(!true);
            jValorTotalProdutos.setEnabled(!true);
            jValorTotalFrete.setEnabled(!true);
            jValorTotalSeguro.setEnabled(!true);
            jValorTotalDesconto.setEnabled(!true);
            jValorTotalIPI.setEnabled(!true);
            jValorTotalNota.setEnabled(!true);
            jObservacao.setEnabled(!true);
            // Habilitar/Desabilitar botões Dados NFe
            jBtPesDescricaoFornecedor.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            // Limpar campos dos produtos
            jPedidoCompras.setText("");
            jIdProd.setText("");
            jCodigoBarras.setText("");
            jReferencia.setText("");
            jLote.setText("");
            jDescricaoProduto.setText("");
            jUnidade.setText("");
            jQuantidade.setText("");
            jValorUnitario.setText("");
            jAliquotoICMS.setText("");
            jAliquotaIPI.setText("");
            jDataVcto.setDate(null);
            jValorTotalItem.setText("");
            // Habilita/Desabilita campos dos produtos
            jPedidoCompras.setEnabled(!true);
            jIdProd.setEnabled(!true);
            jCodigoBarras.setEnabled(!true);
            jReferencia.setEnabled(!true);
            jLote.setEnabled(!true);
            jDescricaoProduto.setEnabled(!true);
            jUnidade.setEnabled(!true);
            jQuantidade.setEnabled(!true);
            jValorUnitario.setEnabled(!true);
            jAliquotoICMS.setEnabled(!true);
            jAliquotaIPI.setEnabled(!true);
            jDataVcto.setEnabled(!true);
            jValorTotalItem.setEnabled(!true);
            // Habilta/Desabilitar botões dos Produtos
            jBtBuscarPedidoCompra.setEnabled(!true);
            jBtBuscarProduto.setEnabled(!true);
            jBtNovoItem.setEnabled(true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(!true);
            jBtAuditoriaItem.setEnabled(!true);
            // Limpara campos das parcelas
            jDescricaoFornecedorParcela.setText("");
            jCodParcela.setText("");
            jDataVctoParcela.setDate(null);
            jValorParcela.setText("");
            jValorTotalDocumento.setText("");
            // Habilitar/Desabilitar campos da parcela
            jDescricaoFornecedorParcela.setEnabled(!true);
            jCodParcela.setEnabled(!true);
            jDataVctoParcela.setEnabled(!true);
            jValorParcela.setEnabled(!true);
            jValorTotalDocumento.setEnabled(!true);
            // Habilitar/Desabilitar botões da parcelas
            jBtNovaParcela.setEnabled(!true);
            jBtAlterarParcela.setEnabled(!true);
            jBtExcluirParcela.setEnabled(!true);
            jBtSalvarParcela.setEnabled(!true);
            jBtCancelarParcela.setEnabled(!true);
            jBtAuditoriaParcela.setEnabled(!true);
        }
    }

    public void efetuarCompras() {
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO FINALIZA
        Integer rows = jTabelaItensNFeCompras.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe produtos a ser lançado.");
        } else {
            tipoInventario = "C";
            DecimalFormat valorRealMoed = new DecimalFormat("###,##00.0");
            valorRealMoed.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            for (int i = 0; i < jTabelaItensNFeCompras.getRowCount(); i++) {
                objProdMed.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objProdMed.setModulo(modulo);
                objProdMed.setIdProd((int) jTabelaItensNFeCompras.getValueAt(i, 1));
                try {
                    objProdMed.setSaldoAtual(valorRealMoed.parse((String) jTabelaItensNFeCompras.getValueAt(i, 3)).floatValue());
                    date = (java.util.Date) formatter.parse((String) jTabelaItensNFeCompras.getValueAt(i, 5));
                } catch (ParseException ex) {
                }
                objProdMed.setLote((String) jTabelaItensNFeCompras.getValueAt(i, 6));
                objProdMed.setDataValidade(date);
                objProdMed.setDataEstoque(jDataEntrada.getDate());
                SomaProdutoLote();
                objProdMed.setIdProd((int) jTabelaItensNFeCompras.getValueAt(i, 1));
                // ALTERAR SALDO DE ESTOQUE DOS PRODUTOS NA TABELA "SALDO_ESTQUE_AC"
                controleSaldo.alterarEstoqueProdutoAC(objProdMed); //SALDO_ESTQUE_AC
                // ALTERART SALDO DE ESTOQUE DOS PRODUTOS NA TABELA "LOTE_PRODUTOS_AC"
                controlLote.alterarLoteProdutoAC(objProdMed); // LOTE_PRODUTOS_AC
                // ATUALIZAR MOVIMENTAÇÃO DE ESTOQUE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC (TESTADO COM SUCESSO.)                    
                objHistMovAC.setIdProd((int) jTabelaItensNFeCompras.getValueAt(i, 1));
                objHistMovAC.setIdLocal(Integer.valueOf(jIdLocal.getText()));
                objHistMovAC.setTipoOpe(tipoInventario);
                objHistMovAC.setNomeOperacao(nomeOperacao);
                objHistMovAC.setIdDoc(Integer.valueOf(jNrNFe.getText()));
                objHistMovAC.setDataMov(jDataEntrada.getDate());
                try {
                    objHistMovAC.setQtdItem(valorRealMoed.parse((String) jTabelaItensNFeCompras.getValueAt(i, 3)).floatValue());
                } catch (ParseException ex) {
                }
                // CALCULAR NOVO SALDO DO HISTORICO_MOVIMENTACAO_ESTOQUE_AC (CORRIGIDO EM 29/08/2016 - EM ITABUNA)
                objProdMed.setIdProd((int) jTabelaItensNFeCompras.getValueAt(i, 1));
                calcularSaldoHistorico();
                // INCLUI O NOVO REGISTRO NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC                      
                objHistMovAC.setSaldoAtual((float) qtdEstoque);
                controlHistMov.incluirHistoricoProdutoAC(objHistMovAC);
                // ATUALIZAR CADASTRO DE PRODUTOS COM A DATA COMPRA, DATA DE VALIDADE, QUANTIDADE COMPRA E VALOR DE COMPRA
                objProdMed.setDescricaoFornecedor(jDescricaoFornecedor.getText());
                objProdMed.setIdProd((int) jTabelaItensNFeCompras.getValueAt(i, 1));
                objProdMed.setDataCompra(jDataEntrada.getDate());
                try {
                    objProdMed.setQtdCompra(valorRealMoed.parse((String) jTabelaItensNFeCompras.getValueAt(i, 3)).floatValue());
                    objProdMed.setValorCompra(valorRealMoed.parse((String) jTabelaItensNFeCompras.getValueAt(i, 4)).floatValue());
                } catch (ParseException ex) {
                }
                objProdMed.setDataValidade(date);
                controlAtualCompras.alterarDadosCompras(objProdMed);
            }
            Finalizar();
        }
    }

    // SOMAR QUANTIDADE DE CADA PRODUTO NA TABELA DE LOTEPRODUTOS PARA INSERIR NA TABELA DE HISTORICO MOVIMENTAÇÃO ESTOQUE
    public void SomaProdutoLote() {
        qtdEstoque = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_AC WHERE IdProd='" + objProdMed.getIdProd() + "'");
            while (conecta.rs.next()) {
                qtdEstoque = objProdMed.getSaldoAtual() + conecta.rs.getFloat("Qtd");
            }
            objProdMed.setSaldoAtual((float) qtdEstoque);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na soma do saldo de estoque.\nERRO: " + ex);
        }
    }

    public void calcularSaldoHistorico() {
        qtdEstoque = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_AC WHERE IdProd='" + objProdMed.getIdProd() + "'");
            conecta.rs.first();
            qtdEstoque = conecta.rs.getFloat("Qtd");
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        objNFEComprasv.setStatusNf(statusEntrada);
        objNFEComprasv.setIdNfEntrada(Integer.parseInt(jIdLanc.getText()));
        control.finalizarNFeCompras(objNFEComprasv);
        jStatusNFe.setText(statusEntrada);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
        jDataEntrada.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtNovoItem.setEnabled(!true);
    }

    public void buscarCodigoDoc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM NF_COMPRAS");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdNfEntrada"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código da registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_COMPRAS_MATERIAIS WHERE IdNfEntrada='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codEntrada = conecta.rs.getString("IdNfEntrada");
            if (jIdLanc.getText().equals(codEntrada)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os itens relacionados a esse registro.");
            } else {
                conecta.executaSQL("SELECT * FROM PARCELAS_COMPRAS WHERE IdNfEntrada='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                codParcela = conecta.rs.getString("IdNfEntrada");
                if (jIdLanc.getText().equals(codParcela)) {
                    JOptionPane.showMessageDialog(rootPane, "Existe parcelas para esse registro. Antes de excluir, delete as parcelas.");
                }
                conecta.desconecta();
            }
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objNFEComprasv.setIdNfEntrada(Integer.parseInt(jIdLanc.getText()));
                control.excluirNFeCompras(objNFEComprasv);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void NovoItem() {
        // Limpar campos dos produtos
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("0,00");
        jValorUnitario.setText("0,00");
        jAliquotoICMS.setText("0,00");
        jAliquotaIPI.setText("0,00");
        jDataVcto.setCalendar(Calendar.getInstance());
        jValorTotalItem.setText("0,00");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(true);
        jValorUnitario.setEnabled(true);
        jAliquotoICMS.setEnabled(true);
        jAliquotaIPI.setEnabled(true);
        jDataVcto.setEnabled(true);
        jValorTotalItem.setEnabled(true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(true);
        jBtBuscarProduto.setEnabled(true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(!true);
        // ABA MANUTENÇÃO
        jModelo.setEnabled(!true);
        jSerie.setEnabled(!true);
        jNumeroNFe.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        jComboBoxFormaPagto.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jBaseCalculoICMS.setEnabled(!true);
        jValorICMS.setEnabled(!true);
        jBaseCalculoICMSSub.setEnabled(!true);
        jValorICMSSub.setEnabled(!true);
        jValorTotalProdutos.setEnabled(!true);
        jValorTotalFrete.setEnabled(!true);
        jValorTotalSeguro.setEnabled(!true);
        jValorTotalDesconto.setEnabled(!true);
        jValorTotalIPI.setEnabled(!true);
        jValorTotalNota.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(!true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // ABA PARCELAS
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void AlterarItem() {
        jPedidoCompras.setEnabled(true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(true);
        jValorUnitario.setEnabled(true);
        jAliquotoICMS.setEnabled(true);
        jAliquotaIPI.setEnabled(true);
        jDataVcto.setEnabled(true);
        jValorTotalItem.setEnabled(true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(true);
        jBtBuscarProduto.setEnabled(true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtAuditoriaItem.setEnabled(!true);
        // ABA MANUTENÇÃO
        jModelo.setEnabled(!true);
        jSerie.setEnabled(!true);
        jNumeroNFe.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        jComboBoxFormaPagto.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jBaseCalculoICMS.setEnabled(!true);
        jValorICMS.setEnabled(!true);
        jBaseCalculoICMSSub.setEnabled(!true);
        jValorICMSSub.setEnabled(!true);
        jValorTotalProdutos.setEnabled(!true);
        jValorTotalFrete.setEnabled(!true);
        jValorTotalSeguro.setEnabled(!true);
        jValorTotalDesconto.setEnabled(!true);
        jValorTotalIPI.setEnabled(!true);
        jValorTotalNota.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(!true);
        jBtPesqLocalArmazenamento.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // ABA PARCELAS
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void ExcluirItem() {
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // ABA PARCELAS
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
    }

    public void SalvarItem() {
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(!true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // ABA PARCELAS
        if (jComboBoxFormaPagto.getSelectedItem().equals("1 - Pagamento a Prazo") || jComboBoxFormaPagto.getSelectedItem().equals("2 - Fatura")) {
            jBtNovaParcela.setEnabled(true);
        }
    }

    public void CancelarItem() {
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        // ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // ABA PARCELAS
        if (jComboBoxFormaPagto.getSelectedItem().equals("1 - Pagamento a Prazo") || jComboBoxFormaPagto.getSelectedItem().equals("2 - Fatura")) {
            jBtNovaParcela.setEnabled(true);
        }
    }

    public void buscarItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_COMPRAS_MATERIAIS");
            conecta.rs.last();
            idItem = conecta.rs.getString("IdItem");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do Item.");
        }
        conecta.desconecta();
    }

    public void verificarProduto() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_COMPRAS_MATERIAIS WHERE IdProd='" + jIdProd.getText() + "' "
                    + "AND IdNfEntrada='" + jIdLanc.getText() + "' "
                    + "AND Lote='" + jLote.getText() + "'");
            conecta.rs.first();
            codProd = conecta.rs.getString("IdProd");
            codNf = conecta.rs.getString("IdNfEntrada");
            loteProd = conecta.rs.getString("Lote");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaParcela() {
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText(jDescricaoFornecedor.getText());
        jCodParcela.setText("");
        jDataVctoParcela.setCalendar(Calendar.getInstance());
        jValorParcela.setText("0,00");
        jValorTotalDocumento.setText(jValorTotalNota.getText());
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(true);
        jDataVctoParcela.setEnabled(true);
        jValorParcela.setEnabled(true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(true);
        jBtCancelarParcela.setEnabled(true);
        jBtAuditoriaParcela.setEnabled(!true);
        // ABA PRODUTOS
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //ABA MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jModelo.setEnabled(!true);
        jSerie.setEnabled(!true);
        jNumeroNFe.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        jComboBoxFormaPagto.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jBaseCalculoICMS.setEnabled(!true);
        jValorICMS.setEnabled(!true);
        jBaseCalculoICMSSub.setEnabled(!true);
        jValorICMSSub.setEnabled(!true);
        jValorTotalProdutos.setEnabled(!true);
        jValorTotalFrete.setEnabled(!true);
        jValorTotalSeguro.setEnabled(!true);
        jValorTotalDesconto.setEnabled(!true);
        jValorTotalIPI.setEnabled(!true);
        jValorTotalNota.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(!true);
    }

    public void AlterarParcela() {
        // Habilitar/Desabilitar campos da parcela      
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(true);
        jDataVctoParcela.setEnabled(true);
        jValorParcela.setEnabled(true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(!true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(true);
        jBtCancelarParcela.setEnabled(true);
        jBtAuditoriaParcela.setEnabled(!true);
        // ABA PRODUTOS
        jPedidoCompras.setText("");
        jIdProd.setText("");
        jCodigoBarras.setText("");
        jReferencia.setText("");
        jLote.setText("");
        jDescricaoProduto.setText("");
        jUnidade.setText("");
        jQuantidade.setText("");
        jValorUnitario.setText("");
        jAliquotoICMS.setText("");
        jAliquotaIPI.setText("");
        jDataVcto.setDate(null);
        jValorTotalItem.setText("");
        // Habilita/Desabilita campos dos produtos
        jPedidoCompras.setEnabled(!true);
        jIdProd.setEnabled(!true);
        jCodigoBarras.setEnabled(true);
        jReferencia.setEnabled(!true);
        jLote.setEnabled(!true);
        jDescricaoProduto.setEnabled(!true);
        jUnidade.setEnabled(!true);
        jQuantidade.setEnabled(!true);
        jValorUnitario.setEnabled(!true);
        jAliquotoICMS.setEnabled(!true);
        jAliquotaIPI.setEnabled(!true);
        jDataVcto.setEnabled(!true);
        jValorTotalItem.setEnabled(!true);
        // Habilta/Desabilitar botões dos Produtos
        jBtBuscarPedidoCompra.setEnabled(!true);
        jBtBuscarProduto.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAuditoriaItem.setEnabled(!true);
        //ABA MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jModelo.setEnabled(!true);
        jSerie.setEnabled(!true);
        jNumeroNFe.setEnabled(!true);
        jDataEmissao.setEnabled(!true);
        jComboBoxTipoDocumento.setEnabled(!true);
        jComboBoxFormaPagto.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jBaseCalculoICMS.setEnabled(!true);
        jValorICMS.setEnabled(!true);
        jBaseCalculoICMSSub.setEnabled(!true);
        jValorICMSSub.setEnabled(!true);
        jValorTotalProdutos.setEnabled(!true);
        jValorTotalFrete.setEnabled(!true);
        jValorTotalSeguro.setEnabled(!true);
        jValorTotalDesconto.setEnabled(!true);
        jValorTotalIPI.setEnabled(!true);
        jValorTotalNota.setEnabled(!true);
        jObservacao.setEnabled(!true);
        // Habilitar/Desabilitar botões Dados NFe
        jBtPesDescricaoFornecedor.setEnabled(!true);
    }

    public void ExcluirParcela() {
        // Limpara campos das parcelas
        jDescricaoFornecedorParcela.setText(jDescricaoFornecedor.getText());
        jCodParcela.setText("");
        jDataVctoParcela.setCalendar(Calendar.getInstance());
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
        //ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA PRODUTOS
        jBtNovoItem.setEnabled(!true);
    }

    public void SalvarParcela() {
        jDescricaoFornecedorParcela.setText(jDescricaoFornecedor.getText());
        jCodParcela.setText("");
        jDataVctoParcela.setCalendar(Calendar.getInstance());
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela      
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
        //ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA PRODUTOS
        jBtNovoItem.setEnabled(true);
    }

    public void CancelarParcela() {
        jDescricaoFornecedorParcela.setText("");
        jCodParcela.setText("");
        jDataVctoParcela.setDate(null);
        jValorParcela.setText("");
        jValorTotalDocumento.setText("");
        // Habilitar/Desabilitar campos da parcela       
        jDescricaoFornecedorParcela.setEnabled(!true);
        jCodParcela.setEnabled(!true);
        jDataVctoParcela.setEnabled(!true);
        jValorParcela.setEnabled(!true);
        jValorTotalDocumento.setEnabled(!true);
        // Habilitar/Desabilitar botões da parcelas
        jBtNovaParcela.setEnabled(true);
        jBtAlterarParcela.setEnabled(!true);
        jBtExcluirParcela.setEnabled(!true);
        jBtSalvarParcela.setEnabled(!true);
        jBtCancelarParcela.setEnabled(!true);
        jBtAuditoriaParcela.setEnabled(!true);
        //ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA PRODUTOS
        jBtNovoItem.setEnabled(true);
    }

    public void buscarCodParcela() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARCELAS_COMPRAS");
            conecta.rs.last();
            jCodParcela.setText(conecta.rs.getString("IdParc"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código da parcela.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void pesquisarNFeCompras(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Emissao", "Status NFE", "Dt.Entrada ", "Fornecedor ", " Valor NFE "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data de emissão
                dataEmissao = conecta.rs.getString("DataEmissao");
                String dia = dataEmissao.substring(8, 10);
                String mes = dataEmissao.substring(5, 7);
                String ano = dataEmissao.substring(0, 4);
                dataEmissao = dia + "/" + mes + "/" + ano;
                // Formatar data de entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                //
                valorTotalNFE = conecta.rs.getFloat("ValorTotalNFE");
                DecimalFormat vtn = new DecimalFormat(",###.00");
                String valorTotalNFe = vtn.format(valorTotalNFE);
                valorTotalNFeFinal = valorTotalNFe;
                //
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdNfEntrada"), dataEmissao, conecta.rs.getString("StatusNf"), dataEntrada, conecta.rs.getString("RazaoSocial"), valorTotalNFeFinal});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaNFeCompras.setModel(modelo);
        jTabelaNFeCompras.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaNFeCompras.getColumnModel().getColumn(0).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaNFeCompras.getColumnModel().getColumn(1).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaNFeCompras.getColumnModel().getColumn(2).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaNFeCompras.getColumnModel().getColumn(3).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(4).setPreferredWidth(280);
        jTabelaNFeCompras.getColumnModel().getColumn(4).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTabelaNFeCompras.getColumnModel().getColumn(5).setResizable(false);
        jTabelaNFeCompras.getTableHeader().setReorderingAllowed(false);
        jTabelaNFeCompras.setAutoResizeMode(jTabelaNFeCompras.AUTO_RESIZE_OFF);
        jTabelaNFeCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaCamposTabelaNFe();
        conecta.desconecta();
    }

    public void alinhaCamposTabelaNFe() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaNFeCompras.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaNFeCompras.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaNFeCompras.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaNFeCompras.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaNFeCompras.getColumnModel().getColumn(5).setCellRenderer(direita);
    }

    public void limparTabelaNFe() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Dt.Emissão", "Status NFE", "Dt.Entrada", "Fornecedor", "Valor NFE"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaNFeCompras.setModel(modelo);
        jTabelaNFeCompras.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaNFeCompras.getColumnModel().getColumn(0).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaNFeCompras.getColumnModel().getColumn(1).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaNFeCompras.getColumnModel().getColumn(2).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaNFeCompras.getColumnModel().getColumn(3).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(4).setPreferredWidth(280);
        jTabelaNFeCompras.getColumnModel().getColumn(4).setResizable(false);
        jTabelaNFeCompras.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTabelaNFeCompras.getColumnModel().getColumn(5).setResizable(false);
        jTabelaNFeCompras.getTableHeader().setReorderingAllowed(false);
        jTabelaNFeCompras.setAutoResizeMode(jTabelaNFeCompras.AUTO_RESIZE_OFF);
        jTabelaNFeCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código ", "Descrição Produto", "Qtd.", "Valor UN", "Data Val.", "Lote"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                // Formatar a data de emissão
                dataValidade = conecta.rs.getString("DataVctoLote");
                if (dataValidade != null) {
                    String diav = dataValidade.substring(8, 10);
                    String mesv = dataValidade.substring(5, 7);
                    String anov = dataValidade.substring(0, 4);
                    dataValidade = diav + "/" + mesv + "/" + anov;
                }
                //
                qtdItem = conecta.rs.getFloat("QtdItem");
                DecimalFormat vi = new DecimalFormat(",###0.00");
                String vqtdItem = vi.format(qtdItem);
                qtdItemTab = vqtdItem;
                //
                valorUnitario1 = conecta.rs.getFloat("ValorUN");
                DecimalFormat vu1 = new DecimalFormat(",###.00");
                String valorUnitarioP = vu1.format(valorUnitario1);
                valorUnitario2 = valorUnitarioP;
                //
                jtotalItens.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdProd"), conecta.rs.getString("DescricaoProd"), qtdItemTab, valorUnitario2, dataValidade, conecta.rs.getString("Lote")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensNFeCompras.setModel(modelo);
        jTabelaItensNFeCompras.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaItensNFeCompras.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensNFeCompras.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaItensNFeCompras.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensNFeCompras.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaItensNFeCompras.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensNFeCompras.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTabelaItensNFeCompras.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensNFeCompras.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTabelaItensNFeCompras.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensNFeCompras.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTabelaItensNFeCompras.getColumnModel().getColumn(5).setResizable(false);
        jTabelaItensNFeCompras.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTabelaItensNFeCompras.getColumnModel().getColumn(6).setResizable(false);
        jTabelaItensNFeCompras.getTableHeader().setReorderingAllowed(false);
        jTabelaItensNFeCompras.setAutoResizeMode(jTabelaItensNFeCompras.AUTO_RESIZE_OFF);
        jTabelaItensNFeCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaCamposTabelaItensNFe();
        conecta.desconecta();
    }

    public void alinhaCamposTabelaItensNFe() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensNFeCompras.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensNFeCompras.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaItensNFeCompras.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaItensNFeCompras.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTabelaItensNFeCompras.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaItensNFeCompras.getColumnModel().getColumn(6).setCellRenderer(direita);
    }

    public void preencherTabelaParcelas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Vencimento ", "Valor Parcela", "Valor Doc."};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar data de entrada
                dataVctoParcela = conecta.rs.getString("DataVcto");
                String diav = dataVctoParcela.substring(8, 10);
                String mesv = dataVctoParcela.substring(5, 7);
                String anov = dataVctoParcela.substring(0, 4);
                dataVctoParcela = diav + "/" + mesv + "/" + anov;
                //
                valorParcelaTabela2 = conecta.rs.getFloat("ValorParcela");
                DecimalFormat vpt = new DecimalFormat(",###.00");
                String valorParcelaT = vpt.format(valorParcelaTabela2);
                valorParcelaTabela = valorParcelaT;
                //
                valorTotalParcela = conecta.rs.getFloat("ValorTotalParcelas");
                DecimalFormat vtn2 = new DecimalFormat(",###.00");
                String valorTotalParce = vtn2.format(valorTotalParcela);
                valorTotalParccelas2 = valorTotalParce;
                dados.add(new Object[]{conecta.rs.getInt("IdParc"), dataVctoParcela, valorParcelaTabela, valorTotalParccelas2});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaParcelas.setModel(modelo);
        jTabelaParcelas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaParcelas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaParcelas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaParcelas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaParcelas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTabelaParcelas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaParcelas.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaParcelas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaParcelas.getTableHeader().setReorderingAllowed(false);
        jTabelaParcelas.setAutoResizeMode(jTabelaParcelas.AUTO_RESIZE_OFF);
        jTabelaParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinhaCamposTabelaParcelas();
        conecta.desconecta();
    }

    public void alinhaCamposTabelaParcelas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaParcelas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaParcelas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaParcelas.getColumnModel().getColumn(2).setCellRenderer(direita);
        jTabelaParcelas.getColumnModel().getColumn(3).setCellRenderer(direita);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserAL = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
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
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
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
