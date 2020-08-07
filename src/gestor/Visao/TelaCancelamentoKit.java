/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.ModeloTabela;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import gestor.Controle.CancelamentoPagamentoKitInternos;
import gestor.Controle.ControleItensProdutosCancelamentoKitInterno;
import gestor.Controle.ControleItensProdutosPagamentoKitInterno;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePesquisaKitInternoManualCancelamento;
import gestor.Controle.ControleProdutosKitLote;
import gestor.Controle.PagamentoKitInternos;
import gestor.Controle.PesquisarInternosProdutosCanceladosKits;
import gestor.Controle.PesquisarKitInternosProdutosCanceladosKits;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import gestor.Modelo.ItensPagamentoKitInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProdutoInternosKitLote;
import gestor.Modelo.ProdutosPagtoKitInterno;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxPavilhao;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxTiposKits;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jDataEntrega;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jHorarioPagto;
import static gestor.Visao.TelaCancelamentoPagamentoKits.codItem;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdKit;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistro;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jTabelaInternos;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jTabelaProdutosKitInterno;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;

/**
 *
 * @author ronaldo
 */
public class TelaCancelamentoKit extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    CancelamentoPagamentoKitInternos controle = new CancelamentoPagamentoKitInternos();
    ControleProdutosKitLote control = new ControleProdutosKitLote();
    //
    ProdutosPagtoKitInterno objItensPagtoProd = new ProdutosPagtoKitInterno();
    ControleItensProdutosCancelamentoKitInterno controleProd = new ControleItensProdutosCancelamentoKitInterno();
    ControlePesquisaKitInternoManualCancelamento controleMan = new ControlePesquisaKitInternoManualCancelamento();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    //
    PesquisarInternosProdutosCanceladosKits listaInternos = new PesquisarInternosProdutosCanceladosKits();
    PesquisarKitInternosProdutosCanceladosKits pPESQUISAR_kits = new PesquisarKitInternosProdutosCanceladosKits();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Base Pavilhão:Pagamento de Kit de Internos:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    public static String caminhoFotoInterno;
    // VARIVAEL PARA ARMAZENAR AS DIGITAIS DO BANCO DE DADOS
    String caminhoBiometria = "";
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturada = null;
    int tipoEntrada = 1; // MANUAL É (0) - BIOMETRIA (1)
    String codigoInterno;
    String codigoKit;
    // VARIÁVEIS PARA OS KITS INICIAL E 15 DIAS
    int copo, prato, colher, vasilha, garfo, absorvente, bermuda, lencol, colchao, toalha, camisa, cueca, sandalia, desodorante = 0;
    int cobertor, bola, calcaoJogo, camisaJogo, parMeiao = 0;
    int cremeDental, sabonete, papelHigienico, barbeador, escovaDente, sabaopo = 0;
    int marcaTodos = 0;
    int kitAnual = 0;
    int kitDecimal = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitSemetral = 0;
    int kitPersonalizado = 0;
    //
    float estoque = 0;
    String codigoInternoKit;
    String kitPago = "Sim";
    int pCodigoInterno = 0;
    int pCodigoProd = 0;
    int pQuantidade = 0;
    int pSaldo = 0;
    String statusFinal = "FINALIZADO";
    String pKitPago = "Não"; // PARA PESQUISAR SOMENTE OS INTERNOS QUE AINDA NÃO FORAM PAGO OS KITS.
    int pRegistroComp = 0;
    //
    int pZERO = 0;
    String utilizado = "Sim";

    /**
     * Creates new form TelaBiometriaKitInterno
     */
    public static TelaCancelamentoPagamentoKits pCANCELAR_kit;

    public TelaCancelamentoKit(TelaCancelamentoPagamentoKits parent, boolean modal) {
        this.pCANCELAR_kit = parent;
        this.setModal(modal);
        setLocationRelativeTo(pCANCELAR_kit);
        initComponents();
        corCampos();
        if (jComboBoxTiposKits.getSelectedItem().equals("Kit Inicial")) {
            pesquisarInternoPagamentoKitInicial();
        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Decendial")) {
            pesquisarInternoPagamentoKitDecendial();
        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Quinzenal")) {
            pesquisarInternoPagamentoKitQuinzenal();
        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Mensal")) {
            pesquisarInternoPagamentoKitMensal();
        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Semestral")) {
            pesquisarInternoPagamentoKitSemestral();
        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Anual")) {
            pesquisarInternoPagamentoKitAnual();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaProdutosKit = new javax.swing.JTable();
        jBtVerificarKit = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxOperacao = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jIdInternoKitBio1 = new javax.swing.JTextField();
        jNomeInternoKitBio1 = new javax.swing.JTextField();
        jPavilhaoKitBio1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jMatriculaPenalKitBio1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jRegimeKitBio1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jCelaKitBio1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jHorarioPagto1 = new javax.swing.JFormattedTextField();
        jDataEntrega1 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jFotoInternoKitBio1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxPesquisarInterno = new javax.swing.JComboBox<>();
        jBtConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Registro de Kit de Internos {Biometria} :::...");

        jProgressBar1.setStringPainted(true);

        jTabelaProdutosKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Un.", "Quant.", "Estoque"
            }
        ));
        jScrollPane2.setViewportView(jTabelaProdutosKit);
        if (jTabelaProdutosKit.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(1).setMinWidth(390);
            jTabelaProdutosKit.getColumnModel().getColumn(1).setMaxWidth(390);
            jTabelaProdutosKit.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaProdutosKit.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaProdutosKit.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(4).setMinWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jBtVerificarKit.setForeground(new java.awt.Color(0, 102, 0));
        jBtVerificarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtVerificarKit.setText("Verificar Kit");
        jBtVerificarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVerificarKitActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/filesave.png"))); // NOI18N
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("Operação de Pesquisa:");

        jComboBoxOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Pesquisa Manual" }));
        jComboBoxOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome Completo do Interno");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Pavilhão");

        jIdInternoKitBio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoKitBio1.setEnabled(false);

        jNomeInternoKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoKitBio1.setEnabled(false);

        jPavilhaoKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoKitBio1.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Matricula Penal");

        jMatriculaPenalKitBio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenalKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalKitBio1.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Regime");

        jRegimeKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeKitBio1.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Cela");

        jCelaKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaKitBio1.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Entrega");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Horário");

        jHorarioPagto1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto1.setEnabled(false);

        jDataEntrega1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega1.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCelaKitBio1)
                    .addComponent(jNomeInternoKitBio1)
                    .addComponent(jPavilhaoKitBio1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jDataEntrega1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jHorarioPagto1)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jIdInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMatriculaPenalKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jRegimeKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegimeKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenalKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPavilhaoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCelaKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDataEntrega1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioPagto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoInternoKitBio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKitBio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKitBio1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Pesquisar Interno:");

        jComboBoxPesquisarInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPesquisarInterno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPesquisarInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setContentAreaFilled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jBtVerificarKit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxOperacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 3, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtVerificarKit)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        setSize(new java.awt.Dimension(555, 544));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        verificarInternoManual();
        Integer rows = jTabelaProdutosKit.getRowCount();
        if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual") && jIdInternoKitBio1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do interno.");
        } else if (jDataEntrega1.getDate() == null && jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            JOptionPane.showMessageDialog(null, "Informe a data de entrega do kit.");
        } else if (jHorarioPagto1.getText().equals("")
                && jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")
                || jHorarioPagto1.getText().equals("00:00")
                && jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            JOptionPane.showMessageDialog(null, "Informe o horário de entrega do kit.");
        } else if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "É necessário verificar os itens do kit para o interno.");
        } else {
            objItensPagto.setTipoEntrada(tipoEntrada);
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
            objItensPagto.setNomeInternoCrcKit(jNomeInternoKitBio1.getText());
            objItensPagto.setIdPagto(Integer.valueOf(jIdRegistro.getText()));
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            objItensPagto.setAssinaturaDigital(pDigitalCapturada);
            //
            objItensPagto.setUsuarioInsert(nameUser);
            objItensPagto.setDataInsert(dataModFinal);
            objItensPagto.setHorarioInsert(horaMov);
            if (jIdInternoKitBio1.getText().equals(codigoInterno) && jIdRegistro.getText().equals(codigoKit)) {
                JOptionPane.showMessageDialog(rootPane, "Esse rregistro de interno já foi cancelado.");
            } else {
                controle.incluirPagamentoKitInterno(objItensPagto);
                //          
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                //
                buscarCodigoItem();
                preencherTabelaItensInterno();
                Salvar();
                bloquearCampos();
                gravarDadosBanco();
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtVerificarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVerificarKitActionPerformed
        // TODO add your handling code here:
        if (jComboBoxOperacao.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de pesquisa dos produtos.");
        } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            limparTabelaProdutosKit();
            PESQUISAR_PRODUTOS_KIT_Kit_InternoManual();
        }
    }//GEN-LAST:event_jBtVerificarKitActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxPesquisarInterno.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para pesquisar os produtos.");
        } else {
            Novo();
            abrirCampos();
            //PESQUISAR OS DADOS DO INTERNO SELECIONADO
            pPESQUISAR_kits.PESQUISAR_INTERNO_KIT_selecionado(objCancelaKit);
            jIdInternoKitBio1.setText(String.valueOf(objCancelaKit.getIdInternoKit()));
            jNomeInternoKitBio1.setText(objCancelaKit.getNomeInternoKit());
            jRegimeKitBio1.setText(objCancelaKit.getRegimeInterno());
            jPavilhaoKitBio1.setText(objCancelaKit.getDescricaoPav());
            jCelaKitBio1.setText(objCancelaKit.getDescricaoCela());//          
            jDataEntrega1.setDate(objCancelaKit.getDataEntrega());
            jHorarioPagto1.setText(objCancelaKit.getHorario());
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCancelamentoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCancelamentoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCancelamentoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCancelamentoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCancelamentoKit dialog = new TelaCancelamentoKit(pCANCELAR_kit, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVerificarKit;
    public static javax.swing.JTextField jCelaKitBio1;
    private javax.swing.JComboBox<String> jComboBoxOperacao;
    public static javax.swing.JComboBox<String> jComboBoxPesquisarInterno;
    public static com.toedter.calendar.JDateChooser jDataEntrega1;
    public static javax.swing.JLabel jFotoInternoKitBio1;
    public static javax.swing.JFormattedTextField jHorarioPagto1;
    public static javax.swing.JTextField jIdInternoKitBio1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaPenalKitBio1;
    public static javax.swing.JTextField jNomeInternoKitBio1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JTextField jPavilhaoKitBio1;
    private javax.swing.JProgressBar jProgressBar1;
    public static javax.swing.JTextField jRegimeKitBio1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTabelaProdutosKit;
    // End of variables declaration//GEN-END:variables

    //---------------------------------------------------------------------
    public void corCampos() {
        jDataEntrega.setBackground(Color.white);
        jHorarioPagto.setBackground(Color.white);
        //
        jIdInternoKitBio1.setBackground(Color.white);
        jMatriculaPenalKitBio1.setBackground(Color.white);
        jNomeInternoKitBio1.setBackground(Color.white);
        jRegimeKitBio1.setBackground(Color.white);
        jPavilhaoKitBio1.setBackground(Color.white);
        jCelaKitBio1.setBackground(Color.white);
        //
        jDataEntrega1.setBackground(Color.white);
        jHorarioPagto1.setBackground(Color.white);
    }

    public void Novo() {
        jDataEntrega.setCalendar(Calendar.getInstance());
        jHorarioPagto.setText(jHoraSistema.getText());
        jIdInternoKitBio1.setText("");
        jNomeInternoKitBio1.setText("");
        jRegimeKitBio1.setText("");
        jPavilhaoKitBio1.setText("");
        jCelaKitBio1.setText("");
        //
        jDataEntrega1.setCalendar(Calendar.getInstance());
        jHorarioPagto1.setText(jHoraSistema.getText());
        //
        jDataEntrega1.setEnabled(true);
        jHorarioPagto1.setEnabled(true);
        //APAGAR REGISTRO DA TABELA
        Integer rows = jTabelaProdutosKit.getRowCount();
        if (rows != 0) {
            // APAGAR DADOS DA TABELA
            while (jTabelaProdutosKit.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaProdutosKit.getModel()).removeRow(0);
            }
        }
    }

    public void Salvar() {
        jDataEntrega1.setEnabled(!true);
        jHorarioPagto1.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
    }

    public void abrirCampos() {
        jBtSalvar.setEnabled(true);
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
    }

    public void bloquearCampos() {
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jDataEntrega1.setEnabled(!true);
        jHorarioPagto1.setEnabled(!true);
    }

    public void PESQUISAR_PRODUTOS_KIT_Kit_InternoManual() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc,"
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND KITS_HIGIENE_INTERNO.IdKit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + estoque + "'");
            conecta.rs.first();
            codigoInternoKit = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        if (jIdInternoKitBio1.getText().equals(codigoInternoKit)) {
            DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
            ProdutoInternosKitLote p = new ProdutoInternosKitLote();
            try {
                for (ProdutoInternosKitLote pp : controleMan.read()) {
                    produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd(), pp.getQtdEstoque()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaCancelamentoKit.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe kit para esse interno.");
        }
    }

    public void verificarInternoManual() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND IdPagto='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT ITENS_PAGAMENTO_KIT_INTERNOS.IdItem "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS ");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
    }

    //KIT INICIAL
    public void pesquisarInternoPagamentoKitInicial() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                    + "PAVILHAO.DescricaoPav,KITS_INICIAL_INTERNOS.KitPago,KITS_INICIAL_INTERNOS.Utilizado "
                    + "FROM  PRONTUARIOSCRC "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_INICIAL_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=KITS_INICIAL_INTERNOS.IdInternoCrc "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp='" + statusFinal + "' "
                    + "AND PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_INICIAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_INICIAL_INTERNOS.Utilizado='" + utilizado + "'"
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    //KIT DECENDIAL
    public void pesquisarInternoPagamentoKitDecendial() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_DECENDIAL_INTERNOS.KitPago, "
                    + "KITS_DECENDIAL_INTERNOS.Utilizado "
                    + "FROM KITS_DECENDIAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_DECENDIAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // KIT QUINZENAL
    public void pesquisarInternoPagamentoKitQuinzenal() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_QUINZENAL_INTERNOS.KitPago, "
                    + "KITS_QUINZENAL_INTERNOS.Utilizado "
                    + "FROM KITS_QUINZENAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_QUINZENAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_QUINZENAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_QUINZENAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // KIT MENSAL
    public void pesquisarInternoPagamentoKitMensal() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_MENSAL_INTERNOS.KitPago,KITS_MENSAL_INTERNOS.Utilizado "
                    + "FROM KITS_MENSAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_MENSAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_MENSAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_MENSAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // KIT SEMESTRAL
    public void pesquisarInternoPagamentoKitSemestral() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_SEMESTRAL_INTERNOS.KitPago,KITS_SEMESTRAL_INTERNOS.Utilizado "
                    + "FROM KITS_SEMESTRAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_SEMESTRAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_SEMESTRAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_SEMESTRAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // KIT ANUAL
    public void pesquisarInternoPagamentoKitAnual() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_ANUAL_INTERNOS.KitPago,KITS_ANUAL_INTERNOS.Utilizado "
                    + "FROM KITS_ANUAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_ANUAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_ANUAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_ANUAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void gravarDadosBanco() {
        // THREAD DOS DADOS
        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    // GRAVAR NA TABELA ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO                         
                    for (int i = 0; i < jTabelaProdutosKit.getRowCount(); i++) {//                          
                        objItensPagtoProd.setUsuarioInsert(nameUser);
                        objItensPagtoProd.setDataInsert(dataModFinal);
                        objItensPagtoProd.setHorarioInsert(horaMov);
                        //CONFIRMAR O RECEBIMENTO DO KIT
                        objItensPagtoProd.setIdPagto(Integer.valueOf(jIdRegistro.getText()));
                        objItensPagtoProd.setIdItem(codItem);
                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                        objItensPagtoProd.setQuatProd((float) jTabelaProdutosKit.getValueAt(i, 3));
                        objItensPagtoProd.setDataEntrega(jDataEntrega.getDate());
                        objItensPagtoProd.setHorario(jHorarioPagto.getText());
                        objItensPagtoProd.setAssinaturaDigitalInterno(pDigitalCapturada);
                        controleProd.incluirPagamentoProdutoKitInterno(objItensPagtoProd);
                        //
                        objProdKit.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                        objProdKit.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                        objProdKit.setDataPagto(jDataEntrega1.getDate());
                        objProdKit.setPago(kitPago);
                        // INFORMAR PAGAMENTO DOS KITS
                        if (jComboBoxTiposKits.getSelectedItem().equals("Kit Inicial")) {
                            controleMan.alterarKitInicial(objProdKit);
                        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Decendial")) {
                            controleMan.alterarKitDecendial(objProdKit);
                        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Quinzenal")) {
                            controleMan.alterarKitQuinzenal(objProdKit);
                        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Mensal")) {
                            controleMan.alterarKitMensal(objProdKit);
                        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Semestral")) {
                            controleMan.alterarKitSemestral(objProdKit);
                        } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Anual")) {
                            controleMan.alterarKitAnual(objProdKit);
                        }
                        //PESQUISAR O PRODUTO DO INTERNO PARA DA BAIXA.
                        conecta.abrirConexao();
                        try {
                            conecta.executaSQL("SELECT DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jIdKit.getText() + "' "
                                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
                            conecta.rs.first();
                            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
                            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
                            pCodigoProd = conecta.rs.getInt("IdProd");
                            pQuantidade = conecta.rs.getInt("QuantProd");
                        } catch (Exception e) {
                        }
                        objItensPagtoProd.setIdPagto(pRegistroComp);
                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                        objItensPagtoProd.setQuatProd((float) jTabelaProdutosKit.getValueAt(i, 3));
                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuatProd());
                        objItensPagtoProd.setQuatProd(pSaldo);
                        controleProd.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            };
            t0.start();
        } catch (Exception e) {
        }
        // THREAD DA BARRA DE EXECUÇÃO
        try {
            Thread t1 = new Thread() {
                public void run() {
                    jProgressBar1.setMaximum(jTabelaProdutosKit.getRowCount());
                    Rectangle rect;
                    for (int b = 0; b < jTabelaProdutosKit.getRowCount(); b++) {
                        rect = jTabelaProdutosKit.getCellRect(b, 0, true);
                        try {
                            jTabelaProdutosKit.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
                        if (b == 0) {
                            jTabelaProdutosKit.setRowSelectionInterval(b, 0);
                            jProgressBar1.setValue((b + 1));
                        } else if (b > 0) {
                            jTabelaProdutosKit.setRowSelectionInterval(b, 1);
                            jProgressBar1.setValue((b + 1));
                        }
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                        }
                    }
                    jProgressBar1.setValue(0);
                    JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                    limparCamposBiometria();
                    while (jTabelaProdutosKit.getModel().getRowCount() > 0) {
                        ((DefaultTableModel) jTabelaProdutosKit.getModel()).removeRow(0);
                    }
                    jComboBoxPesquisarInterno.removeAllItems();
                    jComboBoxPesquisarInterno.addItem("Selecione...");
                    if (jComboBoxTiposKits.getSelectedItem().equals("Kit Inicial")) {
                        pesquisarInternoPagamentoKitInicial();
                    } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Decendial")) {
                        pesquisarInternoPagamentoKitDecendial();
                    } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Quinzenal")) {
                        pesquisarInternoPagamentoKitQuinzenal();
                    } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Mensal")) {
                        pesquisarInternoPagamentoKitMensal();
                    } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Semestral")) {
                        pesquisarInternoPagamentoKitSemestral();
                    } else if (jComboBoxTiposKits.getSelectedItem().equals("Kit Anual")) {
                        pesquisarInternoPagamentoKitAnual();
                    }
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t1.start();
        } catch (Exception e) {
        }
    }

    public void limparCamposBiometria() {
        jIdInternoKitBio1.setText("");
        jNomeInternoKitBio1.setText("");
        jRegimeKitBio1.setText("");
        jPavilhaoKitBio1.setText("");
        jCelaKitBio1.setText("");
        //
        jDataEntrega1.setDate(null);
        jHorarioPagto1.setText("");
    }

    public void preencherTabelaItensInterno() {
        DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaProdutosKitInterno.getModel();
        CancelamentoPagamentoKitHigiene d = new CancelamentoPagamentoKitHigiene();
        try {
            for (CancelamentoPagamentoKitHigiene dd : listaInternos.read()) {
                dadosOrigem.addRow(new Object[]{dd.getIdItemINT(), dd.getIdInternoKit(), dd.getNomeInternoKit()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKitInterno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoPagamentoKits.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void listarTodosProdutosKitCompleto() {
        DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
        ProdutoInternosKitLote p = new ProdutoInternosKitLote();
        try {
            for (ProdutoInternosKitLote pp : control.read()) {
//                jtotaProdutosListados.setText(Integer.toString(qtdProd)); // Converter inteiro em string para exibir na tela 
                produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCancelamentoKit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabelaProdutosKit() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaProdutosKit.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutosKit.getModel()).removeRow(0);
        }
    }
}
