/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePagamentoKit;
import gestor.Controle.ControlePagamentosKitInternos;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.ItensPagamentoKitInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PagamentoKitInterno;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloBaseDois.codigoUserGroupB2;
import static gestor.Visao.TelaModuloBaseDois.codigoGrupoB2;
import static gestor.Visao.TelaModuloBaseDois.codAbrirB2;
import static gestor.Visao.TelaModuloBaseDois.codConsultarB2;
import static gestor.Visao.TelaModuloBaseDois.codAlterarB2;
import static gestor.Visao.TelaModuloBaseDois.codExcluirB2;
import static gestor.Visao.TelaModuloBaseDois.codGravarB2;
import static gestor.Visao.TelaModuloBaseDois.codIncluirB2;
import static gestor.Visao.TelaModuloBaseDois.codUserAcessoB2;
import static gestor.Visao.TelaModuloBaseDois.codigoUserB2;
import static gestor.Visao.TelaModuloBaseDois.nomeGrupoB2;
import static gestor.Visao.TelaModuloBaseDois.nomeTelaB2;
import static gestor.Visao.TelaModuloBaseDois.telaEntregaMaterialUsoB2;
import static gestor.Visao.TelaModuloBaseDois.telaEntregaMaterialUsoInternosB2;
import static gestor.Visao.TelaModuloBaseDois.telaEntregaMaterialUsoInternosBioB2;
import static gestor.Visao.TelaModuloBaseUm.codigoUserGroupB1;
import static gestor.Visao.TelaModuloBaseUm.codigoGrupoB1;
import static gestor.Visao.TelaModuloBaseUm.codAbrirB1;
import static gestor.Visao.TelaModuloBaseUm.codAlterarB1;
import static gestor.Visao.TelaModuloBaseUm.codExcluirB1;
import static gestor.Visao.TelaModuloBaseUm.codGravarB1;
import static gestor.Visao.TelaModuloBaseUm.codIncluirB1;
import static gestor.Visao.TelaModuloBaseUm.codConsultarB1;
import static gestor.Visao.TelaModuloBaseUm.codUserAcessoB1;
import static gestor.Visao.TelaModuloBaseUm.codigoUserB1;
import static gestor.Visao.TelaModuloBaseUm.nomeGrupoB1;
import static gestor.Visao.TelaModuloBaseUm.nomeTelaB1;
import static gestor.Visao.TelaModuloBaseUm.telaEntregaMaterialUsoB1;
import static gestor.Visao.TelaModuloBaseUm.telaEntregaMaterialUsoInternosB1;
import static gestor.Visao.TelaModuloBaseUm.telaEntregaMaterialUsoInternosBioB1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloSeguranca.codUserAcesso;
import static gestor.Visao.TelaModuloSeguranca.codigoUser;
import static gestor.Visao.TelaModuloSeguranca.nomeGrupo;
import static gestor.Visao.TelaModuloTriagem.codAbrirTRI;
import static gestor.Visao.TelaModuloTriagem.codAlterarTRI;
import static gestor.Visao.TelaModuloTriagem.codConcultarTRI;
import static gestor.Visao.TelaModuloTriagem.codExcluirTRI;
import static gestor.Visao.TelaModuloTriagem.codGravarTRI;
import static gestor.Visao.TelaModuloTriagem.codIncluirTRI;
import static gestor.Visao.TelaModuloTriagem.codUserAcessoTRI;
import static gestor.Visao.TelaModuloTriagem.codigoGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.codigoUserGroupTRI;
import static gestor.Visao.TelaModuloTriagem.codigoUserTRI;
import static gestor.Visao.TelaModuloTriagem.nomeGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.nomeTelaTRI;
import static gestor.Visao.TelaModuloTriagem.telaEntregaMaterialUsoInternosBioTRI;
import static gestor.Visao.TelaModuloTriagem.telaEntregaMaterialUsoInternosTRI;
import static gestor.Visao.TelaModuloTriagem.telaEntregaMaterialUsoTRI;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
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
 * @author ronaldo
 */
public class TelaPagamentoKitInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PagamentoKitInterno objPag = new PagamentoKitInterno();
    ControlePagamentoKit control = new ControlePagamentoKit();
    //   
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    ControlePagamentosKitInternos controle = new ControlePagamentosKitInternos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Base Pavilhão:Pagamento de Kit de Internos:Manutenção";
    String nomeModuloTela2 = "Base:Pagamento de Kit de Internos:Pertences";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int count;
    String dataEntrada;
    String dataSaida;
    String dataInicial;
    String dataFinal;
    String situacaoKit = "ABERTO";
    String codLanc;
    // VARIÁVEIS PARA OS KITS INICIAL E 15 DIAS
    int copo, prato, colher, vasilha, garfo, absorvente, bermuda, lencol, colchao, toalha, camisa, cueca, sandalia, desodorante = 0;
    int cobertor, bola, calcaoJogo, camisaJogo, parMeiao = 0;
    int cremeDental, sabonete, papelHigienico, barbeador, escovaDente, sabaopo = 0;
    public static int idItem;
    String caminho;
    int marcaTodos = 0;
    int kitAnual = 0;
    int kitDecimal = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitSemetral = 0;
    int tipoEntrada = 0; // MANUAL É (0) - BIOMETRIA (1)
    String codigoInterno;
    String codigoKit;
    /**
     * Creates new form TelaPagamentoKitInterno
     */
    public static TelaBiometriaKitInterno telaBiometriaKit;

    public TelaPagamentoKitInterno() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarTelaBiometria() {
        telaBiometriaKit = new TelaBiometriaKitInterno(this, true);
        telaBiometriaKit.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jBtPesqData = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jPesqNomeInternoVisitado = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaPagamentoKit = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jResponsavel = new javax.swing.JTextField();
        jHorarioInicial = new javax.swing.JFormattedTextField();
        jHorarioTermino = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxPavilhao = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxTipoKit = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtAuditoria = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBtImpressao = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesquisarInternoKit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jCheckBoxPrato = new javax.swing.JCheckBox();
        jCheckBoxSandalia = new javax.swing.JCheckBox();
        jCheckBoxBermuda = new javax.swing.JCheckBox();
        jCheckBoxCamisa = new javax.swing.JCheckBox();
        jCheckBoxCueca = new javax.swing.JCheckBox();
        jCheckBoxColchao = new javax.swing.JCheckBox();
        jCheckBoxGarfo = new javax.swing.JCheckBox();
        jCheckBoxCobertor = new javax.swing.JCheckBox();
        jCheckBoxParMeiao = new javax.swing.JCheckBox();
        jCheckBoxCamisaJogo = new javax.swing.JCheckBox();
        jCheckBoxCalcaoJogo = new javax.swing.JCheckBox();
        jCheckBoxBolaFutsal = new javax.swing.JCheckBox();
        jCheckBoxVasilha = new javax.swing.JCheckBox();
        jCheckBoxCopo = new javax.swing.JCheckBox();
        jCheckBoxLencol = new javax.swing.JCheckBox();
        jCheckBoxColher = new javax.swing.JCheckBox();
        jCheckBoxToalha = new javax.swing.JCheckBox();
        jCheckBoxEscova = new javax.swing.JCheckBox();
        jCheckBoxDesodorante = new javax.swing.JCheckBox();
        jCheckBoxAbsorvente = new javax.swing.JCheckBox();
        jCheckBoxSabonete = new javax.swing.JCheckBox();
        jCheckBoxPapel = new javax.swing.JCheckBox();
        jCheckBoxSabaoPo = new javax.swing.JCheckBox();
        jCheckBoxBarbeador = new javax.swing.JCheckBox();
        jCheckBoxCreme = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSairInterno = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jFotoInternoKit = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jCheckBoxKitAnual = new javax.swing.JCheckBox();
        jCheckBoxDecimal = new javax.swing.JCheckBox();
        jCheckBoxSemestral = new javax.swing.JCheckBox();
        jCheckBoxKitQuinzenal = new javax.swing.JCheckBox();
        jCheckBoxMensal = new javax.swing.JCheckBox();
        jDataEntrega = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jHorarioPagto = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jBtBiometria = new javax.swing.JButton();
        jBtAuditoriaItens = new javax.swing.JButton();
        jCheckBoxMarcaTodos = new javax.swing.JCheckBox();

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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Relação de Materiais de Uso Pessoal de Internos (Kit) {FO.SGP.07} :::...");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Shopping_cart_Icon_16.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jCheckBox19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox19.setText("Todos");
        jCheckBox19.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox19ItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome Interno:");

        jPesqNomeInternoVisitado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox19))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jCheckBox19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaPagamentoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPagamentoKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaPagamentoKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPagamentoKitMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaPagamentoKit);
        if (jTabelaPagamentoKit.getColumnModel().getColumnCount() > 0) {
            jTabelaPagamentoKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(3).setMinWidth(350);
            jTabelaPagamentoKit.getColumnModel().getColumn(3).setMaxWidth(350);
        }

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

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(204, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Responsável");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Hora Inicio");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Hora Termino");

        jResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jResponsavel.setEnabled(false);

        jHorarioInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioInicial.setEnabled(false);

        jHorarioTermino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioTermino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioTermino.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Pavilhão");

        jComboBoxPavilhao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhao.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tipo de Kit");

        jComboBoxTipoKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoKit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Kit Anual", "Kit Decimal", "Kit Quinzenal", "Kit Semestral", "Kit Mensal" }));
        jComboBoxTipoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoKit.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jResponsavel)
                    .addComponent(jComboBoxPavilhao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(0, 326, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jHorarioInicial)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxTipoKit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusLanc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHorarioInicial, jHorarioTermino});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
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

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
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

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
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

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar)
                .addComponent(jBtSair))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Observação");

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtImpressao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 353, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtFinalizar)
                        .addComponent(jBtImpressao))
                    .addComponent(jBtAuditoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao});

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesquisarInternoKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInternoKit.setToolTipText("Pesquisar Interno");
        jBtPesquisarInternoKit.setContentAreaFilled(false);
        jBtPesquisarInternoKit.setEnabled(false);
        jBtPesquisarInternoKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoKitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jNomeInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisarInternoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtPesquisarInternoKit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Relação de Materiais de Uso Pessoal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jCheckBoxPrato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPrato.setText("Prato ");
        jCheckBoxPrato.setEnabled(false);

        jCheckBoxSandalia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSandalia.setText("Sandália");
        jCheckBoxSandalia.setEnabled(false);

        jCheckBoxBermuda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxBermuda.setText("Bermuda");
        jCheckBoxBermuda.setEnabled(false);

        jCheckBoxCamisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCamisa.setText("Camisa");
        jCheckBoxCamisa.setEnabled(false);

        jCheckBoxCueca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCueca.setText("Cueca");
        jCheckBoxCueca.setEnabled(false);

        jCheckBoxColchao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxColchao.setText("Colchão");
        jCheckBoxColchao.setEnabled(false);

        jCheckBoxGarfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxGarfo.setText("Garfo");
        jCheckBoxGarfo.setEnabled(false);

        jCheckBoxCobertor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCobertor.setText("Cobertor");
        jCheckBoxCobertor.setEnabled(false);

        jCheckBoxParMeiao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxParMeiao.setText("Par meião");
        jCheckBoxParMeiao.setEnabled(false);

        jCheckBoxCamisaJogo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCamisaJogo.setText("Camisa Jg.");
        jCheckBoxCamisaJogo.setEnabled(false);

        jCheckBoxCalcaoJogo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCalcaoJogo.setText("Calção Jg.");
        jCheckBoxCalcaoJogo.setEnabled(false);

        jCheckBoxBolaFutsal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxBolaFutsal.setText("Bola Futsal");
        jCheckBoxBolaFutsal.setEnabled(false);

        jCheckBoxVasilha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxVasilha.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxVasilha.setText("Vasilha/Pote");
        jCheckBoxVasilha.setEnabled(false);

        jCheckBoxCopo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCopo.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxCopo.setText("Copo/Caneca");
        jCheckBoxCopo.setEnabled(false);

        jCheckBoxLencol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxLencol.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxLencol.setText("Lençol");
        jCheckBoxLencol.setEnabled(false);

        jCheckBoxColher.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxColher.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxColher.setText("Colher ");
        jCheckBoxColher.setEnabled(false);

        jCheckBoxToalha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxToalha.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxToalha.setText("Toalha");
        jCheckBoxToalha.setEnabled(false);

        jCheckBoxEscova.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxEscova.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxEscova.setText("Escova Dente");
        jCheckBoxEscova.setEnabled(false);

        jCheckBoxDesodorante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxDesodorante.setForeground(new java.awt.Color(153, 0, 102));
        jCheckBoxDesodorante.setText("Desodorante");
        jCheckBoxDesodorante.setEnabled(false);

        jCheckBoxAbsorvente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAbsorvente.setForeground(new java.awt.Color(153, 0, 102));
        jCheckBoxAbsorvente.setText("Absorvente");
        jCheckBoxAbsorvente.setEnabled(false);

        jCheckBoxSabonete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSabonete.setForeground(new java.awt.Color(0, 153, 0));
        jCheckBoxSabonete.setText("Sabonete");
        jCheckBoxSabonete.setEnabled(false);

        jCheckBoxPapel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxPapel.setForeground(new java.awt.Color(0, 153, 0));
        jCheckBoxPapel.setText("Papel Higiênico");
        jCheckBoxPapel.setEnabled(false);

        jCheckBoxSabaoPo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSabaoPo.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBoxSabaoPo.setText("Sabão Pó");
        jCheckBoxSabaoPo.setEnabled(false);

        jCheckBoxBarbeador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxBarbeador.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBoxBarbeador.setText("Barbeador");
        jCheckBoxBarbeador.setEnabled(false);

        jCheckBoxCreme.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCreme.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBoxCreme.setText("C. Dental");
        jCheckBoxCreme.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxPrato)
                    .addComponent(jCheckBoxSandalia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxBermuda)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxCueca)
                            .addComponent(jCheckBoxCamisa)
                            .addComponent(jCheckBoxGarfo)
                            .addComponent(jCheckBoxColchao))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxLencol)
                    .addComponent(jCheckBoxParMeiao)
                    .addComponent(jCheckBoxCamisaJogo)
                    .addComponent(jCheckBoxCalcaoJogo)
                    .addComponent(jCheckBoxBolaFutsal)
                    .addComponent(jCheckBoxCobertor)
                    .addComponent(jCheckBoxToalha))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxDesodorante)
                    .addComponent(jCheckBoxAbsorvente)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxEscova)
                            .addComponent(jCheckBoxColher)
                            .addComponent(jCheckBoxVasilha)
                            .addComponent(jCheckBoxCopo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxCreme)
                            .addComponent(jCheckBoxBarbeador)
                            .addComponent(jCheckBoxSabaoPo)
                            .addComponent(jCheckBoxSabonete)))
                    .addComponent(jCheckBoxPapel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxSabonete)
                    .addComponent(jCheckBoxCopo)
                    .addComponent(jCheckBoxCobertor)
                    .addComponent(jCheckBoxCueca))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxPrato)
                    .addComponent(jCheckBoxBolaFutsal)
                    .addComponent(jCheckBoxVasilha)
                    .addComponent(jCheckBoxSabaoPo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxSandalia)
                    .addComponent(jCheckBoxCalcaoJogo)
                    .addComponent(jCheckBoxColher)
                    .addComponent(jCheckBoxBarbeador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxCamisa)
                    .addComponent(jCheckBoxCamisaJogo)
                    .addComponent(jCheckBoxEscova)
                    .addComponent(jCheckBoxCreme))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxGarfo)
                    .addComponent(jCheckBoxParMeiao)
                    .addComponent(jCheckBoxAbsorvente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxColchao)
                    .addComponent(jCheckBoxLencol)
                    .addComponent(jCheckBoxDesodorante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxBermuda)
                    .addComponent(jCheckBoxToalha)
                    .addComponent(jCheckBoxPapel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome do Interno"
            }
        ));
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setText("Novo");
        jBtNovoInterno.setContentAreaFilled(false);
        jBtNovoInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setText("Alterar");
        jBtAlterarInterno.setContentAreaFilled(false);
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setText("Excluir");
        jBtExcluirInterno.setContentAreaFilled(false);
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setText("Gravar");
        jBtSalvarInterno.setContentAreaFilled(false);
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setText("Cancelar");
        jBtCancelarInterno.setContentAreaFilled(false);
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtSairInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairInterno.setText("Sair");
        jBtSairInterno.setContentAreaFilled(false);
        jBtSairInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovoInterno)
                .addComponent(jBtAlterarInterno)
                .addComponent(jBtExcluirInterno)
                .addComponent(jBtSalvarInterno)
                .addComponent(jBtCancelarInterno)
                .addComponent(jBtSairInterno))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Internos/Materiais", jPanel9);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKit, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Frequência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        jCheckBoxKitAnual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxKitAnual.setText("Kit Anual");
        jCheckBoxKitAnual.setEnabled(false);
        jCheckBoxKitAnual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxKitAnualItemStateChanged(evt);
            }
        });

        jCheckBoxDecimal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxDecimal.setForeground(new java.awt.Color(0, 153, 51));
        jCheckBoxDecimal.setText("Kit Decendial");
        jCheckBoxDecimal.setEnabled(false);
        jCheckBoxDecimal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxDecimalItemStateChanged(evt);
            }
        });

        jCheckBoxSemestral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxSemestral.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxSemestral.setText("Kit Semestral");
        jCheckBoxSemestral.setEnabled(false);
        jCheckBoxSemestral.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxSemestralItemStateChanged(evt);
            }
        });

        jCheckBoxKitQuinzenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxKitQuinzenal.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBoxKitQuinzenal.setText("Kit Quinzenal");
        jCheckBoxKitQuinzenal.setEnabled(false);
        jCheckBoxKitQuinzenal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxKitQuinzenalItemStateChanged(evt);
            }
        });

        jCheckBoxMensal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMensal.setForeground(new java.awt.Color(153, 0, 102));
        jCheckBoxMensal.setText("Kit Mensal");
        jCheckBoxMensal.setEnabled(false);
        jCheckBoxMensal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMensalItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxMensal)
                    .addComponent(jCheckBoxSemestral)
                    .addComponent(jCheckBoxKitQuinzenal)
                    .addComponent(jCheckBoxDecimal)
                    .addComponent(jCheckBoxKitAnual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jCheckBoxKitAnual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDecimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxKitQuinzenal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSemestral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxMensal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDataEntrega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Entrega");

        jHorarioPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Horário");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtBiometria.setForeground(new java.awt.Color(0, 204, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setText("Biometria");
        jBtBiometria.setToolTipText("Pesquisar Interno pelo Biometria");
        jBtBiometria.setEnabled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        jBtAuditoriaItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItens.setToolTipText("Auditoria");
        jBtAuditoriaItens.setContentAreaFilled(false);
        jBtAuditoriaItens.setEnabled(false);
        jBtAuditoriaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItensActionPerformed(evt);
            }
        });

        jCheckBoxMarcaTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMarcaTodos.setText("Marcar Todos");
        jCheckBoxMarcaTodos.setEnabled(false);
        jCheckBoxMarcaTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMarcaTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtBiometria)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBoxMarcaTodos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoriaItens)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxMarcaTodos)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jHorarioPagto)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        setBounds(300, 60, 632, 477);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else {
            if (jDataPesqFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesqFinal.requestFocus();
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                    preencherTabelaPagotKit("SELECT * FROM PAGAMENTO_KIT_INTERNOS WHERE DataLanc BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            preencherTabelaPagotKit("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdPagto='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jCheckBox19ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox19ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaPagotKit("SELECT * FROM PAGAMENTO_KIT_INTERNOS");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox19ItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInternoVisitado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisa.");
        } else {
            preencherTabelaPagotKitInterno("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jTabelaPagamentoKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPagamentoKitMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaPagamentoKit.getValueAt(jTabelaPagamentoKit.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            jDataLanc.setDate(jDataLanc.getDate());
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtBiometria.setEnabled(true);
            //
            limparCamposManutencao();
            //
            bloquearCampos();
            jComboBoxPavilhao.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM  PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PAVILHAO "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "WHERE IdPagto='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdPagto")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jResponsavel.setText(conecta.rs.getString("Responsavel"));
                jHorarioInicial.setText(conecta.rs.getString("HoraInicio"));
                jHorarioTermino.setText(conecta.rs.getString("HoraTermino"));
                jComboBoxTipoKit.setSelectedItem(conecta.rs.getString("TipoKit"));
                jComboBoxPavilhao.addItem(conecta.rs.getString("DescricaoPav"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdPagto='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaPagamentoKitMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos();
            bloquearBotoes();
            limparTabelaInternos();
            acao = 1;
            Novo();
            corCampos();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos();
            bloquearBotoes();
            limparTabelaInternos();
            acao = 1;
            Novo();
            corCampos();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos();
            bloquearBotoes();
            limparTabelaInternos();
            acao = 1;
            Novo();
            corCampos();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaInternos.getModel().getRowCount();
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (rows != 0) {
                    jComboBoxPavilhao.setEnabled(!true);
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos();
                    bloquearBotoes();
                    Alterar();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos();
                    bloquearBotoes();
                    Alterar();
                    jComboBoxPavilhao.setEnabled(true);
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codAlterarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaInternos.getModel().getRowCount();
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (rows != 0) {
                    jComboBoxPavilhao.setEnabled(!true);
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos();
                    bloquearBotoes();
                    Alterar();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos();
                    bloquearBotoes();
                    Alterar();
                    jComboBoxPavilhao.setEnabled(true);
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codAlterarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaInternos.getModel().getRowCount();
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (rows != 0) {
                    jComboBoxPavilhao.setEnabled(!true);
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos();
                    bloquearBotoes();
                    Alterar();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos();
                    bloquearBotoes();
                    Alterar();
                    jComboBoxPavilhao.setEnabled(true);
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                bloquearCampos();
                bloquearBotoes();
                verificarItens();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codExcluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                bloquearCampos();
                bloquearBotoes();
                verificarItens();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codExcluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                bloquearCampos();
                bloquearBotoes();
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objPag.setUsuarioInsert(nameUser);
                    objPag.setDataInsert(dataModFinal);
                    objPag.setHorarioInsert(horaMov);
                    //
                    control.incluirPagamentoKit(objPag);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objPag.setUsuarioUp(nameUser);
                    objPag.setDataUp(dataModFinal);
                    objPag.setHorarioUp(horaMov);
                    //
                    objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                    control.alterarPagamentoKit(objPag);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codGravarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objPag.setUsuarioInsert(nameUser);
                    objPag.setDataInsert(dataModFinal);
                    objPag.setHorarioInsert(horaMov);
                    //
                    control.incluirPagamentoKit(objPag);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objPag.setUsuarioUp(nameUser);
                    objPag.setDataUp(dataModFinal);
                    objPag.setHorarioUp(horaMov);
                    //
                    objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                    control.alterarPagamentoKit(objPag);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codGravarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objPag.setUsuarioInsert(nameUser);
                    objPag.setDataInsert(dataModFinal);
                    objPag.setHorarioInsert(horaMov);
                    //
                    control.incluirPagamentoKit(objPag);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objPag.setUsuarioUp(nameUser);
                    objPag.setDataUp(dataModFinal);
                    objPag.setHorarioUp(horaMov);
                    //
                    objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                    control.alterarPagamentoKit(objPag);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
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

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                if (jStatusLanc.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
                } else {
                    Finalizar();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPagamentoKit objAudiKit = new TelaAuditoriaPagamentoKit();
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objAudiKit);
            objAudiKit.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objAudiKit);
            objAudiKit.show();
        } else if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAudiKit);
            objAudiKit.show();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesquisarInternoKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoKitActionPerformed
        // TODO add your handling code here:
        TelaPesquisaInternosKit objPesqKit = new TelaPesquisaInternosKit();
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objPesqKit);
            objPesqKit.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objPesqKit);
            objPesqKit.show();
        } else if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objPesqKit);
            objPesqKit.show();
        }
    }//GEN-LAST:event_jBtPesquisarInternoKitActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItemPagto = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //         
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaItens.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdItem='" + idItemPagto + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItem");
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoKit.setIcon(i);
                jFotoInternoKit.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_DEFAULT)));
                // KIT ANUAL
                prato = conecta.rs.getInt("Prato");
                garfo = conecta.rs.getInt("Garfo");
                bermuda = conecta.rs.getInt("Bermuda");
                colchao = conecta.rs.getInt("Colchao");
                camisa = conecta.rs.getInt("Camisa");
                cueca = conecta.rs.getInt("Cueca");
                sandalia = conecta.rs.getInt("Sandalia");
                cobertor = conecta.rs.getInt("Cobertor");
                bola = cobertor = conecta.rs.getInt("BolaFutSal");
                calcaoJogo = cobertor = conecta.rs.getInt("CalcaoJg");
                camisaJogo = cobertor = conecta.rs.getInt("CamisaJg");
                parMeiao = cobertor = conecta.rs.getInt("ParMeiao");
                // KIT DECIMAL
                papelHigienico = conecta.rs.getInt("PapelHigienico");
                sabonete = conecta.rs.getInt("Sabonete");
                // KIT QUINZENAL
                barbeador = conecta.rs.getInt("Barbeador");
                cremeDental = conecta.rs.getInt("CremeDental");
                sabaopo = conecta.rs.getInt("SabaoPo");
                // KIT SEMESTRAL
                copo = conecta.rs.getInt("Copo");
                colher = conecta.rs.getInt("Colher");
                vasilha = conecta.rs.getInt("Vasilha");
                lencol = conecta.rs.getInt("Colchas");
                toalha = conecta.rs.getInt("Toalha");
                escovaDente = conecta.rs.getInt("EscovaDente");
                // KIT MENSAL
                absorvente = conecta.rs.getInt("Absorvente");
                desodorante = conecta.rs.getInt("Desodorante");
                //
                marcaTodos = conecta.rs.getInt("MostraTodos");
                kitAnual = conecta.rs.getInt("KitInicial");
                kitDecimal = conecta.rs.getInt("KitDecimal");
                kitQuinzenal = conecta.rs.getInt("KitQuinzenal");
                kitMensal = conecta.rs.getInt("KitMensal");
                kitSemetral = conecta.rs.getInt("KitSemestral");
                //
                jDataEntrega.setDate(conecta.rs.getDate("DataEntrega"));
                jHorarioPagto.setText(conecta.rs.getString("Horario"));
                //KIT ANUAL
                if (prato == 1) {
                    jCheckBoxPrato.setSelected(true);
                } else if (prato == 0) {
                    jCheckBoxPrato.setSelected(!true);
                }
                if (bermuda == 1) {
                    jCheckBoxBermuda.setSelected(true);
                } else if (bermuda == 0) {
                    jCheckBoxBermuda.setSelected(!true);
                }
                if (colchao == 1) {
                    jCheckBoxColchao.setSelected(true);
                } else if (colchao == 0) {
                    jCheckBoxColchao.setSelected(!true);
                }
                if (camisa == 1) {
                    jCheckBoxCamisa.setSelected(true);
                } else if (camisa == 0) {
                    jCheckBoxCamisa.setSelected(!true);
                }
                if (cueca == 1) {
                    jCheckBoxCueca.setSelected(true);
                } else if (cueca == 0) {
                    jCheckBoxCueca.setSelected(!true);
                }
                if (sandalia == 1) {
                    jCheckBoxSandalia.setSelected(true);
                } else if (sandalia == 0) {
                    jCheckBoxSandalia.setSelected(!true);
                }
                if (cobertor == 1) {
                    jCheckBoxCobertor.setSelected(true);
                } else if (cobertor == 0) {
                    jCheckBoxCobertor.setSelected(!true);
                }
                if (bola == 1) {
                    jCheckBoxBolaFutsal.setSelected(true);
                } else if (bola == 0) {
                    jCheckBoxBolaFutsal.setSelected(!true);
                }
                if (calcaoJogo == 1) {
                    jCheckBoxCalcaoJogo.setSelected(true);
                } else if (calcaoJogo == 0) {
                    jCheckBoxCalcaoJogo.setSelected(!true);
                }
                if (camisaJogo == 1) {
                    jCheckBoxCamisaJogo.setSelected(true);
                } else if (camisaJogo == 0) {
                    jCheckBoxCamisaJogo.setSelected(!true);
                }
                if (parMeiao == 1) {
                    jCheckBoxParMeiao.setSelected(true);
                } else if (parMeiao == 0) {
                    jCheckBoxParMeiao.setSelected(!true);
                }
                // KIT DECIMAL
                if (sabonete == 1) {
                    jCheckBoxSabonete.setSelected(true);
                } else if (sabonete == 0) {
                    jCheckBoxSabonete.setSelected(!true);
                }
                if (papelHigienico == 1) {
                    jCheckBoxPapel.setSelected(true);
                } else if (papelHigienico == 0) {
                    jCheckBoxPapel.setSelected(!true);
                }
                // KIT QUINZENAL
                if (cremeDental == 1) {
                    jCheckBoxCreme.setSelected(true);
                } else if (cremeDental == 0) {
                    jCheckBoxCreme.setSelected(!true);
                }
                if (barbeador == 1) {
                    jCheckBoxBarbeador.setSelected(true);
                } else if (barbeador == 0) {
                    jCheckBoxBarbeador.setSelected(!true);
                }
                if (sabaopo == 1) {
                    jCheckBoxSabaoPo.setSelected(true);
                } else if (sabaopo == 0) {
                    jCheckBoxSabaoPo.setSelected(!true);
                }
                // KIT MENSAL
                if (absorvente == 1) {
                    jCheckBoxAbsorvente.setSelected(true);
                } else if (absorvente == 0) {
                    jCheckBoxAbsorvente.setSelected(!true);
                }
                if (desodorante == 1) {
                    jCheckBoxDesodorante.setSelected(true);
                } else if (desodorante == 0) {
                    jCheckBoxDesodorante.setSelected(!true);
                }
                // KIT SEMESTRAL
                if (copo == 1) {
                    jCheckBoxCopo.setSelected(true);
                } else if (copo == 0) {
                    jCheckBoxCopo.setSelected(!true);
                }
                if (colher == 1) {
                    jCheckBoxColher.setSelected(true);
                } else if (colher == 0) {
                    jCheckBoxColher.setSelected(!true);
                }
                if (vasilha == 1) {
                    jCheckBoxVasilha.setSelected(true);
                } else if (vasilha == 0) {
                    jCheckBoxVasilha.setSelected(!true);
                }
                if (garfo == 1) {
                    jCheckBoxGarfo.setSelected(true);
                } else if (garfo == 0) {
                    jCheckBoxGarfo.setSelected(!true);
                }
                if (lencol == 1) {
                    jCheckBoxLencol.setSelected(true);
                } else if (lencol == 0) {
                    jCheckBoxLencol.setSelected(!true);
                }
                if (toalha == 1) {
                    jCheckBoxToalha.setSelected(true);
                } else if (toalha == 0) {
                    jCheckBoxToalha.setSelected(!true);
                }
                if (escovaDente == 1) {
                    jCheckBoxEscova.setSelected(true);
                } else if (escovaDente == 0) {
                    jCheckBoxEscova.setSelected(!true);
                }
                //
                if (marcaTodos == 1) {
                    jCheckBoxMarcaTodos.setSelected(true);
                } else if (marcaTodos == 0) {
                    jCheckBoxMarcaTodos.setSelected(!true);
                }
                if (kitAnual == 1) {
                    jCheckBoxKitAnual.setSelected(true);
                } else if (kitAnual == 0) {
                    jCheckBoxKitAnual.setSelected(!true);
                }
                if (kitDecimal == 1) {
                    jCheckBoxDecimal.setSelected(true);
                } else if (kitDecimal == 0) {
                    jCheckBoxDecimal.setSelected(!true);
                }
                if (kitQuinzenal == 1) {
                    jCheckBoxKitQuinzenal.setSelected(true);
                } else if (kitQuinzenal == 0) {
                    jCheckBoxKitQuinzenal.setSelected(!true);
                }
                if (kitMensal == 1) {
                    jCheckBoxMensal.setSelected(true);
                } else if (kitMensal == 0) {
                    jCheckBoxMensal.setSelected(!true);
                }
                if (kitSemetral == 1) {
                    jCheckBoxSemestral.setSelected(true);
                } else if (kitSemetral == 0) {
                    jCheckBoxSemestral.setSelected(!true);
                }
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosTRI);
        buscarAcessoUsuario1(telaEntregaMaterialUsoInternosB1);
        buscarAcessoUsuario2(telaEntregaMaterialUsoInternosB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                limparCampos();
                bloquearBotoes();
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosB1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                limparCampos();
                bloquearBotoes();
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosB2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                limparCampos();
                bloquearBotoes();
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosTRI);
        buscarAcessoUsuario1(telaEntregaMaterialUsoInternosB1);
        buscarAcessoUsuario2(telaEntregaMaterialUsoInternosB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarInterno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosB1) && codAlterarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarInterno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosB2) && codAlterarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarInterno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosTRI);
        buscarAcessoUsuario1(telaEntregaMaterialUsoInternosB1);
        buscarAcessoUsuario2(telaEntregaMaterialUsoInternosB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objItensPagto.setIdItem(idItem);
                controle.excluirPagamentoKitInterno(objItensPagto);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
                ExcluirInterno();
                preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUÍDO com sucesso.");
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosB1) && codExcluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objItensPagto.setIdItem(idItem);
                controle.excluirPagamentoKitInterno(objItensPagto);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
                ExcluirInterno();
                preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUÍDO com sucesso.");
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosB2) && codExcluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objItensPagto.setIdItem(idItem);
                controle.excluirPagamentoKitInterno(objItensPagto);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
                ExcluirInterno();
                preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUÍDO com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosTRI);
        buscarAcessoUsuario1(telaEntregaMaterialUsoInternosB1);
        buscarAcessoUsuario2(telaEntregaMaterialUsoInternosB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            verificarInternos();
            tipoEntrada = 0;
            if (marcaTodos == 0 && kitAnual == 0 && kitQuinzenal == 0 && kitDecimal == 0 && kitMensal == 0 && kitSemetral == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe um tipo de kit para ser entregue ao interno.");
            } else if (jIdInterno.getText().equals("") || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe para qual interno será o kit.");
            } else {
                // KIT ANUAL            
                if (jCheckBoxPrato.isSelected()) {
                    prato = 1;
                } else if (!jCheckBoxPrato.isSelected()) {
                    prato = 0;
                }
                if (jCheckBoxGarfo.isSelected()) {
                    garfo = 1;
                } else if (!jCheckBoxGarfo.isSelected()) {
                    garfo = 0;
                }
                if (jCheckBoxBermuda.isSelected()) {
                    bermuda = 1;
                } else if (!jCheckBoxBermuda.isSelected()) {
                    bermuda = 0;
                }
                if (jCheckBoxColchao.isSelected()) {
                    colchao = 1;
                } else if (!jCheckBoxColchao.isSelected()) {
                    colchao = 0;
                }
                if (jCheckBoxCamisa.isSelected()) {
                    camisa = 1;
                } else if (!jCheckBoxCamisa.isSelected()) {
                    camisa = 0;
                }
                if (jCheckBoxCueca.isSelected()) {
                    cueca = 1;
                } else if (!jCheckBoxCueca.isSelected()) {
                    cueca = 0;
                }
                if (jCheckBoxSandalia.isSelected()) {
                    sandalia = 1;
                } else if (!jCheckBoxSandalia.isSelected()) {
                    sandalia = 0;
                }
                if (jCheckBoxCobertor.isSelected()) {
                    cobertor = 1;
                } else if (!jCheckBoxCobertor.isSelected()) {
                    cobertor = 0;
                }
                if (jCheckBoxBolaFutsal.isSelected()) {
                    bola = 1;
                } else if (!jCheckBoxBolaFutsal.isSelected()) {
                    bola = 0;
                }
                if (jCheckBoxCalcaoJogo.isSelected()) {
                    calcaoJogo = 1;
                } else if (!jCheckBoxCalcaoJogo.isSelected()) {
                    calcaoJogo = 0;
                }
                if (jCheckBoxCamisaJogo.isSelected()) {
                    camisaJogo = 1;
                } else if (!jCheckBoxCamisaJogo.isSelected()) {
                    camisaJogo = 0;
                }
                if (jCheckBoxParMeiao.isSelected()) {
                    parMeiao = 1;
                } else if (!jCheckBoxParMeiao.isSelected()) {
                    parMeiao = 0;
                }
                // DECIMAL
                if (jCheckBoxPapel.isSelected()) {
                    papelHigienico = 1;
                } else if (!jCheckBoxPapel.isSelected()) {
                    papelHigienico = 0;
                }
                if (jCheckBoxSabonete.isSelected()) {
                    sabonete = 1;
                } else if (!jCheckBoxSabonete.isSelected()) {
                    sabonete = 0;
                }
                // KIT QUINZENAL
                if (jCheckBoxSabaoPo.isSelected()) {
                    sabaopo = 1;
                } else if (!jCheckBoxSabaoPo.isSelected()) {
                    sabaopo = 0;
                }
                if (jCheckBoxCreme.isSelected()) {
                    cremeDental = 1;
                } else if (!jCheckBoxCreme.isSelected()) {
                    cremeDental = 0;
                }
                if (jCheckBoxBarbeador.isSelected()) {
                    barbeador = 1;
                } else if (!jCheckBoxBarbeador.isSelected()) {
                    barbeador = 0;
                }
                // SEMESTRAL     
                if (jCheckBoxCopo.isSelected()) {
                    copo = 1;
                } else if (!jCheckBoxCopo.isSelected()) {
                    copo = 0;
                }
                if (jCheckBoxColher.isSelected()) {
                    colher = 1;
                } else if (!jCheckBoxColher.isSelected()) {
                    colher = 0;
                }
                if (jCheckBoxToalha.isSelected()) {
                    toalha = 1;
                }
                if (jCheckBoxLencol.isSelected()) {
                    lencol = 1;
                } else if (!jCheckBoxLencol.isSelected()) {
                    lencol = 0;
                }
                if (jCheckBoxVasilha.isSelected()) {
                    vasilha = 1;
                } else if (!jCheckBoxVasilha.isSelected()) {
                    vasilha = 0;
                }
                if (jCheckBoxEscova.isSelected()) {
                    escovaDente = 1;
                } else if (!jCheckBoxEscova.isSelected()) {
                    escovaDente = 0;
                }
                // MENSAL
                if (jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 1;
                }
                // MENSAL
                if (jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 1;
                } else if (!jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 0;
                }
                if (jCheckBoxDesodorante.isSelected()) {
                    desodorante = 1;
                } else if (!jCheckBoxDesodorante.isSelected()) {
                    desodorante = 0;
                }
                // TIPOS DE PAGAMENTO KIT
                if (jCheckBoxMarcaTodos.isSelected()) {
                    marcaTodos = 1;
                } else if (!jCheckBoxMarcaTodos.isSelected()) {
                    marcaTodos = 0;
                }
                if (jCheckBoxKitAnual.isSelected()) {
                    kitAnual = 1;
                } else if (!jCheckBoxKitAnual.isSelected()) {
                    kitAnual = 0;
                }
                if (jCheckBoxKitQuinzenal.isSelected()) {
                    kitQuinzenal = 1;
                } else if (!jCheckBoxKitQuinzenal.isSelected()) {
                    kitQuinzenal = 0;
                }
                if (jCheckBoxDecimal.isSelected()) {
                    kitDecimal = 1;
                } else if (!jCheckBoxDecimal.isSelected()) {
                    kitDecimal = 0;
                }
                if (jCheckBoxSemestral.isSelected()) {
                    kitSemetral = 1;
                } else if (!jCheckBoxSemestral.isSelected()) {
                    kitSemetral = 0;
                }
                if (jCheckBoxMensal.isSelected()) {
                    kitMensal = 1;
                } else if (!jCheckBoxMensal.isSelected()) {
                    kitMensal = 0;
                }
                // KIT ANUAL            
                objItensPagto.setPrato(prato);
                objItensPagto.setGarfo(garfo);
                objItensPagto.setBermuda(bermuda);
                objItensPagto.setColchao(colchao);
                objItensPagto.setCobertor(cobertor);
                objItensPagto.setBolaJogo(bola);
                objItensPagto.setCalcaoJogo(calcaoJogo);
                objItensPagto.setCamisaJogo(camisaJogo);
                objItensPagto.setParMeiao(parMeiao);
                objItensPagto.setCamisa(camisa);
                objItensPagto.setCueca(cueca);
                objItensPagto.setSandalia(sandalia);
                // KIT DECIMAL
                objItensPagto.setSabonete(sabonete);
                objItensPagto.setPapelHigienico(papelHigienico);
                // KIT QUINZENAL
                objItensPagto.setCremeDental(cremeDental);
                objItensPagto.setBarbeador(barbeador);
                objItensPagto.setSabaoPo(sabaopo);
                // KIT SEMESTRAL
                objItensPagto.setLencol(lencol);
                objItensPagto.setCopo(copo);
                objItensPagto.setColher(colher);
                objItensPagto.setVasilha(vasilha);
                objItensPagto.setToalha(toalha);
                objItensPagto.setEscovaDente(escovaDente);
                // KIT MENSAL
                objItensPagto.setAbsorvente(absorvente);
                objItensPagto.setDesodorante(desodorante);
                // TIPOS DE KITS
                objItensPagto.setMostraTodos(marcaTodos);
                objItensPagto.setKitInicial(kitAnual);
                objItensPagto.setKitDecimal(kitDecimal);
                objItensPagto.setKitQuinzenal(kitQuinzenal);
                objItensPagto.setKitMensal(kitMensal);
                objItensPagto.setKitSemestral(kitSemetral);
                //
                objItensPagto.setTipoEntrada(tipoEntrada);
                objItensPagto.setDataEntrega(jDataEntrega.getDate());
                objItensPagto.setHoraEntrega(jHorarioPagto.getText());
                //
                objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                objItensPagto.setNomeInternoCrcKit(jNomeInterno.getText());
                objItensPagto.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                if (acao == 3) {
                    if (jIdInterno.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
                    } else {
                        objItensPagto.setUsuarioInsert(nameUser);
                        objItensPagto.setDataInsert(dataModFinal);
                        objItensPagto.setHorarioInsert(horaMov);
                        //
                        controle.incluirPagamentoKitInterno(objItensPagto);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarInterno();
                        preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 4) {
                    objItensPagto.setUsuarioUp(nameUser);
                    objItensPagto.setDataUp(dataModFinal);
                    objItensPagto.setHorarioUp(horaMov);
                    //
                    objItensPagto.setIdItem(idItem);
                    controle.alterarPagamentoKitInterno(objItensPagto);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarInterno();
                    preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosB1) && codGravarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            verificarInternos();
            tipoEntrada = 0;
            if (marcaTodos == 0 && kitAnual == 0 && kitQuinzenal == 0 && kitDecimal == 0 && kitMensal == 0 && kitSemetral == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe um tipo de kit para ser entregue ao interno.");
            } else if (jIdInterno.getText().equals("") || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe para qual interno será o kit.");
            } else {
                // KIT ANUAL            
                if (jCheckBoxPrato.isSelected()) {
                    prato = 1;
                } else if (!jCheckBoxPrato.isSelected()) {
                    prato = 0;
                }
                if (jCheckBoxGarfo.isSelected()) {
                    garfo = 1;
                } else if (!jCheckBoxGarfo.isSelected()) {
                    garfo = 0;
                }
                if (jCheckBoxBermuda.isSelected()) {
                    bermuda = 1;
                } else if (!jCheckBoxBermuda.isSelected()) {
                    bermuda = 0;
                }
                if (jCheckBoxColchao.isSelected()) {
                    colchao = 1;
                } else if (!jCheckBoxColchao.isSelected()) {
                    colchao = 0;
                }
                if (jCheckBoxCamisa.isSelected()) {
                    camisa = 1;
                } else if (!jCheckBoxCamisa.isSelected()) {
                    camisa = 0;
                }
                if (jCheckBoxCueca.isSelected()) {
                    cueca = 1;
                } else if (!jCheckBoxCueca.isSelected()) {
                    cueca = 0;
                }
                if (jCheckBoxSandalia.isSelected()) {
                    sandalia = 1;
                } else if (!jCheckBoxSandalia.isSelected()) {
                    sandalia = 0;
                }
                if (jCheckBoxCobertor.isSelected()) {
                    cobertor = 1;
                } else if (!jCheckBoxCobertor.isSelected()) {
                    cobertor = 0;
                }
                if (jCheckBoxBolaFutsal.isSelected()) {
                    bola = 1;
                } else if (!jCheckBoxBolaFutsal.isSelected()) {
                    bola = 0;
                }
                if (jCheckBoxCalcaoJogo.isSelected()) {
                    calcaoJogo = 1;
                } else if (!jCheckBoxCalcaoJogo.isSelected()) {
                    calcaoJogo = 0;
                }
                if (jCheckBoxCamisaJogo.isSelected()) {
                    camisaJogo = 1;
                } else if (!jCheckBoxCamisaJogo.isSelected()) {
                    camisaJogo = 0;
                }
                if (jCheckBoxParMeiao.isSelected()) {
                    parMeiao = 1;
                } else if (!jCheckBoxParMeiao.isSelected()) {
                    parMeiao = 0;
                }
                // DECIMAL
                if (jCheckBoxPapel.isSelected()) {
                    papelHigienico = 1;
                } else if (!jCheckBoxPapel.isSelected()) {
                    papelHigienico = 0;
                }
                if (jCheckBoxSabonete.isSelected()) {
                    sabonete = 1;
                } else if (!jCheckBoxSabonete.isSelected()) {
                    sabonete = 0;
                }
                // KIT QUINZENAL
                if (jCheckBoxSabaoPo.isSelected()) {
                    sabaopo = 1;
                } else if (!jCheckBoxSabaoPo.isSelected()) {
                    sabaopo = 0;
                }
                if (jCheckBoxCreme.isSelected()) {
                    cremeDental = 1;
                } else if (!jCheckBoxCreme.isSelected()) {
                    cremeDental = 0;
                }
                if (jCheckBoxBarbeador.isSelected()) {
                    barbeador = 1;
                } else if (!jCheckBoxBarbeador.isSelected()) {
                    barbeador = 0;
                }
                // SEMESTRAL     
                if (jCheckBoxCopo.isSelected()) {
                    copo = 1;
                } else if (!jCheckBoxCopo.isSelected()) {
                    copo = 0;
                }
                if (jCheckBoxColher.isSelected()) {
                    colher = 1;
                } else if (!jCheckBoxColher.isSelected()) {
                    colher = 0;
                }
                if (jCheckBoxToalha.isSelected()) {
                    toalha = 1;
                }
                if (jCheckBoxLencol.isSelected()) {
                    lencol = 1;
                } else if (!jCheckBoxLencol.isSelected()) {
                    lencol = 0;
                }
                if (jCheckBoxVasilha.isSelected()) {
                    vasilha = 1;
                } else if (!jCheckBoxVasilha.isSelected()) {
                    vasilha = 0;
                }
                if (jCheckBoxEscova.isSelected()) {
                    escovaDente = 1;
                } else if (!jCheckBoxEscova.isSelected()) {
                    escovaDente = 0;
                }
                // MENSAL
                if (jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 1;
                }
                // MENSAL
                if (jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 1;
                } else if (!jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 0;
                }
                if (jCheckBoxDesodorante.isSelected()) {
                    desodorante = 1;
                } else if (!jCheckBoxDesodorante.isSelected()) {
                    desodorante = 0;
                }
                // TIPOS DE PAGAMENTO KIT
                if (jCheckBoxMarcaTodos.isSelected()) {
                    marcaTodos = 1;
                } else if (!jCheckBoxMarcaTodos.isSelected()) {
                    marcaTodos = 0;
                }
                if (jCheckBoxKitAnual.isSelected()) {
                    kitAnual = 1;
                } else if (!jCheckBoxKitAnual.isSelected()) {
                    kitAnual = 0;
                }
                if (jCheckBoxKitQuinzenal.isSelected()) {
                    kitQuinzenal = 1;
                } else if (!jCheckBoxKitQuinzenal.isSelected()) {
                    kitQuinzenal = 0;
                }
                if (jCheckBoxDecimal.isSelected()) {
                    kitDecimal = 1;
                } else if (!jCheckBoxDecimal.isSelected()) {
                    kitDecimal = 0;
                }
                if (jCheckBoxSemestral.isSelected()) {
                    kitSemetral = 1;
                } else if (!jCheckBoxSemestral.isSelected()) {
                    kitSemetral = 0;
                }
                if (jCheckBoxMensal.isSelected()) {
                    kitMensal = 1;
                } else if (!jCheckBoxMensal.isSelected()) {
                    kitMensal = 0;
                }
                // KIT ANUAL            
                objItensPagto.setPrato(prato);
                objItensPagto.setGarfo(garfo);
                objItensPagto.setBermuda(bermuda);
                objItensPagto.setColchao(colchao);
                objItensPagto.setCobertor(cobertor);
                objItensPagto.setBolaJogo(bola);
                objItensPagto.setCalcaoJogo(calcaoJogo);
                objItensPagto.setCamisaJogo(camisaJogo);
                objItensPagto.setParMeiao(parMeiao);
                objItensPagto.setCamisa(camisa);
                objItensPagto.setCueca(cueca);
                objItensPagto.setSandalia(sandalia);
                // KIT DECIMAL
                objItensPagto.setSabonete(sabonete);
                objItensPagto.setPapelHigienico(papelHigienico);
                // KIT QUINZENAL
                objItensPagto.setCremeDental(cremeDental);
                objItensPagto.setBarbeador(barbeador);
                objItensPagto.setSabaoPo(sabaopo);
                // KIT SEMESTRAL
                objItensPagto.setLencol(lencol);
                objItensPagto.setCopo(copo);
                objItensPagto.setColher(colher);
                objItensPagto.setVasilha(vasilha);
                objItensPagto.setToalha(toalha);
                objItensPagto.setEscovaDente(escovaDente);
                // KIT MENSAL
                objItensPagto.setAbsorvente(absorvente);
                objItensPagto.setDesodorante(desodorante);
                // TIPOS DE KITS
                objItensPagto.setMostraTodos(marcaTodos);
                objItensPagto.setKitInicial(kitAnual);
                objItensPagto.setKitDecimal(kitDecimal);
                objItensPagto.setKitQuinzenal(kitQuinzenal);
                objItensPagto.setKitMensal(kitMensal);
                objItensPagto.setKitSemestral(kitSemetral);
                //
                objItensPagto.setTipoEntrada(tipoEntrada);
                objItensPagto.setDataEntrega(jDataEntrega.getDate());
                objItensPagto.setHoraEntrega(jHorarioPagto.getText());
                //
                objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                objItensPagto.setNomeInternoCrcKit(jNomeInterno.getText());
                objItensPagto.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                if (acao == 3) {
                    if (jIdInterno.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
                    } else {
                        objItensPagto.setUsuarioInsert(nameUser);
                        objItensPagto.setDataInsert(dataModFinal);
                        objItensPagto.setHorarioInsert(horaMov);
                        //
                        controle.incluirPagamentoKitInterno(objItensPagto);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarInterno();
                        preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 4) {
                    objItensPagto.setUsuarioUp(nameUser);
                    objItensPagto.setDataUp(dataModFinal);
                    objItensPagto.setHorarioUp(horaMov);
                    //
                    objItensPagto.setIdItem(idItem);
                    controle.alterarPagamentoKitInterno(objItensPagto);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarInterno();
                    preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosB2) && codGravarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            verificarInternos();
            tipoEntrada = 0;
            if (marcaTodos == 0 && kitAnual == 0 && kitQuinzenal == 0 && kitDecimal == 0 && kitMensal == 0 && kitSemetral == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe um tipo de kit para ser entregue ao interno.");
            } else if (jIdInterno.getText().equals("") || jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe para qual interno será o kit.");
            } else {
                // KIT ANUAL            
                if (jCheckBoxPrato.isSelected()) {
                    prato = 1;
                } else if (!jCheckBoxPrato.isSelected()) {
                    prato = 0;
                }
                if (jCheckBoxGarfo.isSelected()) {
                    garfo = 1;
                } else if (!jCheckBoxGarfo.isSelected()) {
                    garfo = 0;
                }
                if (jCheckBoxBermuda.isSelected()) {
                    bermuda = 1;
                } else if (!jCheckBoxBermuda.isSelected()) {
                    bermuda = 0;
                }
                if (jCheckBoxColchao.isSelected()) {
                    colchao = 1;
                } else if (!jCheckBoxColchao.isSelected()) {
                    colchao = 0;
                }
                if (jCheckBoxCamisa.isSelected()) {
                    camisa = 1;
                } else if (!jCheckBoxCamisa.isSelected()) {
                    camisa = 0;
                }
                if (jCheckBoxCueca.isSelected()) {
                    cueca = 1;
                } else if (!jCheckBoxCueca.isSelected()) {
                    cueca = 0;
                }
                if (jCheckBoxSandalia.isSelected()) {
                    sandalia = 1;
                } else if (!jCheckBoxSandalia.isSelected()) {
                    sandalia = 0;
                }
                if (jCheckBoxCobertor.isSelected()) {
                    cobertor = 1;
                } else if (!jCheckBoxCobertor.isSelected()) {
                    cobertor = 0;
                }
                if (jCheckBoxBolaFutsal.isSelected()) {
                    bola = 1;
                } else if (!jCheckBoxBolaFutsal.isSelected()) {
                    bola = 0;
                }
                if (jCheckBoxCalcaoJogo.isSelected()) {
                    calcaoJogo = 1;
                } else if (!jCheckBoxCalcaoJogo.isSelected()) {
                    calcaoJogo = 0;
                }
                if (jCheckBoxCamisaJogo.isSelected()) {
                    camisaJogo = 1;
                } else if (!jCheckBoxCamisaJogo.isSelected()) {
                    camisaJogo = 0;
                }
                if (jCheckBoxParMeiao.isSelected()) {
                    parMeiao = 1;
                } else if (!jCheckBoxParMeiao.isSelected()) {
                    parMeiao = 0;
                }
                // DECIMAL
                if (jCheckBoxPapel.isSelected()) {
                    papelHigienico = 1;
                } else if (!jCheckBoxPapel.isSelected()) {
                    papelHigienico = 0;
                }
                if (jCheckBoxSabonete.isSelected()) {
                    sabonete = 1;
                } else if (!jCheckBoxSabonete.isSelected()) {
                    sabonete = 0;
                }
                // KIT QUINZENAL
                if (jCheckBoxSabaoPo.isSelected()) {
                    sabaopo = 1;
                } else if (!jCheckBoxSabaoPo.isSelected()) {
                    sabaopo = 0;
                }
                if (jCheckBoxCreme.isSelected()) {
                    cremeDental = 1;
                } else if (!jCheckBoxCreme.isSelected()) {
                    cremeDental = 0;
                }
                if (jCheckBoxBarbeador.isSelected()) {
                    barbeador = 1;
                } else if (!jCheckBoxBarbeador.isSelected()) {
                    barbeador = 0;
                }
                // SEMESTRAL     
                if (jCheckBoxCopo.isSelected()) {
                    copo = 1;
                } else if (!jCheckBoxCopo.isSelected()) {
                    copo = 0;
                }
                if (jCheckBoxColher.isSelected()) {
                    colher = 1;
                } else if (!jCheckBoxColher.isSelected()) {
                    colher = 0;
                }
                if (jCheckBoxToalha.isSelected()) {
                    toalha = 1;
                }
                if (jCheckBoxLencol.isSelected()) {
                    lencol = 1;
                } else if (!jCheckBoxLencol.isSelected()) {
                    lencol = 0;
                }
                if (jCheckBoxVasilha.isSelected()) {
                    vasilha = 1;
                } else if (!jCheckBoxVasilha.isSelected()) {
                    vasilha = 0;
                }
                if (jCheckBoxEscova.isSelected()) {
                    escovaDente = 1;
                } else if (!jCheckBoxEscova.isSelected()) {
                    escovaDente = 0;
                }
                // MENSAL
                if (jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 1;
                }
                // MENSAL
                if (jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 1;
                } else if (!jCheckBoxAbsorvente.isSelected()) {
                    absorvente = 0;
                }
                if (jCheckBoxDesodorante.isSelected()) {
                    desodorante = 1;
                } else if (!jCheckBoxDesodorante.isSelected()) {
                    desodorante = 0;
                }
                // TIPOS DE PAGAMENTO KIT
                if (jCheckBoxMarcaTodos.isSelected()) {
                    marcaTodos = 1;
                } else if (!jCheckBoxMarcaTodos.isSelected()) {
                    marcaTodos = 0;
                }
                if (jCheckBoxKitAnual.isSelected()) {
                    kitAnual = 1;
                } else if (!jCheckBoxKitAnual.isSelected()) {
                    kitAnual = 0;
                }
                if (jCheckBoxKitQuinzenal.isSelected()) {
                    kitQuinzenal = 1;
                } else if (!jCheckBoxKitQuinzenal.isSelected()) {
                    kitQuinzenal = 0;
                }
                if (jCheckBoxDecimal.isSelected()) {
                    kitDecimal = 1;
                } else if (!jCheckBoxDecimal.isSelected()) {
                    kitDecimal = 0;
                }
                if (jCheckBoxSemestral.isSelected()) {
                    kitSemetral = 1;
                } else if (!jCheckBoxSemestral.isSelected()) {
                    kitSemetral = 0;
                }
                if (jCheckBoxMensal.isSelected()) {
                    kitMensal = 1;
                } else if (!jCheckBoxMensal.isSelected()) {
                    kitMensal = 0;
                }
                // KIT ANUAL            
                objItensPagto.setPrato(prato);
                objItensPagto.setGarfo(garfo);
                objItensPagto.setBermuda(bermuda);
                objItensPagto.setColchao(colchao);
                objItensPagto.setCobertor(cobertor);
                objItensPagto.setBolaJogo(bola);
                objItensPagto.setCalcaoJogo(calcaoJogo);
                objItensPagto.setCamisaJogo(camisaJogo);
                objItensPagto.setParMeiao(parMeiao);
                objItensPagto.setCamisa(camisa);
                objItensPagto.setCueca(cueca);
                objItensPagto.setSandalia(sandalia);
                // KIT DECIMAL
                objItensPagto.setSabonete(sabonete);
                objItensPagto.setPapelHigienico(papelHigienico);
                // KIT QUINZENAL
                objItensPagto.setCremeDental(cremeDental);
                objItensPagto.setBarbeador(barbeador);
                objItensPagto.setSabaoPo(sabaopo);
                // KIT SEMESTRAL
                objItensPagto.setLencol(lencol);
                objItensPagto.setCopo(copo);
                objItensPagto.setColher(colher);
                objItensPagto.setVasilha(vasilha);
                objItensPagto.setToalha(toalha);
                objItensPagto.setEscovaDente(escovaDente);
                // KIT MENSAL
                objItensPagto.setAbsorvente(absorvente);
                objItensPagto.setDesodorante(desodorante);
                // TIPOS DE KITS
                objItensPagto.setMostraTodos(marcaTodos);
                objItensPagto.setKitInicial(kitAnual);
                objItensPagto.setKitDecimal(kitDecimal);
                objItensPagto.setKitQuinzenal(kitQuinzenal);
                objItensPagto.setKitMensal(kitMensal);
                objItensPagto.setKitSemestral(kitSemetral);
                //
                objItensPagto.setTipoEntrada(tipoEntrada);
                objItensPagto.setDataEntrega(jDataEntrega.getDate());
                objItensPagto.setHoraEntrega(jHorarioPagto.getText());
                //
                objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                objItensPagto.setNomeInternoCrcKit(jNomeInterno.getText());
                objItensPagto.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                if (acao == 3) {
                    if (jIdInterno.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                        JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
                    } else {
                        objItensPagto.setUsuarioInsert(nameUser);
                        objItensPagto.setDataInsert(dataModFinal);
                        objItensPagto.setHorarioInsert(horaMov);
                        //
                        controle.incluirPagamentoKitInterno(objItensPagto);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarInterno();
                        preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 4) {
                    objItensPagto.setUsuarioUp(nameUser);
                    objItensPagto.setDataUp(dataModFinal);
                    objItensPagto.setHorarioUp(horaMov);
                    //
                    objItensPagto.setIdItem(idItem);
                    controle.alterarPagamentoKitInterno(objItensPagto);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarInterno();
                    preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso nao autorizado.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSairInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairInternoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairInternoActionPerformed

    private void jBtAuditoriaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItensActionPerformed
        // TODO add your handling code here:
        TelaAudItensPagamentoKit objAudiIten = new TelaAudItensPagamentoKit();
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objAudiIten);
            objAudiIten.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objAudiIten);
            objAudiIten.show();
        } else if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAudiIten);
            objAudiIten.show();
        }
    }//GEN-LAST:event_jBtAuditoriaItensActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoInternosBioTRI) && codAbrirTRI == 1) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else {
                mostrarTelaBiometria();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosBioB1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else {
                mostrarTelaBiometria();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosBioB2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else {
                mostrarTelaBiometria();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed

    private void jCheckBoxMarcaTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMarcaTodosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            marcaTodos = 1;
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(true);
            jCheckBoxGarfo.setSelected(true);
            jCheckBoxColchao.setSelected(true);
            jCheckBoxCamisa.setSelected(true);
            jCheckBoxBermuda.setSelected(true);
            jCheckBoxCueca.setSelected(true);
            jCheckBoxSandalia.setSelected(true);
            jCheckBoxCobertor.setSelected(true);
            jCheckBoxBolaFutsal.setSelected(true);
            jCheckBoxCalcaoJogo.setSelected(true);
            jCheckBoxCamisaJogo.setSelected(true);
            jCheckBoxParMeiao.setSelected(true);
            // DECIMAL
            jCheckBoxPapel.setSelected(true);
            jCheckBoxSabonete.setSelected(true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(true);
            jCheckBoxBarbeador.setSelected(true);
            jCheckBoxSabaoPo.setSelected(true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(true);
            jCheckBoxCopo.setSelected(true);
            jCheckBoxVasilha.setSelected(true);
            jCheckBoxColher.setSelected(true);
            jCheckBoxToalha.setSelected(true);
            jCheckBoxEscova.setSelected(true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(true);
            jCheckBoxDesodorante.setSelected(true);
        } else {
            marcaTodos = 0;
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        }
    }//GEN-LAST:event_jCheckBoxMarcaTodosItemStateChanged

    private void jCheckBoxKitAnualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxKitAnualItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            kitAnual = 1;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(true);
            jCheckBoxColchao.setSelected(true);
            jCheckBoxCamisa.setSelected(true);
            jCheckBoxBermuda.setSelected(true);
            jCheckBoxCueca.setSelected(true);
            jCheckBoxSandalia.setSelected(true);
            jCheckBoxCobertor.setSelected(true);
            jCheckBoxBolaFutsal.setSelected(true);
            jCheckBoxCalcaoJogo.setSelected(true);
            jCheckBoxCamisaJogo.setSelected(true);
            jCheckBoxParMeiao.setSelected(true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        } else {
            kitAnual = 0;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        }
    }//GEN-LAST:event_jCheckBoxKitAnualItemStateChanged

    private void jCheckBoxKitQuinzenalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxKitQuinzenalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            kitQuinzenal = 1;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT QUINZENAL
            jCheckBoxCreme.setSelected(true);
            jCheckBoxBarbeador.setSelected(true);
            jCheckBoxSabaoPo.setSelected(true);
            // KIT INICIAL
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
        } else {
            kitQuinzenal = 0;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        }
    }//GEN-LAST:event_jCheckBoxKitQuinzenalItemStateChanged

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO IMPRIMI
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioPagamentoKitInterno.jasper";
                conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PAVILHAO "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("pUnidade", descricaoUnidade);
                parametros.put("pCodigo", jIdLanc.getText());
                parametros.put("pUsuario", nameUser);
                // Sub Relatório
                try {
                    parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                } catch (SQLException ex) {
                }
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Pagamento de Kit de Interno.");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jCheckBoxMensalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMensalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            kitMensal = 1;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(true);
            jCheckBoxDesodorante.setSelected(true);
        } else {
            kitMensal = 0;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        }
    }//GEN-LAST:event_jCheckBoxMensalItemStateChanged

    private void jCheckBoxSemestralItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxSemestralItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            kitSemetral = 1;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxSemestral.setSelected(true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(true);
            jCheckBoxCopo.setSelected(true);
            jCheckBoxVasilha.setSelected(true);
            jCheckBoxColher.setSelected(true);
            jCheckBoxToalha.setSelected(true);
            jCheckBoxEscova.setSelected(true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        } else {
            kitSemetral = 0;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxDecimal.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        }
    }//GEN-LAST:event_jCheckBoxSemestralItemStateChanged

    private void jCheckBoxDecimalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxDecimalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            kitDecimal = 1;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            jCheckBoxDecimal.setSelected(true);
            //
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(true);
            jCheckBoxSabonete.setSelected(true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        } else {
            kitDecimal = 0;
            jCheckBoxMarcaTodos.setSelected(!true);
            jCheckBoxKitAnual.setSelected(!true);
            jCheckBoxKitQuinzenal.setSelected(!true);
            jCheckBoxSemestral.setSelected(!true);
            jCheckBoxMensal.setSelected(!true);
            // KIT ANUAL            
            jCheckBoxPrato.setSelected(!true);
            jCheckBoxGarfo.setSelected(!true);
            jCheckBoxColchao.setSelected(!true);
            jCheckBoxCamisa.setSelected(!true);
            jCheckBoxBermuda.setSelected(!true);
            jCheckBoxCueca.setSelected(!true);
            jCheckBoxSandalia.setSelected(!true);
            jCheckBoxCobertor.setSelected(!true);
            jCheckBoxBolaFutsal.setSelected(!true);
            jCheckBoxCalcaoJogo.setSelected(!true);
            jCheckBoxCamisaJogo.setSelected(!true);
            jCheckBoxParMeiao.setSelected(!true);
            // DECIMAL
            jCheckBoxPapel.setSelected(!true);
            jCheckBoxSabonete.setSelected(!true);
            // QUINZENAL
            jCheckBoxCreme.setSelected(!true);
            jCheckBoxBarbeador.setSelected(!true);
            jCheckBoxSabaoPo.setSelected(!true);
            //SEMESTRAL
            jCheckBoxLencol.setSelected(!true);
            jCheckBoxCopo.setSelected(!true);
            jCheckBoxVasilha.setSelected(!true);
            jCheckBoxColher.setSelected(!true);
            jCheckBoxToalha.setSelected(!true);
            jCheckBoxEscova.setSelected(!true);
            // MENSAL
            jCheckBoxAbsorvente.setSelected(!true);
            jCheckBoxDesodorante.setSelected(!true);
        }
    }//GEN-LAST:event_jCheckBoxDecimalItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaItens;
    private javax.swing.JButton jBtBiometria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesquisarInternoKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairInterno;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBox19;
    public static javax.swing.JCheckBox jCheckBoxAbsorvente;
    public static javax.swing.JCheckBox jCheckBoxBarbeador;
    public static javax.swing.JCheckBox jCheckBoxBermuda;
    public static javax.swing.JCheckBox jCheckBoxBolaFutsal;
    public static javax.swing.JCheckBox jCheckBoxCalcaoJogo;
    public static javax.swing.JCheckBox jCheckBoxCamisa;
    public static javax.swing.JCheckBox jCheckBoxCamisaJogo;
    public static javax.swing.JCheckBox jCheckBoxCobertor;
    public static javax.swing.JCheckBox jCheckBoxColchao;
    public static javax.swing.JCheckBox jCheckBoxColher;
    public static javax.swing.JCheckBox jCheckBoxCopo;
    public static javax.swing.JCheckBox jCheckBoxCreme;
    public static javax.swing.JCheckBox jCheckBoxCueca;
    public static javax.swing.JCheckBox jCheckBoxDecimal;
    public static javax.swing.JCheckBox jCheckBoxDesodorante;
    public static javax.swing.JCheckBox jCheckBoxEscova;
    public static javax.swing.JCheckBox jCheckBoxGarfo;
    public static javax.swing.JCheckBox jCheckBoxKitAnual;
    public static javax.swing.JCheckBox jCheckBoxKitQuinzenal;
    public static javax.swing.JCheckBox jCheckBoxLencol;
    public static javax.swing.JCheckBox jCheckBoxMarcaTodos;
    private javax.swing.JCheckBox jCheckBoxMensal;
    public static javax.swing.JCheckBox jCheckBoxPapel;
    public static javax.swing.JCheckBox jCheckBoxParMeiao;
    public static javax.swing.JCheckBox jCheckBoxPrato;
    public static javax.swing.JCheckBox jCheckBoxSabaoPo;
    public static javax.swing.JCheckBox jCheckBoxSabonete;
    public static javax.swing.JCheckBox jCheckBoxSandalia;
    private javax.swing.JCheckBox jCheckBoxSemestral;
    public static javax.swing.JCheckBox jCheckBoxToalha;
    public static javax.swing.JCheckBox jCheckBoxVasilha;
    public static javax.swing.JComboBox jComboBoxPavilhao;
    private javax.swing.JComboBox jComboBoxTipoKit;
    private com.toedter.calendar.JDateChooser jDataEntrega;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JLabel jFotoInternoKit;
    private javax.swing.JFormattedTextField jHorarioInicial;
    private javax.swing.JFormattedTextField jHorarioPagto;
    private javax.swing.JFormattedTextField jHorarioTermino;
    private javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdLanc;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInternoVisitado;
    private javax.swing.JTextField jResponsavel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaPagamentoKit;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jResponsavel.setBackground(Color.white);
        jHorarioInicial.setBackground(Color.white);
        jHorarioTermino.setBackground(Color.white);
        jComboBoxTipoKit.setBackground(Color.white);
        jComboBoxPavilhao.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jDataEntrega.setBackground(Color.white);
        jHorarioPagto.setBackground(Color.white);
    }

    public void limparCampos() {
        jIdInterno.setText("");
        jNomeInterno.setText("");
        //
        jCheckBoxMarcaTodos.setSelected(!true);
        jCheckBoxDecimal.setSelected(!true);
        jCheckBoxKitQuinzenal.setSelected(!true);
        jCheckBoxSemestral.setSelected(!true);
        jCheckBoxMensal.setSelected(!true);
        // KIT ANUAL            
        jCheckBoxPrato.setSelected(!true);
        jCheckBoxColchao.setSelected(!true);
        jCheckBoxCamisa.setSelected(!true);
        jCheckBoxBermuda.setSelected(!true);
        jCheckBoxCueca.setSelected(!true);
        jCheckBoxSandalia.setSelected(!true);
        jCheckBoxCobertor.setSelected(!true);
        jCheckBoxBolaFutsal.setSelected(!true);
        jCheckBoxCalcaoJogo.setSelected(!true);
        jCheckBoxCamisaJogo.setSelected(!true);
        jCheckBoxParMeiao.setSelected(!true);
        // DECIMAL
        jCheckBoxPapel.setSelected(!true);
        jCheckBoxSabonete.setSelected(!true);
        // QUINZENAL
        jCheckBoxCreme.setSelected(!true);
        jCheckBoxBarbeador.setSelected(!true);
        jCheckBoxSabaoPo.setSelected(!true);
        //SEMESTRAL
        jCheckBoxLencol.setSelected(!true);
        jCheckBoxCopo.setSelected(!true);
        jCheckBoxVasilha.setSelected(!true);
        jCheckBoxColher.setSelected(!true);
        jCheckBoxToalha.setSelected(!true);
        jCheckBoxEscova.setSelected(!true);
        // MENSAL
        jCheckBoxAbsorvente.setSelected(!true);
        jCheckBoxDesodorante.setSelected(!true);
        //       
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("");
    }

    public void limparCamposManutencao() {
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setDate(null);
        jResponsavel.setText("");
        jHorarioInicial.setText("");
        jHorarioTermino.setText("");
        jComboBoxTipoKit.setSelectedItem("Selecione...");
        jComboBoxPavilhao.setSelectedItem("Selecione...");
        jObservacao.setText("");
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        //
        jCheckBoxMarcaTodos.setSelected(!true);
        jCheckBoxDecimal.setSelected(!true);
        jCheckBoxKitQuinzenal.setSelected(!true);
        jCheckBoxSemestral.setSelected(!true);
        jCheckBoxMensal.setSelected(!true);
        // KIT ANUAL            
        jCheckBoxPrato.setSelected(!true);
        jCheckBoxColchao.setSelected(!true);
        jCheckBoxCamisa.setSelected(!true);
        jCheckBoxBermuda.setSelected(!true);
        jCheckBoxCueca.setSelected(!true);
        jCheckBoxSandalia.setSelected(!true);
        jCheckBoxCobertor.setSelected(!true);
        jCheckBoxBolaFutsal.setSelected(!true);
        jCheckBoxCalcaoJogo.setSelected(!true);
        jCheckBoxCamisaJogo.setSelected(!true);
        jCheckBoxParMeiao.setSelected(!true);
        // DECIMAL
        jCheckBoxPapel.setSelected(!true);
        jCheckBoxSabonete.setSelected(!true);
        // QUINZENAL
        jCheckBoxCreme.setSelected(!true);
        jCheckBoxBarbeador.setSelected(!true);
        jCheckBoxSabaoPo.setSelected(!true);
        //SEMESTRAL
        jCheckBoxLencol.setSelected(!true);
        jCheckBoxCopo.setSelected(!true);
        jCheckBoxVasilha.setSelected(!true);
        jCheckBoxColher.setSelected(!true);
        jCheckBoxToalha.setSelected(!true);
        jCheckBoxEscova.setSelected(!true);
        // MENSAL
        jCheckBoxAbsorvente.setSelected(!true);
        jCheckBoxDesodorante.setSelected(!true);
        //       
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("");
    }

    public void bloquearCampos() {
        jDataLanc.setEnabled(!true);
        jResponsavel.setEnabled(!true);
        jHorarioInicial.setEnabled(!true);
        jHorarioTermino.setEnabled(!true);
        jComboBoxTipoKit.setEnabled(!true);
        jComboBoxPavilhao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jCheckBoxMarcaTodos.setSelected(!true);
        jCheckBoxDecimal.setSelected(!true);
        jCheckBoxKitQuinzenal.setSelected(!true);
        jCheckBoxSemestral.setSelected(!true);
        jCheckBoxMensal.setSelected(!true);
        // KIT ANUAL            
        jCheckBoxPrato.setSelected(!true);
        jCheckBoxColchao.setSelected(!true);
        jCheckBoxCamisa.setSelected(!true);
        jCheckBoxBermuda.setSelected(!true);
        jCheckBoxCueca.setSelected(!true);
        jCheckBoxSandalia.setSelected(!true);
        jCheckBoxCobertor.setSelected(!true);
        jCheckBoxBolaFutsal.setSelected(!true);
        jCheckBoxCalcaoJogo.setEnabled(!true);
        jCheckBoxCamisaJogo.setEnabled(!true);
        jCheckBoxParMeiao.setEnabled(!true);
        // DECIMAL
        jCheckBoxPapel.setEnabled(!true);
        jCheckBoxSabonete.setEnabled(!true);
        // QUINZENAL
        jCheckBoxCreme.setEnabled(!true);
        jCheckBoxBarbeador.setEnabled(!true);
        jCheckBoxSabaoPo.setEnabled(!true);
        //SEMESTRAL
        jCheckBoxLencol.setEnabled(!true);
        jCheckBoxCopo.setEnabled(!true);
        jCheckBoxVasilha.setEnabled(!true);
        jCheckBoxColher.setEnabled(!true);
        jCheckBoxToalha.setEnabled(!true);
        jCheckBoxEscova.setEnabled(!true);
        // MENSAL
        jCheckBoxAbsorvente.setEnabled(!true);
        jCheckBoxDesodorante.setEnabled(!true);
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
    }

    public void bloquearBotoes() {
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtPesquisarInternoKit.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
    }

    public void Novo() {
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jResponsavel.setText(nameUser);
        jHorarioInicial.setText(jHoraSistema.getText());
        jHorarioTermino.setText("00:00");
        jComboBoxTipoKit.setSelectedItem("Selecione...");
        jComboBoxPavilhao.setSelectedItem("Selecione...");
        //
        jDataLanc.setEnabled(true);
        jHorarioInicial.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        jComboBoxTipoKit.setEnabled(true);
        jComboBoxPavilhao.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDataLanc.setEnabled(true);
        jResponsavel.setEnabled(true);
        jHorarioInicial.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        jComboBoxTipoKit.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearCampos();
        bloquearBotoes();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //       
        jBtNovoInterno.setEnabled(true);
        jBtBiometria.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            limparCamposManutencao();
            bloquearBotoes();
            bloquearCampos();
            jBtNovo.setEnabled(true);
        } else {
            bloquearBotoes();
            bloquearCampos();
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //       
            jBtNovoInterno.setEnabled(true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPag.setStatusLanc(statusLanc);
            objPag.setIdPagto(Integer.parseInt(jIdLanc.getText()));
            control.finalizarPagamentoKit(objPag);
            jStatusLanc.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //
            bloquearBotoes();
            bloquearCampos();
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
        }
    }

    public void NovoInterno() {
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jDataEntrega.setCalendar(Calendar.getInstance());
        jHorarioPagto.setText("00:00");
        //
        jCheckBoxMarcaTodos.setEnabled(true);
        jCheckBoxKitAnual.setEnabled(true);
        jCheckBoxDecimal.setEnabled(true);
        jCheckBoxKitQuinzenal.setEnabled(true);
        jCheckBoxSemestral.setEnabled(true);
        jCheckBoxMensal.setEnabled(true);
        // KIT ANUAL            
        jCheckBoxPrato.setEnabled(true);
        jCheckBoxGarfo.setEnabled(true);
        jCheckBoxColher.setEnabled(true);
        jCheckBoxColchao.setEnabled(true);
        jCheckBoxCamisa.setEnabled(true);
        jCheckBoxBermuda.setEnabled(true);
        jCheckBoxCueca.setEnabled(true);
        jCheckBoxSandalia.setEnabled(true);
        jCheckBoxCobertor.setEnabled(true);
        jCheckBoxBolaFutsal.setEnabled(true);
        jCheckBoxCalcaoJogo.setEnabled(true);
        jCheckBoxCamisaJogo.setEnabled(true);
        jCheckBoxParMeiao.setEnabled(true);
        // DECIMAL
        jCheckBoxPapel.setEnabled(true);
        jCheckBoxSabonete.setEnabled(true);
        // QUINZENAL
        jCheckBoxCreme.setEnabled(true);
        jCheckBoxBarbeador.setEnabled(true);
        jCheckBoxSabaoPo.setEnabled(true);
        //SEMESTRAL
        jCheckBoxLencol.setEnabled(true);
        jCheckBoxCopo.setEnabled(true);
        jCheckBoxVasilha.setEnabled(true);
        jCheckBoxColher.setEnabled(true);
        jCheckBoxToalha.setEnabled(true);
        jCheckBoxEscova.setEnabled(true);
        // MENSAL
        jCheckBoxAbsorvente.setEnabled(true);
        jCheckBoxDesodorante.setEnabled(true);
        //
        jDataEntrega.setEnabled(true);
        jHorarioPagto.setEnabled(true);
        //
        jBtPesquisarInternoKit.setEnabled(true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void AlterarInterno() {
        jCheckBoxMarcaTodos.setEnabled(true);
        jCheckBoxDecimal.setEnabled(true);
        jCheckBoxKitQuinzenal.setEnabled(true);
        jCheckBoxSemestral.setEnabled(true);
        jCheckBoxMensal.setEnabled(true);
        // KIT ANUAL            
        jCheckBoxPrato.setEnabled(true);
        jCheckBoxColchao.setEnabled(true);
        jCheckBoxCamisa.setEnabled(true);
        jCheckBoxBermuda.setEnabled(true);
        jCheckBoxCueca.setEnabled(true);
        jCheckBoxSandalia.setEnabled(true);
        jCheckBoxCobertor.setEnabled(true);
        jCheckBoxBolaFutsal.setEnabled(true);
        jCheckBoxCalcaoJogo.setEnabled(true);
        jCheckBoxCamisaJogo.setEnabled(true);
        jCheckBoxParMeiao.setEnabled(true);
        // DECIMAL
        jCheckBoxPapel.setEnabled(true);
        jCheckBoxSabonete.setEnabled(true);
        // QUINZENAL
        jCheckBoxCreme.setEnabled(true);
        jCheckBoxBarbeador.setEnabled(true);
        jCheckBoxSabaoPo.setEnabled(true);
        //SEMESTRAL
        jCheckBoxLencol.setEnabled(true);
        jCheckBoxCopo.setEnabled(true);
        jCheckBoxVasilha.setEnabled(true);
        jCheckBoxColher.setEnabled(true);
        jCheckBoxToalha.setEnabled(true);
        jCheckBoxEscova.setEnabled(true);
        // MENSAL
        jCheckBoxAbsorvente.setEnabled(true);
        jCheckBoxDesodorante.setEnabled(true);
        //
        jBtPesquisarInternoKit.setEnabled(true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void ExcluirInterno() {
        limparCampos();
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jCheckBoxMarcaTodos.setEnabled(!true);
        jCheckBoxDecimal.setEnabled(!true);
        jCheckBoxKitQuinzenal.setEnabled(!true);
        jCheckBoxSemestral.setEnabled(!true);
        jCheckBoxMensal.setEnabled(!true);
        // KIT ANUAL            
        jCheckBoxPrato.setEnabled(!true);
        jCheckBoxColchao.setEnabled(!true);
        jCheckBoxCamisa.setEnabled(!true);
        jCheckBoxBermuda.setEnabled(!true);
        jCheckBoxCueca.setEnabled(!true);
        jCheckBoxSandalia.setEnabled(!true);
        jCheckBoxCobertor.setEnabled(!true);
        jCheckBoxBolaFutsal.setEnabled(!true);
        jCheckBoxCalcaoJogo.setEnabled(!true);
        jCheckBoxCamisaJogo.setEnabled(!true);
        jCheckBoxParMeiao.setEnabled(!true);
        // DECIMAL
        jCheckBoxPapel.setEnabled(!true);
        jCheckBoxSabonete.setEnabled(!true);
        // QUINZENAL
        jCheckBoxCreme.setEnabled(!true);
        jCheckBoxBarbeador.setEnabled(!true);
        jCheckBoxSabaoPo.setEnabled(!true);
        //SEMESTRAL
        jCheckBoxLencol.setEnabled(!true);
        jCheckBoxCopo.setEnabled(!true);
        jCheckBoxVasilha.setEnabled(!true);
        jCheckBoxColher.setEnabled(!true);
        jCheckBoxToalha.setEnabled(!true);
        jCheckBoxEscova.setEnabled(!true);
        // MENSAL
        jCheckBoxAbsorvente.setEnabled(!true);
        jCheckBoxDesodorante.setEnabled(!true);
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaItens.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void SalvarInterno() {
        jCheckBoxCopo.setSelected(!true);
        jCheckBoxGarfo.setSelected(!true);
        jCheckBoxPrato.setSelected(!true);
        jCheckBoxColher.setSelected(!true);
        jCheckBoxVasilha.setSelected(!true);
        jCheckBoxGarfo.setSelected(!true);
        jCheckBoxAbsorvente.setSelected(!true);
        jCheckBoxBermuda.setSelected(!true);
        jCheckBoxLencol.setSelected(!true);
        jCheckBoxColchao.setSelected(!true);
        jCheckBoxToalha.setSelected(!true);
        jCheckBoxCamisa.setSelected(!true);
        jCheckBoxCueca.setSelected(!true);
        jCheckBoxSandalia.setSelected(!true);
        jCheckBoxCreme.setSelected(!true);
        jCheckBoxSabonete.setSelected(!true);
        jCheckBoxPapel.setSelected(!true);
        jCheckBoxBarbeador.setSelected(!true);
        jCheckBoxEscova.setSelected(!true);
        //
        jCheckBoxMarcaTodos.setEnabled(!true);
        jCheckBoxKitAnual.setEnabled(!true);
        jCheckBoxKitQuinzenal.setEnabled(!true);
        jCheckBoxDecimal.setEnabled(!true);
        jCheckBoxSemestral.setEnabled(!true);
        jCheckBoxMensal.setEnabled(!true);
        //
        jCheckBoxSabaoPo.setEnabled(!true);
        jCheckBoxDesodorante.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("00:00");
        //
        jCheckBoxMarcaTodos.setEnabled(!true);
        jCheckBoxDecimal.setEnabled(!true);
        jCheckBoxKitQuinzenal.setEnabled(!true);
        jCheckBoxSemestral.setEnabled(!true);
        jCheckBoxMensal.setEnabled(!true);
        // KIT ANUAL            
        jCheckBoxPrato.setEnabled(!true);
        jCheckBoxColchao.setEnabled(!true);
        jCheckBoxCamisa.setEnabled(!true);
        jCheckBoxBermuda.setEnabled(!true);
        jCheckBoxCueca.setEnabled(!true);
        jCheckBoxSandalia.setEnabled(!true);
        jCheckBoxCobertor.setEnabled(!true);
        jCheckBoxBolaFutsal.setEnabled(!true);
        jCheckBoxCalcaoJogo.setEnabled(!true);
        jCheckBoxCamisaJogo.setEnabled(!true);
        jCheckBoxParMeiao.setEnabled(!true);
        // DECIMAL
        jCheckBoxPapel.setEnabled(!true);
        jCheckBoxSabonete.setEnabled(!true);
        // QUINZENAL
        jCheckBoxCreme.setEnabled(!true);
        jCheckBoxBarbeador.setEnabled(!true);
        jCheckBoxSabaoPo.setEnabled(!true);
        //SEMESTRAL
        jCheckBoxLencol.setEnabled(!true);
        jCheckBoxCopo.setEnabled(!true);
        jCheckBoxVasilha.setEnabled(!true);
        jCheckBoxColher.setEnabled(!true);
        jCheckBoxToalha.setEnabled(!true);
        jCheckBoxEscova.setEnabled(!true);
        // MENSAL
        jCheckBoxAbsorvente.setEnabled(!true);
        jCheckBoxDesodorante.setEnabled(!true);
        //       
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarInterno() {
        jCheckBoxCopo.setSelected(!true);
        jCheckBoxPrato.setSelected(!true);
        jCheckBoxColher.setSelected(!true);
        jCheckBoxVasilha.setSelected(!true);
        jCheckBoxGarfo.setSelected(!true);
        jCheckBoxAbsorvente.setSelected(!true);
        jCheckBoxBermuda.setSelected(!true);
        jCheckBoxLencol.setSelected(!true);
        jCheckBoxColchao.setSelected(!true);
        jCheckBoxToalha.setSelected(!true);
        jCheckBoxCamisa.setSelected(!true);
        jCheckBoxCueca.setSelected(!true);
        jCheckBoxSandalia.setSelected(!true);
        jCheckBoxCreme.setSelected(!true);
        jCheckBoxSabonete.setSelected(!true);
        jCheckBoxPapel.setSelected(!true);
        jCheckBoxBarbeador.setSelected(!true);
        jCheckBoxEscova.setSelected(!true);
        //
        jCheckBoxCobertor.setSelected(!true);
        jCheckBoxBolaFutsal.setSelected(!true);
        jCheckBoxCalcaoJogo.setSelected(!true);
        jCheckBoxCamisaJogo.setSelected(!true);
        jCheckBoxParMeiao.setSelected(!true);
        //
        jCheckBoxMarcaTodos.setEnabled(!true);
        jCheckBoxKitAnual.setEnabled(!true);
        jCheckBoxKitQuinzenal.setEnabled(!true);
        jCheckBoxDecimal.setEnabled(!true);
        jCheckBoxSemestral.setEnabled(!true);
        jCheckBoxMensal.setEnabled(!true);
        //
        jCheckBoxSabaoPo.setEnabled(!true);
        jCheckBoxDesodorante.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("00:00");
        //
        jCheckBoxCobertor.setEnabled(!true);
        jCheckBoxBolaFutsal.setEnabled(!true);
        jCheckBoxCalcaoJogo.setEnabled(!true);
        jCheckBoxCamisaJogo.setEnabled(!true);
        jCheckBoxParMeiao.setEnabled(!true);
        //
        jCheckBoxCopo.setEnabled(!true);
        jCheckBoxPrato.setEnabled(!true);
        jCheckBoxColher.setEnabled(!true);
        jCheckBoxVasilha.setEnabled(!true);
        jCheckBoxGarfo.setEnabled(!true);
        jCheckBoxAbsorvente.setEnabled(!true);
        jCheckBoxBermuda.setEnabled(!true);
        jCheckBoxLencol.setEnabled(!true);
        jCheckBoxColchao.setEnabled(!true);
        jCheckBoxToalha.setEnabled(!true);
        jCheckBoxCamisa.setEnabled(!true);
        jCheckBoxCueca.setEnabled(!true);
        jCheckBoxSandalia.setEnabled(!true);
        jCheckBoxCreme.setEnabled(!true);
        jCheckBoxSabonete.setEnabled(!true);
        jCheckBoxPapel.setEnabled(!true);
        jCheckBoxBarbeador.setEnabled(!true);
        jCheckBoxEscova.setEnabled(!true);
        jCheckBoxMarcaTodos.setEnabled(!true);
        jCheckBoxKitAnual.setEnabled(!true);
        jCheckBoxKitQuinzenal.setEnabled(!true);
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        // ABA INTERNOS
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
        // ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void verificarInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdPagto"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codLanc = conecta.rs.getString("IdPagto");
            if (jIdLanc.getText().equals(codLanc)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o interno selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                control.excluirPagamentoKit(objPag);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherComboBoxPavilhao() {
        jComboBoxPavilhao.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhao.addItem(conecta.rs.getString("DescricaoPav"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTabelaPagotKit(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataLanc");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdPagto"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPagamentoKit.setModel(modelo);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPagamentoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaPagamentoKit.setAutoResizeMode(jTabelaPagamentoKit.AUTO_RESIZE_OFF);
        jTabelaPagamentoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPagamentoKit.setModel(modelo);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPagamentoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaPagamentoKit.setAutoResizeMode(jTabelaPagamentoKit.AUTO_RESIZE_OFF);
        jTabelaPagamentoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaPagotKitInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataLanc");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdPagto"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPagamentoKit.setModel(modelo);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPagamentoKit.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPagamentoKit.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPagamentoKit.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaPagamentoKit.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPagamentoKit.getTableHeader().setReorderingAllowed(false);
        jTabelaPagamentoKit.setAutoResizeMode(jTabelaPagamentoKit.AUTO_RESIZE_OFF);
        jTabelaPagamentoKit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void preencherTabelaItensInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Descrição do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("IdItem"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
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
        String[] Colunas = new String[]{"Item", "Código", "Descrição do Interno"};
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

    public void buscarAcessoUsuario(String pTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroupTRI = conecta.rs.getInt("IdUsuario");
            codigoGrupoTRI = conecta.rs.getInt("IdGrupo");
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + pTela + "'");
            conecta.rs.first();
            codUserAcesso = conecta.rs.getInt("IdUsuario");
            codAbrirTRI = conecta.rs.getInt("Abrir");
            codIncluirTRI = conecta.rs.getInt("Incluir");
            codAlterarTRI = conecta.rs.getInt("Alterar");
            codExcluirTRI = conecta.rs.getInt("Excluir");
            codGravarTRI = conecta.rs.getInt("Gravar");
            codConcultarTRI = conecta.rs.getInt("Consultar");
            nomeTelaTRI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario1(String pTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroupB1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + pTela + "'");
            conecta.rs.first();
            codUserAcessoB1 = conecta.rs.getInt("IdUsuario");
            codAbrirB1 = conecta.rs.getInt("Abrir");
            codIncluirB1 = conecta.rs.getInt("Incluir");
            codAlterarB1 = conecta.rs.getInt("Alterar");
            codExcluirB1 = conecta.rs.getInt("Excluir");
            codGravarB1 = conecta.rs.getInt("Gravar");
            codConsultarB1 = conecta.rs.getInt("Consultar");
            nomeTelaB1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario2(String pTela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroupB2 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB2 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB2 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + pTela + "'");
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
}
