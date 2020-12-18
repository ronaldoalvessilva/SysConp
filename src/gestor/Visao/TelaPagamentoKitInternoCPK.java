/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePagamentoKit;
import gestor.Controle.PagamentoKit;
import gestor.Controle.PagamentoKitInternos;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.ItensPagamentoKitInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PagamentoKitInterno;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloBaseDois.codAlterarB2;
import static gestor.Visao.TelaModuloBaseDois.codExcluirB2;
import static gestor.Visao.TelaModuloBaseDois.codGravarB2;
import static gestor.Visao.TelaModuloBaseDois.codIncluirB2;
import static gestor.Visao.TelaModuloBaseDois.codUserAcessoB2;
import static gestor.Visao.TelaModuloBaseDois.codigoUserB2;
import static gestor.Visao.TelaModuloBaseDois.nomeGrupoB2;
import static gestor.Visao.TelaModuloBaseDois.nomeTelaB2;
import static gestor.Visao.TelaModuloBaseDois.telaEntregaMaterialUsoB2;
import static gestor.Visao.TelaModuloBaseDois.telaEntregaMaterialUsoInternosBioB2;
import static gestor.Visao.TelaModuloBaseUm.codAlterarB1;
import static gestor.Visao.TelaModuloBaseUm.codExcluirB1;
import static gestor.Visao.TelaModuloBaseUm.codGravarB1;
import static gestor.Visao.TelaModuloBaseUm.codIncluirB1;
import static gestor.Visao.TelaModuloBaseUm.codUserAcessoB1;
import static gestor.Visao.TelaModuloBaseUm.codigoUserB1;
import static gestor.Visao.TelaModuloBaseUm.nomeGrupoB1;
import static gestor.Visao.TelaModuloBaseUm.nomeTelaB1;
import static gestor.Visao.TelaModuloBaseUm.telaEntregaMaterialUsoB1;
import static gestor.Visao.TelaModuloBaseUm.telaEntregaMaterialUsoInternosBioB1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloBaseUm.codigoUserGroupB1;
import static gestor.Visao.TelaModuloBaseUm.codigoGrupoB1;
import static gestor.Visao.TelaModuloBaseUm.codAbrirB1;
import static gestor.Visao.TelaModuloBaseUm.codConsultarB1;
import static gestor.Visao.TelaModuloTriagem.codAbrirTRI;
import static gestor.Visao.TelaModuloTriagem.codAlterarTRI;
import static gestor.Visao.TelaModuloTriagem.codExcluirTRI;
import static gestor.Visao.TelaModuloTriagem.codGravarTRI;
import static gestor.Visao.TelaModuloTriagem.codIncluirTRI;
import static gestor.Visao.TelaModuloTriagem.codUserAcessoTRI;
import static gestor.Visao.TelaModuloTriagem.codigoUserTRI;
import static gestor.Visao.TelaModuloTriagem.nomeGrupoTRI;
import static gestor.Visao.TelaModuloTriagem.nomeTelaTRI;
import static gestor.Visao.TelaModuloTriagem.telaEntregaMaterialUsoInternosBioTRI;
import static gestor.Visao.TelaModuloTriagem.telaEntregaMaterialUsoTRI;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TelaPagamentoKitInternoCPK extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PagamentoKitInterno objPag = new PagamentoKitInterno();
    PagamentoKit control = new PagamentoKit();
    //   
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    PagamentoKitInternos controle = new PagamentoKitInternos();
    //
    ControlePagamentoKit controlPagoKit = new ControlePagamentoKit();
    ComposicaoKit objComp = new ComposicaoKit();
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
    public static int codItem;
    String pRespostaKit = "Sim";
    /**
     * Creates new form TelaPagamentoKitInterno
     */
    public static TelaBiometriaKitInternoCPK telaBiometriaKit;

    public TelaPagamentoKitInternoCPK() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarTelaBiometria() {
        telaBiometriaKit = new TelaBiometriaKitInternoCPK(this, true);
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
        jLabel9 = new javax.swing.JLabel();
        jIdKit = new javax.swing.JTextField();
        jBtPesquisarKit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jIdRegistroComp = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxKitPersonalizado = new javax.swing.JComboBox<>();
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
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSairInterno = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaProdutosKitInterno = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jFotoInternoKit = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jBtBiometria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jDataEntrega = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jHorarioPagto = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jBtAuditoria = new javax.swing.JButton();
        jBtAuditoriaItens = new javax.swing.JButton();

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
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_32.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

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
                .addContainerGap(41, Short.MAX_VALUE))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
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
        jComboBoxTipoKit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Kit Inicial", "Kit Decendial", "Kit Quinzenal", "Kit Mensal", "Kit Semestral", "Kit Anual" }));
        jComboBoxTipoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoKit.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("ID Kit");

        jIdKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdKit.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jIdKit.setEnabled(false);

        jBtPesquisarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarKit.setToolTipText("Pesquisar Kit de Higiêne");
        jBtPesquisarKit.setContentAreaFilled(false);
        jBtPesquisarKit.setEnabled(false);
        jBtPesquisarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarKitActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setText("ID Registro");

        jIdRegistroComp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdRegistroComp.setForeground(new java.awt.Color(0, 0, 204));
        jIdRegistroComp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistroComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistroComp.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        jIdRegistroComp.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Kit Personalizado");

        jComboBoxKitPersonalizado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxKitPersonalizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Sim", "Não" }));
        jComboBoxKitPersonalizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxKitPersonalizado.setEnabled(false);
        jComboBoxKitPersonalizado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxKitPersonalizadoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jResponsavel)
                            .addComponent(jComboBoxPavilhao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(132, 132, 132))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jComboBoxTipoKit, 0, 284, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesquisarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxKitPersonalizado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel20)))))
                        .addContainerGap())
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
                            .addComponent(jIdKit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHorarioInicial, jHorarioTermino, jIdKit, jIdRegistroComp});

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarKit)
                    .addComponent(jComboBoxKitPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel10)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                    .addComponent(jNomeInterno))
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
                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jBtNovoInterno.setEnabled(false);
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

        jTabelaProdutosKitInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKitInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Un.", "Quant."
            }
        ));
        jScrollPane4.setViewportView(jTabelaProdutosKitInterno);
        if (jTabelaProdutosKitInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setMinWidth(340);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setMaxWidth(340);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setMinWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtBiometria.setForeground(new java.awt.Color(204, 0, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setText("Pagamento");
        jBtBiometria.setToolTipText("Pesquisar Interno para Pagamento de Kit");
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtBiometria)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jDataEntrega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Entrega");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Horário");

        jHorarioPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtFinalizar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jHorarioPagto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDataEntrega, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtImpressao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAuditoria, jBtAuditoriaItens});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoria)
                    .addComponent(jBtAuditoriaItens))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAuditoria, jBtAuditoriaItens});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        setBounds(300, 60, 648, 488);
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
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%'");
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
                conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
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
                jIdKit.setText(conecta.rs.getString("IdKit"));
                jIdRegistroComp.setText(conecta.rs.getString("IdRegistro"));
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
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
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
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
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
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
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
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else if (jIdKit.getText().equals("") && !jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código da composição do kit de higiêne do interno.");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar se o kit é ou não personalizado.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                objPag.setIdKit(Integer.valueOf(jIdKit.getText()));
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setKitPersonalizado((String) jComboBoxKitPersonalizado.getSelectedItem());
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
            } else if (jIdKit.getText().equals("") && !jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código da composição do kit de higiêne do interno.");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar se o kit é ou não personalizado.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setKitPersonalizado((String) jComboBoxKitPersonalizado.getSelectedItem());
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
            } else if (jIdKit.getText().equals("") && !jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código da composição do kit de higiêne do interno.");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar se o kit é ou não personalizado.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setKitPersonalizado((String) jComboBoxKitPersonalizado.getSelectedItem());
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
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        TelaAuditoriaPagamentoKitCPK objAudiKit = new TelaAuditoriaPagamentoKitCPK();
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objAudiKit);
            objAudiKit.show();
        } else if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAudiKit);
            objAudiKit.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objAudiKit);
            objAudiKit.show();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItemPagto = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //         
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaItens.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdItem='" + idItemPagto + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItem");
                codItem = conecta.rs.getInt("IdItem");
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoKit.setIcon(i);
                jFotoInternoKit.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_DEFAULT)));
                //
                jDataEntrega.setDate(conecta.rs.getDate("DataEntrega"));
                jHorarioPagto.setText(conecta.rs.getString("Horario"));

            } catch (SQLException ex) {
            }
            preencherTabelaProdutosKitInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdPagto='" + jIdLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInterno.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        verificarInternos();
        tipoEntrada = 0;
        if (marcaTodos == 0 && kitAnual == 0 && kitQuinzenal == 0 && kitDecimal == 0 && kitSemetral == 0 && kitMensal == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe um tipo de kit para ser entregue ao interno.");
        } else if (jIdInterno.getText().equals("") || jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe para qual interno será o kit.");
        } else {

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
                    buscarCodigoItem();
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
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        limparCampos();
        bloquearCampos();
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSairInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairInternoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairInternoActionPerformed

    private void jBtAuditoriaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItensActionPerformed
        // TODO add your handling code here:        
        TelaAudItensPagamentoKitCPK objAudiIten = new TelaAudItensPagamentoKitCPK();
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objAudiIten);
            objAudiIten.show();
        } else if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objAudiIten);
            objAudiIten.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objAudiIten);
            objAudiIten.show();
        }
    }//GEN-LAST:event_jBtAuditoriaItensActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoInternosBioTRI) && codAbrirTRI == 1) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else if (!jIdLanc.getText().equals("")) {
                mostrarTelaBiometria();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosBioB1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else if (!jIdLanc.getText().equals("")) {
                mostrarTelaBiometria();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosBioB2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else if (!jIdLanc.getText().equals("")) {
                mostrarTelaBiometria();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO IMPRIMI
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir esse registro, pois não existe(m) produto(s) lançado(s).");
        } else if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para imprimir o relatório.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/GerenciaOperacional/PagamentoKitInterno/RelatorioPagamentoKitInterno.jasper";
                conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PAVILHAO "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PAGAMENTO_KIT_INTERNOS.IdPagto='" + jIdLanc.getText() + "' "
                        + "AND ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc='" + jIdInterno.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("pUnidade", descricaoUnidade);
                parametros.put("pCodigo", jIdLanc.getText());
                parametros.put("pCodigoInternoCrc", jIdInterno.getText());
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

    private void jBtPesquisarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarKitActionPerformed
        // TODO add your handling code here:
        TelaPesquisaKitCpk objPesqKit = new TelaPesquisaKitCpk();
        if (TelaModuloBaseUm.jPainelBaseSegurancaPavilhao != null) {
            TelaModuloBaseUm.jPainelBaseSegurancaPavilhao.add(objPesqKit);
            objPesqKit.show();
        } else if (TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar != null) {
            TelaModuloBaseDois.jPainelBasePavilhaoAuxiliar.add(objPesqKit);
            objPesqKit.show();
        } else if (TelaModuloTriagem.jPainelTriagem != null) {
            TelaModuloTriagem.jPainelTriagem.add(objPesqKit);
            objPesqKit.show();
        }
    }//GEN-LAST:event_jBtPesquisarKitActionPerformed

    private void jComboBoxKitPersonalizadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxKitPersonalizadoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                jComboBoxTipoKit.setSelectedItem("Selecione...");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Sim")) {
                jComboBoxTipoKit.setSelectedItem("Kit Personalizado");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Não")) {
                jComboBoxTipoKit.setSelectedItem("Selecione...");
            }
        }
    }//GEN-LAST:event_jComboBoxKitPersonalizadoItemStateChanged


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
    private javax.swing.JButton jBtPesquisarKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairInterno;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JComboBox<String> jComboBoxKitPersonalizado;
    public static javax.swing.JComboBox jComboBoxPavilhao;
    public static javax.swing.JComboBox jComboBoxTipoKit;
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
    public static javax.swing.JTextField jIdKit;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdRegistroComp;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaPagamentoKit;
    public static javax.swing.JTable jTabelaProdutosKitInterno;
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
        jIdKit.setBackground(Color.white);
        jIdRegistroComp.setBackground(Color.white);
        jComboBoxTipoKit.setBackground(Color.white);
        jComboBoxPavilhao.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jDataEntrega.setBackground(Color.white);
        jHorarioPagto.setBackground(Color.white);
    }

    public void pesquisarTelaAcesso() {
        jComboBoxTipoKit.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM KITS_HIGIENE_INTERNO");
            conecta.rs.first();
            do {
                jComboBoxTipoKit.addItem(conecta.rs.getString("NomeTela"));
            } while (conecta.rs.next());
            jComboBoxTipoKit.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void limparCampos() {
        jIdInterno.setText("");
        jNomeInterno.setText("");
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
        jIdKit.setText("");
        jIdRegistroComp.setText("");
        jComboBoxTipoKit.setSelectedItem("Selecione...");
        jComboBoxPavilhao.setSelectedItem("Selecione...");
        jObservacao.setText("");
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
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
        jBtPesquisarKit.setEnabled(!true);
        //               
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
        // jComboBoxTipoKit.setEnabled(true);
        jComboBoxPavilhao.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesquisarKit.setEnabled(true);
        //        
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jDataLanc.setEnabled(true);
        jResponsavel.setEnabled(true);
        jHorarioInicial.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        //  jComboBoxTipoKit.setEnabled(true);
        jObservacao.setEnabled(true);
        //        
        jBtPesquisarKit.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        bloquearCampos();
        bloquearBotoes();
        limparCampos();
        limparCamposManutencao();
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
            jBtBiometria.setEnabled(true);
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
            //INFORMAR QUE O KIT FOI PAGO.
            objComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.sql.Date data = new java.sql.Date(format.parse(jDataSistema.getText()).getTime());
                objComp.setDataPagamentoKit(data);
            } catch (ParseException ex) {
                Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
            objComp.setKitPago(pRespostaKit);
            controlPagoKit.confirmarPagamentoKit(objComp);
            //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
            objComp.setIdKit(Integer.valueOf(jIdKit.getText()));
            objComp.setKitPago("Sim");
            controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
            //
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
        jHorarioPagto.setText(jHoraSistema.getText());
        //
        jDataEntrega.setEnabled(true);
        jHorarioPagto.setEnabled(true);
        //        
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void AlterarInterno() {
        //       
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
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("00:00");
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
        jBtBiometria.setEnabled(true);
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
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("00:00");
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        // ABA INTERNOS
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
        jBtBiometria.setEnabled(true);
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

    public void buscarCodigoItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS ");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
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

    public void preencherTabelaProdutosKitInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Descrição do Produto", "Un.", "Quant."};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("IdProd"), conecta.rs.getString("DescricaoProd"), conecta.rs.getString("UnidadeProd"), conecta.rs.getString("QuantProd")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaProdutosKitInterno.setModel(modelo);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setPreferredWidth(340);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProdutosKitInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaProdutosKitInterno.setAutoResizeMode(jTabelaProdutosKitInterno.AUTO_RESIZE_OFF);
        jTabelaProdutosKitInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaKitInternos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaKitInternos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setCellRenderer(direita);
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

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserB1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserB1 + "'");
            conecta.rs.first();
            codigoUserGroupB1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserB1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
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
}
